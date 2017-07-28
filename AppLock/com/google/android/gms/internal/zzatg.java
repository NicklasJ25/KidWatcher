package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzatg extends zza {
    public static final Creator<zzatg> CREATOR = new co();
    public final int f11811a;
    public String f11812b;
    public String f11813c;
    public zzauq f11814d;
    public long f11815e;
    public boolean f11816f;
    public String f11817g;
    public zzatq f11818h;
    public long f11819i;
    public zzatq f11820j;
    public long f11821k;
    public zzatq f11822l;

    zzatg(int i, String str, String str2, zzauq com_google_android_gms_internal_zzauq, long j, boolean z, String str3, zzatq com_google_android_gms_internal_zzatq, long j2, zzatq com_google_android_gms_internal_zzatq2, long j3, zzatq com_google_android_gms_internal_zzatq3) {
        this.f11811a = i;
        this.f11812b = str;
        this.f11813c = str2;
        this.f11814d = com_google_android_gms_internal_zzauq;
        this.f11815e = j;
        this.f11816f = z;
        this.f11817g = str3;
        this.f11818h = com_google_android_gms_internal_zzatq;
        this.f11819i = j2;
        this.f11820j = com_google_android_gms_internal_zzatq2;
        this.f11821k = j3;
        this.f11822l = com_google_android_gms_internal_zzatq3;
    }

    zzatg(zzatg com_google_android_gms_internal_zzatg) {
        this.f11811a = 1;
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        this.f11812b = com_google_android_gms_internal_zzatg.f11812b;
        this.f11813c = com_google_android_gms_internal_zzatg.f11813c;
        this.f11814d = com_google_android_gms_internal_zzatg.f11814d;
        this.f11815e = com_google_android_gms_internal_zzatg.f11815e;
        this.f11816f = com_google_android_gms_internal_zzatg.f11816f;
        this.f11817g = com_google_android_gms_internal_zzatg.f11817g;
        this.f11818h = com_google_android_gms_internal_zzatg.f11818h;
        this.f11819i = com_google_android_gms_internal_zzatg.f11819i;
        this.f11820j = com_google_android_gms_internal_zzatg.f11820j;
        this.f11821k = com_google_android_gms_internal_zzatg.f11821k;
        this.f11822l = com_google_android_gms_internal_zzatg.f11822l;
    }

    zzatg(String str, String str2, zzauq com_google_android_gms_internal_zzauq, long j, boolean z, String str3, zzatq com_google_android_gms_internal_zzatq, long j2, zzatq com_google_android_gms_internal_zzatq2, long j3, zzatq com_google_android_gms_internal_zzatq3) {
        this.f11811a = 1;
        this.f11812b = str;
        this.f11813c = str2;
        this.f11814d = com_google_android_gms_internal_zzauq;
        this.f11815e = j;
        this.f11816f = z;
        this.f11817g = str3;
        this.f11818h = com_google_android_gms_internal_zzatq;
        this.f11819i = j2;
        this.f11820j = com_google_android_gms_internal_zzatq2;
        this.f11821k = j3;
        this.f11822l = com_google_android_gms_internal_zzatq3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        co.m9465a(this, parcel, i);
    }
}
