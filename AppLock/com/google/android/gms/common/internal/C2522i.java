package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2522i implements Creator<zzan> {
    static void m8012a(zzan com_google_android_gms_common_internal_zzan, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzan.f7507a);
        C2552b.m8129a(parcel, a);
    }

    public zzan m8013a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzan(i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzan[] m8014a(int i) {
        return new zzan[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8013a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8014a(i);
    }
}
