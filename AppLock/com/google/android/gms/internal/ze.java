package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzw;

@wh
public class ze {
    private final Object f11615a;
    private int f11616b;
    private int f11617c;
    private final zb f11618d;
    private final String f11619e;

    ze(zb zbVar, String str) {
        this.f11615a = new Object();
        this.f11618d = zbVar;
        this.f11619e = str;
    }

    public ze(String str) {
        this(zzw.zzcQ(), str);
    }

    public Bundle m15046a() {
        Bundle bundle;
        synchronized (this.f11615a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f11616b);
            bundle.putInt("pmnll", this.f11617c);
        }
        return bundle;
    }

    public void m15047a(int i, int i2) {
        synchronized (this.f11615a) {
            this.f11616b = i;
            this.f11617c = i2;
            this.f11618d.m14999a(this.f11619e, this);
        }
    }
}
