package com.google.android.exoplayer2.p045c.p048c;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C2092k;
import com.google.android.exoplayer2.p045c.p048c.C1991c.C1987a;

final class C1992d implements C1987a {
    private final long[] f5300a;
    private final long[] f5301b;
    private final long f5302c;

    private C1992d(long[] jArr, long[] jArr2, long j) {
        this.f5300a = jArr;
        this.f5301b = jArr2;
        this.f5302c = j;
    }

    public static C1992d m5902a(C2092k c2092k, C2263k c2263k, long j, long j2) {
        c2263k.m7075d(10);
        int n = c2263k.m7086n();
        if (n <= 0) {
            return null;
        }
        int i = c2092k.f5885d;
        long a = C2273r.m7128a((long) n, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, (long) i);
        int h = c2263k.m7080h();
        int h2 = c2263k.m7080h();
        int h3 = c2263k.m7080h();
        c2263k.m7075d(2);
        long j3 = j + ((long) c2092k.f5884c);
        long[] jArr = new long[(h + 1)];
        long[] jArr2 = new long[(h + 1)];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (n = 1; n < jArr.length; n++) {
            int g;
            switch (h3) {
                case 1:
                    g = c2263k.m7079g();
                    break;
                case 2:
                    g = c2263k.m7080h();
                    break;
                case 3:
                    g = c2263k.m7083k();
                    break;
                case 4:
                    g = c2263k.m7092t();
                    break;
                default:
                    return null;
            }
            j3 += (long) (g * h2);
            jArr[n] = (((long) n) * a) / ((long) h);
            jArr2[n] = j2 == -1 ? j3 : Math.min(j2, j3);
        }
        return new C1992d(jArr, jArr2, a);
    }

    public long mo2971a(long j) {
        return this.f5300a[C2273r.m7127a(this.f5301b, j, true, true)];
    }

    public boolean mo2943a() {
        return true;
    }

    public long mo2945b() {
        return this.f5302c;
    }

    public long mo2946b(long j) {
        return this.f5301b[C2273r.m7127a(this.f5300a, j, true, true)];
    }
}
