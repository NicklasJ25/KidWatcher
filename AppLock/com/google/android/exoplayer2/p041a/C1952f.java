package com.google.android.exoplayer2.p041a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C1961b;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C2113b;
import com.google.android.exoplayer2.drm.C2115d;
import com.google.android.exoplayer2.p041a.C1935c.C1934a;
import com.google.android.exoplayer2.p042d.C1950b;
import com.google.android.exoplayer2.p042d.C2098a;
import com.google.android.exoplayer2.p042d.C2100c;
import com.google.android.exoplayer2.p043j.C1951g;
import com.google.android.exoplayer2.p043j.C2258h;
import com.google.android.exoplayer2.p043j.C2273r;
import java.nio.ByteBuffer;

@TargetApi(16)
public class C1952f extends C1950b implements C1951g {
    private final C1934a f5099b;
    private final C1944d f5100c;
    private boolean f5101d;
    private MediaFormat f5102e;
    private int f5103f;
    private int f5104g = 0;
    private long f5105h;
    private boolean f5106i;
    private boolean f5107j;
    private long f5108k;

    public C1952f(C2100c c2100c, C2113b<C2115d> c2113b, boolean z, Handler handler, C1935c c1935c, C1927b c1927b, int i) {
        super(1, c2100c, c2113b, z);
        this.f5100c = new C1944d(c1927b, i);
        this.f5099b = new C1934a(handler, c1935c);
    }

    protected int mo2920a(C2100c c2100c, Format format) {
        boolean z = false;
        String str = format.f4947e;
        if (!C2258h.m7043a(str)) {
            return 0;
        }
        if (mo2926a(str) && c2100c.mo3002a() != null) {
            return 7;
        }
        C2098a a = c2100c.mo3003a(str, false);
        if (a == null) {
            return 1;
        }
        if (C2273r.f6478a < 21 || ((format.f4959q == -1 || a.m6380a(format.f4959q)) && (format.f4958p == -1 || a.m6384b(format.f4958p)))) {
            z = true;
        }
        return (z ? 3 : 2) | 4;
    }

    protected C2098a mo2921a(C2100c c2100c, Format format, boolean z) {
        if (mo2926a(format.f4947e)) {
            C2098a a = c2100c.mo3002a();
            if (a != null) {
                this.f5101d = true;
                return a;
            }
        }
        this.f5101d = false;
        return super.mo2921a(c2100c, format, z);
    }

    public void mo2896a(int i, Object obj) {
        switch (i) {
            case 2:
                this.f5100c.m5560a(((Float) obj).floatValue());
                return;
            case 3:
                this.f5100c.m5561a((PlaybackParams) obj);
                return;
            default:
                super.mo2896a(i, obj);
                return;
        }
    }

    protected void mo2913a(long j, boolean z) {
        super.mo2913a(j, z);
        this.f5100c.m5572i();
        this.f5105h = j;
        this.f5106i = true;
    }

    protected void mo2922a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i = this.f5102e != null ? 1 : 0;
        String string = i != 0 ? this.f5102e.getString("mime") : "audio/raw";
        if (i != 0) {
            mediaFormat = this.f5102e;
        }
        this.f5100c.m5562a(string, mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), this.f5103f, 0);
    }

    protected void mo2923a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        if (this.f5101d) {
            this.f5102e = format.m5493b();
            this.f5102e.setString("mime", "audio/raw");
            mediaCodec.configure(this.f5102e, null, mediaCrypto, 0);
            this.f5102e.setString("mime", format.f4947e);
            return;
        }
        mediaCodec.configure(format.m5493b(), null, mediaCrypto, 0);
        this.f5102e = null;
    }

    protected void mo2924a(String str, long j, long j2) {
        this.f5099b.m5512a(str, j, j2);
    }

    protected void mo2914a(boolean z) {
        super.mo2914a(z);
        this.f5099b.m5511a(this.a);
    }

    protected boolean mo2925a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.f5101d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            r2 = this.a;
            r2.f5121e++;
            this.f5100c.m5568e();
            return true;
        } else {
            if (this.f5100c.m5563a()) {
                boolean z2 = this.f5107j;
                this.f5107j = this.f5100c.m5570g();
                if (z2 && !this.f5107j && mo2902d() == 2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f5108k;
                    this.f5099b.m5509a(this.f5100c.m5565b(), C1961b.m5732a(this.f5100c.m5566c()), elapsedRealtime);
                }
            } else {
                try {
                    if (this.f5104g == 0) {
                        this.f5104g = this.f5100c.m5557a(0);
                        this.f5099b.m5508a(this.f5104g);
                        m5680b(this.f5104g);
                    } else {
                        this.f5100c.m5557a(this.f5104g);
                    }
                    this.f5107j = false;
                    if (mo2902d() == 2) {
                        this.f5100c.m5567d();
                    }
                } catch (Exception e) {
                    throw C2109d.m6416a(e, m5625p());
                }
            }
            try {
                int a = this.f5100c.m5558a(byteBuffer, j3);
                this.f5108k = SystemClock.elapsedRealtime();
                if ((a & 1) != 0) {
                    mo2930v();
                    this.f5106i = true;
                }
                if ((a & 2) == 0) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                r2 = this.a;
                r2.f5120d++;
                return true;
            } catch (Exception e2) {
                throw C2109d.m6416a(e2, m5625p());
            }
        }
    }

    protected boolean mo2926a(String str) {
        return this.f5100c.m5564a(str);
    }

    protected void m5680b(int i) {
    }

    protected void mo2927b(Format format) {
        super.mo2927b(format);
        this.f5099b.m5510a(format);
        this.f5103f = "audio/raw".equals(format.f4947e) ? format.f4960r : 2;
    }

    public C1951g mo2901c() {
        return this;
    }

    protected void mo2915m() {
        super.mo2915m();
        this.f5100c.m5567d();
    }

    protected void mo2916n() {
        this.f5100c.m5571h();
        super.mo2916n();
    }

    protected void mo2917o() {
        this.f5104g = 0;
        try {
            this.f5100c.m5573j();
            try {
                super.mo2917o();
            } finally {
                this.a.m5705a();
                this.f5099b.m5513b(this.a);
            }
        } catch (Throwable th) {
            super.mo2917o();
        } finally {
            this.a.m5705a();
            this.f5099b.m5513b(this.a);
        }
    }

    public boolean mo2918r() {
        return this.f5100c.m5570g() || super.mo2918r();
    }

    public boolean mo2919s() {
        return super.mo2919s() && !this.f5100c.m5570g();
    }

    public long mo2928t() {
        long a = this.f5100c.m5559a(mo2919s());
        if (a != Long.MIN_VALUE) {
            if (!this.f5106i) {
                a = Math.max(this.f5105h, a);
            }
            this.f5105h = a;
            this.f5106i = false;
        }
        return this.f5105h;
    }

    protected void mo2929u() {
        this.f5100c.m5569f();
    }

    protected void mo2930v() {
    }
}
