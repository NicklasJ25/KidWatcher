package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class wr implements Creator<zzmr> {
    static void m14546a(zzmr com_google_android_gms_internal_zzmr, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8144a(parcel, 2, com_google_android_gms_internal_zzmr.f12063a);
        C2552b.m8144a(parcel, 3, com_google_android_gms_internal_zzmr.f12064b);
        C2552b.m8144a(parcel, 4, com_google_android_gms_internal_zzmr.f12065c);
        C2552b.m8129a(parcel, a);
    }

    public zzmr m14547a(Parcel parcel) {
        boolean z = false;
        int b = C2551a.m8100b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                case 3:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 4:
                    z = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmr(z3, z2, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzmr[] m14548a(int i) {
        return new zzmr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14547a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14548a(i);
    }
}
