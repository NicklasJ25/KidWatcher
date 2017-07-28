package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

public class C2552b {
    public static int m8128a(Parcel parcel) {
        return C2552b.m8151b(parcel, 20293);
    }

    public static void m8129a(Parcel parcel, int i) {
        C2552b.m8154c(parcel, i);
    }

    public static void m8130a(Parcel parcel, int i, double d) {
        C2552b.m8152b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m8131a(Parcel parcel, int i, float f) {
        C2552b.m8152b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m8132a(Parcel parcel, int i, int i2) {
        C2552b.m8152b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m8133a(Parcel parcel, int i, long j) {
        C2552b.m8152b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m8134a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeBundle(bundle);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8135a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8136a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8137a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C2552b.m8151b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8138a(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            C2552b.m8152b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8139a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            C2552b.m8152b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8140a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C2552b.m8152b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8141a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C2552b.m8152b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8142a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeString(str);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8143a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeStringList(list);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8144a(Parcel parcel, int i, boolean z) {
        C2552b.m8152b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m8145a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeByteArray(bArr);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8146a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeIntArray(iArr);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m8147a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C2552b.m8150a(parcel, parcelable, i2);
                }
            }
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8148a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C2552b.m8151b(parcel, i);
            parcel.writeStringArray(strArr);
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    public static void m8149a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int b = C2552b.m8151b(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m8150a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m8151b(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m8152b(Parcel parcel, int i, int i2) {
        if (i2 >= SupportMenu.USER_MASK) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m8153b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C2552b.m8151b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C2552b.m8150a(parcel, parcelable, 0);
                }
            }
            C2552b.m8154c(parcel, b);
        } else if (z) {
            C2552b.m8152b(parcel, i, 0);
        }
    }

    private static void m8154c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
