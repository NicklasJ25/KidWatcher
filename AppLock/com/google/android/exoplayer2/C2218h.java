package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C2129e.C2116c;
import com.google.android.exoplayer2.C2150p.C2299a;
import com.google.android.exoplayer2.C2150p.C2300b;
import com.google.android.exoplayer2.p043j.C1951g;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2265n;
import com.google.android.exoplayer2.p043j.C2270p;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p055f.C2137e;
import com.google.android.exoplayer2.p055f.C2139f;
import com.google.android.exoplayer2.p055f.C2140c;
import com.google.android.exoplayer2.p055f.C2140c.C2149a;
import com.google.android.exoplayer2.p055f.C2145d;
import com.google.android.exoplayer2.p055f.C2145d.C2146a;
import com.google.android.exoplayer2.p063h.C2202f;
import com.google.android.exoplayer2.p063h.C2208h;
import com.google.android.exoplayer2.p063h.C2208h.C2217b;
import com.google.android.exoplayer2.p063h.C2214g;
import java.io.IOException;

final class C2218h<T> implements Callback, C2149a, C2146a, C2217b {
    private int f6286A;
    private C2198a<T> f6287B;
    private C2198a<T> f6288C;
    private C2198a<T> f6289D;
    private C2150p f6290E;
    private final C1947m[] f6291a;
    private final C1948n[] f6292b;
    private final C2208h<T> f6293c;
    private final C2096j f6294d;
    private final C2270p f6295e;
    private final Handler f6296f;
    private final HandlerThread f6297g;
    private final Handler f6298h;
    private final C2300b f6299i;
    private final C2299a f6300j;
    private C2199b f6301k;
    private C1947m f6302l;
    private C1951g f6303m;
    private C2145d f6304n;
    private C1947m[] f6305o;
    private boolean f6306p;
    private boolean f6307q;
    private boolean f6308r;
    private boolean f6309s;
    private int f6310t = 1;
    private int f6311u;
    private int f6312v;
    private long f6313w;
    private long f6314x;
    private boolean f6315y;
    private boolean f6316z;

    private static final class C2198a<T> {
        public final C2140c f6208a;
        public final Object f6209b;
        public final C2137e[] f6210c;
        public final boolean[] f6211d;
        public int f6212e;
        public long f6213f;
        public boolean f6214g;
        public boolean f6215h;
        public boolean f6216i;
        public long f6217j;
        public C2198a<T> f6218k;
        public boolean f6219l;
        private final C1947m[] f6220m;
        private final C1948n[] f6221n;
        private final C2208h<T> f6222o;
        private final C2145d f6223p;
        private C2214g<T> f6224q;
        private C2214g<T> f6225r;

        public C2198a(C1947m[] c1947mArr, C1948n[] c1948nArr, C2208h<T> c2208h, C2145d c2145d, C2140c c2140c, Object obj, long j) {
            this.f6220m = c1947mArr;
            this.f6221n = c1948nArr;
            this.f6222o = c2208h;
            this.f6223p = c2145d;
            this.f6208a = c2140c;
            this.f6209b = C2252a.m7020a(obj);
            this.f6210c = new C2137e[c1947mArr.length];
            this.f6211d = new boolean[c1947mArr.length];
            this.f6213f = j;
        }

        public long m6848a(long j, C2096j c2096j, boolean z) {
            return m6849a(j, c2096j, z, new boolean[this.f6220m.length]);
        }

        public long m6849a(long j, C2096j c2096j, boolean z, boolean[] zArr) {
            int i = 0;
            while (i < this.f6224q.f6281b) {
                boolean z2;
                boolean[] zArr2 = this.f6211d;
                if (!z) {
                    if (C2273r.m7135a(this.f6225r == null ? null : this.f6225r.m6898a(i), this.f6224q.m6898a(i))) {
                        z2 = true;
                        zArr2[i] = z2;
                        i++;
                    }
                }
                z2 = false;
                zArr2[i] = z2;
                i++;
            }
            long a = this.f6208a.mo3018a(this.f6224q.m6899a(), this.f6211d, this.f6210c, zArr, j);
            this.f6225r = this.f6224q;
            this.f6216i = false;
            for (i = 0; i < this.f6210c.length; i++) {
                if (this.f6210c[i] != null) {
                    C2252a.m7024b(this.f6224q.m6898a(i) != null);
                    this.f6216i = true;
                } else {
                    C2252a.m7024b(this.f6224q.m6898a(i) == null);
                }
            }
            c2096j.mo2996a(this.f6220m, this.f6208a.mo3029d(), this.f6224q);
            return a;
        }

        public void m6850a(long j, C2096j c2096j) {
            this.f6215h = true;
            m6854b();
            this.f6213f = m6848a(j, c2096j, false);
        }

