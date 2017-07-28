package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2555u;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.internal.bm;

public class C2480k {
    private static final C2480k f7314a = new C2480k();
    public static final int f7315b = C2489m.f7343b;

    C2480k() {
    }

    public static C2480k m7807b() {
        return f7314a;
    }

    static String m7808b(@Nullable Context context, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f7315b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(bm.m9120b(context).m9118b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int mo3314a(Context context) {
        int b = C2489m.m7863b(context);
        return C2489m.m7865b(context, b) ? 18 : b;
    }

    @Nullable
    public PendingIntent mo3315a(Context context, int i, int i2) {
        return mo3316a(context, i, i2, null);
    }

    @Nullable
    public PendingIntent mo3316a(Context context, int i, int i2, @Nullable String str) {
        Intent b = mo3320b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, 268435456);
    }

    public boolean mo3317a(int i) {
        return C2489m.m7864b(i);
    }

    public boolean m7813a(Context context, String str) {
        return C2489m.m7862a(context, str);
    }

    public int mo3318b(Context context) {
        return C2489m.m7871h(context);
    }

    @Nullable
    @Deprecated
    public Intent mo3319b(int i) {
        return mo3320b(null, i, null);
    }

    @Nullable
    public Intent mo3320b(Context context, int i, @Nullable String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !C2583h.m8294b(context)) ? C2555u.m8174a("com.google.android.gms", C2480k.m7808b(context, str)) : C2555u.m8172a();
            case 3:
                return C2555u.m8173a("com.google.android.gms");
            default:
                return null;
        }
    }

    public boolean mo3321b(Context context, int i) {
        return C2489m.m7865b(context, i);
    }

    public String mo3322c(int i) {
        return C2489m.m7857a(i);
    }

    public void m7819d(Context context) {
        C2489m.m7868e(context);
    }
}
