package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.Log;
import java.io.File;

public class aa {
    private static final String f4189a = aa.class.getSimpleName();

    public enum C1687a {
        UNKNOWN(0),
        UNROOTED(1),
        ROOTED(2);
        
        public final int f4188d;

        private C1687a(int i) {
            this.f4188d = i;
        }
    }

    public static C1687a m4801a() {
        try {
            Object obj = (aa.m4806c() || aa.m4804b() || aa.m4803a("su")) ? 1 : null;
            return obj != null ? C1687a.ROOTED : C1687a.UNROOTED;
        } catch (Throwable th) {
            return C1687a.UNKNOWN;
        }
    }

    public static boolean m4802a(Context context) {
        return aa.m4805b(context) && C1719m.m4937c(context);
    }

    private static boolean m4803a(String str) {
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file);
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File name : listFiles) {
                        if (name.getName().equals(str)) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private static boolean m4804b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean m4805b(Context context) {
        if (context == null) {
            Log.v(f4189a, "Invalid context in screen interactive check, assuming interactive.");
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            Log.e(f4189a, "Exception in screen interactive check, assuming interactive.", e);
            C1737z.m4998a(e, context);
            return true;
        }
    }

    private static boolean m4806c() {
        return new File("/system/app/Superuser.apk").exists();
    }
}
