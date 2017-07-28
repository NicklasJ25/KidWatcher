package com.android.gallery3d.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.android.gallery3d.common.Entry.Column;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.common.Entry.Table;
import java.io.Closeable;
import java.io.File;

public class FileCache implements Closeable {
    private static final String FILE_POSTFIX = ".tmp";
    private static final String FILE_PREFIX = "download";
    private static final String FREESPACE_ORDER_BY = String.format("%s ASC", new Object[]{"last_access"});
    private static final String[] FREESPACE_PROJECTION = new String[]{Columns.ID, Columns.FILENAME, "content_url", Columns.SIZE};
    private static final String ID_WHERE = "_id=?";
    private static final int LRU_CAPACITY = 4;
    private static final int MAX_DELETE_COUNT = 16;
    private static final String[] PROJECTION_SIZE_SUM;
    private static final String QUERY_WHERE = "hash_code=? AND content_url=?";
    private static final String TABLE_NAME = FileEntry.SCHEMA.getTableName();
    private static final String TAG = "FileCache";
    private long mCapacity;
    private DatabaseHelper mDbHelper;
    private final LruCache<String, CacheEntry> mEntryMap = new LruCache(4);
    private boolean mInitialized = false;
    private File mRootDir;
    private long mTotalBytes;

    public static final class CacheEntry {
        public File cacheFile;
        public String contentUrl;
        private long id;

        private CacheEntry(long j, String str, File file) {
            this.id = j;
            this.contentUrl = str;
            this.cacheFile = file;
        }
    }

    private final class DatabaseHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;

