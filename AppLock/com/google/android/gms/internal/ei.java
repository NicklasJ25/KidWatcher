package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class ei implements Creator<zzayz> {
    static void m10619a(zzayz com_google_android_gms_internal_zzayz, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzayz.f11843a, false);
        C2552b.m8133a(parcel, 3, com_google_android_gms_internal_zzayz.f11844b);
        C2552b.m8144a(parcel, 4, com_google_android_gms_internal_zzayz.f11845c);
        C2552b.m8130a(parcel, 5, com_google_android_gms_internal_zzayz.f11846d);
        C2552b.m8142a(parcel, 6, com_google_android_gms_internal_zzayz.f11847e, false);
        C2552b.m8145a(parcel, 7, com_google_android_gms_internal_zzayz.f11848f, false);
        C2552b.m8132a(parcel, 8, com_google_android_gms_internal_zzayz.f11849g);
        C2552b.m8132a(parcel, 9, com_google_android_gms_internal_zzayz.f11850h);
        C2552b.m8129a(parcel, a);
    }

    public zzayz m10620a(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = C2551a.m8100b(parcel);
        long j = 0;
        double d = 0.0d;
        int i2 = 0;
        String str = null;
        boolean z = false;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 4:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 5:
                    d = C2551a.m8112k(parcel, a);
                    break;
                case 6:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    bArr = C2551a.m8118q(parcel, a);
                    break;
                case 8:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 9:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzayz(str2, j, z, d, str, bArr, i2, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzayz[] m10621a(int i) {
        return new zzayz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10620a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10621a(i);
    }
}
