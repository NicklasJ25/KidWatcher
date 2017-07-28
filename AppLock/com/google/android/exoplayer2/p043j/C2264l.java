package com.google.android.exoplayer2.p043j;

public final class C2264l {
    private byte[] f6457a;
    private int f6458b;
    private int f6459c;
    private int f6460d;

    public C2264l(byte[] bArr, int i, int i2) {
        m7102a(bArr, i, i2);
    }

    private boolean m7098d(int i) {
        return 2 <= i && i < this.f6458b && this.f6457a[i] == (byte) 3 && this.f6457a[i - 2] == (byte) 0 && this.f6457a[i - 1] == (byte) 0;
    }

    private int m7099e() {
        int i = 0;
        int i2 = 0;
        while (!m7103a()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m7107c(i2);
        }
        return i3 + i;
    }

    private void m7100f() {
        boolean z = this.f6459c >= 0 && this.f6460d >= 0 && this.f6460d < 8 && (this.f6459c < this.f6458b || (this.f6459c == this.f6458b && this.f6460d == 0));
        C2252a.m7024b(z);
    }

    public void m7101a(int i) {
        int i2 = this.f6459c;
        this.f6459c += i / 8;
        this.f6460d += i % 8;
        if (this.f6460d > 7) {
            this.f6459c++;
            this.f6460d -= 8;
        }
        i2++;
        while (i2 <= this.f6459c) {
            if (m7098d(i2)) {
                this.f6459c++;
                i2 += 2;
            }
            i2++;
        }
        m7100f();
    }

    public void m7102a(byte[] bArr, int i, int i2) {
        this.f6457a = bArr;
        this.f6459c = i;
        this.f6458b = i2;
        this.f6460d = 0;
        m7100f();
    }

    public boolean m7103a() {
        return m7107c(1) == 1;
    }

    public boolean m7104b() {
        int i = this.f6459c;
        int i2 = this.f6460d;
        int i3 = 0;
        while (this.f6459c < this.f6458b && !m7103a()) {
            i3++;
        }
        boolean z = this.f6459c == this.f6458b;
        this.f6459c = i;
        this.f6460d = i2;
        return !z && m7105b((i3 * 2) + 1);
    }

    public boolean m7105b(int i) {
        int i2 = this.f6459c;
        int i3 = (i / 8) + this.f6459c;
        int i4 = this.f6460d + (i % 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        int i5 = i2 + 1;
        i2 = i3;
        i3 = i5;
        while (i3 <= i2 && i2 < this.f6458b) {
            if (m7098d(i3)) {
                i2++;
                i3 += 2;
            }
            i3++;
        }
        return i2 < this.f6458b || (i2 == this.f6458b && i4 == 0);
    }

    public int m7106c() {
        return m7099e();
    }

    public int m7107c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4 = i / 8;
            int i5 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                i2 = m7098d(this.f6459c + 1) ? this.f6459c + 2 : this.f6459c + 1;
                i -= 8;
                i5 |= ((this.f6460d != 0 ? ((this.f6457a[this.f6459c] & 255) << this.f6460d) | ((this.f6457a[i2] & 255) >>> (8 - this.f6460d)) : this.f6457a[this.f6459c]) & 255) << i;
                this.f6459c = i2;
            }
            if (i > 0) {
                i3 = this.f6460d + i;
                byte b = (byte) (255 >> (8 - i));
                int i6 = m7098d(this.f6459c + 1) ? this.f6459c + 2 : this.f6459c + 1;
                if (i3 > 8) {
                    i2 = ((((this.f6457a[this.f6459c] & 255) << (i3 - 8)) | ((this.f6457a[i6] & 255) >> (16 - i3))) & b) | i5;
                    this.f6459c = i6;
                } else {
                    i2 = (((this.f6457a[this.f6459c] & 255) >> (8 - i3)) & b) | i5;
                    if (i3 == 8) {
                        this.f6459c = i6;
                    }
                }
                this.f6460d = i3 % 8;
            } else {
                i2 = i5;
            }
            m7100f();
        }
        return i2;
    }

    public int m7108d() {
        int e = m7099e();
        return (e % 2 == 0 ? -1 : 1) * ((e + 1) / 2);
    }
}
