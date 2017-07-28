package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzfc extends zza {
    public static final Creator<zzfc> CREATOR = new pd();
    public final int f11905a;

    public zzfc(int i) {
        this.f11905a = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        pd.m13036a(this, parcel, i);
    }
}
