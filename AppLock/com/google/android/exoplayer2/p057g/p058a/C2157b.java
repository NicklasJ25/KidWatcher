package com.google.android.exoplayer2.p057g.p058a;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p057g.C2156f;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2160j;
import com.google.android.exoplayer2.p057g.C2194i;
import java.util.LinkedList;
import java.util.TreeSet;

abstract class C2157b implements C2156f {
    private final LinkedList<C2194i> f6032a = new LinkedList();
    private final LinkedList<C2160j> f6033b;
    private final TreeSet<C2194i> f6034c;
    private C2194i f6035d;
    private long f6036e;

    public C2157b() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.f6032a.add(new C2194i());
        }
        this.f6033b = new LinkedList();
        while (i < 2) {
            this.f6033b.add(new C2161c(this));
            i++;
        }
        this.f6034c = new TreeSet();
    }

    private void m6582c(C2194i c2194i) {
        c2194i.mo2931a();
        this.f6032a.add(c2194i);
    }

    public /* synthetic */ Object mo2932a() {
        return mo3050h();
    }

    public void mo3044a(long j) {
        this.f6036e = j;
    }

    protected abstract void mo3045a(C2194i c2194i);

    protected void m6586a(C2160j c2160j) {
        c2160j.mo2931a();
        this.f6033b.add(c2160j);
    }

    public /* synthetic */ void mo2933a(Object obj) {
        mo3046b((C2194i) obj);
    }

    public /* synthetic */ Object mo2934b() {
        return mo3049g();
    }

    public void mo3046b(C2194i c2194i) {
        boolean z = true;
        C2252a.m7022a(c2194i != null);
        if (c2194i != this.f6035d) {
            z = false;
        }
        C2252a.m7022a(z);
        this.f6034c.add(c2194i);
        this.f6035d = null;
    }

    public void mo2935c() {
        this.f6036e = 0;
        while (!this.f6034c.isEmpty()) {
            m6582c((C2194i) this.f6034c.pollFirst());
        }
        if (this.f6035d != null) {
            m6582c(this.f6035d);
            this.f6035d = null;
        }
    }

    public void mo2936d() {
    }

    protected abstract boolean mo3047e();

    protected abstract C2159e mo3048f();

    public C2160j mo3049g() {
        if (this.f6033b.isEmpty()) {
            return null;
        }
        while (!this.f6034c.isEmpty() && ((C2194i) this.f6034c.first()).c <= this.f6036e) {
            C2194i c2194i = (C2194i) this.f6034c.pollFirst();
            if (c2194i.m5694c()) {
                C2160j c2160j = (C2160j) this.f6033b.pollFirst();
                c2160j.m5692b(4);
                m6582c(c2194i);
                return c2160j;
            }
            mo3045a(c2194i);
            if (mo3047e()) {
                C2159e f = mo3048f();
                if (!c2194i.d_()) {
                    c2160j = (C2160j) this.f6033b.pollFirst();
                    c2160j.m6626a(c2194i.c, f, 0);
                    m6582c(c2194i);
                    return c2160j;
                }
            }
            m6582c(c2194i);
        }
        return null;
    }

    public C2194i mo3050h() {
        C2252a.m7024b(this.f6035d == null);
        if (this.f6032a.isEmpty()) {
            return null;
        }
        this.f6035d = (C2194i) this.f6032a.pollFirst();
        return this.f6035d;
    }
}
