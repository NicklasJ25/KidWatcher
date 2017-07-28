package com.google.android.exoplayer2.p043j;

import java.nio.charset.Charset;

public final class C2263k {
    public byte[] f6454a;
    private int f6455b;
    private int f6456c;

    public C2263k(int i) {
        this.f6454a = new byte[i];
        this.f6456c = i;
    }

    public C2263k(byte[] bArr) {
        this.f6454a = bArr;
        this.f6456c = bArr.length;
    }

    public C2263k(byte[] bArr, int i) {
        this.f6454a = bArr;
        this.f6456c = i;
    }

    public String m7064a(int i, Charset charset) {
        String str = new String(this.f6454a, this.f6455b, i, charset);
        this.f6455b += i;
        return str;
    }

    public void m7065a() {
        this.f6455b = 0;
        this.f6456c = 0;
    }

    public void m7066a(int i) {
        m7068a(m7076e() < i ? new byte[i] : this.f6454a, i);
    }

    public void m7067a(C2262j c2262j, int i) {
        m7069a(c2262j.f6450a, 0, i);
        c2262j.m7060a(0);
    }

    public void m7068a(byte[] bArr, int i) {
        this.f6454a = bArr;
        this.f6456c = i;
        this.f6455b = 0;
    }

    public void m7069a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6454a, this.f6455b, bArr, i, i2);
        this.f6455b += i2;
    }

    public int m7070b() {
        return this.f6456c - this.f6455b;
    }

    public void m7071b(int i) {
        boolean z = i >= 0 && i <= this.f6454a.length;
        C2252a.m7022a(z);
        this.f6456c = i;
    }

    public int m7072c() {
        return this.f6456c;
    }

    public void m7073c(int i) {
        boolean z = i >= 0 && i <= this.f6456c;
        C2252a.m7022a(z);
        this.f6455b = i;
    }

    public int m7074d() {
        return this.f6455b;
    }

    public void m7075d(int i) {
        m7073c(this.f6455b + i);
    }

    public int m7076e() {
        return this.f6454a == null ? 0 : this.f6454a.length;
    }

    public String m7077e(int i) {
        return m7064a(i, Charset.defaultCharset());
    }

    public int m7078f() {
        return this.f6454a[this.f6455b] & 255;
    }

    public int m7079g() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        return bArr[i] & 255;
    }

    public int m7080h() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int m7081i() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public short m7082j() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & 255));
    }

    public int m7083k() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f6454a;
        i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public long m7084l() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f6454a;
        int i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m7085m() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f6454a;
        int i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public int m7086n() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f6454a;
        i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f6454a;
        i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int m7087o() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f6454a;
        i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f6454a;
        i3 = this.f6455b;
        this.f6455b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public long m7088p() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f6454a;
        int i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m7089q() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f6454a;
        int i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f6454a;
        i2 = this.f6455b;
        this.f6455b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    public int m7090r() {
        byte[] bArr = this.f6454a;
        int i = this.f6455b;
        this.f6455b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f6454a;
        int i3 = this.f6455b;
        this.f6455b = i3 + 1;
        i2 |= bArr2[i3] & 255;
        this.f6455b += 2;
        return i2;
    }

    public int m7091s() {
        return (((m7079g() << 21) | (m7079g() << 14)) | (m7079g() << 7)) | m7079g();
    }

    public int m7092t() {
        int n = m7086n();
        if (n >= 0) {
            return n;
        }
        throw new IllegalStateException("Top bit not zero: " + n);
    }

    public int m7093u() {
        int o = m7087o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public long m7094v() {
        long p = m7088p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public double m7095w() {
        return Double.longBitsToDouble(m7088p());
    }

    public String m7096x() {
        if (m7070b() == 0) {
            return null;
        }
        int i = this.f6455b;
        while (i < this.f6456c && this.f6454a[i] != (byte) 10 && this.f6454a[i] != (byte) 13) {
            i++;
        }
        if (i - this.f6455b >= 3 && this.f6454a[this.f6455b] == (byte) -17 && this.f6454a[this.f6455b + 1] == (byte) -69 && this.f6454a[this.f6455b + 2] == (byte) -65) {
            this.f6455b += 3;
        }
        String str = new String(this.f6454a, this.f6455b, i - this.f6455b);
        this.f6455b = i;
        if (this.f6455b == this.f6456c) {
            return str;
        }
        if (this.f6454a[this.f6455b] == (byte) 13) {
            this.f6455b++;
            if (this.f6455b == this.f6456c) {
                return str;
            }
        }
        if (this.f6454a[this.f6455b] == (byte) 10) {
            this.f6455b++;
        }
        return str;
    }

    public long m7097y() {
        int i = 1;
        int i2 = 0;
        long j = (long) this.f6454a[this.f6455b];
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b;
            if ((((long) (1 << i3)) & j) == 0) {
                if (i3 < 6) {
                    j &= (long) ((1 << i3) - 1);
                    i2 = 7 - i3;
                } else if (i3 == 7) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
                }
                while (i < i2) {
                    b = this.f6454a[this.f6455b + i];
                    if ((b & 192) == 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                    }
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                }
                this.f6455b += i2;
                return j;
            }
        }
        if (i2 != 0) {
            while (i < i2) {
                b = this.f6454a[this.f6455b + i];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.f6455b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }
}
