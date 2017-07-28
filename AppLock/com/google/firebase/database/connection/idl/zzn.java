package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.gr;
import java.util.List;

class zzn extends zza {
    public static final Creator<zzn> CREATOR = new C3570k();
    final List<String> f12185a;
    final List<String> f12186b;

    public zzn(List<String> list, List<String> list2) {
        this.f12185a = list;
        this.f12186b = list2;
    }

    public static gr m15570a(zzn com_google_firebase_database_connection_idl_zzn, Object obj) {
        return new gr(com_google_firebase_database_connection_idl_zzn.f12185a, com_google_firebase_database_connection_idl_zzn.f12186b, obj);
    }

    public static zzn m15571a(gr grVar) {
        return new zzn(grVar.m11210a(), grVar.m11211b());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3570k.m15561a(this, parcel, i);
    }
}
