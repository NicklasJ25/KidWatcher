package com.google.android.exoplayer2.p045c.p051f;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2264l;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;
import java.util.Collections;

final class C2071j extends C2054g {
    private C2025o f5764a;
    private C2078o f5765b;
    private boolean f5766c;
    private final boolean[] f5767d = new boolean[3];
    private final C2074m f5768e = new C2074m(32, 128);
    private final C2074m f5769f = new C2074m(33, 128);
    private final C2074m f5770g = new C2074m(34, 128);
    private final C2074m f5771h = new C2074m(39, 128);
    private final C2074m f5772i = new C2074m(40, 128);
    private final C2070a f5773j = new C2070a(this.f5764a);
    private long f5774k;
    private long f5775l;
    private final C2263k f5776m = new C2263k();

    private static final class C2070a {
        private final C2025o f5751a;
        private long f5752b;
        private boolean f5753c;
        private int f5754d;
        private long f5755e;
        private boolean f5756f;
        private boolean f5757g;
        private boolean f5758h;
        private boolean f5759i;
        private boolean f5760j;
        private long f5761k;
        private long f5762l;
        private boolean f5763m;

        public C2070a(C2025o c2025o) {
            this.f5751a = c2025o;
        }

        private void m6244a(int i) {
            this.f5751a.mo2977a(this.f5762l, this.f5763m ? 1 : 0, (int) (this.f5752b - this.f5761k), i, null);
        }

        public void m6245a() {
            this.f5756f = false;
            this.f5757g = false;
            this.f5758h = false;
            this.f5759i = false;
            this.f5760j = false;
        }

        public void m6246a(long j, int i) {
            if (this.f5760j && this.f5757g) {
                this.f5763m = this.f5753c;
                this.f5760j = false;
            } else if (this.f5758h || this.f5757g) {
                if (this.f5759i) {
                    m6244a(((int) (j - this.f5752b)) + i);
                }
                this.f5761k = this.f5752b;
                this.f5762l = this.f5755e;
                this.f5759i = true;
                this.f5763m = this.f5753c;
            }
        }

