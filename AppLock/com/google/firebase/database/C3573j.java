package com.google.firebase.database;

import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.je;

public class C3573j {
    static final /* synthetic */ boolean f12190d = (!C3573j.class.desiredAssertionStatus());
    protected final hj f12191a;
    protected final hh f12192b;
    protected final jd f12193c = jd.f9496a;
    private final boolean f12194e = false;

    C3573j(hj hjVar, hh hhVar) {
        this.f12191a = hjVar;
        this.f12192b = hhVar;
    }

    private void m15572a(final hc hcVar) {
        ib.m11642a().m11646c(hcVar);
        this.f12191a.m11475a(new Runnable(this) {
            final /* synthetic */ C3573j f12205b;

            public void run() {
                this.f12205b.f12191a.m11471a(hcVar);
            }
        });
    }

    private void m15573b(final hc hcVar) {
        ib.m11642a().m11645b(hcVar);
        this.f12191a.m11475a(new Runnable(this) {
            final /* synthetic */ C3573j f12207b;

            public void run() {
                this.f12207b.f12191a.m11481b(hcVar);
            }
        });
    }

    public void m15574a(final C0623m c0623m) {
        m15573b(new hx(this.f12191a, new C0623m(this) {
            final /* synthetic */ C3573j f12203b;

            public void mo2378a(C3535a c3535a) {
                this.f12203b.m15575b((C0623m) this);
                c0623m.mo2378a(c3535a);
            }

            public void mo2379a(C3536b c3536b) {
                c0623m.mo2379a(c3536b);
            }
        }, m15577d()));
    }

    public void m15575b(C0623m c0623m) {
        if (c0623m == null) {
            throw new NullPointerException("listener must not be null");
        }
        m15572a(new hx(this.f12191a, c0623m, m15577d()));
    }

    public hh m15576c() {
        return this.f12192b;
    }

    public je m15577d() {
        return new je(this.f12192b, this.f12193c);
    }
}
