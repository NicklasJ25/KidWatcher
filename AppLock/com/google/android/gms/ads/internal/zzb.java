package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzg;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aag;
import com.google.android.gms.internal.aaj;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.se;
import com.google.android.gms.internal.tc;
import com.google.android.gms.internal.ts;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.vf;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vk;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yz;
import com.google.android.gms.internal.za;
import com.google.android.gms.internal.zk;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzmk.C3513a;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzqh;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@wh
public abstract class zzb extends zza implements zzh, zzj, zzu, se, ts {
    protected final ub f6937j;
    protected transient boolean f6938k;

    class C23621 implements Callable<Boolean> {
        final /* synthetic */ zzb f6926a;

        C23621(zzb com_google_android_gms_ads_internal_zzb) {
            this.f6926a = com_google_android_gms_ads_internal_zzb;
        }

        public Boolean m7476a() {
            return Boolean.valueOf(false);
        }

        public /* synthetic */ Object call() {
            return m7476a();
        }
    }

    class C23632 implements Callable<String> {
        final /* synthetic */ zzb f6927a;

        C23632(zzb com_google_android_gms_ads_internal_zzb) {
            this.f6927a = com_google_android_gms_ads_internal_zzb;
        }

        public String m7477a() {
            String str = "";
            if (((Boolean) qb.cV.m13225c()).booleanValue()) {
                CookieManager c = zzw.zzcO().mo4267c(this.f6927a.f.zzqn);
                if (c != null) {
                    return c.getCookie("googleads.g.doubleclick.net");
                }
            }
            return str;
        }

        public /* synthetic */ Object call() {
            return m7477a();
        }
    }

    class C23643 implements Callable<String> {
        final /* synthetic */ zzb f6928a;

        C23643(zzb com_google_android_gms_ads_internal_zzb) {
            this.f6928a = com_google_android_gms_ads_internal_zzb;
        }

        public String m7478a() {
            return this.f6928a.f.f7109b.m10561a().mo3151a(this.f6928a.f.zzqn);
        }

        public /* synthetic */ Object call() {
            return m7478a();
        }
    }

    class C23676 implements Runnable {
        final /* synthetic */ zzb f6935a;

        C23676(zzb com_google_android_gms_ads_internal_zzb) {
            this.f6935a = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.f6935a.e.pause();
        }
    }

    class C23687 implements Runnable {
        final /* synthetic */ zzb f6936a;

        C23687(zzb com_google_android_gms_ads_internal_zzb) {
            this.f6936a = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.f6936a.e.resume();
        }
    }

    public zzb(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this(new zzx(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzqh), ubVar, null, com_google_android_gms_ads_internal_zze);
    }

    protected zzb(zzx com_google_android_gms_ads_internal_zzx, ub ubVar, @Nullable zzt com_google_android_gms_ads_internal_zzt, zze com_google_android_gms_ads_internal_zze) {
        super(com_google_android_gms_ads_internal_zzx, com_google_android_gms_ads_internal_zzt, com_google_android_gms_ads_internal_zze);
        this.f6937j = ubVar;
        this.f6938k = false;
    }

