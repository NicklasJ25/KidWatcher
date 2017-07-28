package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.common.internal.zzaf;

public class ew implements Creator<zzbaw> {
    static void m10694a(zzbaw com_google_android_gms_internal_zzbaw, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzbaw.f11863a);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzbaw.m15371a(), i, false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzbaw.m15372b(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzbaw m10695a(Parcel parcel) {
        zzaf com_google_android_gms_common_internal_zzaf = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int d;
            zzaf com_google_android_gms_common_internal_zzaf2;
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    zzaf com_google_android_gms_common_internal_zzaf3 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    d = C2551a.m8105d(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf3;
                    break;
                case 2:
                    d = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C2551a.m8097a(parcel, a, ConnectionResult.CREATOR);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    com_google_android_gms_common_internal_zzaf2 = (zzaf) C2551a.m8097a(parcel, a, zzaf.CREATOR);
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
            }
            i = d;
            connectionResult = connectionResult2;
            com_google_android_gms_common_internal_zzaf = com_google_android_gms_common_internal_zzaf2;
        }
        if (parcel.dataPosition() == b) {
            return new zzbaw(i, connectionResult, com_google_android_gms_common_internal_zzaf);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzbaw[] m10696a(int i) {
        return new zzbaw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10695a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10696a(i);
    }
}
