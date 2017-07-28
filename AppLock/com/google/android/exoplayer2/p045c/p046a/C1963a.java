package com.google.android.exoplayer2.p045c.p046a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2253b;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.p046a.C1962d.C1971a;
import java.util.Collections;

final class C1963a extends C1962d {
    private static final int[] f5149b = new int[]{5500, 11000, 22000, 44000};
    private boolean f5150c;
    private boolean f5151d;

    public C1963a(C2025o c2025o) {
        super(c2025o);
    }

    protected void mo2937a(C2263k c2263k, long j) {
        int g = c2263k.m7079g();
        if (g == 0 && !this.f5151d) {
            Object obj = new byte[c2263k.m7070b()];
            c2263k.m7069a(obj, 0, obj.length);
            Pair a = C2253b.m7026a(obj);
            this.a.mo2978a(Format.m5480a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(obj), null, 0, null));
            this.f5151d = true;
        } else if (g == 1) {
            int b = c2263k.m7070b();
            this.a.mo2979a(c2263k, b);
            this.a.mo2977a(j, 1, b, 0, null);
        }
    }

    protected boolean mo2938a(C2263k c2263k) {
        if (this.f5150c) {
            c2263k.m7075d(1);
        } else {
            int g = c2263k.m7079g();
            int i = (g >> 4) & 15;
            g = (g >> 2) & 3;
            if (g < 0 || g >= f5149b.length) {
                throw new C1971a("Invalid sample rate index: " + g);
            } else if (i != 10) {
                throw new C1971a("Audio format not supported: " + i);
            } else {
                this.f5150c = true;
            }
        }
        return true;
    }
}
