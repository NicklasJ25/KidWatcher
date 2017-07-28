package com.google.android.exoplayer2.p043j;

import java.util.Arrays;

public final class C2257f {
    private int f6431a;
    private long[] f6432b;

    public C2257f() {
        this(32);
    }

    public C2257f(int i) {
        this.f6432b = new long[i];
    }

    public int m7039a() {
        return this.f6431a;
    }

    public long m7040a(int i) {
        if (i >= 0 && i < this.f6431a) {
            return this.f6432b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f6431a);
    }

    public void m7041a(long j) {
        if (this.f6431a == this.f6432b.length) {
            this.f6432b = Arrays.copyOf(this.f6432b, this.f6431a * 2);
        }
        long[] jArr = this.f6432b;
        int i = this.f6431a;
        this.f6431a = i + 1;
        jArr[i] = j;
    }

    public long[] m7042b() {
        return Arrays.copyOf(this.f6432b, this.f6431a);
    }
}
