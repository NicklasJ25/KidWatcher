package com.domobile.widget.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.domobile.applock.R;

public class C1412b extends ItemDecoration {
    private int f3125a;
    private int f3126b;
    private Paint f3127c;
    private int f3128d = 1;

    public C1412b(Context context) {
        this.f3125a = context.getResources().getDimensionPixelSize(R.dimen.std_divider_size_dp);
        this.f3127c = new Paint(1);
        this.f3127c.setAntiAlias(true);
        this.f3127c.setColor(ContextCompat.getColor(context, R.color.divider_gray_std));
        this.f3127c.setStyle(Style.FILL);
    }

    private void m3580a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int bottom = layoutParams.bottomMargin + childAt.getBottom();
            int i2 = bottom + this.f3125a;
            canvas.drawRect((float) (this.f3126b + paddingLeft), (float) bottom, (float) measuredWidth, (float) i2, this.f3127c);
        }
    }

    private boolean m3581a(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() + -1;
    }

    private void m3582b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int right = layoutParams.rightMargin + childAt.getRight();
            int i2 = right + this.f3125a;
            canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, this.f3127c);
        }
    }

    public void m3583a(int i) {
        this.f3126b = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.f3128d != 1) {
            rect.set(0, 0, this.f3125a, 0);
        } else if (m3581a(view, recyclerView)) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, 0, this.f3125a);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f3128d == 1) {
            m3580a(canvas, recyclerView);
        } else {
            m3582b(canvas, recyclerView);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDrawOver(canvas, recyclerView, state);
    }
}
