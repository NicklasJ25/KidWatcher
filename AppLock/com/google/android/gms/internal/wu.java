package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class wu implements Creator<zzmv> {
    static void m14555a(zzmv com_google_android_gms_internal_zzmv, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzmv.f12068a, i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzmv m14556a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C2551a.m8097a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmv(parcelFileDescriptor);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzmv[] m14557a(int i) {
        return new zzmv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14556a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14557a(i);
    }
}
