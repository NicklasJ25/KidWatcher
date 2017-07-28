package com.domobile.applock.p012e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.domobile.applock.p013f.C0903a;
import com.domobile.applock.service.NotificationService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class C0898c {
    @Nullable
    public static Intent m1562a(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str2 = resolveInfo.activityInfo.packageName;
            String str3 = resolveInfo.activityInfo.name;
            if (str2.equals(str)) {
                Intent intent2 = new Intent();
                intent2.addFlags(268435456);
                intent2.setClassName(str2, str3);
                return intent2;
            }
        }
        return null;
    }

    @NonNull
    public static Intent m1563a(@NonNull C0901f c0901f) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(c0901f.f1352a)) {
            intent.setAction(c0901f.f1352a);
        }
        if (TextUtils.isEmpty(c0901f.f1353b) || TextUtils.isEmpty(c0901f.f1354c)) {
            if (!TextUtils.isEmpty(c0901f.f1353b)) {
                intent.setType(c0901f.f1353b);
            }
            if (!TextUtils.isEmpty(c0901f.f1354c)) {
                intent.setData(Uri.parse(c0901f.f1354c));
            }
        } else {
            intent.setDataAndType(Uri.parse(c0901f.f1354c), c0901f.f1353b);
        }
        if (TextUtils.isEmpty(c0901f.f1355d)) {
            intent.setClassName(c0901f.f1357f, c0901f.f1356e);
        } else {
            intent.setClassName(c0901f.f1357f, c0901f.f1356e);
        }
        if (c0901f.f1358g != null) {
            Iterator it = c0901f.f1358g.iterator();
            while (it.hasNext()) {
                intent.addCategory((String) it.next());
            }
        }
        return intent;
    }

    @NonNull
    public static C0901f m1564a(@NonNull PendingIntent pendingIntent) {
        C0901f c0901f = new C0901f();
        try {
            Method declaredMethod = pendingIntent.getClass().getDeclaredMethod("getIntent", new Class[0]);
            declaredMethod.setAccessible(true);
            Intent intent = (Intent) declaredMethod.invoke(pendingIntent, new Object[0]);
            c0901f.f1352a = intent.getAction();
            c0901f.f1353b = intent.getType();
            c0901f.f1354c = intent.getDataString();
            c0901f.f1355d = intent.getScheme();
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                c0901f.f1358g = new ArrayList();
                for (String add : categories) {
                    c0901f.f1358g.add(add);
                }
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                c0901f.f1356e = component.getClassName();
                c0901f.f1357f = component.getPackageName();
            }
        } catch (Exception e) {
        }
        return c0901f;
    }

    public static String m1565a() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void m1566a(@NonNull Context context) {
        context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public static void m1567a(@NonNull Context context, @NonNull C0899d c0899d) {
        Notification a = C0896a.m1545a().m1554a(c0899d.f1340a);
        if (a != null) {
            try {
                a.contentIntent.send();
                return;
            } catch (Exception e) {
                return;
            }
        }
        C0898c.m1568b(context, c0899d).send();
    }

    @NonNull
    public static PendingIntent m1568b(@NonNull Context context, @NonNull C0899d c0899d) {
        C0901f c0901f = c0899d.f1351l;
        if (c0901f == null || TextUtils.isEmpty(c0901f.f1357f)) {
            return PendingIntent.getActivity(context, 0, C0898c.m1562a(context, c0899d.f1342c), 134217728);
        }
        Intent a = C0898c.m1563a(c0901f);
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(c0901f.f1357f, c0901f.f1356e);
        try {
            return packageManager.getActivityInfo(componentName, 0).exported ? PendingIntent.getActivity(context, 0, a, 134217728) : PendingIntent.getActivity(context, 0, C0898c.m1562a(context, c0901f.f1357f), 134217728);
        } catch (NameNotFoundException e) {
            try {
                return packageManager.getServiceInfo(componentName, 0).exported ? PendingIntent.getService(context, 0, a, 134217728) : PendingIntent.getActivity(context, 0, C0898c.m1562a(context, c0901f.f1357f), 134217728);
            } catch (NameNotFoundException e2) {
                return PendingIntent.getBroadcast(context, 0, a, 134217728);
            }
        }
    }

    @Nullable
    public static Drawable m1569b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean m1570b(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
    }

    @Nullable
    public static Bitmap m1571c(Context context, String str) {
        return C0903a.m1591a(C0898c.m1569b(context, str));
    }

    public static void m1572c(Context context) {
        if (VERSION.SDK_INT >= 18 && !C0898c.m1573d(context)) {
            ComponentName componentName = new ComponentName(context, NotificationService.class);
            if (VERSION.SDK_INT >= 24) {
                NotificationService.requestRebind(componentName);
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static boolean m1573d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String name = NotificationService.class.getName();
        List<RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null || runningServices.isEmpty()) {
            return false;
        }
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            if (name.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
