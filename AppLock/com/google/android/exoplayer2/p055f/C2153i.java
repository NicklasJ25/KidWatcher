package com.google.android.exoplayer2.p055f;

import java.util.Arrays;

public final class C2153i {
    public final int f6028a;
    private final C2152h[] f6029b;
    private int f6030c;

    public C2153i(C2152h... c2152hArr) {
        this.f6029b = c2152hArr;
        this.f6028a = c2152hArr.length;
    }

    public int m6575a(C2152h c2152h) {
        for (int i = 0; i < this.f6028a; i++) {
            if (this.f6029b[i] == c2152h) {
                return i;
            }
        }
        return -1;
    }

    public C2152h m6576a(int i) {
        return this.f6029b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2153i c2153i = (C2153i) obj;
        return this.f6028a == c2153i.f6028a && Arrays.equals(this.f6029b, c2153i.f6029b);
    }

    public int hashCode() {
        if (this.f6030c == 0) {
            this.f6030c = Arrays.hashCode(this.f6029b);
        }
        return this.f6030c;
    }
}
