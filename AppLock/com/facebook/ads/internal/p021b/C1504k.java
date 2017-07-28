package com.facebook.ads.internal.p021b;

import android.text.TextUtils;
import java.util.Locale;

public enum C1504k {
    UNKNOWN,
    AN,
    ADMOB,
    INMOBI,
    YAHOO;

    public static C1504k m3981a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return (C1504k) Enum.valueOf(C1504k.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
