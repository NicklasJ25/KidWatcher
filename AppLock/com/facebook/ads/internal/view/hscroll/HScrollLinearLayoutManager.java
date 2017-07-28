package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class HScrollLinearLayoutManager extends LinearLayoutManager {
    private final C1872c f4711a;
    private final C1867a f4712b;
    private final Context f4713c;
    private int[] f4714d;
    private int f4715e = 0;
    private float f4716f = 50.0f;
    private C1866a f4717g;
    private int f4718h;

    private class C1866a extends LinearSmoothScroller {
        final /* synthetic */ HScrollLinearLayoutManager f4710a;

        public C1866a(HScrollLinearLayoutManager hScrollLinearLayoutManager, Context context) {
            this.f4710a = hScrollLinearLayoutManager;
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (!layoutManager.canScrollHorizontally()) {
                return 0;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i) + this.f4710a.f4715e;
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.f4710a.f4716f / ((float) displayMetrics.densityDpi);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return this.f4710a.computeScrollVectorForPosition(i);
        }

        protected int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public HScrollLinearLayoutManager(Context context, C1872c c1872c, C1867a c1867a) {
        super(context);
        this.f4713c = context;
        this.f4711a = c1872c;
        this.f4712b = c1867a;
        this.f4718h = -1;
        this.f4717g = new C1866a(this, this.f4713c);
    }

    public void m5270a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f4716f = (float) (50.0d / d);
        this.f4717g = new C1866a(this, this.f4713c);
    }

    void m5271a(int i) {
        this.f4718h = i;
    }

    public void m5272b(int i) {
        this.f4715e = i;
    }

    public void onMeasure(Recycler recycler, State state, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(recycler, state, i, i2);
            return;
        }
        int[] a;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f4712b.m5275b(this.f4718h)) {
            a = this.f4712b.m5274a(this.f4718h);
        } else {
            a = new int[]{0, 0};
            if (state.getItemCount() >= 1) {
                for (int i3 = 0; i3 < 1; i3++) {
                    this.f4714d = this.f4711a.m5288a(recycler, i3, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        a[0] = a[0] + this.f4714d[0];
                        if (i3 == 0) {
                            a[1] = (this.f4714d[1] + getPaddingTop()) + getPaddingBottom();
                        }
                    } else {
                        a[1] = a[1] + this.f4714d[1];
                        if (i3 == 0) {
                            a[0] = (this.f4714d[0] + getPaddingLeft()) + getPaddingRight();
                        }
                    }
                }
                if (this.f4718h != -1) {
                    this.f4712b.m5273a(this.f4718h, a);
                }
            }
        }
        if (mode == 1073741824) {
            a[0] = size;
        }
        if (mode2 == 1073741824) {
            a[1] = size2;
        }
        setMeasuredDimension(a[0], a[1]);
    }

    public void scrollToPosition(int i) {
        super.scrollToPositionWithOffset(i, this.f4715e);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        this.f4717g.setTargetPosition(i);
        startSmoothScroll(this.f4717g);
    }
}
