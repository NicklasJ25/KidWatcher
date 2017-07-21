package com.example.nist.kidwatcher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service
{
    @Override
    public void onCreate() {
        //TODO: Sikre at den starter på alle telefoner ved Destroy
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO: Kig efter forkerte ord.
        //TODO: Send mail.
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
