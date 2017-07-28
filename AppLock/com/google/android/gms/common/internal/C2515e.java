package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2515e implements Creator<zzaf> {
    static void m7948a(zzaf com_google_android_gms_common_internal_zzaf, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzaf.f7498a);
        C2552b.m8135a(parcel, 2, com_google_android_gms_common_internal_zzaf.f7499b, false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_common_internal_zzaf.m8191b(), i, false);
        C2552b.m8144a(parcel, 4, com_google_android_gms_common_internal_zzaf.m8192c());
        C2552b.m8144a(parcel, 5, com_google_android_gms_common_internal_zzaf.m8193d());
        C2552b.m8129a(parcel, a);
    }

    public zzaf m7949a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C2551a.m8100b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    iBinder = C2551a.m8116o(parcel, a);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) C2551a.m8097a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 5:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaf(i, iBinder, connectionResult, z2, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzaf[] m7950a(int i) {
        return new zzaf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7949a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7950a(i);
    }
}
