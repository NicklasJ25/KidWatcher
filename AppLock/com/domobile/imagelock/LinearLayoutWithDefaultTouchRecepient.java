package com.domobile.imagelock;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.domobile.eframe.ui.NotifyChangedLinearLayout;

public class LinearLayoutWithDefaultTouchRecepient extends NotifyChangedLinearLayout {
    private View mDefaultTouchRecepient;
    private final Rect mTempRect = new Rect();

    public LinearLayoutWithDefaultTouchRecepient(Context context) {
        super(context);
    }

    public LinearLayoutWithDefaultTouchRecepient(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDefaultTouchRecepient == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        this.mTempRect.set(0, 0, 0, 0);
        offsetRectIntoDescendantCoords(this.mDefaultTouchRecepient, this.mTempRect);
        motionEvent.setLocation(motionEvent.getX() + ((float) this.mTempRect.left), motionEvent.getY() + ((float) this.mTempRect.top));
        return this.mDefaultTouchRecepient.dispatchTouchEvent(motionEvent);
    }

    public void setDefaultTouchRecepient(View view) {
        this.mDefaultTouchRecepient = view;
    }
}
