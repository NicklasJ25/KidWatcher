package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class C3554a implements Creator<zza> {
    static void m15511a(zza com_google_firebase_database_connection_idl_zza, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8143a(parcel, 2, com_google_firebase_database_connection_idl_zza.f12173a, false);
        C2552b.m8143a(parcel, 3, com_google_firebase_database_connection_idl_zza.f12174b, false);
        C2552b.m8129a(parcel, a);
    }

    public zza m15512a(Parcel parcel) {
        List list = null;
        int b = C2551a.m8100b(parcel);
        List list2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    list2 = C2551a.m8091A(parcel, a);
                    break;
                case 3:
                    list = C2551a.m8091A(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(list2, list);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zza[] m15513a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15512a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15513a(i);
    }
}
