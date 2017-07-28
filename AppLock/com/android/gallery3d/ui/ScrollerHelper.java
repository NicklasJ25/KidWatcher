package com.android.gallery3d.ui;

import android.content.Context;
import android.view.ViewConfiguration;
import com.android.gallery3d.common.OverScroller;
import com.android.gallery3d.common.Utils;

public class ScrollerHelper {
    private int mOverflingDistance;
    private boolean mOverflingEnabled;
    private OverScroller mScroller;

    public ScrollerHelper(Context context) {
        this.mScroller = new OverScroller(context);
        this.mOverflingDistance = ViewConfiguration.get(context).getScaledOverflingDistance();
    }

    public boolean advanceAnimation(long j) {
        return this.mScroller.computeScrollOffset();
    }

    public void fling(int i, int i2, int i3) {
        this.mScroller.fling(getPosition(), 0, i, 0, i2, i3, 0, 0, this.mOverflingEnabled ? this.mOverflingDistance : 0, 0);
    }

    public void forceFinished() {
        this.mScroller.forceFinished(true);
    }

    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    public int getPosition() {
        return this.mScroller.getCurrX();
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public void setOverfling(boolean z) {
        this.mOverflingEnabled = z;
    }

    public void setPosition(int i) {
        this.mScroller.startScroll(i, 0, 0, 0, 0);
        this.mScroller.abortAnimation();
    }

    public int startScroll(int i, int i2, int i3) {
        int currX = this.mScroller.getCurrX();
        int finalX = this.mScroller.isFinished() ? currX : this.mScroller.getFinalX();
        int clamp = Utils.clamp(finalX + i, i2, i3);
        if (clamp != currX) {
            this.mScroller.startScroll(currX, 0, clamp - currX, 0, 0);
        }
        return (finalX + i) - clamp;
    }
}
