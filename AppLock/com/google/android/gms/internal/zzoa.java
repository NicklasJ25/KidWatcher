package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public final class zzoa extends zza {
    public static final Creator<zzoa> CREATOR = new xz();
    public final zzec f12072a;
    public final String f12073b;

    public zzoa(zzec com_google_android_gms_internal_zzec, String str) {
        this.f12072a = com_google_android_gms_internal_zzec;
        this.f12073b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        xz.m14845a(this, parcel, i);
    }
}
