package com.facebook.ads.internal.view.p035c.p039b;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.p022h.C1610r;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import com.facebook.ads.internal.view.p035c.p036a.C1770o;
import java.util.concurrent.atomic.AtomicInteger;

public class C1836p extends RelativeLayout implements C1784m {
    private ObjectAnimator f4564a;
    private AtomicInteger f4565b = new AtomicInteger(-1);
    private ProgressBar f4566c;
    private C1864k f4567d;
    private C1511s f4568e = new C18331(this);
    private C1511s f4569f = new C18342(this);
    private C1511s f4570g = new C18353(this);

    class C18331 extends C1770o {
        final /* synthetic */ C1836p f4561a;

        C18331(C1836p c1836p) {
            this.f4561a = c1836p;
        }

        public void m5146a(C1769n c1769n) {
            if (this.f4561a.f4567d != null) {
                this.f4561a.m5152a(this.f4561a.f4567d.getDuration(), this.f4561a.f4567d.getCurrentPosition());
            }
        }
    }

    class C18342 extends C1765i {
        final /* synthetic */ C1836p f4562a;

        C18342(C1836p c1836p) {
            this.f4562a = c1836p;
        }

        public void m5148a(C1764h c1764h) {
            this.f4562a.m5154b();
        }
    }

    class C18353 extends C1767k {
        final /* synthetic */ C1836p f4563a;

        C18353(C1836p c1836p) {
            this.f4563a = c1836p;
        }

        public void m5150a(C1766j c1766j) {
            if (this.f4563a.f4567d != null) {
                this.f4563a.m5152a(this.f4563a.f4567d.getDuration(), this.f4563a.f4567d.getCurrentPosition());
            }
        }
    }

    public C1836p(Context context, int i) {
        super(context);
        this.f4566c = new ProgressBar(context, null, 16842872);
        this.f4566c.setLayoutParams(new LayoutParams(-1, i));
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ColorDrawable colorDrawable2 = new ColorDrawable(0);
        ScaleDrawable scaleDrawable = new ScaleDrawable(new ColorDrawable(-16711681), GravityCompat.START, 1.0f, -1.0f);
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{colorDrawable, colorDrawable2, scaleDrawable});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f4566c.setProgressDrawable(layerDrawable);
        this.f4566c.setMax(10000);
        addView(this.f4566c);
    }

    private void m5152a(int i, int i2) {
        m5154b();
        if (this.f4565b.get() < i2 && i > i2) {
            int i3 = (i2 * 10000) / i;
            int min = (Math.min(i2 + Callback.DEFAULT_SWIPE_ANIMATION_DURATION, i) * 10000) / i;
            this.f4564a = ObjectAnimator.ofInt(this.f4566c, "progress", new int[]{i3, min});
            this.f4564a.setDuration((long) Math.min(Callback.DEFAULT_SWIPE_ANIMATION_DURATION, i - i2));
            this.f4564a.setInterpolator(new LinearInterpolator());
            this.f4564a.start();
            this.f4565b.set(i2);
        }
    }

    private void m5154b() {
        if (this.f4564a != null) {
            this.f4564a.cancel();
            this.f4564a.setTarget(null);
            this.f4564a = null;
            this.f4566c.clearAnimation();
        }
    }

    public void m5156a() {
        m5154b();
        this.f4566c = null;
        this.f4567d = null;
    }

    public void mo2783a(C1864k c1864k) {
        this.f4567d = c1864k;
        C1610r eventBus = c1864k.getEventBus();
        eventBus.m4513a(this.f4569f);
        eventBus.m4513a(this.f4570g);
        eventBus.m4513a(this.f4568e);
    }
}
