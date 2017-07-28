package com.domobile.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;

public class MyLinearLayoutManager extends NpaLinearLayoutManager {
    public MyLinearLayoutManager(Context context) {
        super(context);
    }

    public MyLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        SmoothScroller c14021 = new C1401a(this, recyclerView.getContext()) {
            final /* synthetic */ MyLinearLayoutManager f3059a;

            public PointF computeScrollVectorForPosition(int i) {
                return this.f3059a.computeScrollVectorForPosition(i);
            }
        };
        c14021.setTargetPosition(i);
        startSmoothScroll(c14021);
    }
}
