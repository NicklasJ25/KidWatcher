package com.domobile.p016c;

import android.text.TextUtils;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import java.security.MessageDigest;

public class C1170b {
    private static final String[] f2254a = new String[]{"0", "1", GpsMeasureMode.MODE_2_DIMENSIONAL, GpsMeasureMode.MODE_3_DIMENSIONAL, "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String m2681a(byte b) {
        int i;
        if (b < (byte) 0) {
            i = b + 256;
        }
        return f2254a[i / 16] + f2254a[i % 16];
    }

    public static final String m2682a(String str) {
        return C1170b.m2686b(str, "MD5");
    }

    public static String m2683a(String str, String str2) {
        return C1170b.m2686b(C1170b.m2687c(str, str2), "MD5");
    }

    public static String m2684a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a : bArr) {
            stringBuffer.append(C1170b.m2681a(a));
        }
        return stringBuffer.toString();
    }

    public static String m2685b(String str) {
        return C1170b.m2686b(str, "MD5");
    }

    public static final String m2686b(String str, String str2) {
        String str3 = null;
        if (!(str == null || str2 == null)) {
            try {
                str3 = C1170b.m2684a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
            } catch (Exception e) {
            }
        }
        return str3;
    }

    private static String m2687c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return TextUtils.isEmpty(str2) ? str : str + str2.toString();
    }
}
