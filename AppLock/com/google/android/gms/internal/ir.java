package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ir<T> implements Iterable<Entry<hh, T>> {
    private static final fx f9450c = C2882a.m10944a(gh.m11039a(js.class));
    private static final ir f9451d = new ir(null, f9450c);
    private final T f9452a;
    private final fx<js, ir<T>> f9453b;

    public interface C2875a<T, R> {
        R mo3612a(hh hhVar, T t, R r);
    }

    public ir(T t) {
        this(t, f9450c);
    }

    public ir(T t, fx<js, ir<T>> fxVar) {
        this.f9452a = t;
        this.f9453b = fxVar;
    }

    public static <V> ir<V> m11778a() {
        return f9451d;
    }

    private <R> R m11779a(hh hhVar, C2875a<? super T, R> c2875a, R r) {
        Iterator it = this.f9453b.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            r = ((ir) entry.getValue()).m11779a(hhVar.m11382a((js) entry.getKey()), c2875a, r);
        }
        return this.f9452a != null ? c2875a.mo3612a(hhVar, this.f9452a, r) : r;
    }

    public hh m11780a(hh hhVar) {
        return m11781a(hhVar, is.f9376d);
    }

    public hh m11781a(hh hhVar, is<? super T> isVar) {
        if (this.f9452a != null && isVar.mo3733a(this.f9452a)) {
            return hh.m11376a();
        }
        if (hhVar.m11391h()) {
            return null;
        }
        ir irVar = (ir) this.f9453b.mo3639b(hhVar.m11387d());
        if (irVar == null) {
            return null;
        }
        hh a = irVar.m11781a(hhVar.m11388e(), (is) isVar);
        if (a == null) {
            return null;
        }
        return new hh(r2).m11381a(a);
    }

    public ir<T> m11782a(hh hhVar, ir<T> irVar) {
        if (hhVar.m11391h()) {
            return irVar;
        }
        js d = hhVar.m11387d();
        ir irVar2 = (ir) this.f9453b.mo3639b(d);
        if (irVar2 == null) {
            irVar2 = m11778a();
        }
        irVar2 = irVar2.m11782a(hhVar.m11388e(), (ir) irVar);
        return new ir(this.f9452a, irVar2.m11795d() ? this.f9453b.mo3641c(d) : this.f9453b.mo3634a(d, irVar2));
    }

    public ir<T> m11783a(hh hhVar, T t) {
        if (hhVar.m11391h()) {
            return new ir(t, this.f9453b);
        }
        js d = hhVar.m11387d();
        ir irVar = (ir) this.f9453b.mo3639b(d);
        if (irVar == null) {
            irVar = m11778a();
        }
        return new ir(this.f9452a, this.f9453b.mo3634a(d, irVar.m11783a(hhVar.m11388e(), (Object) t)));
    }

    public ir<T> m11784a(js jsVar) {
        ir<T> irVar = (ir) this.f9453b.mo3639b(jsVar);
        return irVar != null ? irVar : m11778a();
    }

    public <R> R m11785a(R r, C2875a<? super T, R> c2875a) {
        return m11779a(hh.m11376a(), c2875a, r);
    }

    public void m11786a(C2875a<T, Void> c2875a) {
        m11779a(hh.m11376a(), c2875a, null);
    }

    public boolean m11787a(is<? super T> isVar) {
        if (this.f9452a != null && isVar.mo3733a(this.f9452a)) {
            return true;
        }
        Iterator it = this.f9453b.iterator();
        while (it.hasNext()) {
            if (((ir) ((Entry) it.next()).getValue()).m11787a((is) isVar)) {
                return true;
            }
        }
        return false;
    }

    public T m11788b() {
        return this.f9452a;
    }

    public T m11789b(hh hhVar) {
        return m11793c(hhVar, is.f9376d);
    }

    public T m11790b(hh hhVar, is<? super T> isVar) {
        if (this.f9452a != null && isVar.mo3733a(this.f9452a)) {
            return this.f9452a;
        }
        Iterator it = hhVar.iterator();
        while (it.hasNext()) {
            ir irVar = (ir) this.f9453b.mo3639b((js) it.next());
            if (irVar == null) {
                return null;
            }
            if (irVar.f9452a != null && isVar.mo3733a(irVar.f9452a)) {
                return irVar.f9452a;
            }
            this = irVar;
        }
        return null;
    }

    public fx<js, ir<T>> m11791c() {
        return this.f9453b;
    }

    public ir<T> m11792c(hh hhVar) {
        if (hhVar.m11391h()) {
            return this;
        }
        ir irVar = (ir) this.f9453b.mo3639b(hhVar.m11387d());
        return irVar != null ? irVar.m11792c(hhVar.m11388e()) : m11778a();
    }

    public T m11793c(hh hhVar, is<? super T> isVar) {
        T t = (this.f9452a == null || !isVar.mo3733a(this.f9452a)) ? null : this.f9452a;
        Iterator it = hhVar.iterator();
        T t2 = t;
        while (it.hasNext()) {
            ir irVar = (ir) this.f9453b.mo3639b((js) it.next());
            if (irVar == null) {
                break;
            }
            if (irVar.f9452a != null && isVar.mo3733a(irVar.f9452a)) {
                t2 = irVar.f9452a;
            }
            this = irVar;
        }
        return t2;
    }

    public ir<T> m11794d(hh hhVar) {
        if (hhVar.m11391h()) {
            return this.f9453b.mo3643d() ? m11778a() : new ir(null, this.f9453b);
        } else {
            js d = hhVar.m11387d();
            ir irVar = (ir) this.f9453b.mo3639b(d);
            if (irVar == null) {
                return this;
            }
            irVar = irVar.m11794d(hhVar.m11388e());
            fx c = irVar.m11795d() ? this.f9453b.mo3641c(d) : this.f9453b.mo3634a(d, irVar);
            return (this.f9452a == null && c.mo3643d()) ? m11778a() : new ir(this.f9452a, c);
        }
    }

    public boolean m11795d() {
        return this.f9452a == null && this.f9453b.mo3643d();
    }

    public T m11796e(hh hhVar) {
        if (hhVar.m11391h()) {
            return this.f9452a;
        }
        ir irVar = (ir) this.f9453b.mo3639b(hhVar.m11387d());
        return irVar != null ? irVar.m11796e(hhVar.m11388e()) : null;
    }

    public Collection<T> m11797e() {
        final Collection arrayList = new ArrayList();
        m11786a(new C2875a<T, Void>(this) {
            public Void m11775a(hh hhVar, T t, Void voidR) {
                arrayList.add(t);
                return null;
            }
        });
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ir irVar = (ir) obj;
        if (this.f9453b == null ? irVar.f9453b != null : !this.f9453b.equals(irVar.f9453b)) {
            return false;
        }
        if (this.f9452a != null) {
            if (this.f9452a.equals(irVar.f9452a)) {
                return true;
            }
        } else if (irVar.f9452a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f9452a != null ? this.f9452a.hashCode() : 0) * 31;
        if (this.f9453b != null) {
            i = this.f9453b.hashCode();
        }
        return hashCode + i;
    }

    public Iterator<Entry<hh, T>> iterator() {
        final List arrayList = new ArrayList();
        m11786a(new C2875a<T, Void>(this) {
            public Void m11777a(hh hhVar, T t, Void voidR) {
                arrayList.add(new SimpleImmutableEntry(hhVar, t));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableTree { value=");
        stringBuilder.append(m11788b());
        stringBuilder.append(", children={");
        Iterator it = this.f9453b.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append(((js) entry.getKey()).m12010d());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append("} }");
        return stringBuilder.toString();
    }
}
