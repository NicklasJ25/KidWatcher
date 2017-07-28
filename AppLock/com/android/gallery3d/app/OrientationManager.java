package com.android.gallery3d.app;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.android.gallery3d.ui.FadeTexture;
import com.android.gallery3d.ui.OrientationSource;
import java.util.ArrayList;

public class OrientationManager implements OrientationSource {
    private static final int ORIENTATION_HYSTERESIS = 5;
    private static final String TAG = "OrientationManager";
    private Activity mActivity;
    private ArrayList<Listener> mListeners;
    private int mOrientation = -1;
    private int mOrientationCompensation = 0;
    private MyOrientationEventListener mOrientationListener;
    private boolean mOrientationLocked = false;
    private boolean mRotationLockedSetting = false;

    public interface Listener {
        void onOrientationCompensationChanged();
    }

    private class MyOrientationEventListener extends OrientationEventListener {
        public MyOrientationEventListener(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            if (i != -1) {
                OrientationManager.this.mOrientation = OrientationManager.roundOrientation(i, OrientationManager.this.mOrientation);
                if (OrientationManager.this.mOrientationLocked) {
                    OrientationManager.this.updateCompensation();
                }
            }
        }
    }

    public OrientationManager(Activity activity) {
        this.mActivity = activity;
        this.mListeners = new ArrayList();
        this.mOrientationListener = new MyOrientationEventListener(activity);
    }

    private void disableCompensation() {
        if (this.mOrientationCompensation != 0) {
            this.mOrientationCompensation = 0;
            notifyListeners();
        }
    }

    private static int getDisplayRotation(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                return 90;
            case 2:
                return FadeTexture.DURATION;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    private void notifyListeners() {
        synchronized (this.mListeners) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                ((Listener) this.mListeners.get(i)).onOrientationCompensationChanged();
            }
        }
    }

    private static int roundOrientation(int i, int i2) {
        Object obj = 1;
        if (i2 != -1) {
            int abs = Math.abs(i - i2);
            if (Math.min(abs, 360 - abs) < 50) {
                obj = null;
            }
        }
        return obj != null ? (((i + 45) / 90) * 90) % 360 : i2;
    }

    private void updateCompensation() {
        if (this.mOrientation != -1) {
            int displayRotation = (this.mOrientation + getDisplayRotation(this.mActivity)) % 360;
            if (this.mOrientationCompensation != displayRotation) {
                this.mOrientationCompensation = displayRotation;
                notifyListeners();
            }
        }
    }

    public void addListener(Listener listener) {
        synchronized (this.mListeners) {
            this.mListeners.add(listener);
        }
    }

    public int getCompensation() {
        return this.mOrientationCompensation;
    }

    public int getDisplayRotation() {
        return getDisplayRotation(this.mActivity);
    }

    public void lockOrientation() {
        int i = 0;
        int i2 = 1;
        if (!this.mOrientationLocked) {
            this.mOrientationLocked = true;
            int displayRotation = getDisplayRotation();
            int i3 = displayRotation < FadeTexture.DURATION ? 1 : 0;
            if (this.mActivity.getResources().getConfiguration().orientation == 2) {
                Log.m429d(TAG, "lock orientation to landscape");
                Activity activity = this.mActivity;
                if (i3 == 0) {
                    i = 8;
                }
                activity.setRequestedOrientation(i);
            } else {
                if (displayRotation == 90 || displayRotation == 270) {
                    if (i3 == 0) {
                        i = 1;
                    }
                    i3 = i;
                }
                Log.m429d(TAG, "lock orientation to portrait");
                Activity activity2 = this.mActivity;
                if (i3 == 0) {
                    i2 = 9;
                }
                activity2.setRequestedOrientation(i2);
            }
            updateCompensation();
        }
    }

    public void pause() {
        this.mOrientationListener.disable();
    }

    public void removeListener(Listener listener) {
        synchronized (this.mListeners) {
            this.mListeners.remove(listener);
        }
    }

    public void resume() {
        boolean z = true;
        if (System.getInt(this.mActivity.getContentResolver(), "accelerometer_rotation", 0) == 1) {
            z = false;
        }
        this.mRotationLockedSetting = z;
        this.mOrientationListener.enable();
    }

    public void unlockOrientation() {
        if (this.mOrientationLocked && !this.mRotationLockedSetting) {
            this.mOrientationLocked = false;
            Log.m429d(TAG, "unlock orientation");
            this.mActivity.setRequestedOrientation(-1);
            disableCompensation();
        }
    }
}
