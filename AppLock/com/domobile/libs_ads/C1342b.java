package com.domobile.libs_ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.domobile.frame.http.image.C1277a;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.io.File;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1342b {

    public static class C1341a {
        public String f2893a;
        public String f2894b;
        public String f2895c;
    }

    public static int m3316a(Context context) {
        return C1342b.m3318a(context, "key_left_menu_ad_type", 1);
    }

    public static int m3317a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int m3318a(Context context, String str, int i) {
        return context.getSharedPreferences("pref_ads_util", 0).getInt(str, i);
    }

    public static long m3319a(Context context, String str, long j) {
        return context.getSharedPreferences("pref_ads_util", 0).getLong(str, j);
    }

    public static View m3320a(Activity activity, C0588a c0588a, ViewGroup viewGroup, int i, String str, boolean z) {
        return C1342b.m3321a(activity, c0588a, viewGroup, i, str, z, null);
    }

    public static View m3321a(Activity activity, C0588a c0588a, ViewGroup viewGroup, int i, String str, boolean z, String str2) {
        if (!z && !c0588a.mo2352a(activity)) {
            return null;
        }
        View m = C1342b.m3351m(activity);
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (m != null) {
            viewGroup.addView(m);
        }
        return C1342b.m3322a(activity, viewGroup, str, str2);
    }

    public static AdView m3322a(Activity activity, ViewGroup viewGroup, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = C1342b.m3324a(str);
        }
        View adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(str2);
        adView.loadAd(new Builder().build());
        viewGroup.addView(adView);
        return adView;
    }

    public static String m3323a(Context context, String str, String str2) {
        return context.getSharedPreferences("pref_ads_util", 0).getString(str, str2);
    }

    private static String m3324a(String str) {
        return TextUtils.equals("unlock", str) ? "ca-app-pub-4885652974540015/4759582889" : TextUtils.equals("applock", str) ? "ca-app-pub-4885652974540015/4924993286" : "ca-app-pub-4885652974540015/6401726487";
    }

    public static void m3325a(Context context, int i) {
        C1342b.m3326a(context, "key_left_menu_ad_type", Integer.valueOf(i));
    }

    public static void m3326a(Context context, String str, Object obj) {
        if (context != null && str != null && obj != null) {
            Editor edit = context.getSharedPreferences("pref_ads_util", 0).edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else {
                throw new UnsupportedOperationException();
            }
            edit.commit();
        }
    }

    public static void m3327a(Context context, boolean z) {
        C1342b.m3326a(context, "key_unlock_page_show_force", Boolean.valueOf(z));
    }

    public static final void m3328a(View view) {
        if (view != null && (view instanceof AdView)) {
            try {
                ((AdView) view).removeAllViews();
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                ((AdView) view).destroy();
            } catch (Throwable th) {
            }
        }
    }

    public static boolean m3329a(Context context, String str) {
        return context.getSharedPreferences("pref_ads_util", 0).contains(str);
    }

    public static boolean m3330a(Context context, String str, boolean z) {
        return context.getSharedPreferences("pref_ads_util", 0).getBoolean(str, z);
    }

    public static int m3331b(Context context) {
        return C1342b.m3318a(context, "key_full_screen_ad_type", 0);
    }

    public static int m3332b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Integer m3333b(Context context, String str, int i) {
        return Integer.valueOf(4);
    }

    public static void m3334b(Context context, int i) {
        C1342b.m3326a(context, "key_full_screen_ad_type", Integer.valueOf(i));
    }

    public static int m3335c(Context context) {
        return C1342b.m3318a(context, "key_app_list_ad_type", -1);
    }

    public static void m3336c(Context context, int i) {
        C1342b.m3326a(context, "key_app_list_ad_type", Integer.valueOf(i));
    }

    public static int m3337d(Context context) {
        return C1342b.m3318a(context, "key_recommend_head_ad_type", 1);
    }

    public static void m3338d(Context context, int i) {
        C1342b.m3326a(context, "key_recommend_head_ad_type", Integer.valueOf(i));
    }

    public static int m3339e(Context context) {
        return C1342b.m3318a(context, "key_recommend_list_ad_type", 1);
    }

    public static void m3340e(Context context, int i) {
        C1342b.m3326a(context, "key_recommend_list_ad_type", Integer.valueOf(i));
    }

    public static int m3341f(Context context) {
        return C1342b.m3318a(context, "key_unlock_page_ad_type", -1);
    }

    public static void m3342f(Context context, int i) {
        C1342b.m3326a(context, "key_unlock_page_ad_type", Integer.valueOf(i));
    }

    public static int m3343g(Context context) {
        return C1342b.m3318a(context, "key_unlock_page_ad_interval", 15);
    }

    public static void m3344g(Context context, int i) {
        C1342b.m3326a(context, "key_unlock_page_ad_interval", Integer.valueOf(i));
    }

    public static int m3345h(Context context) {
        return C1342b.m3318a(context, "key_unlock_page_show_count", 0);
    }

    public static void m3346h(Context context, int i) {
        C1342b.m3326a(context, "key_unlock_page_show_count", Integer.valueOf(i));
    }

    public static boolean m3347i(Context context) {
        return C1342b.m3330a(context, "key_unlock_page_show_force", false);
    }

    public static JSONObject m3348j(Context context) {
        File file = new File(context.getFilesDir(), "domobile_custom_ad");
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return new JSONObject(C3613c.m15742f(file));
        } catch (Exception e) {
            return null;
        }
    }

    public static C1341a m3349k(Context context) {
        if (DoMoAdsService.m3310a(context)) {
            context.startService(new Intent("com.domobile.libs_ads.ACTION_DOMO_AD_SERVICE").setPackage(context.getPackageName()));
        }
        int a = C1342b.m3318a(context, "domo_ad_index", -1) + 1;
        try {
            JSONArray optJSONArray = new JSONObject(C1342b.m3323a(context, "domo_ad_json", "")).optJSONArray("ad");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = a >= optJSONArray.length() ? 0 : a;
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                C1341a c1341a = new C1341a();
                c1341a.f2893a = jSONObject.optString("pic");
                c1341a.f2894b = jSONObject.optString("action1");
                c1341a.f2895c = jSONObject.optString("action2");
                C1342b.m3326a(context, "domo_ad_index", Integer.valueOf(i));
                return c1341a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static int m3350l(Context context) {
        return C1342b.m3318a(context, "trial_day_server", 0);
    }

    private static View m3351m(final Context context) {
        final C1341a k = C1342b.m3349k(context);
        if (k == null) {
            return null;
        }
        int a = C1342b.m3317a(context, 320.0f);
        int a2 = C1342b.m3317a(context, 50.0f);
        View linearLayout = new LinearLayout(context);
        final View imageView = new ImageView(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, a2));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a, a2));
        linearLayout.setGravity(17);
        new Thread() {

            class C13381 implements Runnable {
                final /* synthetic */ C13391 f2887a;

                C13381(C13391 c13391) {
                    this.f2887a = c13391;
                }

                public void run() {
                    imageView.setImageBitmap(C1277a.m3056a(k.f2893a, false, CompressFormat.JPEG));
                }
            }

            public void run() {
                try {
                    new Handler(context.getMainLooper()).post(new C13381(this));
                } catch (Exception e) {
                }
            }
        }.start();
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent;
                try {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(k.f2894b));
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception e) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(k.f2895c));
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                }
            }
        });
        return linearLayout;
    }
}
