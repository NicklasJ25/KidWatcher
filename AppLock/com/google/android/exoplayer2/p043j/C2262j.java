package com.google.android.exoplayer2.p043j;

public final class C2262j {
    public byte[] f6450a;
    private int f6451b;
    private int f6452c;
    private int f6453d;

    public C2262j(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public C2262j(byte[] bArr, int i) {
        this.f6450a = bArr;
        this.f6453d = i;
    }

    private void m7058c() {
        boolean z = this.f6451b >= 0 && this.f6452c >= 0 && this.f6452c < 8 && (this.f6451b < this.f6453d || (this.f6451b == this.f6453d && this.f6452c == 0));
        C2252a.m7024b(z);
    }

    public int m7059a() {
        return (this.f6451b * 8) + this.f6452c;
    }

    public void m7060a(int i) {
        this.f6451b = i / 8;
        this.f6452c = i - (this.f6451b * 8);
        m7058c();
    }

    public void m7061b(int i) {
        this.f6451b += i / 8;
        this.f6452c += i % 8;
        if (this.f6452c > 7) {
            this.f6451b++;
            this.f6452c -= 8;
        }
        m7058c();
    }

    public boolean m7062b() {
        return m7063c(1) == 1;
    }

    public int m7063c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4 = i / 8;
            int i5 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                i -= 8;
                i5 |= ((this.f6452c != 0 ? ((this.f6450a[this.f6451b] & 255) << this.f6452c) | ((this.f6450a[this.f6451b + 1] & 255) >>> (8 - this.f6452c)) : this.f6450a[this.f6451b]) & 255) << i;
                this.f6451b++;
            }
            if (i > 0) {
                i3 = this.f6452c + i;
                byte b = (byte) (255 >> (8 - i));
                if (i3 > 8) {
                    i2 = (b & (((this.f6450a[this.f6451b] & 255) << (i3 - 8)) | ((this.f6450a[this.f6451b + 1] & 255) >> (16 - i3)))) | i5;
                    this.f6451b++;
                } else {
                    i2 = (b & ((this.f6450a[this.f6451b] & 255) >> (8 - i3))) | i5;
                    if (i3 == 8) {
                        this.f6451b++;
                    }
                }
                this.f6452c = i3 % 8;
            } else {
                i2 = i5;
            }
            m7058c();
        }
        return i2;
    }
}
