package com.android.gallery3d.ui;

import android.annotation.TargetApi;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.android.gallery3d.common.ApiHelper;

@TargetApi(11)
public abstract class SurfaceTextureScreenNail implements OnFrameAvailableListener, ScreenNail {
    private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static final String TAG = "SurfaceTextureScreenNail";
    protected ExtTexture mExtTexture;
    private boolean mHasTexture = false;
    private int mHeight;
    private SurfaceTexture mSurfaceTexture;
    private float[] mTransform = new float[16];
    private int mWidth;

    @TargetApi(14)
    private static void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.setOnFrameAvailableListener(null);
        if (ApiHelper.HAS_RELEASE_SURFACE_TEXTURE) {
            surfaceTexture.release();
        }
    }

    @TargetApi(15)
    private static void setDefaultBufferSize(SurfaceTexture surfaceTexture, int i, int i2) {
        if (ApiHelper.HAS_SET_DEFALT_BUFFER_SIZE) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    public void acquireSurfaceTexture() {
        this.mExtTexture = new ExtTexture(GL_TEXTURE_EXTERNAL_OES);
        this.mExtTexture.setSize(this.mWidth, this.mHeight);
        this.mSurfaceTexture = new SurfaceTexture(this.mExtTexture.getId());
        setDefaultBufferSize(this.mSurfaceTexture, this.mWidth, this.mHeight);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        synchronized (this) {
            this.mHasTexture = true;
        }
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        synchronized (this) {
            if (this.mHasTexture) {
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mTransform);
                gLCanvas.save(2);
                int i5 = (i3 / 2) + i;
                int i6 = (i4 / 2) + i2;
                gLCanvas.translate((float) i5, (float) i6);
                gLCanvas.scale(1.0f, -1.0f, 1.0f);
                gLCanvas.translate((float) (-i5), (float) (-i6));
                updateTransformMatrix(this.mTransform);
                gLCanvas.drawTexture(this.mExtTexture, this.mTransform, i, i2, i3, i4);
                gLCanvas.restore();
                return;
            }
        }
    }

    public void draw(GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        throw new UnsupportedOperationException();
    }

    public int getHeight() {
        return this.mHeight;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public abstract void noDraw();

    public abstract void onFrameAvailable(SurfaceTexture surfaceTexture);

    public abstract void recycle();

    public void releaseSurfaceTexture() {
        synchronized (this) {
            this.mHasTexture = false;
        }
        this.mExtTexture.recycle();
        this.mExtTexture = null;
        releaseSurfaceTexture(this.mSurfaceTexture);
        this.mSurfaceTexture = null;
    }

    public void resizeTexture() {
        if (this.mExtTexture != null) {
            this.mExtTexture.setSize(this.mWidth, this.mHeight);
            setDefaultBufferSize(this.mSurfaceTexture, this.mWidth, this.mHeight);
        }
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    protected void updateTransformMatrix(float[] fArr) {
    }
}
