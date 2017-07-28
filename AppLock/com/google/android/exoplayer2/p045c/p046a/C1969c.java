package com.google.android.exoplayer2.p045c.p046a;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class C1969c extends C1962d {
    private long f5167b = -9223372036854775807L;

    public C1969c(C2025o c2025o) {
        super(c2025o);
    }

    private static Object m5762a(C2263k c2263k, int i) {
        switch (i) {
            case 0:
                return C1969c.m5765d(c2263k);
            case 1:
                return C1969c.m5764c(c2263k);
            case 2:
                return C1969c.m5766e(c2263k);
            case 3:
                return C1969c.m5768g(c2263k);
            case 8:
                return C1969c.m5769h(c2263k);
            case 10:
                return C1969c.m5767f(c2263k);
            case 11:
                return C1969c.m5770i(c2263k);
            default:
                return null;
        }
    }

    private static int m5763b(C2263k c2263k) {
        return c2263k.m7079g();
    }

    private static Boolean m5764c(C2263k c2263k) {
        boolean z = true;
        if (c2263k.m7079g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double m5765d(C2263k c2263k) {
        return Double.valueOf(Double.longBitsToDouble(c2263k.m7088p()));
    }

    private static String m5766e(C2263k c2263k) {
        int h = c2263k.m7080h();
        int d = c2263k.m7074d();
        c2263k.m7075d(h);
        return new String(c2263k.f6454a, d, h);
    }

    private static ArrayList<Object> m5767f(C2263k c2263k) {
        int t = c2263k.m7092t();
        ArrayList<Object> arrayList = new ArrayList(t);
        for (int i = 0; i < t; i++) {
            arrayList.add(C1969c.m5762a(c2263k, C1969c.m5763b(c2263k)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> m5768g(C2263k c2263k) {
        HashMap<String, Object> hashMap = new HashMap();
        while (true) {
            String e = C1969c.m5766e(c2263k);
            int b = C1969c.m5763b(c2263k);
            if (b == 9) {
                return hashMap;
            }
            hashMap.put(e, C1969c.m5762a(c2263k, b));
        }
    }

    private static HashMap<String, Object> m5769h(C2263k c2263k) {
        int t = c2263k.m7092t();
        HashMap<String, Object> hashMap = new HashMap(t);
        for (int i = 0; i < t; i++) {
            hashMap.put(C1969c.m5766e(c2263k), C1969c.m5762a(c2263k, C1969c.m5763b(c2263k)));
        }
        return hashMap;
    }

    private static Date m5770i(C2263k c2263k) {
        Date date = new Date((long) C1969c.m5765d(c2263k).doubleValue());
        c2263k.m7075d(2);
        return date;
    }

    public long m5771a() {
        return this.f5167b;
    }

    protected void mo2937a(C2263k c2263k, long j) {
        if (C1969c.m5763b(c2263k) != 2) {
            throw new C1970k();
        }
        if (!"onMetaData".equals(C1969c.m5766e(c2263k))) {
            return;
        }
        if (C1969c.m5763b(c2263k) != 8) {
            throw new C1970k();
        }
        Map h = C1969c.m5769h(c2263k);
        if (h.containsKey("duration")) {
            double doubleValue = ((Double) h.get("duration")).doubleValue();
            if (doubleValue > 0.0d) {
                this.f5167b = (long) (doubleValue * 1000000.0d);
            }
        }
    }

    protected boolean mo2938a(C2263k c2263k) {
        return true;
    }
}
