package com.domobile.widget.timepicker;

import android.content.Context;
import android.database.ContentObserver;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;

public class C1419c {
    private final Context f3189a;
    private final ContentObserver f3190b = new ContentObserver(this, null) {
        final /* synthetic */ C1419c f3188a;

        public void onChange(boolean z) {
            this.f3188a.f3192d = C1419c.m3613b(this.f3188a.f3189a);
        }
    };
    private Vibrator f3191c;
    private boolean f3192d;
    private long f3193e;

    public C1419c(Context context) {
        this.f3189a = context;
    }

    private static boolean m3613b(Context context) {
        return System.getInt(context.getContentResolver(), "haptic_feedback_enabled", 0) == 1;
    }

    public void m3614a() {
        this.f3191c = (Vibrator) this.f3189a.getSystemService("vibrator");
        this.f3192d = C1419c.m3613b(this.f3189a);
        this.f3189a.getContentResolver().registerContentObserver(System.getUriFor("haptic_feedback_enabled"), false, this.f3190b);
    }

    public void m3615b() {
        this.f3191c = null;
        this.f3189a.getContentResolver().unregisterContentObserver(this.f3190b);
    }

    public void m3616c() {
        if (this.f3191c != null && this.f3192d) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f3193e >= 125) {
                this.f3191c.vibrate(5);
                this.f3193e = uptimeMillis;
            }
        }
    }
}
