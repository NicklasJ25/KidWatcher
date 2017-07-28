package com.google.android.exoplayer2.p063h;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p055f.C2152h;
import java.util.Arrays;
import java.util.Comparator;

public abstract class C2203b implements C2202f {
    protected final C2152h f6236a;
    protected final int f6237b;
    protected final int[] f6238c;
    private final Format[] f6239d;
    private final long[] f6240e;
    private int f6241f;

    private static final class C2206a implements Comparator<Format> {
        private C2206a() {
        }

        public int m6869a(Format format, Format format2) {
            return format2.f4944b - format.f4944b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6869a((Format) obj, (Format) obj2);
        }
    }

    public C2203b(C2152h c2152h, int... iArr) {
        int i = 0;
        C2252a.m7024b(iArr.length > 0);
        this.f6236a = (C2152h) C2252a.m7020a((Object) c2152h);
        this.f6237b = iArr.length;
        this.f6239d = new Format[this.f6237b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f6239d[i2] = c2152h.m6574a(iArr[i2]);
        }
        Arrays.sort(this.f6239d, new C2206a());
        this.f6238c = new int[this.f6237b];
        while (i < this.f6237b) {
            this.f6238c[i] = c2152h.m6573a(this.f6239d[i]);
            i++;
        }
        this.f6240e = new long[this.f6237b];
    }

    public final Format mo3086a(int i) {
        return this.f6239d[i];
    }

    public final C2152h mo3087a() {
        return this.f6236a;
    }

    protected final boolean m6865a(int i, long j) {
        return this.f6240e[i] > j;
    }

    public final int mo3088b() {
        return this.f6238c.length;
    }

    public final int mo3089b(int i) {
        return this.f6238c[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2203b c2203b = (C2203b) obj;
        return this.f6236a == c2203b.f6236a && Arrays.equals(this.f6238c, c2203b.f6238c);
    }

    public int hashCode() {
        if (this.f6241f == 0) {
            this.f6241f = (System.identityHashCode(this.f6236a) * 31) + Arrays.hashCode(this.f6238c);
        }
        return this.f6241f;
    }
}
