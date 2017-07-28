package com.facebook.ads.internal.p029i;

import com.facebook.ads.internal.p021b.C1504k;

public class C1613a {
    private static final String[] f4004a = new String[]{"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};
    private static final String[] f4005b = new String[]{"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};
    private static final String[] f4006c = new String[]{"com.google.android.gms.ads.formats.NativeAdView"};

    public static boolean m4522a(C1504k c1504k) {
        switch (c1504k) {
            case AN:
                return true;
            case YAHOO:
                return C1613a.m4524a(f4004a);
            case INMOBI:
                return C1613a.m4524a(f4005b);
            case ADMOB:
                return C1613a.m4524a(f4006c);
            default:
                return false;
        }
    }

    private static boolean m4523a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m4524a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String a : strArr) {
            if (!C1613a.m4523a(a)) {
                return false;
            }
        }
        return true;
    }
}
