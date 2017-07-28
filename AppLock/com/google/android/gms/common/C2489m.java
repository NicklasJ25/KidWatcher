package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.common.C2571l.C2570d;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.common.util.C2584i;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.common.util.C2594s;
import java.util.concurrent.atomic.AtomicBoolean;

public class C2489m {
    private static boolean f7342a = false;
    @Deprecated
    public static final int f7343b = 10260000;
    public static boolean f7344c = false;
    public static boolean f7345d = false;
    static boolean f7346e = false;
    static final AtomicBoolean f7347f = new AtomicBoolean();
    private static final AtomicBoolean f7348g = new AtomicBoolean();

    @Deprecated
    public static String m7857a(int i) {
        return ConnectionResult.m7711a(i);
    }

    private static void m7858a(Context context) {
        if (!f7348g.get()) {
            int b = ac.m7926b(context);
            if (b == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (b != f7343b) {
                int i = f7343b;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(b).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    @Deprecated
    public static boolean m7859a() {
        return C2583h.m8292a();
    }

    @Deprecated
    public static boolean m7860a(Context context, int i) {
        return C2594s.m8324a(context, i);
    }

    @TargetApi(19)
    @Deprecated
    public static boolean m7861a(Context context, int i, String str) {
        return C2594s.m8325a(context, i, str);
    }

    @TargetApi(21)
    static boolean m7862a(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (C2590o.m8315j()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            boolean z = applicationInfo.enabled && !C2489m.m7872i(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @Deprecated
    public static int m7863b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C2307b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C2489m.m7858a(context);
        }
        int i = (C2583h.m8294b(context) || C2583h.m8296d(context)) ? 0 : 1;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C2572n a = C2572n.m8220a(context);
            if (i != 0) {
                if (a.m8221a(packageInfo, C2570d.f7526a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a.m8221a(packageInfo2, a.m8221a(packageInfo, C2570d.f7526a)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (a.m8221a(packageInfo2, C2570d.f7526a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C2584i.m8297a(packageInfo2.versionCode) < C2584i.m8297a(f7343b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f7343b + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean m7864b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m7865b(Context context, int i) {
        return i == 18 ? true : i == 1 ? C2489m.m7862a(context, "com.google.android.gms") : false;
    }

    public static boolean m7866c(Context context) {
        C2489m.m7873j(context);
        return f7346e;
    }

    public static boolean m7867d(Context context) {
        return C2489m.m7866c(context) || !C2489m.m7859a();
    }

    @Deprecated
    public static void m7868e(Context context) {
        if (!f7347f.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    public static Resources m7869f(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context m7870g(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int m7871h(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @TargetApi(18)
    public static boolean m7872i(Context context) {
        if (C2590o.m8311f()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void m7873j(Context context) {
        if (!f7342a) {
            C2489m.m7874k(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m7874k(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = com.google.android.gms.internal.bm.m9120b(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.m9118b(r1, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x000f:
        r1 = com.google.android.gms.common.C2572n.m8220a(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r2 = 1;
        r2 = new com.google.android.gms.common.C2571l.C2565a[r2];	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = 0;
        r4 = com.google.android.gms.common.C2571l.C2570d.f7526a;	 Catch:{ NameNotFoundException -> 0x002e }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x002e }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x002e }
        r0 = r1.m8221a(r0, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r0 = 1;
        f7346e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
    L_0x0027:
        f7342a = r6;
    L_0x0029:
        return;
    L_0x002a:
        r0 = 0;
        f7346e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
        goto L_0x0027;
    L_0x002e:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0039 }
        f7342a = r6;
        goto L_0x0029;
    L_0x0039:
        r0 = move-exception;
        f7342a = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.m.k(android.content.Context):void");
    }
}
