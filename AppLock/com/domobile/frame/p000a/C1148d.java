package com.domobile.frame.p000a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.ui.C1288c;
import com.domobile.frame.ui.C1290d;
import com.domobile.p015b.C1168b.C1165i;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

public class C1148d extends C1147a {
    public static void m2489A(Context context, String str) {
        C1148d.m2510a(context, new Intent(str));
    }

    public static int m2490B(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String m2491C(Context context, String str) {
        String str2 = "1.0";
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void m2492D(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static void m2493E(Context context, String str) {
        Intent intent;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        try {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }

    public static String m2494F(Context context, String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            str2 = str3;
            while (true) {
                try {
                    str3 = bufferedReader.readLine();
                    if (str3 == null) {
                        break;
                    }
                    str2 = str2 + str3;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    public static void m2495G(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", str, null));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void m2496H(Context context, String str) {
        try {
            Locale locale = Locale.getDefault();
            String a = C1147a.m2480a(context.getApplicationInfo().loadLabel(context.getPackageManager()).toString(), "-v", C1148d.ae(context));
            Object[] objArr = new Object[2];
            objArr[0] = "mailto:";
            if (TextUtils.isEmpty(str)) {
                str = "support@domobile.com";
            }
            objArr[1] = str;
            Uri parse = Uri.parse(C1147a.m2480a(objArr));
            String a2 = C1147a.m2480a("\n\n\n\n---------------------------\nModel:", Build.MODEL, "\nSDK:", VERSION.RELEASE, "\nVersion:", C1148d.ae(context), "\nCountry:", locale.getCountry(), "\nLanguage:", locale.getLanguage(), "\npkg:", context.getPackageName());
            Intent intent = new Intent("android.intent.action.SENDTO", parse);
            intent.setFlags(268435456);
            intent.putExtra("android.intent.extra.SUBJECT", a);
            intent.putExtra("android.intent.extra.TEXT", a2);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float m2497a(Context context, String str, float f) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(str, f);
    }

    public static int m2498a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int m2499a(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public static Point m2500a(WindowManager windowManager) {
        Point point = new Point(0, 0);
        if (VERSION.SDK_INT < 13) {
            point.x = windowManager.getDefaultDisplay().getWidth();
            point.y = windowManager.getDefaultDisplay().getHeight();
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point;
    }

    public static Drawable m2501a(Context context, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        return bitmapDrawable;
    }

    public static final Drawable m2502a(Resources resources, int i) {
        Drawable drawable = null;
        try {
            drawable = ResourcesCompat.getDrawable(resources, i, null);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e2) {
        }
        return drawable;
    }

    public static TransitionDrawable m2503a(Drawable drawable) {
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
        transitionDrawable.startTransition(350);
        return transitionDrawable;
    }

    public static TypedValue m2504a(Context context, int i, boolean z) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, z);
        return typedValue;
    }

    public static C1290d m2505a(Activity activity, String str, String str2) {
        C1290d c1290d = null;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = activity.getString(C1165i.loading);
            }
            c1290d = C1290d.m3130a(activity, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c1290d;
    }

    public static String m2506a(Bitmap bitmap, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(N, "AppLock_by_DoMobile.png");
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.PNG, 80, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (z && bitmap != null) {
                    bitmap.recycle();
                }
                return file.getAbsolutePath();
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return !z ? null : null;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                bitmap.recycle();
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (!z && bitmap != null) {
                bitmap.recycle();
                return null;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (z && bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static String m2507a(TextView textView) {
        return textView.getText().toString();
    }

    public static void m2508a(Context context, int i, Notification notification) {
        ((NotificationManager) context.getSystemService("notification")).notify(i, notification);
    }

    public static void m2509a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
        }
    }

    public static void m2510a(Context context, Intent intent) {
        try {
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m2511a(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Exception e) {
        }
    }

    public static void m2512a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(536870912);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        if (!TextUtils.isEmpty(str3)) {
            intent.setType(GalleryUtils.MIME_TYPE_IMAGE);
            String str4 = "android.intent.extra.STREAM";
            intent.putExtra(str4, Uri.parse(C1147a.m2480a("file://", str3)));
        }
        intent = Intent.createChooser(intent, context.getString(C1165i.domo_share_by));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static void m2513a(AsyncTask asyncTask, Object... objArr) {
        try {
            asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(21)
    public static void m2514a(View view, Drawable drawable) {
        if (O >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void m2515a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void m2516a(C1276e c1276e, C0607f... c0607fArr) {
        try {
            if (!((ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR).isShutdown()) {
                c1276e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c0607fArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m2517a(C1288c c1288c) {
        if (c1288c != null) {
            try {
                c1288c.m3125e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final void m2518a(String str, String str2) {
        Exception e;
        Throwable th;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
            try {
                bufferedWriter2.write(str);
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = bufferedWriter2;
                try {
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    public static int ad(Context context) {
        return C1148d.m2490B(context, context.getPackageName());
    }

    public static String ae(Context context) {
        return C1148d.m2491C(context, context.getPackageName());
    }

    public static void af(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions")));
        } catch (Exception e) {
        }
    }

    public static void ag(Context context) {
        C1148d.m2493E(context, null);
    }

    public static String ah(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return null;
        }
    }

    public static int ai(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        } catch (NotFoundException e) {
            return C1148d.m2498a(context, 24.0f);
        }
    }

    public static void m2519b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
        }
    }

    public static void m2520b(Context context, String str, Object obj) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
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

    public static void m2521b(AsyncTask asyncTask, Object... objArr) {
        try {
            if (!((ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR).isShutdown()) {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean m2522b(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static long m2523c(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static String m2524c(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static void m2525c(Context context, long j) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }

    public static String m2526d() {
        return DateFormat.format("yyyyMMddkkmmss", System.currentTimeMillis()).toString();
    }

    public static void m2527d(Activity activity) {
        C1148d.m2493E(activity, null);
    }

    public static C1288c m2528e(final Activity activity) {
        C1288c c1288c = new C1288c(activity);
        c1288c.m3101a(C1165i.domo_exit_tip);
        c1288c.m3127e(true);
        c1288c.m3124d(false);
        c1288c.m3117b(true);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b(17039370, new OnClickListener() {
            public void onClick(View view) {
                activity.finish();
            }
        }).m3122d();
        return c1288c;
    }

    public static C1288c m2529f(Activity activity) {
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            if (C1147a.ac(activity) < packageInfo.versionCode) {
                C1147a.m2483c(activity, packageInfo.versionCode);
                return C1148d.m2532g(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final void m2530f(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    public static TypedValue m2531g(Context context, int i) {
        return C1148d.m2504a(context, i, true);
    }

    public static C1288c m2532g(Activity activity) {
        return new C1288c(activity).m3123d(C1165i.domo_update_content).m3114b(17039370, null).m3117b(false).m3122d();
    }

    public static int m2533h(Context context, int i) {
        return context.obtainStyledAttributes(new int[]{i}).getResourceId(0, 0);
    }

    public static void m2534y(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
    }

    public static boolean m2535z(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }
}
