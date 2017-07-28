package com.google.android.exoplayer2.p045c.p049d;

import android.support.v4.media.TransportMediator;
import android.util.Log;
import android.util.Pair;
import com.android.gallery3d.ui.FadeTexture;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p041a.C1926a;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2253b;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C2091j;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2000a;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2001b;
import com.google.android.exoplayer2.p045c.p049d.C2012d.C2011a;
import com.google.android.exoplayer2.p064k.C2275a;
import com.google.android.exoplayer2.p064k.C2276b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class C2008b {
    private static final int f5407a = C2273r.m7142e("vide");
    private static final int f5408b = C2273r.m7142e("soun");
    private static final int f5409c = C2273r.m7142e("text");
    private static final int f5410d = C2273r.m7142e("sbtl");
    private static final int f5411e = C2273r.m7142e("subt");
    private static final int f5412f = C2273r.m7142e("clcp");
    private static final int f5413g = C2273r.m7142e("cenc");

    private static final class C2002a {
        public final int f5383a;
        public int f5384b;
        public int f5385c;
        public long f5386d;
        private final boolean f5387e;
        private final C2263k f5388f;
        private final C2263k f5389g;
        private int f5390h;
        private int f5391i;

        public C2002a(C2263k c2263k, C2263k c2263k2, boolean z) {
            boolean z2 = true;
            this.f5389g = c2263k;
            this.f5388f = c2263k2;
            this.f5387e = z;
            c2263k2.m7073c(12);
            this.f5383a = c2263k2.m7092t();
            c2263k.m7073c(12);
            this.f5391i = c2263k.m7092t();
            if (c2263k.m7086n() != 1) {
                z2 = false;
            }
            C2252a.m7025b(z2, "first_chunk must be 1");
            this.f5384b = -1;
        }

        public boolean m5935a() {
            int i = this.f5384b + 1;
            this.f5384b = i;
            if (i == this.f5383a) {
                return false;
            }
            this.f5386d = this.f5387e ? this.f5388f.m7094v() : this.f5388f.m7084l();
            if (this.f5384b == this.f5390h) {
                this.f5385c = this.f5389g.m7092t();
                this.f5389g.m7075d(4);
                i = this.f5391i - 1;
                this.f5391i = i;
                this.f5390h = i > 0 ? this.f5389g.m7092t() - 1 : -1;
            }
            return true;
        }
    }

    private interface C2003b {
        int mo2973a();

        int mo2974b();

        boolean mo2975c();
    }

    private static final class C2004c {
        public final C2022j[] f5392a;
        public Format f5393b;
        public int f5394c;
        public int f5395d = 0;

        public C2004c(int i) {
            this.f5392a = new C2022j[i];
        }
    }

    static final class C2005d implements C2003b {
        private final int f5396a = this.f5398c.m7092t();
        private final int f5397b = this.f5398c.m7092t();
        private final C2263k f5398c;

        public C2005d(C2001b c2001b) {
            this.f5398c = c2001b.aN;
            this.f5398c.m7073c(12);
        }

        public int mo2973a() {
            return this.f5397b;
        }

        public int mo2974b() {
            return this.f5396a == 0 ? this.f5398c.m7092t() : this.f5396a;
        }

        public boolean mo2975c() {
            return this.f5396a != 0;
        }
    }

    static final class C2006e implements C2003b {
        private final C2263k f5399a;
        private final int f5400b = this.f5399a.m7092t();
        private final int f5401c = (this.f5399a.m7092t() & 255);
        private int f5402d;
        private int f5403e;

        public C2006e(C2001b c2001b) {
            this.f5399a = c2001b.aN;
            this.f5399a.m7073c(12);
        }

        public int mo2973a() {
            return this.f5400b;
        }

        public int mo2974b() {
            if (this.f5401c == 8) {
                return this.f5399a.m7079g();
            }
            if (this.f5401c == 16) {
                return this.f5399a.m7080h();
            }
            int i = this.f5402d;
            this.f5402d = i + 1;
            if (i % 2 != 0) {
                return this.f5403e & 15;
            }
            this.f5403e = this.f5399a.m7079g();
            return (this.f5403e & 240) >> 4;
        }

        public boolean mo2975c() {
            return false;
        }
    }

    private static final class C2007f {
        private final int f5404a;
        private final long f5405b;
        private final int f5406c;

        public C2007f(int i, long j, int i2) {
            this.f5404a = i;
            this.f5405b = j;
            this.f5406c = i2;
        }
    }

    private static float m5948a(C2263k c2263k, int i) {
        c2263k.m7073c(i + 8);
        return ((float) c2263k.m7092t()) / ((float) c2263k.m7092t());
    }

    private static int m5949a(C2263k c2263k, int i, int i2) {
        int d = c2263k.m7074d();
        while (d - i < i2) {
            c2263k.m7073c(d);
            int n = c2263k.m7086n();
            C2252a.m7023a(n > 0, "childAtomSize should be positive");
            if (c2263k.m7086n() == C1999a.f5339I) {
                return d;
            }
            d += n;
        }
        return -1;
    }

    private static int m5950a(C2263k c2263k, int i, int i2, C2004c c2004c, int i3) {
        int d = c2263k.m7074d();
        while (d - i < i2) {
            c2263k.m7073c(d);
            int n = c2263k.m7086n();
            C2252a.m7023a(n > 0, "childAtomSize should be positive");
            if (c2263k.m7086n() == C1999a.f5351U) {
                Pair b = C2008b.m5961b(c2263k, d, n);
                if (b != null) {
                    c2004c.f5392a[i3] = (C2022j) b.second;
                    return ((Integer) b.first).intValue();
                }
            }
            d += n;
        }
        return 0;
    }

    private static long m5951a(C2263k c2263k) {
        int i = 8;
        c2263k.m7073c(8);
        if (C1999a.m5928a(c2263k.m7086n()) != 0) {
            i = 16;
        }
        c2263k.m7075d(i);
        return c2263k.m7084l();
    }

    private static Pair<long[], long[]> m5952a(C2000a c2000a) {
        if (c2000a != null) {
            C2001b d = c2000a.m5933d(C1999a.f5346P);
            if (d != null) {
                C2263k c2263k = d.aN;
                c2263k.m7073c(8);
                int a = C1999a.m5928a(c2263k.m7086n());
                int t = c2263k.m7092t();
                Object obj = new long[t];
                Object obj2 = new long[t];
                for (int i = 0; i < t; i++) {
                    obj[i] = a == 1 ? c2263k.m7094v() : c2263k.m7084l();
                    obj2[i] = a == 1 ? c2263k.m7088p() : (long) c2263k.m7086n();
                    if (c2263k.m7082j() != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    c2263k.m7075d(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static C2004c m5953a(C2263k c2263k, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        c2263k.m7073c(12);
        int n = c2263k.m7086n();
        C2004c c2004c = new C2004c(n);
        for (int i3 = 0; i3 < n; i3++) {
            int d = c2263k.m7074d();
            int n2 = c2263k.m7086n();
            C2252a.m7023a(n2 > 0, "childAtomSize should be positive");
            int n3 = c2263k.m7086n();
            if (n3 == C1999a.f5358b || n3 == C1999a.f5359c || n3 == C1999a.f5355Y || n3 == C1999a.ak || n3 == C1999a.f5360d || n3 == C1999a.f5361e || n3 == C1999a.f5362f || n3 == C1999a.aI || n3 == C1999a.aJ) {
                C2008b.m5957a(c2263k, n3, d, n2, i, i2, drmInitData, c2004c, i3);
            } else if (n3 == C1999a.f5365i || n3 == C1999a.f5356Z || n3 == C1999a.f5369m || n3 == C1999a.f5371o || n3 == C1999a.f5373q || n3 == C1999a.f5376t || n3 == C1999a.f5374r || n3 == C1999a.f5375s || n3 == C1999a.ax || n3 == C1999a.ay || n3 == C1999a.f5367k || n3 == C1999a.f5368l) {
                C2008b.m5958a(c2263k, n3, d, n2, i, str, z, drmInitData, c2004c, i3);
            } else if (n3 == C1999a.ai) {
                c2004c.f5393b = Format.m5481a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData);
            } else if (n3 == C1999a.at) {
                c2004c.f5393b = Format.m5481a(Integer.toString(i), "application/x-quicktime-tx3g", null, -1, 0, str, drmInitData);
            } else if (n3 == C1999a.au) {
                c2004c.f5393b = Format.m5481a(Integer.toString(i), "application/x-mp4vtt", null, -1, 0, str, drmInitData);
            } else if (n3 == C1999a.av) {
                c2004c.f5393b = Format.m5482a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData, 0);
            } else if (n3 == C1999a.aw) {
                c2004c.f5393b = Format.m5481a(Integer.toString(i), "application/cea-608", null, -1, 0, str, drmInitData);
                c2004c.f5395d = 1;
            }
            c2263k.m7073c(d + n2);
        }
        return c2004c;
    }

    public static C2021i m5954a(C2000a c2000a, C2001b c2001b, long j, DrmInitData drmInitData, boolean z) {
        C2000a e = c2000a.m5934e(C1999a.f5334D);
        int c = C2008b.m5964c(e.m5933d(C1999a.f5348R).aN);
        if (c == -1) {
            return null;
        }
        C2007f b = C2008b.m5962b(c2000a.m5933d(C1999a.f5344N).aN);
        long a = j == -9223372036854775807L ? b.f5405b : j;
        long a2 = C2008b.m5951a(c2001b.aN);
        long a3 = a == -9223372036854775807L ? -9223372036854775807L : C2273r.m7128a(a, 1000000, a2);
        C2000a e2 = e.m5934e(C1999a.f5335E).m5934e(C1999a.f5336F);
        Pair d = C2008b.m5966d(e.m5933d(C1999a.f5347Q).aN);
        C2004c a4 = C2008b.m5953a(e2.m5933d(C1999a.f5349S).aN, b.f5404a, b.f5406c, (String) d.second, drmInitData, z);
        Pair a5 = C2008b.m5952a(c2000a.m5934e(C1999a.f5345O));
        if (a4.f5393b == null) {
            return null;
        }
        return new C2021i(b.f5404a, c, ((Long) d.first).longValue(), a2, a3, a4.f5393b, a4.f5395d, a4.f5392a, a4.f5394c, (long[]) a5.first, (long[]) a5.second);
    }

    public static C2024l m5955a(C2021i c2021i, C2000a c2000a, C2091j c2091j) {
        C2003b c2005d;
        C2001b d = c2000a.m5933d(C1999a.ap);
        if (d != null) {
            c2005d = new C2005d(d);
        } else {
            d = c2000a.m5933d(C1999a.aq);
            if (d == null) {
                throw new C1970k("Track has no sample table size information");
            }
            c2005d = new C2006e(d);
        }
        int a = c2005d.mo2973a();
        if (a == 0) {
            return new C2024l(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        int t;
        int i;
        int i2;
        Object obj;
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long[] jArr;
        int i9;
        Object obj2;
        Object obj3;
        long j2;
        boolean z = false;
        d = c2000a.m5933d(C1999a.ar);
        if (d == null) {
            z = true;
            d = c2000a.m5933d(C1999a.as);
        }
        C2263k c2263k = d.aN;
        C2263k c2263k2 = c2000a.m5933d(C1999a.ao).aN;
        C2263k c2263k3 = c2000a.m5933d(C1999a.al).aN;
        d = c2000a.m5933d(C1999a.am);
        C2263k c2263k4 = d != null ? d.aN : null;
        C2001b d2 = c2000a.m5933d(C1999a.an);
        C2263k c2263k5 = d2 != null ? d2.aN : null;
        C2002a c2002a = new C2002a(c2263k2, c2263k, z);
        c2263k3.m7073c(12);
        int t2 = c2263k3.m7092t() - 1;
        int t3 = c2263k3.m7092t();
        int t4 = c2263k3.m7092t();
        int i10 = 0;
        if (c2263k5 != null) {
            c2263k5.m7073c(12);
            i10 = c2263k5.m7092t();
        }
        if (c2263k4 != null) {
            c2263k4.m7073c(12);
            t = c2263k4.m7092t();
            if (t > 0) {
                i = t;
                t = c2263k4.m7092t() - 1;
                c2263k = c2263k4;
                i2 = i;
            } else {
                i = t;
                t = -1;
                c2263k = null;
                i2 = i;
            }
        } else {
            t = -1;
            c2263k = c2263k4;
            i2 = 0;
        }
        Object obj4 = (c2005d.mo2975c() && "audio/raw".equals(c2021i.f5483f.f4947e) && t2 == 0 && i10 == 0 && i2 == 0) ? 1 : null;
        if (obj4 == null) {
            obj = new long[a];
            Object obj5 = new int[a];
            long[] jArr2 = new long[a];
            Object obj6 = new int[a];
            long j3 = 0;
            int i11 = 0;
            i3 = t3;
            int i12 = 0;
            int i13 = i2;
            i2 = 0;
            i = t;
            t = i10;
            j = 0;
            i4 = 0;
            i5 = 0;
            i6 = t4;
            i7 = t2;
            t4 = i;
            while (i11 < a) {
                long j4 = j3;
                i8 = i5;
                while (i8 == 0) {
                    C2252a.m7024b(c2002a.m5935a());
                    j4 = c2002a.f5386d;
                    i8 = c2002a.f5385c;
                }
                if (c2263k5 != null) {
                    while (i12 == 0 && t > 0) {
                        i12 = c2263k5.m7092t();
                        i2 = c2263k5.m7086n();
                        t--;
                    }
                    i12--;
                }
                obj[i11] = j4;
                obj5[i11] = c2005d.mo2974b();
                if (obj5[i11] > i4) {
                    i4 = obj5[i11];
                }
                jArr2[i11] = ((long) i2) + j;
                obj6[i11] = c2263k == null ? 1 : 0;
                if (i11 == t4) {
                    obj6[i11] = 1;
                    i5 = i13 - 1;
                    if (i5 > 0) {
                        t4 = c2263k.m7092t() - 1;
                        i13 = i5;
                    } else {
                        i13 = i5;
                    }
                }
                long j5 = ((long) i6) + j;
                i5 = i3 - 1;
                if (i5 != 0 || i7 <= 0) {
                    i = i6;
                    i6 = i5;
                    i5 = i;
                } else {
                    i6 = c2263k3.m7092t();
                    i5 = c2263k3.m7092t();
                    i7--;
                }
                j4 += (long) obj5[i11];
                i10 = i8 - 1;
                i11++;
                j3 = j4;
                i3 = i6;
                i6 = i5;
                i5 = i10;
                j = j5;
            }
            C2252a.m7022a(i12 == 0);
            while (t > 0) {
                C2252a.m7022a(c2263k5.m7092t() == 0);
                c2263k5.m7086n();
                t--;
            }
            if (!(i13 == 0 && i3 == 0 && i5 == 0 && i7 == 0)) {
                Log.w("AtomParsers", "Inconsistent stbl box for track " + c2021i.f5478a + ": remainingSynchronizationSamples " + i13 + ", remainingSamplesAtTimestampDelta " + i3 + ", remainingSamplesInChunk " + i5 + ", remainingTimestampDeltaChanges " + i7);
            }
            obj4 = obj6;
            jArr = jArr2;
            i9 = i4;
            obj2 = obj5;
            obj3 = obj;
            j2 = j;
        } else {
            long[] jArr3 = new long[c2002a.f5383a];
            int[] iArr = new int[c2002a.f5383a];
            while (c2002a.m5935a()) {
                jArr3[c2002a.f5384b] = c2002a.f5386d;
                iArr[c2002a.f5384b] = c2002a.f5385c;
            }
            C2011a a2 = C2012d.m5969a(c2005d.mo2974b(), jArr3, iArr, (long) t4);
            obj3 = a2.f5418a;
            obj2 = a2.f5419b;
            i9 = a2.f5420c;
            jArr = a2.f5421d;
            obj4 = a2.f5422e;
            j2 = 0;
        }
        if (c2021i.f5486i == null || c2091j.m6346a()) {
            C2273r.m7133a(jArr, 1000000, c2021i.f5480c);
            return new C2024l(obj3, obj2, i9, jArr, obj4);
        }
        long a3;
        if (c2021i.f5486i.length == 1 && c2021i.f5479b == 1 && jArr.length >= 2) {
            long j6 = c2021i.f5487j[0];
            a3 = C2273r.m7128a(c2021i.f5486i[0], c2021i.f5480c, c2021i.f5481d) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < a3 && a3 <= j2) {
                j2 -= a3;
                j6 = C2273r.m7128a(j6 - jArr[0], (long) c2021i.f5483f.f4959q, c2021i.f5480c);
                a3 = C2273r.m7128a(j2, (long) c2021i.f5483f.f4959q, c2021i.f5480c);
                if (!(j6 == 0 && a3 == 0) && j6 <= 2147483647L && a3 <= 2147483647L) {
                    c2091j.f5873a = (int) j6;
                    c2091j.f5874b = (int) a3;
                    C2273r.m7133a(jArr, 1000000, c2021i.f5480c);
                    return new C2024l(obj3, obj2, i9, jArr, obj4);
                }
            }
        }
        int i14;
        if (c2021i.f5486i.length == 1 && c2021i.f5486i[0] == 0) {
            for (i14 = 0; i14 < jArr.length; i14++) {
                jArr[i14] = C2273r.m7128a(jArr[i14] - c2021i.f5487j[0], 1000000, c2021i.f5480c);
            }
            return new C2024l(obj3, obj2, i9, jArr, obj4);
        }
        long j7;
        i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i14 < c2021i.f5486i.length) {
            j7 = c2021i.f5487j[i14];
            if (j7 != -1) {
                a3 = C2273r.m7128a(c2021i.f5486i[i14], c2021i.f5480c, c2021i.f5481d);
                i7 = C2273r.m7138b(jArr, j7, true, true);
                i5 = C2273r.m7138b(jArr, a3 + j7, true, false);
                i6 = i17 + (i5 - i7);
                i4 = (i16 != i7 ? 1 : 0) | i15;
            } else {
                i4 = i15;
                i5 = i16;
                i6 = i17;
            }
            i14++;
            i15 = i4;
            i16 = i5;
            i17 = i6;
        }
        t2 = i15 | (i17 != a ? 1 : 0);
        Object obj7 = t2 != 0 ? new long[i17] : obj3;
        Object obj8 = t2 != 0 ? new int[i17] : obj2;
        i6 = t2 != 0 ? 0 : i9;
        obj = t2 != 0 ? new int[i17] : obj4;
        long[] jArr4 = new long[i17];
        i14 = 0;
        i15 = 0;
        j7 = 0;
        i9 = i6;
        while (i14 < c2021i.f5486i.length) {
            j5 = c2021i.f5487j[i14];
            a3 = c2021i.f5486i[i14];
            if (j5 != -1) {
                j = j5 + C2273r.m7128a(a3, c2021i.f5480c, c2021i.f5481d);
                i6 = C2273r.m7138b(jArr, j5, true, true);
                i3 = C2273r.m7138b(jArr, j, true, false);
                if (t2 != 0) {
                    i7 = i3 - i6;
                    System.arraycopy(obj3, i6, obj7, i15, i7);
                    System.arraycopy(obj2, i6, obj8, i15, i7);
                    System.arraycopy(obj4, i6, obj, i15, i7);
                }
                i17 = i15;
                for (i8 = i6; i8 < i3; i8++) {
                    jArr4[i17] = C2273r.m7128a(jArr[i8] - j5, 1000000, c2021i.f5480c) + C2273r.m7128a(j7, 1000000, c2021i.f5481d);
                    if (t2 != 0 && obj8[i17] > i9) {
                        i9 = obj2[i8];
                    }
                    i17++;
                }
                i6 = i9;
                i9 = i17;
            } else {
                i6 = i9;
                i9 = i15;
            }
            i14++;
            i15 = i9;
            j7 = a3 + j7;
            i9 = i6;
        }
        i2 = 0;
        for (i14 = 0; i14 < obj.length && i2 == 0; i14++) {
            i2 |= (obj[i14] & 1) != 0 ? 1 : 0;
        }
        if (i2 != 0) {
            return new C2024l(obj7, obj8, i9, jArr4, obj);
        }
        throw new C1970k("The edited sample sequence does not contain a sync sample.");
    }

    public static void m5956a(C2001b c2001b, boolean z, C2091j c2091j) {
        if (!z) {
            C2263k c2263k = c2001b.aN;
            c2263k.m7073c(8);
            while (c2263k.m7070b() >= 8) {
                int n = c2263k.m7086n();
                if (c2263k.m7086n() == C1999a.aA) {
                    c2263k.m7073c(c2263k.m7074d() - 8);
                    c2263k.m7071b(n + c2263k.m7074d());
                    C2008b.m5959a(c2263k, c2091j);
                    return;
                }
                c2263k.m7075d(n - 8);
            }
        }
    }

    private static void m5957a(C2263k c2263k, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, C2004c c2004c, int i6) {
        c2263k.m7073c(i2 + 8);
        c2263k.m7075d(24);
        int h = c2263k.m7080h();
        int h2 = c2263k.m7080h();
        Object obj = null;
        float f = 1.0f;
        c2263k.m7075d(50);
        int d = c2263k.m7074d();
        if (i == C1999a.f5355Y) {
            i = C2008b.m5950a(c2263k, i2, i3, c2004c, i6);
            c2263k.m7073c(d);
        }
        List list = null;
        String str = null;
        byte[] bArr = null;
        int i7 = -1;
        int i8 = d;
        while (i8 - i2 < i3) {
            c2263k.m7073c(i8);
            int d2 = c2263k.m7074d();
            int n = c2263k.m7086n();
            if (n != 0 || c2263k.m7074d() - i2 != i3) {
                Object obj2;
                C2252a.m7023a(n > 0, "childAtomSize should be positive");
                d = c2263k.m7086n();
                if (d == C1999a.f5337G) {
                    C2252a.m7024b(str == null);
                    str = "video/avc";
                    c2263k.m7073c(d2 + 8);
                    C2275a a = C2275a.m7150a(c2263k);
                    list = a.f6487a;
                    c2004c.f5394c = a.f6488b;
                    if (obj == null) {
                        f = a.f6491e;
                    }
                    obj2 = obj;
                } else if (d == C1999a.f5338H) {
                    C2252a.m7024b(str == null);
                    str = "video/hevc";
                    c2263k.m7073c(d2 + 8);
                    C2276b a2 = C2276b.m7152a(c2263k);
                    list = a2.f6492a;
                    c2004c.f5394c = a2.f6493b;
                    obj2 = obj;
                } else if (d == C1999a.aK) {
                    C2252a.m7024b(str == null);
                    str = i == C1999a.aI ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    obj2 = obj;
                } else if (d == C1999a.f5363g) {
                    C2252a.m7024b(str == null);
                    str = "video/3gpp";
                    obj2 = obj;
                } else if (d == C1999a.f5339I) {
                    C2252a.m7024b(str == null);
                    Pair b = C2008b.m5960b(c2263k, d2);
                    String str2 = (String) b.first;
                    list = Collections.singletonList(b.second);
                    str = str2;
                    obj2 = obj;
                } else if (d == C1999a.ah) {
                    f = C2008b.m5948a(c2263k, d2);
                    obj2 = 1;
                } else if (d == C1999a.aG) {
                    bArr = C2008b.m5967d(c2263k, d2, n);
                    obj2 = obj;
                } else {
                    if (d == C1999a.aF) {
                        d = c2263k.m7079g();
                        c2263k.m7075d(3);
                        if (d == 0) {
                            switch (c2263k.m7079g()) {
                                case 0:
                                    i7 = 0;
                                    obj2 = obj;
                                    continue;
                                case 1:
                                    i7 = 1;
                                    obj2 = obj;
                                    continue;
                                case 2:
                                    i7 = 2;
                                    obj2 = obj;
                                    continue;
                            }
                        }
                    }
                    obj2 = obj;
                }
                i8 += n;
                obj = obj2;
            } else if (str == null) {
                c2004c.f5393b = Format.m5477a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
            }
        }
        if (str == null) {
            c2004c.f5393b = Format.m5477a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
        }
    }

    private static void m5958a(C2263k c2263k, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, C2004c c2004c, int i5) {
        int h;
        int i6;
        int h2;
        c2263k.m7073c(i2 + 8);
        if (z) {
            c2263k.m7075d(8);
            h = c2263k.m7080h();
            c2263k.m7075d(6);
            i6 = h;
        } else {
            c2263k.m7075d(16);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            h2 = c2263k.m7080h();
            c2263k.m7075d(6);
            h = c2263k.m7090r();
            if (i6 == 1) {
                c2263k.m7075d(16);
            }
        } else if (i6 == 2) {
            c2263k.m7075d(16);
            h = (int) Math.round(c2263k.m7095w());
            h2 = c2263k.m7092t();
            c2263k.m7075d(20);
        } else {
            return;
        }
        int d = c2263k.m7074d();
        if (i == C1999a.f5356Z) {
            i = C2008b.m5950a(c2263k, i2, i3, c2004c, i5);
            c2263k.m7073c(d);
        }
        String str2 = null;
        if (i == C1999a.f5369m) {
            str2 = "audio/ac3";
        } else if (i == C1999a.f5371o) {
            str2 = "audio/eac3";
        } else if (i == C1999a.f5373q) {
            str2 = "audio/vnd.dts";
        } else if (i == C1999a.f5374r || i == C1999a.f5375s) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == C1999a.f5376t) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == C1999a.ax) {
            str2 = "audio/3gpp";
        } else if (i == C1999a.ay) {
            str2 = "audio/amr-wb";
        } else if (i == C1999a.f5367k || i == C1999a.f5368l) {
            str2 = "audio/raw";
        }
        Object obj = null;
        int i7 = h;
        int i8 = h2;
        String str3 = str2;
        while (d - i2 < i3) {
            c2263k.m7073c(d);
            int n = c2263k.m7086n();
            C2252a.m7023a(n > 0, "childAtomSize should be positive");
            h = c2263k.m7086n();
            if (h == C1999a.f5339I || (z && h == C1999a.f5366j)) {
                Object obj2;
                h = h == C1999a.f5339I ? d : C2008b.m5949a(c2263k, d, n);
                if (h != -1) {
                    Pair b = C2008b.m5960b(c2263k, h);
                    str3 = (String) b.first;
                    obj2 = (byte[]) b.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair a = C2253b.m7026a(obj2);
                        i7 = ((Integer) a.first).intValue();
                        i8 = ((Integer) a.second).intValue();
                    }
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            } else if (h == C1999a.f5370n) {
                c2263k.m7073c(d + 8);
                c2004c.f5393b = C1926a.m5499a(c2263k, Integer.toString(i4), str, drmInitData);
            } else if (h == C1999a.f5372p) {
                c2263k.m7073c(d + 8);
                c2004c.f5393b = C1926a.m5502b(c2263k, Integer.toString(i4), str, drmInitData);
            } else if (h == C1999a.f5377u) {
                c2004c.f5393b = Format.m5480a(Integer.toString(i4), str3, null, -1, -1, i8, i7, null, drmInitData, 0, str);
            }
            d += n;
        }
        if (c2004c.f5393b == null && str3 != null) {
            c2004c.f5393b = Format.m5479a(Integer.toString(i4), str3, null, -1, -1, i8, i7, "audio/raw".equals(str3) ? 2 : -1, obj == null ? null : Collections.singletonList(obj), drmInitData, 0, str);
        }
    }

    private static void m5959a(C2263k c2263k, C2091j c2091j) {
        c2263k.m7075d(12);
        C2263k c2263k2 = new C2263k();
        while (c2263k.m7070b() >= 8) {
            int n = c2263k.m7086n() - 8;
            if (c2263k.m7086n() == C1999a.aB) {
                c2263k2.m7068a(c2263k.f6454a, c2263k.m7074d() + n);
                c2263k2.m7073c(c2263k.m7074d());
                C2008b.m5963b(c2263k2, c2091j);
                if (c2091j.m6346a()) {
                    return;
                }
            }
            c2263k.m7075d(n);
        }
    }

    private static Pair<String, byte[]> m5960b(C2263k c2263k, int i) {
        Object obj = null;
        c2263k.m7073c((i + 8) + 4);
        c2263k.m7075d(1);
        C2008b.m5968e(c2263k);
        c2263k.m7075d(2);
        int g = c2263k.m7079g();
        if ((g & 128) != 0) {
            c2263k.m7075d(2);
        }
        if ((g & 64) != 0) {
            c2263k.m7075d(c2263k.m7080h());
        }
        if ((g & 32) != 0) {
            c2263k.m7075d(2);
        }
        c2263k.m7075d(1);
        C2008b.m5968e(c2263k);
        switch (c2263k.m7079g()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        c2263k.m7075d(12);
        c2263k.m7075d(1);
        g = C2008b.m5968e(c2263k);
        Object obj2 = new byte[g];
        c2263k.m7069a(obj2, 0, g);
        return Pair.create(obj, obj2);
    }

    private static Pair<Integer, C2022j> m5961b(C2263k c2263k, int i, int i2) {
        boolean z = true;
        Object obj = null;
        boolean z2 = false;
        int i3 = i + 8;
        Object obj2 = null;
        while (i3 - i < i2) {
            c2263k.m7073c(i3);
            int n = c2263k.m7086n();
            int n2 = c2263k.m7086n();
            if (n2 == C1999a.aa) {
                obj2 = Integer.valueOf(c2263k.m7086n());
            } else if (n2 == C1999a.f5352V) {
                c2263k.m7075d(4);
                z2 = c2263k.m7086n() == f5413g;
            } else if (n2 == C1999a.f5353W) {
                obj = C2008b.m5965c(c2263k, i3, n);
            }
            i3 += n;
        }
        if (!z2) {
            return null;
        }
        C2252a.m7023a(obj2 != null, "frma atom is mandatory");
        if (obj == null) {
            z = false;
        }
        C2252a.m7023a(z, "schi->tenc atom is mandatory");
        return Pair.create(obj2, obj);
    }

    private static C2007f m5962b(C2263k c2263k) {
        long j;
        int i = 8;
        c2263k.m7073c(8);
        int a = C1999a.m5928a(c2263k.m7086n());
        c2263k.m7075d(a == 0 ? 8 : 16);
        int n = c2263k.m7086n();
        c2263k.m7075d(4);
        Object obj = 1;
        int d = c2263k.m7074d();
        if (a == 0) {
            i = 4;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (c2263k.f6454a[d + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            c2263k.m7075d(i);
            j = -9223372036854775807L;
        } else {
            j = a == 0 ? c2263k.m7084l() : c2263k.m7094v();
            if (j == 0) {
                j = -9223372036854775807L;
            }
        }
        c2263k.m7075d(16);
        int n2 = c2263k.m7086n();
        int n3 = c2263k.m7086n();
        c2263k.m7075d(4);
        int n4 = c2263k.m7086n();
        int n5 = c2263k.m7086n();
        n2 = (n2 == 0 && n3 == 65536 && n4 == (-65536) && n5 == 0) ? 90 : (n2 == 0 && n3 == (-65536) && n4 == 65536 && n5 == 0) ? 270 : (n2 == (-65536) && n3 == 0 && n4 == 0 && n5 == (-65536)) ? FadeTexture.DURATION : 0;
        return new C2007f(n, j, n2);
    }

    private static void m5963b(C2263k c2263k, C2091j c2091j) {
        while (c2263k.m7070b() > 0) {
            int d = c2263k.m7074d() + c2263k.m7086n();
            if (c2263k.m7086n() == C1999a.aL) {
                String str = null;
                String str2 = null;
                Object obj = null;
                while (c2263k.m7074d() < d) {
                    int n = c2263k.m7086n() - 12;
                    int n2 = c2263k.m7086n();
                    c2263k.m7075d(4);
                    if (n2 == C1999a.aC) {
                        obj = c2263k.m7077e(n);
                    } else if (n2 == C1999a.aD) {
                        str2 = c2263k.m7077e(n);
                    } else if (n2 == C1999a.aE) {
                        c2263k.m7075d(4);
                        str = c2263k.m7077e(n - 4);
                    } else {
                        c2263k.m7075d(n);
                    }
                }
                if (!(str2 == null || str == null || !"com.apple.iTunes".equals(r2))) {
                    c2091j.m6348a(str2, str);
                    return;
                }
            }
            c2263k.m7073c(d);
        }
    }

    private static int m5964c(C2263k c2263k) {
        c2263k.m7073c(16);
        int n = c2263k.m7086n();
        return n == f5408b ? 1 : n == f5407a ? 2 : (n == f5409c || n == f5410d || n == f5411e || n == f5412f) ? 3 : -1;
    }

    private static C2022j m5965c(C2263k c2263k, int i, int i2) {
        boolean z = true;
        int i3 = i + 8;
        while (i3 - i < i2) {
            c2263k.m7073c(i3);
            int n = c2263k.m7086n();
            if (c2263k.m7086n() == C1999a.f5354X) {
                c2263k.m7075d(6);
                if (c2263k.m7079g() != 1) {
                    z = false;
                }
                i3 = c2263k.m7079g();
                byte[] bArr = new byte[16];
                c2263k.m7069a(bArr, 0, bArr.length);
                return new C2022j(z, i3, bArr);
            }
            i3 += n;
        }
        return null;
    }

    private static Pair<Long, String> m5966d(C2263k c2263k) {
        int i = 8;
        c2263k.m7073c(8);
        int a = C1999a.m5928a(c2263k.m7086n());
        c2263k.m7075d(a == 0 ? 8 : 16);
        long l = c2263k.m7084l();
        if (a == 0) {
            i = 4;
        }
        c2263k.m7075d(i);
        int h = c2263k.m7080h();
        return Pair.create(Long.valueOf(l), "" + ((char) (((h >> 10) & 31) + 96)) + ((char) (((h >> 5) & 31) + 96)) + ((char) ((h & 31) + 96)));
    }

    private static byte[] m5967d(C2263k c2263k, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c2263k.m7073c(i3);
            int n = c2263k.m7086n();
            if (c2263k.m7086n() == C1999a.aH) {
                return Arrays.copyOfRange(c2263k.f6454a, i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static int m5968e(C2263k c2263k) {
        int g = c2263k.m7079g();
        int i = g & TransportMediator.KEYCODE_MEDIA_PAUSE;
        while ((g & 128) == 128) {
            g = c2263k.m7079g();
            i = (i << 7) | (g & TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        return i;
    }
}
