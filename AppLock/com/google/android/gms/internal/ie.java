package com.google.android.gms.internal;

import com.google.android.gms.internal.C2978if.C2979a;

public class ie extends C2978if {
    private final gx f9401a;

    public ie(ig igVar, hh hhVar, gx gxVar) {
        super(C2979a.Merge, igVar, hhVar);
        this.f9401a = gxVar;
    }

    public gx m11655a() {
        return this.f9401a;
    }

    public C2978if mo3735a(js jsVar) {
        if (!this.d.m11391h()) {
            return this.d.m11387d().equals(jsVar) ? new ie(this.c, this.d.m11388e(), this.f9401a) : null;
        } else {
            gx d = this.f9401a.m11289d(new hh(jsVar));
            return d.m11291e() ? null : d.m11285b() != null ? new ih(this.c, hh.m11376a(), d.m11285b()) : new ie(this.c, hh.m11376a(), d);
        }
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{m11648c(), m11649d(), this.f9401a});
    }
}
