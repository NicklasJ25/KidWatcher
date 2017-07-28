package com.google.android.exoplayer2.p064k;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2263k;
import java.util.Collections;
import java.util.List;

public final class C2276b {
    public final List<byte[]> f6492a;
    public final int f6493b;

    private C2276b(List<byte[]> list, int i) {
        this.f6492a = list;
        this.f6493b = i;
    }

    public static C2276b m7152a(C2263k c2263k) {
        try {
            int h;
            int i;
            int i2;
            c2263k.m7075d(21);
            int g = c2263k.m7079g() & 3;
            int g2 = c2263k.m7079g();
            int d = c2263k.m7074d();
            int i3 = 0;
            int i4 = 0;
            while (i3 < g2) {
                c2263k.m7075d(1);
                h = c2263k.m7080h();
                i = i4;
                for (i2 = 0; i2 < h; i2++) {
                    i4 = c2263k.m7080h();
                    i += i4 + 4;
                    c2263k.m7075d(i4);
                }
                i3++;
                i4 = i;
            }
            c2263k.m7073c(d);
            Object obj = new byte[i4];
            i3 = 0;
            i2 = 0;
            while (i3 < g2) {
                c2263k.m7075d(1);
                h = c2263k.m7080h();
                i = i2;
                for (i2 = 0; i2 < h; i2++) {
                    int h2 = c2263k.m7080h();
                    System.arraycopy(C2261i.f6446a, 0, obj, i, C2261i.f6446a.length);
                    i += C2261i.f6446a.length;
                    System.arraycopy(c2263k.f6454a, c2263k.m7074d(), obj, i, h2);
                    i += h2;
                    c2263k.m7075d(h2);
                }
                i3++;
                i2 = i;
            }
            return new C2276b(i4 == 0 ? null : Collections.singletonList(obj), g + 1);
        } catch (Throwable e) {
            throw new C1970k("Error parsing HEVC config", e);
        }
    }
}
