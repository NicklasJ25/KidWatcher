package com.facebook.ads.internal.p024l;

import com.facebook.ads.internal.p028g.C1576d;

public class C1683e {
    private C1576d f4179a;
    private C1682a f4180b;

    public enum C1682a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public C1683e(C1682a c1682a, C1576d c1576d) {
        this.f4180b = c1682a;
        this.f4179a = c1576d;
    }

    public C1682a m4797a() {
        return this.f4180b;
    }

    public C1576d m4798b() {
        return this.f4179a;
    }
}
