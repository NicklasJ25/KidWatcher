package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacs.zza;

public class bb implements Creator<zza> {
    static void m9094a(zza com_google_android_gms_internal_zzacs_zza, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacs_zza.m15296a());
        C2552b.m8132a(parcel, 2, com_google_android_gms_internal_zzacs_zza.m15299b());
        C2552b.m8144a(parcel, 3, com_google_android_gms_internal_zzacs_zza.m15300c());
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzacs_zza.m15301d());
        C2552b.m8144a(parcel, 5, com_google_android_gms_internal_zzacs_zza.m15302e());
        C2552b.m8142a(parcel, 6, com_google_android_gms_internal_zzacs_zza.m15303f(), false);
        C2552b.m8132a(parcel, 7, com_google_android_gms_internal_zzacs_zza.m15304g());
        C2552b.m8142a(parcel, 8, com_google_android_gms_internal_zzacs_zza.m15306i(), false);
        C2552b.m8137a(parcel, 9, com_google_android_gms_internal_zzacs_zza.m15308k(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zza m9095a(Parcel parcel) {
        zzacn com_google_android_gms_internal_zzacn = null;
        int i = 0;
        int b = C2551a.m8100b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i4 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 4:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 8:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    com_google_android_gms_internal_zzacn = (zzacn) C2551a.m8097a(parcel, a, zzacn.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i4, i3, z2, i2, z, str2, i, str, com_google_android_gms_internal_zzacn);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zza[] m9096a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9095a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9096a(i);
    }
}
