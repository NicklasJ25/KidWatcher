package com.facebook.ads.internal.p025c;

import android.os.Bundle;

public class C1545d {
    private C1544c f3764a;
    private final C1544c f3765b;
    private final C1542b f3766c;
    private boolean f3767d = false;
    private boolean f3768e = false;
    private boolean f3769f = false;

    public C1545d(C1542b c1542b) {
        this.f3766c = c1542b;
        this.f3765b = new C1544c(c1542b.f3747a);
        this.f3764a = new C1544c(c1542b.f3747a);
    }

    public C1545d(C1542b c1542b, Bundle bundle) {
        this.f3766c = c1542b;
        this.f3765b = (C1544c) bundle.getSerializable("testStats");
        this.f3764a = (C1544c) bundle.getSerializable("viewableStats");
        this.f3767d = bundle.getBoolean("ended");
        this.f3768e = bundle.getBoolean("passed");
        this.f3769f = bundle.getBoolean("complete");
    }

    private void m4287b() {
        this.f3768e = true;
        m4288c();
    }

    private void m4288c() {
        this.f3769f = true;
        m4289d();
    }

    private void m4289d() {
        this.f3767d = true;
        this.f3766c.mo2778a(this.f3769f, this.f3768e, this.f3768e ? this.f3764a : this.f3765b);
    }

    public Bundle m4290a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewableStats", this.f3764a);
        bundle.putSerializable("testStats", this.f3765b);
        bundle.putBoolean("ended", this.f3767d);
        bundle.putBoolean("passed", this.f3768e);
        bundle.putBoolean("complete", this.f3769f);
        return bundle;
    }

    public void m4291a(double d, double d2) {
        if (!this.f3767d) {
            this.f3765b.m4283a(d, d2);
            this.f3764a.m4283a(d, d2);
            double f = this.f3764a.m4284b().m4280f();
            if (this.f3766c.f3750d && d2 < this.f3766c.f3747a) {
                this.f3764a = new C1544c(this.f3766c.f3747a);
            }
            if (this.f3766c.f3748b >= 0.0d && this.f3765b.m4284b().m4279e() > this.f3766c.f3748b && f == 0.0d) {
                m4288c();
            } else if (f >= this.f3766c.f3749c) {
                m4287b();
            }
        }
    }
}
