package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.p057g.C2163a;
import com.google.android.exoplayer2.p057g.C2167b;
import com.google.android.exoplayer2.p057g.C2196k.C2195a;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements C2195a {
    private final List<C2305a> f6624a;
    private List<C2167b> f6625b;
    private int f6626c;
    private float f6627d;
    private boolean f6628e;
    private C2163a f6629f;
    private float f6630g;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6624a = new ArrayList();
        this.f6626c = 0;
        this.f6627d = 0.0533f;
        this.f6628e = true;
        this.f6629f = C2163a.f6054a;
        this.f6630g = 0.08f;
    }

    private void m7320a(int i, float f) {
        if (this.f6626c != i || this.f6627d != f) {
            this.f6626c = i;
            this.f6627d = f;
            invalidate();
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private C2163a getUserCaptionStyleV19() {
        return C2163a.m6635a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void m7321a(float f, boolean z) {
        m7320a(z ? 1 : 0, f);
    }

    public void mo3120a(List<C2167b> list) {
        setCues(list);
    }

    public void dispatchDraw(Canvas canvas) {
        int size = this.f6625b == null ? 0 : this.f6625b.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            float f;
            if (this.f6626c == 2) {
                f = this.f6627d;
            } else {
                f = this.f6627d * ((float) (this.f6626c == 0 ? paddingBottom - paddingTop : bottom - top));
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    ((C2305a) this.f6624a.get(i)).m7325a((C2167b) this.f6625b.get(i), this.f6628e, this.f6629f, f, this.f6630g, canvas, left, paddingTop, right, paddingBottom);
                }
            }
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.f6628e != z) {
            this.f6628e = z;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.f6630g != f) {
            this.f6630g = f;
            invalidate();
        }
    }

    public void setCues(List<C2167b> list) {
        if (this.f6625b != list) {
            this.f6625b = list;
            int size = list == null ? 0 : list.size();
            while (this.f6624a.size() < size) {
                this.f6624a.add(new C2305a(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float f) {
        m7321a(f, false);
    }

    public void setStyle(C2163a c2163a) {
        if (this.f6629f != c2163a) {
            this.f6629f = c2163a;
            invalidate();
        }
    }
}
