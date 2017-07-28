package com.google.android.gms.internal;

public class kh extends jy {
    private final hh f9629a;

    public kh(hh hhVar) {
        if (hhVar.m11392i() == 1 && hhVar.m11387d().m12011e()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f9629a = hhVar;
    }

    public int m12179a(ke keVar, ke keVar2) {
        int compareTo = keVar.m12170d().mo3772a(this.f9629a).compareTo(keVar2.m12170d().mo3772a(this.f9629a));
        return compareTo == 0 ? keVar.m12169c().m12009a(keVar2.m12169c()) : compareTo;
    }

    public ke mo3809a(js jsVar, kf kfVar) {
        return new ke(jsVar, jx.m12080j().mo3773a(this.f9629a, kfVar));
    }

    public boolean mo3810a(kf kfVar) {
        return !kfVar.mo3772a(this.f9629a).mo3778b();
    }

    public ke mo3811b() {
        return new ke(js.m12006b(), jx.m12080j().mo3773a(this.f9629a, kf.f9552d));
    }

    public String mo3812c() {
        return this.f9629a.m11383b();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12179a((ke) obj, (ke) obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9629a.equals(((kh) obj).f9629a);
    }

    public int hashCode() {
        return this.f9629a.hashCode();
    }
}
