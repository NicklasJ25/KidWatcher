package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.widget.Button;

public class C1829l extends Button {
    private final Path f4548a = new Path();
    private final Path f4549b = new Path();
    private final Paint f4550c = new C18281(this);
    private final Path f4551d = new Path();
    private boolean f4552e = false;

    class C18281 extends Paint {
        final /* synthetic */ C1829l f4547a;

        C18281(C1829l c1829l) {
            this.f4547a = c1829l;
            setStyle(Style.FILL_AND_STROKE);
            setStrokeCap(Cap.ROUND);
            setStrokeWidth(3.0f);
            setAntiAlias(true);
            setColor(-1);
        }
    }

    public C1829l(Context context) {
        super(context);
        setClickable(true);
        setBackgroundColor(0);
    }

    protected void onDraw(Canvas canvas) {
        if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
        if (this.f4552e) {
            this.f4551d.rewind();
            this.f4551d.moveTo(26.5f * max, 15.5f * max);
            this.f4551d.lineTo(26.5f * max, 84.5f * max);
            this.f4551d.lineTo(82.5f * max, 50.5f * max);
            this.f4551d.lineTo(26.5f * max, max * 15.5f);
            this.f4551d.close();
            canvas.drawPath(this.f4551d, this.f4550c);
        } else {
            this.f4548a.rewind();
            this.f4548a.moveTo(29.0f * max, 21.0f * max);
            this.f4548a.lineTo(29.0f * max, 79.0f * max);
            this.f4548a.lineTo(45.0f * max, 79.0f * max);
            this.f4548a.lineTo(45.0f * max, 21.0f * max);
            this.f4548a.lineTo(29.0f * max, 21.0f * max);
            this.f4548a.close();
            this.f4549b.rewind();
            this.f4549b.moveTo(55.0f * max, 21.0f * max);
            this.f4549b.lineTo(55.0f * max, 79.0f * max);
            this.f4549b.lineTo(71.0f * max, 79.0f * max);
            this.f4549b.lineTo(71.0f * max, 21.0f * max);
            this.f4549b.lineTo(55.0f * max, max * 21.0f);
            this.f4549b.close();
            canvas.drawPath(this.f4548a, this.f4550c);
            canvas.drawPath(this.f4549b, this.f4550c);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.f4552e = z;
        refreshDrawableState();
        invalidate();
    }
}
