package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.media.TransportMediator;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;

@wh
class C2330b implements SensorEventListener {
    private final SensorManager f6724a;
    private final Object f6725b = new Object();
    private final Display f6726c;
    private final float[] f6727d = new float[9];
    private final float[] f6728e = new float[9];
    private float[] f6729f;
    private Handler f6730g;
    private C2329a f6731h;

    class C23281 implements Runnable {
        C23281(C2330b c2330b) {
        }

        public void run() {
            Looper.myLooper().quit();
        }
    }

    interface C2329a {
        void zzhJ();
    }

    C2330b(Context context) {
        this.f6724a = (SensorManager) context.getSystemService("sensor");
        this.f6726c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void m7380a(int i, int i2) {
        float f = this.f6728e[i];
        this.f6728e[i] = this.f6728e[i2];
        this.f6728e[i2] = f;
    }

    int m7381a() {
        return this.f6726c.getRotation();
    }

    void m7382a(C2329a c2329a) {
        this.f6731h = c2329a;
    }

    void m7383a(float[] fArr) {
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f6725b) {
                if (this.f6729f == null) {
                    this.f6729f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f6727d, fArr);
            switch (m7381a()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.f6727d, 2, 129, this.f6728e);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.f6727d, 129, TransportMediator.KEYCODE_MEDIA_RECORD, this.f6728e);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.f6727d, TransportMediator.KEYCODE_MEDIA_RECORD, 1, this.f6728e);
                    break;
                default:
                    System.arraycopy(this.f6727d, 0, this.f6728e, 0, 9);
                    break;
            }
            m7380a(1, 3);
            m7380a(2, 6);
            m7380a(5, 7);
            synchronized (this.f6725b) {
                System.arraycopy(this.f6728e, 0, this.f6729f, 0, 9);
            }
            if (this.f6731h != null) {
                this.f6731h.zzhJ();
            }
        }
    }

    void m7384b() {
        if (this.f6730g == null) {
            Sensor defaultSensor = this.f6724a.getDefaultSensor(11);
            if (defaultSensor == null) {
                aad.m8423c("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f6730g = new Handler(handlerThread.getLooper());
            if (!this.f6724a.registerListener(this, defaultSensor, 0, this.f6730g)) {
                aad.m8423c("SensorManager.registerListener failed.");
                m7386c();
            }
        }
    }

    boolean m7385b(float[] fArr) {
        boolean z = false;
        synchronized (this.f6725b) {
            if (this.f6729f == null) {
            } else {
                System.arraycopy(this.f6729f, 0, fArr, 0, this.f6729f.length);
                z = true;
            }
        }
        return z;
    }

    void m7386c() {
        if (this.f6730g != null) {
            this.f6724a.unregisterListener(this);
            this.f6730g.post(new C23281(this));
            this.f6730g = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        m7383a(sensorEvent.values);
    }
}
