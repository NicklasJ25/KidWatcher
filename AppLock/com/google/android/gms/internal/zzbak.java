package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbak extends zza implements C2445g {
    public static final Creator<zzbak> CREATOR = new eo();
    final int f11851a;
    private int f11852b;
    private Intent f11853c;

    public zzbak() {
        this(0, null);
    }

    zzbak(int i, int i2, Intent intent) {
        this.f11851a = i;
        this.f11852b = i2;
        this.f11853c = intent;
    }

    public zzbak(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status mo3313a() {
        return this.f11852b == 0 ? Status.zzazx : Status.zzazB;
    }

    public int m15365b() {
        return this.f11852b;
    }

    public Intent m15366c() {
        return this.f11853c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        eo.m10642a(this, parcel, i);
    }
}
