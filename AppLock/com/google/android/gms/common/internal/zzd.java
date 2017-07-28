package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR = new C2524k();
    final int f7508a;
    final IBinder f7509b;
    final Scope[] f7510c;
    Integer f7511d;
    Integer f7512e;

    zzd(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f7508a = i;
        this.f7509b = iBinder;
        this.f7510c = scopeArr;
        this.f7511d = num;
        this.f7512e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2524k.m8018a(this, parcel, i);
    }
}