        public void m6247a(long j, int i, int i2, long j2) {
            boolean z = false;
            this.f5757g = false;
            this.f5758h = false;
            this.f5755e = j2;
            this.f5754d = 0;
            this.f5752b = j;
            if (i2 >= 32) {
                if (!this.f5760j && this.f5759i) {
                    m6244a(i);
                    this.f5759i = false;
                }
                if (i2 <= 34) {
                    this.f5758h = !this.f5760j;
                    this.f5760j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.f5753c = z2;
            if (this.f5753c || i2 <= 9) {
                z = true;
            }
            this.f5756f = z;
        }

        public void m6248a(byte[] bArr, int i, int i2) {
            if (this.f5756f) {
                int i3 = (i + 2) - this.f5754d;
                if (i3 < i2) {
                    this.f5757g = (bArr[i3] & 128) != 0;
                    this.f5756f = false;
                    return;
                }
                this.f5754d += i2 - i;
            }
        }
    }

    private static Format m6249a(C2074m c2074m, C2074m c2074m2, C2074m c2074m3) {
        int i;
        float f;
        Object obj = new byte[((c2074m.f5795b + c2074m2.f5795b) + c2074m3.f5795b)];
        System.arraycopy(c2074m.f5794a, 0, obj, 0, c2074m.f5795b);
        System.arraycopy(c2074m2.f5794a, 0, obj, c2074m.f5795b, c2074m2.f5795b);
        System.arraycopy(c2074m3.f5794a, 0, obj, c2074m.f5795b + c2074m2.f5795b, c2074m3.f5795b);
        C2264l c2264l = new C2264l(c2074m2.f5794a, 0, c2074m2.f5795b);
        c2264l.m7101a(44);
        int c = c2264l.m7107c(3);
        c2264l.m7101a(1);
        c2264l.m7101a(88);
        c2264l.m7101a(8);
        int i2 = 0;
        for (i = 0; i < c; i++) {
            if (c2264l.m7103a()) {
                i2 += 89;
            }
            if (c2264l.m7103a()) {
                i2 += 8;
            }
        }
        c2264l.m7101a(i2);
        if (c > 0) {
            c2264l.m7101a((8 - c) * 2);
        }
        c2264l.m7106c();
        int c2 = c2264l.m7106c();
        if (c2 == 3) {
            c2264l.m7101a(1);
        }
        int c3 = c2264l.m7106c();
        int c4 = c2264l.m7106c();
        if (c2264l.m7103a()) {
            int c5 = c2264l.m7106c();
            int c6 = c2264l.m7106c();
            int c7 = c2264l.m7106c();
            int c8 = c2264l.m7106c();
            i = (c2 == 1 || c2 == 2) ? 2 : 1;
            c3 -= i * (c5 + c6);
            c4 -= (c2 == 1 ? 2 : 1) * (c7 + c8);
        }
        c2264l.m7106c();
        c2264l.m7106c();
        i = c2264l.m7106c();
        i2 = c2264l.m7103a() ? 0 : c;
        while (i2 <= c) {
            c2264l.m7106c();
            c2264l.m7106c();
            c2264l.m7106c();
            i2++;
        }
        c2264l.m7106c();
        c2264l.m7106c();
        c2264l.m7106c();
        c2264l.m7106c();
        c2264l.m7106c();
        c2264l.m7106c();
        if (c2264l.m7103a() && c2264l.m7103a()) {
            C2071j.m6251a(c2264l);
        }
        c2264l.m7101a(2);
        if (c2264l.m7103a()) {
            c2264l.m7101a(8);
            c2264l.m7106c();
            c2264l.m7106c();
            c2264l.m7101a(1);
        }
        C2071j.m6254b(c2264l);
        if (c2264l.m7103a()) {
            for (i2 = 0; i2 < c2264l.m7106c(); i2++) {
                c2264l.m7101a((i + 4) + 1);
            }
        }
        c2264l.m7101a(2);
        float f2 = 1.0f;
        if (c2264l.m7103a() && c2264l.m7103a()) {
            c = c2264l.m7107c(8);
            if (c == 255) {
                c = c2264l.m7107c(16);
                i = c2264l.m7107c(16);
                if (!(c == 0 || i == 0)) {
                    f2 = ((float) c) / ((float) i);
                }
                f = f2;
            } else if (c < C2261i.f6447b.length) {
                f = C2261i.f6447b[c];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            return Format.m5476a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
        }
        f = 1.0f;
        return Format.m5476a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
    }

    private void m6250a(long j, int i, int i2, long j2) {
        if (this.f5766c) {
            this.f5773j.m6247a(j, i, i2, j2);
        } else {
            this.f5768e.m6274a(i2);
            this.f5769f.m6274a(i2);
            this.f5770g.m6274a(i2);
        }
        this.f5771h.m6274a(i2);
        this.f5772i.m6274a(i2);
    }

    private static void m6251a(C2264l c2264l) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (c2264l.m7103a()) {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        c2264l.m7108d();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        c2264l.m7108d();
                    }
                } else {
                    c2264l.m7106c();
                }
            }
            i++;
        }
    }

    private void m6252a(byte[] bArr, int i, int i2) {
        if (this.f5766c) {
            this.f5773j.m6248a(bArr, i, i2);
        } else {
            this.f5768e.m6275a(bArr, i, i2);
            this.f5769f.m6275a(bArr, i, i2);
            this.f5770g.m6275a(bArr, i, i2);
        }
        this.f5771h.m6275a(bArr, i, i2);
        this.f5772i.m6275a(bArr, i, i2);
    }

    private void m6253b(long j, int i, int i2, long j2) {
        if (this.f5766c) {
            this.f5773j.m6246a(j, i);
        } else {
            this.f5768e.m6277b(i2);
            this.f5769f.m6277b(i2);
            this.f5770g.m6277b(i2);
            if (this.f5768e.m6276b() && this.f5769f.m6276b() && this.f5770g.m6276b()) {
                this.f5764a.mo2978a(C2071j.m6249a(this.f5768e, this.f5769f, this.f5770g));
                this.f5766c = true;
            }
        }
        if (this.f5771h.m6277b(i2)) {
            this.f5776m.m7068a(this.f5771h.f5794a, C2261i.m7048a(this.f5771h.f5794a, this.f5771h.f5795b));
            this.f5776m.m7075d(5);
            this.f5765b.m6288a(j2, this.f5776m);
        }
        if (this.f5772i.m6277b(i2)) {
            this.f5776m.m7068a(this.f5772i.f5794a, C2261i.m7048a(this.f5772i.f5794a, this.f5772i.f5795b));
            this.f5776m.m7075d(5);
            this.f5765b.m6288a(j2, this.f5776m);
        }
    }

    private static void m6254b(C2264l c2264l) {
        int c = c2264l.m7106c();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < c) {
            boolean a = i != 0 ? c2264l.m7103a() : z;
            int i3;
            if (a) {
                c2264l.m7101a(1);
                c2264l.m7106c();
                for (i3 = 0; i3 <= i2; i3++) {
                    if (c2264l.m7103a()) {
                        c2264l.m7101a(1);
                    }
                }
            } else {
                int c2 = c2264l.m7106c();
                int c3 = c2264l.m7106c();
                i2 = c2 + c3;
                for (i3 = 0; i3 < c2; i3++) {
                    c2264l.m7106c();
                    c2264l.m7101a(1);
                }
                for (i3 = 0; i3 < c3; i3++) {
                    c2264l.m7106c();
                    c2264l.m7101a(1);
                }
            }
            i++;
            z = a;
        }
    }

    public void mo2987a() {
        C2261i.m7053a(this.f5767d);
        this.f5768e.m6273a();
        this.f5769f.m6273a();
        this.f5770g.m6273a();
        this.f5771h.m6273a();
        this.f5772i.m6273a();
        this.f5773j.m6245a();
        this.f5774k = 0;
    }

    public void mo2988a(long j, boolean z) {
        this.f5775l = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5764a = c2090h.mo3019a(c2063c.m6212a());
        this.f5765b = new C2078o(c2090h.mo3019a(c2063c.m6212a()));
    }

    public void mo2990a(C2263k c2263k) {
        while (c2263k.m7070b() > 0) {
            int d = c2263k.m7074d();
            int c = c2263k.m7072c();
            byte[] bArr = c2263k.f6454a;
            this.f5774k += (long) c2263k.m7070b();
            this.f5764a.mo2979a(c2263k, c2263k.m7070b());
            while (d < c) {
                int a = C2261i.m7049a(bArr, d, c, this.f5767d);
                if (a == c) {
                    m6252a(bArr, d, c);
                    return;
                }
                int c2 = C2261i.m7056c(bArr, a);
                int i = a - d;
                if (i > 0) {
                    m6252a(bArr, d, a);
                }
                int i2 = c - a;
                long j = this.f5774k - ((long) i2);
                m6253b(j, i2, i < 0 ? -i : 0, this.f5775l);
                m6250a(j, i2, c2, this.f5775l);
                d = a + 3;
            }
        }
    }

    public void mo2991b() {
    }
}
