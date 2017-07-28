package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;

public class C2036c implements C1966f {
    public static final C1964i f5569a = new C20351();
    private C2033h f5570b;

    static class C20351 implements C1964i {
        C20351() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2036c()};
        }
    }

    private static C2263k m6115a(C2263k c2263k) {
        c2263k.m7073c(0);
        return c2263k;
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        return this.f5570b.m6098a(c1985g, c2093l);
    }

    public void mo2941a(long j) {
        this.f5570b.m6099a(j);
    }

    public void mo2942a(C2090h c2090h) {
        C2025o a = c2090h.mo3019a(0);
        c2090h.mo3020a();
        this.f5570b.m6100a(c2090h, a);
    }

    public boolean mo2944a(C1985g c1985g) {
        try {
            C2038e c2038e = new C2038e();
            if (!c2038e.m6126a(c1985g, true) || (c2038e.f5578b & 2) != 2) {
                return false;
            }
            int min = Math.min(c2038e.f5585i, 8);
            C2263k c2263k = new C2263k(min);
            c1985g.mo2969c(c2263k.f6454a, 0, min);
            if (C2034b.m6108a(C2036c.m6115a(c2263k))) {
                this.f5570b = new C2034b();
            } else if (C2045j.m6142a(C2036c.m6115a(c2263k))) {
                this.f5570b = new C2045j();
            } else if (!C2039g.m6129a(C2036c.m6115a(c2263k))) {
                return false;
            } else {
                this.f5570b = new C2039g();
            }
            return true;
        } catch (C1970k e) {
            return false;
        }
    }

    public void mo2947c() {
    }
}
