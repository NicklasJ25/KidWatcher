package com.google.android.gms.internal;

import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;

@wh
public class vu extends zg {
    private final C2360a f11039a;
    private final zzmn f11040b = this.f11041c.f11510b;
    private final C3457a f11041c;

    public vu(C3457a c3457a, C2360a c2360a) {
        this.f11041c = c3457a;
        this.f11039a = c2360a;
    }

    private yy m14378a(int i) {
        return new yy(this.f11041c.f11509a.f11994c, null, null, i, null, null, this.f11040b.f12046l, this.f11040b.f12045k, this.f11041c.f11509a.f12000i, false, null, null, null, null, null, this.f11040b.f12043i, this.f11041c.f11512d, this.f11040b.f12041g, this.f11041c.f11514f, this.f11040b.f12048n, this.f11040b.f12049o, this.f11041c.f11516h, null, null, null, null, this.f11041c.f11510b.f12023F, this.f11041c.f11510b.f12024G, null, null, null);
    }

    public void onStop() {
    }

    public void zzco() {
        final yy a = m14378a(0);
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ vu f11038b;

            public void run() {
                this.f11038b.f11039a.zzb(a);
            }
        });
    }
}
