package com.domobile.eframe.widget.pagetabs;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;

public class ViewPagerTabs extends ViewGroup implements OnPageChangeListener {
    private Context f2514a;
    private ViewPager f2515b;
    private int f2516c;
    private int f2517d;
    private boolean f2518e;
    private int f2519f;
    private int f2520g;
    private int f2521h;
    private int f2522i;
    private int f2523j;
    private int f2524k;
    private int f2525l;
    private int f2526m;
    private int f2527n;
    private int f2528o;
    private float f2529p;

    class C12441 implements OnClickListener {
        final /* synthetic */ ViewPagerTabs f2498a;

        C12441(ViewPagerTabs viewPagerTabs) {
            this.f2498a = viewPagerTabs;
        }

        public void onClick(View view) {
            this.f2498a.f2515b.setCurrentItem(((C1247a) view).getIndex());
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C12451();
        int f2499a;
        int f2500b;
        int f2501c;
        int f2502d;
        int f2503e;
        int f2504f;
        int f2505g;
        int f2506h;
        int f2507i;
        int f2508j;
        float f2509k;

        static class C12451 implements Creator<SavedState> {
            C12451() {
            }

            public SavedState m2928a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2929a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2928a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2929a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f2499a = parcel.readInt();
            this.f2500b = parcel.readInt();
            this.f2501c = parcel.readInt();
            this.f2502d = parcel.readInt();
            this.f2503e = parcel.readInt();
            this.f2504f = parcel.readInt();
            this.f2505g = parcel.readInt();
            this.f2506h = parcel.readInt();
            this.f2507i = parcel.readInt();
            this.f2508j = parcel.readInt();
            this.f2509k = parcel.readFloat();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2499a);
            parcel.writeInt(this.f2500b);
            parcel.writeInt(this.f2501c);
            parcel.writeInt(this.f2502d);
            parcel.writeInt(this.f2503e);
            parcel.writeInt(this.f2504f);
            parcel.writeInt(this.f2505g);
            parcel.writeInt(this.f2506h);
            parcel.writeInt(this.f2507i);
            parcel.writeInt(this.f2508j);
            parcel.writeFloat(this.f2509k);
        }
    }

    private enum C1246a {
        Left,
        Right,
        Center
    }

    private int m2930a(C1247a c1247a) {
        return (c1247a.getMeasuredWidth() * -1) - this.f2517d;
    }

