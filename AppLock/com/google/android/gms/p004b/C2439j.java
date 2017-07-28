package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class C2439j<TResult> implements C2436l<TResult> {
    private final Executor f7238a;
    private final Object f7239b = new Object();
    private C2425b f7240c;

    public C2439j(@NonNull Executor executor, @NonNull C2425b c2425b) {
        this.f7238a = executor;
        this.f7240c = c2425b;
    }

    public void mo3305a(@NonNull final C2428e<TResult> c2428e) {
        if (!c2428e.mo3310a()) {
            synchronized (this.f7239b) {
                if (this.f7240c == null) {
                    return;
                }
                this.f7238a.execute(new Runnable(this) {
                    final /* synthetic */ C2439j f7237b;

                    public void run() {
                        synchronized (this.f7237b.f7239b) {
                            if (this.f7237b.f7240c != null) {
                                this.f7237b.f7240c.mo3595a(c2428e.mo3312c());
                            }
                        }
                    }
                });
            }
        }
    }
}
