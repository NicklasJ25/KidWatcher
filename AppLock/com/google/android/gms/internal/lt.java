package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;

public final class lt {
    private final byte[] f9724a;
    private int f9725b;
    private int f9726c;
    private int f9727d;
    private int f9728e;
    private int f9729f;
    private int f9730g = Integer.MAX_VALUE;
    private int f9731h;
    private int f9732i = 64;
    private int f9733j = 67108864;

    private lt(byte[] bArr, int i, int i2) {
        this.f9724a = bArr;
        this.f9725b = i;
        this.f9726c = i + i2;
        this.f9728e = i;
    }

    public static long m12331a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static lt m12332a(byte[] bArr) {
        return m12333a(bArr, 0, bArr.length);
    }

    public static lt m12333a(byte[] bArr, int i, int i2) {
        return new lt(bArr, i, i2);
    }

    private void m12334t() {
        this.f9726c += this.f9727d;
        int i = this.f9726c;
        if (i > this.f9730g) {
            this.f9727d = i - this.f9730g;
            this.f9726c -= this.f9727d;
            return;
        }
        this.f9727d = 0;
    }

    public int m12335a() {
        if (m12359q()) {
            this.f9729f = 0;
            return 0;
        }
        this.f9729f = m12354l();
        if (this.f9729f != 0) {
            return this.f9729f;
        }
        throw ma.m12492d();
    }

    public void m12336a(int i) {
        if (this.f9729f != i) {
            throw ma.m12493e();
        }
    }

    public void m12337a(mb mbVar) {
        int l = m12354l();
        if (this.f9731h >= this.f9732i) {
            throw ma.m12495g();
        }
        l = m12342c(l);
        this.f9731h++;
        mbVar.mo3509b(this);
        m12336a(0);
        this.f9731h--;
        m12344d(l);
    }

    public byte[] m12338a(int i, int i2) {
        if (i2 == 0) {
            return me.f9784l;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f9724a, this.f9725b + i, obj, 0, i2);
        return obj;
    }

    public void m12339b() {
        int a;
        do {
            a = m12335a();
            if (a == 0) {
                return;
            }
        } while (m12340b(a));
    }

    public boolean m12340b(int i) {
        switch (me.m12504a(i)) {
            case 0:
                m12349g();
                return true;
            case 1:
                m12357o();
                return true;
            case 2:
                m12348f(m12354l());
                return true;
            case 3:
                m12339b();
                m12336a(me.m12505a(me.m12507b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m12356n();
                return true;
            default:
                throw ma.m12494f();
        }
    }

    public double m12341c() {
        return Double.longBitsToDouble(m12357o());
    }

    public int m12342c(int i) {
        if (i < 0) {
            throw ma.m12490b();
        }
        int i2 = this.f9728e + i;
        int i3 = this.f9730g;
        if (i2 > i3) {
            throw ma.m12489a();
        }
        this.f9730g = i2;
        m12334t();
        return i3;
    }

    public float m12343d() {
        return Float.intBitsToFloat(m12356n());
    }

    public void m12344d(int i) {
        this.f9730g = i;
        m12334t();
    }

    public long m12345e() {
        return m12355m();
    }

    public void m12346e(int i) {
        if (i > this.f9728e - this.f9725b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f9728e - this.f9725b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f9728e = this.f9725b + i;
        }
    }

    public long m12347f() {
        return m12355m();
    }

    public void m12348f(int i) {
        if (i < 0) {
            throw ma.m12490b();
        } else if (this.f9728e + i > this.f9730g) {
            m12348f(this.f9730g - this.f9728e);
            throw ma.m12489a();
        } else if (i <= this.f9726c - this.f9728e) {
            this.f9728e += i;
        } else {
            throw ma.m12489a();
        }
    }

    public int m12349g() {
        return m12354l();
    }

    public boolean m12350h() {
        return m12354l() != 0;
    }

    public String m12351i() {
        int l = m12354l();
        if (l < 0) {
            throw ma.m12490b();
        } else if (l > this.f9726c - this.f9728e) {
            throw ma.m12489a();
        } else {
            String str = new String(this.f9724a, this.f9728e, l, lz.f9747a);
            this.f9728e = l + this.f9728e;
            return str;
        }
    }

    public byte[] m12352j() {
        int l = m12354l();
        if (l < 0) {
            throw ma.m12490b();
        } else if (l == 0) {
            return me.f9784l;
        } else {
            if (l > this.f9726c - this.f9728e) {
                throw ma.m12489a();
            }
            Object obj = new byte[l];
            System.arraycopy(this.f9724a, this.f9728e, obj, 0, l);
            this.f9728e = l + this.f9728e;
            return obj;
        }
    }

    public long m12353k() {
        return m12331a(m12355m());
    }

    public int m12354l() {
        byte s = m12361s();
        if (s >= (byte) 0) {
            return s;
        }
        int i = s & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte s2 = m12361s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 7);
        }
        i |= (s2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        s2 = m12361s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 14);
        }
        i |= (s2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        s2 = m12361s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 21);
        }
        i |= (s2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        s2 = m12361s();
        i |= s2 << 28;
        if (s2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m12361s() >= (byte) 0) {
                return i;
            }
        }
        throw ma.m12491c();
    }

    public long m12355m() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte s = m12361s();
            j |= ((long) (s & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((s & 128) == 0) {
                return j;
            }
        }
        throw ma.m12491c();
    }

    public int m12356n() {
        return (((m12361s() & 255) | ((m12361s() & 255) << 8)) | ((m12361s() & 255) << 16)) | ((m12361s() & 255) << 24);
    }

    public long m12357o() {
        byte s = m12361s();
        byte s2 = m12361s();
        return ((((((((((long) s2) & 255) << 8) | (((long) s) & 255)) | ((((long) m12361s()) & 255) << 16)) | ((((long) m12361s()) & 255) << 24)) | ((((long) m12361s()) & 255) << 32)) | ((((long) m12361s()) & 255) << 40)) | ((((long) m12361s()) & 255) << 48)) | ((((long) m12361s()) & 255) << 56);
    }

    public int m12358p() {
        if (this.f9730g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f9730g - this.f9728e;
    }

    public boolean m12359q() {
        return this.f9728e == this.f9726c;
    }

    public int m12360r() {
        return this.f9728e - this.f9725b;
    }

    public byte m12361s() {
        if (this.f9728e == this.f9726c) {
            throw ma.m12489a();
        }
        byte[] bArr = this.f9724a;
        int i = this.f9728e;
        this.f9728e = i + 1;
        return bArr[i];
    }
}
