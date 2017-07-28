package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C2295l.C2294e;

public final class AspectRatioFrameLayout extends FrameLayout {
    private float f6598a;
    private int f6599b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6599b = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2294e.AspectRatioFrameLayout, 0, 0);
            try {
                this.f6599b = obtainStyledAttributes.getInt(C2294e.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6598a != 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.f6598a / (((float) measuredWidth) / ((float) measuredHeight))) - 1.0f;
            if (Math.abs(f) > 0.01f) {
                switch (this.f6599b) {
                    case 1:
                        measuredHeight = (int) (((float) measuredWidth) / this.f6598a);
                        break;
                    case 2:
                        measuredWidth = (int) (((float) measuredHeight) * this.f6598a);
                        break;
                    default:
                        if (f <= 0.0f) {
                            measuredWidth = (int) (((float) measuredHeight) * this.f6598a);
                            break;
                        } else {
                            measuredHeight = (int) (((float) measuredWidth) / this.f6598a);
                            break;
                        }
                }
                super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.f6598a != f) {
            this.f6598a = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.f6599b != i) {
            this.f6599b = i;
            requestLayout();
        }
    }
}
