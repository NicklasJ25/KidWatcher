package com.domobile.applock.chamber.p010b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.domobile.applock.AppLockApplication;

public class C0780c {
    private static C0780c f1031a;
    private Context f1032b = AppLockApplication.m577b();
    private C0779b f1033c = new C0779b(this.f1032b);

    private C0780c() {
    }

    public static synchronized C0780c m1191a() {
        C0780c c0780c;
        synchronized (C0780c.class) {
            if (f1031a == null) {
                f1031a = new C0780c();
            }
            c0780c = f1031a;
        }
        return c0780c;
    }

    public SQLiteDatabase m1192b() {
        return this.f1033c.getWritableDatabase();
    }

    public SQLiteDatabase m1193c() {
        return this.f1033c.getReadableDatabase();
    }
}
