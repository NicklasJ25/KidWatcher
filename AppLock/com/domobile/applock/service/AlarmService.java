package com.domobile.applock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.lockbean.Alarm;
import com.domobile.lockbean.Alarm.C1352a;
import com.domobile.lockbean.Alarm.C1353b;
import com.domobile.lockbean.C1358a;
import com.domobile.lockbean.C1359b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class AlarmService extends Service {
    private static ArrayList<Alarm> m2117a(Alarm alarm) {
        ArrayList<Alarm> arrayList = null;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(alarm.f2911f);
        int a = C1353b.m3364a(instance.get(7));
        Cursor query = C1217c.m2853a().query("alarms", C1352a.f2903a, C1147a.m2480a("hour", "=", Integer.valueOf(instance.get(11)), " and ", "minutes", "=", Integer.valueOf(instance.get(12)), " and ", "enabled=1"), null, null, null, null);
        if (query != null) {
            try {
                arrayList = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        Alarm alarm2 = new Alarm(query);
                        if (alarm2.f2910e.m3369b(a) || !alarm2.f2910e.m3371c()) {
                            arrayList.add(alarm2);
                        }
                    } while (query.moveToNext());
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return arrayList;
    }

    private void m2118a() {
        stopForeground(true);
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        startForeground(R.id.notify_foreground, C1150y.m2555T(this));
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        Alarm alarm = (Alarm) intent.getParcelableExtra("intent.extra.alarm");
        if (alarm == null) {
            C1358a.m3402a((Context) this);
            m2118a();
            return;
        }
        if (System.currentTimeMillis() <= alarm.f2911f + 1800000) {
            ArrayList a = m2117a(alarm);
            if (!(a == null || a.isEmpty())) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    Alarm alarm2 = (Alarm) it.next();
                    C1359b.m3418a((Context) this, alarm2.f2906a, alarm2.m3373a((Context) this), alarm2.f2913h);
                }
            }
        }
        if (alarm.f2910e.m3371c()) {
            C1358a.m3402a((Context) this);
        } else {
            C1358a.m3403a((Context) this, alarm.f2906a, false);
        }
        m2118a();
    }
}
