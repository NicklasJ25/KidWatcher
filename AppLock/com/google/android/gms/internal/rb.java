package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class rb implements Creator<zzhc> {
    static void m13570a(zzhc com_google_android_gms_internal_zzhc, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzhc.f11921a);
        C2552b.m8144a(parcel, 2, com_google_android_gms_internal_zzhc.f11922b);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzhc.f11923c);
        C2552b.m8144a(parcel, 4, com_google_android_gms_internal_zzhc.f11924d);
        C2552b.m8132a(parcel, 5, com_google_android_gms_internal_zzhc.f11925e);
        C2552b.m8137a(parcel, 6, com_google_android_gms_internal_zzhc.f11926f, i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzhc m13571a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        zzft com_google_android_gms_internal_zzft = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 3:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 5:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 6:
                    com_google_android_gms_internal_zzft = (zzft) C2551a.m8097a(parcel, a, zzft.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzhc(i3, z2, i2, z, i, com_google_android_gms_internal_zzft);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzhc[] m13572a(int i) {
        return new zzhc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13571a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m13572a(i);
    }
}
