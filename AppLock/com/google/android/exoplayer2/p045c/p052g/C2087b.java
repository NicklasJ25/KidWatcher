package com.google.android.exoplayer2.p045c.p052g;

final class C2087b {
    private final int f5862a;
    private final int f5863b;
    private final int f5864c;
    private final int f5865d;
    private final int f5866e;
    private final int f5867f;
    private long f5868g;
    private long f5869h;

    public C2087b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f5862a = i;
        this.f5863b = i2;
        this.f5864c = i3;
        this.f5865d = i4;
        this.f5866e = i5;
        this.f5867f = i6;
    }

    public long m6330a() {
        return ((this.f5869h / ((long) this.f5865d)) * 1000000) / ((long) this.f5863b);
    }

    public long m6331a(long j) {
        return Math.min((((((long) this.f5864c) * j) / 1000000) / ((long) this.f5865d)) * ((long) this.f5865d), this.f5869h - ((long) this.f5865d)) + this.f5868g;
    }

    public void m6332a(long j, long j2) {
        this.f5868g = j;
        this.f5869h = j2;
    }

    public int m6333b() {
        return this.f5865d;
    }

    public long m6334b(long j) {
        return (1000000 * j) / ((long) this.f5864c);
    }

    public int m6335c() {
        return (this.f5863b * this.f5866e) * this.f5862a;
    }

    public int m6336d() {
        return this.f5863b;
    }

    public int m6337e() {
        return this.f5862a;
    }

    public boolean m6338f() {
        return (this.f5868g == 0 || this.f5869h == 0) ? false : true;
    }

    public int m6339g() {
        return this.f5867f;
    }
}
