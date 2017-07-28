package com.google.android.gms.internal;

import com.google.android.gms.internal.C2978if.C2979a;

public class ih extends C2978if {
    private final kf f9416a;

    public ih(ig igVar, hh hhVar, kf kfVar) {
        super(C2979a.Overwrite, igVar, hhVar);
        this.f9416a = kfVar;
    }

    public C2978if mo3735a(js jsVar) {
        return this.d.m11391h() ? new ih(this.c, hh.m11376a(), this.f9416a.mo3780c(jsVar)) : new ih(this.c, this.d.m11388e(), this.f9416a);
    }

    public kf m11663a() {
        return this.f9416a;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", new Object[]{m11648c(), m11649d(), this.f9416a});
    }
}
