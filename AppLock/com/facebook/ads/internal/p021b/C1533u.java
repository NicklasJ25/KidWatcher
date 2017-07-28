package com.facebook.ads.internal.p021b;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.internal.p018m.C1726q;
import com.facebook.ads.internal.p018m.C1727r;
import com.facebook.ads.internal.p018m.C1727r.C1526a;
import com.facebook.ads.internal.p018m.C1729s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1533u implements C1526a {
    private final String f3686a;
    private final String f3687b;
    private final C1726q f3688c;
    private final Collection<String> f3689d;
    private final Map<String, String> f3690e;
    private final String f3691f;
    private final int f3692g;
    private final int f3693h;
    private final int f3694i;
    private final String f3695j;

    private C1533u(String str, String str2, C1726q c1726q, Collection<String> collection, Map<String, String> map, String str3, int i, int i2, int i3, String str4) {
        this.f3686a = str;
        this.f3687b = str2;
        this.f3688c = c1726q;
        this.f3689d = collection;
        this.f3690e = map;
        this.f3691f = str3;
        this.f3692g = i;
        this.f3693h = i2;
        this.f3694i = i3;
        this.f3695j = str4;
    }

    public static C1533u m4166a(Bundle bundle) {
        return new C1533u(C1729s.m4966a(bundle.getByteArray("markup")), null, C1726q.NONE, null, null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"), bundle.getInt("skip_after_seconds", 0), bundle.getString("ct"));
    }

    public static C1533u m4167a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray;
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("request_id");
        String a = C1729s.m4964a(jSONObject, "ct");
        C1726q a2 = C1726q.m4951a(jSONObject.optString("invalidation_behavior"));
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection a3 = C1727r.m4952a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
        }
        int i2 = 1000;
        int parseInt = hashMap.containsKey("viewability_check_initial_delay") ? Integer.parseInt((String) hashMap.get("viewability_check_initial_delay")) : 0;
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        if (hashMap.containsKey("skip_after_seconds")) {
            i = Integer.parseInt((String) hashMap.get("skip_after_seconds"));
        }
        return new C1533u(optString, optString2, a2, a3, hashMap, optString3, parseInt, i2, i, a);
    }

    public static C1533u m4168b(Intent intent) {
        return new C1533u(C1729s.m4966a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), C1726q.NONE, null, null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", 1000), intent.getIntExtra("skipAfterSeconds", 0), intent.getStringExtra("ct"));
    }

    public Collection<String> mo2721A() {
        return this.f3689d;
    }

    public String m4170a() {
        return this.f3686a;
    }

    public void m4171a(Intent intent) {
        intent.putExtra("markup", C1729s.m4974a(this.f3686a));
        intent.putExtra("activation_command", this.f3687b);
        intent.putExtra("request_id", this.f3691f);
        intent.putExtra("viewability_check_initial_delay", this.f3692g);
        intent.putExtra("viewability_check_interval", this.f3693h);
        intent.putExtra("skipAfterSeconds", this.f3694i);
        intent.putExtra("ct", this.f3695j);
    }

    public String m4172b() {
        return this.f3687b;
    }

    public Map<String, String> m4173c() {
        return this.f3690e;
    }

    public String m4174d() {
        return this.f3691f;
    }

    public int m4175e() {
        return this.f3692g;
    }

    public int m4176f() {
        return this.f3693h;
    }

    public Bundle m4177g() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("markup", C1729s.m4974a(this.f3686a));
        bundle.putString("request_id", this.f3691f);
        bundle.putInt("viewability_check_initial_delay", this.f3692g);
        bundle.putInt("viewability_check_interval", this.f3693h);
        bundle.putInt("skip_after_seconds", this.f3694i);
        bundle.putString("ct", this.f3695j);
        return bundle;
    }

    public String mo2704y() {
        return this.f3695j;
    }

    public C1726q mo2722z() {
        return this.f3688c;
    }
}
