package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C3563d implements Creator<zzf> {
    static void m15545a(zzf com_google_firebase_database_connection_idl_zzf, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_firebase_database_connection_idl_zzf.f12182a, false);
        C2552b.m8142a(parcel, 3, com_google_firebase_database_connection_idl_zzf.f12183b, false);
        C2552b.m8144a(parcel, 4, com_google_firebase_database_connection_idl_zzf.f12184c);
        C2552b.m8129a(parcel, a);
    }

    public zzf m15546a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        boolean z = false;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str = C2551a.m8115n(parcel, a);
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
            return new zzf(str2, str, z);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzf[] m15547a(int i) {
        return new zzf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15546a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15547a(i);
    }
}
