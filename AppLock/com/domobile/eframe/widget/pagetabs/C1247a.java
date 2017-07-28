package com.domobile.eframe.widget.pagetabs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class C1247a extends TextView {
    public int f2530a;
    public int f2531b;
    public int f2532c;
    public int f2533d;
    private int f2534e;
    private int f2535f;
    private int f2536g;
    private int f2537h;
    private int f2538i;
    private int f2539j;
    private int f2540k;
    private int f2541l;
    private Paint f2542m;
    private Paint f2543n;

    public C1247a(Context context) {
        this(context, null);
    }

    public C1247a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1247a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2534e = -4408132;
        this.f2535f = -7232456;
        this.f2536g = -12895429;
        this.f2537h = -7232456;
        this.f2538i = -1723631233;
        this.f2539j = 4;
        this.f2540k = 0;
        this.f2541l = -1;
        this.f2542m = new Paint();
        this.f2543n = new Paint();
        this.f2530a = 0;
        this.f2531b = 0;
        this.f2532c = 0;
        this.f2533d = 0;
        setSingleLine(true);
        setEllipsize(TruncateAt.END);
        setPadding(0, 0, 0, 0);
        setFocusable(true);
    }

    private int m2941a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }

    private int m2942a(int[] iArr, float f) {
        if (f <= 0.0f) {
            return iArr[0];
        }
        if (f >= 1.0f) {
            return iArr[iArr.length - 1];
        }
        float length = ((float) (iArr.length - 1)) * f;
        int i = (int) length;
        length -= (float) i;
        int i2 = iArr[i];
        i = iArr[i + 1];
        return Color.argb(m2941a(Color.alpha(i2), Color.alpha(i), length), m2941a(Color.red(i2), Color.red(i), length), m2941a(Color.green(i2), Color.green(i), length), m2941a(Color.blue(i2), Color.blue(i), length));
    }

    public void m2943a(int i, int i2) {
        this.f2534e = i;
        this.f2535f = i2;
    }

    public void m2944b(int i, int i2) {
        this.f2536g = i;
        this.f2537h = i2;
    }

    protected void drawableStateChanged() {
        invalidate();
        super.drawableStateChanged();
    }

    public int getIndex() {
        return this.f2541l;
    }

    protected synchronized void onDraw(Canvas canvas) {
        Paint paint = this.f2542m;
        Paint paint2 = this.f2543n;
        paint2.setColor(this.f2538i);
        setTextColor(m2942a(new int[]{this.f2534e, this.f2535f}, ((float) this.f2540k) / 100.0f));
        paint.setColor(m2942a(new int[]{this.f2536g, this.f2537h}, ((float) this.f2540k) / 100.0f));
        canvas.drawRect(0.0f, (float) (getHeight() - this.f2539j), (float) getWidth(), (float) getHeight(), paint);
        if (isFocused() || isPressed()) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), paint2);
        }
        super.onDraw(canvas);
    }

    public void setBackgroundColorPressed(int i) {
        this.f2538i = i;
    }

    public void setCenterPercent(int i) {
        int i2 = 100;
        int i3 = i < 0 ? 0 : i;
        if (i3 <= 100) {
            i2 = i3;
        }
        this.f2540k = i2;
    }

    public void setIndex(int i) {
        this.f2541l = i;
    }

    public void setLineHeight(int i) {
        this.f2539j = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getText()).append(": ");
        stringBuilder.append(this.f2531b);
        stringBuilder.append(" <- ").append(this.f2530a);
        stringBuilder.append(" -> ").append(this.f2532c);
        stringBuilder.append(" (").append(this.f2533d).append(")");
        return stringBuilder.toString();
    }
}
