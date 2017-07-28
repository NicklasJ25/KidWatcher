package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class C1869d extends RecyclerView implements OnTouchListener {
    protected int f4720a = 0;
    protected int f4721b;
    private int f4722c = 0;
    private boolean f4723d = true;
    private boolean f4724e = false;
    private LinearLayoutManager f4725f;
    private C1870a f4726g;

    public interface C1870a {
        int mo2837a(int i);
    }

    public C1869d(Context context) {
        super(context);
        m5279a(context);
    }

    private int mo2837a(int i) {
        int i2 = this.f4722c - i;
        int a = this.f4726g.mo2837a(i2);
        return i2 > this.f4721b ? m5278a(this.f4720a, a) : i2 < (-this.f4721b) ? m5280b(this.f4720a, a) : this.f4720a;
    }

    private int m5278a(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    private void m5279a(Context context) {
        setOnTouchListener(this);
        this.f4721b = ((int) context.getResources().getDisplayMetrics().density) * 10;
    }

    private int m5280b(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int getItemCount() {
        return getAdapter() == null ? 0 : getAdapter().getItemCount();
    }

    protected void mo2838a(int i, boolean z) {
        if (getAdapter() != null) {
            this.f4720a = i;
            if (z) {
                smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public int getCurrentPosition() {
        return this.f4720a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.f4724e) {
                mo2838a(mo2837a(rawX), true);
            }
            this.f4723d = true;
            this.f4724e = false;
            return true;
        } else if (actionMasked != 0 && actionMasked != 5 && (!this.f4723d || actionMasked != 2)) {
            return false;
        } else {
            this.f4722c = rawX;
            if (this.f4723d) {
                this.f4723d = false;
            }
            this.f4724e = true;
            return false;
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            super.setLayoutManager(layoutManager);
            this.f4725f = (LinearLayoutManager) layoutManager;
            return;
        }
        throw new IllegalArgumentException("SnapRecyclerView only supports LinearLayoutManager");
    }

    public void setSnapDelegate(C1870a c1870a) {
        this.f4726g = c1870a;
    }
}
