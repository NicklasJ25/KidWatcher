package com.google.firebase.database;

import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.ho;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.kf;

public class C3578h {
    private final ho f12200a;
    private final hh f12201b;

    private C3578h(ho hoVar, hh hhVar) {
        this.f12200a = hoVar;
        this.f12201b = hhVar;
        hw.m11596a(this.f12201b, m15591b());
    }

    C3578h(kf kfVar) {
        this(new ho(kfVar), new hh(""));
    }

    kf m15590a() {
        return this.f12200a.m11496a(this.f12201b);
    }

    public Object m15591b() {
        return m15590a().mo3786a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3578h) && this.f12200a.equals(((C3578h) obj).f12200a) && this.f12201b.equals(((C3578h) obj).f12201b);
    }

    public String toString() {
        js d = this.f12201b.m11387d();
        String d2 = d != null ? d.m12010d() : "<none>";
        String valueOf = String.valueOf(this.f12200a.m11495a().mo3775a(true));
        return new StringBuilder((String.valueOf(d2).length() + 32) + String.valueOf(valueOf).length()).append("MutableData { key = ").append(d2).append(", value = ").append(valueOf).append(" }").toString();
    }
}
