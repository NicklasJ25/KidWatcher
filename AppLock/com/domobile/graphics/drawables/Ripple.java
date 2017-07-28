package com.domobile.graphics.drawables;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

class Ripple {
    private static final TimeInterpolator DECEL_INTERPOLATOR = new LogInterpolator();
    private static final float GLOBAL_SPEED = 1.0f;
    private static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final long RIPPLE_ENTER_DELAY = 80;
    private static final float WAVE_OPACITY_DECAY_VELOCITY = 3.0f;
    private static final float WAVE_TOUCH_DOWN_ACCELERATION = 1024.0f;
    private static final float WAVE_TOUCH_UP_ACCELERATION = 3400.0f;
    private ObjectAnimator mAnimOpacity;
    private ObjectAnimator mAnimRadius;
    private ObjectAnimator mAnimX;
    private ObjectAnimator mAnimY;
    private final AnimatorListenerAdapter mAnimationListener = new C13031();
    private final Rect mBounds;
    private boolean mCanceled;
    private float mClampedStartingX;
    private float mClampedStartingY;
    private float mDensity;
    private boolean mHasMaxRadius;
    private float mOpacity = GLOBAL_SPEED;
    private float mOuterRadius;
    private float mOuterX;
    private float mOuterY;
    private final RippleDrawable mOwner;
    private float mStartingX;
    private float mStartingY;
    private Paint mTempPaint;
    private float mTweenRadius = 0.0f;
    private float mTweenX = 0.0f;
    private float mTweenY = 0.0f;

    class C13031 extends AnimatorListenerAdapter {
        C13031() {
        }

        public void onAnimationEnd(Animator animator) {
            Ripple.this.removeSelf();
        }
    }

    private static final class LogInterpolator implements TimeInterpolator {
        private LogInterpolator() {
        }

        public float getInterpolation(float f) {
            return Ripple.GLOBAL_SPEED - ((float) Math.pow(400.0d, ((double) (-f)) * 1.4d));
        }
    }

    public Ripple(RippleDrawable rippleDrawable, Rect rect, float f, float f2) {
        this.mOwner = rippleDrawable;
        this.mBounds = rect;
        this.mStartingX = f;
        this.mStartingY = f2;
    }

