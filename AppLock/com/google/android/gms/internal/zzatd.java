package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzatd extends zza {
    public static final Creator<zzatd> CREATOR = new cm();
    public final String f11797a;
    public final String f11798b;
    public final String f11799c;
    public final String f11800d;
    public final long f11801e;
    public final long f11802f;
    public final String f11803g;
    public final boolean f11804h;
    public final boolean f11805i;
    public final long f11806j;
    public final String f11807k;
    public final long f11808l;
    public final long f11809m;
    public final int f11810n;

    zzatd(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i) {
        C2513c.m7934a(str);
        this.f11797a = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.f11798b = str2;
        this.f11799c = str3;
        this.f11806j = j;
        this.f11800d = str4;
        this.f11801e = j2;
        this.f11802f = j3;
        this.f11803g = str5;
        this.f11804h = z;
        this.f11805i = z2;
        this.f11807k = str6;
        this.f11808l = j4;
        this.f11809m = j5;
        this.f11810n = i;
    }

    zzatd(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i) {
        this.f11797a = str;
        this.f11798b = str2;
        this.f11799c = str3;
        this.f11806j = j3;
        this.f11800d = str4;
        this.f11801e = j;
        this.f11802f = j2;
        this.f11803g = str5;
        this.f11804h = z;
        this.f11805i = z2;
        this.f11807k = str6;
        this.f11808l = j4;
        this.f11809m = j5;
        this.f11810n = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cm.m9444a(this, parcel, i);
    }
}
