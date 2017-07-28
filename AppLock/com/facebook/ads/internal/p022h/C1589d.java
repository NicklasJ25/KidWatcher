package com.facebook.ads.internal.p022h;

import android.content.Context;
import com.facebook.ads.internal.p018m.C1694b;
import com.facebook.ads.internal.p018m.C1729s;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C1589d {
    protected final String f3962a;
    protected final double f3963b;
    protected final double f3964c;
    protected final String f3965d;
    protected final Map<String, String> f3966e;

    public C1589d(Context context, String str, double d, String str2, Map<String, String> map) {
        this.f3962a = str;
        this.f3963b = ((double) System.currentTimeMillis()) / 1000.0d;
        this.f3964c = d;
        this.f3965d = str2;
        Map hashMap = new HashMap();
        if (!(map == null || map.isEmpty())) {
            hashMap.putAll(map);
        }
        if (mo2734c()) {
            hashMap.put("analog", C1729s.m4963a(C1694b.m4844a()));
        }
        this.f3966e = C1589d.m4419a(hashMap);
    }

    public C1589d(String str, double d, String str2, Map<String, String> map) {
        this(null, str, d, str2, map);
    }

    private static Map<String, String> m4419a(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public abstract C1600h mo2732a();

    public abstract String mo2733b();

    public abstract boolean mo2734c();

    public String m4423d() {
        return this.f3962a;
    }

    public double m4424e() {
        return this.f3963b;
    }

    public double m4425f() {
        return this.f3964c;
    }

    public String m4426g() {
        return this.f3965d;
    }

    public Map<String, String> m4427h() {
        return this.f3966e;
    }

    public final boolean m4428i() {
        return mo2732a() == C1600h.IMMEDIATE;
    }
}
