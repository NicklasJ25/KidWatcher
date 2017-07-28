package com.google.android.gms.internal;

import com.google.android.gms.internal.jl.C3002a;
import java.util.Iterator;

public class jk implements jl {
    static final /* synthetic */ boolean f9531a = (!jk.class.desiredAssertionStatus());
    private final jm f9532b;
    private final jy f9533c;
    private final int f9534d;
    private final boolean f9535e;

    public jk(jd jdVar) {
        this.f9532b = new jm(jdVar);
        this.f9533c = jdVar.m11860i();
        this.f9534d = jdVar.m11859h();
        this.f9535e = !jdVar.m11861j();
    }

    private jz m11921a(jz jzVar, js jsVar, kf kfVar, C3002a c3002a, ji jiVar) {
        if (f9531a || jzVar.m12112a().mo3779c() == this.f9534d) {
            ke keVar = new ke(jsVar, kfVar);
            ke c = this.f9535e ? jzVar.m12116c() : jzVar.m12117d();
            boolean a = this.f9532b.m11934a(keVar);
            if (jzVar.m12112a().mo3776a(jsVar)) {
                kf c2 = jzVar.m12112a().mo3780c(jsVar);
                ke a2 = c3002a.mo3757a(this.f9533c, c, this.f9535e);
                while (a2 != null && (a2.m12169c().equals(jsVar) || jzVar.m12112a().mo3776a(a2.m12169c()))) {
                    a2 = c3002a.mo3757a(this.f9533c, a2, this.f9535e);
                }
                Object obj = (!a || kfVar.mo3778b() || (a2 == null ? 1 : this.f9533c.m12100a(a2, keVar, this.f9535e)) < 0) ? null : 1;
                if (obj != null) {
                    if (jiVar != null) {
                        jiVar.m11908a(ix.m11827a(jsVar, kfVar, c2));
                    }
                    return jzVar.m12111a(jsVar, kfVar);
                }
                if (jiVar != null) {
                    jiVar.m11908a(ix.m11830b(jsVar, c2));
                }
                jzVar = jzVar.m12111a(jsVar, jx.m12080j());
                obj = (a2 == null || !this.f9532b.m11934a(a2)) ? null : 1;
                if (obj == null) {
                    return jzVar;
                }
                if (jiVar != null) {
                    jiVar.m11908a(ix.m11826a(a2.m12169c(), a2.m12170d()));
                }
                return jzVar.m12111a(a2.m12169c(), a2.m12170d());
            } else if (kfVar.mo3778b() || !a || this.f9533c.m12100a(c, keVar, this.f9535e) < 0) {
                return jzVar;
            } else {
                if (jiVar != null) {
                    jiVar.m11908a(ix.m11830b(c.m12169c(), c.m12170d()));
                    jiVar.m11908a(ix.m11826a(jsVar, kfVar));
                }
                return jzVar.m12111a(jsVar, kfVar).m12111a(c.m12169c(), jx.m12080j());
            }
        }
        throw new AssertionError();
    }

    public jl mo3759a() {
        return this.f9532b.mo3759a();
    }

    public jz mo3760a(jz jzVar, js jsVar, kf kfVar, hh hhVar, C3002a c3002a, ji jiVar) {
        kf j = !this.f9532b.m11934a(new ke(jsVar, kfVar)) ? jx.m12080j() : kfVar;
        return jzVar.m12112a().mo3780c(jsVar).equals(j) ? jzVar : jzVar.m12112a().mo3779c() < this.f9534d ? this.f9532b.mo3759a().mo3760a(jzVar, jsVar, j, hhVar, c3002a, jiVar) : m11921a(jzVar, jsVar, j, c3002a, jiVar);
    }

    public jz mo3761a(jz jzVar, jz jzVar2, ji jiVar) {
        jz a;
        if (jzVar2.m12112a().mo3782e() || jzVar2.m12112a().mo3778b()) {
            a = jz.m12108a(jx.m12080j(), this.f9533c);
        } else {
            Object d;
            Iterator it;
            int i;
            jz b = jzVar2.m12114b(kj.m12190a());
            if (this.f9535e) {
                Iterator b2 = jzVar2.m12115b();
                Object e = this.f9532b.m11938e();
                d = this.f9532b.m11937d();
                it = b2;
                i = -1;
            } else {
                Iterator it2 = jzVar2.iterator();
                ke d2 = this.f9532b.m11937d();
                ke e2 = this.f9532b.m11938e();
                ke keVar = d2;
                i = 1;
                it = it2;
            }
            int i2 = 0;
            a = b;
            Object obj = null;
            while (it.hasNext()) {
                int i3;
                jz jzVar3;
                ke keVar2 = (ke) it.next();
                if (obj == null && this.f9533c.compare(r5, keVar2) * i <= 0) {
                    obj = 1;
                }
                Object obj2 = (obj == null || i2 >= this.f9534d || this.f9533c.compare(keVar2, d) * i > 0) ? null : 1;
                if (obj2 != null) {
                    i3 = i2 + 1;
                    jzVar3 = a;
                } else {
                    a = a.m12111a(keVar2.m12169c(), jx.m12080j());
                    i3 = i2;
                    jzVar3 = a;
                }
                a = jzVar3;
                i2 = i3;
            }
        }
        return this.f9532b.mo3759a().mo3761a(jzVar, a, jiVar);
    }

    public jz mo3762a(jz jzVar, kf kfVar) {
        return jzVar;
    }

    public jy mo3763b() {
        return this.f9533c;
    }

    public boolean mo3764c() {
        return true;
    }
}
