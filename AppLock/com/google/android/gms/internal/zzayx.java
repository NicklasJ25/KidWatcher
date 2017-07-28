package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class zzayx extends zza implements Comparable<zzayx> {
    public static final Creator<zzayx> CREATOR = new eg();
    public final int f11838a;
    public final zzayz[] f11839b;
    public final String[] f11840c;
    public final Map<String, zzayz> f11841d = new TreeMap();

    public zzayx(int i, zzayz[] com_google_android_gms_internal_zzayzArr, String[] strArr) {
        this.f11838a = i;
        this.f11839b = com_google_android_gms_internal_zzayzArr;
        for (zzayz com_google_android_gms_internal_zzayz : com_google_android_gms_internal_zzayzArr) {
            this.f11841d.put(com_google_android_gms_internal_zzayz.f11843a, com_google_android_gms_internal_zzayz);
        }
        this.f11840c = strArr;
        if (this.f11840c != null) {
            Arrays.sort(this.f11840c);
        }
    }

    public int m15355a(zzayx com_google_android_gms_internal_zzayx) {
        return this.f11838a - com_google_android_gms_internal_zzayx.f11838a;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m15355a((zzayx) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzayx)) {
            return false;
        }
        zzayx com_google_android_gms_internal_zzayx = (zzayx) obj;
        return this.f11838a == com_google_android_gms_internal_zzayx.f11838a && C2512b.m7931a(this.f11841d, com_google_android_gms_internal_zzayx.f11841d) && Arrays.equals(this.f11840c, com_google_android_gms_internal_zzayx.f11840c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Configuration(");
        stringBuilder.append(this.f11838a);
        stringBuilder.append(", ");
        stringBuilder.append("(");
        for (zzayz append : this.f11841d.values()) {
            stringBuilder.append(append);
            stringBuilder.append(", ");
        }
        stringBuilder.append(")");
        stringBuilder.append(", ");
        stringBuilder.append("(");
        if (this.f11840c != null) {
            for (String append2 : this.f11840c) {
                stringBuilder.append(append2);
                stringBuilder.append(", ");
            }
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        eg.m10575a(this, parcel, i);
    }
}
