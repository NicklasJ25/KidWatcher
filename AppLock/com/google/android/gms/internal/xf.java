package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@wh
class xf {
    private final List<String> f11356a;
    private final List<String> f11357b;
    private final String f11358c;
    private final String f11359d;
    private final String f11360e;
    private final String f11361f;
    private final boolean f11362g;
    private final boolean f11363h;
    private final String f11364i;
    private final String f11365j;
    private String f11366k;
    private int f11367l;

    public xf(int i, Map<String, String> map) {
        this.f11366k = (String) map.get("url");
        this.f11359d = (String) map.get("base_uri");
        this.f11360e = (String) map.get("post_parameters");
        this.f11362g = m14745b((String) map.get("drt_include"));
        this.f11363h = m14745b((String) map.get("pan_include"));
        this.f11358c = (String) map.get("activation_overlay_url");
        this.f11357b = m14746c((String) map.get("check_packages"));
        this.f11364i = (String) map.get("request_id");
        this.f11361f = (String) map.get("type");
        this.f11356a = m14746c((String) map.get("errors"));
        this.f11367l = i;
        this.f11365j = (String) map.get("fetched_ad");
    }

    private static boolean m14745b(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List<String> m14746c(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int m14747a() {
        return this.f11367l;
    }

    public void m14748a(String str) {
        this.f11366k = str;
    }

    public List<String> m14749b() {
        return this.f11356a;
    }

    public String m14750c() {
        return this.f11359d;
    }

    public String m14751d() {
        return this.f11360e;
    }

    public String m14752e() {
        return this.f11366k;
    }

    public String m14753f() {
        return this.f11361f;
    }

    public boolean m14754g() {
        return this.f11362g;
    }

    public String m14755h() {
        return this.f11364i;
    }

    public String m14756i() {
        return this.f11365j;
    }
}
