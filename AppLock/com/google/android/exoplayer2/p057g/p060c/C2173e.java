package com.google.android.exoplayer2.p057g.p060c;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p043j.C2252a;

final class C2173e {
    private String f6099a;
    private int f6100b;
    private boolean f6101c;
    private int f6102d;
    private boolean f6103e;
    private int f6104f = -1;
    private int f6105g = -1;
    private int f6106h = -1;
    private int f6107i = -1;
    private int f6108j = -1;
    private float f6109k;
    private String f6110l;
    private C2173e f6111m;
    private Alignment f6112n;

    private C2173e m6685a(C2173e c2173e, boolean z) {
        if (c2173e != null) {
            if (!this.f6101c && c2173e.f6101c) {
                m6688a(c2173e.f6100b);
            }
            if (this.f6106h == -1) {
                this.f6106h = c2173e.f6106h;
            }
            if (this.f6107i == -1) {
                this.f6107i = c2173e.f6107i;
            }
            if (this.f6099a == null) {
                this.f6099a = c2173e.f6099a;
            }
            if (this.f6104f == -1) {
                this.f6104f = c2173e.f6104f;
            }
            if (this.f6105g == -1) {
                this.f6105g = c2173e.f6105g;
            }
            if (this.f6112n == null) {
                this.f6112n = c2173e.f6112n;
            }
            if (this.f6108j == -1) {
                this.f6108j = c2173e.f6108j;
                this.f6109k = c2173e.f6109k;
            }
            if (z && !this.f6103e && c2173e.f6103e) {
                m6693b(c2173e.f6102d);
            }
        }
        return this;
    }

    public int m6686a() {
        int i = 0;
        if (this.f6106h == -1 && this.f6107i == -1) {
            return -1;
        }
        int i2 = this.f6106h == 1 ? 1 : 0;
        if (this.f6107i == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public C2173e m6687a(float f) {
        this.f6109k = f;
        return this;
    }

    public C2173e m6688a(int i) {
        C2252a.m7024b(this.f6111m == null);
        this.f6100b = i;
        this.f6101c = true;
        return this;
    }

    public C2173e m6689a(Alignment alignment) {
        this.f6112n = alignment;
        return this;
    }

    public C2173e m6690a(C2173e c2173e) {
        return m6685a(c2173e, true);
    }

    public C2173e m6691a(String str) {
        C2252a.m7024b(this.f6111m == null);
        this.f6099a = str;
        return this;
    }

    public C2173e m6692a(boolean z) {
        int i = 1;
        C2252a.m7024b(this.f6111m == null);
        if (!z) {
            i = 0;
        }
        this.f6104f = i;
        return this;
    }

    public C2173e m6693b(int i) {
        this.f6102d = i;
        this.f6103e = true;
        return this;
    }

    public C2173e m6694b(String str) {
        this.f6110l = str;
        return this;
    }

    public C2173e m6695b(boolean z) {
        int i = 1;
        C2252a.m7024b(this.f6111m == null);
        if (!z) {
            i = 0;
        }
        this.f6105g = i;
        return this;
    }

    public boolean m6696b() {
        return this.f6104f == 1;
    }

    public C2173e m6697c(int i) {
        this.f6108j = i;
        return this;
    }

    public C2173e m6698c(boolean z) {
        int i = 1;
        C2252a.m7024b(this.f6111m == null);
        if (!z) {
            i = 0;
        }
        this.f6106h = i;
        return this;
    }

    public boolean m6699c() {
        return this.f6105g == 1;
    }

    public C2173e m6700d(boolean z) {
        int i = 1;
        C2252a.m7024b(this.f6111m == null);
        if (!z) {
            i = 0;
        }
        this.f6107i = i;
        return this;
    }

    public String m6701d() {
        return this.f6099a;
    }

    public int m6702e() {
        if (this.f6101c) {
            return this.f6100b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public boolean m6703f() {
        return this.f6101c;
    }

    public int m6704g() {
        if (this.f6103e) {
            return this.f6102d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean m6705h() {
        return this.f6103e;
    }

    public String m6706i() {
        return this.f6110l;
    }

    public Alignment m6707j() {
        return this.f6112n;
    }

    public int m6708k() {
        return this.f6108j;
    }

    public float m6709l() {
        return this.f6109k;
    }
}
