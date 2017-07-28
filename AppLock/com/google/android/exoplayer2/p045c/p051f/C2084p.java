package com.google.android.exoplayer2.p045c.p051f;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.C2095n;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2059b;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2062a;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;
import java.util.Arrays;

public final class C2084p implements C1966f {
    public static final C1964i f5841a = new C20791();
    private static final long f5842b = ((long) C2273r.m7142e("AC-3"));
    private static final long f5843c = ((long) C2273r.m7142e("EAC3"));
    private static final long f5844d = ((long) C2273r.m7142e("HEVC"));
    private final boolean f5845e;
    private final C2095n f5846f;
    private final C2263k f5847g;
    private final C2262j f5848h;
    private final SparseIntArray f5849i;
    private final C2059b f5850j;
    private final SparseArray<C2080d> f5851k;
    private final SparseBooleanArray f5852l;
    private C2090h f5853m;
    private boolean f5854n;
    private C2054g f5855o;

    static class C20791 implements C1964i {
        C20791() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2084p()};
        }
    }

    private static abstract class C2080d {
        private C2080d() {
        }

        public abstract void mo2993a();

        public abstract void mo2994a(C2263k c2263k, boolean z, C2090h c2090h);
    }

    private class C2081a extends C2080d {
        final /* synthetic */ C2084p f5816a;
        private final C2263k f5817b = new C2263k();
        private final C2262j f5818c = new C2262j(new byte[4]);
        private int f5819d;
        private int f5820e;
        private int f5821f;

        public C2081a(C2084p c2084p) {
            this.f5816a = c2084p;
            super();
        }

        public void mo2993a() {
        }

        public void mo2994a(C2263k c2263k, boolean z, C2090h c2090h) {
            int i = 0;
            if (z) {
                c2263k.m7075d(c2263k.m7079g());
                c2263k.m7067a(this.f5818c, 3);
                this.f5818c.m7061b(12);
                this.f5819d = this.f5818c.m7063c(12);
                this.f5820e = 0;
                this.f5821f = C2273r.m7126a(this.f5818c.f6450a, 0, 3, -1);
                this.f5817b.m7066a(this.f5819d);
            }
            int min = Math.min(c2263k.m7070b(), this.f5819d - this.f5820e);
            c2263k.m7069a(this.f5817b.f6454a, this.f5820e, min);
            this.f5820e = min + this.f5820e;
            if (this.f5820e >= this.f5819d && C2273r.m7126a(this.f5817b.f6454a, 0, this.f5819d, this.f5821f) == 0) {
                this.f5817b.m7075d(5);
                min = (this.f5819d - 9) / 4;
                while (i < min) {
                    this.f5817b.m7067a(this.f5818c, 4);
                    int c = this.f5818c.m7063c(16);
                    this.f5818c.m7061b(3);
                    if (c == 0) {
                        this.f5818c.m7061b(13);
                    } else {
                        c = this.f5818c.m7063c(13);
                        this.f5816a.f5851k.put(c, new C2083c(this.f5816a, c));
                    }
                    i++;
                }
            }
        }
    }

    private static final class C2082b extends C2080d {
        private final C2054g f5822a;
        private final C2095n f5823b;
        private final C2262j f5824c = new C2262j(new byte[10]);
        private int f5825d = 0;
        private int f5826e;
        private boolean f5827f;
        private boolean f5828g;
        private boolean f5829h;
        private int f5830i;
        private int f5831j;
        private boolean f5832k;
        private long f5833l;

        public C2082b(C2054g c2054g, C2095n c2095n) {
            super();
            this.f5822a = c2054g;
            this.f5823b = c2095n;
        }

        private void m6294a(int i) {
            this.f5825d = i;
            this.f5826e = 0;
        }

        private boolean m6295a(C2263k c2263k, byte[] bArr, int i) {
            int min = Math.min(c2263k.m7070b(), i - this.f5826e);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                c2263k.m7075d(min);
            } else {
                c2263k.m7069a(bArr, this.f5826e, min);
            }
            this.f5826e = min + this.f5826e;
            return this.f5826e == i;
        }

        private boolean m6296b() {
            this.f5824c.m7060a(0);
            int c = this.f5824c.m7063c(24);
            if (c != 1) {
                Log.w("TsExtractor", "Unexpected start code prefix: " + c);
                this.f5831j = -1;
                return false;
            }
            this.f5824c.m7061b(8);
            int c2 = this.f5824c.m7063c(16);
            this.f5824c.m7061b(5);
            this.f5832k = this.f5824c.m7062b();
            this.f5824c.m7061b(2);
            this.f5827f = this.f5824c.m7062b();
            this.f5828g = this.f5824c.m7062b();
            this.f5824c.m7061b(6);
            this.f5830i = this.f5824c.m7063c(8);
            if (c2 == 0) {
                this.f5831j = -1;
            } else {
                this.f5831j = ((c2 + 6) - 9) - this.f5830i;
            }
            return true;
        }

        private void m6297c() {
            this.f5824c.m7060a(0);
            this.f5833l = -9223372036854775807L;
            if (this.f5827f) {
                this.f5824c.m7061b(4);
                long c = ((long) this.f5824c.m7063c(3)) << 30;
                this.f5824c.m7061b(1);
                c |= (long) (this.f5824c.m7063c(15) << 15);
                this.f5824c.m7061b(1);
                c |= (long) this.f5824c.m7063c(15);
                this.f5824c.m7061b(1);
                if (!this.f5829h && this.f5828g) {
                    this.f5824c.m7061b(4);
                    long c2 = ((long) this.f5824c.m7063c(3)) << 30;
                    this.f5824c.m7061b(1);
                    c2 |= (long) (this.f5824c.m7063c(15) << 15);
                    this.f5824c.m7061b(1);
                    c2 |= (long) this.f5824c.m7063c(15);
                    this.f5824c.m7061b(1);
                    this.f5823b.m6357a(c2);
                    this.f5829h = true;
                }
                this.f5833l = this.f5823b.m6357a(c);
            }
        }

        public void mo2993a() {
            this.f5825d = 0;
            this.f5826e = 0;
            this.f5829h = false;
            this.f5822a.mo2987a();
        }

        public void mo2994a(C2263k c2263k, boolean z, C2090h c2090h) {
            if (z) {
                switch (this.f5825d) {
                    case 2:
                        Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                        break;
                    case 3:
                        if (this.f5831j != -1) {
                            Log.w("TsExtractor", "Unexpected start indicator: expected " + this.f5831j + " more bytes");
                        }
                        this.f5822a.mo2991b();
                        break;
                }
                m6294a(1);
            }
            while (c2263k.m7070b() > 0) {
                switch (this.f5825d) {
                    case 0:
                        c2263k.m7075d(c2263k.m7070b());
                        break;
                    case 1:
                        if (!m6295a(c2263k, this.f5824c.f6450a, 9)) {
                            break;
                        }
                        m6294a(m6296b() ? 2 : 0);
                        break;
                    case 2:
                        if (m6295a(c2263k, this.f5824c.f6450a, Math.min(10, this.f5830i)) && m6295a(c2263k, null, this.f5830i)) {
                            m6297c();
                            this.f5822a.mo2988a(this.f5833l, this.f5832k);
                            m6294a(3);
                            break;
                        }
                    case 3:
                        int b = c2263k.m7070b();
                        int i = this.f5831j == -1 ? 0 : b - this.f5831j;
                        if (i > 0) {
                            b -= i;
                            c2263k.m7071b(c2263k.m7074d() + b);
                        }
                        this.f5822a.mo2990a(c2263k);
                        if (this.f5831j == -1) {
                            break;
                        }
                        this.f5831j -= b;
                        if (this.f5831j != 0) {
                            break;
                        }
                        this.f5822a.mo2991b();
                        m6294a(1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private class C2083c extends C2080d {
        final /* synthetic */ C2084p f5834a;
        private final C2262j f5835b = new C2262j(new byte[5]);
        private final C2263k f5836c = new C2263k();
        private final int f5837d;
        private int f5838e;
        private int f5839f;
        private int f5840g;

        public C2083c(C2084p c2084p, int i) {
            this.f5834a = c2084p;
            super();
            this.f5837d = i;
        }

        private C2062a m6300a(C2263k c2263k, int i) {
            int d = c2263k.m7074d();
            int i2 = d + i;
            int i3 = -1;
            String str = null;
            while (c2263k.m7074d() < i2) {
                int g = c2263k.m7079g();
                int g2 = c2263k.m7079g() + c2263k.m7074d();
                if (g == 5) {
                    long l = c2263k.m7084l();
                    if (l == C2084p.f5842b) {
                        i3 = 129;
                    } else if (l == C2084p.f5843c) {
                        i3 = 135;
                    } else if (l == C2084p.f5844d) {
                        i3 = 36;
                    }
                } else if (g == 106) {
                    i3 = 129;
                } else if (g == 122) {
                    i3 = 135;
                } else if (g == 123) {
                    i3 = 138;
                } else if (g == 10) {
                    str = new String(c2263k.f6454a, c2263k.m7074d(), 3).trim();
                }
                c2263k.m7075d(g2 - c2263k.m7074d());
            }
            c2263k.m7073c(i2);
            return new C2062a(i3, str, Arrays.copyOfRange(this.f5836c.f6454a, d, i2));
        }

        public void mo2993a() {
        }

        public void mo2994a(C2263k c2263k, boolean z, C2090h c2090h) {
            if (z) {
                c2263k.m7075d(c2263k.m7079g());
                c2263k.m7067a(this.f5835b, 3);
                this.f5835b.m7061b(12);
                this.f5838e = this.f5835b.m7063c(12);
                this.f5839f = 0;
                this.f5840g = C2273r.m7126a(this.f5835b.f6450a, 0, 3, -1);
                this.f5836c.m7066a(this.f5838e);
            }
            int min = Math.min(c2263k.m7070b(), this.f5838e - this.f5839f);
            c2263k.m7069a(this.f5836c.f6454a, this.f5839f, min);
            this.f5839f = min + this.f5839f;
            if (this.f5839f >= this.f5838e && C2273r.m7126a(this.f5836c.f6454a, 0, this.f5838e, this.f5840g) == 0) {
                this.f5836c.m7075d(7);
                this.f5836c.m7067a(this.f5835b, 2);
                this.f5835b.m7061b(4);
                min = this.f5835b.m7063c(12);
                this.f5836c.m7075d(min);
                if (this.f5834a.f5845e && this.f5834a.f5855o == null) {
                    this.f5834a.f5855o = this.f5834a.f5850j.mo2992a(21, new C2062a(21, null, new byte[0]));
                    this.f5834a.f5855o.mo2989a(c2090h, new C2063c(21, 8192));
                }
                int i = ((this.f5838e - 9) - min) - 4;
                while (i > 0) {
                    this.f5836c.m7067a(this.f5835b, 5);
                    min = this.f5835b.m7063c(8);
                    this.f5835b.m7061b(3);
                    int c = this.f5835b.m7063c(13);
                    this.f5835b.m7061b(4);
                    int c2 = this.f5835b.m7063c(12);
                    C2062a a = m6300a(this.f5836c, c2);
                    if (min == 6) {
                        min = a.f5681a;
                    }
                    c2 = i - (c2 + 5);
                    i = this.f5834a.f5845e ? min : c;
                    if (this.f5834a.f5852l.get(i)) {
                        i = c2;
                    } else {
                        C2054g c3;
                        this.f5834a.f5852l.put(i, true);
                        if (this.f5834a.f5845e && min == 21) {
                            c3 = this.f5834a.f5855o;
                        } else {
                            c3 = this.f5834a.f5850j.mo2992a(min, a);
                            c3.mo2989a(c2090h, new C2063c(i, 8192));
                        }
                        if (c3 != null) {
                            this.f5834a.f5851k.put(c, new C2082b(c3, this.f5834a.f5846f));
                        }
                        i = c2;
                    }
                }
                if (!this.f5834a.f5845e) {
                    this.f5834a.f5851k.remove(0);
                    this.f5834a.f5851k.remove(this.f5837d);
                    c2090h.mo3020a();
                } else if (!this.f5834a.f5854n) {
                    c2090h.mo3020a();
                }
                this.f5834a.f5854n = true;
            }
        }
    }

    public C2084p() {
        this(new C2095n(0));
    }

    public C2084p(C2095n c2095n) {
        this(c2095n, new C2060e(), false);
    }

    public C2084p(C2095n c2095n, C2059b c2059b, boolean z) {
        this.f5846f = c2095n;
        this.f5850j = (C2059b) C2252a.m7020a((Object) c2059b);
        this.f5845e = z;
        this.f5847g = new C2263k(940);
        this.f5848h = new C2262j(new byte[3]);
        this.f5852l = new SparseBooleanArray();
        this.f5851k = new SparseArray();
        this.f5849i = new SparseIntArray();
        m6313e();
    }

    private void m6313e() {
        this.f5852l.clear();
        this.f5851k.clear();
        this.f5851k.put(0, new C2081a(this));
        this.f5855o = null;
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        int b;
        int a;
        byte[] bArr = this.f5847g.f6454a;
        if (940 - this.f5847g.m7074d() < 188) {
            b = this.f5847g.m7070b();
            if (b > 0) {
                System.arraycopy(bArr, this.f5847g.m7074d(), bArr, 0, b);
            }
            this.f5847g.m7068a(bArr, b);
        }
        while (this.f5847g.m7070b() < 188) {
            b = this.f5847g.m7072c();
            a = c1985g.mo2960a(bArr, b, 940 - b);
            if (a == -1) {
                return -1;
            }
            this.f5847g.m7071b(b + a);
        }
        b = this.f5847g.m7072c();
        int d = this.f5847g.m7074d();
        while (d < b && bArr[d] != (byte) 71) {
            d++;
        }
        this.f5847g.m7073c(d);
        a = d + 188;
        if (a > b) {
            return 0;
        }
        this.f5847g.m7075d(1);
        this.f5847g.m7067a(this.f5848h, 3);
        if (this.f5848h.m7062b()) {
            this.f5847g.m7073c(a);
            return 0;
        }
        boolean b2 = this.f5848h.m7062b();
        this.f5848h.m7061b(1);
        d = this.f5848h.m7063c(13);
        this.f5848h.m7061b(2);
        boolean b3 = this.f5848h.m7062b();
        boolean b4 = this.f5848h.m7062b();
        int c = this.f5848h.m7063c(4);
        int i = this.f5849i.get(d, c - 1);
        this.f5849i.put(d, c);
        if (i == c) {
            this.f5847g.m7073c(a);
            return 0;
        }
        c = c != (i + 1) % 16 ? 1 : 0;
        if (b3) {
            this.f5847g.m7075d(this.f5847g.m7079g());
        }
        if (b4) {
            C2080d c2080d = (C2080d) this.f5851k.get(d);
            if (c2080d != null) {
                if (c != 0) {
                    c2080d.mo2993a();
                }
                this.f5847g.m7071b(a);
                c2080d.mo2994a(this.f5847g, b2, this.f5853m);
                C2252a.m7024b(this.f5847g.m7074d() <= a);
                this.f5847g.m7071b(b);
            }
        }
        this.f5847g.m7073c(a);
        return 0;
    }

    public void mo2941a(long j) {
        this.f5846f.m6358a();
        this.f5847g.m7065a();
        this.f5849i.clear();
        m6313e();
    }

    public void mo2942a(C2090h c2090h) {
        this.f5853m = c2090h;
        c2090h.mo3022a(new C2094a(-9223372036854775807L));
    }

    public boolean mo2944a(C1985g c1985g) {
        byte[] bArr = this.f5847g.f6454a;
        c1985g.mo2969c(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] != (byte) 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            c1985g.mo2964b(i);
            return true;
        }
        return false;
    }

    public void mo2947c() {
    }
}
