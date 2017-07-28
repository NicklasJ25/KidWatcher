package com.facebook.ads.internal.p018m;

import android.graphics.Rect;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class C1711g {
    private static final String f4288a = C1711g.class.getSimpleName();
    private boolean f4289b;
    private int f4290c = -1;
    private int f4291d = -1;
    private int f4292e = -1;
    private int f4293f = -1;
    private long f4294g = -1;
    private int f4295h = -1;
    private long f4296i = -1;
    private long f4297j = -1;
    private int f4298k = -1;
    private int f4299l = -1;
    private int f4300m = -1;
    private int f4301n = -1;
    private float f4302o = -1.0f;
    private float f4303p = -1.0f;
    private float f4304q = -1.0f;

    public void m4918a() {
        this.f4294g = System.currentTimeMillis();
    }

    public void m4919a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f4289b) {
            this.f4289b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                MotionRange motionRange = device.getMotionRange(0);
                MotionRange motionRange2 = device.getMotionRange(1);
                if (!(motionRange == null || motionRange2 == null)) {
                    this.f4304q = Math.min(motionRange.getRange(), motionRange2.getRange());
                }
            }
            if (this.f4304q <= 0.0f) {
                this.f4304q = (float) Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        switch (motionEvent.getAction()) {
            case 0:
                this.f4290c = iArr[0];
                this.f4291d = iArr[1];
                this.f4292e = view.getWidth();
                this.f4293f = view.getHeight();
                this.f4295h = 1;
                this.f4296i = System.currentTimeMillis();
                this.f4298k = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f4299l = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                this.f4302o = motionEvent.getPressure();
                this.f4303p = motionEvent.getSize();
                return;
            case 1:
            case 3:
                this.f4297j = System.currentTimeMillis();
                this.f4300m = (((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0];
                this.f4301n = (iArr2[1] + ((int) (motionEvent.getY() + 0.5f))) - iArr[1];
                return;
            case 2:
                this.f4302o -= this.f4302o / ((float) this.f4295h);
                this.f4302o += motionEvent.getPressure() / ((float) this.f4295h);
                this.f4303p -= this.f4303p / ((float) this.f4295h);
                this.f4303p += motionEvent.getSize() / ((float) this.f4295h);
                this.f4295h++;
                return;
            default:
                return;
        }
    }

    public boolean m4920a(int i) {
        if (!m4923d() || this.f4300m == -1 || this.f4301n == -1 || this.f4292e == -1 || this.f4293f == -1) {
            return false;
        }
        int i2 = (this.f4293f * i) / 100;
        int i3 = (this.f4292e * i) / 100;
        return !new Rect(i3, i2, this.f4292e - i3, this.f4293f - i2).contains(this.f4300m, this.f4301n);
    }

    public boolean m4921b() {
        return this.f4294g != -1;
    }

    public long m4922c() {
        return m4921b() ? System.currentTimeMillis() - this.f4294g : -1;
    }

    public boolean m4923d() {
        return this.f4289b;
    }

    public Map<String, String> m4924e() {
        if (!this.f4289b) {
            return null;
        }
        String valueOf = String.valueOf((this.f4303p * this.f4304q) / 2.0f);
        long j = (this.f4294g <= 0 || this.f4297j <= this.f4294g) ? -1 : this.f4297j - this.f4294g;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("adPositionX", String.valueOf(this.f4290c));
        hashMap.put("adPositionY", String.valueOf(this.f4291d));
        hashMap.put("width", String.valueOf(this.f4292e));
        hashMap.put("height", String.valueOf(this.f4293f));
        hashMap.put("clickDelayTime", String.valueOf(j));
        hashMap.put("startTime", String.valueOf(this.f4296i));
        hashMap.put("endTime", String.valueOf(this.f4297j));
        hashMap.put("startX", String.valueOf(this.f4298k));
        hashMap.put("startY", String.valueOf(this.f4299l));
        hashMap.put("clickX", String.valueOf(this.f4300m));
        hashMap.put("clickY", String.valueOf(this.f4301n));
        hashMap.put("endX", String.valueOf(this.f4300m));
        hashMap.put("endY", String.valueOf(this.f4301n));
        hashMap.put("force", String.valueOf(this.f4302o));
        hashMap.put("radiusX", valueOf);
        hashMap.put("radiusY", valueOf);
        return hashMap;
    }
}
