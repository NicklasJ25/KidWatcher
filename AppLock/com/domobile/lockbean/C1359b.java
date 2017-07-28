package com.domobile.lockbean;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1017n;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.eframe.C1217c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;

public class C1359b {
    public static long f2925a = 0;
    public static String f2926b = "";

    public static Scene m3412a(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(Location.CODE_SCENE)) {
            return null;
        }
        String replaceFirst = str.replaceFirst(Location.CODE_SCENE, "");
        int indexOf = replaceFirst.indexOf("|");
        if (indexOf == -1) {
            return null;
        }
        try {
            Scene scene = new Scene();
            scene.f2923b = replaceFirst.substring(indexOf + 1);
            scene.f2922a = Long.parseLong(replaceFirst.substring(0, indexOf));
            return scene;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String m3413a(Context context, String str) {
        if (str.startsWith(Location.CODE_START)) {
            return context.getString(R.string.protect_startup_success);
        }
        if (str.startsWith(Location.CODE_STOP)) {
            return context.getString(R.string.protect_stop_success);
        }
        if (!str.startsWith(Location.CODE_SCENE)) {
            return null;
        }
        if (C1359b.m3412a(str) != null) {
            return context.getString(R.string.startup_success, new Object[]{C1359b.m3412a(str).f2923b});
        }
        return context.getString(R.string.startup_success, new Object[]{context.getString(R.string.scenes_mode)});
    }

    public static String m3414a(Scene scene) {
        return C1147a.m2480a(Location.CODE_SCENE, Long.valueOf(scene.f2922a), "|", scene.f2923b);
    }

    private static void m3415a(int i, Context context, String str, String str2) {
        if (C1150y.m2592a(context, "notify_when_codeset_excute", true)) {
            Notification build = new Builder(context).setSmallIcon(R.drawable.toolbar_lock).setTicker(str).setContentTitle(str).setContentText(str2).setVisibility(1).setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent(), 0)).setWhen(System.currentTimeMillis()).build();
            build.defaults |= 16;
            C1148d.m2508a(context, i, build);
        }
    }

    public static void m3416a(long j) {
        Context b = AppLockApplication.m577b();
        String str = "code like 'scene:" + j + "|%'";
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", Location.CODE_START);
        C1217c.m2853a().update("alarms", contentValues, str, null);
        C1217c.m2853a().update("locations", contentValues, str, null);
        C1148d.m2489A(b, "com.domobile.elock.action.ACTION_SCENE_CHANGED");
    }

    public static void m3417a(Context context) {
        C1148d.m2534y(context, "last_connected_wifi");
    }

    public static void m3418a(Context context, int i, String str, String str2) {
        if (str2.startsWith(Location.CODE_START)) {
            C1150y.m2598b(context).m2665a(context, true);
        } else if (str2.startsWith(Location.CODE_STOP)) {
            C1150y.m2598b(context).m2665a(context, false);
        } else if (str2.startsWith(Location.CODE_SCENE)) {
            try {
                if (C1017n.m2041c(C1359b.m3412a(str2).f2922a)) {
                    C1148d.m2489A(context, "com.domobile.elock.proctect_list_change");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i != -1) {
            C1359b.m3415a(i, context, str, C1359b.m3413a(context, str2));
        }
    }

    public static String m3419b(Context context) {
        return C1150y.m2602b(context, "last_connected_wifi");
    }

    public static String m3420b(Context context, String str) {
        if (str.startsWith(Location.CODE_START)) {
            return context.getString(R.string.protect_startup_mode);
        }
        if (str.startsWith(Location.CODE_STOP)) {
            return context.getString(R.string.protect_stop_mode);
        }
        if (str.startsWith(Location.CODE_SCENE)) {
            Scene a = C1359b.m3412a(str);
            if (a != null) {
                return a.f2923b;
            }
        }
        return context.getString(R.string.protect_startup_mode);
    }

    public static void m3421b(Scene scene) {
        Context b = AppLockApplication.m577b();
        String a = C1359b.m3414a(scene);
        String str = "code like 'scene:" + scene.f2922a + "|%'";
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", a);
        C1217c.m2853a().update("alarms", contentValues, str, null);
        C1217c.m2853a().update("locations", contentValues, str, null);
        C1148d.m2489A(b, "com.domobile.elock.action.ACTION_SCENE_CHANGED");
    }

    public static void m3422c(Context context, String str) {
        C1148d.m2520b(context, "last_connected_wifi", (Object) str);
    }
}
