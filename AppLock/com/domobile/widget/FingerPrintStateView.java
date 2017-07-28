package com.domobile.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FingerPrintStateView extends ImageView implements AnimatorUpdateListener, Runnable {
    private float f3047a = 0.0f;
    private int f3048b = 0;
    private ValueAnimator f3049c;
    private Paint f3050d = new Paint(7);

    public FingerPrintStateView(Context context) {
        super(context);
    }

    public FingerPrintStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FingerPrintStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public FingerPrintStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void m3530a() {
        try {
            removeCallbacks(this);
            if (this.f3049c != null) {
                this.f3049c.cancel();
            }
        } catch (Exception e) {
        }
        this.f3049c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f3049c.setDuration(400);
        this.f3049c.setTarget(this);
        this.f3049c.addUpdateListener(this);
        this.f3049c.start();
        postDelayed(this, 4000);
    }

    public void m3531a(int i) {
        this.f3048b = i;
        m3530a();
        invalidate();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3047a = valueAnimator.getAnimatedFraction();
        postInvalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3047a != 0.0f && this.f3048b != 0 && getDrawable() != null) {
            if (this.f3048b == 1) {
                this.f3050d.setColorFilter(new PorterDuffColorFilter(-16711936, Mode.SRC_ATOP));
            } else if (this.f3048b == 2) {
                this.f3050d.setColorFilter(new PorterDuffColorFilter(SupportMenu.CATEGORY_MASK, Mode.SRC_ATOP));
            }
            float f = this.f3047a;
            float f2 = 1.0f - f;
            int width = getWidth();
            int height = getHeight();
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            int i = (int) (((float) width2) * f);
            int i2 = (int) (((float) height2) * f);
            canvas.drawBitmap(bitmap, new Rect(0, 0, i, i2), new Rect(0, 0, (int) (((float) width) * f), (int) (f * ((float) height))), this.f3050d);
            canvas.drawBitmap(((BitmapDrawable) getDrawable()).getBitmap(), new Rect(width2 - i, height2 - i2, width2, height2), new Rect((int) (((float) width) * f2), (int) (f2 * ((float) height)), width, height), this.f3050d);
        }
    }

    public void run() {
        this.f3047a = 0.0f;
        postInvalidate();
    }
}
