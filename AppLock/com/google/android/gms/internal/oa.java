package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.op.C3112a;

@wh
public final class oa extends C3112a {
    private final AdListener f10061a;

    public oa(AdListener adListener) {
        this.f10061a = adListener;
    }

    public void mo3853a() {
        this.f10061a.onAdClosed();
    }

    public void mo3854a(int i) {
        this.f10061a.onAdFailedToLoad(i);
    }

    public void mo3855b() {
        this.f10061a.onAdLeftApplication();
    }

    public void mo3856c() {
        this.f10061a.onAdLoaded();
    }

    public void mo3857d() {
        this.f10061a.onAdOpened();
    }
}
