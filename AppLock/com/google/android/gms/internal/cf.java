package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class cf implements Creator<zzaqk> {
    static void m9298a(zzaqk com_google_android_gms_internal_zzaqk, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzaqk.f11794a);
        C2552b.m8145a(parcel, 2, com_google_android_gms_internal_zzaqk.m15347a(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzaqk m9299a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    bArr = C2551a.m8118q(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaqk(i, bArr);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzaqk[] m9300a(int i) {
        return new zzaqk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9299a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9300a(i);
    }
}
