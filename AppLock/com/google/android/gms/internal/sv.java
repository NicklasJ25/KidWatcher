package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzm;

@wh
public class sv {
    private final Context f10610a;
    private final ub f10611b;
    private final zzqh f10612c;
    private final zze f10613d;

    sv(Context context, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this.f10610a = context;
        this.f10611b = ubVar;
        this.f10612c = com_google_android_gms_internal_zzqh;
        this.f10613d = com_google_android_gms_ads_internal_zze;
    }

    public Context m13764a() {
        return this.f10610a.getApplicationContext();
    }

    public zzm m13765a(String str) {
        return new zzm(this.f10610a, new zzeg(), str, this.f10611b, this.f10612c, this.f10613d);
    }

    public zzm m13766b(String str) {
        return new zzm(this.f10610a.getApplicationContext(), new zzeg(), str, this.f10611b, this.f10612c, this.f10613d);
    }

    public sv m13767b() {
        return new sv(m13764a(), this.f10611b, this.f10612c, this.f10613d);
    }
}
