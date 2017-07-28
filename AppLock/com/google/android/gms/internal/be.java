package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacw.zza;
import com.google.android.gms.internal.zzacw.zzb;
import java.util.ArrayList;

public class be implements Creator<zza> {
    static void m9103a(zza com_google_android_gms_internal_zzacw_zza, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacw_zza.f11774a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzacw_zza.f11775b, false);
        C2552b.m8153b(parcel, 3, com_google_android_gms_internal_zzacw_zza.f11776c, false);
        C2552b.m8129a(parcel, a);
    }

    public zza m9104a(Parcel parcel) {
        ArrayList arrayList = null;
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
                    arrayList = C2551a.m8103c(parcel, a, zzb.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i, str, arrayList);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zza[] m9105a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9104a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9105a(i);
    }
}
