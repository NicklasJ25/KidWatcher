package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class eo implements Creator<zzbak> {
    static void m10642a(zzbak com_google_android_gms_internal_zzbak, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzbak.f11851a);
        C2552b.m8132a(parcel, 2, com_google_android_gms_internal_zzbak.m15365b());
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzbak.m15366c(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzbak m10643a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    intent = (Intent) C2551a.m8097a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbak(i2, i, intent);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzbak[] m10644a(int i) {
        return new zzbak[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10643a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10644a(i);
    }
}
