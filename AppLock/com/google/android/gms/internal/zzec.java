package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

@wh
public final class zzec extends zza {
    public static final Creator<zzec> CREATOR = new of();
    public final int f11877a;
    public final long f11878b;
    public final Bundle f11879c;
    public final int f11880d;
    public final List<String> f11881e;
    public final boolean f11882f;
    public final int f11883g;
    public final boolean f11884h;
    public final String f11885i;
    public final zzfp f11886j;
    public final Location f11887k;
    public final String f11888l;
    public final Bundle f11889m;
    public final Bundle f11890n;
    public final List<String> f11891o;
    public final String f11892p;
    public final String f11893q;
    public final boolean f11894r;

    public zzec(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzfp com_google_android_gms_internal_zzfp, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f11877a = i;
        this.f11878b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f11879c = bundle;
        this.f11880d = i2;
        this.f11881e = list;
        this.f11882f = z;
        this.f11883g = i3;
        this.f11884h = z2;
        this.f11885i = str;
        this.f11886j = com_google_android_gms_internal_zzfp;
        this.f11887k = location;
        this.f11888l = str2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.f11889m = bundle2;
        this.f11890n = bundle3;
        this.f11891o = list2;
        this.f11892p = str3;
        this.f11893q = str4;
        this.f11894r = z3;
    }

    public static void m15380a(zzec com_google_android_gms_internal_zzec) {
        com_google_android_gms_internal_zzec.f11889m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", com_google_android_gms_internal_zzec.f11879c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzec)) {
            return false;
        }
        zzec com_google_android_gms_internal_zzec = (zzec) obj;
        return this.f11877a == com_google_android_gms_internal_zzec.f11877a && this.f11878b == com_google_android_gms_internal_zzec.f11878b && C2512b.m7931a(this.f11879c, com_google_android_gms_internal_zzec.f11879c) && this.f11880d == com_google_android_gms_internal_zzec.f11880d && C2512b.m7931a(this.f11881e, com_google_android_gms_internal_zzec.f11881e) && this.f11882f == com_google_android_gms_internal_zzec.f11882f && this.f11883g == com_google_android_gms_internal_zzec.f11883g && this.f11884h == com_google_android_gms_internal_zzec.f11884h && C2512b.m7931a(this.f11885i, com_google_android_gms_internal_zzec.f11885i) && C2512b.m7931a(this.f11886j, com_google_android_gms_internal_zzec.f11886j) && C2512b.m7931a(this.f11887k, com_google_android_gms_internal_zzec.f11887k) && C2512b.m7931a(this.f11888l, com_google_android_gms_internal_zzec.f11888l) && C2512b.m7931a(this.f11889m, com_google_android_gms_internal_zzec.f11889m) && C2512b.m7931a(this.f11890n, com_google_android_gms_internal_zzec.f11890n) && C2512b.m7931a(this.f11891o, com_google_android_gms_internal_zzec.f11891o) && C2512b.m7931a(this.f11892p, com_google_android_gms_internal_zzec.f11892p) && C2512b.m7931a(this.f11893q, com_google_android_gms_internal_zzec.f11893q) && this.f11894r == com_google_android_gms_internal_zzec.f11894r;
    }

    public int hashCode() {
        return C2512b.m7929a(Integer.valueOf(this.f11877a), Long.valueOf(this.f11878b), this.f11879c, Integer.valueOf(this.f11880d), this.f11881e, Boolean.valueOf(this.f11882f), Integer.valueOf(this.f11883g), Boolean.valueOf(this.f11884h), this.f11885i, this.f11886j, this.f11887k, this.f11888l, this.f11889m, this.f11890n, this.f11891o, this.f11892p, this.f11893q, Boolean.valueOf(this.f11894r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        of.m12901a(this, parcel, i);
    }
}
