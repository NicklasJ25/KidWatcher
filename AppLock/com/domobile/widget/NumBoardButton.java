package com.domobile.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.graphics.drawables.LollipopDrawablesCompat;

public class NumBoardButton extends ImageButton implements AnimatorUpdateListener {
    private final float f3060a = 0.3f;
    private BitmapDrawable f3061b;
    private boolean f3062c = false;
    private boolean f3063d = false;
    private float f3064e = 1.0f;
    private boolean f3065f = false;
    private ValueAnimator f3066g;
    private AppLockApplication f3067h;

    public NumBoardButton(Context context) {
        super(context);
        m3536a(context);
    }

    public NumBoardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3536a(context);
    }

    public NumBoardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3536a(context);
    }

    public NumBoardButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3536a(context);
    }

    public static BitmapDrawable m3535a(Context context, String str) {
        Bitmap f = C1150y.m2566a(context).m592f();
        try {
            int width = f.getWidth() / 12;
            return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(f, Integer.parseInt(str) * width, 0, width, f.getHeight()));
        } catch (Exception e) {
            return null;
        }
    }

    private void m3536a(Context context) {
        if (this.f3067h == null) {
            this.f3067h = C1150y.m2566a(context);
        }
    }

    private void m3537a(boolean z) {
        try {
            if (this.f3066g != null) {
                this.f3066g.cancel();
            }
        } catch (Exception e) {
        }
        this.f3065f = z;
        this.f3066g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f3066g.setDuration(100);
        this.f3066g.setTarget(this);
        this.f3066g.addUpdateListener(this);
        this.f3066g.start();
    }

    public void m3538a() {
        if (this.f3061b != null) {
            try {
                this.f3061b.getBitmap().recycle();
            } catch (Exception e) {
            }
        }
    }

    public void m3539a(Object obj, BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable == null || bitmapDrawable.getBitmap().isRecycled()) {
            setTag(obj);
            return;
        }
        super.setTag(obj);
        this.f3061b = bitmapDrawable;
        invalidate();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f3065f) {
            setKeyScaleSize(1.3f - (valueAnimator.getAnimatedFraction() * 0.3f));
        } else {
            setKeyScaleSize(1.0f + (valueAnimator.getAnimatedFraction() * 0.3f));
        }
    }

    protected void onDraw(Canvas canvas) {
        float f = 1.0f;
        super.onDraw(canvas);
        if (this.f3062c) {
            if (this.f3061b == null && getTag() != null) {
                this.f3061b = m3535a(getContext(), getTag().toString());
            }
            BitmapDrawable bitmapDrawable = this.f3061b;
            if (bitmapDrawable != null) {
                float height = (float) getHeight();
                if (getDrawable() != null) {
                    f = (1.0f * height) / ((float) getDrawable().getIntrinsicHeight());
                }
                int intrinsicWidth = (int) (f * ((float) ((int) (((float) bitmapDrawable.getIntrinsicWidth()) * this.f3064e))));
                int width = (getWidth() - intrinsicWidth) / 2;
                int i = (int) ((height - ((float) intrinsicWidth)) / 2.0f);
                bitmapDrawable.setBounds(width, i, width + intrinsicWidth, intrinsicWidth + i);
                bitmapDrawable.setColorFilter(this.f3063d ? 0 : this.f3067h.f439n, Mode.SRC_ATOP);
                bitmapDrawable.draw(canvas);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m3537a(false);
                break;
            case 1:
            case 3:
                m3537a(true);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIgnoreCustomedColor(boolean z) {
        this.f3063d = z;
    }

    public void setKeyScaleSize(float f) {
        this.f3064e = f;
        invalidate();
    }

    public void setNeedDrawNumber(boolean z) {
        this.f3062c = z;
        if (this.f3062c) {
            LollipopDrawablesCompat.setBackground(this, R.drawable.toggle_numbutton, null);
        }
    }

    public void setTag(Object obj) {
        super.setTag(obj);
        m3538a();
        this.f3061b = null;
        invalidate();
    }
}
