package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C2025o;
import com.google.android.exoplayer2.p045c.C2090h;
import com.google.android.exoplayer2.p045c.p051f.C2054g.C2063c;

final class C2072k extends C2054g {
    private final C2263k f5777a = new C2263k(10);
    private C2025o f5778b;
    private boolean f5779c;
    private long f5780d;
    private int f5781e;
    private int f5782f;

    public void mo2987a() {
        this.f5779c = false;
    }

    public void mo2988a(long j, boolean z) {
        if (z) {
            this.f5779c = true;
            this.f5780d = j;
            this.f5781e = 0;
            this.f5782f = 0;
        }
    }

    public void mo2989a(C2090h c2090h, C2063c c2063c) {
        this.f5778b = c2090h.mo3019a(c2063c.m6212a());
        this.f5778b.mo2978a(Format.m5483a(null, "application/id3", null, -1, null));
    }

    public void mo2990a(C2263k c2263k) {
        if (this.f5779c) {
            int b = c2263k.m7070b();
            if (this.f5782f < 10) {
                int min = Math.min(b, 10 - this.f5782f);
                System.arraycopy(c2263k.f6454a, c2263k.m7074d(), this.f5777a.f6454a, this.f5782f, min);
                if (min + this.f5782f == 10) {
                    this.f5777a.m7073c(6);
                    this.f5781e = this.f5777a.m7091s() + 10;
                }
            }
            b = Math.min(b, this.f5781e - this.f5782f);
            this.f5778b.mo2979a(c2263k, b);
            this.f5782f = b + this.f5782f;
        }
    }

    public void mo2991b() {
        if (this.f5779c && this.f5781e != 0 && this.f5782f == this.f5781e) {
            this.f5778b.mo2977a(this.f5780d, 1, this.f5781e, 0, null);
            this.f5779c = false;
        }
    }
}
