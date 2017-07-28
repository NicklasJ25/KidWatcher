package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.bm;

public class ac {
    private static Object f7391a = new Object();
    private static boolean f7392b;
    private static String f7393c;
    private static int f7394d;

    public static String m7925a(Context context) {
        m7927c(context);
        return f7393c;
    }

    public static int m7926b(Context context) {
        m7927c(context);
        return f7394d;
    }

    private static void m7927c(Context context) {
        synchronized (f7391a) {
            if (f7392b) {
                return;
            }
            f7392b = true;
            try {
                Bundle bundle = bm.m9120b(context).m9114a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f7393c = bundle.getString("com.google.app.id");
                f7394d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
