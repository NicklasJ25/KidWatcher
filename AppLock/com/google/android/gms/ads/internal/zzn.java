package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.wh;

@wh
public final class zzn extends zza {
    public static final Creator<zzn> CREATOR = new zzo();
    public final boolean zztK;
    public final boolean zztL;
    public final String zztM;
    public final boolean zztN;
    public final float zztO;
    public final int zztP;

    zzn(boolean z, boolean z2, String str, boolean z3, float f, int i) {
        this.zztK = z;
        this.zztL = z2;
        this.zztM = str;
        this.zztN = z3;
        this.zztO = f;
        this.zztP = i;
    }

    public zzn(boolean z, boolean z2, boolean z3, float f, int i) {
        this(z, z2, null, z3, f, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m7533a(this, parcel, i);
    }
}
