package com.google.android.exoplayer2.p055f;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C2251i;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2255d;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p044b.C1957e;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C1986b;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2026d;
import com.google.android.exoplayer2.p045c.C2026d.C1998c;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;
import com.google.android.exoplayer2.p055f.C2140c.C2149a;
import com.google.android.exoplayer2.p055f.C2145d.C2146a;
import com.google.android.exoplayer2.p055f.C2147b.C2143a;
import com.google.android.exoplayer2.p055f.C2147b.C2144b;
import com.google.android.exoplayer2.p056i.C2220b;
import com.google.android.exoplayer2.p056i.C2222f;
import com.google.android.exoplayer2.p056i.C2230h;
import com.google.android.exoplayer2.p056i.C2250q;
import com.google.android.exoplayer2.p056i.C2250q.C2134c;
import com.google.android.exoplayer2.p056i.C2250q.C2141a;
import java.io.EOFException;
import java.io.IOException;

final class C2142a implements C1998c, C2090h, C2140c, C2141a<C2135a> {
    private long f5978A;
    private int f5979B;
    private boolean f5980C;
    private boolean f5981D;
    private final Uri f5982a;
    private final C2222f f5983b;
    private final int f5984c;
    private final Handler f5985d;
    private final C2143a f5986e;
    private final C2146a f5987f;
    private final C2220b f5988g;
    private final C2250q f5989h = new C2250q("Loader:ExtractorMediaPeriod");
    private final C2136b f5990i;
    private final C2255d f5991j;
    private final Runnable f5992k;
    private final Runnable f5993l;
    private final Handler f5994m;
    private final SparseArray<C2026d> f5995n;
    private C2149a f5996o;
    private C1967m f5997p;
    private boolean f5998q;
    private boolean f5999r;
    private boolean f6000s;
    private boolean f6001t;
    private int f6002u;
    private C2153i f6003v;
    private long f6004w;
    private boolean[] f6005x;
    private long f6006y;
    private long f6007z;

    class C21301 implements Runnable {
        final /* synthetic */ C2142a f5958a;

        C21301(C2142a c2142a) {
            this.f5958a = c2142a;
        }

        public void run() {
            this.f5958a.m6518i();
        }
    }

    class C21312 implements Runnable {
        final /* synthetic */ C2142a f5959a;

        C21312(C2142a c2142a) {
            this.f5959a = c2142a;
        }

        public void run() {
            if (!this.f5959a.f5981D) {
                this.f5959a.f5996o.mo3093a(this.f5959a);
            }
        }
    }

    final class C2135a implements C2134c {
        final /* synthetic */ C2142a f5964a;
        private final Uri f5965b;
        private final C2222f f5966c;
        private final C2136b f5967d;
        private final C2255d f5968e;
        private final C2093l f5969f = new C2093l();
        private volatile boolean f5970g;
        private boolean f5971h = true;
        private long f5972i = -1;

        public C2135a(C2142a c2142a, Uri uri, C2222f c2222f, C2136b c2136b, C2255d c2255d) {
            this.f5964a = c2142a;
            this.f5965b = (Uri) C2252a.m7020a((Object) uri);
            this.f5966c = (C2222f) C2252a.m7020a((Object) c2222f);
            this.f5967d = (C2136b) C2252a.m7020a((Object) c2136b);
            this.f5968e = c2255d;
        }

        public void mo3010a() {
            this.f5970g = true;
        }

        public void m6481a(long j) {
            this.f5969f.f5889a = j;
            this.f5971h = true;
        }

        public boolean mo3011b() {
            return this.f5970g;
        }

