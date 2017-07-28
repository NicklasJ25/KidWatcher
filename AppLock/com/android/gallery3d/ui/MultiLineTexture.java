package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;

class MultiLineTexture extends CanvasTexture {
    private final Layout mLayout;

    private MultiLineTexture(Layout layout) {
        super(layout.getWidth(), layout.getHeight());
        this.mLayout = layout;
    }

    public static MultiLineTexture newInstance(String str, int i, float f, int i2, Alignment alignment) {
        return new MultiLineTexture(new StaticLayout(str, 0, str.length(), StringTexture.getDefaultPaint(f, i2), i, alignment, 1.0f, 0.0f, true, null, 0));
    }

    protected void onDraw(Canvas canvas, Bitmap bitmap) {
        this.mLayout.draw(canvas);
    }
}
