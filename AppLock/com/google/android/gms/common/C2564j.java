package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2564j implements Creator<zzc> {
    static void m8204a(zzc com_google_android_gms_common_zzc, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 1, com_google_android_gms_common_zzc.f7568a, false);
        C2552b.m8132a(parcel, 2, com_google_android_gms_common_zzc.f7569b);
        C2552b.m8129a(parcel, a);
    }

    public zzc m8205a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 2:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzc(str, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzc[] m8206a(int i) {
        return new zzc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8205a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8206a(i);
    }
}
