package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.Callable;

@wh
public class ps {
    private final Context f10241a;

    class C31561 implements Callable<Boolean> {
        C31561() {
        }

        public Boolean m13205a() {
            return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
        }

        public /* synthetic */ Object call() {
            return m13205a();
        }
    }

    public ps(Context context) {
        C2513c.m7933a((Object) context, (Object) "Context can not be null");
        this.f10241a = context;
    }

    public static boolean m13206d() {
        return ((Boolean) zz.m15285a(new C31561())).booleanValue();
    }

    public boolean m13207a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m13208a(intent);
    }

    public boolean m13208a(Intent intent) {
        C2513c.m7933a((Object) intent, (Object) "Intent can not be null");
        return !this.f10241a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean m13209b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m13208a(intent);
    }

    public boolean m13210c() {
        return m13206d() && bm.m9120b(this.f10241a).m9112a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public boolean m13211e() {
        Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
        int i = VERSION.SDK_INT;
        return m13208a(type);
    }
}
