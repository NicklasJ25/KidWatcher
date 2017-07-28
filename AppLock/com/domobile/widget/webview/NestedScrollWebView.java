package com.domobile.widget.webview;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.webkit.WebView;

public class NestedScrollWebView extends WebView implements NestedScrollingChild, NestedScrollingParent {
    private final int[] f3293a;
    private final int[] f3294b;
    private int f3295c;
    private NestedScrollingChildHelper f3296d;
    private boolean f3297e;
    private VelocityTracker f3298f;
    private int f3299g;
    private int f3300h;
    private int f3301i;
    private ScrollerCompat f3302j;
    private int f3303k;
    private int f3304l;

    public NestedScrollWebView(Context context) {
        this(context, null);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3293a = new int[2];
        this.f3294b = new int[2];
        this.f3297e = false;
        this.f3300h = -1;
        setOverScrollMode(2);
        m3661a();
        this.f3296d = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    private void m3661a() {
        this.f3302j = ScrollerCompat.create(getContext(), null);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3299g = viewConfiguration.getScaledTouchSlop();
        this.f3303k = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3304l = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m3662a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.f3300h) {
            action = action == 0 ? 1 : 0;
            this.f3295c = (int) motionEvent.getY(action);
            this.f3300h = motionEvent.getPointerId(action);
            if (this.f3298f != null) {
                this.f3298f.clear();
            }
        }
    }

    private void m3663b() {
        this.f3297e = false;
        m3667e();
        stopNestedScroll();
    }

    private void m3664b(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m3668a(i);
            }
        }
    }

    private void m3665c() {
        if (this.f3298f == null) {
            this.f3298f = VelocityTracker.obtain();
        } else {
            this.f3298f.clear();
        }
    }

    private void m3666d() {
        if (this.f3298f == null) {
            this.f3298f = VelocityTracker.obtain();
        }
    }

    private void m3667e() {
        if (this.f3298f != null) {
            this.f3298f.recycle();
            this.f3298f = null;
        }
    }

    public void m3668a(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f3302j.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3296d.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3296d.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f3296d.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3296d.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public int getNestedScrollAxes() {
        return 0;
    }

    int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public boolean hasNestedScrollingParent() {
        return this.f3296d.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f3296d.isNestedScrollingEnabled();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f3297e) {
            return true;
        }
        switch (action & 255) {
            case 0:
                this.f3295c = (int) motionEvent.getY();
                this.f3300h = motionEvent.getPointerId(0);
                m3665c();
                this.f3298f.addMovement(motionEvent);
                this.f3302j.computeScrollOffset();
                if (!this.f3302j.isFinished()) {
                    z = true;
                }
                this.f3297e = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f3297e = false;
                this.f3300h = -1;
                m3667e();
                if (this.f3302j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f3300h;
                if (action != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(action);
                    if (findPointerIndex != -1) {
                        action = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(action - this.f3295c) > this.f3299g && (getNestedScrollAxes() & 2) == 0) {
                            this.f3297e = true;
                            this.f3295c = action;
                            m3666d();
                            this.f3298f.addMovement(motionEvent);
                            this.f3301i = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedWebView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m3662a(motionEvent);
                break;
        }
        return this.f3297e;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m3666d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f3301i = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f3301i);
        switch (actionMasked) {
            case 0:
                boolean z = !this.f3302j.isFinished();
                this.f3297e = z;
                if (z) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (!this.f3302j.isFinished()) {
                    this.f3302j.abortAnimation();
                }
                this.f3295c = (int) motionEvent.getY();
                this.f3300h = motionEvent.getPointerId(0);
                startNestedScroll(2);
                break;
            case 1:
                if (this.f3297e) {
                    VelocityTracker velocityTracker = this.f3298f;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f3304l);
                    actionMasked = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f3300h);
                    if (Math.abs(actionMasked) > this.f3303k) {
                        m3664b(-actionMasked);
                    } else {
                        if (this.f3302j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
                this.f3300h = -1;
                m3663b();
                break;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.f3300h);
                if (actionMasked != -1) {
                    int y = (int) motionEvent.getY(actionMasked);
                    actionMasked = this.f3295c - y;
                    if (dispatchNestedPreScroll(0, actionMasked, this.f3294b, this.f3293a)) {
                        actionMasked -= this.f3294b[1];
                        obtain.offsetLocation(0.0f, (float) this.f3293a[1]);
                        this.f3301i += this.f3293a[1];
                    }
                    if (!this.f3297e && Math.abs(actionMasked) > this.f3299g) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3297e = true;
                        actionMasked = actionMasked > 0 ? actionMasked - this.f3299g : actionMasked + this.f3299g;
                    }
                    if (this.f3297e) {
                        this.f3295c = y - this.f3293a[1];
                        y = getScrollY() - getScrollY();
                        if (dispatchNestedScroll(0, y, 0, actionMasked - y, this.f3293a)) {
                            this.f3295c -= this.f3293a[1];
                            obtain.offsetLocation(0.0f, (float) this.f3293a[1]);
                            this.f3301i += this.f3293a[1];
                            break;
                        }
                    }
                }
                Log.e("NestedWebView", "Invalid pointerId=" + this.f3300h + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f3297e && getChildCount() > 0) {
                    if (this.f3302j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
                this.f3300h = -1;
                m3663b();
                break;
            case 5:
                actionMasked = MotionEventCompat.getActionIndex(motionEvent);
                this.f3295c = (int) motionEvent.getY(actionMasked);
                this.f3300h = motionEvent.getPointerId(actionMasked);
                break;
            case 6:
                m3662a(motionEvent);
                this.f3295c = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3300h));
                break;
        }
        if (this.f3298f != null) {
            this.f3298f.addMovement(obtain);
        }
        obtain.recycle();
        return super.onTouchEvent(motionEvent);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f3296d.setNestedScrollingEnabled(z);
    }

    public boolean startNestedScroll(int i) {
        return this.f3296d.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f3296d.stopNestedScroll();
    }
}
