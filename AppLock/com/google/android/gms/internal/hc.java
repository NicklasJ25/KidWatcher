package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import com.google.firebase.database.C3536b;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class hc {
    static final /* synthetic */ boolean f9181a = (!hc.class.desiredAssertionStatus());
    private AtomicBoolean f9182b = new AtomicBoolean(false);
    private hd f9183c;
    private boolean f9184d = false;

    public abstract hc mo3726a(je jeVar);

    public abstract iy mo3727a(ix ixVar, je jeVar);

    public abstract je mo3728a();

    public void m11336a(hd hdVar) {
        if (!f9181a && m11343c()) {
            throw new AssertionError();
        } else if (f9181a || this.f9183c == null) {
            this.f9183c = hdVar;
        } else {
            throw new AssertionError();
        }
    }

    public abstract void mo3729a(iy iyVar);

    public abstract void mo3730a(C3536b c3536b);

    public void m11339a(boolean z) {
        this.f9184d = z;
    }

    public abstract boolean mo3731a(hc hcVar);

    public abstract boolean mo3732a(C2995a c2995a);

    public void m11342b() {
        if (this.f9182b.compareAndSet(false, true) && this.f9183c != null) {
            this.f9183c.mo3734a(this);
            this.f9183c = null;
        }
    }

    public boolean m11343c() {
        return this.f9182b.get();
    }

    public boolean m11344d() {
        return this.f9184d;
    }
}
