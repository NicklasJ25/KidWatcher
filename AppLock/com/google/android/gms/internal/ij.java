package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class ij implements im {
    static final /* synthetic */ boolean f9418a = (!ij.class.desiredAssertionStatus());
    private final in f9419b;
    private final iq f9420c;
    private final jp f9421d;
    private final ii f9422e;
    private long f9423f;

    public ij(ha haVar, in inVar, ii iiVar) {
        this(haVar, inVar, iiVar, new la());
    }

    public ij(ha haVar, in inVar, ii iiVar, kz kzVar) {
        this.f9423f = 0;
        this.f9419b = inVar;
        this.f9421d = haVar.m11314a("Persistence");
        this.f9420c = new iq(this.f9419b, this.f9421d, kzVar);
        this.f9422e = iiVar;
    }

    private void m11687b() {
        this.f9423f++;
        if (this.f9422e.mo3737a(this.f9423f)) {
            if (this.f9421d.m11961a()) {
                this.f9421d.m11960a("Reached prune check threshold.", new Object[0]);
            }
            this.f9423f = 0;
            int i = 1;
            long b = this.f9419b.mo3625b();
            if (this.f9421d.m11961a()) {
                this.f9421d.m11960a("Cache size: " + b, new Object[0]);
            }
            while (i != 0 && this.f9422e.mo3738a(r2, this.f9420c.m11762a())) {
                io a = this.f9420c.m11763a(this.f9422e);
                if (a.m11731a()) {
                    this.f9419b.mo3621a(hh.m11376a(), a);
                } else {
                    i = 0;
                }
                b = this.f9419b.mo3625b();
                if (this.f9421d.m11961a()) {
                    this.f9421d.m11960a("Cache size after prune: " + b, new Object[0]);
                }
            }
        }
    }

    public iv mo3740a(je jeVar) {
        boolean z;
        Set d;
        if (this.f9420c.m11773f(jeVar)) {
            ip a = this.f9420c.m11764a(jeVar);
            d = (jeVar.m11873e() || a == null || !a.f9435d) ? null : this.f9419b.mo3630d(a.f9432a);
            z = true;
        } else {
            d = this.f9420c.m11766b(jeVar.m11869a());
            z = false;
        }
        kf a2 = this.f9419b.mo3613a(jeVar.m11869a());
        if (r0 == null) {
            return new iv(jz.m12108a(a2, jeVar.m11871c()), true, false);
        }
        kf j = jx.m12080j();
        for (js jsVar : r0) {
            j = j.mo3774a(jsVar, a2.mo3780c(jsVar));
        }
        return new iv(jz.m12108a(j, jeVar.m11871c()), z, true);
    }

    public <T> T mo3741a(Callable<T> callable) {
        this.f9419b.mo3631d();
        try {
            T call = callable.call();
            this.f9419b.mo3633f();
            this.f9419b.mo3632e();
            return call;
        } catch (Throwable th) {
            this.f9419b.mo3632e();
        }
    }

    public List<hv> mo3742a() {
        return this.f9419b.mo3614a();
    }

    public void mo3743a(long j) {
        this.f9419b.mo3616a(j);
    }

    public void mo3744a(hh hhVar, gx gxVar) {
        Iterator it = gxVar.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            mo3746a(hhVar.m11381a((hh) entry.getKey()), (kf) entry.getValue());
        }
    }

    public void mo3745a(hh hhVar, gx gxVar, long j) {
        this.f9419b.mo3620a(hhVar, gxVar, j);
    }

    public void mo3746a(hh hhVar, kf kfVar) {
        if (!this.f9420c.m11771d(hhVar)) {
            this.f9419b.mo3622a(hhVar, kfVar);
            this.f9420c.m11768c(hhVar);
        }
    }

    public void mo3747a(hh hhVar, kf kfVar, long j) {
        this.f9419b.mo3623a(hhVar, kfVar, j);
    }

    public void mo3748a(je jeVar, kf kfVar) {
        if (jeVar.m11873e()) {
            this.f9419b.mo3622a(jeVar.m11869a(), kfVar);
        } else {
            this.f9419b.mo3627b(jeVar.m11869a(), kfVar);
        }
        mo3754d(jeVar);
        m11687b();
    }

    public void mo3749a(je jeVar, Set<js> set) {
        if (f9418a || !jeVar.m11873e()) {
            ip a = this.f9420c.m11764a(jeVar);
            if (f9418a || (a != null && a.f9436e)) {
                this.f9419b.mo3617a(a.f9432a, (Set) set);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void mo3750a(je jeVar, Set<js> set, Set<js> set2) {
        if (f9418a || !jeVar.m11873e()) {
            ip a = this.f9420c.m11764a(jeVar);
            if (f9418a || (a != null && a.f9436e)) {
                this.f9419b.mo3618a(a.f9432a, (Set) set, (Set) set2);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void mo3751b(hh hhVar, gx gxVar) {
        this.f9419b.mo3619a(hhVar, gxVar);
        m11687b();
    }

    public void mo3752b(je jeVar) {
        this.f9420c.m11769c(jeVar);
    }

    public void mo3753c(je jeVar) {
        this.f9420c.m11770d(jeVar);
    }

    public void mo3754d(je jeVar) {
        if (jeVar.m11873e()) {
            this.f9420c.m11765a(jeVar.m11869a());
        } else {
            this.f9420c.m11772e(jeVar);
        }
    }
}
