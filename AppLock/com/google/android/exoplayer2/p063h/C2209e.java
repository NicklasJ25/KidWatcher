package com.google.android.exoplayer2.p063h;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.C1948n;
import com.google.android.exoplayer2.p055f.C2152h;
import com.google.android.exoplayer2.p055f.C2153i;
import com.google.android.exoplayer2.p063h.C2202f.C2200a;
import java.util.Arrays;
import java.util.Map;

public abstract class C2209e extends C2208h<C2212a> {
    private final SparseArray<Map<C2153i, C2213b>> f6264a = new SparseArray();
    private final SparseBooleanArray f6265b = new SparseBooleanArray();

    public static final class C2212a {
        private final int[] f6271a;
        private final C2153i[] f6272b;
        private final int[] f6273c;
        private final int[][][] f6274d;
        private final C2153i f6275e;
        private final int f6276f;

        C2212a(int[] iArr, C2153i[] c2153iArr, int[] iArr2, int[][][] iArr3, C2153i c2153i) {
            this.f6271a = iArr;
            this.f6272b = c2153iArr;
            this.f6274d = iArr3;
            this.f6273c = iArr2;
            this.f6275e = c2153i;
            this.f6276f = c2153iArr.length;
        }
    }

    public static final class C2213b {
        public final C2200a f6277a;
        public final int f6278b;
        public final int[] f6279c;

        public C2202f m6897a(C2153i c2153i) {
            return this.f6277a.mo3085b(c2153i.m6576a(this.f6278b), this.f6279c);
        }
    }

    public C2209e(Handler handler) {
        super(handler);
    }

    private static int m6876a(C1948n[] c1948nArr, C2152h c2152h) {
        int i = 0;
        int length = c1948nArr.length;
        for (int i2 = 0; i2 < c1948nArr.length; i2++) {
            C1948n c1948n = c1948nArr[i2];
            int i3 = 0;
            while (i3 < c2152h.f6025a) {
                int a = c1948n.mo2911a(c2152h.m6574a(i3));
                if (a <= i) {
                    a = length;
                    length = i;
                } else if (a == 3) {
                    return i2;
                } else {
                    length = a;
                    a = i2;
                }
                i3++;
                i = length;
                length = a;
            }
        }
        return length;
    }

    private static int[] m6877a(C1948n c1948n, C2152h c2152h) {
        int[] iArr = new int[c2152h.f6025a];
        for (int i = 0; i < c2152h.f6025a; i++) {
            iArr[i] = c1948n.mo2911a(c2152h.m6574a(i));
        }
        return iArr;
    }

    private static int[] m6878a(C1948n[] c1948nArr) {
        int[] iArr = new int[c1948nArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = c1948nArr[i].mo2910l();
        }
        return iArr;
    }

    public final C2214g<C2212a> mo3090a(C1948n[] c1948nArr, C2153i c2153i) {
        int i;
        int[] a;
        int i2 = 0;
        int[] iArr = new int[(c1948nArr.length + 1)];
        C2152h[][] c2152hArr = new C2152h[(c1948nArr.length + 1)][];
        int[][][] iArr2 = new int[(c1948nArr.length + 1)][][];
        for (i = 0; i < c2152hArr.length; i++) {
            c2152hArr[i] = new C2152h[c2153i.f6028a];
            iArr2[i] = new int[c2153i.f6028a][];
        }
        int[] a2 = C2209e.m6878a(c1948nArr);
        for (i = 0; i < c2153i.f6028a; i++) {
            C2152h a3 = c2153i.m6576a(i);
            int a4 = C2209e.m6876a(c1948nArr, a3);
            a = a4 == c1948nArr.length ? new int[a3.f6025a] : C2209e.m6877a(c1948nArr[a4], a3);
            int i3 = iArr[a4];
            c2152hArr[a4][i3] = a3;
            iArr2[a4][i3] = a;
            iArr[a4] = iArr[a4] + 1;
        }
        C2153i[] c2153iArr = new C2153i[c1948nArr.length];
        a = new int[c1948nArr.length];
        for (a4 = 0; a4 < c1948nArr.length; a4++) {
            i3 = iArr[a4];
            c2153iArr[a4] = new C2153i((C2152h[]) Arrays.copyOf(c2152hArr[a4], i3));
            iArr2[a4] = (int[][]) Arrays.copyOf(iArr2[a4], i3);
            a[a4] = c1948nArr[a4].mo2894a();
        }
        C2153i c2153i2 = new C2153i((C2152h[]) Arrays.copyOf(c2152hArr[c1948nArr.length], iArr[c1948nArr.length]));
        C2202f[] a5 = mo3091a(c1948nArr, c2153iArr, iArr2);
        while (i2 < c1948nArr.length) {
            if (this.f6265b.get(i2)) {
                a5[i2] = null;
            } else {
                C2153i c2153i3 = c2153iArr[i2];
                Map map = (Map) this.f6264a.get(i2);
                C2213b c2213b = map == null ? null : (C2213b) map.get(c2153i3);
                if (c2213b != null) {
                    a5[i2] = c2213b.m6897a(c2153i3);
                }
            }
            i2++;
        }
        return new C2214g(new C2212a(a, c2153iArr, a2, iArr2, c2153i2), a5);
    }

    protected abstract C2202f[] mo3091a(C1948n[] c1948nArr, C2153i[] c2153iArr, int[][][] iArr);
}
