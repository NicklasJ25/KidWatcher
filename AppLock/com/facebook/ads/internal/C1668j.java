package com.facebook.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p018m.C1729s;
import java.util.Iterator;
import org.json.JSONObject;

public class C1668j {
    private static C1668j f4102a;
    private final SharedPreferences f4103b;

    public C1668j(Context context) {
        this.f4103b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    public static boolean m4718a(Context context) {
        return VERSION.SDK_INT >= 14 && C1729s.m4973a("com.google.android.exoplayer2", "ExoPlayer") && C1668j.m4732o(context).m4737a("adnw_enable_exoplayer", false);
    }

    public static boolean m4719b(Context context) {
        return C1668j.m4732o(context).m4737a("adnw_block_lockscreen", false);
    }

    public static boolean m4720c(Context context) {
        return C1668j.m4732o(context).m4737a("show_metadata_rewarded_video", false);
    }

    public static boolean m4721d(Context context) {
        return VERSION.SDK_INT >= 19 && C1668j.m4732o(context).m4737a("adnw_enable_iab", false);
    }

    public static boolean m4722e(Context context) {
        return C1668j.m4732o(context).m4737a("adnw_debug_logging", false);
    }

    public static long m4723f(Context context) {
        return C1668j.m4732o(context).m4734a("unified_logging_immediate_delay_ms", 500);
    }

    public static long m4724g(Context context) {
        return ((long) C1668j.m4732o(context).m4733a("unified_logging_dispatch_interval_seconds", 300)) * 1000;
    }

    public static int m4725h(Context context) {
        return C1668j.m4732o(context).m4733a("unified_logging_event_limit", -1);
    }

    public static boolean m4726i(Context context) {
        return C1668j.m4732o(context).m4735a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    public static boolean m4727j(Context context) {
        return C1668j.m4732o(context).m4737a("show_play_pause_rewarded_video", false);
    }

    public static int m4728k(Context context) {
        return C1668j.m4732o(context).m4733a("minimum_elapsed_time_after_impression", -1);
    }

    public static int m4729l(Context context) {
        return C1668j.m4732o(context).m4733a("ad_viewability_tap_margin", 0);
    }

    public static boolean m4730m(Context context) {
        return C1668j.m4732o(context).m4737a("visible_area_check_enabled", false);
    }

    public static int m4731n(Context context) {
        return C1668j.m4732o(context).m4733a("visible_area_percentage", 50);
    }

    private static C1668j m4732o(Context context) {
        if (f4102a == null) {
            synchronized (C1668j.class) {
                if (f4102a == null) {
                    f4102a = new C1668j(context);
                }
            }
        }
        return f4102a;
    }

    public int m4733a(String str, int i) {
        String string = this.f4103b.getString(str, String.valueOf(i));
        return (string == null || string.equals("null")) ? i : Integer.valueOf(string).intValue();
    }

    public long m4734a(String str, long j) {
        String string = this.f4103b.getString(str, String.valueOf(j));
        return (string == null || string.equals("null")) ? j : Long.valueOf(string).longValue();
    }

    @Nullable
    public String m4735a(String str, String str2) {
        String string = this.f4103b.getString(str, str2);
        return (string == null || string.equals("null")) ? str2 : string;
    }

    public void m4736a(@Nullable String str) {
        if (str != null && !str.isEmpty() && !str.equals("[]")) {
            Editor edit = this.f4103b.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                edit.putString(str2, jSONObject.getString(str2));
            }
            edit.commit();
        }
    }

    public boolean m4737a(String str, boolean z) {
        String string = this.f4103b.getString(str, String.valueOf(z));
        return (string == null || string.equals("null")) ? z : Boolean.valueOf(string).booleanValue();
    }
}
