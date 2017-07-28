package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class za {
    private final long f11568a;
    private final List<String> f11569b = new ArrayList();
    private final Map<String, tr> f11570c = new HashMap();
    private String f11571d;
    private String f11572e;
    private boolean f11573f = false;

    public za(String str, long j) {
        this.f11572e = str;
        this.f11568a = j;
        m14979a(str);
    }

    private void m14979a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.f11573f = false;
                    aad.m8426e("App settings could not be fetched successfully.");
                    return;
                }
                this.f11573f = true;
                this.f11571d = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        m14980a(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (Throwable e) {
                aad.m8424c("Exception occurred while processing app setting json", e);
                zzw.zzcQ().m15000a(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    private void m14980a(JSONObject jSONObject) {
        String optString = jSONObject.optString("format");
        CharSequence optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.f11569b.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                if (optJSONObject != null) {
                    this.f11570c.put(optString2, new tr(optJSONObject));
                }
            }
        }
    }

    public long m14981a() {
        return this.f11568a;
    }

    public boolean m14982b() {
        return this.f11573f;
    }

    public String m14983c() {
        return this.f11572e;
    }

    public String m14984d() {
        return this.f11571d;
    }

    public Map<String, tr> m14985e() {
        return this.f11570c;
    }
}
