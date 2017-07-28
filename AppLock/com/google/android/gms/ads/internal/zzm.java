package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.aau;
import com.google.android.gms.internal.aau.C2377c;
import com.google.android.gms.internal.na;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sm;
import com.google.android.gms.internal.sm.C2389a;
import com.google.android.gms.internal.tq;
import com.google.android.gms.internal.tr;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.xb;
import com.google.android.gms.internal.yp;
import com.google.android.gms.internal.yr;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zg;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzqh;
import java.util.Collections;
import org.json.JSONObject;

@wh
public class zzm extends zzc implements sg, C2389a {
    protected transient boolean f7004l = false;
    private int f7005m = -1;
    private boolean f7006n;
    private float f7007o;
    private final yr f7008p;

    @wh
    private class C2388a extends zg {
        final /* synthetic */ zzm f7002a;
        private final int f7003b;

        public C2388a(zzm com_google_android_gms_ads_internal_zzm, int i) {
            this.f7002a = com_google_android_gms_ads_internal_zzm;
            this.f7003b = i;
        }

        public void onStop() {
        }

        public void zzco() {
            zzn com_google_android_gms_ads_internal_zzn = new zzn(this.f7002a.f.f7130w, this.f7002a.m7532g(), this.f7002a.f7006n, this.f7002a.f7007o, this.f7002a.f.f7130w ? this.f7003b : -1);
            int q = this.f7002a.f.zzvs.f11527b.mo3434q();
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this.f7002a, this.f7002a, this.f7002a, this.f7002a.f.zzvs.f11527b, q == -1 ? this.f7002a.f.zzvs.f11532g : q, this.f7002a.f.zzvn, this.f7002a.f.zzvs.f11519C, com_google_android_gms_ads_internal_zzn);
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ C2388a f7001b;

