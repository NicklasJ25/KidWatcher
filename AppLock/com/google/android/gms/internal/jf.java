package com.google.android.gms.internal;

import com.google.android.gms.internal.C2978if.C2979a;
import com.google.android.gms.internal.jh.C3005a;
import com.google.firebase.database.C3536b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class jf {
    static final /* synthetic */ boolean f9510a = (!jf.class.desiredAssertionStatus());
    private final je f9511b;
    private final jh f9512c;
    private jg f9513d;
    private final List<hc> f9514e = new ArrayList();
    private final ja f9515f;

    public static class C3001a {
        public final List<iy> f9508a;
        public final List<ix> f9509b;

        public C3001a(List<iy> list, List<ix> list2) {
            this.f9508a = list;
            this.f9509b = list2;
        }
    }

    public jf(je jeVar, jg jgVar) {
        this.f9511b = jeVar;
        jj jjVar = new jj(jeVar.m11871c());
        jl o = jeVar.m11870b().m11866o();
        this.f9512c = new jh(o);
        iv c = jgVar.m11888c();
        iv a = jgVar.m11884a();
        jz a2 = jz.m12108a(jx.m12080j(), jeVar.m11871c());
        jz a3 = jjVar.mo3761a(a2, c.m11820d(), null);
        a2 = o.mo3761a(a2, a.m11820d(), null);
        this.f9513d = new jg(new iv(a2, a.m11815a(), o.mo3764c()), new iv(a3, c.m11815a(), jjVar.mo3764c()));
        this.f9515f = new ja(jeVar);
    }

    private List<iy> m11874a(List<ix> list, jz jzVar, hc hcVar) {
        List list2;
        if (hcVar == null) {
            list2 = this.f9514e;
        } else {
            list2 = Arrays.asList(new hc[]{hcVar});
        }
        return this.f9515f.m11846a((List) list, jzVar, list2);
    }

    public je m11875a() {
        return this.f9511b;
    }

    public C3001a m11876a(C2978if c2978if, hz hzVar, kf kfVar) {
        if (c2978if.m11650e() == C2979a.Merge && c2978if.m11649d().m11661d() != null) {
            if (!f9510a && this.f9513d.m11889d() == null) {
                throw new AssertionError("We should always have a full cache before handling merges");
            } else if (!f9510a && this.f9513d.m11887b() == null) {
                throw new AssertionError("Missing event cache, even though we have a server cache");
            }
        }
        jg jgVar = this.f9513d;
        C3005a a = this.f9512c.m11906a(jgVar, c2978if, hzVar, kfVar);
        if (f9510a || a.f9519a.m11888c().m11815a() || !jgVar.m11888c().m11815a()) {
            this.f9513d = a.f9519a;
            return new C3001a(m11874a(a.f9520b, a.f9519a.m11884a().m11820d(), null), a.f9520b);
        }
        throw new AssertionError("Once a server snap is complete, it should never go back");
    }

    public kf m11877a(hh hhVar) {
        kf d = this.f9513d.m11889d();
        return (d == null || (!this.f9511b.m11873e() && (hhVar.m11391h() || d.mo3780c(hhVar.m11387d()).mo3778b()))) ? null : d.mo3772a(hhVar);
    }

    public List<iz> m11878a(hc hcVar, C3536b c3536b) {
        List<iz> list;
        if (c3536b != null) {
            List<iz> arrayList = new ArrayList();
            if (f9510a || hcVar == null) {
                hh a = this.f9511b.m11869a();
                for (hc iwVar : this.f9514e) {
                    hc iwVar2;
                    arrayList.add(new iw(iwVar2, c3536b, a));
                }
                list = arrayList;
            } else {
                throw new AssertionError("A cancel should cancel all event registrations");
            }
        }
        list = Collections.emptyList();
        if (hcVar != null) {
            int i = 0;
            int i2 = -1;
            while (i < this.f9514e.size()) {
                iwVar2 = (hc) this.f9514e.get(i);
                if (iwVar2.mo3731a(hcVar)) {
                    if (iwVar2.m11343c()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            i = i2;
            if (i != -1) {
                iwVar2 = (hc) this.f9514e.get(i);
                this.f9514e.remove(i);
                iwVar2.m11342b();
            }
        } else {
            for (hc iwVar22 : this.f9514e) {
                iwVar22.m11342b();
            }
            this.f9514e.clear();
        }
        return list;
    }

    public void m11879a(hc hcVar) {
        this.f9514e.add(hcVar);
    }

    public kf m11880b() {
        return this.f9513d.m11888c().m11819c();
    }

    public List<iy> m11881b(hc hcVar) {
        iv a = this.f9513d.m11884a();
        List arrayList = new ArrayList();
        for (ke keVar : a.m11819c()) {
            arrayList.add(ix.m11826a(keVar.m12169c(), keVar.m12170d()));
        }
        if (a.m11815a()) {
            arrayList.add(ix.m11828a(a.m11820d()));
        }
        return m11874a(arrayList, a.m11820d(), hcVar);
    }

    public kf m11882c() {
        return this.f9513d.m11884a().m11819c();
    }

    public boolean m11883d() {
        return this.f9514e.isEmpty();
    }
}
