package com.google.android.exoplayer2.p063h;

import android.os.Handler;
import com.google.android.exoplayer2.C1948n;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p055f.C2153i;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class C2208h<T> {
    private final Handler f6260a;
    private final CopyOnWriteArraySet<C2216a<? super T>> f6261b = new CopyOnWriteArraySet();
    private C2217b f6262c;
    private C2214g<T> f6263d;

    public interface C2216a<T> {
        void mo3117a(C2214g<? extends T> c2214g);
    }

    public interface C2217b {
    }

    public C2208h(Handler handler) {
        this.f6260a = (Handler) C2252a.m7020a((Object) handler);
    }

    private void m6871b(final C2214g<T> c2214g) {
        if (this.f6260a != null) {
            this.f6260a.post(new Runnable(this) {
                final /* synthetic */ C2208h f6285b;

                public void run() {
                    Iterator it = this.f6285b.f6261b.iterator();
                    while (it.hasNext()) {
                        ((C2216a) it.next()).mo3117a(c2214g);
                    }
                }
            });
        }
    }

    public abstract C2214g<T> mo3090a(C1948n[] c1948nArr, C2153i c2153i);

    public final void m6873a(C2214g<T> c2214g) {
        this.f6263d = c2214g;
        m6871b(c2214g);
    }

    public final void m6874a(C2216a<? super T> c2216a) {
        this.f6261b.add(c2216a);
    }

    public final void m6875a(C2217b c2217b) {
        this.f6262c = c2217b;
    }
}
