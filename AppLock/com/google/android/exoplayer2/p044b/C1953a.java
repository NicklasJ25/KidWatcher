package com.google.android.exoplayer2.p044b;

public abstract class C1953a {
    private int f5109a;

    public void mo2931a() {
        this.f5109a = 0;
    }

    public final void m5692b(int i) {
        this.f5109a |= i;
    }

    public final void b_(int i) {
        this.f5109a = i;
    }

    public final void m5693c(int i) {
        this.f5109a &= i ^ -1;
    }

    public final boolean m5694c() {
        return m5695d(4);
    }

    protected final boolean m5695d(int i) {
        return (this.f5109a & i) == i;
    }

    public final boolean d_() {
        return m5695d(Integer.MIN_VALUE);
    }
}
