package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.abq.C2670c;
import com.google.android.gms.internal.mf.C3053d;
import java.util.Arrays;

public class zzzm extends zza {
    public static final Creator<zzzm> CREATOR = new abs();
    public zzzu f12086a;
    public byte[] f12087b;
    public int[] f12088c;
    public String[] f12089d;
    public int[] f12090e;
    public byte[][] f12091f;
    public boolean f12092g;
    public final C3053d f12093h;
    public final C2670c f12094i;
    public final C2670c f12095j;

    public zzzm(zzzu com_google_android_gms_internal_zzzu, C3053d c3053d, C2670c c2670c, C2670c c2670c2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.f12086a = com_google_android_gms_internal_zzzu;
        this.f12093h = c3053d;
        this.f12094i = c2670c;
        this.f12095j = c2670c2;
        this.f12088c = iArr;
        this.f12089d = strArr;
        this.f12090e = iArr2;
        this.f12091f = bArr;
        this.f12092g = z;
    }

    zzzm(zzzu com_google_android_gms_internal_zzzu, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.f12086a = com_google_android_gms_internal_zzzu;
        this.f12087b = bArr;
        this.f12088c = iArr;
        this.f12089d = strArr;
        this.f12093h = null;
        this.f12094i = null;
        this.f12095j = null;
        this.f12090e = iArr2;
        this.f12091f = bArr2;
        this.f12092g = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzm)) {
            return false;
        }
        zzzm com_google_android_gms_internal_zzzm = (zzzm) obj;
        return C2512b.m7931a(this.f12086a, com_google_android_gms_internal_zzzm.f12086a) && Arrays.equals(this.f12087b, com_google_android_gms_internal_zzzm.f12087b) && Arrays.equals(this.f12088c, com_google_android_gms_internal_zzzm.f12088c) && Arrays.equals(this.f12089d, com_google_android_gms_internal_zzzm.f12089d) && C2512b.m7931a(this.f12093h, com_google_android_gms_internal_zzzm.f12093h) && C2512b.m7931a(this.f12094i, com_google_android_gms_internal_zzzm.f12094i) && C2512b.m7931a(this.f12095j, com_google_android_gms_internal_zzzm.f12095j) && Arrays.equals(this.f12090e, com_google_android_gms_internal_zzzm.f12090e) && Arrays.deepEquals(this.f12091f, com_google_android_gms_internal_zzzm.f12091f) && this.f12092g == com_google_android_gms_internal_zzzm.f12092g;
    }

    public int hashCode() {
        return C2512b.m7929a(this.f12086a, this.f12087b, this.f12088c, this.f12089d, this.f12093h, this.f12094i, this.f12095j, this.f12090e, this.f12091f, Boolean.valueOf(this.f12092g));
    }

    public String toString() {
        return "LogEventParcelable[" + this.f12086a + ", " + "LogEventBytes: " + (this.f12087b == null ? null : new String(this.f12087b)) + ", " + "TestCodes: " + Arrays.toString(this.f12088c) + ", " + "MendelPackages: " + Arrays.toString(this.f12089d) + ", " + "LogEvent: " + this.f12093h + ", " + "ExtensionProducer: " + this.f12094i + ", " + "VeProducer: " + this.f12095j + ", " + "ExperimentIDs: " + Arrays.toString(this.f12090e) + ", " + "ExperimentTokens: " + Arrays.toString(this.f12091f) + ", " + "AddPhenotypeExperimentTokens: " + this.f12092g + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        abs.m8837a(this, parcel, i);
    }
}
