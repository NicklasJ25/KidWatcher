package com.facebook.ads.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class C1614i extends View {
    private Paint f4007a;
    private Paint f4008b;
    private Paint f4009c;
    private int f4010d;
    private boolean f4011e;

    public C1614i(Context context) {
        this(context, 60, true);
    }

    public C1614i(Context context, int i, boolean z) {
        super(context);
        this.f4010d = i;
        this.f4011e = z;
        if (z) {
            this.f4007a = new Paint();
            this.f4007a.setColor(-3355444);
            this.f4007a.setStyle(Style.STROKE);
            this.f4007a.setStrokeWidth(3.0f);
            this.f4007a.setAntiAlias(true);
            this.f4008b = new Paint();
            this.f4008b.setColor(-1287371708);
            this.f4008b.setStyle(Style.FILL);
            this.f4008b.setAntiAlias(true);
            this.f4009c = new Paint();
            this.f4009c.setColor(-1);
            this.f4009c.setStyle(Style.STROKE);
            this.f4009c.setStrokeWidth(6.0f);
            this.f4009c.setAntiAlias(true);
        }
        m4525a();
    }

    private void m4525a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f4010d) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f4010d)));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4011e) {
            if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.f4007a);
            canvas.drawCircle((float) i, (float) i2, (float) (i3 - 2), this.f4008b);
            int i4 = min / 3;
            int i5 = min / 3;
            canvas.drawLine((float) i4, (float) i5, (float) (i4 * 2), (float) (i5 * 2), this.f4009c);
            canvas.drawLine((float) (i4 * 2), (float) i5, (float) i4, (float) (i5 * 2), this.f4009c);
        }
        super.onDraw(canvas);
    }
}
