package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p018m.C1686a;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1729s.C1728a;
import com.facebook.ads.internal.p018m.ae;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class C1462f {
    static volatile boolean f3385a = false;
    private static final String f3386b = C1462f.class.getSimpleName();
    private static final Collection<String> f3387c = new HashSet();
    private static final Collection<String> f3388d = new HashSet();
    private static String f3389e;
    private static boolean f3390f;
    private static boolean f3391g;
    private static String f3392h;
    private static boolean f3393i;
    private static String f3394j;
    private static C1461a f3395k = C1461a.DEFAULT;

    public enum C1461a {
        DEFAULT("DEFAULT"),
        IMG_16_9_APP_INSTALL("IMG_16_9_APP_INSTALL"),
        IMG_16_9_LINK("IMG_16_9_LINK"),
        VIDEO_HD_16_9_46S_APP_INSTALL("VID_HD_16_9_46S_APP_INSTALL"),
        VIDEO_HD_16_9_46S_LINK("VID_HD_16_9_46S_LINK"),
        VIDEO_HD_16_9_15S_APP_INSTALL("VID_HD_16_9_15S_APP_INSTALL"),
        VIDEO_HD_16_9_15S_LINK("VID_HD_16_9_15S_LINK"),
        VIDEO_HD_9_16_39S_APP_INSTALL("VID_HD_9_16_39S_APP_INSTALL"),
        VIDEO_HD_9_16_39S_LINK("VID_HD_9_16_39S_LINK"),
        CAROUSEL_IMG_SQUARE_APP_INSTALL("CAROUSEL_IMG_SQUARE_APP_INSTALL"),
        CAROUSEL_IMG_SQUARE_LINK("CAROUSEL_IMG_SQUARE_LINK");
        
        private final String f3384l;

        private C1461a(String str) {
            this.f3384l = str;
        }

        public String m3758a() {
            return this.f3384l;
        }
    }

    static {
        f3388d.add("sdk");
        f3388d.add("google_sdk");
        f3388d.add("vbox86p");
        f3388d.add("vbox86tp");
    }

    public static String m3759a() {
        return f3389e;
    }

    private static void m3760a(String str) {
        if (!f3385a) {
            f3385a = true;
            Log.d(f3386b, "Test mode device hash: " + str);
            Log.d(f3386b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
    }

    public static boolean m3761a(Context context) {
        if (C1686a.f4183a || f3388d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f3394j == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            f3394j = sharedPreferences.getString("deviceIdHash", null);
            if (TextUtils.isEmpty(f3394j)) {
                C1728a a = C1729s.m4958a(context.getContentResolver());
                if (!TextUtils.isEmpty(a.f4353b)) {
                    f3394j = ae.m4814a(a.f4353b);
                } else if (TextUtils.isEmpty(a.f4352a)) {
                    f3394j = ae.m4814a(UUID.randomUUID().toString());
                } else {
                    f3394j = ae.m4814a(a.f4352a);
                }
                sharedPreferences.edit().putString("deviceIdHash", f3394j).apply();
            }
        }
        if (f3387c.contains(f3394j)) {
            return true;
        }
        C1462f.m3760a(f3394j);
        return false;
    }

    public static boolean m3762b() {
        return f3390f;
    }

    public static boolean m3763c() {
        return f3391g;
    }

    public static String m3764d() {
        return f3392h;
    }

    public static boolean m3765e() {
        return f3393i;
    }

    public static C1461a m3766f() {
        return f3395k;
    }
}
