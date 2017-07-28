package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@wh
public final class uh implements MediationAdRequest {
    private final Date f10872a;
    private final int f10873b;
    private final Set<String> f10874c;
    private final boolean f10875d;
    private final Location f10876e;
    private final int f10877f;
    private final boolean f10878g;

    public uh(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.f10872a = date;
        this.f10873b = i;
        this.f10874c = set;
        this.f10876e = location;
        this.f10875d = z;
        this.f10877f = i2;
        this.f10878g = z2;
    }

    public Date getBirthday() {
        return this.f10872a;
    }

    public int getGender() {
        return this.f10873b;
    }

    public Set<String> getKeywords() {
        return this.f10874c;
    }

    public Location getLocation() {
        return this.f10876e;
    }

    public boolean isDesignedForFamilies() {
        return this.f10878g;
    }

    public boolean isTesting() {
        return this.f10875d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f10877f;
    }
}
