package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import com.google.firebase.database.C0623m;
import com.google.firebase.database.C3536b;
import com.google.firebase.database.C3588n;

public class hx extends hc {
    private final hj f9373b;
    private final C0623m f9374c;
    private final je f9375d;

    public hx(hj hjVar, C0623m c0623m, je jeVar) {
        this.f9373b = hjVar;
        this.f9374c = c0623m;
        this.f9375d = jeVar;
    }

    public hc mo3726a(je jeVar) {
        return new hx(this.f9373b, this.f9374c, jeVar);
    }

    public iy mo3727a(ix ixVar, je jeVar) {
        return new iy(C2995a.VALUE, this, C3588n.m15600a(C3588n.m15601a(this.f9373b, jeVar.m11869a()), ixVar.m11835c()), null);
    }

    public je mo3728a() {
        return this.f9375d;
    }

    public void mo3729a(iy iyVar) {
        if (!m11343c()) {
            this.f9374c.mo2378a(iyVar.m11839c());
        }
    }

    public void mo3730a(C3536b c3536b) {
        this.f9374c.mo2379a(c3536b);
    }

    public boolean mo3731a(hc hcVar) {
        return (hcVar instanceof hx) && ((hx) hcVar).f9374c.equals(this.f9374c);
    }

    public boolean mo3732a(C2995a c2995a) {
        return c2995a == C2995a.VALUE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof hx) && ((hx) obj).f9374c.equals(this.f9374c) && ((hx) obj).f9373b.equals(this.f9373b) && ((hx) obj).f9375d.equals(this.f9375d);
    }

    public int hashCode() {
        return (((this.f9374c.hashCode() * 31) + this.f9373b.hashCode()) * 31) + this.f9375d.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }
}
