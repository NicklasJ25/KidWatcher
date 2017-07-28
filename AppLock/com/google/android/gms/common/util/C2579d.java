package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.bm;

public class C2579d {
    public static boolean m8272a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (bm.m9120b(context).m9114a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
