package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@wh
public class sm implements sc {
    private final C2389a f10581a;

    public interface C2389a {
        void zzb(zzoo com_google_android_gms_internal_zzoo);

        void zzcn();
    }

    public sm(C2389a c2389a) {
        this.f10581a = c2389a;
    }

    public static void m13732a(aat com_google_android_gms_internal_aat, C2389a c2389a) {
        com_google_android_gms_internal_aat.mo3424l().m8552a("/reward", new sm(c2389a));
    }

    private void m13733a(Map<String, String> map) {
        zzoo com_google_android_gms_internal_zzoo;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                com_google_android_gms_internal_zzoo = new zzoo(str, parseInt);
                this.f10581a.zzb(com_google_android_gms_internal_zzoo);
            }
        } catch (Throwable e) {
            aad.m8424c("Unable to parse reward amount.", e);
        }
        com_google_android_gms_internal_zzoo = null;
        this.f10581a.zzb(com_google_android_gms_internal_zzoo);
    }

    private void m13734b(Map<String, String> map) {
        this.f10581a.zzcn();
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            m13733a(map);
        } else if ("video_start".equals(str)) {
            m13734b(map);
        }
    }
}
