package com.google.android.exoplayer2.p045c.p049d;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;

final class C2024l {
    public final int f5511a;
    public final long[] f5512b;
    public final int[] f5513c;
    public final int f5514d;
    public final long[] f5515e;
    public final int[] f5516f;

    public C2024l(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        C2252a.m7022a(iArr.length == jArr2.length);
        C2252a.m7022a(jArr.length == jArr2.length);
        if (iArr2.length != jArr2.length) {
            z = false;
        }
        C2252a.m7022a(z);
        this.f5512b = jArr;
        this.f5513c = iArr;
        this.f5514d = i;
        this.f5515e = jArr2;
        this.f5516f = iArr2;
        this.f5511a = jArr.length;
    }

    public int m6040a(long j) {
        for (int a = C2273r.m7127a(this.f5515e, j, true, false); a >= 0; a--) {
            if ((this.f5516f[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int m6041b(long j) {
        for (int b = C2273r.m7138b(this.f5515e, j, true, false); b < this.f5515e.length; b++) {
            if ((this.f5516f[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
