package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.C2580e;

public class dt extends dn {
    protected long f8691a;
    private Handler f8692b;
    private final cr f8693c = new cr(this, this.n) {
        final /* synthetic */ dt f8685a;

        @WorkerThread
        public void mo3570a() {
            this.f8685a.m10322z();
        }
    };
    private final cr f8694d = new cr(this, this.n) {
        final /* synthetic */ dt f8686a;

        @WorkerThread
        public void mo3570a() {
            this.f8686a.m10290B();
        }
    };

    dt(dk dkVar) {
        super(dkVar);
    }

    private void m10289A() {
        synchronized (this) {
            if (this.f8692b == null) {
                this.f8692b = new Handler(Looper.getMainLooper());
            }
        }
    }

    @WorkerThread
    private void m10290B() {
        mo3532e();
        m10297a(false);
        mo3533f().m9369a(mo3540m().mo3361b());
    }

    @WorkerThread
    private void m10291a(long j) {
        mo3532e();
        m10289A();
        this.f8693c.m9620c();
        this.f8694d.m9620c();
        mo3548u().m9786D().m9775a("Activity resumed, time", Long.valueOf(j));
        this.f8691a = j;
        if (mo3540m().mo3360a() - mo3549v().f8412i.m9858a() > mo3549v().f8414k.m9858a()) {
            mo3549v().f8413j.m9855a(true);
            mo3549v().f8415l.m9859a(0);
        }
        if (mo3549v().f8413j.m9856a()) {
            this.f8693c.m9618a(Math.max(0, mo3549v().f8411h.m9858a() - mo3549v().f8415l.m9858a()));
        } else {
            this.f8694d.m9618a(Math.max(0, 3600000 - mo3549v().f8415l.m9858a()));
        }
    }

    @WorkerThread
    private void m10294b(long j) {
        mo3532e();
        m10289A();
        this.f8693c.m9620c();
        this.f8694d.m9620c();
        mo3548u().m9786D().m9775a("Activity paused, time", Long.valueOf(j));
        if (this.f8691a != 0) {
            mo3549v().f8415l.m9859a(mo3549v().f8415l.m9858a() + (j - this.f8691a));
        }
        mo3549v().f8414k.m9859a(mo3540m().mo3360a());
    }

    protected void mo3551a() {
    }

    @WorkerThread
    public boolean m10297a(boolean z) {
        mo3532e();
        m9448R();
        long b = mo3540m().mo3361b();
        if (this.f8691a == 0) {
            this.f8691a = b - 3600000;
        }
        long j = b - this.f8691a;
        if (z || j >= 1000) {
            mo3549v().f8415l.m9859a(j);
            mo3548u().m9786D().m9775a("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            dq.m10178a(mo3539l().m10212x(), bundle);
            mo3535h().m10136a("auto", "_e", bundle);
            this.f8691a = b;
            this.f8694d.m9620c();
            this.f8694d.m9618a(Math.max(0, 3600000 - mo3549v().f8415l.m9858a()));
            return true;
        }
        mo3548u().m9786D().m9775a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    @MainThread
    protected void m10320x() {
        final long b = mo3540m().mo3361b();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dt f8688b;

            public void run() {
                this.f8688b.m10291a(b);
            }
        });
    }

    @MainThread
    protected void m10321y() {
        final long b = mo3540m().mo3361b();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dt f8690b;

            public void run() {
                this.f8690b.m10294b(b);
            }
        });
    }

    @WorkerThread
    protected void m10322z() {
        mo3532e();
        mo3548u().m9786D().m9775a("Session started, time", Long.valueOf(mo3540m().mo3361b()));
        mo3549v().f8413j.m9855a(false);
        mo3535h().m10136a("auto", "_s", new Bundle());
    }
}
