package com.domobile.widget;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;

public abstract class C1401a extends LinearSmoothScroller {
    public C1401a(Context context) {
        super(context);
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 0.22f;
    }

    protected int calculateTimeForDeceleration(int i) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(i)) / 0.3356d);
    }
}