        public void m6851a(C2198a<T> c2198a) {
            this.f6218k = c2198a;
        }

        public void m6852a(C2150p c2150p, C2300b c2300b, int i) {
            this.f6212e = i;
            boolean z = this.f6212e == c2150p.mo3043b() + -1 && !c2300b.f6592e;
            this.f6214g = z;
        }

        public boolean m6853a() {
            return this.f6215h && (!this.f6216i || this.f6208a.mo3032g() == Long.MIN_VALUE);
        }

        public boolean m6854b() {
            C2214g a = this.f6222o.mo3090a(this.f6221n, this.f6208a.mo3029d());
            if (a.equals(this.f6225r)) {
                return false;
            }
            this.f6224q = a;
            return true;
        }

        public void m6855c() {
            try {
                this.f6223p.mo3035a(this.f6208a);
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }
    }

    public static final class C2199b {
        public final int f6226a;
        public final long f6227b;
        public volatile long f6228c;
        public volatile long f6229d;

        public C2199b(int i, long j) {
            this.f6226a = i;
            this.f6227b = j;
            this.f6228c = j;
            this.f6229d = j;
        }
    }

    public C2218h(C1947m[] c1947mArr, C2208h<T> c2208h, C2096j c2096j, boolean z, Handler handler, C2199b c2199b) {
        this.f6291a = c1947mArr;
        this.f6293c = c2208h;
        this.f6294d = c2096j;
        this.f6307q = z;
        this.f6298h = handler;
        this.f6301k = c2199b;
        this.f6292b = new C1948n[c1947mArr.length];
        for (int i = 0; i < c1947mArr.length; i++) {
            c1947mArr[i].mo2895a(i);
            this.f6292b[i] = c1947mArr[i].mo2900b();
        }
        this.f6295e = new C2270p();
        this.f6305o = new C1947m[0];
        this.f6299i = new C2300b();
        this.f6300j = new C2299a();
        c2208h.m6875a((C2217b) this);
        this.f6297g = new C2265n("ExoPlayerImplInternal:Handler", -16);
        this.f6297g.start();
        this.f6296f = new Handler(this.f6297g.getLooper(), this);
    }

