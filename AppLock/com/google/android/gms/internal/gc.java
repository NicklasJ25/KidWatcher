package com.google.android.gms.internal;

import com.google.android.gms.internal.gd.C2888a;
import com.google.android.gms.internal.gd.C2889b;
import java.util.Comparator;

public class gc<K, V> implements gd<K, V> {
    private static final gc f8996a = new gc();

    private gc() {
    }

    public static <K, V> gc<K, V> m10999a() {
        return f8996a;
    }

    public gd<K, V> mo3649a(K k, V v, C2888a c2888a, gd<K, V> gdVar, gd<K, V> gdVar2) {
        return this;
    }

    public gd<K, V> mo3650a(K k, V v, Comparator<K> comparator) {
        return new ge(k, v);
    }

    public gd<K, V> mo3651a(K k, Comparator<K> comparator) {
        return this;
    }

    public void mo3652a(C2889b<K, V> c2889b) {
    }

    public boolean mo3663b() {
        return false;
    }

    public boolean mo3653c() {
        return true;
    }

    public K mo3654d() {
        return null;
    }

    public V mo3655e() {
        return null;
    }

    public gd<K, V> mo3656f() {
        return this;
    }

    public gd<K, V> mo3657g() {
        return this;
    }

    public gd<K, V> mo3658h() {
        return this;
    }

    public gd<K, V> mo3659i() {
        return this;
    }

    public int mo3660j() {
        return 0;
    }
}
