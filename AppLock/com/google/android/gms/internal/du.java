package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;

class du {
    private final C2580e f8695a;
    private long f8696b;

    public du(C2580e c2580e) {
        C2513c.m7932a((Object) c2580e);
        this.f8695a = c2580e;
    }

    public void m10323a() {
        this.f8696b = this.f8695a.mo3361b();
    }

    public boolean m10324a(long j) {
        return this.f8696b == 0 || this.f8695a.mo3361b() - this.f8696b >= j;
    }

    public void m10325b() {
        this.f8696b = 0;
    }
}
