package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.pg;

public final class InterstitialAd {
    private final pg f6681a;

    public InterstitialAd(Context context) {
        this.f6681a = new pg(context);
    }

    public AdListener getAdListener() {
        return this.f6681a.m13129a();
    }

    public String getAdUnitId() {
        return this.f6681a.m13141b();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f6681a.m13143d();
    }

    public String getMediationAdapterClassName() {
        return this.f6681a.m13147h();
    }

    public boolean isLoaded() {
        return this.f6681a.m13145f();
    }

    public boolean isLoading() {
        return this.f6681a.m13146g();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.f6681a.m13138a(adRequest.zzbp());
    }

    public void setAdListener(AdListener adListener) {
        this.f6681a.m13130a(adListener);
        if (adListener != null && (adListener instanceof ny)) {
            this.f6681a.m13137a((ny) adListener);
        } else if (adListener == null) {
            this.f6681a.m13137a(null);
        }
    }

    public void setAdUnitId(String str) {
        this.f6681a.m13139a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f6681a.m13134a(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f6681a.m13135a(playStorePurchaseListener, str);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f6681a.m13136a(rewardedVideoAdListener);
    }

    public void show() {
        this.f6681a.m13148i();
    }

    public void zzd(boolean z) {
        this.f6681a.m13140a(z);
    }
}
