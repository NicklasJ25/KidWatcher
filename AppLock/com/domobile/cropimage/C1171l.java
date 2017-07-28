package com.domobile.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

abstract class C1171l extends ImageView {
    private final Matrix f2255a;
    private final float[] f2256b;
    private C1206a f2257c;
    private Runnable f2258d;
    protected Matrix f2259f;
    protected Matrix f2260g;
    protected final C1210o f2261h;
    int f2262i;
    int f2263j;
    float f2264k;
    protected Handler f2265l;

    public interface C1206a {
        void m2819a(Bitmap bitmap);
    }

    public C1171l(Context context) {
        super(context);
        this.f2259f = new Matrix();
        this.f2260g = new Matrix();
        this.f2255a = new Matrix();
        this.f2256b = new float[9];
        this.f2261h = new C1210o(null);
        this.f2262i = -1;
        this.f2263j = -1;
        this.f2265l = new Handler();
        this.f2258d = null;
        m2690c();
    }

    public C1171l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2259f = new Matrix();
        this.f2260g = new Matrix();
        this.f2255a = new Matrix();
        this.f2256b = new float[9];
        this.f2261h = new C1210o(null);
        this.f2262i = -1;
        this.f2263j = -1;
        this.f2265l = new Handler();
        this.f2258d = null;
        m2690c();
    }

    private void m2688a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap b = this.f2261h.m2827b();
        this.f2261h.m2826a(bitmap);
        this.f2261h.m2825a(i);
        if (b != null && b != bitmap && this.f2257c != null) {
            this.f2257c.m2819a(b);
        }
    }

    private void m2689a(C1210o c1210o, Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float f = (float) c1210o.m2831f();
        float e = (float) c1210o.m2830e();
        matrix.reset();
        float min = Math.min(Math.min(width / f, 3.0f), Math.min(height / e, 3.0f));
        matrix.postConcat(c1210o.m2828c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (f * min)) / 2.0f, (height - (e * min)) / 2.0f);
    }

    private void m2690c() {
        setScaleType(ScaleType.MATRIX);
    }

    protected float m2691a(Matrix matrix) {
        return m2692a(matrix, 0);
    }

    protected float m2692a(Matrix matrix, int i) {
        matrix.getValues(this.f2256b);
        return this.f2256b[i];
    }

    public void mo2495a() {
        mo2498a(null, true);
    }

    protected void m2694a(float f) {
        mo2497a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    protected void mo2496a(float f, float f2) {
        this.f2260g.postTranslate(f, f2);
    }

    protected void mo2497a(float f, float f2, float f3) {
        if (f > this.f2264k) {
            f = this.f2264k;
        }
        float scale = f / getScale();
        this.f2260g.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        m2700a(true, true);
    }

    protected void m2697a(float f, float f2, float f3, float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f5 = f4;
        final float f6 = f2;
        final float f7 = f3;
        this.f2265l.post(new Runnable(this) {
            final /* synthetic */ C1171l f2377g;

            public void run() {
                float min = Math.min(f5, (float) (System.currentTimeMillis() - currentTimeMillis));
                this.f2377g.mo2497a(scale2 + (scale * min), f6, f7);
                if (min < f5) {
                    this.f2377g.f2265l.post(this);
                }
            }
        });
    }

    public void mo2498a(Bitmap bitmap, boolean z) {
        mo2499a(new C1210o(bitmap), z);
    }

    public void mo2499a(final C1210o c1210o, final boolean z) {
        if (getWidth() <= 0) {
            this.f2258d = new Runnable(this) {
                final /* synthetic */ C1171l f2370c;

                public void run() {
                    this.f2370c.mo2499a(c1210o, z);
                }
            };
            return;
        }
        if (c1210o.m2827b() != null) {
            m2689a(c1210o, this.f2259f);
            m2688a(c1210o.m2827b(), c1210o.m2824a());
        } else {
            this.f2259f.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f2260g.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.f2264k = m2701b();
    }

    protected void m2700a(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.f2261h.m2827b() != null) {
            int height;
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f2261h.m2827b().getWidth(), (float) this.f2261h.m2827b().getHeight());
            imageViewMatrix.mapRect(rectF);
            float height2 = rectF.height();
            float width = rectF.width();
            if (z2) {
                height = getHeight();
                if (height2 < ((float) height)) {
                    height2 = ((((float) height) - height2) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height2 = -rectF.top;
                } else if (rectF.bottom < ((float) height)) {
                    height2 = ((float) getHeight()) - rectF.bottom;
                }
                if (z) {
                    height = getWidth();
                    if (width < ((float) height)) {
                        f = ((((float) height) - width) / 2.0f) - rectF.left;
                    } else if (rectF.left > 0.0f) {
                        f = -rectF.left;
                    } else if (rectF.right < ((float) height)) {
                        f = ((float) height) - rectF.right;
                    }
                }
                mo2496a(f, height2);
                setImageMatrix(getImageViewMatrix());
            }
            height2 = 0.0f;
            if (z) {
                height = getWidth();
                if (width < ((float) height)) {
                    f = ((((float) height) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) height)) {
                    f = ((float) height) - rectF.right;
                }
            }
            mo2496a(f, height2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected float m2701b() {
        return this.f2261h.m2827b() == null ? 1.0f : Math.max(((float) this.f2261h.m2831f()) / ((float) this.f2262i), ((float) this.f2261h.m2830e()) / ((float) this.f2263j)) * 4.0f;
    }

    protected void m2702b(float f, float f2) {
        mo2496a(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected Matrix getImageViewMatrix() {
        this.f2255a.set(this.f2259f);
        this.f2255a.postConcat(this.f2260g);
        return this.f2255a;
    }

    protected float getScale() {
        return m2691a(this.f2260g);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m2694a(1.0f);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2262i = i3 - i;
        this.f2263j = i4 - i2;
        Runnable runnable = this.f2258d;
        if (runnable != null) {
            this.f2258d = null;
            runnable.run();
        }
        if (this.f2261h.m2827b() != null) {
            m2689a(this.f2261h, this.f2259f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        m2688a(bitmap, 0);
    }

    public void setRecycler(C1206a c1206a) {
        this.f2257c = c1206a;
    }
}
