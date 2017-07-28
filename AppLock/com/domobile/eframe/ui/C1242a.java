package com.domobile.eframe.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.domobile.applock.R;

public class C1242a extends View {
    private int[] f2489a = null;
    private float f2490b = -1.0f;
    private int f2491c = 0;
    private int f2492d = 0;
    private Paint f2493e = new Paint();
    private boolean f2494f = false;
    private C1241b f2495g;
    private C1104a f2496h;
    private int f2497i;

    public interface C1104a {
        void mo2493b(int i);
    }

    public interface C1241b {
        void m2925a();

        void m2926b();
    }

    public C1242a(Context context) {
        super(context);
        this.f2497i = context.getResources().getColor(R.color.multi_color_selector_borderColor);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int left = getLeft();
        int right = getRight();
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (x >= 0.0f && x <= ((float) right)) {
            switch (action) {
                case 0:
                    if (this.f2495g != null) {
                        this.f2495g.m2925a();
                        break;
                    }
                    break;
                case 1:
                    this.f2490b = x;
                    if (this.f2495g != null) {
                        this.f2495g.m2926b();
                        break;
                    }
                    break;
                case 2:
                    break;
            }
            this.f2490b = x;
            left = (int) Math.floor((double) (this.f2490b / ((((float) (right - left)) * 1.0f) / ((float) this.f2489a.length))));
            if (!(this.f2496h == null || this.f2492d == left)) {
                this.f2496h.mo2493b(left);
            }
            if (this.f2492d != left) {
                this.f2492d = left;
                invalidate();
            }
        }
        return true;
    }

    public void draw(Canvas canvas) {
        if (this.f2489a != null) {
            Rect rect = new Rect(getLeft(), getTop(), getRight(), getBottom());
            RectF rectF = new RectF(rect);
            int length = this.f2489a.length;
            int i = 0;
            while (i < length) {
                int i2 = this.f2489a[i];
                int rgb = this.f2494f ? Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2)) : i2;
                if ((rgb >>> 24) != 0) {
                    Object obj;
                    this.f2493e.setColor(rgb);
                    float f = (1.0f * ((float) (rect.right - rect.left))) / ((float) length);
                    float f2 = ((float) (rect.bottom - rect.top)) / 2.0f;
                    rectF.left = i == 0 ? 0.0f : rectF.right;
                    rectF.right = rectF.left + f;
                    rectF.bottom = (float) rect.bottom;
                    if (this.f2492d == i) {
                        canvas.drawRect(rectF, this.f2493e);
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    f = ((float) rect.top) + (f2 / 4.0f);
                    RectF rectF2;
                    if (obj != null) {
                        this.f2493e.setColor(this.f2497i);
                        rectF2 = new RectF(rectF);
                        rectF2.top = f;
                        rectF2.right = rectF2.left;
                        rectF2.left -= 2.0f;
                        canvas.drawRect(rectF2, this.f2493e);
                        rectF2 = new RectF(rectF);
                        rectF2.top = f;
                        rectF2.left = rectF2.right;
                        rectF2.right += 2.0f;
                        canvas.drawRect(rectF2, this.f2493e);
                        rectF2 = new RectF(rectF);
                        rectF2.top = f;
                        rectF2.top = rectF2.bottom - 2.0f;
                        canvas.drawRect(rectF2, this.f2493e);
                    } else {
                        rectF.bottom = f;
                        this.f2493e.setColor(this.f2497i);
                        rectF2 = new RectF(rectF);
                        rectF2.top = rectF2.bottom;
                        rectF2.bottom += 2.0f;
                        canvas.drawRect(rectF2, this.f2493e);
                    }
                    this.f2493e.setColor(rgb);
                    rectF.bottom = f;
                    canvas.drawRect(rectF, this.f2493e);
                    this.f2493e.setColor(this.f2497i);
                    canvas.drawRect((float) rect.left, (float) rect.top, (float) rect.right, (float) (rect.top + 2), this.f2493e);
                }
                i++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setColorListener(C1104a c1104a) {
        this.f2496h = c1104a;
    }

    public void setColors(int[] iArr) {
        this.f2489a = iArr;
    }

    public void setIgnoreAlpha(boolean z) {
        this.f2494f = z;
    }

    public void setInitialColor(int i) {
        this.f2491c = i;
        this.f2492d = i;
    }

    public void setOnTouchDelegate(C1241b c1241b) {
        this.f2495g = c1241b;
    }
}
