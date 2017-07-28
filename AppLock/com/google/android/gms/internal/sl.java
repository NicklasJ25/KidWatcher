package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class sl implements sc {
    private final Object f10579a = new Object();
    private final Map<String, C3240a> f10580b = new HashMap();

    public interface C3240a {
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        map.get("fail_reason");
        String str3 = (String) map.get("result");
        synchronized (this.f10579a) {
            if (((C3240a) this.f10580b.remove(str)) == null) {
                str2 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                aad.m8426e(str.length() != 0 ? str2.concat(str) : new String(str2));
            } else if (!TextUtils.isEmpty(str2)) {
            } else if (str3 == null) {
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        }
    }
}
