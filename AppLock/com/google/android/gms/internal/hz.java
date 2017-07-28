package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class hz {
    private final hh f9385a;
    private final hy f9386b;

    public hz(hh hhVar, hy hyVar) {
        this.f9385a = hhVar;
        this.f9386b = hyVar;
    }

    public hz m11627a(js jsVar) {
        return new hz(this.f9385a.m11382a(jsVar), this.f9386b);
    }

    public ke m11628a(kf kfVar, ke keVar, boolean z, jy jyVar) {
        return this.f9386b.m11618a(this.f9385a, kfVar, keVar, z, jyVar);
    }

    public kf m11629a(hh hhVar) {
        return this.f9386b.m11625b(this.f9385a.m11381a(hhVar));
    }

    public kf m11630a(hh hhVar, kf kfVar, kf kfVar2) {
        return this.f9386b.m11619a(this.f9385a, hhVar, kfVar, kfVar2);
    }

    public kf m11631a(js jsVar, iv ivVar) {
        return this.f9386b.m11620a(this.f9385a, jsVar, ivVar);
    }

    public kf m11632a(kf kfVar) {
        return m11633a(kfVar, Collections.emptyList());
    }

    public kf m11633a(kf kfVar, List<Long> list) {
        return m11634a(kfVar, (List) list, false);
    }

    public kf m11634a(kf kfVar, List<Long> list, boolean z) {
        return this.f9386b.m11622a(this.f9385a, kfVar, (List) list, z);
    }

    public kf m11635b(kf kfVar) {
        return this.f9386b.m11621a(this.f9385a, kfVar);
    }
}