    private void m6901a(int i) {
        if (this.f6310t != i) {
            this.f6310t = i;
            this.f6298h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void m6902a(long j) {
        this.f6314x = (this.f6287B == null ? 0 : this.f6287B.f6217j) + j;
        this.f6295e.m7117a(this.f6314x);
        for (C1947m a : this.f6305o) {
            a.mo2897a(this.f6314x);
        }
    }

    private void m6903a(long j, long j2) {
        this.f6296f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f6296f.sendEmptyMessage(2);
        } else {
            this.f6296f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void m6904a(Pair<C2150p, Object> pair) {
        int i;
        this.f6298h.obtainMessage(5, pair).sendToTarget();
        C2150p c2150p = this.f6290E;
        this.f6290E = (C2150p) pair.first;
        if (this.f6287B != null) {
            int a = this.f6290E.mo3040a(this.f6287B.f6209b);
            if (a == -1) {
                m6907a(this.f6290E, c2150p, this.f6287B.f6212e);
                return;
            }
            this.f6290E.mo3041a(a, this.f6300j, true);
            this.f6287B.m6852a(this.f6290E, this.f6290E.m6565a(this.f6300j.f6585c, this.f6299i), a);
            C2198a c2198a = this.f6287B;
            this.f6286A = 0;
            int i2 = a;
            C2198a c2198a2 = c2198a;
            i = 0;
            C2198a c2198a3 = c2198a2;
            while (c2198a3.f6218k != null) {
                C2198a c2198a4 = c2198a3.f6218k;
                i2++;
                this.f6290E.mo3041a(i2, this.f6300j, true);
                if (c2198a4.f6209b.equals(this.f6300j.f6584b)) {
                    this.f6286A++;
                    c2198a4.m6852a(this.f6290E, this.f6290E.m6565a(this.f6290E.m6563a(i2, this.f6300j).f6585c, this.f6299i), i2);
                    if (c2198a4 == this.f6288C) {
                        i = true;
                    }
                    c2198a3 = c2198a4;
                } else if (i == 0) {
                    i = this.f6287B.f6212e;
                    m6905a(this.f6287B);
                    this.f6287B = null;
                    this.f6288C = null;
                    this.f6289D = null;
                    long c = m6914c(i, this.f6301k.f6228c);
                    if (c != this.f6301k.f6228c) {
                        this.f6301k = new C2199b(i, c);
                        this.f6298h.obtainMessage(4, this.f6301k).sendToTarget();
                        return;
                    }
                    return;
                } else {
                    this.f6289D = c2198a3;
                    this.f6289D.f6218k = null;
                    m6905a(c2198a4);
                }
            }
        } else if (this.f6289D != null) {
            i = this.f6290E.mo3040a(this.f6289D.f6209b);
            if (i == -1) {
                m6907a(this.f6290E, c2150p, this.f6289D.f6212e);
                return;
            }
            this.f6289D.m6852a(this.f6290E, this.f6290E.m6565a(this.f6290E.m6563a(i, this.f6300j).f6585c, this.f6299i), i);
        }
        if (c2150p != null) {
            i = this.f6287B != null ? this.f6287B.f6212e : this.f6289D != null ? this.f6289D.f6212e : -1;
            if (i != -1 && i != this.f6301k.f6226a) {
                this.f6301k = new C2199b(i, this.f6301k.f6228c);
                m6922e();
                this.f6298h.obtainMessage(4, this.f6301k).sendToTarget();
            }
        }
    }

    private void m6905a(C2198a<T> c2198a) {
        C2198a c2198a2;
        while (c2198a2 != null) {
            c2198a2.m6855c();
            c2198a2 = c2198a2.f6218k;
        }
    }

    private void m6906a(C1947m c1947m) {
        if (c1947m.mo2902d() == 2) {
            c1947m.mo2908j();
        }
    }

    private void m6907a(C2150p c2150p, C2150p c2150p2, int i) {
        int i2 = -1;
        while (i2 == -1 && i < c2150p2.mo3043b() - 1) {
            i++;
            i2 = c2150p.mo3040a(c2150p2.mo3041a(i, this.f6300j, true).f6584b);
        }
        if (i2 == -1) {
            m6924g();
            return;
        }
        m6905a(this.f6287B != null ? this.f6287B : this.f6289D);
        this.f6286A = 0;
        this.f6287B = null;
        this.f6288C = null;
        this.f6289D = null;
        Pair b = m6909b(i2);
        this.f6301k = new C2199b(((Integer) b.first).intValue(), ((Long) b.second).longValue());
        this.f6298h.obtainMessage(4, this.f6301k).sendToTarget();
    }

    private void m6908a(boolean[] zArr, int i) {
        this.f6305o = new C1947m[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6291a.length; i3++) {
            C1947m c1947m = this.f6291a[i3];
            C2202f a = this.f6287B.f6224q.m6898a(i3);
            if (a != null) {
                int i4 = i2 + 1;
                this.f6305o[i2] = c1947m;
                if (c1947m.mo2902d() == 0) {
                    Object obj = (this.f6307q && this.f6310t == 3) ? 1 : null;
                    boolean z = (zArr[i3] || obj == null) ? false : true;
                    Format[] formatArr = new Format[a.mo3088b()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = a.mo3086a(i5);
                    }
                    c1947m.mo2899a(formatArr, this.f6287B.f6210c[i3], this.f6314x, z, this.f6287B.f6217j);
                    C1951g c = c1947m.mo2901c();
                    if (c != null) {
                        if (this.f6303m != null) {
                            throw C2109d.m6417a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.f6303m = c;
                        this.f6302l = c1947m;
                    }
                    if (obj != null) {
                        c1947m.mo2903e();
                    }
                }
                i2 = i4;
            }
        }
    }

    private Pair<Integer, Long> m6909b(int i) {
        this.f6290E.m6563a(i, this.f6300j);
        this.f6290E.m6565a(this.f6300j.f6585c, this.f6299i);
        int i2 = this.f6299i.f6593f;
        long d = this.f6299i.m7278d() + this.f6299i.m7274a();
        this.f6290E.m6563a(i2, this.f6300j);
        while (i2 < this.f6299i.f6594g && d > this.f6300j.m7270a()) {
            d -= this.f6300j.m7272b();
            int i3 = i2 + 1;
            this.f6290E.m6563a(i2, this.f6300j);
            i2 = i3;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(d));
    }

    private void m6910b(int i, long j) {
        if (j == -9223372036854775807L) {
            try {
                if (this.f6290E != null && i < this.f6290E.mo3043b()) {
                    Pair b = m6909b(i);
                    i = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                }
            } catch (Throwable th) {
                this.f6301k = new C2199b(i, j);
                this.f6298h.obtainMessage(3, this.f6301k).sendToTarget();
            }
        }
        if (i == this.f6301k.f6226a && ((j == -9223372036854775807L && this.f6301k.f6228c == -9223372036854775807L) || j / 1000 == this.f6301k.f6228c / 1000)) {
            this.f6301k = new C2199b(i, j);
            this.f6298h.obtainMessage(3, this.f6301k).sendToTarget();
            return;
        }
        this.f6301k = new C2199b(i, m6914c(i, j));
        this.f6298h.obtainMessage(3, this.f6301k).sendToTarget();
    }

    private void m6911b(C2145d c2145d, boolean z) {
        m6926i();
        this.f6294d.mo2995a();
        if (z) {
            this.f6301k = new C2199b(0, -9223372036854775807L);
        }
        this.f6304n = c2145d;
        c2145d.mo3036a((C2146a) this);
        m6901a(2);
        this.f6296f.sendEmptyMessage(2);
    }

    private void m6912b(C2198a<T> c2198a) {
        boolean[] zArr = new boolean[this.f6291a.length];
        int i = 0;
        for (int i2 = 0; i2 < this.f6291a.length; i2++) {
            C1947m c1947m = this.f6291a[i2];
            zArr[i2] = c1947m.mo2902d() != 0;
            if (c2198a.f6224q.m6898a(i2) != null) {
                i++;
            } else if (zArr[i2]) {
                if (c1947m == this.f6302l) {
                    this.f6295e.m7117a(this.f6303m.mo2928t());
                    this.f6303m = null;
                    this.f6302l = null;
                }
                m6906a(c1947m);
                c1947m.mo2909k();
            }
        }
        this.f6293c.m6873a(c2198a.f6224q);
        this.f6287B = c2198a;
        m6908a(zArr, i);
    }

    private void m6913b(boolean z) {
        if (this.f6309s != z) {
            this.f6309s = z;
            this.f6298h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private long m6914c(int i, long j) {
        if (this.f6304n != null) {
            C2198a c2198a;
            m6919d();
            this.f6308r = false;
            m6901a(2);
            if (j == -9223372036854775807L || (this.f6288C != this.f6287B && (i == this.f6287B.f6212e || i == this.f6288C.f6212e))) {
                i = -1;
            }
            if (this.f6287B != null) {
                C2198a c2198a2 = this.f6287B;
                c2198a = null;
                while (c2198a2 != null) {
                    if (c2198a2.f6212e == i && c2198a2.f6215h) {
                        c2198a = c2198a2;
                    } else {
                        c2198a2.m6855c();
                    }
                    c2198a2 = c2198a2.f6218k;
                }
            } else if (this.f6289D != null) {
                this.f6289D.m6855c();
                c2198a = null;
            } else {
                c2198a = null;
            }
            if (c2198a != this.f6287B) {
                for (C1947m k : this.f6305o) {
                    k.mo2909k();
                }
                this.f6305o = new C1947m[0];
                this.f6303m = null;
                this.f6302l = null;
            }
            this.f6286A = 0;
            if (c2198a != null) {
                c2198a.f6218k = null;
                m6912b(c2198a);
                m6931n();
                this.f6288C = this.f6287B;
                this.f6289D = this.f6287B;
                if (this.f6287B.f6216i) {
                    j = this.f6287B.f6208a.mo3027b(j);
                }
                m6902a(j);
                m6930m();
            } else {
                this.f6287B = null;
                this.f6288C = null;
                this.f6289D = null;
                if (j != -9223372036854775807L) {
                    m6902a(j);
                }
            }
            m6922e();
            this.f6296f.sendEmptyMessage(2);
        } else if (j != -9223372036854775807L) {
            m6902a(j);
        }
        return j;
    }

    private void m6915c() {
        int i = 0;
        this.f6308r = false;
        this.f6295e.m7116a();
        C1947m[] c1947mArr = this.f6305o;
        int length = c1947mArr.length;
        while (i < length) {
            c1947mArr[i].mo2903e();
            i++;
        }
    }

    private void m6916c(C2140c c2140c) {
        if (this.f6289D != null && this.f6289D.f6208a == c2140c) {
            this.f6289D.m6850a(this.f6289D.f6213f, this.f6294d);
            if (this.f6287B == null) {
                this.f6288C = this.f6289D;
                m6912b(this.f6288C);
                if (this.f6301k.f6227b == -9223372036854775807L) {
                    this.f6301k = new C2199b(this.f6287B.f6212e, this.f6287B.f6213f);
                    m6902a(this.f6301k.f6227b);
                    m6922e();
                    this.f6298h.obtainMessage(4, this.f6301k).sendToTarget();
                }
                m6931n();
            }
            m6930m();
        }
    }

    private void m6917c(boolean z) {
        this.f6308r = false;
        this.f6307q = z;
        if (!z) {
            m6919d();
            m6922e();
        } else if (this.f6310t == 3) {
            m6915c();
            this.f6296f.sendEmptyMessage(2);
        } else if (this.f6310t == 2) {
            this.f6296f.sendEmptyMessage(2);
        }
    }

    private void m6918c(C2116c[] c2116cArr) {
        try {
            for (C2116c c2116c : c2116cArr) {
                c2116c.f5932a.mo2896a(c2116c.f5933b, c2116c.f5934c);
            }
            if (this.f6304n != null) {
                this.f6296f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.f6312v++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f6312v++;
                notifyAll();
            }
        }
    }

    private void m6919d() {
        this.f6295e.m7118b();
        for (C1947m a : this.f6305o) {
            m6906a(a);
        }
    }

    private void m6920d(C2140c c2140c) {
        if (this.f6289D != null && this.f6289D.f6208a == c2140c) {
            m6930m();
        }
    }

    private boolean m6921d(boolean z) {
        if (this.f6289D == null) {
            return false;
        }
        long j = this.f6314x - this.f6289D.f6217j;
        long g = !this.f6289D.f6215h ? 0 : this.f6289D.f6208a.mo3032g();
        if (g == Long.MIN_VALUE) {
            if (this.f6289D.f6214g) {
                return true;
            }
            g = this.f6290E.m6563a(this.f6289D.f6212e, this.f6300j).m7272b();
        }
        return this.f6294d.mo2998a(g - j, z);
    }

    private void m6922e() {
        if (this.f6287B != null) {
            long f = this.f6287B.f6208a.mo3031f();
            if (f != -9223372036854775807L) {
                m6902a(f);
            } else {
                if (this.f6302l == null || this.f6302l.mo2919s()) {
                    this.f6314x = this.f6295e.mo2928t();
                } else {
                    this.f6314x = this.f6303m.mo2928t();
                    this.f6295e.m7117a(this.f6314x);
                }
                f = this.f6314x - this.f6287B.f6217j;
            }
            this.f6301k.f6228c = f;
            this.f6313w = SystemClock.elapsedRealtime() * 1000;
            f = this.f6305o.length == 0 ? Long.MIN_VALUE : this.f6287B.f6208a.mo3032g();
            C2199b c2199b = this.f6301k;
            if (f == Long.MIN_VALUE) {
                f = this.f6290E.m6563a(this.f6287B.f6212e, this.f6300j).m7272b();
            }
            c2199b.f6229d = f;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6923f() {
        /*
        r15 = this;
        r4 = android.os.SystemClock.elapsedRealtime();
        r15.m6929l();
        r0 = r15.f6287B;
        if (r0 != 0) goto L_0x0014;
    L_0x000b:
        r15.m6928k();
        r0 = 10;
        r15.m6903a(r4, r0);
    L_0x0013:
        return;
    L_0x0014:
        r0 = "doSomeWork";
        com.google.android.exoplayer2.p043j.C2271q.m7121a(r0);
        r15.m6922e();
        r2 = 1;
        r1 = 1;
        r6 = r15.f6305o;
        r7 = r6.length;
        r0 = 0;
        r3 = r1;
        r14 = r0;
        r0 = r2;
        r2 = r14;
    L_0x0026:
        if (r2 >= r7) goto L_0x005b;
    L_0x0028:
        r8 = r6[r2];
        r10 = r15.f6314x;
        r12 = r15.f6313w;
        r8.mo2912a(r10, r12);
        if (r0 == 0) goto L_0x0055;
    L_0x0033:
        r0 = r8.mo2919s();
        if (r0 == 0) goto L_0x0055;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        r1 = r8.mo2918r();
        if (r1 != 0) goto L_0x0046;
    L_0x0040:
        r1 = r8.mo2919s();
        if (r1 == 0) goto L_0x0057;
    L_0x0046:
        r1 = 1;
    L_0x0047:
        if (r1 != 0) goto L_0x004c;
    L_0x0049:
        r8.mo2907i();
    L_0x004c:
        if (r3 == 0) goto L_0x0059;
    L_0x004e:
        if (r1 == 0) goto L_0x0059;
    L_0x0050:
        r1 = 1;
    L_0x0051:
        r2 = r2 + 1;
        r3 = r1;
        goto L_0x0026;
    L_0x0055:
        r0 = 0;
        goto L_0x003a;
    L_0x0057:
        r1 = 0;
        goto L_0x0047;
    L_0x0059:
        r1 = 0;
        goto L_0x0051;
    L_0x005b:
        if (r3 != 0) goto L_0x0060;
    L_0x005d:
        r15.m6928k();
    L_0x0060:
        r1 = r15.f6290E;
        r2 = r15.f6287B;
        r2 = r2.f6212e;
        r6 = r15.f6300j;
        r1 = r1.m6563a(r2, r6);
        r6 = r1.m7272b();
        if (r0 == 0) goto L_0x00a1;
    L_0x0072:
        r0 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x0083;
    L_0x007b:
        r0 = r15.f6301k;
        r0 = r0.f6228c;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x00a1;
    L_0x0083:
        r0 = r15.f6316z;
        if (r0 == 0) goto L_0x00a1;
    L_0x0087:
        r0 = 4;
        r15.m6901a(r0);
        r15.m6919d();
    L_0x008e:
        r0 = r15.f6310t;
        r1 = 2;
        if (r0 != r1) goto L_0x00e3;
    L_0x0093:
        r1 = r15.f6305o;
        r2 = r1.length;
        r0 = 0;
    L_0x0097:
        if (r0 >= r2) goto L_0x00e3;
    L_0x0099:
        r3 = r1[r0];
        r3.mo2907i();
        r0 = r0 + 1;
        goto L_0x0097;
    L_0x00a1:
        r0 = r15.f6310t;
        r1 = 2;
        if (r0 != r1) goto L_0x00c6;
    L_0x00a6:
        r0 = r15.f6305o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00c1;
    L_0x00ab:
        if (r3 == 0) goto L_0x008e;
    L_0x00ad:
        r0 = r15.f6308r;
        r0 = r15.m6921d(r0);
        if (r0 == 0) goto L_0x008e;
    L_0x00b5:
        r0 = 3;
        r15.m6901a(r0);
        r0 = r15.f6307q;
        if (r0 == 0) goto L_0x008e;
    L_0x00bd:
        r15.m6915c();
        goto L_0x008e;
    L_0x00c1:
        r0 = r15.f6315y;
        if (r0 == 0) goto L_0x008e;
    L_0x00c5:
        goto L_0x00b5;
    L_0x00c6:
        r0 = r15.f6310t;
        r1 = 3;
        if (r0 != r1) goto L_0x008e;
    L_0x00cb:
        r0 = r15.f6305o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00de;
    L_0x00d0:
        if (r3 != 0) goto L_0x008e;
    L_0x00d2:
        r0 = r15.f6307q;
        r15.f6308r = r0;
        r0 = 2;
        r15.m6901a(r0);
        r15.m6919d();
        goto L_0x008e;
    L_0x00de:
        r0 = r15.f6315y;
        if (r0 != 0) goto L_0x008e;
    L_0x00e2:
        goto L_0x00d2;
    L_0x00e3:
        r0 = r15.f6307q;
        if (r0 == 0) goto L_0x00ec;
    L_0x00e7:
        r0 = r15.f6310t;
        r1 = 3;
        if (r0 == r1) goto L_0x00f1;
    L_0x00ec:
        r0 = r15.f6310t;
        r1 = 2;
        if (r0 != r1) goto L_0x00fb;
    L_0x00f1:
        r0 = 10;
        r15.m6903a(r4, r0);
    L_0x00f6:
        com.google.android.exoplayer2.p043j.C2271q.m7120a();
        goto L_0x0013;
    L_0x00fb:
        r0 = r15.f6305o;
        r0 = r0.length;
        if (r0 == 0) goto L_0x0106;
    L_0x0100:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r15.m6903a(r4, r0);
        goto L_0x00f6;
    L_0x0106:
        r0 = r15.f6296f;
        r1 = 2;
        r0.removeMessages(r1);
        goto L_0x00f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.f():void");
    }

    private void m6924g() {
        m6926i();
        this.f6294d.mo2999b();
        m6901a(1);
    }

    private void m6925h() {
        m6926i();
        this.f6294d.mo3000c();
        m6901a(1);
        synchronized (this) {
            this.f6306p = true;
            notifyAll();
        }
    }

    private void m6926i() {
        Throwable e;
        this.f6296f.removeMessages(2);
        this.f6308r = false;
        this.f6295e.m7118b();
        this.f6303m = null;
        this.f6302l = null;
        for (C1947m c1947m : this.f6305o) {
            try {
                m6906a(c1947m);
                c1947m.mo2909k();
            } catch (C2109d e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            }
        }
        this.f6305o = new C1947m[0];
        m6905a(this.f6287B != null ? this.f6287B : this.f6289D);
        if (this.f6304n != null) {
            this.f6304n.mo3038b();
            this.f6304n = null;
        }
        this.f6315y = false;
        this.f6316z = false;
        this.f6287B = null;
        this.f6288C = null;
        this.f6289D = null;
        this.f6290E = null;
        this.f6286A = 0;
        m6913b(false);
        return;
        Log.e("ExoPlayerImplInternal", "Stop failed.", e);
    }

    private void m6927j() {
        if (this.f6287B != null) {
            C2198a c2198a = this.f6287B;
            boolean z = true;
            while (c2198a != null && c2198a.f6215h) {
                if (c2198a.m6854b()) {
                    if (z) {
                        boolean z2 = this.f6288C != this.f6287B;
                        m6905a(this.f6287B.f6218k);
                        this.f6287B.f6218k = null;
                        this.f6288C = this.f6287B;
                        this.f6289D = this.f6287B;
                        this.f6286A = 0;
                        boolean[] zArr = new boolean[this.f6291a.length];
                        long a = this.f6287B.m6849a(this.f6301k.f6228c, this.f6294d, z2, zArr);
                        if (a != this.f6301k.f6228c) {
                            this.f6301k.f6228c = a;
                            m6902a(a);
                        }
                        boolean[] zArr2 = new boolean[this.f6291a.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.f6291a.length; i2++) {
                            C1947m c1947m = this.f6291a[i2];
                            zArr2[i2] = c1947m.mo2902d() != 0;
                            C2137e c2137e = this.f6287B.f6210c[i2];
                            if (c2137e != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (c2137e != c1947m.mo2904f()) {
                                    if (c1947m == this.f6302l) {
                                        if (c2137e == null) {
                                            this.f6295e.m7117a(this.f6303m.mo2928t());
                                        }
                                        this.f6303m = null;
                                        this.f6302l = null;
                                    }
                                    m6906a(c1947m);
                                    c1947m.mo2909k();
                                } else if (zArr[i2]) {
                                    c1947m.mo2897a(this.f6301k.f6228c);
                                }
                            }
                        }
                        this.f6293c.m6873a(this.f6287B.f6224q);
                        m6908a(zArr2, i);
                    } else {
                        this.f6289D = c2198a;
                        C2198a c2198a2 = this.f6289D.f6218k;
                        while (c2198a2 != null) {
                            c2198a2.m6855c();
                            c2198a2 = c2198a2.f6218k;
                            this.f6286A--;
                        }
                        this.f6289D.f6218k = null;
                        this.f6289D.m6848a(Math.max(0, this.f6314x - this.f6289D.f6217j), this.f6294d, false);
                    }
                    m6930m();
                    m6922e();
                    this.f6296f.sendEmptyMessage(2);
                    return;
                }
                if (c2198a == this.f6288C) {
                    z = false;
                }
                c2198a = c2198a.f6218k;
            }
        }
    }

    private void m6928k() {
        if (this.f6289D != null && !this.f6289D.f6215h) {
            if (this.f6288C == null || this.f6288C.f6218k == this.f6289D) {
                C1947m[] c1947mArr = this.f6305o;
                int length = c1947mArr.length;
                int i = 0;
                while (i < length) {
                    if (c1947mArr[i].mo2905g()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f6289D.f6208a.mo3028c();
            }
        }
    }

    private void m6929l() {
        int i = 0;
        if (this.f6290E == null) {
            this.f6304n.mo3034a();
            return;
        }
        int i2;
        if (this.f6289D == null || (this.f6289D.m6853a() && !this.f6289D.f6214g && this.f6286A < 100)) {
            i2 = this.f6289D == null ? this.f6301k.f6226a : this.f6289D.f6212e + 1;
            if (i2 >= this.f6290E.mo3043b()) {
                this.f6304n.mo3034a();
            } else {
                int i3 = this.f6290E.m6563a(i2, this.f6300j).f6585c;
                long j = this.f6289D == null ? this.f6301k.f6228c : i2 == this.f6290E.m6565a(i3, this.f6299i).f6593f ? -9223372036854775807L : 0;
                if (j == -9223372036854775807L) {
                    Pair b = m6909b(i2);
                    int intValue = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                    i2 = intValue;
                }
                Object obj = this.f6290E.mo3041a(i2, this.f6300j, true).f6584b;
                C2140c a = this.f6304n.mo3033a(i2, this.f6294d.mo3001d(), j);
                a.mo3023a(this);
                C2198a c2198a = new C2198a(this.f6291a, this.f6292b, this.f6293c, this.f6304n, a, obj, j);
                this.f6290E.m6565a(i3, this.f6299i);
                c2198a.m6852a(this.f6290E, this.f6299i, i2);
                if (this.f6289D != null) {
                    this.f6289D.m6851a(c2198a);
                    c2198a.f6217j = this.f6289D.f6217j + this.f6290E.m6563a(this.f6289D.f6212e, this.f6300j).m7272b();
                }
                this.f6286A++;
                this.f6289D = c2198a;
                m6913b(true);
            }
        }
        if (this.f6289D == null || this.f6289D.m6853a()) {
            m6913b(false);
        } else if (this.f6289D != null && this.f6289D.f6219l) {
            m6930m();
        }
        if (this.f6287B != null) {
            while (this.f6287B != this.f6288C && this.f6287B.f6218k != null && this.f6314x >= this.f6287B.f6218k.f6217j) {
                this.f6287B.m6855c();
                m6912b(this.f6287B.f6218k);
                this.f6286A--;
                this.f6301k = new C2199b(this.f6287B.f6212e, this.f6287B.f6213f);
                m6922e();
                this.f6298h.obtainMessage(4, this.f6301k).sendToTarget();
            }
            m6931n();
            if (this.f6288C.f6214g) {
                C1947m[] c1947mArr = this.f6305o;
                intValue = c1947mArr.length;
                while (i < intValue) {
                    c1947mArr[i].mo2906h();
                    i++;
                }
                return;
            }
            C1947m[] c1947mArr2 = this.f6305o;
            int length = c1947mArr2.length;
            i2 = 0;
            while (i2 < length) {
                if (c1947mArr2[i2].mo2905g()) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.f6288C.f6218k != null && this.f6288C.f6218k.f6215h) {
                C2214g b2 = this.f6288C.f6224q;
                this.f6288C = this.f6288C.f6218k;
                C2214g b3 = this.f6288C.f6224q;
                for (i2 = 0; i2 < this.f6291a.length; i2++) {
                    C1947m c1947m = this.f6291a[i2];
                    C2202f a2 = b2.m6898a(i2);
                    C2202f a3 = b3.m6898a(i2);
                    if (a2 != null) {
                        if (a3 != null) {
                            Format[] formatArr = new Format[a3.mo3088b()];
                            for (intValue = 0; intValue < formatArr.length; intValue++) {
                                formatArr[intValue] = a3.mo3086a(intValue);
                            }
                            c1947m.mo2898a(formatArr, this.f6288C.f6210c[i2], this.f6288C.f6217j);
                        } else {
                            c1947m.mo2906h();
                        }
                    }
                }
            }
        }
    }

    private void m6930m() {
        long e = this.f6289D.f6208a.mo3030e();
        if (e != Long.MIN_VALUE) {
            long j = this.f6314x - this.f6289D.f6217j;
            boolean a = this.f6294d.mo2997a(e - j);
            m6913b(a);
            if (a) {
                this.f6289D.f6219l = false;
                this.f6289D.f6208a.mo3026a(j);
                return;
            }
            this.f6289D.f6219l = true;
            return;
        }
        m6913b(false);
    }

    private void m6931n() {
        long b = this.f6290E.m6563a(this.f6287B.f6212e, this.f6300j).m7272b();
        boolean z = b == -9223372036854775807L || this.f6301k.f6228c < b || (this.f6287B.f6218k != null && this.f6287B.f6218k.f6215h);
        this.f6315y = z;
        this.f6316z = this.f6287B.f6214g;
    }

    public void m6932a() {
        this.f6296f.sendEmptyMessage(4);
    }

    public void m6933a(int i, long j) {
        this.f6296f.obtainMessage(3, i, 0, Long.valueOf(j)).sendToTarget();
    }

    public void mo3092a(C2140c c2140c) {
        this.f6296f.obtainMessage(7, c2140c).sendToTarget();
    }

    public void m6935a(C2145d c2145d, boolean z) {
        this.f6296f.obtainMessage(0, z ? 1 : 0, 0, c2145d).sendToTarget();
    }

    public /* synthetic */ void mo3093a(C2139f c2139f) {
        m6941b((C2140c) c2139f);
    }

    public void mo3037a(C2150p c2150p, Object obj) {
        this.f6296f.obtainMessage(6, Pair.create(c2150p, obj)).sendToTarget();
    }

    public void m6938a(boolean z) {
        this.f6296f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void m6939a(C2116c... c2116cArr) {
        if (this.f6306p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f6311u++;
        this.f6296f.obtainMessage(10, c2116cArr).sendToTarget();
    }

    public synchronized void m6940b() {
        if (!this.f6306p) {
            this.f6296f.sendEmptyMessage(5);
            while (!this.f6306p) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.f6297g.quit();
        }
    }

    public void m6941b(C2140c c2140c) {
        this.f6296f.obtainMessage(8, c2140c).sendToTarget();
    }

    public synchronized void m6942b(C2116c... c2116cArr) {
        if (this.f6306p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.f6311u;
            this.f6311u = i + 1;
            this.f6296f.obtainMessage(10, c2116cArr).sendToTarget();
            while (this.f6312v <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        try {
            switch (message.what) {
                case 0:
                    C2145d c2145d = (C2145d) message.obj;
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m6911b(c2145d, z);
                    return true;
                case 1:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m6917c(z);
                    return true;
                case 2:
                    m6923f();
                    return true;
                case 3:
                    m6910b(message.arg1, ((Long) message.obj).longValue());
                    return true;
                case 4:
                    m6924g();
                    return true;
                case 5:
                    m6925h();
                    return true;
                case 6:
                    m6904a((Pair) message.obj);
                    return true;
                case 7:
                    m6916c((C2140c) message.obj);
                    return true;
                case 8:
                    m6920d((C2140c) message.obj);
                    return true;
                case 9:
                    m6927j();
                    return true;
                case 10:
                    m6918c((C2116c[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.f6298h.obtainMessage(6, e).sendToTarget();
            m6924g();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.f6298h.obtainMessage(6, C2109d.m6415a(e2)).sendToTarget();
            m6924g();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.f6298h.obtainMessage(6, C2109d.m6417a(e3)).sendToTarget();
            m6924g();
            return true;
        }
    }
}
