package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class cw implements Creator<zzatq> {
    static void m9656a(zzatq com_google_android_gms_internal_zzatq, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzatq.f11826a, false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzatq.f11827b, i, false);
        C2552b.m8142a(parcel, 4, com_google_android_gms_internal_zzatq.f11828c, false);
        C2552b.m8133a(parcel, 5, com_google_android_gms_internal_zzatq.f11829d);
        C2552b.m8129a(parcel, a);
    }

    public zzatq m9657a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        long j = 0;
        zzato com_google_android_gms_internal_zzato = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_internal_zzato = (zzato) C2551a.m8097a(parcel, a, zzato.CREATOR);
                    break;
                case 4:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    j = C2551a.m8107f(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzatq(str2, com_google_android_gms_internal_zzato, str, j);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzatq[] m9658a(int i) {
        return new zzatq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9657a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9658a(i);
    }
}
