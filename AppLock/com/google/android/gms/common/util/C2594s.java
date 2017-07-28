package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C2572n;
import com.google.android.gms.internal.bm;

public final class C2594s {
    public static boolean m8324a(Context context, int i) {
        boolean z = false;
        if (!C2594s.m8325a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C2572n.m8220a(context).m8226a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m8325a(Context context, int i, String str) {
        return bm.m9120b(context).m9116a(i, str);
    }
}
