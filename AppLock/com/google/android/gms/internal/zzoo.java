package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public final class zzoo extends zza {
    public static final Creator<zzoo> CREATOR = new ym();
    public final String f12074a;
    public final int f12075b;

    public zzoo(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public zzoo(String str, int i) {
        this.f12074a = str;
        this.f12075b = i;
    }

    @Nullable
    public static zzoo m15393a(@Nullable String str) {
        zzoo com_google_android_gms_internal_zzoo = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                com_google_android_gms_internal_zzoo = m15394a(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return com_google_android_gms_internal_zzoo;
    }

    @Nullable
    public static zzoo m15394a(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new zzoo(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public JSONArray m15395a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.f12074a);
        jSONObject.put("rb_amount", this.f12075b);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzoo)) {
            return false;
        }
        zzoo com_google_android_gms_internal_zzoo = (zzoo) obj;
        return C2512b.m7931a(this.f12074a, com_google_android_gms_internal_zzoo.f12074a) && C2512b.m7931a(Integer.valueOf(this.f12075b), Integer.valueOf(com_google_android_gms_internal_zzoo.f12075b));
    }

    public int hashCode() {
        return C2512b.m7929a(this.f12074a, Integer.valueOf(this.f12075b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        ym.m14926a(this, parcel, i);
    }
}
