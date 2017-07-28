package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C2503v.C2504a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf extends zza {
    public static final Creator<zzaf> CREATOR = new C2515e();
    final int f7498a;
    IBinder f7499b;
    private ConnectionResult f7500c;
    private boolean f7501d;
    private boolean f7502e;

    zzaf(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f7498a = i;
        this.f7499b = iBinder;
        this.f7500c = connectionResult;
        this.f7501d = z;
        this.f7502e = z2;
    }

    public C2503v m8190a() {
        return C2504a.m7910a(this.f7499b);
    }

    public ConnectionResult m8191b() {
        return this.f7500c;
    }

    public boolean m8192c() {
        return this.f7501d;
    }

    public boolean m8193d() {
        return this.f7502e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf com_google_android_gms_common_internal_zzaf = (zzaf) obj;
        return this.f7500c.equals(com_google_android_gms_common_internal_zzaf.f7500c) && m8190a().equals(com_google_android_gms_common_internal_zzaf.m8190a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2515e.m7948a(this, parcel, i);
    }
}
