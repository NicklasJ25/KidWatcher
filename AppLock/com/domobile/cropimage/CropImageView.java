package com.domobile.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.domobile.cropimage.C1171l.C1206a;
import com.domobile.cropimage.C1191e.C1190a;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends C1171l {
    ArrayList<C1191e> f2266a = new ArrayList();
    C1191e f2267b = null;
    float f2268c;
    float f2269d;
    int f2270e;

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m2703a(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.f2266a.size(); i2++) {
            C1191e c1191e = (C1191e) this.f2266a.get(i2);
            c1191e.m2772a(false);
            c1191e.m2777c();
        }
        while (i < this.f2266a.size()) {
            c1191e = (C1191e) this.f2266a.get(i);
            if (c1191e.m2767a(motionEvent.getX(), motionEvent.getY()) != 1) {
                if (!c1191e.m2773a()) {
                    c1191e.m2772a(true);
                    c1191e.m2777c();
                }
                invalidate();
            }
            i++;
        }
        invalidate();
    }

    private void m2704b(C1191e c1191e) {
        Rect rect = c1191e.f2333d;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            m2702b((float) max, (float) max2);
        }
    }

    private void m2705c(C1191e c1191e) {
        Rect rect = c1191e.f2333d;
        float width = (float) getWidth();
        float max = Math.max(1.0f, Math.min((width / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = new float[]{c1191e.f2334e.centerX(), c1191e.f2334e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m2697a(max, fArr[0], fArr[1], 300.0f);
        }
        m2704b(c1191e);
    }

    public /* bridge */ /* synthetic */ void mo2495a() {
        super.mo2495a();
    }

    protected void mo2496a(float f, float f2) {
        super.mo2496a(f, f2);
        for (int i = 0; i < this.f2266a.size(); i++) {
            C1191e c1191e = (C1191e) this.f2266a.get(i);
            c1191e.f2335f.postTranslate(f, f2);
            c1191e.m2777c();
        }
    }

    protected void mo2497a(float f, float f2, float f3) {
        super.mo2497a(f, f2, f3);
        Iterator it = this.f2266a.iterator();
        while (it.hasNext()) {
            C1191e c1191e = (C1191e) it.next();
            c1191e.f2335f.set(getImageMatrix());
            c1191e.m2777c();
        }
    }

    public void m2710a(C1191e c1191e) {
        this.f2266a.add(c1191e);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f2266a.size(); i++) {
            ((C1191e) this.f2266a.get(i)).m2769a(canvas);
        }
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h.m2827b() != null) {
            Iterator it = this.f2266a.iterator();
            while (it.hasNext()) {
                C1191e c1191e = (C1191e) it.next();
                c1191e.f2335f.set(getImageMatrix());
                c1191e.m2777c();
                if (c1191e.f2331b) {
                    m2705c(c1191e);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0591d c0591d = (C0591d) getContext();
        if (c0591d.f455b) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (!c0591d.f454a) {
                    for (int i = 0; i < this.f2266a.size(); i++) {
                        C1191e c1191e = (C1191e) this.f2266a.get(i);
                        int a = c1191e.m2767a(motionEvent.getX(), motionEvent.getY());
                        if (a != 1) {
                            this.f2270e = a;
                            this.f2267b = c1191e;
                            this.f2268c = motionEvent.getX();
                            this.f2269d = motionEvent.getY();
                            this.f2267b.m2771a(a == 32 ? C1190a.Move : C1190a.Grow);
                            break;
                        }
                    }
                    break;
                }
                m2703a(motionEvent);
                break;
            case 1:
                if (c0591d.f454a) {
                    for (int i2 = 0; i2 < this.f2266a.size(); i2++) {
                        C1191e c1191e2 = (C1191e) this.f2266a.get(i2);
                        if (c1191e2.m2773a()) {
                            c0591d.f456c = c1191e2;
                            for (int i3 = 0; i3 < this.f2266a.size(); i3++) {
                                if (i3 != i2) {
                                    ((C1191e) this.f2266a.get(i3)).m2776b(true);
                                }
                            }
                            m2705c(c1191e2);
                            ((C0591d) getContext()).f454a = false;
                            return true;
                        }
                    }
                } else if (this.f2267b != null) {
                    m2705c(this.f2267b);
                    this.f2267b.m2771a(C1190a.None);
                }
                this.f2267b = null;
                break;
            case 2:
                if (!c0591d.f454a) {
                    if (this.f2267b != null) {
                        this.f2267b.m2768a(this.f2270e, motionEvent.getX() - this.f2268c, motionEvent.getY() - this.f2269d);
                        this.f2268c = motionEvent.getX();
                        this.f2269d = motionEvent.getY();
                        m2704b(this.f2267b);
                        break;
                    }
                }
                m2703a(motionEvent);
                break;
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                m2700a(true, true);
                break;
            case 2:
                if (getScale() == 1.0f) {
                    m2700a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public /* bridge */ /* synthetic */ void setRecycler(C1206a c1206a) {
        super.setRecycler(c1206a);
    }
}
