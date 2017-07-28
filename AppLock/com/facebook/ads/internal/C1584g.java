package com.facebook.ads.internal;

public enum C1584g {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(200),
    REWARDED_VIDEO(400),
    NATIVE_250(201),
    INSTREAM_VIDEO(300);
    
    private final int f3952n;

    private C1584g(int i) {
        this.f3952n = i;
    }

    public int m4415a() {
        return this.f3952n;
    }
}
