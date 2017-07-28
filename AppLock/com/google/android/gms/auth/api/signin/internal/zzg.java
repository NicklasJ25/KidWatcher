package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg extends zza {
    public static final Creator<zzg> CREATOR = new C2422a();
    final int f7222a;
    private int f7223b;
    private Bundle f7224c;

    zzg(int i, int i2, Bundle bundle) {
        this.f7222a = i;
        this.f7223b = i2;
        this.f7224c = bundle;
    }

    public int m7668a() {
        return this.f7223b;
    }

    public Bundle m7669b() {
        return this.f7224c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2422a.m7655a(this, parcel, i);
    }
}
