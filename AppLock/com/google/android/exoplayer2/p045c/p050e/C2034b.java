package com.google.android.exoplayer2.p045c.p050e;

import android.support.v4.media.TransportMediator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2256e;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.p050e.C2033h.C2041a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class C2034b extends C2033h {
    private C2256e f5567a;
    private C2032a f5568b;

    private class C2032a implements C2029f, C1967m {
        final /* synthetic */ C2034b f5547a;
        private long[] f5548b;
        private long[] f5549c;
        private long f5550d;
        private volatile long f5551e;
        private volatile long f5552f;
        private long f5553g;

        private C2032a(C2034b c2034b) {
            this.f5547a = c2034b;
            this.f5550d = -1;
            this.f5553g = -1;
        }

        public long mo2980a(C1985g c1985g) {
            if (this.f5553g < 0) {
                return -1;
            }
            this.f5553g = (-this.f5553g) - 2;
            return this.f5553g;
        }

        public void m6090a(long j) {
            this.f5550d = j;
        }

        public void m6091a(C2263k c2263k) {
            c2263k.m7075d(1);
            int k = c2263k.m7083k() / 18;
            this.f5548b = new long[k];
            this.f5549c = new long[k];
            for (int i = 0; i < k; i++) {
                this.f5548b[i] = c2263k.m7088p();
                this.f5549c[i] = c2263k.m7088p();
                c2263k.m7075d(2);
            }
        }

        public boolean mo2943a() {
            return true;
        }

        public long mo2945b() {
            return this.f5547a.f5567a.m7038b();
        }

        public synchronized long mo2946b(long j) {
            int a;
            this.f5551e = this.f5547a.m6105c(j);
            a = C2273r.m7127a(this.f5548b, this.f5551e, true, true);
            this.f5552f = this.f5548b[a];
            return this.f5549c[a] + this.f5550d;
        }

        public synchronized long c_() {
            this.f5553g = this.f5552f;
            return this.f5551e;
        }

        public C1967m mo2982d() {
            return this;
        }
    }

    C2034b() {
    }

    public static boolean m6108a(C2263k c2263k) {
        return c2263k.m7070b() >= 5 && c2263k.m7079g() == TransportMediator.KEYCODE_MEDIA_PAUSE && c2263k.m7084l() == 1179402563;
    }

    private static boolean m6109a(byte[] bArr) {
        return bArr[0] == (byte) -1;
    }

    private int m6110c(C2263k c2263k) {
        int i = (c2263k.f6454a[2] & 255) >> 4;
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                c2263k.m7075d(4);
                c2263k.m7097y();
                i = i == 6 ? c2263k.m7079g() : c2263k.m7080h();
                c2263k.m7073c(0);
                return i + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    protected void mo2983a(boolean z) {
        super.mo2983a(z);
        if (z) {
            this.f5567a = null;
            this.f5568b = null;
        }
    }

    protected boolean mo2984a(C2263k c2263k, long j, C2041a c2041a) {
        byte[] bArr = c2263k.f6454a;
        if (this.f5567a == null) {
            this.f5567a = new C2256e(bArr, 17);
            Object copyOfRange = Arrays.copyOfRange(bArr, 9, c2263k.m7072c());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            c2041a.f5591a = Format.m5480a(null, "audio/x-flac", null, -1, this.f5567a.m7037a(), this.f5567a.f6428f, this.f5567a.f6427e, singletonList, null, 0, null);
        } else if ((bArr[0] & TransportMediator.KEYCODE_MEDIA_PAUSE) == 3) {
            this.f5568b = new C2032a();
            this.f5568b.m6091a(c2263k);
        } else if (C2034b.m6109a(bArr)) {
            if (this.f5568b == null) {
                return false;
            }
            this.f5568b.m6090a(j);
            c2041a.f5592b = this.f5568b;
            return false;
        }
        return true;
    }

    protected long mo2985b(C2263k c2263k) {
        return !C2034b.m6109a(c2263k.f6454a) ? -1 : (long) m6110c(c2263k);
    }
}
