package com.android.gallery3d.ui;

import com.android.gallery3d.common.Utils;

public class ColorTexture implements Texture {
    private final int mColor;
    private int mHeight = 1;
    private int mWidth = 1;

    public ColorTexture(int i) {
        this.mColor = i;
    }

    public void draw(GLCanvas gLCanvas, int i, int i2) {
        draw(gLCanvas, i, i2, this.mWidth, this.mHeight);
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        gLCanvas.fillRect((float) i, (float) i2, (float) i3, (float) i4, this.mColor);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return Utils.isOpaque(this.mColor);
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }
}
