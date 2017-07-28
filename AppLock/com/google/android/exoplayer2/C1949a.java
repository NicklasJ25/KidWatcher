package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p043j.C1951g;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p044b.C1957e;
import com.google.android.exoplayer2.p055f.C2137e;

public abstract class C1949a implements C1947m, C1948n {
    private final int f5056a;
    private int f5057b;
    private int f5058c;
    private C2137e f5059d;
    private long f5060e;
    private boolean f5061f = true;
    private boolean f5062g;

    public C1949a(int i) {
        this.f5056a = i;
    }

    public final int mo2894a() {
        return this.f5056a;
    }

    protected final int m5601a(C2251i c2251i, C1957e c1957e) {
        int a = this.f5059d.mo3013a(c2251i, c1957e);
        if (a == -4) {
            if (c1957e.m5694c()) {
                this.f5061f = true;
                return this.f5062g ? -4 : -3;
            } else {
                c1957e.f5126c += this.f5060e;
            }
        }
        return a;
    }

    public final void mo2895a(int i) {
        this.f5057b = i;
    }

    public void mo2896a(int i, Object obj) {
    }

    public final void mo2897a(long j) {
        this.f5062g = false;
        mo2913a(j, false);
    }

    protected void mo2913a(long j, boolean z) {
    }

    protected void mo2914a(boolean z) {
    }

    protected void mo3065a(Format[] formatArr) {
    }

    public final void mo2898a(Format[] formatArr, C2137e c2137e, long j) {
        C2252a.m7024b(!this.f5062g);
        this.f5059d = c2137e;
        this.f5061f = false;
        this.f5060e = j;
        mo3065a(formatArr);
    }

    public final void mo2899a(Format[] formatArr, C2137e c2137e, long j, boolean z, long j2) {
        C2252a.m7024b(this.f5058c == 0);
        this.f5058c = 1;
        mo2914a(z);
        mo2898a(formatArr, c2137e, j2);
        mo2913a(j, z);
    }

    public final C1948n mo2900b() {
        return this;
    }

    protected void m5611b(long j) {
        this.f5059d.mo3014a(j);
    }

    public C1951g mo2901c() {
        return null;
    }

    public final int mo2902d() {
        return this.f5058c;
    }

    public final void mo2903e() {
        boolean z = true;
        if (this.f5058c != 1) {
            z = false;
        }
        C2252a.m7024b(z);
        this.f5058c = 2;
        mo2915m();
    }

    public final C2137e mo2904f() {
        return this.f5059d;
    }

    public final boolean mo2905g() {
        return this.f5061f;
    }

    public final void mo2906h() {
        this.f5062g = true;
    }

    public final void mo2907i() {
        this.f5059d.mo3016b();
    }

    public final void mo2908j() {
        C2252a.m7024b(this.f5058c == 2);
        this.f5058c = 1;
        mo2916n();
    }

    public final void mo2909k() {
        boolean z = true;
        if (this.f5058c != 1) {
            z = false;
        }
        C2252a.m7024b(z);
        this.f5058c = 0;
        mo2917o();
        this.f5059d = null;
        this.f5062g = false;
    }

    public int mo2910l() {
        return 0;
    }

    protected void mo2915m() {
    }

    protected void mo2916n() {
    }

    protected void mo2917o() {
    }

    protected final int m5625p() {
        return this.f5057b;
    }

    protected final boolean m5626q() {
        return this.f5061f ? this.f5062g : this.f5059d.mo3015a();
    }
}
