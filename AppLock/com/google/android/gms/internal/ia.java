package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class ia extends ml {
    private static volatile Long f9390i = null;
    private static final Object f9391j = new Object();

    public ia(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        if (f9390i == null) {
            synchronized (f9391j) {
                if (f9390i == null) {
                    f9390i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f8062u = f9390i;
        }
    }
}
