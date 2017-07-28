package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p057g.p058a.C2158a;

final class C2078o {
    private final C2025o f5815a;

    public C2078o(C2025o c2025o) {
        this.f5815a = c2025o;
        c2025o.mo2978a(Format.m5481a(null, "application/cea-608", null, -1, 0, null, null));
    }

    public void m6288a(long j, C2263k c2263k) {
        while (c2263k.m7070b() > 1) {
            int g;
            int i = 0;
            do {
                g = c2263k.m7079g();
                i += g;
            } while (g == 255);
            g = 0;
            while (true) {
                int g2 = c2263k.m7079g();
                int i2 = g + g2;
                if (g2 != 255) {
                    break;
                }
                g = i2;
            }
            if (C2158a.m6599a(i, i2, c2263k)) {
                c2263k.m7075d(8);
                int g3 = c2263k.m7079g() & 31;
                c2263k.m7075d(1);
                int i3 = 0;
                for (i = 0; i < g3; i++) {
                    if ((c2263k.m7078f() & 7) != 4) {
                        c2263k.m7075d(3);
                    } else {
                        i3 += 3;
                        this.f5815a.mo2979a(c2263k, 3);
                    }
                }
                this.f5815a.mo2977a(j, 1, i3, 0, null);
                c2263k.m7075d(i2 - ((g3 * 3) + 10));
            } else {
                c2263k.m7075d(i2);
            }
        }
    }
}
