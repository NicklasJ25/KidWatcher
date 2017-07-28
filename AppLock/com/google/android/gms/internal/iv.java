package com.google.android.gms.internal;

public class iv {
    private final jz f9462a;
    private final boolean f9463b;
    private final boolean f9464c;

    public iv(jz jzVar, boolean z, boolean z2) {
        this.f9462a = jzVar;
        this.f9463b = z;
        this.f9464c = z2;
    }

    public boolean m11815a() {
        return this.f9463b;
    }

    public boolean m11816a(hh hhVar) {
        return hhVar.m11391h() ? m11815a() && !this.f9464c : m11817a(hhVar.m11387d());
    }

    public boolean m11817a(js jsVar) {
        return (m11815a() && !this.f9464c) || this.f9462a.m12112a().mo3776a(jsVar);
    }

    public boolean m11818b() {
        return this.f9464c;
    }

    public kf m11819c() {
        return this.f9462a.m12112a();
    }

    public jz m11820d() {
        return this.f9462a;
    }
}
