package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.gd.C2889b;
import com.google.android.gms.internal.ir.C2875a;
import com.google.firebase.database.C3536b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class hr {
    static final /* synthetic */ boolean f9352a = (!hr.class.desiredAssertionStatus());
    private ir<hq> f9353b = ir.m11778a();
    private final hy f9354c = new hy();
    private final Map<hs, je> f9355d = new HashMap();
    private final Map<je, hs> f9356e = new HashMap();
    private final Set<je> f9357f = new HashSet();
    private final C2940c f9358g;
    private final im f9359h;
    private final jp f9360i;
    private long f9361j = 1;

    public interface C2940c {
        void mo3708a(je jeVar, hs hsVar);

        void mo3709a(je jeVar, hs hsVar, go goVar, C2971a c2971a);
    }

    public interface C2971a {
        List<? extends iz> mo3723a(C3536b c3536b);
    }

    private class C2972b implements go, C2971a {
        final /* synthetic */ hr f9349a;
        private final jf f9350b;
        private final hs f9351c;

        public C2972b(hr hrVar, jf jfVar) {
            this.f9349a = hrVar;
            this.f9350b = jfVar;
            this.f9351c = hrVar.m11554b(jfVar.m11875a());
        }

        public String mo3722a() {
            return this.f9350b.m11880b().mo3781d();
        }

        public List<? extends iz> mo3723a(C3536b c3536b) {
            if (c3536b == null) {
                return this.f9351c != null ? this.f9349a.m11577a(this.f9351c) : this.f9349a.m11568a(this.f9350b.m11875a().m11869a());
            } else {
                jp a = this.f9349a.f9360i;
                String valueOf = String.valueOf(this.f9350b.m11875a().m11869a());
                String valueOf2 = String.valueOf(c3536b.toString());
                a.m11957a(new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("Listen at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
                return this.f9349a.m11578a(this.f9350b.m11875a(), c3536b);
            }
        }

        public boolean mo3724b() {
            return lc.m12281a(this.f9350b.m11880b()) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        public gi mo3725c() {
            ju a = ju.m12063a(this.f9350b.m11880b());
            List<hh> a2 = a.m12067a();
            List arrayList = new ArrayList(a2.size());
            for (hh c : a2) {
                arrayList.add(c.m11386c());
            }
            return new gi(arrayList, a.m12068b());
        }
    }

    public hr(ha haVar, im imVar, C2940c c2940c) {
        this.f9358g = c2940c;
        this.f9359h = imVar;
        this.f9360i = haVar.m11314a("SyncTree");
    }

    private hs m11535a() {
        long j = this.f9361j;
        this.f9361j = 1 + j;
        return new hs(j);
    }

    private je m11539a(je jeVar) {
        return (!jeVar.m11873e() || jeVar.m11872d()) ? jeVar : je.m11867a(jeVar.m11869a());
    }

    private List<iz> m11544a(C2978if c2978if) {
        return m11545a(c2978if, this.f9353b, null, this.f9354c.m11617a(hh.m11376a()));
    }

    private List<iz> m11545a(C2978if c2978if, ir<hq> irVar, kf kfVar, hz hzVar) {
        if (c2978if.m11648c().m11391h()) {
            return m11559b(c2978if, irVar, kfVar, hzVar);
        }
        hq hqVar = (hq) irVar.m11788b();
        if (kfVar == null && hqVar != null) {
            kfVar = hqVar.m11505a(hh.m11376a());
        }
        List<iz> arrayList = new ArrayList();
        js d = c2978if.m11648c().m11387d();
        C2978if a = c2978if.mo3735a(d);
        ir irVar2 = (ir) irVar.m11791c().mo3639b(d);
        if (!(irVar2 == null || a == null)) {
            arrayList.addAll(m11545a(a, irVar2, kfVar != null ? kfVar.mo3780c(d) : null, hzVar.m11627a(d)));
        }
        if (hqVar != null) {
            arrayList.addAll(hqVar.m11508a(c2978if, hzVar, kfVar));
        }
        return arrayList;
    }

    private List<jf> m11546a(ir<hq> irVar) {
        List arrayList = new ArrayList();
        m11551a((ir) irVar, arrayList);
        return arrayList;
    }

    private List<iz> m11547a(final je jeVar, final hc hcVar, final C3536b c3536b) {
        return (List) this.f9359h.mo3741a(new Callable<List<iz>>(this) {
            static final /* synthetic */ boolean f9344a = (!hr.class.desiredAssertionStatus());
            final /* synthetic */ hr f9348e;

            public List<iz> m11528a() {
                hh a = jeVar.m11869a();
                hq hqVar = (hq) this.f9348e.f9353b.m11796e(a);
                List<iz> arrayList = new ArrayList();
                if (hqVar != null && (jeVar.m11872d() || hqVar.m11511b(jeVar))) {
                    Object obj;
                    lf a2 = hqVar.m11506a(jeVar, hcVar, c3536b);
                    if (hqVar.m11509a()) {
                        this.f9348e.f9353b = this.f9348e.f9353b.m11794d(a);
                    }
                    List<je> list = (List) a2.m12286a();
                    arrayList = (List) a2.m12287b();
                    Object obj2 = null;
                    for (je jeVar : list) {
                        this.f9348e.f9359h.mo3753c(jeVar);
                        obj = (obj2 != null || jeVar.m11873e()) ? 1 : null;
                        obj2 = obj;
                    }
                    ir d = this.f9348e.f9353b;
                    obj = (d.m11788b() == null || !((hq) d.m11788b()).m11512c()) ? null : 1;
                    Iterator it = a.iterator();
                    ir irVar = d;
                    Object obj3 = obj;
                    while (it.hasNext()) {
                        irVar = irVar.m11784a((js) it.next());
                        obj = (obj3 != null || (irVar.m11788b() != null && ((hq) irVar.m11788b()).m11512c())) ? 1 : null;
                        if (obj != null) {
                            obj3 = obj;
                            break;
                        } else if (irVar.m11795d()) {
                            obj3 = obj;
                            break;
                        } else {
                            obj3 = obj;
                        }
                    }
                    if (obj2 != null && obj3 == null) {
                        ir c = this.f9348e.f9353b.m11792c(a);
                        if (!c.m11795d()) {
                            for (jf jfVar : this.f9348e.m11546a(c)) {
                                C2972b c2972b = new C2972b(this.f9348e, jfVar);
                                this.f9348e.f9358g.mo3709a(this.f9348e.m11539a(jfVar.m11875a()), c2972b.f9351c, c2972b, c2972b);
                            }
                        }
                    }
                    if (obj3 == null && !list.isEmpty() && c3536b == null) {
                        if (obj2 != null) {
                            this.f9348e.f9358g.mo3708a(this.f9348e.m11539a(jeVar), null);
                        } else {
                            for (je jeVar2 : list) {
                                hs a3 = this.f9348e.m11554b(jeVar2);
                                if (f9344a || a3 != null) {
                                    this.f9348e.f9358g.mo3708a(this.f9348e.m11539a(jeVar2), a3);
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }
                    this.f9348e.m11553a((List) list);
                }
                return arrayList;
            }

            public /* synthetic */ Object call() {
                return m11528a();
            }
        });
    }

    private List<? extends iz> m11548a(je jeVar, C2978if c2978if) {
        hh a = jeVar.m11869a();
        hq hqVar = (hq) this.f9353b.m11796e(a);
        if (f9352a || hqVar != null) {
            return hqVar.m11508a(c2978if, this.f9354c.m11617a(a), null);
        }
        throw new AssertionError("Missing sync point for query tag that we're tracking");
    }

    private void m11551a(ir<hq> irVar, List<jf> list) {
        hq hqVar = (hq) irVar.m11788b();
        if (hqVar == null || !hqVar.m11512c()) {
            if (hqVar != null) {
                list.addAll(hqVar.m11510b());
            }
            Iterator it = irVar.m11791c().iterator();
            while (it.hasNext()) {
                m11551a((ir) ((Entry) it.next()).getValue(), (List) list);
            }
            return;
        }
        list.add(hqVar.m11513d());
    }

    private void m11552a(je jeVar, jf jfVar) {
        hh a = jeVar.m11869a();
        hs b = m11554b(jeVar);
        Object c2972b = new C2972b(this, jfVar);
        this.f9358g.mo3709a(m11539a(jeVar), b, c2972b, c2972b);
        ir c = this.f9353b.m11792c(a);
        if (b == null) {
            c.m11786a(new C2875a<hq, Void>(this) {
                final /* synthetic */ hr f9299a;

                {
                    this.f9299a = r1;
                }

                public Void m11515a(hh hhVar, hq hqVar, Void voidR) {
                    je a;
                    if (hhVar.m11391h() || !hqVar.m11512c()) {
                        for (jf a2 : hqVar.m11510b()) {
                            a = a2.m11875a();
                            this.f9299a.f9358g.mo3708a(this.f9299a.m11539a(a), this.f9299a.m11554b(a));
                        }
                    } else {
                        a = hqVar.m11513d().m11875a();
                        this.f9299a.f9358g.mo3708a(this.f9299a.m11539a(a), this.f9299a.m11554b(a));
                    }
                    return null;
                }
            });
        } else if (!f9352a && ((hq) c.m11788b()).m11512c()) {
            throw new AssertionError("If we're adding a query, it shouldn't be shadowed");
        }
    }

    private void m11553a(List<je> list) {
        for (je jeVar : list) {
            if (!jeVar.m11873e()) {
                hs b = m11554b(jeVar);
                if (f9352a || b != null) {
                    this.f9356e.remove(jeVar);
                    this.f9355d.remove(b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    private hs m11554b(je jeVar) {
        return (hs) this.f9356e.get(jeVar);
    }

    private je m11557b(hs hsVar) {
        return (je) this.f9355d.get(hsVar);
    }

    private List<iz> m11559b(C2978if c2978if, ir<hq> irVar, kf kfVar, hz hzVar) {
        hq hqVar = (hq) irVar.m11788b();
        final kf a = (kfVar != null || hqVar == null) ? kfVar : hqVar.m11505a(hh.m11376a());
        final List<iz> arrayList = new ArrayList();
        final hz hzVar2 = hzVar;
        final C2978if c2978if2 = c2978if;
        irVar.m11791c().mo3636a(new C2889b<js, ir<hq>>(this) {
            final /* synthetic */ hr f9304e;

            public void m11516a(js jsVar, ir<hq> irVar) {
                kf kfVar = null;
                if (a != null) {
                    kfVar = a.mo3780c(jsVar);
                }
                hz a = hzVar2.m11627a(jsVar);
                C2978if a2 = c2978if2.mo3735a(jsVar);
                if (a2 != null) {
                    arrayList.addAll(this.f9304e.m11559b(a2, irVar, kfVar, a));
                }
            }

            public /* synthetic */ void mo3719a(Object obj, Object obj2) {
                m11516a((js) obj, (ir) obj2);
            }
        });
        if (hqVar != null) {
            arrayList.addAll(hqVar.m11508a(c2978if, hzVar, a));
        }
        return arrayList;
    }

    public List<? extends iz> m11566a(long j, boolean z, boolean z2, kz kzVar) {
        final boolean z3 = z2;
        final long j2 = j;
        final boolean z4 = z;
        final kz kzVar2 = kzVar;
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9315e;

            public List<? extends iz> m11519a() {
                if (z3) {
                    this.f9315e.f9359h.mo3743a(j2);
                }
                hv a = this.f9315e.f9354c.m11616a(j2);
                boolean b = this.f9315e.f9354c.m11626b(j2);
                if (a.m11592f() && !z4) {
                    Map a2 = hn.m11494a(kzVar2);
                    if (a.m11591e()) {
                        this.f9315e.f9359h.mo3746a(a.m11588b(), hn.m11492a(a.m11589c(), a2));
                    } else {
                        this.f9315e.f9359h.mo3744a(a.m11588b(), hn.m11490a(a.m11590d(), a2));
                    }
                }
                if (!b) {
                    return Collections.emptyList();
                }
                ir a3;
                ir a4 = ir.m11778a();
                if (a.m11591e()) {
                    a3 = a4.m11783a(hh.m11376a(), Boolean.valueOf(true));
                } else {
                    Iterator it = a.m11590d().iterator();
                    a3 = a4;
                    while (it.hasNext()) {
                        a3 = a3.m11783a((hh) ((Entry) it.next()).getKey(), Boolean.valueOf(true));
                    }
                }
                return this.f9315e.m11544a(new ic(a.m11588b(), a3, z4));
            }

            public /* synthetic */ Object call() {
                return m11519a();
            }
        });
    }

    public List<? extends iz> m11567a(final hc hcVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            static final /* synthetic */ boolean f9341a = (!hr.class.desiredAssertionStatus());
            final /* synthetic */ hr f9343c;

            public List<? extends iz> m11527a() {
                hq hqVar;
                kf kfVar;
                hq hqVar2;
                iv ivVar;
                je a = hcVar.mo3728a();
                hh a2 = a.m11869a();
                kf kfVar2 = null;
                hh hhVar = a2;
                ir d = this.f9343c.f9353b;
                boolean z = false;
                while (!d.m11795d()) {
                    boolean z2;
                    kf kfVar3;
                    hqVar = (hq) d.m11788b();
                    if (hqVar != null) {
                        if (kfVar2 == null) {
                            kfVar2 = hqVar.m11505a(hhVar);
                        }
                        z2 = z || hqVar.m11512c();
                        kfVar3 = kfVar2;
                    } else {
                        z2 = z;
                        kfVar3 = kfVar2;
                    }
                    d = d.m11784a(hhVar.m11391h() ? js.m12005a("") : hhVar.m11387d());
                    hhVar = hhVar.m11388e();
                    kfVar2 = kfVar3;
                    z = z2;
                }
                hqVar = (hq) this.f9343c.f9353b.m11796e(a2);
                hq hqVar3;
                boolean z3;
                if (hqVar == null) {
                    hqVar = new hq(this.f9343c.f9359h);
                    this.f9343c.f9353b = this.f9343c.f9353b.m11783a(a2, (Object) hqVar);
                    hqVar3 = hqVar;
                    kfVar = kfVar2;
                    z3 = z;
                    hqVar2 = hqVar3;
                } else {
                    z = z || hqVar.m11512c();
                    if (kfVar2 == null) {
                        kfVar2 = hqVar.m11505a(hh.m11376a());
                    }
                    hqVar3 = hqVar;
                    kfVar = kfVar2;
                    z3 = z;
                    hqVar2 = hqVar3;
                }
                this.f9343c.f9359h.mo3752b(a);
                if (kfVar != null) {
                    ivVar = new iv(jz.m12108a(kfVar, a.m11871c()), true, false);
                } else {
                    iv a3 = this.f9343c.f9359h.mo3740a(a);
                    if (a3.m11815a()) {
                        ivVar = a3;
                    } else {
                        kf j = jx.m12080j();
                        Iterator it = this.f9343c.f9353b.m11792c(a2).m11791c().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            hq hqVar4 = (hq) ((ir) entry.getValue()).m11788b();
                            if (hqVar4 != null) {
                                kf a4 = hqVar4.m11505a(hh.m11376a());
                                if (a4 != null) {
                                    kfVar = j.mo3774a((js) entry.getKey(), a4);
                                    j = kfVar;
                                }
                            }
                            kfVar = j;
                            j = kfVar;
                        }
                        for (ke keVar : a3.m11819c()) {
                            if (!j.mo3776a(keVar.m12169c())) {
                                j = j.mo3774a(keVar.m12169c(), keVar.m12170d());
                            }
                        }
                        ivVar = new iv(jz.m12108a(j, a.m11871c()), false, false);
                    }
                }
                boolean b = hqVar2.m11511b(a);
                if (!(b || a.m11873e())) {
                    if (f9341a || !this.f9343c.f9356e.containsKey(a)) {
                        hs f = this.f9343c.m11535a();
                        this.f9343c.f9356e.put(a, f);
                        this.f9343c.f9355d.put(f, a);
                    } else {
                        throw new AssertionError("View does not exist but we have a tag");
                    }
                }
                List<? extends iz> a5 = hqVar2.m11507a(hcVar, this.f9343c.f9354c.m11617a(a2), ivVar);
                if (!(b || r4)) {
                    this.f9343c.m11552a(a, hqVar2.m11504a(a));
                }
                return a5;
            }

            public /* synthetic */ Object call() {
                return m11527a();
            }
        });
    }

    public List<? extends iz> m11568a(final hh hhVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9330b;

            public List<? extends iz> m11523a() {
                this.f9330b.f9359h.mo3754d(je.m11867a(hhVar));
                return this.f9330b.m11544a(new id(ig.f9411b, hhVar));
            }

            public /* synthetic */ Object call() {
                return m11523a();
            }
        });
    }

    public List<? extends iz> m11569a(hh hhVar, gx gxVar, gx gxVar2, long j, boolean z) {
        final boolean z2 = z;
        final hh hhVar2 = hhVar;
        final gx gxVar3 = gxVar;
        final long j2 = j;
        final gx gxVar4 = gxVar2;
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9310f;

            public List<? extends iz> m11518a() {
                if (z2) {
                    this.f9310f.f9359h.mo3745a(hhVar2, gxVar3, j2);
                }
                this.f9310f.f9354c.m11623a(hhVar2, gxVar4, Long.valueOf(j2));
                return this.f9310f.m11544a(new ie(ig.f9410a, hhVar2, gxVar4));
            }

            public /* synthetic */ Object call() {
                return m11518a();
            }
        });
    }

    public List<? extends iz> m11570a(final hh hhVar, final kf kfVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9325c;

            public List<? extends iz> m11521a() {
                this.f9325c.f9359h.mo3748a(je.m11867a(hhVar), kfVar);
                return this.f9325c.m11544a(new ih(ig.f9411b, hhVar, kfVar));
            }

            public /* synthetic */ Object call() {
                return m11521a();
            }
        });
    }

    public List<? extends iz> m11571a(final hh hhVar, final kf kfVar, final hs hsVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9336d;

            public List<? extends iz> m11525a() {
                je a = this.f9336d.m11557b(hsVar);
                if (a == null) {
                    return Collections.emptyList();
                }
                hh a2 = hh.m11377a(a.m11869a(), hhVar);
                this.f9336d.f9359h.mo3748a(a2.m11391h() ? a : je.m11867a(hhVar), kfVar);
                return this.f9336d.m11548a(a, new ih(ig.m11657a(a.m11870b()), a2, kfVar));
            }

            public /* synthetic */ Object call() {
                return m11525a();
            }
        });
    }

    public List<? extends iz> m11572a(hh hhVar, kf kfVar, kf kfVar2, long j, boolean z, boolean z2) {
        boolean z3 = z || !z2;
        lh.m12296a(z3, "We shouldn't be persisting non-visible writes.");
        final boolean z4 = z2;
        final hh hhVar2 = hhVar;
        final kf kfVar3 = kfVar;
        final long j2 = j;
        final kf kfVar4 = kfVar2;
        final boolean z5 = z;
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9322g;

            public List<? extends iz> m11520a() {
                if (z4) {
                    this.f9322g.f9359h.mo3747a(hhVar2, kfVar3, j2);
                }
                this.f9322g.f9354c.m11624a(hhVar2, kfVar4, Long.valueOf(j2), z5);
                return !z5 ? Collections.emptyList() : this.f9322g.m11544a(new ih(ig.f9410a, hhVar2, kfVar4));
            }

            public /* synthetic */ Object call() {
                return m11520a();
            }
        });
    }

    public List<? extends iz> m11573a(hh hhVar, List<kk> list) {
        hq hqVar = (hq) this.f9353b.m11796e(hhVar);
        if (hqVar == null) {
            return Collections.emptyList();
        }
        jf d = hqVar.m11513d();
        if (d == null) {
            return Collections.emptyList();
        }
        kf b = d.m11880b();
        kf kfVar = b;
        for (kk a : list) {
            kfVar = a.m12194a(kfVar);
        }
        return m11570a(hhVar, kfVar);
    }

    public List<? extends iz> m11574a(hh hhVar, List<kk> list, hs hsVar) {
        je b = m11557b(hsVar);
        if (b == null) {
            return Collections.emptyList();
        }
        if (f9352a || hhVar.equals(b.m11869a())) {
            hq hqVar = (hq) this.f9353b.m11796e(b.m11869a());
            if (f9352a || hqVar != null) {
                jf a = hqVar.m11504a(b);
                if (f9352a || a != null) {
                    kf b2 = a.m11880b();
                    kf kfVar = b2;
                    for (kk a2 : list) {
                        kfVar = a2.m12194a(kfVar);
                    }
                    return m11571a(hhVar, kfVar, hsVar);
                }
                throw new AssertionError("Missing view for query tag that we're tracking");
            }
            throw new AssertionError("Missing sync point for query tag that we're tracking");
        }
        throw new AssertionError();
    }

    public List<? extends iz> m11575a(final hh hhVar, final Map<hh, kf> map) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9328c;

            public List<? extends iz> m11522a() {
                gx b = gx.m11278b(map);
                this.f9328c.f9359h.mo3751b(hhVar, b);
                return this.f9328c.m11544a(new ie(ig.f9411b, hhVar, b));
            }

            public /* synthetic */ Object call() {
                return m11522a();
            }
        });
    }

    public List<? extends iz> m11576a(final hh hhVar, final Map<hh, kf> map, final hs hsVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9340d;

            public List<? extends iz> m11526a() {
                je a = this.f9340d.m11557b(hsVar);
                if (a == null) {
                    return Collections.emptyList();
                }
                hh a2 = hh.m11377a(a.m11869a(), hhVar);
                gx b = gx.m11278b(map);
                this.f9340d.f9359h.mo3751b(hhVar, b);
                return this.f9340d.m11548a(a, new ie(ig.m11657a(a.m11870b()), a2, b));
            }

            public /* synthetic */ Object call() {
                return m11526a();
            }
        });
    }

    public List<? extends iz> m11577a(final hs hsVar) {
        return (List) this.f9359h.mo3741a(new Callable<List<? extends iz>>(this) {
            final /* synthetic */ hr f9332b;

            public List<? extends iz> m11524a() {
                je a = this.f9332b.m11557b(hsVar);
                if (a == null) {
                    return Collections.emptyList();
                }
                this.f9332b.f9359h.mo3754d(a);
                return this.f9332b.m11548a(a, new id(ig.m11657a(a.m11870b()), hh.m11376a()));
            }

            public /* synthetic */ Object call() {
                return m11524a();
            }
        });
    }

    public List<iz> m11578a(je jeVar, C3536b c3536b) {
        return m11547a(jeVar, null, c3536b);
    }

    public kf m11579b(hh hhVar, List<Long> list) {
        kf a;
        ir irVar = this.f9353b;
        irVar.m11788b();
        kf kfVar = null;
        hh a2 = hh.m11376a();
        ir irVar2 = irVar;
        hh hhVar2 = hhVar;
        while (true) {
            js d = hhVar2.m11387d();
            hh e = hhVar2.m11388e();
            hhVar2 = a2.m11382a(d);
            hh a3 = hh.m11377a(hhVar2, hhVar);
            irVar2 = d != null ? irVar2.m11784a(d) : ir.m11778a();
            hq hqVar = (hq) irVar2.m11788b();
            a = hqVar != null ? hqVar.m11505a(a3) : kfVar;
            if (!e.m11391h() && a == null) {
                kfVar = a;
                a2 = hhVar2;
                hhVar2 = e;
            }
        }
        return this.f9354c.m11622a(hhVar, a, (List) list, true);
    }

    public List<iz> m11580b(hc hcVar) {
        return m11547a(hcVar.mo3728a(), hcVar, null);
    }
}
