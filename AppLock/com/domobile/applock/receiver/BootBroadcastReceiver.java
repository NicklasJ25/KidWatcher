package com.domobile.applock.receiver;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainActivity;
import com.domobile.applock.R;
import com.domobile.applock.VerifyActivity;
import com.domobile.applock.service.LockService;
import com.domobile.applock.service.ProfilesService;
import com.domobile.applock.theme.C1102c;
import com.domobile.frame.p000a.C1148d;

public class BootBroadcastReceiver extends BroadcastReceiver {
    public static String m2086a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (LockService.f1931a) {
            return C1150y.m2600b(activityManager);
        }
        try {
            return C1150y.m2563a(activityManager).topActivity.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void m2087b(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void m2088c(Context context) {
        String string;
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        PendingIntent service;
        long b = C1150y.m2596b(context, "actived_profile", -100);
        String string2 = context.getString(R.string.app_name);
        String string3;
        Object obj;
        Object obj2;
        if (!C1150y.m2627g(context)) {
            string3 = context.getString(R.string.notify_title_stopped, new Object[]{string2});
            string = context.getString(R.string.notify_open_lock, new Object[]{string2});
            i = R.drawable.toolbar_unlock;
            obj = string3;
            obj2 = string;
        } else if (b == -1) {
            string3 = context.getString(R.string.notify_title_stopped, new Object[]{string2});
            string = context.getString(R.string.notify_open_lock, new Object[]{string2});
            i = R.drawable.toolbar_unlock;
            charSequence = string3;
            charSequence2 = string;
        } else {
            string3 = context.getString(R.string.notify_title_running, new Object[]{string2});
            string = context.getString(R.string.notify_close_lock, new Object[]{string2});
            i = R.drawable.toolbar_lock;
            obj = string3;
            obj2 = string;
        }
        if (b == -1 || !C1150y.m2627g(context)) {
            service = PendingIntent.getService(context, 0, new Intent(context, ProfilesService.class).putExtra("com.domobile.applock.EXTRA_PROFILE_ID", -3).putExtra("com.domobile.applock.EXTRA_PROFILE_MESSAGE", context.getString(R.string.notify_title_running, new Object[]{string2})), 134217728);
        } else {
            string = context.getString(R.string.notify_title_stopped, new Object[]{string2});
            Intent intent = new Intent(context, VerifyActivity.class);
            intent.setAction("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT");
            intent.setFlags(268435456);
            intent.putExtra("com.domobile.applock.EXTRA_PROFILE_ID", -1);
            intent.putExtra("com.domobile.applock.EXTRA_PROFILE_NAME", context.getString(R.string.default_profile));
            intent.putExtra("com.domobile.applock.EXTRA_PROFILE_MESSAGE", string);
            intent.putExtra("com.domobile.applock.EXTRA_AUTO_STARTUP_GUEST", false);
            service = PendingIntent.getActivity(context, 0, intent, 134217728);
        }
        Builder smallIcon = new Builder(context).setSmallIcon(i);
        smallIcon.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
        smallIcon.setContentText(charSequence2).setContentTitle(charSequence);
        smallIcon.setTicker(charSequence).setOngoing(true);
        smallIcon.setWhen(System.currentTimeMillis());
        C1148d.m2508a(context, (int) R.id.show_notification, smallIcon.setContentIntent(service).build());
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Intent intent2;
        if ("android.intent.action.BOOT_COMPLETED".equals(action) || "com.domobile.applock.ACTION_START_SERVICE".equals(action) || "android.intent.action.QUICKBOOT_POWERON".equals(action)) {
            if (C1150y.m2614c(context, "key_hide_app_icon")) {
                C1150y.m2540E(context);
            }
            intent2 = new Intent(context, MainActivity.class);
            if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                intent2.putExtra("com.domobile.elock.EXTRA_NOT_OPEN_ACTIVITY", true);
            } else {
                if (!"com.domobile.applock".equals(m2086a(context))) {
                    intent2.putExtra("com.domobile.elock.EXTRA_NOT_OPEN_ACTIVITY", intent.getBooleanExtra("com.domobile.elock.EXTRA_NOT_OPEN_ACTIVITY", true));
                } else {
                    return;
                }
            }
            intent2.setFlags(268435456);
            context.startActivity(intent2);
        } else if ("com.domobile.elock.action.CHANGE_NOTIFY".equals(action) || "com.domobile.elock.proctect_list_change".equals(action)) {
            if (C1150y.m2614c(context, "show_notification")) {
                m2088c(context);
            } else {
                C1148d.m2530f(context, R.id.show_notification);
            }
        } else if ("android.provider.Telephony.SECRET_CODE".equals(action)) {
            context.startActivity(new Intent(context, MainActivity.class).setFlags(268435456));
        } else if ("android.intent.action.NEW_OUTGOING_CALL".equals(action)) {
            action = getResultData();
            if ("*#*#12345#*#*".equals(action)) {
                setResultData(null);
                m2087b(context);
            } else if (!TextUtils.isEmpty(action) && action.startsWith("#") && action.length() > 1 && C1150y.m2608b(context, action.substring(1), null)) {
                setResultData(null);
                m2087b(context);
            }
        } else if ("android.intent.action.USER_PRESENT".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
            if (!LockService.m2172a()) {
                context.startService(new Intent(context, LockService.class));
            }
        } else if ("com.domobile.applock.ACTION_STARTUP_THEME".equals(action)) {
            if (!C1150y.m2592a(context, action, false)) {
                String stringExtra = intent.getStringExtra("com.domobile.applock.EXTRA_THEME_PKGNAME");
                C1150y.m2582a(context, action, Boolean.valueOf(true));
                C1102c.m2399c(context, stringExtra);
            }
        } else if ("android.intent.action.PACKAGE_RESTARTED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
            try {
                action = intent.getData().toString().replace("package:", "");
                if (!TextUtils.equals(context.getPackageName(), action) && C1150y.m2566a(context).m597k().containsKey(action.toLowerCase())) {
                    intent2 = new Intent("com.domobile.applock.plugins.ACTION_RESTART_KILLED_APP");
                    intent2.setFlags(32);
                    intent2.setPackage(action);
                    context.sendBroadcast(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
