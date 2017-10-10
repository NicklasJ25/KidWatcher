package com.nist.kidwatcher;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service
{
    @Override
    public void onCreate()
    {
        //TODO: Sikre at den starter på alle telefoner ved Destroy
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //TODO: Tag screenshot hvert 10. sekund
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_LONG).show();
        new AsyncTask()
        {
            @Override
            protected Object doInBackground(Object... arg0)
            {
                try
                {
                    Thread.sleep(10000);
                    Screenshot screenshot = new Screenshot();
                    screenshot.TakeScreenshot();
                    Toast.makeText(getBaseContext(), "Screenshot taget", Toast.LENGTH_LONG).show();
                    return "Godkendt";
                } catch (Exception e)
                {
                    e.printStackTrace();
                    return "Fejl";
                }
            }
        }.execute();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }


}
