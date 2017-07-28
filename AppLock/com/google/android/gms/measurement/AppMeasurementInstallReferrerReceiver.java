package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dh.C2771a;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements C2771a {
    private dh f12112a;

    private dh m15406a() {
        if (this.f12112a == null) {
            this.f12112a = new dh(this);
        }
        return this.f12112a;
    }

    public void mo4278a(Context context, Intent intent) {
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        m15406a().m9888a(context, intent);
    }
}
