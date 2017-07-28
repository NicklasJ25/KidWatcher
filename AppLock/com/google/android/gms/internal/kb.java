package com.google.android.gms.internal;

import com.google.android.gms.internal.kf.C3025a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class kb<T extends kb> implements kf {
    static final /* synthetic */ boolean f9553c = (!kb.class.desiredAssertionStatus());
    private String f9554a;
    protected final kf f9555b;

    protected enum C3023a {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    kb(kf kfVar) {
        this.f9555b = kfVar;
    }

    private static int m11980a(kd kdVar, jw jwVar) {
        return Double.valueOf((double) ((Long) kdVar.mo3786a()).longValue()).compareTo((Double) jwVar.mo3786a());
    }

    protected abstract int mo3785a(T t);

    public kf mo3772a(hh hhVar) {
        return hhVar.m11391h() ? this : hhVar.m11387d().m12011e() ? this.f9555b : jx.m12080j();
    }

    public kf mo3773a(hh hhVar, kf kfVar) {
        js d = hhVar.m11387d();
        if (d == null) {
            return kfVar;
        }
        if (kfVar.mo3778b() && !d.m12011e()) {
            return this;
        }
        if (f9553c || !hhVar.m11387d().m12011e() || hhVar.m11392i() == 1) {
            return mo3774a(d, jx.m12080j().mo3773a(hhVar.m11388e(), kfVar));
        }
        throw new AssertionError();
    }

    public kf mo3774a(js jsVar, kf kfVar) {
        return jsVar.m12011e() ? mo3788b(kfVar) : !kfVar.mo3778b() ? jx.m12080j().mo3774a(jsVar, kfVar).mo3788b(this.f9555b) : this;
    }

    public Object mo3775a(boolean z) {
        if (!z || this.f9555b.mo3778b()) {
            return mo3786a();
        }
        Map hashMap = new HashMap();
        hashMap.put(".value", mo3786a());
        hashMap.put(".priority", this.f9555b.mo3786a());
        return hashMap;
    }

    public boolean mo3776a(js jsVar) {
        return false;
    }

    protected int m11987b(kb<?> kbVar) {
        C3023a f_ = f_();
        Enum f_2 = kbVar.f_();
        return f_.equals(f_2) ? mo3785a((kb) kbVar) : f_.compareTo(f_2);
    }

    public js mo3777b(js jsVar) {
        return null;
    }

    protected String m11989b(C3025a c3025a) {
        switch (c3025a) {
            case V1:
            case V2:
                if (this.f9555b.mo3778b()) {
                    return "";
                }
                String valueOf = String.valueOf(this.f9555b.mo3787a(c3025a));
                return new StringBuilder(String.valueOf(valueOf).length() + 10).append("priority:").append(valueOf).append(":").toString();
            default:
                String valueOf2 = String.valueOf(c3025a);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 22).append("Unknown hash version: ").append(valueOf2).toString());
        }
    }

    public boolean mo3778b() {
        return false;
    }

    public int mo3779c() {
        return 0;
    }

    public int m11992c(kf kfVar) {
        if (kfVar.mo3778b()) {
            return 1;
        }
        if (kfVar instanceof jt) {
            return -1;
        }
        if (f9553c || kfVar.mo3782e()) {
            return ((this instanceof kd) && (kfVar instanceof jw)) ? m11980a((kd) this, (jw) kfVar) : ((this instanceof jw) && (kfVar instanceof kd)) ? m11980a((kd) kfVar, (jw) this) * -1 : m11987b((kb) kfVar);
        } else {
            throw new AssertionError("Node is not leaf node!");
        }
    }

    public kf mo3780c(js jsVar) {
        return jsVar.m12011e() ? this.f9555b : jx.m12080j();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m11992c((kf) obj);
    }

    public String mo3781d() {
        if (this.f9554a == null) {
            this.f9554a = lh.m12297b(mo3787a(C3025a.V1));
        }
        return this.f9554a;
    }

    public boolean mo3782e() {
        return true;
    }

    public kf mo3783f() {
        return this.f9555b;
    }

    protected abstract C3023a f_();

    public Iterator<ke> mo3784i() {
        return Collections.emptyList().iterator();
    }

    public Iterator<ke> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = mo3775a(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }
}
