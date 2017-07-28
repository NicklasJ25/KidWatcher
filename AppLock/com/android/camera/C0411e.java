package com.android.camera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.domobile.applock.p003a.C0614e;
import java.io.File;

public class C0411e {
    public static final String[] f104a = new String[]{"CREATE TABLE IF NOT EXISTS medias (_id INTEGER PRIMARY KEY,album TEXT, from_path TEXT, dest_path TEXT,thumb_path TEXT,file_name TEXT,file_type TEXT,file_ext TEXT,timestamp LONG,rotation INTEGER DEFAULT 0)"};
    public static final String[][] f105b;
    private static C0411e f106c;
    private Context f107d;
    private C0410a f108e;
    private SQLiteDatabase f109f;

    public class C0410a extends SQLiteOpenHelper {
        final /* synthetic */ C0411e f103a;

        public C0410a(C0411e c0411e, Context context, String str) {
            this.f103a = c0411e;
            super(context, str, null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            for (String execSQL : C0411e.f104a) {
                sQLiteDatabase.execSQL(execSQL);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String[][] strArr = C0411e.f105b;
            while (i < i2) {
                for (String execSQL : strArr[i - 1]) {
                    sQLiteDatabase.execSQL(execSQL);
                }
                i++;
            }
        }
    }

    static {
        String[][] strArr = new String[1][];
        strArr[0] = new String[]{"ALTER TABLE medias ADD rotation INTEGER DEFAULT 0"};
        f105b = strArr;
    }

    public C0411e(Context context) {
        this.f107d = context;
    }

    public static SQLiteDatabase m157a() {
        if (f106c != null) {
            f106c.m160c();
        }
        return f106c.f109f;
    }

    public static C0411e m158a(Context context) {
        if (f106c == null) {
            f106c = new C0411e(context);
        }
        f106c.m160c();
        return f106c;
    }

    public static String m159b(Context context) {
        return context.getFilesDir() + File.separator + "Media" + File.separator + "6c9d3f90697a41b";
    }

    private void m160c() {
        if (this.f108e == null) {
            this.f108e = new C0410a(this, this.f107d, m162d());
        }
        try {
            if (this.f109f == null) {
                this.f109f = this.f108e.getWritableDatabase();
            }
        } catch (Error e) {
        }
    }

    public static boolean m161c(Context context) {
        String b = C0411e.m159b(context);
        String a = C0487k.m410a(context, "6c9d3f90697a41b");
        String a2 = C0487k.m410a(context, "6c9d3f90697a41b_temp");
        if (!C0614e.m709a(new File(b), new File(a2))) {
            return false;
        }
        File file = new File(a);
        if (file.exists()) {
            file.delete();
        }
        return new File(a2).renameTo(file);
    }

    private String m162d() {
        String b = C0411e.m159b(this.f107d);
        File file = new File(b);
        if (!file.exists()) {
            File file2 = new File(C0487k.m410a(this.f107d, "6c9d3f90697a41b"));
            if (file2.exists()) {
                C0614e.m709a(file2, file);
            } else {
                file2 = new File(C0487k.m410a(this.f107d, "6c9d3f90697a41b_temp"));
                if (file2.exists()) {
                    C0614e.m709a(file2, file);
                }
            }
        }
        return b;
    }

    public static boolean m163d(Context context) {
        return C0614e.m709a(new File(C0487k.m410a(context, "6c9d3f90697a41b")), new File(C0411e.m159b(context)));
    }

    public void m164b() {
        if (this.f108e != null) {
            this.f109f.close();
            this.f108e.close();
            this.f108e = null;
        }
    }
}
