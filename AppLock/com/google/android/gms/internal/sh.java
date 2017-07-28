package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@wh
public class sh implements sc {
    final HashMap<String, aag<JSONObject>> f10571a = new HashMap();

    public Future<JSONObject> m13715a(String str) {
        Future com_google_android_gms_internal_aag = new aag();
        this.f10571a.put(str, com_google_android_gms_internal_aag);
        return com_google_android_gms_internal_aag;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        m13717a((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void m13717a(String str, String str2) {
        aad.m8421b("Received ad from the cache.");
        aag com_google_android_gms_internal_aag = (aag) this.f10571a.get(str);
        if (com_google_android_gms_internal_aag == null) {
            aad.m8423c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            com_google_android_gms_internal_aag.m8436b(new JSONObject(str2));
        } catch (Throwable e) {
            aad.m8422b("Failed constructing JSON object from value passed from javascript", e);
            com_google_android_gms_internal_aag.m8436b(null);
        } finally {
            this.f10571a.remove(str);
        }
    }

    public void m13718b(String str) {
        aag com_google_android_gms_internal_aag = (aag) this.f10571a.get(str);
        if (com_google_android_gms_internal_aag == null) {
            aad.m8423c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!com_google_android_gms_internal_aag.isDone()) {
            com_google_android_gms_internal_aag.cancel(true);
        }
        this.f10571a.remove(str);
    }
}
