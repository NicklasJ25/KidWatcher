package com.google.android.gms.internal;

public class kw {
    private static final boolean f9685a = m12263b();

    public static boolean m12262a() {
        return f9685a;
    }

    private static boolean m12263b() {
        try {
            Class.forName("android.app.Activity");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
