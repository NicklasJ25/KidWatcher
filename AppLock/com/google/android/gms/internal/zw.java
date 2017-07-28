package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;

@wh
public class zw {
    private long f11750a;
    private long f11751b = Long.MIN_VALUE;
    private Object f11752c = new Object();

    public zw(long j) {
        this.f11750a = j;
    }

    public boolean m15282a() {
        boolean z;
        synchronized (this.f11752c) {
            long b = zzw.zzcS().mo3361b();
            if (this.f11751b + this.f11750a > b) {
                z = false;
            } else {
                this.f11751b = b;
                z = true;
            }
        }
        return z;
    }
}
