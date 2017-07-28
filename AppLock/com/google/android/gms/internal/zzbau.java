package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzad;

public class zzbau extends zza {
    public static final Creator<zzbau> CREATOR = new ev();
    final int f11861a;
    final zzad f11862b;

    zzbau(int i, zzad com_google_android_gms_common_internal_zzad) {
        this.f11861a = i;
        this.f11862b = com_google_android_gms_common_internal_zzad;
    }

    public zzbau(zzad com_google_android_gms_common_internal_zzad) {
        this(1, com_google_android_gms_common_internal_zzad);
    }

    public zzad m15370a() {
        return this.f11862b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ev.m10691a(this, parcel, i);
    }
}
