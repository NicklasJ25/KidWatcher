package com.google.android.exoplayer2.p045c.p052g;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p045c.C1964i;
import com.google.android.exoplayer2.p045c.C1966f;
import com.google.android.exoplayer2.p045c.C1967m;
import com.google.android.exoplayer2.p045c.C1985g;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.C2093l;

public final class C2086a implements C1966f, C1967m {
    public static final C1964i f5856a = new C20851();
    private C2090h f5857b;
    private C2025o f5858c;
    private C2087b f5859d;
    private int f5860e;
    private int f5861f;

    static class C20851 implements C1964i {
        C20851() {
        }

        public C1966f[] mo2939a() {
            return new C1966f[]{new C2086a()};
        }
    }

    public int mo2940a(C1985g c1985g, C2093l c2093l) {
        if (this.f5859d == null) {
            this.f5859d = C2089c.m6341a(c1985g);
            if (this.f5859d == null) {
                throw new C1970k("Unsupported or unrecognized wav header.");
            }
            this.f5858c.mo2978a(Format.m5479a(null, "audio/raw", null, this.f5859d.m6335c(), 32768, this.f5859d.m6337e(), this.f5859d.m6336d(), this.f5859d.m6339g(), null, null, 0, null));
            this.f5860e = this.f5859d.m6333b();
        }
        if (!this.f5859d.m6338f()) {
            C2089c.m6342a(c1985g, this.f5859d);
            this.f5857b.mo3022a((C1967m) this);
        }
        int a = this.f5858c.mo2976a(c1985g, 32768 - this.f5861f, true);
        if (a != -1) {
            this.f5861f += a;
        }
        int i = this.f5861f / this.f5860e;
        if (i > 0) {
            long b = this.f5859d.m6334b(c1985g.mo2967c() - ((long) this.f5861f));
            int i2 = i * this.f5860e;
            this.f5861f -= i2;
            this.f5858c.mo2977a(b, 1, i2, this.f5861f, null);
        }
        return a == -1 ? -1 : 0;
    }

    public void mo2941a(long j) {
        this.f5861f = 0;
    }

    public void mo2942a(C2090h c2090h) {
        this.f5857b = c2090h;
        this.f5858c = c2090h.mo3019a(0);
        this.f5859d = null;
        c2090h.mo3020a();
    }

    public boolean mo2943a() {
        return true;
    }

    public boolean mo2944a(C1985g c1985g) {
        return C2089c.m6341a(c1985g) != null;
    }

    public long mo2945b() {
        return this.f5859d.m6330a();
    }

    public long mo2946b(long j) {
        return this.f5859d.m6331a(j);
    }

    public void mo2947c() {
    }
}
