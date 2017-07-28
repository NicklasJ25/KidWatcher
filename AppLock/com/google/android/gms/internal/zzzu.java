package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzzu extends zza {
    public static final Creator<zzzu> CREATOR = new abz();
    public final String f12096a;
    public final int f12097b;
    public final int f12098c;
    public final String f12099d;
    public final String f12100e;
    public final boolean f12101f;
    public final String f12102g;
    public final boolean f12103h;
    public final int f12104i;

    public zzzu(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.f12096a = (String) C2513c.m7932a((Object) str);
        this.f12097b = i;
        this.f12098c = i2;
        this.f12102g = str2;
        this.f12099d = str3;
        this.f12100e = str4;
        this.f12101f = !z;
        this.f12103h = z;
        this.f12104i = i3;
    }

    public zzzu(String str, int i, int i2, String str2, String str3, boolean z, String str4, boolean z2, int i3) {
        this.f12096a = str;
        this.f12097b = i;
        this.f12098c = i2;
        this.f12099d = str2;
        this.f12100e = str3;
        this.f12101f = z;
        this.f12102g = str4;
        this.f12103h = z2;
        this.f12104i = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzu)) {
            return false;
        }
        zzzu com_google_android_gms_internal_zzzu = (zzzu) obj;
        return this.f12096a.equals(com_google_android_gms_internal_zzzu.f12096a) && this.f12097b == com_google_android_gms_internal_zzzu.f12097b && this.f12098c == com_google_android_gms_internal_zzzu.f12098c && C2512b.m7931a(this.f12102g, com_google_android_gms_internal_zzzu.f12102g) && C2512b.m7931a(this.f12099d, com_google_android_gms_internal_zzzu.f12099d) && C2512b.m7931a(this.f12100e, com_google_android_gms_internal_zzzu.f12100e) && this.f12101f == com_google_android_gms_internal_zzzu.f12101f && this.f12103h == com_google_android_gms_internal_zzzu.f12103h && this.f12104i == com_google_android_gms_internal_zzzu.f12104i;
    }

    public int hashCode() {
        return C2512b.m7929a(this.f12096a, Integer.valueOf(this.f12097b), Integer.valueOf(this.f12098c), this.f12102g, this.f12099d, this.f12100e, Boolean.valueOf(this.f12101f), Boolean.valueOf(this.f12103h), Integer.valueOf(this.f12104i));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("package=").append(this.f12096a).append(',');
        stringBuilder.append("packageVersionCode=").append(this.f12097b).append(',');
        stringBuilder.append("logSource=").append(this.f12098c).append(',');
        stringBuilder.append("logSourceName=").append(this.f12102g).append(',');
        stringBuilder.append("uploadAccount=").append(this.f12099d).append(',');
        stringBuilder.append("loggingId=").append(this.f12100e).append(',');
        stringBuilder.append("logAndroidId=").append(this.f12101f).append(',');
        stringBuilder.append("isAnonymous=").append(this.f12103h).append(',');
        stringBuilder.append("qosTier=").append(this.f12104i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        abz.m8921a(this, parcel, i);
    }
}
