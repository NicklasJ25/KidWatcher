package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import com.google.android.gms.internal.jf.C3001a;
import com.google.firebase.database.C3536b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class hq {
    static final /* synthetic */ boolean f9296a = (!hq.class.desiredAssertionStatus());
    private final Map<jd, jf> f9297b = new HashMap();
    private final im f9298c;

    public hq(im imVar) {
        this.f9298c = imVar;
    }

    private List<iy> m11503a(jf jfVar, C2978if c2978if, hz hzVar, kf kfVar) {
        C3001a a = jfVar.m11876a(c2978if, hzVar, kfVar);
        if (!jfVar.m11875a().m11873e()) {
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            for (ix ixVar : a.f9509b) {
                C2995a b = ixVar.m11834b();
                if (b == C2995a.CHILD_ADDED) {
                    hashSet2.add(ixVar.m11833a());
                } else if (b == C2995a.CHILD_REMOVED) {
                    hashSet.add(ixVar.m11833a());
                }
            }
            if (!(hashSet2.isEmpty() && hashSet.isEmpty())) {
                this.f9298c.mo3750a(jfVar.m11875a(), hashSet2, hashSet);
            }
        }
        return a.f9508a;
    }

    public jf m11504a(je jeVar) {
        return jeVar.m11873e() ? m11513d() : (jf) this.f9297b.get(jeVar.m11870b());
    }

    public kf m11505a(hh hhVar) {
        for (jf jfVar : this.f9297b.values()) {
            if (jfVar.m11877a(hhVar) != null) {
                return jfVar.m11877a(hhVar);
            }
        }
        return null;
    }

    public lf<List<je>, List<iz>> m11506a(je jeVar, hc hcVar, C3536b c3536b) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        boolean c = m11512c();
        jf jfVar;
        if (jeVar.m11872d()) {
            Iterator it = this.f9297b.entrySet().iterator();
            while (it.hasNext()) {
                jfVar = (jf) ((Entry) it.next()).getValue();
                arrayList2.addAll(jfVar.m11878a(hcVar, c3536b));
                if (jfVar.m11883d()) {
                    it.remove();
                    if (!jfVar.m11875a().m11873e()) {
                        arrayList.add(jfVar.m11875a());
                    }
                }
            }
        } else {
            jfVar = (jf) this.f9297b.get(jeVar.m11870b());
            if (jfVar != null) {
                arrayList2.addAll(jfVar.m11878a(hcVar, c3536b));
                if (jfVar.m11883d()) {
                    this.f9297b.remove(jeVar.m11870b());
                    if (!jfVar.m11875a().m11873e()) {
                        arrayList.add(jfVar.m11875a());
                    }
                }
            }
        }
        if (c && !m11512c()) {
            arrayList.add(je.m11867a(jeVar.m11869a()));
        }
        return new lf(arrayList, arrayList2);
    }

    public List<iy> m11507a(hc hcVar, hz hzVar, iv ivVar) {
        je a = hcVar.mo3728a();
        jf jfVar = (jf) this.f9297b.get(a.m11870b());
        if (jfVar == null) {
            boolean z;
            kf a2 = hzVar.m11632a(ivVar.m11815a() ? ivVar.m11819c() : null);
            if (a2 != null) {
                z = true;
            } else {
                a2 = hzVar.m11635b(ivVar.m11819c());
                z = false;
            }
            jf jfVar2 = new jf(a, new jg(new iv(jz.m12108a(a2, a.m11871c()), z, false), ivVar));
            if (!a.m11873e()) {
                Set hashSet = new HashSet();
                for (ke c : jfVar2.m11882c()) {
                    hashSet.add(c.m12169c());
                }
                this.f9298c.mo3749a(a, hashSet);
            }
            this.f9297b.put(a.m11870b(), jfVar2);
            jfVar = jfVar2;
        }
        jfVar.m11879a(hcVar);
        return jfVar.m11881b(hcVar);
    }

    public List<iy> m11508a(C2978if c2978if, hz hzVar, kf kfVar) {
        jd d = c2978if.m11649d().m11661d();
        if (d != null) {
            jf jfVar = (jf) this.f9297b.get(d);
            if (f9296a || jfVar != null) {
                return m11503a(jfVar, c2978if, hzVar, kfVar);
            }
            throw new AssertionError();
        }
        List<iy> arrayList = new ArrayList();
        for (Entry value : this.f9297b.entrySet()) {
            arrayList.addAll(m11503a((jf) value.getValue(), c2978if, hzVar, kfVar));
        }
        return arrayList;
    }

    public boolean m11509a() {
        return this.f9297b.isEmpty();
    }

    public List<jf> m11510b() {
        List<jf> arrayList = new ArrayList();
        for (Entry value : this.f9297b.entrySet()) {
            jf jfVar = (jf) value.getValue();
            if (!jfVar.m11875a().m11873e()) {
                arrayList.add(jfVar);
            }
        }
        return arrayList;
    }

    public boolean m11511b(je jeVar) {
        return m11504a(jeVar) != null;
    }

    public boolean m11512c() {
        return m11513d() != null;
    }

    public jf m11513d() {
        for (Entry value : this.f9297b.entrySet()) {
            jf jfVar = (jf) value.getValue();
            if (jfVar.m11875a().m11873e()) {
                return jfVar;
            }
        }
        return null;
    }
}
