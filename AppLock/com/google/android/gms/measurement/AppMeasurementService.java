package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ds.C2822a;

public final class AppMeasurementService extends Service implements C2822a {
    private ds f12114a;

    private ds m15410b() {
        if (this.f12114a == null) {
            this.f12114a = new ds(this);
        }
        return this.f12114a;
    }

    public Context mo4279a() {
        return this;
    }

    public boolean mo4280a(int i) {
        return stopSelfResult(i);
    }

    @MainThread
    public IBinder onBind(Intent intent) {
        return m15410b().m10282a(intent);
    }

    @MainThread
    public void onCreate() {
        super.onCreate();
        m15410b().m10283a();
    }

    @MainThread
    public void onDestroy() {
        m15410b().m10284b();
        super.onDestroy();
    }

    @MainThread
    public void onRebind(Intent intent) {
        m15410b().m10286c(intent);
    }

    @MainThread
    public int onStartCommand(Intent intent, int i, int i2) {
        m15410b().m10281a(intent, i, i2);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        return 2;
    }

    @MainThread
    public boolean onUnbind(Intent intent) {
        return m15410b().m10285b(intent);
    }
}
