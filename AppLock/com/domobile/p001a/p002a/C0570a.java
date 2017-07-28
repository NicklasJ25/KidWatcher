package com.domobile.p001a.p002a;

import android.support.v4.media.TransportMediator;
import com.google.android.vending.licensing.p066a.C3525a;

public class C0570a {
    static final /* synthetic */ boolean f343a = (!C0570a.class.desiredAssertionStatus());
    private static final byte[] f344b = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] f345c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    private static final byte[] f346d = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    private static final byte[] f347e = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9};

    private C0570a() {
    }

    private static int m497a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        if (bArr[i + 2] == (byte) 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[i]] << 24) >>> 6) | ((bArr3[bArr[i + 1]] << 24) >>> 12)) >>> 16);
            return 1;
        } else if (bArr[i + 3] == (byte) 61) {
            r0 = (((bArr3[bArr[i]] << 24) >>> 6) | ((bArr3[bArr[i + 1]] << 24) >>> 12)) | ((bArr3[bArr[i + 2]] << 24) >>> 18);
            bArr2[i2] = (byte) (r0 >>> 16);
            bArr2[i2 + 1] = (byte) (r0 >>> 8);
            return 2;
        } else {
            r0 = ((((bArr3[bArr[i]] << 24) >>> 6) | ((bArr3[bArr[i + 1]] << 24) >>> 12)) | ((bArr3[bArr[i + 2]] << 24) >>> 18)) | ((bArr3[bArr[i + 3]] << 24) >>> 24);
            bArr2[i2] = (byte) (r0 >> 16);
            bArr2[i2 + 1] = (byte) (r0 >> 8);
            bArr2[i2 + 2] = (byte) r0;
            return 3;
        }
    }

    public static byte[] m498a(String str) {
        byte[] bytes = str.getBytes();
        return C0570a.m499a(bytes, 0, bytes.length);
    }

    public static byte[] m499a(byte[] bArr, int i, int i2) {
        return C0570a.m500a(bArr, i, i2, f346d);
    }

    public static byte[] m500a(byte[] bArr, int i, int i2, byte[] bArr2) {
        Object obj;
        Object obj2 = new byte[(((i2 * 3) / 4) + 2)];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6;
            byte b = (byte) (bArr[i3 + i] & TransportMediator.KEYCODE_MEDIA_PAUSE);
            byte b2 = bArr2[b];
            if (b2 >= (byte) -5) {
                if (b2 < (byte) -1) {
                    i6 = i4;
                    i4 = i5;
                } else if (b == (byte) 61) {
                    i6 = i2 - i3;
                    b = (byte) (bArr[(i2 - 1) + i] & TransportMediator.KEYCODE_MEDIA_PAUSE);
                    if (i4 == 0 || i4 == 1) {
                        throw new C3525a("invalid padding byte '=' at byte offset " + i3);
                    } else if ((i4 != 3 || i6 <= 2) && (i4 != 4 || i6 <= 1)) {
                        if (!(b == (byte) 61 || b == (byte) 10)) {
                            throw new C3525a("encoded value has invalid trailing byte");
                        }
                        if (i4 != 0) {
                            if (i4 != 1) {
                                throw new C3525a("single trailing character at offset " + (i2 - 1));
                            }
                            i6 = i4 + 1;
                            bArr3[i4] = (byte) 61;
                            i5 += C0570a.m497a(bArr3, 0, obj2, i5, bArr2);
                        }
                        obj = new byte[i5];
                        System.arraycopy(obj2, 0, obj, 0, i5);
                        return obj;
                    } else {
                        throw new C3525a("padding byte '=' falsely signals end of encoded value at offset " + i3);
                    }
                } else {
                    i6 = i4 + 1;
                    bArr3[i4] = b;
                    if (i6 == 4) {
                        i4 = C0570a.m497a(bArr3, 0, obj2, i5, bArr2) + i5;
                        i6 = 0;
                    } else {
                        i4 = i5;
                    }
                }
                i3++;
                i5 = i4;
                i4 = i6;
            } else {
                throw new C3525a("Bad Base64 input character at " + i3 + ": " + bArr[i3 + i] + "(decimal)");
            }
        }
        if (i4 != 0) {
            if (i4 != 1) {
                i6 = i4 + 1;
                bArr3[i4] = (byte) 61;
                i5 += C0570a.m497a(bArr3, 0, obj2, i5, bArr2);
            } else {
                throw new C3525a("single trailing character at offset " + (i2 - 1));
            }
        }
        obj = new byte[i5];
        System.arraycopy(obj2, 0, obj, 0, i5);
        return obj;
    }
}
