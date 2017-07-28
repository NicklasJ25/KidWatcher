package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dh.C2771a;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements C2771a {
    private dh f12113a;

    private dh m15408a() {
        if (this.f12113a == null) {
            this.f12113a = new dh(this);
        }
        return this.f12113a;
    }

    @MainThread
    public void mo4278a(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        m15408a().m9888a(context, intent);
    }
}
