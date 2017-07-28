package com.google.android.exoplayer2.p045c.p046a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;

public final class C1968b implements C1966f, C1967m {
    public static final C1964i f5152a = new C19651();
    private static final int f5153e = C2273r.m7142e("FLV");
    public int f5154b;
    public int f5155c;
    public long f5156d;
    private final C2263k f5157f = new C2263k(4);
    private final C2263k f5158g = new C2263k(9);
    private final C2263k f5159h = new C2263k(11);
    private final C2263k f5160i = new C2263k();
    private C2090h f5161j;
    private int f5162k = 1;
    private int f5163l;
    private C1963a f5164m;
    private C1972e f5165n;
    private C1969c f5166o;

    static class C19651 implements C1964i {
        C19651() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C1968b()};
        }
    }

    private boolean m5749b(C1985g c1985g) {
        boolean z = false;
        if (!c1985g.mo2962a(this.f5158g.f6454a, 0, 9, true)) {
            return false;
        }
        this.f5158g.m7073c(0);
        this.f5158g.m7075d(4);
        int g = this.f5158g.m7079g();
        boolean z2 = (g & 4) != 0;
        if ((g & 1) != 0) {
            z = true;
        }
        if (z2 && this.f5164m == null) {
            this.f5164m = new C1963a(this.f5161j.mo3019a(8));
        }
        if (z && this.f5165n == null) {
            this.f5165n = new C1972e(this.f5161j.mo3019a(9));
        }
        if (this.f5166o == null) {
            this.f5166o = new C1969c(null);
        }
        this.f5161j.mo3020a();
        this.f5161j.mo3022a((C1967m) this);
        this.f5163l = (this.f5158g.m7086n() - 9) + 4;
        this.f5162k = 2;
        return true;
    }

    private void m5750c(C1985g c1985g) {
        c1985g.mo2964b(this.f5163l);
        this.f5163l = 0;
        this.f5162k = 3;
    }

    private boolean m5751d(C1985g c1985g) {
        if (!c1985g.mo2962a(this.f5159h.f6454a, 0, 11, true)) {
            return false;
        }
        this.f5159h.m7073c(0);
        this.f5154b = this.f5159h.m7079g();
        this.f5155c = this.f5159h.m7083k();
        this.f5156d = (long) this.f5159h.m7083k();
        this.f5156d = (((long) (this.f5159h.m7079g() << 24)) | this.f5156d) * 1000;
        this.f5159h.m7075d(3);
        this.f5162k = 4;
        return true;
    }

    private boolean m5752e(C1985g c1985g) {
        boolean z = true;
        if (this.f5154b == 8 && this.f5164m != null) {
            this.f5164m.m5736b(m5753f(c1985g), this.f5156d);
        } else if (this.f5154b == 9 && this.f5165n != null) {
            this.f5165n.m5736b(m5753f(c1985g), this.f5156d);
        } else if (this.f5154b != 18 || this.f5166o == null) {
            c1985g.mo2964b(this.f5155c);
            z = false;
        } else {
            this.f5166o.m5736b(m5753f(c1985g), this.f5156d);
        }
        this.f5163l = 4;
        this.f5162k = 2;
        return z;
    }

    private C2263k m5753f(C1985g c1985g) {
        if (this.f5155c > this.f5160i.m7076e()) {
            this.f5160i.m7068a(new byte[Math.max(this.f5160i.m7076e() * 2, this.f5155c)], 0);
        } else {
            this.f5160i.m7073c(0);
        }
        this.f5160i.m7071b(this.f5155c);
        c1985g.mo2965b(this.f5160i.f6454a, 0, this.f5155c);
        return this.f5160i;
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        while (true) {
            switch (this.f5162k) {
                case 1:
                    if (m5749b(c1985g)) {
                        break;
                    }
                    return -1;
                case 2:
                    m5750c(c1985g);
                    break;
                case 3:
                    if (m5751d(c1985g)) {
                        break;
                    }
                    return -1;
                case 4:
                    if (!m5752e(c1985g)) {
                        break;
                    }
                    return 0;
                default:
                    break;
            }
        }
    }

    public void mo2941a(long j) {
        this.f5162k = 1;
        this.f5163l = 0;
    }

    public void mo2942a(C2090h c2090h) {
        this.f5161j = c2090h;
    }

    public boolean mo2943a() {
        return false;
    }

    public boolean mo2944a(C1985g c1985g) {
        c1985g.mo2969c(this.f5157f.f6454a, 0, 3);
        this.f5157f.m7073c(0);
        if (this.f5157f.m7083k() != f5153e) {
            return false;
        }
        c1985g.mo2969c(this.f5157f.f6454a, 0, 2);
        this.f5157f.m7073c(0);
        if ((this.f5157f.m7080h() & Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        c1985g.mo2969c(this.f5157f.f6454a, 0, 4);
        this.f5157f.m7073c(0);
        int n = this.f5157f.m7086n();
        c1985g.mo2961a();
        c1985g.mo2968c(n);
        c1985g.mo2969c(this.f5157f.f6454a, 0, 4);
        this.f5157f.m7073c(0);
        return this.f5157f.m7086n() == 0;
    }

    public long mo2945b() {
        return this.f5166o.m5771a();
    }

    public long mo2946b(long j) {
        return 0;
    }

    public void mo2947c() {
    }
}
