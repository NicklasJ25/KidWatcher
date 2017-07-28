package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class xz implements Creator<zzoa> {
    static void m14845a(zzoa com_google_android_gms_internal_zzoa, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzoa.f12072a, i, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzoa.f12073b, false);
        C2552b.m8129a(parcel, a);
    }

    public zzoa m14846a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        zzec com_google_android_gms_internal_zzec = null;
        while (parcel.dataPosition() < b) {
            zzec com_google_android_gms_internal_zzec2;
            String str2;
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    String str3 = str;
                    com_google_android_gms_internal_zzec2 = (zzec) C2551a.m8097a(parcel, a, zzec.CREATOR);
                    str2 = str3;
                    break;
                case 3:
                    str2 = C2551a.m8115n(parcel, a);
                    com_google_android_gms_internal_zzec2 = com_google_android_gms_internal_zzec;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    str2 = str;
                    com_google_android_gms_internal_zzec2 = com_google_android_gms_internal_zzec;
                    break;
            }
            com_google_android_gms_internal_zzec = com_google_android_gms_internal_zzec2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zzoa(com_google_android_gms_internal_zzec, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzoa[] m14847a(int i) {
        return new zzoa[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14846a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14847a(i);
    }
}
