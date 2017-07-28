package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ja {
    private final je f9485a;
    private final jy f9486b;

    class C29971 implements Comparator<ix> {
        static final /* synthetic */ boolean f9483a = (!ja.class.desiredAssertionStatus());
        final /* synthetic */ ja f9484b;

        C29971(ja jaVar) {
            this.f9484b = jaVar;
        }

        public int m11841a(ix ixVar, ix ixVar2) {
            if (f9483a || !(ixVar.m11833a() == null || ixVar2.m11833a() == null)) {
                return this.f9484b.f9486b.compare(new ke(ixVar.m11833a(), ixVar.m11835c().m12112a()), new ke(ixVar2.m11833a(), ixVar2.m11835c().m12112a()));
            }
            throw new AssertionError();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11841a((ix) obj, (ix) obj2);
        }
    }

    public ja(je jeVar) {
        this.f9485a = jeVar;
        this.f9486b = jeVar.m11871c();
    }

    private iy m11842a(ix ixVar, hc hcVar, jz jzVar) {
        if (!(ixVar.m11834b().equals(C2995a.VALUE) || ixVar.m11834b().equals(C2995a.CHILD_REMOVED))) {
            ixVar = ixVar.m11832a(jzVar.m12110a(ixVar.m11833a(), ixVar.m11835c().m12112a(), this.f9486b));
        }
        return hcVar.mo3727a(ixVar, this.f9485a);
    }

    private Comparator<ix> m11844a() {
        return new C29971(this);
    }

    private void m11845a(List<iy> list, C2995a c2995a, List<ix> list2, List<hc> list3, jz jzVar) {
        List<ix> arrayList = new ArrayList();
        for (ix ixVar : list2) {
            if (ixVar.m11834b().equals(c2995a)) {
                arrayList.add(ixVar);
            }
        }
        Collections.sort(arrayList, m11844a());
        for (ix ixVar2 : arrayList) {
            for (hc hcVar : list3) {
                if (hcVar.mo3732a(c2995a)) {
                    list.add(m11842a(ixVar2, hcVar, jzVar));
                }
            }
        }
    }

    public List<iy> m11846a(List<ix> list, jz jzVar, List<hc> list2) {
        List<iy> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (ix ixVar : list) {
            if (ixVar.m11834b().equals(C2995a.CHILD_CHANGED) && this.f9486b.m12104a(ixVar.m11836d().m12112a(), ixVar.m11835c().m12112a())) {
                arrayList2.add(ix.m11831c(ixVar.m11833a(), ixVar.m11835c()));
            }
        }
        m11845a(arrayList, C2995a.CHILD_REMOVED, list, list2, jzVar);
        m11845a(arrayList, C2995a.CHILD_ADDED, list, list2, jzVar);
        m11845a(arrayList, C2995a.CHILD_MOVED, arrayList2, list2, jzVar);
        m11845a(arrayList, C2995a.CHILD_CHANGED, list, list2, jzVar);
        m11845a(arrayList, C2995a.VALUE, list, list2, jzVar);
        return arrayList;
    }
}
