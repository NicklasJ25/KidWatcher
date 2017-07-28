package com.facebook.ads.internal.p018m;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class C1694b {
    private static SensorManager f4236a = null;
    private static Sensor f4237b = null;
    private static Sensor f4238c = null;
    private static volatile float[] f4239d;
    private static volatile float[] f4240e;
    private static Map<String, String> f4241f = new ConcurrentHashMap();
    private static String[] f4242g = new String[]{"x", "y", "z"};

    private static class C1693a implements SensorEventListener {
        private C1693a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor == C1694b.f4237b) {
                C1694b.f4239d = sensorEvent.values;
            } else if (sensorEvent.sensor == C1694b.f4238c) {
                C1694b.f4240e = sensorEvent.values;
            }
            C1694b.m4846a(this);
        }
    }

    public static Map<String, String> m4844a() {
        Map hashMap = new HashMap();
        hashMap.putAll(f4241f);
        C1694b.m4847a(hashMap);
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m4845a(android.content.Context r5) {
        /*
        r1 = com.facebook.ads.internal.p018m.C1694b.class;
        monitor-enter(r1);
        com.facebook.ads.internal.p018m.C1694b.m4850b(r5);	 Catch:{ all -> 0x005f }
        com.facebook.ads.internal.p018m.C1694b.m4853c(r5);	 Catch:{ all -> 0x005f }
        com.facebook.ads.internal.p018m.C1694b.m4854d(r5);	 Catch:{ all -> 0x005f }
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x0010:
        r0 = "sensor";
        r0 = r5.getSystemService(r0);	 Catch:{ all -> 0x005f }
        r0 = (android.hardware.SensorManager) r0;	 Catch:{ all -> 0x005f }
        f4236a = r0;	 Catch:{ all -> 0x005f }
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r1);
        return;
    L_0x0020:
        r0 = f4237b;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x002d;
    L_0x0024:
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        r2 = 1;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f4237b = r0;	 Catch:{ all -> 0x005f }
    L_0x002d:
        r0 = f4238c;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x003a;
    L_0x0031:
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        r2 = 4;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f4238c = r0;	 Catch:{ all -> 0x005f }
    L_0x003a:
        r0 = f4237b;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x004c;
    L_0x003e:
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        r2 = new com.facebook.ads.internal.m.b$a;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f4237b;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
    L_0x004c:
        r0 = f4238c;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x001e;
    L_0x0050:
        r0 = f4236a;	 Catch:{ all -> 0x005f }
        r2 = new com.facebook.ads.internal.m.b$a;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f4238c;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
        goto L_0x001e;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.b.a(android.content.Context):void");
    }

    public static synchronized void m4846a(C1693a c1693a) {
        synchronized (C1694b.class) {
            if (f4236a != null) {
                f4236a.unregisterListener(c1693a);
            }
        }
    }

    private static void m4847a(Map<String, String> map) {
        int i;
        int i2 = 0;
        float[] fArr = f4239d;
        float[] fArr2 = f4240e;
        if (fArr != null) {
            int min = Math.min(f4242g.length, fArr.length);
            for (i = 0; i < min; i++) {
                map.put("accelerometer_" + f4242g[i], String.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            i = Math.min(f4242g.length, fArr2.length);
            while (i2 < i) {
                map.put("rotation_" + f4242g[i2], String.valueOf(fArr2[i2]));
                i2++;
            }
        }
    }

    private static void m4850b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f4241f.put("available_memory", String.valueOf(memoryInfo.availMem));
    }

    private static void m4853c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = (long) statFs.getAvailableBlocks();
        f4241f.put("free_space", String.valueOf(availableBlocks * ((long) statFs.getBlockSize())));
    }

    private static void m4854d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            Object obj = (intExtra3 == 2 || intExtra3 == 5) ? 1 : null;
            float f = 0.0f;
            if (intExtra2 > 0) {
                f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            }
            f4241f.put("battery", String.valueOf(f));
            f4241f.put("charging", obj != null ? "1" : "0");
        }
    }
}
