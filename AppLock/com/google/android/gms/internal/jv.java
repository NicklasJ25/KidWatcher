package com.google.android.gms.internal;

import com.google.android.gms.internal.kb.C3023a;
import com.google.android.gms.internal.kf.C3025a;
import java.util.Map;

public class jv extends kb<jv> {
    static final /* synthetic */ boolean f9585a = (!jv.class.desiredAssertionStatus());
    private Map<Object, Object> f9586e;

    public jv(Map<Object, Object> map, kf kfVar) {
        super(kfVar);
        this.f9586e = map;
    }

    public jv m12070a(kf kfVar) {
        if (f9585a || kj.m12192a(kfVar)) {
            return new jv(this.f9586e, kfVar);
        }
        throw new AssertionError();
    }

    public Object mo3786a() {
        return this.f9586e;
    }

    public String mo3787a(C3025a c3025a) {
        String valueOf = String.valueOf(m11989b(c3025a));
        String valueOf2 = String.valueOf(this.f9586e);
        return new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append(valueOf).append("deferredValue:").append(valueOf2).toString();
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12070a(kfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jv)) {
            return false;
        }
        jv jvVar = (jv) obj;
        return this.f9586e.equals(jvVar.f9586e) && this.b.equals(jvVar.b);
    }

    protected C3023a f_() {
        return C3023a.DeferredValue;
    }

    public int hashCode() {
        return this.f9586e.hashCode() + this.b.hashCode();
    }
}
