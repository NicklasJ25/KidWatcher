package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.vz.C3381a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@wh
public class wb implements C3381a<qt> {
    private final boolean f11140a;
    private final boolean f11141b;

    public wb(boolean z, boolean z2) {
        this.f11140a = z;
        this.f11141b = z2;
    }

    public /* synthetic */ C3180a mo4181a(vz vzVar, JSONObject jSONObject) {
        return m14467b(vzVar, jSONObject);
    }

    public qt m14467b(vz vzVar, JSONObject jSONObject) {
        List<aaj> a = vzVar.m14444a(jSONObject, "images", true, this.f11140a, this.f11141b);
        Future a2 = vzVar.m14439a(jSONObject, "app_icon", true, this.f11140a);
        aaj a3 = vzVar.m14438a(jSONObject, "video");
        Future b = vzVar.m14448b(jSONObject);
        List arrayList = new ArrayList();
        for (aaj com_google_android_gms_internal_aaj : a) {
            arrayList.add((qs) com_google_android_gms_internal_aaj.get());
        }
        aat a4 = vz.m14425a(a3);
        return new qt(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (rd) a2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (qq) b.get(), new Bundle(), a4 != null ? a4.mo3448z() : null, a4 != null ? a4.mo3405b() : null);
    }
}
