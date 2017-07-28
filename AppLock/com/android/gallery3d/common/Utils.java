package com.android.gallery3d.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.InterruptedIOException;

public class Utils {
    private static final String DEBUG_TAG = "GalleryDebug";
    private static final long INITIALCRC = -1;
    private static final boolean IS_DEBUG_BUILD;
    private static final String MASK_STRING = "********************************";
    private static final long POLY64REV = -7661587058870466123L;
    private static final String TAG = "Utils";
    private static long[] sCrcTable = new long[256];

    static {
        boolean z = Build.TYPE.equals("eng") || Build.TYPE.equals("userdebug");
        IS_DEBUG_BUILD = z;
        for (int i = 0; i < 256; i++) {
            int i2 = 0;
            long j = (long) i;
            while (i2 < 8) {
                i2++;
                j = ((((int) j) & 1) != 0 ? POLY64REV : 0) ^ (j >> 1);
            }
            sCrcTable[i] = j;
        }
    }

    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static int ceilLog2(float f) {
        int i = 0;
        while (i < 31 && ((float) (1 << i)) < f) {
            i++;
        }
        return i;
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static float clamp(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    public static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        return j > j3 ? j3 : j < j2 ? j2 : j;
    }

    public static void closeSilently(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                Log.w(TAG, "fail to close", th);
            }
        }
    }

    public static void closeSilently(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable th) {
                Log.w(TAG, "fail to close", th);
            }
        }
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.w(TAG, "close fail", th);
            }
        }
    }

    public static int compare(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    public static String[] copyOf(String[] strArr, int i) {
        Object obj = new String[i];
        System.arraycopy(strArr, 0, obj, 0, Math.min(strArr.length, i));
        return obj;
    }

    public static final long crc64Long(String str) {
        return (str == null || str.length() == 0) ? 0 : crc64Long(getBytes(str));
    }

    public static final long crc64Long(byte[] bArr) {
        long j = -1;
        for (byte b : bArr) {
            j = (j >> 8) ^ sCrcTable[(((int) j) ^ b) & 255];
        }
        return j;
    }

    public static void debug(String str, Object... objArr) {
        Log.v(DEBUG_TAG, String.format(str, objArr));
    }

    public static String ensureNotNull(String str) {
        return str == null ? "" : str;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String escapeXml(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&#039;");
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static void fail(String str, Object... objArr) {
        Object format;
        if (objArr.length != 0) {
            format = String.format(str, objArr);
        }
        throw new AssertionError(format);
    }

    public static int floorLog2(float f) {
        int i = 0;
        while (i < 31 && ((float) (1 << i)) <= f) {
            i++;
        }
        return i - 1;
    }

    public static byte[] getBytes(String str) {
        int i = 0;
        byte[] bArr = new byte[(str.length() * 2)];
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            char c = toCharArray[i];
            int i3 = i2 + 1;
            bArr[i2] = (byte) (c & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) (c >> 8);
            i++;
        }
        return bArr;
    }

    public static String getUserAgent(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return String.format("%s/%s; %s/%s/%s/%s; %s/%s/%s", new Object[]{packageInfo.packageName, packageInfo.versionName, Build.BRAND, Build.DEVICE, Build.MODEL, Build.ID, Integer.valueOf(VERSION.SDK_INT), VERSION.RELEASE, VERSION.INCREMENTAL});
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("getPackageInfo failed");
        }
    }

    public static boolean handleInterrruptedException(Throwable th) {
        if (!(th instanceof InterruptedIOException) && !(th instanceof InterruptedException)) {
            return false;
        }
        Thread.currentThread().interrupt();
        return true;
    }

    public static float interpolateAngle(float f, float f2, float f3) {
        float f4 = f2 - f;
        if (f4 < 0.0f) {
            f4 += 360.0f;
        }
        if (f4 > 180.0f) {
            f4 -= 360.0f;
        }
        f4 = (f4 * f3) + f;
        return f4 < 0.0f ? f4 + 360.0f : f4;
    }

    public static float interpolateScale(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static boolean isNullOrEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isOpaque(int i) {
        return (i >>> 24) == 255;
    }

    public static String maskDebugInfo(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        return !IS_DEBUG_BUILD ? MASK_STRING.substring(0, Math.min(obj2.length(), MASK_STRING.length())) : obj2;
    }

    public static int nextPowerOf2(int i) {
        if (i <= 0 || i > 1073741824) {
            throw new IllegalArgumentException("n is invalid: " + i);
        }
        int i2 = i - 1;
        i2 |= i2 >> 16;
        i2 |= i2 >> 8;
        i2 |= i2 >> 4;
        i2 |= i2 >> 2;
        return (i2 | (i2 >> 1)) + 1;
    }

    public static float parseFloatSafely(String str, float f) {
        if (str != null) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    public static int parseIntSafely(String str, int i) {
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static int prevPowerOf2(int i) {
        if (i > 0) {
            return Integer.highestOneBit(i);
        }
        throw new IllegalArgumentException();
    }

    public static void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static void waitWithoutInterrupt(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            Log.w(TAG, "unexpected interrupt: " + obj);
        }
    }
}
