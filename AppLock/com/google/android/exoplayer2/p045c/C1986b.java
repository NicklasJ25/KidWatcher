package com.google.android.exoplayer2.p045c;

import com.google.android.exoplayer2.p056i.C2222f;
import java.io.EOFException;
import java.util.Arrays;

public final class C1986b implements C1985g {
    private static final byte[] f5273a = new byte[4096];
    private final C2222f f5274b;
    private final long f5275c;
    private long f5276d;
    private byte[] f5277e = new byte[8192];
    private int f5278f;
    private int f5279g;

    public C1986b(C2222f c2222f, long j, long j2) {
        this.f5274b = c2222f;
        this.f5276d = j;
        this.f5275c = j2;
    }

    private int m5860a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a = this.f5274b.mo3094a(bArr, i + i3, i2 - i3);
        if (a != -1) {
            return i3 + a;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private int m5861d(byte[] bArr, int i, int i2) {
        if (this.f5279g == 0) {
            return 0;
        }
        int min = Math.min(this.f5279g, i2);
        System.arraycopy(this.f5277e, 0, bArr, i, min);
        m5864f(min);
        return min;
    }

    private void m5862d(int i) {
        int i2 = this.f5278f + i;
        if (i2 > this.f5277e.length) {
            this.f5277e = Arrays.copyOf(this.f5277e, Math.max(this.f5277e.length * 2, i2));
        }
    }

    private int m5863e(int i) {
        int min = Math.min(this.f5279g, i);
        m5864f(min);
        return min;
    }

    private void m5864f(int i) {
        this.f5279g -= i;
        this.f5278f = 0;
        System.arraycopy(this.f5277e, i, this.f5277e, 0, this.f5279g);
    }

    private void m5865g(int i) {
        if (i != -1) {
            this.f5276d += (long) i;
        }
    }

    public int mo2959a(int i) {
        int e = m5863e(i);
        if (e == 0) {
            e = m5860a(f5273a, 0, Math.min(i, f5273a.length), 0, true);
        }
        m5865g(e);
        return e;
    }

    public int mo2960a(byte[] bArr, int i, int i2) {
        int d = m5861d(bArr, i, i2);
        if (d == 0) {
            d = m5860a(bArr, i, i2, 0, true);
        }
        m5865g(d);
        return d;
    }

    public void mo2961a() {
        this.f5278f = 0;
    }

    public boolean m5869a(int i, boolean z) {
        int e = m5863e(i);
        while (e < i && e != -1) {
            e = m5860a(f5273a, -e, Math.min(i, f5273a.length + e), e, z);
        }
        m5865g(e);
        return e != -1;
    }

    public boolean mo2962a(byte[] bArr, int i, int i2, boolean z) {
        int d = m5861d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m5860a(bArr, i, i2, d, z);
        }
        m5865g(d);
        return d != -1;
    }

    public long mo2963b() {
        return this.f5276d + ((long) this.f5278f);
    }

    public void mo2964b(int i) {
        m5869a(i, false);
    }

    public void mo2965b(byte[] bArr, int i, int i2) {
        mo2962a(bArr, i, i2, false);
    }

    public boolean m5874b(int i, boolean z) {
        m5862d(i);
        int min = Math.min(this.f5279g - this.f5278f, i);
        while (min < i) {
            min = m5860a(this.f5277e, this.f5278f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f5278f += i;
        this.f5279g = Math.max(this.f5279g, this.f5278f);
        return true;
    }

    public boolean mo2966b(byte[] bArr, int i, int i2, boolean z) {
        if (!m5874b(i2, z)) {
            return false;
        }
        System.arraycopy(this.f5277e, this.f5278f - i2, bArr, i, i2);
        return true;
    }

    public long mo2967c() {
        return this.f5276d;
    }

    public void mo2968c(int i) {
        m5874b(i, false);
    }

    public void mo2969c(byte[] bArr, int i, int i2) {
        mo2966b(bArr, i, i2, false);
    }

    public long mo2970d() {
        return this.f5275c;
    }
}
