package com.google.android.exoplayer2.p045c.p047b;

import com.google.android.exoplayer2.p045c.C1985g;

final class C1984f {
    private static final long[] f5269a = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] f5270b = new byte[8];
    private int f5271c;
    private int f5272d;

    public static int m5843a(int i) {
        for (int i2 = 0; i2 < f5269a.length; i2++) {
            if ((f5269a[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long m5844a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f5269a[i - 1] ^ -1;
        }
        long j2 = j;
        for (int i2 = 1; i2 < i; i2++) {
            j2 = (j2 << 8) | (((long) bArr[i2]) & 255);
        }
        return j2;
    }

    public long m5845a(C1985g c1985g, boolean z, boolean z2, int i) {
        if (this.f5271c == 0) {
            if (!c1985g.mo2962a(this.f5270b, 0, 1, z)) {
                return -1;
            }
            this.f5272d = C1984f.m5843a(this.f5270b[0] & 255);
            if (this.f5272d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f5271c = 1;
        }
        if (this.f5272d > i) {
            this.f5271c = 0;
            return -2;
        }
        if (this.f5272d != 1) {
            c1985g.mo2965b(this.f5270b, 1, this.f5272d - 1);
        }
        this.f5271c = 0;
        return C1984f.m5844a(this.f5270b, this.f5272d, z2);
    }

    public void m5846a() {
        this.f5271c = 0;
        this.f5272d = 0;
    }

    public int m5847b() {
        return this.f5272d;
    }
}
