package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
public class si implements sc {
    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        if (zzw.zzdl().m14943a()) {
            int i = -1;
            try {
                i = Integer.parseInt((String) map.get("eventType"));
            } catch (Throwable e) {
                aad.m8422b("Parse Scion log event type error", e);
            }
            String str = (String) map.get("eventId");
            switch (i) {
                case 0:
                    zzw.zzdl().m14948c(com_google_android_gms_internal_aat.getContext(), str);
                    return;
                case 1:
                    zzw.zzdl().m14951d(com_google_android_gms_internal_aat.getContext(), str);
                    return;
                case 2:
                    zzw.zzdl().m14955f(com_google_android_gms_internal_aat.getContext(), str);
                    return;
                default:
                    return;
            }
        }
    }
}