        public DatabaseHelper(Context context, String str) {
            super(context, str, null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            FileEntry.SCHEMA.createTables(sQLiteDatabase);
            for (File file : FileCache.this.mRootDir.listFiles()) {
                if (!file.delete()) {
                    Log.w(FileCache.TAG, "fail to remove: " + file.getAbsolutePath());
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            FileEntry.SCHEMA.dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    @Table("files")
    private static class FileEntry extends Entry {
        public static final EntrySchema SCHEMA = new EntrySchema(FileEntry.class);
        @Column("content_url")
        public String contentUrl;
        @Column("filename")
        public String filename;
        @Column(indexed = true, value = "hash_code")
        public long hashCode;
        @Column(indexed = true, value = "last_access")
        public long lastAccess;
        @Column("size")
        public long size;

        public interface Columns extends com.android.gallery3d.common.Entry.Columns {
            public static final String CONTENT_URL = "content_url";
            public static final String FILENAME = "filename";
            public static final String HASH_CODE = "hash_code";
            public static final String LAST_ACCESS = "last_access";
            public static final String SIZE = "size";
        }

        private FileEntry() {
        }

        public String toString() {
            return "hash_code: " + this.hashCode + ", " + "content_url" + this.contentUrl + ", " + "last_access" + this.lastAccess + ", " + Columns.FILENAME + this.filename;
        }
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = String.format("sum(%s)", new Object[]{Columns.SIZE});
        PROJECTION_SIZE_SUM = strArr;
    }

    public FileCache(Context context, File file, String str, long j) {
        this.mRootDir = (File) Utils.checkNotNull(file);
        this.mCapacity = j;
        this.mDbHelper = new DatabaseHelper(context, str);
    }

    public static void deleteFiles(Context context, File file, String str) {
        try {
            context.getDatabasePath(str).delete();
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    String name = file2.getName();
                    if (file2.isFile() && name.startsWith("download") && name.endsWith(FILE_POSTFIX)) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable th) {
            Log.w(TAG, "cannot reset database", th);
        }
    }

    private void freeSomeSpaceIfNeed(int i) {
        Cursor query = this.mDbHelper.getReadableDatabase().query(TABLE_NAME, FREESPACE_PROJECTION, null, null, null, null, FREESPACE_ORDER_BY);
        while (i > 0) {
            if (this.mTotalBytes <= this.mCapacity || !query.moveToNext()) {
                break;
            }
            long j = query.getLong(0);
            String string = query.getString(1);
            String string2 = query.getString(2);
            long j2 = query.getLong(3);
            synchronized (this.mEntryMap) {
                if (this.mEntryMap.containsKey(string2)) {
                } else {
                    i--;
                    try {
                        if (new File(this.mRootDir, string).delete()) {
                            this.mTotalBytes -= j2;
                            this.mDbHelper.getWritableDatabase().delete(TABLE_NAME, ID_WHERE, new String[]{String.valueOf(j)});
                        } else {
                            Log.w(TAG, "unable to delete file: " + string);
                        }
                    } catch (Throwable th) {
                        query.close();
                    }
                }
            }
        }
        query.close();
    }

    private synchronized void initialize() {
        if (!this.mInitialized) {
            if (!this.mRootDir.isDirectory()) {
                this.mRootDir.mkdirs();
                if (!this.mRootDir.isDirectory()) {
                    throw new RuntimeException("cannot create: " + this.mRootDir.getAbsolutePath());
                }
            }
            Cursor query = this.mDbHelper.getReadableDatabase().query(TABLE_NAME, PROJECTION_SIZE_SUM, null, null, null, null, null);
            try {
                if (query.moveToNext()) {
                    this.mTotalBytes = query.getLong(0);
                }
                if (this.mTotalBytes > this.mCapacity) {
                    freeSomeSpaceIfNeed(16);
                }
                this.mInitialized = true;
            } finally {
                query.close();
            }
        }
    }

    private FileEntry queryDatabase(String str) {
        FileEntry fileEntry = null;
        Cursor query = this.mDbHelper.getReadableDatabase().query(TABLE_NAME, FileEntry.SCHEMA.getProjection(), QUERY_WHERE, new String[]{String.valueOf(Utils.crc64Long(str)), str}, null, null, null);
        try {
            if (query.moveToNext()) {
                fileEntry = new FileEntry();
                FileEntry.SCHEMA.cursorToObject(query, fileEntry);
                updateLastAccess(fileEntry.id);
                query.close();
            }
            return fileEntry;
        } finally {
            query.close();
        }
    }

    private void updateLastAccess(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        this.mDbHelper.getWritableDatabase().update(TABLE_NAME, contentValues, ID_WHERE, new String[]{String.valueOf(j)});
    }

    public void close() {
        this.mDbHelper.close();
    }

    public File createFile() {
        return File.createTempFile("download", FILE_POSTFIX, this.mRootDir);
    }

    public CacheEntry lookup(String str) {
        if (!this.mInitialized) {
            initialize();
        }
        synchronized (this.mEntryMap) {
            CacheEntry cacheEntry = (CacheEntry) this.mEntryMap.get(str);
        }
        if (cacheEntry != null) {
            synchronized (this) {
                updateLastAccess(cacheEntry.id);
            }
            return cacheEntry;
        }
        synchronized (this) {
            FileEntry queryDatabase = queryDatabase(str);
            if (queryDatabase == null) {
                return null;
            }
            CacheEntry cacheEntry2 = new CacheEntry(queryDatabase.id, str, new File(this.mRootDir, queryDatabase.filename));
            if (cacheEntry2.cacheFile.isFile()) {
                synchronized (this.mEntryMap) {
                    this.mEntryMap.put(str, cacheEntry2);
                }
                return cacheEntry2;
            }
            try {
                this.mDbHelper.getWritableDatabase().delete(TABLE_NAME, ID_WHERE, new String[]{String.valueOf(queryDatabase.id)});
                this.mTotalBytes -= queryDatabase.size;
            } catch (Throwable th) {
                Log.w(TAG, "cannot delete entry: " + queryDatabase.filename, th);
            }
            return null;
        }
    }

    public void store(String str, File file) {
        if (!this.mInitialized) {
            initialize();
        }
        Utils.assertTrue(file.getParentFile().equals(this.mRootDir));
        Entry fileEntry = new FileEntry();
        fileEntry.hashCode = Utils.crc64Long(str);
        fileEntry.contentUrl = str;
        fileEntry.filename = file.getName();
        fileEntry.size = file.length();
        fileEntry.lastAccess = System.currentTimeMillis();
        if (fileEntry.size >= this.mCapacity) {
            file.delete();
            throw new IllegalArgumentException("file too large: " + fileEntry.size);
        }
        synchronized (this) {
            FileEntry queryDatabase = queryDatabase(str);
            if (queryDatabase != null) {
                file.delete();
                fileEntry.filename = queryDatabase.filename;
                fileEntry.size = queryDatabase.size;
            } else {
                this.mTotalBytes += fileEntry.size;
            }
            FileEntry.SCHEMA.insertOrReplace(this.mDbHelper.getWritableDatabase(), fileEntry);
            if (this.mTotalBytes > this.mCapacity) {
                freeSomeSpaceIfNeed(16);
            }
        }
    }
}
