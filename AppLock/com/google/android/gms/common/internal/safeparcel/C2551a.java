package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class C2551a {

    public static class C2550a extends RuntimeException {
        public C2550a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static ArrayList<String> m8091A(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m8092B(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m8093C(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    public static int m8094a(int i) {
        return SupportMenu.USER_MASK & i;
    }

    public static int m8095a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m8096a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    public static <T extends Parcelable> T m8097a(Parcel parcel, int i, Creator<T> creator) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m8098a(Parcel parcel, int i, int i2) {
        int a = C2551a.m8096a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C2550a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m8099a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new C2550a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static int m8100b(Parcel parcel) {
        int a = C2551a.m8095a(parcel);
        int a2 = C2551a.m8096a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C2551a.m8094a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C2550a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C2550a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m8101b(Parcel parcel, int i) {
        parcel.setDataPosition(C2551a.m8096a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m8102b(Parcel parcel, int i, Creator<T> creator) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m8103c(Parcel parcel, int i, Creator<T> creator) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m8104c(Parcel parcel, int i) {
        C2551a.m8098a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m8105d(Parcel parcel, int i) {
        C2551a.m8098a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m8106e(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2551a.m8099a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m8107f(Parcel parcel, int i) {
        C2551a.m8098a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m8108g(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2551a.m8099a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger m8109h(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m8110i(Parcel parcel, int i) {
        C2551a.m8098a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m8111j(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2551a.m8099a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double m8112k(Parcel parcel, int i) {
        C2551a.m8098a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double m8113l(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2551a.m8099a(parcel, i, a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static BigDecimal m8114m(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m8115n(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m8116o(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m8117p(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m8118q(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static byte[][] m8119r(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    public static boolean[] m8120s(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m8121t(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m8122u(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m8123v(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m8124w(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m8125x(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m8126y(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m8127z(Parcel parcel, int i) {
        int a = C2551a.m8096a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }
}
