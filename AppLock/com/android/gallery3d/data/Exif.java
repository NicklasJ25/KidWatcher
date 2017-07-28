package com.android.gallery3d.data;

import java.io.IOException;
import java.io.InputStream;

public class Exif {
    private static final String TAG = "CameraExif";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getOrientation(java.io.InputStream r9) {
        /*
        r6 = 6;
        r0 = 1;
        r7 = 4;
        r8 = 2;
        r1 = 0;
        if (r9 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = 8;
        r3 = new byte[r2];
    L_0x000c:
        r2 = read(r9, r3, r8);
        if (r2 == 0) goto L_0x00f4;
    L_0x0012:
        r2 = r3[r1];
        r2 = r2 & 255;
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r2 != r4) goto L_0x00f4;
    L_0x001a:
        r2 = r3[r0];
        r4 = r2 & 255;
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r4 == r2) goto L_0x000c;
    L_0x0022:
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r4 == r2) goto L_0x000c;
    L_0x0026:
        if (r4 == r0) goto L_0x000c;
    L_0x0028:
        r2 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        if (r4 == r2) goto L_0x0007;
    L_0x002c:
        r2 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        if (r4 == r2) goto L_0x0007;
    L_0x0030:
        r2 = read(r9, r3, r8);
        if (r2 == 0) goto L_0x0007;
    L_0x0036:
        r2 = pack(r3, r1, r8, r1);
        if (r2 >= r8) goto L_0x0044;
    L_0x003c:
        r0 = "CameraExif";
        r2 = "Invalid length";
        android.util.Log.e(r0, r2);
        goto L_0x0007;
    L_0x0044:
        r2 = r2 + -2;
        r5 = 225; // 0xe1 float:3.15E-43 double:1.11E-321;
        if (r4 != r5) goto L_0x0085;
    L_0x004a:
        if (r2 < r6) goto L_0x0085;
    L_0x004c:
        r4 = read(r9, r3, r6);
        if (r4 == 0) goto L_0x0007;
    L_0x0052:
        r2 = r2 + -6;
        r4 = pack(r3, r1, r7, r1);
        r5 = 1165519206; // 0x45786966 float:3974.5874 double:5.758429993E-315;
        if (r4 != r5) goto L_0x0085;
    L_0x005d:
        r4 = pack(r3, r7, r8, r1);
        if (r4 != 0) goto L_0x0085;
    L_0x0063:
        r3 = 8;
        if (r2 <= r3) goto L_0x00eb;
    L_0x0067:
        r6 = new byte[r2];
        r3 = read(r9, r6, r2);
        if (r3 == 0) goto L_0x0007;
    L_0x006f:
        r3 = pack(r6, r1, r7, r1);
        r4 = 1229531648; // 0x49492a00 float:823968.0 double:6.074693478E-315;
        if (r3 == r4) goto L_0x008d;
    L_0x0078:
        r4 = 1296891946; // 0x4d4d002a float:2.14958752E8 double:6.40749757E-315;
        if (r3 == r4) goto L_0x008d;
    L_0x007d:
        r0 = "CameraExif";
        r2 = "Invalid byte order";
        android.util.Log.e(r0, r2);
        goto L_0x0007;
    L_0x0085:
        r4 = (long) r2;
        r9.skip(r4);	 Catch:{ IOException -> 0x008a }
        goto L_0x000c;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0007;
    L_0x008d:
        r4 = 1229531648; // 0x49492a00 float:823968.0 double:6.074693478E-315;
        if (r3 != r4) goto L_0x00a7;
    L_0x0092:
        r3 = pack(r6, r7, r7, r0);
        r4 = r3 + 2;
        r3 = 10;
        if (r4 < r3) goto L_0x009e;
    L_0x009c:
        if (r4 <= r2) goto L_0x00a9;
    L_0x009e:
        r0 = "CameraExif";
        r2 = "Invalid offset";
        android.util.Log.e(r0, r2);
        goto L_0x0007;
    L_0x00a7:
        r0 = r1;
        goto L_0x0092;
    L_0x00a9:
        r3 = r1 + r4;
        r4 = r2 - r4;
        r2 = r3 + -2;
        r2 = pack(r6, r2, r8, r0);
        r5 = r4;
        r4 = r3;
    L_0x00b5:
        r3 = r2 + -1;
        if (r2 <= 0) goto L_0x00eb;
    L_0x00b9:
        r2 = 12;
        if (r5 < r2) goto L_0x00eb;
    L_0x00bd:
        r2 = pack(r6, r4, r8, r0);
        r7 = 274; // 0x112 float:3.84E-43 double:1.354E-321;
        if (r2 != r7) goto L_0x00e3;
    L_0x00c5:
        r2 = r4 + 8;
        r0 = pack(r6, r2, r8, r0);
        switch(r0) {
            case 1: goto L_0x0007;
            case 2: goto L_0x00ce;
            case 3: goto L_0x00d7;
            case 4: goto L_0x00ce;
            case 5: goto L_0x00ce;
            case 6: goto L_0x00db;
            case 7: goto L_0x00ce;
            case 8: goto L_0x00df;
            default: goto L_0x00ce;
        };
    L_0x00ce:
        r0 = "CameraExif";
        r2 = "Unsupported orientation";
        android.util.Log.i(r0, r2);
        goto L_0x0007;
    L_0x00d7:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0007;
    L_0x00db:
        r1 = 90;
        goto L_0x0007;
    L_0x00df:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0007;
    L_0x00e3:
        r2 = r4 + 12;
        r4 = r5 + -12;
        r5 = r4;
        r4 = r2;
        r2 = r3;
        goto L_0x00b5;
    L_0x00eb:
        r0 = "CameraExif";
        r2 = "Orientation not found";
        android.util.Log.i(r0, r2);
        goto L_0x0007;
    L_0x00f4:
        r2 = r1;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.data.Exif.getOrientation(java.io.InputStream):int");
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3 = 1;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (i4 << 8) | (bArr[i] & 255);
            i += i3;
            i2 = i5;
        }
    }

    private static boolean read(InputStream inputStream, byte[] bArr, int i) {
        try {
            return inputStream.read(bArr, 0, i) == i;
        } catch (IOException e) {
            return false;
        }
    }
}
