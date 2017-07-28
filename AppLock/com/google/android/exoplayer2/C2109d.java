package com.google.android.exoplayer2;

import java.io.IOException;

public final class C2109d extends Exception {
    public final int f5921a;
    public final int f5922b;

    private C2109d(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f5921a = i;
        this.f5922b = i2;
    }

    public static C2109d m6415a(IOException iOException) {
        return new C2109d(0, null, iOException, -1);
    }

    public static C2109d m6416a(Exception exception, int i) {
        return new C2109d(1, null, exception, i);
    }

    static C2109d m6417a(RuntimeException runtimeException) {
        return new C2109d(2, null, runtimeException, -1);
    }
}
