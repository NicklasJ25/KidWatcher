package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p055f.C2153i;
import com.google.android.exoplayer2.p056i.C2220b;
import com.google.android.exoplayer2.p056i.C2231i;
import com.google.android.exoplayer2.p063h.C2214g;

public final class C2097c implements C2096j {
    private final C2231i f5894a;
    private final long f5895b;
    private final long f5896c;
    private final long f5897d;
    private final long f5898e;
    private int f5899f;
    private boolean f5900g;

    public C2097c() {
        this(new C2231i(true, 65536));
    }

    public C2097c(C2231i c2231i) {
        this(c2231i, 15000, 30000, 2500, 5000);
    }

    public C2097c(C2231i c2231i, int i, int i2, long j, long j2) {
        this.f5894a = c2231i;
        this.f5895b = ((long) i) * 1000;
        this.f5896c = ((long) i2) * 1000;
        this.f5897d = j * 1000;
        this.f5898e = j2 * 1000;
    }

    private void m6367a(boolean z) {
        this.f5899f = 0;
        this.f5900g = false;
        if (z) {
            this.f5894a.m6967d();
        }
    }

    private int m6368b(long j) {
        return j > this.f5896c ? 0 : j < this.f5895b ? 2 : 1;
    }

    public void mo2995a() {
        m6367a(false);
    }

    public void mo2996a(C1947m[] c1947mArr, C2153i c2153i, C2214g<?> c2214g) {
        int i = 0;
        this.f5899f = 0;
        while (i < c1947mArr.length) {
            if (c2214g.m6898a(i) != null) {
                this.f5899f += C2273r.m7137b(c1947mArr[i].mo2894a());
            }
            i++;
        }
        this.f5894a.m6962a(this.f5899f);
    }

    public boolean mo2997a(long j) {
        boolean z = false;
        int b = m6368b(j);
        boolean z2 = this.f5894a.m6968e() >= this.f5899f;
        if (b == 2 || (b == 1 && this.f5900g && !z2)) {
            z = true;
        }
        this.f5900g = z;
        return this.f5900g;
    }

    public boolean mo2998a(long j, boolean z) {
        long j2 = z ? this.f5898e : this.f5897d;
        return j2 <= 0 || j >= j2;
    }

    public void mo2999b() {
        m6367a(true);
    }

    public void mo3000c() {
        m6367a(true);
    }

    public C2220b mo3001d() {
        return this.f5894a;
    }
}
