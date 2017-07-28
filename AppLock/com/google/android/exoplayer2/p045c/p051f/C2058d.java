package com.google.android.exoplayer2.p045c.p051f;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2253b;
import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2051e;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;
import java.util.Arrays;
import java.util.Collections;

final class C2058d extends C2054g {
    private static final byte[] f5653a = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final boolean f5654b;
    private final C2262j f5655c;
    private final C2263k f5656d;
    private final String f5657e;
    private C2025o f5658f;
    private C2025o f5659g;
    private int f5660h;
    private int f5661i;
    private int f5662j;
    private boolean f5663k;
    private boolean f5664l;
    private long f5665m;
    private int f5666n;
    private long f5667o;
    private C2025o f5668p;
    private long f5669q;

    public C2058d(boolean z) {
        this(z, null);
    }

    public C2058d(boolean z, String str) {
        this.f5655c = new C2262j(new byte[7]);
        this.f5656d = new C2263k(Arrays.copyOf(f5653a, 10));
        m6191c();
        this.f5654b = z;
        this.f5657e = str;
    }

    private void m6188a(C2025o c2025o, long j, int i, int i2) {
        this.f5660h = 3;
        this.f5661i = i;
        this.f5668p = c2025o;
        this.f5669q = j;
        this.f5666n = i2;
    }

    private boolean m6189a(C2263k c2263k, byte[] bArr, int i) {
        int min = Math.min(c2263k.m7070b(), i - this.f5661i);
        c2263k.m7069a(bArr, this.f5661i, min);
        this.f5661i = min + this.f5661i;
        return this.f5661i == i;
    }

    private void m6190b(C2263k c2263k) {
        byte[] bArr = c2263k.f6454a;
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        while (d < c) {
            int i = d + 1;
            d = bArr[d] & 255;
            if (this.f5662j != 512 || d < 240 || d == 255) {
                switch (d | this.f5662j) {
                    case 329:
                        this.f5662j = 768;
                        d = i;
                        break;
                    case 511:
                        this.f5662j = 512;
                        d = i;
                        break;
                    case 836:
                        this.f5662j = 1024;
                        d = i;
                        break;
                    case 1075:
                        m6193d();
                        c2263k.m7073c(i);
                        return;
                    default:
                        if (this.f5662j == 256) {
                            d = i;
                            break;
                        }
                        this.f5662j = 256;
                        d = i - 1;
                        break;
                }
            }
            this.f5663k = (d & 1) == 0;
            m6194e();
            c2263k.m7073c(i);
            return;
        }
        c2263k.m7073c(d);
    }

    private void m6191c() {
        this.f5660h = 0;
        this.f5661i = 0;
        this.f5662j = 256;
    }

    private void m6192c(C2263k c2263k) {
        int min = Math.min(c2263k.m7070b(), this.f5666n - this.f5661i);
        this.f5668p.mo2979a(c2263k, min);
        this.f5661i = min + this.f5661i;
        if (this.f5661i == this.f5666n) {
            this.f5668p.mo2977a(this.f5667o, 1, this.f5666n, 0, null);
            this.f5667o += this.f5669q;
            m6191c();
        }
    }

    private void m6193d() {
        this.f5660h = 1;
        this.f5661i = f5653a.length;
        this.f5666n = 0;
        this.f5656d.m7073c(0);
    }

    private void m6194e() {
        this.f5660h = 2;
        this.f5661i = 0;
    }

    private void m6195f() {
        this.f5659g.mo2979a(this.f5656d, 10);
        this.f5656d.m7073c(6);
        m6188a(this.f5659g, 0, 10, this.f5656d.m7091s() + 10);
    }

    private void m6196g() {
        int i = 2;
        this.f5655c.m7060a(0);
        if (this.f5664l) {
            this.f5655c.m7061b(10);
        } else {
            int c = this.f5655c.m7063c(2) + 1;
            if (c != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + c + ", but assuming AAC LC.");
            } else {
                i = c;
            }
            c = this.f5655c.m7063c(4);
            this.f5655c.m7061b(1);
            Object a = C2253b.m7027a(i, c, this.f5655c.m7063c(3));
            Pair a2 = C2253b.m7026a(a);
            Format a3 = Format.m5480a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a), null, 0, this.f5657e);
            this.f5665m = 1024000000 / ((long) a3.f4959q);
            this.f5658f.mo2978a(a3);
            this.f5664l = true;
        }
        this.f5655c.m7061b(4);
        int c2 = (this.f5655c.m7063c(13) - 2) - 5;
        if (this.f5663k) {
            c2 -= 2;
        }
        m6188a(this.f5658f, this.f5665m, 0, c2);
    }

    public void mo2987a() {
        m6191c();
    }

    public void mo2988a(long j, boolean z) {
        this.f5667o = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5658f = c2090h.mo3019a(c2063c.m6212a());
        if (this.f5654b) {
            this.f5659g = c2090h.mo3019a(c2063c.m6212a());
            this.f5659g.mo2978a(Format.m5483a(null, "application/id3", null, -1, null));
            return;
        }
        this.f5659g = new C2051e();
    }

    public void mo2990a(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            switch (this.f5660h) {
                case 0:
                    m6190b(c2263k);
                    break;
                case 1:
                    if (!m6189a(c2263k, this.f5656d.f6454a, 10)) {
                        break;
                    }
                    m6195f();
                    break;
                case 2:
                    if (!m6189a(c2263k, this.f5655c.f6450a, this.f5663k ? 7 : 5)) {
                        break;
                    }
                    m6196g();
                    break;
                case 3:
                    m6192c(c2263k);
                    break;
                default:
                    break;
            }
        }
    }

    public void mo2991b() {
    }
}
