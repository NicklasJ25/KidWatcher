package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C2552b;

@wh
public class zzfr extends zzeg {
    public zzfr(zzeg com_google_android_gms_internal_zzeg) {
        super(com_google_android_gms_internal_zzeg.f11895a, com_google_android_gms_internal_zzeg.f11896b, com_google_android_gms_internal_zzeg.f11897c, com_google_android_gms_internal_zzeg.f11898d, com_google_android_gms_internal_zzeg.f11899e, com_google_android_gms_internal_zzeg.f11900f, com_google_android_gms_internal_zzeg.f11901g, com_google_android_gms_internal_zzeg.f11902h, com_google_android_gms_internal_zzeg.f11903i, com_google_android_gms_internal_zzeg.f11904j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, this.a, false);
        C2552b.m8132a(parcel, 3, this.b);
        C2552b.m8132a(parcel, 6, this.e);
        C2552b.m8129a(parcel, a);
    }
}
