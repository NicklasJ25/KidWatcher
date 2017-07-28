package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.xk.C3438a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@wh
public class wy {
    @Nullable
    public Bundle f11222a;
    @Nullable
    public Bundle f11223b;
    @Nullable
    public List<String> f11224c = new ArrayList();
    @Nullable
    public Location f11225d;
    @Nullable
    public C3438a f11226e;
    @Nullable
    public String f11227f;
    @Nullable
    public String f11228g;
    @Nullable
    public Info f11229h;
    public zzmk f11230i;
    public xg f11231j;
    public JSONObject f11232k = new JSONObject();

    public wy m14583a(Location location) {
        this.f11225d = location;
        return this;
    }

    public wy m14584a(Bundle bundle) {
        this.f11223b = bundle;
        return this;
    }

    public wy m14585a(Info info) {
        this.f11229h = info;
        return this;
    }

    public wy m14586a(xg xgVar) {
        this.f11231j = xgVar;
        return this;
    }

    public wy m14587a(C3438a c3438a) {
        this.f11226e = c3438a;
        return this;
    }

    public wy m14588a(zzmk com_google_android_gms_internal_zzmk) {
        this.f11230i = com_google_android_gms_internal_zzmk;
        return this;
    }

    public wy m14589a(String str) {
        this.f11228g = str;
        return this;
    }

    public wy m14590a(List<String> list) {
        if (list == null) {
            this.f11224c.clear();
        }
        this.f11224c = list;
        return this;
    }

    public wy m14591a(JSONObject jSONObject) {
        this.f11232k = jSONObject;
        return this;
    }

    public wy m14592b(Bundle bundle) {
        this.f11222a = bundle;
        return this;
    }

    public wy m14593b(String str) {
        this.f11227f = str;
        return this;
    }
}
