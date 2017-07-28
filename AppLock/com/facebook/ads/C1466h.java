package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.C1464c;
import com.facebook.ads.internal.C1540b;
import com.facebook.ads.internal.C1555d;
import com.facebook.ads.internal.C1558e;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p021b.C1490a;
import com.facebook.ads.internal.p024l.C1675a;

public class C1466h implements C1453b {
    private static final C1558e f3404a = C1558e.ADS;
    private final Context f3405b;
    private final String f3406c;
    private C1540b f3407d;
    private boolean f3408e;
    private boolean f3409f;
    private C0664j f3410g;

    class C14651 extends C1464c {
        final /* synthetic */ C1466h f3403a;

        C14651(C1466h c1466h) {
            this.f3403a = c1466h;
        }

        public void mo2634a() {
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2392b(this.f3403a);
            }
        }

        public void mo2635a(View view) {
        }

        public void mo2636a(C1490a c1490a) {
            this.f3403a.f3408e = true;
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2390a(this.f3403a);
            }
        }

        public void mo2637a(C1555d c1555d) {
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2391a(this.f3403a, c1555d.m4323b());
            }
        }

        public void mo2638b() {
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2393c(this.f3403a);
            }
        }

        public void mo2639c() {
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2396e(this.f3403a);
            }
        }

        public void mo2640d() {
            this.f3403a.f3409f = false;
            if (this.f3403a.f3407d != null) {
                this.f3403a.f3407d.m4268d();
                this.f3403a.f3407d = null;
            }
            if (this.f3403a.f3410g != null) {
                this.f3403a.f3410g.mo2395d(this.f3403a);
            }
        }
    }

    public C1466h(Context context, String str) {
        this.f3405b = context;
        this.f3406c = str;
    }

    public void m3794a() {
        this.f3408e = false;
        if (this.f3409f) {
            throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
        }
        if (this.f3407d != null) {
            this.f3407d.m4268d();
            this.f3407d = null;
        }
        C1463g c1463g = C1463g.f3397b;
        this.f3407d = new C1540b(this.f3405b, this.f3406c, C1729s.m4957a(C1463g.f3397b), C1675a.INTERSTITIAL, c1463g, f3404a, 1, true);
        this.f3407d.m4263a(new C14651(this));
        this.f3407d.m4266b();
    }

    public void m3795a(C0664j c0664j) {
        this.f3410g = c0664j;
    }

    public boolean m3796b() {
        return this.f3408e;
    }

    public boolean m3797c() {
        if (this.f3408e) {
            this.f3407d.m4267c();
            this.f3409f = true;
            this.f3408e = false;
            return true;
        } else if (this.f3410g == null) {
            return false;
        } else {
            this.f3410g.mo2391a(this, C1460d.f3367e);
            return false;
        }
    }
}
