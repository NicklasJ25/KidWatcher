package com.domobile.applock;

import aaa.domobile.applock.accessibility.service.MyAccessibilityService;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageEvents.Event;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcelable;
import android.os.Process;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.domobile.applock.aj.C0721a;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.fake.DefaultFakeViewInitialer;
import com.domobile.applock.p003a.C0611b;
import com.domobile.applock.p003a.C0622i;
import com.domobile.applock.p003a.C0630k;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.receiver.AppLockDeviceAdminReceiver;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.service.LockService;
import com.domobile.applock.service.ProfilesService;
import com.domobile.applock.service.StepWindowService;
import com.domobile.applock.service.UpdateService;
import com.domobile.applock.theme.ThemePickerFragment;
import com.domobile.eframe.C1149b;
import com.domobile.eframe.C1224e;
import com.domobile.eframe.ui.SlidingLeftMenu.C1236a;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.libs_ads.C1342b;
import com.domobile.lockbean.C1382o;
import com.domobile.lockbean.Scene;
import com.domobile.p016c.C1169a;
import com.domobile.p016c.C1170b;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;

public class C1150y extends C1149b {
    public static final String f2214a = C1147a.m2480a(L, File.separator, "applock_valut");
    public static final String f2215b = C1147a.m2480a(M, "backup");
    public static final Pattern f2216c = Pattern.compile(" *@(drawable/[a-z0-9_]+) *");
    public static final Pattern f2217d = Pattern.compile(" *@(color/[a-z0-9_]+) *");
    public static final Pattern f2218e = Pattern.compile(" *@(string/[a-z0-9_]+) *");
    public boolean f2219A = true;
    public boolean f2220B = false;
    public String f2221f;
    public boolean f2222g = true;
    public boolean f2223h;
    public boolean f2224i = false;
    public boolean f2225j = false;
    public int f2226k;
    public int f2227l;
    public int f2228m;
    public int f2229n;
    public boolean f2230o = true;
    public boolean f2231p = true;
    public boolean f2232q = false;
    public boolean f2233r = false;
    public boolean f2234s = false;
    public boolean f2235t = false;
    public boolean f2236u = false;
    public boolean f2237v = false;
    public boolean f2238w = false;
    public boolean f2239x;
    public int f2240y;
    public boolean f2241z;

    public static boolean m2536A(Context context) {
        return C1150y.m2614c(context, "is_image_lock_pattern") && C1150y.m2537B(context);
    }

    public static boolean m2537B(Context context) {
        return !TextUtils.isEmpty(C1150y.m2561Z(context));
    }

    public static boolean m2538C(Context context) {
        return "com.domobile.applockpaid".equals(context.getPackageName());
    }

    public static boolean m2539D(Context context) {
        return C1150y.m2566a(context).f430e || C1150y.m2538C(context) || C1150y.m2641l(context);
    }

    public static void m2540E(Context context) {
        String charSequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        Parcelable intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(context.getPackageName(), LauncherActivity.class.getName());
        intent.setFlags(268435456);
        intent.setFlags(67108864);
        Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", charSequence);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("duplicate", false);
        context.sendBroadcast(intent2);
    }

    public static void m2541F(Context context) {
        Intent intent = new Intent("com.domobile.applock.START_RECEIVER");
        intent.setFlags(32);
        context.sendBroadcast(intent);
    }

    public static boolean m2542G(Context context) {
        return C1150y.m2590a(context, C1150y.m2597b()) && C1150y.m2590a(context, new ComponentName(context, AppLockDeviceAdminReceiver.class)) && C1150y.m2543H(context);
    }

