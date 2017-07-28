package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.C2489m;

public final class C2583h {
    private static Boolean f7559a;
    private static Boolean f7560b;
    private static Boolean f7561c;

    public static boolean m8292a() {
        boolean z = C2489m.f7344c;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean m8293a(Context context) {
        if (f7559a == null) {
            boolean z = C2590o.m8313h() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f7559a = Boolean.valueOf(z);
        }
        return f7559a.booleanValue();
    }

    @TargetApi(24)
    public static boolean m8294b(Context context) {
        return (!C2590o.m8317l() || C2583h.m8295c(context)) && C2583h.m8293a(context);
    }

    @TargetApi(21)
    public static boolean m8295c(Context context) {
        if (f7560b == null) {
            boolean z = C2590o.m8315j() && context.getPackageManager().hasSystemFeature("cn.google");
            f7560b = Boolean.valueOf(z);
        }
        return f7560b.booleanValue();
    }

    public static boolean m8296d(Context context) {
        if (f7561c == null) {
            f7561c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return f7561c.booleanValue();
    }
}
