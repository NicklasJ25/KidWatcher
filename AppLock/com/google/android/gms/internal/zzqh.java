package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public final class zzqh extends zza {
    public static final Creator<zzqh> CREATOR = new aaf();
    public String f12081a;
    public int f12082b;
    public int f12083c;
    public boolean f12084d;
    public boolean f12085e;

    public zzqh(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzqh(int i, int i2, boolean z, boolean z2) {
        this(i, i2, z, false, z2);
    }

    public zzqh(int i, int i2, boolean z, boolean z2, boolean z3) {
        String valueOf = String.valueOf("afma-sdk-a-v");
        String str = z ? "0" : z2 ? GpsMeasureMode.MODE_2_DIMENSIONAL : "1";
        this(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(str).length()).append(valueOf).append(i).append(".").append(i2).append(".").append(str).toString(), i, i2, z, z3);
    }

    zzqh(String str, int i, int i2, boolean z, boolean z2) {
        this.f12081a = str;
        this.f12082b = i;
        this.f12083c = i2;
        this.f12084d = z;
        this.f12085e = z2;
    }

    public static zzqh m15397a() {
        return new zzqh(10260208, 10260208, true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        aaf.m8428a(this, parcel, i);
    }
}
