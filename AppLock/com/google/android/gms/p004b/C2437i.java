package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class C2437i<TResult> implements C2436l<TResult> {
    private final Executor f7233a;
    private final Object f7234b = new Object();
    private C0625a<TResult> f7235c;

    public C2437i(@NonNull Executor executor, @NonNull C0625a<TResult> c0625a) {
        this.f7233a = executor;
        this.f7235c = c0625a;
    }

    public void mo3305a(@NonNull final C2428e<TResult> c2428e) {
        synchronized (this.f7234b) {
            if (this.f7235c == null) {
                return;
            }
            this.f7233a.execute(new Runnable(this) {
                final /* synthetic */ C2437i f7232b;

                public void run() {
                    synchronized (this.f7232b.f7234b) {
                        if (this.f7232b.f7235c != null) {
                            this.f7232b.f7235c.mo2380a(c2428e);
                        }
                    }
                }
            });
        }
    }
}
