package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.C2513c;

@wh
public class zt {
    private HandlerThread f11742a = null;
    private Handler f11743b = null;
    private int f11744c = 0;
    private final Object f11745d = new Object();

    class C35091 implements Runnable {
        final /* synthetic */ zt f11741a;

        C35091(zt ztVar) {
            this.f11741a = ztVar;
        }

        public void run() {
            synchronized (this.f11741a.f11745d) {
                zh.m15051a("Suspending the looper thread");
                while (this.f11741a.f11744c == 0) {
                    try {
                        this.f11741a.f11745d.wait();
                        zh.m15051a("Looper thread resumed");
                    } catch (InterruptedException e) {
                        zh.m15051a("Looper thread interrupted.");
                    }
                }
            }
        }
    }

    public Looper m15277a() {
        Looper looper;
        synchronized (this.f11745d) {
            if (this.f11744c != 0) {
                C2513c.m7933a(this.f11742a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f11742a == null) {
                zh.m15051a("Starting the looper thread.");
                this.f11742a = new HandlerThread("LooperProvider");
                this.f11742a.start();
                this.f11743b = new Handler(this.f11742a.getLooper());
                zh.m15051a("Looper thread started.");
            } else {
                zh.m15051a("Resuming the looper thread");
                this.f11745d.notifyAll();
            }
            this.f11744c++;
            looper = this.f11742a.getLooper();
        }
        return looper;
    }

    public void m15278b() {
        synchronized (this.f11745d) {
            C2513c.m7942b(this.f11744c > 0, "Invalid state: release() called more times than expected.");
            int i = this.f11744c - 1;
            this.f11744c = i;
            if (i == 0) {
                this.f11743b.post(new C35091(this));
            }
        }
    }
}
