package com.google.android.exoplayer2.p045c.p046a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.p046a.C1962d.C1971a;
import com.google.android.exoplayer2.p064k.C2275a;

final class C1972e extends C1962d {
    private final C2263k f5168b = new C2263k(C2261i.f6446a);
    private final C2263k f5169c = new C2263k(4);
    private int f5170d;
    private boolean f5171e;
    private int f5172f;

    public C1972e(C2025o c2025o) {
        super(c2025o);
    }

    protected void mo2937a(C2263k c2263k, long j) {
        int g = c2263k.m7079g();
        long k = (((long) c2263k.m7083k()) * 1000) + j;
        if (g == 0 && !this.f5171e) {
            C2263k c2263k2 = new C2263k(new byte[c2263k.m7070b()]);
            c2263k.m7069a(c2263k2.f6454a, 0, c2263k.m7070b());
            C2275a a = C2275a.m7150a(c2263k2);
            this.f5170d = a.f6488b;
            this.a.mo2978a(Format.m5476a(null, "video/avc", null, -1, -1, a.f6489c, a.f6490d, -1.0f, a.f6487a, -1, a.f6491e, null));
            this.f5171e = true;
        } else if (g == 1) {
            byte[] bArr = this.f5169c.f6454a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            g = 4 - this.f5170d;
            int i = 0;
            while (c2263k.m7070b() > 0) {
                c2263k.m7069a(this.f5169c.f6454a, g, this.f5170d);
                this.f5169c.m7073c(0);
                int t = this.f5169c.m7092t();
                this.f5168b.m7073c(0);
                this.a.mo2979a(this.f5168b, 4);
                int i2 = i + 4;
                this.a.mo2979a(c2263k, t);
                i = i2 + t;
            }
            this.a.mo2977a(k, this.f5172f == 1 ? 1 : 0, i, 0, null);
        }
    }

    protected boolean mo2938a(C2263k c2263k) {
        int g = c2263k.m7079g();
        int i = (g >> 4) & 15;
        g &= 15;
        if (g != 7) {
            throw new C1971a("Video format not supported: " + g);
        }
        this.f5172f = i;
        return i != 5;
    }
}
