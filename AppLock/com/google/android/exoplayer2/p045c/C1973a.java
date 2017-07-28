package com.google.android.exoplayer2.p045c;

import com.google.android.exoplayer2.p043j.C2273r;

public final class C1973a implements C1967m {
    public final int f5173a;
    public final int[] f5174b;
    public final long[] f5175c;
    public final long[] f5176d;
    public final long[] f5177e;
    private final long f5178f;

    public C1973a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f5174b = iArr;
        this.f5175c = jArr;
        this.f5176d = jArr2;
        this.f5177e = jArr3;
        this.f5173a = iArr.length;
        this.f5178f = jArr2[this.f5173a - 1] + jArr3[this.f5173a - 1];
    }

    public int m5776a(long j) {
        return C2273r.m7127a(this.f5177e, j, true, true);
    }

    public boolean mo2943a() {
        return true;
    }

    public long mo2945b() {
        return this.f5178f;
    }

    public long mo2946b(long j) {
        return this.f5175c[m5776a(j)];
    }
}
