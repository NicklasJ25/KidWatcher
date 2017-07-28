package com.google.android.exoplayer2.p045c;

import android.support.v4.media.TransportMediator;
import com.domobile.lockbean.Scene;
import com.google.android.exoplayer2.C2251i;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p044b.C1957e;
import com.google.android.exoplayer2.p056i.C2219a;
import com.google.android.exoplayer2.p056i.C2220b;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class C2026d implements C2025o {
    private final C2220b f5517a;
    private final int f5518b;
    private final C1997b f5519c = new C1997b();
    private final LinkedBlockingDeque<C2219a> f5520d = new LinkedBlockingDeque();
    private final C1996a f5521e = new C1996a();
    private final C2263k f5522f = new C2263k(32);
    private final AtomicInteger f5523g = new AtomicInteger();
    private long f5524h;
    private Format f5525i;
    private long f5526j;
    private long f5527k;
    private C2219a f5528l;
    private int f5529m = this.f5518b;
    private boolean f5530n = true;
    private boolean f5531o;
    private C1998c f5532p;

    private static final class C1996a {
        public int f5310a;
        public long f5311b;
        public long f5312c;
        public byte[] f5313d;

        private C1996a() {
        }
    }

    private static final class C1997b {
        private int f5314a = 1000;
        private int[] f5315b = new int[this.f5314a];
        private long[] f5316c = new long[this.f5314a];
        private int[] f5317d = new int[this.f5314a];
        private int[] f5318e = new int[this.f5314a];
        private long[] f5319f = new long[this.f5314a];
        private byte[][] f5320g = new byte[this.f5314a][];
        private Format[] f5321h = new Format[this.f5314a];
        private int f5322i;
        private int f5323j;
        private int f5324k;
        private int f5325l;
        private long f5326m = Long.MIN_VALUE;
        private long f5327n = Long.MIN_VALUE;
        private boolean f5328o = true;
        private Format f5329p;
        private int f5330q;

        public synchronized int m5914a(C2251i c2251i, C1957e c1957e, Format format, C1996a c1996a) {
            int i = -5;
            synchronized (this) {
                if (this.f5322i == 0) {
                    if (this.f5329p == null || this.f5329p == format) {
                        i = -3;
                    } else {
                        c2251i.f6414a = this.f5329p;
                    }
                } else if (this.f5321h[this.f5324k] != format) {
                    c2251i.f6414a = this.f5321h[this.f5324k];
                } else {
                    c1957e.f5126c = this.f5319f[this.f5324k];
                    c1957e.b_(this.f5318e[this.f5324k]);
                    c1996a.f5310a = this.f5317d[this.f5324k];
                    c1996a.f5311b = this.f5316c[this.f5324k];
                    c1996a.f5313d = this.f5320g[this.f5324k];
                    this.f5326m = Math.max(this.f5326m, c1957e.f5126c);
                    this.f5322i--;
                    this.f5324k++;
                    this.f5323j++;
                    if (this.f5324k == this.f5314a) {
                        this.f5324k = 0;
                    }
                    c1996a.f5312c = this.f5322i > 0 ? this.f5316c[this.f5324k] : c1996a.f5311b + ((long) c1996a.f5310a);
                    i = -4;
                }
            }
            return i;
        }

        public long m5915a(int i) {
            int c = m5922c() - i;
            boolean z = c >= 0 && c <= this.f5322i;
            C2252a.m7022a(z);
            int i2;
            if (c != 0) {
                this.f5322i -= c;
                this.f5325l = ((this.f5325l + this.f5314a) - c) % this.f5314a;
                this.f5327n = Long.MIN_VALUE;
                for (i2 = this.f5322i - 1; i2 >= 0; i2--) {
                    c = (this.f5324k + i2) % this.f5314a;
                    this.f5327n = Math.max(this.f5327n, this.f5319f[c]);
                    if ((this.f5318e[c] & 1) != 0) {
                        break;
                    }
                }
                return this.f5316c[this.f5325l];
            } else if (this.f5323j == 0) {
                return 0;
            } else {
                i2 = (this.f5325l == 0 ? this.f5314a : this.f5325l) - 1;
                return ((long) this.f5317d[i2]) + this.f5316c[i2];
            }
        }

        public synchronized long m5916a(long j) {
            long j2 = -1;
            synchronized (this) {
                if (this.f5322i != 0 && j >= this.f5319f[this.f5324k]) {
                    if (j <= this.f5319f[(this.f5325l == 0 ? this.f5314a : this.f5325l) - 1]) {
                        int i = 0;
                        int i2 = this.f5324k;
                        int i3 = -1;
                        while (i2 != this.f5325l && this.f5319f[i2] <= j) {
                            if ((this.f5318e[i2] & 1) != 0) {
                                i3 = i;
                            }
                            i2 = (i2 + 1) % this.f5314a;
                            i++;
                        }
                        if (i3 != -1) {
                            this.f5322i -= i3;
                            this.f5324k = (this.f5324k + i3) % this.f5314a;
                            this.f5323j += i3;
                            j2 = this.f5316c[this.f5324k];
                        }
                    }
                }
            }
            return j2;
        }

        public void m5917a() {
            this.f5323j = 0;
            this.f5324k = 0;
            this.f5325l = 0;
            this.f5322i = 0;
        }

        public synchronized void m5918a(long j, int i, long j2, int i2, byte[] bArr) {
            C2252a.m7024b(!this.f5328o);
            m5921b(j);
            this.f5319f[this.f5325l] = j;
            this.f5316c[this.f5325l] = j2;
            this.f5317d[this.f5325l] = i2;
            this.f5318e[this.f5325l] = i;
            this.f5320g[this.f5325l] = bArr;
            this.f5321h[this.f5325l] = this.f5329p;
            this.f5315b[this.f5325l] = this.f5330q;
            this.f5322i++;
            if (this.f5322i == this.f5314a) {
                int i3 = this.f5314a + 1000;
                Object obj = new int[i3];
                Object obj2 = new long[i3];
                Object obj3 = new long[i3];
                Object obj4 = new int[i3];
                Object obj5 = new int[i3];
                Object obj6 = new byte[i3][];
                Object obj7 = new Format[i3];
                int i4 = this.f5314a - this.f5324k;
                System.arraycopy(this.f5316c, this.f5324k, obj2, 0, i4);
                System.arraycopy(this.f5319f, this.f5324k, obj3, 0, i4);
                System.arraycopy(this.f5318e, this.f5324k, obj4, 0, i4);
                System.arraycopy(this.f5317d, this.f5324k, obj5, 0, i4);
                System.arraycopy(this.f5320g, this.f5324k, obj6, 0, i4);
                System.arraycopy(this.f5321h, this.f5324k, obj7, 0, i4);
                System.arraycopy(this.f5315b, this.f5324k, obj, 0, i4);
                int i5 = this.f5324k;
                System.arraycopy(this.f5316c, 0, obj2, i4, i5);
                System.arraycopy(this.f5319f, 0, obj3, i4, i5);
                System.arraycopy(this.f5318e, 0, obj4, i4, i5);
                System.arraycopy(this.f5317d, 0, obj5, i4, i5);
                System.arraycopy(this.f5320g, 0, obj6, i4, i5);
                System.arraycopy(this.f5321h, 0, obj7, i4, i5);
                System.arraycopy(this.f5315b, 0, obj, i4, i5);
                this.f5316c = obj2;
                this.f5319f = obj3;
                this.f5318e = obj4;
                this.f5317d = obj5;
                this.f5320g = obj6;
                this.f5321h = obj7;
                this.f5315b = obj;
                this.f5324k = 0;
                this.f5325l = this.f5314a;
                this.f5322i = this.f5314a;
                this.f5314a = i3;
            } else {
                this.f5325l++;
                if (this.f5325l == this.f5314a) {
                    this.f5325l = 0;
                }
            }
        }

        public synchronized boolean m5919a(Format format) {
            boolean z = false;
            synchronized (this) {
                if (format == null) {
                    this.f5328o = true;
                } else {
                    this.f5328o = false;
                    if (!C2273r.m7135a((Object) format, this.f5329p)) {
                        this.f5329p = format;
                        z = true;
                    }
                }
            }
            return z;
        }

        public void m5920b() {
            this.f5326m = Long.MIN_VALUE;
            this.f5327n = Long.MIN_VALUE;
        }

        public synchronized void m5921b(long j) {
            this.f5327n = Math.max(this.f5327n, j);
        }

        public int m5922c() {
            return this.f5323j + this.f5322i;
        }

        public synchronized boolean m5923c(long j) {
            boolean z;
            if (this.f5326m >= j) {
                z = false;
            } else {
                int i = this.f5322i;
                while (i > 0 && this.f5319f[((this.f5324k + i) - 1) % this.f5314a] >= j) {
                    i--;
                }
                m5915a(i + this.f5323j);
                z = true;
            }
            return z;
        }

        public synchronized boolean m5924d() {
            return this.f5322i == 0;
        }

        public synchronized Format m5925e() {
            return this.f5328o ? null : this.f5329p;
        }

        public synchronized long m5926f() {
            return Math.max(this.f5326m, this.f5327n);
        }
    }

    public interface C1998c {
        void mo3021a(Format format);
    }

    public C2026d(C2220b c2220b) {
        this.f5517a = c2220b;
        this.f5518b = c2220b.mo3101c();
    }

    private int m6046a(int i) {
        if (this.f5529m == this.f5518b) {
            this.f5529m = 0;
            this.f5528l = this.f5517a.mo3097a();
            this.f5520d.add(this.f5528l);
        }
        return Math.min(i, this.f5518b - this.f5529m);
    }

    private static Format m6047a(Format format, long j) {
        return format == null ? null : (j == 0 || format.f4963u == Format.OFFSET_SAMPLE_RELATIVE) ? format : format.m5491a(format.f4963u + j);
    }

    private void m6048a(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            m6051b(j);
            int i2 = (int) (j - this.f5524h);
            int min = Math.min(i, this.f5518b - i2);
            C2219a c2219a = (C2219a) this.f5520d.peek();
            byteBuffer.put(c2219a.f6317a, c2219a.m6943a(i2), min);
            j += (long) min;
            i -= min;
        }
    }

    private void m6049a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            m6051b(j);
            int i3 = (int) (j - this.f5524h);
            int min = Math.min(i - i2, this.f5518b - i3);
            C2219a c2219a = (C2219a) this.f5520d.peek();
            System.arraycopy(c2219a.f6317a, c2219a.m6943a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
        }
    }

    private void m6050a(C1957e c1957e, C1996a c1996a) {
        long j;
        int i = 0;
        long j2 = c1996a.f5311b;
        this.f5522f.m7066a(1);
        m6049a(j2, this.f5522f.f6454a, 1);
        long j3 = 1 + j2;
        byte b = this.f5522f.f6454a[0];
        int i2 = (b & 128) != 0 ? 1 : 0;
        int i3 = b & TransportMediator.KEYCODE_MEDIA_PAUSE;
        if (c1957e.f5124a.f5110a == null) {
            c1957e.f5124a.f5110a = new byte[16];
        }
        m6049a(j3, c1957e.f5124a.f5110a, i3);
        j3 += (long) i3;
        if (i2 != 0) {
            this.f5522f.m7066a(2);
            m6049a(j3, this.f5522f.f6454a, 2);
            j3 += 2;
            i3 = this.f5522f.m7080h();
            j = j3;
        } else {
            i3 = 1;
            j = j3;
        }
        int[] iArr = c1957e.f5124a.f5113d;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = c1957e.f5124a.f5114e;
        if (iArr2 == null || iArr2.length < i3) {
            iArr2 = new int[i3];
        }
        if (i2 != 0) {
            i2 = i3 * 6;
            this.f5522f.m7066a(i2);
            m6049a(j, this.f5522f.f6454a, i2);
            j += (long) i2;
            this.f5522f.m7073c(0);
            while (i < i3) {
                iArr[i] = this.f5522f.m7080h();
                iArr2[i] = this.f5522f.m7092t();
                i++;
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = c1996a.f5310a - ((int) (j - c1996a.f5311b));
        }
        c1957e.f5124a.m5699a(i3, iArr, iArr2, c1996a.f5313d, c1957e.f5124a.f5110a, 1);
        i2 = (int) (j - c1996a.f5311b);
        c1996a.f5311b += (long) i2;
        c1996a.f5310a -= i2;
    }

    private void m6051b(long j) {
        int i = ((int) (j - this.f5524h)) / this.f5518b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f5517a.mo3098a((C2219a) this.f5520d.remove());
            this.f5524h += (long) this.f5518b;
        }
    }

    private boolean m6052f() {
        return this.f5523g.compareAndSet(0, 1);
    }

    private void m6053g() {
        if (!this.f5523g.compareAndSet(1, 0)) {
            m6054h();
        }
    }

    private void m6054h() {
        this.f5519c.m5917a();
        this.f5517a.mo3099a((C2219a[]) this.f5520d.toArray(new C2219a[this.f5520d.size()]));
        this.f5520d.clear();
        this.f5517a.mo3100b();
        this.f5524h = 0;
        this.f5527k = 0;
        this.f5528l = null;
        this.f5529m = this.f5518b;
        this.f5530n = true;
    }

    public int m6055a() {
        return this.f5519c.m5922c();
    }

    public int mo2976a(C1985g c1985g, int i, boolean z) {
        int a;
        if (m6052f()) {
            try {
                a = c1985g.mo2960a(this.f5528l.f6317a, this.f5528l.m6943a(this.f5529m), m6046a(i));
                if (a != -1) {
                    this.f5529m += a;
                    this.f5527k += (long) a;
                    m6053g();
                    return a;
                } else if (z) {
                    return -1;
                } else {
                    throw new EOFException();
                }
            } finally {
                m6053g();
            }
        } else {
            a = c1985g.mo2959a(i);
            if (a != -1) {
                return a;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
    }

    public int m6057a(C2251i c2251i, C1957e c1957e, boolean z, long j) {
        switch (this.f5519c.m5914a(c2251i, c1957e, this.f5525i, this.f5521e)) {
            case -5:
                this.f5525i = c2251i.f6414a;
                return -5;
            case -4:
                if (c1957e.f5126c < j) {
                    c1957e.m5692b(Integer.MIN_VALUE);
                }
                if (c1957e.m5708d()) {
                    m6050a(c1957e, this.f5521e);
                }
                c1957e.m5710e(this.f5521e.f5310a);
                m6048a(this.f5521e.f5311b, c1957e.f5125b, this.f5521e.f5310a);
                m6051b(this.f5521e.f5312c);
                return -4;
            case Scene.PAST_ID /*-3*/:
                if (!z) {
                    return -3;
                }
                c1957e.b_(4);
                return -4;
            default:
                throw new IllegalStateException();
        }
    }

    public void mo2977a(long j, int i, int i2, int i3, byte[] bArr) {
        if (m6052f()) {
            try {
                if (this.f5531o) {
                    if ((i & 1) == 0 || !this.f5519c.m5923c(j)) {
                        m6053g();
                        return;
                    }
                    this.f5531o = false;
                }
                if (this.f5530n) {
                    if ((i & 1) == 0) {
                        m6053g();
                        return;
                    }
                    this.f5530n = false;
                }
                this.f5519c.m5918a(j + this.f5526j, i, (this.f5527k - ((long) i2)) - ((long) i3), i2, bArr);
                m6053g();
            } catch (Throwable th) {
                m6053g();
            }
        } else {
            this.f5519c.m5921b(j);
        }
    }

    public void mo2978a(Format format) {
        Format a = C2026d.m6047a(format, this.f5526j);
        boolean a2 = this.f5519c.m5919a(a);
        if (this.f5532p != null && a2) {
            this.f5532p.mo3021a(a);
        }
    }

    public void m6060a(C1998c c1998c) {
        this.f5532p = c1998c;
    }

    public void mo2979a(C2263k c2263k, int i) {
        if (m6052f()) {
            while (i > 0) {
                int a = m6046a(i);
                c2263k.m7069a(this.f5528l.f6317a, this.f5528l.m6943a(this.f5529m), a);
                this.f5529m += a;
                this.f5527k += (long) a;
                i -= a;
            }
            m6053g();
            return;
        }
        c2263k.m7075d(i);
    }

    public void m6062a(boolean z) {
        int andSet = this.f5523g.getAndSet(z ? 0 : 2);
        m6054h();
        this.f5519c.m5920b();
        if (andSet == 2) {
            this.f5525i = null;
        }
    }

    public boolean m6063a(long j) {
        long a = this.f5519c.m5916a(j);
        if (a == -1) {
            return false;
        }
        m6051b(a);
        return true;
    }

    public void m6064b() {
        if (this.f5523g.getAndSet(2) == 0) {
            m6054h();
        }
    }

    public boolean m6065c() {
        return this.f5519c.m5924d();
    }

    public Format m6066d() {
        return this.f5519c.m5925e();
    }

    public long m6067e() {
        return this.f5519c.m5926f();
    }
}
