package com.android.gallery3d.ui;

import javax.microedition.khronos.opengles.GL11;

public class ExtTexture extends BasicTexture {
    private static float[] sCropRect = new float[4];
    private static int[] sTextureId = new int[1];
    private int mTarget;

    public ExtTexture(int i) {
        GLId.glGenTextures(1, sTextureId, 0);
        this.mId = sTextureId[0];
        this.mTarget = i;
    }

    private void uploadToCanvas(GLCanvas gLCanvas) {
        GL11 gLInstance = gLCanvas.getGLInstance();
        int width = getWidth();
        int height = getHeight();
        sCropRect[0] = 0.0f;
        sCropRect[1] = (float) height;
        sCropRect[2] = (float) width;
        sCropRect[3] = (float) (-height);
        gLInstance.glBindTexture(this.mTarget, this.mId);
        gLInstance.glTexParameterfv(this.mTarget, 35741, sCropRect, 0);
        gLInstance.glTexParameteri(this.mTarget, 10242, 33071);
        gLInstance.glTexParameteri(this.mTarget, 10243, 33071);
        gLInstance.glTexParameterf(this.mTarget, 10241, 9729.0f);
        gLInstance.glTexParameterf(this.mTarget, 10240, 9729.0f);
        setAssociatedCanvas(gLCanvas);
        this.mState = 1;
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

    public int getTarget() {
        return this.mTarget;
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
        return true;
    }

    protected boolean onBind(GLCanvas gLCanvas) {
        if (!isLoaded()) {
            uploadToCanvas(gLCanvas);
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void recycle() {
        super.recycle();
    }

    public void yield() {
    }
}
