package com.google.android.gms.internal;

import com.google.android.gms.internal.xs.C3155a;
import com.google.android.gms.p065a.C2309a;

public class po extends C3155a {
    private xu f10239a;

    class C31541 implements Runnable {
        final /* synthetic */ po f10238a;

        C31541(po poVar) {
            this.f10238a = poVar;
        }

        public void run() {
            if (this.f10238a.f10239a != null) {
                try {
                    this.f10238a.f10239a.mo4020a(1);
                } catch (Throwable e) {
                    aad.m8424c("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void mo3886a() {
    }

    public void mo3887a(C2309a c2309a) {
    }

    public void mo3888a(xu xuVar) {
        this.f10239a = xuVar;
    }

    public void mo3889a(zzoa com_google_android_gms_internal_zzoa) {
        aad.m8423c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        aac.f7622a.post(new C31541(this));
    }

    public void mo3890a(String str) {
    }

    public void mo3891b(C2309a c2309a) {
    }

    public boolean mo3892b() {
        return false;
    }

    public void mo3893c() {
    }

    public void mo3894c(C2309a c2309a) {
    }

    public void mo3895d() {
    }

    public void mo3896e() {
    }
}
