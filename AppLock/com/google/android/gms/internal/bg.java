package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class bg implements Creator<zzacz> {
    static void m9108a(zzacz com_google_android_gms_internal_zzacz, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacz.m15340b());
        C2552b.m8136a(parcel, 2, com_google_android_gms_internal_zzacz.m15342c(), false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzacz.m15343d(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzacz m9109a(Parcel parcel) {
        zzacw com_google_android_gms_internal_zzacw = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    parcel2 = C2551a.m8092B(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_internal_zzacw = (zzacw) C2551a.m8097a(parcel, a, zzacw.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacz(i, parcel2, com_google_android_gms_internal_zzacw);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzacz[] m9110a(int i) {
        return new zzacz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9109a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9110a(i);
    }
}
