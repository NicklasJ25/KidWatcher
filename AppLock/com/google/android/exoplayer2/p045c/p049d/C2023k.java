package com.google.android.exoplayer2.p045c.p049d;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1985g;

final class C2023k {
    public C2009c f5492a;
    public long f5493b;
    public long f5494c;
    public long f5495d;
    public int f5496e;
    public int f5497f;
    public long[] f5498g;
    public int[] f5499h;
    public int[] f5500i;
    public int[] f5501j;
    public long[] f5502k;
    public boolean[] f5503l;
    public boolean f5504m;
    public boolean[] f5505n;
    public C2022j f5506o;
    public int f5507p;
    public C2263k f5508q;
    public boolean f5509r;
    public long f5510s;

    C2023k() {
    }

    public void m6034a() {
        this.f5496e = 0;
        this.f5510s = 0;
        this.f5504m = false;
        this.f5509r = false;
        this.f5506o = null;
    }

    public void m6035a(int i) {
        if (this.f5508q == null || this.f5508q.m7072c() < i) {
            this.f5508q = new C2263k(i);
        }
        this.f5507p = i;
        this.f5504m = true;
        this.f5509r = true;
    }

    public void m6036a(int i, int i2) {
        this.f5496e = i;
        this.f5497f = i2;
        if (this.f5499h == null || this.f5499h.length < i) {
            this.f5498g = new long[i];
            this.f5499h = new int[i];
        }
        if (this.f5500i == null || this.f5500i.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.f5500i = new int[i3];
            this.f5501j = new int[i3];
            this.f5502k = new long[i3];
            this.f5503l = new boolean[i3];
            this.f5505n = new boolean[i3];
        }
    }

    public void m6037a(C1985g c1985g) {
        c1985g.mo2965b(this.f5508q.f6454a, 0, this.f5507p);
        this.f5508q.m7073c(0);
        this.f5509r = false;
    }

    public void m6038a(C2263k c2263k) {
        c2263k.m7069a(this.f5508q.f6454a, 0, this.f5507p);
        this.f5508q.m7073c(0);
        this.f5509r = false;
    }

    public long m6039b(int i) {
        return this.f5502k[i] + ((long) this.f5501j[i]);
    }
}
