package com.domobile.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p015b.C1168b.C1158b;

public class ViewPagerTabs extends HorizontalScrollView implements OnPageChangeListener {
    private static final int[] f3106i = new int[]{16842901, 16842903, 16842904, 16843660};
    ViewPager f3107a;
    final int f3108b;
    final ColorStateList f3109c;
    final int f3110d;
    final boolean f3111e;
    int f3112f;
    int f3113g;
    private C1410b f3114h;

    private class C1409a implements OnLongClickListener {
        final int f3104a;
        final /* synthetic */ ViewPagerTabs f3105b;

        public C1409a(ViewPagerTabs viewPagerTabs, int i) {
            this.f3105b = viewPagerTabs;
            this.f3104a = i;
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            this.f3105b.getLocationOnScreen(iArr);
            Context context = this.f3105b.getContext();
            int width = this.f3105b.getWidth();
            int height = this.f3105b.getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f3105b.f3107a.getAdapter().getPageTitle(this.f3104a), 0);
            makeText.setGravity(49, ((width / 2) + iArr[0]) - (i / 2), iArr[1] + height);
            makeText.show();
            return true;
        }
    }

    public ViewPagerTabs(Context context) {
        this(context, null);
    }

    public ViewPagerTabs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerTabs(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3112f = -1;
        setFillViewport(true);
        this.f3113g = (int) (getResources().getDisplayMetrics().density * 10.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3106i);
        this.f3110d = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3108b = obtainStyledAttributes.getInt(1, 0);
        this.f3109c = obtainStyledAttributes.getColorStateList(2);
        this.f3111e = obtainStyledAttributes.getBoolean(3, false);
        this.f3114h = new C1410b(context);
        C1148d.m2514a(this.f3114h, getBackground());
        addView(this.f3114h, new LayoutParams(-2, -1));
        obtainStyledAttributes.recycle();
    }

    private int m3573a(int i) {
        return (C1148d.O < 17 || getLayoutDirection() != 1) ? i : (this.f3114h.getChildCount() - 1) - i;
    }

    private void m3575a(PagerAdapter pagerAdapter) {
        this.f3114h.removeAllViews();
        int count = pagerAdapter.getCount();
        for (int i = 0; i < count; i++) {
            m3576a(pagerAdapter.getPageTitle(i), i);
        }
    }

    private void m3576a(CharSequence charSequence, final int i) {
        View textView = new TextView(getContext());
        textView.setText(charSequence.toString().toUpperCase());
        textView.setBackgroundResource(C1148d.m2531g(getContext(), C1158b.selectableItemBackground).resourceId);
        textView.setGravity(17);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ViewPagerTabs f3103b;

            public void onClick(View view) {
                this.f3103b.f3107a.setCurrentItem(this.f3103b.m3573a(i));
            }
        });
        textView.setOnLongClickListener(new C1409a(this, i));
        if (this.f3108b > 0) {
            textView.setTypeface(textView.getTypeface(), this.f3108b);
        }
        if (this.f3110d > 0) {
            textView.setTextSize(0, (float) this.f3110d);
        }
        if (this.f3109c != null) {
            textView.setTextColor(this.f3109c);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(this.f3111e);
        }
        textView.setPadding(this.f3113g, 0, this.f3113g, 0);
        this.f3114h.addView(textView, new LinearLayout.LayoutParams(-2, -1, 1.0f));
        if (i == 0) {
            this.f3112f = 0;
            textView.setSelected(true);
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        int a = m3573a(i);
        int childCount = this.f3114h.getChildCount();
        if (childCount != 0 && a >= 0 && a < childCount) {
            this.f3114h.m3578a(a, f, i2);
        }
    }

    public void onPageSelected(int i) {
        int a = m3573a(i);
        if (this.f3112f >= 0) {
            this.f3114h.getChildAt(this.f3112f).setSelected(false);
        }
        View childAt = this.f3114h.getChildAt(a);
        childAt.setSelected(true);
        smoothScrollTo(childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2), 0);
        this.f3112f = a;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f3107a = viewPager;
        m3575a(this.f3107a.getAdapter());
    }
}
