package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzban extends zza {
    public static final Creator<zzban> CREATOR = new eq();
    final int f11854a;
    final boolean f11855b;
    final List<Scope> f11856c;

    zzban(int i, boolean z, List<Scope> list) {
        this.f11854a = i;
        this.f11855b = z;
        this.f11856c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        eq.m10645a(this, parcel, i);
    }
}
