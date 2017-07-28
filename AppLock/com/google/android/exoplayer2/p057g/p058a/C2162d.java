package com.google.android.exoplayer2.p057g.p058a;

import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.Collections;
import java.util.List;

final class C2162d implements C2159e {
    private final List<C2167b> f6053a;

    public C2162d(C2167b c2167b) {
        if (c2167b == null) {
            this.f6053a = Collections.emptyList();
        } else {
            this.f6053a = Collections.singletonList(c2167b);
        }
    }

    public int mo3051a(long j) {
        return 0;
    }

    public long mo3052a(int i) {
        return 0;
    }

    public int mo3053b() {
        return 1;
    }

    public List<C2167b> mo3054b(long j) {
        return this.f6053a;
    }
}
