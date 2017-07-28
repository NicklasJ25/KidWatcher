package com.google.android.exoplayer2.p064k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C2113b;
import com.google.android.exoplayer2.drm.C2115d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p042d.C1950b;
import com.google.android.exoplayer2.p042d.C2098a;
import com.google.android.exoplayer2.p042d.C2100c;
import com.google.android.exoplayer2.p042d.C2108d;
import com.google.android.exoplayer2.p043j.C2258h;
import com.google.android.exoplayer2.p043j.C2271q;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p044b.C1956d;
import com.google.android.exoplayer2.p064k.C2289e.C2288a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class C2278c extends C1950b {
    private final C2280d f6497b;
    private final C2288a f6498c;
    private final long f6499d;
    private final int f6500e;
    private final int f6501f;
    private final boolean f6502g = C2278c.m7153B();
    private Format[] f6503h;
    private C2277a f6504i;
    private Surface f6505j;
    private boolean f6506k;
    private long f6507l = -9223372036854775807L;
    private long f6508m;
    private int f6509n;
    private int f6510o;
    private int f6511p;
    private float f6512q = -1.0f;
    private int f6513r = -1;
    private int f6514s = -1;
    private int f6515t;
    private float f6516u = -1.0f;
    private int f6517v = -1;
    private int f6518w = -1;
    private int f6519x;
    private float f6520y = -1.0f;

    private static final class C2277a {
        public final int f6494a;
        public final int f6495b;
        public final int f6496c;

        public C2277a(int i, int i2, int i3) {
            this.f6494a = i;
            this.f6495b = i2;
            this.f6496c = i3;
        }
    }

    public C2278c(Context context, C2100c c2100c, int i, long j, C2113b<C2115d> c2113b, boolean z, Handler handler, C2289e c2289e, int i2) {
        super(2, c2100c, c2113b, z);
        this.f6500e = i;
        this.f6499d = j;
        this.f6501f = i2;
        this.f6497b = new C2280d(context);
        this.f6498c = new C2288a(handler, c2289e);
    }

    private static boolean m7153B() {
        return C2273r.f6478a <= 22 && "foster".equals(C2273r.f6479b) && "NVIDIA".equals(C2273r.f6480c);
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat m7154a(Format format, C2277a c2277a, boolean z) {
        MediaFormat b = format.m5493b();
        b.setInteger("max-width", c2277a.f6494a);
        b.setInteger("max-height", c2277a.f6495b);
        if (c2277a.f6496c != -1) {
            b.setInteger("max-input-size", c2277a.f6496c);
        }
        if (z) {
            b.setInteger("auto-frc", 0);
        }
        return b;
    }

    private static C2277a m7155a(Format format, Format[] formatArr) {
        int i = format.f4951i;
        int i2 = format.f4952j;
        int c = C2278c.m7161c(format);
        int i3 = c;
        c = i2;
        i2 = i;
        for (Format format2 : formatArr) {
            if (C2278c.m7159a(format, format2)) {
                i2 = Math.max(i2, format2.f4951i);
                c = Math.max(c, format2.f4952j);
                i3 = Math.max(i3, C2278c.m7161c(format2));
            }
        }
        return new C2277a(i2, c, i3);
    }

    private void m7156a(MediaCodec mediaCodec, int i) {
        C2271q.m7121a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        C2271q.m7120a();
        C1956d c1956d = this.a;
        c1956d.f5121e++;
    }

    @TargetApi(21)
    private void m7157a(MediaCodec mediaCodec, int i, long j) {
        m7165t();
        C2271q.m7121a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        C2271q.m7120a();
        C1956d c1956d = this.a;
        c1956d.f5120d++;
        this.f6510o = 0;
        if (!this.f6506k) {
            this.f6506k = true;
            this.f6498c.m7199a(this.f6505j);
        }
    }

    private void m7158a(Surface surface) {
        if (this.f6505j != surface) {
            this.f6506k = false;
            this.f6505j = surface;
            int d = mo2902d();
            if (d == 1 || d == 2) {
                m5667y();
                m5665w();
            }
        }
    }

    private static boolean m7159a(Format format, Format format2) {
        return format.f4947e.equals(format2.f4947e) && C2278c.m7164e(format) == C2278c.m7164e(format2);
    }

    private void m7160b(MediaCodec mediaCodec, int i) {
        C2271q.m7121a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        C2271q.m7120a();
        C1956d c1956d = this.a;
        c1956d.f5122f++;
        this.f6509n++;
        this.f6510o++;
        this.a.f5123g = Math.max(this.f6510o, this.a.f5123g);
        if (this.f6509n == this.f6501f) {
            m7166v();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m7161c(com.google.android.exoplayer2.Format r6) {
        /*
        r1 = 4;
        r0 = 2;
        r2 = -1;
        r3 = r6.f4948f;
        if (r3 == r2) goto L_0x000a;
    L_0x0007:
        r0 = r6.f4948f;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = r6.f4951i;
        if (r3 == r2) goto L_0x0012;
    L_0x000e:
        r3 = r6.f4952j;
        if (r3 != r2) goto L_0x0014;
    L_0x0012:
        r0 = r2;
        goto L_0x0009;
    L_0x0014:
        r3 = r6.f4947e;
        r4 = r3.hashCode();
        switch(r4) {
            case -1664118616: goto L_0x0023;
            case -1662541442: goto L_0x004b;
            case 1187890754: goto L_0x002d;
            case 1331836730: goto L_0x0037;
            case 1599127256: goto L_0x0041;
            case 1599127257: goto L_0x0055;
            default: goto L_0x001d;
        };
    L_0x001d:
        r3 = r2;
    L_0x001e:
        switch(r3) {
            case 0: goto L_0x005f;
            case 1: goto L_0x005f;
            case 2: goto L_0x006b;
            case 3: goto L_0x0089;
            case 4: goto L_0x008f;
            case 5: goto L_0x008f;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = r2;
        goto L_0x0009;
    L_0x0023:
        r4 = "video/3gpp";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x002b:
        r3 = 0;
        goto L_0x001e;
    L_0x002d:
        r4 = "video/mp4v-es";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0035:
        r3 = 1;
        goto L_0x001e;
    L_0x0037:
        r4 = "video/avc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x003f:
        r3 = r0;
        goto L_0x001e;
    L_0x0041:
        r4 = "video/x-vnd.on2.vp8";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0049:
        r3 = 3;
        goto L_0x001e;
    L_0x004b:
        r4 = "video/hevc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0053:
        r3 = r1;
        goto L_0x001e;
    L_0x0055:
        r4 = "video/x-vnd.on2.vp9";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x005d:
        r3 = 5;
        goto L_0x001e;
    L_0x005f:
        r1 = r6.f4951i;
        r2 = r6.f4952j;
        r1 = r1 * r2;
    L_0x0064:
        r1 = r1 * 3;
        r0 = r0 * 2;
        r0 = r1 / r0;
        goto L_0x0009;
    L_0x006b:
        r1 = "BRAVIA 4K 2015";
        r3 = com.google.android.exoplayer2.p043j.C2273r.f6481d;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r2;
        goto L_0x0009;
    L_0x0077:
        r1 = r6.f4951i;
        r1 = r1 + 15;
        r1 = r1 / 16;
        r2 = r6.f4952j;
        r2 = r2 + 15;
        r2 = r2 / 16;
        r1 = r1 * r2;
        r1 = r1 * 16;
        r1 = r1 * 16;
        goto L_0x0064;
    L_0x0089:
        r1 = r6.f4951i;
        r2 = r6.f4952j;
        r1 = r1 * r2;
        goto L_0x0064;
    L_0x008f:
        r0 = r6.f4951i;
        r2 = r6.f4952j;
        r0 = r0 * r2;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.c.c(com.google.android.exoplayer2.Format):int");
    }

    private void m7162c(MediaCodec mediaCodec, int i) {
        m7165t();
        C2271q.m7121a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        C2271q.m7120a();
        C1956d c1956d = this.a;
        c1956d.f5120d++;
        this.f6510o = 0;
        if (!this.f6506k) {
            this.f6506k = true;
            this.f6498c.m7199a(this.f6505j);
        }
    }

    private static float m7163d(Format format) {
        return format.f4955m == -1.0f ? 1.0f : format.f4955m;
    }

    private static int m7164e(Format format) {
        return format.f4954l == -1 ? 0 : format.f4954l;
    }

    private void m7165t() {
        if (this.f6517v != this.f6513r || this.f6518w != this.f6514s || this.f6519x != this.f6515t || this.f6520y != this.f6516u) {
            this.f6498c.m7197a(this.f6513r, this.f6514s, this.f6515t, this.f6516u);
            this.f6517v = this.f6513r;
            this.f6518w = this.f6514s;
            this.f6519x = this.f6515t;
            this.f6520y = this.f6516u;
        }
    }

    private void m7166v() {
        if (this.f6509n > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f6498c.m7198a(this.f6509n, elapsedRealtime - this.f6508m);
            this.f6509n = 0;
            this.f6508m = elapsedRealtime;
        }
    }

    protected int mo2920a(C2100c c2100c, Format format) {
        boolean z = false;
        String str = format.f4947e;
        if (!C2258h.m7044b(str)) {
            return 0;
        }
        boolean z2;
        DrmInitData drmInitData = format.f4950h;
        if (drmInitData != null) {
            z2 = false;
            for (int i = 0; i < drmInitData.f5928a; i++) {
                z2 |= drmInitData.m6424a(i).f5925c;
            }
        } else {
            z2 = false;
        }
        C2098a a = c2100c.mo3003a(str, z2);
        if (a == null) {
            return 1;
        }
        boolean b = a.m6385b(format.f4945c);
        if (!b || format.f4951i <= 0 || format.f4952j <= 0) {
            z = b;
        } else if (C2273r.f6478a >= 21) {
            z = format.f4953k > 0.0f ? a.m6382a(format.f4951i, format.f4952j, (double) format.f4953k) : a.m6381a(format.f4951i, format.f4952j);
        } else if (format.f4951i * format.f4952j <= C2108d.m6412b()) {
            z = true;
        }
        return (a.f5902b ? 8 : 4) | (z ? 3 : 2);
    }

    public void mo2896a(int i, Object obj) {
        if (i == 1) {
            m7158a((Surface) obj);
        } else {
            super.mo2896a(i, obj);
        }
    }

    protected void mo2913a(long j, boolean z) {
        super.mo2913a(j, z);
        this.f6506k = false;
        this.f6510o = 0;
        long elapsedRealtime = (!z || this.f6499d <= 0) ? -9223372036854775807L : SystemClock.elapsedRealtime() + this.f6499d;
        this.f6507l = elapsedRealtime;
    }

    protected void mo2922a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        this.f6513r = obj != null ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.f6514s = obj != null ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.f6516u = this.f6512q;
        if (C2273r.f6478a < 21) {
            this.f6515t = this.f6511p;
        } else if (this.f6511p == 90 || this.f6511p == 270) {
            int i = this.f6513r;
            this.f6513r = this.f6514s;
            this.f6514s = i;
            this.f6516u = 1.0f / this.f6516u;
        }
        mediaCodec.setVideoScalingMode(this.f6500e);
    }

    protected void mo2923a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.f6504i = C2278c.m7155a(format, this.f6503h);
        mediaCodec.configure(C2278c.m7154a(format, this.f6504i, this.f6502g), this.f6505j, mediaCrypto, 0);
    }

    protected void mo2924a(String str, long j, long j2) {
        this.f6498c.m7202a(str, j, j2);
    }

    protected void mo2914a(boolean z) {
        super.mo2914a(z);
        this.f6498c.m7201a(this.a);
        this.f6497b.m7193a();
    }

    protected void mo3065a(Format[] formatArr) {
        this.f6503h = formatArr;
        super.mo3065a(formatArr);
    }

    protected boolean mo2925a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (z) {
            m7156a(mediaCodec, i);
            return true;
        } else if (!this.f6506k) {
            if (C2273r.f6478a >= 21) {
                m7157a(mediaCodec, i, System.nanoTime());
            } else {
                m7162c(mediaCodec, i);
            }
            return true;
        } else if (mo2902d() != 2) {
            return false;
        } else {
            long elapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            elapsedRealtime = this.f6497b.m7192a(j3, (elapsedRealtime * 1000) + nanoTime);
            nanoTime = (elapsedRealtime - nanoTime) / 1000;
            if (nanoTime < -30000) {
                m7160b(mediaCodec, i);
                return true;
            }
            if (C2273r.f6478a >= 21) {
                if (nanoTime < 50000) {
                    m7157a(mediaCodec, i, elapsedRealtime);
                    return true;
                }
            } else if (nanoTime < 30000) {
                if (nanoTime > 11000) {
                    try {
                        Thread.sleep((nanoTime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m7162c(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    protected boolean mo3108a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return C2278c.m7159a(format, format2) && format2.f4951i <= this.f6504i.f6494a && format2.f4952j <= this.f6504i.f6495b && format2.f4948f <= this.f6504i.f6496c && (z || (format.f4951i == format2.f4951i && format.f4952j == format2.f4952j));
    }

    protected void mo2927b(Format format) {
        super.mo2927b(format);
        this.f6498c.m7200a(format);
        this.f6512q = C2278c.m7163d(format);
        this.f6511p = C2278c.m7164e(format);
    }

    protected void mo2915m() {
        super.mo2915m();
        this.f6509n = 0;
        this.f6508m = SystemClock.elapsedRealtime();
    }

    protected void mo2916n() {
        this.f6507l = -9223372036854775807L;
        m7166v();
        super.mo2916n();
    }

    protected void mo2917o() {
        this.f6513r = -1;
        this.f6514s = -1;
        this.f6516u = -1.0f;
        this.f6512q = -1.0f;
        this.f6517v = -1;
        this.f6518w = -1;
        this.f6520y = -1.0f;
        this.f6497b.m7194b();
        try {
            super.mo2917o();
        } finally {
            this.a.m5705a();
            this.f6498c.m7203b(this.a);
        }
    }

    public boolean mo2918r() {
        if ((this.f6506k || super.mo3109x()) && super.mo2918r()) {
            this.f6507l = -9223372036854775807L;
            return true;
        } else if (this.f6507l == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f6507l) {
                return true;
            }
            this.f6507l = -9223372036854775807L;
            return false;
        }
    }

    protected boolean mo3109x() {
        return super.mo3109x() && this.f6505j != null && this.f6505j.isValid();
    }
}
