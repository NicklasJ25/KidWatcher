package com.google.android.exoplayer2.p064k;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2253b;
import com.google.android.exoplayer2.p043j.C2261i;
import com.google.android.exoplayer2.p043j.C2261i.C2260b;
import com.google.android.exoplayer2.p043j.C2263k;
import java.util.ArrayList;
import java.util.List;

public final class C2275a {
    public final List<byte[]> f6487a;
    public final int f6488b;
    public final int f6489c;
    public final int f6490d;
    public final float f6491e;

    private C2275a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f6487a = list;
        this.f6488b = i;
        this.f6489c = i2;
        this.f6490d = i3;
        this.f6491e = f;
    }

    public static C2275a m7150a(C2263k c2263k) {
        int i = -1;
        int i2 = 0;
        try {
            c2263k.m7075d(4);
            int g = (c2263k.m7079g() & 3) + 1;
            if (g == 3) {
                throw new IllegalStateException();
            }
            int i3;
            List arrayList = new ArrayList();
            int g2 = c2263k.m7079g() & 31;
            for (i3 = 0; i3 < g2; i3++) {
                arrayList.add(C2275a.m7151b(c2263k));
            }
            i3 = c2263k.m7079g();
            while (i2 < i3) {
                arrayList.add(C2275a.m7151b(c2263k));
                i2++;
            }
            float f = 1.0f;
            if (g2 > 0) {
                C2260b a = C2261i.m7050a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                i3 = a.f6437b;
                i = a.f6438c;
                f = a.f6439d;
            } else {
                i3 = -1;
            }
            return new C2275a(arrayList, g, i3, i, f);
        } catch (Throwable e) {
            throw new C1970k("Error parsing AVC config", e);
        }
    }

    private static byte[] m7151b(C2263k c2263k) {
        int h = c2263k.m7080h();
        int d = c2263k.m7074d();
        c2263k.m7075d(h);
        return C2253b.m7028a(c2263k.f6454a, d, h);
    }
}
