package com.android.gallery3d.ui;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.gallery3d.common.Utils;

class EdgeAnimation {
    private static final int ABSORB_TIME = 200;
    private static final int RELEASE_TIME = 500;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_RELEASE = 3;
    private static final String TAG = "EdgeAnimation";
    private static final float VELOCITY_FACTOR = 0.1f;
    private long mDuration;
    private final Interpolator mInterpolator = new DecelerateInterpolator();
    private long mStartTime;
    private int mState = 0;
    private float mValue;
    private float mValueFinish;
    private float mValueStart;

    private long now() {
        return AnimationTime.get();
    }

    private void startAnimation(float f, float f2, long j, int i) {
        this.mValueStart = f;
        this.mValueFinish = f2;
        this.mDuration = j;
        this.mStartTime = now();
        this.mState = i;
    }

    public float getValue() {
        return this.mValue;
    }

    public void onAbsorb(float f) {
        startAnimation(this.mValue, Utils.clamp(this.mValue + (VELOCITY_FACTOR * f), -1.0f, 1.0f), 200, 2);
    }

    public void onPull(float f) {
        if (this.mState != 2) {
            this.mValue = Utils.clamp(this.mValue + f, -1.0f, 1.0f);
            this.mState = 1;
        }
    }

    public void onRelease() {
        if (this.mState != 0 && this.mState != 2) {
            startAnimation(this.mValue, 0.0f, 500, 3);
        }
    }

    public boolean update() {
        if (this.mState == 0) {
            return false;
        }
        if (this.mState == 1) {
            return true;
        }
        float clamp = Utils.clamp(((float) (now() - this.mStartTime)) / ((float) this.mDuration), 0.0f, 1.0f);
        this.mValue = ((this.mState == 2 ? clamp : this.mInterpolator.getInterpolation(clamp)) * (this.mValueFinish - this.mValueStart)) + this.mValueStart;
        if (clamp >= 1.0f) {
            switch (this.mState) {
                case 2:
                    startAnimation(this.mValue, 0.0f, 500, 3);
                    break;
                case 3:
                    this.mState = 0;
                    break;
            }
        }
        return true;
    }
}
