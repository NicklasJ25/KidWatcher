package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@wh
public final class um implements NativeMediationAdRequest {
    private final Date f10885a;
    private final int f10886b;
    private final Set<String> f10887c;
    private final boolean f10888d;
    private final Location f10889e;
    private final int f10890f;
    private final zzhc f10891g;
    private final List<String> f10892h;
    private final boolean f10893i;

    public um(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzhc com_google_android_gms_internal_zzhc, List<String> list, boolean z2) {
        this.f10885a = date;
        this.f10886b = i;
        this.f10887c = set;
        this.f10889e = location;
        this.f10888d = z;
        this.f10890f = i2;
        this.f10891g = com_google_android_gms_internal_zzhc;
        this.f10892h = list;
        this.f10893i = z2;
    }

    public Date getBirthday() {
        return this.f10885a;
    }

    public int getGender() {
        return this.f10886b;
    }

    public Set<String> getKeywords() {
        return this.f10887c;
    }

    public Location getLocation() {
        return this.f10889e;
    }

    public NativeAdOptions getNativeAdOptions() {
        if (this.f10891g == null) {
            return null;
        }
        Builder requestMultipleImages = new Builder().setReturnUrlsForImageAssets(this.f10891g.f11922b).setImageOrientation(this.f10891g.f11923c).setRequestMultipleImages(this.f10891g.f11924d);
        if (this.f10891g.f11921a >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.f10891g.f11925e);
        }
        if (this.f10891g.f11921a >= 3 && this.f10891g.f11926f != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions.Builder().setStartMuted(this.f10891g.f11926f.f11920a).build());
        }
        return requestMultipleImages.build();
    }

    public boolean isAppInstallAdRequested() {
        return this.f10892h != null && this.f10892h.contains(GpsMeasureMode.MODE_2_DIMENSIONAL);
    }

    public boolean isContentAdRequested() {
        return this.f10892h != null && this.f10892h.contains("1");
    }

    public boolean isDesignedForFamilies() {
        return this.f10893i;
    }

    public boolean isTesting() {
        return this.f10888d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f10890f;
    }
}
