package com.android.gallery3d.app;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PackagesMonitor extends BroadcastReceiver {
    public static final String KEY_PACKAGES_VERSION = "packages-version";

    public static class AsyncService extends IntentService {
        public AsyncService() {
            super("GalleryPackagesMonitorAsync");
        }

        protected void onHandleIntent(Intent intent) {
            PackagesMonitor.onReceiveAsync(this, intent);
        }
    }

    public static synchronized int getPackagesVersion(Context context) {
        int i;
        synchronized (PackagesMonitor.class) {
            i = PreferenceManager.getDefaultSharedPreferences(context).getInt(KEY_PACKAGES_VERSION, 1);
        }
        return i;
    }

    private static void onReceiveAsync(Context context, Intent intent) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putInt(KEY_PACKAGES_VERSION, defaultSharedPreferences.getInt(KEY_PACKAGES_VERSION, 1) + 1).commit();
        String action = intent.getAction();
        if (!"android.intent.action.PACKAGE_ADDED".equals(action) && !"android.intent.action.PACKAGE_REMOVED".equals(action) && "android.intent.action.PACKAGE_CHANGED".equals(action)) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, AsyncService.class);
        context.startService(intent);
    }
}
