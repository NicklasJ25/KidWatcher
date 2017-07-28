package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class lp extends ml {
    private static volatile Long f9718i = null;
    private static final Object f9719j = new Object();

    public lp(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        if (f9718i == null) {
            synchronized (f9719j) {
                if (f9718i == null) {
                    f9718i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f8016A = f9718i;
        }
    }
}
