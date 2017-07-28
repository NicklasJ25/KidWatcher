package com.google.android.exoplayer2.p042d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.C1949a;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.C2251i;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C2112a;
import com.google.android.exoplayer2.drm.C2113b;
import com.google.android.exoplayer2.drm.C2115d;
import com.google.android.exoplayer2.p042d.C2108d.C2104b;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2271q;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p044b.C1956d;
import com.google.android.exoplayer2.p044b.C1957e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class C1950b extends C1949a {
    private static final byte[] f5063b = C2273r.m7143f("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private int f5064A;
    private boolean f5065B;
    private boolean f5066C;
    private int f5067D;
    private int f5068E;
    private boolean f5069F;
    private boolean f5070G;
    private boolean f5071H;
    private boolean f5072I;
    private boolean f5073J;
    protected C1956d f5074a;
    private final C2100c f5075c;
    private final C2113b<C2115d> f5076d;
    private final boolean f5077e;
    private final C1957e f5078f;
    private final C2251i f5079g;
    private final List<Long> f5080h;
    private final BufferInfo f5081i;
    private Format f5082j;
    private MediaCodec f5083k;
    private C2112a<C2115d> f5084l;
    private C2112a<C2115d> f5085m;
    private boolean f5086n;
    private boolean f5087o;
    private boolean f5088p;
    private boolean f5089q;
    private boolean f5090r;
    private boolean f5091s;
    private boolean f5092t;
    private boolean f5093u;
    private boolean f5094v;
    private ByteBuffer[] f5095w;
    private ByteBuffer[] f5096x;
    private long f5097y;
    private int f5098z;

    public static class C2099a extends Exception {
        public final String f5905a;
        public final boolean f5906b;
        public final String f5907c;
        public final String f5908d;

        public C2099a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.f5905a = format.f4947e;
            this.f5906b = z;
            this.f5907c = null;
            this.f5908d = C2099a.m6386a(i);
        }

        public C2099a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f5905a = format.f4947e;
            this.f5906b = z;
            this.f5907c = str;
            this.f5908d = C2273r.f6478a >= 21 ? C2099a.m6387a(th) : null;
        }

        private static String m6386a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        @TargetApi(21)
        private static String m6387a(Throwable th) {
            return th instanceof CodecException ? ((CodecException) th).getDiagnosticInfo() : null;
        }
    }

    public C1950b(int i, C2100c c2100c, C2113b<C2115d> c2113b, boolean z) {
        super(i);
        C2252a.m7024b(C2273r.f6478a >= 16);
        this.f5075c = (C2100c) C2252a.m7020a((Object) c2100c);
        this.f5076d = c2113b;
        this.f5077e = z;
        this.f5078f = new C1957e(0);
        this.f5079g = new C2251i();
        this.f5080h = new ArrayList();
        this.f5081i = new BufferInfo();
        this.f5067D = 0;
        this.f5068E = 0;
    }

    private void m5627B() {
        MediaFormat outputFormat = this.f5083k.getOutputFormat();
        if (this.f5089q && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.f5094v = true;
            return;
        }
        if (this.f5092t) {
            outputFormat.setInteger("channel-count", 1);
        }
        mo2922a(this.f5083k, outputFormat);
    }

    private void m5628C() {
        this.f5096x = this.f5083k.getOutputBuffers();
    }

    private void m5629D() {
        if (this.f5068E == 2) {
            m5667y();
            m5665w();
            return;
        }
        this.f5072I = true;
        mo2929u();
    }

    private static CryptoInfo m5630a(C1957e c1957e, int i) {
        CryptoInfo a = c1957e.f5124a.m5698a();
        if (i != 0) {
            if (a.numBytesOfClearData == null) {
                a.numBytesOfClearData = new int[1];
            }
            int[] iArr = a.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return a;
    }

    private void m5631a(C2099a c2099a) {
        throw C2109d.m6416a(c2099a, m5625p());
    }

    private static boolean mo2926a(String str) {
        return C2273r.f6478a < 18 || ((C2273r.f6478a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (C2273r.f6478a == 19 && C2273r.f6481d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))));
    }

    private static boolean m5633a(String str, Format format) {
        return C2273r.f6478a < 21 && format.f4949g.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private boolean m5634b(long j, long j2) {
        if (this.f5072I) {
            return false;
        }
        if (this.f5064A < 0) {
            this.f5064A = this.f5083k.dequeueOutputBuffer(this.f5081i, m5643A());
            if (this.f5064A >= 0) {
                if (this.f5094v) {
                    this.f5094v = false;
                    this.f5083k.releaseOutputBuffer(this.f5064A, false);
                    this.f5064A = -1;
                    return true;
                } else if ((this.f5081i.flags & 4) != 0) {
                    m5629D();
                    this.f5064A = -1;
                    return true;
                } else {
                    ByteBuffer byteBuffer = this.f5096x[this.f5064A];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.f5081i.offset);
                        byteBuffer.limit(this.f5081i.offset + this.f5081i.size);
                    }
                    this.f5065B = m5639d(this.f5081i.presentationTimeUs);
                }
            } else if (this.f5064A == -2) {
                m5627B();
                return true;
            } else if (this.f5064A == -3) {
                m5628C();
                return true;
            } else if (!this.f5090r || (!this.f5071H && this.f5068E != 2)) {
                return false;
            } else {
                m5629D();
                return true;
            }
        }
        if (!mo2925a(j, j2, this.f5083k, this.f5096x[this.f5064A], this.f5064A, this.f5081i.flags, this.f5081i.presentationTimeUs, this.f5065B)) {
            return false;
        }
        m5657c(this.f5081i.presentationTimeUs);
        this.f5064A = -1;
        return true;
    }

    private static boolean m5635b(String str) {
        return C2273r.f6478a < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(C2273r.f6479b) || "flounder_lte".equals(C2273r.f6479b) || "grouper".equals(C2273r.f6479b) || "tilapia".equals(C2273r.f6479b)));
    }

    private static boolean m5636b(String str, Format format) {
        return C2273r.f6478a <= 18 && format.f4958p == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean m5637b(boolean z) {
        if (this.f5084l == null) {
            return false;
        }
        int a = this.f5084l.m6425a();
        if (a != 0) {
            return a != 4 ? z || !this.f5077e : false;
        } else {
            throw C2109d.m6416a(this.f5084l.m6428c(), m5625p());
        }
    }

    private static boolean m5638c(String str) {
        return C2273r.f6478a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private boolean m5639d(long j) {
        int size = this.f5080h.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f5080h.get(i)).longValue() == j) {
                this.f5080h.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean m5640d(String str) {
        return C2273r.f6478a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private void mo2928t() {
        if (m5601a(this.f5079g, null) == -5) {
            mo2927b(this.f5079g.f6414a);
        }
    }

    private boolean mo2930v() {
        if (this.f5071H || this.f5068E == 2) {
            return false;
        }
        if (this.f5098z < 0) {
            this.f5098z = this.f5083k.dequeueInputBuffer(0);
            if (this.f5098z < 0) {
                return false;
            }
            this.f5078f.f5125b = this.f5095w[this.f5098z];
            this.f5078f.mo2931a();
        }
        if (this.f5068E == 1) {
            if (!this.f5090r) {
                this.f5070G = true;
                this.f5083k.queueInputBuffer(this.f5098z, 0, 0, 0, 4);
                this.f5098z = -1;
            }
            this.f5068E = 2;
            return false;
        } else if (this.f5093u) {
            this.f5093u = false;
            this.f5078f.f5125b.put(f5063b);
            this.f5083k.queueInputBuffer(this.f5098z, 0, f5063b.length, 0, 0);
            this.f5098z = -1;
            this.f5069F = true;
            return true;
        } else {
            int i;
            int i2;
            if (this.f5073J) {
                i = -4;
                i2 = 0;
            } else {
                if (this.f5067D == 1) {
                    for (i = 0; i < this.f5082j.f4949g.size(); i++) {
                        this.f5078f.f5125b.put((byte[]) this.f5082j.f4949g.get(i));
                    }
                    this.f5067D = 2;
                }
                i2 = this.f5078f.f5125b.position();
                i = m5601a(this.f5079g, this.f5078f);
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.f5067D == 2) {
                    this.f5078f.mo2931a();
                    this.f5067D = 1;
                }
                mo2927b(this.f5079g.f6414a);
                return true;
            } else if (this.f5078f.m5694c()) {
                if (this.f5067D == 2) {
                    this.f5078f.mo2931a();
                    this.f5067D = 1;
                }
                this.f5071H = true;
                if (this.f5069F) {
                    try {
                        if (this.f5090r) {
                            return false;
                        }
                        this.f5070G = true;
                        this.f5083k.queueInputBuffer(this.f5098z, 0, 0, 0, 4);
                        this.f5098z = -1;
                        return false;
                    } catch (Exception e) {
                        throw C2109d.m6416a(e, m5625p());
                    }
                }
                m5629D();
                return false;
            } else {
                boolean d = this.f5078f.m5708d();
                this.f5073J = m5637b(d);
                if (this.f5073J) {
                    return false;
                }
                if (this.f5087o && !d) {
                    C2261i.m7052a(this.f5078f.f5125b);
                    if (this.f5078f.f5125b.position() == 0) {
                        return true;
                    }
                    this.f5087o = false;
                }
                try {
                    long j = this.f5078f.f5126c;
                    if (this.f5078f.d_()) {
                        this.f5080h.add(Long.valueOf(j));
                    }
                    this.f5078f.m5709e();
                    m5651a(this.f5078f);
                    if (d) {
                        this.f5083k.queueSecureInputBuffer(this.f5098z, 0, C1950b.m5630a(this.f5078f, i2), j, 0);
                    } else {
                        this.f5083k.queueInputBuffer(this.f5098z, 0, this.f5078f.f5125b.limit(), j, 0);
                    }
                    this.f5098z = -1;
                    this.f5069F = true;
                    this.f5067D = 0;
                    C1956d c1956d = this.f5074a;
                    c1956d.f5119c++;
                    return true;
                } catch (Exception e2) {
                    throw C2109d.m6416a(e2, m5625p());
                }
            }
        }
    }

    protected long m5643A() {
        return 0;
    }

    public final int mo2911a(Format format) {
        try {
            return mo2920a(this.f5075c, format);
        } catch (Exception e) {
            throw C2109d.m6416a(e, m5625p());
        }
    }

    protected abstract int mo2920a(C2100c c2100c, Format format);

    protected C2098a mo2921a(C2100c c2100c, Format format, boolean z) {
        return c2100c.mo3003a(format.f4947e, z);
    }

    public void mo2912a(long j, long j2) {
        if (this.f5082j == null) {
            mo2928t();
        }
        m5665w();
        if (this.f5083k != null) {
            C2271q.m7121a("drainAndFeed");
            do {
            } while (m5634b(j, j2));
            do {
            } while (mo2930v());
            C2271q.m7120a();
        } else if (this.f5082j != null) {
            m5611b(j);
        }
        this.f5074a.m5705a();
    }

    protected void mo2913a(long j, boolean z) {
        this.f5071H = false;
        this.f5072I = false;
        if (this.f5083k != null) {
            m5668z();
        }
    }

    protected void mo2922a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected abstract void mo2923a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected void m5651a(C1957e c1957e) {
    }

    protected void mo2924a(String str, long j, long j2) {
    }

    protected void mo2914a(boolean z) {
        this.f5074a = new C1956d();
    }

    protected abstract boolean mo2925a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean mo3108a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    protected void mo2927b(Format format) {
        Format format2 = this.f5082j;
        this.f5082j = format;
        if (!C2273r.m7135a(this.f5082j.f4950h, format2 == null ? null : format2.f4950h)) {
            if (this.f5082j.f4950h == null) {
                this.f5085m = null;
            } else if (this.f5076d == null) {
                throw C2109d.m6416a(new IllegalStateException("Media requires a DrmSessionManager"), m5625p());
            } else {
                this.f5085m = this.f5076d.m6429a(Looper.myLooper(), this.f5082j.f4950h);
                if (this.f5085m == this.f5084l) {
                    this.f5076d.m6430a(this.f5085m);
                }
            }
        }
        if (this.f5085m == this.f5084l && this.f5083k != null && mo3108a(this.f5083k, this.f5086n, format2, this.f5082j)) {
            this.f5066C = true;
            this.f5067D = 1;
            boolean z = this.f5089q && this.f5082j.f4951i == format2.f4951i && this.f5082j.f4952j == format2.f4952j;
            this.f5093u = z;
        } else if (this.f5069F) {
            this.f5068E = 1;
        } else {
            m5667y();
            m5665w();
        }
    }

    protected void m5657c(long j) {
    }

    public final int mo2910l() {
        return 4;
    }

    protected void mo2915m() {
    }

    protected void mo2916n() {
    }

    protected void mo2917o() {
        this.f5082j = null;
        try {
            m5667y();
            try {
                if (this.f5084l != null) {
                    this.f5076d.m6430a(this.f5084l);
                }
                try {
                    if (!(this.f5085m == null || this.f5085m == this.f5084l)) {
                        this.f5076d.m6430a(this.f5085m);
                    }
                    this.f5084l = null;
                    this.f5085m = null;
                } catch (Throwable th) {
                    this.f5084l = null;
                    this.f5085m = null;
                }
            } catch (Throwable th2) {
                this.f5084l = null;
                this.f5085m = null;
            }
        } catch (Throwable th3) {
            this.f5084l = null;
            this.f5085m = null;
        }
    }

    public boolean mo2918r() {
        return (this.f5082j == null || this.f5073J || (!m5626q() && this.f5064A < 0 && (this.f5097y == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f5097y))) ? false : true;
    }

    public boolean mo2919s() {
        return this.f5072I;
    }

    protected void mo2929u() {
    }

    protected final void m5665w() {
        boolean a;
        Throwable th;
        if (mo3109x()) {
            MediaCrypto mediaCrypto;
            C2098a c2098a;
            String str;
            long elapsedRealtime;
            long elapsedRealtime2;
            C1956d c1956d;
            this.f5084l = this.f5085m;
            String str2 = this.f5082j.f4947e;
            if (this.f5084l != null) {
                int a2 = this.f5084l.m6425a();
                if (a2 == 0) {
                    throw C2109d.m6416a(this.f5084l.m6428c(), m5625p());
                } else if (a2 == 3 || a2 == 4) {
                    MediaCrypto a3 = ((C2115d) this.f5084l.m6427b()).m6431a();
                    a = this.f5084l.m6426a(str2);
                    mediaCrypto = a3;
                } else {
                    return;
                }
            }
            a = false;
            mediaCrypto = null;
            try {
                C2098a a4 = mo2921a(this.f5075c, this.f5082j, a);
                if (a4 == null && a) {
                    try {
                        a4 = mo2921a(this.f5075c, this.f5082j, false);
                        if (a4 != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str2 + ", but no secure decoder available. Trying to proceed with " + a4.f5901a + ".");
                        }
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        c2098a = a4;
                        th = th2;
                        m5631a(new C2099a(this.f5082j, th, a, -49998));
                        if (c2098a == null) {
                            m5631a(new C2099a(this.f5082j, null, a, -49999));
                        }
                        str = c2098a.f5901a;
                        this.f5086n = c2098a.f5902b;
                        this.f5087o = C1950b.m5633a(str, this.f5082j);
                        this.f5088p = C1950b.mo2926a(str);
                        this.f5089q = C1950b.m5635b(str);
                        this.f5090r = C1950b.m5638c(str);
                        this.f5091s = C1950b.m5640d(str);
                        this.f5092t = C1950b.m5636b(str, this.f5082j);
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        C2271q.m7121a("createCodec:" + str);
                        this.f5083k = MediaCodec.createByCodecName(str);
                        C2271q.m7120a();
                        C2271q.m7121a("configureCodec");
                        mo2923a(this.f5083k, this.f5082j, mediaCrypto);
                        C2271q.m7120a();
                        C2271q.m7121a("startCodec");
                        this.f5083k.start();
                        C2271q.m7120a();
                        elapsedRealtime2 = SystemClock.elapsedRealtime();
                        mo2924a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.f5095w = this.f5083k.getInputBuffers();
                        this.f5096x = this.f5083k.getOutputBuffers();
                        this.f5097y = mo2902d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
                        this.f5098z = -1;
                        this.f5064A = -1;
                        c1956d = this.f5074a;
                        c1956d.f5117a++;
                    }
                }
                c2098a = a4;
            } catch (C2104b e2) {
                th = e2;
                c2098a = null;
                m5631a(new C2099a(this.f5082j, th, a, -49998));
                if (c2098a == null) {
                    m5631a(new C2099a(this.f5082j, null, a, -49999));
                }
                str = c2098a.f5901a;
                this.f5086n = c2098a.f5902b;
                this.f5087o = C1950b.m5633a(str, this.f5082j);
                this.f5088p = C1950b.mo2926a(str);
                this.f5089q = C1950b.m5635b(str);
                this.f5090r = C1950b.m5638c(str);
                this.f5091s = C1950b.m5640d(str);
                this.f5092t = C1950b.m5636b(str, this.f5082j);
                elapsedRealtime = SystemClock.elapsedRealtime();
                C2271q.m7121a("createCodec:" + str);
                this.f5083k = MediaCodec.createByCodecName(str);
                C2271q.m7120a();
                C2271q.m7121a("configureCodec");
                mo2923a(this.f5083k, this.f5082j, mediaCrypto);
                C2271q.m7120a();
                C2271q.m7121a("startCodec");
                this.f5083k.start();
                C2271q.m7120a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                mo2924a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f5095w = this.f5083k.getInputBuffers();
                this.f5096x = this.f5083k.getOutputBuffers();
                if (mo2902d() == 2) {
                }
                this.f5097y = mo2902d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
                this.f5098z = -1;
                this.f5064A = -1;
                c1956d = this.f5074a;
                c1956d.f5117a++;
            }
            if (c2098a == null) {
                m5631a(new C2099a(this.f5082j, null, a, -49999));
            }
            str = c2098a.f5901a;
            this.f5086n = c2098a.f5902b;
            this.f5087o = C1950b.m5633a(str, this.f5082j);
            this.f5088p = C1950b.mo2926a(str);
            this.f5089q = C1950b.m5635b(str);
            this.f5090r = C1950b.m5638c(str);
            this.f5091s = C1950b.m5640d(str);
            this.f5092t = C1950b.m5636b(str, this.f5082j);
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                C2271q.m7121a("createCodec:" + str);
                this.f5083k = MediaCodec.createByCodecName(str);
                C2271q.m7120a();
                C2271q.m7121a("configureCodec");
                mo2923a(this.f5083k, this.f5082j, mediaCrypto);
                C2271q.m7120a();
                C2271q.m7121a("startCodec");
                this.f5083k.start();
                C2271q.m7120a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                mo2924a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f5095w = this.f5083k.getInputBuffers();
                this.f5096x = this.f5083k.getOutputBuffers();
            } catch (Throwable e3) {
                m5631a(new C2099a(this.f5082j, e3, a, str));
            }
            if (mo2902d() == 2) {
            }
            this.f5097y = mo2902d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
            this.f5098z = -1;
            this.f5064A = -1;
            c1956d = this.f5074a;
            c1956d.f5117a++;
        }
    }

    protected boolean mo3109x() {
        return this.f5083k == null && this.f5082j != null;
    }

    protected void m5667y() {
        if (this.f5083k != null) {
            this.f5097y = -9223372036854775807L;
            this.f5098z = -1;
            this.f5064A = -1;
            this.f5073J = false;
            this.f5065B = false;
            this.f5080h.clear();
            this.f5095w = null;
            this.f5096x = null;
            this.f5066C = false;
            this.f5069F = false;
            this.f5086n = false;
            this.f5087o = false;
            this.f5088p = false;
            this.f5089q = false;
            this.f5090r = false;
            this.f5091s = false;
            this.f5092t = false;
            this.f5093u = false;
            this.f5094v = false;
            this.f5070G = false;
            this.f5067D = 0;
            this.f5068E = 0;
            C1956d c1956d = this.f5074a;
            c1956d.f5118b++;
            try {
                this.f5083k.stop();
                try {
                    this.f5083k.release();
                    this.f5083k = null;
                    if (this.f5084l != null && this.f5085m != this.f5084l) {
                        try {
                            this.f5076d.m6430a(this.f5084l);
                        } finally {
                            this.f5084l = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f5083k = null;
                    if (!(this.f5084l == null || this.f5085m == this.f5084l)) {
                        this.f5076d.m6430a(this.f5084l);
                    }
                } finally {
                    this.f5084l = null;
                }
            } catch (Throwable th2) {
                this.f5083k = null;
                if (!(this.f5084l == null || this.f5085m == this.f5084l)) {
                    try {
                        this.f5076d.m6430a(this.f5084l);
                    } finally {
                        this.f5084l = null;
                    }
                }
            } finally {
                this.f5084l = null;
            }
        }
    }

    protected void m5668z() {
        this.f5097y = -9223372036854775807L;
        this.f5098z = -1;
        this.f5064A = -1;
        this.f5073J = false;
        this.f5065B = false;
        this.f5080h.clear();
        this.f5093u = false;
        this.f5094v = false;
        if (this.f5088p || (this.f5091s && this.f5070G)) {
            m5667y();
            m5665w();
        } else if (this.f5068E != 0) {
            m5667y();
            m5665w();
        } else {
            this.f5083k.flush();
            this.f5069F = false;
        }
        if (this.f5066C && this.f5082j != null) {
            this.f5067D = 1;
        }
    }
}
