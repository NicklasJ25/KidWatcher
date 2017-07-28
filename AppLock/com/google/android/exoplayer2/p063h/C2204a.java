package com.google.android.exoplayer2.p063h;

import com.google.android.exoplayer2.p055f.C2152h;
import com.google.android.exoplayer2.p056i.C2225d;
import com.google.android.exoplayer2.p063h.C2202f.C2200a;

public class C2204a extends C2203b {
    private final C2225d f6242d;
    private final int f6243e;
    private final long f6244f;
    private final long f6245g;
    private final long f6246h;
    private final float f6247i;
    private int f6248j = m6868a(Long.MIN_VALUE);
    private int f6249k = 1;

    public static final class C2201a implements C2200a {
        private final C2225d f6230a;
        private final int f6231b;
        private final int f6232c;
        private final int f6233d;
        private final int f6234e;
        private final float f6235f;

        public C2201a(C2225d c2225d) {
            this(c2225d, 800000, 10000, 25000, 25000, 0.75f);
        }

        public C2201a(C2225d c2225d, int i, int i2, int i3, int i4, float f) {
            this.f6230a = c2225d;
            this.f6231b = i;
            this.f6232c = i2;
            this.f6233d = i3;
            this.f6234e = i4;
            this.f6235f = f;
        }

        public C2204a m6857a(C2152h c2152h, int... iArr) {
            return new C2204a(c2152h, iArr, this.f6230a, this.f6231b, (long) this.f6232c, (long) this.f6233d, (long) this.f6234e, this.f6235f);
        }

        public /* synthetic */ C2202f mo3085b(C2152h c2152h, int[] iArr) {
            return m6857a(c2152h, iArr);
        }
    }

    public C2204a(C2152h c2152h, int[] iArr, C2225d c2225d, int i, long j, long j2, long j3, float f) {
        super(c2152h, iArr);
        this.f6242d = c2225d;
        this.f6243e = i;
        this.f6244f = j * 1000;
        this.f6245g = j2 * 1000;
        this.f6246h = j3 * 1000;
        this.f6247i = f;
    }

    private int m6868a(long j) {
        int i = 0;
        long a = this.f6242d.mo3102a();
        a = a == -1 ? (long) this.f6243e : (long) (((float) a) * this.f6247i);
        int i2 = 0;
        while (i < this.b) {
            if (j == Long.MIN_VALUE || !m6865a(i, j)) {
                if (((long) mo3086a(i).f4944b) <= a) {
                    return i;
                }
                i2 = i;
            }
            i++;
        }
        return i2;
    }
}
