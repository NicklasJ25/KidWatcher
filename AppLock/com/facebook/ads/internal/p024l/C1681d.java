package com.facebook.ads.internal.p024l;

import android.text.TextUtils;
import com.facebook.ads.internal.p024l.C1683e.C1682a;
import com.facebook.ads.internal.p028g.C1572a;
import com.facebook.ads.internal.p028g.C1576d;
import com.facebook.ads.internal.p028g.C1577e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1681d {
    private static C1681d f4174a = new C1681d();

    public static synchronized C1681d m4792a() {
        C1681d c1681d;
        synchronized (C1681d.class) {
            c1681d = f4174a;
        }
        return c1681d;
    }

    private C1684f m4793a(JSONObject jSONObject) {
        int i = 0;
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        C1576d c1576d = new C1576d(C1577e.m4387a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                c1576d.m4384a(new C1572a(jSONObject3.optString("adapter"), jSONObject3.optJSONObject("data"), jSONObject3.optJSONArray("trackers")));
                i++;
            }
        }
        return new C1684f(c1576d);
    }

    private C1685g m4794b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
            return new C1685g(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), new C1576d(C1577e.m4387a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config")));
        } catch (JSONException e) {
            return m4795c(jSONObject);
        }
    }

    private C1685g m4795c(JSONObject jSONObject) {
        return new C1685g(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), null);
    }

    public C1683e m4796a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            Object obj = -1;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals("error")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return m4793a(jSONObject);
                case 1:
                    return m4794b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    if (optJSONObject != null) {
                        return m4795c(optJSONObject);
                    }
                    break;
            }
        }
        return new C1683e(C1682a.UNKNOWN, null);
    }
}
