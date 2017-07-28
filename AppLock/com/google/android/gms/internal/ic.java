package com.google.android.gms.internal;

import com.google.android.gms.internal.C2978if.C2979a;

public class ic extends C2978if {
    private final boolean f9398a;
    private final ir<Boolean> f9399e;

    public ic(hh hhVar, ir<Boolean> irVar, boolean z) {
        super(C2979a.AckUserWrite, ig.f9410a, hhVar);
        this.f9399e = irVar;
        this.f9398a = z;
    }

    public C2978if mo3735a(js jsVar) {
        if (!this.d.m11391h()) {
            lh.m12296a(this.d.m11387d().equals(jsVar), "operationForChild called for unrelated child.");
            return new ic(this.d.m11388e(), this.f9399e, this.f9398a);
        } else if (this.f9399e.m11788b() != null) {
            lh.m12296a(this.f9399e.m11791c().mo3643d(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new ic(hh.m11376a(), this.f9399e.m11792c(new hh(jsVar)), this.f9398a);
        }
    }

    public ir<Boolean> m11652a() {
        return this.f9399e;
    }

    public boolean m11653b() {
        return this.f9398a;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", new Object[]{m11648c(), Boolean.valueOf(this.f9398a), this.f9399e});
    }
}
