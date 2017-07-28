package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2520g;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C3349v.C3162a;

public class C3166q implements C3165u {
    private final C3349v f10252a;
    private boolean f10253b = false;

    public C3166q(C3349v c3349v) {
        this.f10252a = c3349v;
    }

    private <A extends C2449c> void m13254b(C2676a<? extends C2445g, A> c2676a) {
        this.f10252a.f10989g.f10656i.m9037a((C2675h) c2676a);
        C2449c a = this.f10252a.f10989g.m13851a(c2676a.mo3473b());
        if (a.m7739b() || !this.f10252a.f10984b.containsKey(c2676a.mo3473b())) {
            if (a instanceof C2520g) {
                a = ((C2520g) a).mo3338k();
            }
            c2676a.m8872a(a);
            return;
        }
        c2676a.m8871a(new Status(17));
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3900a(T t) {
        try {
            m13254b(t);
        } catch (DeadObjectException e) {
            this.f10252a.m14334a(new C3162a(this, this) {
                final /* synthetic */ C3166q f10250a;

                public void mo3899a() {
                    this.f10250a.mo3902a(1);
                }
            });
        }
        return t;
    }

    public void mo3901a() {
    }

    public void mo3902a(int i) {
        this.f10252a.m14332a(null);
        this.f10252a.f10990h.mo3800a(i, this.f10253b);
    }

    public void mo3903a(Bundle bundle) {
    }

    public void mo3904a(ConnectionResult connectionResult, C2456a<?> c2456a, boolean z) {
    }

    public boolean mo3905b() {
        if (this.f10253b) {
            return false;
        }
        if (this.f10252a.f10989g.m13868i()) {
            this.f10253b = true;
            for (at a : this.f10252a.f10989g.f10655h) {
                a.m9027a();
            }
            return false;
        }
        this.f10252a.m14332a(null);
        return true;
    }

    public void mo3906c() {
        if (this.f10253b) {
            this.f10253b = false;
            this.f10252a.m14334a(new C3162a(this, this) {
                final /* synthetic */ C3166q f10251a;

                public void mo3899a() {
                    this.f10251a.f10252a.f10990h.mo3801a(null);
                }
            });
        }
    }

    void m13262d() {
        if (this.f10253b) {
            this.f10253b = false;
            this.f10252a.f10989g.f10656i.m9036a();
            mo3905b();
        }
    }
}
