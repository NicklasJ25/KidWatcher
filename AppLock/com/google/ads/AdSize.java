package com.google.ads;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(300, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, PositionController.SNAPBACK_ANIMATION_TIME, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final com.google.android.gms.ads.AdSize f4900a;

    public AdSize(int i, int i2) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f4900a = adSize;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.f4900a.equals(((AdSize) obj).f4900a);
    }

    public AdSize findBestSize(AdSize... adSizeArr) {
        AdSize adSize = null;
        if (adSizeArr != null) {
            float f = 0.0f;
            int width = getWidth();
            int height = getHeight();
            int length = adSizeArr.length;
            int i = 0;
            while (i < length) {
                float f2;
                AdSize adSize2;
                AdSize adSize3 = adSizeArr[i];
                int width2 = adSize3.getWidth();
                int height2 = adSize3.getHeight();
                if (isSizeAppropriate(width2, height2)) {
                    f2 = ((float) (width2 * height2)) / ((float) (width * height));
                    if (f2 > 1.0f) {
                        f2 = 1.0f / f2;
                    }
                    if (f2 > f) {
                        adSize2 = adSize3;
                        i++;
                        adSize = adSize2;
                        f = f2;
                    }
                }
                f2 = f;
                adSize2 = adSize;
                i++;
                adSize = adSize2;
                f = f2;
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.f4900a.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.f4900a.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.f4900a.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.f4900a.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.f4900a.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f4900a.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.f4900a.isFullWidth();
    }

    public boolean isSizeAppropriate(int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        return ((float) i) <= ((float) width) * 1.25f && ((float) i) >= ((float) width) * 0.8f && ((float) i2) <= ((float) height) * 1.25f && ((float) i2) >= ((float) height) * 0.8f;
    }

    public String toString() {
        return this.f4900a.toString();
    }
}
