package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class zzo implements Creator<zzn> {
    static void m7533a(zzn com_google_android_gms_ads_internal_zzn, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8144a(parcel, 2, com_google_android_gms_ads_internal_zzn.zztK);
        C2552b.m8144a(parcel, 3, com_google_android_gms_ads_internal_zzn.zztL);
        C2552b.m8142a(parcel, 4, com_google_android_gms_ads_internal_zzn.zztM, false);
        C2552b.m8144a(parcel, 5, com_google_android_gms_ads_internal_zzn.zztN);
        C2552b.m8131a(parcel, 6, com_google_android_gms_ads_internal_zzn.zztO);
        C2552b.m8132a(parcel, 7, com_google_android_gms_ads_internal_zzn.zztP);
        C2552b.m8129a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzi(i);
    }

    public zzn zzb(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                case 3:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 4:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    f = C2551a.m8110i(parcel, a);
                    break;
                case 7:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzn(z3, z2, str, z, f, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzn[] zzi(int i) {
        return new zzn[i];
    }
}
