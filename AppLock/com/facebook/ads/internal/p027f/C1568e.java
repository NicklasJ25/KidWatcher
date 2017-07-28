package com.facebook.ads.internal.p027f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class C1568e extends SQLiteOpenHelper {
    private final C1567d f3830a;

    public C1568e(Context context, C1567d c1567d) {
        super(context, "ads.db", null, 3);
        if (c1567d == null) {
            throw new IllegalArgumentException("AdDatabaseHelper can not be null");
        }
        this.f3830a = c1567d;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (C1561g a : this.f3830a.m4362c()) {
            a.m4336a(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (C1561g c1561g : this.f3830a.m4362c()) {
            c1561g.m4337b(sQLiteDatabase);
            c1561g.m4336a(sQLiteDatabase);
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 2 && i2 == 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crashes");
        }
    }
}
