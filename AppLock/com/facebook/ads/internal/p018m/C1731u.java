package com.facebook.ads.internal.p018m;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1731u {
    private final String f4358a;
    private final String f4359b;
    private final String f4360c;
    private final List<String> f4361d;
    private final String f4362e;
    private final String f4363f;

    private C1731u(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f4358a = str;
        this.f4359b = str2;
        this.f4360c = str3;
        this.f4361d = list;
        this.f4362e = str4;
        this.f4363f = str5;
    }

    public static C1731u m4980a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C1731u(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    public String m4981a() {
        return this.f4358a;
    }

    public String m4982b() {
        return this.f4359b;
    }

    public String m4983c() {
        return this.f4360c;
    }
}
