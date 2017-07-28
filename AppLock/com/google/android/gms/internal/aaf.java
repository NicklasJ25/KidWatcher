package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class aaf implements Creator<zzqh> {
    static void m8428a(zzqh com_google_android_gms_internal_zzqh, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzqh.f12081a, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzqh.f12082b);
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzqh.f12083c);
        C2552b.m8144a(parcel, 5, com_google_android_gms_internal_zzqh.f12084d);
        C2552b.m8144a(parcel, 6, com_google_android_gms_internal_zzqh.f12085e);
        C2552b.m8129a(parcel, a);
    }

    public zzqh m8429a(Parcel parcel) {
        boolean z = false;
        int b = C2551a.m8100b(parcel);
        String str = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzqh(str, i2, i, z2, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzqh[] m8430a(int i) {
        return new zzqh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8429a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8430a(i);
    }
}
