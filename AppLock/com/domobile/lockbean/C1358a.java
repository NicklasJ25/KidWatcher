package com.domobile.lockbean;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.domobile.applock.C1150y;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.Alarm.C1352a;
import com.domobile.lockbean.Alarm.C1353b;
import com.google.android.exoplayer2.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class C1358a {
    public static int m3395a(Context context, int i) {
        if (i == -1 || C1217c.m2853a().delete("alarms", "_id=" + i, null) <= 0) {
            return 0;
        }
        C1358a.m3402a(context);
        return 1;
    }

    public static long m3396a(Context context, Alarm alarm) {
        alarm.f2906a = (int) C1217c.m2853a().insert("alarms", null, C1358a.m3397a(alarm));
        long b = C1358a.m3407b(alarm);
        C1358a.m3402a(context);
        return b;
    }

    private static ContentValues m3397a(Alarm alarm) {
        ContentValues contentValues = new ContentValues(8);
        long j = 0;
        if (!alarm.f2910e.m3371c()) {
            j = C1358a.m3407b(alarm);
        }
        contentValues.put("enabled", Integer.valueOf(alarm.f2907b ? 1 : 0));
        contentValues.put("hour", Integer.valueOf(alarm.f2908c));
        contentValues.put("minutes", Integer.valueOf(alarm.f2909d));
        contentValues.put("alarmtime", Long.valueOf(j));
        contentValues.put("daysofweek", Integer.valueOf(alarm.f2910e.m3365a()));
        contentValues.put("label", alarm.f2912g);
        contentValues.put("code", alarm.f2913h);
        return contentValues;
    }

    public static Cursor m3398a() {
        return C1358a.m3399a(null);
    }

    public static Cursor m3399a(String str) {
        return C1217c.m2853a().query("alarms", C1352a.f2903a, null, null, null, null, TextUtils.isEmpty(str) ? "hour, minutes ASC" : str);
    }

    public static Alarm m3400a(int i) {
        Alarm alarm = null;
        Cursor query = C1217c.m2853a().query("alarms", C1352a.f2903a, "_id=" + i, null, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                alarm = new Alarm(query);
            }
            query.close();
        }
        return alarm;
    }

    static Calendar m3401a(int i, int i2, C1353b c1353b) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        int i3 = instance.get(11);
        int i4 = instance.get(12);
        if (i < i3 || (i == i3 && i2 <= i4)) {
            instance.add(6, 1);
        }
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        instance.set(14, 0);
        i3 = c1353b.m3366a(instance);
        if (i3 > 0) {
            instance.add(7, i3);
        }
        return instance;
    }

    public static void m3402a(Context context) {
        Alarm c = C1358a.m3411c(context);
        C1148d.m2489A(context, "com.domobile.elock.action.ACTION_ALARM_LOCK_CHANGED");
        if (c != null) {
            C1358a.m3404a(context, c, c.f2911f);
        } else {
            C1358a.m3409b(context);
        }
    }

    public static void m3403a(Context context, int i, boolean z) {
        C1358a.m3410b(context, i, z);
        C1358a.m3402a(context);
    }

    private static void m3404a(Context context, Alarm alarm, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Log.i("Alarm", "** setAlert id " + alarm.f2906a + " atTime " + new SimpleDateFormat("yyyyMMdd kk:mm").format(Long.valueOf(j)));
        Parcel obtain = Parcel.obtain();
        alarm.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        Intent intent = new Intent("com.domobile.ACTION_ALARM_LOCK");
        intent.setPackage(context.getPackageName());
        intent.putExtra("intent.extra.alarm_raw", obtain.marshall());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        if (C1150y.O > 19) {
            alarmManager.setExact(0, j, broadcast);
        } else {
            alarmManager.set(0, j, broadcast);
        }
    }

    private static void m3405a(Context context, Alarm alarm, boolean z) {
        if (alarm != null) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("enabled", Integer.valueOf(z ? 1 : 0));
            if (z) {
                long j = 0;
                if (!alarm.f2910e.m3371c()) {
                    j = C1358a.m3407b(alarm);
                }
                contentValues.put("alarmtime", Long.valueOf(j));
            }
            C1217c.m2853a().update("alarms", contentValues, "_id=" + alarm.f2906a, null);
        }
    }

    public static long m3406b(Context context, Alarm alarm) {
        String str = "_id=" + alarm.f2906a;
        C1217c.m2853a().update("alarms", C1358a.m3397a(alarm), str, null);
        long b = C1358a.m3407b(alarm);
        C1358a.m3402a(context);
        return b;
    }

    private static long m3407b(Alarm alarm) {
        return C1358a.m3401a(alarm.f2908c, alarm.f2909d, alarm.f2910e).getTimeInMillis();
    }

    private static Cursor m3408b() {
        return C1217c.m2853a().query("alarms", C1352a.f2903a, "enabled=1", null, null, null, null);
    }

    static void m3409b(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.domobile.ACTION_ALARM_LOCK"), 268435456));
    }

    private static void m3410b(Context context, int i, boolean z) {
        C1358a.m3405a(context, C1358a.m3400a(i), z);
    }

    private static Alarm m3411c(Context context) {
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long currentTimeMillis = System.currentTimeMillis();
        Set<Alarm> hashSet = new HashSet();
        Cursor b = C1358a.m3408b();
        if (b != null) {
            try {
                if (b.moveToFirst()) {
                    do {
                        hashSet.add(new Alarm(b));
                    } while (b.moveToNext());
                }
                b.close();
            } catch (Throwable th) {
                b.close();
            }
        }
        Alarm alarm = null;
        for (Alarm alarm2 : hashSet) {
            Alarm alarm22;
            if (alarm22.f2911f == 0) {
                alarm22.f2911f = C1358a.m3407b(alarm22);
            }
            if (alarm22.f2911f < currentTimeMillis) {
                Log.v("Alarm", "Disabling expired alarm set for " + Alarm.m3372a(alarm22.f2911f));
                C1358a.m3405a(context, alarm22, false);
            } else {
                if (alarm22.f2911f < j) {
                    j = alarm22.f2911f;
                } else {
                    alarm22 = alarm;
                }
                alarm = alarm22;
            }
        }
        return alarm;
    }
}
