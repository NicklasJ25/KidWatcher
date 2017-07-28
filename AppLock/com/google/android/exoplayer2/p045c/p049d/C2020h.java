package com.google.android.exoplayer2.p045c.p049d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1985g;

final class C2020h {
    private static final int[] f5477a = new int[]{C2273r.m7142e("isom"), C2273r.m7142e("iso2"), C2273r.m7142e("iso3"), C2273r.m7142e("iso4"), C2273r.m7142e("iso5"), C2273r.m7142e("iso6"), C2273r.m7142e("avc1"), C2273r.m7142e("hvc1"), C2273r.m7142e("hev1"), C2273r.m7142e("mp41"), C2273r.m7142e("mp42"), C2273r.m7142e("3g2a"), C2273r.m7142e("3g2b"), C2273r.m7142e("3gr6"), C2273r.m7142e("3gs6"), C2273r.m7142e("3ge6"), C2273r.m7142e("3gg6"), C2273r.m7142e("M4V "), C2273r.m7142e("M4A "), C2273r.m7142e("f4v "), C2273r.m7142e("kddi"), C2273r.m7142e("M4VP"), C2273r.m7142e("qt  "), C2273r.m7142e("MSNV")};

    private static boolean m6030a(int i) {
        if ((i >>> 8) == C2273r.m7142e("3gp")) {
            return true;
        }
        for (int i2 : f5477a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean m6031a(C1985g c1985g) {
        return C2020h.m6032a(c1985g, true);
    }

    private static boolean m6032a(C1985g c1985g, boolean z) {
        long d = c1985g.mo2970d();
        if (d == -1 || d > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            d = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        int i = (int) d;
        C2263k c2263k = new C2263k(64);
        Object obj = null;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            c2263k.m7066a(8);
            c1985g.mo2969c(c2263k.f6454a, 0, 8);
            long l = c2263k.m7084l();
            int n = c2263k.m7086n();
            if (l == 1) {
                i3 = 16;
                c1985g.mo2969c(c2263k.f6454a, 8, 8);
                c2263k.m7071b(16);
                l = c2263k.m7094v();
            }
            if (l >= ((long) i3)) {
                i2 += i3;
                if (n != C1999a.f5331A) {
                    if (n != C1999a.f5340J && n != C1999a.f5342L) {
                        if ((((long) i2) + l) - ((long) i3) >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (l - ((long) i3));
                        int i5 = i2 + i4;
                        if (n == C1999a.f5357a) {
                            if (i4 < 8) {
                                return false;
                            }
                            c2263k.m7066a(i4);
                            c1985g.mo2969c(c2263k.f6454a, 0, i4);
                            i3 = i4 / 4;
                            for (i4 = 0; i4 < i3; i4++) {
                                if (i4 == 1) {
                                    c2263k.m7075d(4);
                                } else if (C2020h.m6030a(c2263k.m7086n())) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            c1985g.mo2968c(i4);
                        }
                        i2 = i5;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        return obj != null && z == z2;
    }

    public static boolean m6033b(C1985g c1985g) {
        return C2020h.m6032a(c1985g, false);
    }
}
