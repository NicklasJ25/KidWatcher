package com.google.android.exoplayer2.p057g.p062e;

import android.text.TextUtils;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2164c;
import com.google.android.exoplayer2.p057g.C2191g;
import com.google.android.exoplayer2.p057g.p062e.C2184e.C2183a;
import java.util.ArrayList;
import java.util.List;

public final class C2188g extends C2164c {
    private final C2187f f6169a = new C2187f();
    private final C2263k f6170b = new C2263k();
    private final C2183a f6171c = new C2183a();
    private final C2178a f6172d = new C2178a();
    private final List<C2181d> f6173e = new ArrayList();

    public C2188g() {
        super("WebvttDecoder");
    }

    private static int m6796a(C2263k c2263k) {
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i2 = c2263k.m7074d();
            String x = c2263k.m7096x();
            i = x == null ? 0 : "STYLE".equals(x) ? 2 : "NOTE".startsWith(x) ? 1 : 3;
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        c2263k.m7073c(i);
        return i2;
    }

    private static void m6797b(C2263k c2263k) {
        do {
        } while (!TextUtils.isEmpty(c2263k.m7096x()));
    }

    protected /* synthetic */ C2159e mo3062a(byte[] bArr, int i) {
        return m6799b(bArr, i);
    }

    protected C2190i m6799b(byte[] bArr, int i) {
        this.f6170b.m7068a(bArr, i);
        this.f6171c.m6770a();
        this.f6173e.clear();
        C2189h.m6801a(this.f6170b);
        do {
        } while (!TextUtils.isEmpty(this.f6170b.m7096x()));
        List arrayList = new ArrayList();
        while (true) {
            int a = C2188g.m6796a(this.f6170b);
            if (a == 0) {
                return new C2190i(arrayList);
            }
            if (a == 1) {
                C2188g.m6797b(this.f6170b);
            } else if (a == 2) {
                if (arrayList.isEmpty()) {
                    this.f6170b.m7096x();
                    C2181d a2 = this.f6172d.m6732a(this.f6170b);
                    if (a2 != null) {
                        this.f6173e.add(a2);
                    }
                } else {
                    throw new C2191g("A style block was found after the first cue.");
                }
            } else if (a == 3 && this.f6169a.m6795a(this.f6170b, this.f6171c, this.f6173e)) {
                arrayList.add(this.f6171c.m6774b());
                this.f6171c.m6770a();
            }
        }
    }
}
