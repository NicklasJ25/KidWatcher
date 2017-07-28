package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.vz.C3381a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@wh
public class wd implements C3381a<qu> {
    private final boolean f11153a;
    private final boolean f11154b;

    public wd(boolean z, boolean z2) {
        this.f11153a = z;
        this.f11154b = z2;
    }

    public /* synthetic */ C3180a mo4181a(vz vzVar, JSONObject jSONObject) {
        return m14474b(vzVar, jSONObject);
    }

    public qu m14474b(vz vzVar, JSONObject jSONObject) {
        View view = null;
        List<aaj> a = vzVar.m14444a(jSONObject, "images", true, this.f11153a, this.f11154b);
        Future a2 = vzVar.m14439a(jSONObject, "secondary_image", false, this.f11153a);
        Future b = vzVar.m14448b(jSONObject);
        aaj a3 = vzVar.m14438a(jSONObject, "video");
        List arrayList = new ArrayList();
        for (aaj com_google_android_gms_internal_aaj : a) {
            arrayList.add((qs) com_google_android_gms_internal_aaj.get());
        }
        aat a4 = vz.m14425a(a3);
        String string = jSONObject.getString("headline");
        String string2 = jSONObject.getString("body");
        rd rdVar = (rd) a2.get();
        String string3 = jSONObject.getString("call_to_action");
        String string4 = jSONObject.getString("advertiser");
        qq qqVar = (qq) b.get();
        Bundle bundle = new Bundle();
        pb z = a4 != null ? a4.mo3448z() : null;
        if (a4 != null) {
            view = a4.mo3405b();
        }
        return new qu(string, arrayList, string2, rdVar, string3, string4, qqVar, bundle, z, view);
    }
}
