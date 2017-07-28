package com.google.android.exoplayer2.p045c.p048c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2091j;
import com.google.android.exoplayer2.p045c.C2092k;
import com.google.android.exoplayer2.p045c.C2093l;
import java.io.EOFException;

public final class C1991c implements C1966f {
    public static final C1964i f5285a = new C19901();
    private static final int f5286b = C2273r.m7142e("Xing");
    private static final int f5287c = C2273r.m7142e("Info");
    private static final int f5288d = C2273r.m7142e("VBRI");
    private final long f5289e;
    private final C2263k f5290f;
    private final C2092k f5291g;
    private final C2091j f5292h;
    private C2090h f5293i;
    private C2025o f5294j;
    private int f5295k;
    private C1987a f5296l;
    private long f5297m;
    private long f5298n;
    private int f5299o;

    interface C1987a extends C1967m {
        long mo2971a(long j);
    }

    static class C19901 implements C1964i {
        C19901() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C1991c()};
        }
    }

    public C1991c() {
        this(-9223372036854775807L);
    }

    public C1991c(long j) {
        this.f5289e = j;
        this.f5290f = new C2263k(4);
        this.f5291g = new C2092k();
        this.f5292h = new C2091j();
        this.f5297m = -9223372036854775807L;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5894a(com.google.android.exoplayer2.p045c.C1985g r13, boolean r14) {
        /*
        r12 = this;
        r11 = 4;
        r10 = -128000; // 0xfffffffffffe0c00 float:NaN double:NaN;
        r7 = 1;
        r2 = 0;
        if (r14 == 0) goto L_0x0042;
    L_0x0008:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x000a:
        r13.mo2961a();
        r4 = r13.mo2967c();
        r8 = 0;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x009b;
    L_0x0017:
        r1 = r12.f5292h;
        com.google.android.exoplayer2.p045c.p048c.C1989b.m5886a(r13, r1);
        r4 = r13.mo2963b();
        r1 = (int) r4;
        if (r14 != 0) goto L_0x0026;
    L_0x0023:
        r13.mo2964b(r1);
    L_0x0026:
        r3 = r1;
        r4 = r2;
        r5 = r2;
        r1 = r2;
    L_0x002a:
        r6 = r12.f5290f;
        r8 = r6.f6454a;
        if (r5 <= 0) goto L_0x0045;
    L_0x0030:
        r6 = r7;
    L_0x0031:
        r6 = r13.mo2966b(r8, r2, r11, r6);
        if (r6 != 0) goto L_0x0047;
    L_0x0037:
        if (r14 == 0) goto L_0x0097;
    L_0x0039:
        r0 = r3 + r1;
        r13.mo2964b(r0);
    L_0x003e:
        r12.f5295k = r4;
        r2 = r7;
    L_0x0041:
        return r2;
    L_0x0042:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        goto L_0x000a;
    L_0x0045:
        r6 = r2;
        goto L_0x0031;
    L_0x0047:
        r6 = r12.f5290f;
        r6.m7073c(r2);
        r6 = r12.f5290f;
        r6 = r6.m7086n();
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        r8 = r6 & r10;
        r9 = r4 & r10;
        if (r8 != r9) goto L_0x0061;
    L_0x005a:
        r8 = com.google.android.exoplayer2.p045c.C2092k.m6349a(r6);
        r9 = -1;
        if (r8 != r9) goto L_0x0084;
    L_0x0061:
        r4 = r1 + 1;
        if (r1 != r0) goto L_0x006f;
    L_0x0065:
        if (r14 != 0) goto L_0x0041;
    L_0x0067:
        r0 = new com.google.android.exoplayer2.k;
        r1 = "Searched too many bytes.";
        r0.<init>(r1);
        throw r0;
    L_0x006f:
        if (r14 == 0) goto L_0x007d;
    L_0x0071:
        r13.mo2961a();
        r1 = r3 + r4;
        r13.mo2968c(r1);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x007d:
        r13.mo2964b(r7);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x0084:
        r5 = r5 + 1;
        if (r5 != r7) goto L_0x0094;
    L_0x0088:
        r4 = r12.f5291g;
        com.google.android.exoplayer2.p045c.C2092k.m6351a(r6, r4);
        r4 = r6;
    L_0x008e:
        r6 = r8 + -4;
        r13.mo2968c(r6);
        goto L_0x002a;
    L_0x0094:
        if (r5 != r11) goto L_0x008e;
    L_0x0096:
        goto L_0x0037;
    L_0x0097:
        r13.mo2961a();
        goto L_0x003e;
    L_0x009b:
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.c.a(com.google.android.exoplayer2.c.g, boolean):boolean");
    }

    private int m5895b(C1985g c1985g) {
        int n;
        if (this.f5299o == 0) {
            c1985g.mo2961a();
            if (!c1985g.mo2966b(this.f5290f.f6454a, 0, 4, true)) {
                return -1;
            }
            this.f5290f.m7073c(0);
            n = this.f5290f.m7086n();
            if ((n & -128000) != (this.f5295k & -128000) || C2092k.m6349a(n) == -1) {
                c1985g.mo2964b(1);
                this.f5295k = 0;
                return 0;
            }
            C2092k.m6351a(n, this.f5291g);
            if (this.f5297m == -9223372036854775807L) {
                this.f5297m = this.f5296l.mo2971a(c1985g.mo2967c());
                if (this.f5289e != -9223372036854775807L) {
                    long a = this.f5296l.mo2971a(0);
                    this.f5297m = (this.f5289e - a) + this.f5297m;
                }
            }
            this.f5299o = this.f5291g.f5884c;
        }
        n = this.f5294j.mo2976a(c1985g, this.f5299o, true);
        if (n == -1) {
            return -1;
        }
        this.f5299o -= n;
        if (this.f5299o > 0) {
            return 0;
        }
        this.f5294j.mo2977a(((this.f5298n * 1000000) / ((long) this.f5291g.f5885d)) + this.f5297m, 1, this.f5291g.f5884c, 0, null);
        this.f5298n += (long) this.f5291g.f5888g;
        this.f5299o = 0;
        return 0;
    }

    private C1987a m5896c(C1985g c1985g) {
        int n;
        C1987a a;
        int i = 21;
        C2263k c2263k = new C2263k(this.f5291g.f5884c);
        c1985g.mo2969c(c2263k.f6454a, 0, this.f5291g.f5884c);
        long c = c1985g.mo2967c();
        long d = c1985g.mo2970d();
        if ((this.f5291g.f5882a & 1) != 0) {
            if (this.f5291g.f5886e != 1) {
                i = 36;
            }
        } else if (this.f5291g.f5886e == 1) {
            i = 13;
        }
        if (c2263k.m7072c() >= i + 4) {
            c2263k.m7073c(i);
            n = c2263k.m7086n();
        } else {
            n = 0;
        }
        if (n == f5286b || n == f5287c) {
            a = C1993e.m5908a(this.f5291g, c2263k, c, d);
            if (!(a == null || this.f5292h.m6346a())) {
                c1985g.mo2961a();
                c1985g.mo2968c(i + 141);
                c1985g.mo2969c(this.f5290f.f6454a, 0, 3);
                this.f5290f.m7073c(0);
                this.f5292h.m6347a(this.f5290f.m7083k());
            }
            c1985g.mo2964b(this.f5291g.f5884c);
        } else {
            if (c2263k.m7072c() >= 40) {
                c2263k.m7073c(36);
                if (c2263k.m7086n() == f5288d) {
                    a = C1992d.m5902a(this.f5291g, c2263k, c, d);
                    c1985g.mo2964b(this.f5291g.f5884c);
                }
            }
            a = null;
        }
        if (a != null) {
            return a;
        }
        c1985g.mo2961a();
        c1985g.mo2969c(this.f5290f.f6454a, 0, 4);
        this.f5290f.m7073c(0);
        C2092k.m6351a(this.f5290f.m7086n(), this.f5291g);
        return new C1988a(c1985g.mo2967c(), this.f5291g.f5887f, d);
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        if (this.f5295k == 0) {
            try {
                m5894a(c1985g, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.f5296l == null) {
            this.f5296l = m5896c(c1985g);
            this.f5293i.mo3022a(this.f5296l);
            this.f5294j.mo2978a(Format.m5478a(null, this.f5291g.f5883b, null, -1, 4096, this.f5291g.f5886e, this.f5291g.f5885d, -1, this.f5292h.f5873a, this.f5292h.f5874b, null, null, 0, null));
        }
        return m5895b(c1985g);
    }

    public void mo2941a(long j) {
        this.f5295k = 0;
        this.f5297m = -9223372036854775807L;
        this.f5298n = 0;
        this.f5299o = 0;
    }

    public void mo2942a(C2090h c2090h) {
        this.f5293i = c2090h;
        this.f5294j = this.f5293i.mo3019a(0);
        this.f5293i.mo3020a();
    }

    public boolean mo2944a(C1985g c1985g) {
        return m5894a(c1985g, true);
    }

    public void mo2947c() {
    }
}
