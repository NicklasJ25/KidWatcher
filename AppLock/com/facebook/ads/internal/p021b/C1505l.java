package com.facebook.ads.internal.p021b;

import com.facebook.ads.internal.p024l.C1675a;
import com.facebook.ads.internal.p029i.C1613a;
import java.util.ArrayList;
import java.util.List;

public enum C1505l {
    ANBANNER(C1510n.class, C1504k.AN, C1675a.BANNER),
    ANINTERSTITIAL(C1520p.class, C1504k.AN, C1675a.INTERSTITIAL),
    ADMOBNATIVE(C1501i.class, C1504k.ADMOB, C1675a.NATIVE),
    ANNATIVE(C1527r.class, C1504k.AN, C1675a.NATIVE),
    ANINSTREAMVIDEO(C1517o.class, C1504k.AN, C1675a.INSTREAM),
    ANREWARDEDVIDEO(C1530s.class, C1504k.AN, C1675a.REWARDED_VIDEO),
    INMOBINATIVE(C1537w.class, C1504k.INMOBI, C1675a.NATIVE),
    YAHOONATIVE(C1532t.class, C1504k.YAHOO, C1675a.NATIVE);
    
    private static List<C1505l> f3533m;
    public Class<?> f3535i;
    public String f3536j;
    public C1504k f3537k;
    public C1675a f3538l;

    private C1505l(Class<?> cls, C1504k c1504k, C1675a c1675a) {
        this.f3535i = cls;
        this.f3537k = c1504k;
        this.f3538l = c1675a;
    }

    public static List<C1505l> m3982a() {
        if (f3533m == null) {
            synchronized (C1505l.class) {
                f3533m = new ArrayList();
                f3533m.add(ANBANNER);
                f3533m.add(ANINTERSTITIAL);
                f3533m.add(ANNATIVE);
                f3533m.add(ANINSTREAMVIDEO);
                f3533m.add(ANREWARDEDVIDEO);
                if (C1613a.m4522a(C1504k.YAHOO)) {
                    f3533m.add(YAHOONATIVE);
                }
                if (C1613a.m4522a(C1504k.INMOBI)) {
                    f3533m.add(INMOBINATIVE);
                }
                if (C1613a.m4522a(C1504k.ADMOB)) {
                    f3533m.add(ADMOBNATIVE);
                }
            }
        }
        return f3533m;
    }
}
