package com.google.android.gms.internal;

import android.content.Context;

public class bk {
    private static Context f7977a;
    private static Boolean f7978b;

    public static synchronized boolean m9111a(Context context) {
        boolean booleanValue;
        synchronized (bk.class) {
            Context applicationContext = context.getApplicationContext();
            if (f7977a == null || f7978b == null || f7977a != applicationContext) {
                f7978b = null;
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f7978b = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f7978b = Boolean.valueOf(false);
                }
                f7977a = applicationContext;
                booleanValue = f7978b.booleanValue();
            } else {
                booleanValue = f7978b.booleanValue();
            }
        }
        return booleanValue;
    }
}
