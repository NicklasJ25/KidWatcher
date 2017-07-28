package com.domobile.applock.p012e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0901f {
    public String f1352a = "";
    public String f1353b = "";
    public String f1354c = "";
    public String f1355d = "";
    public String f1356e = "";
    public String f1357f = "";
    public ArrayList<String> f1358g;

    @NonNull
    public static C0901f m1587a(String str) {
        C0901f c0901f = new C0901f();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0901f.f1352a = jSONObject.optString("action");
                c0901f.f1353b = jSONObject.optString("type");
                c0901f.f1354c = jSONObject.optString("dataString");
                c0901f.f1355d = jSONObject.optString("scheme");
                c0901f.f1356e = jSONObject.optString("className");
                c0901f.f1357f = jSONObject.optString("packageName");
                c0901f.f1358g = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("categoryList");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        c0901f.f1358g.add(optJSONArray.getString(i));
                    }
                }
            } catch (JSONException e) {
            }
        }
        return c0901f;
    }

    public String m1588a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", this.f1352a);
            jSONObject.put("type", this.f1353b);
            jSONObject.put("dataString", this.f1354c);
            jSONObject.put("scheme", this.f1355d);
            jSONObject.put("className", this.f1356e);
            jSONObject.put("packageName", this.f1357f);
            JSONArray jSONArray = new JSONArray();
            if (this.f1358g != null) {
                Iterator it = this.f1358g.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
            }
            jSONObject.put("categoryList", jSONArray);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "PendingIntentInfo{action='" + this.f1352a + '\'' + ", type='" + this.f1353b + '\'' + ", dataString='" + this.f1354c + '\'' + ", scheme='" + this.f1355d + '\'' + ", className='" + this.f1356e + '\'' + ", packageName='" + this.f1357f + '\'' + ", categoryList=" + this.f1358g + '}';
    }
}
