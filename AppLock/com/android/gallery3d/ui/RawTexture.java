package com.android.gallery3d.ui;

import javax.microedition.khronos.opengles.GL11;

public class RawTexture extends BasicTexture {
    private static final String TAG = "RawTexture";
    private static final float[] sCropRect = new float[4];
    private static final int[] sTextureId = new int[1];
    private final boolean mOpaque;

    public RawTexture(int i, int i2, boolean z) {
        this.mOpaque = z;
        setSize(i, i2);
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

    protected int getTarget() {
        return 3553;
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

    public /* bridge */ /* synthetic */ boolean isLoaded() {
        return super.isLoaded();
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    protected boolean onBind(GLCanvas gLCanvas) {
        if (isLoaded()) {
            return true;
        }
        Log.m459w(TAG, "lost the content due to context change");
        return false;
    }

    protected void prepare(GLCanvas gLCanvas) {
        GL11 gLInstance = gLCanvas.getGLInstance();
        sCropRect[0] = 0.0f;
        sCropRect[1] = (float) this.mHeight;
        sCropRect[2] = (float) this.mWidth;
        sCropRect[3] = (float) (-this.mHeight);
        GLId.glGenTextures(1, sTextureId, 0);
        gLInstance.glBindTexture(3553, sTextureId[0]);
        gLInstance.glTexParameterfv(3553, 35741, sCropRect, 0);
        gLInstance.glTexParameteri(3553, 10242, 33071);
        gLInstance.glTexParameteri(3553, 10243, 33071);
        gLInstance.glTexParameterf(3553, 10241, 9729.0f);
        gLInstance.glTexParameterf(3553, 10240, 9729.0f);
        gLInstance.glTexImage2D(3553, 0, 6408, getTextureWidth(), getTextureHeight(), 0, 6408, 5121, null);
        this.mId = sTextureId[0];
        this.mState = 1;
        setAssociatedCanvas(gLCanvas);
    }

    public /* bridge */ /* synthetic */ void recycle() {
        super.recycle();
    }

    public void yield() {
    }
}
