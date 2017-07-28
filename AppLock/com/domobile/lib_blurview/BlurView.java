package com.domobile.lib_blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.domobile.lib_blurview.C1331e.C1330a;

public class BlurView extends FrameLayout {
    private static final String f2851b = BlurView.class.getSimpleName();
    C1321c f2852a = m3269a();
    @ColorInt
    private int f2853c;

    class C13223 implements C1321c {
        final /* synthetic */ BlurView f2849a;

        C13223(BlurView blurView) {
            this.f2849a = blurView;
        }

        public void mo2561a(float f) {
        }

        public void mo2562a(Canvas canvas) {
        }

        public void mo2563a(@Nullable Drawable drawable) {
        }

        public void mo2564a(C1328b c1328b) {
        }

        public void mo2565a(boolean z) {
        }

        public void mo2566b() {
        }

        public void mo2567b(Canvas canvas) {
        }

        public void mo2568b(boolean z) {
        }

        public void mo2569c() {
        }
    }

    public static class C1323a {
        C1321c f2850a;

        C1323a(C1321c c1321c) {
            this.f2850a = c1321c;
        }

        public C1323a m3266a(float f) {
            this.f2850a.mo2561a(f);
            return this;
        }

        public C1323a m3267a(@Nullable Drawable drawable) {
            this.f2850a.mo2563a(drawable);
            return this;
        }

        public C1323a m3268a(C1328b c1328b) {
            this.f2850a.mo2564a(c1328b);
            return this;
        }
    }

    public BlurView(Context context) {
        super(context);
        m3271a(null, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3271a(attributeSet, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3271a(attributeSet, i);
    }

    private C1321c m3269a() {
        return new C13223(this);
    }

    private void m3270a(Canvas canvas) {
        canvas.drawColor(this.f2853c);
    }

    private void m3271a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1330a.BlurView, i, 0);
        this.f2853c = obtainStyledAttributes.getColor(C1330a.BlurView_blurOverlayColor, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    private void setBlurController(@NonNull C1321c c1321c) {
        this.f2852a.mo2569c();
        this.f2852a = c1321c;
    }

    public C1323a m3272a(@NonNull ViewGroup viewGroup) {
        C1321c c1327a = new C1327a(this, viewGroup);
        setBlurController(c1327a);
        if (!isHardwareAccelerated()) {
            c1327a.mo2568b(false);
        }
        return new C1323a(c1327a);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f2852a.mo2567b(canvas);
    }

    public void draw(Canvas canvas) {
        if (canvas.isHardwareAccelerated()) {
            this.f2852a.mo2562a(canvas);
            m3270a(canvas);
            super.draw(canvas);
        } else if (!isHardwareAccelerated()) {
            super.draw(canvas);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            this.f2852a.mo2568b(true);
        } else {
            Log.e(f2851b, "BlurView can't be used in not hardware-accelerated window!");
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2852a.mo2568b(false);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2852a.mo2566b();
    }

    public void setBlurAutoUpdate(final boolean z) {
        post(new Runnable(this) {
            final /* synthetic */ BlurView f2846b;

            public void run() {
                this.f2846b.f2852a.mo2568b(z);
            }
        });
    }

    public void setBlurEnabled(final boolean z) {
        post(new Runnable(this) {
            final /* synthetic */ BlurView f2848b;

            public void run() {
                this.f2848b.f2852a.mo2565a(z);
            }
        });
    }

    public void setOverlayColor(@ColorInt int i) {
        if (i != this.f2853c) {
            this.f2853c = i;
            invalidate();
        }
    }
}
