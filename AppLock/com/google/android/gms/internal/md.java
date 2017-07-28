package com.google.android.gms.internal;

import java.util.Arrays;

final class md {
    final int f9771a;
    final byte[] f9772b;

    md(int i, byte[] bArr) {
        this.f9771a = i;
        this.f9772b = bArr;
    }

    int m12502a() {
        return (lu.m12387f(this.f9771a) + 0) + this.f9772b.length;
    }

    void m12503a(lu luVar) {
        luVar.m12420e(this.f9771a);
        luVar.m12419d(this.f9772b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof md)) {
            return false;
        }
        md mdVar = (md) obj;
        return this.f9771a == mdVar.f9771a && Arrays.equals(this.f9772b, mdVar.f9772b);
    }

    public int hashCode() {
        return ((this.f9771a + 527) * 31) + Arrays.hashCode(this.f9772b);
    }
}
