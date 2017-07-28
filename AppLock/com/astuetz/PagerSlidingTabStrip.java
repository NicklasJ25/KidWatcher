package com.astuetz;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] f310b = new int[]{16842901, 16842904};
    private int f311A;
    private int f312B;
    private Locale f313C;
    public OnPageChangeListener f314a;
    private LayoutParams f315c;
    private LayoutParams f316d;
    private final C0560b f317e;
    private LinearLayout f318f;
    private ViewPager f319g;
    private int f320h;
    private int f321i;
    private float f322j;
    private Paint f323k;
    private Paint f324l;
    private int f325m;
    private int f326n;
    private int f327o;
    private boolean f328p;
    private boolean f329q;
    private int f330r;
    private int f331s;
    private int f332t;
    private int f333u;
    private int f334v;
    private int f335w;
    private int f336x;
    private Typeface f337y;
    private int f338z;

    class C05561 implements OnGlobalLayoutListener {
        final /* synthetic */ PagerSlidingTabStrip f305a;

        C05561(PagerSlidingTabStrip pagerSlidingTabStrip) {
            this.f305a = pagerSlidingTabStrip;
        }

        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            if (VERSION.SDK_INT < 16) {
                this.f305a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.f305a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            this.f305a.f321i = this.f305a.f319g.getCurrentItem();
            this.f305a.m485b(this.f305a.f321i, 0);
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C05581();
        int f308a;

        static class C05581 implements Creator<SavedState> {
            C05581() {
            }

            public SavedState m473a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m474a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m473a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m474a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f308a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f308a);
        }
    }

    public interface C0559a {
        int m475a(int i);
    }

    private class C0560b implements OnPageChangeListener {
        final /* synthetic */ PagerSlidingTabStrip f309a;

        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                this.f309a.m485b(this.f309a.f319g.getCurrentItem(), 0);
            }
            if (this.f309a.f314a != null) {
                this.f309a.f314a.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            this.f309a.f321i = i;
            this.f309a.f322j = f;
            this.f309a.m485b(i, (int) (((float) this.f309a.f318f.getChildAt(i).getWidth()) * f));
            this.f309a.invalidate();
            if (this.f309a.f314a != null) {
                this.f309a.f314a.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            if (this.f309a.f314a != null) {
                this.f309a.f314a.onPageSelected(i);
            }
        }
    }

    private void m479a(int i, int i2) {
        View imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        m480a(i, imageButton);
    }

    private void m480a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagerSlidingTabStrip f307b;

            public void onClick(View view) {
                this.f307b.f319g.setCurrentItem(i);
            }
        });
        view.setPadding(this.f334v, 0, this.f334v, 0);
        this.f318f.addView(view, i, this.f328p ? this.f316d : this.f315c);
    }

    private void m481a(int i, String str) {
        View textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        m480a(i, textView);
    }

    private void m484b() {
        for (int i = 0; i < this.f320h; i++) {
            View childAt = this.f318f.getChildAt(i);
            childAt.setBackgroundResource(this.f312B);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.f335w);
                textView.setTypeface(this.f337y, this.f338z);
                textView.setTextColor(this.f336x);
                if (this.f329q) {
                    if (VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.f313C));
                    }
                }
            }
        }
    }

    private void m485b(int i, int i2) {
        if (this.f320h != 0) {
            int left = this.f318f.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.f330r;
            }
            if (left != this.f311A) {
                this.f311A = left;
                scrollTo(left, 0);
            }
        }
    }

    public void m487a() {
        this.f318f.removeAllViews();
        this.f320h = this.f319g.getAdapter().getCount();
        for (int i = 0; i < this.f320h; i++) {
            if (this.f319g.getAdapter() instanceof C0559a) {
                m479a(i, ((C0559a) this.f319g.getAdapter()).m475a(i));
            } else {
                m481a(i, this.f319g.getAdapter().getPageTitle(i).toString());
            }
        }
        m484b();
        getViewTreeObserver().addOnGlobalLayoutListener(new C05561(this));
    }

    public int getDividerColor() {
        return this.f327o;
    }

    public int getDividerPadding() {
        return this.f333u;
    }

    public int getIndicatorColor() {
        return this.f325m;
    }

    public int getIndicatorHeight() {
        return this.f331s;
    }

    public int getScrollOffset() {
        return this.f330r;
    }

    public boolean getShouldExpand() {
        return this.f328p;
    }

    public int getTabBackground() {
        return this.f312B;
    }

    public int getTabPaddingLeftRight() {
        return this.f334v;
    }

    public int getTextColor() {
        return this.f336x;
    }

    public int getTextSize() {
        return this.f335w;
    }

    public int getUnderlineColor() {
        return this.f326n;
    }

    public int getUnderlineHeight() {
        return this.f332t;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f320h != 0) {
            int height = getHeight();
            this.f323k.setColor(this.f325m);
            View childAt = this.f318f.getChildAt(this.f321i);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.f322j > 0.0f && this.f321i < this.f320h - 1) {
                childAt = this.f318f.getChildAt(this.f321i + 1);
                float left2 = (float) childAt.getLeft();
                left = (left * (1.0f - this.f322j)) + (left2 * this.f322j);
                right = (((float) childAt.getRight()) * this.f322j) + ((1.0f - this.f322j) * right);
            }
            canvas.drawRect(left, (float) (height - this.f331s), right, (float) height, this.f323k);
            this.f323k.setColor(this.f326n);
            canvas.drawRect(0.0f, (float) (height - this.f332t), (float) this.f318f.getWidth(), (float) height, this.f323k);
            this.f324l.setColor(this.f327o);
            for (int i = 0; i < this.f320h - 1; i++) {
                childAt = this.f318f.getChildAt(i);
                canvas.drawLine((float) childAt.getRight(), (float) this.f333u, (float) childAt.getRight(), (float) (height - this.f333u), this.f324l);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f321i = savedState.f308a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f308a = this.f321i;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        this.f329q = z;
    }

    public void setDividerColor(int i) {
        this.f327o = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.f327o = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.f333u = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.f325m = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.f325m = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.f331s = i;
        invalidate();
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f314a = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        this.f330r = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.f328p = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.f312B = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.f334v = i;
        m484b();
    }

    public void setTextColor(int i) {
        this.f336x = i;
        m484b();
    }

    public void setTextColorResource(int i) {
        this.f336x = getResources().getColor(i);
        m484b();
    }

    public void setTextSize(int i) {
        this.f335w = i;
        m484b();
    }

    public void setUnderlineColor(int i) {
        this.f326n = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.f326n = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.f332t = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f319g = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.f317e);
        m487a();
    }
}
