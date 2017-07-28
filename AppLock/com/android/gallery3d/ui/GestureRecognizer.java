package com.android.gallery3d.ui;

import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.android.gallery3d.ui.DownUpDetector.DownUpListener;

public class GestureRecognizer {
    private static final String TAG = "GestureRecognizer";
    private final DownUpDetector mDownUpDetector = new DownUpDetector(new MyDownUpListener());
    private final GestureDetector mGestureDetector;
    private final Listener mListener;
    private final ScaleGestureDetector mScaleDetector;

    public interface Listener {
        boolean onDoubleTap(float f, float f2);

        void onDown(float f, float f2);

        boolean onFling(float f, float f2);

        boolean onScale(float f, float f2, float f3);

        boolean onScaleBegin(float f, float f2);

        void onScaleEnd();

        boolean onScroll(float f, float f2, float f3, float f4);

        boolean onSingleTapUp(float f, float f2);

        void onUp();
    }

    private class MyDownUpListener implements DownUpListener {
        private MyDownUpListener() {
        }

        public void onDown(MotionEvent motionEvent) {
            GestureRecognizer.this.mListener.onDown(motionEvent.getX(), motionEvent.getY());
        }

        public void onUp(MotionEvent motionEvent) {
            GestureRecognizer.this.mListener.onUp();
        }
    }

    private class MyGestureListener extends SimpleOnGestureListener {
        private MyGestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return GestureRecognizer.this.mListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return GestureRecognizer.this.mListener.onFling(f, f2);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return GestureRecognizer.this.mListener.onScroll(f, f2, motionEvent2.getX() - motionEvent.getX(), motionEvent2.getY() - motionEvent.getY());
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return GestureRecognizer.this.mListener.onSingleTapUp(motionEvent.getX(), motionEvent.getY());
        }
    }

    private class MyScaleListener extends SimpleOnScaleGestureListener {
        private MyScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return GestureRecognizer.this.mListener.onScale(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getScaleFactor());
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return GestureRecognizer.this.mListener.onScaleBegin(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            GestureRecognizer.this.mListener.onScaleEnd();
        }
    }

    public GestureRecognizer(Context context, Listener listener) {
        this.mListener = listener;
        this.mGestureDetector = new GestureDetector(context, new MyGestureListener(), null, true);
        this.mScaleDetector = new ScaleGestureDetector(context, new MyScaleListener());
    }

    public void cancelScale() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mScaleDetector.onTouchEvent(obtain);
        obtain.recycle();
    }

    public boolean isDown() {
        return this.mDownUpDetector.isDown();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        this.mScaleDetector.onTouchEvent(motionEvent);
        this.mDownUpDetector.onTouchEvent(motionEvent);
    }
}
