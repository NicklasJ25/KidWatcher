package com.google.android.gms.internal;

import com.google.android.gms.internal.jl.C3002a;
import java.util.Iterator;

public class jm implements jl {
    private final jj f9536a;
    private final jy f9537b;
    private final ke f9538c;
    private final ke f9539d;

    public jm(jd jdVar) {
        this.f9536a = new jj(jdVar.m11860i());
        this.f9537b = jdVar.m11860i();
        this.f9538c = m11928a(jdVar);
        this.f9539d = m11929b(jdVar);
    }

    private static ke m11928a(jd jdVar) {
        if (!jdVar.m11852a()) {
            return jdVar.m11860i().m12101a();
        }
        return jdVar.m11860i().mo3809a(jdVar.m11854c(), jdVar.m11853b());
    }

    private static ke m11929b(jd jdVar) {
        if (!jdVar.m11855d()) {
            return jdVar.m11860i().mo3811b();
        }
        return jdVar.m11860i().mo3809a(jdVar.m11857f(), jdVar.m11856e());
    }

    public jl mo3759a() {
        return this.f9536a;
    }

    public jz mo3760a(jz jzVar, js jsVar, kf kfVar, hh hhVar, C3002a c3002a, ji jiVar) {
        return this.f9536a.mo3760a(jzVar, jsVar, !m11934a(new ke(jsVar, kfVar)) ? jx.m12080j() : kfVar, hhVar, c3002a, jiVar);
    }

    public jz mo3761a(jz jzVar, jz jzVar2, ji jiVar) {
        jz a;
        if (jzVar2.m12112a().mo3782e()) {
            a = jz.m12108a(jx.m12080j(), this.f9537b);
        } else {
            jz b = jzVar2.m12114b(kj.m12190a());
            Iterator it = jzVar2.iterator();
            a = b;
            while (it.hasNext()) {
                ke keVar = (ke) it.next();
                a = !m11934a(keVar) ? a.m12111a(keVar.m12169c(), jx.m12080j()) : a;
            }
        }
        return this.f9536a.mo3761a(jzVar, a, jiVar);
    }

    public jz mo3762a(jz jzVar, kf kfVar) {
        return jzVar;
    }

    public boolean m11934a(ke keVar) {
        return this.f9537b.compare(m11937d(), keVar) <= 0 && this.f9537b.compare(keVar, m11938e()) <= 0;
    }

    public jy mo3763b() {
        return this.f9537b;
    }

    public boolean mo3764c() {
        return true;
    }

    public ke m11937d() {
        return this.f9538c;
    }

    public ke m11938e() {
        return this.f9539d;
    }
}
