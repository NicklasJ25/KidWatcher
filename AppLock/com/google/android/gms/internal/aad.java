package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@wh
public class aad {
    public static void m8419a(String str, Throwable th) {
        if (m8420a(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m8420a(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void m8421b(String str) {
        if (m8420a(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m8422b(String str, Throwable th) {
        if (m8420a(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8423c(String str) {
        if (m8420a(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m8424c(String str, Throwable th) {
        if (m8420a(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8425d(String str) {
        if (m8420a(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m8426e(String str) {
        if (m8420a(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
