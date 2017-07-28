package com.google.android.exoplayer2.p045c.p048c;

import com.google.android.exoplayer2.p045c.p048c.C1991c.C1987a;

final class C1988a implements C1987a {
    private final long f5280a;
    private final int f5281b;
    private final long f5282c;

    public C1988a(long j, int i, long j2) {
        this.f5280a = j;
        this.f5281b = i;
        this.f5282c = j2 == -1 ? -9223372036854775807L : mo2971a(j2);
    }

    public long mo2971a(long j) {
        return ((Math.max(0, j - this.f5280a) * 1000000) * 8) / ((long) this.f5281b);
    }

    public boolean mo2943a() {
        return this.f5282c != -9223372036854775807L;
    }

    public long mo2945b() {
        return this.f5282c;
    }

    public long mo2946b(long j) {
        return this.f5282c == -9223372036854775807L ? 0 : this.f5280a + ((((long) this.f5281b) * j) / 8000000);
    }
}
