package com.google.android.exoplayer2.p045c.p048c;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C2092k;
import com.google.android.exoplayer2.p045c.p048c.C1991c.C1987a;

final class C1993e implements C1987a {
    private final long f5303a;
    private final long f5304b;
    private final long f5305c;
    private final long[] f5306d;
    private final long f5307e;
    private final int f5308f;

    private C1993e(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    private C1993e(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f5303a = j;
        this.f5304b = j2;
        this.f5305c = j3;
        this.f5306d = jArr;
        this.f5307e = j4;
        this.f5308f = i;
    }

    private long m5907a(int i) {
        return (this.f5304b * ((long) i)) / 100;
    }

    public static C1993e m5908a(C2092k c2092k, C2263k c2263k, long j, long j2) {
        int i = c2092k.f5888g;
        int i2 = c2092k.f5885d;
        long j3 = j + ((long) c2092k.f5884c);
        int n = c2263k.m7086n();
        if ((n & 1) == 1) {
            int t = c2263k.m7092t();
            if (t != 0) {
                long a = C2273r.m7128a((long) t, ((long) i) * 1000000, (long) i2);
                if ((n & 6) != 6) {
                    return new C1993e(j3, a, j2);
                }
                long t2 = (long) c2263k.m7092t();
                c2263k.m7075d(1);
                long[] jArr = new long[99];
                for (t = 0; t < 99; t++) {
                    jArr[t] = (long) c2263k.m7079g();
                }
                return new C1993e(j3, a, j2, jArr, t2, c2092k.f5884c);
            }
        }
        return null;
    }

    public long mo2971a(long j) {
        if (!mo2943a() || j < this.f5303a) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.f5303a))) / ((double) this.f5307e);
        int a = C2273r.m7127a(this.f5306d, (long) d, true, false) + 1;
        long a2 = m5907a(a);
        long j2 = a == 0 ? 0 : this.f5306d[a - 1];
        long j3 = a == 99 ? 256 : this.f5306d[a];
        return a2 + (j3 == j2 ? 0 : (long) ((((double) (m5907a(a + 1) - a2)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    public boolean mo2943a() {
        return this.f5306d != null;
    }

    public long mo2945b() {
        return this.f5304b;
    }

    public long mo2946b(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        if (!mo2943a()) {
            return this.f5303a;
        }
        float f3 = (((float) j) * 100.0f) / ((float) this.f5304b);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) this.f5306d[i - 1];
            }
            if (i < 99) {
                f = (float) this.f5306d[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        return Math.min(this.f5303a + Math.round((((double) f) * 0.00390625d) * ((double) this.f5307e)), this.f5305c != -1 ? this.f5305c - 1 : ((this.f5303a - ((long) this.f5308f)) + this.f5307e) - 1);
    }
}
