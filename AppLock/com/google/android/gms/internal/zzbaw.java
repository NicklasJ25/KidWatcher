package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaf;

public class zzbaw extends zza {
    public static final Creator<zzbaw> CREATOR = new ew();
    final int f11863a;
    private final ConnectionResult f11864b;
    private final zzaf f11865c;

    public zzbaw(int i) {
        this(new ConnectionResult(i, null), null);
    }

    zzbaw(int i, ConnectionResult connectionResult, zzaf com_google_android_gms_common_internal_zzaf) {
        this.f11863a = i;
        this.f11864b = connectionResult;
        this.f11865c = com_google_android_gms_common_internal_zzaf;
    }

    public zzbaw(ConnectionResult connectionResult, zzaf com_google_android_gms_common_internal_zzaf) {
        this(1, connectionResult, com_google_android_gms_common_internal_zzaf);
    }

    public ConnectionResult m15371a() {
        return this.f11864b;
    }

    public zzaf m15372b() {
        return this.f11865c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ew.m10694a(this, parcel, i);
    }
}
