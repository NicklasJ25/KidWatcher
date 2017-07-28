package com.google.android.exoplayer2.p057g.p060c;

import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class C2174f implements C2159e {
    private final C2170b f6113a;
    private final long[] f6114b;
    private final Map<String, C2173e> f6115c;
    private final Map<String, C2171c> f6116d;

    public C2174f(C2170b c2170b, Map<String, C2173e> map, Map<String, C2171c> map2) {
        this.f6113a = c2170b;
        this.f6116d = map2;
        this.f6115c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f6114b = c2170b.m6680b();
    }

    public int mo3051a(long j) {
        int b = C2273r.m7138b(this.f6114b, j, false, false);
        return b < this.f6114b.length ? b : -1;
    }

    public long mo3052a(int i) {
        return this.f6114b[i];
    }

    public int mo3053b() {
        return this.f6114b.length;
    }

    public List<C2167b> mo3054b(long j) {
        return this.f6113a.m6677a(j, this.f6115c, this.f6116d);
    }
}
