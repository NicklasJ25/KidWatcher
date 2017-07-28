package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gm;
import java.util.ArrayList;
import java.util.List;

class zza extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zza> CREATOR = new C3554a();
    final List<String> f12173a;
    final List<String> f12174b;

    public zza(List<String> list, List<String> list2) {
        this.f12173a = list;
        this.f12174b = list2;
    }

    public static gi m15564a(zza com_google_firebase_database_connection_idl_zza) {
        List arrayList = new ArrayList(com_google_firebase_database_connection_idl_zza.f12173a.size());
        for (String a : com_google_firebase_database_connection_idl_zza.f12173a) {
            arrayList.add(gm.m11074a(a));
        }
        return new gi(arrayList, com_google_firebase_database_connection_idl_zza.f12174b);
    }

    public static zza m15565a(gi giVar) {
        List<List> a = giVar.m11041a();
        List arrayList = new ArrayList(a.size());
        for (List a2 : a) {
            arrayList.add(gm.m11073a(a2));
        }
        return new zza(arrayList, giVar.m11042b());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3554a.m15511a(this, parcel, i);
    }
}
