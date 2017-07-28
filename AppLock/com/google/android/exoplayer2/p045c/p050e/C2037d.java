package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1985g;

final class C2037d {
    private final C2038e f5571a = new C2038e();
    private final C2263k f5572b = new C2263k(new byte[65025], 0);
    private int f5573c = -1;
    private int f5574d;
    private boolean f5575e;

    C2037d() {
    }

    private int m6121a(int i) {
        int i2 = 0;
        this.f5574d = 0;
        while (this.f5574d + i < this.f5571a.f5583g) {
            int[] iArr = this.f5571a.f5586j;
            int i3 = this.f5574d;
            this.f5574d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }

    public void m6122a() {
        this.f5571a.m6125a();
        this.f5572b.m7065a();
        this.f5573c = -1;
        this.f5575e = false;
    }

    public boolean m6123a(C1985g c1985g) {
        C2252a.m7024b(c1985g != null);
        if (this.f5575e) {
            this.f5575e = false;
            this.f5572b.m7065a();
        }
        while (!this.f5575e) {
            int i;
            int i2;
            if (this.f5573c < 0) {
                if (!this.f5571a.m6126a(c1985g, true)) {
                    return false;
                }
                i = this.f5571a.f5584h;
                if ((this.f5571a.f5578b & 1) == 1 && this.f5572b.m7072c() == 0) {
                    i += m6121a(0);
                    i2 = this.f5574d + 0;
                } else {
                    i2 = 0;
                }
                c1985g.mo2964b(i);
                this.f5573c = i2;
            }
            i = m6121a(this.f5573c);
            i2 = this.f5573c + this.f5574d;
            if (i > 0) {
                c1985g.mo2965b(this.f5572b.f6454a, this.f5572b.m7072c(), i);
                this.f5572b.m7071b(i + this.f5572b.m7072c());
                this.f5575e = this.f5571a.f5586j[i2 + -1] != 255;
            }
            this.f5573c = i2 == this.f5571a.f5583g ? -1 : i2;
        }
        return true;
    }

    public C2263k m6124b() {
        return this.f5572b;
    }
}
