package com.domobile.cropimage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.domobile.p015b.C1168b.C1161e;

class C1191e {
    View f2330a;
    boolean f2331b;
    boolean f2332c;
    Rect f2333d;
    RectF f2334e;
    Matrix f2335f;
    private C1190a f2336g = C1190a.None;
    private RectF f2337h;
    private boolean f2338i = false;
    private float f2339j;
    private boolean f2340k = false;
    private Drawable f2341l;
    private Drawable f2342m;
    private Drawable f2343n;
    private final Paint f2344o = new Paint();
    private final Paint f2345p = new Paint();
    private final Paint f2346q = new Paint();

    enum C1190a {
        None,
        Move,
        Grow
    }

    public C1191e(View view) {
        this.f2330a = view;
        if (VERSION.SDK_INT > 11) {
            this.f2330a.setLayerType(1, null);
        }
    }

    private void m2765d() {
        Resources resources = this.f2330a.getResources();
        this.f2341l = resources.getDrawable(C1161e.image_crop_width);
        this.f2342m = resources.getDrawable(C1161e.image_crop_height);
        this.f2343n = resources.getDrawable(C1161e.image_autocrop);
    }

    private Rect m2766e() {
        RectF rectF = new RectF(this.f2334e.left, this.f2334e.top, this.f2334e.right, this.f2334e.bottom);
        this.f2335f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int m2767a(float f, float f2) {
        Object obj = null;
        Rect e = m2766e();
        int sqrt;
        if (this.f2340k) {
            float centerX = f - ((float) e.centerX());
            float centerY = f2 - ((float) e.centerY());
            sqrt = (int) Math.sqrt((double) ((centerX * centerX) + (centerY * centerY)));
            int width = this.f2333d.width() / 2;
            return ((float) Math.abs(sqrt - width)) <= 20.0f ? Math.abs(centerY) > Math.abs(centerX) ? centerY < 0.0f ? 8 : 16 : centerX < 0.0f ? 2 : 4 : sqrt >= width ? 1 : 32;
        } else {
            Object obj2 = (f2 < ((float) e.top) - 20.0f || f2 >= ((float) e.bottom) + 20.0f) ? null : 1;
            if (f >= ((float) e.left) - 20.0f && f < ((float) e.right) + 20.0f) {
                obj = 1;
            }
            sqrt = (Math.abs(((float) e.left) - f) >= 20.0f || obj2 == null) ? 1 : 3;
            if (Math.abs(((float) e.right) - f) < 20.0f && obj2 != null) {
                sqrt |= 4;
            }
            if (Math.abs(((float) e.top) - f2) < 20.0f && obj != null) {
                sqrt |= 8;
            }
            int i = (Math.abs(((float) e.bottom) - f2) >= 20.0f || obj == null) ? sqrt : sqrt | 16;
            return (i == 1 && e.contains((int) f, (int) f2)) ? 32 : i;
        }
    }

    void m2768a(int i, float f, float f2) {
        Rect e = m2766e();
        if (i != 1) {
            if (i == 32) {
                m2775b((this.f2334e.width() / ((float) e.width())) * f, (this.f2334e.height() / ((float) e.height())) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m2778c((f * (this.f2334e.width() / ((float) e.width()))) * ((float) ((i & 2) != 0 ? -1 : 1)), ((float) ((i & 8) != 0 ? -1 : 1)) * (f2 * (this.f2334e.height() / ((float) e.height()))));
        }
    }

    protected void m2769a(Canvas canvas) {
        if (!this.f2332c) {
            canvas.save();
            Path path = new Path();
            if (m2773a()) {
                Rect rect = new Rect();
                this.f2330a.getDrawingRect(rect);
                if (this.f2340k) {
                    float width = (float) this.f2333d.width();
                    path.addCircle(((float) this.f2333d.left) + (width / 2.0f), (((float) this.f2333d.height()) / 2.0f) + ((float) this.f2333d.top), width / 2.0f, Direction.CW);
                    this.f2346q.setColor(-1112874);
                } else {
                    path.addRect(new RectF(this.f2333d), Direction.CW);
                    this.f2346q.setColor(-30208);
                }
                canvas.clipPath(path, Op.DIFFERENCE);
                canvas.drawRect(rect, m2773a() ? this.f2344o : this.f2345p);
                canvas.restore();
                canvas.drawPath(path, this.f2346q);
                if (this.f2336g != C1190a.Grow) {
                    return;
                }
                int round;
                int width2;
                int height;
                if (this.f2340k) {
                    round = (int) Math.round(Math.cos(0.7853981633974483d) * (((double) this.f2333d.width()) / 2.0d));
                    width2 = ((this.f2333d.left + (this.f2333d.width() / 2)) + round) - (this.f2343n.getIntrinsicWidth() / 2);
                    height = ((this.f2333d.top + (this.f2333d.height() / 2)) - round) - (this.f2343n.getIntrinsicHeight() / 2);
                    this.f2343n.setBounds(width2, height, this.f2343n.getIntrinsicWidth() + width2, this.f2343n.getIntrinsicHeight() + height);
                    this.f2343n.draw(canvas);
                    return;
                }
                width2 = this.f2333d.left + 1;
                height = this.f2333d.right + 1;
                round = this.f2333d.top + 4;
                int i = this.f2333d.bottom + 3;
                int intrinsicWidth = this.f2341l.getIntrinsicWidth() / 2;
                int intrinsicHeight = this.f2341l.getIntrinsicHeight() / 2;
                int intrinsicHeight2 = this.f2342m.getIntrinsicHeight() / 2;
                int intrinsicWidth2 = this.f2342m.getIntrinsicWidth() / 2;
                int i2 = this.f2333d.left + ((this.f2333d.right - this.f2333d.left) / 2);
                int i3 = this.f2333d.top + ((this.f2333d.bottom - this.f2333d.top) / 2);
                this.f2341l.setBounds(width2 - intrinsicWidth, i3 - intrinsicHeight, width2 + intrinsicWidth, i3 + intrinsicHeight);
                this.f2341l.draw(canvas);
                this.f2341l.setBounds(height - intrinsicWidth, i3 - intrinsicHeight, height + intrinsicWidth, i3 + intrinsicHeight);
                this.f2341l.draw(canvas);
                this.f2342m.setBounds(i2 - intrinsicWidth2, round - intrinsicHeight2, i2 + intrinsicWidth2, round + intrinsicHeight2);
                this.f2342m.draw(canvas);
                this.f2342m.setBounds(i2 - intrinsicWidth2, i - intrinsicHeight2, i2 + intrinsicWidth2, i + intrinsicHeight2);
                this.f2342m.draw(canvas);
                return;
            }
            this.f2346q.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(this.f2333d, this.f2346q);
        }
    }

    public void m2770a(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f2335f = new Matrix(matrix);
        this.f2334e = rectF;
        this.f2337h = new RectF(rect);
        this.f2338i = z2;
        this.f2340k = z;
        this.f2339j = this.f2334e.width() / this.f2334e.height();
        this.f2333d = m2766e();
        this.f2344o.setARGB(125, 50, 50, 50);
        this.f2345p.setARGB(125, 50, 50, 50);
        this.f2346q.setStrokeWidth(3.0f);
        this.f2346q.setStyle(Style.STROKE);
        this.f2346q.setAntiAlias(true);
        this.f2336g = C1190a.None;
        m2765d();
    }

    public void m2771a(C1190a c1190a) {
        if (c1190a != this.f2336g) {
            this.f2336g = c1190a;
            this.f2330a.invalidate();
        }
    }

    public void m2772a(boolean z) {
        this.f2331b = z;
    }

    public boolean m2773a() {
        return this.f2331b;
    }

    public Rect m2774b() {
        return new Rect((int) this.f2334e.left, (int) this.f2334e.top, (int) this.f2334e.right, (int) this.f2334e.bottom);
    }

    void m2775b(float f, float f2) {
        Rect rect = new Rect(this.f2333d);
        this.f2334e.offset(f, f2);
        this.f2334e.offset(Math.max(0.0f, this.f2337h.left - this.f2334e.left), Math.max(0.0f, this.f2337h.top - this.f2334e.top));
        this.f2334e.offset(Math.min(0.0f, this.f2337h.right - this.f2334e.right), Math.min(0.0f, this.f2337h.bottom - this.f2334e.bottom));
        this.f2333d = m2766e();
        rect.union(this.f2333d);
        rect.inset(-10, -10);
        this.f2330a.invalidate(rect);
    }

    public void m2776b(boolean z) {
        this.f2332c = z;
    }

    public void m2777c() {
        this.f2333d = m2766e();
    }

    void m2778c(float f, float f2) {
        float f3;
        float f4;
        if (this.f2338i) {
            if (f != 0.0f) {
                f2 = f / this.f2339j;
            } else if (f2 != 0.0f) {
                f = f2 * this.f2339j;
            }
        }
        RectF rectF = new RectF(this.f2334e);
        if (f > 0.0f && rectF.width() + (2.0f * f) > this.f2337h.width()) {
            f = (this.f2337h.width() - rectF.width()) / 2.0f;
            if (this.f2338i) {
                f3 = f / this.f2339j;
                f4 = f;
                if (f3 > 0.0f && rectF.height() + (2.0f * f3) > this.f2337h.height()) {
                    f3 = (this.f2337h.height() - rectF.height()) / 2.0f;
                    if (this.f2338i) {
                        f4 = this.f2339j * f3;
                    }
                }
                rectF.inset(-f4, -f3);
                if (rectF.width() < 25.0f) {
                    rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
                }
                f3 = this.f2338i ? 25.0f / this.f2339j : 25.0f;
                if (rectF.height() < f3) {
                    rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
                }
                if (rectF.left < this.f2337h.left) {
                    rectF.offset(this.f2337h.left - rectF.left, 0.0f);
                } else if (rectF.right > this.f2337h.right) {
                    rectF.offset(-(rectF.right - this.f2337h.right), 0.0f);
                }
                if (rectF.top < this.f2337h.top) {
                    rectF.offset(0.0f, this.f2337h.top - rectF.top);
                } else if (rectF.bottom > this.f2337h.bottom) {
                    rectF.offset(0.0f, -(rectF.bottom - this.f2337h.bottom));
                }
                this.f2334e.set(rectF);
                this.f2333d = m2766e();
                this.f2330a.invalidate();
            }
        }
        f3 = f2;
        f4 = f;
        f3 = (this.f2337h.height() - rectF.height()) / 2.0f;
        if (this.f2338i) {
            f4 = this.f2339j * f3;
        }
        rectF.inset(-f4, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.f2338i) {
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.f2337h.left) {
            rectF.offset(this.f2337h.left - rectF.left, 0.0f);
        } else if (rectF.right > this.f2337h.right) {
            rectF.offset(-(rectF.right - this.f2337h.right), 0.0f);
        }
        if (rectF.top < this.f2337h.top) {
            rectF.offset(0.0f, this.f2337h.top - rectF.top);
        } else if (rectF.bottom > this.f2337h.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.f2337h.bottom));
        }
        this.f2334e.set(rectF);
        this.f2333d = m2766e();
        this.f2330a.invalidate();
    }
}
