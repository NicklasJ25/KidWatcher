package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacp.zza;

public class ba implements Creator<zza> {
    static void m9091a(zza com_google_android_gms_internal_zzacp_zza, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacp_zza.f11756a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzacp_zza.f11757b, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzacp_zza.f11758c);
        C2552b.m8129a(parcel, a);
    }

    public zza m9092a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i2, str, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zza[] m9093a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9092a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9093a(i);
    }
}
