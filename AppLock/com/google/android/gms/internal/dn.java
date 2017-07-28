package com.google.android.gms.internal;

abstract class dn extends dm {
    private boolean f8257a;

    dn(dk dkVar) {
        super(dkVar);
        this.n.m10005a(this);
    }

    boolean m9447Q() {
        return this.f8257a;
    }

    protected void m9448R() {
        if (!m9447Q()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m9449S() {
        if (this.f8257a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo3551a();
        this.n.m9996N();
        this.f8257a = true;
    }

    protected abstract void mo3551a();
}
