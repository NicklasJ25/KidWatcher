package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class mh {
    private static String f9834a;

    public static String m12561a(Context context) {
        if (f9834a != null) {
            return f9834a;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        Object obj = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        List arrayList = new ArrayList();
        for (ResolveInfo resolveActivity2 : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveActivity2.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveActivity2.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f9834a = null;
        } else if (arrayList.size() == 1) {
            f9834a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(obj) && !m12562a(context, intent) && arrayList.contains(obj)) {
            f9834a = obj;
        } else if (arrayList.contains("com.android.chrome")) {
            f9834a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f9834a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f9834a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f9834a = "com.google.android.apps.chrome";
        }
        return f9834a;
    }

    private static boolean m12562a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
    }
}
