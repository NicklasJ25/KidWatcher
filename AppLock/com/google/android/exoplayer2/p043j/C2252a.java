package com.google.android.exoplayer2.p043j;

import android.text.TextUtils;

public final class C2252a {
    public static int m7019a(int i, int i2, int i3) {
        if (i >= i2 && i < i3) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static <T> T m7020a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static String m7021a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static void m7022a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m7023a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m7024b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m7025b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
