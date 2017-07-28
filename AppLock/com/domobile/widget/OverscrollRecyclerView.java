package com.domobile.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0419f;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1348d;

@TargetApi(14)
public class OverscrollRecyclerView extends RecyclerView {
    private boolean f3077a;
    private boolean f3078b;
    private C1404b f3079c;
    private C1405c f3080d;
    private int f3081e;
    private int f3082f;
    private float f3083g;

    public static abstract class C0652a<VH extends ViewHolder> extends C0419f<VH> {
        public int m776c() {
            return 0;
        }

        public View m777c(int i) {
            return null;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
        }
    }

    private class C1404b extends RelativeLayout {
        final /* synthetic */ OverscrollRecyclerView f3071a;
        private float f3072b = 0.0f;
        private float f3073c = 0.0f;

        public C1404b(OverscrollRecyclerView overscrollRecyclerView, Context context) {
            this.f3071a = overscrollRecyclerView;
            super(context);
        }

        public boolean m3540a(MotionEvent motionEvent, ViewGroup viewGroup) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int childCount = viewGroup.getChildCount() - 1;
            while (childCount > -1) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3540a(motionEvent, (ViewGroup) childAt);
                }
                if (!childAt.isClickable() || x <= ((float) childAt.getLeft()) || x >= ((float) childAt.getRight()) || y <= ((float) childAt.getTop()) || y >= ((float) childAt.getBottom())) {
                    childCount--;
                } else {
                    childAt.performClick();
                    return true;
                }
            }
            return false;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f3072b = motionEvent.getX();
                    this.f3073c = motionEvent.getY();
                    break;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    x = Math.abs(x - this.f3072b);
                    y = Math.abs(y - this.f3073c);
                    if (x < this.f3071a.f3083g && y < this.f3071a.f3083g) {
                        m3540a(motionEvent, this);
                        break;
                    }
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    public class C1405c extends OnScrollListener {
        protected View f3074a;
        final /* synthetic */ OverscrollRecyclerView f3075b;
        private int f3076c;

        public C1405c(OverscrollRecyclerView overscrollRecyclerView, Context context, View view, int i) {
            this.f3075b = overscrollRecyclerView;
            m3541a(view, i);
        }

        private void m3541a(View view, int i) {
            this.f3076c = i;
            this.f3074a = view;
        }

        public void m3543a() {
            long abs = (long) Math.abs(this.f3074a.getTranslationY());
            if (abs != 0) {
                this.f3074a.animate().translationY(0.0f).setDuration(abs).start();
            }
        }

        public void m3544a(int i, int i2) {
            int translationY = ((int) this.f3074a.getTranslationY()) - i;
            if (translationY > 0) {
                translationY = 0;
            } else if (Math.abs(translationY) > this.f3076c) {
                translationY = -this.f3076c;
            }
            this.f3074a.setTranslationY((float) translationY);
        }

        public void m3545a(RecyclerView recyclerView) {
            this.f3074a.animate().translationY((float) (-this.f3076c)).setDuration((long) (this.f3076c - ((int) Math.abs(this.f3074a.getTranslationY())))).start();
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                float translationY = this.f3074a.getTranslationY();
                if (translationY < 0.0f) {
                    if (Math.abs(translationY) > 0.8f * ((float) this.f3076c)) {
                        m3545a(recyclerView);
                    } else {
                        m3543a();
                    }
                }
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            try {
                m3544a(i2, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public OverscrollRecyclerView(Context context) {
        super(context);
    }

    public OverscrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3083g = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public OverscrollRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3083g = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void m3548b(int i, View view) {
        m3554a((RecyclerView) this, view.getHeight());
        if (!C1147a.f2198Q) {
            return;
        }
        if (this.f3080d == null) {
            this.f3080d = new C1405c(this, getContext(), view, i);
            addOnScrollListener(this.f3080d);
            return;
        }
        this.f3080d.m3541a(view, i);
    }

    private void m3549c() {
        if (this.f3079c == null && C1147a.f2198Q) {
            this.f3079c = new C1404b(this, getContext());
            this.f3079c.setLayoutParams(new LayoutParams(-1, -2));
        }
    }

    private void m3550d() {
        if (this.f3079c != null) {
            int e = m3551e();
            int bottom = getLayoutManager().findViewByPosition(e).getBottom();
            int childCount = this.f3079c.getChildCount();
            for (int i = 1; i < childCount; i++) {
                View childAt = this.f3079c.getChildAt((childCount - i) - 1);
                if (e >= childCount) {
                    childAt.setVisibility(0);
                } else if (i < e) {
                    childAt.setVisibility(0);
                } else {
                    int dimensionPixelSize = ((childCount - i) - 1) * getResources().getDimensionPixelSize(R.dimen.PaddingSizeLarge);
                    if (e != i || this.f3079c.getBottom() - dimensionPixelSize <= bottom) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                    }
                }
            }
        }
    }

    private int m3551e() {
        LayoutManager layoutManager = getLayoutManager();
        return layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() : layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() : layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(null)[0] : -1;
    }

    public void m3552a() {
        if (C1348d.Q && this.f3080d != null) {
            this.f3080d.m3543a();
        }
    }

    public void m3553a(final int i, final View view) {
        m3548b(i, view);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ OverscrollRecyclerView f3070c;

            public void onGlobalLayout() {
                C1148d.m2515a(view.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                this.f3070c.m3548b(i, view);
            }
        });
    }

    public void m3554a(RecyclerView recyclerView, int i) {
        recyclerView.setClipToPadding(!C1147a.f2198Q);
        recyclerView.setPadding(recyclerView.getPaddingLeft(), i, recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        recyclerView.scrollToPosition(0);
    }

    public View m3555b() {
        if (this.f3077a) {
            Adapter adapter = getAdapter();
            if (adapter != null && (adapter instanceof C0652a)) {
                C0652a c0652a = (C0652a) adapter;
                m3549c();
                this.f3079c.removeAllViews();
                int c = c0652a.m776c();
                for (int i = 0; i < c; i++) {
                    View c2 = c0652a.m777c(i);
                    if (c2 != null) {
                        this.f3079c.addView(c2, 0);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2.getLayoutParams();
                        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.PaddingSizeLarge) * i;
                        c2.setLayoutParams(layoutParams);
                    }
                }
            }
        }
        return this.f3079c;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f3079c != null) {
            Adapter adapter = getAdapter();
            if (adapter != null && ((C0652a) adapter).m776c() > 0) {
                Paint paint = new Paint(1);
                paint.setColor(getResources().getColor(R.color.plugins_page_bgcolor));
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), 100.0f, paint);
            }
            drawChild(canvas, this.f3079c, getDrawingTime());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f3079c != null && this.f3079c.getChildCount() > 0) {
            switch (motionEvent.getAction()) {
                case 0:
                case 1:
                case 2:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (x <= ((float) this.f3081e) && y <= ((float) this.f3082f)) {
                        return true;
                    }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3079c != null) {
            this.f3079c.layout(0, 0, this.f3081e, this.f3082f);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3079c != null) {
            measureChild(this.f3079c, i, i2);
            this.f3081e = this.f3079c.getMeasuredWidth();
            this.f3082f = this.f3079c.getMeasuredHeight();
            this.f3079c.layout(0, 0, this.f3081e, this.f3082f);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m3550d();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            requestDisallowInterceptTouchEvent(false);
        }
        if (this.f3079c != null && this.f3079c.getChildCount() > 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x <= ((float) this.f3081e) && y <= ((float) this.f3082f)) {
                this.f3079c.onTouchEvent(motionEvent);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f3078b = z;
    }

    public void setHasPinnedHeader(boolean z) {
        boolean z2 = z && C1147a.f2198Q;
        this.f3077a = z2;
    }
}
