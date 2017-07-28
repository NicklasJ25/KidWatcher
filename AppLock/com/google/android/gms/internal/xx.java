package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.xu.C3268a;

@wh
public class xx extends C3268a {
    private final RewardedVideoAdListener f11446a;

    public xx(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f11446a = rewardedVideoAdListener;
    }

    public void mo4019a() {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoAdLoaded();
        }
    }

    public void mo4020a(int i) {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public void mo4021a(xr xrVar) {
        if (this.f11446a != null) {
            this.f11446a.onRewarded(new xv(xrVar));
        }
    }

    public void mo4022b() {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoAdOpened();
        }
    }

    public void mo4023c() {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoStarted();
        }
    }

    public void mo4024d() {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoAdClosed();
        }
    }

    public void mo4025e() {
        if (this.f11446a != null) {
            this.f11446a.onRewardedVideoAdLeftApplication();
        }
    }
}
