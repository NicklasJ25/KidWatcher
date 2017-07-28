package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.vz.C3381a;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class we implements C3381a<qv> {
    private final boolean f11155a;

    public we(boolean z) {
        this.f11155a = z;
    }

    private <K, V> SimpleArrayMap<K, V> m14475a(SimpleArrayMap<K, Future<V>> simpleArrayMap) {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap();
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            simpleArrayMap2.put(simpleArrayMap.keyAt(i), ((Future) simpleArrayMap.valueAt(i)).get());
        }
        return simpleArrayMap2;
    }

    private void m14476a(vz vzVar, JSONObject jSONObject, SimpleArrayMap<String, Future<qs>> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), vzVar.m14445a(jSONObject, "image_value", this.f11155a));
    }

    private void m14477a(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    public /* synthetic */ C3180a mo4181a(vz vzVar, JSONObject jSONObject) {
        return m14479b(vzVar, jSONObject);
    }

    public qv m14479b(vz vzVar, JSONObject jSONObject) {
        String valueOf;
        View view = null;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        Future b = vzVar.m14448b(jSONObject);
        aaj a = vzVar.m14438a(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                m14477a(jSONObject2, simpleArrayMap2);
            } else if ("image".equals(string)) {
                m14476a(vzVar, jSONObject2, simpleArrayMap);
            } else {
                String str = "Unknown custom asset type: ";
                valueOf = String.valueOf(string);
                aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        aat a2 = vz.m14425a(a);
        valueOf = jSONObject.getString("custom_template_id");
        simpleArrayMap = m14475a(simpleArrayMap);
        qq qqVar = (qq) b.get();
        pb z = a2 != null ? a2.mo3448z() : null;
        if (a2 != null) {
            view = a2.mo3405b();
        }
        return new qv(valueOf, simpleArrayMap, simpleArrayMap2, qqVar, z, view);
    }
}
