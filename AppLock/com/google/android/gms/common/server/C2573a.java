package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2573a implements Creator<FavaDiagnosticsEntity> {
    static void m8230a(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, favaDiagnosticsEntity.f7533a);
        C2552b.m8142a(parcel, 2, favaDiagnosticsEntity.f7534b, false);
        C2552b.m8132a(parcel, 3, favaDiagnosticsEntity.f7535c);
        C2552b.m8129a(parcel, a);
    }

    public FavaDiagnosticsEntity m8231a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FavaDiagnosticsEntity(i2, str, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public FavaDiagnosticsEntity[] m8232a(int i) {
        return new FavaDiagnosticsEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8231a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8232a(i);
    }
}
