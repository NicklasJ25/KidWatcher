package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
public class ut {
    private final aat f10950a;
    private final boolean f10951b;
    private final String f10952c;

    public ut(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        this.f10950a = com_google_android_gms_internal_aat;
        this.f10952c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f10951b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f10951b = true;
        }
    }

    public void m14295a() {
        if (this.f10950a == null) {
            aad.m8426e("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f10952c) ? zzw.zzcO().mo4249b() : "landscape".equalsIgnoreCase(this.f10952c) ? zzw.zzcO().mo4247a() : this.f10951b ? -1 : zzw.zzcO().mo4265c();
        this.f10950a.mo3406b(b);
    }
}
