package com.domobile.applock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.domobile.lockbean.C1359b;
import com.domobile.lockbean.Location;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent == null) {
            stopSelf();
            return;
        }
        String stringExtra = intent.getStringExtra(Location.LOCATION_INTENT_EXTRA);
        boolean booleanExtra = intent.getBooleanExtra(Location.LOCATION_DISCONNECT_EXTRA, false);
        if (TextUtils.isEmpty(stringExtra)) {
            stopSelf();
            return;
        }
        ArrayList a = Location.m3381a(stringExtra, true, booleanExtra);
        if (!(a == null || a.isEmpty())) {
            C1359b.f2926b = stringExtra;
            C1359b.f2925a = System.currentTimeMillis();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                Location location = (Location) it.next();
                C1359b.m3418a((Context) this, location.f2915a, location.m3384a((Context) this), booleanExtra ? location.f2920f : location.f2919e);
            }
        }
        stopSelf();
    }
}
