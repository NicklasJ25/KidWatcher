package com.facebook.ads.internal.p034k;

import java.util.HashMap;
import java.util.Map;

public class C1672b {
    private C1673c f4119a;
    private float f4120b;
    private Map<String, String> f4121c;

    public C1672b(C1673c c1673c) {
        this(c1673c, 0.0f);
    }

    public C1672b(C1673c c1673c, float f) {
        this(c1673c, f, null);
    }

    public C1672b(C1673c c1673c, float f, Map<String, String> map) {
        this.f4119a = c1673c;
        this.f4120b = f;
        if (map != null) {
            this.f4121c = map;
        } else {
            this.f4121c = new HashMap();
        }
    }

    public boolean m4763a() {
        return this.f4119a == C1673c.IS_VIEWABLE;
    }

    public int m4764b() {
        return this.f4119a.m4767a();
    }

    public float m4765c() {
        return this.f4120b;
    }

    public Map<String, String> m4766d() {
        return this.f4121c;
    }
}
