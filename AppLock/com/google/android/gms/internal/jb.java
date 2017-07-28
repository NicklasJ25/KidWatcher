package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class jb extends ml {
    private long f9487i = -1;

    public jb(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8053l = Long.valueOf(-1);
        if (this.f9487i == -1) {
            this.f9487i = (long) ((Integer) this.f.invoke(null, new Object[]{this.b.m10718a()})).intValue();
        }
        synchronized (this.e) {
            this.e.f8053l = Long.valueOf(this.f9487i);
        }
    }
}
