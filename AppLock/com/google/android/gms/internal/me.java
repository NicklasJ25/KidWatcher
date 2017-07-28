package com.google.android.gms.internal;

public final class me {
    static final int f9773a = m12505a(1, 3);
    static final int f9774b = m12505a(1, 4);
    static final int f9775c = m12505a(2, 0);
    static final int f9776d = m12505a(3, 2);
    public static final int[] f9777e = new int[0];
    public static final long[] f9778f = new long[0];
    public static final float[] f9779g = new float[0];
    public static final double[] f9780h = new double[0];
    public static final boolean[] f9781i = new boolean[0];
    public static final String[] f9782j = new String[0];
    public static final byte[][] f9783k = new byte[0][];
    public static final byte[] f9784l = new byte[0];

    static int m12504a(int i) {
        return i & 7;
    }

    public static int m12505a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int m12506a(lt ltVar, int i) {
        int i2 = 1;
        int r = ltVar.m12360r();
        ltVar.m12340b(i);
        while (ltVar.m12335a() == i) {
            ltVar.m12340b(i);
            i2++;
        }
        ltVar.m12346e(r);
        return i2;
    }

    public static int m12507b(int i) {
        return i >>> 3;
    }
}
