package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class ww implements Creator<zzmy> {
    static void m14575a(zzmy com_google_android_gms_internal_zzmy, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzmy.f12071a, false);
        C2552b.m8129a(parcel, a);
    }

    public zzmy m14576a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmy(str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzmy[] m14577a(int i) {
        return new zzmy[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14576a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14577a(i);
    }
}
