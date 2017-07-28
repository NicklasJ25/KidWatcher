package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.os.Build.VERSION;

public class C0810f {
    public static C0785a m1290a(Context context) {
        return VERSION.SDK_INT >= 21 ? new C0809e(context) : new C0800d(context);
    }
}
