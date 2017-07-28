package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.android.gallery3d.anim.CanvasAnimation;
import com.android.gallery3d.anim.FloatAnimation;
import java.util.Random;
import javax.microedition.khronos.opengles.GL11;

public class SlideshowView extends GLView {
    private static final float MOVE_SPEED = 0.2f;
    private static final float SCALE_SPEED = 0.2f;
    private static final int SLIDESHOW_DURATION = 3500;
    private static final String TAG = "SlideshowView";
    private static final int TRANSITION_DURATION = 1000;
    private SlideshowAnimation mCurrentAnimation;
    private int mCurrentRotation;
    private BitmapTexture mCurrentTexture;
    private SlideshowAnimation mPrevAnimation;
    private int mPrevRotation;
    private BitmapTexture mPrevTexture;
    private Random mRandom = new Random();
    private final FloatAnimation mTransitionAnimation = new FloatAnimation(0.0f, 1.0f, 1000);

    private class SlideshowAnimation extends CanvasAnimation {
        private final int mHeight;
        private final PointF mMovingVector;
        private float mProgress;
        private final int mWidth;

        public SlideshowAnimation(int i, int i2, Random random) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mMovingVector = new PointF((((float) this.mWidth) * 0.2f) * (random.nextFloat() - 0.5f), (((float) this.mHeight) * 0.2f) * (random.nextFloat() - 0.5f));
            setDuration(SlideshowView.SLIDESHOW_DURATION);
        }

        public void apply(GLCanvas gLCanvas) {
            int width = SlideshowView.this.getWidth();
            int height = SlideshowView.this.getHeight();
            float min = Math.min(((float) width) / ((float) this.mWidth), ((float) height) / ((float) this.mHeight)) * (1.0f + (0.2f * this.mProgress));
            gLCanvas.translate(((float) (width / 2)) + (this.mMovingVector.x * this.mProgress), ((float) (height / 2)) + (this.mMovingVector.y * this.mProgress));
            gLCanvas.scale(min, min, 0.0f);
        }

        public int getCanvasSaveFlags() {
            return 2;
        }

        protected void onCalculate(float f) {
            this.mProgress = f;
        }
    }

    public void next(Bitmap bitmap, int i) {
        this.mTransitionAnimation.start();
        if (this.mPrevTexture != null) {
            this.mPrevTexture.getBitmap().recycle();
            this.mPrevTexture.recycle();
        }
        this.mPrevTexture = this.mCurrentTexture;
        this.mPrevAnimation = this.mCurrentAnimation;
        this.mPrevRotation = this.mCurrentRotation;
        this.mCurrentRotation = i;
        this.mCurrentTexture = new BitmapTexture(bitmap);
        if (((i / 90) & 1) == 0) {
            this.mCurrentAnimation = new SlideshowAnimation(this.mCurrentTexture.getWidth(), this.mCurrentTexture.getHeight(), this.mRandom);
        } else {
            this.mCurrentAnimation = new SlideshowAnimation(this.mCurrentTexture.getHeight(), this.mCurrentTexture.getWidth(), this.mRandom);
        }
        this.mCurrentAnimation.start();
        invalidate();
    }

    public void release() {
        if (this.mPrevTexture != null) {
            this.mPrevTexture.recycle();
            this.mPrevTexture = null;
        }
        if (this.mCurrentTexture != null) {
            this.mCurrentTexture.recycle();
            this.mCurrentTexture = null;
        }
    }

    protected void render(GLCanvas gLCanvas) {
        long j = AnimationTime.get();
        int calculate = this.mTransitionAnimation.calculate(j);
        GL11 gLInstance = gLCanvas.getGLInstance();
        gLInstance.glBlendFunc(1, 1);
        float f = this.mPrevTexture == null ? 1.0f : this.mTransitionAnimation.get();
        if (!(this.mPrevTexture == null || f == 1.0f)) {
            calculate |= this.mPrevAnimation.calculate(j);
            gLCanvas.save(3);
            gLCanvas.setAlpha(1.0f - f);
            this.mPrevAnimation.apply(gLCanvas);
            gLCanvas.rotate((float) this.mPrevRotation, 0.0f, 0.0f, 1.0f);
            this.mPrevTexture.draw(gLCanvas, (-this.mPrevTexture.getWidth()) / 2, (-this.mPrevTexture.getHeight()) / 2);
            gLCanvas.restore();
        }
        if (this.mCurrentTexture != null) {
            calculate |= this.mCurrentAnimation.calculate(j);
            gLCanvas.save(3);
            gLCanvas.setAlpha(f);
            this.mCurrentAnimation.apply(gLCanvas);
            gLCanvas.rotate((float) this.mCurrentRotation, 0.0f, 0.0f, 1.0f);
            this.mCurrentTexture.draw(gLCanvas, (-this.mCurrentTexture.getWidth()) / 2, (-this.mCurrentTexture.getHeight()) / 2);
            gLCanvas.restore();
        }
        if (calculate != 0) {
            invalidate();
        }
        gLInstance.glBlendFunc(1, 771);
    }
}
