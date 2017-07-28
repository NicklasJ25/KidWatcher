package com.android.gallery3d.anim;

public class FloatAnimation extends Animation {
    private float mCurrent;
    private final float mFrom;
    private final float mTo;

    public FloatAnimation(float f, float f2, int i) {
        this.mFrom = f;
        this.mTo = f2;
        this.mCurrent = f;
        setDuration(i);
    }

    public float get() {
        return this.mCurrent;
    }

    protected void onCalculate(float f) {
        this.mCurrent = this.mFrom + ((this.mTo - this.mFrom) * f);
    }
}
