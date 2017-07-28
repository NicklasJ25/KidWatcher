package com.google.android.exoplayer2.p045c.p049d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2091j;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2000a;
import com.google.android.exoplayer2.p045c.p049d.C1999a.C2001b;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class C2018f implements C1966f, C1967m {
    public static final C1964i f5460a = new C20161();
    private static final int f5461b = C2273r.m7142e("qt  ");
    private final C2263k f5462c = new C2263k(C2261i.f6446a);
    private final C2263k f5463d = new C2263k(4);
    private final C2263k f5464e = new C2263k(16);
    private final Stack<C2000a> f5465f = new Stack();
    private int f5466g;
    private int f5467h;
    private long f5468i;
    private int f5469j;
    private C2263k f5470k;
    private int f5471l;
    private int f5472m;
    private C2090h f5473n;
    private C2017a[] f5474o;
    private long f5475p;
    private boolean f5476q;

    static class C20161 implements C1964i {
        C20161() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2018f()};
        }
    }

    private static final class C2017a {
        public final C2021i f5456a;
        public final C2024l f5457b;
        public final C2025o f5458c;
        public int f5459d;

        public C2017a(C2021i c2021i, C2024l c2024l, C2025o c2025o) {
            this.f5456a = c2021i;
            this.f5457b = c2024l;
            this.f5458c = c2025o;
        }
    }

    public C2018f() {
        m6018d();
    }

    private void m6010a(C2000a c2000a) {
        List arrayList = new ArrayList();
        C2091j c2091j = new C2091j();
        C2001b d = c2000a.m5933d(C1999a.az);
        if (d != null) {
            C2008b.m5956a(d, this.f5476q, c2091j);
        }
        int i = 0;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = -9223372036854775807L;
        while (i < c2000a.aP.size()) {
            long j3;
            long j4;
            C2000a c2000a2 = (C2000a) c2000a.aP.get(i);
            if (c2000a2.aM != C1999a.f5333C) {
                j3 = j;
                j4 = j2;
            } else {
                C2021i a = C2008b.m5954a(c2000a2, c2000a.m5933d(C1999a.f5332B), -9223372036854775807L, null, this.f5476q);
                if (a == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    C2024l a2 = C2008b.m5955a(a, c2000a2.m5934e(C1999a.f5334D).m5934e(C1999a.f5335E).m5934e(C1999a.f5336F), c2091j);
                    if (a2.f5511a == 0) {
                        j3 = j;
                        j4 = j2;
                    } else {
                        C2017a c2017a = new C2017a(a, a2, this.f5473n.mo3019a(i));
                        Format a3 = a.f5483f.m5489a(a2.f5514d + 30);
                        if (a.f5479b == 1 && c2091j.m6346a()) {
                            a3 = a3.m5490a(c2091j.f5873a, c2091j.f5874b);
                        }
                        c2017a.f5458c.mo2978a(a3);
                        j2 = Math.max(j2, a.f5482e);
                        arrayList.add(c2017a);
                        j3 = a2.f5512b[0];
                        if (j3 < j) {
                            j4 = j2;
                        } else {
                            j3 = j;
                            j4 = j2;
                        }
                    }
                }
            }
            i++;
            j = j3;
            j2 = j4;
        }
        this.f5475p = j2;
        this.f5474o = (C2017a[]) arrayList.toArray(new C2017a[arrayList.size()]);
        this.f5473n.mo3020a();
        this.f5473n.mo3022a((C1967m) this);
    }

    private static boolean m6011a(int i) {
        return i == C1999a.f5347Q || i == C1999a.f5332B || i == C1999a.f5348R || i == C1999a.f5349S || i == C1999a.al || i == C1999a.am || i == C1999a.an || i == C1999a.f5346P || i == C1999a.ao || i == C1999a.ap || i == C1999a.aq || i == C1999a.ar || i == C1999a.as || i == C1999a.f5344N || i == C1999a.f5357a || i == C1999a.az;
    }

    private static boolean m6012a(C2263k c2263k) {
        c2263k.m7073c(8);
        if (c2263k.m7086n() == f5461b) {
            return true;
        }
        c2263k.m7075d(4);
        while (c2263k.m7070b() > 0) {
            if (c2263k.m7086n() == f5461b) {
                return true;
            }
        }
        return false;
    }

    private static boolean m6013b(int i) {
        return i == C1999a.f5331A || i == C1999a.f5333C || i == C1999a.f5334D || i == C1999a.f5335E || i == C1999a.f5336F || i == C1999a.f5345O;
    }

    private boolean m6014b(C1985g c1985g) {
        if (this.f5469j == 0) {
            if (!c1985g.mo2962a(this.f5464e.f6454a, 0, 8, true)) {
                return false;
            }
            this.f5469j = 8;
            this.f5464e.m7073c(0);
            this.f5468i = this.f5464e.m7084l();
            this.f5467h = this.f5464e.m7086n();
        }
        if (this.f5468i == 1) {
            c1985g.mo2965b(this.f5464e.f6454a, 8, 8);
            this.f5469j += 8;
            this.f5468i = this.f5464e.m7094v();
        }
        if (C2018f.m6013b(this.f5467h)) {
            long c = (c1985g.mo2967c() + this.f5468i) - ((long) this.f5469j);
            this.f5465f.add(new C2000a(this.f5467h, c));
            if (this.f5468i == ((long) this.f5469j)) {
                m6017c(c);
            } else {
                m6018d();
            }
        } else if (C2018f.m6011a(this.f5467h)) {
            C2252a.m7024b(this.f5469j == 8);
            C2252a.m7024b(this.f5468i <= 2147483647L);
            this.f5470k = new C2263k((int) this.f5468i);
            System.arraycopy(this.f5464e.f6454a, 0, this.f5470k.f6454a, 0, 8);
            this.f5466g = 2;
        } else {
            this.f5470k = null;
            this.f5466g = 2;
        }
        return true;
    }

    private boolean m6015b(C1985g c1985g, C2093l c2093l) {
        boolean z;
        long j = this.f5468i - ((long) this.f5469j);
        long c = c1985g.mo2967c() + j;
        if (this.f5470k != null) {
            c1985g.mo2965b(this.f5470k.f6454a, this.f5469j, (int) j);
            if (this.f5467h == C1999a.f5357a) {
                this.f5476q = C2018f.m6012a(this.f5470k);
                z = false;
            } else if (this.f5465f.isEmpty()) {
                z = false;
            } else {
                ((C2000a) this.f5465f.peek()).m5932a(new C2001b(this.f5467h, this.f5470k));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            c1985g.mo2964b((int) j);
            z = false;
        } else {
            c2093l.f5889a = j + c1985g.mo2967c();
            z = true;
        }
        m6017c(c);
        return z && this.f5466g != 3;
    }

    private int m6016c(C1985g c1985g, C2093l c2093l) {
        int e = m6019e();
        if (e == -1) {
            return -1;
        }
        C2017a c2017a = this.f5474o[e];
        C2025o c2025o = c2017a.f5458c;
        int i = c2017a.f5459d;
        long j = c2017a.f5457b.f5512b[i];
        e = c2017a.f5457b.f5513c[i];
        if (c2017a.f5456a.f5484g == 1) {
            j += 8;
            e -= 8;
        }
        long c = (j - c1985g.mo2967c()) + ((long) this.f5471l);
        if (c < 0 || c >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            c2093l.f5889a = j;
            return 1;
        }
        int a;
        c1985g.mo2964b((int) c);
        int i2;
        if (c2017a.f5456a.f5488k != 0) {
            byte[] bArr = this.f5463d.f6454a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            i2 = c2017a.f5456a.f5488k;
            int i3 = 4 - c2017a.f5456a.f5488k;
            while (this.f5471l < e) {
                if (this.f5472m == 0) {
                    c1985g.mo2965b(this.f5463d.f6454a, i3, i2);
                    this.f5463d.m7073c(0);
                    this.f5472m = this.f5463d.m7092t();
                    this.f5462c.m7073c(0);
                    c2025o.mo2979a(this.f5462c, 4);
                    this.f5471l += 4;
                    e += i3;
                } else {
                    a = c2025o.mo2976a(c1985g, this.f5472m, false);
                    this.f5471l += a;
                    this.f5472m -= a;
                }
            }
            a = e;
        } else {
            while (this.f5471l < e) {
                i2 = c2025o.mo2976a(c1985g, e - this.f5471l, false);
                this.f5471l += i2;
                this.f5472m -= i2;
            }
            a = e;
        }
        c2025o.mo2977a(c2017a.f5457b.f5515e[i], c2017a.f5457b.f5516f[i], a, 0, null);
        c2017a.f5459d++;
        this.f5471l = 0;
        this.f5472m = 0;
        return 0;
    }

    private void m6017c(long j) {
        while (!this.f5465f.isEmpty() && ((C2000a) this.f5465f.peek()).aN == j) {
            C2000a c2000a = (C2000a) this.f5465f.pop();
            if (c2000a.aM == C1999a.f5331A) {
                m6010a(c2000a);
                this.f5465f.clear();
                this.f5466g = 3;
            } else if (!this.f5465f.isEmpty()) {
                ((C2000a) this.f5465f.peek()).m5931a(c2000a);
            }
        }
        if (this.f5466g != 3) {
            m6018d();
        }
    }

    private void m6018d() {
        this.f5466g = 1;
        this.f5469j = 0;
    }

    private int m6019e() {
        int i = -1;
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i2 = 0; i2 < this.f5474o.length; i2++) {
            C2017a c2017a = this.f5474o[i2];
            int i3 = c2017a.f5459d;
            if (i3 != c2017a.f5457b.f5511a) {
                long j2 = c2017a.f5457b.f5512b[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        while (true) {
            switch (this.f5466g) {
                case 0:
                    if (c1985g.mo2967c() != 0) {
                        this.f5466g = 3;
                        break;
                    }
                    m6018d();
                    break;
                case 1:
                    if (m6014b(c1985g)) {
                        break;
                    }
                    return -1;
                case 2:
                    if (!m6015b(c1985g, c2093l)) {
                        break;
                    }
                    return 1;
                default:
                    return m6016c(c1985g, c2093l);
            }
        }
    }

    public void mo2941a(long j) {
        this.f5465f.clear();
        this.f5469j = 0;
        this.f5471l = 0;
        this.f5472m = 0;
        this.f5466g = 0;
    }

    public void mo2942a(C2090h c2090h) {
        this.f5473n = c2090h;
    }

    public boolean mo2943a() {
        return true;
    }

    public boolean mo2944a(C1985g c1985g) {
        return C2020h.m6033b(c1985g);
    }

    public long mo2945b() {
        return this.f5475p;
    }

    public long mo2946b(long j) {
        long j2 = Format.OFFSET_SAMPLE_RELATIVE;
        C2017a[] c2017aArr = this.f5474o;
        int length = c2017aArr.length;
        int i = 0;
        while (i < length) {
            C2017a c2017a = c2017aArr[i];
            C2024l c2024l = c2017a.f5457b;
            int a = c2024l.m6040a(j);
            if (a == -1) {
                a = c2024l.m6041b(j);
            }
            c2017a.f5459d = a;
            long j3 = c2024l.f5512b[a];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    public void mo2947c() {
    }
}
