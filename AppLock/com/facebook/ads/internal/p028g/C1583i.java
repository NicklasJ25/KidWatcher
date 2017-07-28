package com.facebook.ads.internal.p028g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.C1611h;
import com.facebook.ads.internal.C1611h.C1588c;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1729s.C1728a;

public class C1583i {
    public static final String f3920a = VERSION.RELEASE;
    public static String f3921b = "";
    public static String f3922c = "";
    public static String f3923d = "";
    public static String f3924e = "";
    public static String f3925f = "";
    public static int f3926g = 0;
    public static String f3927h = "";
    public static String f3928i = "";
    public static int f3929j = 0;
    public static String f3930k = "";
    public static int f3931l = 0;
    public static String f3932m = "";
    public static String f3933n = "";
    public static String f3934o = "";
    public static boolean f3935p = false;
    public static String f3936q = "";
    private static boolean f3937r = false;

    public static synchronized void m4411a(Context context) {
        synchronized (C1583i.class) {
            if (!f3937r) {
                f3937r = true;
                C1583i.m4413c(context);
            }
            C1583i.m4414d(context);
        }
    }

    public static void m4412b(Context context) {
        if (f3937r) {
            try {
                C1728a a;
                C1611h a2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f3933n = sharedPreferences.getString("attributionId", "");
                }
                if (sharedPreferences.contains("advertisingId")) {
                    f3934o = sharedPreferences.getString("advertisingId", "");
                    f3935p = sharedPreferences.getBoolean("limitAdTracking", f3935p);
                    f3936q = C1588c.SHARED_PREFS.name();
                }
                try {
                    a = C1729s.m4958a(context.getContentResolver());
                } catch (Throwable e) {
                    C1723o.m4943a(C1722n.m4940a(e, "Error retrieving attribution id from fb4a"));
                    a = null;
                }
                if (a != null) {
                    String str = a.f4352a;
                    if (str != null) {
                        f3933n = str;
                    }
                }
                try {
                    a2 = C1611h.m4516a(context, a);
                } catch (Throwable e2) {
                    C1723o.m4943a(C1722n.m4940a(e2, "Error retrieving advertising id from Google Play Services"));
                    a2 = null;
                }
                if (a2 != null) {
                    String a3 = a2.m4519a();
                    Boolean valueOf = Boolean.valueOf(a2.m4520b());
                    if (a3 != null) {
                        f3934o = a3;
                        f3935p = valueOf.booleanValue();
                        f3936q = a2.m4521c().name();
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f3933n);
                edit.putString("advertisingId", f3934o);
                edit.putBoolean("limitAdTracking", f3935p);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void m4413c(Context context) {
        String networkOperatorName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f3923d = packageInfo.packageName;
            f3925f = packageInfo.versionName;
            f3926g = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        try {
            if (f3923d != null && f3923d.length() >= 0) {
                String installerPackageName = packageManager.getInstallerPackageName(f3923d);
                if (installerPackageName != null && installerPackageName.length() > 0) {
                    f3927h = installerPackageName;
                }
            }
        } catch (Exception e2) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f3924e = applicationLabel.toString();
            }
        } catch (NameNotFoundException e3) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                f3928i = networkOperatorName;
            }
        }
        networkOperatorName = Build.MANUFACTURER;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f3921b = networkOperatorName;
        }
        networkOperatorName = Build.MODEL;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f3922c = Build.MODEL;
        }
    }

    private static void m4414d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f3929j = activeNetworkInfo.getType();
                f3930k = activeNetworkInfo.getTypeName();
                f3931l = activeNetworkInfo.getSubtype();
                f3932m = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
