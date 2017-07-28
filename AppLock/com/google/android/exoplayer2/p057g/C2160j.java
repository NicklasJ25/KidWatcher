package com.google.android.exoplayer2.p057g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p044b.C1958f;
import java.util.List;

public abstract class C2160j extends C1958f implements C2159e {
    private C2159e f6050c;
    private long f6051d;

    public int mo3051a(long j) {
        return this.f6050c.mo3051a(j - this.f6051d);
    }

    public long mo3052a(int i) {
        return this.f6050c.mo3052a(i) + this.f6051d;
    }

    public void mo2931a() {
        super.mo2931a();
        this.f6050c = null;
    }

    public void m6626a(long j, C2159e c2159e, long j2) {
        this.a = j;
        this.f6050c = c2159e;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.a;
        }
        this.f6051d = j2;
    }

    public int mo3053b() {
        return this.f6050c.mo3053b();
    }

    public List<C2167b> mo3054b(long j) {
        return this.f6050c.mo3054b(j - this.f6051d);
    }

    public abstract void mo3055d();
}
