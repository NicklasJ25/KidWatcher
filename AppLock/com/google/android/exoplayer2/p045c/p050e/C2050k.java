package com.google.android.exoplayer2.p045c.p050e;

import android.util.Log;
import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.p043j.C2263k;
import java.util.Arrays;

final class C2050k {

    public static final class C2046a {
        public final int f5607a;
        public final int f5608b;
        public final long[] f5609c;
        public final int f5610d;
        public final boolean f5611e;

        public C2046a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f5607a = i;
            this.f5608b = i2;
            this.f5609c = jArr;
            this.f5610d = i3;
            this.f5611e = z;
        }
    }

    public static final class C2047b {
        public final String f5612a;
        public final String[] f5613b;
        public final int f5614c;

        public C2047b(String str, String[] strArr, int i) {
            this.f5612a = str;
            this.f5613b = strArr;
            this.f5614c = i;
        }
    }

    public static final class C2048c {
        public final boolean f5615a;
        public final int f5616b;
        public final int f5617c;
        public final int f5618d;

        public C2048c(boolean z, int i, int i2, int i3) {
            this.f5615a = z;
            this.f5616b = i;
            this.f5617c = i2;
            this.f5618d = i3;
        }
    }

    public static final class C2049d {
        public final long f5619a;
        public final int f5620b;
        public final long f5621c;
        public final int f5622d;
        public final int f5623e;
        public final int f5624f;
        public final int f5625g;
        public final int f5626h;
        public final boolean f5627i;
        public final byte[] f5628j;

        public C2049d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f5619a = j;
            this.f5620b = i;
            this.f5621c = j2;
            this.f5622d = i2;
            this.f5623e = i3;
            this.f5624f = i4;
            this.f5625g = i5;
            this.f5626h = i6;
            this.f5627i = z;
            this.f5628j = bArr;
        }
    }

    public static int m6148a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private static long m6149a(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }

    public static C2049d m6150a(C2263k c2263k) {
        C2050k.m6152a(1, c2263k, false);
        long m = c2263k.m7085m();
        int g = c2263k.m7079g();
        long m2 = c2263k.m7085m();
        int o = c2263k.m7087o();
        int o2 = c2263k.m7087o();
        int o3 = c2263k.m7087o();
        int g2 = c2263k.m7079g();
        return new C2049d(m, g, m2, o, o2, o3, (int) Math.pow(2.0d, (double) (g2 & 15)), (int) Math.pow(2.0d, (double) ((g2 & 240) >> 4)), (c2263k.m7079g() & 1) > 0, Arrays.copyOf(c2263k.f6454a, c2263k.m7072c()));
    }

    private static void m6151a(int i, C2043i c2043i) {
        int a = c2043i.m6135a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = c2043i.m6135a(16);
            switch (a2) {
                case 0:
                    int i3;
                    a2 = c2043i.m6136a() ? c2043i.m6135a(4) + 1 : 1;
                    if (c2043i.m6136a()) {
                        int a3 = c2043i.m6135a(8) + 1;
                        for (i3 = 0; i3 < a3; i3++) {
                            c2043i.m6138b(C2050k.m6148a(i - 1));
                            c2043i.m6138b(C2050k.m6148a(i - 1));
                        }
                    }
                    if (c2043i.m6135a(2) == 0) {
                        if (a2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                c2043i.m6138b(4);
                            }
                        }
                        for (i3 = 0; i3 < a2; i3++) {
                            c2043i.m6138b(8);
                            c2043i.m6138b(8);
                            c2043i.m6138b(8);
                        }
                        break;
                    }
                    throw new C1970k("to reserved bits must be zero after mapping coupling steps");
                default:
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a2);
                    break;
            }
        }
    }

    public static boolean m6152a(int i, C2263k c2263k, boolean z) {
        if (c2263k.m7070b() < 7) {
            if (z) {
                return false;
            }
            throw new C1970k("too short header: " + c2263k.m7070b());
        } else if (c2263k.m7079g() != i) {
            if (z) {
                return false;
            }
            throw new C1970k("expected header type " + Integer.toHexString(i));
        } else if (c2263k.m7079g() == 118 && c2263k.m7079g() == 111 && c2263k.m7079g() == 114 && c2263k.m7079g() == 98 && c2263k.m7079g() == 105 && c2263k.m7079g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new C1970k("expected characters 'vorbis'");
        }
    }

    private static C2048c[] m6153a(C2043i c2043i) {
        int a = c2043i.m6135a(6) + 1;
        C2048c[] c2048cArr = new C2048c[a];
        for (int i = 0; i < a; i++) {
            c2048cArr[i] = new C2048c(c2043i.m6136a(), c2043i.m6135a(16), c2043i.m6135a(16), c2043i.m6135a(8));
        }
        return c2048cArr;
    }

    public static C2048c[] m6154a(C2263k c2263k, int i) {
        int i2;
        int i3 = 0;
        C2050k.m6152a(5, c2263k, false);
        int g = c2263k.m7079g() + 1;
        C2043i c2043i = new C2043i(c2263k.f6454a);
        c2043i.m6138b(c2263k.m7074d() * 8);
        for (i2 = 0; i2 < g; i2++) {
            C2050k.m6158d(c2043i);
        }
        i2 = c2043i.m6135a(6) + 1;
        while (i3 < i2) {
            if (c2043i.m6135a(16) != 0) {
                throw new C1970k("placeholder of time domain transforms not zeroed out");
            }
            i3++;
        }
        C2050k.m6157c(c2043i);
        C2050k.m6156b(c2043i);
        C2050k.m6151a(i, c2043i);
        C2048c[] a = C2050k.m6153a(c2043i);
        if (c2043i.m6136a()) {
            return a;
        }
        throw new C1970k("framing bit after modes not set as expected");
    }

    public static C2047b m6155b(C2263k c2263k) {
        int i = 0;
        C2050k.m6152a(3, c2263k, false);
        String e = c2263k.m7077e((int) c2263k.m7085m());
        int length = e.length() + 11;
        long m = c2263k.m7085m();
        String[] strArr = new String[((int) m)];
        length += 4;
        while (((long) i) < m) {
            length += 4;
            strArr[i] = c2263k.m7077e((int) c2263k.m7085m());
            length += strArr[i].length();
            i++;
        }
        if ((c2263k.m7079g() & 1) != 0) {
            return new C2047b(e, strArr, length + 1);
        }
        throw new C1970k("framing bit expected to be set");
    }

    private static void m6156b(C2043i c2043i) {
        int a = c2043i.m6135a(6) + 1;
        for (int i = 0; i < a; i++) {
            if (c2043i.m6135a(16) > 2) {
                throw new C1970k("residueType greater than 2 is not decodable");
            }
            int i2;
            c2043i.m6138b(24);
            c2043i.m6138b(24);
            c2043i.m6138b(24);
            int a2 = c2043i.m6135a(6) + 1;
            c2043i.m6138b(8);
            int[] iArr = new int[a2];
            for (i2 = 0; i2 < a2; i2++) {
                iArr[i2] = ((c2043i.m6136a() ? c2043i.m6135a(5) : 0) * 8) + c2043i.m6135a(3);
            }
            for (i2 = 0; i2 < a2; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if ((iArr[i2] & (1 << i3)) != 0) {
                        c2043i.m6138b(8);
                    }
                }
            }
        }
    }

    private static void m6157c(C2043i c2043i) {
        int a = c2043i.m6135a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = c2043i.m6135a(16);
            int a3;
            switch (a2) {
                case 0:
                    c2043i.m6138b(8);
                    c2043i.m6138b(16);
                    c2043i.m6138b(16);
                    c2043i.m6138b(6);
                    c2043i.m6138b(8);
                    a3 = c2043i.m6135a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        c2043i.m6138b(8);
                    }
                    break;
                case 1:
                    int a4;
                    int a5 = c2043i.m6135a(5);
                    a2 = -1;
                    int[] iArr = new int[a5];
                    for (a3 = 0; a3 < a5; a3++) {
                        iArr[a3] = c2043i.m6135a(4);
                        if (iArr[a3] > a2) {
                            a2 = iArr[a3];
                        }
                    }
                    int[] iArr2 = new int[(a2 + 1)];
                    for (a2 = 0; a2 < iArr2.length; a2++) {
                        iArr2[a2] = c2043i.m6135a(3) + 1;
                        a4 = c2043i.m6135a(2);
                        if (a4 > 0) {
                            c2043i.m6138b(8);
                        }
                        for (a3 = 0; a3 < (1 << a4); a3++) {
                            c2043i.m6138b(8);
                        }
                    }
                    c2043i.m6138b(2);
                    int a6 = c2043i.m6135a(4);
                    a2 = 0;
                    a4 = 0;
                    for (a3 = 0; a3 < a5; a3++) {
                        a4 += iArr2[iArr[a3]];
                        while (a2 < a4) {
                            c2043i.m6138b(a6);
                            a2++;
                        }
                    }
                    break;
                default:
                    throw new C1970k("floor type greater than 1 not decodable: " + a2);
            }
        }
    }

    private static C2046a m6158d(C2043i c2043i) {
        int i = 0;
        if (c2043i.m6135a(24) != 5653314) {
            throw new C1970k("expected code book to start with [0x56, 0x43, 0x42] at " + c2043i.m6137b());
        }
        int i2;
        int a = c2043i.m6135a(16);
        int a2 = c2043i.m6135a(24);
        long[] jArr = new long[a2];
        boolean a3 = c2043i.m6136a();
        if (a3) {
            int a4 = c2043i.m6135a(5) + 1;
            i2 = 0;
            while (i2 < jArr.length) {
                int a5 = c2043i.m6135a(C2050k.m6148a(a2 - i2));
                int i3 = 0;
                while (i3 < a5 && i2 < jArr.length) {
                    jArr[i2] = (long) a4;
                    i3++;
                    i2++;
                }
                a4++;
            }
        } else {
            boolean a6 = c2043i.m6136a();
            while (i < jArr.length) {
                if (!a6) {
                    jArr[i] = (long) (c2043i.m6135a(5) + 1);
                } else if (c2043i.m6136a()) {
                    jArr[i] = (long) (c2043i.m6135a(5) + 1);
                } else {
                    jArr[i] = 0;
                }
                i++;
            }
        }
        i2 = c2043i.m6135a(4);
        if (i2 > 2) {
            throw new C1970k("lookup type greater than 2 not decodable: " + i2);
        }
        if (i2 == 1 || i2 == 2) {
            c2043i.m6138b(32);
            c2043i.m6138b(32);
            i = c2043i.m6135a(4) + 1;
            c2043i.m6138b(1);
            long a7 = i2 == 1 ? a != 0 ? C2050k.m6149a((long) a2, (long) a) : 0 : (long) (a2 * a);
            c2043i.m6138b((int) (a7 * ((long) i)));
        }
        return new C2046a(a, a2, jArr, i2, a3);
    }
}
