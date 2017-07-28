package com.google.android.gms.internal;

import com.google.android.gms.internal.kb.C3023a;
import com.google.android.gms.internal.kf.C3025a;

public class jr extends kb<jr> {
    private final boolean f9556a;

    public jr(Boolean bool, kf kfVar) {
        super(kfVar);
        this.f9556a = bool.booleanValue();
    }

    protected int m11998a(jr jrVar) {
        return this.f9556a == jrVar.f9556a ? 0 : this.f9556a ? 1 : -1;
    }

    public jr m12000a(kf kfVar) {
        return new jr(Boolean.valueOf(this.f9556a), kfVar);
    }

    public Object mo3786a() {
        return Boolean.valueOf(this.f9556a);
    }

    public String mo3787a(C3025a c3025a) {
        String valueOf = String.valueOf(m11989b(c3025a));
        return new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append("boolean:").append(this.f9556a).toString();
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12000a(kfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jr)) {
            return false;
        }
        jr jrVar = (jr) obj;
        return this.f9556a == jrVar.f9556a && this.b.equals(jrVar.b);
    }

    protected C3023a f_() {
        return C3023a.Boolean;
    }

    public int hashCode() {
        return (this.f9556a ? 1 : 0) + this.b.hashCode();
    }
}
