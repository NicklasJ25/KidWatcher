package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class C2441k<TResult> implements C2436l<TResult> {
    private final Executor f7243a;
    private final Object f7244b = new Object();
    private C2426c<? super TResult> f7245c;

    public C2441k(@NonNull Executor executor, @NonNull C2426c<? super TResult> c2426c) {
        this.f7243a = executor;
        this.f7245c = c2426c;
    }

    public void mo3305a(@NonNull final C2428e<TResult> c2428e) {
        if (c2428e.mo3310a()) {
            synchronized (this.f7244b) {
                if (this.f7245c == null) {
                    return;
                }
                this.f7243a.execute(new Runnable(this) {
                    final /* synthetic */ C2441k f7242b;

                    public void run() {
                        synchronized (this.f7242b.f7244b) {
                            if (this.f7242b.f7245c != null) {
                                this.f7242b.f7245c.mo3596a(c2428e.mo3311b());
                            }
                        }
                    }
                });
            }
        }
    }
}
