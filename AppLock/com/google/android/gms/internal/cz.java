package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C2580e;

public class cz extends dn {
    private String f8336a;
    private String f8337b;
    private int f8338c;
    private String f8339d;
    private String f8340e;
    private long f8341f;
    private long f8342g;
    private int f8343h;
    private String f8344i;

    cz(dk dkVar) {
        super(dkVar);
    }

    int m9701A() {
        m9448R();
        return this.f8338c;
    }

    String m9702B() {
        m9448R();
        return this.f8339d;
    }

    long m9703C() {
        return mo3550w().m9489V();
    }

    @WorkerThread
    long m9704D() {
        m9448R();
        mo3532e();
        if (this.f8341f == 0) {
            this.f8341f = this.n.m10043o().m10415b(mo3541n(), mo3541n().getPackageName());
        }
        return this.f8341f;
    }

    long m9705E() {
        m9448R();
        return 0;
    }

    int m9706F() {
        m9448R();
        return this.f8343h;
    }

    @WorkerThread
    zzatd m9707a(String str) {
        mo3532e();
        return new zzatd(m9732x(), m9733y(), m9734z(), (long) m9701A(), m9702B(), m9703C(), m9704D(), str, this.n.m9989G(), !mo3549v().f8416m, mo3549v().m9885z(), m9705E(), this.n.m9990H(), m9706F());
    }

    protected void mo3551a() {
        int i = 1;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        String str2 = "Unknown";
        int i2 = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = mo3541n().getPackageName();
        PackageManager packageManager = mo3541n().getPackageManager();
        if (packageManager == null) {
            mo3548u().m9815x().m9775a("PackageManager is null, app identity information might be inaccurate. appId", dc.m9779a(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                mo3548u().m9815x().m9775a("Error retrieving app installer package name. appId", dc.m9779a(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(mo3541n().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e2) {
                mo3548u().m9815x().m9776a("Error retrieving package info. appId, appName", dc.m9779a(packageName), str3);
            }
        }
        this.f8336a = packageName;
        this.f8339d = str;
        this.f8337b = str2;
        this.f8338c = i2;
        this.f8340e = str3;
        this.f8341f = 0;
        mo3550w().m9490W();
        Status a = ab.m8739a(mo3541n());
        int i3 = (a == null || !a.m7729d()) ? 0 : 1;
        if (i3 == 0) {
            m9709a(a);
        }
        if (i3 != 0) {
            Boolean Z = mo3550w().m9493Z();
            if (mo3550w().m9492Y()) {
                mo3548u().m9784B().m9774a("Collection disabled with firebase_analytics_collection_deactivated=1");
                i3 = 0;
            } else if (Z != null && !Z.booleanValue()) {
                mo3548u().m9784B().m9774a("Collection disabled with firebase_analytics_collection_enabled=0");
                i3 = 0;
            } else if (Z == null && mo3550w().aa()) {
                mo3548u().m9784B().m9774a("Collection disabled with google_app_measurement_enable=0");
                i3 = 0;
            } else {
                mo3548u().m9786D().m9774a("Collection enabled");
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        this.f8344i = "";
        this.f8342g = 0;
        mo3550w().m9490W();
        try {
            String a2 = ab.m8741a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            this.f8344i = a2;
            if (i3 != 0) {
                mo3548u().m9786D().m9776a("App package, google app id", this.f8336a, this.f8344i);
            }
        } catch (IllegalStateException e3) {
            mo3548u().m9815x().m9776a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", dc.m9779a(packageName), e3);
        }
        if (VERSION.SDK_INT >= 16) {
            if (!bk.m9111a(mo3541n())) {
                i = 0;
            }
            this.f8343h = i;
            return;
        }
        this.f8343h = 0;
    }

    protected void m9709a(Status status) {
        if (status == null) {
            mo3548u().m9815x().m9774a("GoogleService failed to initialize (no status)");
        } else {
            mo3548u().m9815x().m9776a("GoogleService failed to initialize, status", Integer.valueOf(status.m7730e()), status.m7728c());
        }
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

    String m9732x() {
        m9448R();
        return this.f8336a;
    }

    String m9733y() {
        m9448R();
        return this.f8344i;
    }

    String m9734z() {
        m9448R();
        return this.f8337b;
    }
}