                public void run() {
                    zzw.zzcK().zza(this.f7001b.f7002a.f.zzqn, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzm(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        super(context, com_google_android_gms_internal_zzeg, str, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
        this.f7008p = zzw.zzdl().m14952d() ? new yr(context, str) : null;
    }

    static C3457a m7524a(C3457a c3457a) {
        try {
            String jSONObject = xb.m14689a(c3457a.f11510b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, c3457a.f11509a.f11996e);
            tq tqVar = new tq(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            zzmn com_google_android_gms_internal_zzmn = c3457a.f11510b;
            tr trVar = new tr(Collections.singletonList(tqVar), ((Long) qb.bG.m13225c()).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.f12027J, com_google_android_gms_internal_zzmn.f12028K, "", -1, 0, 1, null, 0, -1, -1, false);
            return new C3457a(c3457a.f11509a, new zzmn(c3457a.f11509a, com_google_android_gms_internal_zzmn.f12036b, com_google_android_gms_internal_zzmn.f12037c, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.f12041g, true, com_google_android_gms_internal_zzmn.f12043i, Collections.emptyList(), com_google_android_gms_internal_zzmn.f12045k, com_google_android_gms_internal_zzmn.f12046l, com_google_android_gms_internal_zzmn.f12047m, com_google_android_gms_internal_zzmn.f12048n, com_google_android_gms_internal_zzmn.f12049o, com_google_android_gms_internal_zzmn.f12050p, com_google_android_gms_internal_zzmn.f12051q, null, com_google_android_gms_internal_zzmn.f12053s, com_google_android_gms_internal_zzmn.f12054t, com_google_android_gms_internal_zzmn.f12055u, com_google_android_gms_internal_zzmn.f12056v, com_google_android_gms_internal_zzmn.f12057w, com_google_android_gms_internal_zzmn.f12060z, com_google_android_gms_internal_zzmn.f12018A, com_google_android_gms_internal_zzmn.f12019B, null, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.f12023F, com_google_android_gms_internal_zzmn.f12024G, com_google_android_gms_internal_zzmn.f12025H, com_google_android_gms_internal_zzmn.f12026I, com_google_android_gms_internal_zzmn.f12027J, com_google_android_gms_internal_zzmn.f12028K, com_google_android_gms_internal_zzmn.f12029L, null, com_google_android_gms_internal_zzmn.f12031N, com_google_android_gms_internal_zzmn.f12032O, com_google_android_gms_internal_zzmn.f12033P), trVar, c3457a.f11512d, c3457a.f11513e, c3457a.f11514f, c3457a.f11515g, null);
        } catch (Throwable e) {
            aad.m8422b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return c3457a;
        }
    }

    private void m7525a(Bundle bundle) {
        zzw.zzcM().m15142b(this.f.zzqn, this.f.zzvn.f12081a, "gmob-apps", bundle, false);
    }

    protected aat mo3269a(C3457a c3457a, @Nullable zzf com_google_android_gms_ads_internal_zzf, @Nullable yp ypVar) {
        aat a = zzw.zzcN().m8575a(this.f.zzqn, this.f.zzvr, false, false, this.f.f7109b, this.f.zzvn, this.a, this, this.i);
        a.mo3424l().m8551a(this, null, this, this, ((Boolean) qb.ap.m13225c()).booleanValue(), this, this, com_google_android_gms_ads_internal_zzf, null, ypVar);
        m7488a(a);
        a.mo3408b(c3457a.f11509a.f12013v);
        sm.m13732a(a, (C2389a) this);
        return a;
    }

    protected void mo3283a() {
        zzcm();
        super.mo3283a();
    }

    protected boolean mo3284a(zzec com_google_android_gms_internal_zzec, yy yyVar, boolean z) {
        if (this.f.zzdq() && yyVar.f11527b != null) {
            zzw.zzcO().m15181a(yyVar.f11527b);
        }
        return this.e.zzcy();
    }

    protected void mo3285d() {
        super.mo3285d();
        this.f7004l = true;
    }

    protected boolean m7532g() {
        if (!(this.f.zzqn instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.f.zzqn).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void showInterstitial() {
        C2513c.m7940b("showInterstitial must be called on the main UI thread.");
        if (this.f.zzvs == null) {
            aad.m8426e("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) qb.br.m13225c()).booleanValue()) {
            Bundle bundle;
            String packageName = this.f.zzqn.getApplicationContext() != null ? this.f.zzqn.getApplicationContext().getPackageName() : this.f.zzqn.getPackageName();
            if (!this.f7004l) {
                aad.m8426e("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                m7525a(bundle);
            }
            if (!zzw.zzcM().m15158g(this.f.zzqn)) {
                aad.m8426e("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                m7525a(bundle);
            }
        }
        if (!this.f.zzdr()) {
            if (this.f.zzvs.f11539n && this.f.zzvs.f11541p != null) {
                try {
                    this.f.zzvs.f11541p.mo4073b();
                } catch (Throwable e) {
                    aad.m8424c("Could not show interstitial.", e);
                    zzcm();
                }
            } else if (this.f.zzvs.f11527b == null) {
                aad.m8426e("The interstitial failed to load.");
            } else if (this.f.zzvs.f11527b.mo3433p()) {
                aad.m8426e("The interstitial is already showing.");
            } else {
                this.f.zzvs.f11527b.mo3404a(true);
                if (this.f.zzvs.f11535j != null) {
                    this.h.m12632a(this.f.zzvr, this.f.zzvs);
                }
                C2590o.m8307b();
                final yy yyVar = this.f.zzvs;
                if (yyVar.m14963a()) {
                    new na(this.f.zzqn, yyVar.f11527b.mo3405b()).m12739a(yyVar.f11527b);
                } else {
                    yyVar.f11527b.mo3424l().m8549a(new C2377c(this) {
                        final /* synthetic */ zzm f6999b;

                        public void mo3268a() {
                            new na(this.f6999b.f.zzqn, yyVar.f11527b.mo3405b()).m12739a(yyVar.f11527b);
                        }
                    });
                }
                Bitmap h = this.f.f7130w ? zzw.zzcM().m15159h(this.f.zzqn) : null;
                this.f7005m = zzw.zzdh().m15279a(h);
                if (!((Boolean) qb.bU.m13225c()).booleanValue() || h == null) {
                    zzn com_google_android_gms_ads_internal_zzn = new zzn(this.f.f7130w, m7532g(), false, 0.0f, -1);
                    int q = this.f.zzvs.f11527b.mo3434q();
                    if (q == -1) {
                        q = this.f.zzvs.f11532g;
                    }
                    zzw.zzcK().zza(this.f.zzqn, new AdOverlayInfoParcel(this, this, this, this.f.zzvs.f11527b, q, this.f.zzvn, this.f.zzvs.f11519C, com_google_android_gms_ads_internal_zzn));
                    return;
                }
                new C2388a(this, this.f7005m).zziP();
            }
        }
    }

    public void zza(C3457a c3457a, qj qjVar) {
        Object obj = 1;
        if (!((Boolean) qb.aW.m13225c()).booleanValue()) {
            super.zza(c3457a, qjVar);
        } else if (c3457a.f11513e != -2) {
            super.zza(c3457a, qjVar);
        } else {
            Bundle bundle = c3457a.f11509a.f11994c.f11889m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            Object obj2 = (bundle == null || !bundle.containsKey("gw")) ? 1 : null;
            if (c3457a.f11510b.f12042h) {
                obj = null;
            }
            if (!(obj2 == null || r2 == null)) {
                this.f.zzvt = m7524a(c3457a);
            }
            super.zza(this.f.zzvt, qjVar);
        }
    }

    public void zza(boolean z, float f) {
        this.f7006n = z;
        this.f7007o = f;
    }

    public boolean zza(@Nullable yy yyVar, yy yyVar2) {
        if (!super.zza(yyVar, yyVar2)) {
            return false;
        }
        if (!(this.f.zzdq() || this.f.f7128u == null || yyVar2.f11535j == null)) {
            this.h.m12633a(this.f.zzvr, yyVar2, this.f.f7128u);
        }
        return true;
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, qj qjVar) {
        if (this.f.zzvs == null) {
            return super.zza(com_google_android_gms_internal_zzec, qjVar);
        }
        aad.m8426e("An interstitial is already loading. Aborting.");
        return false;
    }

    public void zzb(zzoo com_google_android_gms_internal_zzoo) {
        if (this.f.zzvs != null) {
            if (this.f.zzvs.f11551z != null) {
                zzw.zzcM().m15121a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs.f11551z);
            }
            if (this.f.zzvs.f11549x != null) {
                com_google_android_gms_internal_zzoo = this.f.zzvs.f11549x;
            }
        }
        m7467a(com_google_android_gms_internal_zzoo);
    }

    public void zzbN() {
        super.zzbN();
        if (zzw.zzdl().m14952d()) {
            this.f7008p.m14933a(false);
        }
    }

    public void zzbO() {
        recordImpression();
        super.zzbO();
        if (!(this.f.zzvs == null || this.f.zzvs.f11527b == null)) {
            aau l = this.f.zzvs.f11527b.mo3424l();
            if (l != null) {
                l.m8564h();
            }
        }
        if (zzw.zzdl().m14952d()) {
            zzw.zzdl().m14942a(this.f.zzqn, this.f.zzvl, zzw.zzdl().m14940a(this.f.zzqn));
            this.f7008p.m14933a(true);
        }
    }

    public void zzcm() {
        zzw.zzdh().m15281b(Integer.valueOf(this.f7005m));
        if (this.f.zzdq()) {
            this.f.zzdn();
            this.f.zzvs = null;
            this.f.f7130w = false;
            this.f7004l = false;
        }
    }

    public void zzcn() {
        if (!(this.f.zzvs == null || this.f.zzvs.f11550y == null)) {
            zzw.zzcM().m15121a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs.f11550y);
        }
        m7475e();
    }

    public void zzf(boolean z) {
        this.f.f7130w = z;
    }
}
