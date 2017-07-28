package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class C3555b implements Creator<zzc> {
    static void m15514a(zzc com_google_firebase_database_connection_idl_zzc, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8137a(parcel, 2, com_google_firebase_database_connection_idl_zzc.f12176a, i, false);
        C2552b.m8132a(parcel, 3, com_google_firebase_database_connection_idl_zzc.f12177b);
        C2552b.m8143a(parcel, 4, com_google_firebase_database_connection_idl_zzc.f12178c, false);
        C2552b.m8144a(parcel, 5, com_google_firebase_database_connection_idl_zzc.f12179d);
        C2552b.m8142a(parcel, 6, com_google_firebase_database_connection_idl_zzc.f12180e, false);
        C2552b.m8142a(parcel, 7, com_google_firebase_database_connection_idl_zzc.f12181f, false);
        C2552b.m8129a(parcel, a);
    }

    public zzc m15515a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = C2551a.m8100b(parcel);
        String str2 = null;
        List list = null;
        int i = 0;
        zzf com_google_firebase_database_connection_idl_zzf = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    com_google_firebase_database_connection_idl_zzf = (zzf) C2551a.m8097a(parcel, a, zzf.CREATOR);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    list = C2551a.m8091A(parcel, a);
                    break;
                case 5:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzc(com_google_firebase_database_connection_idl_zzf, i, list, z, str2, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzc[] m15516a(int i) {
        return new zzc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15515a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15516a(i);
    }
}
