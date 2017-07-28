package com.google.android.gms.internal;

import com.google.firebase.database.C3536b;

public class iw implements iz {
    private final hh f9465a;
    private final hc f9466b;
    private final C3536b f9467c;

    public iw(hc hcVar, C3536b c3536b, hh hhVar) {
        this.f9466b = hcVar;
        this.f9465a = hhVar;
        this.f9467c = c3536b;
    }

    public hh m11822a() {
        return this.f9465a;
    }

    public void mo3755b() {
        this.f9466b.mo3730a(this.f9467c);
    }

    public String toString() {
        String valueOf = String.valueOf(m11822a());
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }
}
