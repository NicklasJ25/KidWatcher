package com.google.android.exoplayer2.p063h;

import java.util.Arrays;

public final class C2214g<T> {
    public final T f6280a;
    public final int f6281b;
    private final C2202f[] f6282c;
    private int f6283d;

    public C2214g(T t, C2202f... c2202fArr) {
        this.f6280a = t;
        this.f6282c = c2202fArr;
        this.f6281b = c2202fArr.length;
    }

    public C2202f m6898a(int i) {
        return this.f6282c[i];
    }

    public C2202f[] m6899a() {
        return (C2202f[]) this.f6282c.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6282c, ((C2214g) obj).f6282c);
    }

    public int hashCode() {
        if (this.f6283d == 0) {
            this.f6283d = Arrays.hashCode(this.f6282c) + 527;
        }
        return this.f6283d;
    }
}
