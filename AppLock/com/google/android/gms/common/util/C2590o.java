package com.google.android.gms.common.util;

import android.os.Build.VERSION;

public final class C2590o {
    public static boolean m8306a() {
        int i = VERSION.SDK_INT;
        return true;
    }

    public static boolean m8307b() {
        int i = VERSION.SDK_INT;
        return true;
    }

    public static boolean m8308c() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean m8309d() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean m8310e() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m8311f() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean m8312g() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean m8313h() {
        return VERSION.SDK_INT >= 20;
    }

    @Deprecated
    public static boolean m8314i() {
        return C2590o.m8315j();
    }

    public static boolean m8315j() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m8316k() {
        return VERSION.SDK_INT >= 23;
    }

    public static boolean m8317l() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean m8318m() {
        return VERSION.SDK_INT > 25 || "O".equals(VERSION.CODENAME) || VERSION.CODENAME.startsWith("OMR");
    }
}
