package com.google.android.gms.internal;

import com.google.android.gms.internal.ir.C2875a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class gx implements Iterable<Entry<hh, kf>> {
    static final /* synthetic */ boolean f9156a = (!gx.class.desiredAssertionStatus());
    private static final gx f9157b = new gx(new ir(null));
    private final ir<kf> f9158c;

    private gx(ir<kf> irVar) {
        this.f9158c = irVar;
    }

    public static gx m11275a() {
        return f9157b;
    }

    public static gx m11276a(Map<String, Object> map) {
        ir a = ir.m11778a();
        ir irVar = a;
        for (Entry entry : map.entrySet()) {
            irVar = irVar.m11782a(new hh((String) entry.getKey()), new ir(kg.m12177a(entry.getValue())));
        }
        return new gx(irVar);
    }

    private kf m11277a(hh hhVar, ir<kf> irVar, kf kfVar) {
        if (irVar.m11788b() != null) {
            return kfVar.mo3773a(hhVar, (kf) irVar.m11788b());
        }
        kf kfVar2 = null;
        Iterator it = irVar.m11791c().iterator();
        kf kfVar3 = kfVar;
        while (it.hasNext()) {
            kf a;
            kf kfVar4;
            Entry entry = (Entry) it.next();
            ir irVar2 = (ir) entry.getValue();
            js jsVar = (js) entry.getKey();
            if (!jsVar.m12011e()) {
                a = m11277a(hhVar.m11382a(jsVar), irVar2, kfVar3);
                kfVar4 = kfVar2;
            } else if (f9156a || irVar2.m11788b() != null) {
                kfVar4 = (kf) irVar2.m11788b();
                a = kfVar3;
            } else {
                throw new AssertionError("Priority writes must always be leaf nodes");
            }
            kfVar2 = kfVar4;
            kfVar3 = a;
        }
        return (kfVar3.mo3772a(hhVar).mo3778b() || kfVar2 == null) ? kfVar3 : kfVar3.mo3773a(hhVar.m11382a(js.m12008c()), kfVar2);
    }

    public static gx m11278b(Map<hh, kf> map) {
        ir a = ir.m11778a();
        ir irVar = a;
        for (Entry entry : map.entrySet()) {
            irVar = irVar.m11782a((hh) entry.getKey(), new ir((kf) entry.getValue()));
        }
        return new gx(irVar);
    }

    public gx m11279a(hh hhVar) {
        return hhVar.m11391h() ? f9157b : new gx(this.f9158c.m11782a(hhVar, ir.m11778a()));
    }

    public gx m11280a(final hh hhVar, gx gxVar) {
        return (gx) gxVar.f9158c.m11785a((Object) this, new C2875a<kf, gx>(this) {
            public gx m11271a(hh hhVar, kf kfVar, gx gxVar) {
                return gxVar.m11281a(hhVar.m11381a(hhVar), kfVar);
            }
        });
    }

    public gx m11281a(hh hhVar, kf kfVar) {
        if (hhVar.m11391h()) {
            return new gx(new ir(kfVar));
        }
        hh a = this.f9158c.m11780a(hhVar);
        if (a != null) {
            hh a2 = hh.m11377a(a, hhVar);
            kf kfVar2 = (kf) this.f9158c.m11796e(a);
            js g = a2.m11390g();
            if (g != null && g.m12011e() && kfVar2.mo3772a(a2.m11389f()).mo3778b()) {
                return this;
            }
            return new gx(this.f9158c.m11783a(a, kfVar2.mo3773a(a2, kfVar)));
        }
        return new gx(this.f9158c.m11782a(hhVar, new ir(kfVar)));
    }

    public gx m11282a(js jsVar, kf kfVar) {
        return m11281a(new hh(jsVar), kfVar);
    }

    public kf m11283a(kf kfVar) {
        return m11277a(hh.m11376a(), this.f9158c, kfVar);
    }

    public Map<String, Object> m11284a(final boolean z) {
        final Map<String, Object> hashMap = new HashMap();
        this.f9158c.m11786a(new C2875a<kf, Void>(this) {
            public Void m11274a(hh hhVar, kf kfVar, Void voidR) {
                hashMap.put(hhVar.m11383b(), kfVar.mo3775a(z));
                return null;
            }
        });
        return hashMap;
    }

    public kf m11285b() {
        return (kf) this.f9158c.m11788b();
    }

    public boolean m11286b(hh hhVar) {
        return m11287c(hhVar) != null;
    }

    public kf m11287c(hh hhVar) {
        hh a = this.f9158c.m11780a(hhVar);
        return a != null ? ((kf) this.f9158c.m11796e(a)).mo3772a(hh.m11377a(a, hhVar)) : null;
    }

    public List<ke> m11288c() {
        List<ke> arrayList = new ArrayList();
        if (this.f9158c.m11788b() != null) {
            for (ke keVar : (kf) this.f9158c.m11788b()) {
                arrayList.add(new ke(keVar.m12169c(), keVar.m12170d()));
            }
        } else {
            Iterator it = this.f9158c.m11791c().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                ir irVar = (ir) entry.getValue();
                if (irVar.m11788b() != null) {
                    arrayList.add(new ke((js) entry.getKey(), (kf) irVar.m11788b()));
                }
            }
        }
        return arrayList;
    }

    public gx m11289d(hh hhVar) {
        if (hhVar.m11391h()) {
            return this;
        }
        kf c = m11287c(hhVar);
        return c != null ? new gx(new ir(c)) : new gx(this.f9158c.m11792c(hhVar));
    }

    public Map<js, gx> m11290d() {
        Map<js, gx> hashMap = new HashMap();
        Iterator it = this.f9158c.m11791c().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put((js) entry.getKey(), new gx((ir) entry.getValue()));
        }
        return hashMap;
    }

    public boolean m11291e() {
        return this.f9158c.m11795d();
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || obj.getClass() != getClass()) ? false : ((gx) obj).m11284a(true).equals(m11284a(true));
    }

    public int hashCode() {
        return m11284a(true).hashCode();
    }

    public Iterator<Entry<hh, kf>> iterator() {
        return this.f9158c.iterator();
    }

    public String toString() {
        String valueOf = String.valueOf(m11284a(true).toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 15).append("CompoundWrite{").append(valueOf).append("}").toString();
    }
}