        public void mo3012c() {
            Throwable th;
            C1985g c1985g;
            Throwable th2;
            int i = 0;
            while (i == 0 && !this.f5970g) {
                int a;
                try {
                    long j = this.f5969f.f5889a;
                    this.f5972i = this.f5966c.mo3095a(new C2230h(this.f5965b, j, -1, C2273r.m7144g(this.f5965b.toString())));
                    if (this.f5972i != -1) {
                        this.f5972i += j;
                    }
                    C1985g c1986b = new C1986b(this.f5966c, j, this.f5972i);
                    try {
                        int i2;
                        C1966f a2 = this.f5967d.m6484a(c1986b);
                        if (this.f5971h) {
                            a2.mo2941a(j);
                            this.f5971h = false;
                        }
                        long j2 = j;
                        int i3 = i;
                        while (i3 == 0) {
                            try {
                                if (this.f5970g) {
                                    break;
                                }
                                this.f5968e.m7036c();
                                a = a2.mo2940a(c1986b, this.f5969f);
                                try {
                                    if (c1986b.mo2967c() > 1048576 + j2) {
                                        j2 = c1986b.mo2967c();
                                        this.f5968e.m7035b();
                                        this.f5964a.f5994m.post(this.f5964a.f5993l);
                                        i3 = a;
                                    } else {
                                        i3 = a;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    c1985g = c1986b;
                                    th2 = th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                a = i3;
                                c1985g = c1986b;
                                th2 = th;
                            }
                        }
                        if (i3 == 1) {
                            i2 = 0;
                        } else {
                            if (c1986b != null) {
                                this.f5969f.f5889a = c1986b.mo2967c();
                            }
                            i2 = i3;
                        }
                        this.f5966c.mo3096a();
                        i = i2;
                    } catch (Throwable th32) {
                        a = i;
                        C1985g c1985g2 = c1986b;
                        th2 = th32;
                        c1985g = c1985g2;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    c1985g = null;
                    a = i;
                }
            }
            return;
            if (!(a == 1 || c1985g == null)) {
                this.f5969f.f5889a = c1985g.mo2967c();
            }
            this.f5966c.mo3096a();
            throw th2;
        }
    }

    private static final class C2136b {
        private final C1966f[] f5973a;
        private final C2090h f5974b;
        private C1966f f5975c;

        public C2136b(C1966f[] c1966fArr, C2090h c2090h) {
            this.f5973a = c1966fArr;
            this.f5974b = c2090h;
        }

        public C1966f m6484a(C1985g c1985g) {
            if (this.f5975c != null) {
                return this.f5975c;
            }
            C1966f[] c1966fArr = this.f5973a;
            int length = c1966fArr.length;
            int i = 0;
            loop0:
            while (i < length) {
                C1966f c1966f = c1966fArr[i];
                try {
                    if (c1966f.mo2944a(c1985g)) {
                        this.f5975c = c1966f;
                        c1985g.mo2961a();
                        break loop0;
                    }
                    i++;
                } catch (EOFException e) {
                    i++;
                } finally {
                    c1985g.mo2961a();
                }
            }
            if (this.f5975c == null) {
                throw new C2144b(this.f5973a);
            }
            this.f5975c.mo2942a(this.f5974b);
            return this.f5975c;
        }

        public void m6485a() {
            if (this.f5975c != null) {
                this.f5975c.mo2947c();
                this.f5975c = null;
            }
        }
    }

    private final class C2138c implements C2137e {
        final /* synthetic */ C2142a f5976a;
        private final int f5977b;

        public C2138c(C2142a c2142a, int i) {
            this.f5976a = c2142a;
            this.f5977b = i;
        }

        public int mo3013a(C2251i c2251i, C1957e c1957e) {
            return this.f5976a.m6523a(this.f5977b, c2251i, c1957e);
        }

        public void mo3014a(long j) {
            ((C2026d) this.f5976a.f5995n.valueAt(this.f5977b)).m6063a(j);
        }

        public boolean mo3015a() {
            return this.f5976a.m6539b(this.f5977b);
        }

        public void mo3016b() {
            this.f5976a.m6545h();
        }
    }

    public C2142a(Uri uri, C2222f c2222f, C1966f[] c1966fArr, int i, Handler handler, C2143a c2143a, C2146a c2146a, C2220b c2220b) {
        this.f5982a = uri;
        this.f5983b = c2222f;
        this.f5984c = i;
        this.f5985d = handler;
        this.f5986e = c2143a;
        this.f5987f = c2146a;
        this.f5988g = c2220b;
        this.f5990i = new C2136b(c1966fArr, this);
        this.f5991j = new C2255d();
        this.f5992k = new C21301(this);
        this.f5993l = new C21312(this);
        this.f5994m = new Handler();
        this.f5978A = -9223372036854775807L;
        this.f5995n = new SparseArray();
        this.f6006y = -1;
    }

    private void m6507a(C2135a c2135a) {
        if (this.f6006y == -1) {
            this.f6006y = c2135a.f5972i;
        }
    }

    private boolean m6509a(IOException iOException) {
        return iOException instanceof C2144b;
    }

    private void m6510b(C2135a c2135a) {
        if (this.f6006y != -1) {
            return;
        }
        if (this.f5997p == null || this.f5997p.mo2945b() == -9223372036854775807L) {
            this.f6007z = 0;
            this.f6001t = this.f5999r;
            int size = this.f5995n.size();
            for (int i = 0; i < size; i++) {
                C2026d c2026d = (C2026d) this.f5995n.valueAt(i);
                boolean z = !this.f5999r || this.f6005x[i];
                c2026d.m6062a(z);
            }
            c2135a.m6481a(0);
        }
    }

    private void m6511b(final IOException iOException) {
        if (this.f5985d != null && this.f5986e != null) {
            this.f5985d.post(new Runnable(this) {
                final /* synthetic */ C2142a f5963b;

                public void run() {
                    this.f5963b.f5986e.m6546a(iOException);
                }
            });
        }
    }

    private void m6518i() {
        if (!this.f5981D && !this.f5999r && this.f5997p != null && this.f5998q) {
            int size = this.f5995n.size();
            int i = 0;
            while (i < size) {
                if (((C2026d) this.f5995n.valueAt(i)).m6066d() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.f5991j.m7035b();
            C2152h[] c2152hArr = new C2152h[size];
            this.f6005x = new boolean[size];
            this.f6004w = this.f5997p.mo2945b();
            for (i = 0; i < size; i++) {
                c2152hArr[i] = new C2152h(((C2026d) this.f5995n.valueAt(i)).m6066d());
            }
            this.f6003v = new C2153i(c2152hArr);
            this.f5999r = true;
            this.f5987f.mo3037a(new C2151g(this.f6004w, this.f5997p.mo2943a()), null);
            this.f5996o.mo3092a(this);
        }
    }

    private void m6519j() {
        C2134c c2135a = new C2135a(this, this.f5982a, this.f5983b, this.f5990i, this.f5991j);
        if (this.f5999r) {
            C2252a.m7024b(m6522m());
            if (this.f6004w == -9223372036854775807L || this.f5978A < this.f6004w) {
                c2135a.m6481a(this.f5997p.mo2946b(this.f5978A));
                this.f5978A = -9223372036854775807L;
            } else {
                this.f5980C = true;
                this.f5978A = -9223372036854775807L;
                return;
            }
        }
        this.f5979B = m6520k();
        int i = this.f5984c;
        if (i == -1) {
            i = (this.f5999r && this.f6006y == -1 && (this.f5997p == null || this.f5997p.mo2945b() == -9223372036854775807L)) ? 6 : 3;
        }
        this.f5989h.m7013a(c2135a, this, i);
    }

    private int m6520k() {
        int i = 0;
        for (int i2 = 0; i2 < this.f5995n.size(); i2++) {
            i += ((C2026d) this.f5995n.valueAt(i2)).m6055a();
        }
        return i;
    }

    private long m6521l() {
        long j = Long.MIN_VALUE;
        int size = this.f5995n.size();
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((C2026d) this.f5995n.valueAt(i)).m6067e());
        }
        return j;
    }

    private boolean m6522m() {
        return this.f5978A != -9223372036854775807L;
    }

    int m6523a(int i, C2251i c2251i, C1957e c1957e) {
        if (this.f6001t || m6522m()) {
            return -3;
        }
        return ((C2026d) this.f5995n.valueAt(i)).m6057a(c2251i, c1957e, this.f5980C, this.f6007z);
    }

    public int m6524a(C2135a c2135a, long j, long j2, IOException iOException) {
        m6507a(c2135a);
        m6511b(iOException);
        if (m6509a(iOException)) {
            return 3;
        }
        int i = m6520k() > this.f5979B ? 1 : 0;
        m6510b(c2135a);
        this.f5979B = m6520k();
        return i == 0 ? 0 : 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo3018a(com.google.android.exoplayer2.p063h.C2202f[] r8, boolean[] r9, com.google.android.exoplayer2.p055f.C2137e[] r10, boolean[] r11, long r12) {
        /*
        r7 = this;
        r3 = 1;
        r2 = 0;
        r0 = r7.f5999r;
        com.google.android.exoplayer2.p043j.C2252a.m7024b(r0);
        r1 = r2;
    L_0x0008:
        r0 = r8.length;
        if (r1 >= r0) goto L_0x0042;
    L_0x000b:
        r0 = r10[r1];
        if (r0 == 0) goto L_0x003e;
    L_0x000f:
        r0 = r8[r1];
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        r0 = r9[r1];
        if (r0 != 0) goto L_0x003e;
    L_0x0017:
        r0 = r10[r1];
        r0 = (com.google.android.exoplayer2.p055f.C2142a.C2138c) r0;
        r0 = r0.f5977b;
        r4 = r7.f6005x;
        r4 = r4[r0];
        com.google.android.exoplayer2.p043j.C2252a.m7024b(r4);
        r4 = r7.f6002u;
        r4 = r4 + -1;
        r7.f6002u = r4;
        r4 = r7.f6005x;
        r4[r0] = r2;
        r4 = r7.f5995n;
        r0 = r4.valueAt(r0);
        r0 = (com.google.android.exoplayer2.p045c.C2026d) r0;
        r0.m6064b();
        r0 = 0;
        r10[r1] = r0;
    L_0x003e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0008;
    L_0x0042:
        r0 = r2;
        r1 = r2;
    L_0x0044:
        r4 = r8.length;
        if (r0 >= r4) goto L_0x0096;
    L_0x0047:
        r4 = r10[r0];
        if (r4 != 0) goto L_0x008d;
    L_0x004b:
        r4 = r8[r0];
        if (r4 == 0) goto L_0x008d;
    L_0x004f:
        r4 = r8[r0];
        r1 = r4.mo3088b();
        if (r1 != r3) goto L_0x0090;
    L_0x0057:
        r1 = r3;
    L_0x0058:
        com.google.android.exoplayer2.p043j.C2252a.m7024b(r1);
        r1 = r4.mo3089b(r2);
        if (r1 != 0) goto L_0x0092;
    L_0x0061:
        r1 = r3;
    L_0x0062:
        com.google.android.exoplayer2.p043j.C2252a.m7024b(r1);
        r1 = r7.f6003v;
        r4 = r4.mo3087a();
        r4 = r1.m6575a(r4);
        r1 = r7.f6005x;
        r1 = r1[r4];
        if (r1 != 0) goto L_0x0094;
    L_0x0075:
        r1 = r3;
    L_0x0076:
        com.google.android.exoplayer2.p043j.C2252a.m7024b(r1);
        r1 = r7.f6002u;
        r1 = r1 + 1;
        r7.f6002u = r1;
        r1 = r7.f6005x;
        r1[r4] = r3;
        r1 = new com.google.android.exoplayer2.f.a$c;
        r1.<init>(r7, r4);
        r10[r0] = r1;
        r11[r0] = r3;
        r1 = r3;
    L_0x008d:
        r0 = r0 + 1;
        goto L_0x0044;
    L_0x0090:
        r1 = r2;
        goto L_0x0058;
    L_0x0092:
        r1 = r2;
        goto L_0x0062;
    L_0x0094:
        r1 = r2;
        goto L_0x0076;
    L_0x0096:
        r0 = r7.f6000s;
        if (r0 != 0) goto L_0x00b8;
    L_0x009a:
        r0 = r7.f5995n;
        r5 = r0.size();
        r4 = r2;
    L_0x00a1:
        if (r4 >= r5) goto L_0x00b8;
    L_0x00a3:
        r0 = r7.f6005x;
        r0 = r0[r4];
        if (r0 != 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r7.f5995n;
        r0 = r0.valueAt(r4);
        r0 = (com.google.android.exoplayer2.p045c.C2026d) r0;
        r0.m6064b();
    L_0x00b4:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00a1;
    L_0x00b8:
        r0 = r7.f6002u;
        if (r0 != 0) goto L_0x00ce;
    L_0x00bc:
        r7.f6001t = r2;
        r0 = r7.f5989h;
        r0 = r0.m7016a();
        if (r0 == 0) goto L_0x00cb;
    L_0x00c6:
        r0 = r7.f5989h;
        r0.m7017b();
    L_0x00cb:
        r7.f6000s = r3;
        return r12;
    L_0x00ce:
        r0 = r7.f6000s;
        if (r0 == 0) goto L_0x00e4;
    L_0x00d2:
        if (r1 == 0) goto L_0x00cb;
    L_0x00d4:
        r12 = r7.mo3027b(r12);
    L_0x00d8:
        r0 = r10.length;
        if (r2 >= r0) goto L_0x00cb;
    L_0x00db:
        r0 = r10[r2];
        if (r0 == 0) goto L_0x00e1;
    L_0x00df:
        r11[r2] = r3;
    L_0x00e1:
        r2 = r2 + 1;
        goto L_0x00d8;
    L_0x00e4:
        r0 = 0;
        r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00cb;
    L_0x00ea:
        goto L_0x00d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.a.a(com.google.android.exoplayer2.h.f[], boolean[], com.google.android.exoplayer2.f.e[], boolean[], long):long");
    }

    public C2025o mo3019a(int i) {
        C2026d c2026d = (C2026d) this.f5995n.get(i);
        if (c2026d != null) {
            return c2026d;
        }
        C2025o c2026d2 = new C2026d(this.f5988g);
        c2026d2.m6060a((C1998c) this);
        this.f5995n.put(i, c2026d2);
        return c2026d2;
    }

    public void mo3020a() {
        this.f5998q = true;
        this.f5994m.post(this.f5992k);
    }

    public void mo3021a(Format format) {
        this.f5994m.post(this.f5992k);
    }

    public void mo3022a(C1967m c1967m) {
        this.f5997p = c1967m;
        this.f5994m.post(this.f5992k);
    }

    public void m6531a(C2135a c2135a, long j, long j2) {
        m6507a(c2135a);
        this.f5980C = true;
        if (this.f6004w == -9223372036854775807L) {
            long l = m6521l();
            this.f6004w = l == Long.MIN_VALUE ? 0 : l + 10000;
            this.f5987f.mo3037a(new C2151g(this.f6004w, this.f5997p.mo2943a()), null);
        }
    }

    public void m6532a(C2135a c2135a, long j, long j2, boolean z) {
        m6507a(c2135a);
        if (!z && this.f6002u > 0) {
            int size = this.f5995n.size();
            for (int i = 0; i < size; i++) {
                ((C2026d) this.f5995n.valueAt(i)).m6062a(this.f6005x[i]);
            }
            this.f5996o.mo3093a(this);
        }
    }

    public void mo3023a(C2149a c2149a) {
        this.f5996o = c2149a;
        this.f5991j.m7034a();
        m6519j();
    }

    public boolean mo3026a(long j) {
        if (this.f5980C) {
            return false;
        }
        boolean a = this.f5991j.m7034a();
        if (this.f5989h.m7016a()) {
            return a;
        }
        m6519j();
        return true;
    }

    public long mo3027b(long j) {
        if (!this.f5997p.mo2943a()) {
            j = 0;
        }
        this.f6007z = j;
        int size = this.f5995n.size();
        boolean z = !m6522m();
        int i = 0;
        while (z && i < size) {
            if (this.f6005x[i]) {
                z = ((C2026d) this.f5995n.valueAt(i)).m6063a(j);
            }
            i++;
        }
        if (!z) {
            this.f5978A = j;
            this.f5980C = false;
            if (this.f5989h.m7016a()) {
                this.f5989h.m7017b();
            } else {
                for (i = 0; i < size; i++) {
                    ((C2026d) this.f5995n.valueAt(i)).m6062a(this.f6005x[i]);
                }
            }
        }
        this.f6001t = false;
        return j;
    }

    public void m6538b() {
        final C2136b c2136b = this.f5990i;
        this.f5989h.m7015a(new Runnable(this) {
            final /* synthetic */ C2142a f5961b;

            public void run() {
                c2136b.m6485a();
                int size = this.f5961b.f5995n.size();
                for (int i = 0; i < size; i++) {
                    ((C2026d) this.f5961b.f5995n.valueAt(i)).m6064b();
                }
            }
        });
        this.f5994m.removeCallbacksAndMessages(null);
        this.f5981D = true;
    }

    boolean m6539b(int i) {
        return this.f5980C || !(m6522m() || ((C2026d) this.f5995n.valueAt(i)).m6065c());
    }

    public void mo3028c() {
        m6545h();
    }

    public C2153i mo3029d() {
        return this.f6003v;
    }

    public long mo3030e() {
        return mo3032g();
    }

    public long mo3031f() {
        if (!this.f6001t) {
            return -9223372036854775807L;
        }
        this.f6001t = false;
        return this.f6007z;
    }

    public long mo3032g() {
        if (this.f5980C) {
            return Long.MIN_VALUE;
        }
        if (m6522m()) {
            return this.f5978A;
        }
        long l = m6521l();
        return l == Long.MIN_VALUE ? this.f6007z : l;
    }

    void m6545h() {
        this.f5989h.m7018c();
    }
}
