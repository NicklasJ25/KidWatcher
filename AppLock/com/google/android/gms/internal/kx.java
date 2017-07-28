package com.google.android.gms.internal;

import java.util.Map;

public class kx {
    private final String f9686a;
    private final Map<String, Object> f9687b;

    public kx(String str, Map<String, Object> map) {
        this.f9686a = str;
        this.f9687b = map;
    }

    public static kx m12264a(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map a = ky.m12270a(str.substring("gauth|".length()));
            return new kx((String) a.get("token"), (Map) a.get("auth"));
        } catch (Throwable e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public String m12265a() {
        return this.f9686a;
    }

    public Map<String, Object> m12266b() {
        return this.f9687b;
    }
}
