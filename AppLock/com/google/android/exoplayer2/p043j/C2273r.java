package com.google.android.exoplayer2.p043j;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public final class C2273r {
    public static final int f6478a;
    public static final String f6479b = Build.DEVICE;
    public static final String f6480c = Build.MANUFACTURER;
    public static final String f6481d = Build.MODEL;
    private static final Pattern f6482e = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern f6483f = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern f6484g = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final char[] f6485h = "0123456789ABCDEF".toCharArray();
    private static final int[] f6486i = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    static {
        int i = (VERSION.SDK_INT == 23 && VERSION.CODENAME.charAt(0) == 'N') ? 24 : VERSION.SDK_INT;
        f6478a = i;
    }

    public static int m7124a(int i) {
        switch (i) {
            case 8:
                return 3;
            case 16:
                return 2;
            case 24:
                return Integer.MIN_VALUE;
            case 32:
                return 1073741824;
            default:
                return 0;
        }
    }

    public static int m7125a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int m7126a(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = (i3 << 8) ^ f6486i[((i3 >>> 24) ^ (bArr[i] & 255)) & 255];
            i++;
        }
        return i3;
    }

    public static int m7127a(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }

    public static long m7128a(long j, long j2, long j3) {
        return (j3 < j2 || j3 % j2 != 0) ? (j3 >= j2 || j2 % j3 != 0) ? (long) ((((double) j2) / ((double) j3)) * ((double) j)) : (j2 / j3) * j : j / (j3 / j2);
    }

    public static String m7129a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + VERSION.RELEASE + ") ExoPlayerLib/" + "2.0.3";
    }

    public static String m7130a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[(bArr.length * 2)];
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f6485h[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f6485h[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static String m7131a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            stringBuilder.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public static ExecutorService m7132a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    public static void m7133a(long[] jArr, long j, long j2) {
        int i = 0;
        long j3;
        if (j2 >= j && j2 % j == 0) {
            j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = ((double) j) / ((double) j2);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) jArr[i]) * d);
                i++;
            }
        } else {
            j3 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j3;
                i++;
            }
        }
    }

    public static boolean m7134a(Uri uri) {
        Object scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || scheme.equals("file");
    }

    public static boolean m7135a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int[] m7136a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    public static int m7137b(int i) {
        switch (i) {
            case 0:
                return 16777216;
            case 1:
                return 3538944;
            case 2:
                return 13107200;
            case 3:
            case 4:
                return 131072;
            default:
                throw new IllegalStateException();
        }
    }

    public static int m7138b(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        } else if (!z) {
            binarySearch++;
        }
        return z2 ? Math.min(jArr.length - 1, binarySearch) : binarySearch;
    }

    public static String m7139b(String str) {
        return str == null ? null : new Locale(str).getLanguage();
    }

    public static byte[] m7140c(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static String m7141d(String str) {
        return str == null ? null : str.toLowerCase(Locale.US);
    }

    public static int m7142e(String str) {
        int i = 0;
        int length = str.length();
        C2252a.m7022a(length <= 4);
        int i2 = 0;
        while (i < length) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static byte[] m7143f(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        return bArr;
    }

    public static String m7144g(String str) {
        Throwable e;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return C2273r.m7130a(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }
}
