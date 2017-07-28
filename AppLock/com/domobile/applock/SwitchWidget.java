package com.domobile.applock;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.domobile.applock.service.ProfilesService;

public class SwitchWidget extends AppWidgetProvider {
    static RemoteViews m668a(Context context, int i) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        remoteViews.setOnClickPendingIntent(R.id.widget_bg, m669b(context));
        if (!C1150y.m2627g(context)) {
            remoteViews.setImageViewResource(R.id.widget_bg, R.drawable.widget_unlock_bg);
        } else if (C1150y.m2596b(context, "actived_profile", -100) == -1) {
            remoteViews.setImageViewResource(R.id.widget_bg, R.drawable.widget_unlock_bg);
        } else {
            remoteViews.setImageViewResource(R.id.widget_bg, R.drawable.widget_lock_bg);
        }
        return remoteViews;
    }

    private static PendingIntent m669b(Context context) {
        Intent intent = new Intent(context, SwitchWidget.class);
        intent.addCategory("android.intent.category.ALTERNATIVE");
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    public void m670a(Context context) {
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context.getPackageName(), SwitchWidget.class.getName()), m668a(context, -1));
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.hasCategory("android.intent.category.ALTERNATIVE")) {
            if (C1150y.m2596b(context, "actived_profile", -100) == -1 || !C1150y.m2627g(context)) {
                context.startService(new Intent(context, ProfilesService.class).putExtra("com.domobile.applock.EXTRA_PROFILE_ID", -3).putExtra("com.domobile.applock.EXTRA_PROFILE_MESSAGE", context.getString(R.string.notify_title_running, new Object[]{context.getString(R.string.app_name)})));
            } else {
                String string = context.getString(R.string.notify_title_stopped, new Object[]{context.getString(R.string.app_name)});
                Intent intent2 = new Intent(context, VerifyActivity.class);
                intent2.setAction("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT");
                intent2.setFlags(268435456);
                intent2.putExtra("com.domobile.applock.EXTRA_PROFILE_ID", -1);
                intent2.putExtra("com.domobile.applock.EXTRA_PROFILE_NAME", context.getString(R.string.default_profile));
                intent2.putExtra("com.domobile.applock.EXTRA_PROFILE_MESSAGE", string);
                intent2.putExtra("com.domobile.applock.EXTRA_AUTO_STARTUP_GUEST", false);
                context.startActivity(intent2);
            }
        }
        m670a(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        RemoteViews a = m668a(context, -1);
        for (int updateAppWidget : iArr) {
            appWidgetManager.updateAppWidget(updateAppWidget, a);
        }
    }
}
