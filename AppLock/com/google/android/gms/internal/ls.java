package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.internal.bp.C2711a;
import com.google.android.gms.internal.bp.C2711a.C2710b;

public class ls extends ml {
    private final View f9723i;

    public ls(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2, View view) {
        super(ezVar, str, str2, c2711a, i, i2);
        this.f9723i = view;
    }

    protected void mo3587a() {
        if (this.f9723i != null) {
            fc fcVar = new fc((String) this.f.invoke(null, new Object[]{this.f9723i}));
            synchronized (this.e) {
                this.e.f8040Y = new C2710b();
                this.e.f8040Y.f8015c = fcVar.f8900a;
            }
        }
    }
}
