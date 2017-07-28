package com.google.android.exoplayer2.p057g.p059b;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.Collections;
import java.util.List;

final class C2166b implements C2159e {
    private final C2167b[] f6065a;
    private final long[] f6066b;

    public C2166b(C2167b[] c2167bArr, long[] jArr) {
        this.f6065a = c2167bArr;
        this.f6066b = jArr;
    }

    public int mo3051a(long j) {
        int b = C2273r.m7138b(this.f6066b, j, false, false);
        return b < this.f6066b.length ? b : -1;
    }

    public long mo3052a(int i) {
        boolean z = true;
        C2252a.m7022a(i >= 0);
        if (i >= this.f6066b.length) {
            z = false;
        }
        C2252a.m7022a(z);
        return this.f6066b[i];
    }

    public int mo3053b() {
        return this.f6066b.length;
    }

    public List<C2167b> mo3054b(long j) {
        int a = C2273r.m7127a(this.f6066b, j, true, false);
        return (a == -1 || this.f6065a[a] == null) ? Collections.emptyList() : Collections.singletonList(this.f6065a[a]);
    }
}
