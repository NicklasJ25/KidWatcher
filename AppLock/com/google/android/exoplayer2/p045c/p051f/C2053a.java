package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.p041a.C1926a;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

public final class C2053a implements C1966f {
    public static final C1964i f5629a = new C20521();
    private static final int f5630b = C2273r.m7142e("ID3");
    private final long f5631c;
    private final C2263k f5632d;
    private C2055b f5633e;
    private boolean f5634f;

    static class C20521 implements C1964i {
        C20521() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2053a()};
        }
    }

    public C2053a() {
        this(0);
    }

    public C2053a(long j) {
        this.f5631c = j;
        this.f5632d = new C2263k(2786);
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        int a = c1985g.mo2960a(this.f5632d.f6454a, 0, 2786);
        if (a == -1) {
            return -1;
        }
        this.f5632d.m7073c(0);
        this.f5632d.m7071b(a);
        if (!this.f5634f) {
            this.f5633e.mo2988a(this.f5631c, true);
            this.f5634f = true;
        }
        this.f5633e.mo2990a(this.f5632d);
        return 0;
    }

    public void mo2941a(long j) {
        this.f5634f = false;
        this.f5633e.mo2987a();
    }

    public void mo2942a(C2090h c2090h) {
        this.f5633e = new C2055b();
        this.f5633e.mo2989a(c2090h, new C2063c(0, 1));
        c2090h.mo3020a();
        c2090h.mo3022a(new C2094a(-9223372036854775807L));
    }

    public boolean mo2944a(C1985g c1985g) {
        int s;
        C2263k c2263k = new C2263k(10);
        int i = 0;
        while (true) {
            c1985g.mo2969c(c2263k.f6454a, 0, 10);
            c2263k.m7073c(0);
            if (c2263k.m7083k() != f5630b) {
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
        int i2 = i;
        while (true) {
            c1985g.mo2969c(c2263k.f6454a, 0, 5);
            c2263k.m7073c(0);
            if (c2263k.m7080h() != 2935) {
                c1985g.mo2961a();
                i2++;
                if (i2 - i >= 8192) {
                    return false;
                }
                c1985g.mo2968c(i2);
                s = 0;
            } else {
                s++;
                if (s >= 4) {
                    return true;
                }
                int a = C1926a.m5497a(c2263k.f6454a);
                if (a == -1) {
                    return false;
                }
                c1985g.mo2968c(a - 5);
            }
        }
    }

    public void mo2947c() {
    }
}
