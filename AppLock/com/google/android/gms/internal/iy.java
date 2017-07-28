package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import com.google.firebase.database.C3535a;

public class iy implements iz {
    private final C2995a f9473a;
    private final hc f9474b;
    private final C3535a f9475c;
    private final String f9476d;

    public iy(C2995a c2995a, hc hcVar, C3535a c3535a, String str) {
        this.f9473a = c2995a;
        this.f9474b = hcVar;
        this.f9475c = c3535a;
        this.f9476d = str;
    }

    public hh m11837a() {
        hh c = this.f9475c.m15458b().m15576c();
        return this.f9473a == C2995a.VALUE ? c : c.m11389f();
    }

    public void mo3755b() {
        this.f9474b.mo3729a(this);
    }

    public C3535a m11839c() {
        return this.f9475c;
    }

    public String toString() {
        if (this.f9473a == C2995a.VALUE) {
            String valueOf = String.valueOf(m11837a());
            String valueOf2 = String.valueOf(this.f9473a);
            String valueOf3 = String.valueOf(this.f9475c.m15457a(true));
            return new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        valueOf = String.valueOf(m11837a());
        valueOf2 = String.valueOf(this.f9473a);
        valueOf3 = String.valueOf(this.f9475c.m15459c());
        String valueOf4 = String.valueOf(this.f9475c.m15457a(true));
        return new StringBuilder((((String.valueOf(valueOf).length() + 10) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(valueOf).append(": ").append(valueOf2).append(": { ").append(valueOf3).append(": ").append(valueOf4).append(" }").toString();
    }
}
