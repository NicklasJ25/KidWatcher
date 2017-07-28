package com.android.gallery3d.ui;

import android.content.Context;
import android.util.TypedValue;

public class ScrollBarView extends GLView {
    private static final String TAG = "ScrollBarView";
    private int mBarHeight;
    private int mContentPosition;
    private int mContentTotal;
    private int mGivenGripWidth;
    private int mGripHeight;
    private int mGripPosition = 0;
    private int mGripWidth = 0;
    private NinePatchTexture mScrollBarTexture;

    public ScrollBarView(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842852, typedValue, true);
        this.mScrollBarTexture = new NinePatchTexture(context, typedValue.resourceId);
        this.mGivenGripWidth = i2;
        this.mGripHeight = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mBarHeight = i4 - i2;
        }
    }

    protected void render(GLCanvas gLCanvas) {
        super.render(gLCanvas);
        if (this.mGripWidth != 0) {
            bounds();
            GLCanvas gLCanvas2 = gLCanvas;
            this.mScrollBarTexture.draw(gLCanvas2, this.mGripPosition, (this.mBarHeight - this.mGripHeight) / 2, this.mGripWidth, this.mGripHeight);
        }
    }

    public void setContentPosition(int i, int i2) {
        if (i != this.mContentPosition || i2 != this.mContentTotal) {
            invalidate();
            this.mContentPosition = i;
            this.mContentTotal = i2;
            if (this.mContentTotal <= 0) {
                this.mGripPosition = 0;
                this.mGripWidth = 0;
                return;
            }
            this.mGripWidth = this.mGivenGripWidth;
            this.mGripPosition = Math.round((((float) (getWidth() - this.mGripWidth)) / ((float) this.mContentTotal)) * ((float) this.mContentPosition));
        }
    }
}
