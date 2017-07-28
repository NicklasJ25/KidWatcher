package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import java.io.EOFException;
import java.io.IOException;

final class C2030a implements C2029f {
    private final C2038e f5534a = new C2038e();
    private final long f5535b;
    private final long f5536c;
    private final C2033h f5537d;
    private int f5538e;
    private long f5539f;
    private volatile long f5540g;
    private long f5541h;
    private long f5542i;
    private long f5543j;
    private long f5544k;
    private long f5545l;
    private long f5546m;

    private class C2028a implements C1967m {
        final /* synthetic */ C2030a f5533a;

        private C2028a(C2030a c2030a) {
            this.f5533a = c2030a;
        }

        public boolean mo2943a() {
            return true;
        }

        public long mo2945b() {
            return this.f5533a.f5537d.m6103b(this.f5533a.f5539f);
        }

        public long mo2946b(long j) {
            if (j == 0) {
                this.f5533a.f5540g = 0;
                return this.f5533a.f5535b;
            }
            this.f5533a.f5540g = this.f5533a.f5537d.m6105c(j);
            return this.f5533a.m6073a(this.f5533a.f5535b, this.f5533a.f5540g, 30000);
        }
    }

    public C2030a(long j, long j2, C2033h c2033h) {
        boolean z = j >= 0 && j2 > j;
        C2252a.m7022a(z);
        this.f5537d = c2033h;
        this.f5535b = j;
        this.f5536c = j2;
        this.f5538e = 0;
    }

    private long m6073a(long j, long j2, long j3) {
        long j4 = ((((this.f5536c - this.f5535b) * j2) / this.f5539f) - j3) + j;
        if (j4 < this.f5535b) {
            j4 = this.f5535b;
        }
        return j4 >= this.f5536c ? this.f5536c - 1 : j4;
    }

    public long m6080a(long j, C1985g c1985g) {
        if (this.f5543j == this.f5544k) {
            return -(this.f5545l + 2);
        }
        long c = c1985g.mo2967c();
        if (m6083a(c1985g, this.f5544k)) {
            this.f5534a.m6126a(c1985g, false);
            c1985g.mo2961a();
            long j2 = j - this.f5534a.f5579c;
            int i = this.f5534a.f5584h + this.f5534a.f5585i;
            if (j2 < 0 || j2 > 72000) {
                if (j2 < 0) {
                    this.f5544k = c;
                    this.f5546m = this.f5534a.f5579c;
                } else {
                    this.f5543j = c1985g.mo2967c() + ((long) i);
                    this.f5545l = this.f5534a.f5579c;
                    if ((this.f5544k - this.f5543j) + ((long) i) < 100000) {
                        c1985g.mo2964b(i);
                        return -(this.f5545l + 2);
                    }
                }
                if (this.f5544k - this.f5543j < 100000) {
                    this.f5544k = this.f5543j;
                    return this.f5543j;
                }
                return Math.min(Math.max((c1985g.mo2967c() - ((long) ((j2 <= 0 ? 2 : 1) * i))) + ((j2 * (this.f5544k - this.f5543j)) / (this.f5546m - this.f5545l)), this.f5543j), this.f5544k - 1);
            }
            c1985g.mo2964b(i);
            return -(this.f5534a.f5579c + 2);
        } else if (this.f5543j != c) {
            return this.f5543j;
        } else {
            throw new IOException("No ogg page can be found.");
        }
    }

    public long mo2980a(C1985g c1985g) {
        long j = 0;
        switch (this.f5538e) {
            case 0:
                this.f5541h = c1985g.mo2967c();
                this.f5538e = 1;
                j = this.f5536c - 65307;
                if (j > this.f5541h) {
                    return j;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.f5542i != 0) {
                    long a = m6080a(this.f5542i, c1985g);
                    if (a >= 0) {
                        return a;
                    }
                    C1985g c1985g2 = c1985g;
                    j = m6082a(c1985g2, this.f5542i, -(a + 2));
                }
                this.f5538e = 3;
                return -(j + 2);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
        this.f5539f = m6086c(c1985g);
        this.f5538e = 3;
        return this.f5541h;
    }

    long m6082a(C1985g c1985g, long j, long j2) {
        this.f5534a.m6126a(c1985g, false);
        while (this.f5534a.f5579c < j) {
            c1985g.mo2964b(this.f5534a.f5584h + this.f5534a.f5585i);
            j2 = this.f5534a.f5579c;
            this.f5534a.m6126a(c1985g, false);
        }
        c1985g.mo2961a();
        return j2;
    }

    boolean m6083a(C1985g c1985g, long j) {
        long min = Math.min(3 + j, this.f5536c);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (c1985g.mo2967c() + ((long) length) > min) {
                length = (int) (min - c1985g.mo2967c());
                if (length < 4) {
                    return false;
                }
            }
            c1985g.mo2966b(bArr, 0, length, false);
            int i = 0;
            while (i < length - 3) {
                if (bArr[i] == (byte) 79 && bArr[i + 1] == (byte) 103 && bArr[i + 2] == (byte) 103 && bArr[i + 3] == (byte) 83) {
                    c1985g.mo2964b(i);
                    return true;
                }
                i++;
            }
            c1985g.mo2964b(length - 3);
        }
    }

    public C2028a m6084b() {
        return this.f5539f != 0 ? new C2028a() : null;
    }

    void m6085b(C1985g c1985g) {
        if (!m6083a(c1985g, this.f5536c)) {
            throw new EOFException();
        }
    }

    long m6086c(C1985g c1985g) {
        m6085b(c1985g);
        this.f5534a.m6125a();
        while ((this.f5534a.f5578b & 4) != 4 && c1985g.mo2967c() < this.f5536c) {
            this.f5534a.m6126a(c1985g, false);
            c1985g.mo2964b(this.f5534a.f5584h + this.f5534a.f5585i);
        }
        return this.f5534a.f5579c;
    }

    public void m6087c() {
        this.f5543j = this.f5535b;
        this.f5544k = this.f5536c;
        this.f5545l = 0;
        this.f5546m = this.f5539f;
    }

    public long c_() {
        boolean z = this.f5538e == 3 || this.f5538e == 2;
        C2252a.m7022a(z);
        this.f5542i = this.f5540g;
        this.f5538e = 2;
        m6087c();
        return this.f5542i;
    }

    public /* synthetic */ C1967m mo2982d() {
        return m6084b();
    }
}
