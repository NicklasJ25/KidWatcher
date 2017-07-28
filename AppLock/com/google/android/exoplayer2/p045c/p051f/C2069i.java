package com.google.android.exoplayer2.p045c.p051f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2261i.C2259a;
import com.google.android.exoplayer2.p043j.C2261i.C2260b;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2264l;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class C2069i extends C2054g {
    private final boolean f5738a;
    private final boolean f5739b;
    private final C2074m f5740c;
    private final C2074m f5741d;
    private final C2074m f5742e;
    private long f5743f;
    private final boolean[] f5744g = new boolean[3];
    private C2025o f5745h;
    private C2078o f5746i;
    private C2068a f5747j;
    private boolean f5748k;
    private long f5749l;
    private final C2263k f5750m;

    private static final class C2068a {
        private final C2025o f5720a;
        private final boolean f5721b;
        private final boolean f5722c;
        private final SparseArray<C2260b> f5723d = new SparseArray();
        private final SparseArray<C2259a> f5724e = new SparseArray();
        private final C2264l f5725f = new C2264l(this.f5726g, 0, 0);
        private byte[] f5726g = new byte[128];
        private int f5727h;
        private int f5728i;
        private long f5729j;
        private boolean f5730k;
        private long f5731l;
        private C2067a f5732m = new C2067a();
        private C2067a f5733n = new C2067a();
        private boolean f5734o;
        private long f5735p;
        private long f5736q;
        private boolean f5737r;

        private static final class C2067a {
            private boolean f5704a;
            private boolean f5705b;
            private C2260b f5706c;
            private int f5707d;
            private int f5708e;
            private int f5709f;
            private int f5710g;
            private boolean f5711h;
            private boolean f5712i;
            private boolean f5713j;
            private boolean f5714k;
            private int f5715l;
            private int f5716m;
            private int f5717n;
            private int f5718o;
            private int f5719p;

            private C2067a() {
            }

            private boolean m6222a(C2067a c2067a) {
                if (this.f5704a) {
                    if (!c2067a.f5704a || this.f5709f != c2067a.f5709f || this.f5710g != c2067a.f5710g || this.f5711h != c2067a.f5711h) {
                        return true;
                    }
                    if (this.f5712i && c2067a.f5712i && this.f5713j != c2067a.f5713j) {
                        return true;
                    }
                    if (this.f5707d != c2067a.f5707d && (this.f5707d == 0 || c2067a.f5707d == 0)) {
                        return true;
                    }
                    if (this.f5706c.f6443h == 0 && c2067a.f5706c.f6443h == 0 && (this.f5716m != c2067a.f5716m || this.f5717n != c2067a.f5717n)) {
                        return true;
                    }
                    if ((this.f5706c.f6443h == 1 && c2067a.f5706c.f6443h == 1 && (this.f5718o != c2067a.f5718o || this.f5719p != c2067a.f5719p)) || this.f5714k != c2067a.f5714k) {
                        return true;
                    }
                    if (this.f5714k && c2067a.f5714k && this.f5715l != c2067a.f5715l) {
                        return true;
                    }
                }
                return false;
            }

            public void m6224a() {
                this.f5705b = false;
                this.f5704a = false;
            }

            public void m6225a(int i) {
                this.f5708e = i;
                this.f5705b = true;
            }

            public void m6226a(C2260b c2260b, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f5706c = c2260b;
                this.f5707d = i;
                this.f5708e = i2;
                this.f5709f = i3;
                this.f5710g = i4;
                this.f5711h = z;
                this.f5712i = z2;
                this.f5713j = z3;
                this.f5714k = z4;
                this.f5715l = i5;
                this.f5716m = i6;
                this.f5717n = i7;
                this.f5718o = i8;
                this.f5719p = i9;
                this.f5704a = true;
                this.f5705b = true;
            }

            public boolean m6227b() {
                return this.f5705b && (this.f5708e == 7 || this.f5708e == 2);
            }
        }

        public C2068a(C2025o c2025o, boolean z, boolean z2) {
            this.f5720a = c2025o;
            this.f5721b = z;
            this.f5722c = z2;
            m6235b();
        }

        private void m6228a(int i) {
            this.f5720a.mo2977a(this.f5736q, this.f5737r ? 1 : 0, (int) (this.f5729j - this.f5735p), i, null);
        }

        public void m6229a(long j, int i) {
            int i2 = 0;
            if (this.f5728i == 9 || (this.f5722c && this.f5733n.m6222a(this.f5732m))) {
                if (this.f5734o) {
                    m6228a(((int) (j - this.f5729j)) + i);
                }
                this.f5735p = this.f5729j;
                this.f5736q = this.f5731l;
                this.f5737r = false;
                this.f5734o = true;
            }
            boolean z = this.f5737r;
            if (this.f5728i == 5 || (this.f5721b && this.f5728i == 1 && this.f5733n.m6227b())) {
                i2 = 1;
            }
            this.f5737r = i2 | z;
        }

        public void m6230a(long j, int i, long j2) {
            this.f5728i = i;
            this.f5731l = j2;
            this.f5729j = j;
            if (!(this.f5721b && this.f5728i == 1)) {
                if (!this.f5722c) {
                    return;
                }
                if (!(this.f5728i == 5 || this.f5728i == 1 || this.f5728i == 2)) {
                    return;
                }
            }
            C2067a c2067a = this.f5732m;
            this.f5732m = this.f5733n;
            this.f5733n = c2067a;
            this.f5733n.m6224a();
            this.f5727h = 0;
            this.f5730k = true;
        }

        public void m6231a(C2259a c2259a) {
            this.f5724e.append(c2259a.f6433a, c2259a);
        }

        public void m6232a(C2260b c2260b) {
            this.f5723d.append(c2260b.f6436a, c2260b);
        }

        public void m6233a(byte[] bArr, int i, int i2) {
            if (this.f5730k) {
                int i3 = i2 - i;
                if (this.f5726g.length < this.f5727h + i3) {
                    this.f5726g = Arrays.copyOf(this.f5726g, (this.f5727h + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f5726g, this.f5727h, i3);
                this.f5727h = i3 + this.f5727h;
                this.f5725f.m7102a(this.f5726g, 0, this.f5727h);
                if (this.f5725f.m7105b(8)) {
                    this.f5725f.m7101a(1);
                    int c = this.f5725f.m7107c(2);
                    this.f5725f.m7101a(5);
                    if (this.f5725f.m7104b()) {
                        this.f5725f.m7106c();
                        if (this.f5725f.m7104b()) {
                            int c2 = this.f5725f.m7106c();
                            if (!this.f5722c) {
                                this.f5730k = false;
                                this.f5733n.m6225a(c2);
                            } else if (this.f5725f.m7104b()) {
                                int c3 = this.f5725f.m7106c();
                                if (this.f5724e.indexOfKey(c3) < 0) {
                                    this.f5730k = false;
                                    return;
                                }
                                C2259a c2259a = (C2259a) this.f5724e.get(c3);
                                C2260b c2260b = (C2260b) this.f5723d.get(c2259a.f6434b);
                                if (c2260b.f6440e) {
                                    if (this.f5725f.m7105b(2)) {
                                        this.f5725f.m7101a(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.f5725f.m7105b(c2260b.f6442g)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int c4 = this.f5725f.m7107c(c2260b.f6442g);
                                    if (!c2260b.f6441f) {
                                        if (this.f5725f.m7105b(1)) {
                                            z = this.f5725f.m7103a();
                                            if (z) {
                                                if (this.f5725f.m7105b(1)) {
                                                    z3 = this.f5725f.m7103a();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    boolean z4 = this.f5728i == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.f5725f.m7104b()) {
                                            i4 = this.f5725f.m7106c();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (c2260b.f6443h == 0) {
                                        if (this.f5725f.m7105b(c2260b.f6444i)) {
                                            i5 = this.f5725f.m7107c(c2260b.f6444i);
                                            if (c2259a.f6435c && !z) {
                                                if (this.f5725f.m7104b()) {
                                                    i6 = this.f5725f.m7108d();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    } else if (c2260b.f6443h == 1 && !c2260b.f6445j) {
                                        if (this.f5725f.m7104b()) {
                                            i7 = this.f5725f.m7108d();
                                            if (c2259a.f6435c && !z) {
                                                if (this.f5725f.m7104b()) {
                                                    i8 = this.f5725f.m7108d();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    this.f5733n.m6226a(c2260b, c, c2, c4, c3, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.f5730k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean m6234a() {
            return this.f5722c;
        }

        public void m6235b() {
            this.f5730k = false;
            this.f5734o = false;
            this.f5733n.m6224a();
        }
    }

    public C2069i(boolean z, boolean z2) {
        this.f5738a = z;
        this.f5739b = z2;
        this.f5740c = new C2074m(7, 128);
        this.f5741d = new C2074m(8, 128);
        this.f5742e = new C2074m(6, 128);
        this.f5750m = new C2263k();
    }

    private void m6236a(long j, int i, int i2, long j2) {
        if (!this.f5748k || this.f5747j.m6234a()) {
            this.f5740c.m6277b(i2);
            this.f5741d.m6277b(i2);
            if (this.f5748k) {
                if (this.f5740c.m6276b()) {
                    this.f5747j.m6232a(C2261i.m7050a(this.f5740c.f5794a, 3, this.f5740c.f5795b));
                    this.f5740c.m6273a();
                } else if (this.f5741d.m6276b()) {
                    this.f5747j.m6231a(C2261i.m7055b(this.f5741d.f5794a, 3, this.f5741d.f5795b));
                    this.f5741d.m6273a();
                }
            } else if (this.f5740c.m6276b() && this.f5741d.m6276b()) {
                List arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(this.f5740c.f5794a, this.f5740c.f5795b));
                arrayList.add(Arrays.copyOf(this.f5741d.f5794a, this.f5741d.f5795b));
                C2260b a = C2261i.m7050a(this.f5740c.f5794a, 3, this.f5740c.f5795b);
                C2259a b = C2261i.m7055b(this.f5741d.f5794a, 3, this.f5741d.f5795b);
                this.f5745h.mo2978a(Format.m5476a(null, "video/avc", null, -1, -1, a.f6437b, a.f6438c, -1.0f, arrayList, -1, a.f6439d, null));
                this.f5748k = true;
                this.f5747j.m6232a(a);
                this.f5747j.m6231a(b);
                this.f5740c.m6273a();
                this.f5741d.m6273a();
            }
        }
        if (this.f5742e.m6277b(i2)) {
            this.f5750m.m7068a(this.f5742e.f5794a, C2261i.m7048a(this.f5742e.f5794a, this.f5742e.f5795b));
            this.f5750m.m7073c(4);
            this.f5746i.m6288a(j2, this.f5750m);
        }
        this.f5747j.m6229a(j, i);
    }

    private void m6237a(long j, int i, long j2) {
        if (!this.f5748k || this.f5747j.m6234a()) {
            this.f5740c.m6274a(i);
            this.f5741d.m6274a(i);
        }
        this.f5742e.m6274a(i);
        this.f5747j.m6230a(j, i, j2);
    }

    private void m6238a(byte[] bArr, int i, int i2) {
        if (!this.f5748k || this.f5747j.m6234a()) {
            this.f5740c.m6275a(bArr, i, i2);
            this.f5741d.m6275a(bArr, i, i2);
        }
        this.f5742e.m6275a(bArr, i, i2);
        this.f5747j.m6233a(bArr, i, i2);
    }

    public void mo2987a() {
        C2261i.m7053a(this.f5744g);
        this.f5740c.m6273a();
        this.f5741d.m6273a();
        this.f5742e.m6273a();
        this.f5747j.m6235b();
        this.f5743f = 0;
    }

    public void mo2988a(long j, boolean z) {
        this.f5749l = j;
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5745h = c2090h.mo3019a(c2063c.m6212a());
        this.f5747j = new C2068a(this.f5745h, this.f5738a, this.f5739b);
        this.f5746i = new C2078o(c2090h.mo3019a(c2063c.m6212a()));
    }

    public void mo2990a(C2263k c2263k) {
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        byte[] bArr = c2263k.f6454a;
        this.f5743f += (long) c2263k.m7070b();
        this.f5745h.mo2979a(c2263k, c2263k.m7070b());
        while (true) {
            int a = C2261i.m7049a(bArr, d, c, this.f5744g);
            if (a == c) {
                m6238a(bArr, d, c);
                return;
            }
            int b = C2261i.m7054b(bArr, a);
            int i = a - d;
            if (i > 0) {
                m6238a(bArr, d, a);
            }
            int i2 = c - a;
            long j = this.f5743f - ((long) i2);
            m6236a(j, i2, i < 0 ? -i : 0, this.f5749l);
            m6237a(j, b, this.f5749l);
            d = a + 3;
        }
    }

    public void mo2991b() {
    }
}
