package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2583h;
import java.util.Locale;

@wh
public final class xg {
    public final int f11394a;
    public final boolean f11395b;
    public final boolean f11396c;
    public final String f11397d;
    public final String f11398e;
    public final boolean f11399f;
    public final boolean f11400g;
    public final boolean f11401h;
    public final boolean f11402i;
    public final String f11403j;
    public final String f11404k;
    public final int f11405l;
    public final int f11406m;
    public final int f11407n;
    public final int f11408o;
    public final int f11409p;
    public final int f11410q;
    public final float f11411r;
    public final int f11412s;
    public final int f11413t;
    public final double f11414u;
    public final boolean f11415v;
    public final boolean f11416w;
    public final int f11417x;
    public final String f11418y;
    public final boolean f11419z;

    public static final class C3435a {
        private int f11368a;
        private boolean f11369b;
        private boolean f11370c;
        private int f11371d;
        private int f11372e;
        private int f11373f;
        private String f11374g;
        private int f11375h;
        private int f11376i;
        private int f11377j;
        private boolean f11378k;
        private int f11379l;
        private double f11380m;
        private boolean f11381n;
        private String f11382o;
        private boolean f11383p;
        private boolean f11384q;
        private String f11385r;
        private boolean f11386s;
        private boolean f11387t;
        private String f11388u;
        private String f11389v;
        private float f11390w;
        private int f11391x;
        private int f11392y;
        private boolean f11393z;

        public C3435a(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            m14759a(context);
            m14760b(context);
            m14761c(context);
            Locale locale = Locale.getDefault();
            this.f11383p = C3435a.m14757a(packageManager, "geo:0,0?q=donuts") != null;
            if (C3435a.m14757a(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.f11384q = z;
            this.f11385r = locale.getCountry();
            this.f11386s = ol.m12979a().m8409a();
            this.f11387t = C2583h.m8295c(context);
            this.f11388u = locale.getLanguage();
            this.f11389v = C3435a.m14758a(context, packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.f11390w = displayMetrics.density;
                    this.f11391x = displayMetrics.widthPixels;
                    this.f11392y = displayMetrics.heightPixels;
                }
            }
        }

        public C3435a(Context context, xg xgVar) {
            context.getPackageManager();
            m14759a(context);
            m14760b(context);
            m14761c(context);
            m14762d(context);
            this.f11383p = xgVar.f11395b;
            this.f11384q = xgVar.f11396c;
            this.f11385r = xgVar.f11398e;
            this.f11386s = xgVar.f11399f;
            this.f11387t = xgVar.f11400g;
            this.f11388u = xgVar.f11403j;
            this.f11389v = xgVar.f11404k;
            this.f11390w = xgVar.f11411r;
            this.f11391x = xgVar.f11412s;
            this.f11392y = xgVar.f11413t;
        }

        private static ResolveInfo m14757a(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String m14758a(Context context, PackageManager packageManager) {
            String str = null;
            ResolveInfo a = C3435a.m14757a(packageManager, "market://details?id=com.google.android.gms.ads");
            if (a != null) {
                ActivityInfo activityInfo = a.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo b = bm.m9120b(context).m9118b(activityInfo.packageName, 0);
                        if (b != null) {
                            int i = b.versionCode;
                            String valueOf = String.valueOf(activityInfo.packageName);
                            str = new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void m14759a(Context context) {
            AudioManager i = zzw.zzcM().m15161i(context);
            if (i != null) {
                try {
                    this.f11368a = i.getMode();
                    this.f11369b = i.isMusicActive();
                    this.f11370c = i.isSpeakerphoneOn();
                    this.f11371d = i.getStreamVolume(3);
                    this.f11372e = i.getRingerMode();
                    this.f11373f = i.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    zzw.zzcQ().m15000a(th, "DeviceInfo.gatherAudioInfo");
                }
            }
            this.f11368a = -2;
            this.f11369b = false;
            this.f11370c = false;
            this.f11371d = 0;
            this.f11372e = 0;
            this.f11373f = 0;
        }

        @TargetApi(16)
        private void m14760b(Context context) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f11374g = telephonyManager.getNetworkOperator();
            this.f11376i = telephonyManager.getNetworkType();
            this.f11377j = telephonyManager.getPhoneType();
            this.f11375h = -2;
            this.f11378k = false;
            this.f11379l = -1;
            if (zzw.zzcM().m15131a(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f11375h = activeNetworkInfo.getType();
                    this.f11379l = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.f11375h = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.f11378k = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void m14761c(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.f11380m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.f11381n = z;
                return;
            }
            this.f11380m = -1.0d;
            this.f11381n = false;
        }

        private void m14762d(Context context) {
            this.f11382o = Build.FINGERPRINT;
            this.f11393z = qp.m13332a(context);
        }

        public xg m14763a() {
            return new xg(this.f11368a, this.f11383p, this.f11384q, this.f11374g, this.f11385r, this.f11386s, this.f11387t, this.f11369b, this.f11370c, this.f11388u, this.f11389v, this.f11371d, this.f11375h, this.f11376i, this.f11377j, this.f11372e, this.f11373f, this.f11390w, this.f11391x, this.f11392y, this.f11380m, this.f11381n, this.f11378k, this.f11379l, this.f11382o, this.f11393z);
        }
    }

    xg(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.f11394a = i;
        this.f11395b = z;
        this.f11396c = z2;
        this.f11397d = str;
        this.f11398e = str2;
        this.f11399f = z3;
        this.f11400g = z4;
        this.f11401h = z5;
        this.f11402i = z6;
        this.f11403j = str3;
        this.f11404k = str4;
        this.f11405l = i2;
        this.f11406m = i3;
        this.f11407n = i4;
        this.f11408o = i5;
        this.f11409p = i6;
        this.f11410q = i7;
        this.f11411r = f;
        this.f11412s = i8;
        this.f11413t = i9;
        this.f11414u = d;
        this.f11415v = z7;
        this.f11416w = z8;
        this.f11417x = i10;
        this.f11418y = str5;
        this.f11419z = z9;
    }
}
