package org.apache.p068a.p069a.p070a;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class C3609a extends OutputStream {
    private static final byte[] f12289a = new byte[0];
    private final List<byte[]> f12290b;
    private int f12291c;
    private int f12292d;
    private byte[] f12293e;
    private int f12294f;

    public C3609a() {
        this(1024);
    }

    public C3609a(int i) {
        this.f12290b = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            m15720a(i);
        }
    }

    private void m15720a(int i) {
        if (this.f12291c < this.f12290b.size() - 1) {
            this.f12292d += this.f12293e.length;
            this.f12291c++;
            this.f12293e = (byte[]) this.f12290b.get(this.f12291c);
            return;
        }
        if (this.f12293e == null) {
            this.f12292d = 0;
        } else {
            i = Math.max(this.f12293e.length << 1, i - this.f12292d);
            this.f12292d += this.f12293e.length;
        }
        this.f12291c++;
        this.f12293e = new byte[i];
        this.f12290b.add(this.f12293e);
    }

    public synchronized byte[] m15721a() {
        byte[] bArr;
        int i = this.f12294f;
        if (i == 0) {
            bArr = f12289a;
        } else {
            Object obj = new byte[i];
            int i2 = i;
            i = 0;
            for (byte[] bArr2 : this.f12290b) {
                int min = Math.min(bArr2.length, i2);
                System.arraycopy(bArr2, 0, obj, i, min);
                int i3 = i + min;
                i = i2 - min;
                if (i == 0) {
                    break;
                }
                i2 = i;
                i = i3;
            }
            Object obj2 = obj;
        }
        return bArr2;
    }

    public void close() {
    }

    public String toString() {
        return new String(m15721a());
    }

    public synchronized void write(int i) {
        int i2 = this.f12294f - this.f12292d;
        if (i2 == this.f12293e.length) {
            m15720a(this.f12294f + 1);
            i2 = 0;
        }
        this.f12293e[i2] = (byte) i;
        this.f12294f++;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i3 = this.f12294f + i2;
                int i4 = this.f12294f - this.f12292d;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.f12293e.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.f12293e, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        m15720a(i3);
                        i4 = 0;
                    }
                }
                this.f12294f = i3;
            }
        }
    }
}
