package com.google.android.gms.internal;

import java.util.Map;

@wh
public final class rw implements sc {
    private final rx f10526a;

    public rw(rx rxVar) {
        this.f10526a = rxVar;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            aad.m8426e("App event with no name parameter.");
        } else {
            this.f10526a.onAppEvent(str, (String) map.get("info"));
        }
    }
}
