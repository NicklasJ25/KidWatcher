package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class C3570k implements Creator<zzn> {
    static void m15561a(zzn com_google_firebase_database_connection_idl_zzn, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8143a(parcel, 2, com_google_firebase_database_connection_idl_zzn.f12185a, false);
        C2552b.m8143a(parcel, 3, com_google_firebase_database_connection_idl_zzn.f12186b, false);
        C2552b.m8129a(parcel, a);
    }

    public zzn m15562a(Parcel parcel) {
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
            return new zzn(list2, list);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzn[] m15563a(int i) {
        return new zzn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15562a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15563a(i);
    }
}
