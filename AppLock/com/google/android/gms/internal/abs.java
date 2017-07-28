package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class abs implements Creator<zzzm> {
    static void m8837a(zzzm com_google_android_gms_internal_zzzm, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzzm.f12086a, i, false);
        C2552b.m8145a(parcel, 3, com_google_android_gms_internal_zzzm.f12087b, false);
        C2552b.m8146a(parcel, 4, com_google_android_gms_internal_zzzm.f12088c, false);
        C2552b.m8148a(parcel, 5, com_google_android_gms_internal_zzzm.f12089d, false);
        C2552b.m8146a(parcel, 6, com_google_android_gms_internal_zzzm.f12090e, false);
        C2552b.m8149a(parcel, 7, com_google_android_gms_internal_zzzm.f12091f, false);
        C2552b.m8144a(parcel, 8, com_google_android_gms_internal_zzzm.f12092g);
        C2552b.m8129a(parcel, a);
    }

    public zzzm m8838a(Parcel parcel) {
        byte[][] bArr = null;
        int b = C2551a.m8100b(parcel);
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        zzzu com_google_android_gms_internal_zzzu = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    com_google_android_gms_internal_zzzu = (zzzu) C2551a.m8097a(parcel, a, zzzu.CREATOR);
                    break;
                case 3:
                    bArr2 = C2551a.m8118q(parcel, a);
                    break;
                case 4:
                    iArr2 = C2551a.m8121t(parcel, a);
                    break;
                case 5:
                    strArr = C2551a.m8127z(parcel, a);
                    break;
                case 6:
                    iArr = C2551a.m8121t(parcel, a);
                    break;
                case 7:
                    bArr = C2551a.m8119r(parcel, a);
                    break;
                case 8:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzzm(com_google_android_gms_internal_zzzu, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzzm[] m8839a(int i) {
        return new zzzm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8838a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8839a(i);
    }
}
