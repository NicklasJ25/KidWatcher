package com.google.android.exoplayer2.p045c;

import com.google.android.exoplayer2.Format;

public final class C2095n {
    private final long f5891a;
    private long f5892b;
    private volatile long f5893c = -9223372036854775807L;

    public C2095n(long j) {
        this.f5891a = j;
    }

    public static long m6355c(long j) {
        return (1000000 * j) / 90000;
    }

    public static long m6356d(long j) {
        return (90000 * j) / 1000000;
    }

    public long m6357a(long j) {
        long j2;
        if (this.f5893c != -9223372036854775807L) {
            long d = C2095n.m6356d(this.f5893c);
            long j3 = (4294967296L + d) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - d) >= Math.abs(j3 - d)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        return m6359b(C2095n.m6355c(j2));
    }

    public void m6358a() {
        this.f5893c = -9223372036854775807L;
    }

    public long m6359b(long j) {
        if (this.f5893c != -9223372036854775807L) {
            this.f5893c = j;
        } else {
            if (this.f5891a != Format.OFFSET_SAMPLE_RELATIVE) {
                this.f5892b = this.f5891a - j;
            }
            synchronized (this) {
                this.f5893c = j;
                notifyAll();
            }
        }
        return this.f5892b + j;
    }
}
