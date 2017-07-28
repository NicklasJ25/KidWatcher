package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbnn extends zza {
    public static final Creator<zzbnn> CREATOR = new fn();
    public final int f11866a;
    private String f11867b;
    private String f11868c;

    zzbnn(int i, String str, String str2) {
        this.f11866a = i;
        this.f11867b = str;
        this.f11868c = str2;
    }

    public zzbnn(String str, String str2) {
        this.f11866a = 1;
        this.f11867b = str;
        this.f11868c = str2;
    }

    public String m15373a() {
        return this.f11867b;
    }

    public String m15374b() {
        return this.f11868c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        fn.m10778a(this, parcel, i);
    }
}
