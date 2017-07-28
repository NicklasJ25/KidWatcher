package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public final class zzmp extends zza {
    public static final Creator<zzmp> CREATOR = new wq();
    public final boolean f12061a;
    @Nullable
    public final List<String> f12062b;

    public zzmp() {
        this(false, Collections.emptyList());
    }

    public zzmp(boolean z) {
        this(z, Collections.emptyList());
    }

    public zzmp(boolean z, List<String> list) {
        this.f12061a = z;
        this.f12062b = list;
    }

    @Nullable
    public static zzmp m15388a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzmp();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Throwable e) {
                    aad.m8424c("Error grabbing url from json.", e);
                }
            }
        }
        return new zzmp(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        wq.m14543a(this, parcel, i);
    }
}