    private void cancelSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.cancel();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.cancel();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.cancel();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.cancel();
            this.mAnimY = null;
        }
    }

    private void clampStartingPosition() {
        float exactCenterX = this.mBounds.exactCenterX();
        float exactCenterY = this.mBounds.exactCenterY();
        float f = this.mStartingX - exactCenterX;
        float f2 = this.mStartingY - exactCenterY;
        float f3 = this.mOuterRadius;
        if ((f * f) + (f2 * f2) > f3 * f3) {
            double atan2 = Math.atan2((double) f2, (double) f);
            this.mClampedStartingX = exactCenterX + ((float) (Math.cos(atan2) * ((double) f3)));
            this.mClampedStartingY = ((float) (Math.sin(atan2) * ((double) f3))) + exactCenterY;
            return;
        }
        this.mClampedStartingX = this.mStartingX;
        this.mClampedStartingY = this.mStartingY;
    }

    private void endSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.end();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.end();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.end();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.end();
            this.mAnimY = null;
        }
    }

    private void exitSoftware(int i, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", new float[]{GLOBAL_SPEED});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", new float[]{GLOBAL_SPEED});
        ofFloat2.setDuration((long) i);
        ofFloat2.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", new float[]{GLOBAL_SPEED});
        ofFloat3.setDuration((long) i);
        ofFloat3.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "opacity", new float[]{0.0f});
        ofFloat4.setDuration((long) i2);
        ofFloat4.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat4.addListener(this.mAnimationListener);
        this.mAnimRadius = ofFloat;
        this.mAnimOpacity = ofFloat4;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        AnimatorsCompat.startWithAutoCancel(ofFloat);
        AnimatorsCompat.startWithAutoCancel(ofFloat4);
        AnimatorsCompat.startWithAutoCancel(ofFloat2);
        AnimatorsCompat.startWithAutoCancel(ofFloat3);
    }

    private Paint getTempPaint(Paint paint) {
        if (this.mTempPaint == null) {
            this.mTempPaint = new Paint();
        }
        this.mTempPaint.set(paint);
        return this.mTempPaint;
    }

    private void invalidateSelf() {
        this.mOwner.invalidateSelf();
    }

    private void removeSelf() {
        if (!this.mCanceled) {
            this.mOwner.removeRipple(this);
        }
    }

    public void cancel() {
        this.mCanceled = true;
        cancelSoftwareAnimations();
        this.mCanceled = false;
    }

    public boolean draw(Canvas canvas, Paint paint) {
        int alpha = paint.getAlpha();
        int i = (int) ((((float) alpha) * this.mOpacity) + 0.5f);
        float lerp = MathUtils.lerp(0.0f, this.mOuterRadius, this.mTweenRadius);
        if (i <= 0 || lerp <= 0.0f) {
            return false;
        }
        float lerp2 = MathUtils.lerp(this.mClampedStartingX - this.mBounds.exactCenterX(), this.mOuterX, this.mTweenX);
        float lerp3 = MathUtils.lerp(this.mClampedStartingY - this.mBounds.exactCenterY(), this.mOuterY, this.mTweenY);
        paint.setAlpha(i);
        canvas.drawCircle(lerp2, lerp3, lerp, paint);
        paint.setAlpha(alpha);
        return true;
    }

    public void enter() {
        cancel();
        int sqrt = (int) ((800.0d * Math.sqrt((double) ((this.mOuterRadius / WAVE_TOUCH_DOWN_ACCELERATION) * this.mDensity))) + 0.5d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", new float[]{GLOBAL_SPEED});
        ofFloat.setDuration((long) sqrt);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", new float[]{GLOBAL_SPEED});
        ofFloat2.setDuration((long) sqrt);
        ofFloat2.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat2.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", new float[]{GLOBAL_SPEED});
        ofFloat3.setDuration((long) sqrt);
        ofFloat3.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat3.setStartDelay(RIPPLE_ENTER_DELAY);
        this.mAnimRadius = ofFloat;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        AnimatorsCompat.startWithAutoCancel(ofFloat);
        AnimatorsCompat.startWithAutoCancel(ofFloat2);
        AnimatorsCompat.startWithAutoCancel(ofFloat3);
    }

    public void exit() {
        float lerp = (this.mAnimRadius == null || !this.mAnimRadius.isRunning()) ? this.mOuterRadius : this.mOuterRadius - MathUtils.lerp(0.0f, this.mOuterRadius, this.mTweenRadius);
        cancel();
        exitSoftware((int) ((Math.sqrt((double) ((lerp / 4424.0f) * this.mDensity)) * 1000.0d) + 0.5d), (int) (((1000.0f * this.mOpacity) / WAVE_OPACITY_DECAY_VELOCITY) + 0.5f));
    }

    public void getBounds(Rect rect) {
        int i = (int) this.mOuterX;
        int i2 = (int) this.mOuterY;
        int i3 = ((int) this.mOuterRadius) + 1;
        rect.set(i - i3, i2 - i3, i + i3, i2 + i3);
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getRadiusGravity() {
        return this.mTweenRadius;
    }

    public float getXGravity() {
        return this.mTweenX;
    }

    public float getYGravity() {
        return this.mTweenY;
    }

    public void jump() {
        this.mCanceled = true;
        endSoftwareAnimations();
        this.mCanceled = false;
    }

    public void move(float f, float f2) {
        this.mStartingX = f;
        this.mStartingY = f2;
        clampStartingPosition();
    }

    public void onHotspotBoundsChanged() {
        if (!this.mHasMaxRadius) {
            float width = ((float) this.mBounds.width()) / 2.0f;
            float height = ((float) this.mBounds.height()) / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((double) ((width * width) + (height * height)));
            clampStartingPosition();
        }
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
        invalidateSelf();
    }

    public void setRadiusGravity(float f) {
        this.mTweenRadius = f;
        invalidateSelf();
    }

    public void setXGravity(float f) {
        this.mTweenX = f;
        invalidateSelf();
    }

    public void setYGravity(float f) {
        this.mTweenY = f;
        invalidateSelf();
    }

    public void setup(int i, float f) {
        if (i != -1) {
            this.mHasMaxRadius = true;
            this.mOuterRadius = (float) i;
        } else {
            float width = ((float) this.mBounds.width()) / 2.0f;
            float height = ((float) this.mBounds.height()) / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((double) ((width * width) + (height * height)));
        }
        this.mOuterX = 0.0f;
        this.mOuterY = 0.0f;
        this.mDensity = f;
        clampStartingPosition();
    }
}
