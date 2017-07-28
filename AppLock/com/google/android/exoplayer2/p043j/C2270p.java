package com.google.android.exoplayer2.p043j;

import android.os.SystemClock;

public final class C2270p implements C1951g {
    private boolean f6474a;
    private long f6475b;
    private long f6476c;

    private long m7115b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }

    public void m7116a() {
        if (!this.f6474a) {
            this.f6474a = true;
            this.f6476c = m7115b(this.f6475b);
        }
    }

    public void m7117a(long j) {
        this.f6475b = j;
        this.f6476c = m7115b(j);
    }

    public void m7118b() {
        if (this.f6474a) {
            this.f6475b = m7115b(this.f6476c);
            this.f6474a = false;
        }
    }

    public long mo2928t() {
        return this.f6474a ? m7115b(this.f6476c) : this.f6475b;
    }
}
