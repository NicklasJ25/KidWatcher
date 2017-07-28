package com.google.android.exoplayer2.p045c;

public final class C2092k {
    private static final String[] f5875h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] f5876i = new int[]{44100, 48000, 32000};
    private static final int[] f5877j = new int[]{32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};
    private static final int[] f5878k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] f5879l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    private static final int[] f5880m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] f5881n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int f5882a;
    public String f5883b;
    public int f5884c;
    public int f5885d;
    public int f5886e;
    public int f5887f;
    public int f5888g;

    public static int m6349a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = f5876i[i5];
        i5 = i2 == 2 ? i6 / 2 : i2 == 0 ? i6 / 4 : i6;
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f5877j[i4 - 1] : f5878k[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? f5879l[i4 - 1] : f5880m[i4 - 1];
        } else {
            i4 = f5881n[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    private void m6350a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.f5882a = i;
        this.f5883b = str;
        this.f5884c = i2;
        this.f5885d = i3;
        this.f5886e = i4;
        this.f5887f = i5;
        this.f5888g = i6;
    }

    public static boolean m6351a(int i, C2092k c2092k) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8;
        int i9 = f5876i[i6];
        if (i3 == 2) {
            i9 /= 2;
        } else if (i3 == 0) {
            i9 /= 4;
        }
        i6 = (i >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f5877j[i5 - 1] : f5878k[i5 - 1];
            i6 = (((i7 * 12000) / i9) + i6) * 4;
            i8 = 384;
        } else if (i3 == 3) {
            i7 = i4 == 2 ? f5879l[i5 - 1] : f5880m[i5 - 1];
            i8 = 1152;
            i6 += (144000 * i7) / i9;
        } else {
            i5 = f5881n[i5 - 1];
            i8 = i4 == 1 ? 576 : 1152;
            i6 += ((i4 == 1 ? 72000 : 144000) * i5) / i9;
            i7 = i5;
        }
        String str = f5875h[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        c2092k.m6350a(i3, str, i6, i9, i2, i7 * 1000, i8);
        return true;
    }
}
