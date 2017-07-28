package com.android.gallery3d.ui;

public class RelativePosition {
    private float mAbsoluteX;
    private float mAbsoluteY;
    private float mReferenceX;
    private float mReferenceY;

    public float getX() {
        return this.mAbsoluteX - this.mReferenceX;
    }

    public float getY() {
        return this.mAbsoluteY - this.mReferenceY;
    }

    public void setAbsolutePosition(int i, int i2) {
        this.mAbsoluteX = (float) i;
        this.mAbsoluteY = (float) i2;
    }

    public void setReferencePosition(int i, int i2) {
        this.mReferenceX = (float) i;
        this.mReferenceY = (float) i2;
    }
}
