package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzauq extends zza {
    public static final Creator<zzauq> CREATOR = new dw();
    public final int f11830a;
    public final String f11831b;
    public final long f11832c;
    public final Long f11833d;
    public final Float f11834e;
    public final String f11835f;
    public final String f11836g;
    public final Double f11837h;

    zzauq(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.f11830a = i;
        this.f11831b = str;
        this.f11832c = j;
        this.f11833d = l;
        this.f11834e = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.f11837h = d2;
        } else {
            this.f11837h = d;
        }
        this.f11835f = str2;
        this.f11836g = str3;
    }

    zzauq(dx dxVar) {
        this(dxVar.f8703c, dxVar.f8704d, dxVar.f8705e, dxVar.f8702b);
    }

    zzauq(String str, long j, Object obj, String str2) {
        C2513c.m7934a(str);
        this.f11830a = 2;
        this.f11831b = str;
        this.f11832c = j;
        this.f11836g = str2;
        if (obj == null) {
            this.f11833d = null;
            this.f11834e = null;
            this.f11837h = null;
            this.f11835f = null;
        } else if (obj instanceof Long) {
            this.f11833d = (Long) obj;
            this.f11834e = null;
            this.f11837h = null;
            this.f11835f = null;
        } else if (obj instanceof String) {
            this.f11833d = null;
            this.f11834e = null;
            this.f11837h = null;
            this.f11835f = (String) obj;
        } else if (obj instanceof Double) {
            this.f11833d = null;
            this.f11834e = null;
            this.f11837h = (Double) obj;
            this.f11835f = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object m15354a() {
        return this.f11833d != null ? this.f11833d : this.f11837h != null ? this.f11837h : this.f11835f != null ? this.f11835f : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        dw.m10355a(this, parcel, i);
    }
}
