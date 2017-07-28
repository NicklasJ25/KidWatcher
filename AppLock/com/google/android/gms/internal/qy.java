package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class qy extends Thread {
    private final BlockingQueue<vb<?>> f10425a;
    private final px f10426b;
    private final ej f10427c;
    private final xy f10428d;
    private volatile boolean f10429e = false;

    public qy(BlockingQueue<vb<?>> blockingQueue, px pxVar, ej ejVar, xy xyVar) {
        this.f10425a = blockingQueue;
        this.f10426b = pxVar;
        this.f10427c = ejVar;
        this.f10428d = xyVar;
    }

    @TargetApi(14)
    private void m13494a(vb<?> vbVar) {
        int i = VERSION.SDK_INT;
        TrafficStats.setThreadStatsTag(vbVar.m9051b());
    }

    private void m13495a(vb<?> vbVar, abi com_google_android_gms_internal_abi) {
        this.f10428d.mo3874a((vb) vbVar, vbVar.m9044a(com_google_android_gms_internal_abi));
    }

    public void m13496a() {
        this.f10429e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                vb vbVar = (vb) this.f10425a.take();
                try {
                    vbVar.m9053b("network-queue-take");
                    m13494a(vbVar);
                    sz a = this.f10426b.mo3459a(vbVar);
                    vbVar.m9053b("network-http-complete");
                    if (a.f10643d && vbVar.m9069q()) {
                        vbVar.m9055c("not-modified");
                    } else {
                        wx a2 = vbVar.mo3502a(a);
                        vbVar.m9053b("network-parse-complete");
                        if (vbVar.m9064l() && a2.f11219b != null) {
                            this.f10427c.mo3462a(vbVar.m9056d(), a2.f11219b);
                            vbVar.m9053b("network-cache-written");
                        }
                        vbVar.m9068p();
                        this.f10428d.mo3875a(vbVar, a2);
                    }
                } catch (abi e) {
                    e.m8381a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m13495a(vbVar, e);
                } catch (Throwable e2) {
                    abj.m8756a(e2, "Unhandled exception %s", e2.toString());
                    abi com_google_android_gms_internal_abi = new abi(e2);
                    com_google_android_gms_internal_abi.m8381a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f10428d.mo3874a(vbVar, com_google_android_gms_internal_abi);
                }
            } catch (InterruptedException e3) {
                if (this.f10429e) {
                    return;
                }
            }
        }
    }
}
