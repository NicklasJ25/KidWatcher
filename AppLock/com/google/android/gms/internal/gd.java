package com.google.android.gms.internal;

import java.util.Comparator;

public interface gd<K, V> {

    public enum C2888a {
        RED,
        BLACK
    }

    public static abstract class C2889b<K, V> {
        public abstract void mo3719a(K k, V v);
    }

    gd<K, V> mo3649a(K k, V v, C2888a c2888a, gd<K, V> gdVar, gd<K, V> gdVar2);

    gd<K, V> mo3650a(K k, V v, Comparator<K> comparator);

    gd<K, V> mo3651a(K k, Comparator<K> comparator);

    void mo3652a(C2889b<K, V> c2889b);

    boolean mo3663b();

    boolean mo3653c();

    K mo3654d();

    V mo3655e();

    gd<K, V> mo3656f();

    gd<K, V> mo3657g();

    gd<K, V> mo3658h();

    gd<K, V> mo3659i();

    int mo3660j();
}
