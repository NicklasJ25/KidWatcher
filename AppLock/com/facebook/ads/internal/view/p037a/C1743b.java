package com.facebook.ads.internal.view.p037a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

@TargetApi(19)
public class C1743b extends ProgressBar {
    private static final int f4398a = Color.argb(26, 0, 0, 0);
    private static final int f4399b = Color.rgb(88, 144, 255);
    private Rect f4400c;
    private Paint f4401d;

    public C1743b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5008a();
    }

    private void m5008a() {
        setIndeterminate(false);
        setMax(100);
        setProgressDrawable(m5009b());
        this.f4400c = new Rect();
        this.f4401d = new Paint();
        this.f4401d.setStyle(Style.FILL);
        this.f4401d.setColor(f4398a);
    }

    private Drawable m5009b() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(f4399b), 3, 1);
        return new LayerDrawable(new Drawable[]{colorDrawable, clipDrawable});
    }

    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawRect(this.f4400c, this.f4401d);
        super.onDraw(canvas);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f4400c.set(0, 0, getMeasuredWidth(), 2);
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i == 100 ? 0 : Math.max(i, 5));
    }
}
