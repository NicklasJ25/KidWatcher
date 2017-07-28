package com.domobile.eframe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.domobile.applock.service.LockService;
import com.domobile.frame.p000a.C1147a;

public class C1217c {
    private static C1217c f2395a;
    private Context f2396b;
    private C1216a f2397c;
    private SQLiteDatabase f2398d;

    public class C1216a extends SQLiteOpenHelper {
        final /* synthetic */ C1217c f2394a;

        C1216a(C1217c c1217c, Context context) {
            this.f2394a = c1217c;
            super(context, "domobile_elock.db", null, 5);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            for (String execSQL : C1149b.f2205C) {
                sQLiteDatabase.execSQL(execSQL);
            }
            this.f2394a.m2855a(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String[][] strArr = C1149b.f2206D;
            for (int i3 = i; i3 < i2; i3++) {
                for (String execSQL : strArr[i3 - 1]) {
                    sQLiteDatabase.execSQL(execSQL);
                }
            }
            if (i < 5) {
                this.f2394a.m2855a(sQLiteDatabase);
            }
        }
    }

    public C1217c(Context context) {
        this.f2396b = context;
    }

    public static SQLiteDatabase m2853a() {
        return f2395a.f2398d;
    }

    public static C1217c m2854a(Context context) {
        if (f2395a == null) {
            f2395a = new C1217c(context);
        }
        f2395a.m2857c();
        return f2395a;
    }

    private void m2855a(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        sQLiteDatabase.delete("locks", C1147a.m2480a("sid=", Integer.valueOf(-2)), null);
        String[] strArr = new String[]{"com.android.vending", "com.android.mms", "com.google.android.gm", "com.android.email", "com.google.android.email", "com.google.android.gallery3d", "com.sec.android.gallery3d", "com.cooliris.media", "com.tencent.mm", "com.tencent.mobileqq", "com.google.android.talk", "com.google.android.apps.photos", "com.google.android.contacts", "com.facebook.katana", "com.whatsapp", "com.twitter.android", "com.snapchat.android", "jp.naver.line.android", "com.android.settings"};
        int length = strArr.length - 1;
        if (LockService.f1931a) {
            length++;
        }
        sQLiteDatabase.beginTransaction();
        while (i < length) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("sid", Integer.valueOf(-2));
                contentValues.put("pname", strArr[i]);
                contentValues.put("type", Integer.valueOf(1));
                sQLiteDatabase.insert("locks", null, contentValues);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void m2857c() {
        if (this.f2397c == null) {
            this.f2397c = new C1216a(this, this.f2396b);
            this.f2398d = this.f2397c.getWritableDatabase();
        }
    }

    public void m2858b() {
        if (this.f2397c != null) {
            this.f2398d.close();
            this.f2397c.close();
            this.f2397c = null;
        }
    }
}
