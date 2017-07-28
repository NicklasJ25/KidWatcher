package com.google.android.exoplayer2.p041a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p043j.C2262j;
import java.nio.ByteBuffer;

public final class C1945e {
    private static final int[] f5053a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] f5054b = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] f5055c = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int m5574a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int m5575a(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static Format m5576a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        C2262j c2262j = new C2262j(bArr);
        c2262j.m7061b(60);
        int i = f5053a[c2262j.m7063c(6)];
        int i2 = f5054b[c2262j.m7063c(4)];
        int c = c2262j.m7063c(5);
        c = c >= f5055c.length ? -1 : (f5055c[c] * 1000) / 2;
        c2262j.m7061b(10);
        return Format.m5480a(str, "audio/vnd.dts", null, c, -1, i + (c2262j.m7063c(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
    }

    public static int m5577b(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
