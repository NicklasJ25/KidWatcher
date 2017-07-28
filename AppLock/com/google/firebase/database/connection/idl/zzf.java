package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.gn;

class zzf extends zza {
    public static final Creator<zzf> CREATOR = new C3563d();
    final String f12182a;
    final String f12183b;
    final boolean f12184c;

    public zzf(String str, String str2, boolean z) {
        this.f12182a = str;
        this.f12183b = str2;
        this.f12184c = z;
    }

    public static gn m15568a(zzf com_google_firebase_database_connection_idl_zzf) {
        return new gn(com_google_firebase_database_connection_idl_zzf.f12182a, com_google_firebase_database_connection_idl_zzf.f12183b, com_google_firebase_database_connection_idl_zzf.f12184c);
    }

    public static zzf m15569a(gn gnVar) {
        return new zzf(gnVar.m11078a(), gnVar.m11079b(), gnVar.m11080c());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3563d.m15545a(this, parcel, i);
    }
}
