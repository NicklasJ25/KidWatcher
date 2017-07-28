package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.measurement.AppMeasurement;

public final class dh {
    private final C2771a f8430a;

    public interface C2771a {
        void mo4278a(Context context, Intent intent);
    }

    public dh(C2771a c2771a) {
        C2513c.m7932a((Object) c2771a);
        this.f8430a = c2771a;
    }

    public static boolean m9887a(Context context, boolean z) {
        C2513c.m7932a((Object) context);
        return dy.m10373a(context, z ? "com.google.android.gms.measurement.PackageMeasurementReceiver" : "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    }

    @MainThread
    public void m9888a(Context context, Intent intent) {
        final dk a = dk.m9976a(context);
        final dc f = a.m10034f();
        if (intent == null) {
            f.m9817z().m9774a("Receiver called with null intent");
            return;
        }
        a.m10030d().m9490W();
        String action = intent.getAction();
        f.m9786D().m9775a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            ds.m10278a(context, false);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.f8430a.mo4278a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            action = intent.getStringExtra("referrer");
            if (action == null) {
                f.m9786D().m9774a("Install referrer extras are null");
                return;
            }
            f.m9784B().m9775a("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            final Bundle a2 = a.m10043o().m10386a(Uri.parse(action));
            if (a2 == null) {
                f.m9786D().m9774a("No campaign defined in install referrer broadcast");
                return;
            }
            final long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                f.m9817z().m9774a("Install referrer is missing timestamp");
            }
            final Context context2 = context;
            a.m10036h().m9938a(new Runnable(this) {
                public void run() {
                    dx c = a.m10044p().m9597c(a.m10052x().m9732x(), "_fot");
                    long longValue = (c == null || !(c.f8705e instanceof Long)) ? 0 : ((Long) c.f8705e).longValue();
                    long j = longExtra;
                    longValue = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
                    if (longValue > 0) {
                        a2.putLong("click_timestamp", longValue);
                    }
                    AppMeasurement.getInstance(context2).logEventInternal("auto", "_cmp", a2);
                    f.m9786D().m9774a("Install campaign recorded");
                }
            });
        }
    }
}
