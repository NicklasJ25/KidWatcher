package com.google.android.gms.internal;

import com.google.android.gms.internal.kb.C3023a;
import com.google.android.gms.internal.kf.C3025a;

public class kl extends kb<kl> {
    private final String f9636a;

    public kl(String str, kf kfVar) {
        super(kfVar);
        this.f9636a = str;
    }

    protected int m12196a(kl klVar) {
        return this.f9636a.compareTo(klVar.f9636a);
    }

    public kl m12197a(kf kfVar) {
        return new kl(this.f9636a, kfVar);
    }

    public Object mo3786a() {
        return this.f9636a;
    }

    public String mo3787a(C3025a c3025a) {
        String valueOf;
        String str;
        switch (c3025a) {
            case V1:
                valueOf = String.valueOf(m11989b(c3025a));
                str = this.f9636a;
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            case V2:
                valueOf = String.valueOf(m11989b(c3025a));
                str = String.valueOf(lh.m12298c(this.f9636a));
                return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append("string:").append(str).toString();
            default:
                str = String.valueOf(c3025a);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 38).append("Invalid hash version for string node: ").append(str).toString());
        }
    }

    public /* synthetic */ kf mo3788b(kf kfVar) {
        return m12197a(kfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kl)) {
            return false;
        }
        kl klVar = (kl) obj;
        return this.f9636a.equals(klVar.f9636a) && this.b.equals(klVar.b);
    }

    protected C3023a f_() {
        return C3023a.String;
    }

    public int hashCode() {
        return this.f9636a.hashCode() + this.b.hashCode();
    }
}
