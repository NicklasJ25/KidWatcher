package com.facebook.ads.internal.p030j.p032b;

final class C1663j {
    static <T> T m4705a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T m4706a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void m4707a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
