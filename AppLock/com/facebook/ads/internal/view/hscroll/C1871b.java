package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View.MeasureSpec;
import com.facebook.ads.internal.view.hscroll.C1869d.C1870a;

public class C1871b extends C1869d implements C1870a {
    private HScrollLinearLayoutManager f4727c;
    private C1868a f4728d;
    private int f4729e = -1;
    private int f4730f = -1;
    private int f4731g = 0;
    private int f4732h = 0;

    public interface C1868a {
        void m5276a(int i, int i2);
    }

    public C1871b(Context context) {
        super(context);
        m5283a();
    }

    private void m5283a() {
        this.f4727c = new HScrollLinearLayoutManager(getContext(), new C1872c(), new C1867a());
        this.f4727c.setOrientation(0);
        setLayoutManager(this.f4727c);
        setSnapDelegate(this);
    }

    private void m5284a(int i, int i2) {
        if (i != this.f4729e || i2 != this.f4730f) {
            this.f4729e = i;
            this.f4730f = i2;
            if (this.f4728d != null) {
                this.f4728d.m5276a(this.f4729e, this.f4730f);
            }
        }
    }

    private int m5285b(int i) {
        int i2 = this.f4732h * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i2;
        int itemCount = getAdapter().getItemCount();
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i4 > i) {
            i3++;
            if (i3 >= itemCount) {
                return i;
            }
            i4 = (int) (((float) (measuredWidth - (i3 * i2))) / (((float) i3) + 0.333f));
        }
        return i4;
    }

    public int mo2837a(int i) {
        int abs = Math.abs(i);
        return abs <= this.b ? 0 : this.f4731g == 0 ? 1 : (abs / this.f4731g) + 1;
    }

    protected void mo2838a(int i, boolean z) {
        super.mo2838a(i, z);
        m5284a(i, 0);
    }

    public int getChildSpacing() {
        return this.f4732h;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int round = Math.round(((float) getMeasuredWidth()) / 1.91f);
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                round = Math.min(MeasureSpec.getSize(i2), round);
                break;
            case 1073741824:
                round = MeasureSpec.getSize(i2);
                break;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        round = m5285b(round - paddingTop);
        setMeasuredDimension(getMeasuredWidth(), paddingTop + round);
        setChildWidth(round + (this.f4732h * 2));
    }

    public void setAdapter(Adapter adapter) {
        this.f4727c.m5271a(adapter == null ? -1 : adapter.hashCode());
        super.setAdapter(adapter);
    }

    public void setChildSpacing(int i) {
        this.f4732h = i;
    }

    public void setChildWidth(int i) {
        this.f4731g = i;
        int measuredWidth = getMeasuredWidth();
        this.f4727c.m5272b((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.f4731g) / 2);
        this.f4727c.m5270a(((double) this.f4731g) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i) {
        mo2838a(i, false);
    }

    public void setOnPageChangedListener(C1868a c1868a) {
        this.f4728d = c1868a;
    }
}
