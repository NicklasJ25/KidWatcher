package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import com.facebook.ads.internal.view.p035c.p036a.C1770o;

public class C1832o extends View implements C1784m {
    private final Paint f4555a = new Paint();
    private final Rect f4556b;
    private float f4557c;
    private final C1770o f4558d = new C18301(this);
    private final C1759c f4559e = new C18312(this);
    @Nullable
    private C1864k f4560f;

    class C18301 extends C1770o {
        final /* synthetic */ C1832o f4553a;

        C18301(C1832o c1832o) {
            this.f4553a = c1832o;
        }

        public void m5139a(C1769n c1769n) {
            if (this.f4553a.f4560f != null) {
                int duration = this.f4553a.f4560f.getDuration();
                if (duration > 0) {
                    this.f4553a.f4557c = ((float) this.f4553a.f4560f.getCurrentPosition()) / ((float) duration);
                } else {
                    this.f4553a.f4557c = 0.0f;
                }
                this.f4553a.postInvalidate();
            }
        }
    }

    class C18312 extends C1759c {
        final /* synthetic */ C1832o f4554a;

        C18312(C1832o c1832o) {
            this.f4554a = c1832o;
        }

        public void m5141a(C1758b c1758b) {
            if (this.f4554a.f4560f != null) {
                this.f4554a.f4557c = 0.0f;
                this.f4554a.postInvalidate();
            }
        }
    }

    public C1832o(Context context) {
        super(context);
        this.f4555a.setStyle(Style.FILL);
        this.f4555a.setColor(-9528840);
        this.f4556b = new Rect();
    }

    public void mo2783a(C1864k c1864k) {
        this.f4560f = c1864k;
        c1864k.getEventBus().m4513a(this.f4558d);
        c1864k.getEventBus().m4513a(this.f4559e);
    }

    public void draw(Canvas canvas) {
        this.f4556b.set(0, 0, (int) (((float) getWidth()) * this.f4557c), getHeight());
        canvas.drawRect(this.f4556b, this.f4555a);
        super.draw(canvas);
    }
}
