package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@wh
public final class oe {
    private long f10066a;
    private Bundle f10067b;
    private int f10068c;
    private List<String> f10069d;
    private boolean f10070e;
    private int f10071f;
    private boolean f10072g;
    private String f10073h;
    private zzfp f10074i;
    private Location f10075j;
    private String f10076k;
    private Bundle f10077l;
    private Bundle f10078m;
    private List<String> f10079n;
    private String f10080o;
    private String f10081p;
    private boolean f10082q;

    public oe() {
        this.f10066a = -1;
        this.f10067b = new Bundle();
        this.f10068c = -1;
        this.f10069d = new ArrayList();
        this.f10070e = false;
        this.f10071f = -1;
        this.f10072g = false;
        this.f10073h = null;
        this.f10074i = null;
        this.f10075j = null;
        this.f10076k = null;
        this.f10077l = new Bundle();
        this.f10078m = new Bundle();
        this.f10079n = new ArrayList();
        this.f10080o = null;
        this.f10081p = null;
        this.f10082q = false;
    }

    public oe(zzec com_google_android_gms_internal_zzec) {
        this.f10066a = com_google_android_gms_internal_zzec.f11878b;
        this.f10067b = com_google_android_gms_internal_zzec.f11879c;
        this.f10068c = com_google_android_gms_internal_zzec.f11880d;
        this.f10069d = com_google_android_gms_internal_zzec.f11881e;
        this.f10070e = com_google_android_gms_internal_zzec.f11882f;
        this.f10071f = com_google_android_gms_internal_zzec.f11883g;
        this.f10072g = com_google_android_gms_internal_zzec.f11884h;
        this.f10073h = com_google_android_gms_internal_zzec.f11885i;
        this.f10074i = com_google_android_gms_internal_zzec.f11886j;
        this.f10075j = com_google_android_gms_internal_zzec.f11887k;
        this.f10076k = com_google_android_gms_internal_zzec.f11888l;
        this.f10077l = com_google_android_gms_internal_zzec.f11889m;
        this.f10078m = com_google_android_gms_internal_zzec.f11890n;
        this.f10079n = com_google_android_gms_internal_zzec.f11891o;
        this.f10080o = com_google_android_gms_internal_zzec.f11892p;
        this.f10081p = com_google_android_gms_internal_zzec.f11893q;
    }

    public oe m12899a(@Nullable Location location) {
        this.f10075j = location;
        return this;
    }

    public zzec m12900a() {
        return new zzec(7, this.f10066a, this.f10067b, this.f10068c, this.f10069d, this.f10070e, this.f10071f, this.f10072g, this.f10073h, this.f10074i, this.f10075j, this.f10076k, this.f10077l, this.f10078m, this.f10079n, this.f10080o, this.f10081p, false);
    }
}
