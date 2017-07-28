package com.android.gallery3d.ui;

import com.android.gallery3d.common.Utils;

public abstract class FadeTexture implements Texture {
    public static final int DURATION = 180;
    private static final String TAG = "FadeTexture";
    private final int mHeight;
    private boolean mIsAnimating = true;
    private final boolean mIsOpaque;
    private final long mStartTime = now();
    private final int mWidth;

    public FadeTexture(int i, int i2, boolean z) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsOpaque = z;
    }

    private long now() {
        return AnimationTime.get();
    }

    public void draw(GLCanvas gLCanvas, int i, int i2) {
        draw(gLCanvas, i, i2, this.mWidth, this.mHeight);
    }

    public int getHeight() {
        return this.mHeight;
    }

    protected float getRatio() {
        return Utils.clamp(1.0f - (((float) (now() - this.mStartTime)) / 180.0f), 0.0f, 1.0f);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAnimating() {
        if (this.mIsAnimating && now() - this.mStartTime >= 180) {
            this.mIsAnimating = false;
        }
        return this.mIsAnimating;
    }

    public boolean isOpaque() {
        return this.mIsOpaque;
    }
}
