package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.internal.xr.C3439a;

@wh
public class xo extends C3439a {
    private final String f11428a;
    private final int f11429b;

    public xo(String str, int i) {
        this.f11428a = str;
        this.f11429b = i;
    }

    public String mo4195a() {
        return this.f11428a;
    }

    public int mo4196b() {
        return this.f11429b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof xo)) {
            return false;
        }
        xo xoVar = (xo) obj;
        return C2512b.m7931a(mo4195a(), xoVar.mo4195a()) && C2512b.m7931a(Integer.valueOf(mo4196b()), Integer.valueOf(xoVar.mo4196b()));
    }
}
