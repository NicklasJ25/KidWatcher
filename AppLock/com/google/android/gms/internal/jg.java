package com.google.android.gms.internal;

public class jg {
    private final iv f9516a;
    private final iv f9517b;

    public jg(iv ivVar, iv ivVar2) {
        this.f9516a = ivVar;
        this.f9517b = ivVar2;
    }

    public iv m11884a() {
        return this.f9516a;
    }

    public jg m11885a(jz jzVar, boolean z, boolean z2) {
        return new jg(new iv(jzVar, z, z2), this.f9517b);
    }

    public jg m11886b(jz jzVar, boolean z, boolean z2) {
        return new jg(this.f9516a, new iv(jzVar, z, z2));
    }

    public kf m11887b() {
        return this.f9516a.m11815a() ? this.f9516a.m11819c() : null;
    }

    public iv m11888c() {
        return this.f9517b;
    }

    public kf m11889d() {
        return this.f9517b.m11815a() ? this.f9517b.m11819c() : null;
    }
}