    public static boolean m2543H(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.domobile.applockwatcher", 0).applicationInfo.loadLabel(packageManager);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m2544I(Context context) {
        if (!C1150y.m2641l(context)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean a = C1342b.m3330a(context, "is_trial_term_ended", false);
        if (a) {
            long a2 = currentTimeMillis - C1342b.m3319a(context, "ad_active_time", currentTimeMillis);
            return (a2 >= 86400000 || a2 <= 0) ? a : false;
        } else {
            long a3 = C1342b.m3319a(context, "ad_active_time", 0);
            if (a3 == 0) {
                C1342b.m3326a(context, "ad_active_time", Long.valueOf(currentTimeMillis));
                return false;
            } else if (!C1342b.m3329a(context, "trial_day_server")) {
                return false;
            } else {
                currentTimeMillis -= a3;
                if (currentTimeMillis <= ((long) C1342b.m3350l(context)) * 86400000 && currentTimeMillis >= 0) {
                    return false;
                }
                C1342b.m3326a(context, "is_trial_term_ended", Boolean.valueOf(true));
                return currentTimeMillis <= 0 || currentTimeMillis >= 86400000;
            }
        }
    }

    public static void m2545J(Context context) {
        if (!C1342b.m3330a(context, "trial_end_notified", false)) {
            C1150y b = C1150y.m2598b(context);
            int l = C1342b.m3350l(context);
            if (l != 0 || !b.f2224i) {
                int i = b.f2224i ? R.string.adtype_banner_title : R.string.adtype_interstitial_title;
                C1342b.m3326a(context, "trial_end_notified", Boolean.valueOf(true));
                CharSequence string = context.getString(R.string.trial_ended_notify_title, new Object[]{context.getString(R.string.app_name), context.getString(i)});
                CharSequence string2 = context.getString(l > 0 ? R.string.trial_ended_message : R.string.trial_ended_message_zero, new Object[]{context.getString(R.string.app_name)});
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(268435456);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                Builder autoCancel = new Builder(context).setSmallIcon(R.drawable.icon_notify).setAutoCancel(true);
                autoCancel.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
                autoCancel.setContentText(string2).setContentTitle(string).setTicker(string);
                autoCancel.setWhen(System.currentTimeMillis()).setOngoing(false);
                C1148d.m2508a(context, (int) R.id.notify_trial_ended, autoCancel.setContentIntent(activity).build());
            }
        }
    }

    public static int m2546K(Context context) {
        return C1148d.m2499a(context, "move_in_vault_speed", context.getResources().getInteger(R.integer.move_in_vault_speed));
    }

    public static int m2547L(Context context) {
        return C1148d.m2499a(context, "move_out_vault_speed", context.getResources().getInteger(R.integer.move_out_vault_speed));
    }

    public static Point m2548M(Context context) {
        Resources resources = context.getResources();
        return new Point(resources.getDimensionPixelSize(R.dimen.gallery_single_image_thumb_width), resources.getDimensionPixelSize(R.dimen.gallery_single_image_thumb_height));
    }

    public static String m2549N(Context context) {
        Account[] accountsByType = ((AccountManager) context.getSystemService("account")).getAccountsByType("com.google");
        return accountsByType.length > 0 ? accountsByType[0].name : null;
    }

    public static void m2550O(Context context) {
        try {
            context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
            StepWindowService.m2249a(context, -6);
        } catch (Exception e) {
        }
    }

    public static void m2551P(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("com.domoile.applock.ACTION_MANAGE_OVERLAY"), 134217728);
        Builder builder = new Builder(context);
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setSmallIcon(R.drawable.icon_notify);
        builder.setContentTitle(context.getString(R.string.app_name));
        builder.setContentText(context.getString(R.string.warning_permission_toplayer));
        builder.setContentIntent(broadcast);
        builder.setWhen(System.currentTimeMillis());
        Notification build = builder.build();
        build.flags |= 32;
        notificationManager.notify(99, build);
    }

    public static void m2552Q(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(99);
    }

    @TargetApi(19)
    public static boolean m2553R(Context context) {
        if (!LockService.f1931a) {
            return false;
        }
        try {
            return ((AppOpsManager) context.getSystemService("appops")).checkOp("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m2554S(Context context) {
        try {
            String string = Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return string != null && string.contains(MyAccessibilityService.class.getName());
        } catch (Throwable th) {
            return false;
        }
    }

    public static Notification m2555T(Context context) {
        if (UpdateService.f2005a) {
            return new Notification();
        }
        try {
            Builder smallIcon = new Builder(context).setContentTitle(context.getString(R.string.app_name)).setContentText(context.getString(R.string.pyp)).setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent(""), 0)).setSmallIcon(R.drawable.icon_notify);
            if (VERSION.SDK_INT >= 16) {
                smallIcon.setPriority(-2);
            }
            if (VERSION.SDK_INT < 11) {
                smallIcon.setOngoing(true);
                smallIcon.setTicker(null);
            }
            return smallIcon.build();
        } catch (Exception e) {
            return new Notification();
        }
    }

