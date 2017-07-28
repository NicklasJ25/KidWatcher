package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class eq implements Creator<zzban> {
    static void m10645a(zzban com_google_android_gms_internal_zzban, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzban.f11854a);
        C2552b.m8144a(parcel, 2, com_google_android_gms_internal_zzban.f11855b);
        C2552b.m8153b(parcel, 3, com_google_android_gms_internal_zzban.f11856c, false);
        C2552b.m8129a(parcel, a);
    }

    public zzban m10646a(Parcel parcel) {
        boolean z = false;
        int b = C2551a.m8100b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 3:
                    list = C2551a.m8103c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzban(i, z, list);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzban[] m10647a(int i) {
        return new zzban[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10646a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10647a(i);
    }
}
