package com.google.android.gms.internal;

import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@wh
public class aan<T> implements aam<T> {
    protected int f7651a = 0;
    protected final BlockingQueue<C2639a> f7652b = new LinkedBlockingQueue();
    protected T f7653c;
    private final Object f7654d = new Object();

    class C2639a {
        public final C2380c<T> f7649a;
        public final C2637a f7650b;

        public C2639a(aan com_google_android_gms_internal_aan, C2380c<T> c2380c, C2637a c2637a) {
            this.f7649a = c2380c;
            this.f7650b = c2637a;
        }
    }

    public void mo4042a() {
        synchronized (this.f7654d) {
            if (this.f7651a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f7651a = -1;
            for (C2639a c2639a : this.f7652b) {
                c2639a.f7650b.mo3379a();
            }
            this.f7652b.clear();
        }
    }

    public void mo3380a(C2380c<T> c2380c, C2637a c2637a) {
        synchronized (this.f7654d) {
            if (this.f7651a == 1) {
                c2380c.mo3272a(this.f7653c);
            } else if (this.f7651a == -1) {
                c2637a.mo3379a();
            } else if (this.f7651a == 0) {
                this.f7652b.add(new C2639a(this, c2380c, c2637a));
            }
        }
    }

    public void mo3381a(T t) {
        synchronized (this.f7654d) {
            if (this.f7651a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f7653c = t;
            this.f7651a = 1;
            for (C2639a c2639a : this.f7652b) {
                c2639a.f7649a.mo3272a(t);
            }
            this.f7652b.clear();
        }
    }

    public int mo4043b() {
        return this.f7651a;
    }
}
