package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class oh implements Creator<zzeg> {
    static void m12907a(zzeg com_google_android_gms_internal_zzeg, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzeg.f11895a, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzeg.f11896b);
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzeg.f11897c);
        C2552b.m8144a(parcel, 5, com_google_android_gms_internal_zzeg.f11898d);
        C2552b.m8132a(parcel, 6, com_google_android_gms_internal_zzeg.f11899e);
        C2552b.m8132a(parcel, 7, com_google_android_gms_internal_zzeg.f11900f);
        C2552b.m8147a(parcel, 8, com_google_android_gms_internal_zzeg.f11901g, i, false);
        C2552b.m8144a(parcel, 9, com_google_android_gms_internal_zzeg.f11902h);
        C2552b.m8144a(parcel, 10, com_google_android_gms_internal_zzeg.f11903i);
        C2552b.m8144a(parcel, 11, com_google_android_gms_internal_zzeg.f11904j);
        C2552b.m8129a(parcel, a);
    }

    public zzeg m12908a(Parcel parcel) {
        zzeg[] com_google_android_gms_internal_zzegArr = null;
        boolean z = false;
        int b = C2551a.m8100b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    i4 = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    z4 = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 7:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 8:
                    com_google_android_gms_internal_zzegArr = (zzeg[]) C2551a.m8102b(parcel, a, zzeg.CREATOR);
                    break;
                case 9:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                case 10:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 11:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzeg(str, i4, i3, z4, i2, i, com_google_android_gms_internal_zzegArr, z3, z2, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzeg[] m12909a(int i) {
        return new zzeg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12908a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12909a(i);
    }
}
