package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1985g;
import java.io.EOFException;

final class C2038e {
    private static final int f5576k = C2273r.m7142e("OggS");
    public int f5577a;
    public int f5578b;
    public long f5579c;
    public long f5580d;
    public long f5581e;
    public long f5582f;
    public int f5583g;
    public int f5584h;
    public int f5585i;
    public final int[] f5586j = new int[255];
    private final C2263k f5587l = new C2263k(255);

    C2038e() {
    }

    public void m6125a() {
        this.f5577a = 0;
        this.f5578b = 0;
        this.f5579c = 0;
        this.f5580d = 0;
        this.f5581e = 0;
        this.f5582f = 0;
        this.f5583g = 0;
        this.f5584h = 0;
        this.f5585i = 0;
    }

    public boolean m6126a(C1985g c1985g, boolean z) {
        int i = 0;
        this.f5587l.m7065a();
        m6125a();
        int i2 = (c1985g.mo2970d() == -1 || c1985g.mo2970d() - c1985g.mo2963b() >= 27) ? true : 0;
        if (i2 == 0 || !c1985g.mo2966b(this.f5587l.f6454a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.f5587l.m7084l() == ((long) f5576k)) {
            this.f5577a = this.f5587l.m7079g();
            if (this.f5577a == 0) {
                this.f5578b = this.f5587l.m7079g();
                this.f5579c = this.f5587l.m7089q();
                this.f5580d = this.f5587l.m7085m();
                this.f5581e = this.f5587l.m7085m();
                this.f5582f = this.f5587l.m7085m();
                this.f5583g = this.f5587l.m7079g();
                this.f5584h = this.f5583g + 27;
                this.f5587l.m7065a();
                c1985g.mo2969c(this.f5587l.f6454a, 0, this.f5583g);
                while (i < this.f5583g) {
                    this.f5586j[i] = this.f5587l.m7079g();
                    this.f5585i += this.f5586j[i];
                    i++;
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new C1970k("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new C1970k("expected OggS capture pattern at begin of page");
        }
    }
}
