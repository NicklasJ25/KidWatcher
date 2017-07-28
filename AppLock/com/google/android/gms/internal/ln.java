package com.google.android.gms.internal;

import com.google.android.gms.internal.bp.C2711a;

public class ln extends ml {
    private final StackTraceElement[] f9717i;

    public ln(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(ezVar, str, str2, c2711a, i, i2);
        this.f9717i = stackTraceElementArr;
    }

    protected void mo3587a() {
        if (this.f9717i != null) {
            ex exVar = new ex((String) this.f.invoke(null, new Object[]{this.f9717i}));
            synchronized (this.e) {
                this.e.f8027L = exVar.f8858a;
                if (exVar.f8859b.booleanValue()) {
                    this.e.f8037V = Integer.valueOf(exVar.f8860c.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
