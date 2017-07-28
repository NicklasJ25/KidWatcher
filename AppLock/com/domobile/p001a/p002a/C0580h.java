package com.domobile.p001a.p002a;

import org.json.JSONObject;

public class C0580h {
    String f387a;
    String f388b;
    String f389c;
    String f390d;
    String f391e;
    String f392f;
    String f393g;

    public C0580h(String str, String str2) {
        this.f387a = str;
        this.f393g = str2;
        JSONObject jSONObject = new JSONObject(this.f393g);
        this.f388b = jSONObject.optString("productId");
        this.f389c = jSONObject.optString("type");
        this.f390d = jSONObject.optString("price");
        this.f391e = jSONObject.optString("title");
        this.f392f = jSONObject.optString("description");
    }

    public String m540a() {
        return this.f387a;
    }

    public String m541b() {
        return this.f388b;
    }

    public String m542c() {
        return this.f390d;
    }

    public String toString() {
        return "SkuDetails:" + this.f393g;
    }
}
