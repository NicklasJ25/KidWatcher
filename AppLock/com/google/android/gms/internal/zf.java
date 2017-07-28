package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.math.BigInteger;
import java.util.Locale;

@wh
public final class zf {
    private static final Object f11620a = new Object();
    private static String f11621b;

    public static String m15048a() {
        String str;
        synchronized (f11620a) {
            str = f11621b;
        }
        return str;
    }

    public static String m15049a(Context context, String str, String str2) {
        String str3;
        synchronized (f11620a) {
            if (f11621b == null && !TextUtils.isEmpty(str)) {
                m15050b(context, str, str2);
            }
            str3 = f11621b;
        }
        return str3;
    }

    private static void m15050b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (zzw.zzcM().m15134a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f11621b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f11621b = "err";
        }
    }
}
