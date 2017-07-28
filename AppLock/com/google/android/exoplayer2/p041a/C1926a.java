package com.google.android.exoplayer2.p041a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p043j.C2262j;
import com.google.android.exoplayer2.p043j.C2263k;
import java.nio.ByteBuffer;

public final class C1926a {
    private static final int[] f4968a = new int[]{1, 2, 3, 6};
    private static final int[] f4969b = new int[]{48000, 44100, 32000};
    private static final int[] f4970c = new int[]{24000, 22050, 16000};
    private static final int[] f4971d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] f4972e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f4973f = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int m5494a() {
        return 1536;
    }

    private static int m5495a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= f4969b.length || i2 < 0 || i3 >= f4973f.length) {
            return -1;
        }
        int i4 = f4969b[i];
        if (i4 == 44100) {
            return (f4973f[i3] + (i2 % 2)) * 2;
        }
        i3 = f4972e[i3];
        return i4 == 32000 ? i3 * 6 : i3 * 4;
    }

    public static int m5496a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3 ? 6 : f4968a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4]) * 256;
    }

    public static int m5497a(byte[] bArr) {
        return bArr.length < 5 ? -1 : C1926a.m5495a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static Format m5498a(C2262j c2262j, String str, String str2, DrmInitData drmInitData) {
        int i = 1;
        c2262j.m7061b(32);
        int c = c2262j.m7063c(2);
        c2262j.m7061b(14);
        int c2 = c2262j.m7063c(3);
        if (!((c2 & 1) == 0 || c2 == 1)) {
            c2262j.m7061b(2);
        }
        if ((c2 & 4) != 0) {
            c2262j.m7061b(2);
        }
        if (c2 == 2) {
            c2262j.m7061b(2);
        }
        boolean b = c2262j.m7062b();
        String str3 = "audio/ac3";
        c2 = f4971d[c2];
        if (!b) {
            i = 0;
        }
        return Format.m5480a(str, str3, null, -1, -1, c2 + i, f4969b[c], null, drmInitData, 0, str2);
    }

    public static Format m5499a(C2263k c2263k, String str, String str2, DrmInitData drmInitData) {
        int i = f4969b[(c2263k.m7079g() & 192) >> 6];
        int g = c2263k.m7079g();
        int i2 = f4971d[(g & 56) >> 3];
        if ((g & 4) != 0) {
            i2++;
        }
        return Format.m5480a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static int m5500b(byte[] bArr) {
        return ((((bArr[2] & 7) << 8) + (bArr[3] & 255)) + 1) * 2;
    }

    public static Format m5501b(C2262j c2262j, String str, String str2, DrmInitData drmInitData) {
        int i;
        c2262j.m7061b(32);
        int c = c2262j.m7063c(2);
        if (c == 3) {
            i = f4970c[c2262j.m7063c(2)];
        } else {
            c2262j.m7061b(2);
            i = f4969b[c];
        }
        return Format.m5480a(str, "audio/eac3", null, -1, -1, f4971d[c2262j.m7063c(3)] + (c2262j.m7062b() ? 1 : 0), i, null, drmInitData, 0, str2);
    }

    public static Format m5502b(C2263k c2263k, String str, String str2, DrmInitData drmInitData) {
        c2263k.m7075d(2);
        int i = f4969b[(c2263k.m7079g() & 192) >> 6];
        int g = c2263k.m7079g();
        int i2 = f4971d[(g & 14) >> 1];
        if ((g & 1) != 0) {
            i2++;
        }
        return Format.m5480a(str, "audio/eac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static int m5503c(byte[] bArr) {
        return (((bArr[4] & 192) >> 6) == 3 ? 6 : f4968a[(bArr[4] & 48) >> 4]) * 256;
    }
}
