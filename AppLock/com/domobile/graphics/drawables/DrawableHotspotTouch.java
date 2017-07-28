package com.domobile.graphics.drawables;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public class DrawableHotspotTouch implements OnTouchListener {
    boolean mHasPerformedLongPress;
    LollipopDrawable mHotspotDrawable;
    boolean mInsideScrollContainer;
    CheckForLongPress mPendingCheckForLongPress;
    CheckForTap mPendingCheckForTap;
    PerformClick mPerformClick;
    boolean mPrePressed;
    int mTouchSlop;
    UnsetPressedState mUnsetPressedState;

    private final class CheckForLongPress implements Runnable {
        View target;

        private CheckForLongPress(View view) {
            this.target = view;
        }

        public void run() {
            if (this.target.isPressed() && this.target.getParent() != null) {
                DrawableHotspotTouch.this.mHasPerformedLongPress = true;
            }
        }
    }

    final class CheckForTap implements Runnable {
        View target;
        float f2764x;
        float f2765y;

        CheckForTap(View view) {
            this.target = view;
        }

        public void run() {
            DrawableHotspotTouch.this.mPrePressed = true;
            DrawableHotspotTouch.this.setPressed(this.target, true, this.f2764x, this.f2765y);
            DrawableHotspotTouch.this.checkForLongClick(this.target, ViewConfiguration.getTapTimeout());
        }
    }

    private static final class PerformClick implements Runnable {
        WeakReference<View> target;

        private PerformClick(View view) {
            this.target = new WeakReference(view);
        }

        public void run() {
            if (this.target.get() == null) {
            }
        }
    }

    private final class UnsetPressedState implements Runnable {
        View target;

        private UnsetPressedState(View view) {
            this.target = view;
        }

        public void run() {
            this.target.setPressed(false);
        }
    }

    public DrawableHotspotTouch() {
        this(null);
    }

    public DrawableHotspotTouch(LollipopDrawable lollipopDrawable) {
        this.mHotspotDrawable = lollipopDrawable;
        this.mTouchSlop = -1;
    }

    private void checkForLongClick(View view, int i) {
        if (view.isLongClickable()) {
            this.mHasPerformedLongPress = false;
            if (this.mPendingCheckForLongPress == null) {
                this.mPendingCheckForLongPress = new CheckForLongPress(view);
            }
            view.postDelayed(this.mPendingCheckForLongPress, (long) (ViewConfiguration.getLongPressTimeout() - i));
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.isClickable() || view.isLongClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mHasPerformedLongPress = false;
                    if (!this.mInsideScrollContainer) {
                        setPressed(view, true, x, y);
                        checkForLongClick(view, 0);
                        break;
                    }
                    this.mPrePressed = true;
                    if (this.mPendingCheckForTap == null) {
                        this.mPendingCheckForTap = new CheckForTap(view);
                    }
                    this.mPendingCheckForTap.f2764x = motionEvent.getX();
                    this.mPendingCheckForTap.f2765y = motionEvent.getY();
                    view.postDelayed(this.mPendingCheckForTap, (long) ViewConfiguration.getTapTimeout());
                    break;
                case 1:
                    if (this.mPrePressed || view.isPressed()) {
                        boolean requestFocus = (view.isFocusable() && view.isFocusableInTouchMode() && !view.isFocused()) ? view.requestFocus() : false;
                        if (this.mPrePressed) {
                            setPressed(view, true, x, y);
                        }
                        if (!this.mHasPerformedLongPress) {
                            removeLongPressCallback(view);
                            if (!requestFocus) {
                                if (this.mPerformClick == null) {
                                    this.mPerformClick = new PerformClick(view);
                                }
                                if (!view.post(this.mPerformClick)) {
                                    view.performClick();
                                }
                            }
                        }
                        if (this.mUnsetPressedState == null) {
                            this.mUnsetPressedState = new UnsetPressedState(view);
                        }
                        if (this.mPrePressed) {
                            view.postDelayed(this.mUnsetPressedState, (long) ViewConfiguration.getPressedStateDuration());
                        } else if (!view.post(this.mUnsetPressedState)) {
                            this.mUnsetPressedState.run();
                        }
                        removeTapCallback(view);
                        break;
                    }
                    break;
                case 2:
                    this.mHotspotDrawable.setHotspot(x, y);
                    if (this.mTouchSlop == -1) {
                        this.mTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                    }
                    if (!pointInView(view, x, y, (float) this.mTouchSlop)) {
                        removeTapCallback(view);
                        if (view.isPressed()) {
                            removeLongPressCallback(view);
                            view.setPressed(false);
                            break;
                        }
                    }
                    break;
                case 3:
                    view.setPressed(false);
                    removeTapCallback(view);
                    removeLongPressCallback(view);
                    break;
            }
        }
        return false;
    }

    public boolean pointInView(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    void removeLongPressCallback(View view) {
        if (this.mPendingCheckForLongPress != null) {
            view.removeCallbacks(this.mPendingCheckForLongPress);
        }
    }

    void removeTapCallback(View view) {
        if (this.mPendingCheckForTap != null) {
            view.removeCallbacks(this.mPendingCheckForTap);
        }
    }

    public DrawableHotspotTouch setInsideScrollContainer(boolean z) {
        this.mInsideScrollContainer = z;
        return this;
    }

    void setPressed(View view, boolean z, float f, float f2) {
        view.setPressed(z);
        this.mHotspotDrawable.setHotspot(f, f2);
    }
}
