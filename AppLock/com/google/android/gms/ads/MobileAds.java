package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.ph;
import com.google.android.gms.internal.pi;

public class MobileAds {

    public static final class Settings {
        private final pi f6682a = new pi();

        pi m7334a() {
            return this.f6682a;
        }

        @Deprecated
        public String getTrackingId() {
            return null;
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return ph.m13149a().m13150a(context);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        ph.m13149a().m13153a(context, str, settings == null ? null : settings.m7334a());
    }

    public static void openDebugMenu(Context context, String str) {
        ph.m13149a().m13152a(context, str);
    }

    public static void setAppMuted(boolean z) {
        ph.m13149a().m13154a(z);
    }

    public static void setAppVolume(float f) {
        ph.m13149a().m13151a(f);
    }
}
