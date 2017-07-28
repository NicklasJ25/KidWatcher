package com.google.android.gms.internal;

import com.google.android.gms.internal.ir.C2875a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class iq {
    static final /* synthetic */ boolean f9438a = (!iq.class.desiredAssertionStatus());
    private static final is<Map<jd, ip>> f9439b = new C29851();
    private static final is<Map<jd, ip>> f9440c = new C29862();
    private static final is<ip> f9441d = new C29873();
    private static final is<ip> f9442e = new C29884();
    private ir<Map<jd, ip>> f9443f;
    private final in f9444g;
    private final jp f9445h;
    private final kz f9446i;
    private long f9447j = 0;

    class C29851 implements is<Map<jd, ip>> {
        C29851() {
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11740a((Map) obj);
        }

        public boolean m11740a(Map<jd, ip> map) {
            ip ipVar = (ip) map.get(jd.f9496a);
            return ipVar != null && ipVar.f9435d;
        }
    }

    class C29862 implements is<Map<jd, ip>> {
        C29862() {
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11742a((Map) obj);
        }

        public boolean m11742a(Map<jd, ip> map) {
            ip ipVar = (ip) map.get(jd.f9496a);
            return ipVar != null && ipVar.f9436e;
        }
    }

    class C29873 implements is<ip> {
        C29873() {
        }

        public boolean m11743a(ip ipVar) {
            return !ipVar.f9436e;
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11743a((ip) obj);
        }
    }

    class C29884 implements is<ip> {
        C29884() {
        }

        public boolean m11745a(ip ipVar) {
            return !iq.f9441d.mo3733a(ipVar);
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11745a((ip) obj);
        }
    }

    class C29895 implements C2875a<Map<jd, ip>, Void> {
        final /* synthetic */ iq f9437a;

        C29895(iq iqVar) {
            this.f9437a = iqVar;
        }

        public Void m11748a(hh hhVar, Map<jd, ip> map, Void voidR) {
            for (Entry value : map.entrySet()) {
                ip ipVar = (ip) value.getValue();
                if (!ipVar.f9435d) {
                    this.f9437a.m11756b(ipVar.m11736a());
                }
            }
            return null;
        }
    }

    class C29906 implements Comparator<ip> {
        C29906(iq iqVar) {
        }

        public int m11749a(ip ipVar, ip ipVar2) {
            return lh.m12291a(ipVar.f9434c, ipVar2.f9434c);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11749a((ip) obj, (ip) obj2);
        }
    }

    public iq(in inVar, jp jpVar, kz kzVar) {
        this.f9444g = inVar;
        this.f9445h = jpVar;
        this.f9446i = kzVar;
        this.f9443f = new ir(null);
        m11757c();
        for (ip ipVar : this.f9444g.mo3628c()) {
            this.f9447j = Math.max(ipVar.f9432a + 1, this.f9447j);
            m11752a(ipVar);
        }
    }

    private static long m11750a(ii iiVar, long j) {
        return j - Math.min((long) Math.floor((double) ((1.0f - iiVar.mo3736a()) * ((float) j))), iiVar.mo3739b());
    }

    private List<ip> m11751a(is<ip> isVar) {
        List<ip> arrayList = new ArrayList();
        Iterator it = this.f9443f.iterator();
        while (it.hasNext()) {
            for (ip ipVar : ((Map) ((Entry) it.next()).getValue()).values()) {
                if (isVar.mo3733a(ipVar)) {
                    arrayList.add(ipVar);
                }
            }
        }
        return arrayList;
    }

    private void m11752a(ip ipVar) {
        Map map;
        m11760g(ipVar.f9433b);
        Map map2 = (Map) this.f9443f.m11796e(ipVar.f9433b.m11869a());
        if (map2 == null) {
            map2 = new HashMap();
            this.f9443f = this.f9443f.m11783a(ipVar.f9433b.m11869a(), (Object) map2);
            map = map2;
        } else {
            map = map2;
        }
        ip ipVar2 = (ip) map.get(ipVar.f9433b.m11870b());
        boolean z = ipVar2 == null || ipVar2.f9432a == ipVar.f9432a;
        lh.m12295a(z);
        map.put(ipVar.f9433b.m11870b(), ipVar);
    }

    private void m11754a(je jeVar, boolean z) {
        je h = m11761h(jeVar);
        ip a = m11764a(h);
        long a2 = this.f9446i.mo3817a();
        if (a != null) {
            a = a.m11737a(a2).m11738a(z);
        } else if (f9438a || z) {
            long j = this.f9447j;
            this.f9447j = 1 + j;
            a = new ip(j, h, a2, false, z);
        } else {
            throw new AssertionError("If we're setting the query to inactive, we should already be tracking it!");
        }
        m11756b(a);
    }

    private void m11756b(ip ipVar) {
        m11752a(ipVar);
        this.f9444g.mo3624a(ipVar);
    }

    private void m11757c() {
        try {
            this.f9444g.mo3631d();
            this.f9444g.mo3629c(this.f9446i.mo3817a());
            this.f9444g.mo3633f();
        } finally {
            this.f9444g.mo3632e();
        }
    }

    private boolean m11758e(hh hhVar) {
        return this.f9443f.m11781a(hhVar, f9439b) != null;
    }

    private Set<Long> m11759f(hh hhVar) {
        Set<Long> hashSet = new HashSet();
        Map map = (Map) this.f9443f.m11796e(hhVar);
        if (map != null) {
            for (ip ipVar : map.values()) {
                if (!ipVar.f9433b.m11873e()) {
                    hashSet.add(Long.valueOf(ipVar.f9432a));
                }
            }
        }
        return hashSet;
    }

    private static void m11760g(je jeVar) {
        boolean z = !jeVar.m11873e() || jeVar.m11872d();
        lh.m12296a(z, "Can't have tracked non-default query that loads all data");
    }

    private static je m11761h(je jeVar) {
        return jeVar.m11873e() ? je.m11867a(jeVar.m11869a()) : jeVar;
    }

    public long m11762a() {
        return (long) m11751a(f9441d).size();
    }

    public io m11763a(ii iiVar) {
        List a = m11751a(f9441d);
        long a2 = m11750a(iiVar, (long) a.size());
        io ioVar = new io();
        if (this.f9445h.m11961a()) {
            this.f9445h.m11960a("Pruning old queries.  Prunable: " + a.size() + " Count to prune: " + a2, new Object[0]);
        }
        Collections.sort(a, new C29906(this));
        for (int i = 0; ((long) i) < a2; i++) {
            ip ipVar = (ip) a.get(i);
            ioVar = ioVar.m11734c(ipVar.f9433b.m11869a());
            m11767b(ipVar.f9433b);
        }
        io ioVar2 = ioVar;
        for (int i2 = (int) a2; i2 < a.size(); i2++) {
            ioVar2 = ioVar2.m11735d(((ip) a.get(i2)).f9433b.m11869a());
        }
        List<ip> a3 = m11751a(f9442e);
        if (this.f9445h.m11961a()) {
            this.f9445h.m11960a("Unprunable queries: " + a3.size(), new Object[0]);
        }
        for (ip ipVar2 : a3) {
            ioVar2 = ioVar2.m11735d(ipVar2.f9433b.m11869a());
        }
        return ioVar2;
    }

    public ip m11764a(je jeVar) {
        je h = m11761h(jeVar);
        Map map = (Map) this.f9443f.m11796e(h.m11869a());
        return map != null ? (ip) map.get(h.m11870b()) : null;
    }

    public void m11765a(hh hhVar) {
        this.f9443f.m11792c(hhVar).m11786a(new C29895(this));
    }

    public Set<js> m11766b(hh hhVar) {
        if (f9438a || !m11773f(je.m11867a(hhVar))) {
            Set<js> hashSet = new HashSet();
            Set f = m11759f(hhVar);
            if (!f.isEmpty()) {
                hashSet.addAll(this.f9444g.mo3615a(f));
            }
            Iterator it = this.f9443f.m11792c(hhVar).m11791c().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                js jsVar = (js) entry.getKey();
                ir irVar = (ir) entry.getValue();
                if (irVar.m11788b() != null && f9439b.mo3733a((Map) irVar.m11788b())) {
                    hashSet.add(jsVar);
                }
            }
            return hashSet;
        }
        throw new AssertionError("Path is fully complete.");
    }

    public void m11767b(je jeVar) {
        je h = m11761h(jeVar);
        ip a = m11764a(h);
        if (f9438a || a != null) {
            this.f9444g.mo3626b(a.f9432a);
            Map map = (Map) this.f9443f.m11796e(h.m11869a());
            map.remove(h.m11870b());
            if (map.isEmpty()) {
                this.f9443f = this.f9443f.m11794d(h.m11869a());
                return;
            }
            return;
        }
        throw new AssertionError("Query must exist to be removed.");
    }

    public void m11768c(hh hhVar) {
        if (!m11758e(hhVar)) {
            je a = je.m11867a(hhVar);
            ip a2 = m11764a(a);
            if (a2 == null) {
                long j = this.f9447j;
                this.f9447j = 1 + j;
                a2 = new ip(j, a, this.f9446i.mo3817a(), true, false);
            } else if (f9438a || !a2.f9435d) {
                a2 = a2.m11736a();
            } else {
                throw new AssertionError("This should have been handled above!");
            }
            m11756b(a2);
        }
    }

    public void m11769c(je jeVar) {
        m11754a(jeVar, true);
    }

    public void m11770d(je jeVar) {
        m11754a(jeVar, false);
    }

    public boolean m11771d(hh hhVar) {
        return this.f9443f.m11790b(hhVar, f9440c) != null;
    }

    public void m11772e(je jeVar) {
        ip a = m11764a(m11761h(jeVar));
        if (a != null && !a.f9435d) {
            m11756b(a.m11736a());
        }
    }

    public boolean m11773f(je jeVar) {
        if (m11758e(jeVar.m11869a())) {
            return true;
        }
        if (jeVar.m11873e()) {
            return false;
        }
        Map map = (Map) this.f9443f.m11796e(jeVar.m11869a());
        boolean z = map != null && map.containsKey(jeVar.m11870b()) && ((ip) map.get(jeVar.m11870b())).f9435d;
        return z;
    }
}
