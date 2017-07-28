package com.domobile.graphics.drawables;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

class RippleBackground {
    private static final int ENTER_DURATION = 667;
    private static final int ENTER_DURATION_FAST = 100;
    private static final float GLOBAL_SPEED = 1.0f;
    private static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float WAVE_OPACITY_DECAY_VELOCITY = 3.0f;
    private static final float WAVE_OUTER_OPACITY_EXIT_VELOCITY_MAX = 4.5f;
    private static final float WAVE_OUTER_OPACITY_EXIT_VELOCITY_MIN = 1.5f;
    private static final float WAVE_OUTER_SIZE_INFLUENCE_MAX = 200.0f;
    private static final float WAVE_OUTER_SIZE_INFLUENCE_MIN = 40.0f;
    private ObjectAnimator mAnimOuterOpacity;
    private final Rect mBounds;
    private int mColor;
    private float mDensity;
    private boolean mHasMaxRadius;
    private float mOuterOpacity = 0.0f;
    private float mOuterRadius;
    private float mOuterX;
    private float mOuterY;
    private final RippleDrawable mOwner;
    private Paint mTempPaint;

    public RippleBackground(RippleDrawable rippleDrawable, Rect rect) {
        this.mOwner = rippleDrawable;
        this.mBounds = rect;
    }

    private void cancelSoftwareAnimations() {
        if (this.mAnimOuterOpacity != null) {
            this.mAnimOuterOpacity.cancel();
            this.mAnimOuterOpacity = null;
        }
    }

    private boolean drawSoftware(Canvas canvas, Paint paint) {
        int alpha = paint.getAlpha();
        int i = (int) ((((float) alpha) * this.mOuterOpacity) + 0.5f);
        float f = this.mOuterRadius;
        if (i <= 0 || f <= 0.0f) {
            return false;
        }
        paint.setAlpha(i);
        canvas.drawCircle(this.mOuterX, this.mOuterY, f, paint);
        paint.setAlpha(alpha);
        return true;
    }

    private void endSoftwareAnimations() {
        if (this.mAnimOuterOpacity != null) {
            this.mAnimOuterOpacity.end();
            this.mAnimOuterOpacity = null;
        }
    }

    private void exitSoftware(int i, int i2, int i3) {
        ObjectAnimator ofFloat;
        if (i2 > 0) {
            ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", new float[]{((float) i3) / 255.0f});
            ofFloat.setDuration((long) i2);
            ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
            final int i4 = i - i2;
            if (i4 > 0) {
                ofFloat.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationCancel(Animator animator) {
                        animator.removeListener(this);
                    }

                    public void onAnimationEnd(Animator animator) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RippleBackground.this, "outerOpacity", new float[]{0.0f});
                        ofFloat.setDuration((long) i4);
                        ofFloat.setInterpolator(RippleBackground.LINEAR_INTERPOLATOR);
                        RippleBackground.this.mAnimOuterOpacity = ofFloat;
                        AnimatorsCompat.startWithAutoCancel(ofFloat);
                    }
                });
            }
        } else {
            ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", new float[]{0.0f});
            ofFloat.setDuration((long) i);
        }
        this.mAnimOuterOpacity = ofFloat;
        AnimatorsCompat.startWithAutoCancel(ofFloat);
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

    public void cancel() {
        cancelSoftwareAnimations();
    }

    public boolean draw(Canvas canvas, Paint paint) {
        this.mColor = paint.getColor();
        return drawSoftware(canvas, paint);
    }

    public void enter(boolean z) {
        cancel();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "outerOpacity", new float[]{0.0f, GLOBAL_SPEED});
        ofFloat.setDuration(z ? 100 : 667);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        this.mAnimOuterOpacity = ofFloat;
        AnimatorsCompat.startWithAutoCancel(ofFloat);
    }

    public void exit() {
        cancel();
        float constrain = MathUtils.constrain((this.mOuterRadius - (WAVE_OUTER_SIZE_INFLUENCE_MIN * this.mDensity)) / (WAVE_OUTER_SIZE_INFLUENCE_MAX * this.mDensity), 0.0f, (float) GLOBAL_SPEED);
        float lerp = MathUtils.lerp(WAVE_OUTER_OPACITY_EXIT_VELOCITY_MIN, WAVE_OUTER_OPACITY_EXIT_VELOCITY_MAX, constrain);
        int max = Math.max(0, (int) ((((GLOBAL_SPEED - this.mOuterOpacity) * 1000.0f) / (WAVE_OPACITY_DECAY_VELOCITY + lerp)) + 0.5f));
        exitSoftware(333, max, (int) (((((constrain * (lerp * ((float) max))) / 1000.0f) + this.mOuterOpacity) * ((float) Color.alpha(this.mColor))) + 0.5f));
    }

    public void getBounds(Rect rect) {
        int i = (int) this.mOuterX;
        int i2 = (int) this.mOuterY;
        int i3 = ((int) this.mOuterRadius) + 1;
        rect.set(i - i3, i2 - i3, i + i3, i2 + i3);
    }

    public float getOuterOpacity() {
        return this.mOuterOpacity;
    }

    public void jump() {
        endSoftwareAnimations();
    }

    public void onHotspotBoundsChanged() {
        if (!this.mHasMaxRadius) {
            float width = ((float) this.mBounds.width()) / 2.0f;
            float height = ((float) this.mBounds.height()) / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((double) ((width * width) + (height * height)));
        }
    }

    public void setOuterOpacity(float f) {
        this.mOuterOpacity = f;
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
    }

    public boolean shouldDraw() {
        return this.mOuterOpacity > 0.0f && this.mOuterRadius > 0.0f;
    }
}
