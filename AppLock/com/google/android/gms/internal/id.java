package com.google.android.gms.internal;

import com.google.android.gms.internal.C2978if.C2979a;

public class id extends C2978if {
    static final /* synthetic */ boolean f9400a = (!id.class.desiredAssertionStatus());

    public id(ig igVar, hh hhVar) {
        super(C2979a.ListenComplete, igVar, hhVar);
        if (!f9400a && igVar.m11658a()) {
            throw new AssertionError("Can't have a listen complete from a user source");
        }
    }

    public C2978if mo3735a(js jsVar) {
        return this.d.m11391h() ? new id(this.c, hh.m11376a()) : new id(this.c, this.d.m11388e());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", new Object[]{m11648c(), m11649d()});
    }
}
