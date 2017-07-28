package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.C2576a;

public class C3111o extends C2741g {
    private final C2576a<acd<?>> f10059e;
    private C3424x f10060f;

    public void mo3514a() {
        super.mo3514a();
        if (!this.f10059e.isEmpty()) {
            this.f10060f.m14662a(this);
        }
    }

    protected void mo3519a(ConnectionResult connectionResult, int i) {
        this.f10060f.m14665b(connectionResult, i);
    }

    public void mo3517b() {
        super.mo3517b();
        this.f10060f.m14666b(this);
    }

    protected void mo3521c() {
        this.f10060f.m14667c();
    }

    C2576a<acd<?>> m12874e() {
        return this.f10059e;
    }
}
