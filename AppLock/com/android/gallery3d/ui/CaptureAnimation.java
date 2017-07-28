package com.android.gallery3d.ui;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class CaptureAnimation {
    private static final float ZOOM_DELTA = 0.2f;
    private static final float ZOOM_IN_BEGIN = 0.8f;
    private static final Interpolator sSlideInterpolator = new AccelerateDecelerateInterpolator();
    private static final Interpolator sZoomInInterpolator = new AccelerateInterpolator();
    private static final Interpolator sZoomOutInterpolator = new DecelerateInterpolator();

    public static float calculateScale(float f) {
        return f <= 0.5f ? 1.0f - (sZoomOutInterpolator.getInterpolation(f * 2.0f) * ZOOM_DELTA) : ZOOM_IN_BEGIN + (sZoomInInterpolator.getInterpolation((f - 0.5f) * 2.0f) * ZOOM_DELTA);
    }

    public static float calculateSlide(float f) {
        return sSlideInterpolator.getInterpolation(f);
    }
}
