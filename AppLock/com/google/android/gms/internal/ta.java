package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import java.util.Arrays;

@wh
class ta {
    private final Object[] f10673a;

    ta(zzec com_google_android_gms_internal_zzec, String str, int i) {
        this.f10673a = zzd.zza((String) qb.aY.m13225c(), com_google_android_gms_internal_zzec, str, i, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ta)) {
            return false;
        }
        return Arrays.equals(this.f10673a, ((ta) obj).f10673a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10673a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f10673a));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
