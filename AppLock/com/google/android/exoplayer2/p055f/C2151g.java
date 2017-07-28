package com.google.android.exoplayer2.p055f;

import com.google.android.exoplayer2.C2150p;
import com.google.android.exoplayer2.C2150p.C2299a;
import com.google.android.exoplayer2.C2150p.C2300b;
import com.google.android.exoplayer2.p043j.C2252a;

public final class C2151g extends C2150p {
    private static final Object f6018a = new Object();
    private final long f6019b;
    private final long f6020c;
    private final long f6021d;
    private final long f6022e;
    private final boolean f6023f;
    private final boolean f6024g;

    public C2151g(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f6019b = j;
        this.f6020c = j2;
        this.f6021d = j3;
        this.f6022e = j4;
        this.f6023f = z;
        this.f6024g = z2;
    }

    public C2151g(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public int mo3039a() {
        return 1;
    }

    public int mo3040a(Object obj) {
        return f6018a.equals(obj) ? 0 : -1;
    }

    public C2299a mo3041a(int i, C2299a c2299a, boolean z) {
        C2252a.m7019a(i, 0, 1);
        Object obj = z ? f6018a : null;
        return c2299a.m7271a(obj, obj, 0, this.f6019b, -this.f6021d);
    }

    public C2300b mo3042a(int i, C2300b c2300b, boolean z) {
        C2252a.m7019a(i, 0, 1);
        return c2300b.m7275a(z ? f6018a : null, -9223372036854775807L, -9223372036854775807L, this.f6023f, this.f6024g, this.f6022e, this.f6020c, 0, 0, this.f6021d);
    }

    public int mo3043b() {
        return 1;
    }
}
