package com.google.android.exoplayer2.p045c.p051f;

import android.support.v4.view.InputDeviceCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m.C2094a;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p045c.C2095n;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

public final class C2077n implements C1966f {
    public static final C1964i f5807a = new C20751();
    private final C2095n f5808b;
    private final SparseArray<C2076a> f5809c;
    private final C2263k f5810d;
    private boolean f5811e;
    private boolean f5812f;
    private boolean f5813g;
    private C2090h f5814h;

    static class C20751 implements C1964i {
        C20751() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2077n()};
        }
    }

    private static final class C2076a {
        private final C2054g f5799a;
        private final C2095n f5800b;
        private final C2262j f5801c = new C2262j(new byte[64]);
        private boolean f5802d;
        private boolean f5803e;
        private boolean f5804f;
        private int f5805g;
        private long f5806h;

        public C2076a(C2054g c2054g, C2095n c2095n) {
            this.f5799a = c2054g;
            this.f5800b = c2095n;
        }

        private void m6279b() {
            this.f5801c.m7061b(8);
            this.f5802d = this.f5801c.m7062b();
            this.f5803e = this.f5801c.m7062b();
            this.f5801c.m7061b(6);
            this.f5805g = this.f5801c.m7063c(8);
        }

        private void m6280c() {
            this.f5806h = 0;
            if (this.f5802d) {
                this.f5801c.m7061b(4);
                long c = ((long) this.f5801c.m7063c(3)) << 30;
                this.f5801c.m7061b(1);
                c |= (long) (this.f5801c.m7063c(15) << 15);
                this.f5801c.m7061b(1);
                c |= (long) this.f5801c.m7063c(15);
                this.f5801c.m7061b(1);
                if (!this.f5804f && this.f5803e) {
                    this.f5801c.m7061b(4);
                    long c2 = ((long) this.f5801c.m7063c(3)) << 30;
                    this.f5801c.m7061b(1);
                    c2 |= (long) (this.f5801c.m7063c(15) << 15);
                    this.f5801c.m7061b(1);
                    c2 |= (long) this.f5801c.m7063c(15);
                    this.f5801c.m7061b(1);
                    this.f5800b.m6357a(c2);
                    this.f5804f = true;
                }
                this.f5806h = this.f5800b.m6357a(c);
            }
        }

        public void m6281a() {
            this.f5804f = false;
            this.f5799a.mo2987a();
        }

        public void m6282a(C2263k c2263k) {
            c2263k.m7069a(this.f5801c.f6450a, 0, 3);
            this.f5801c.m7060a(0);
            m6279b();
            c2263k.m7069a(this.f5801c.f6450a, 0, this.f5805g);
            this.f5801c.m7060a(0);
            m6280c();
            this.f5799a.mo2988a(this.f5806h, true);
            this.f5799a.mo2990a(c2263k);
            this.f5799a.mo2991b();
        }
    }

    public C2077n() {
        this(new C2095n(0));
    }

    public C2077n(C2095n c2095n) {
        this.f5808b = c2095n;
        this.f5810d = new C2263k(4096);
        this.f5809c = new SparseArray();
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        if (!c1985g.mo2966b(this.f5810d.f6454a, 0, 4, true)) {
            return -1;
        }
        this.f5810d.m7073c(0);
        int n = this.f5810d.m7086n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            c1985g.mo2969c(this.f5810d.f6454a, 0, 10);
            this.f5810d.m7073c(9);
            c1985g.mo2964b((this.f5810d.m7079g() & 7) + 14);
            return 0;
        } else if (n == 443) {
            c1985g.mo2969c(this.f5810d.f6454a, 0, 2);
            this.f5810d.m7073c(0);
            c1985g.mo2964b(this.f5810d.m7080h() + 6);
            return 0;
        } else if (((n & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            c1985g.mo2964b(1);
            return 0;
        } else {
            int i = n & 255;
            C2076a c2076a = (C2076a) this.f5809c.get(i);
            if (!this.f5811e) {
                if (c2076a == null) {
                    C2054g c2054g = null;
                    if (!this.f5812f && i == 189) {
                        c2054g = new C2055b();
                        this.f5812f = true;
                    } else if (!this.f5812f && (i & 224) == 192) {
                        c2054g = new C2073l();
                        this.f5812f = true;
                    } else if (!this.f5813g && (i & 240) == 224) {
                        c2054g = new C2065h();
                        this.f5813g = true;
                    }
                    if (c2054g != null) {
                        c2054g.mo2989a(this.f5814h, new C2063c(i, 256));
                        c2076a = new C2076a(c2054g, this.f5808b);
                        this.f5809c.put(i, c2076a);
                    }
                }
                if ((this.f5812f && this.f5813g) || c1985g.mo2967c() > 1048576) {
                    this.f5811e = true;
                    this.f5814h.mo3020a();
                }
            }
            c1985g.mo2969c(this.f5810d.f6454a, 0, 2);
            this.f5810d.m7073c(0);
            n = this.f5810d.m7080h() + 6;
            if (c2076a == null) {
                c1985g.mo2964b(n);
            } else {
                this.f5810d.m7066a(n);
                c1985g.mo2965b(this.f5810d.f6454a, 0, n);
                this.f5810d.m7073c(6);
                c2076a.m6282a(this.f5810d);
                this.f5810d.m7071b(this.f5810d.m7076e());
            }
            return 0;
        }
    }

    public void mo2941a(long j) {
        this.f5808b.m6358a();
        for (int i = 0; i < this.f5809c.size(); i++) {
            ((C2076a) this.f5809c.valueAt(i)).m6281a();
        }
    }

    public void mo2942a(C2090h c2090h) {
        this.f5814h = c2090h;
        c2090h.mo3022a(new C2094a(-9223372036854775807L));
    }

    public boolean mo2944a(C1985g c1985g) {
        boolean z = true;
        byte[] bArr = new byte[14];
        c1985g.mo2969c(bArr, 0, 14);
        if (442 != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        c1985g.mo2968c(bArr[13] & 7);
        c1985g.mo2969c(bArr, 0, 3);
        if (1 != ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)))) {
            z = false;
        }
        return z;
    }

    public void mo2947c() {
    }
}
