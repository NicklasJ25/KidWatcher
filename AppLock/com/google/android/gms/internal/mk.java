package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.ej.C2847a;
import java.util.concurrent.BlockingQueue;

public class mk extends Thread {
    private static final boolean f9838a = abj.f7796b;
    private final BlockingQueue<vb<?>> f9839b;
    private final BlockingQueue<vb<?>> f9840c;
    private final ej f9841d;
    private final xy f9842e;
    private volatile boolean f9843f = false;

    public mk(BlockingQueue<vb<?>> blockingQueue, BlockingQueue<vb<?>> blockingQueue2, ej ejVar, xy xyVar) {
        this.f9839b = blockingQueue;
        this.f9840c = blockingQueue2;
        this.f9841d = ejVar;
        this.f9842e = xyVar;
    }

    public void m12564a() {
        this.f9843f = true;
        interrupt();
    }

    public void run() {
        if (f9838a) {
            abj.m8755a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f9841d.mo3461a();
        while (true) {
            try {
                final vb vbVar = (vb) this.f9839b.take();
                vbVar.m9053b("cache-queue-take");
                C2847a a = this.f9841d.mo3460a(vbVar.m9056d());
                if (a == null) {
                    vbVar.m9053b("cache-miss");
                    this.f9840c.put(vbVar);
                } else if (a.m10622a()) {
                    vbVar.m9053b("cache-hit-expired");
                    vbVar.m9046a(a);
                    this.f9840c.put(vbVar);
                } else {
                    vbVar.m9053b("cache-hit");
                    wx a2 = vbVar.mo3502a(new sz(a.f8827a, a.f8833g));
                    vbVar.m9053b("cache-hit-parsed");
                    if (a.m10623b()) {
                        vbVar.m9053b("cache-hit-refresh-needed");
                        vbVar.m9046a(a);
                        a2.f11221d = true;
                        this.f9842e.mo3876a(vbVar, a2, new Runnable(this) {
                            final /* synthetic */ mk f9837b;

                            public void run() {
                                try {
                                    this.f9837b.f9840c.put(vbVar);
                                } catch (InterruptedException e) {
                                }
                            }
                        });
                    } else {
                        this.f9842e.mo3875a(vbVar, a2);
                    }
                }
            } catch (InterruptedException e) {
                if (this.f9843f) {
                    return;
                }
            }
        }
    }
}
