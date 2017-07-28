package com.domobile.widget.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class HorzRecyclerView extends RecyclerView {
    private int f3119a;
    private int f3120b;
    private int f3121c;

    public HorzRecyclerView(Context context) {
        super(context);
        m3579a(context);
    }

    public HorzRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3579a(context);
    }

    public HorzRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3579a(context);
    }

    private void m3579a(Context context) {
        this.f3119a = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.f3120b = (int) (motionEvent.getX() + 0.5f);
                this.f3121c = (int) (motionEvent.getY() + 0.5f);
                break;
            case 2:
                int y = (int) (motionEvent.getY() + 0.5f);
                int abs = Math.abs(((int) (motionEvent.getX() + 0.5f)) - this.f3120b);
                Math.abs(y - this.f3121c);
                if (Math.abs(abs) > this.f3119a) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return onTouchEvent;
    }
}
