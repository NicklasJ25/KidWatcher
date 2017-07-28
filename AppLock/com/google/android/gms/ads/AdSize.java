package com.google.android.gms.ads;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.domobile.lockbean.Scene;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.zzeg;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, PositionController.SNAPBACK_ANIMATION_TIME, "160x600_as");
    public static final AdSize zzrB = new AdSize(50, 50, "50x50_mb");
    private final int f6676a;
    private final int f6677b;
    private final String f6678c;

    public AdSize(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String valueOf3 = String.valueOf("_as");
        this(i, i2, new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append("x").append(valueOf2).append(valueOf3).toString());
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f6676a = i;
            this.f6677b = i2;
            this.f6678c = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f6676a == adSize.f6676a && this.f6677b == adSize.f6677b && this.f6678c.equals(adSize.f6678c);
    }

    public int getHeight() {
        return this.f6677b;
    }

    public int getHeightInPixels(Context context) {
        switch (this.f6677b) {
            case -4:
            case Scene.PAST_ID /*-3*/:
                return -1;
            case -2:
                return zzeg.m15384b(context.getResources().getDisplayMetrics());
            default:
                return ol.m12979a().m8398a(context, this.f6677b);
        }
    }

    public int getWidth() {
        return this.f6676a;
    }

    public int getWidthInPixels(Context context) {
        switch (this.f6676a) {
            case -4:
            case Scene.PAST_ID /*-3*/:
                return -1;
            case -1:
                return zzeg.m15381a(context.getResources().getDisplayMetrics());
            default:
                return ol.m12979a().m8398a(context, this.f6676a);
        }
    }

    public int hashCode() {
        return this.f6678c.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f6677b == -2;
    }

    public boolean isFluid() {
        return this.f6676a == -3 && this.f6677b == -4;
    }

    public boolean isFullWidth() {
        return this.f6676a == -1;
    }

    public String toString() {
        return this.f6678c;
    }
}
