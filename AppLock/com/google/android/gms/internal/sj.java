package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.common.util.C2581f;
import java.util.Map;

@wh
public class sj implements sc {
    static final Map<String, Integer> f10572a = C2581f.m8277a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    private final zzf f10573b;
    private final us f10574c;

    public sj(zzf com_google_android_gms_ads_internal_zzf, us usVar) {
        this.f10573b = com_google_android_gms_ads_internal_zzf;
        this.f10574c = usVar;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        int intValue = ((Integer) f10572a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f10573b == null || this.f10573b.zzcd()) {
            switch (intValue) {
                case 1:
                    this.f10574c.m14288a((Map) map);
                    return;
                case 3:
                    new uu(com_google_android_gms_internal_aat, map).m14299a();
                    return;
                case 4:
                    new ur(com_google_android_gms_internal_aat, map).m14282a();
                    return;
                case 5:
                    new ut(com_google_android_gms_internal_aat, map).m14295a();
                    return;
                case 6:
                    this.f10574c.m14289a(true);
                    return;
                default:
                    aad.m8425d("Unknown MRAID command called.");
                    return;
            }
        }
        this.f10573b.zzx(null);
    }
}
