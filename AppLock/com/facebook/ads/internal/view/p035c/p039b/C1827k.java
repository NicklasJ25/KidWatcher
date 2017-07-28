package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p040c.C1847d;

public class C1827k extends C1785n {
    private final C1829l f4541b;
    private final C1765i f4542c = new C18231(this);
    private final C1767k f4543d = new C18242(this);
    private final C1759c f4544e = new C18253(this);
    private final Paint f4545f;
    private final RectF f4546g;

    class C18231 extends C1765i {
        final /* synthetic */ C1827k f4536a;

        C18231(C1827k c1827k) {
            this.f4536a = c1827k;
        }

        public void m5132a(C1764h c1764h) {
            this.f4536a.f4541b.setChecked(true);
        }
    }

    class C18242 extends C1767k {
        final /* synthetic */ C1827k f4537a;

        C18242(C1827k c1827k) {
            this.f4537a = c1827k;
        }

        public void m5134a(C1766j c1766j) {
            this.f4537a.f4541b.setChecked(false);
        }
    }

    class C18253 extends C1759c {
        final /* synthetic */ C1827k f4538a;

        C18253(C1827k c1827k) {
            this.f4538a = c1827k;
        }

        public void m5136a(C1758b c1758b) {
            this.f4538a.f4541b.setChecked(true);
        }
    }

    public C1827k(Context context) {
        super(context);
        this.f4541b = new C1829l(context);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 50.0f), (int) (displayMetrics.density * 50.0f));
        layoutParams.addRule(13);
        this.f4541b.setLayoutParams(layoutParams);
        this.f4541b.setChecked(true);
        this.f4545f = new Paint();
        this.f4545f.setStyle(Style.FILL);
        this.f4545f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4545f.setAlpha(119);
        this.f4546g = new RectF();
        setBackgroundColor(0);
        addView(this.f4541b);
        setGravity(17);
        layoutParams = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 75.0d), (int) (((double) displayMetrics.density) * 75.0d));
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
    }

    protected void a_(final C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4542c);
        c1864k.getEventBus().m4513a(this.f4543d);
        c1864k.getEventBus().m4513a(this.f4544e);
        this.f4541b.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ C1827k f4540b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    return true;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                if (c1864k.getState() == C1847d.PREPARED) {
                    c1864k.mo2828d();
                    return true;
                } else if (c1864k.getState() == C1847d.IDLE) {
                    c1864k.mo2828d();
                    return true;
                } else if (c1864k.getState() == C1847d.PAUSED) {
                    c1864k.mo2828d();
                    return true;
                } else if (c1864k.getState() == C1847d.STARTED) {
                    c1864k.m5256e();
                    return true;
                } else if (c1864k.getState() != C1847d.PLAYBACK_COMPLETED) {
                    return false;
                } else {
                    c1864k.mo2828d();
                    return true;
                }
            }
        });
        super.a_(c1864k);
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4546g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f4546g, 5.0f * f, f * 5.0f, this.f4545f);
        super.onDraw(canvas);
    }
}
