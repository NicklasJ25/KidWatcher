package com.google.android.gms.internal;

import com.google.android.gms.internal.jl.C3002a;

public class jj implements jl {
    static final /* synthetic */ boolean f9529a = (!jj.class.desiredAssertionStatus());
    private final jy f9530b;

    public jj(jy jyVar) {
        this.f9530b = jyVar;
    }

    public jl mo3759a() {
        return this;
    }

    public jz mo3760a(jz jzVar, js jsVar, kf kfVar, hh hhVar, C3002a c3002a, ji jiVar) {
        if (f9529a || jzVar.m12113a(this.f9530b)) {
            kf a = jzVar.m12112a();
            kf c = a.mo3780c(jsVar);
            if (c.mo3772a(hhVar).equals(kfVar.mo3772a(hhVar)) && c.mo3778b() == kfVar.mo3778b()) {
                return jzVar;
            }
            if (jiVar != null) {
                if (kfVar.mo3778b()) {
                    if (a.mo3776a(jsVar)) {
                        jiVar.m11908a(ix.m11830b(jsVar, c));
                    } else if (!(f9529a || a.mo3782e())) {
                        throw new AssertionError("A child remove without an old child only makes sense on a leaf node");
                    }
                } else if (c.mo3778b()) {
                    jiVar.m11908a(ix.m11826a(jsVar, kfVar));
                } else {
                    jiVar.m11908a(ix.m11827a(jsVar, kfVar, c));
                }
            }
            return (a.mo3782e() && kfVar.mo3778b()) ? jzVar : jzVar.m12111a(jsVar, kfVar);
        } else {
            throw new AssertionError("The index must match the filter");
        }
    }

    public jz mo3761a(jz jzVar, jz jzVar2, ji jiVar) {
        if (f9529a || jzVar2.m12113a(this.f9530b)) {
            if (jiVar != null) {
                for (ke keVar : jzVar.m12112a()) {
                    if (!jzVar2.m12112a().mo3776a(keVar.m12169c())) {
                        jiVar.m11908a(ix.m11830b(keVar.m12169c(), keVar.m12170d()));
                    }
                }
                if (!jzVar2.m12112a().mo3782e()) {
                    for (ke keVar2 : jzVar2.m12112a()) {
                        if (jzVar.m12112a().mo3776a(keVar2.m12169c())) {
                            kf c = jzVar.m12112a().mo3780c(keVar2.m12169c());
                            if (!c.equals(keVar2.m12170d())) {
                                jiVar.m11908a(ix.m11827a(keVar2.m12169c(), keVar2.m12170d(), c));
                            }
                        } else {
                            jiVar.m11908a(ix.m11826a(keVar2.m12169c(), keVar2.m12170d()));
                        }
                    }
                }
            }
            return jzVar2;
        }
        throw new AssertionError("Can't use IndexedNode that doesn't have filter's index");
    }

    public jz mo3762a(jz jzVar, kf kfVar) {
        return jzVar.m12112a().mo3778b() ? jzVar : jzVar.m12114b(kfVar);
    }

    public jy mo3763b() {
        return this.f9530b;
    }

    public boolean mo3764c() {
        return false;
    }
}
