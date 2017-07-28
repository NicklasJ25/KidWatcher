package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import java.util.concurrent.atomic.AtomicBoolean;

public class C1817h extends C1785n {
    private final C1816a f4516b;
    private final int f4517c;
    private final String f4518d;
    private final String f4519e;
    private final AtomicBoolean f4520f;
    private final C1511s<C1769n> f4521g = new C18141(this);

    class C18141 extends C1511s<C1769n> {
        final /* synthetic */ C1817h f4510a;

        C18141(C1817h c1817h) {
            this.f4510a = c1817h;
        }

        public Class<C1769n> mo2709a() {
            return C1769n.class;
        }

        public void m5112a(C1769n c1769n) {
            if (!this.f4510a.f4520f.get()) {
                int b = this.f4510a.f4517c - (this.f4510a.getVideoView().getCurrentPosition() / 1000);
                if (b > 0) {
                    this.f4510a.f4516b.setText(this.f4510a.f4518d + ' ' + b);
                    return;
                }
                this.f4510a.f4516b.setText(this.f4510a.f4519e);
                this.f4510a.f4520f.set(true);
            }
        }
    }

    private static class C1816a extends TextView {
        private final Paint f4513a = new Paint();
        private final Paint f4514b;
        private final RectF f4515c;

        public C1816a(Context context) {
            super(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            setBackgroundColor(0);
            setTextColor(-3355444);
            setPadding((int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f), (int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f));
            setTextSize(18.0f);
            this.f4513a.setStyle(Style.STROKE);
            this.f4513a.setColor(-10066330);
            this.f4513a.setStrokeWidth(1.0f);
            this.f4513a.setAntiAlias(true);
            this.f4514b = new Paint();
            this.f4514b.setStyle(Style.FILL);
            this.f4514b.setColor(-1895825408);
            this.f4515c = new RectF();
        }

        protected void onDraw(Canvas canvas) {
            if (getText().length() != 0) {
                int width = getWidth();
                int height = getHeight();
                this.f4515c.set((float) null, (float) null, (float) width, (float) height);
                canvas.drawRoundRect(this.f4515c, 6.0f, 6.0f, this.f4514b);
                this.f4515c.set((float) 2, (float) 2, (float) (width - 2), (float) (height - 2));
                canvas.drawRoundRect(this.f4515c, 6.0f, 6.0f, this.f4513a);
                super.onDraw(canvas);
            }
        }
    }

    public C1817h(Context context, int i, String str, String str2) {
        super(context);
        this.f4517c = i;
        this.f4518d = str;
        this.f4519e = str2;
        this.f4520f = new AtomicBoolean(false);
        this.f4516b = new C1816a(context);
        this.f4516b.setText(this.f4518d + ' ' + i);
        addView(this.f4516b, new LayoutParams(-2, -2));
    }

    public void a_(final C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4521g);
        this.f4516b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C1817h f4512b;

            public void onClick(View view) {
                if (this.f4512b.f4520f.get()) {
                    c1864k.m5257f();
                } else {
                    Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
                }
            }
        });
    }
}
