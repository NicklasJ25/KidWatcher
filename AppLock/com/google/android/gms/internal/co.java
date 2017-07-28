package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class co implements Creator<zzatg> {
    static void m9465a(zzatg com_google_android_gms_internal_zzatg, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzatg.f11811a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzatg.f11812b, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzatg.f11813c, false);
        C2552b.m8137a(parcel, 4, com_google_android_gms_internal_zzatg.f11814d, i, false);
        C2552b.m8133a(parcel, 5, com_google_android_gms_internal_zzatg.f11815e);
        C2552b.m8144a(parcel, 6, com_google_android_gms_internal_zzatg.f11816f);
        C2552b.m8142a(parcel, 7, com_google_android_gms_internal_zzatg.f11817g, false);
        C2552b.m8137a(parcel, 8, com_google_android_gms_internal_zzatg.f11818h, i, false);
        C2552b.m8133a(parcel, 9, com_google_android_gms_internal_zzatg.f11819i);
        C2552b.m8137a(parcel, 10, com_google_android_gms_internal_zzatg.f11820j, i, false);
        C2552b.m8133a(parcel, 11, com_google_android_gms_internal_zzatg.f11821k);
        C2552b.m8137a(parcel, 12, com_google_android_gms_internal_zzatg.f11822l, i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzatg m9466a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        zzauq com_google_android_gms_internal_zzauq = null;
        long j = 0;
        boolean z = false;
        String str3 = null;
        zzatq com_google_android_gms_internal_zzatq = null;
        long j2 = 0;
        zzatq com_google_android_gms_internal_zzatq2 = null;
        long j3 = 0;
        zzatq com_google_android_gms_internal_zzatq3 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    com_google_android_gms_internal_zzauq = (zzauq) C2551a.m8097a(parcel, a, zzauq.CREATOR);
                    break;
                case 5:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 6:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 7:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    com_google_android_gms_internal_zzatq = (zzatq) C2551a.m8097a(parcel, a, zzatq.CREATOR);
                    break;
                case 9:
                    j2 = C2551a.m8107f(parcel, a);
                    break;
                case 10:
                    com_google_android_gms_internal_zzatq2 = (zzatq) C2551a.m8097a(parcel, a, zzatq.CREATOR);
                    break;
                case 11:
                    j3 = C2551a.m8107f(parcel, a);
                    break;
                case 12:
                    com_google_android_gms_internal_zzatq3 = (zzatq) C2551a.m8097a(parcel, a, zzatq.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzatg(i, str, str2, com_google_android_gms_internal_zzauq, j, z, str3, com_google_android_gms_internal_zzatq, j2, com_google_android_gms_internal_zzatq2, j3, com_google_android_gms_internal_zzatq3);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzatg[] m9467a(int i) {
        return new zzatg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9466a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9467a(i);
    }
}
