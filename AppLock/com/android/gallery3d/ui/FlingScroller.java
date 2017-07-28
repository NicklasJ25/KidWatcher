package com.android.gallery3d.ui;

class FlingScroller {
    private static final int DECELERATED_FACTOR = 4;
    private static final float FLING_DURATION_PARAM = 50.0f;
    private static final String TAG = "FlingController";
    private double mCosAngle;
    private double mCurrV;
    private int mCurrX;
    private int mCurrY;
    private int mDistance;
    private int mDuration;
    private int mFinalX;
    private int mFinalY;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private double mSinAngle;
    private int mStartX;
    private int mStartY;

    FlingScroller() {
    }

    private double getV(float f) {
        return (((double) ((this.mDistance * 4) * 1000)) * Math.pow((double) (1.0f - f), 3.0d)) / ((double) this.mDuration);
    }

    private int getX(float f) {
        int round = (int) Math.round(((double) this.mStartX) + (((double) (((float) this.mDistance) * f)) * this.mCosAngle));
        return (this.mCosAngle <= 0.0d || this.mStartX > this.mMaxX) ? (this.mCosAngle >= 0.0d || this.mStartX < this.mMinX) ? round : Math.max(round, this.mMinX) : Math.min(round, this.mMaxX);
    }

    private int getY(float f) {
        int round = (int) Math.round(((double) this.mStartY) + (((double) (((float) this.mDistance) * f)) * this.mSinAngle));
        return (this.mSinAngle <= 0.0d || this.mStartY > this.mMaxY) ? (this.mSinAngle >= 0.0d || this.mStartY < this.mMinY) ? round : Math.max(round, this.mMinY) : Math.min(round, this.mMaxY);
    }

    public void computeScrollOffset(float f) {
        float min = Math.min(f, 1.0f);
        float pow = 1.0f - ((float) Math.pow((double) (1.0f - min), 4.0d));
        this.mCurrX = getX(pow);
        this.mCurrY = getY(pow);
        this.mCurrV = getV(min);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mStartX = i;
        this.mStartY = i2;
        this.mMinX = i5;
        this.mMinY = i7;
        this.mMaxX = i6;
        this.mMaxY = i8;
        double hypot = Math.hypot((double) i3, (double) i4);
        this.mSinAngle = ((double) i4) / hypot;
        this.mCosAngle = ((double) i3) / hypot;
        this.mDuration = (int) Math.round(50.0d * Math.pow(Math.abs(hypot), 0.3333333333333333d));
        this.mDistance = (int) Math.round(((hypot * ((double) this.mDuration)) / 4.0d) / 1000.0d);
        this.mFinalX = getX(1.0f);
        this.mFinalY = getY(1.0f);
    }

    public int getCurrVelocityX() {
        return (int) Math.round(this.mCurrV * this.mCosAngle);
    }

    public int getCurrVelocityY() {
        return (int) Math.round(this.mCurrV * this.mSinAngle);
    }

    public int getCurrX() {
        return this.mCurrX;
    }

    public int getCurrY() {
        return this.mCurrY;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getFinalX() {
        return this.mFinalX;
    }

    public int getFinalY() {
        return this.mFinalY;
    }
}
