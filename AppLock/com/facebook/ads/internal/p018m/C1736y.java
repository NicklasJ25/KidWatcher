package com.facebook.ads.internal.p018m;

import java.util.HashMap;
import java.util.Map;

public class C1736y {
    private final String f4382a;
    private final String f4383b;
    private final String f4384c;

    public C1736y(String str, String str2) {
        this(str, str2, false);
    }

    public C1736y(String str, String str2, boolean z) {
        this.f4382a = str;
        this.f4383b = str2;
        this.f4384c = z ? "1" : "0";
    }

    public Map<String, String> m4997a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("stacktrace", this.f4382a);
        hashMap.put("app_crashed_version", this.f4383b);
        hashMap.put("caught_exception", this.f4384c);
        return hashMap;
    }
}
