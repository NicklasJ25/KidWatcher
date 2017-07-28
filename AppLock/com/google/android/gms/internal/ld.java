package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;
import java.util.List;

public class ld extends ml {
    private List<Long> f9696i = null;

    public ld(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8066y = Long.valueOf(-1);
        this.e.f8067z = Long.valueOf(-1);
        if (this.f9696i == null) {
            this.f9696i = (List) this.f.invoke(null, new Object[]{this.b.m10718a()});
        }
        if (this.f9696i != null && this.f9696i.size() == 2) {
            synchronized (this.e) {
                this.e.f8066y = Long.valueOf(((Long) this.f9696i.get(0)).longValue());
                this.e.f8067z = Long.valueOf(((Long) this.f9696i.get(1)).longValue());
            }
        }
    }
}
