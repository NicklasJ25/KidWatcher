package com.facebook.ads.internal;

import org.json.JSONArray;

public enum C1571f {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11),
    UNIFIED_LOGGING(16),
    HTTP_LINKS(17);
    
    public static final C1571f[] f3860o = null;
    private static final String f3861q = null;
    private final int f3863p;

    static {
        f3860o = new C1571f[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON, UNIFIED_LOGGING, HTTP_LINKS};
        JSONArray jSONArray = new JSONArray();
        C1571f[] c1571fArr = f3860o;
        int length = c1571fArr.length;
        int i;
        while (i < length) {
            jSONArray.put(c1571fArr[i].m4375a());
            i++;
        }
        f3861q = jSONArray.toString();
    }

    private C1571f(int i) {
        this.f3863p = i;
    }

    public static String m4374b() {
        return f3861q;
    }

    public int m4375a() {
        return this.f3863p;
    }

    public String toString() {
        return String.valueOf(this.f3863p);
    }
}
