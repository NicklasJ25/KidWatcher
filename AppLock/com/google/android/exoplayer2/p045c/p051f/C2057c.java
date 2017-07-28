package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

public final class C2057c implements C1966f {
    public static final C1964i f5647a = new C20561();
    private static final int f5648b = C2273r.m7142e("ID3");
    private final long f5649c;
    private final C2263k f5650d;
    private C2058d f5651e;
    private boolean f5652f;

    static class C20561 implements C1964i {
        C20561() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2057c()};
        }
    }

    public C2057c() {
        this(0);
    }

    public C2057c(long j) {
        this.f5649c = j;
        this.f5650d = new C2263k(200);
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        int a = c1985g.mo2960a(this.f5650d.f6454a, 0, 200);
        if (a == -1) {
            return -1;
        }
        this.f5650d.m7073c(0);
        this.f5650d.m7071b(a);
        if (!this.f5652f) {
            this.f5651e.mo2988a(this.f5649c, true);
            this.f5652f = true;
        }
        this.f5651e.mo2990a(this.f5650d);
        return 0;
    }

    public void mo2941a(long j) {
        this.f5652f = false;
        this.f5651e.mo2987a();
    }

    public void mo2942a(C2090h c2090h) {
        this.f5651e = new C2058d(true);
        this.f5651e.mo2989a(c2090h, new C2063c(0, 1));
        c2090h.mo3020a();
        c2090h.mo3022a(new C2094a(-9223372036854775807L));
    }

    public boolean mo2944a(C1985g c1985g) {
        int s;
        C2263k c2263k = new C2263k(10);
        C2262j c2262j = new C2262j(c2263k.f6454a);
        int i = 0;
        while (true) {
            c1985g.mo2969c(c2263k.f6454a, 0, 10);
            c2263k.m7073c(0);
            if (c2263k.m7083k() != f5648b) {
                break;
            }
            c2263k.m7075d(3);
            s = c2263k.m7091s();
            i += s + 10;
            c1985g.mo2968c(s);
        }
        c1985g.mo2961a();
        c1985g.mo2968c(i);
        s = 0;
        int i2 = 0;
        int i3 = i;
        while (true) {
            c1985g.mo2969c(c2263k.f6454a, 0, 2);
            c2263k.m7073c(0);
            if ((c2263k.m7080h() & 65526) != 65520) {
                c1985g.mo2961a();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                c1985g.mo2968c(i3);
                s = 0;
                i2 = 0;
            } else {
                s++;
                if (s >= 4 && i2 > 188) {
                    return true;
                }
                c1985g.mo2969c(c2263k.f6454a, 0, 4);
                c2262j.m7060a(14);
                int c = c2262j.m7063c(13);
                if (c <= 6) {
                    return false;
                }
                c1985g.mo2968c(c - 6);
                i2 += c;
            }
        }
    }

    public void mo2947c() {
    }
}
