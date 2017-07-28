package com.google.android.gms.common.util;

import android.os.SystemClock;

public class C2582g implements C2580e {
    private static C2582g f7558a = new C2582g();

    private C2582g() {
    }

    public static C2580e m8288d() {
        return f7558a;
    }

    public long mo3360a() {
        return System.currentTimeMillis();
    }

    public long mo3361b() {
        return SystemClock.elapsedRealtime();
    }

    public long mo3362c() {
        return System.nanoTime();
    }
}
