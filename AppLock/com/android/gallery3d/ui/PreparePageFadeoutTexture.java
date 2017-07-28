package com.android.gallery3d.ui;

import android.os.ConditionVariable;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.ui.GLRoot.OnGLIdleListener;

public class PreparePageFadeoutTexture implements OnGLIdleListener {
    public static final String KEY_FADE_TEXTURE = "fade_texture";
    private static final long TIMEOUT = 200;
    private boolean mCancelled = false;
    private ConditionVariable mResultReady = new ConditionVariable(false);
    private GLView mRootPane;
    private RawTexture mTexture;

    public PreparePageFadeoutTexture(GLView gLView) {
        int width = gLView.getWidth();
        int height = gLView.getHeight();
        if (width == 0 || height == 0) {
            this.mCancelled = true;
            return;
        }
        this.mTexture = new RawTexture(width, height, true);
        this.mRootPane = gLView;
    }

    public static void prepareFadeOutTexture(AbstractGalleryActivity abstractGalleryActivity, GLView gLView) {
        Object preparePageFadeoutTexture = new PreparePageFadeoutTexture(gLView);
        if (!preparePageFadeoutTexture.isCancelled()) {
            GLRoot gLRoot = abstractGalleryActivity.getGLRoot();
            gLRoot.unlockRenderThread();
            try {
                gLRoot.addOnGLIdleListener(preparePageFadeoutTexture);
                preparePageFadeoutTexture = preparePageFadeoutTexture.get();
                if (preparePageFadeoutTexture != null) {
                    abstractGalleryActivity.getTransitionStore().put(KEY_FADE_TEXTURE, preparePageFadeoutTexture);
                }
            } finally {
                gLRoot.lockRenderThread();
            }
        }
    }

    public synchronized RawTexture get() {
        RawTexture rawTexture = null;
        synchronized (this) {
            if (!this.mCancelled) {
                if (this.mResultReady.block(TIMEOUT)) {
                    rawTexture = this.mTexture;
                } else {
                    this.mCancelled = true;
                }
            }
        }
        return rawTexture;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    public boolean onGLIdle(GLCanvas gLCanvas, boolean z) {
        if (this.mCancelled) {
            this.mTexture = null;
        } else {
            try {
                gLCanvas.beginRenderTarget(this.mTexture);
                this.mRootPane.render(gLCanvas);
                gLCanvas.endRenderTarget();
            } catch (RuntimeException e) {
                this.mTexture = null;
            }
        }
        this.mResultReady.open();
        return false;
    }
}
