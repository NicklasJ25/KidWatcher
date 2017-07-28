package com.google.android.exoplayer2.p057g.p062e;

import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2164c;
import com.google.android.exoplayer2.p057g.C2167b;
import com.google.android.exoplayer2.p057g.C2191g;
import com.google.android.exoplayer2.p057g.p062e.C2184e.C2183a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class C2179b extends C2164c {
    private static final int f6124a = C2273r.m7142e("payl");
    private static final int f6125b = C2273r.m7142e("sttg");
    private static final int f6126c = C2273r.m7142e("vttc");
    private final C2263k f6127d = new C2263k();
    private final C2183a f6128e = new C2183a();

    public C2179b() {
        super("Mp4WebvttDecoder");
    }

    private static C2167b m6733a(C2263k c2263k, C2183a c2183a, int i) {
        c2183a.m6770a();
        while (i > 0) {
            if (i < 8) {
                throw new C2191g("Incomplete vtt cue box header found.");
            }
            int n = c2263k.m7086n();
            int n2 = c2263k.m7086n();
            int i2 = i - 8;
            n -= 8;
            String str = new String(c2263k.f6454a, c2263k.m7074d(), n);
            c2263k.m7075d(n);
            i = i2 - n;
            if (n2 == f6125b) {
                C2187f.m6785a(str, c2183a);
            } else if (n2 == f6124a) {
                C2187f.m6787a(null, str.trim(), c2183a, Collections.emptyList());
            }
        }
        return c2183a.m6774b();
    }

    protected /* synthetic */ C2159e mo3062a(byte[] bArr, int i) {
        return m6735b(bArr, i);
    }

    protected C2180c m6735b(byte[] bArr, int i) {
        this.f6127d.m7068a(bArr, i);
        List arrayList = new ArrayList();
        while (this.f6127d.m7070b() > 0) {
            if (this.f6127d.m7070b() < 8) {
                throw new C2191g("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int n = this.f6127d.m7086n();
            if (this.f6127d.m7086n() == f6126c) {
                arrayList.add(C2179b.m6733a(this.f6127d, this.f6128e, n - 8));
            } else {
                this.f6127d.m7075d(n - 8);
            }
        }
        return new C2180c(arrayList);
    }
}
