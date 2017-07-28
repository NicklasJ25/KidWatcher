package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class zzor extends zza {
    public static final Creator<zzor> CREATOR = new yo();
    public final String f12076a;
    public final String f12077b;
    public final boolean f12078c;
    public final boolean f12079d;
    public final List<String> f12080e;

    public zzor(String str, String str2, boolean z, boolean z2, List<String> list) {
        this.f12076a = str;
        this.f12077b = str2;
        this.f12078c = z;
        this.f12079d = z2;
        this.f12080e = list;
    }

    @Nullable
    public static zzor m15396a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", "");
        String optString2 = jSONObject.optString("report_url", "");
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        List arrayList = new ArrayList();
        while (i < optJSONArray.length()) {
            Object optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
            i++;
        }
        return new zzor(optString, optString2, optBoolean, optBoolean2, arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        yo.m14929a(this, parcel, i);
    }
}
