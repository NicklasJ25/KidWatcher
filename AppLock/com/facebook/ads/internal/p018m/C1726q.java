package com.facebook.ads.internal.p018m;

import android.text.TextUtils;
import java.util.Locale;

public enum C1726q {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static C1726q m4951a(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        try {
            return C1726q.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
