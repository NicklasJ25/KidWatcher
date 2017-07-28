package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;

@wh
public class zzk {
    private final String f6913a;

    public zzk(String str) {
        this.f6913a = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzw.zzda().zze(intent);
        String zzf = zzw.zzda().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzw.zzda().zzaE(zze))) {
            aad.m8426e("Developer payload not match.");
            return false;
        } else if (this.f6913a == null || zzl.zzb(this.f6913a, zze, zzf)) {
            return true;
        } else {
            aad.m8426e("Fail to verify signature.");
            return false;
        }
    }

    public String zziM() {
        return zzw.zzcM().m15151d();
    }
}
