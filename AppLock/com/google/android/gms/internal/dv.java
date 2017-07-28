package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.C2580e;

public class dv extends dn {
    private boolean f8698a;
    private final AlarmManager f8699b = ((AlarmManager) mo3541n().getSystemService("alarm"));
    private final cr f8700c;

    protected dv(dk dkVar) {
        super(dkVar);
        this.f8700c = new cr(this, dkVar) {
            final /* synthetic */ dv f8697a;

            public void mo3570a() {
                this.f8697a.m10329z();
            }
        };
    }

    private PendingIntent m10328y() {
        Intent intent = new Intent();
        Context n = mo3541n();
        mo3550w().m9490W();
        intent = intent.setClassName(n, "com.google.android.gms.measurement.AppMeasurementReceiver");
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo3541n(), 0, intent, 0);
    }

    private void m10329z() {
        Intent intent = new Intent();
        Context n = mo3541n();
        mo3550w().m9490W();
        intent = intent.setClassName(n, "com.google.android.gms.measurement.AppMeasurementReceiver");
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        mo3541n().sendBroadcast(intent);
    }

    protected void mo3551a() {
        this.f8699b.cancel(m10328y());
    }

    public void m10331a(long j) {
        m9448R();
        mo3550w().m9490W();
        if (!dh.m9887a(mo3541n(), false)) {
            mo3548u().m9785C().m9774a("Receiver not registered/enabled");
        }
        mo3550w().m9490W();
        if (!ds.m10278a(mo3541n(), false)) {
            mo3548u().m9785C().m9774a("Service not registered/enabled");
        }
        m10354x();
        long b = mo3540m().mo3361b() + j;
        this.f8698a = true;
        if (j < mo3550w().aq() && !this.f8700c.m9619b()) {
            this.f8700c.m9618a(j);
        }
        this.f8699b.setInexactRepeating(2, b, Math.max(mo3550w().ar(), j), m10328y());
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

    public void m10354x() {
        m9448R();
        this.f8698a = false;
        this.f8699b.cancel(m10328y());
        this.f8700c.m9620c();
    }
}
