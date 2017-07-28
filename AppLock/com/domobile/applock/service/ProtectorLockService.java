package com.domobile.applock.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;

public class ProtectorLockService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        try {
            startForeground(R.id.notify_foreground, C1150y.m2555T(this));
            sendBroadcast(new Intent("com.domobile.applock.ACTION_PROTECTOR_SERVICE_COMPLETE"));
        } catch (Exception e) {
        }
    }

    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
