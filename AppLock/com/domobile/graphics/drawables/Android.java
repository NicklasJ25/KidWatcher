package com.domobile.graphics.drawables;

import android.os.Build.VERSION;

class Android {
    public static int VERSION = VERSION.SDK_INT;

    Android() {
    }

    public static boolean isKitkat() {
        return VERSION >= 19;
    }

    public static boolean isLollipop() {
        return VERSION >= 21;
    }
}
