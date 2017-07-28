package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.measurement.AppMeasurement.C2803f;
import java.util.Map;

public class ck extends dm {
    private final Map<String, Long> f8228a = new ArrayMap();
    private final Map<String, Integer> f8229b = new ArrayMap();
    private long f8230c;

    public ck(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    private void m9360a(long j, C2803f c2803f) {
        if (c2803f == null) {
            mo3548u().m9786D().m9774a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            mo3548u().m9786D().m9775a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            dq.m10178a(c2803f, bundle);
            mo3535h().m10136a("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private void m9363a(String str, long j) {
        mo3530c();
        mo3532e();
        C2513c.m7934a(str);
        if (this.f8229b.isEmpty()) {
            this.f8230c = j;
        }
        Integer num = (Integer) this.f8229b.get(str);
        if (num != null) {
            this.f8229b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f8229b.size() >= 100) {
            mo3548u().m9817z().m9774a("Too many ads visible");
        } else {
            this.f8229b.put(str, Integer.valueOf(1));
            this.f8228a.put(str, Long.valueOf(j));
        }
    }

    @WorkerThread
    private void m9364a(String str, long j, C2803f c2803f) {
        if (c2803f == null) {
            mo3548u().m9786D().m9774a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            mo3548u().m9786D().m9775a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            dq.m10178a(c2803f, bundle);
            mo3535h().m10136a("am", "_xu", bundle);
        }
    }

    @WorkerThread
    private void m9365b(long j) {
        for (String put : this.f8228a.keySet()) {
            this.f8228a.put(put, Long.valueOf(j));
        }
        if (!this.f8228a.isEmpty()) {
            this.f8230c = j;
        }
    }

    @WorkerThread
    private void m9367b(String str, long j) {
        mo3530c();
        mo3532e();
        C2513c.m7934a(str);
        Integer num = (Integer) this.f8229b.get(str);
        if (num != null) {
            C2803f x = mo3539l().m10212x();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f8229b.remove(str);
                Long l = (Long) this.f8228a.get(str);
                if (l == null) {
                    mo3548u().m9815x().m9774a("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.f8228a.remove(str);
                    m9364a(str, longValue, x);
                }
                if (!this.f8229b.isEmpty()) {
                    return;
                }
                if (this.f8230c == 0) {
                    mo3548u().m9815x().m9774a("First ad exposure time was never set");
                    return;
                }
                m9360a(j - this.f8230c, x);
                this.f8230c = 0;
                return;
            }
            this.f8229b.put(str, Integer.valueOf(intValue));
            return;
        }
        mo3548u().m9815x().m9775a("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public void m9368a() {
        final long b = mo3540m().mo3361b();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ ck f8226b;

            public void run() {
                this.f8226b.m9365b(b);
            }
        });
    }

    @WorkerThread
    public void m9369a(long j) {
        C2803f x = mo3539l().m10212x();
        for (String str : this.f8228a.keySet()) {
            m9364a(str, j - ((Long) this.f8228a.get(str)).longValue(), x);
        }
        if (!this.f8228a.isEmpty()) {
            m9360a(j - this.f8230c, x);
        }
        m9365b(j);
    }

    public void m9370a(final String str) {
        int i = VERSION.SDK_INT;
        if (str == null || str.length() == 0) {
            mo3548u().m9815x().m9774a("Ad unit id must be a non-empty string");
            return;
        }
        final long b = mo3540m().mo3361b();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ ck f8221c;

            public void run() {
                this.f8221c.m9363a(str, b);
            }
        });
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public void m9372b(final String str) {
        int i = VERSION.SDK_INT;
        if (str == null || str.length() == 0) {
            mo3548u().m9815x().m9774a("Ad unit id must be a non-empty string");
            return;
        }
        final long b = mo3540m().mo3361b();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ ck f8224c;

            public void run() {
                this.f8224c.m9367b(str, b);
            }
        });
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
}
