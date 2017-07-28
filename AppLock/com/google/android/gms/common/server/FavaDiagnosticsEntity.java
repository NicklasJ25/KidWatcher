package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class FavaDiagnosticsEntity extends zza implements ReflectedParcelable {
    public static final Creator<FavaDiagnosticsEntity> CREATOR = new C2573a();
    final int f7533a;
    public final String f7534b;
    public final int f7535c;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f7533a = i;
        this.f7534b = str;
        this.f7535c = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2573a.m8230a(this, parcel, i);
    }
}
