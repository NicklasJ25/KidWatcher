package com.domobile.applock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.domobile.applock.C1150y;
import com.domobile.applock.OpenAdvanceProtectActivity;
import com.domobile.applock.service.LockService;
import com.domobile.applock.service.UpdateProtectedAppsService;
import com.domobile.applock.theme.C1102c;
import com.domobile.eframe.DatabaseErrorActivity;

public class PackageChangedReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, Intent intent) {
        Object obj = 1;
        String action = intent.getAction();
        boolean equals = "android.intent.action.PACKAGE_ADDED".equals(action);
        if (equals || "android.intent.action.PACKAGE_RESTARTED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
            try {
                action = intent.getData().toString().replace("package:", "");
                if ("com.domobile.applockwatcher".equals(action.toLowerCase())) {
                    if (C1150y.m2592a(context, "auto_upgrade_secure_level", true)) {
                        C1150y.m2566a(context).f438m = false;
                        OpenAdvanceProtectActivity.m646a(context);
                    } else {
                        C1150y.m2582a(context, "auto_upgrade_secure_level", Boolean.valueOf(true));
                    }
                    C1150y.m2541F(context);
                    return;
                }
                if (equals) {
                    if (action.startsWith("com.domobile.aut.")) {
                        context.sendBroadcast(new Intent("com.domobile.applock.ACTION_DISABLE_THEME_LAUNCHER").setFlags(32));
                        C1102c.m2399c(context, action);
                        return;
                    }
                }
                if (equals) {
                    new Thread(this) {
                        final /* synthetic */ PackageChangedReceiver f1883c;

                        public void run() {
                            try {
                                UpdateProtectedAppsService.m2256a(context, action.toLowerCase());
                            } catch (Exception e) {
                            }
                        }
                    }.start();
                }
                if (!C1150y.m2619d(context, "lock_newest_installed_app") || (LockService.f1931a && !C1150y.m2553R(context))) {
                    obj = null;
                }
                if (equals && r0 != null && C1150y.m2614c(context, "first_launch") && !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                    context.startActivity(new Intent(context, DatabaseErrorActivity.class).putExtra("com.domobile.elock.packagename", action).setFlags(268435456));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
