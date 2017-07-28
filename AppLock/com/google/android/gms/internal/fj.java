package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class fj extends ml {
    private static volatile Long f8923i = null;
    private static final Object f8924j = new Object();

    public fj(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        if (f8923i == null) {
            synchronized (f8924j) {
                if (f8923i == null) {
                    f8923i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f8026K = f8923i;
        }
    }
}
