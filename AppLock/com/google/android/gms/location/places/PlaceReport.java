package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2512b.C2511a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class PlaceReport extends zza implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new C3515a();
    final int f12105a;
    private final String f12106b;
    private final String f12107c;
    private final String f12108d;

    PlaceReport(int i, String str, String str2, String str3) {
        this.f12105a = i;
        this.f12106b = str;
        this.f12107c = str2;
        this.f12108d = str3;
    }

    public String m15398a() {
        return this.f12106b;
    }

    public String m15399b() {
        return this.f12107c;
    }

    public String m15400c() {
        return this.f12108d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return C2512b.m7931a(this.f12106b, placeReport.f12106b) && C2512b.m7931a(this.f12107c, placeReport.f12107c) && C2512b.m7931a(this.f12108d, placeReport.f12108d);
    }

    public int hashCode() {
        return C2512b.m7929a(this.f12106b, this.f12107c, this.f12108d);
    }

    public String toString() {
        C2511a a = C2512b.m7930a((Object) this);
        a.m7928a("placeId", this.f12106b);
        a.m7928a("tag", this.f12107c);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.f12108d)) {
            a.m7928a("source", this.f12108d);
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3515a.m15401a(this, parcel, i);
    }
}
