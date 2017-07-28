package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
class so implements sc {
    so() {
    }

    private int m13738a(Map<String, String> map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        return (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        Throwable e;
        if (((Boolean) qb.by.m13225c()).booleanValue()) {
            aaz com_google_android_gms_internal_aaz;
            aaz z = com_google_android_gms_internal_aat.mo3448z();
            if (z == null) {
                try {
                    z = new aaz(com_google_android_gms_internal_aat, Float.parseFloat((String) map.get("duration")));
                    com_google_android_gms_internal_aat.mo3397a(z);
                    com_google_android_gms_internal_aaz = z;
                } catch (NullPointerException e2) {
                    e = e2;
                    aad.m8422b("Unable to parse videoMeta message.", e);
                    zzw.zzcQ().m15000a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    aad.m8422b("Unable to parse videoMeta message.", e);
                    zzw.zzcQ().m15000a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            }
            com_google_android_gms_internal_aaz = z;
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int a = m13738a(map);
            String str = (String) map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (aad.m8420a(3)) {
                aad.m8421b(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(a).append(" , aspectRatio : ").append(str).toString());
            }
            com_google_android_gms_internal_aaz.m8729a(parseFloat, a, equals, parseFloat2);
        }
    }
}
