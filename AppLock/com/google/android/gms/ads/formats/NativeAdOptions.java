package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.wh;

@wh
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean f6697a;
    private final int f6698b;
    private final boolean f6699c;
    private final int f6700d;
    private final VideoOptions f6701e;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        private boolean f6692a = false;
        private int f6693b = 0;
        private boolean f6694c = false;
        private VideoOptions f6695d;
        private int f6696e = 1;

        public NativeAdOptions build() {
            return new NativeAdOptions();
        }

        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.f6696e = i;
            return this;
        }

        public Builder setImageOrientation(int i) {
            this.f6693b = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.f6694c = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.f6692a = z;
            return this;
        }

        public Builder setVideoOptions(VideoOptions videoOptions) {
            this.f6695d = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f6697a = builder.f6692a;
        this.f6698b = builder.f6693b;
        this.f6699c = builder.f6694c;
        this.f6700d = builder.f6696e;
        this.f6701e = builder.f6695d;
    }

    public int getAdChoicesPlacement() {
        return this.f6700d;
    }

    public int getImageOrientation() {
        return this.f6698b;
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.f6701e;
    }

    public boolean shouldRequestMultipleImages() {
        return this.f6699c;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.f6697a;
    }
}
