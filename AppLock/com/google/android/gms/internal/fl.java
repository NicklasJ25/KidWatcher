package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.C2861c;
import com.google.firebase.crash.FirebaseCrash;

public class fl {
    final C2861c f8926a = new C28621(this);
    private final Context f8927b;
    private boolean f8928c = false;
    private AppMeasurement f8929d = null;

    class C28621 implements C2861c {
        C28621(fl flVar) {
        }

        public void mo3588a(String str, String str2, Bundle bundle, long j) {
            if (!str.equals("crash")) {
                FirebaseCrash.m15439a(str2, j, bundle);
            }
        }
    }

    public fl(Context context) {
        this.f8927b = context;
        try {
            this.f8929d = AppMeasurement.getInstance(this.f8927b);
        } catch (NoClassDefFoundError e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseCrashAnalytics", new StringBuilder(String.valueOf(valueOf).length() + 50).append("Unable to log event, missing measurement library: ").append(valueOf).toString());
        }
    }

    private void m10775a(Bundle bundle) {
        if (this.f8929d != null) {
            this.f8929d.logEventInternal("crash", "_ae", bundle);
        }
    }

    public void m10776a() {
        try {
            if (!this.f8928c && this.f8929d != null) {
                this.f8929d.zza(this.f8926a);
                this.f8928c = true;
            }
        } catch (IllegalStateException e) {
            Log.d("FirebaseCrashAnalytics", "Firebase Analytics breadcrumbs is not supported");
        }
    }

    public void m10777a(boolean z, long j) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("fatal", 1);
        } else {
            bundle.putInt("fatal", 0);
        }
        bundle.putLong("timestamp", j);
        m10775a(bundle);
    }
}
