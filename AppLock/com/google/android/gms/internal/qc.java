package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.internal.zzw;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@wh
public class qc {
    private boolean f10314a;
    private String f10315b;
    private Map<String, String> f10316c;
    private Context f10317d = null;
    private String f10318e = null;

    public qc(Context context, String str) {
        this.f10317d = context;
        this.f10318e = str;
        this.f10314a = ((Boolean) qb.f10280T.m13225c()).booleanValue();
        this.f10315b = (String) qb.f10281U.m13225c();
        this.f10316c = new LinkedHashMap();
        this.f10316c.put("s", "gmob_sdk");
        this.f10316c.put("v", GpsMeasureMode.MODE_3_DIMENSIONAL);
        this.f10316c.put("os", VERSION.RELEASE);
        this.f10316c.put("sdk", VERSION.SDK);
        this.f10316c.put("device", zzw.zzcM().m15154e());
        this.f10316c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.f10316c.put("is_lite_sdk", zzw.zzcM().m15165l(context) ? "1" : "0");
        Future a = zzw.zzcV().m14767a(this.f10317d);
        try {
            a.get();
            this.f10316c.put("network_coarse", Integer.toString(((xg) a.get()).f11406m));
            this.f10316c.put("network_fine", Integer.toString(((xg) a.get()).f11407n));
        } catch (Throwable e) {
            zzw.zzcQ().m15000a(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    boolean m13270a() {
        return this.f10314a;
    }

    String m13271b() {
        return this.f10315b;
    }

    Context m13272c() {
        return this.f10317d;
    }

    String m13273d() {
        return this.f10318e;
    }

    Map<String, String> m13274e() {
        return this.f10316c;
    }
}
