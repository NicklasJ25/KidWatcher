package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;
import java.util.concurrent.atomic.AtomicBoolean;

@wh
public abstract class vq implements C2340a, zn<Void> {
    protected final C2360a f11019a;
    protected final Context f11020b;
    protected final aat f11021c;
    protected final C3457a f11022d;
    protected zzmn f11023e;
    protected final Object f11024f = new Object();
    private Runnable f11025g;
    private AtomicBoolean f11026h = new AtomicBoolean(true);

    class C33631 implements Runnable {
        final /* synthetic */ vq f11018a;

        C33631(vq vqVar) {
            this.f11018a = vqVar;
        }

        public void run() {
            if (this.f11018a.f11026h.get()) {
                aad.m8423c("Timed out waiting for WebView to finish loading.");
                this.f11018a.cancel();
            }
        }
    }

    protected vq(Context context, C3457a c3457a, aat com_google_android_gms_internal_aat, C2360a c2360a) {
        this.f11020b = context;
        this.f11022d = c3457a;
        this.f11023e = this.f11022d.f11510b;
        this.f11021c = com_google_android_gms_internal_aat;
        this.f11019a = c2360a;
    }

    private yy m14364b(int i) {
        zzmk com_google_android_gms_internal_zzmk = this.f11022d.f11509a;
        return new yy(com_google_android_gms_internal_zzmk.f11994c, this.f11021c, this.f11023e.f12038d, i, this.f11023e.f12040f, this.f11023e.f12044j, this.f11023e.f12046l, this.f11023e.f12045k, com_google_android_gms_internal_zzmk.f12000i, this.f11023e.f12042h, null, null, null, null, null, this.f11023e.f12043i, this.f11022d.f11512d, this.f11023e.f12041g, this.f11022d.f11514f, this.f11023e.f12048n, this.f11023e.f12049o, this.f11022d.f11516h, null, this.f11023e.f12020C, this.f11023e.f12021D, this.f11023e.f12022E, this.f11023e.f12023F, this.f11023e.f12024G, null, this.f11023e.f12027J, this.f11023e.f12031N);
    }

    public final Void m14365a() {
        C2513c.m7940b("Webview render task needs to be called on UI thread.");
        this.f11025g = new C33631(this);
        zl.f11678a.postDelayed(this.f11025g, ((Long) qb.bG.m13225c()).longValue());
        mo4171b();
        return null;
    }

    protected void mo4172a(int i) {
        if (i != -2) {
            this.f11023e = new zzmn(i, this.f11023e.f12045k);
        }
        this.f11021c.mo3417e();
        this.f11019a.zzb(m14364b(i));
    }

    public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
        int i = 0;
        aad.m8421b("WebView finished loading.");
        if (this.f11026h.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            mo4172a(i);
            zl.f11678a.removeCallbacks(this.f11025g);
        }
    }

    protected abstract void mo4171b();

    public void cancel() {
        if (this.f11026h.getAndSet(false)) {
            this.f11021c.stopLoading();
            zzw.zzcO().m15181a(this.f11021c);
            mo4172a(-1);
            zl.f11678a.removeCallbacks(this.f11025g);
        }
    }

    public /* synthetic */ Object zziP() {
        return m14365a();
    }
}
