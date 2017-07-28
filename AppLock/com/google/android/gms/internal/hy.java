package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class hy {
    static final /* synthetic */ boolean f9380a = (!hy.class.desiredAssertionStatus());
    private static final is<hv> f9381e = new C29762();
    private gx f9382b = gx.m11275a();
    private List<hv> f9383c = new ArrayList();
    private Long f9384d = Long.valueOf(-1);

    class C29762 implements is<hv> {
        C29762() {
        }

        public boolean m11611a(hv hvVar) {
            return hvVar.m11592f();
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11611a((hv) obj);
        }
    }

    private static gx m11613a(List<hv> list, is<hv> isVar, hh hhVar) {
        gx a = gx.m11275a();
        gx gxVar = a;
        for (hv hvVar : list) {
            if (isVar.mo3733a(hvVar)) {
                hh b = hvVar.m11588b();
                if (hvVar.m11591e()) {
                    if (hhVar.m11384b(b)) {
                        a = gxVar.m11281a(hh.m11377a(hhVar, b), hvVar.m11589c());
                    } else if (b.m11384b(hhVar)) {
                        a = gxVar.m11281a(hh.m11376a(), hvVar.m11589c().mo3772a(hh.m11377a(b, hhVar)));
                    }
                    gxVar = a;
                } else {
                    if (hhVar.m11384b(b)) {
                        a = gxVar.m11280a(hh.m11377a(hhVar, b), hvVar.m11590d());
                    } else if (b.m11384b(hhVar)) {
                        b = hh.m11377a(b, hhVar);
                        if (b.m11391h()) {
                            a = gxVar.m11280a(hh.m11376a(), hvVar.m11590d());
                        } else {
                            kf c = hvVar.m11590d().m11287c(b);
                            if (c != null) {
                                a = gxVar.m11281a(hh.m11376a(), c);
                            }
                        }
                    }
                    gxVar = a;
                }
            }
            a = gxVar;
            gxVar = a;
        }
        return gxVar;
    }

    private void m11614a() {
        this.f9382b = m11613a(this.f9383c, f9381e, hh.m11376a());
        if (this.f9383c.size() > 0) {
            this.f9384d = Long.valueOf(((hv) this.f9383c.get(this.f9383c.size() - 1)).m11587a());
        } else {
            this.f9384d = Long.valueOf(-1);
        }
    }

    private boolean m11615a(hv hvVar, hh hhVar) {
        if (hvVar.m11591e()) {
            return hvVar.m11588b().m11384b(hhVar);
        }
        Iterator it = hvVar.m11590d().iterator();
        while (it.hasNext()) {
            if (hvVar.m11588b().m11381a((hh) ((Entry) it.next()).getKey()).m11384b(hhVar)) {
                return true;
            }
        }
        return false;
    }

    public hv m11616a(long j) {
        for (hv hvVar : this.f9383c) {
            if (hvVar.m11587a() == j) {
                return hvVar;
            }
        }
        return null;
    }

    public hz m11617a(hh hhVar) {
        return new hz(hhVar, this);
    }

    public ke m11618a(hh hhVar, kf kfVar, ke keVar, boolean z, jy jyVar) {
        ke keVar2 = null;
        gx d = this.f9382b.m11289d(hhVar);
        kf c = d.m11287c(hh.m11376a());
        if (c == null) {
            if (kfVar != null) {
                c = d.m11283a(kfVar);
            }
            return keVar2;
        }
        for (ke keVar3 : r0) {
            ke keVar32;
            if (jyVar.m12100a(keVar32, keVar, z) <= 0 || (keVar2 != null && jyVar.m12100a(keVar32, keVar2, z) >= 0)) {
                keVar32 = keVar2;
            }
            keVar2 = keVar32;
        }
        return keVar2;
    }

    public kf m11619a(hh hhVar, hh hhVar2, kf kfVar, kf kfVar2) {
        if (!f9380a && kfVar == null && kfVar2 == null) {
            throw new AssertionError("Either existingEventSnap or existingServerSnap must exist");
        }
        hh a = hhVar.m11381a(hhVar2);
        if (this.f9382b.m11286b(a)) {
            return null;
        }
        gx d = this.f9382b.m11289d(a);
        return d.m11291e() ? kfVar2.mo3772a(hhVar2) : d.m11283a(kfVar2.mo3772a(hhVar2));
    }

    public kf m11620a(hh hhVar, js jsVar, iv ivVar) {
        hh a = hhVar.m11382a(jsVar);
        kf c = this.f9382b.m11287c(a);
        return c != null ? c : ivVar.m11817a(jsVar) ? this.f9382b.m11289d(a).m11283a(ivVar.m11819c().mo3780c(jsVar)) : null;
    }

    public kf m11621a(hh hhVar, kf kfVar) {
        jx j = jx.m12080j();
        kf<ke> c = this.f9382b.m11287c(hhVar);
        kf kfVar2;
        if (c == null) {
            gx d = this.f9382b.m11289d(hhVar);
            kfVar2 = j;
            for (ke keVar : kfVar) {
                kfVar2 = kfVar2.mo3774a(keVar.m12169c(), d.m11289d(new hh(keVar.m12169c())).m11283a(keVar.m12170d()));
            }
            for (ke keVar2 : d.m11288c()) {
                kfVar2 = kfVar2.mo3774a(keVar2.m12169c(), keVar2.m12170d());
            }
            return kfVar2;
        } else if (c.mo3782e()) {
            return j;
        } else {
            kfVar2 = j;
            for (ke keVar22 : c) {
                kfVar2 = kfVar2.mo3774a(keVar22.m12169c(), keVar22.m12170d());
            }
            return kfVar2;
        }
    }

    public kf m11622a(final hh hhVar, kf kfVar, final List<Long> list, final boolean z) {
        gx d;
        if (!list.isEmpty() || z) {
            d = this.f9382b.m11289d(hhVar);
            if (!z && d.m11291e()) {
                return kfVar;
            }
            if (!z && kfVar == null && !d.m11286b(hh.m11376a())) {
                return null;
            }
            d = m11613a(this.f9383c, new is<hv>(this) {
                public boolean m11609a(hv hvVar) {
                    return (hvVar.m11592f() || z) && !list.contains(Long.valueOf(hvVar.m11587a())) && (hvVar.m11588b().m11384b(hhVar) || hhVar.m11384b(hvVar.m11588b()));
                }

                public /* synthetic */ boolean mo3733a(Object obj) {
                    return m11609a((hv) obj);
                }
            }, hhVar);
            if (kfVar == null) {
                kfVar = jx.m12080j();
            }
            return d.m11283a(kfVar);
        }
        kf c = this.f9382b.m11287c(hhVar);
        if (c != null) {
            return c;
        }
        d = this.f9382b.m11289d(hhVar);
        if (d.m11291e()) {
            return kfVar;
        }
        if (kfVar == null && !d.m11286b(hh.m11376a())) {
            return null;
        }
        if (kfVar == null) {
            kfVar = jx.m12080j();
        }
        return d.m11283a(kfVar);
    }

    public void m11623a(hh hhVar, gx gxVar, Long l) {
        if (f9380a || l.longValue() > this.f9384d.longValue()) {
            this.f9383c.add(new hv(l.longValue(), hhVar, gxVar));
            this.f9382b = this.f9382b.m11280a(hhVar, gxVar);
            this.f9384d = l;
            return;
        }
        throw new AssertionError();
    }

    public void m11624a(hh hhVar, kf kfVar, Long l, boolean z) {
        if (f9380a || l.longValue() > this.f9384d.longValue()) {
            this.f9383c.add(new hv(l.longValue(), hhVar, kfVar, z));
            if (z) {
                this.f9382b = this.f9382b.m11281a(hhVar, kfVar);
            }
            this.f9384d = l;
            return;
        }
        throw new AssertionError();
    }

    public kf m11625b(hh hhVar) {
        return this.f9382b.m11287c(hhVar);
    }

    public boolean m11626b(long j) {
        hv hvVar;
        hv hvVar2 = null;
        int i = 0;
        for (hv hvVar3 : this.f9383c) {
            if (hvVar3.m11587a() == j) {
                hvVar2 = hvVar3;
                break;
            }
            i++;
        }
        if (f9380a || hvVar2 != null) {
            this.f9383c.remove(hvVar2);
            boolean f = hvVar2.m11592f();
            int size = this.f9383c.size() - 1;
            boolean z = false;
            while (f && size >= 0) {
                boolean z2;
                hvVar3 = (hv) this.f9383c.get(size);
                if (hvVar3.m11592f()) {
                    if (size >= i && m11615a(hvVar3, hvVar2.m11588b())) {
                        z2 = z;
                        z = false;
                        size--;
                        f = z;
                        z = z2;
                    } else if (hvVar2.m11588b().m11384b(hvVar3.m11588b())) {
                        z2 = true;
                        z = f;
                        size--;
                        f = z;
                        z = z2;
                    }
                }
                z2 = z;
                z = f;
                size--;
                f = z;
                z = z2;
            }
            if (!f) {
                return false;
            }
            if (z) {
                m11614a();
                return true;
            } else if (hvVar2.m11591e()) {
                this.f9382b = this.f9382b.m11279a(hvVar2.m11588b());
                return true;
            } else {
                Iterator it = hvVar2.m11590d().iterator();
                while (it.hasNext()) {
                    this.f9382b = this.f9382b.m11279a(hvVar2.m11588b().m11381a((hh) ((Entry) it.next()).getKey()));
                }
                return true;
            }
        }
        throw new AssertionError("removeWrite called with nonexistent writeId");
    }
}
