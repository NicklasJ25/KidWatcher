package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class fk extends ml {
    private long f8925i;

    public fk(ez ezVar, String str, String str2, C2711a c2711a, long j, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
        this.f8925i = j;
    }

    protected void mo3587a() {
        long longValue = ((Long) this.f.invoke(null, new Object[0])).longValue();
        synchronized (this.e) {
            this.e.ae = Long.valueOf(longValue);
            if (this.f8925i != 0) {
                this.e.f8058q = Long.valueOf(longValue - this.f8925i);
                this.e.f8063v = Long.valueOf(this.f8925i);
            }
        }
    }
}
