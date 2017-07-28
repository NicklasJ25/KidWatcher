package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.C2513c;

abstract class cr {
    private static volatile Handler f8274b;
    private final dk f8275a;
    private final Runnable f8276c = new C27521(this);
    private volatile long f8277d;
    private boolean f8278e = true;

    class C27521 implements Runnable {
        final /* synthetic */ cr f8273a;

        C27521(cr crVar) {
            this.f8273a = crVar;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f8273a.f8275a.m10036h().m9938a((Runnable) this);
                return;
            }
            boolean b = this.f8273a.m9619b();
            this.f8273a.f8277d = 0;
            if (b && this.f8273a.f8278e) {
                this.f8273a.mo3570a();
            }
        }
    }

    cr(dk dkVar) {
        C2513c.m7932a((Object) dkVar);
        this.f8275a = dkVar;
    }

    private Handler m9616d() {
        if (f8274b != null) {
            return f8274b;
        }
        Handler handler;
        synchronized (cr.class) {
            if (f8274b == null) {
                f8274b = new Handler(this.f8275a.m10047s().getMainLooper());
            }
            handler = f8274b;
        }
        return handler;
    }

    public abstract void mo3570a();

    public void m9618a(long j) {
        m9620c();
        if (j >= 0) {
            this.f8277d = this.f8275a.m10048t().mo3360a();
            if (!m9616d().postDelayed(this.f8276c, j)) {
                this.f8275a.m10034f().m9815x().m9775a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean m9619b() {
        return this.f8277d != 0;
    }

    public void m9620c() {
        this.f8277d = 0;
        m9616d().removeCallbacks(this.f8276c);
    }
}
