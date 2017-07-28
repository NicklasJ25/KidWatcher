package com.google.android.gms.internal;

import com.google.android.gms.internal.gd.C2888a;
import com.google.android.gms.internal.gd.C2889b;
import java.util.Comparator;

public abstract class gf<K, V> implements gd<K, V> {
    private final K f8992a;
    private final V f8993b;
    private gd<K, V> f8994c;
    private final gd<K, V> f8995d;

    gf(K k, V v, gd<K, V> gdVar, gd<K, V> gdVar2) {
        gd a;
        gd a2;
        this.f8992a = k;
        this.f8993b = v;
        if (gdVar == null) {
            a = gc.m10999a();
        }
        this.f8994c = a;
        if (gdVar2 == null) {
            a2 = gc.m10999a();
        }
        this.f8995d = a2;
    }

    private static C2888a m10972b(gd gdVar) {
        return gdVar.mo3663b() ? C2888a.BLACK : C2888a.RED;
    }

    private gd<K, V> m10973k() {
        if (this.f8994c.mo3653c()) {
            return gc.m10999a();
        }
        if (!(mo3656f().mo3663b() || mo3656f().mo3656f().mo3663b())) {
            this = m10974l();
        }
        return mo3662a(null, null, ((gf) this.f8994c).m10973k(), null).m10976n();
    }

    private gf<K, V> m10974l() {
        gf<K, V> q = m10979q();
        return q.mo3657g().mo3656f().mo3663b() ? q.mo3662a(null, null, null, ((gf) q.mo3657g()).m10978p()).m10977o().m10979q() : q;
    }

    private gf<K, V> m10975m() {
        gf<K, V> q = m10979q();
        return q.mo3656f().mo3656f().mo3663b() ? q.m10978p().m10979q() : q;
    }

    private gf<K, V> m10976n() {
        gf<K, V> o;
        if (this.f8995d.mo3663b() && !this.f8994c.mo3663b()) {
            o = m10977o();
        }
        if (o.f8994c.mo3663b() && ((gf) o.f8994c).f8994c.mo3663b()) {
            o = o.m10978p();
        }
        return (o.f8994c.mo3663b() && o.f8995d.mo3663b()) ? o.m10979q() : o;
    }

    private gf<K, V> m10977o() {
        return (gf) this.f8995d.mo3649a(null, null, mo3661a(), (gf) mo3649a(null, null, C2888a.RED, null, ((gf) this.f8995d).f8994c), null);
    }

    private gf<K, V> m10978p() {
        return (gf) this.f8994c.mo3649a(null, null, mo3661a(), null, (gf) mo3649a(null, null, C2888a.RED, ((gf) this.f8994c).f8995d, null));
    }

    private gf<K, V> m10979q() {
        return (gf) mo3649a(null, null, m10972b(this), this.f8994c.mo3649a(null, null, m10972b(this.f8994c), null, null), this.f8995d.mo3649a(null, null, m10972b(this.f8995d), null, null));
    }

    protected abstract C2888a mo3661a();

    public /* synthetic */ gd mo3649a(Object obj, Object obj2, C2888a c2888a, gd gdVar, gd gdVar2) {
        return m10987b(obj, obj2, c2888a, gdVar, gdVar2);
    }

    public gd<K, V> mo3650a(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.f8992a);
        gf a = compare < 0 ? mo3662a(null, null, this.f8994c.mo3650a(k, v, comparator), null) : compare == 0 ? mo3662a(k, v, null, null) : mo3662a(null, null, null, this.f8995d.mo3650a(k, v, comparator));
        return a.m10976n();
    }

    public gd<K, V> mo3651a(K k, Comparator<K> comparator) {
        gf a;
        if (comparator.compare(k, this.f8992a) < 0) {
            if (!(this.f8994c.mo3653c() || this.f8994c.mo3663b() || ((gf) this.f8994c).f8994c.mo3663b())) {
                this = m10974l();
            }
            a = mo3662a(null, null, this.f8994c.mo3651a(k, comparator), null);
        } else {
            if (this.f8994c.mo3663b()) {
                this = m10978p();
            }
            if (!(this.f8995d.mo3653c() || this.f8995d.mo3663b() || ((gf) this.f8995d).f8994c.mo3663b())) {
                this = m10975m();
            }
            if (comparator.compare(k, this.f8992a) == 0) {
                if (this.f8995d.mo3653c()) {
                    return gc.m10999a();
                }
                gd h = this.f8995d.mo3658h();
                this = mo3662a(h.mo3654d(), h.mo3655e(), null, ((gf) this.f8995d).m10973k());
            }
            a = mo3662a(null, null, null, this.f8995d.mo3651a(k, comparator));
        }
        return a.m10976n();
    }

    protected abstract gf<K, V> mo3662a(K k, V v, gd<K, V> gdVar, gd<K, V> gdVar2);

    public void mo3652a(C2889b<K, V> c2889b) {
        this.f8994c.mo3652a(c2889b);
        c2889b.mo3719a(this.f8992a, this.f8993b);
        this.f8995d.mo3652a(c2889b);
    }

    void m10986a(gd<K, V> gdVar) {
        this.f8994c = gdVar;
    }

    public gf<K, V> m10987b(K k, V v, C2888a c2888a, gd<K, V> gdVar, gd<K, V> gdVar2) {
        Object obj;
        Object obj2;
        gd gdVar3;
        gd gdVar4;
        if (k == null) {
            obj = this.f8992a;
        }
        if (v == null) {
            obj2 = this.f8993b;
        }
        if (gdVar == null) {
            gdVar3 = this.f8994c;
        }
        if (gdVar2 == null) {
            gdVar4 = this.f8995d;
        }
        return c2888a == C2888a.RED ? new ge(obj, obj2, gdVar3, gdVar4) : new gb(obj, obj2, gdVar3, gdVar4);
    }

    public boolean mo3653c() {
        return false;
    }

    public K mo3654d() {
        return this.f8992a;
    }

    public V mo3655e() {
        return this.f8993b;
    }

    public gd<K, V> mo3656f() {
        return this.f8994c;
    }

    public gd<K, V> mo3657g() {
        return this.f8995d;
    }

    public gd<K, V> mo3658h() {
        return this.f8994c.mo3653c() ? this : this.f8994c.mo3658h();
    }

    public gd<K, V> mo3659i() {
        return this.f8995d.mo3653c() ? this : this.f8995d.mo3659i();
    }

    public int mo3660j() {
        return (this.f8994c.mo3660j() + 1) + this.f8995d.mo3660j();
    }
}
