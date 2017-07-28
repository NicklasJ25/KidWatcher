package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.p065a.C2312b;

@wh
public class ya implements RewardedVideoAd {
    private final xs f11448a;
    private final Context f11449b;
    private final Object f11450c = new Object();
    private RewardedVideoAdListener f11451d;

    public ya(Context context, xs xsVar) {
        this.f11448a = xsVar;
        this.f11449b = context;
    }

    public void destroy() {
        destroy(null);
    }

    public void destroy(Context context) {
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
                return;
            }
            try {
                this.f11448a.mo3894c(C2312b.m7327a((Object) context));
            } catch (Throwable e) {
                aad.m8424c("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.f11450c) {
            rewardedVideoAdListener = this.f11451d;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        aad.m8426e("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
            } else {
                try {
                    z = this.f11448a.mo3892b();
                } catch (Throwable e) {
                    aad.m8424c("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
                return;
            }
            try {
                this.f11448a.mo3889a(og.m12904a().m12906a(this.f11449b, adRequest.zzbp(), str));
            } catch (Throwable e) {
                aad.m8424c("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        pause(null);
    }

    public void pause(Context context) {
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
                return;
            }
            try {
                this.f11448a.mo3887a(C2312b.m7327a((Object) context));
            } catch (Throwable e) {
                aad.m8424c("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        resume(null);
    }

    public void resume(Context context) {
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
                return;
            }
            try {
                this.f11448a.mo3891b(C2312b.m7327a((Object) context));
            } catch (Throwable e) {
                aad.m8424c("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f11450c) {
            this.f11451d = rewardedVideoAdListener;
            if (this.f11448a != null) {
                try {
                    this.f11448a.mo3888a(new xx(rewardedVideoAdListener));
                } catch (Throwable e) {
                    aad.m8424c("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        aad.m8426e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.f11450c) {
            if (this.f11448a == null) {
                return;
            }
            try {
                this.f11448a.mo3886a();
            } catch (Throwable e) {
                aad.m8424c("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
