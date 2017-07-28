package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class lq extends ml {
    public lq(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8030O = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.f.invoke(null, new Object[]{this.b.m10721b()})).booleanValue();
        synchronized (this.e) {
            if (booleanValue) {
                this.e.f8030O = Integer.valueOf(1);
            } else {
                this.e.f8030O = Integer.valueOf(0);
            }
        }
    }
}
