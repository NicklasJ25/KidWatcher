package com.android.gallery3d.ui;

import android.view.MotionEvent;

public class DownUpDetector {
    private DownUpListener mListener;
    private boolean mStillDown;

    public interface DownUpListener {
        void onDown(MotionEvent motionEvent);

        void onUp(MotionEvent motionEvent);
    }

    public DownUpDetector(DownUpListener downUpListener) {
        this.mListener = downUpListener;
    }

    private void setState(boolean z, MotionEvent motionEvent) {
        if (z != this.mStillDown) {
            this.mStillDown = z;
            if (z) {
                this.mListener.onDown(motionEvent);
            } else {
                this.mListener.onUp(motionEvent);
            }
        }
    }

    public boolean isDown() {
        return this.mStillDown;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                setState(true, motionEvent);
                return;
            case 1:
            case 3:
            case 5:
                setState(false, motionEvent);
                return;
            default:
                return;
        }
    }
}
