package com.android.gallery3d.ui;

import com.android.gallery3d.common.Utils;

public class GLPaint {
    private int mColor = 0;
    private float mLineWidth = 1.0f;

    public int getColor() {
        return this.mColor;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setLineWidth(float f) {
        Utils.assertTrue(f >= 0.0f);
        this.mLineWidth = f;
    }
}
