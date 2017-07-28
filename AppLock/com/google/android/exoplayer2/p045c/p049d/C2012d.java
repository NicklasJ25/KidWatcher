package com.google.android.exoplayer2.p045c.p049d;

import com.google.android.exoplayer2.p043j.C2273r;

final class C2012d {

    public static final class C2011a {
        public final long[] f5418a;
        public final int[] f5419b;
        public final int f5420c;
        public final long[] f5421d;
        public final int[] f5422e;

        private C2011a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.f5418a = jArr;
            this.f5419b = iArr;
            this.f5420c = i;
            this.f5421d = jArr2;
            this.f5422e = iArr2;
        }
    }

    public static C2011a m5969a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iArr.length) {
            i3++;
            i4 = C2273r.m7125a(iArr[i3], i2) + i4;
        }
        long[] jArr2 = new long[i4];
        int[] iArr2 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr3 = new int[i4];
        i3 = 0;
        i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < iArr.length) {
            int i7 = iArr[i3];
            long j2 = jArr[i3];
            int i8 = i6;
            i6 = i5;
            i5 = i4;
            i4 = i8;
            while (i7 > 0) {
                int min = Math.min(i2, i7);
                jArr2[i4] = j2;
                iArr2[i4] = i * min;
                int max = Math.max(i5, iArr2[i4]);
                jArr3[i4] = ((long) i6) * j;
                iArr3[i4] = 1;
                j2 += (long) iArr2[i4];
                i4++;
                i7 -= min;
                i6 += min;
                i5 = max;
            }
            i3++;
            i8 = i4;
            i4 = i5;
            i5 = i6;
            i6 = i8;
        }
        return new C2011a(jArr2, iArr2, i4, jArr3, iArr3);
    }
}
