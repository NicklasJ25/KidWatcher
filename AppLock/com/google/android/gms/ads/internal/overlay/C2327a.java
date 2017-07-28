package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zl;

@wh
class C2327a implements Runnable {
    private zzl f6722a;
    private boolean f6723b = false;

    C2327a(zzl com_google_android_gms_ads_internal_overlay_zzl) {
        this.f6722a = com_google_android_gms_ads_internal_overlay_zzl;
    }

    private void m7377c() {
        zl.f11678a.removeCallbacks(this);
        zl.f11678a.postDelayed(this, 250);
    }

    public void m7378a() {
        this.f6723b = true;
    }

    public void m7379b() {
        this.f6723b = false;
        m7377c();
    }

    public void run() {
        if (!this.f6723b) {
            this.f6722a.m7421a();
            m7377c();
        }
    }
}
