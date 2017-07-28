package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import com.android.gallery3d.common.Utils;

public class BitmapTexture extends UploadedTexture {
    protected Bitmap mContentBitmap;

    public BitmapTexture(Bitmap bitmap) {
        this(bitmap, false);
    }

    public BitmapTexture(Bitmap bitmap, boolean z) {
        super(z);
        boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
        Utils.assertTrue(z2);
        this.mContentBitmap = bitmap;
    }

    public /* bridge */ /* synthetic */ void draw(GLCanvas gLCanvas, int i, int i2) {
        super.draw(gLCanvas, i, i2);
    }

    public /* bridge */ /* synthetic */ void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        super.draw(gLCanvas, i, i2, i3, i4);
    }

    public Bitmap getBitmap() {
        return this.mContentBitmap;
    }

    public /* bridge */ /* synthetic */ int getHeight() {
        return super.getHeight();
    }

    public /* bridge */ /* synthetic */ int getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ int getTextureHeight() {
        return super.getTextureHeight();
    }

    public /* bridge */ /* synthetic */ int getTextureWidth() {
        return super.getTextureWidth();
    }

    public /* bridge */ /* synthetic */ int getWidth() {
        return super.getWidth();
    }

    public /* bridge */ /* synthetic */ boolean hasBorder() {
        return super.hasBorder();
    }

    public /* bridge */ /* synthetic */ boolean isContentValid() {
        return super.isContentValid();
    }

    public /* bridge */ /* synthetic */ boolean isLoaded() {
        return super.isLoaded();
    }

    public /* bridge */ /* synthetic */ boolean isOpaque() {
        return super.isOpaque();
    }

    public /* bridge */ /* synthetic */ boolean isUploading() {
        return super.isUploading();
    }

    protected void onFreeBitmap(Bitmap bitmap) {
    }

    protected Bitmap onGetBitmap() {
        return this.mContentBitmap;
    }

    public /* bridge */ /* synthetic */ void recycle() {
        super.recycle();
    }

    public /* bridge */ /* synthetic */ void setOpaque(boolean z) {
        super.setOpaque(z);
    }

    public /* bridge */ /* synthetic */ void updateContent(GLCanvas gLCanvas) {
        super.updateContent(gLCanvas);
    }

    public /* bridge */ /* synthetic */ void yield() {
        super.yield();
    }
}
