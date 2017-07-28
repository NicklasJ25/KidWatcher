package com.google.android.exoplayer2.p045c.p047b;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p045c.C1985g;
import java.util.Stack;

final class C1977a implements C1976b {
    private final byte[] f5181a = new byte[8];
    private final Stack<C1975a> f5182b = new Stack();
    private final C1984f f5183c = new C1984f();
    private C1978c f5184d;
    private int f5185e;
    private int f5186f;
    private long f5187g;

    private static final class C1975a {
        private final int f5179a;
        private final long f5180b;

        private C1975a(int i, long j) {
            this.f5179a = i;
            this.f5180b = j;
        }
    }

    C1977a() {
    }

    private long m5785a(C1985g c1985g, int i) {
        int i2 = 0;
        c1985g.mo2965b(this.f5181a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f5181a[i2] & 255));
            i2++;
        }
        return j;
    }

    private double m5786b(C1985g c1985g, int i) {
        long a = m5785a(c1985g, i);
        return i == 4 ? (double) Float.intBitsToFloat((int) a) : Double.longBitsToDouble(a);
    }

    private long m5787b(C1985g c1985g) {
        c1985g.mo2961a();
        while (true) {
            c1985g.mo2969c(this.f5181a, 0, 4);
            int a = C1984f.m5843a(this.f5181a[0]);
            if (a != -1 && a <= 4) {
                int a2 = (int) C1984f.m5844a(this.f5181a, a, false);
                if (this.f5184d.mo2957b(a2)) {
                    c1985g.mo2964b(a);
                    return (long) a2;
                }
            }
            c1985g.mo2964b(1);
        }
    }

    private String m5788c(C1985g c1985g, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        c1985g.mo2965b(bArr, 0, i);
        return new String(bArr);
    }

    public void mo2948a() {
        this.f5185e = 0;
        this.f5182b.clear();
        this.f5183c.m5846a();
    }

    public void mo2949a(C1978c c1978c) {
        this.f5184d = c1978c;
    }

    public boolean mo2950a(C1985g c1985g) {
        C2252a.m7024b(this.f5184d != null);
        while (true) {
            if (this.f5182b.isEmpty() || c1985g.mo2967c() < ((C1975a) this.f5182b.peek()).f5180b) {
                if (this.f5185e == 0) {
                    long a = this.f5183c.m5845a(c1985g, true, false, 4);
                    if (a == -2) {
                        a = m5787b(c1985g);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.f5186f = (int) a;
                    this.f5185e = 1;
                }
                if (this.f5185e == 1) {
                    this.f5187g = this.f5183c.m5845a(c1985g, false, true, 8);
                    this.f5185e = 2;
                }
                int a2 = this.f5184d.mo2951a(this.f5186f);
                switch (a2) {
                    case 0:
                        c1985g.mo2964b((int) this.f5187g);
                        this.f5185e = 0;
                    case 1:
                        long c = c1985g.mo2967c();
                        this.f5182b.add(new C1975a(this.f5186f, this.f5187g + c));
                        this.f5184d.mo2955a(this.f5186f, c, this.f5187g);
                        this.f5185e = 0;
                        return true;
                    case 2:
                        if (this.f5187g > 8) {
                            throw new C1970k("Invalid integer size: " + this.f5187g);
                        }
                        this.f5184d.mo2954a(this.f5186f, m5785a(c1985g, (int) this.f5187g));
                        this.f5185e = 0;
                        return true;
                    case 3:
                        if (this.f5187g > 2147483647L) {
                            throw new C1970k("String element size: " + this.f5187g);
                        }
                        this.f5184d.mo2956a(this.f5186f, m5788c(c1985g, (int) this.f5187g));
                        this.f5185e = 0;
                        return true;
                    case 4:
                        this.f5184d.mo2953a(this.f5186f, (int) this.f5187g, c1985g);
                        this.f5185e = 0;
                        return true;
                    case 5:
                        if (this.f5187g == 4 || this.f5187g == 8) {
                            this.f5184d.mo2952a(this.f5186f, m5786b(c1985g, (int) this.f5187g));
                            this.f5185e = 0;
                            return true;
                        }
                        throw new C1970k("Invalid float size: " + this.f5187g);
                    default:
                        throw new C1970k("Invalid element type " + a2);
                }
            }
            this.f5184d.mo2958c(((C1975a) this.f5182b.pop()).f5179a);
            return true;
        }
    }
}
