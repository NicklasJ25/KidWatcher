package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class kk {
    static final /* synthetic */ boolean f9631a = (!kk.class.desiredAssertionStatus());
    private final hh f9632b;
    private final hh f9633c;
    private final kf f9634d;

    public kk(gr grVar) {
        hh hhVar = null;
        List a = grVar.m11210a();
        this.f9632b = a != null ? new hh(a) : null;
        List b = grVar.m11211b();
        if (b != null) {
            hhVar = new hh(b);
        }
        this.f9633c = hhVar;
        this.f9634d = kg.m12177a(grVar.m11212c());
    }

    private kf m12193a(hh hhVar, kf kfVar, kf kfVar2) {
        Object obj = 1;
        int c = this.f9632b == null ? 1 : hhVar.m11385c(this.f9632b);
        int c2 = this.f9633c == null ? -1 : hhVar.m11385c(this.f9633c);
        Object obj2 = (this.f9632b == null || !hhVar.m11384b(this.f9632b)) ? null : 1;
        if (this.f9633c == null || !hhVar.m11384b(this.f9633c)) {
            obj = null;
        }
        if (c > 0 && c2 < 0 && r1 == null) {
            return kfVar2;
        }
        if (c > 0 && r1 != null && kfVar2.mo3782e()) {
            return kfVar2;
        }
        if (c <= 0 || c2 != 0) {
            if (obj2 != null || r1 != null) {
                Collection hashSet = new HashSet();
                for (ke c3 : kfVar) {
                    hashSet.add(c3.m12169c());
                }
                for (ke c32 : kfVar2) {
                    hashSet.add(c32.m12169c());
                }
                List<js> arrayList = new ArrayList(hashSet.size() + 1);
                arrayList.addAll(hashSet);
                if (!(kfVar2.mo3783f().mo3778b() && kfVar.mo3783f().mo3778b())) {
                    arrayList.add(js.m12008c());
                }
                kf kfVar3 = kfVar;
                for (js jsVar : arrayList) {
                    kf c4 = kfVar.mo3780c(jsVar);
                    kf a = m12193a(hhVar.m11382a(jsVar), kfVar.mo3780c(jsVar), kfVar2.mo3780c(jsVar));
                    kfVar3 = a != c4 ? kfVar3.mo3774a(jsVar, a) : kfVar3;
                }
                return kfVar3;
            } else if (f9631a || c2 > 0 || c <= 0) {
                return kfVar;
            } else {
                throw new AssertionError();
            }
        } else if (!f9631a && r1 == null) {
            throw new AssertionError();
        } else if (f9631a || !kfVar2.mo3782e()) {
            return kfVar.mo3782e() ? jx.m12080j() : kfVar;
        } else {
            throw new AssertionError();
        }
    }

    public kf m12194a(kf kfVar) {
        return m12193a(hh.m11376a(), kfVar, this.f9634d);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9632b);
        String valueOf2 = String.valueOf(this.f9633c);
        String valueOf3 = String.valueOf(this.f9634d);
        return new StringBuilder(((String.valueOf(valueOf).length() + 55) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("RangeMerge{optExclusiveStart=").append(valueOf).append(", optInclusiveEnd=").append(valueOf2).append(", snap=").append(valueOf3).append("}").toString();
    }
}
