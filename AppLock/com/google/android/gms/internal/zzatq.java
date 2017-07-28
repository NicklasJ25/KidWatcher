package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzatq extends zza {
    public static final Creator<zzatq> CREATOR = new cw();
    public final String f11826a;
    public final zzato f11827b;
    public final String f11828c;
    public final long f11829d;

    zzatq(zzatq com_google_android_gms_internal_zzatq, long j) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        this.f11826a = com_google_android_gms_internal_zzatq.f11826a;
        this.f11827b = com_google_android_gms_internal_zzatq.f11827b;
        this.f11828c = com_google_android_gms_internal_zzatq.f11828c;
        this.f11829d = j;
    }

    public zzatq(String str, zzato com_google_android_gms_internal_zzato, String str2, long j) {
        this.f11826a = str;
        this.f11827b = com_google_android_gms_internal_zzato;
        this.f11828c = str2;
        this.f11829d = j;
    }

    public String toString() {
        String str = this.f11828c;
        String str2 = this.f11826a;
        String valueOf = String.valueOf(this.f11827b);
        return new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        cw.m9656a(this, parcel, i);
    }
}
