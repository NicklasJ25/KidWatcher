package com.facebook.ads.internal.p028g;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1572a {
    private final String f3864a;
    private final JSONObject f3865b;
    private final Map<C1582h, List<String>> f3866c = new HashMap();

    public C1572a(String str, JSONObject jSONObject, @Nullable JSONArray jSONArray) {
        this.f3864a = str;
        this.f3865b = jSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            int i;
            for (Object put : C1582h.values()) {
                this.f3866c.put(put, new LinkedList());
            }
            for (i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("type");
                    CharSequence string2 = jSONObject2.getString("url");
                    C1582h valueOf = C1582h.valueOf(string.toUpperCase(Locale.US));
                    if (!(valueOf == null || TextUtils.isEmpty(string2))) {
                        ((List) this.f3866c.get(valueOf)).add(string2);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public String m4376a() {
        return this.f3864a;
    }

    public List<String> m4377a(C1582h c1582h) {
        return (List) this.f3866c.get(c1582h);
    }

    public JSONObject m4378b() {
        return this.f3865b;
    }
}
