package com.facebook.ads.internal.p026e;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.C1668j;

public class C1556a {
    private static final String f3794a = C1556a.class.getName();
    private static C1556a f3795b;
    private static boolean f3796c = false;
    private Context f3797d;

    private C1556a(Context context) {
        this.f3797d = context;
    }

    public static C1556a m4324a(Context context) {
        if (f3795b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f3795b == null) {
                    f3795b = new C1556a(applicationContext);
                }
            }
        }
        return f3795b;
    }

    public synchronized void m4325a() {
        if (!f3796c) {
            if (C1668j.m4722e(this.f3797d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new C1557b(Thread.getDefaultUncaughtExceptionHandler(), this.f3797d));
                } catch (Throwable e) {
                    Log.e(f3794a, "No permissions to set the default uncaught exception handler", e);
                }
            }
            f3796c = true;
        }
    }
}
