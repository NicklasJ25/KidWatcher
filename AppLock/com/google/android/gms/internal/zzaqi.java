package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzaqi extends zza {
    public static final Creator<zzaqi> CREATOR = new ce();
    public final int f11791a;
    public final String f11792b;
    public final String f11793c;

    zzaqi(int i, String str, String str2) {
        this.f11791a = i;
        this.f11792b = str;
        this.f11793c = str2;
    }

    public zzaqi(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ce.m9295a(this, parcel, i);
    }
}
