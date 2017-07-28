package com.domobile.applock.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.domobile.applock.C1150y;
import com.domobile.applock.VerifyActivity;
import com.domobile.applock.service.AlarmService;
import com.domobile.applock.service.CodeSetService;
import com.domobile.applock.service.ProfilesService;
import com.domobile.lockbean.Alarm;

public class CodeSetReceiver extends BroadcastReceiver {
    private static final byte[] f1880a = new byte[0];

    public static void m2089a(Service service, int i) {
        synchronized (f1880a) {
            service.stopSelfResult(i);
        }
    }

    public static void m2090a(Context context, Intent intent) {
        synchronized (f1880a) {
            context.startService(intent);
        }
    }

    private void m2091b(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            intent.setClass(context, CodeSetService.class);
            m2090a(context, intent);
        } else if ("com.domobile.ACTION_ALARM_LOCK".equals(action)) {
            if (C1150y.m2539D(context)) {
                Parcelable parcelable = null;
                byte[] byteArrayExtra = intent.getByteArrayExtra("intent.extra.alarm_raw");
                if (byteArrayExtra != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                    obtain.setDataPosition(0);
                    parcelable = (Alarm) Alarm.CREATOR.createFromParcel(obtain);
                }
                Intent intent2 = new Intent(context, AlarmService.class);
                intent2.putExtra("intent.extra.alarm", parcelable);
                context.startService(intent2);
            }
        } else if (!"com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT".equals(action)) {
        } else {
            Intent intent3;
            if (intent.getLongExtra("com.domobile.applock.EXTRA_PROFILE_ID", -2) == -2) {
                intent3 = new Intent(context, ProfilesService.class);
                intent3.putExtras(intent);
                context.startService(intent3);
                return;
            }
            intent3 = new Intent(context, VerifyActivity.class);
            intent3.setAction("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT");
            intent3.setFlags(268435456);
            intent3.putExtras(intent);
            context.startActivity(intent3);
        }
    }

    public void onReceive(Context context, Intent intent) {
        m2091b(context, intent);
    }
}
