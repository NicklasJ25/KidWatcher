package com.domobile.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class C1411a extends ItemDecoration {
    private int f3122a;
    private int f3123b;
    private boolean f3124c;

    public C1411a(int i) {
        this(i, true);
    }

    public C1411a(int i, boolean z) {
        this.f3123b = i;
        this.f3124c = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (this.f3122a == 0) {
            this.f3122a = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.f3122a;
        if (this.f3124c) {
            rect.left = this.f3123b - ((this.f3123b * i) / this.f3122a);
            rect.right = ((i + 1) * this.f3123b) / this.f3122a;
            if (childAdapterPosition < this.f3122a) {
                rect.top = this.f3123b;
            }
            rect.bottom = this.f3123b;
            return;
        }
        rect.left = (this.f3123b * i) / this.f3122a;
        rect.right = this.f3123b - (((i + 1) * this.f3123b) / this.f3122a);
        if (childAdapterPosition >= this.f3122a) {
            rect.top = this.f3123b;
        }
    }
}
