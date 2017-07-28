package com.google.android.gms.auth.api.signin.internal;

public class C2423b {
    static int f7216a = 31;
    private int f7217b = 1;

    public int m7658a() {
        return this.f7217b;
    }

    public C2423b m7659a(Object obj) {
        this.f7217b = (obj == null ? 0 : obj.hashCode()) + (this.f7217b * f7216a);
        return this;
    }

    public C2423b m7660a(boolean z) {
        this.f7217b = (z ? 1 : 0) + (this.f7217b * f7216a);
        return this;
    }
}
