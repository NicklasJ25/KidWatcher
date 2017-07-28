package com.android.gallery3d.app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.GalleryUtils;

public class EyePosition {
    private static final float GYROSCOPE_LIMIT = 10.0f;
    private static final float GYROSCOPE_RESTORE_FACTOR = 0.995f;
    private static final int GYROSCOPE_SETTLE_DOWN = 15;
    private static final float GYROSCOPE_THRESHOLD = 0.15f;
    private static final float MAX_VIEW_RANGE = 0.5f;
    private static final int NOT_STARTED = -1;
    private static final String TAG = "EyePosition";
    private static final float USER_ANGEL = ((float) Math.toRadians(10.0d));
    private static final float USER_ANGEL_COS = ((float) Math.cos((double) USER_ANGEL));
    private static final float USER_ANGEL_SIN = ((float) Math.sin((double) USER_ANGEL));
    private static final float USER_DISTANCE_METER = 0.3f;
    private Context mContext;
    private Display mDisplay;
    private int mGyroscopeCountdown = 0;
    private final float mLimit;
    private EyePositionListener mListener;
    private PositionListener mPositionListener = new PositionListener();
    private Sensor mSensor;
    private long mStartTime = -1;
    private final float mUserDistance;
    private float mX;
    private float mY;
    private float mZ;

    public interface EyePositionListener {
        void onEyePositionChanged(float f, float f2, float f3);
    }

    private class PositionListener implements SensorEventListener {
        private PositionListener() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            switch (sensorEvent.sensor.getType()) {
                case 1:
                    EyePosition.this.onAccelerometerChanged(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                    return;
                case 4:
                    EyePosition.this.onGyroscopeChanged(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                    return;
                default:
                    return;
            }
        }
    }

    public EyePosition(Context context, EyePositionListener eyePositionListener) {
        this.mContext = context;
        this.mListener = eyePositionListener;
        this.mUserDistance = (float) GalleryUtils.meterToPixel(USER_DISTANCE_METER);
        this.mLimit = this.mUserDistance * MAX_VIEW_RANGE;
        this.mDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
    }

    private void onAccelerometerChanged(float f, float f2, float f3) {
        float f4;
        switch (this.mDisplay.getRotation()) {
            case 1:
                f2 = -f2;
                break;
            case 2:
                f4 = -f;
                f = -f2;
                f2 = f4;
                break;
            case 3:
                f = -f;
                break;
            default:
                float f5 = f2;
                f2 = f;
                f = f5;
                break;
        }
        f4 = ((f2 * f2) + (f * f)) + (f3 * f3);
        float f6 = (-f) / f4;
        float f7 = f6 * f2;
        float f8 = -1.0f + (f6 * f);
        f6 *= f3;
        f6 = (float) Math.sqrt((double) ((f6 * f6) + ((f7 * f7) + (f8 * f8))));
        f4 = (float) Math.sqrt((double) f4);
        this.mX = Utils.clamp((((f7 * USER_ANGEL_SIN) / f6) + ((USER_ANGEL_COS * f2) / f4)) * this.mUserDistance, -this.mLimit, this.mLimit);
        this.mY = -Utils.clamp((((USER_ANGEL_COS * f) / f4) + ((USER_ANGEL_SIN * f8) / f6)) * this.mUserDistance, -this.mLimit, this.mLimit);
        this.mZ = -((float) Math.sqrt((double) (((this.mUserDistance * this.mUserDistance) - (this.mX * this.mX)) - (this.mY * this.mY))));
        this.mListener.onEyePositionChanged(this.mX, this.mY, this.mZ);
    }

    private void onGyroscopeChanged(float f, float f2, float f3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f4 = (f2 > 0.0f ? f2 : -f2) + (f > 0.0f ? f : -f);
        if (f4 < GYROSCOPE_THRESHOLD || f4 > GYROSCOPE_LIMIT || this.mGyroscopeCountdown > 0) {
            this.mGyroscopeCountdown--;
            this.mStartTime = elapsedRealtime;
            f4 = this.mUserDistance / 20.0f;
            if (this.mX > f4 || this.mX < (-f4) || this.mY > f4 || this.mY < (-f4)) {
                this.mX *= GYROSCOPE_RESTORE_FACTOR;
                this.mY *= GYROSCOPE_RESTORE_FACTOR;
                this.mZ = (float) (-Math.sqrt((double) (((this.mUserDistance * this.mUserDistance) - (this.mX * this.mX)) - (this.mY * this.mY))));
                this.mListener.onEyePositionChanged(this.mX, this.mY, this.mZ);
                return;
            }
            return;
        }
        float f5 = ((((float) (elapsedRealtime - this.mStartTime)) / 1000.0f) * this.mUserDistance) * (-this.mZ);
        this.mStartTime = elapsedRealtime;
        float f6 = -f2;
        f4 = -f;
        switch (this.mDisplay.getRotation()) {
            case 1:
                f = -f;
                break;
            case 2:
                float f7 = f;
                f = f2;
                f2 = f7;
                break;
            case 3:
                f2 = -f2;
                break;
            default:
                f2 = f4;
                f = f6;
                break;
        }
        this.mX = Utils.clamp((float) (((double) this.mX) + (((double) (f * f5)) / Math.hypot((double) this.mZ, (double) this.mX))), -this.mLimit, this.mLimit) * GYROSCOPE_RESTORE_FACTOR;
        this.mY = Utils.clamp((float) (((double) this.mY) + (((double) (f2 * f5)) / Math.hypot((double) this.mZ, (double) this.mY))), -this.mLimit, this.mLimit) * GYROSCOPE_RESTORE_FACTOR;
        this.mZ = -((float) Math.sqrt((double) (((this.mUserDistance * this.mUserDistance) - (this.mX * this.mX)) - (this.mY * this.mY))));
        this.mListener.onEyePositionChanged(this.mX, this.mY, this.mZ);
    }

    public void pause() {
        if (this.mSensor != null) {
            ((SensorManager) this.mContext.getSystemService("sensor")).unregisterListener(this.mPositionListener);
        }
    }

    public void resetPosition() {
        this.mStartTime = -1;
        this.mY = 0.0f;
        this.mX = 0.0f;
        this.mZ = -this.mUserDistance;
        this.mListener.onEyePositionChanged(this.mX, this.mY, this.mZ);
    }

    public void resume() {
        if (this.mSensor != null) {
            ((SensorManager) this.mContext.getSystemService("sensor")).registerListener(this.mPositionListener, this.mSensor, 1);
        }
        this.mStartTime = -1;
        this.mGyroscopeCountdown = 15;
        this.mY = 0.0f;
        this.mX = 0.0f;
        this.mZ = -this.mUserDistance;
        this.mListener.onEyePositionChanged(this.mX, this.mY, this.mZ);
    }
}
