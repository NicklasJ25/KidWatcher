package com.google.android.gms.internal;

import com.google.android.gms.internal.kb.C3023a;
import com.google.android.gms.internal.kf.C3025a;

public class jw extends kb<jw> {
    static final /* synthetic */ boolean f9587a = (!jw.class.desiredAssertionStatus());
    private final Double f9588e;

    public jw(Double d, kf kfVar) {
        super(kfVar);
        this.f9588e = d;
    }

    protected int m12074a(jw jwVar) {
        return this.f9588e.compareTo(jwVar.f9588e);
    }

    public jw m12076a(kf kfVar) {
        if (f9587a || kj.m12192a(kfVar)) {
            return new jw(this.f9588e, kfVar);
        }
        throw new AssertionError();
    }

    public Object mo3786a() {
        return this.f9588e;
    }

    public String mo3787a(C3025a c3025a) {
        String valueOf = String.valueOf(String.valueOf(m11989b(c3025a)).concat("number:"));
        String valueOf2 = String.valueOf(lh.m12294a(this.f9588e.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12076a(kfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jw)) {
            return false;
        }
        jw jwVar = (jw) obj;
        return this.f9588e.equals(jwVar.f9588e) && this.b.equals(jwVar.b);
    }

    protected C3023a f_() {
        return C3023a.Number;
    }

    public int hashCode() {
        return this.f9588e.hashCode() + this.b.hashCode();
    }
}
