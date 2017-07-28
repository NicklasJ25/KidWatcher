package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2523j;
import java.util.Map;

@wh
public class ss implements sc {
    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        sq zzdj = zzw.zzdj();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                aad.m8426e("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (zzdj.m13745b(com_google_android_gms_internal_aat)) {
                aad.m8426e("Precache task already running.");
                return;
            }
            C2523j.m8015a(com_google_android_gms_internal_aat.mo3420h());
            new sp(com_google_android_gms_internal_aat, com_google_android_gms_internal_aat.mo3420h().zzsM.mo4013a(com_google_android_gms_internal_aat, parseInt, str2), str).zziP();
        } else if (!zzdj.m13743a(com_google_android_gms_internal_aat)) {
            aad.m8426e("Precache abort but no preload task running.");
        }
    }
}
