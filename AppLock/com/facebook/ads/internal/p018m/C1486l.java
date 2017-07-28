package com.facebook.ads.internal.p018m;

import java.lang.ref.WeakReference;

public abstract class C1486l<T> implements Runnable {
    private final WeakReference<T> f3476a;

    public C1486l(T t) {
        this.f3476a = new WeakReference(t);
    }

    public T m3873a() {
        return this.f3476a.get();
    }
}