    private C3513a m7479a(zzec com_google_android_gms_internal_zzec, Bundle bundle, za zaVar) {
        PackageInfo b;
        ApplicationInfo applicationInfo = this.f.zzqn.getApplicationInfo();
        try {
            b = bm.m9120b(this.f.zzqn).m9118b(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            b = null;
        }
        DisplayMetrics displayMetrics = this.f.zzqn.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.f.f7110c == null || this.f.f7110c.getParent() == null)) {
            int[] iArr = new int[2];
            this.f.f7110c.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.f.f7110c.getWidth();
            int height = this.f.f7110c.getHeight();
            int i3 = 0;
            if (this.f.f7110c.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String d = zzw.zzcQ().m15012d();
        this.f.zzvu = new yz(d, this.f.zzvl);
        this.f.zzvu.m14970a(com_google_android_gms_internal_zzec);
        String a = zzw.zzcM().m15104a(this.f.zzqn, this.f.f7110c, this.f.zzvr);
        long j = 0;
        if (this.f.f7114g != null) {
            try {
                j = this.f.f7114g.mo3864b();
            } catch (RemoteException e2) {
                aad.m8426e("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle a2 = zzw.zzcQ().m14987a(this.f.zzqn, this, d);
        List arrayList = new ArrayList();
        for (i = 0; i < this.f.f7120m.size(); i++) {
            arrayList.add((String) this.f.f7120m.keyAt(i));
        }
        final boolean z = this.f.f7115h != null;
        final boolean z2 = this.f.f7116i != null && zzw.zzcQ().m15033v();
        final aaj a3 = zk.m15080a(new C23621(this));
        Future a4 = zk.m15080a(new C23632(this));
        Future a5 = zk.m15080a(new C23643(this));
        String str = null;
        if (zaVar != null) {
            str = zaVar.m14983c();
        }
        final aag com_google_android_gms_internal_aag = new aag();
        a3.mo3377a(new Runnable(this) {
            public void run() {
                boolean z = false;
                try {
                    z = a3.isDone() ? ((Boolean) a3.get()).booleanValue() : false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable e2) {
                    aad.m8422b("Error receiving app streaming support", e2);
                }
                com_google_android_gms_internal_aag.m8436b(new zzmr(z, z2, z));
            }
        });
        return new C3513a(bundle2, com_google_android_gms_internal_zzec, this.f.zzvr, this.f.zzvl, applicationInfo, b, d, zzw.zzcQ().m14989a(), this.f.zzvn, a2, this.f.f7126s, arrayList, bundle, zzw.zzcQ().m15019h(), displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, a, j, uuid, qb.m13267a(), this.f.f7108a, this.f.f7121n, com_google_android_gms_internal_aag, this.f.zzdu(), zzw.zzcM().m15157g(), zzw.zzcM().m15160h(), zzw.zzcM().m15164k(this.f.zzqn), zzw.zzcM().m15136b(this.f.f7110c), this.f.zzqn instanceof Activity, zzw.zzcQ().m15024m(), a4, str, zzw.zzcQ().m15028q(), zzw.zzdj().m13741a(), zzw.zzcM().m15162i(), zzw.zzcU().m15239a(), this.f.f7123p, zzw.zzcU().m15247b(), tc.m13885a().m13894i(), zzw.zzcQ().m15011c(this.f.zzqn, this.f.zzvl), a5);
    }

    protected void mo3270a(@Nullable yy yyVar, boolean z) {
        if (yyVar == null) {
            aad.m8426e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.m7471b(yyVar);
        if (!(yyVar.f11543r == null || yyVar.f11543r.f10790d == null)) {
            String d = zzw.zzdl().m14950d(this.f.zzqn);
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, yyVar, this.f.zzvl, z, m7463a(d, yyVar.f11543r.f10790d));
            if (yyVar.f11543r.f10790d.size() > 0) {
                zzw.zzdl().m14951d(this.f.zzqn, d);
            }
        }
        if (yyVar.f11540o != null && yyVar.f11540o.f10777g != null) {
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, yyVar, this.f.zzvl, z, yyVar.f11540o.f10777g);
        }
    }

    boolean mo3239a(yy yyVar) {
        zzec com_google_android_gms_internal_zzec;
        boolean z = false;
        if (this.g != null) {
            com_google_android_gms_internal_zzec = this.g;
            this.g = null;
        } else {
            com_google_android_gms_internal_zzec = yyVar.f11526a;
            if (com_google_android_gms_internal_zzec.f11879c != null) {
                z = com_google_android_gms_internal_zzec.f11879c.getBoolean("_noRefresh", false);
            }
        }
        return mo3284a(com_google_android_gms_internal_zzec, yyVar, z);
    }

    protected boolean mo3240a(zzec com_google_android_gms_internal_zzec) {
        return super.mo3240a(com_google_android_gms_internal_zzec) && !this.f6938k;
    }

    protected boolean mo3284a(zzec com_google_android_gms_internal_zzec, yy yyVar, boolean z) {
        if (!z && this.f.zzdq()) {
            if (yyVar.f11533h > 0) {
                this.e.zza(com_google_android_gms_internal_zzec, yyVar.f11533h);
            } else if (yyVar.f11543r != null && yyVar.f11543r.f10795i > 0) {
                this.e.zza(com_google_android_gms_internal_zzec, yyVar.f11543r.f10795i);
            } else if (!yyVar.f11539n && yyVar.f11529d == 2) {
                this.e.zzh(com_google_android_gms_internal_zzec);
            }
        }
        return this.e.zzcy();
    }

    protected boolean mo3241f() {
        return zzw.zzcM().m15131a(this.f.zzqn, this.f.zzqn.getPackageName(), "android.permission.INTERNET") && zzw.zzcM().m15130a(this.f.zzqn);
    }

    public String getMediationAdapterClassName() {
        return this.f.zzvs == null ? null : this.f.zzvs.f11542q;
    }

    public void onAdClicked() {
        if (this.f.zzvs == null) {
            aad.m8426e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.f.zzvs.f11543r == null || this.f.zzvs.f11543r.f10789c == null)) {
            String d = zzw.zzdl().m14950d(this.f.zzqn);
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs, this.f.zzvl, false, m7463a(d, this.f.zzvs.f11543r.f10789c));
            if (this.f.zzvs.f11543r.f10789c.size() > 0) {
                zzw.zzdl().m14948c(this.f.zzqn, d);
            }
        }
        if (!(this.f.zzvs.f11540o == null || this.f.zzvs.f11540o.f10776f == null)) {
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs, this.f.zzvl, false, this.f.zzvs.f11540o.f10776f);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.h.m12640d(this.f.zzvs);
    }

    public void onResume() {
        this.h.m12641e(this.f.zzvs);
    }

    public void pause() {
        C2513c.m7940b("pause must be called on the main UI thread.");
        if (!(this.f.zzvs == null || this.f.zzvs.f11527b == null || !this.f.zzdq())) {
            zzw.zzcO().m15181a(this.f.zzvs.f11527b);
        }
        if (!(this.f.zzvs == null || this.f.zzvs.f11541p == null)) {
            try {
                this.f.zzvs.f11541p.mo4075d();
            } catch (RemoteException e) {
                aad.m8426e("Could not pause mediation adapter.");
            }
        }
        this.h.m12640d(this.f.zzvs);
        this.e.pause();
    }

    public void recordImpression() {
        mo3270a(this.f.zzvs, false);
    }

    public void resume() {
        C2513c.m7940b("resume must be called on the main UI thread.");
        aat com_google_android_gms_internal_aat = null;
        if (!(this.f.zzvs == null || this.f.zzvs.f11527b == null)) {
            com_google_android_gms_internal_aat = this.f.zzvs.f11527b;
        }
        if (com_google_android_gms_internal_aat != null && this.f.zzdq()) {
            zzw.zzcO().m15185b(this.f.zzvs.f11527b);
        }
        if (!(this.f.zzvs == null || this.f.zzvs.f11541p == null)) {
            try {
                this.f.zzvs.f11541p.mo4076e();
            } catch (RemoteException e) {
                aad.m8426e("Could not resume mediation adapter.");
            }
        }
        if (com_google_android_gms_internal_aat == null || !com_google_android_gms_internal_aat.mo3443u()) {
            this.e.resume();
        }
        this.h.m12641e(this.f.zzvs);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(vg vgVar) {
        C2513c.m7940b("setInAppPurchaseListener must be called on the main UI thread.");
        this.f.f7115h = vgVar;
    }

    public void zza(vk vkVar, @Nullable String str) {
        C2513c.m7940b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f.f7127t = new zzk(str);
        this.f.f7116i = vkVar;
        if (!zzw.zzcQ().m15018g() && vkVar != null) {
            new zzc(this.f.zzqn, this.f.f7116i, this.f.f7127t).zziP();
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        vf com_google_android_gms_ads_internal_purchase_zzd = new zzd(str, arrayList, this.f.zzqn, this.f.zzvn.f12081a);
        if (this.f.f7115h == null) {
            aad.m8426e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!ol.m12979a().m8414c(this.f.zzqn)) {
                aad.m8426e("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.f.f7116i == null) {
                aad.m8426e("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.f.f7127t == null) {
                aad.m8426e("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.f.f7129v) {
                aad.m8426e("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.f.f7129v = true;
                try {
                    if (this.f.f7116i.mo4162a(str)) {
                        zzw.zzda().zza(this.f.zzqn, this.f.zzvn.f12084d, new GInAppPurchaseManagerInfoParcel(this.f.zzqn, this.f.f7127t, com_google_android_gms_ads_internal_purchase_zzd, (zzj) this));
                        return;
                    } else {
                        this.f.f7129v = false;
                        return;
                    }
                } catch (RemoteException e) {
                    aad.m8426e("Could not start In-App purchase.");
                    this.f.f7129v = false;
                    return;
                }
            }
        }
        try {
            this.f.f7115h.mo4018a(com_google_android_gms_ads_internal_purchase_zzd);
        } catch (RemoteException e2) {
            aad.m8426e("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        try {
            if (this.f.f7116i != null) {
                this.f.f7116i.mo4161a(new zzg(this.f.zzqn, str, z, i, intent, com_google_android_gms_ads_internal_purchase_zzf));
            }
        } catch (RemoteException e) {
            aad.m8426e("Fail to invoke PlayStorePurchaseListener.");
        }
        zl.f11678a.postDelayed(new Runnable(this) {
            final /* synthetic */ zzb f6934b;

            public void run() {
                int zzd = zzw.zzda().zzd(intent);
                zzw.zzda();
                if (!(zzd != 0 || this.f6934b.f.zzvs == null || this.f6934b.f.zzvs.f11527b == null || this.f6934b.f.zzvs.f11527b.mo3421i() == null)) {
                    this.f6934b.f.zzvs.f11527b.mo3421i().close();
                }
                this.f6934b.f.f7129v = false;
            }
        }, 500);
    }

    protected boolean zza(@Nullable yy yyVar, yy yyVar2) {
        int i;
        int i2 = 0;
        if (!(yyVar == null || yyVar.f11544s == null)) {
            yyVar.f11544s.m13993a(null);
        }
        if (yyVar2.f11544s != null) {
            yyVar2.f11544s.m13993a((ts) this);
        }
        if (yyVar2.f11543r != null) {
            i = yyVar2.f11543r.f10802p;
            i2 = yyVar2.f11543r.f10803q;
        } else {
            i = 0;
        }
        this.f.zzvM.m15047a(i, i2);
        return true;
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, qj qjVar) {
        if (!mo3241f()) {
            return false;
        }
        za r;
        Bundle m = zzw.zzcM().m15166m(this.f.zzqn);
        this.e.cancel();
        this.f.zzvO = 0;
        if (((Boolean) qb.cD.m13225c()).booleanValue()) {
            r = zzw.zzcQ().m15029r();
            zzw.zzdi().zza(this.f.zzqn, this.f.zzvn, this.f.zzvl, r);
        } else {
            r = null;
        }
        C3513a a = m7479a(com_google_android_gms_internal_zzec, m, r);
        qjVar.m13305a("seq_num", a.f11950g);
        qjVar.m13305a("request_id", a.f11964u);
        qjVar.m13305a("session_id", a.f11951h);
        if (a.f11949f != null) {
            qjVar.m13305a("app_version", String.valueOf(a.f11949f.versionCode));
        }
        this.f.zzvp = zzw.zzcI().m14494a(this.f.zzqn, a, this);
        return true;
    }

    public void zzb(yy yyVar) {
        super.zzb(yyVar);
        if (yyVar.f11540o != null) {
            aad.m8421b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.f.f7110c != null) {
                this.f.f7110c.zzdy();
            }
            aad.m8421b("Pinging network fill URLs.");
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, yyVar, this.f.zzvl, false, yyVar.f11540o.f10778h);
            if (!(yyVar.f11543r == null || yyVar.f11543r.f10792f == null || yyVar.f11543r.f10792f.size() <= 0)) {
                aad.m8421b("Pinging urls remotely");
                zzw.zzcM().m15124a(this.f.zzqn, yyVar.f11543r.f10792f);
            }
        } else {
            aad.m8421b("Enable the debug gesture detector on the admob ad frame.");
            if (this.f.f7110c != null) {
                this.f.f7110c.zzdx();
            }
        }
        if (yyVar.f11529d == 3 && yyVar.f11543r != null && yyVar.f11543r.f10791e != null) {
            aad.m8421b("Pinging no fill URLs.");
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, yyVar, this.f.zzvl, false, yyVar.f11543r.f10791e);
        }
    }

    public void zzbN() {
        this.h.m12638b(this.f.zzvs);
        this.f6938k = false;
        mo3283a();
        this.f.zzvu.m14975c();
    }

    public void zzbO() {
        this.f6938k = true;
        m7472c();
    }

    public void zzbP() {
        onAdClicked();
    }

    public void zzbQ() {
        zzbN();
    }

    public void zzbR() {
        zzbD();
    }

    public void zzbS() {
        zzbO();
    }

    public void zzbT() {
        if (this.f.zzvs != null) {
            String str = this.f.zzvs.f11542q;
            aad.m8426e(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        mo3270a(this.f.zzvs, true);
        mo3285d();
    }

    public void zzbU() {
        recordImpression();
    }

    public void zzbV() {
        zzw.zzcM().m15125a(new C23676(this));
    }

    public void zzbW() {
        zzw.zzcM().m15125a(new C23687(this));
    }
}
