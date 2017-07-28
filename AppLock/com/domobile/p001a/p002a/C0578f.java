package com.domobile.p001a.p002a;

import org.json.JSONObject;

public class C0578f {
    String f377a;
    String f378b;
    String f379c;
    String f380d;
    long f381e;
    int f382f;
    String f383g;
    String f384h;
    String f385i;
    String f386j;

    public C0578f(String str, String str2, String str3) {
        this.f377a = str;
        this.f385i = str2;
        JSONObject jSONObject = new JSONObject(this.f385i);
        this.f378b = jSONObject.optString("orderId");
        this.f379c = jSONObject.optString("packageName");
        this.f380d = jSONObject.optString("productId");
        this.f381e = jSONObject.optLong("purchaseTime");
        this.f382f = jSONObject.optInt("purchaseState");
        this.f383g = jSONObject.optString("developerPayload");
        this.f384h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f386j = str3;
    }

    public String m534a() {
        return this.f377a;
    }

    public String m535b() {
        return this.f380d;
    }

    public String m536c() {
        return this.f384h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f377a + "):" + this.f385i;
    }
}
