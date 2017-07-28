package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzmy extends zza {
    public static final Creator<zzmy> CREATOR = new ww();
    String f12071a;

    public zzmy(String str) {
        this.f12071a = str;
    }

    public String m15392a() {
        return this.f12071a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ww.m14575a(this, parcel, i);
    }
}
