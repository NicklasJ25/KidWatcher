package com.facebook.ads.internal.p028g;

import com.facebook.ads.internal.C1584g;

public enum C1575c {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE,
    REWARDED_VIDEO;

    public static C1575c m4382a(C1584g c1584g) {
        switch (c1584g) {
            case NATIVE_UNKNOWN:
                return NATIVE;
            case WEBVIEW_BANNER_50:
            case WEBVIEW_BANNER_90:
            case WEBVIEW_BANNER_LEGACY:
            case WEBVIEW_BANNER_250:
                return BANNER;
            case WEBVIEW_INTERSTITIAL_HORIZONTAL:
            case WEBVIEW_INTERSTITIAL_VERTICAL:
            case WEBVIEW_INTERSTITIAL_TABLET:
            case WEBVIEW_INTERSTITIAL_UNKNOWN:
                return INTERSTITIAL;
            case REWARDED_VIDEO:
                return REWARDED_VIDEO;
            default:
                return UNKNOWN;
        }
    }
}
