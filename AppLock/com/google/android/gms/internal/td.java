package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.internal.tb.C3277a;
import com.google.android.gms.p065a.C2309a;

@wh
public class td extends C2359a {
    private final String f10692a;
    private final sv f10693b;
    @Nullable
    private zzm f10694c;
    private final sx f10695d;
    @Nullable
    private vk f10696e;
    private String f10697f;

    public td(Context context, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this(str, new sv(context, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze));
    }

    td(String str, sv svVar) {
        this.f10692a = str;
        this.f10693b = svVar;
        this.f10695d = new sx();
        zzw.zzdb().m13834a(svVar);
    }

    static boolean m13895a(zzec com_google_android_gms_internal_zzec) {
        return sy.m13821a(com_google_android_gms_internal_zzec).contains("gw");
    }

    private void m13896b() {
        if (this.f10694c != null && this.f10696e != null) {
            this.f10694c.zza(this.f10696e, this.f10697f);
        }
    }

    static boolean m13897b(zzec com_google_android_gms_internal_zzec) {
        return sy.m13821a(com_google_android_gms_internal_zzec).contains("_ad");
    }

    void m13898a() {
        if (this.f10694c == null) {
            this.f10694c = this.f10693b.m13765a(this.f10692a);
            this.f10695d.m13819a(this.f10694c);
            m13896b();
        }
    }

    public void destroy() {
        if (this.f10694c != null) {
            this.f10694c.destroy();
        }
    }

    @Nullable
    public String getMediationAdapterClassName() {
        return this.f10694c != null ? this.f10694c.getMediationAdapterClassName() : null;
    }

    public boolean isLoading() {
        return this.f10694c != null && this.f10694c.isLoading();
    }

    public boolean isReady() {
        return this.f10694c != null && this.f10694c.isReady();
    }

    public void pause() {
        if (this.f10694c != null) {
            this.f10694c.pause();
        }
    }

    public void resume() {
        if (this.f10694c != null) {
            this.f10694c.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        m13898a();
        if (this.f10694c != null) {
            this.f10694c.setManualImpressionsEnabled(z);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
        if (this.f10694c != null) {
            this.f10694c.showInterstitial();
        } else {
            aad.m8426e("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() {
        if (this.f10694c != null) {
            this.f10694c.stopLoading();
        }
    }

    public void zza(oo ooVar) {
        this.f10695d.f10635e = ooVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(op opVar) {
        this.f10695d.f10631a = opVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(ov ovVar) {
        this.f10695d.f10632b = ovVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(ox oxVar) {
        m13898a();
        if (this.f10694c != null) {
            this.f10694c.zza(oxVar);
        }
    }

    public void zza(qn qnVar) {
        this.f10695d.f10634d = qnVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(vg vgVar) {
        this.f10695d.f10633c = vgVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(vk vkVar, String str) {
        this.f10696e = vkVar;
        this.f10697f = str;
        m13896b();
    }

    public void zza(xu xuVar) {
        this.f10695d.f10636f = xuVar;
        if (this.f10694c != null) {
            this.f10695d.m13819a(this.f10694c);
        }
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        if (this.f10694c != null) {
            this.f10694c.zza(com_google_android_gms_internal_zzeg);
        }
    }

    public void zza(zzfc com_google_android_gms_internal_zzfc) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzft com_google_android_gms_internal_zzft) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        if (!m13895a(com_google_android_gms_internal_zzec)) {
            m13898a();
        }
        if (sy.m13827c(com_google_android_gms_internal_zzec)) {
            m13898a();
        }
        if (com_google_android_gms_internal_zzec.f11886j != null) {
            m13898a();
        }
        if (this.f10694c != null) {
            return this.f10694c.zzb(com_google_android_gms_internal_zzec);
        }
        sy zzdb = zzw.zzdb();
        if (m13897b(com_google_android_gms_internal_zzec)) {
            zzdb.m13836b(com_google_android_gms_internal_zzec, this.f10692a);
        }
        C3277a a = zzdb.m13832a(com_google_android_gms_internal_zzec, this.f10692a);
        if (a != null) {
            if (a.f10678e) {
                tc.m13885a().m13889d();
            } else {
                a.m13871a();
                tc.m13885a().m13890e();
            }
            this.f10694c = a.f10674a;
            a.f10676c.m13813a(this.f10695d);
            this.f10695d.m13819a(this.f10694c);
            m13896b();
            return a.f10679f;
        }
        m13898a();
        tc.m13885a().m13890e();
        return this.f10694c.zzb(com_google_android_gms_internal_zzec);
    }

    @Nullable
    public C2309a zzbB() {
        return this.f10694c != null ? this.f10694c.zzbB() : null;
    }

    @Nullable
    public zzeg zzbC() {
        return this.f10694c != null ? this.f10694c.zzbC() : null;
    }

    public void zzbE() {
        if (this.f10694c != null) {
            this.f10694c.zzbE();
        } else {
            aad.m8426e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public pb zzbF() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
