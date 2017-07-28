package com.facebook.ads.internal;

import android.support.v4.view.PointerIconCompat;

public enum C1474a {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(1000, "Network Error", true),
    NO_FILL(PointerIconCompat.TYPE_CONTEXT_MENU, "No Fill", true),
    LOAD_TOO_FREQUENTLY(PointerIconCompat.TYPE_HAND, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(2000, "Server Error", true),
    INTERNAL_ERROR(2001, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    
    private final int f3446o;
    private final String f3447p;
    private final boolean f3448q;

    private C1474a(int i, String str, boolean z) {
        this.f3446o = i;
        this.f3447p = str;
        this.f3448q = z;
    }

    public static C1474a m3817a(int i) {
        return C1474a.m3818a(i, UNKNOWN_ERROR);
    }

    public static C1474a m3818a(int i, C1474a c1474a) {
        for (C1474a c1474a2 : C1474a.values()) {
            if (c1474a2.m3819a() == i) {
                return c1474a2;
            }
        }
        return c1474a;
    }

    public int m3819a() {
        return this.f3446o;
    }

    public C1555d m3820a(String str) {
        return new C1555d(this, str);
    }

    public String m3821b() {
        return this.f3447p;
    }

    boolean m3822c() {
        return this.f3448q;
    }
}
