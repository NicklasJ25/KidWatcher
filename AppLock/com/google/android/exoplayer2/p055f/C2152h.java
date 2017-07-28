package com.google.android.exoplayer2.p055f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import java.util.Arrays;

public final class C2152h {
    public final int f6025a;
    private final Format[] f6026b;
    private int f6027c;

    public C2152h(Format... formatArr) {
        C2252a.m7024b(formatArr.length > 0);
        this.f6026b = formatArr;
        this.f6025a = formatArr.length;
    }

    public int m6573a(Format format) {
        for (int i = 0; i < this.f6026b.length; i++) {
            if (format == this.f6026b[i]) {
                return i;
            }
        }
        return -1;
    }

    public Format m6574a(int i) {
        return this.f6026b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2152h c2152h = (C2152h) obj;
        return this.f6025a == c2152h.f6025a && Arrays.equals(this.f6026b, c2152h.f6026b);
    }

    public int hashCode() {
        if (this.f6027c == 0) {
            this.f6027c = Arrays.hashCode(this.f6026b) + 527;
        }
        return this.f6027c;
    }
}
