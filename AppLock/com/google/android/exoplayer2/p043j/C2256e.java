package com.google.android.exoplayer2.p043j;

public final class C2256e {
    public final int f6423a;
    public final int f6424b;
    public final int f6425c;
    public final int f6426d;
    public final int f6427e;
    public final int f6428f;
    public final int f6429g;
    public final long f6430h;

    public C2256e(byte[] bArr, int i) {
        C2262j c2262j = new C2262j(bArr);
        c2262j.m7060a(i * 8);
        this.f6423a = c2262j.m7063c(16);
        this.f6424b = c2262j.m7063c(16);
        this.f6425c = c2262j.m7063c(24);
        this.f6426d = c2262j.m7063c(24);
        this.f6427e = c2262j.m7063c(20);
        this.f6428f = c2262j.m7063c(3) + 1;
        this.f6429g = c2262j.m7063c(5) + 1;
        this.f6430h = (long) c2262j.m7063c(36);
    }

    public int m7037a() {
        return this.f6429g * this.f6427e;
    }

    public long m7038b() {
        return (this.f6430h * 1000000) / ((long) this.f6427e);
    }
}
