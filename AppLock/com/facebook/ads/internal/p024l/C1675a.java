package com.facebook.ads.internal.p024l;

import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import java.util.Locale;

public enum C1675a {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE("native"),
    INSTREAM("instream"),
    REWARDED_VIDEO("rewarded_video");
    
    private String f4159g;

    private C1675a(String str) {
        this.f4159g = str;
    }

    public static C1675a m4770a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return C1675a.valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f4159g;
    }
}
