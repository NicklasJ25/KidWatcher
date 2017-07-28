package com.google.android.gms.internal;

import com.google.android.gms.internal.ir.C2875a;

public class io {
    private static final is<Boolean> f9427b = new C29821();
    private static final is<Boolean> f9428c = new C29832();
    private static final ir<Boolean> f9429d = new ir(Boolean.valueOf(true));
    private static final ir<Boolean> f9430e = new ir(Boolean.valueOf(false));
    private final ir<Boolean> f9431a;

    class C29821 implements is<Boolean> {
        C29821() {
        }

        public boolean m11723a(Boolean bool) {
            return !bool.booleanValue();
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11723a((Boolean) obj);
        }
    }

    class C29832 implements is<Boolean> {
        C29832() {
        }

        public boolean m11725a(Boolean bool) {
            return bool.booleanValue();
        }

        public /* synthetic */ boolean mo3733a(Object obj) {
            return m11725a((Boolean) obj);
        }
    }

    public io() {
        this.f9431a = ir.m11778a();
    }

    private io(ir<Boolean> irVar) {
        this.f9431a = irVar;
    }

    public io m11729a(js jsVar) {
        ir a = this.f9431a.m11784a(jsVar);
        ir irVar = a == null ? new ir((Boolean) this.f9431a.m11788b()) : (a.m11788b() != null || this.f9431a.m11788b() == null) ? a : a.m11783a(hh.m11376a(), (Boolean) this.f9431a.m11788b());
        return new io(irVar);
    }

    public <T> T m11730a(T t, final C2875a<Void, T> c2875a) {
        return this.f9431a.m11785a((Object) t, new C2875a<Boolean, T>(this) {
            public T m11727a(hh hhVar, Boolean bool, T t) {
                return !bool.booleanValue() ? c2875a.mo3612a(hhVar, null, t) : t;
            }
        });
    }

    public boolean m11731a() {
        return this.f9431a.m11787a(f9428c);
    }

    public boolean m11732a(hh hhVar) {
        Boolean bool = (Boolean) this.f9431a.m11789b(hhVar);
        return bool != null && bool.booleanValue();
    }

    public boolean m11733b(hh hhVar) {
        Boolean bool = (Boolean) this.f9431a.m11789b(hhVar);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public io m11734c(hh hhVar) {
        if (this.f9431a.m11790b(hhVar, f9427b) == null) {
            return this.f9431a.m11790b(hhVar, f9428c) != null ? this : new io(this.f9431a.m11782a(hhVar, f9429d));
        } else {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        }
    }

    public io m11735d(hh hhVar) {
        return this.f9431a.m11790b(hhVar, f9427b) != null ? this : new io(this.f9431a.m11782a(hhVar, f9430e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof io)) {
            return false;
        }
        return this.f9431a.equals(((io) obj).f9431a);
    }

    public int hashCode() {
        return this.f9431a.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9431a.toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 14).append("{PruneForest:").append(valueOf).append("}").toString();
    }
}
