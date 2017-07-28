package com.google.android.gms.internal;

import com.google.android.gms.internal.kb.C3023a;
import com.google.android.gms.internal.kf.C3025a;

public class kd extends kb<kd> {
    private final long f9621a;

    public kd(Long l, kf kfVar) {
        super(kfVar);
        this.f9621a = l.longValue();
    }

    protected int m12162a(kd kdVar) {
        return lh.m12291a(this.f9621a, kdVar.f9621a);
    }

    public kd m12163a(kf kfVar) {
        return new kd(Long.valueOf(this.f9621a), kfVar);
    }

    public Object mo3786a() {
        return Long.valueOf(this.f9621a);
    }

    public String mo3787a(C3025a c3025a) {
        String valueOf = String.valueOf(String.valueOf(m11989b(c3025a)).concat("number:"));
        String valueOf2 = String.valueOf(lh.m12294a((double) this.f9621a));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12163a(kfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kd)) {
            return false;
        }
        kd kdVar = (kd) obj;
        return this.f9621a == kdVar.f9621a && this.b.equals(kdVar.b);
    }

    protected C3023a f_() {
        return C3023a.Number;
    }

    public int hashCode() {
        return ((int) (this.f9621a ^ (this.f9621a >>> 32))) + this.b.hashCode();
    }
}
