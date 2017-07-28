package com.google.android.gms.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class hu implements he {
    private final ThreadPoolExecutor f9365a;

    public hu(final ThreadFactory threadFactory, final ht htVar) {
        int i = 1;
        this.f9365a = new ThreadPoolExecutor(1, i, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) {
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory.newThread(runnable);
                htVar.mo3701a(newThread, "FirebaseDatabaseEventTarget");
                htVar.mo3703a(newThread, true);
                return newThread;
            }
        });
    }

    public void mo3599a() {
        this.f9365a.setCorePoolSize(1);
    }

    public void mo3600a(Runnable runnable) {
        this.f9365a.execute(runnable);
    }
}
