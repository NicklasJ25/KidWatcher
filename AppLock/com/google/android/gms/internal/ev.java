package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.common.internal.zzad;

public class ev implements Creator<zzbau> {
    static void m10691a(zzbau com_google_android_gms_internal_zzbau, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzbau.f11861a);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzbau.m15370a(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzbau m10692a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        zzad com_google_android_gms_common_internal_zzad = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    com_google_android_gms_common_internal_zzad = (zzad) C2551a.m8097a(parcel, a, zzad.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbau(i, com_google_android_gms_common_internal_zzad);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzbau[] m10693a(int i) {
        return new zzbau[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10692a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10693a(i);
    }
}
