package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class pd implements Creator<zzfc> {
    static void m13036a(zzfc com_google_android_gms_internal_zzfc, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 2, com_google_android_gms_internal_zzfc.f11905a);
        C2552b.m8129a(parcel, a);
    }

    public zzfc m13037a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzfc(i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzfc[] m13038a(int i) {
        return new zzfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13037a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m13038a(i);
    }
}
