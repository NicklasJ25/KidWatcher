package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzan extends zza {
    public static final Creator<zzan> CREATOR = new C2522i();
    final int f7507a;

    zzan(int i) {
        this.f7507a = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2522i.m8012a(this, parcel, i);
    }
}
