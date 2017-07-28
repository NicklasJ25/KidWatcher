package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.p065a.C2312b;

@wh
public class ph {
    private static ph f10229a;
    private static final Object f10230b = new Object();
    private oy f10231c;
    private RewardedVideoAd f10232d;

    private ph() {
    }

    public static ph m13149a() {
        ph phVar;
        synchronized (f10230b) {
            if (f10229a == null) {
                f10229a = new ph();
            }
            phVar = f10229a;
        }
        return phVar;
    }

    public RewardedVideoAd m13150a(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (f10230b) {
            if (this.f10232d != null) {
                rewardedVideoAd = this.f10232d;
            } else {
                this.f10232d = new ya(context, ol.m12981b().m12975a(context, new tz()));
                rewardedVideoAd = this.f10232d;
            }
        }
        return rewardedVideoAd;
    }

    public void m13151a(float f) {
        boolean z = true;
        boolean z2 = 0.0f <= f && f <= 1.0f;
        C2513c.m7942b(z2, "The app volume must be a value between 0 and 1 inclusive.");
        if (this.f10231c == null) {
            z = false;
        }
        C2513c.m7938a(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f10231c.setAppVolume(f);
        } catch (Throwable e) {
            aad.m8422b("Unable to set app volume.", e);
        }
    }

    public void m13152a(Context context, String str) {
        C2513c.m7938a(this.f10231c != null, (Object) "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.f10231c.zzb(C2312b.m7327a((Object) context), str);
        } catch (Throwable e) {
            aad.m8422b("Unable to open debug menu.", e);
        }
    }

    public void m13153a(final Context context, String str, pi piVar) {
        synchronized (f10230b) {
            if (this.f10231c != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else {
                try {
                    this.f10231c = ol.m12981b().m12972a(context);
                    this.f10231c.initialize();
                    if (str != null) {
                        this.f10231c.zzc(str, C2312b.m7327a(new Runnable(this) {
                            final /* synthetic */ ph f10228b;

                            public void run() {
                                this.f10228b.m13150a(context);
                            }
                        }));
                    }
                } catch (Throwable e) {
                    aad.m8424c("MobileAdsSettingManager initialization failed", e);
                }
            }
        }
    }

    public void m13154a(boolean z) {
        C2513c.m7938a(this.f10231c != null, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f10231c.setAppMuted(z);
        } catch (Throwable e) {
            aad.m8422b("Unable to set app mute state.", e);
        }
    }
}
