package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacs.zza;
import com.google.android.gms.internal.zzacw.zzb;

public class bc implements Creator<zzb> {
    static void m9097a(zzb com_google_android_gms_internal_zzacw_zzb, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacw_zzb.f11777a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzacw_zzb.f11778b, false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzacw_zzb.f11779c, i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzb m9098a(Parcel parcel) {
        zza com_google_android_gms_internal_zzacs_zza = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str = null;
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
                    com_google_android_gms_internal_zzacs_zza = (zza) C2551a.m8097a(parcel, a, zza.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzb(i, str, com_google_android_gms_internal_zzacs_zza);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzb[] m9099a(int i) {
        return new zzb[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9098a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9099a(i);
    }
}
