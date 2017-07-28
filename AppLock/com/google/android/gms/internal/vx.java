package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@wh
public class vx extends zg {
    private final C2360a f11056a;
    private final zzmn f11057b;
    private final C3457a f11058c;
    private final vz f11059d;
    private final Object f11060e;
    private Future<yy> f11061f;

    public vx(Context context, zzs com_google_android_gms_ads_internal_zzs, C3457a c3457a, ed edVar, C2360a c2360a, qj qjVar) {
        this(c3457a, c2360a, new vz(context, com_google_android_gms_ads_internal_zzs, new zs(context), edVar, c3457a, qjVar));
    }

    vx(C3457a c3457a, C2360a c2360a, vz vzVar) {
        this.f11060e = new Object();
        this.f11058c = c3457a;
        this.f11057b = c3457a.f11510b;
        this.f11056a = c2360a;
        this.f11059d = vzVar;
    }

    private yy m14392a(int i) {
        return new yy(this.f11058c.f11509a.f11994c, null, null, i, null, null, this.f11057b.f12046l, this.f11057b.f12045k, this.f11058c.f11509a.f12000i, false, null, null, null, null, null, this.f11057b.f12043i, this.f11058c.f11512d, this.f11057b.f12041g, this.f11058c.f11514f, this.f11057b.f12048n, this.f11057b.f12049o, this.f11058c.f11516h, null, null, null, null, this.f11058c.f11510b.f12023F, this.f11058c.f11510b.f12024G, null, null, this.f11057b.f12031N);
    }

    public void onStop() {
        synchronized (this.f11060e) {
            if (this.f11061f != null) {
                this.f11061f.cancel(true);
            }
        }
    }

    public void zzco() {
        yy yyVar;
        int i;
        try {
            synchronized (this.f11060e) {
                this.f11061f = zk.m15080a(this.f11059d);
            }
            yyVar = (yy) this.f11061f.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            aad.m8426e("Timed out waiting for native ad.");
            this.f11061f.cancel(true);
            i = 2;
            yyVar = null;
        } catch (ExecutionException e2) {
            yyVar = null;
            i = 0;
        } catch (InterruptedException e3) {
            yyVar = null;
            i = 0;
        } catch (CancellationException e4) {
            yyVar = null;
            i = 0;
        }
        if (yyVar == null) {
            yyVar = m14392a(i);
        }
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ vx f11055b;

            public void run() {
                this.f11055b.f11056a.zzb(yyVar);
            }
        });
    }
}
