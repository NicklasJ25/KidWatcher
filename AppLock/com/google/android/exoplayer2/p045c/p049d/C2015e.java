package com.google.android.exoplayer2.p045c.p049d;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1973a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.C2095n;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2000a;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2001b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class C2015e implements C1966f {
    public static final C1964i f5430a = new C20131();
    private static final int f5431b = C2273r.m7142e("seig");
    private static final byte[] f5432c = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private final int f5433d;
    private final C2021i f5434e;
    private final SparseArray<C2014a> f5435f;
    private final C2263k f5436g;
    private final C2263k f5437h;
    private final C2263k f5438i;
    private final C2095n f5439j;
    private final C2263k f5440k;
    private final byte[] f5441l;
    private final Stack<C2000a> f5442m;
    private int f5443n;
    private int f5444o;
    private long f5445p;
    private int f5446q;
    private C2263k f5447r;
    private long f5448s;
    private long f5449t;
    private C2014a f5450u;
    private int f5451v;
    private int f5452w;
    private int f5453x;
    private C2090h f5454y;
    private boolean f5455z;

    static class C20131 implements C1964i {
        C20131() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2015e()};
        }
    }

    private static final class C2014a {
        public final C2023k f5423a = new C2023k();
        public final C2025o f5424b;
        public C2021i f5425c;
        public C2009c f5426d;
        public int f5427e;
        public int f5428f;
        public int f5429g;

        public C2014a(C2025o c2025o) {
            this.f5424b = c2025o;
        }

        public void m5971a() {
            this.f5423a.m6034a();
            this.f5427e = 0;
            this.f5429g = 0;
            this.f5428f = 0;
        }

        public void m5972a(C2021i c2021i, C2009c c2009c) {
            this.f5425c = (C2021i) C2252a.m7020a((Object) c2021i);
            this.f5426d = (C2009c) C2252a.m7020a((Object) c2009c);
            this.f5424b.mo2978a(c2021i.f5483f);
            m5971a();
        }

        public void m5973a(DrmInitData drmInitData) {
            this.f5424b.mo2978a(this.f5425c.f5483f.m5492a(drmInitData));
        }
    }

    public C2015e() {
        this(0, null);
    }

    public C2015e(int i, C2021i c2021i, C2095n c2095n) {
        this.f5434e = c2021i;
        this.f5433d = (c2021i != null ? 4 : 0) | i;
        this.f5439j = c2095n;
        this.f5440k = new C2263k(16);
        this.f5436g = new C2263k(C2261i.f6446a);
        this.f5437h = new C2263k(4);
        this.f5438i = new C2263k(1);
        this.f5441l = new byte[16];
        this.f5442m = new Stack();
        this.f5435f = new SparseArray();
        this.f5449t = -9223372036854775807L;
        m5981a();
    }

    public C2015e(int i, C2095n c2095n) {
        this(i, null, c2095n);
    }

    private int m5974a(C2014a c2014a) {
        C2023k c2023k = c2014a.f5423a;
        C2263k c2263k = c2023k.f5508q;
        int i = (c2023k.f5506o != null ? c2023k.f5506o : c2014a.f5425c.f5485h[c2023k.f5492a.f5414a]).f5490b;
        boolean z = c2023k.f5505n[c2014a.f5427e];
        this.f5438i.f6454a[0] = (byte) ((z ? 128 : 0) | i);
        this.f5438i.m7073c(0);
        C2025o c2025o = c2014a.f5424b;
        c2025o.mo2979a(this.f5438i, 1);
        c2025o.mo2979a(c2263k, i);
        if (!z) {
            return i + 1;
        }
        int h = c2263k.m7080h();
        c2263k.m7075d(-2);
        h = (h * 6) + 2;
        c2025o.mo2979a(c2263k, h);
        return (i + 1) + h;
    }

    private static int m5975a(C2014a c2014a, int i, long j, int i2, C2263k c2263k, int i3) {
        c2263k.m7073c(8);
        int b = C1999a.m5929b(c2263k.m7086n());
        C2021i c2021i = c2014a.f5425c;
        C2023k c2023k = c2014a.f5423a;
        C2009c c2009c = c2023k.f5492a;
        c2023k.f5499h[i] = c2263k.m7092t();
        c2023k.f5498g[i] = c2023k.f5494c;
        if ((b & 1) != 0) {
            long[] jArr = c2023k.f5498g;
            jArr[i] = jArr[i] + ((long) c2263k.m7086n());
        }
        Object obj = (b & 4) != 0 ? 1 : null;
        int i4 = c2009c.f5417d;
        if (obj != null) {
            i4 = c2263k.m7092t();
        }
        Object obj2 = (b & 256) != 0 ? 1 : null;
        Object obj3 = (b & 512) != 0 ? 1 : null;
        Object obj4 = (b & 1024) != 0 ? 1 : null;
        Object obj5 = (b & 2048) != 0 ? 1 : null;
        long a = (c2021i.f5486i != null && c2021i.f5486i.length == 1 && c2021i.f5486i[0] == 0) ? C2273r.m7128a(c2021i.f5487j[0], 1000, c2021i.f5480c) : 0;
        int[] iArr = c2023k.f5500i;
        int[] iArr2 = c2023k.f5501j;
        long[] jArr2 = c2023k.f5502k;
        boolean[] zArr = c2023k.f5503l;
        Object obj6 = (c2021i.f5479b != 2 || (i2 & 1) == 0) ? null : 1;
        int i5 = i3 + c2023k.f5499h[i];
        long j2 = c2021i.f5480c;
        if (i > 0) {
            j = c2023k.f5510s;
        }
        long j3 = j;
        while (i3 < i5) {
            int t = obj2 != null ? c2263k.m7092t() : c2009c.f5415b;
            int t2 = obj3 != null ? c2263k.m7092t() : c2009c.f5416c;
            int n = (i3 != 0 || obj == null) ? obj4 != null ? c2263k.m7086n() : c2009c.f5417d : i4;
            if (obj5 != null) {
                iArr2[i3] = (int) (((long) (c2263k.m7086n() * 1000)) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = C2273r.m7128a(j3, 1000, j2) - a;
            iArr[i3] = t2;
            boolean z = ((n >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j3 += (long) t;
            i3++;
        }
        c2023k.f5510s = j3;
        return i5;
    }

    private static Pair<Integer, C2009c> m5976a(C2263k c2263k) {
        c2263k.m7073c(12);
        return Pair.create(Integer.valueOf(c2263k.m7086n()), new C2009c(c2263k.m7092t() - 1, c2263k.m7092t(), c2263k.m7092t(), c2263k.m7086n()));
    }

    private static C1973a m5977a(C2263k c2263k, long j) {
        long l;
        long l2;
        c2263k.m7073c(8);
        int a = C1999a.m5928a(c2263k.m7086n());
        c2263k.m7075d(4);
        long l3 = c2263k.m7084l();
        if (a == 0) {
            l = c2263k.m7084l() + j;
            l2 = c2263k.m7084l();
        } else {
            l = c2263k.m7094v() + j;
            l2 = c2263k.m7094v();
        }
        c2263k.m7075d(2);
        int h = c2263k.m7080h();
        int[] iArr = new int[h];
        long[] jArr = new long[h];
        long[] jArr2 = new long[h];
        long[] jArr3 = new long[h];
        long j2 = l;
        int i = 0;
        long j3 = l2;
        l2 = C2273r.m7128a(l2, 1000000, l3);
        while (i < h) {
            int n = c2263k.m7086n();
            if ((Integer.MIN_VALUE & n) != 0) {
                throw new C1970k("Unhandled indirect reference");
            }
            long l4 = c2263k.m7084l();
            iArr[i] = n & Integer.MAX_VALUE;
            jArr[i] = j2;
            jArr3[i] = l2;
            l2 = j3 + l4;
            l4 = C2273r.m7128a(l2, 1000000, l3);
            jArr2[i] = l4 - jArr3[i];
            c2263k.m7075d(4);
            j2 += (long) iArr[i];
            i++;
            j3 = l2;
            l2 = l4;
        }
        return new C1973a(iArr, jArr, jArr2, jArr3);
    }

    private static C2014a m5978a(SparseArray<C2014a> sparseArray) {
        C2014a c2014a = null;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            C2014a c2014a2;
            long j2;
            C2014a c2014a3 = (C2014a) sparseArray.valueAt(i);
            long j3;
            if (c2014a3.f5429g == c2014a3.f5423a.f5496e) {
                j3 = j;
                c2014a2 = c2014a;
                j2 = j3;
            } else {
                long j4 = c2014a3.f5423a.f5498g[c2014a3.f5429g];
                if (j4 < j) {
                    c2014a2 = c2014a3;
                    j2 = j4;
                } else {
                    j3 = j;
                    c2014a2 = c2014a;
                    j2 = j3;
                }
            }
            i++;
            c2014a = c2014a2;
            j = j2;
        }
        return c2014a;
    }

    private static C2014a m5979a(C2263k c2263k, SparseArray<C2014a> sparseArray, int i) {
        c2263k.m7073c(8);
        int b = C1999a.m5929b(c2263k.m7086n());
        int n = c2263k.m7086n();
        if ((i & 4) != 0) {
            n = 0;
        }
        C2014a c2014a = (C2014a) sparseArray.get(n);
        if (c2014a == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long v = c2263k.m7094v();
            c2014a.f5423a.f5494c = v;
            c2014a.f5423a.f5495d = v;
        }
        C2009c c2009c = c2014a.f5426d;
        c2014a.f5423a.f5492a = new C2009c((b & 2) != 0 ? c2263k.m7092t() - 1 : c2009c.f5414a, (b & 8) != 0 ? c2263k.m7092t() : c2009c.f5415b, (b & 16) != 0 ? c2263k.m7092t() : c2009c.f5416c, (b & 32) != 0 ? c2263k.m7092t() : c2009c.f5417d);
        return c2014a;
    }

    private static DrmInitData m5980a(List<C2001b> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            C2001b c2001b = (C2001b) list.get(i);
            if (c2001b.aM == C1999a.f5350T) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = c2001b.aN.f6454a;
                UUID a = C2019g.m6028a(bArr);
                if (a == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    list2.add(new SchemeData(a, "video/mp4", bArr));
                }
            }
        }
        return list2 == null ? null : new DrmInitData(list2);
    }

    private void m5981a() {
        this.f5443n = 0;
        this.f5446q = 0;
    }

    private void m5982a(C2000a c2000a) {
        if (c2000a.aM == C1999a.f5331A) {
            m5994b(c2000a);
        } else if (c2000a.aM == C1999a.f5340J) {
            m6000c(c2000a);
        } else if (!this.f5442m.isEmpty()) {
            ((C2000a) this.f5442m.peek()).m5931a(c2000a);
        }
    }

    private static void m5983a(C2000a c2000a, SparseArray<C2014a> sparseArray, int i, byte[] bArr) {
        int size = c2000a.aP.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2000a c2000a2 = (C2000a) c2000a.aP.get(i2);
            if (c2000a2.aM == C1999a.f5341K) {
                C2015e.m5995b(c2000a2, sparseArray, i, bArr);
            }
        }
    }

    private static void m5984a(C2000a c2000a, C2014a c2014a, long j, int i) {
        List list = c2000a.aO;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int t;
            C2001b c2001b = (C2001b) list.get(i2);
            if (c2001b.aM == C1999a.f5381y) {
                C2263k c2263k = c2001b.aN;
                c2263k.m7073c(12);
                t = c2263k.m7092t();
                if (t > 0) {
                    t += i3;
                    i3 = i4 + 1;
                    i2++;
                    i4 = i3;
                    i3 = t;
                }
            }
            t = i3;
            i3 = i4;
            i2++;
            i4 = i3;
            i3 = t;
        }
        c2014a.f5429g = 0;
        c2014a.f5428f = 0;
        c2014a.f5427e = 0;
        c2014a.f5423a.m6036a(i4, i3);
        int i5 = 0;
        i3 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            c2001b = (C2001b) list.get(i6);
            if (c2001b.aM == C1999a.f5381y) {
                int i7 = i3 + 1;
                i5 = C2015e.m5975a(c2014a, i3, j, i, c2001b.aN, i5);
                i3 = i7;
            }
        }
    }

    private void m5985a(C2001b c2001b, long j) {
        if (!this.f5442m.isEmpty()) {
            ((C2000a) this.f5442m.peek()).m5932a(c2001b);
        } else if (c2001b.aM == C1999a.f5382z) {
            this.f5454y.mo3022a(C2015e.m5977a(c2001b.aN, j));
            this.f5455z = true;
        }
    }

    private static void m5986a(C2022j c2022j, C2263k c2263k, C2023k c2023k) {
        boolean z = true;
        int i = c2022j.f5490b;
        c2263k.m7073c(8);
        if ((C1999a.m5929b(c2263k.m7086n()) & 1) == 1) {
            c2263k.m7075d(8);
        }
        int g = c2263k.m7079g();
        int t = c2263k.m7092t();
        if (t != c2023k.f5497f) {
            throw new C1970k("Length mismatch: " + t + ", " + c2023k.f5497f);
        }
        if (g == 0) {
            boolean[] zArr = c2023k.f5505n;
            int i2 = 0;
            g = 0;
            while (i2 < t) {
                int g2 = c2263k.m7079g();
                int i3 = g + g2;
                zArr[i2] = g2 > i;
                i2++;
                g = i3;
            }
        } else {
            if (g <= i) {
                z = false;
            }
            g = (g * t) + 0;
            Arrays.fill(c2023k.f5505n, 0, t, z);
        }
        c2023k.m6035a(g);
    }

    private static void m5987a(C2263k c2263k, int i, C2023k c2023k) {
        c2263k.m7073c(i + 8);
        int b = C1999a.m5929b(c2263k.m7086n());
        if ((b & 1) != 0) {
            throw new C1970k("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b & 2) != 0;
        int t = c2263k.m7092t();
        if (t != c2023k.f5497f) {
            throw new C1970k("Length mismatch: " + t + ", " + c2023k.f5497f);
        }
        Arrays.fill(c2023k.f5505n, 0, t, z);
        c2023k.m6035a(c2263k.m7070b());
        c2023k.m6038a(c2263k);
    }

    private static void m5988a(C2263k c2263k, C2023k c2023k) {
        c2263k.m7073c(8);
        int n = c2263k.m7086n();
        if ((C1999a.m5929b(n) & 1) == 1) {
            c2263k.m7075d(8);
        }
        int t = c2263k.m7092t();
        if (t != 1) {
            throw new C1970k("Unexpected saio entry count: " + t);
        }
        n = C1999a.m5928a(n);
        c2023k.f5495d = (n == 0 ? c2263k.m7084l() : c2263k.m7094v()) + c2023k.f5495d;
    }

    private static void m5989a(C2263k c2263k, C2023k c2023k, byte[] bArr) {
        c2263k.m7073c(8);
        c2263k.m7069a(bArr, 0, 16);
        if (Arrays.equals(bArr, f5432c)) {
            C2015e.m5987a(c2263k, 16, c2023k);
        }
    }

    private static void m5990a(C2263k c2263k, C2263k c2263k2, C2023k c2023k) {
        c2263k.m7073c(8);
        int n = c2263k.m7086n();
        if (c2263k.m7086n() == f5431b) {
            if (C1999a.m5928a(n) == 1) {
                c2263k.m7075d(4);
            }
            if (c2263k.m7086n() != 1) {
                throw new C1970k("Entry count in sbgp != 1 (unsupported).");
            }
            c2263k2.m7073c(8);
            n = c2263k2.m7086n();
            if (c2263k2.m7086n() == f5431b) {
                n = C1999a.m5928a(n);
                if (n == 1) {
                    if (c2263k2.m7084l() == 0) {
                        throw new C1970k("Variable length decription in sgpd found (unsupported)");
                    }
                } else if (n >= 2) {
                    c2263k2.m7075d(4);
                }
                if (c2263k2.m7084l() != 1) {
                    throw new C1970k("Entry count in sgpd != 1 (unsupported).");
                }
                c2263k2.m7075d(2);
                boolean z = c2263k2.m7079g() == 1;
                if (z) {
                    int g = c2263k2.m7079g();
                    byte[] bArr = new byte[16];
                    c2263k2.m7069a(bArr, 0, bArr.length);
                    c2023k.f5504m = true;
                    c2023k.f5506o = new C2022j(z, g, bArr);
                }
            }
        }
    }

    private static boolean m5991a(int i) {
        return i == C1999a.f5348R || i == C1999a.f5347Q || i == C1999a.f5332B || i == C1999a.f5382z || i == C1999a.f5349S || i == C1999a.f5378v || i == C1999a.f5379w || i == C1999a.f5344N || i == C1999a.f5380x || i == C1999a.f5381y || i == C1999a.f5350T || i == C1999a.ab || i == C1999a.ac || i == C1999a.ag || i == C1999a.af || i == C1999a.ad || i == C1999a.ae || i == C1999a.f5346P || i == C1999a.f5343M;
    }

    private static long m5992b(C2263k c2263k) {
        c2263k.m7073c(8);
        return C1999a.m5928a(c2263k.m7086n()) == 0 ? c2263k.m7084l() : c2263k.m7094v();
    }

    private void m5993b(long j) {
        while (!this.f5442m.isEmpty() && ((C2000a) this.f5442m.peek()).aN == j) {
            m5982a((C2000a) this.f5442m.pop());
        }
        m5981a();
    }

    private void m5994b(C2000a c2000a) {
        int i;
        C2021i a;
        boolean z = true;
        int i2 = 0;
        C2252a.m7025b(this.f5434e == null, "Unexpected moov box.");
        DrmInitData a2 = C2015e.m5980a(c2000a.aO);
        C2000a e = c2000a.m5934e(C1999a.f5342L);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = e.aO.size();
        for (i = 0; i < size; i++) {
            C2001b c2001b = (C2001b) e.aO.get(i);
            if (c2001b.aM == C1999a.f5380x) {
                Pair a3 = C2015e.m5976a(c2001b.aN);
                sparseArray.put(((Integer) a3.first).intValue(), a3.second);
            } else if (c2001b.aM == C1999a.f5343M) {
                j = C2015e.m5992b(c2001b.aN);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c2000a.aP.size();
        for (int i3 = 0; i3 < size2; i3++) {
            C2000a c2000a2 = (C2000a) c2000a.aP.get(i3);
            if (c2000a2.aM == C1999a.f5333C) {
                a = C2008b.m5954a(c2000a2, c2000a.m5933d(C1999a.f5332B), j, a2, false);
                if (a != null) {
                    sparseArray2.put(a.f5478a, a);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.f5435f.size() == 0) {
            for (i = 0; i < size3; i++) {
                a = (C2021i) sparseArray2.valueAt(i);
                this.f5435f.put(a.f5478a, new C2014a(this.f5454y.mo3019a(i)));
                this.f5449t = Math.max(this.f5449t, a.f5482e);
            }
            this.f5454y.mo3020a();
        } else {
            if (this.f5435f.size() != size3) {
                z = false;
            }
            C2252a.m7024b(z);
        }
        while (i2 < size3) {
            a = (C2021i) sparseArray2.valueAt(i2);
            ((C2014a) this.f5435f.get(a.f5478a)).m5972a(a, (C2009c) sparseArray.get(a.f5478a));
            i2++;
        }
    }

    private static void m5995b(C2000a c2000a, SparseArray<C2014a> sparseArray, int i, byte[] bArr) {
        C2014a a = C2015e.m5979a(c2000a.m5933d(C1999a.f5379w).aN, (SparseArray) sparseArray, i);
        if (a != null) {
            C2023k c2023k = a.f5423a;
            long j = c2023k.f5510s;
            a.m5971a();
            if (c2000a.m5933d(C1999a.f5378v) != null && (i & 2) == 0) {
                j = C2015e.m5999c(c2000a.m5933d(C1999a.f5378v).aN);
            }
            C2015e.m5984a(c2000a, a, j, i);
            C2001b d = c2000a.m5933d(C1999a.ab);
            if (d != null) {
                C2015e.m5986a(a.f5425c.f5485h[c2023k.f5492a.f5414a], d.aN, c2023k);
            }
            d = c2000a.m5933d(C1999a.ac);
            if (d != null) {
                C2015e.m5988a(d.aN, c2023k);
            }
            d = c2000a.m5933d(C1999a.ag);
            if (d != null) {
                C2015e.m5996b(d.aN, c2023k);
            }
            d = c2000a.m5933d(C1999a.ad);
            C2001b d2 = c2000a.m5933d(C1999a.ae);
            if (!(d == null || d2 == null)) {
                C2015e.m5990a(d.aN, d2.aN, c2023k);
            }
            int size = c2000a.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                d = (C2001b) c2000a.aO.get(i2);
                if (d.aM == C1999a.af) {
                    C2015e.m5989a(d.aN, c2023k, bArr);
                }
            }
        }
    }

    private static void m5996b(C2263k c2263k, C2023k c2023k) {
        C2015e.m5987a(c2263k, 0, c2023k);
    }

    private static boolean m5997b(int i) {
        return i == C1999a.f5331A || i == C1999a.f5333C || i == C1999a.f5334D || i == C1999a.f5335E || i == C1999a.f5336F || i == C1999a.f5340J || i == C1999a.f5341K || i == C1999a.f5342L || i == C1999a.f5345O;
    }

    private boolean m5998b(C1985g c1985g) {
        if (this.f5446q == 0) {
            if (!c1985g.mo2962a(this.f5440k.f6454a, 0, 8, true)) {
                return false;
            }
            this.f5446q = 8;
            this.f5440k.m7073c(0);
            this.f5445p = this.f5440k.m7084l();
            this.f5444o = this.f5440k.m7086n();
        }
        if (this.f5445p == 1) {
            c1985g.mo2965b(this.f5440k.f6454a, 8, 8);
            this.f5446q += 8;
            this.f5445p = this.f5440k.m7094v();
        }
        long c = c1985g.mo2967c() - ((long) this.f5446q);
        if (this.f5444o == C1999a.f5340J) {
            int size = this.f5435f.size();
            for (int i = 0; i < size; i++) {
                C2023k c2023k = ((C2014a) this.f5435f.valueAt(i)).f5423a;
                c2023k.f5493b = c;
                c2023k.f5495d = c;
                c2023k.f5494c = c;
            }
        }
        if (this.f5444o == C1999a.f5364h) {
            this.f5450u = null;
            this.f5448s = this.f5445p + c;
            if (!this.f5455z) {
                this.f5454y.mo3022a(new C2094a(this.f5449t));
                this.f5455z = true;
            }
            this.f5443n = 2;
            return true;
        }
        if (C2015e.m5997b(this.f5444o)) {
            long c2 = (c1985g.mo2967c() + this.f5445p) - 8;
            this.f5442m.add(new C2000a(this.f5444o, c2));
            if (this.f5445p == ((long) this.f5446q)) {
                m5993b(c2);
            } else {
                m5981a();
            }
        } else if (C2015e.m5991a(this.f5444o)) {
            if (this.f5446q != 8) {
                throw new C1970k("Leaf atom defines extended atom size (unsupported).");
            } else if (this.f5445p > 2147483647L) {
                throw new C1970k("Leaf atom with length > 2147483647 (unsupported).");
            } else {
                this.f5447r = new C2263k((int) this.f5445p);
                System.arraycopy(this.f5440k.f6454a, 0, this.f5447r.f6454a, 0, 8);
                this.f5443n = 1;
            }
        } else if (this.f5445p > 2147483647L) {
            throw new C1970k("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.f5447r = null;
            this.f5443n = 1;
        }
        return true;
    }

    private static long m5999c(C2263k c2263k) {
        c2263k.m7073c(8);
        return C1999a.m5928a(c2263k.m7086n()) == 1 ? c2263k.m7094v() : c2263k.m7084l();
    }

    private void m6000c(C2000a c2000a) {
        C2015e.m5983a(c2000a, this.f5435f, this.f5433d, this.f5441l);
        DrmInitData a = C2015e.m5980a(c2000a.aO);
        if (a != null) {
            int size = this.f5435f.size();
            for (int i = 0; i < size; i++) {
                ((C2014a) this.f5435f.valueAt(i)).m5973a(a);
            }
        }
    }

    private void m6001c(C1985g c1985g) {
        int i = ((int) this.f5445p) - this.f5446q;
        if (this.f5447r != null) {
            c1985g.mo2965b(this.f5447r.f6454a, 8, i);
            m5985a(new C2001b(this.f5444o, this.f5447r), c1985g.mo2967c());
        } else {
            c1985g.mo2964b(i);
        }
        m5993b(c1985g.mo2967c());
    }

    private void m6002d(C1985g c1985g) {
        C2014a c2014a = null;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        int size = this.f5435f.size();
        int i = 0;
        while (i < size) {
            C2014a c2014a2;
            long j2;
            C2023k c2023k = ((C2014a) this.f5435f.valueAt(i)).f5423a;
            long j3;
            if (!c2023k.f5509r || c2023k.f5495d >= j) {
                j3 = j;
                c2014a2 = c2014a;
                j2 = j3;
            } else {
                j3 = c2023k.f5495d;
                c2014a2 = (C2014a) this.f5435f.valueAt(i);
                j2 = j3;
            }
            i++;
            c2014a = c2014a2;
            j = j2;
        }
        if (c2014a == null) {
            this.f5443n = 3;
            return;
        }
        int c = (int) (j - c1985g.mo2967c());
        if (c < 0) {
            throw new C1970k("Offset to encryption data was negative.");
        }
        c1985g.mo2964b(c);
        c2014a.f5423a.m6037a(c1985g);
    }

    private boolean m6003e(C1985g c1985g) {
        int c;
        int i;
        byte[] bArr;
        if (this.f5443n == 3) {
            if (this.f5450u == null) {
                C2014a a = C2015e.m5978a(this.f5435f);
                if (a == null) {
                    c = (int) (this.f5448s - c1985g.mo2967c());
                    if (c < 0) {
                        throw new C1970k("Offset to end of mdat was negative.");
                    }
                    c1985g.mo2964b(c);
                    m5981a();
                    return false;
                }
                long j = a.f5423a.f5498g[a.f5429g];
                c = (int) (j - c1985g.mo2967c());
                if (c < 0) {
                    if (j == a.f5423a.f5493b) {
                        Log.w("FragmentedMp4Extractor", "Offset to sample data was missing.");
                        c = 0;
                    } else {
                        throw new C1970k("Offset to sample data was negative.");
                    }
                }
                c1985g.mo2964b(c);
                this.f5450u = a;
            }
            this.f5451v = this.f5450u.f5423a.f5500i[this.f5450u.f5427e];
            if (this.f5450u.f5423a.f5504m) {
                this.f5452w = m5974a(this.f5450u);
                this.f5451v += this.f5452w;
            } else {
                this.f5452w = 0;
            }
            if (this.f5450u.f5425c.f5484g == 1) {
                this.f5451v -= 8;
                c1985g.mo2964b(8);
            }
            this.f5443n = 4;
            this.f5453x = 0;
        }
        C2023k c2023k = this.f5450u.f5423a;
        C2021i c2021i = this.f5450u.f5425c;
        C2025o c2025o = this.f5450u.f5424b;
        int i2 = this.f5450u.f5427e;
        if (c2021i.f5488k != 0) {
            byte[] bArr2 = this.f5437h.f6454a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            c = c2021i.f5488k;
            i = 4 - c2021i.f5488k;
            while (this.f5452w < this.f5451v) {
                if (this.f5453x == 0) {
                    c1985g.mo2965b(this.f5437h.f6454a, i, c);
                    this.f5437h.m7073c(0);
                    this.f5453x = this.f5437h.m7092t();
                    this.f5436g.m7073c(0);
                    c2025o.mo2979a(this.f5436g, 4);
                    this.f5452w += 4;
                    this.f5451v += i;
                } else {
                    int a2 = c2025o.mo2976a(c1985g, this.f5453x, false);
                    this.f5452w += a2;
                    this.f5453x -= a2;
                }
            }
        } else {
            while (this.f5452w < this.f5451v) {
                this.f5452w = c2025o.mo2976a(c1985g, this.f5451v - this.f5452w, false) + this.f5452w;
            }
        }
        long b = 1000 * c2023k.m6039b(i2);
        i = (c2023k.f5504m ? 1073741824 : 0) | (c2023k.f5503l[i2] ? 1 : 0);
        c = c2023k.f5492a.f5414a;
        if (c2023k.f5504m) {
            bArr = c2023k.f5506o != null ? c2023k.f5506o.f5491c : c2021i.f5485h[c].f5491c;
        } else {
            bArr = null;
        }
        c2025o.mo2977a(this.f5439j != null ? this.f5439j.m6359b(b) : b, i, this.f5451v, 0, bArr);
        C2014a c2014a = this.f5450u;
        c2014a.f5427e++;
        c2014a = this.f5450u;
        c2014a.f5428f++;
        if (this.f5450u.f5428f == c2023k.f5499h[this.f5450u.f5429g]) {
            c2014a = this.f5450u;
            c2014a.f5429g++;
            this.f5450u.f5428f = 0;
            this.f5450u = null;
        }
        this.f5443n = 3;
        return true;
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        while (true) {
            switch (this.f5443n) {
                case 0:
                    if (m5998b(c1985g)) {
                        break;
                    }
                    return -1;
                case 1:
                    m6001c(c1985g);
                    break;
                case 2:
                    m6002d(c1985g);
                    break;
                default:
                    if (!m6003e(c1985g)) {
                        break;
                    }
                    return 0;
            }
        }
    }

    public void mo2941a(long j) {
        int size = this.f5435f.size();
        for (int i = 0; i < size; i++) {
            ((C2014a) this.f5435f.valueAt(i)).m5971a();
        }
        this.f5442m.clear();
        m5981a();
    }

    public void mo2942a(C2090h c2090h) {
        this.f5454y = c2090h;
        if (this.f5434e != null) {
            C2014a c2014a = new C2014a(c2090h.mo3019a(0));
            c2014a.m5972a(this.f5434e, new C2009c(0, 0, 0, 0));
            this.f5435f.put(0, c2014a);
            this.f5454y.mo3020a();
        }
    }

    public boolean mo2944a(C1985g c1985g) {
        return C2020h.m6031a(c1985g);
    }

    public void mo2947c() {
    }
}
