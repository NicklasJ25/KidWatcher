package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class nu implements Creator<zzds> {
    static void m12859a(zzds com_google_android_gms_internal_zzds, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzds.f11870a, false);
        C2552b.m8133a(parcel, 3, com_google_android_gms_internal_zzds.f11871b);
        C2552b.m8142a(parcel, 4, com_google_android_gms_internal_zzds.f11872c, false);
        C2552b.m8142a(parcel, 5, com_google_android_gms_internal_zzds.f11873d, false);
        C2552b.m8142a(parcel, 6, com_google_android_gms_internal_zzds.f11874e, false);
        C2552b.m8134a(parcel, 7, com_google_android_gms_internal_zzds.f11875f, false);
        C2552b.m8144a(parcel, 8, com_google_android_gms_internal_zzds.f11876g);
        C2552b.m8129a(parcel, a);
    }

    public zzds m12860a(Parcel parcel) {
        Bundle bundle = null;
        int b = C2551a.m8100b(parcel);
        long j = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 4:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                case 8:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzds(str4, j, str3, str2, str, bundle, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzds[] m12861a(int i) {
        return new zzds[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12860a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12861a(i);
    }
}
