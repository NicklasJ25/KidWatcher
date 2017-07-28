package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import com.facebook.ads.internal.view.p035c.p036a.C1770o;
import java.util.concurrent.atomic.AtomicInteger;

public class C1820i extends View implements C1784m {
    private final Paint f4524a;
    private final Paint f4525b;
    private final Paint f4526c;
    private final RectF f4527d;
    private C1864k f4528e;
    private int f4529f;
    private final AtomicInteger f4530g = new AtomicInteger(0);
    private final C1770o f4531h = new C18181(this);
    private final C1759c f4532i = new C18192(this);

    class C18181 extends C1770o {
        final /* synthetic */ C1820i f4522a;

        C18181(C1820i c1820i) {
            this.f4522a = c1820i;
        }

        public void m5119a(C1769n c1769n) {
            this.f4522a.f4530g.set((this.f4522a.f4529f * 1000) - this.f4522a.f4528e.getCurrentPosition());
            this.f4522a.postInvalidate();
        }
    }

    class C18192 extends C1759c {
        final /* synthetic */ C1820i f4523a;

        C18192(C1820i c1820i) {
            this.f4523a = c1820i;
        }

        public void m5121a(C1758b c1758b) {
            this.f4523a.f4529f = 0;
        }
    }

    public C1820i(Context context, int i, int i2) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.f4529f = i;
        this.f4524a = new Paint();
        this.f4524a.setStyle(Style.FILL);
        this.f4524a.setColor(i2);
        this.f4525b = new Paint();
        this.f4525b.setColor(-3355444);
        this.f4525b.setStyle(Style.FILL);
        this.f4525b.setStrokeWidth(1.0f * f);
        this.f4525b.setAntiAlias(true);
        this.f4526c = new Paint();
        this.f4526c.setColor(-10066330);
        this.f4526c.setStyle(Style.STROKE);
        this.f4526c.setStrokeWidth(f * 2.0f);
        this.f4526c.setAntiAlias(true);
        this.f4527d = new RectF();
    }

    public void mo2783a(C1864k c1864k) {
        this.f4528e = c1864k;
        this.f4528e.getEventBus().m4513a(this.f4531h);
        this.f4528e.getEventBus().m4513a(this.f4532i);
    }

    public boolean m5127a() {
        return this.f4528e == null ? false : this.f4529f <= 0 || this.f4530g.get() < 0;
    }

    public int getSkipSeconds() {
        return this.f4529f;
    }

    protected void onDraw(Canvas canvas) {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i = min / 2;
        canvas.drawCircle((float) (getPaddingLeft() + i), (float) ((min / 2) + getPaddingTop()), (float) i, this.f4525b);
        if (this.f4530g.get() <= 0) {
            int i2 = min / 3;
            int i3 = min / 3;
            canvas.drawLine((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i3), (float) ((i2 * 2) + getPaddingLeft()), (float) ((i3 * 2) + getPaddingTop()), this.f4526c);
            canvas.drawLine((float) ((i2 * 2) + getPaddingLeft()), (float) (getPaddingTop() + i3), (float) (getPaddingLeft() + i2), (float) ((i3 * 2) + getPaddingTop()), this.f4526c);
        } else {
            this.f4527d.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            canvas.drawArc(this.f4527d, -90.0f, ((float) (-(this.f4530g.get() * 360))) / ((float) (this.f4529f * 1000)), true, this.f4524a);
        }
        super.onDraw(canvas);
    }
}
