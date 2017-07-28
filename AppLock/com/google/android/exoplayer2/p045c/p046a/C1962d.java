package com.google.android.exoplayer2.p045c.p046a;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;

abstract class C1962d {
    protected final C2025o f5148a;

    public static final class C1971a extends C1970k {
        public C1971a(String str) {
            super(str);
        }
    }

    protected C1962d(C2025o c2025o) {
        this.f5148a = c2025o;
    }

    protected abstract void mo2937a(C2263k c2263k, long j);

    protected abstract boolean mo2938a(C2263k c2263k);

    public final void m5736b(C2263k c2263k, long j) {
        if (mo2938a(c2263k)) {
            mo2937a(c2263k, j);
        }
    }
}
