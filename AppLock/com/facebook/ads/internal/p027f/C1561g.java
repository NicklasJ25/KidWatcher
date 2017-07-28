package com.facebook.ads.internal.p027f;

import android.database.sqlite.SQLiteDatabase;

public abstract class C1561g {
    protected final C1567d f3807j;

    protected C1561g(C1567d c1567d) {
        this.f3807j = c1567d;
    }

    public static String m4332a(String str, C1560b[] c1560bArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        for (int i = 0; i < c1560bArr.length - 1; i++) {
            stringBuilder.append(c1560bArr[i].f3805b);
            stringBuilder.append(", ");
        }
        stringBuilder.append(c1560bArr[c1560bArr.length - 1].f3805b);
        stringBuilder.append(" FROM ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m4333a(String str, C1560b[] c1560bArr, C1560b c1560b) {
        StringBuilder stringBuilder = new StringBuilder(C1561g.m4332a(str, c1560bArr));
        stringBuilder.append(" WHERE ");
        stringBuilder.append(c1560b.f3805b);
        stringBuilder.append(" = ?");
        return stringBuilder.toString();
    }

    private String mo2730c() {
        C1560b[] b = mo2729b();
        if (b.length < 1) {
            return null;
        }
        String str = "";
        for (int i = 0; i < b.length - 1; i++) {
            str = str + b[i].m4331a() + ", ";
        }
        return str + b[b.length - 1].m4331a();
    }

    public abstract String mo2728a();

    public void m4336a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + mo2728a() + " (" + mo2730c() + ")");
    }

    public void m4337b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + mo2728a());
    }

    public abstract C1560b[] mo2729b();

    public void m4339e() {
    }

    protected SQLiteDatabase m4340f() {
        return this.f3807j.m4357a();
    }
}
