package com.google.android.gms.internal;

import com.google.android.gms.internal.gk.C2899a;
import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.gw.C2925a;
import com.google.android.gms.internal.jq.C3008a;
import com.google.firebase.C3531b;
import com.google.firebase.database.C3537c;
import com.google.firebase.database.C3576f;
import java.util.concurrent.ScheduledExecutorService;

public class ha {
    protected jq f9168a;
    protected he f9169b;
    protected gw f9170c;
    protected hm f9171d;
    protected String f9172e;
    protected String f9173f;
    protected C3008a f9174g = C3008a.INFO;
    protected boolean f9175h;
    protected long f9176i = 10485760;
    protected C3531b f9177j;
    private boolean f9178k = false;
    private boolean f9179l = false;
    private hi f9180m;

    class C29331 implements gk {
        final /* synthetic */ gw f9167a;

        C29331(gw gwVar) {
            this.f9167a = gwVar;
        }

        public void mo3699a(boolean z, final C2899a c2899a) {
            this.f9167a.mo3598a(z, new C2925a(this) {
                public void mo3697a(String str) {
                    c2899a.mo3666a(str);
                }

                public void mo3698b(String str) {
                    c2899a.mo3667b(str);
                }
            });
        }
    }

    private static gk m11300a(gw gwVar) {
        return new C29331(gwVar);
    }

    private String mo3700c(String str) {
        return "Firebase/" + "5" + "/" + C3576f.m15586c() + "/" + str;
    }

    private hi m11302o() {
        if (this.f9180m == null) {
            if (kw.m12262a()) {
                m11303p();
            } else if (hf.m11357a()) {
                hi hiVar = hf.INSTANCE;
                hiVar.m11365b();
                this.f9180m = hiVar;
            } else {
                this.f9180m = hg.INSTANCE;
            }
        }
        return this.f9180m;
    }

    private synchronized void m11303p() {
        this.f9180m = new fu(this.f9177j);
    }

    private void m11304q() {
        m11307t();
        m11302o();
        m11310w();
        m11309v();
        m11308u();
        m11312y();
        m11311x();
    }

    private void m11305r() {
        this.f9169b.mo3599a();
        this.f9171d.mo3602c();
    }

    private ScheduledExecutorService m11306s() {
        hm k = m11326k();
        if (k instanceof lb) {
            return ((lb) k).m10819d();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private void m11307t() {
        if (this.f9168a == null) {
            this.f9168a = m11302o().mo3609a(this, this.f9174g, null);
        }
    }

    private void m11308u() {
        if (this.f9171d == null) {
            this.f9171d = this.f9180m.mo3610b(this);
        }
    }

    private void m11309v() {
        if (this.f9169b == null) {
            this.f9169b = m11302o().mo3607a(this);
        }
    }

    private void m11310w() {
        if (this.f9173f == null) {
            this.f9173f = mo3700c(m11302o().mo3611c(this));
        }
    }

    private void m11311x() {
        if (this.f9170c == null) {
            this.f9170c = m11302o().mo3606a(m11306s());
        }
    }

    private void m11312y() {
        if (this.f9172e == null) {
            this.f9172e = "default";
        }
    }

    public gp m11313a(gn gnVar, C2900a c2900a) {
        return m11302o().mo3605a(this, m11322g(), gnVar, c2900a);
    }

    public jp m11314a(String str) {
        return new jp(this.f9168a, str);
    }

    public boolean m11315a() {
        return this.f9178k;
    }

    im m11316b(String str) {
        if (!this.f9175h) {
            return new il();
        }
        im a = this.f9180m.mo3608a(this, str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    synchronized void m11317b() {
        if (!this.f9178k) {
            this.f9178k = true;
            m11304q();
        }
    }

    public void m11318c() {
        if (this.f9179l) {
            m11305r();
            this.f9179l = false;
        }
    }

    protected void m11319d() {
        if (m11315a()) {
            throw new C3537c("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public C3008a m11320e() {
        return this.f9174g;
    }

    public jq m11321f() {
        return this.f9168a;
    }

    public gl m11322g() {
        return new gl(m11321f(), m11300a(m11329n()), m11306s(), m11323h(), C3576f.m15586c(), m11327l());
    }

    public boolean m11323h() {
        return this.f9175h;
    }

    public long m11324i() {
        return this.f9176i;
    }

    public he m11325j() {
        return this.f9169b;
    }

    public hm m11326k() {
        return this.f9171d;
    }

    public String m11327l() {
        return this.f9173f;
    }

    public String m11328m() {
        return this.f9172e;
    }

    public gw m11329n() {
        return this.f9170c;
    }
}