    private void m2932a(boolean z) {
        int i;
        C1247a c1247a;
        int i2 = this.f2516c;
        int childCount = getChildCount();
        C1147a.m2481a((Object) "ViewPagerTabs child count: " + childCount);
        for (i = 0; i < i2 - 2; i++) {
            c1247a = (C1247a) getChildAt(i);
            c1247a.f2530a = m2930a(c1247a);
            c1247a.f2531b = c1247a.f2530a;
            c1247a.f2532c = c1247a.f2530a;
        }
        if (i2 > 1) {
            c1247a = (C1247a) getChildAt(i2 - 2);
            c1247a.f2530a = m2930a(c1247a);
            c1247a.f2531b = c1247a.f2530a;
            c1247a.f2532c = m2933b(c1247a);
        }
        if (i2 > 0) {
            c1247a = (C1247a) getChildAt(i2 - 1);
            C1147a.m2481a((Object) "ViewPagerTab is " + c1247a);
            c1247a.f2530a = m2933b(c1247a);
            c1247a.f2531b = m2930a(c1247a);
            c1247a.f2532c = m2935c(c1247a);
        }
        if (childCount > 0) {
            c1247a = (C1247a) getChildAt(i2);
            c1247a.f2530a = m2935c(c1247a);
            c1247a.f2531b = m2933b(c1247a);
            c1247a.f2532c = m2937d(c1247a);
        }
        if (i2 < childCount - 1) {
            c1247a = (C1247a) getChildAt(i2 + 1);
            c1247a.f2530a = m2937d(c1247a);
            c1247a.f2531b = m2935c(c1247a);
            c1247a.f2532c = m2938e(c1247a);
        }
        if (i2 < childCount - 2) {
            c1247a = (C1247a) getChildAt(i2 + 2);
            c1247a.f2530a = m2938e(c1247a);
            c1247a.f2531b = m2937d(c1247a);
            c1247a.f2532c = c1247a.f2530a;
        }
        for (i = i2 + 3; i < childCount; i++) {
            c1247a = (C1247a) getChildAt(i);
            c1247a.f2530a = m2938e(c1247a);
            c1247a.f2531b = c1247a.f2530a;
            c1247a.f2532c = c1247a.f2530a;
        }
        C1247a c1247a2 = i2 > 1 ? (C1247a) getChildAt(i2 - 2) : null;
        C1247a c1247a3 = i2 > 0 ? (C1247a) getChildAt(i2 - 1) : null;
        c1247a = (C1247a) getChildAt(i2);
        C1247a c1247a4 = i2 < getChildCount() + -1 ? (C1247a) getChildAt(i2 + 1) : null;
        C1247a c1247a5 = i2 < getChildCount() + -2 ? (C1247a) getChildAt(i2 + 2) : null;
        if (c1247a2 != null && c1247a2.f2532c + c1247a2.getMeasuredWidth() >= c1247a3.f2532c) {
            c1247a2.f2532c = c1247a3.f2532c - c1247a2.getMeasuredWidth();
        }
        if (c1247a3 != null) {
            if (c1247a3.f2530a + c1247a3.getMeasuredWidth() >= c1247a.f2530a) {
                c1247a3.f2530a = c1247a.f2530a - c1247a3.getMeasuredWidth();
            }
            if (c1247a.f2532c <= c1247a3.f2532c + c1247a3.getMeasuredWidth()) {
                c1247a.f2532c = c1247a3.getMeasuredWidth() + c1247a3.f2532c;
            }
        }
        if (c1247a4 != null) {
            if (c1247a.f2531b + c1247a.getMeasuredWidth() >= c1247a4.f2531b) {
                c1247a.f2531b = c1247a4.f2531b - c1247a.getMeasuredWidth();
            }
            if (c1247a4.f2530a <= c1247a.f2530a + c1247a.getMeasuredWidth()) {
                c1247a4.f2530a = c1247a.getMeasuredWidth() + c1247a.f2530a;
            }
        }
        if (c1247a5 != null && c1247a5.f2531b <= c1247a4.f2531b + c1247a4.getMeasuredWidth()) {
            c1247a5.f2531b = c1247a4.f2531b + c1247a4.getMeasuredWidth();
        }
        if (z) {
            for (i = 0; i < childCount; i++) {
                c1247a = (C1247a) getChildAt(i);
                c1247a.f2533d = c1247a.f2530a;
            }
        }
    }

    private int m2933b(C1247a c1247a) {
        return 0 - c1247a.getPaddingLeft();
    }

