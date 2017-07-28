package com.android.gallery3d.anim;

import com.android.gallery3d.common.Utils;
import com.android.gallery3d.ui.GLCanvas;

public class AlphaAnimation extends CanvasAnimation {
    private float mCurrentAlpha;
    private final float mEndAlpha;
    private final float mStartAlpha;

    public AlphaAnimation(float f, float f2) {
        this.mStartAlpha = f;
        this.mEndAlpha = f2;
        this.mCurrentAlpha = f;
    }

    public void apply(GLCanvas gLCanvas) {
        gLCanvas.multiplyAlpha(this.mCurrentAlpha);
    }

    public int getCanvasSaveFlags() {
        return 1;
    }

    protected void onCalculate(float f) {
        this.mCurrentAlpha = Utils.clamp(this.mStartAlpha + ((this.mEndAlpha - this.mStartAlpha) * f), 0.0f, 1.0f);
    }
}
