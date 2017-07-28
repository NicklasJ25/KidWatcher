package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public final class zzfp extends zza {
    public static final Creator<zzfp> CREATOR = new pp();
    public final int f11906a;
    public final int f11907b;
    public final int f11908c;
    public final int f11909d;
    public final int f11910e;
    public final int f11911f;
    public final int f11912g;
    public final int f11913h;
    public final String f11914i;
    public final int f11915j;
    public final String f11916k;
    public final int f11917l;
    public final int f11918m;
    public final String f11919n;

    zzfp(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, int i9, String str2, int i10, int i11, String str3) {
        this.f11906a = i;
        this.f11907b = i2;
        this.f11908c = i3;
        this.f11909d = i4;
        this.f11910e = i5;
        this.f11911f = i6;
        this.f11912g = i7;
        this.f11913h = i8;
        this.f11914i = str;
        this.f11915j = i9;
        this.f11916k = str2;
        this.f11917l = i10;
        this.f11918m = i11;
        this.f11919n = str3;
    }

    public zzfp(SearchAdRequest searchAdRequest) {
        this.f11906a = searchAdRequest.getAnchorTextColor();
        this.f11907b = searchAdRequest.getBackgroundColor();
        this.f11908c = searchAdRequest.getBackgroundGradientBottom();
        this.f11909d = searchAdRequest.getBackgroundGradientTop();
        this.f11910e = searchAdRequest.getBorderColor();
        this.f11911f = searchAdRequest.getBorderThickness();
        this.f11912g = searchAdRequest.getBorderType();
        this.f11913h = searchAdRequest.getCallButtonColor();
        this.f11914i = searchAdRequest.getCustomChannels();
        this.f11915j = searchAdRequest.getDescriptionTextColor();
        this.f11916k = searchAdRequest.getFontFace();
        this.f11917l = searchAdRequest.getHeaderTextColor();
        this.f11918m = searchAdRequest.getHeaderTextSize();
        this.f11919n = searchAdRequest.getQuery();
    }

    public void writeToParcel(Parcel parcel, int i) {
        pp.m13195a(this, parcel, i);
    }
}