    private void m2934b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = getChildAt(i).getLayoutParams();
            getChildAt(i).measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        }
    }

    private int m2935c(C1247a c1247a) {
        return (getMeasuredWidth() / 2) - (c1247a.getMeasuredWidth() / 2);
    }

    private void m2936c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C1247a c1247a = (C1247a) getChildAt(i);
            c1247a.setPadding(this.f2525l, this.f2526m, this.f2527n, (this.f2524k + this.f2528o) - 4);
            c1247a.m2943a(this.f2520g, this.f2521h);
            c1247a.m2944b(this.f2522i, this.f2523j);
            c1247a.setLineHeight(this.f2524k);
            c1247a.setBackgroundColorPressed(this.f2519f);
            c1247a.setTextSize(this.f2529p);
        }
        m2934b();
        m2932a(true);
        requestLayout();
    }

    private int m2937d(C1247a c1247a) {
        return (getMeasuredWidth() - c1247a.getMeasuredWidth()) + c1247a.getPaddingRight();
    }

    private int m2938e(C1247a c1247a) {
        return getMeasuredWidth() + this.f2517d;
    }

    public void m2939a() {
        removeAllViews();
        for (int i = 0; i < this.f2515b.getAdapter().getCount(); i++) {
            m2940a(i, ((C0917b) this.f2515b.getAdapter()).mo2441a(i));
        }
        m2936c();
        m2932a(true);
        requestLayout();
    }

    public void m2940a(int i, String str) {
        View c1247a = new C1247a(this.f2514a);
        c1247a.setText(str);
        c1247a.setIndex(i);
        addView(c1247a);
        c1247a.setOnClickListener(new C12441(this));
    }

    protected float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    public int getPosition() {
        return this.f2516c;
    }

    protected float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredWidth2 = getMeasuredWidth() / 5;
        for (int i5 = 0; i5 < childCount; i5++) {
            C1247a c1247a = (C1247a) getChildAt(i5);
            int abs = Math.abs(measuredWidth - (c1247a.f2533d + (c1247a.getMeasuredWidth() / 2)));
            if (abs <= measuredWidth2) {
                c1247a.setCenterPercent(100 - ((abs * 100) / measuredWidth2));
            } else {
                c1247a.setCenterPercent(0);
            }
            c1247a.layout(c1247a.f2533d, getPaddingTop(), c1247a.f2533d + c1247a.getMeasuredWidth(), getPaddingTop() + c1247a.getMeasuredHeight());
        }
    }

    protected void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            TextView textView = (TextView) childAt;
            LayoutParams layoutParams = textView.getLayoutParams();
            textView.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
            setMeasuredDimension(resolveSize(0, i), resolveSize((textView.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom(), i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize(getPaddingTop() + getPaddingBottom(), i2));
        }
        if (this.f2518e) {
            this.f2518e = false;
            if (this.f2517d < 0) {
                this.f2517d = getMeasuredWidth();
            }
            m2934b();
            m2932a(true);
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        int childCount = getChildCount();
        int width = this.f2516c * (this.f2515b.getWidth() + this.f2515b.getPageMargin());
        C1246a c1246a = C1246a.Center;
        if (this.f2515b.getScrollX() < width) {
            f = 1.0f - f;
            c1246a = C1246a.Left;
        } else if (this.f2515b.getScrollX() > width) {
            c1246a = C1246a.Right;
        } else {
            f = 0.0f;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C1247a c1247a = (C1247a) getChildAt(i3);
            float f2 = (float) c1247a.f2530a;
            float f3 = c1246a == C1246a.Left ? (float) c1247a.f2532c : c1246a == C1246a.Right ? (float) c1247a.f2531b : (float) c1247a.f2530a;
            c1247a.f2533d = (int) (((f3 * f) - (f2 * f)) + f2);
            c1247a.invalidate();
        }
        requestLayout();
    }

    public void onPageSelected(int i) {
        this.f2516c = i;
        m2932a(false);
        requestLayout();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2516c = savedState.f2499a;
        this.f2519f = savedState.f2500b;
        this.f2520g = savedState.f2501c;
        this.f2521h = savedState.f2502d;
        this.f2523j = savedState.f2503e;
        this.f2524k = savedState.f2504f;
        this.f2525l = savedState.f2505g;
        this.f2526m = savedState.f2506h;
        this.f2527n = savedState.f2507i;
        this.f2528o = savedState.f2508j;
        this.f2529p = savedState.f2509k;
        C1147a.m2481a((Object) "onRestoreInstanceState mPosition:" + this.f2516c);
        C1147a.m2481a((Object) "ViewPagerTabs child count: " + getChildCount());
        this.f2516c = 0;
        m2936c();
    }

    public Parcelable onSaveInstanceState() {
        C1147a.m2481a((Object) "onSaveInstanceState mPosition:" + this.f2516c);
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2499a = this.f2516c;
        savedState.f2500b = this.f2519f;
        savedState.f2501c = this.f2520g;
        savedState.f2502d = this.f2521h;
        savedState.f2503e = this.f2523j;
        savedState.f2504f = this.f2524k;
        savedState.f2505g = this.f2525l;
        savedState.f2506h = this.f2526m;
        savedState.f2507i = this.f2527n;
        savedState.f2508j = this.f2528o;
        savedState.f2509k = this.f2529p;
        return savedState;
    }

    public void setBackgroundColorPressed(int i) {
        this.f2519f = i;
        m2936c();
    }

    public void setLineColorCenter(int i) {
        this.f2523j = i;
        m2936c();
    }

    public void setLineHeight(int i) {
        this.f2524k = i;
        m2936c();
    }

    public void setOutsideOffset(int i) {
        this.f2517d = i;
        m2936c();
    }

    public void setTabPaddingBottom(int i) {
        this.f2528o = i;
        m2936c();
    }

    public void setTabPaddingLeft(int i) {
        this.f2525l = i;
        m2936c();
    }

    public void setTabPaddingRight(int i) {
        this.f2527n = i;
        m2936c();
    }

    public void setTabPaddingTop(int i) {
        this.f2526m = i;
        m2936c();
    }

    public void setTextColor(int i) {
        this.f2520g = i;
        m2936c();
    }

    public void setTextColorCenter(int i) {
        this.f2521h = i;
        m2936c();
    }

    public void setTextSize(float f) {
        this.f2529p = f;
        m2936c();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager.getAdapter() instanceof C0917b) {
            this.f2515b = viewPager;
            this.f2515b.setCurrentItem(this.f2516c);
            this.f2515b.setOnPageChangeListener(this);
            m2939a();
            return;
        }
        throw new IllegalStateException("The pager's adapter has to implement ViewPagerTabProvider.");
    }
}
