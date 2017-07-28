package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class bf {
    public static wc m9106a(Context context) {
        return m9107a(context, null);
    }

    public static wc m9107a(Context context, abp com_google_android_gms_internal_abp) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (com_google_android_gms_internal_abp == null) {
            com_google_android_gms_internal_abp = VERSION.SDK_INT >= 9 ? new C2704b() : new abn(AndroidHttpClient.newInstance(str));
        }
        wc wcVar = new wc(new abm(file), new abk(com_google_android_gms_internal_abp));
        wcVar.m14469a();
        return wcVar;
    }
}
