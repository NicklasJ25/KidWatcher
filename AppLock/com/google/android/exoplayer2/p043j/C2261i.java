package com.google.android.exoplayer2.p043j;

import android.support.v4.media.TransportMediator;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class C2261i {
    public static final byte[] f6446a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] f6447b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object f6448c = new Object();
    private static int[] f6449d = new int[10];

    public static final class C2259a {
        public final int f6433a;
        public final int f6434b;
        public final boolean f6435c;

        public C2259a(int i, int i2, boolean z) {
            this.f6433a = i;
            this.f6434b = i2;
            this.f6435c = z;
        }
    }

    public static final class C2260b {
        public final int f6436a;
        public final int f6437b;
        public final int f6438c;
        public final float f6439d;
        public final boolean f6440e;
        public final boolean f6441f;
        public final int f6442g;
        public final int f6443h;
        public final int f6444i;
        public final boolean f6445j;

        public C2260b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f6436a = i;
            this.f6437b = i2;
            this.f6438c = i3;
            this.f6439d = f;
            this.f6440e = z;
            this.f6441f = z2;
            this.f6442g = i4;
            this.f6443h = i5;
            this.f6444i = i6;
            this.f6445j = z3;
        }
    }

    public static int m7048a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        synchronized (f6448c) {
            int c;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                c = C2261i.m7057c(bArr, i5, i);
                if (c < i) {
                    if (f6449d.length <= i4) {
                        f6449d = Arrays.copyOf(f6449d, f6449d.length * 2);
                    }
                    i5 = i4 + 1;
                    f6449d[i4] = c;
                    i4 = i5;
                    i5 = c + 3;
                } else {
                    i5 = c;
                }
            }
            i2 = i - i4;
            i5 = 0;
            c = 0;
            while (i3 < i4) {
                int i6 = f6449d[i3] - c;
                System.arraycopy(bArr, c, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                c += i6 + 3;
                i3++;
            }
            System.arraycopy(bArr, c, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static int m7049a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        C2252a.m7024b(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                C2261i.m7053a(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                C2261i.m7053a(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                C2261i.m7053a(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        C2261i.m7053a(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i2 - 1] == (byte) 0 : zArr[2] && bArr[i2 - 1] == (byte) 0;
        zArr[1] = z2;
        if (bArr[i2 - 1] != (byte) 0) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static C2260b m7050a(byte[] bArr, int i, int i2) {
        int c;
        int i3;
        boolean z;
        int i4;
        float f;
        C2264l c2264l = new C2264l(bArr, i, i2);
        c2264l.m7101a(8);
        int c2 = c2264l.m7107c(8);
        c2264l.m7101a(16);
        int c3 = c2264l.m7106c();
        boolean z2 = false;
        if (c2 == 100 || c2 == 110 || c2 == 122 || c2 == 244 || c2 == 44 || c2 == 83 || c2 == 86 || c2 == 118 || c2 == 128 || c2 == 138) {
            c = c2264l.m7106c();
            if (c == 3) {
                z2 = c2264l.m7103a();
            }
            c2264l.m7106c();
            c2264l.m7106c();
            c2264l.m7101a(1);
            if (c2264l.m7103a()) {
                i3 = c != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i3) {
                    if (c2264l.m7103a()) {
                        C2261i.m7051a(c2264l, i5 < 6 ? 16 : 64);
                    }
                    i5++;
                }
            }
            z = z2;
            i4 = c;
        } else {
            z = false;
            i4 = 1;
        }
        int c4 = c2264l.m7106c() + 4;
        int c5 = c2264l.m7106c();
        int i6 = 0;
        boolean z3 = false;
        if (c5 == 0) {
            i6 = c2264l.m7106c() + 4;
        } else if (c5 == 1) {
            z3 = c2264l.m7103a();
            c2264l.m7108d();
            c2264l.m7108d();
            long c6 = (long) c2264l.m7106c();
            for (i3 = 0; ((long) i3) < c6; i3++) {
                c2264l.m7106c();
            }
        }
        c2264l.m7106c();
        c2264l.m7101a(1);
        c2 = c2264l.m7106c() + 1;
        c = c2264l.m7106c() + 1;
        boolean a = c2264l.m7103a();
        i3 = (2 - (a ? 1 : 0)) * c;
        if (!a) {
            c2264l.m7101a(1);
        }
        c2264l.m7101a(1);
        c = c2 * 16;
        c2 = i3 * 16;
        if (c2264l.m7103a()) {
            int c7 = c2264l.m7106c();
            int c8 = c2264l.m7106c();
            int c9 = c2264l.m7106c();
            int c10 = c2264l.m7106c();
            if (i4 == 0) {
                i3 = 1;
                i4 = 2 - (a ? 1 : 0);
            } else {
                i3 = i4 == 3 ? 1 : 2;
                i4 = (2 - (a ? 1 : 0)) * (i4 == 1 ? 2 : 1);
            }
            i3 = c - (i3 * (c7 + c8));
            c2 -= i4 * (c9 + c10);
        } else {
            i3 = c;
        }
        float f2 = 1.0f;
        if (c2264l.m7103a() && c2264l.m7103a()) {
            c = c2264l.m7107c(8);
            if (c == 255) {
                c = c2264l.m7107c(16);
                int c11 = c2264l.m7107c(16);
                if (!(c == 0 || c11 == 0)) {
                    f2 = ((float) c) / ((float) c11);
                }
                f = f2;
            } else if (c < f6447b.length) {
                f = f6447b[c];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + c);
            }
            return new C2260b(c3, i3, c2, f, z, a, c4, c5, i6, z3);
        }
        f = 1.0f;
        return new C2260b(c3, i3, c2, f, z, a, c4, c5, i6, z3);
    }

    private static void m7051a(C2264l c2264l, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((c2264l.m7108d() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    public static void m7052a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static void m7053a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int m7054b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static C2259a m7055b(byte[] bArr, int i, int i2) {
        C2264l c2264l = new C2264l(bArr, i, i2);
        c2264l.m7101a(8);
        int c = c2264l.m7106c();
        int c2 = c2264l.m7106c();
        c2264l.m7101a(1);
        return new C2259a(c, c2, c2264l.m7103a());
    }

    public static int m7056c(byte[] bArr, int i) {
        return (bArr[i + 3] & TransportMediator.KEYCODE_MEDIA_PLAY) >> 1;
    }

    private static int m7057c(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 2) {
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 3) {
                return i3;
            }
            i3++;
        }
        return i2;
    }
}
