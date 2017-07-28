package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzft extends zza {
    public static final Creator<zzft> CREATOR = new pr();
    public final boolean f11920a;

    public zzft(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted());
    }

    public zzft(boolean z) {
        this.f11920a = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        pr.m13202a(this, parcel, i);
    }
}
