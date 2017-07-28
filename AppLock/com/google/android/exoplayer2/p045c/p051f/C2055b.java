package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p041a.C1926a;
import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

final class C2055b extends C2054g {
    private final C2262j f5635a;
    private final C2263k f5636b;
    private final String f5637c;
    private C2025o f5638d;
    private int f5639e;
    private int f5640f;
    private boolean f5641g;
    private long f5642h;
    private Format f5643i;
    private int f5644j;
    private boolean f5645k;
    private long f5646l;

    public C2055b() {
        this(null);
    }

    public C2055b(String str) {
        this.f5635a = new C2262j(new byte[8]);
        this.f5636b = new C2263k(this.f5635a.f6450a);
        this.f5639e = 0;
        this.f5637c = str;
    }

    private boolean m6174a(C2263k c2263k, byte[] bArr, int i) {
        int min = Math.min(c2263k.m7070b(), i - this.f5640f);
        c2263k.m7069a(bArr, this.f5640f, min);
        this.f5640f = min + this.f5640f;
        return this.f5640f == i;
    }

    private boolean m6175b(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            if (this.f5641g) {
                int g = c2263k.m7079g();
                if (g == 119) {
                    this.f5641g = false;
                    return true;
                }
                this.f5641g = g == 11;
            } else {
                this.f5641g = c2263k.m7079g() == 11;
            }
        }
        return false;
    }

    private void m6176c() {
        if (this.f5643i == null) {
            this.f5635a.m7061b(40);
            this.f5645k = this.f5635a.m7063c(5) == 16;
            this.f5635a.m7060a(this.f5635a.m7059a() - 45);
            this.f5643i = this.f5645k ? C1926a.m5501b(this.f5635a, null, this.f5637c, null) : C1926a.m5498a(this.f5635a, null, this.f5637c, null);
            this.f5638d.mo2978a(this.f5643i);
        }
        this.f5644j = this.f5645k ? C1926a.m5500b(this.f5635a.f6450a) : C1926a.m5497a(this.f5635a.f6450a);
        this.f5642h = (long) ((int) ((((long) (this.f5645k ? C1926a.m5503c(this.f5635a.f6450a) : C1926a.m5494a())) * 1000000) / ((long) this.f5643i.f4959q)));
    }

    public void mo2987a() {
        this.f5639e = 0;
        this.f5640f = 0;
        this.f5641g = false;
    }

    public void mo2988a(long j, boolean z) {
        this.f5646l = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5638d = c2090h.mo3019a(c2063c.m6212a());
    }

    public void mo2990a(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            switch (this.f5639e) {
                case 0:
                    if (!m6175b(c2263k)) {
                        break;
                    }
                    this.f5639e = 1;
                    this.f5636b.f6454a[0] = (byte) 11;
                    this.f5636b.f6454a[1] = (byte) 119;
                    this.f5640f = 2;
                    break;
                case 1:
                    if (!m6174a(c2263k, this.f5636b.f6454a, 8)) {
                        break;
                    }
                    m6176c();
                    this.f5636b.m7073c(0);
                    this.f5638d.mo2979a(this.f5636b, 8);
                    this.f5639e = 2;
                    break;
                case 2:
                    int min = Math.min(c2263k.m7070b(), this.f5644j - this.f5640f);
                    this.f5638d.mo2979a(c2263k, min);
                    this.f5640f = min + this.f5640f;
                    if (this.f5640f != this.f5644j) {
                        break;
                    }
                    this.f5638d.mo2977a(this.f5646l, 1, this.f5644j, 0, null);
                    this.f5646l += this.f5642h;
                    this.f5639e = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void mo2991b() {
    }
}
