package com.google.android.exoplayer2.p045c.p051f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;
import java.util.Arrays;
import java.util.Collections;

final class C2065h extends C2054g {
    private static final double[] f5691b = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private C2025o f5692a;
    private boolean f5693c;
    private long f5694d;
    private final boolean[] f5695e = new boolean[4];
    private final C2064a f5696f = new C2064a(128);
    private boolean f5697g;
    private long f5698h;
    private long f5699i;
    private boolean f5700j;
    private boolean f5701k;
    private long f5702l;
    private long f5703m;

    private static final class C2064a {
        public int f5687a;
        public int f5688b;
        public byte[] f5689c;
        private boolean f5690d;

        public C2064a(int i) {
            this.f5689c = new byte[i];
        }

        public void m6213a() {
            this.f5690d = false;
            this.f5687a = 0;
            this.f5688b = 0;
        }

        public void m6214a(byte[] bArr, int i, int i2) {
            if (this.f5690d) {
                int i3 = i2 - i;
                if (this.f5689c.length < this.f5687a + i3) {
                    this.f5689c = Arrays.copyOf(this.f5689c, (this.f5687a + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f5689c, this.f5687a, i3);
                this.f5687a = i3 + this.f5687a;
            }
        }

        public boolean m6215a(int i, int i2) {
            if (this.f5690d) {
                if (this.f5688b == 0 && i == 181) {
                    this.f5688b = this.f5687a;
                } else {
                    this.f5687a -= i2;
                    this.f5690d = false;
                    return true;
                }
            } else if (i == 179) {
                this.f5690d = true;
            }
            return false;
        }
    }

    private static Pair<Format, Long> m6216a(C2064a c2064a) {
        Object copyOf = Arrays.copyOf(c2064a.f5689c, c2064a.f5687a);
        int i = copyOf[5] & 255;
        int i2 = i >> 4;
        i2 |= (copyOf[4] & 255) << 4;
        int i3 = ((i & 15) << 8) | (copyOf[6] & 255);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = ((float) (i3 * 4)) / ((float) (i2 * 3));
                break;
            case 3:
                f = ((float) (i3 * 16)) / ((float) (i2 * 9));
                break;
            case 4:
                f = ((float) (i3 * 121)) / ((float) (i2 * 100));
                break;
        }
        Format a = Format.m5476a(null, "video/mpeg2", null, -1, -1, i2, i3, -1.0f, Collections.singletonList(copyOf), -1, f, null);
        long j = 0;
        int i4 = (copyOf[7] & 15) - 1;
        if (i4 >= 0 && i4 < f5691b.length) {
            double d = f5691b[i4];
            i4 = c2064a.f5688b;
            int i5 = (copyOf[i4 + 9] & 96) >> 5;
            i4 = copyOf[i4 + 9] & 31;
            if (i5 != i4) {
                d *= (((double) i5) + 1.0d) / ((double) (i4 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a, Long.valueOf(j));
    }

    public void mo2987a() {
        C2261i.m7053a(this.f5695e);
        this.f5696f.m6213a();
        this.f5700j = false;
        this.f5697g = false;
        this.f5698h = 0;
    }

    public void mo2988a(long j, boolean z) {
        this.f5700j = j != -9223372036854775807L;
        if (this.f5700j) {
            this.f5699i = j;
        }
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5692a = c2090h.mo3019a(c2063c.m6212a());
    }

    public void mo2990a(C2263k c2263k) {
        int d = c2263k.m7074d();
        int c = c2263k.m7072c();
        byte[] bArr = c2263k.f6454a;
        this.f5698h += (long) c2263k.m7070b();
        this.f5692a.mo2979a(c2263k, c2263k.m7070b());
        int i = d;
        while (true) {
            int a = C2261i.m7049a(bArr, d, c, this.f5695e);
            if (a == c) {
                break;
            }
            int i2 = c2263k.f6454a[a + 3] & 255;
            if (!this.f5693c) {
                d = a - i;
                if (d > 0) {
                    this.f5696f.m6214a(bArr, i, a);
                }
                if (this.f5696f.m6215a(i2, d < 0 ? -d : 0)) {
                    Pair a2 = C2065h.m6216a(this.f5696f);
                    this.f5692a.mo2978a((Format) a2.first);
                    this.f5694d = ((Long) a2.second).longValue();
                    this.f5693c = true;
                }
            }
            if (this.f5693c && (i2 == 184 || i2 == 0)) {
                int i3 = c - a;
                if (this.f5697g) {
                    this.f5692a.mo2977a(this.f5703m, this.f5701k ? 1 : 0, ((int) (this.f5698h - this.f5702l)) - i3, i3, null);
                    this.f5701k = false;
                }
                if (i2 == 184) {
                    this.f5697g = false;
                    this.f5701k = true;
                } else {
                    this.f5703m = this.f5700j ? this.f5699i : this.f5703m + this.f5694d;
                    this.f5702l = this.f5698h - ((long) i3);
                    this.f5700j = false;
                    this.f5697g = true;
                }
            }
            d = a + 3;
            i = a;
        }
        if (!this.f5693c) {
            this.f5696f.m6214a(bArr, i, c);
        }
    }

    public void mo2991b() {
    }
}
