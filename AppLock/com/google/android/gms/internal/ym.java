package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class ym implements Creator<zzoo> {
    static void m14926a(zzoo com_google_android_gms_internal_zzoo, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzoo.f12074a, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzoo.f12075b);
        C2552b.m8129a(parcel, a);
    }

    public zzoo m14927a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
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
            return new zzoo(str, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzoo[] m14928a(int i) {
        return new zzoo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14927a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14928a(i);
    }
}
