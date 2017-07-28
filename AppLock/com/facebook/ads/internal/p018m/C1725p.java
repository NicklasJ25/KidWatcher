package com.facebook.ads.internal.p018m;

import com.facebook.ads.internal.p028g.C1575c;
import com.facebook.ads.internal.p028g.C1580f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class C1725p {
    private static Map<String, Long> f4345a = new ConcurrentHashMap();
    private static Map<String, Long> f4346b = new ConcurrentHashMap();
    private static Map<String, String> f4347c = new ConcurrentHashMap();

    private static long m4944a(String str, C1575c c1575c) {
        if (f4345a.containsKey(str)) {
            return ((Long) f4345a.get(str)).longValue();
        }
        switch (c1575c) {
            case BANNER:
                return 15000;
            case INTERSTITIAL:
            case NATIVE:
                return -1000;
            default:
                return -1000;
        }
    }

    public static void m4945a(long j, C1580f c1580f) {
        f4345a.put(C1725p.m4950d(c1580f), Long.valueOf(j));
    }

    public static void m4946a(String str, C1580f c1580f) {
        f4347c.put(C1725p.m4950d(c1580f), str);
    }

    public static boolean m4947a(C1580f c1580f) {
        String d = C1725p.m4950d(c1580f);
        if (!f4346b.containsKey(d)) {
            return false;
        }
        return System.currentTimeMillis() - ((Long) f4346b.get(d)).longValue() < C1725p.m4944a(d, c1580f.m4404b());
    }

    public static void m4948b(C1580f c1580f) {
        f4346b.put(C1725p.m4950d(c1580f), Long.valueOf(System.currentTimeMillis()));
    }

    public static String m4949c(C1580f c1580f) {
        return (String) f4347c.get(C1725p.m4950d(c1580f));
    }

    private static String m4950d(C1580f c1580f) {
        int i = 0;
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        objArr[0] = c1580f.m4403a();
        objArr[1] = c1580f.m4404b();
        objArr[2] = c1580f.f3907e;
        objArr[3] = Integer.valueOf(c1580f.m4405c() == null ? 0 : c1580f.m4405c().m3768b());
        if (c1580f.m4405c() != null) {
            i = c1580f.m4405c().m3767a();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(c1580f.m4406d());
        return String.format(str, objArr);
    }
}
