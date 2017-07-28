package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.gallery3d.common.Utils;

public class ResourceTexture extends UploadedTexture {
    protected final Context mContext;
    protected final int mResId;

    public ResourceTexture(Context context, int i) {
        this.mContext = (Context) Utils.checkNotNull(context);
        this.mResId = i;
        setOpaque(false);
    }

    public /* bridge */ /* synthetic */ void draw(GLCanvas gLCanvas, int i, int i2) {
        super.draw(gLCanvas, i, i2);
    }

    public /* bridge */ /* synthetic */ void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        super.draw(gLCanvas, i, i2, i3, i4);
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
        if (!BasicTexture.inFinalizer()) {
            bitmap.recycle();
        }
    }

    protected Bitmap onGetBitmap() {
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        return BitmapFactory.decodeResource(this.mContext.getResources(), this.mResId, options);
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
