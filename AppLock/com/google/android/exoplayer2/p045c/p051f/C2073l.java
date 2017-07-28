package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2092k;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

final class C2073l extends C2054g {
    private final C2263k f5783a;
    private final C2092k f5784b;
    private final String f5785c;
    private C2025o f5786d;
    private int f5787e;
    private int f5788f;
    private boolean f5789g;
    private boolean f5790h;
    private long f5791i;
    private int f5792j;
    private long f5793k;

    public C2073l() {
        this(null);
    }

    public C2073l(String str) {
        this.f5787e = 0;
        this.f5783a = new C2263k(4);
        this.f5783a.f6454a[0] = (byte) -1;
        this.f5784b = new C2092k();
        this.f5785c = str;
    }

    private void m6265b(C2263k c2263k) {
        byte[] bArr = c2263k.f6454a;
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        int i = d;
        while (i < c) {
            boolean z = (bArr[i] & 255) == 255;
            if (this.f5790h && (bArr[i] & 224) == 224) {
                int i2 = 1;
            } else {
                boolean z2 = false;
            }
            this.f5790h = z;
            if (i2 != 0) {
                c2263k.m7073c(i + 1);
                this.f5790h = false;
                this.f5783a.f6454a[1] = bArr[i];
                this.f5788f = 2;
                this.f5787e = 1;
                return;
            }
            i++;
        }
        c2263k.m7073c(c);
    }

    private void m6266c(C2263k c2263k) {
        int min = Math.min(c2263k.m7070b(), 4 - this.f5788f);
        c2263k.m7069a(this.f5783a.f6454a, this.f5788f, min);
        this.f5788f = min + this.f5788f;
        if (this.f5788f >= 4) {
            this.f5783a.m7073c(0);
            if (C2092k.m6351a(this.f5783a.m7086n(), this.f5784b)) {
                this.f5792j = this.f5784b.f5884c;
                if (!this.f5789g) {
                    this.f5791i = (1000000 * ((long) this.f5784b.f5888g)) / ((long) this.f5784b.f5885d);
                    this.f5786d.mo2978a(Format.m5480a(null, this.f5784b.f5883b, null, -1, 4096, this.f5784b.f5886e, this.f5784b.f5885d, null, null, 0, this.f5785c));
                    this.f5789g = true;
                }
                this.f5783a.m7073c(0);
                this.f5786d.mo2979a(this.f5783a, 4);
                this.f5787e = 2;
                return;
            }
            this.f5788f = 0;
            this.f5787e = 1;
        }
    }

    private void m6267d(C2263k c2263k) {
        int min = Math.min(c2263k.m7070b(), this.f5792j - this.f5788f);
        this.f5786d.mo2979a(c2263k, min);
        this.f5788f = min + this.f5788f;
        if (this.f5788f >= this.f5792j) {
            this.f5786d.mo2977a(this.f5793k, 1, this.f5792j, 0, null);
            this.f5793k += this.f5791i;
            this.f5788f = 0;
            this.f5787e = 0;
        }
    }

    public void mo2987a() {
        this.f5787e = 0;
        this.f5788f = 0;
        this.f5790h = false;
    }

    public void mo2988a(long j, boolean z) {
        this.f5793k = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5786d = c2090h.mo3019a(c2063c.m6212a());
    }

    public void mo2990a(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            switch (this.f5787e) {
                case 0:
                    m6265b(c2263k);
                    break;
                case 1:
                    m6266c(c2263k);
                    break;
                case 2:
                    m6267d(c2263k);
                    break;
                default:
                    break;
            }
        }
    }

    public void mo2991b() {
    }
}
