package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.pg;

public final class PublisherInterstitialAd {
    private final pg f6691a;

    public PublisherInterstitialAd(Context context) {
        this.f6691a = new pg(context, this);
    }

    public AdListener getAdListener() {
        return this.f6691a.m13129a();
    }

    public String getAdUnitId() {
        return this.f6691a.m13141b();
    }

    public AppEventListener getAppEventListener() {
        return this.f6691a.m13142c();
    }

    public String getMediationAdapterClassName() {
        return this.f6691a.m13147h();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f6691a.m13144e();
    }

    public boolean isLoaded() {
        return this.f6691a.m13145f();
    }

    public boolean isLoading() {
        return this.f6691a.m13146g();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f6691a.m13138a(publisherAdRequest.zzbp());
    }

    public void setAdListener(AdListener adListener) {
        this.f6691a.m13130a(adListener);
    }

    public void setAdUnitId(String str) {
        this.f6691a.m13139a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f6691a.m13132a(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f6691a.m13131a(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f6691a.m13133a(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.f6691a.m13148i();
    }
}
