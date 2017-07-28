package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah extends zza {
    public static final Creator<zzah> CREATOR = new C2516f();
    final int f7503a;
    private final int f7504b;
    private final int f7505c;
    @Deprecated
    private final Scope[] f7506d;

    zzah(int i, int i2, int i3, Scope[] scopeArr) {
        this.f7503a = i;
        this.f7504b = i2;
        this.f7505c = i3;
        this.f7506d = scopeArr;
    }

    public int m8194a() {
        return this.f7504b;
    }

    public int m8195b() {
        return this.f7505c;
    }

    @Deprecated
    public Scope[] m8196c() {
        return this.f7506d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2516f.m7951a(this, parcel, i);
    }
}
