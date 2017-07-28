package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.p065a.C2312b;

@wh
public class yl implements MediationRewardedVideoAdListener {
    private final yk f11499a;

    public yl(yk ykVar) {
        this.f11499a = ykVar;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onAdClicked must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClicked.");
        try {
            this.f11499a.mo4231f(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onAdClosed must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClosed.");
        try {
            this.f11499a.mo4230e(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        C2513c.m7940b("onAdFailedToLoad must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdFailedToLoad.");
        try {
            this.f11499a.mo4227b(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onAdLeftApplication must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLeftApplication.");
        try {
            this.f11499a.mo4232g(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onAdLoaded must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLoaded.");
        try {
            this.f11499a.mo4226b(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onAdOpened must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdOpened.");
        try {
            this.f11499a.mo4228c(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        C2513c.m7940b("onInitializationFailed must be called on the main UI thread.");
        aad.m8421b("Adapter called onInitializationFailed.");
        try {
            this.f11499a.mo4224a(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            aad.m8424c("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onInitializationSucceeded must be called on the main UI thread.");
        aad.m8421b("Adapter called onInitializationSucceeded.");
        try {
            this.f11499a.mo4223a(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        C2513c.m7940b("onRewarded must be called on the main UI thread.");
        aad.m8421b("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.f11499a.mo4225a(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter), new zzoo(rewardItem));
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onRewarded.", e);
                return;
            }
        }
        this.f11499a.mo4225a(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter), new zzoo("", 1));
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2513c.m7940b("onVideoStarted must be called on the main UI thread.");
        aad.m8421b("Adapter called onVideoStarted.");
        try {
            this.f11499a.mo4229d(C2312b.m7327a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            aad.m8424c("Could not call onVideoStarted.", e);
        }
    }
}
