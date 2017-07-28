package com.domobile.p017d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.File;

public class C1213a {
    private static final Uri f2391a = Uri.parse("content://com.domobile.applock/password");

    public static int m2842a(Activity activity, Bundle bundle, String str) {
        return C1213a.m2843a(activity, null, bundle, str);
    }

    public static int m2843a(Activity activity, Fragment fragment, Bundle bundle, String str) {
        if (!C1213a.m2846a(activity, str)) {
            return 5;
        }
        int a = C1213a.m2844a(activity);
        if (a != 0) {
            return a;
        }
        try {
            Intent intent = new Intent("com.domobile.applock.plugins.ACTION_PLEASE_UNLOCK_APP");
            intent.addFlags(32);
            intent.putExtra("unlock_app_action", "com.domobile.applock.plugins.ACTION_PLEASE_UNLOCK_APP");
            intent.putExtra("unlock_app_pkgname", activity.getPackageName());
            intent.setPackage("com.domobile.applock");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.addFlags(AccessibilityEventCompat.TYPE_WINDOWS_CHANGED);
            if (fragment != null) {
                fragment.startActivityForResult(intent, 4132);
            } else {
                activity.startActivityForResult(intent, 4132);
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public static int m2844a(Context context) {
        return !C1213a.m2849b(context) ? 2 : ((long) C1213a.m2850c(context, "com.domobile.applock")) < 2014040901 ? 4 : 0;
    }

    public static boolean m2845a(int i, int i2, Intent intent) {
        return i != 4132 ? true : i == 4132 && i2 == -1;
    }

    public static boolean m2846a(Context context, String str) {
        if (!context.getSharedPreferences("com.domobile.applock.plugins.plugin_pref_name", 0).getBoolean(str, false)) {
            return false;
        }
        if (C1213a.m2849b(context)) {
            return true;
        }
        C1213a.m2847a(context, str, false);
        return false;
    }

    public static boolean m2847a(Context context, String str, boolean z) {
        return (!z || C1213a.m2849b(context)) ? context.getSharedPreferences("com.domobile.applock.plugins.plugin_pref_name", 0).edit().putBoolean(str, z).commit() : false;
    }

    public static String m2848b(Context context, String str) {
        return new File(context.getFilesDir(), str).getAbsolutePath();
    }

    public static boolean m2849b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.domobile.applock", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static int m2850c(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }
}
