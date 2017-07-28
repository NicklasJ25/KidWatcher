package com.android.gallery3d.common;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.android.gallery3d.common.Entry.Column;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.common.Entry.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class EntrySchema {
    private static final String FULL_TEXT_INDEX_SUFFIX = "_fulltext";
    private static final String[] SQLITE_TYPES = new String[]{"TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL", "REAL", "NONE"};
    private static final String TAG = "EntrySchema";
    public static final int TYPE_BLOB = 7;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_STRING = 0;
    private final ColumnInfo[] mColumnInfo;
    private final boolean mHasFullTextIndex;
    private final String[] mProjection;
    private final String mTableName;

    public static final class ColumnInfo {
        private static final String ID_KEY = "_id";
        public final String defaultValue;
        public final Field field;
        public final boolean fullText;
        public final boolean indexed;
        public final String name;
        public final int projectionIndex;
        public final int type;
        public final boolean unique;

        public ColumnInfo(String str, int i, boolean z, boolean z2, boolean z3, String str2, Field field, int i2) {
            this.name = str.toLowerCase();
            this.type = i;
            this.indexed = z;
            this.unique = z2;
            this.fullText = z3;
            this.defaultValue = str2;
            this.field = field;
            this.projectionIndex = i2;
            field.setAccessible(true);
        }

        public boolean isId() {
            return "_id".equals(this.name);
        }
    }

    public EntrySchema(Class<? extends Entry> cls) {
        boolean z;
        String[] strArr;
        int i = 0;
        ColumnInfo[] parseColumnInfo = parseColumnInfo(cls);
        this.mTableName = parseTableName(cls);
        this.mColumnInfo = parseColumnInfo;
        String[] strArr2 = new String[0];
        if (parseColumnInfo != null) {
            String[] strArr3 = new String[parseColumnInfo.length];
            z = false;
            while (i != parseColumnInfo.length) {
                ColumnInfo columnInfo = parseColumnInfo[i];
                strArr3[i] = columnInfo.name;
                if (columnInfo.fullText) {
                    z = true;
                }
                i++;
            }
            strArr = strArr3;
        } else {
            strArr = strArr2;
            z = false;
        }
        this.mProjection = strArr;
        this.mHasFullTextIndex = z;
    }

    private void logExecSql(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    private void parseColumnInfo(Class<? extends Object> cls, ArrayList<ColumnInfo> arrayList) {
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i = 0; i != declaredFields.length; i++) {
            Field field = declaredFields[i];
            Column column = (Column) field.getAnnotation(Column.class);
            if (column != null) {
                int i2;
                Class type = field.getType();
                if (type == String.class) {
                    i2 = 0;
                } else if (type == Boolean.TYPE) {
                    i2 = 1;
                } else if (type == Short.TYPE) {
                    i2 = 2;
                } else if (type == Integer.TYPE) {
                    i2 = 3;
                } else if (type == Long.TYPE) {
                    i2 = 4;
                } else if (type == Float.TYPE) {
                    i2 = 5;
                } else if (type == Double.TYPE) {
                    i2 = 6;
                } else if (type == byte[].class) {
                    i2 = 7;
                } else {
                    throw new IllegalArgumentException("Unsupported field type for column: " + type.getName());
                }
                arrayList.add(new ColumnInfo(column.value(), i2, column.indexed(), column.unique(), column.fullText(), column.defaultValue(), field, arrayList.size()));
            }
        }
    }

    private ColumnInfo[] parseColumnInfo(Class<? extends Object> cls) {
        ArrayList arrayList = new ArrayList();
        Class superclass;
        while (superclass != null) {
            parseColumnInfo(superclass, arrayList);
            superclass = superclass.getSuperclass();
        }
        ColumnInfo[] columnInfoArr = new ColumnInfo[arrayList.size()];
        arrayList.toArray(columnInfoArr);
        return columnInfoArr;
    }

    private String parseTableName(Class<? extends Object> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        return table == null ? null : table.value();
    }

    private void setIfNotNull(Field field, Object obj, Object obj2) {
        if (obj2 != null) {
            field.set(obj, obj2);
        }
    }

    public void createTables(SQLiteDatabase sQLiteDatabase) {
        String str = this.mTableName;
        Utils.assertTrue(str != null);
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(str);
        stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
        CharSequence stringBuilder2 = new StringBuilder();
        for (ColumnInfo columnInfo : this.mColumnInfo) {
            if (!columnInfo.isId()) {
                stringBuilder.append(',');
                stringBuilder.append(columnInfo.name);
                stringBuilder.append(' ');
                stringBuilder.append(SQLITE_TYPES[columnInfo.type]);
                if (!TextUtils.isEmpty(columnInfo.defaultValue)) {
                    stringBuilder.append(" DEFAULT ");
                    stringBuilder.append(columnInfo.defaultValue);
                }
                if (columnInfo.unique) {
                    if (stringBuilder2.length() == 0) {
                        stringBuilder2.append(columnInfo.name);
                    } else {
                        stringBuilder2.append(',').append(columnInfo.name);
                    }
                }
            }
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder.append(",UNIQUE(").append(stringBuilder2).append(')');
        }
        stringBuilder.append(");");
        logExecSql(sQLiteDatabase, stringBuilder.toString());
        stringBuilder.setLength(0);
        for (ColumnInfo columnInfo2 : this.mColumnInfo) {
            if (columnInfo2.indexed) {
                stringBuilder.append("CREATE INDEX ");
                stringBuilder.append(str);
                stringBuilder.append("_index_");
                stringBuilder.append(columnInfo2.name);
                stringBuilder.append(" ON ");
                stringBuilder.append(str);
                stringBuilder.append(" (");
                stringBuilder.append(columnInfo2.name);
                stringBuilder.append(");");
                logExecSql(sQLiteDatabase, stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        if (this.mHasFullTextIndex) {
            String str2 = str + FULL_TEXT_INDEX_SUFFIX;
            stringBuilder.append("CREATE VIRTUAL TABLE ");
            stringBuilder.append(str2);
            stringBuilder.append(" USING FTS3 (_id INTEGER PRIMARY KEY");
            for (ColumnInfo columnInfo3 : this.mColumnInfo) {
                if (columnInfo3.fullText) {
                    String str3 = columnInfo3.name;
                    stringBuilder.append(',');
                    stringBuilder.append(str3);
                    stringBuilder.append(" TEXT");
                }
            }
            stringBuilder.append(");");
            logExecSql(sQLiteDatabase, stringBuilder.toString());
            stringBuilder.setLength(0);
            StringBuilder stringBuilder3 = new StringBuilder("INSERT OR REPLACE INTO ");
            stringBuilder3.append(str2);
            stringBuilder3.append(" (_id");
            for (ColumnInfo columnInfo4 : this.mColumnInfo) {
                if (columnInfo4.fullText) {
                    stringBuilder3.append(',');
                    stringBuilder3.append(columnInfo4.name);
                }
            }
            stringBuilder3.append(") VALUES (new._id");
            for (ColumnInfo columnInfo42 : this.mColumnInfo) {
                if (columnInfo42.fullText) {
                    stringBuilder3.append(",new.");
                    stringBuilder3.append(columnInfo42.name);
                }
            }
            stringBuilder3.append(");");
            String stringBuilder4 = stringBuilder3.toString();
            stringBuilder.append("CREATE TRIGGER ");
            stringBuilder.append(str);
            stringBuilder.append("_insert_trigger AFTER INSERT ON ");
            stringBuilder.append(str);
            stringBuilder.append(" FOR EACH ROW BEGIN ");
            stringBuilder.append(stringBuilder4);
            stringBuilder.append("END;");
            logExecSql(sQLiteDatabase, stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TRIGGER ");
            stringBuilder.append(str);
            stringBuilder.append("_update_trigger AFTER UPDATE ON ");
            stringBuilder.append(str);
            stringBuilder.append(" FOR EACH ROW BEGIN ");
            stringBuilder.append(stringBuilder4);
            stringBuilder.append("END;");
            logExecSql(sQLiteDatabase, stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TRIGGER ");
            stringBuilder.append(str);
            stringBuilder.append("_delete_trigger AFTER DELETE ON ");
            stringBuilder.append(str);
            stringBuilder.append(" FOR EACH ROW BEGIN DELETE FROM ");
            stringBuilder.append(str2);
            stringBuilder.append(" WHERE _id = old._id; END;");
            logExecSql(sQLiteDatabase, stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    public <T extends Entry> T cursorToObject(Cursor cursor, T t) {
        try {
            for (ColumnInfo columnInfo : this.mColumnInfo) {
                int i = columnInfo.projectionIndex;
                Field field = columnInfo.field;
                switch (columnInfo.type) {
                    case 0:
                        field.set(t, cursor.isNull(i) ? null : cursor.getString(i));
                        break;
                    case 1:
                        field.setBoolean(t, cursor.getShort(i) == (short) 1);
                        break;
                    case 2:
                        field.setShort(t, cursor.getShort(i));
                        break;
                    case 3:
                        field.setInt(t, cursor.getInt(i));
                        break;
                    case 4:
                        field.setLong(t, cursor.getLong(i));
                        break;
                    case 5:
                        field.setFloat(t, cursor.getFloat(i));
                        break;
                    case 6:
                        field.setDouble(t, cursor.getDouble(i));
                        break;
                    case 7:
                        field.set(t, cursor.isNull(i) ? null : cursor.getBlob(i));
                        break;
                    default:
                        break;
                }
            }
            return t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
        stringBuilder.append(this.mTableName);
        stringBuilder.append(";");
        logExecSql(sQLiteDatabase, stringBuilder.toString());
    }

    public boolean deleteWithId(SQLiteDatabase sQLiteDatabase, long j) {
        return sQLiteDatabase.delete(this.mTableName, "_id=?", new String[]{Long.toString(j)}) == 1;
    }

    public void dropTables(SQLiteDatabase sQLiteDatabase) {
        String str = this.mTableName;
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        stringBuilder.append(str);
        stringBuilder.append(';');
        logExecSql(sQLiteDatabase, stringBuilder.toString());
        stringBuilder.setLength(0);
        if (this.mHasFullTextIndex) {
            stringBuilder.append("DROP TABLE IF EXISTS ");
            stringBuilder.append(str);
            stringBuilder.append(FULL_TEXT_INDEX_SUFFIX);
            stringBuilder.append(';');
            logExecSql(sQLiteDatabase, stringBuilder.toString());
        }
    }

    public ColumnInfo getColumn(String str) {
        int columnIndex = getColumnIndex(str);
        return columnIndex < 0 ? null : this.mColumnInfo[columnIndex];
    }

    public int getColumnIndex(String str) {
        for (ColumnInfo columnInfo : this.mColumnInfo) {
            if (columnInfo.name.equals(str)) {
                return columnInfo.projectionIndex;
            }
        }
        return -1;
    }

    public ColumnInfo[] getColumnInfo() {
        return this.mColumnInfo;
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getTableName() {
        return this.mTableName;
    }

    public long insertOrReplace(SQLiteDatabase sQLiteDatabase, Entry entry) {
        ContentValues contentValues = new ContentValues();
        objectToValues(entry, contentValues);
        if (entry.id == 0) {
            contentValues.remove(Columns.ID);
        }
        long replace = sQLiteDatabase.replace(this.mTableName, Columns.ID, contentValues);
        entry.id = replace;
        return replace;
    }

    public void objectToValues(Entry entry, ContentValues contentValues) {
        try {
            for (ColumnInfo columnInfo : this.mColumnInfo) {
                String str = columnInfo.name;
                Field field = columnInfo.field;
                switch (columnInfo.type) {
                    case 0:
                        contentValues.put(str, (String) field.get(entry));
                        break;
                    case 1:
                        contentValues.put(str, Boolean.valueOf(field.getBoolean(entry)));
                        break;
                    case 2:
                        contentValues.put(str, Short.valueOf(field.getShort(entry)));
                        break;
                    case 3:
                        contentValues.put(str, Integer.valueOf(field.getInt(entry)));
                        break;
                    case 4:
                        contentValues.put(str, Long.valueOf(field.getLong(entry)));
                        break;
                    case 5:
                        contentValues.put(str, Float.valueOf(field.getFloat(entry)));
                        break;
                    case 6:
                        contentValues.put(str, Double.valueOf(field.getDouble(entry)));
                        break;
                    case 7:
                        contentValues.put(str, (byte[]) field.get(entry));
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Cursor queryAll(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.query(this.mTableName, this.mProjection, null, null, null, null, null);
    }

    public boolean queryWithId(SQLiteDatabase sQLiteDatabase, long j, Entry entry) {
        boolean z;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(this.mTableName, this.mProjection, "_id=?", new String[]{Long.toString(j)}, null, null, null);
        if (query.moveToFirst()) {
            cursorToObject(query, entry);
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }

    public String toDebugString(Entry entry) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ID=").append(entry.id);
            for (ColumnInfo columnInfo : this.mColumnInfo) {
                String str = columnInfo.name;
                Object obj = columnInfo.field.get(entry);
                stringBuilder.append(" ").append(str).append("=").append(obj == null ? "null" : obj.toString());
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String toDebugString(Entry entry, String... strArr) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ID=").append(entry.id);
            for (String str : strArr) {
                Object obj = getColumn(str).field.get(entry);
                stringBuilder.append(" ").append(str).append("=").append(obj == null ? "null" : obj.toString());
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Entry> T valuesToObject(ContentValues contentValues, T t) {
        try {
            for (ColumnInfo columnInfo : this.mColumnInfo) {
                String str = columnInfo.name;
                Field field = columnInfo.field;
                switch (columnInfo.type) {
                    case 0:
                        setIfNotNull(field, t, contentValues.getAsString(str));
                        break;
                    case 1:
                        setIfNotNull(field, t, contentValues.getAsBoolean(str));
                        break;
                    case 2:
                        setIfNotNull(field, t, contentValues.getAsShort(str));
                        break;
                    case 3:
                        setIfNotNull(field, t, contentValues.getAsInteger(str));
                        break;
                    case 4:
                        setIfNotNull(field, t, contentValues.getAsLong(str));
                        break;
                    case 5:
                        setIfNotNull(field, t, contentValues.getAsFloat(str));
                        break;
                    case 6:
                        setIfNotNull(field, t, contentValues.getAsDouble(str));
                        break;
                    case 7:
                        setIfNotNull(field, t, contentValues.getAsByteArray(str));
                        break;
                    default:
                        break;
                }
            }
            return t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
