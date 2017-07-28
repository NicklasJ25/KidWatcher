package com.facebook.ads.internal.p018m;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.p024l.C1675a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class C1722n {
    public static String f4338a = null;
    private String f4339b;
    private Map<String, Object> f4340c;
    private int f4341d;
    private String f4342e;

    public enum C1720a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        int f4334f;

        private C1720a(int i) {
            this.f4334f = i;
        }
    }

    public enum C1721b {
        LOADING_AD(0);
        
        int f4337b;

        private C1721b(int i) {
            this.f4337b = i;
        }
    }

    public C1722n(String str, Map<String, Object> map, int i, String str2) {
        this.f4339b = str;
        this.f4340c = map;
        this.f4341d = i;
        this.f4342e = str2;
    }

    public static C1722n m4938a(long j, C1720a c1720a, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(c1720a.f4334f));
        return new C1722n("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static C1722n m4939a(C1721b c1721b, C1675a c1675a, long j, String str) {
        Map hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(c1721b.f4337b));
        hashMap.put("AdPlacementType", c1675a.toString());
        hashMap.put("Time", String.valueOf(j));
        String str2 = "latency";
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f4338a;
        }
        return new C1722n(str2, hashMap, currentTimeMillis, str);
    }

    public static C1722n m4940a(@Nullable Throwable th, @Nullable String str) {
        Map hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = "error";
        if (str == null) {
            str = f4338a;
        }
        return new C1722n(str2, hashMap, currentTimeMillis, str);
    }

    public JSONObject m4941a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f4339b);
            jSONObject.put("data", new JSONObject(this.f4340c));
            jSONObject.put("time", this.f4341d);
            jSONObject.put("request_id", this.f4342e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
