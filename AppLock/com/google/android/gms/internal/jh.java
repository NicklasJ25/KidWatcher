package com.google.android.gms.internal;

import com.google.android.gms.internal.jl.C3002a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class jh {
    static final /* synthetic */ boolean f9524a = (!jh.class.desiredAssertionStatus());
    private static C3002a f9525c = new C30031();
    private final jl f9526b;

    class C30031 implements C3002a {
        C30031() {
        }

        public ke mo3757a(jy jyVar, ke keVar, boolean z) {
            return null;
        }

        public kf mo3758a(js jsVar) {
            return null;
        }
    }

    public static class C3005a {
        public final jg f9519a;
        public final List<ix> f9520b;

        public C3005a(jg jgVar, List<ix> list) {
            this.f9519a = jgVar;
            this.f9520b = list;
        }
    }

    private static class C3006b implements C3002a {
        private final hz f9521a;
        private final jg f9522b;
        private final kf f9523c;

        public C3006b(hz hzVar, jg jgVar, kf kfVar) {
            this.f9521a = hzVar;
            this.f9522b = jgVar;
            this.f9523c = kfVar;
        }

        public ke mo3757a(jy jyVar, ke keVar, boolean z) {
            return this.f9521a.m11628a(this.f9523c != null ? this.f9523c : this.f9522b.m11889d(), keVar, z, jyVar);
        }

        public kf mo3758a(js jsVar) {
            iv a = this.f9522b.m11884a();
            if (a.m11817a(jsVar)) {
                return a.m11819c().mo3780c(jsVar);
            }
            return this.f9521a.m11631a(jsVar, this.f9523c != null ? new iv(jz.m12108a(this.f9523c, ka.m12154d()), true, false) : this.f9522b.m11888c());
        }
    }

    public jh(jl jlVar) {
        this.f9526b = jlVar;
    }

    private jg m11896a(jg jgVar, hh hhVar, gx gxVar, hz hzVar, kf kfVar, ji jiVar) {
        if (f9524a || gxVar.m11285b() == null) {
            Entry entry;
            hh a;
            Iterator it = gxVar.iterator();
            jg jgVar2 = jgVar;
            while (it.hasNext()) {
                entry = (Entry) it.next();
                a = hhVar.m11381a((hh) entry.getKey());
                if (m11903a(jgVar, a.m11387d())) {
                    jgVar2 = m11900a(jgVar2, a, (kf) entry.getValue(), hzVar, kfVar, jiVar);
                }
            }
            it = gxVar.iterator();
            while (it.hasNext()) {
                entry = (Entry) it.next();
                a = hhVar.m11381a((hh) entry.getKey());
                if (!m11903a(jgVar, a.m11387d())) {
                    jgVar2 = m11900a(jgVar2, a, (kf) entry.getValue(), hzVar, kfVar, jiVar);
                }
            }
            return jgVar2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private jg m11897a(jg jgVar, hh hhVar, gx gxVar, hz hzVar, kf kfVar, boolean z, ji jiVar) {
        if (jgVar.m11888c().m11819c().mo3778b() && !jgVar.m11888c().m11815a()) {
            return jgVar;
        }
        if (f9524a || gxVar.m11285b() == null) {
            js jsVar;
            if (!hhVar.m11391h()) {
                gxVar = gx.m11275a().m11280a(hhVar, gxVar);
            }
            kf c = jgVar.m11888c().m11819c();
            Map d = gxVar.m11290d();
            jg jgVar2 = jgVar;
            for (Entry entry : d.entrySet()) {
                jsVar = (js) entry.getKey();
                if (c.mo3776a(jsVar)) {
                    jgVar2 = m11901a(jgVar2, new hh(jsVar), ((gx) entry.getValue()).m11283a(c.mo3780c(jsVar)), hzVar, kfVar, z, jiVar);
                }
            }
            for (Entry entry2 : d.entrySet()) {
                jsVar = (js) entry2.getKey();
                Object obj = (jgVar.m11888c().m11817a(jsVar) || ((gx) entry2.getValue()).m11285b() != null) ? null : 1;
                if (!c.mo3776a(jsVar) && obj == null) {
                    jgVar2 = m11901a(jgVar2, new hh(jsVar), ((gx) entry2.getValue()).m11283a(c.mo3780c(jsVar)), hzVar, kfVar, z, jiVar);
                }
            }
            return jgVar2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private jg m11898a(jg jgVar, hh hhVar, hz hzVar, C3002a c3002a, ji jiVar) {
        iv a = jgVar.m11884a();
        if (hzVar.m11629a(hhVar) != null) {
            return jgVar;
        }
        jz a2;
        kf a3;
        if (!hhVar.m11391h()) {
            js d = hhVar.m11387d();
            if (!d.m12011e()) {
                kf a4;
                hh e = hhVar.m11388e();
                if (a.m11817a(d)) {
                    a3 = hzVar.m11630a(hhVar, a.m11819c(), jgVar.m11888c().m11819c());
                    a4 = a3 != null ? a.m11819c().mo3780c(d).mo3773a(e, a3) : a.m11819c().mo3780c(d);
                } else {
                    a4 = hzVar.m11631a(d, jgVar.m11888c());
                }
                a2 = a4 != null ? this.f9526b.mo3760a(a.m11820d(), d, a4, e, c3002a, jiVar) : a.m11820d();
            } else if (f9524a || hhVar.m11392i() == 1) {
                a3 = hzVar.m11630a(hhVar, a.m11819c(), jgVar.m11888c().m11819c());
                a2 = a3 != null ? this.f9526b.mo3762a(a.m11820d(), a3) : a.m11820d();
            } else {
                throw new AssertionError("Can't have a priority with additional path components");
            }
        } else if (f9524a || jgVar.m11888c().m11815a()) {
            if (jgVar.m11888c().m11818b()) {
                a3 = jgVar.m11889d();
                if (!(a3 instanceof jt)) {
                    a3 = jx.m12080j();
                }
                a3 = hzVar.m11635b(a3);
            } else {
                a3 = hzVar.m11632a(jgVar.m11889d());
            }
            a2 = this.f9526b.mo3761a(jgVar.m11884a().m11820d(), jz.m12108a(a3, this.f9526b.mo3763b()), jiVar);
        } else {
            throw new AssertionError("If change path is empty, we must have complete server data");
        }
        boolean z = a.m11815a() || hhVar.m11391h();
        return jgVar.m11885a(a2, z, this.f9526b.mo3764c());
    }

    private jg m11899a(jg jgVar, hh hhVar, ir<Boolean> irVar, hz hzVar, kf kfVar, ji jiVar) {
        if (hzVar.m11629a(hhVar) != null) {
            return jgVar;
        }
        boolean b = jgVar.m11888c().m11818b();
        iv c = jgVar.m11888c();
        gx a;
        if (irVar.m11788b() == null) {
            a = gx.m11275a();
            Iterator it = irVar.iterator();
            while (it.hasNext()) {
                hh hhVar2 = (hh) ((Entry) it.next()).getKey();
                hh a2 = hhVar.m11381a(hhVar2);
                if (c.m11816a(a2)) {
                    a = a.m11281a(hhVar2, c.m11819c().mo3772a(a2));
                }
            }
            return m11897a(jgVar, hhVar, a, hzVar, kfVar, b, jiVar);
        } else if ((hhVar.m11391h() && c.m11815a()) || c.m11816a(hhVar)) {
            return m11901a(jgVar, hhVar, c.m11819c().mo3772a(hhVar), hzVar, kfVar, b, jiVar);
        } else if (!hhVar.m11391h()) {
            return jgVar;
        } else {
            a = gx.m11275a();
            for (ke keVar : c.m11819c()) {
                a = a.m11282a(keVar.m12169c(), keVar.m12170d());
            }
            return m11897a(jgVar, hhVar, a, hzVar, kfVar, b, jiVar);
        }
    }

    private jg m11900a(jg jgVar, hh hhVar, kf kfVar, hz hzVar, kf kfVar2, ji jiVar) {
        iv a = jgVar.m11884a();
        C3002a c3006b = new C3006b(hzVar, jgVar, kfVar2);
        if (hhVar.m11391h()) {
            return jgVar.m11885a(this.f9526b.mo3761a(jgVar.m11884a().m11820d(), jz.m12108a(kfVar, this.f9526b.mo3763b()), jiVar), true, this.f9526b.mo3764c());
        }
        js d = hhVar.m11387d();
        if (d.m12011e()) {
            return jgVar.m11885a(this.f9526b.mo3762a(jgVar.m11884a().m11820d(), kfVar), a.m11815a(), a.m11818b());
        }
        kf kfVar3;
        hh e = hhVar.m11388e();
        kf c = a.m11819c().mo3780c(d);
        if (e.m11391h()) {
            kfVar3 = kfVar;
        } else {
            kfVar3 = c3006b.mo3758a(d);
            if (kfVar3 == null) {
                kfVar3 = jx.m12080j();
            } else if (!(e.m11390g().m12011e() && kfVar3.mo3772a(e.m11389f()).mo3778b())) {
                kfVar3 = kfVar3.mo3773a(e, kfVar);
            }
        }
        return !c.equals(kfVar3) ? jgVar.m11885a(this.f9526b.mo3760a(a.m11820d(), d, kfVar3, e, c3006b, jiVar), a.m11815a(), this.f9526b.mo3764c()) : jgVar;
    }

    private jg m11901a(jg jgVar, hh hhVar, kf kfVar, hz hzVar, kf kfVar2, boolean z, ji jiVar) {
        jz a;
        iv c = jgVar.m11888c();
        jl a2 = z ? this.f9526b : this.f9526b.mo3759a();
        if (hhVar.m11391h()) {
            a = a2.mo3761a(c.m11820d(), jz.m12108a(kfVar, a2.mo3763b()), null);
        } else if (!a2.mo3764c() || c.m11818b()) {
            js d = hhVar.m11387d();
            if (!c.m11816a(hhVar) && hhVar.m11392i() > 1) {
                return jgVar;
            }
            hh e = hhVar.m11388e();
            kf a3 = c.m11819c().mo3780c(d).mo3773a(e, kfVar);
            a = d.m12011e() ? a2.mo3762a(c.m11820d(), a3) : a2.mo3760a(c.m11820d(), d, a3, e, f9525c, null);
        } else if (f9524a || !hhVar.m11391h()) {
            js d2 = hhVar.m11387d();
            a = a2.mo3761a(c.m11820d(), c.m11820d().m12111a(d2, c.m11819c().mo3780c(d2).mo3773a(hhVar.m11388e(), kfVar)), null);
        } else {
            throw new AssertionError("An empty path should have been caught in the other branch");
        }
        boolean z2 = c.m11815a() || hhVar.m11391h();
        jg b = jgVar.m11886b(a, z2, a2.mo3764c());
        return m11898a(b, hhVar, hzVar, new C3006b(hzVar, b, kfVar2), jiVar);
    }

    private void m11902a(jg jgVar, jg jgVar2, List<ix> list) {
        iv a = jgVar2.m11884a();
        if (a.m11815a()) {
            Object obj = (a.m11819c().mo3782e() || a.m11819c().mo3778b()) ? 1 : null;
            if (!list.isEmpty() || !jgVar.m11884a().m11815a() || ((obj != null && !a.m11819c().equals(jgVar.m11887b())) || !a.m11819c().mo3783f().equals(jgVar.m11887b().mo3783f()))) {
                list.add(ix.m11828a(a.m11820d()));
            }
        }
    }

    private static boolean m11903a(jg jgVar, js jsVar) {
        return jgVar.m11884a().m11817a(jsVar);
    }

    private jg m11904b(jg jgVar, hh hhVar, hz hzVar, kf kfVar, ji jiVar) {
        iv c = jgVar.m11888c();
        jz d = c.m11820d();
        boolean z = c.m11815a() || hhVar.m11391h();
        return m11898a(jgVar.m11886b(d, z, c.m11818b()), hhVar, hzVar, f9525c, jiVar);
    }

    public jg m11905a(jg jgVar, hh hhVar, hz hzVar, kf kfVar, ji jiVar) {
        if (hzVar.m11629a(hhVar) != null) {
            return jgVar;
        }
        C3002a c3006b = new C3006b(hzVar, jgVar, kfVar);
        jz d = jgVar.m11884a().m11820d();
        if (hhVar.m11391h() || hhVar.m11387d().m12011e()) {
            d = this.f9526b.mo3761a(d, jz.m12108a(jgVar.m11888c().m11815a() ? hzVar.m11632a(jgVar.m11889d()) : hzVar.m11635b(jgVar.m11888c().m11819c()), this.f9526b.mo3763b()), jiVar);
        } else {
            js d2 = hhVar.m11387d();
            kf a = hzVar.m11631a(d2, jgVar.m11888c());
            if (a == null && jgVar.m11888c().m11817a(d2)) {
                a = d.m12112a().mo3780c(d2);
            }
            if (a != null) {
                d = this.f9526b.mo3760a(d, d2, a, hhVar.m11388e(), c3006b, jiVar);
            } else if (a == null && jgVar.m11884a().m11819c().mo3776a(d2)) {
                d = this.f9526b.mo3760a(d, d2, jx.m12080j(), hhVar.m11388e(), c3006b, jiVar);
            }
            if (d.m12112a().mo3778b() && jgVar.m11888c().m11815a()) {
                kf a2 = hzVar.m11632a(jgVar.m11889d());
                if (a2.mo3782e()) {
                    d = this.f9526b.mo3761a(d, jz.m12108a(a2, this.f9526b.mo3763b()), jiVar);
                }
            }
        }
        boolean z = jgVar.m11888c().m11815a() || hzVar.m11629a(hh.m11376a()) != null;
        return jgVar.m11885a(d, z, this.f9526b.mo3764c());
    }

    public C3005a m11906a(jg jgVar, C2978if c2978if, hz hzVar, kf kfVar) {
        jg a;
        ji jiVar = new ji();
        boolean z;
        switch (c2978if.m11650e()) {
            case Overwrite:
                ih ihVar = (ih) c2978if;
                if (ihVar.m11649d().m11658a()) {
                    a = m11900a(jgVar, ihVar.m11648c(), ihVar.m11663a(), hzVar, kfVar, jiVar);
                    break;
                } else if (f9524a || ihVar.m11649d().m11659b()) {
                    z = ihVar.m11649d().m11660c() || (jgVar.m11888c().m11818b() && !ihVar.m11648c().m11391h());
                    a = m11901a(jgVar, ihVar.m11648c(), ihVar.m11663a(), hzVar, kfVar, z, jiVar);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case Merge:
                ie ieVar = (ie) c2978if;
                if (ieVar.m11649d().m11658a()) {
                    a = m11896a(jgVar, ieVar.m11648c(), ieVar.m11655a(), hzVar, kfVar, jiVar);
                    break;
                } else if (f9524a || ieVar.m11649d().m11659b()) {
                    z = ieVar.m11649d().m11660c() || jgVar.m11888c().m11818b();
                    a = m11897a(jgVar, ieVar.m11648c(), ieVar.m11655a(), hzVar, kfVar, z, jiVar);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case AckUserWrite:
                ic icVar = (ic) c2978if;
                if (!icVar.m11653b()) {
                    a = m11899a(jgVar, icVar.m11648c(), icVar.m11652a(), hzVar, kfVar, jiVar);
                    break;
                }
                a = m11905a(jgVar, icVar.m11648c(), hzVar, kfVar, jiVar);
                break;
            case ListenComplete:
                a = m11904b(jgVar, c2978if.m11648c(), hzVar, kfVar, jiVar);
                break;
            default:
                String valueOf = String.valueOf(c2978if.m11650e());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        List arrayList = new ArrayList(jiVar.m11907a());
        m11902a(jgVar, a, arrayList);
        return new C3005a(a, arrayList);
    }
}
