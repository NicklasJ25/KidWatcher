package com.android.gallery3d.ui;

import android.graphics.Rect;
import android.opengl.Matrix;

class Paper {
    private static final int ROTATE_FACTOR = 4;
    private static final String TAG = "Paper";
    private EdgeAnimation mAnimationLeft = new EdgeAnimation();
    private EdgeAnimation mAnimationRight = new EdgeAnimation();
    private float[] mMatrix = new float[16];
    private int mWidth;

    Paper() {
    }

    public boolean advanceAnimation() {
        return this.mAnimationLeft.update() | this.mAnimationRight.update();
    }

    public void edgeReached(float f) {
        float f2 = f / ((float) this.mWidth);
        if (f2 < 0.0f) {
            this.mAnimationRight.onAbsorb(-f2);
        } else {
            this.mAnimationLeft.onAbsorb(f2);
        }
    }

    public float[] getTransform(Rect rect, float f) {
        float centerX = (((float) rect.centerX()) - f) + ((float) (this.mWidth / 4));
        int i = (this.mWidth * 3) / 2;
        float exp = (((1.0f / (((float) Math.exp((double) ((-(((this.mAnimationLeft.getValue() * (((float) i) - centerX)) - (this.mAnimationRight.getValue() * centerX)) / ((float) i))) * 4.0f))) + 1.0f)) - 0.5f) * 2.0f) * -45.0f;
        Matrix.setIdentityM(this.mMatrix, 0);
        Matrix.translateM(this.mMatrix, 0, this.mMatrix, 0, (float) rect.centerX(), (float) rect.centerY(), 0.0f);
        Matrix.rotateM(this.mMatrix, 0, exp, 0.0f, 1.0f, 0.0f);
        Matrix.translateM(this.mMatrix, 0, this.mMatrix, 0, (float) ((-rect.width()) / 2), (float) ((-rect.height()) / 2), 0.0f);
        return this.mMatrix;
    }

    public void onRelease() {
        this.mAnimationLeft.onRelease();
        this.mAnimationRight.onRelease();
    }

    public void overScroll(float f) {
        float f2 = f / ((float) this.mWidth);
        if (f2 < 0.0f) {
            this.mAnimationLeft.onPull(-f2);
        } else {
            this.mAnimationRight.onPull(f2);
        }
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
    }
}
