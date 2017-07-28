package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p041a.C1945e;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

final class C2061f extends C2054g {
    private final C2263k f5671a = new C2263k(new byte[15]);
    private final String f5672b;
    private C2025o f5673c;
    private int f5674d;
    private int f5675e;
    private int f5676f;
    private long f5677g;
    private Format f5678h;
    private int f5679i;
    private long f5680j;

    public C2061f(String str) {
        this.f5671a.f6454a[0] = Byte.MAX_VALUE;
        this.f5671a.f6454a[1] = (byte) -2;
        this.f5671a.f6454a[2] = Byte.MIN_VALUE;
        this.f5671a.f6454a[3] = (byte) 1;
        this.f5674d = 0;
        this.f5672b = str;
    }

    private boolean m6204a(C2263k c2263k, byte[] bArr, int i) {
        int min = Math.min(c2263k.m7070b(), i - this.f5675e);
        c2263k.m7069a(bArr, this.f5675e, min);
        this.f5675e = min + this.f5675e;
        return this.f5675e == i;
    }

    private boolean m6205b(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            this.f5676f <<= 8;
            this.f5676f |= c2263k.m7079g();
            if (this.f5676f == 2147385345) {
                this.f5676f = 0;
                return true;
            }
        }
        return false;
    }

    private void m6206c() {
        byte[] bArr = this.f5671a.f6454a;
        if (this.f5678h == null) {
            this.f5678h = C1945e.m5576a(bArr, null, this.f5672b, null);
            this.f5673c.mo2978a(this.f5678h);
        }
        this.f5679i = C1945e.m5577b(bArr);
        this.f5677g = (long) ((int) ((((long) C1945e.m5575a(bArr)) * 1000000) / ((long) this.f5678h.f4959q)));
    }

    public void mo2987a() {
        this.f5674d = 0;
        this.f5675e = 0;
        this.f5676f = 0;
    }

    public void mo2988a(long j, boolean z) {
        this.f5680j = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5673c = c2090h.mo3019a(c2063c.m6212a());
    }

    public void mo2990a(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            switch (this.f5674d) {
                case 0:
                    if (!m6205b(c2263k)) {
                        break;
                    }
                    this.f5675e = 4;
                    this.f5674d = 1;
                    break;
                case 1:
                    if (!m6204a(c2263k, this.f5671a.f6454a, 15)) {
                        break;
                    }
                    m6206c();
                    this.f5671a.m7073c(0);
                    this.f5673c.mo2979a(this.f5671a, 15);
                    this.f5674d = 2;
                    break;
                case 2:
                    int min = Math.min(c2263k.m7070b(), this.f5679i - this.f5675e);
                    this.f5673c.mo2979a(c2263k, min);
                    this.f5675e = min + this.f5675e;
                    if (this.f5675e != this.f5679i) {
                        break;
                    }
                    this.f5673c.mo2977a(this.f5680j, 1, this.f5679i, 0, null);
                    this.f5680j += this.f5677g;
                    this.f5674d = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void mo2991b() {
    }
}
