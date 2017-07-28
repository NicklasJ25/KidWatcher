package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class pr implements Creator<zzft> {
    static void m13202a(zzft com_google_android_gms_internal_zzft, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8144a(parcel, 2, com_google_android_gms_internal_zzft.f11920a);
        C2552b.m8129a(parcel, a);
    }

    public zzft m13203a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzft(z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzft[] m13204a(int i) {
        return new zzft[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13203a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m13204a(i);
    }
}
