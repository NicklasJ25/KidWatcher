package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2516f implements Creator<zzah> {
    static void m7951a(zzah com_google_android_gms_common_internal_zzah, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzah.f7503a);
        C2552b.m8132a(parcel, 2, com_google_android_gms_common_internal_zzah.m8194a());
        C2552b.m8132a(parcel, 3, com_google_android_gms_common_internal_zzah.m8195b());
        C2552b.m8147a(parcel, 4, com_google_android_gms_common_internal_zzah.m8196c(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzah m7952a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C2551a.m8102b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzah(i3, i2, i, scopeArr);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzah[] m7953a(int i) {
        return new zzah[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7952a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7953a(i);
    }
}
