package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.internal.dc.C2759a;
import com.google.android.gms.measurement.AppMeasurement.C2803f;
import com.google.android.gms.measurement.AppMeasurement.C3519d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class dq extends dn {
    protected C2804a f8615a;
    private volatile C2803f f8616b;
    private C2803f f8617c;
    private long f8618d;
    private final Map<Activity, C2804a> f8619e = new ArrayMap();
    private final CopyOnWriteArrayList<C3519d> f8620f = new CopyOnWriteArrayList();
    private boolean f8621g;
    private C2803f f8622h;
    private String f8623i;

    static class C2804a extends C2803f {
        public boolean f8614a;

        public C2804a(C2804a c2804a) {
            this.b = c2804a.b;
            this.c = c2804a.c;
            this.d = c2804a.d;
            this.f8614a = c2804a.f8614a;
        }

        public C2804a(String str, String str2, long j) {
            this.b = str;
            this.c = str2;
            this.d = j;
            this.f8614a = false;
        }
    }

    public dq(dk dkVar) {
        super(dkVar);
    }

    static String m10174a(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str.substring(0, 36);
        }
        String str2 = split[split.length - 1];
        return str2.length() > 36 ? str2.substring(0, 36) : str2;
    }

    @MainThread
    private void m10175a(Activity activity, C2804a c2804a, final boolean z) {
        int i = 1;
        C2803f c2803f = this.f8616b != null ? this.f8616b : (this.f8617c == null || Math.abs(mo3540m().mo3361b() - this.f8618d) >= 1000) ? null : this.f8617c;
        c2803f = c2803f != null ? new C2803f(c2803f) : null;
        this.f8621g = true;
        try {
            Iterator it = this.f8620f.iterator();
            while (it.hasNext()) {
                int a;
                try {
                    a = ((C3519d) it.next()).m15405a(c2803f, c2804a) & i;
                } catch (Exception e) {
                    mo3548u().m9815x().m9775a("onScreenChangeCallback threw exception", e);
                    a = i;
                }
                i = a;
            }
        } catch (Exception e2) {
            mo3548u().m9815x().m9775a("onScreenChangeCallback loop threw exception", e2);
        } finally {
            this.f8621g = false;
        }
        if (i != 0) {
            if (c2804a.c == null) {
                c2804a.c = m10174a(activity.getClass().getCanonicalName());
            }
            final C2803f c2804a2 = new C2804a(c2804a);
            this.f8617c = this.f8616b;
            this.f8618d = mo3540m().mo3361b();
            this.f8616b = c2804a2;
            mo3547t().m9938a(new Runnable(this) {
                final /* synthetic */ dq f8608c;

                public void run() {
                    if (z && this.f8608c.f8615a != null) {
                        this.f8608c.m10176a(this.f8608c.f8615a);
                    }
                    this.f8608c.f8615a = c2804a2;
                    this.f8608c.mo3538k().m10245a(c2804a2);
                }
            });
        }
    }

    @WorkerThread
    private void m10176a(@NonNull C2804a c2804a) {
        mo3533f().m9369a(mo3540m().mo3361b());
        if (mo3546s().m10297a(c2804a.f8614a)) {
            c2804a.f8614a = false;
        }
    }

    public static void m10178a(C2803f c2803f, Bundle bundle) {
        if (bundle != null && c2803f != null && !bundle.containsKey("_sc")) {
            if (c2803f.f8611b != null) {
                bundle.putString("_sn", c2803f.f8611b);
            }
            bundle.putString("_sc", c2803f.f8612c);
            bundle.putLong("_si", c2803f.f8613d);
        }
    }

    @MainThread
    C2804a m10179a(@NonNull Activity activity) {
        C2513c.m7932a((Object) activity);
        C2804a c2804a = (C2804a) this.f8619e.get(activity);
        if (c2804a != null) {
            return c2804a;
        }
        c2804a = new C2804a(null, m10174a(activity.getClass().getCanonicalName()), mo3544q().m10455x());
        this.f8619e.put(activity, c2804a);
        return c2804a;
    }

    protected void mo3551a() {
    }

    @MainThread
    public void m10181a(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service");
            if (bundle2 != null) {
                C2804a a = m10179a(activity);
                a.d = bundle2.getLong("id");
                a.b = bundle2.getString("name");
                a.c = bundle2.getString("referrer_name");
            }
        }
    }

    @MainThread
    public void m10182a(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        int i = VERSION.SDK_INT;
        if (activity == null) {
            mo3548u().m9817z().m9774a("setCurrentScreen must be called with a non-null activity");
        } else if (!mo3547t().m9963x()) {
            mo3548u().m9817z().m9774a("setCurrentScreen must be called from the main thread");
        } else if (this.f8621g) {
            mo3548u().m9817z().m9774a("Cannot call setCurrentScreen from onScreenChangeCallback");
        } else if (this.f8616b == null) {
            mo3548u().m9817z().m9774a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f8619e.get(activity) == null) {
            mo3548u().m9817z().m9774a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = m10174a(activity.getClass().getCanonicalName());
            }
            boolean equals = this.f8616b.f8612c.equals(str2);
            boolean z = (this.f8616b.f8611b == null && str == null) || (this.f8616b.f8611b != null && this.f8616b.f8611b.equals(str));
            if (equals && z) {
                mo3548u().m9783A().m9774a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() < 1 || str.length() > mo3550w().m9469B())) {
                mo3548u().m9817z().m9775a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() >= 1 && str2.length() <= mo3550w().m9469B())) {
                Object obj;
                C2759a D = mo3548u().m9786D();
                String str3 = "Setting current screen to name, class";
                if (str == null) {
                    obj = "null";
                } else {
                    String str4 = str;
                }
                D.m9776a(str3, obj, str2);
                C2804a c2804a = new C2804a(str, str2, mo3544q().m10455x());
                this.f8619e.put(activity, c2804a);
                m10175a(activity, c2804a, true);
            } else {
                mo3548u().m9817z().m9775a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @MainThread
    public void m10183a(@NonNull C3519d c3519d) {
        mo3530c();
        if (c3519d == null) {
            mo3548u().m9817z().m9774a("Attempting to register null OnScreenChangeCallback");
            return;
        }
        this.f8620f.remove(c3519d);
        this.f8620f.add(c3519d);
    }

    @WorkerThread
    public void m10184a(String str, C2803f c2803f) {
        mo3532e();
        synchronized (this) {
            if (this.f8623i == null || this.f8623i.equals(str) || c2803f != null) {
                this.f8623i = str;
                this.f8622h = c2803f;
            }
        }
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    @MainThread
    public void m10186b(Activity activity) {
        m10175a(activity, m10179a(activity), false);
        mo3533f().m9368a();
    }

    @MainThread
    public void m10187b(Activity activity, Bundle bundle) {
        if (bundle != null) {
            C2804a c2804a = (C2804a) this.f8619e.get(activity);
            if (c2804a != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", c2804a.d);
                bundle2.putString("name", c2804a.b);
                bundle2.putString("referrer_name", c2804a.c);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }

    @MainThread
    public void m10188b(@NonNull C3519d c3519d) {
        mo3530c();
        this.f8620f.remove(c3519d);
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    @MainThread
    public void m10190c(Activity activity) {
        final C2804a a = m10179a(activity);
        this.f8617c = this.f8616b;
        this.f8618d = mo3540m().mo3361b();
        this.f8616b = null;
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dq f8610b;

            public void run() {
                this.f8610b.m10176a(a);
                this.f8610b.f8615a = null;
                this.f8610b.mo3538k().m10245a(null);
            }
        });
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    @MainThread
    public void m10192d(Activity activity) {
        this.f8619e.remove(activity);
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

    @WorkerThread
    public C2804a m10212x() {
        m9448R();
        mo3532e();
        return this.f8615a;
    }

    public C2803f m10213y() {
        mo3530c();
        C2803f c2803f = this.f8616b;
        return c2803f == null ? null : new C2803f(c2803f);
    }
}
