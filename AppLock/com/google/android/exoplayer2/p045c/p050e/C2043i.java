package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.p043j.C2252a;

final class C2043i {
    public final byte[] f5593a;
    private int f5594b;
    private int f5595c;
    private int f5596d;

    public C2043i(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public C2043i(byte[] bArr, int i) {
        this.f5593a = bArr;
        this.f5594b = i * 8;
    }

    public int m6135a(int i) {
        C2252a.m7024b(m6137b() + i <= this.f5594b);
        if (i == 0) {
            return 0;
        }
        long min;
        int i2;
        int i3;
        int i4;
        if (this.f5596d != 0) {
            min = Math.min(i, 8 - this.f5596d);
            i2 = (255 >>> (8 - min)) & (this.f5593a[this.f5595c] >>> this.f5596d);
            this.f5596d += min;
            if (this.f5596d == 8) {
                this.f5595c++;
                this.f5596d = 0;
            }
        } else {
            min = 0;
            i2 = 0;
        }
        if (i - min > 7) {
            int i5 = (i - min) / 8;
            i3 = i2;
            i2 = 0;
            while (i2 < i5) {
                long j = (long) i3;
                byte[] bArr = this.f5593a;
                int i6 = this.f5595c;
                this.f5595c = i6 + 1;
                min += 8;
                i2++;
                i3 = (int) (j | ((((long) bArr[i6]) & 255) << min));
            }
            int i7 = min;
            i4 = i3;
            i3 = i7;
        } else {
            i3 = min;
            i4 = i2;
        }
        if (i > i3) {
            i2 = i - i3;
            i4 |= ((255 >>> (8 - i2)) & this.f5593a[this.f5595c]) << i3;
            this.f5596d += i2;
        }
        return i4;
    }

    public boolean m6136a() {
        return m6135a(1) == 1;
    }

    public int m6137b() {
        return (this.f5595c * 8) + this.f5596d;
    }

    public void m6138b(int i) {
        C2252a.m7024b(m6137b() + i <= this.f5594b);
        this.f5595c += i / 8;
        this.f5596d += i % 8;
        if (this.f5596d > 7) {
            this.f5595c++;
            this.f5596d -= 8;
        }
    }
}
