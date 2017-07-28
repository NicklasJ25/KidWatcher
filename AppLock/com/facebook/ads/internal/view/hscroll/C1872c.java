package com.facebook.ads.internal.view.hscroll;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.view.View;
import android.view.ViewGroup;

public class C1872c {
    public int[] m5288a(Recycler recycler, int i, int i2, int i3) {
        View viewForPosition = recycler.getViewForPosition(i);
        int[] a = m5289a(viewForPosition, i2, i3);
        recycler.recycleView(viewForPosition);
        return a;
    }

    public int[] m5289a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), layoutParams.height));
        int[] iArr = new int[2];
        iArr[0] = (view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
        iArr[1] = layoutParams.topMargin + (view.getMeasuredHeight() + layoutParams.bottomMargin);
        return iArr;
    }
}
