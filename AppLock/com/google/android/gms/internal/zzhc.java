package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzhc extends zza {
    public static final Creator<zzhc> CREATOR = new rb();
    public final int f11921a;
    public final boolean f11922b;
    public final int f11923c;
    public final boolean f11924d;
    public final int f11925e;
    @Nullable
    public final zzft f11926f;

    public zzhc(int i, boolean z, int i2, boolean z2, int i3, zzft com_google_android_gms_internal_zzft) {
        this.f11921a = i;
        this.f11922b = z;
        this.f11923c = i2;
        this.f11924d = z2;
        this.f11925e = i3;
        this.f11926f = com_google_android_gms_internal_zzft;
    }

    public zzhc(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzft(nativeAdOptions.getVideoOptions()) : null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        rb.m13570a(this, parcel, i);
    }
}
