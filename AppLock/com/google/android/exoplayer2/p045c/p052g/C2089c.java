package com.google.android.exoplayer2.p045c.p052g;

import android.util.Log;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1985g;

final class C2089c {

    private static final class C2088a {
        public final int f5870a;
        public final long f5871b;

        private C2088a(int i, long j) {
            this.f5870a = i;
            this.f5871b = j;
        }

        public static C2088a m6340a(C1985g c1985g, C2263k c2263k) {
            c1985g.mo2969c(c2263k.f6454a, 0, 8);
            c2263k.m7073c(0);
            return new C2088a(c2263k.m7086n(), c2263k.m7085m());
        }
    }

    public static C2087b m6341a(C1985g c1985g) {
        C2252a.m7020a((Object) c1985g);
        C2263k c2263k = new C2263k(16);
        if (C2088a.m6340a(c1985g, c2263k).f5870a != C2273r.m7142e("RIFF")) {
            return null;
        }
        c1985g.mo2969c(c2263k.f6454a, 0, 4);
        c2263k.m7073c(0);
        int n = c2263k.m7086n();
        if (n != C2273r.m7142e("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + n);
            return null;
        }
        C2088a a = C2088a.m6340a(c1985g, c2263k);
        while (a.f5870a != C2273r.m7142e("fmt ")) {
            c1985g.mo2968c((int) a.f5871b);
            a = C2088a.m6340a(c1985g, c2263k);
        }
        C2252a.m7024b(a.f5871b >= 16);
        c1985g.mo2969c(c2263k.f6454a, 0, 16);
        c2263k.m7073c(0);
        int i = c2263k.m7081i();
        int i2 = c2263k.m7081i();
        int u = c2263k.m7093u();
        int u2 = c2263k.m7093u();
        int i3 = c2263k.m7081i();
        int i4 = c2263k.m7081i();
        int i5 = (i2 * i4) / 8;
        if (i3 != i5) {
            throw new C1970k("Expected block alignment: " + i5 + "; got: " + i3);
        }
        i5 = C2273r.m7124a(i4);
        if (i5 == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + i4);
            return null;
        } else if (i == 1 || i == 65534) {
            c1985g.mo2968c(((int) a.f5871b) - 16);
            return new C2087b(i2, u, u2, i3, i4, i5);
        } else {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + i);
            return null;
        }
    }

    public static void m6342a(C1985g c1985g, C2087b c2087b) {
        C2252a.m7020a((Object) c1985g);
        C2252a.m7020a((Object) c2087b);
        c1985g.mo2961a();
        C2263k c2263k = new C2263k(8);
        C2088a a = C2088a.m6340a(c1985g, c2263k);
        while (a.f5870a != C2273r.m7142e("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a.f5870a);
            long j = 8 + a.f5871b;
            if (a.f5870a == C2273r.m7142e("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new C1970k("Chunk is too large (~2GB+) to skip; id: " + a.f5870a);
            }
            c1985g.mo2964b((int) j);
            a = C2088a.m6340a(c1985g, c2263k);
        }
        c1985g.mo2964b(8);
        c2087b.m6332a(c1985g.mo2967c(), a.f5871b);
    }
}
