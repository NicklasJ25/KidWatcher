package com.google.android.gms.internal;

import java.util.Map;

@wh
public class sf implements sc {
    private final sg f10570a;

    public sf(sg sgVar) {
        this.f10570a = sgVar;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.f10570a.zzf(equals);
                this.f10570a.zza(equals2, parseFloat);
            }
        } catch (Throwable e) {
            aad.m8422b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.f10570a.zzf(equals);
        this.f10570a.zza(equals2, parseFloat);
    }
}