    public static ArrayList<C1236a> m2556U(Context context) {
        ArrayList<C1236a> arrayList = new ArrayList();
        try {
            Object a = C1342b.m3323a(context, "home_header_ads_json", "");
            if (!TextUtils.isEmpty(a)) {
                JSONArray jSONArray = new JSONArray(a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new C1236a(jSONArray.getJSONObject(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void m2557V(final Context context) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(Object... objArr) {
                Iterator it = C1150y.m2556U(context).iterator();
                while (it.hasNext()) {
                    C1236a c1236a = (C1236a) it.next();
                    if (!(TextUtils.isEmpty(c1236a.f2454c) || new File(C1277a.m3057a(c1236a.f2454c)).exists())) {
                        C1277a.m3055a(c1236a.f2454c, false);
                    }
                }
                return null;
            }
        }, new Object[0]);
    }

    public static void m2558W(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!defaultSharedPreferences.getBoolean("pk_is_upgrade_safe_data", false)) {
            Object string = defaultSharedPreferences.getString("secure_email", "");
            if (!TextUtils.isEmpty(string)) {
                C1150y.m2657u(context, string);
            }
            string = defaultSharedPreferences.getString("security_answer", "");
            if (!TextUtils.isEmpty(string)) {
                C1150y.m2660v(context, string);
            }
            string = defaultSharedPreferences.getString("image_lock_pattern", "");
            if (!TextUtils.isEmpty(string)) {
                C1150y.m2656t(context, string);
            }
            defaultSharedPreferences.edit().putBoolean("pk_is_upgrade_safe_data", true).apply();
        }
    }

    @NonNull
    public static String m2559X(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Object string = defaultSharedPreferences.getString("pk_applock_uuid", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String a = C0630k.m753a();
        defaultSharedPreferences.edit().putString("pk_applock_uuid", a).apply();
        return a;
    }

    public static String m2560Y(Context context) {
        String str = context.getFilesDir() + File.separator + C1150y.m2577a(C1150y.m2559X(context));
        if (new File(str).exists()) {
            return C0611b.m698b("domobile", new String(C3613c.m15734a(str)));
        }
        String a = C0622i.m740a(32);
        C3613c.m15733a(C0611b.m697a("domobile", a).getBytes(), str);
        return a;
    }

    public static String m2561Z(Context context) {
        Object string = PreferenceManager.getDefaultSharedPreferences(context).getString("image_lock_pattern", "");
        return !TextUtils.isEmpty(string) ? C0611b.m698b(C1150y.m2560Y(context), string) : "";
    }

    public static long m2562a(long j, long j2, long j3) {
        return Math.min(j3, Math.max(j, j2));
    }

    public static RunningTaskInfo m2563a(ActivityManager activityManager) {
        int i = 0;
        while (true) {
            try {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) activityManager.getRunningTasks(i + 1).get(i);
                i++;
                if (runningTaskInfo != null && runningTaskInfo.numRunning > 0) {
                    return runningTaskInfo;
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Intent m2564a(Activity activity) {
        if (C1150y.m2639k(activity, "com.android.vending")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.domobile.applockwatcher"));
            intent.setFlags(268435456);
            intent.setPackage("com.android.vending");
            return intent;
        }
        File file = new File(N, "AppLockWatcher.apk");
        try {
            if (file.exists()) {
                file.delete();
            }
            C3613c.m15732a(activity.getAssets().open("AppLockWatcher.apk"), file);
            try {
                Runtime.getRuntime().exec(C1147a.m2480a("chmod 777 ", file));
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), FileInfo.MIME_APK);
            intent.setPackage("com.android.packageinstaller");
            return intent;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable m2565a(BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2, int i) {
        Drawable bitmapDrawable3;
        if (bitmapDrawable2 == null) {
            bitmapDrawable3 = new BitmapDrawable(Resources.getSystem(), bitmapDrawable.getBitmap());
            bitmapDrawable3.setColorFilter(i, Mode.SRC_ATOP);
        }
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, bitmapDrawable3);
        stateListDrawable.addState(new int[]{16842908}, bitmapDrawable3);
        stateListDrawable.addState(StateSet.WILD_CARD, bitmapDrawable);
        return stateListDrawable;
    }

    public static AppLockApplication m2566a(Context context) {
        return (AppLockApplication) context.getApplicationContext();
    }

    public static C1288c m2567a(Activity activity, int i, int i2, int i3) {
        return new C1288c(activity).m3101a(i).m3123d(i2).m3102a(i3, null).m3117b(true).m3122d();
    }

    public static C1288c m2568a(Activity activity, String str, String str2, String str3) {
        return new C1288c(activity).m3109a(str).mo2528a((CharSequence) str2).m3110a(str3, null).m3117b(true).m3122d();
    }

    public static C1288c m2569a(final C0386c c0386c) {
        C1288c c1288c = new C1288c(c0386c);
        c1288c.m3123d((int) R.string.notice_enable_usage_stats);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b((int) R.string.enable_usage_stats, new OnClickListener() {
            public void onClick(View view) {
                try {
                    c0386c.m80e();
                    c0386c.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
                    StepWindowService.m2249a(c0386c, -4);
                } catch (Exception e) {
                }
            }
        });
        return c1288c.m3122d();
    }

    public static C1288c m2570a(C0386c c0386c, OnClickListener onClickListener, OnClickListener onClickListener2) {
        C1288c c1288c = new C1288c(c0386c);
        c1288c.m3123d((int) R.string.unlock_settings_notice_message);
        c1288c.m3102a((int) R.string.lock, onClickListener);
        c1288c.m3114b((int) R.string.unlock, onClickListener2);
        return c1288c.m3117b(false).m3122d();
    }

    public static C1288c m2571a(final C0386c c0386c, String str) {
        C1288c a = new C1288c(c0386c).mo2528a((CharSequence) str);
        a.m3102a(17039360, null);
        a.m3114b(17039370, new OnClickListener() {
            public void onClick(View view) {
                c0386c.m78a(true);
            }
        }).m3122d();
        return a;
    }

    public static final Object m2572a(Context context, String str, Object obj) {
        try {
            Object obj2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            return obj2 == null ? obj : obj2;
        } catch (Exception e) {
            return obj;
        }
    }

    public static String m2573a(int i, int i2) {
        String valueOf = String.valueOf(i);
        while (valueOf.length() < i2) {
            valueOf = C1147a.m2480a("0", valueOf);
        }
        return valueOf;
    }

    public static String m2574a(UsageStatsManager usageStatsManager) {
        String str = null;
        if (VERSION.SDK_INT >= 21) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                UsageEvents queryEvents = usageStatsManager.queryEvents(currentTimeMillis - 10000, currentTimeMillis);
                Event event = new Event();
                while (queryEvents.hasNextEvent()) {
                    queryEvents.getNextEvent(event);
                    if (event.getEventType() == 1) {
                        str = event.getPackageName();
                    }
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String m2575a(Context context, PackageManager packageManager, ApplicationInfo applicationInfo) {
        try {
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            C1150y.m2585a(resourcesForApplication, C1224e.m2873a(context));
            return resourcesForApplication.getString(applicationInfo.labelRes);
        } catch (Exception e) {
            return packageManager.getApplicationLabel(applicationInfo).toString();
        }
    }

    public static String m2576a(Context context, PackageManager packageManager, ResolveInfo resolveInfo) {
        try {
            Resources resourcesForApplication = packageManager.getResourcesForApplication(resolveInfo.activityInfo.applicationInfo);
            C1150y.m2585a(resourcesForApplication, C1224e.m2873a(context));
            return resourcesForApplication.getString(resolveInfo.labelRes);
        } catch (Exception e) {
            return resolveInfo.loadLabel(packageManager).toString();
        }
    }

    public static String m2577a(String str) {
        try {
            String str2 = new String(str);
            try {
                return C1170b.m2684a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    @TargetApi(24)
    public static Locale m2578a() {
        return VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
    }

    public static void m2579a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435457);
        intent.setDataAndType(uri, FileInfo.MIME_APK);
        context.startActivity(intent);
    }

    public static void m2580a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(uri, str);
        context.startActivity(intent);
    }

    public static void m2581a(Context context, String str, long j) {
        C1148d.m2520b(context, str, (Object) Long.valueOf(j));
    }

    public static void m2582a(Context context, String str, Boolean bool) {
        C1148d.m2520b(context, str, (Object) bool);
    }

    public static void m2583a(Context context, String str, String str2) {
        C1148d.m2520b(context, str, (Object) str2);
    }

    public static void m2584a(Context context, Locale locale) {
        C1150y.m2585a(context.getResources(), locale);
    }

    @TargetApi(17)
    public static void m2585a(Resources resources, Locale locale) {
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        try {
            configuration.setLocale(locale);
        } catch (NoSuchMethodError e) {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static void m2586a(ImageView imageView, int i, int i2) {
        if (i2 > 0) {
            i = ResourcesCompat.getColor(imageView.getResources(), i2, null);
        }
        if (imageView.getDrawable() != null) {
            imageView.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
        }
    }

    public static void m2587a(C0386c c0386c, int i) {
        if (TextUtils.isEmpty(C1150y.aa(c0386c))) {
            C1150y.m2607b(c0386c, i);
            return;
        }
        Intent a;
        if (i == FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
            if (C1150y.m2543H(c0386c)) {
                c0386c.m80e();
                OpenAdvanceProtectActivity.m646a((Context) c0386c);
                return;
            }
            C1150y.m2566a((Context) c0386c).f438m = true;
            a = C1150y.m2564a((Activity) c0386c);
            C1382o.m3517a().m3519b(c0386c, 1);
        } else if (i == InputDeviceCompat.SOURCE_TOUCHSCREEN) {
            r0 = C1150y.m2597b();
            if (C1150y.m2590a((Context) c0386c, r0)) {
                C1150y.m2587a(c0386c, (int) FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                a = null;
            } else {
                C1382o.m3517a().m3519b(c0386c, 2);
                a = C1150y.m2610c((Context) c0386c, r0);
            }
        } else if (i == FragmentTransaction.TRANSIT_FRAGMENT_FADE) {
            r0 = new ComponentName(c0386c, AppLockDeviceAdminReceiver.class);
            if (C1150y.m2590a((Context) c0386c, r0)) {
                a = null;
            } else {
                C1382o.m3517a().m3518a(c0386c, 3);
                a = C1150y.m2610c((Context) c0386c, r0);
            }
        } else {
            return;
        }
        if (a != null) {
            c0386c.f44a = i;
            c0386c.m80e();
            try {
                c0386c.startActivity(a);
            } catch (Exception e) {
                a.setPackage(null);
                c0386c.startActivity(a);
                e.printStackTrace();
            }
        }
    }

    public static boolean m2588a(Context context, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("password_length", i).commit();
    }

    public static boolean m2589a(Context context, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("pk_password_error_time", j).commit();
    }

    public static boolean m2590a(Context context, ComponentName componentName) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        return devicePolicyManager != null ? devicePolicyManager.isAdminActive(componentName) : false;
    }

    public static boolean m2591a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public static boolean m2592a(Context context, String str, boolean z) {
        return C1148d.m2522b(context, str, z);
    }

    public static boolean m2593a(PackageManager packageManager, String str) {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(23)
    public static boolean m2594a(WindowManager windowManager, View view, LayoutParams layoutParams) {
        try {
            if (O < 23 || Settings.canDrawOverlays(view.getContext())) {
                windowManager.addView(view, layoutParams);
                return true;
            }
            layoutParams.type = 2005;
            windowManager.addView(view, layoutParams);
            return false;
        } catch (Exception e) {
            try {
                layoutParams.type = 2005;
                windowManager.addView(view, layoutParams);
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public static String[] m2595a(Context context, ArrayList<Scene> arrayList) {
        int size = arrayList.size();
        String[] strArr = new String[(size + 1)];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((Scene) arrayList.get(i)).f2923b;
        }
        strArr[size] = context.getString(R.string.add_scenes);
        return strArr;
    }

    public static String aa(Context context) {
        Object string = PreferenceManager.getDefaultSharedPreferences(context).getString("secure_email", "");
        return !TextUtils.isEmpty(string) ? C0611b.m698b(C1150y.m2560Y(context), string) : "";
    }

    public static String ab(Context context) {
        Object string = PreferenceManager.getDefaultSharedPreferences(context).getString("security_answer", "");
        return !TextUtils.isEmpty(string) ? C0611b.m698b(C1150y.m2560Y(context), string) : "";
    }

    public static long m2596b(Context context, String str, long j) {
        return C1148d.m2523c(context, str, j);
    }

    public static ComponentName m2597b() {
        return new ComponentName("com.domobile.applockwatcher", "com.domobile.applockwatcher.AppLockWatcherDeviceAdmin");
    }

    public static C1150y m2598b(Context context) {
        return C1150y.m2566a(context).m591e();
    }

    public static C1288c m2599b(final C0386c c0386c) {
        C1288c c1288c = new C1288c(c0386c);
        c1288c.m3123d((int) R.string.notification_permission_message);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b((int) R.string.enable_usage_stats, new OnClickListener() {
            public void onClick(View view) {
                try {
                    c0386c.m80e();
                    C0898c.m1566a(c0386c);
                    StepWindowService.m2249a(c0386c, -5);
                } catch (Exception e) {
                }
            }
        });
        return c1288c.m3122d();
    }

    public static String m2600b(ActivityManager activityManager) {
        List list;
        Throwable th;
        List runningAppProcesses;
        try {
            runningAppProcesses = activityManager.getRunningAppProcesses();
            int i = 0;
            while (((RunningAppProcessInfo) runningAppProcesses.get(i)).pkgList.length != 1) {
                try {
                    i++;
                } catch (Exception e) {
                    list = runningAppProcesses;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            String str = ((RunningAppProcessInfo) runningAppProcesses.get(i)).pkgList[0];
            if (runningAppProcesses == null) {
                return str;
            }
            runningAppProcesses.clear();
            return str;
        } catch (Exception e2) {
            list = null;
            if (list != null) {
                list.clear();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            runningAppProcesses = null;
            if (runningAppProcesses != null) {
                runningAppProcesses.clear();
            }
            throw th;
        }
    }

    public static String m2601b(Context context, long j) {
        return C1147a.m2480a("version_data_updated_success_", Long.valueOf(j));
    }

    public static String m2602b(Context context, String str) {
        return C1148d.m2524c(context, str, "");
    }

    public static String m2603b(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(str.charAt(i));
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public static final void m2604b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.getBooleanExtra("com.domobile.elock.EXTRA_NOTIFICATION_LOCK", false)) {
            activity.startActivity(new Intent(activity, NotificationCenterActivity.class));
        } else if ("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT".equals(intent.getAction())) {
            activity.startService(new Intent(activity, ProfilesService.class).putExtras(intent));
        } else if ("com.domobile.applock.plugins.ACTION_PLEASE_UNLOCK_APP".equals(intent.getStringExtra("unlock_app_action"))) {
            Object stringExtra = intent.getStringExtra("unlock_app_broadcast_action");
            String stringExtra2 = intent.getStringExtra("unlock_app_pkgname");
            if (!TextUtils.isEmpty(stringExtra)) {
                Intent intent2 = new Intent(stringExtra);
                if (intent.getExtras() != null) {
                    intent2.putExtras(intent.getExtras());
                }
                intent2.setPackage(stringExtra2);
                activity.sendBroadcast(intent2);
            }
        } else {
            String stringExtra3 = intent.getStringExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION");
            if (!TextUtils.isEmpty(stringExtra3)) {
                try {
                    C1148d.m2520b((Context) activity, stringExtra3, (Object) Boolean.valueOf(true));
                    SwitcherLockReceiver.m2100b((Context) activity, new Intent(stringExtra3));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getBooleanExtra("com.domobile.elock.EXTRA_MANAGER_SPACE", false)) {
                intent = new Intent(activity, ManagerSpaceActivity.class);
                intent.putExtra("com.domobile.elock.EXTRA_MANAGER_SPACE", true);
                activity.startActivity(intent);
            } else if (intent.getBooleanExtra("com.domobile.elock.EXTRA_GOTO_CHOOSEBG", false)) {
                activity.startActivity(AgentActivity.m570a(activity, 295));
            } else if (intent.getBooleanExtra("GoToCore", true)) {
                Object stringExtra4 = intent.getStringExtra("com.domobile.applock.EXTRA_OPEN_ACTIVITY");
                if (!TextUtils.isEmpty(stringExtra4)) {
                    try {
                        Class.forName(stringExtra4);
                        activity.startActivity(new Intent().setClassName(activity.getPackageName(), stringExtra4));
                        return;
                    } catch (Exception e2) {
                        if (TextUtils.equals(stringExtra4, "com.domobile.applock.theme.ThemePickerActivity")) {
                            stringExtra4 = ThemePickerFragment.class.getName();
                        }
                    }
                }
                Intent intent3 = new Intent(activity, MainTabFragmentActivity.class);
                if (!TextUtils.isEmpty(stringExtra4)) {
                    intent3.putExtra("com.domobile.applock.EXTRA_OPEN_ACTIVITY", stringExtra4);
                }
                activity.startActivity(intent3);
            }
        }
    }

    public static void m2605b(Context context, @StringRes int i) {
        FirebaseAnalytics.getInstance(context).logEvent("z_" + context.getString(i), new Bundle());
    }

    public static void m2606b(Context context, ComponentName componentName) {
        if (C1150y.m2597b().equals(componentName)) {
            Intent intent = new Intent("com.domobile.applock.ACTION_REMOVE_DEVICE_ADMIN").setPackage("com.domobile.applockwatcher");
            intent.setFlags(32);
            context.sendBroadcast(intent);
            return;
        }
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        if (devicePolicyManager != null) {
            devicePolicyManager.removeActiveAdmin(componentName);
        }
    }

    private static void m2607b(final C0386c c0386c, final int i) {
        View inflate = c0386c.getLayoutInflater().inflate(R.layout.secure_email, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.edittext_security_email);
        final C1288c c1288c = new C1288c(c0386c);
        c1288c.m3101a((int) R.string.secure_email);
        c1288c.m3117b(false).m3111a(true);
        c1288c.m3102a(17039360, new OnClickListener() {
            public void onClick(View view) {
                if (c0386c instanceof OpenAdvanceProtectActivity) {
                    c0386c.finish();
                }
            }
        });
        c1288c.m3114b(17039370, null);
        c1288c.m3104a(new OnClickListener() {
            public void onClick(View view) {
                String obj = editText.getText().toString();
                if (TextUtils.isEmpty(obj) || !C1150y.m2631h(obj)) {
                    editText.startAnimation(AnimationUtils.loadAnimation(c0386c, R.anim.shake));
                    C1147a.m2485d(c0386c, R.string.email_error);
                    return;
                }
                C1150y.m2657u(c0386c, obj);
                C1150y.m2587a(c0386c, i);
                c1288c.m3125e();
            }
        }, false).m3105a(inflate).m3122d();
    }

    public static boolean m2608b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            CharSequence e = C1150y.m2620e(context);
        }
        if (!e.startsWith("salt:")) {
            return TextUtils.equals(C1150y.m2618d(str), e);
        }
        return TextUtils.equals(C1170b.m2683a(str, "domobile"), e.substring("salt:".length()));
    }

    public static boolean m2609b(Context context, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("pk_invader_remind_flag", z).commit();
    }

    public static Intent m2610c(Context context, ComponentName componentName) {
        String string = context.getString(R.string.device_admin_summary);
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
        intent.putExtra("android.app.extra.ADD_EXPLANATION", string);
        return intent;
    }

    public static String m2611c(String str) {
        String[] split = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                stringBuilder.append((char) Integer.parseInt(obj));
            }
        }
        return stringBuilder.toString();
    }

    public static void m2612c(Activity activity) {
    }

    public static void m2613c(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static boolean m2614c(Context context, String str) {
        return C1148d.m2522b(context, str, false);
    }

    public static boolean m2615c(Context context, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("invader_protect_flag", z).commit();
    }

    public static String m2616d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("short_exit_time_limit", "0SECONDS");
    }

    public static String m2617d(Context context, boolean z) {
        if (!C1150y.m2539D(context)) {
            return null;
        }
        return C1150y.m2602b(context, z ? "lock_bgimage_landscape" : "lock_bgimage_portrait");
    }

    public static String m2618d(String str) {
        return C1150y.m2577a(str);
    }

    public static boolean m2619d(Context context, String str) {
        return C1148d.m2522b(context, str, true);
    }

    public static String m2620e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("password", C1150y.m2618d("1234"));
    }

    public static String m2621e(String str) {
        return str.replace("a", "0").replace("c", "1").replace("g", GpsMeasureMode.MODE_2_DIMENSIONAL).replace("b", GpsMeasureMode.MODE_3_DIMENSIONAL).replace("e", "4").replace("q", "5").replace("k", "6").replace("l", "7").replace("u", "8").replace("y", "9");
    }

    public static boolean m2622e(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putString("pk_unread_invader_path", str).commit();
    }

    public static int m2623f(String str) {
        return str.equals("0SECONDS") ? 0 : str.equals("15SECONDS") ? 15000 : str.equals("30SECONDS") ? 30000 : str.equals("1MINUTE") ? 60000 : str.equals("3MINUTES") ? 180000 : str.equals("5MINUTES") ? 300000 : str.equals("SCREEN_OFF") ? Integer.MAX_VALUE : 0;
    }

    public static String m2624f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("password_hint", "");
    }

    public static boolean m2625f(Context context, String str) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String a = C1170b.m2683a(str, "domobile");
        return edit.putString("password", C1147a.m2480a("salt:", a)).putInt("password_length", str.length()).commit();
    }

    public static String m2626g(Context context, String str) {
        return str.equals("0SECONDS") ? context.getString(R.string.seconds_0) : str.equals("15SECONDS") ? context.getString(R.string.seconds_15) : str.equals("30SECONDS") ? context.getString(R.string.seconds_30) : str.equals("1MINUTE") ? context.getString(R.string.minutes_1) : str.equals("3MINUTES") ? context.getString(R.string.minutes_3) : str.equals("5MINUTES") ? context.getString(R.string.minutes_5) : str.equals("SCREEN_OFF") ? context.getString(R.string.after_screen_off) : context.getString(R.string.seconds_0);
    }

    public static boolean m2627g(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("protect_flag", true);
    }

    public static boolean m2628g(String str) {
        return "com.android.settings".equals(str) || "com.android.vending".equals(str) || "com.sec.android.app.controlpanel".equals(str);
    }

    public static String m2629h(Context context) {
        return C1150y.m2643m(context) ? DefaultFakeViewInitialer.class.getName() : C1148d.m2524c(context, "fake_view_type", DefaultFakeViewInitialer.class.getName());
    }

    public static String m2630h(Context context, String str) {
        return C1169a.m2679b(str, context.getPackageName().substring(4, 12));
    }

    public static boolean m2631h(String str) {
        return TextUtils.isEmpty(str) ? false : Pattern.compile("[\\S]{1,256}\\@[\\S]{1,64}(\\.[\\S]{1,25})+").matcher(str).matches();
    }

    public static String m2632i(String str) {
        return !TextUtils.isEmpty(str) ? C1170b.m2685b(str).toUpperCase() : "";
    }

    public static void m2633i(Context context, String str) {
        try {
            ((ActivityManager) context.getSystemService("activity")).killBackgroundProcesses(str);
        } catch (Exception e) {
        }
    }

    public static boolean m2634i(Context context) {
        return TextUtils.equals(C1150y.m2629h(context), DefaultFakeViewInitialer.class.getName());
    }

    public static int m2635j(Context context) {
        return C1148d.m2499a(context, "billing_mode", 1);
    }

    public static int m2636j(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String m2637j(String str) {
        return str.contains(".") ? str.replaceAll("\\.", "_") : str;
    }

    public static boolean m2638k(Context context) {
        return C1150y.m2635j(context) == 3 && C1150y.m2566a(context).f430e;
    }

    public static boolean m2639k(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Object m2640l(Context context, String str) {
        try {
            return context.getSystemService(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean m2641l(Context context) {
        return C1150y.m2635j(context) == 1 && !C1150y.m2566a(context).f430e;
    }

    public static void m2642m(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), FileInfo.MIME_APK);
        context.startActivity(intent);
    }

    public static boolean m2643m(Context context) {
        return C1150y.m2635j(context) == 2 && !C1150y.m2566a(context).f430e;
    }

    public static void m2644n(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_" + str, new Bundle());
    }

    public static boolean m2645n(Context context) {
        return C1150y.m2641l(context) && C1150y.m2598b(context).f2225j;
    }

    public static void m2646o(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_ad_box_" + C1150y.m2637j(str), new Bundle());
    }

    public static void m2647p(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_ad_head_" + C1150y.m2637j(str), new Bundle());
    }

    public static boolean m2648p(Context context) {
        return C1342b.m3318a(context, "user_default_adtype", 2) == 1;
    }

    public static long m2649q(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("pk_password_error_time", 0);
    }

    public static void m2650q(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_ad_left_" + C1150y.m2637j(str), new Bundle());
    }

    public static void m2651r(Context context) {
        C1150y.m2622e(context, "");
        C1150y.m2609b(context, false);
    }

    public static void m2652r(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_ad_plugin_" + C1150y.m2637j(str), new Bundle());
    }

    public static void m2653s(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent("z_sliding_" + str, new Bundle());
    }

    public static boolean m2654s(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pk_invader_remind_flag", false);
    }

    @Nullable
    public static String m2655t(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("pk_unread_invader_path", "");
    }

    public static void m2656t(Context context, String str) {
        String Y = C1150y.m2560Y(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("image_lock_pattern", C0611b.m697a(Y, str.trim())).apply();
    }

    public static void m2657u(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("secure_email", C0611b.m697a(C1150y.m2560Y(context), str)).apply();
    }

    public static boolean m2658u(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("invader_protect_flag", false);
    }

    public static int m2659v(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("password_length", 0);
    }

    public static void m2660v(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("security_answer", C0611b.m697a(C1150y.m2560Y(context), str)).apply();
    }

    public static boolean m2661w(Context context) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove("password");
        edit.remove("password_hint");
        edit.remove("password_length");
        return edit.commit();
    }

    public static boolean m2662x(Context context) {
        return C1148d.m2535z(context, "password");
    }

    public static int m2663y(Context context) {
        return !C1150y.m2539D(context) ? 0 : C1148d.m2499a(context, "lock_numboard_color", 0);
    }

    public static void m2664z(Context context) {
        String e = C1150y.m2620e(context);
        if (e.length() != 32 && !e.startsWith("salt:")) {
            C1150y.m2625f(context, C1150y.m2621e(C1150y.m2620e(context)));
            C1150y.m2583a(context, "security_answer", C1150y.m2603b(C1150y.m2602b(context, "security_answer")));
        }
    }

    public void m2665a(Context context, boolean z) {
        if ((z == this.f2238w ? 1 : null) != null && z) {
            C0721a.m1000c(context);
        }
        this.f2238w = z;
        C1150y.m2582a(context, "protect_flag", Boolean.valueOf(this.f2238w));
        Intent intent = new Intent(context, LockService.class);
        C1147a.m2481a(this.f2238w ? context.startService(intent) : Boolean.valueOf(context.stopService(intent)));
    }

    public void m2666o(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f2240y = C1150y.m2623f(C1150y.m2616d(context));
        this.f2238w = C1150y.m2627g(context);
        this.f2221f = defaultSharedPreferences.getString("password_hint", "");
        this.f2222g = defaultSharedPreferences.getBoolean("lock_after_screen_on", this.f2222g);
        this.f2223h = defaultSharedPreferences.getBoolean("enable_visible_pattern", true);
        this.f2233r = defaultSharedPreferences.getBoolean("fingerprint_auth_enabled", false);
        if (C1342b.m3323a(context, "user_enabled_adtype", "").contains(",")) {
            this.f2225j = C1150y.m2544I(context);
            this.f2226k = C1342b.m3318a(context, "interstitial_gap", 1);
            this.f2227l = C1342b.m3318a(context, "interstitial_times", 1);
            this.f2228m = C1342b.m3318a(context, "interstitial_gap_now", 0);
            this.f2229n = C1342b.m3318a(context, "interstitial_times_today", 0);
            this.f2230o = C1342b.m3330a(context, "preload_interstitial_ads", true);
            this.f2231p = C1342b.m3330a(context, "preload_ads_when_show_unlock", true);
            this.f2232q = C1342b.m3330a(context, "show_ads_locked_apps_flag", false);
        } else {
            this.f2225j = C1150y.m2544I(context);
            this.f2226k = C1342b.m3318a(context, "interstitial_gap", 1);
            this.f2227l = C1342b.m3318a(context, "interstitial_times", 1);
            this.f2228m = C1342b.m3318a(context, "interstitial_gap_now", 0);
            this.f2229n = C1342b.m3318a(context, "interstitial_times_today", 0);
            this.f2230o = C1342b.m3330a(context, "preload_interstitial_ads", true);
            this.f2231p = C1342b.m3330a(context, "preload_ads_when_show_unlock", true);
            this.f2232q = C1342b.m3330a(context, "show_ads_locked_apps_flag", false);
        }
    }
}
