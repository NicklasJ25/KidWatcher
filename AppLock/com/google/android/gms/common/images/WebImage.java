package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Locale;

public final class WebImage extends zza {
    public static final Creator<WebImage> CREATOR = new C2501b();
    final int f7375a;
    private final Uri f7376b;
    private final int f7377c;
    private final int f7378d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f7375a = i;
        this.f7376b = uri;
        this.f7377c = i2;
        this.f7378d = i3;
    }

    public Uri m7896a() {
        return this.f7376b;
    }

    public int m7897b() {
        return this.f7377c;
    }

    public int m7898c() {
        return this.f7378d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return C2512b.m7931a(this.f7376b, webImage.f7376b) && this.f7377c == webImage.f7377c && this.f7378d == webImage.f7378d;
    }

    public int hashCode() {
        return C2512b.m7929a(this.f7376b, Integer.valueOf(this.f7377c), Integer.valueOf(this.f7378d));
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f7377c), Integer.valueOf(this.f7378d), this.f7376b.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2501b.m7904a(this, parcel, i);
    }
}
