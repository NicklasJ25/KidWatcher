package com.google.android.gms.internal;

public final class lx implements Cloneable {
    private static final ly f9739a = new ly();
    private boolean f9740b;
    private int[] f9741c;
    private ly[] f9742d;
    private int f9743e;

    lx() {
        this(10);
    }

    lx(int i) {
        this.f9740b = false;
        int c = m12432c(i);
        this.f9741c = new int[c];
        this.f9742d = new ly[c];
        this.f9743e = 0;
    }

    private boolean m12430a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m12431a(ly[] lyVarArr, ly[] lyVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!lyVarArr[i2].equals(lyVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m12432c(int i) {
        return m12433d(i * 4) / 4;
    }

    private int m12433d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m12434e(int i) {
        int i2 = 0;
        int i3 = this.f9743e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f9741c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m12435a() {
        return this.f9743e;
    }

    ly m12436a(int i) {
        int e = m12434e(i);
        return (e < 0 || this.f9742d[e] == f9739a) ? null : this.f9742d[e];
    }

    void m12437a(int i, ly lyVar) {
        int e = m12434e(i);
        if (e >= 0) {
            this.f9742d[e] = lyVar;
            return;
        }
        e ^= -1;
        if (e >= this.f9743e || this.f9742d[e] != f9739a) {
            if (this.f9743e >= this.f9741c.length) {
                int c = m12432c(this.f9743e + 1);
                Object obj = new int[c];
                Object obj2 = new ly[c];
                System.arraycopy(this.f9741c, 0, obj, 0, this.f9741c.length);
                System.arraycopy(this.f9742d, 0, obj2, 0, this.f9742d.length);
                this.f9741c = obj;
                this.f9742d = obj2;
            }
            if (this.f9743e - e != 0) {
                System.arraycopy(this.f9741c, e, this.f9741c, e + 1, this.f9743e - e);
                System.arraycopy(this.f9742d, e, this.f9742d, e + 1, this.f9743e - e);
            }
            this.f9741c[e] = i;
            this.f9742d[e] = lyVar;
            this.f9743e++;
            return;
        }
        this.f9741c[e] = i;
        this.f9742d[e] = lyVar;
    }

    ly m12438b(int i) {
        return this.f9742d[i];
    }

    public boolean m12439b() {
        return m12435a() == 0;
    }

    public final lx m12440c() {
        int a = m12435a();
        lx lxVar = new lx(a);
        System.arraycopy(this.f9741c, 0, lxVar.f9741c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f9742d[i] != null) {
                lxVar.f9742d[i] = (ly) this.f9742d[i].clone();
            }
        }
        lxVar.f9743e = a;
        return lxVar;
    }

    public /* synthetic */ Object clone() {
        return m12440c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lx)) {
            return false;
        }
        lx lxVar = (lx) obj;
        return m12435a() != lxVar.m12435a() ? false : m12430a(this.f9741c, lxVar.f9741c, this.f9743e) && m12431a(this.f9742d, lxVar.f9742d, this.f9743e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f9743e; i2++) {
            i = (((i * 31) + this.f9741c[i2]) * 31) + this.f9742d[i2].hashCode();
        }
        return i;
    }
}
