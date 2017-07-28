package com.google.android.gms.internal;

import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.p065a.C2309a;

public class pl extends C2359a {
    private op f10237a;

    class C31521 implements Runnable {
        final /* synthetic */ pl f10236a;

        C31521(pl plVar) {
            this.f10236a = plVar;
        }

        public void run() {
            if (this.f10236a.f10237a != null) {
                try {
                    this.f10236a.f10237a.mo3854a(1);
                } catch (Throwable e) {
                    aad.m8424c("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(oo ooVar) {
    }

    public void zza(op opVar) {
        this.f10237a = opVar;
    }

    public void zza(ov ovVar) {
    }

    public void zza(ox oxVar) {
    }

    public void zza(qn qnVar) {
    }

    public void zza(vg vgVar) {
    }

    public void zza(vk vkVar, String str) {
    }

    public void zza(xu xuVar) {
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
    }

    public void zza(zzfc com_google_android_gms_internal_zzfc) {
    }

    public void zza(zzft com_google_android_gms_internal_zzft) {
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        aad.m8423c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        aac.f7622a.post(new C31521(this));
        return false;
    }

    public C2309a zzbB() {
        return null;
    }

    public zzeg zzbC() {
        return null;
    }

    public void zzbE() {
    }

    public pb zzbF() {
        return null;
    }
}
