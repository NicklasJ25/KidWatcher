package com.google.android.gms.internal;

import java.util.Map.Entry;

public class it<T> {
    static final /* synthetic */ boolean f9456a = (!it.class.desiredAssertionStatus());
    private js f9457b;
    private it<T> f9458c;
    private iu<T> f9459d;

    public interface C2942b<T> {
        void mo3711a(it<T> itVar);
    }

    public interface C2949a<T> {
        boolean mo3712a(it<T> itVar);
    }

    public it() {
        this(null, null, new iu());
    }

    public it(js jsVar, it<T> itVar, iu<T> iuVar) {
        this.f9457b = jsVar;
        this.f9458c = itVar;
        this.f9459d = iuVar;
    }

    private void m11800a(js jsVar, it<T> itVar) {
        boolean d = itVar.m11813d();
        boolean containsKey = this.f9459d.f9460a.containsKey(jsVar);
        if (d && containsKey) {
            this.f9459d.f9460a.remove(jsVar);
            m11801e();
        } else if (!d && !containsKey) {
            this.f9459d.f9460a.put(jsVar, itVar.f9459d);
            m11801e();
        }
    }

    private void m11801e() {
        if (this.f9458c != null) {
            this.f9458c.m11800a(this.f9457b, this);
        }
    }

    public it<T> m11802a(hh hhVar) {
        it<T> itVar;
        js d = hhVar.m11387d();
        while (d != null) {
            it<T> itVar2 = new it(d, itVar, itVar.f9459d.f9460a.containsKey(d) ? (iu) itVar.f9459d.f9460a.get(d) : new iu());
            hhVar = hhVar.m11388e();
            d = hhVar.m11387d();
            itVar = itVar2;
        }
        return itVar;
    }

    public T m11803a() {
        return this.f9459d.f9461b;
    }

    String m11804a(String str) {
        String d = this.f9457b == null ? "<anon>" : this.f9457b.m12010d();
        String valueOf = String.valueOf(this.f9459d.m11814a(String.valueOf(str).concat("\t")));
        return new StringBuilder(((String.valueOf(str).length() + 1) + String.valueOf(d).length()) + String.valueOf(valueOf).length()).append(str).append(d).append("\n").append(valueOf).toString();
    }

    public void m11805a(C2942b<T> c2942b) {
        m11806a(c2942b, false, false);
    }

    public void m11806a(final C2942b<T> c2942b, boolean z, final boolean z2) {
        if (z && !z2) {
            c2942b.mo3711a(this);
        }
        m11811b(new C2942b<T>(this) {
            public void mo3711a(it<T> itVar) {
                itVar.m11806a(c2942b, true, z2);
            }
        });
        if (z && z2) {
            c2942b.mo3711a(this);
        }
    }

    public void m11807a(T t) {
        this.f9459d.f9461b = t;
        m11801e();
    }

    public boolean m11808a(C2949a<T> c2949a) {
        return m11809a((C2949a) c2949a, false);
    }

    public boolean m11809a(C2949a<T> c2949a, boolean z) {
        if (!z) {
            this = this.f9458c;
        }
        while (this != null) {
            c2949a.mo3712a(this);
            this = this.f9458c;
        }
        return false;
    }

    public hh m11810b() {
        if (this.f9458c != null) {
            if (f9456a || this.f9457b != null) {
                return this.f9458c.m11810b().m11382a(this.f9457b);
            }
            throw new AssertionError();
        } else if (this.f9457b == null) {
            return hh.m11376a();
        } else {
            return new hh(this.f9457b);
        }
    }

    public void m11811b(C2942b<T> c2942b) {
        Object[] toArray = this.f9459d.f9460a.entrySet().toArray();
        for (Object obj : toArray) {
            Entry entry = (Entry) obj;
            c2942b.mo3711a(new it((js) entry.getKey(), this, (iu) entry.getValue()));
        }
    }

    public boolean m11812c() {
        return !this.f9459d.f9460a.isEmpty();
    }

    public boolean m11813d() {
        return this.f9459d.f9461b == null && this.f9459d.f9460a.isEmpty();
    }

    public String toString() {
        return m11804a("");
    }
}
