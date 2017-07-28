package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.zza;

@wh
public class zzeg extends zza {
    public static final Creator<zzeg> CREATOR = new oh();
    public final String f11895a;
    public final int f11896b;
    public final int f11897c;
    public final boolean f11898d;
    public final int f11899e;
    public final int f11900f;
    public final zzeg[] f11901g;
    public final boolean f11902h;
    public final boolean f11903i;
    public boolean f11904j;

    public zzeg() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzeg(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public zzeg(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        AdSize adSize = adSizeArr[0];
        this.f11898d = false;
        this.f11903i = adSize.isFluid();
        if (this.f11903i) {
            this.f11899e = AdSize.BANNER.getWidth();
            this.f11896b = AdSize.BANNER.getHeight();
        } else {
            this.f11899e = adSize.getWidth();
            this.f11896b = adSize.getHeight();
        }
        boolean z = this.f11899e == -1;
        boolean z2 = this.f11896b == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (ol.m12979a().m8416e(context) && ol.m12979a().m8417f(context)) {
                this.f11900f = m15381a(displayMetrics) - ol.m12979a().m8418g(context);
            } else {
                this.f11900f = m15381a(displayMetrics);
            }
            double d = (double) (((float) this.f11900f) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f11899e;
            this.f11900f = ol.m12979a().m8399a(displayMetrics, this.f11899e);
            i2 = i;
        }
        i = z2 ? m15385c(displayMetrics) : this.f11896b;
        this.f11897c = ol.m12979a().m8399a(displayMetrics, i);
        if (z || z2) {
            this.f11895a = i2 + "x" + i + "_as";
        } else if (this.f11903i) {
            this.f11895a = "320x50_mb";
        } else {
            this.f11895a = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.f11901g = new zzeg[adSizeArr.length];
            for (int i3 = 0; i3 < adSizeArr.length; i3++) {
                this.f11901g[i3] = new zzeg(context, adSizeArr[i3]);
            }
        } else {
            this.f11901g = null;
        }
        this.f11902h = false;
        this.f11904j = false;
    }

    public zzeg(zzeg com_google_android_gms_internal_zzeg, zzeg[] com_google_android_gms_internal_zzegArr) {
        this(com_google_android_gms_internal_zzeg.f11895a, com_google_android_gms_internal_zzeg.f11896b, com_google_android_gms_internal_zzeg.f11897c, com_google_android_gms_internal_zzeg.f11898d, com_google_android_gms_internal_zzeg.f11899e, com_google_android_gms_internal_zzeg.f11900f, com_google_android_gms_internal_zzegArr, com_google_android_gms_internal_zzeg.f11902h, com_google_android_gms_internal_zzeg.f11903i, com_google_android_gms_internal_zzeg.f11904j);
    }

    zzeg(String str, int i, int i2, boolean z, int i3, int i4, zzeg[] com_google_android_gms_internal_zzegArr, boolean z2, boolean z3, boolean z4) {
        this.f11895a = str;
        this.f11896b = i;
        this.f11897c = i2;
        this.f11898d = z;
        this.f11899e = i3;
        this.f11900f = i4;
        this.f11901g = com_google_android_gms_internal_zzegArr;
        this.f11902h = z2;
        this.f11903i = z3;
        this.f11904j = z4;
    }

    public static int m15381a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static zzeg m15382a() {
        return new zzeg("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static zzeg m15383a(Context context) {
        return new zzeg("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int m15384b(DisplayMetrics displayMetrics) {
        return (int) (((float) m15385c(displayMetrics)) * displayMetrics.density);
    }

    private static int m15385c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public void m15386a(boolean z) {
        this.f11904j = z;
    }

    public AdSize m15387b() {
        return com.google.android.gms.ads.zza.zza(this.f11899e, this.f11896b, this.f11895a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        oh.m12907a(this, parcel, i);
    }
}
