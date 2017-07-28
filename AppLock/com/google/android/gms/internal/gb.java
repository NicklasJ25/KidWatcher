package com.google.android.gms.internal;

import com.google.android.gms.internal.gd.C2888a;

public class gb<K, V> extends gf<K, V> {
    gb(K k, V v, gd<K, V> gdVar, gd<K, V> gdVar2) {
        super(k, v, gdVar, gdVar2);
    }

    protected C2888a mo3661a() {
        return C2888a.BLACK;
    }

    protected gf<K, V> mo3662a(K k, V v, gd<K, V> gdVar, gd<K, V> gdVar2) {
        Object d;
        Object e;
        gd f;
        gd g;
        if (k == null) {
            d = mo3654d();
        }
        if (v == null) {
            e = mo3655e();
        }
        if (gdVar == null) {
            f = mo3656f();
        }
        if (gdVar2 == null) {
            g = mo3657g();
        }
        return new gb(d, e, f, g);
    }

    public boolean mo3663b() {
        return false;
    }
}
