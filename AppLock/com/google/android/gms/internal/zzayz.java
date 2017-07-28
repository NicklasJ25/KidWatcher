package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class zzayz extends zza implements Comparable<zzayz> {
    public static final Creator<zzayz> CREATOR = new ei();
    private static final Charset f11842i = Charset.forName("UTF-8");
    public static final C3512a zzbBJ = new C3512a();
    public final String f11843a;
    final long f11844b;
    final boolean f11845c;
    final double f11846d;
    final String f11847e;
    final byte[] f11848f;
    public final int f11849g;
    public final int f11850h;

    public static class C3512a implements Comparator<zzayz> {
        public int m15356a(zzayz com_google_android_gms_internal_zzayz, zzayz com_google_android_gms_internal_zzayz2) {
            return com_google_android_gms_internal_zzayz.f11850h == com_google_android_gms_internal_zzayz2.f11850h ? com_google_android_gms_internal_zzayz.f11843a.compareTo(com_google_android_gms_internal_zzayz2.f11843a) : com_google_android_gms_internal_zzayz.f11850h - com_google_android_gms_internal_zzayz2.f11850h;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m15356a((zzayz) obj, (zzayz) obj2);
        }
    }

    public zzayz(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2) {
        this.f11843a = str;
        this.f11844b = j;
        this.f11845c = z;
        this.f11846d = d;
        this.f11847e = str2;
        this.f11848f = bArr;
        this.f11849g = i;
        this.f11850h = i2;
    }

    private static int m15357a(byte b, byte b2) {
        return b - b2;
    }

    private static int m15358a(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    private static int m15359a(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    private static int m15360a(String str, String str2) {
        return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : str.compareTo(str2);
    }

    private static int m15361a(boolean z, boolean z2) {
        return z == z2 ? 0 : z ? 1 : -1;
    }

    public int m15362a(zzayz com_google_android_gms_internal_zzayz) {
        int i = 0;
        int compareTo = this.f11843a.compareTo(com_google_android_gms_internal_zzayz.f11843a);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = m15358a(this.f11849g, com_google_android_gms_internal_zzayz.f11849g);
        if (compareTo != 0) {
            return compareTo;
        }
        switch (this.f11849g) {
            case 1:
                return m15359a(this.f11844b, com_google_android_gms_internal_zzayz.f11844b);
            case 2:
                return m15361a(this.f11845c, com_google_android_gms_internal_zzayz.f11845c);
            case 3:
                return Double.compare(this.f11846d, com_google_android_gms_internal_zzayz.f11846d);
            case 4:
                return m15360a(this.f11847e, com_google_android_gms_internal_zzayz.f11847e);
            case 5:
                if (this.f11848f == com_google_android_gms_internal_zzayz.f11848f) {
                    return 0;
                }
                if (this.f11848f == null) {
                    return -1;
                }
                if (com_google_android_gms_internal_zzayz.f11848f == null) {
                    return 1;
                }
                while (i < Math.min(this.f11848f.length, com_google_android_gms_internal_zzayz.f11848f.length)) {
                    compareTo = m15357a(this.f11848f[i], com_google_android_gms_internal_zzayz.f11848f[i]);
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    i++;
                }
                return m15358a(this.f11848f.length, com_google_android_gms_internal_zzayz.f11848f.length);
            default:
                throw new AssertionError("Invalid enum value: " + this.f11849g);
        }
    }

    public String m15363a(StringBuilder stringBuilder) {
        stringBuilder.append("Flag(");
        stringBuilder.append(this.f11843a);
        stringBuilder.append(", ");
        switch (this.f11849g) {
            case 1:
                stringBuilder.append(this.f11844b);
                break;
            case 2:
                stringBuilder.append(this.f11845c);
                break;
            case 3:
                stringBuilder.append(this.f11846d);
                break;
            case 4:
                stringBuilder.append("'");
                stringBuilder.append(this.f11847e);
                stringBuilder.append("'");
                break;
            case 5:
                if (this.f11848f != null) {
                    stringBuilder.append("'");
                    stringBuilder.append(new String(this.f11848f, f11842i));
                    stringBuilder.append("'");
                    break;
                }
                stringBuilder.append("null");
                break;
            default:
                String str = this.f11843a;
                throw new AssertionError(new StringBuilder(String.valueOf(str).length() + 27).append("Invalid type: ").append(str).append(", ").append(this.f11849g).toString());
        }
        stringBuilder.append(", ");
        stringBuilder.append(this.f11849g);
        stringBuilder.append(", ");
        stringBuilder.append(this.f11850h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m15362a((zzayz) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzayz)) {
            return false;
        }
        zzayz com_google_android_gms_internal_zzayz = (zzayz) obj;
        if (!C2512b.m7931a(this.f11843a, com_google_android_gms_internal_zzayz.f11843a) || this.f11849g != com_google_android_gms_internal_zzayz.f11849g || this.f11850h != com_google_android_gms_internal_zzayz.f11850h) {
            return false;
        }
        switch (this.f11849g) {
            case 1:
                return this.f11844b == com_google_android_gms_internal_zzayz.f11844b;
            case 2:
                return this.f11845c == com_google_android_gms_internal_zzayz.f11845c;
            case 3:
                return this.f11846d == com_google_android_gms_internal_zzayz.f11846d;
            case 4:
                return C2512b.m7931a(this.f11847e, com_google_android_gms_internal_zzayz.f11847e);
            case 5:
                return Arrays.equals(this.f11848f, com_google_android_gms_internal_zzayz.f11848f);
            default:
                throw new AssertionError("Invalid enum value: " + this.f11849g);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m15363a(stringBuilder);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ei.m10619a(this, parcel, i);
    }
}
