package com.google.android.gms.ads;

import com.google.android.gms.internal.wh;

@wh
public final class VideoOptions {
    private final boolean f6687a;

    public static final class Builder {
        private boolean f6686a = false;

        public VideoOptions build() {
            return new VideoOptions();
        }

        public Builder setStartMuted(boolean z) {
            this.f6686a = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.f6687a = builder.f6686a;
    }

    public boolean getStartMuted() {
        return this.f6687a;
    }
}
