package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class dw implements Creator<zzauq> {
    static void m10355a(zzauq com_google_android_gms_internal_zzauq, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzauq.f11830a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzauq.f11831b, false);
        C2552b.m8133a(parcel, 3, com_google_android_gms_internal_zzauq.f11832c);
        C2552b.m8141a(parcel, 4, com_google_android_gms_internal_zzauq.f11833d, false);
        C2552b.m8139a(parcel, 5, com_google_android_gms_internal_zzauq.f11834e, false);
        C2552b.m8142a(parcel, 6, com_google_android_gms_internal_zzauq.f11835f, false);
        C2552b.m8142a(parcel, 7, com_google_android_gms_internal_zzauq.f11836g, false);
        C2552b.m8138a(parcel, 8, com_google_android_gms_internal_zzauq.f11837h, false);
        C2552b.m8129a(parcel, a);
    }

    public zzauq m10356a(Parcel parcel) {
        Double d = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 4:
                    l = C2551a.m8108g(parcel, a);
                    break;
                case 5:
                    f = C2551a.m8111j(parcel, a);
                    break;
                case 6:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    d = C2551a.m8113l(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzauq(i, str3, j, l, f, str2, str, d);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzauq[] m10357a(int i) {
        return new zzauq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10356a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10357a(i);
    }
}
