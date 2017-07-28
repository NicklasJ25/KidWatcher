package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class BitmapScreenNail implements ScreenNail {
    private final BitmapTexture mBitmapTexture;

    public BitmapScreenNail(Bitmap bitmap) {
        this.mBitmapTexture = new BitmapTexture(bitmap);
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        this.mBitmapTexture.draw(gLCanvas, i, i2, i3, i4);
    }

    public void draw(GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        gLCanvas.drawTexture(this.mBitmapTexture, rectF, rectF2);
    }

    public int getHeight() {
        return this.mBitmapTexture.getHeight();
    }

    public int getWidth() {
        return this.mBitmapTexture.getWidth();
    }

    public void noDraw() {
    }

    public void recycle() {
        this.mBitmapTexture.recycle();
    }
}
