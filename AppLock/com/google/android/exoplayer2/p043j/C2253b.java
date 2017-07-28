package com.google.android.exoplayer2.p043j;

import android.util.Pair;

public final class C2253b {
    private static final byte[] f6415a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] f6416b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] f6417c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> m7026a(byte[] bArr) {
        int c;
        boolean z = true;
        C2262j c2262j = new C2262j(bArr);
        int c2 = c2262j.m7063c(5);
        int c3 = c2262j.m7063c(4);
        if (c3 == 15) {
            c = c2262j.m7063c(24);
        } else {
            C2252a.m7022a(c3 < 13);
            c = f6416b[c3];
        }
        c3 = c2262j.m7063c(4);
        if (c2 == 5 || c2 == 29) {
            c2 = c2262j.m7063c(4);
            if (c2 == 15) {
                c = c2262j.m7063c(24);
            } else {
                C2252a.m7022a(c2 < 13);
                c = f6416b[c2];
            }
            if (c2262j.m7063c(5) == 22) {
                c3 = c;
                c = c2262j.m7063c(4);
                c = f6417c[c];
                if (c == -1) {
                    z = false;
                }
                C2252a.m7022a(z);
                return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
            }
        }
        int i = c3;
        c3 = c;
        c = i;
        c = f6417c[c];
        if (c == -1) {
            z = false;
        }
        C2252a.m7022a(z);
        return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
    }

    public static byte[] m7027a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] m7028a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(f6415a.length + i2)];
        System.arraycopy(f6415a, 0, obj, 0, f6415a.length);
        System.arraycopy(bArr, i, obj, f6415a.length, i2);
        return obj;
    }
}
