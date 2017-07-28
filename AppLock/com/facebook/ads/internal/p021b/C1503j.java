package com.facebook.ads.internal.p021b;

import com.facebook.ads.internal.p018m.C1712h;
import com.facebook.ads.internal.p024l.C1675a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class C1503j {
    private static final Set<C1505l> f3517a = new HashSet();
    private static final Map<C1675a, String> f3518b = new ConcurrentHashMap();

    static {
        for (C1505l c1505l : C1505l.m3982a()) {
            Class cls;
            switch (c1505l.f3538l) {
                case BANNER:
                    cls = C1492b.class;
                    break;
                case INTERSTITIAL:
                    cls = C1493d.class;
                    break;
                case NATIVE:
                    cls = ab.class;
                    break;
                case INSTREAM:
                    cls = C1516x.class;
                    break;
                case REWARDED_VIDEO:
                    cls = ad.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class cls2 = c1505l.f3535i;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(c1505l.f3536j);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f3517a.add(c1505l);
                }
            }
        }
    }

    public static C1490a m3977a(C1504k c1504k, C1675a c1675a) {
        try {
            C1505l b = C1503j.m3980b(c1504k, c1675a);
            if (b != null && f3517a.contains(b)) {
                Class cls = b.f3535i;
                if (cls == null) {
                    cls = Class.forName(b.f3536j);
                }
                return (C1490a) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static C1490a m3978a(String str, C1675a c1675a) {
        return C1503j.m3977a(C1504k.m3981a(str), c1675a);
    }

    public static String m3979a(C1675a c1675a) {
        if (f3518b.containsKey(c1675a)) {
            return (String) f3518b.get(c1675a);
        }
        Set hashSet = new HashSet();
        for (C1505l c1505l : f3517a) {
            if (c1505l.f3538l == c1675a) {
                hashSet.add(c1505l.f3537k.toString());
            }
        }
        String a = C1712h.m4925a(hashSet, ",");
        f3518b.put(c1675a, a);
        return a;
    }

    private static C1505l m3980b(C1504k c1504k, C1675a c1675a) {
        for (C1505l c1505l : f3517a) {
            if (c1505l.f3537k == c1504k && c1505l.f3538l == c1675a) {
                return c1505l;
            }
        }
        return null;
    }
}
