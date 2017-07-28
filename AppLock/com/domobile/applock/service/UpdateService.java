package com.domobile.applock.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.eframe.C1228f;
import com.domobile.eframe.C1230g;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1258c;
import com.domobile.libs_ads.C1342b;
import com.domobile.widget.UnlockGiftView;
import java.io.File;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateService extends Service {
    public static final boolean f2005a = (C1150y.O < 17);
    private int f2006b = 0;

    private class C1068a extends AsyncTask<Object, Integer, Object> {
        final /* synthetic */ UpdateService f1998a;
        private Context f1999b;
        private JSONObject f2000c;

        public C1068a(UpdateService updateService, Context context, JSONObject jSONObject) {
            this.f1998a = updateService;
            this.f1999b = context;
            this.f2000c = jSONObject;
        }

        protected Object doInBackground(Object... objArr) {
            if (!(this.f2000c == null || TextUtils.isEmpty(this.f2000c.optString("content_icon")))) {
                C1277a.m3060b(this.f2000c.optString("content_icon"));
            }
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            C1228f.m2882a(this.f1999b, this.f2000c);
            C1230g.m2896a(this.f1999b, "push_message_loaded_url", C1230g.m2892a(this.f1999b, "push_message_url"));
            this.f1998a.m2265a();
        }
    }

    public class C1069b implements C0607f {
        final /* synthetic */ UpdateService f2001a;
        private Context f2002b;
        private String f2003c;

        public C1069b(UpdateService updateService, Context context, String str) {
            this.f2001a = updateService;
            this.f2002b = context;
            this.f2003c = str;
        }

        public C1275d mo2363a() {
            this.f2001a.f2006b = this.f2001a.f2006b + 1;
            C1275d c1275d = new C1275d(this.f2003c);
            c1275d.f2625c = "GET";
            c1275d.f2624b = "utf-8";
            return c1275d;
        }

        public void mo2364a(String str) {
            if ("500".equals(str) || "404".equals(str)) {
                if (this.f2001a.f2006b < 2) {
                    try {
                        this.f2001a.m2271a(String.format(C1230g.m2892a(this.f2002b, "push_message_url"), new Object[]{"values"}));
                        return;
                    } catch (Exception e) {
                    }
                }
                this.f2001a.m2265a();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                C1230g.m2897a("push_json_cache", str);
                if (TextUtils.isEmpty(jSONObject.optString("content_icon"))) {
                    C1228f.m2882a(this.f2002b, jSONObject);
                    C1230g.m2896a(this.f2002b, "push_message_loaded_url", C1230g.m2892a(this.f2002b, "push_message_url"));
                    this.f2001a.m2265a();
                    return;
                }
                this.f2001a.m2272a(jSONObject);
            } catch (Exception e2) {
                this.f2001a.m2265a();
            }
        }
    }

    public static class C1070c implements C0607f {
        private Context f2004a;

        public C1070c(Context context) {
            this.f2004a = context;
        }

        private Object m2260a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("version_control");
                if (optJSONObject.has(str4)) {
                    optJSONObject = optJSONObject.optJSONObject(str4);
                    if (optJSONObject.has(str)) {
                        return optJSONObject.opt(str);
                    }
                    if (optJSONObject.has(str3)) {
                        return optJSONObject.opt(str3);
                    }
                    if (optJSONObject.has(str2)) {
                        return optJSONObject.opt(str2);
                    }
                }
            } catch (Exception e) {
            }
            return jSONObject.opt(str4);
        }

        private void m2261a(Context context) {
            if (!C1342b.m3329a(context, "trial_day_server")) {
                C1342b.m3326a(context, "trial_day_server", Integer.valueOf(0));
            }
            if (!C1342b.m3329a(context, "user_default_adtype")) {
                C1342b.m3326a(context, "user_default_adtype", Integer.valueOf(2));
                if (!C1342b.m3329a(context, "is_user_adtype_banner")) {
                    C1342b.m3326a(context, "is_user_adtype_banner", Boolean.valueOf(C1150y.m2648p(context)));
                }
            }
        }

        public C1275d mo2363a() {
            String str = "";
            try {
                str = C1150y.m2572a(this.f2004a, "THEME_PICKER_DOMAIN_SUFFIX", (Object) "").toString();
            } catch (Exception e) {
            }
            return new C1275d(C1147a.m2480a("https://www.domobile.com/", "apps/version/", this.f2004a.getPackageName(), str, ".json"));
        }

        public void mo2364a(String str) {
            Object obj;
            Exception e;
            Object obj2;
            Throwable th;
            Error e2;
            Object obj3 = 1;
            try {
                JSONObject optJSONObject;
                int optInt;
                Object obj4;
                int optInt2;
                Object optString;
                Intent intent;
                String str2;
                int i;
                JSONObject jSONObject = new JSONObject(str);
                CharSequence optString2 = jSONObject.optString("key_server_hider_folder");
                if (!optString2.startsWith(".")) {
                    optString2 = C1147a.m2480a(".", optString2);
                }
                CharSequence b = C1150y.m2602b(this.f2004a, "key_server_hider_folder");
                if (!(TextUtils.isEmpty(optString2) || TextUtils.equals(b, optString2))) {
                    C1148d.m2520b(this.f2004a, "key_server_hider_folder", (Object) optString2);
                }
                C1148d.m2520b(this.f2004a, "enable_power_saving_warning_type", (Object) Integer.valueOf(jSONObject.optInt("enable_power_saving_warning_type", 2)));
                UpdateService.m2277b(this.f2004a, jSONObject);
                if (jSONObject.has("gift_trial_day_switch")) {
                    C1342b.m3326a(this.f2004a, "gift_trial_day_switch", Boolean.valueOf(jSONObject.optInt("gift_trial_day_switch") == 1));
                }
                UpdateService.m2278b(jSONObject, this.f2004a);
                C1148d.m2520b(this.f2004a, "using_ga_tracking_id", (Object) jSONObject.optString("using_ga_tracking_id", "4"));
                C1148d.m2520b(this.f2004a, "auto_load_promts", (Object) Boolean.valueOf(jSONObject.optInt("auto_load_promts") == 1));
                if (jSONObject.has("our_ad")) {
                    optJSONObject = jSONObject.optJSONObject("our_ad");
                    if (!(optJSONObject == null || TextUtils.isEmpty(optJSONObject.toString()))) {
                        C1148d.m2518a(optJSONObject.toString(), new File(this.f2004a.getFilesDir(), "domobile_custom_ad").getAbsolutePath());
                    }
                }
                long ad = (long) C1148d.ad(this.f2004a);
                String a = C1147a.m2480a("*_", Integer.valueOf(C1150y.O));
                String a2 = C1147a.m2480a(Long.valueOf(ad), "_*");
                String a3 = C1147a.m2480a(Long.valueOf(ad), "_", Integer.valueOf(C1150y.O));
                C1150y b2 = C1150y.m2598b(this.f2004a);
                if (jSONObject.has("preload_interstitial_ads")) {
                    b2.f2230o = ((Integer) m2260a(jSONObject, a3, a, a2, "preload_interstitial_ads")).intValue() == 0;
                    C1342b.m3326a(this.f2004a, "preload_interstitial_ads", Boolean.valueOf(b2.f2230o));
                    if (jSONObject.has("preload_ads_when_show_unlock")) {
                        b2.f2231p = jSONObject.optInt("preload_ads_when_show_unlock") == 1;
                        C1342b.m3326a(this.f2004a, "preload_ads_when_show_unlock", Boolean.valueOf(b2.f2231p));
                    }
                }
                if (jSONObject.has("show_ads_locked_apps_flag")) {
                    b2.f2232q = jSONObject.optInt("preload_ads_when_show_unlock") == 1;
                    C1342b.m3326a(this.f2004a, "show_ads_locked_apps_flag", Boolean.valueOf(b2.f2232q));
                }
                if (jSONObject.has("max_interstitial_load_mills")) {
                    C1342b.m3326a(this.f2004a, "max_interstitial_load_mills", Integer.valueOf(jSONObject.optInt("max_interstitial_load_mills")));
                }
                if (jSONObject.has("default_adtype")) {
                    C1342b.m3326a(this.f2004a, "user_default_adtype", Integer.valueOf(jSONObject.optInt("default_adtype")));
                    if (!C1342b.m3329a(this.f2004a, "is_user_adtype_banner")) {
                        C1342b.m3326a(this.f2004a, "is_user_adtype_banner", Boolean.valueOf(C1150y.m2648p(this.f2004a)));
                    }
                }
                if (jSONObject.has("enabled_adtype")) {
                    C1342b.m3326a(this.f2004a, "user_enabled_adtype", jSONObject.optString("enabled_adtype"));
                }
                int a4 = C1342b.m3318a(this.f2004a, "interstitial_mode_switcher", 1);
                if (jSONObject.has("interstitial_mode_switcher")) {
                    optInt = jSONObject.optInt("interstitial_mode_switcher");
                    if (optInt != a4) {
                        C1342b.m3326a(this.f2004a, "interstitial_mode_switcher", Integer.valueOf(optInt));
                        if (optInt == 2) {
                            C1342b.m3326a(this.f2004a, "interstitial_show_timemills", Long.valueOf(System.currentTimeMillis()));
                        }
                        obj4 = 1;
                        if (jSONObject.has("interstitial_first_gap")) {
                            C1342b.m3326a(this.f2004a, "interstitial_first_gap", Integer.valueOf(jSONObject.optInt("interstitial_first_gap")));
                        }
                        if (jSONObject.has("interstitial_hour_gap")) {
                            optInt = C1342b.m3318a(this.f2004a, "interstitial_hour_gap", 1);
                            optInt2 = jSONObject.optInt("interstitial_hour_gap");
                            if (optInt2 != optInt) {
                                C1342b.m3326a(this.f2004a, "interstitial_hour_gap", Integer.valueOf(optInt2));
                                obj4 = 1;
                            }
                        }
                        if (obj4 != null) {
                            C1148d.m2489A(this.f2004a, "com.domobile.applock.ACTION_ADS_PARAMS_CHANGED");
                        }
                        if (!C1342b.m3329a(this.f2004a, "trial_day_server") && jSONObject.has("default_trial_day")) {
                            C1342b.m3326a(this.f2004a, "trial_day_server", Integer.valueOf(jSONObject.optInt("default_trial_day")));
                        }
                        if (jSONObject.has("interstitial_times")) {
                            C1342b.m3326a(this.f2004a, "interstitial_times", Integer.valueOf(jSONObject.optInt("interstitial_times")));
                        }
                        if (jSONObject.has("interstitial_gap")) {
                            C1342b.m3326a(this.f2004a, "interstitial_gap", Integer.valueOf(jSONObject.optInt("interstitial_gap")));
                        }
                        if (jSONObject.has("protected_plugins_url")) {
                            optString2 = C1148d.m2524c(this.f2004a, "protected_plugins_json_url", null);
                            optString = jSONObject.optString("protected_plugins_url");
                            if (!(TextUtils.isEmpty(optString) || TextUtils.equals(optString, optString2))) {
                                intent = new Intent(this.f2004a, UpdateProtectedAppsService.class);
                                intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", optString);
                                this.f2004a.startService(intent);
                            }
                        }
                        if (jSONObject.has("newest_theme_version")) {
                            C1148d.m2510a(this.f2004a, new Intent("newest_theme_version").putExtra("newest_theme_version", jSONObject.optInt("newest_theme_version")));
                        }
                        if (jSONObject.has("push_message_url")) {
                            str2 = (String) m2260a(jSONObject, a3, a, a2, "push_message_url");
                            b = C1230g.m2892a(this.f2004a, "push_message_url");
                            if (TextUtils.isEmpty(str2) && !TextUtils.equals(str2, b)) {
                                a3 = String.format(str2, new Object[]{C1230g.m2898b(this.f2004a)});
                                C1230g.m2896a(this.f2004a, "push_message_url", str2);
                                if (this.f2004a instanceof UpdateService) {
                                    ((UpdateService) this.f2004a).m2271a(a3);
                                }
                                obj = null;
                                if (jSONObject.has("home_header_ads")) {
                                    C1342b.m3326a(this.f2004a, "home_header_ads_json", jSONObject.getJSONArray("home_header_ads").toString());
                                    C1148d.m2510a(this.f2004a, new Intent("com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED"));
                                    C1150y.m2557V(this.f2004a);
                                }
                                if (jSONObject.has("ad_params")) {
                                    optJSONObject = jSONObject.getJSONObject("ad_params");
                                    C1258c.m2987b("Json:" + optJSONObject.toString(4));
                                    C1342b.m3325a(this.f2004a, optJSONObject.optInt("key_left_menu_ad_type", 1));
                                    C1342b.m3334b(this.f2004a, optJSONObject.optInt("key_full_screen_ad_type", 0));
                                    C1342b.m3336c(this.f2004a, optJSONObject.optInt("key_app_list_ad_type", 1));
                                    C1342b.m3338d(this.f2004a, optJSONObject.optInt("key_recommend_head_ad_type", 1));
                                    C1342b.m3340e(this.f2004a, optJSONObject.optInt("key_recommend_list_ad_type", 1));
                                    C1342b.m3342f(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_type", 1));
                                    C1342b.m3344g(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_interval", 15));
                                }
                                C1150y.m2581a(this.f2004a, "update_version_time", System.currentTimeMillis());
                                if (!(this.f2004a instanceof UpdateService)) {
                                }
                            } else if (!TextUtils.equals(C1230g.m2892a(this.f2004a, "push_message_loaded_url"), b)) {
                                a3 = String.format(str2, new Object[]{C1230g.m2898b(this.f2004a)});
                                if (this.f2004a instanceof UpdateService) {
                                    ((UpdateService) this.f2004a).m2271a(a3);
                                }
                                obj = null;
                                if (jSONObject.has("home_header_ads")) {
                                    C1342b.m3326a(this.f2004a, "home_header_ads_json", jSONObject.getJSONArray("home_header_ads").toString());
                                    C1148d.m2510a(this.f2004a, new Intent("com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED"));
                                    C1150y.m2557V(this.f2004a);
                                }
                                if (jSONObject.has("ad_params")) {
                                    optJSONObject = jSONObject.getJSONObject("ad_params");
                                    C1258c.m2987b("Json:" + optJSONObject.toString(4));
                                    C1342b.m3325a(this.f2004a, optJSONObject.optInt("key_left_menu_ad_type", 1));
                                    C1342b.m3334b(this.f2004a, optJSONObject.optInt("key_full_screen_ad_type", 0));
                                    C1342b.m3336c(this.f2004a, optJSONObject.optInt("key_app_list_ad_type", 1));
                                    C1342b.m3338d(this.f2004a, optJSONObject.optInt("key_recommend_head_ad_type", 1));
                                    C1342b.m3340e(this.f2004a, optJSONObject.optInt("key_recommend_list_ad_type", 1));
                                    C1342b.m3342f(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_type", 1));
                                    C1342b.m3344g(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_interval", 15));
                                }
                                C1150y.m2581a(this.f2004a, "update_version_time", System.currentTimeMillis());
                                if (!(this.f2004a instanceof UpdateService) && obj != null) {
                                    ((UpdateService) this.f2004a).m2265a();
                                    return;
                                }
                            }
                        }
                        i = 1;
                        if (jSONObject.has("home_header_ads")) {
                            C1342b.m3326a(this.f2004a, "home_header_ads_json", jSONObject.getJSONArray("home_header_ads").toString());
                            C1148d.m2510a(this.f2004a, new Intent("com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED"));
                            C1150y.m2557V(this.f2004a);
                        }
                        if (jSONObject.has("ad_params")) {
                            optJSONObject = jSONObject.getJSONObject("ad_params");
                            C1258c.m2987b("Json:" + optJSONObject.toString(4));
                            C1342b.m3325a(this.f2004a, optJSONObject.optInt("key_left_menu_ad_type", 1));
                            C1342b.m3334b(this.f2004a, optJSONObject.optInt("key_full_screen_ad_type", 0));
                            C1342b.m3336c(this.f2004a, optJSONObject.optInt("key_app_list_ad_type", 1));
                            C1342b.m3338d(this.f2004a, optJSONObject.optInt("key_recommend_head_ad_type", 1));
                            C1342b.m3340e(this.f2004a, optJSONObject.optInt("key_recommend_list_ad_type", 1));
                            C1342b.m3342f(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_type", 1));
                            C1342b.m3344g(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_interval", 15));
                        }
                        C1150y.m2581a(this.f2004a, "update_version_time", System.currentTimeMillis());
                        if (!(this.f2004a instanceof UpdateService)) {
                        }
                    }
                }
                obj4 = null;
                if (jSONObject.has("interstitial_first_gap")) {
                    C1342b.m3326a(this.f2004a, "interstitial_first_gap", Integer.valueOf(jSONObject.optInt("interstitial_first_gap")));
                }
                if (jSONObject.has("interstitial_hour_gap")) {
                    optInt = C1342b.m3318a(this.f2004a, "interstitial_hour_gap", 1);
                    optInt2 = jSONObject.optInt("interstitial_hour_gap");
                    if (optInt2 != optInt) {
                        C1342b.m3326a(this.f2004a, "interstitial_hour_gap", Integer.valueOf(optInt2));
                        obj4 = 1;
                    }
                }
                if (obj4 != null) {
                    C1148d.m2489A(this.f2004a, "com.domobile.applock.ACTION_ADS_PARAMS_CHANGED");
                }
                C1342b.m3326a(this.f2004a, "trial_day_server", Integer.valueOf(jSONObject.optInt("default_trial_day")));
                if (jSONObject.has("interstitial_times")) {
                    C1342b.m3326a(this.f2004a, "interstitial_times", Integer.valueOf(jSONObject.optInt("interstitial_times")));
                }
                if (jSONObject.has("interstitial_gap")) {
                    C1342b.m3326a(this.f2004a, "interstitial_gap", Integer.valueOf(jSONObject.optInt("interstitial_gap")));
                }
                if (jSONObject.has("protected_plugins_url")) {
                    optString2 = C1148d.m2524c(this.f2004a, "protected_plugins_json_url", null);
                    optString = jSONObject.optString("protected_plugins_url");
                    intent = new Intent(this.f2004a, UpdateProtectedAppsService.class);
                    intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", optString);
                    this.f2004a.startService(intent);
                }
                if (jSONObject.has("newest_theme_version")) {
                    C1148d.m2510a(this.f2004a, new Intent("newest_theme_version").putExtra("newest_theme_version", jSONObject.optInt("newest_theme_version")));
                }
                if (jSONObject.has("push_message_url")) {
                    str2 = (String) m2260a(jSONObject, a3, a, a2, "push_message_url");
                    b = C1230g.m2892a(this.f2004a, "push_message_url");
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.equals(C1230g.m2892a(this.f2004a, "push_message_loaded_url"), b)) {
                        a3 = String.format(str2, new Object[]{C1230g.m2898b(this.f2004a)});
                        if (this.f2004a instanceof UpdateService) {
                            ((UpdateService) this.f2004a).m2271a(a3);
                        }
                        obj = null;
                        if (jSONObject.has("home_header_ads")) {
                            C1342b.m3326a(this.f2004a, "home_header_ads_json", jSONObject.getJSONArray("home_header_ads").toString());
                            C1148d.m2510a(this.f2004a, new Intent("com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED"));
                            C1150y.m2557V(this.f2004a);
                        }
                        if (jSONObject.has("ad_params")) {
                            optJSONObject = jSONObject.getJSONObject("ad_params");
                            C1258c.m2987b("Json:" + optJSONObject.toString(4));
                            C1342b.m3325a(this.f2004a, optJSONObject.optInt("key_left_menu_ad_type", 1));
                            C1342b.m3334b(this.f2004a, optJSONObject.optInt("key_full_screen_ad_type", 0));
                            C1342b.m3336c(this.f2004a, optJSONObject.optInt("key_app_list_ad_type", 1));
                            C1342b.m3338d(this.f2004a, optJSONObject.optInt("key_recommend_head_ad_type", 1));
                            C1342b.m3340e(this.f2004a, optJSONObject.optInt("key_recommend_list_ad_type", 1));
                            C1342b.m3342f(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_type", 1));
                            C1342b.m3344g(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_interval", 15));
                        }
                        C1150y.m2581a(this.f2004a, "update_version_time", System.currentTimeMillis());
                        if (!(this.f2004a instanceof UpdateService)) {
                        }
                    }
                }
                i = 1;
                try {
                    if (jSONObject.has("home_header_ads")) {
                        C1342b.m3326a(this.f2004a, "home_header_ads_json", jSONObject.getJSONArray("home_header_ads").toString());
                        C1148d.m2510a(this.f2004a, new Intent("com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED"));
                        C1150y.m2557V(this.f2004a);
                    }
                    if (jSONObject.has("ad_params")) {
                        optJSONObject = jSONObject.getJSONObject("ad_params");
                        C1258c.m2987b("Json:" + optJSONObject.toString(4));
                        C1342b.m3325a(this.f2004a, optJSONObject.optInt("key_left_menu_ad_type", 1));
                        C1342b.m3334b(this.f2004a, optJSONObject.optInt("key_full_screen_ad_type", 0));
                        C1342b.m3336c(this.f2004a, optJSONObject.optInt("key_app_list_ad_type", 1));
                        C1342b.m3338d(this.f2004a, optJSONObject.optInt("key_recommend_head_ad_type", 1));
                        C1342b.m3340e(this.f2004a, optJSONObject.optInt("key_recommend_list_ad_type", 1));
                        C1342b.m3342f(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_type", 1));
                        C1342b.m3344g(this.f2004a, optJSONObject.optInt("key_unlock_page_ad_interval", 15));
                    }
                    C1150y.m2581a(this.f2004a, "update_version_time", System.currentTimeMillis());
                    if (!(this.f2004a instanceof UpdateService)) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    obj2 = obj;
                    try {
                        e.printStackTrace();
                        m2261a(this.f2004a);
                        if ((this.f2004a instanceof UpdateService) && obj2 != null) {
                            ((UpdateService) this.f2004a).m2265a();
                        }
                    } catch (Throwable th2) {
                        obj3 = obj2;
                        th = th2;
                        ((UpdateService) this.f2004a).m2265a();
                        throw th;
                    }
                } catch (Error e4) {
                    e2 = e4;
                    obj3 = obj;
                    try {
                        e2.printStackTrace();
                        m2261a(this.f2004a);
                        if ((this.f2004a instanceof UpdateService) && r6 != null) {
                            ((UpdateService) this.f2004a).m2265a();
                        }
                    } catch (Throwable th22) {
                        th = th22;
                        if ((this.f2004a instanceof UpdateService) && r6 != null) {
                            ((UpdateService) this.f2004a).m2265a();
                        }
                        throw th;
                    }
                } catch (Throwable th222) {
                    th = th222;
                    obj3 = obj;
                    ((UpdateService) this.f2004a).m2265a();
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                obj2 = 1;
                e.printStackTrace();
                m2261a(this.f2004a);
                if (this.f2004a instanceof UpdateService) {
                }
            } catch (Error e6) {
                e2 = e6;
                e2.printStackTrace();
                m2261a(this.f2004a);
                if (this.f2004a instanceof UpdateService) {
                }
            }
        }
    }

    private void m2265a() {
        if (f2005a) {
            stopForeground(true);
        }
        stopSelf();
    }

    public static void m2266a(Context context, long j) {
        String valueOf = String.valueOf(j);
        SharedPreferences sharedPreferences = context.getSharedPreferences("version_notification_timestamp", 0);
        if (Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(valueOf, 0)) >= 259200000) {
            CharSequence string = context.getString(R.string.version_update_title);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
            intent.setFlags(268435456);
            try {
                Notification build = new Builder(context).setSmallIcon(R.drawable.icon).setTicker(string).setContentTitle(string).setVisibility(1).setContentText(context.getString(R.string.version_update_message)).setContentIntent(PendingIntent.getActivity(context, 0, intent, 0)).build();
                build.flags |= 16;
                C1148d.m2508a(context, (int) InputDeviceCompat.SOURCE_TOUCHSCREEN, build);
                sharedPreferences.edit().putLong(valueOf, System.currentTimeMillis()).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void m2271a(String str) {
        C1148d.m2516a(new C1276e(), new C1069b(this, this, str));
    }

    private void m2272a(JSONObject jSONObject) {
        C1148d.m2521b(new C1068a(this, this, jSONObject), new Object[0]);
    }

    public static boolean m2274a(Context context) {
        return Math.abs(System.currentTimeMillis() - C1150y.m2596b(context, "update_version_time", 0)) >= 86400000;
    }

    public static long m2276b(Context context) {
        long b = C1150y.m2596b(context, "new_version_code", 0);
        return ((long) C1148d.ad(context)) < b ? b : -1;
    }

    private static void m2277b(Context context, JSONObject jSONObject) {
        int i = 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("admob_pids");
        String country = Locale.getDefault().getCountry();
        int length = optJSONArray != null ? optJSONArray.length() : 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("locales");
                if (!TextUtils.isEmpty(optString)) {
                    if (country != null && optString.contains(country.toLowerCase())) {
                        i = optJSONObject.optInt("pid", 0);
                        break;
                    }
                }
                i = optJSONObject.optInt("pid", 0);
                break;
            }
        }
        switch (i) {
            case 1:
                C1148d.m2520b(context, "key_actived_admob_publishid", (Object) "ca-app-pub-2172680244283609/9136972178");
                return;
            default:
                C1148d.m2520b(context, "key_actived_admob_publishid", (Object) "ca-app-pub-4885652974540015/9196455687");
                return;
        }
    }

    private static void m2278b(JSONObject jSONObject, Context context) {
        JSONArray optJSONArray = jSONObject.optJSONArray("unlock_page_gift");
        if (optJSONArray != null) {
            String country = Locale.getDefault().getCountry();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    int a = UnlockGiftView.m3562a(context, optJSONObject, country);
                    if (a > 0) {
                        jSONArray.put(optJSONObject);
                    } else if (a == -1) {
                        break;
                    }
                } catch (Exception e) {
                }
            }
            C1148d.m2518a(jSONArray.toString(), new File(context.getFilesDir(), "unlock_page_gift").getAbsolutePath());
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (f2005a) {
            startForeground(R.id.notify_foreground, C1150y.m2555T(this));
        }
        C1148d.m2516a(new C1276e(), new C1070c(this));
    }
}
