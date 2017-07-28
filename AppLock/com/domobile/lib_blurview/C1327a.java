package com.domobile.lib_blurview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;

class C1327a implements C1321c {
    private static final String f2857c = C1327a.class.getSimpleName();
    final View f2858a;
    boolean f2859b;
    private final float f2860d = 8.0f;
    private float f2861e = 16.0f;
    private float f2862f = 1.0f;
    private float f2863g = 1.0f;
    private C1328b f2864h;
    private Canvas f2865i;
    private Bitmap f2866j;
    private final ViewGroup f2867k;
    private final Rect f2868l = new Rect();
    private final OnPreDrawListener f2869m = new C13241(this);
    private boolean f2870n = true;
    private final Runnable f2871o = new C13252(this);
    @Nullable
    private Drawable f2872p;
    private boolean f2873q = true;

    class C13241 implements OnPreDrawListener {
        final /* synthetic */ C1327a f2854a;

        C13241(C1327a c1327a) {
            this.f2854a = c1327a;
        }

        public boolean onPreDraw() {
            if (!this.f2854a.f2859b) {
                this.f2854a.m3283a();
            }
            return true;
        }
    }

    class C13252 implements Runnable {
        final /* synthetic */ C1327a f2855a;

        C13252(C1327a c1327a) {
            this.f2855a = c1327a;
        }

        public void run() {
            this.f2855a.f2859b = false;
        }
    }

    class C13263 implements OnGlobalLayoutListener {
        final /* synthetic */ C1327a f2856a;

        C13263(C1327a c1327a) {
            this.f2856a = c1327a;
        }

        private void m3273a() {
            this.f2856a.f2858a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (VERSION.SDK_INT >= 16) {
                this.f2856a.f2858a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                m3273a();
            }
            this.f2856a.m3285a(this.f2856a.f2858a.getMeasuredWidth(), this.f2856a.f2858a.getMeasuredHeight());
        }
    }

    C1327a(@NonNull View view, @NonNull ViewGroup viewGroup) {
        this.f2867k = viewGroup;
        this.f2858a = view;
        this.f2864h = new C1329d();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (m3276b(measuredWidth, measuredHeight)) {
            m3279d();
        } else {
            m3285a(measuredWidth, measuredHeight);
        }
    }

    private int m3274a(int i) {
        return i % 16 == 0 ? i : (i - (i % 16)) + 16;
    }

    private int m3275b(float f) {
        return (int) Math.ceil((double) (f / 8.0f));
    }

    private boolean m3276b(int i, int i2) {
        return m3275b((float) i2) == 0 || m3275b((float) i) == 0;
    }

    private void m3277c(int i, int i2) {
        int b = m3275b((float) i);
        int b2 = m3275b((float) i2);
        int a = m3274a(b);
        int a2 = m3274a(b2);
        this.f2863g = ((float) b2) / ((float) a2);
        this.f2862f = ((float) b) / ((float) a);
        this.f2866j = Bitmap.createBitmap(a, a2, this.f2864h.mo2572b());
    }

    private void m3278c(Canvas canvas) {
        canvas.save();
        canvas.scale(this.f2862f * 8.0f, this.f2863g * 8.0f);
        canvas.drawBitmap(this.f2866j, 0.0f, 0.0f, null);
        canvas.restore();
    }

    private void m3279d() {
        this.f2858a.getViewTreeObserver().addOnGlobalLayoutListener(new C13263(this));
    }

    private void m3280e() {
        this.f2858a.getDrawingRect(this.f2868l);
        if (this.f2873q) {
            try {
                this.f2867k.offsetDescendantRectToMyCoords(this.f2858a, this.f2868l);
            } catch (IllegalArgumentException e) {
                this.f2873q = false;
            }
        }
        float f = this.f2862f * 8.0f;
        float f2 = this.f2863g * 8.0f;
        float translationX = this.f2858a.getTranslationX() / f;
        this.f2865i.translate((((float) (-this.f2868l.left)) / f) - translationX, (((float) (-this.f2868l.top)) / f2) - (this.f2858a.getTranslationY() / f2));
        this.f2865i.scale(1.0f / f, 1.0f / f2);
    }

    private void m3281f() {
        if (this.f2872p != null) {
            this.f2872p.draw(this.f2865i);
        }
        this.f2867k.draw(this.f2865i);
    }

    private void m3282g() {
        this.f2866j = this.f2864h.mo2570a(this.f2866j, this.f2861e);
    }

    void m3283a() {
        this.f2859b = true;
        this.f2858a.invalidate();
    }

    public void mo2561a(float f) {
        this.f2861e = f;
    }

    void m3285a(int i, int i2) {
        if (m3276b(i, i2)) {
            this.f2858a.setWillNotDraw(true);
            mo2568b(false);
            return;
        }
        this.f2858a.setWillNotDraw(false);
        m3277c(i, i2);
        this.f2865i = new Canvas(this.f2866j);
        mo2568b(true);
    }

    public void mo2562a(Canvas canvas) {
        this.f2859b = true;
        if (this.f2870n) {
            this.f2865i.save();
            m3280e();
            m3281f();
            this.f2865i.restore();
            m3282g();
            m3278c(canvas);
        }
    }

    public void mo2563a(@Nullable Drawable drawable) {
        this.f2872p = drawable;
    }

    public void mo2564a(C1328b c1328b) {
        this.f2864h = c1328b;
    }

    public void mo2565a(boolean z) {
        this.f2870n = z;
        mo2568b(z);
        this.f2858a.invalidate();
    }

    public void mo2566b() {
        m3285a(this.f2858a.getMeasuredWidth(), this.f2858a.getMeasuredHeight());
    }

    public void mo2567b(Canvas canvas) {
        this.f2858a.post(this.f2871o);
    }

    public void mo2568b(boolean z) {
        this.f2858a.getViewTreeObserver().removeOnPreDrawListener(this.f2869m);
        if (z) {
            this.f2858a.getViewTreeObserver().addOnPreDrawListener(this.f2869m);
        }
    }

    public void mo2569c() {
        mo2568b(false);
        this.f2864h.mo2571a();
        if (this.f2866j != null) {
            this.f2866j.recycle();
        }
    }
}
