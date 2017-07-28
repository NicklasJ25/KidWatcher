package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Matrix;
import com.android.gallery3d.anim.CanvasAnimation;

public interface GLRoot {

    public interface OnGLIdleListener {
        boolean onGLIdle(GLCanvas gLCanvas, boolean z);
    }

    void addOnGLIdleListener(OnGLIdleListener onGLIdleListener);

    void freeze();

    int getCompensation();

    Matrix getCompensationMatrix();

    Context getContext();

    int getDisplayRotation();

    void lockRenderThread();

    void registerLaunchedAnimation(CanvasAnimation canvasAnimation);

    void requestLayoutContentPane();

    void requestRender();

    void requestRenderForced();

    void setContentPane(GLView gLView);

    void setLightsOutMode(boolean z);

    void setOrientationSource(OrientationSource orientationSource);

    void unfreeze();

    void unlockRenderThread();
}
