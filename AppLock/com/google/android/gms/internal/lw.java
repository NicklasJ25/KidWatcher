package com.google.android.gms.internal;

import java.lang.reflect.Array;

public class lw<M extends lv<M>, T> {
    protected final int f9735a;
    protected final Class<T> f9736b;
    public final int f9737c;
    protected final boolean f9738d;

    int m12424a(Object obj) {
        return this.f9738d ? m12426b(obj) : m12428c(obj);
    }

    void m12425a(Object obj, lu luVar) {
        if (this.f9738d) {
            m12429c(obj, luVar);
        } else {
            m12427b(obj, luVar);
        }
    }

    protected int m12426b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m12428c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m12427b(Object obj, lu luVar) {
        try {
            luVar.m12420e(this.f9737c);
            switch (this.f9735a) {
                case 10:
                    mb mbVar = (mb) obj;
                    int b = me.m12507b(this.f9737c);
                    luVar.m12406a(mbVar);
                    luVar.m12416c(b, 4);
                    return;
                case 11:
                    luVar.m12412b((mb) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f9735a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m12428c(Object obj) {
        int b = me.m12507b(this.f9737c);
        switch (this.f9735a) {
            case 10:
                return lu.m12372b(b, (mb) obj);
            case 11:
                return lu.m12378c(b, (mb) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f9735a);
        }
    }

    protected void m12429c(Object obj, lu luVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m12427b(obj2, luVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lw)) {
            return false;
        }
        lw lwVar = (lw) obj;
        return this.f9735a == lwVar.f9735a && this.f9736b == lwVar.f9736b && this.f9737c == lwVar.f9737c && this.f9738d == lwVar.f9738d;
    }

    public int hashCode() {
        return (this.f9738d ? 1 : 0) + ((((((this.f9735a + 1147) * 31) + this.f9736b.hashCode()) * 31) + this.f9737c) * 31);
    }
}
