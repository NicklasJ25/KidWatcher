package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class ay implements Creator<zzacn> {
    static void m9077a(zzacn com_google_android_gms_internal_zzacn, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacn.f11754a);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzacn.m15287a(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzacn m9078a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        zzacp com_google_android_gms_internal_zzacp = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    com_google_android_gms_internal_zzacp = (zzacp) C2551a.m8097a(parcel, a, zzacp.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacn(i, com_google_android_gms_internal_zzacp);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzacn[] m9079a(int i) {
        return new zzacn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9078a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9079a(i);
    }
}
