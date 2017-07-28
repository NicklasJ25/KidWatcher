package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc extends zza {
    public static final Creator<zzc> CREATOR = new C2564j();
    public final String f7568a;
    public final int f7569b;

    public zzc(String str, int i) {
        this.f7568a = str;
        this.f7569b = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2564j.m8204a(this, parcel, i);
    }
}
