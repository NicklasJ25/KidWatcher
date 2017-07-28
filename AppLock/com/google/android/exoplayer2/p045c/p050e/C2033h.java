package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;

abstract class C2033h {
    private C2037d f5554a;
    private C2025o f5555b;
    private C2090h f5556c;
    private C2029f f5557d;
    private long f5558e;
    private long f5559f;
    private long f5560g;
    private int f5561h;
    private int f5562i;
    private C2041a f5563j;
    private long f5564k;
    private boolean f5565l;
    private boolean f5566m;

    static class C2041a {
        Format f5591a;
        C2029f f5592b;

        C2041a() {
        }
    }

    private static final class C2042b implements C2029f {
        private C2042b() {
        }

        public long mo2980a(C1985g c1985g) {
            return -1;
        }

        public long c_() {
            return 0;
        }

        public C1967m mo2982d() {
            return new C2094a(-9223372036854775807L);
        }
    }

    C2033h() {
    }

    private int m6096a(C1985g c1985g) {
        boolean z = true;
        while (z) {
            if (this.f5554a.m6123a(c1985g)) {
                this.f5564k = c1985g.mo2967c() - this.f5559f;
                z = mo2984a(this.f5554a.m6124b(), this.f5559f, this.f5563j);
                if (z) {
                    this.f5559f = c1985g.mo2967c();
                }
            } else {
                this.f5561h = 3;
                return -1;
            }
        }
        this.f5562i = this.f5563j.f5591a.f4959q;
        if (!this.f5566m) {
            this.f5555b.mo2978a(this.f5563j.f5591a);
            this.f5566m = true;
        }
        if (this.f5563j.f5592b != null) {
            this.f5557d = this.f5563j.f5592b;
        } else if (c1985g.mo2970d() == -1) {
            this.f5557d = new C2042b();
        } else {
            this.f5557d = new C2030a(this.f5559f, c1985g.mo2970d(), this);
        }
        this.f5563j = null;
        this.f5561h = 2;
        return 0;
    }

    private int m6097b(C1985g c1985g, C2093l c2093l) {
        long a = this.f5557d.mo2980a(c1985g);
        if (a >= 0) {
            c2093l.f5889a = a;
            return 1;
        }
        if (a < -1) {
            mo2986d((-a) - 2);
        }
        if (!this.f5565l) {
            this.f5556c.mo3022a(this.f5557d.mo2982d());
            this.f5565l = true;
        }
        if (this.f5564k > 0 || this.f5554a.m6123a(c1985g)) {
            this.f5564k = 0;
            C2263k b = this.f5554a.m6124b();
            long b2 = mo2985b(b);
            if (b2 >= 0 && this.f5560g + b2 >= this.f5558e) {
                long b3 = m6103b(this.f5560g);
                this.f5555b.mo2979a(b, b.m7072c());
                this.f5555b.mo2977a(b3, 1, b.m7072c(), 0, null);
                this.f5558e = -1;
            }
            this.f5560g += b2;
            return 0;
        }
        this.f5561h = 3;
        return -1;
    }

    final int m6098a(C1985g c1985g, C2093l c2093l) {
        switch (this.f5561h) {
            case 0:
                return m6096a(c1985g);
            case 1:
                c1985g.mo2964b((int) this.f5559f);
                this.f5561h = 2;
                return 0;
            case 2:
                return m6097b(c1985g, c2093l);
            default:
                throw new IllegalStateException();
        }
    }

    final void m6099a(long j) {
        this.f5554a.m6122a();
        if (j == 0) {
            mo2983a(!this.f5565l);
        } else if (this.f5561h != 0) {
            this.f5558e = this.f5557d.c_();
            this.f5561h = 2;
        }
    }

    void m6100a(C2090h c2090h, C2025o c2025o) {
        this.f5556c = c2090h;
        this.f5555b = c2025o;
        this.f5554a = new C2037d();
        mo2983a(true);
    }

    protected void mo2983a(boolean z) {
        if (z) {
            this.f5563j = new C2041a();
            this.f5559f = 0;
            this.f5561h = 0;
        } else {
            this.f5561h = 1;
        }
        this.f5558e = -1;
        this.f5560g = 0;
    }

    protected abstract boolean mo2984a(C2263k c2263k, long j, C2041a c2041a);

    protected long m6103b(long j) {
        return (1000000 * j) / ((long) this.f5562i);
    }

    protected abstract long mo2985b(C2263k c2263k);

    protected long m6105c(long j) {
        return (((long) this.f5562i) * j) / 1000000;
    }

    protected void mo2986d(long j) {
        this.f5560g = j;
    }
}
