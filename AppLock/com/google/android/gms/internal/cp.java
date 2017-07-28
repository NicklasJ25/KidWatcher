package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.android.gallery3d.data.MediaSet;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.common.util.C2591p;
import com.google.android.gms.internal.cx.C2753a;
import java.lang.reflect.InvocationTargetException;

public class cp extends dm {
    static final String f8258a = String.valueOf(C2480k.f7315b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean f8259b;

    cp(dk dkVar) {
        super(dkVar);
    }

    int m9468A() {
        return 40;
    }

    int m9469B() {
        return 100;
    }

    int m9470C() {
        return 256;
    }

    int m9471D() {
        return 1000;
    }

    public int m9472E() {
        return 36;
    }

    public int m9473F() {
        return 2048;
    }

    int m9474G() {
        return MediaSet.MEDIAITEM_BATCH_FETCH_COUNT;
    }

    public long m9475H() {
        return (long) ((Integer) cx.f8325q.m9669b()).intValue();
    }

    public long m9476I() {
        return (long) ((Integer) cx.f8327s.m9669b()).intValue();
    }

    int m9477J() {
        return 25;
    }

    int m9478K() {
        return 1000;
    }

    int m9479L() {
        return 25;
    }

    int m9480M() {
        return 1000;
    }

    long m9481N() {
        return 15552000000L;
    }

    long m9482O() {
        return 15552000000L;
    }

    long m9483P() {
        return 3600000;
    }

    long m9484Q() {
        return 60000;
    }

    long m9485R() {
        return 61000;
    }

    long m9486S() {
        return ((Long) cx.f8308M.m9669b()).longValue();
    }

    public String m9487T() {
        return "google_app_measurement.db";
    }

    String m9488U() {
        return "google_app_measurement_local.db";
    }

    public long m9489V() {
        return 10260;
    }

    public boolean m9490W() {
        return false;
    }

    public boolean m9491X() {
        if (this.f8259b == null) {
            synchronized (this) {
                if (this.f8259b == null) {
                    ApplicationInfo applicationInfo = mo3541n().getApplicationInfo();
                    String a = C2591p.m8319a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f8259b = Boolean.valueOf(z);
                    }
                    if (this.f8259b == null) {
                        this.f8259b = Boolean.TRUE;
                        mo3548u().m9815x().m9774a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f8259b.booleanValue();
    }

    public boolean m9492Y() {
        Boolean g = m9510g("firebase_analytics_collection_deactivated");
        return g != null && g.booleanValue();
    }

    public Boolean m9493Z() {
        return m9510g("firebase_analytics_collection_enabled");
    }

    public int m9494a(@Size(min = 1) String str) {
        return Math.max(0, Math.min(1000000, m9499b(str, cx.f8326r)));
    }

    public long m9495a(String str, C2753a<Long> c2753a) {
        if (str == null) {
            return ((Long) c2753a.m9669b()).longValue();
        }
        Object a = mo3545r().m9894a(str, c2753a.m9668a());
        if (TextUtils.isEmpty(a)) {
            return ((Long) c2753a.m9669b()).longValue();
        }
        try {
            return ((Long) c2753a.m9667a(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) c2753a.m9669b()).longValue();
        }
    }

    String m9496a() {
        return (String) cx.f8315g.m9669b();
    }

    public String m9497a(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) cx.f8319k.m9669b()).encodedAuthority((String) cx.f8320l.m9669b());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(10260));
        return builder.build().toString();
    }

    public boolean aa() {
        return ab.m8742b();
    }

    public long ab() {
        return ((Long) cx.f8305J.m9669b()).longValue();
    }

    public long ac() {
        return ((Long) cx.f8300E.m9669b()).longValue();
    }

    public long ad() {
        return ((Long) cx.f8301F.m9669b()).longValue();
    }

    public long ae() {
        return 1000;
    }

    public long af() {
        return Math.max(0, ((Long) cx.f8317i.m9669b()).longValue());
    }

    public int ag() {
        return Math.max(0, ((Integer) cx.f8323o.m9669b()).intValue());
    }

    public int ah() {
        return Math.max(1, ((Integer) cx.f8324p.m9669b()).intValue());
    }

    public int ai() {
        return 100000;
    }

    public String aj() {
        return (String) cx.f8331w.m9669b();
    }

    public long ak() {
        return ((Long) cx.f8318j.m9669b()).longValue();
    }

    public long al() {
        return Math.max(0, ((Long) cx.f8332x.m9669b()).longValue());
    }

    public long am() {
        return Math.max(0, ((Long) cx.f8334z.m9669b()).longValue());
    }

    public long an() {
        return Math.max(0, ((Long) cx.f8296A.m9669b()).longValue());
    }

    public long ao() {
        return Math.max(0, ((Long) cx.f8297B.m9669b()).longValue());
    }

    public long ap() {
        return Math.max(0, ((Long) cx.f8298C.m9669b()).longValue());
    }

    public long aq() {
        return Math.max(0, ((Long) cx.f8299D.m9669b()).longValue());
    }

    public long ar() {
        return ((Long) cx.f8333y.m9669b()).longValue();
    }

    public long as() {
        return Math.max(0, ((Long) cx.f8302G.m9669b()).longValue());
    }

    public long at() {
        return Math.max(0, ((Long) cx.f8303H.m9669b()).longValue());
    }

    public int au() {
        return Math.min(20, Math.max(0, ((Integer) cx.f8304I.m9669b()).intValue()));
    }

    public String av() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            mo3548u().m9815x().m9775a("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            mo3548u().m9815x().m9775a("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            mo3548u().m9815x().m9775a("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            mo3548u().m9815x().m9775a("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    public int m9498b(@Size(min = 1) String str) {
        return m9499b(str, cx.f8328t);
    }

    public int m9499b(String str, C2753a<Integer> c2753a) {
        if (str == null) {
            return ((Integer) c2753a.m9669b()).intValue();
        }
        Object a = mo3545r().m9894a(str, c2753a.m9668a());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) c2753a.m9669b()).intValue();
        }
        try {
            return ((Integer) c2753a.m9667a(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) c2753a.m9669b()).intValue();
        }
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public int m9501c(@Size(min = 1) String str) {
        return m9499b(str, cx.f8329u);
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    long m9503d(String str) {
        return m9495a(str, cx.f8316h);
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    int m9505e(String str) {
        return m9499b(str, cx.f8306K);
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    int m9507f(String str) {
        return Math.max(0, Math.min(2000, m9499b(str, cx.f8307L)));
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    @Nullable
    Boolean m9510g(@Size(min = 1) String str) {
        Boolean bool = null;
        C2513c.m7934a(str);
        try {
            if (mo3541n().getPackageManager() == null) {
                mo3548u().m9815x().m9774a("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo a = bm.m9120b(mo3541n()).m9114a(mo3541n().getPackageName(), 128);
                if (a == null) {
                    mo3548u().m9815x().m9774a("Failed to load metadata: ApplicationInfo is null");
                } else if (a.metaData == null) {
                    mo3548u().m9815x().m9774a("Failed to load metadata: Metadata bundle is null");
                } else if (a.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(a.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            mo3548u().m9815x().m9775a("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public int m9511h(String str) {
        return m9499b(str, cx.f8321m);
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public int m9513i(String str) {
        return Math.max(0, m9499b(str, cx.f8322n));
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public int m9515j(String str) {
        return Math.max(0, Math.min(1000000, m9499b(str, cx.f8330v)));
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

    public int m9530x() {
        return 25;
    }

    public int m9531y() {
        return 40;
    }

    public int m9532z() {
        return 24;
    }
}
