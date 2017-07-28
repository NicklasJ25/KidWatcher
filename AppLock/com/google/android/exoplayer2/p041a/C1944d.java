package com.google.android.exoplayer2.p041a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.C1961b;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class C1944d {
    public static boolean f5016a = false;
    public static boolean f5017b = false;
    private int f5018A;
    private int f5019B;
    private long f5020C;
    private long f5021D;
    private long f5022E;
    private float f5023F;
    private byte[] f5024G;
    private int f5025H;
    private ByteBuffer f5026I;
    private ByteBuffer f5027J;
    private boolean f5028K;
    private final C1927b f5029c;
    private final int f5030d;
    private final ConditionVariable f5031e = new ConditionVariable(true);
    private final long[] f5032f;
    private final C1938a f5033g;
    private AudioTrack f5034h;
    private AudioTrack f5035i;
    private int f5036j;
    private int f5037k;
    private int f5038l;
    private int f5039m;
    private boolean f5040n;
    private int f5041o;
    private int f5042p;
    private long f5043q;
    private int f5044r;
    private int f5045s;
    private long f5046t;
    private long f5047u;
    private boolean f5048v;
    private long f5049w;
    private Method f5050x;
    private long f5051y;
    private long f5052z;

    private static class C1938a {
        protected AudioTrack f4999a;
        private boolean f5000b;
        private int f5001c;
        private long f5002d;
        private long f5003e;
        private long f5004f;
        private long f5005g;
        private long f5006h;
        private long f5007i;

        private C1938a() {
        }

        public void m5520a() {
            if (this.f5005g == -9223372036854775807L) {
                this.f4999a.pause();
            }
        }

        public void m5521a(long j) {
            this.f5006h = m5524b();
            this.f5005g = SystemClock.elapsedRealtime() * 1000;
            this.f5007i = j;
            this.f4999a.stop();
        }

        public void mo2888a(AudioTrack audioTrack, boolean z) {
            this.f4999a = audioTrack;
            this.f5000b = z;
            this.f5005g = -9223372036854775807L;
            this.f5002d = 0;
            this.f5003e = 0;
            this.f5004f = 0;
            if (audioTrack != null) {
                this.f5001c = audioTrack.getSampleRate();
            }
        }

        public void mo2892a(PlaybackParams playbackParams) {
            throw new UnsupportedOperationException();
        }

        public long m5524b() {
            if (this.f5005g != -9223372036854775807L) {
                return Math.min(this.f5007i, ((((SystemClock.elapsedRealtime() * 1000) - this.f5005g) * ((long) this.f5001c)) / 1000000) + this.f5006h);
            }
            int playState = this.f4999a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f4999a.getPlaybackHeadPosition());
            if (this.f5000b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f5004f = this.f5002d;
                }
                playbackHeadPosition += this.f5004f;
            }
            if (this.f5002d > playbackHeadPosition) {
                this.f5003e++;
            }
            this.f5002d = playbackHeadPosition;
            return playbackHeadPosition + (this.f5003e << 32);
        }

        public long m5525c() {
            return (m5524b() * 1000000) / ((long) this.f5001c);
        }

        public boolean mo2889d() {
            return false;
        }

        public long mo2890e() {
            throw new UnsupportedOperationException();
        }

        public long mo2891f() {
            throw new UnsupportedOperationException();
        }

        public float mo2893g() {
            return 1.0f;
        }
    }

    @TargetApi(19)
    private static class C1939b extends C1938a {
        private final AudioTimestamp f5008b = new AudioTimestamp();
        private long f5009c;
        private long f5010d;
        private long f5011e;

        public C1939b() {
            super();
        }

        public void mo2888a(AudioTrack audioTrack, boolean z) {
            super.mo2888a(audioTrack, z);
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = 0;
        }

        public boolean mo2889d() {
            boolean timestamp = this.a.getTimestamp(this.f5008b);
            if (timestamp) {
                long j = this.f5008b.framePosition;
                if (this.f5010d > j) {
                    this.f5009c++;
                }
                this.f5010d = j;
                this.f5011e = j + (this.f5009c << 32);
            }
            return timestamp;
        }

        public long mo2890e() {
            return this.f5008b.nanoTime;
        }

        public long mo2891f() {
            return this.f5011e;
        }
    }

    @TargetApi(23)
    private static class C1940c extends C1939b {
        private PlaybackParams f5012b;
        private float f5013c = 1.0f;

        private void m5534h() {
            if (this.a != null && this.f5012b != null) {
                this.a.setPlaybackParams(this.f5012b);
            }
        }

        public void mo2888a(AudioTrack audioTrack, boolean z) {
            super.mo2888a(audioTrack, z);
            m5534h();
        }

        public void mo2892a(PlaybackParams playbackParams) {
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            PlaybackParams allowDefaults = playbackParams.allowDefaults();
            this.f5012b = allowDefaults;
            this.f5013c = allowDefaults.getSpeed();
            m5534h();
        }

        public float mo2893g() {
            return this.f5013c;
        }
    }

    public static final class C1941d extends Exception {
        public final int f5014a;

        public C1941d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.f5014a = i;
        }
    }

    public static final class C1942e extends RuntimeException {
        public C1942e(String str) {
            super(str);
        }
    }

    public static final class C1943f extends Exception {
        public final int f5015a;

        public C1943f(int i) {
            super("AudioTrack write failed: " + i);
            this.f5015a = i;
        }
    }

    public C1944d(C1927b c1927b, int i) {
        this.f5029c = c1927b;
        this.f5030d = i;
        if (C2273r.f6478a >= 18) {
            try {
                this.f5050x = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (C2273r.f6478a >= 23) {
            this.f5033g = new C1940c();
        } else if (C2273r.f6478a >= 19) {
            this.f5033g = new C1939b();
        } else {
            this.f5033g = new C1938a();
        }
        this.f5032f = new long[10];
        this.f5023F = 1.0f;
        this.f5019B = 0;
    }

    private static int m5538a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return C1945e.m5574a(byteBuffer);
        }
        if (i == 5) {
            return C1926a.m5494a();
        }
        if (i == 6) {
            return C1926a.m5496a(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    @TargetApi(21)
    private static int m5539a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private long m5540a(long j) {
        return j / ((long) this.f5041o);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer m5542a(java.nio.ByteBuffer r5, int r6, java.nio.ByteBuffer r7) {
        /*
        r4 = 0;
        r0 = r5.position();
        r2 = r5.limit();
        r1 = r2 - r0;
        switch(r6) {
            case -2147483648: goto L_0x0031;
            case 3: goto L_0x0014;
            case 1073741824: goto L_0x0036;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0014:
        r1 = r1 * 2;
    L_0x0016:
        if (r7 == 0) goto L_0x001e;
    L_0x0018:
        r3 = r7.capacity();
        if (r3 >= r1) goto L_0x0022;
    L_0x001e:
        r7 = java.nio.ByteBuffer.allocateDirect(r1);
    L_0x0022:
        r7.position(r4);
        r7.limit(r1);
        switch(r6) {
            case -2147483648: goto L_0x004d;
            case 3: goto L_0x0039;
            case 1073741824: goto L_0x0064;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0031:
        r1 = r1 / 3;
        r1 = r1 * 2;
        goto L_0x0016;
    L_0x0036:
        r1 = r1 / 2;
        goto L_0x0016;
    L_0x0039:
        if (r0 >= r2) goto L_0x007b;
    L_0x003b:
        r7.put(r4);
        r1 = r5.get(r0);
        r1 = r1 & 255;
        r1 = r1 + -128;
        r1 = (byte) r1;
        r7.put(r1);
        r0 = r0 + 1;
        goto L_0x0039;
    L_0x004d:
        if (r0 >= r2) goto L_0x007b;
    L_0x004f:
        r1 = r0 + 1;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 3;
        goto L_0x004d;
    L_0x0064:
        if (r0 >= r2) goto L_0x007b;
    L_0x0066:
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 3;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 4;
        goto L_0x0064;
    L_0x007b:
        r7.position(r4);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.d.a(java.nio.ByteBuffer, int, java.nio.ByteBuffer):java.nio.ByteBuffer");
    }

    @TargetApi(21)
    private static void m5543a(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static int m5544b(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    private long m5545b(long j) {
        return (1000000 * j) / ((long) this.f5036j);
    }

    private static void m5546b(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private long m5547c(long j) {
        return (((long) this.f5036j) * j) / 1000000;
    }

    private void m5548k() {
        if (!m5563a()) {
            return;
        }
        if (C2273r.f6478a >= 21) {
            C1944d.m5543a(this.f5035i, this.f5023F);
        } else {
            C1944d.m5546b(this.f5035i, this.f5023F);
        }
    }

    private void m5549l() {
        if (this.f5034h != null) {
            final AudioTrack audioTrack = this.f5034h;
            this.f5034h = null;
            new Thread(this) {
                final /* synthetic */ C1944d f4998b;

                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean m5550m() {
        return m5563a() && this.f5019B != 0;
    }

    private void m5551n() {
        long c = this.f5033g.m5525c();
        if (c != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f5047u >= 30000) {
                this.f5032f[this.f5044r] = c - nanoTime;
                this.f5044r = (this.f5044r + 1) % 10;
                if (this.f5045s < 10) {
                    this.f5045s++;
                }
                this.f5047u = nanoTime;
                this.f5046t = 0;
                for (int i = 0; i < this.f5045s; i++) {
                    this.f5046t += this.f5032f[i] / ((long) this.f5045s);
                }
            }
            if (!m5555r() && nanoTime - this.f5049w >= 500000) {
                this.f5048v = this.f5033g.mo2889d();
                if (this.f5048v) {
                    long e = this.f5033g.mo2890e() / 1000;
                    long f = this.f5033g.mo2891f();
                    if (e < this.f5021D) {
                        this.f5048v = false;
                    } else if (Math.abs(e - nanoTime) > 5000000) {
                        r0 = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f5017b) {
                            throw new C1942e(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f5048v = false;
                    } else if (Math.abs(m5545b(f) - c) > 5000000) {
                        r0 = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f5017b) {
                            throw new C1942e(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f5048v = false;
                    }
                }
                if (!(this.f5050x == null || this.f5040n)) {
                    try {
                        this.f5022E = (((long) ((Integer) this.f5050x.invoke(this.f5035i, (Object[]) null)).intValue()) * 1000) - this.f5043q;
                        this.f5022E = Math.max(this.f5022E, 0);
                        if (this.f5022E > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.f5022E);
                            this.f5022E = 0;
                        }
                    } catch (Exception e2) {
                        this.f5050x = null;
                    }
                }
                this.f5049w = nanoTime;
            }
        }
    }

    private void m5552o() {
        int state = this.f5035i.getState();
        if (state != 1) {
            try {
                this.f5035i.release();
            } catch (Exception e) {
            } finally {
                this.f5035i = null;
            }
            throw new C1941d(state, this.f5036j, this.f5037k, this.f5042p);
        }
    }

    private long m5553p() {
        return this.f5040n ? this.f5052z : m5540a(this.f5051y);
    }

    private void m5554q() {
        this.f5046t = 0;
        this.f5045s = 0;
        this.f5044r = 0;
        this.f5047u = 0;
        this.f5048v = false;
        this.f5049w = 0;
    }

    private boolean m5555r() {
        return C2273r.f6478a < 23 && (this.f5039m == 5 || this.f5039m == 6);
    }

    private boolean m5556s() {
        return m5555r() && this.f5035i.getPlayState() == 2 && this.f5035i.getPlaybackHeadPosition() == 0;
    }

    public int m5557a(int i) {
        this.f5031e.block();
        if (i == 0) {
            this.f5035i = new AudioTrack(this.f5030d, this.f5036j, this.f5037k, this.f5039m, this.f5042p, 1);
        } else {
            this.f5035i = new AudioTrack(this.f5030d, this.f5036j, this.f5037k, this.f5039m, this.f5042p, 1, i);
        }
        m5552o();
        int audioSessionId = this.f5035i.getAudioSessionId();
        if (f5016a && C2273r.f6478a < 21) {
            if (!(this.f5034h == null || audioSessionId == this.f5034h.getAudioSessionId())) {
                m5549l();
            }
            if (this.f5034h == null) {
                this.f5034h = new AudioTrack(this.f5030d, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.f5033g.mo2888a(this.f5035i, m5555r());
        m5548k();
        return audioSessionId;
    }

    public int m5558a(ByteBuffer byteBuffer, long j) {
        int remaining;
        int i = 1;
        int i2 = 0;
        int i3 = this.f5026I == null ? 1 : 0;
        boolean z = i3 != 0 || this.f5026I == byteBuffer;
        C2252a.m7024b(z);
        this.f5026I = byteBuffer;
        if (m5555r()) {
            if (this.f5035i.getPlayState() == 2) {
                return 0;
            }
            if (this.f5035i.getPlayState() == 1 && this.f5033g.m5524b() != 0) {
                return 0;
            }
        }
        if (i3 == 0) {
            i = 0;
        } else if (this.f5026I.hasRemaining()) {
            this.f5028K = this.f5039m != this.f5038l;
            if (this.f5028K) {
                C2252a.m7024b(this.f5039m == 2);
                this.f5027J = C1944d.m5542a(this.f5026I, this.f5038l, this.f5027J);
                byteBuffer = this.f5027J;
            }
            if (this.f5040n && this.f5018A == 0) {
                this.f5018A = C1944d.m5538a(this.f5039m, byteBuffer);
            }
            if (this.f5019B == 0) {
                this.f5020C = Math.max(0, j);
                this.f5019B = 1;
                i = 0;
            } else {
                long b = this.f5020C + m5545b(m5553p());
                if (this.f5019B == 1 && Math.abs(b - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b + ", got " + j + "]");
                    this.f5019B = 2;
                }
                if (this.f5019B == 2) {
                    this.f5020C = (j - b) + this.f5020C;
                    this.f5019B = 1;
                } else {
                    i = 0;
                }
            }
            if (C2273r.f6478a < 21) {
                remaining = byteBuffer.remaining();
                if (this.f5024G == null || this.f5024G.length < remaining) {
                    this.f5024G = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f5024G, 0, remaining);
                byteBuffer.position(position);
                this.f5025H = 0;
            }
        } else {
            this.f5026I = null;
            return 2;
        }
        if (this.f5028K) {
            byteBuffer = this.f5027J;
        }
        remaining = byteBuffer.remaining();
        if (C2273r.f6478a < 21) {
            position = this.f5042p - ((int) (this.f5051y - (this.f5033g.m5524b() * ((long) this.f5041o))));
            if (position > 0) {
                i2 = this.f5035i.write(this.f5024G, this.f5025H, Math.min(remaining, position));
                if (i2 >= 0) {
                    this.f5025H += i2;
                }
                byteBuffer.position(byteBuffer.position() + i2);
            }
        } else {
            i2 = C1944d.m5539a(this.f5035i, byteBuffer, remaining);
        }
        if (i2 < 0) {
            throw new C1943f(i2);
        }
        if (!this.f5040n) {
            this.f5051y += (long) i2;
        }
        if (i2 == remaining) {
            if (this.f5040n) {
                this.f5052z += (long) this.f5018A;
            }
            this.f5026I = null;
            i |= 2;
        }
        return i;
    }

    public long m5559a(boolean z) {
        if (!m5550m()) {
            return Long.MIN_VALUE;
        }
        if (this.f5035i.getPlayState() == 3) {
            m5551n();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.f5048v) {
            return m5545b(m5547c((long) (((float) (nanoTime - (this.f5033g.mo2890e() / 1000))) * this.f5033g.mo2893g())) + this.f5033g.mo2891f()) + this.f5020C;
        }
        nanoTime = this.f5045s == 0 ? this.f5033g.m5525c() + this.f5020C : (nanoTime + this.f5046t) + this.f5020C;
        return !z ? nanoTime - this.f5022E : nanoTime;
    }

    public void m5560a(float f) {
        if (this.f5023F != f) {
            this.f5023F = f;
            m5548k();
        }
    }

    public void m5561a(PlaybackParams playbackParams) {
        this.f5033g.mo2892a(playbackParams);
    }

    public void m5562a(String str, int i, int i2, int i3, int i4) {
        int i5;
        switch (i) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 12;
                break;
            case 3:
                i5 = 28;
                break;
            case 4:
                i5 = 204;
                break;
            case 5:
                i5 = 220;
                break;
            case 6:
                i5 = 252;
                break;
            case 7:
                i5 = 1276;
                break;
            case 8:
                i5 = C1961b.f5144a;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + i);
        }
        boolean z = !"audio/raw".equals(str);
        if (z) {
            i3 = C1944d.m5544b(str);
        } else if (!(i3 == 3 || i3 == 2 || i3 == Integer.MIN_VALUE || i3 == 1073741824)) {
            throw new IllegalArgumentException("Unsupported PCM encoding: " + i3);
        }
        if (!m5563a() || this.f5038l != i3 || this.f5036j != i2 || this.f5037k != i5) {
            m5572i();
            this.f5038l = i3;
            this.f5040n = z;
            this.f5036j = i2;
            this.f5037k = i5;
            if (!z) {
                i3 = 2;
            }
            this.f5039m = i3;
            this.f5041o = i * 2;
            if (i4 != 0) {
                this.f5042p = i4;
            } else if (!z) {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i5, this.f5039m);
                C2252a.m7024b(minBufferSize != -2);
                int i6 = minBufferSize * 4;
                i5 = ((int) m5547c(250000)) * this.f5041o;
                minBufferSize = (int) Math.max((long) minBufferSize, m5547c(750000) * ((long) this.f5041o));
                if (i6 >= i5) {
                    i5 = i6 > minBufferSize ? minBufferSize : i6;
                }
                this.f5042p = i5;
            } else if (this.f5039m == 5 || this.f5039m == 6) {
                this.f5042p = 20480;
            } else {
                this.f5042p = 49152;
            }
            this.f5043q = z ? -9223372036854775807L : m5545b(m5540a((long) this.f5042p));
        }
    }

    public boolean m5563a() {
        return this.f5035i != null;
    }

    public boolean m5564a(String str) {
        return this.f5029c != null && this.f5029c.m5506a(C1944d.m5544b(str));
    }

    public int m5565b() {
        return this.f5042p;
    }

    public long m5566c() {
        return this.f5043q;
    }

    public void m5567d() {
        if (m5563a()) {
            this.f5021D = System.nanoTime() / 1000;
            this.f5035i.play();
        }
    }

    public void m5568e() {
        if (this.f5019B == 1) {
            this.f5019B = 2;
        }
    }

    public void m5569f() {
        if (m5563a()) {
            this.f5033g.m5521a(m5553p());
        }
    }

    public boolean m5570g() {
        return m5563a() && (m5553p() > this.f5033g.m5524b() || m5556s());
    }

    public void m5571h() {
        if (m5563a()) {
            m5554q();
            this.f5033g.m5520a();
        }
    }

    public void m5572i() {
        if (m5563a()) {
            this.f5051y = 0;
            this.f5052z = 0;
            this.f5018A = 0;
            this.f5026I = null;
            this.f5019B = 0;
            this.f5022E = 0;
            m5554q();
            if (this.f5035i.getPlayState() == 3) {
                this.f5035i.pause();
            }
            final AudioTrack audioTrack = this.f5035i;
            this.f5035i = null;
            this.f5033g.mo2888a(null, false);
            this.f5031e.close();
            new Thread(this) {
                final /* synthetic */ C1944d f4996b;

                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        this.f4996b.f5031e.open();
                    }
                }
            }.start();
        }
    }

    public void m5573j() {
        m5572i();
        m5549l();
    }
}
