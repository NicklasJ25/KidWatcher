package com.google.android.exoplayer2.p045c.p051f;

import com.google.android.exoplayer2.p043j.C2252a;
import java.util.Arrays;

final class C2074m {
    public byte[] f5794a;
    public int f5795b;
    private final int f5796c;
    private boolean f5797d;
    private boolean f5798e;

    public C2074m(int i, int i2) {
        this.f5796c = i;
        this.f5794a = new byte[(i2 + 3)];
        this.f5794a[2] = (byte) 1;
    }

    public void m6273a() {
        this.f5797d = false;
        this.f5798e = false;
    }

    public void m6274a(int i) {
        boolean z = true;
        C2252a.m7024b(!this.f5797d);
        if (i != this.f5796c) {
            z = false;
        }
        this.f5797d = z;
        if (this.f5797d) {
            this.f5795b = 3;
            this.f5798e = false;
        }
    }

    public void m6275a(byte[] bArr, int i, int i2) {
        if (this.f5797d) {
            int i3 = i2 - i;
            if (this.f5794a.length < this.f5795b + i3) {
                this.f5794a = Arrays.copyOf(this.f5794a, (this.f5795b + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f5794a, this.f5795b, i3);
            this.f5795b = i3 + this.f5795b;
        }
    }

    public boolean m6276b() {
        return this.f5798e;
    }

    public boolean m6277b(int i) {
        if (!this.f5797d) {
            return false;
        }
        this.f5795b -= i;
        this.f5797d = false;
        this.f5798e = true;
        return true;
    }
}
