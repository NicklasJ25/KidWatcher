package com.domobile.applock;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.AppOpsManager.OnOpChangedListener;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.android.camera.C0411e;
import com.android.camera.C0487k;
import com.android.camera.gallery.C0455e;
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.app.GalleryAppImpl;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.MediaSource;
import com.android.gallery3d.data.UriSource;
import com.domobile.applock.p003a.C0633m;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.service.LockService;
import com.domobile.eframe.C1217c;
import com.domobile.eframe.DatabaseErrorActivity;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.libs_ads.C0588a;
import com.domobile.libs_ads.C1342b;
import com.domobile.lockbean.C1360c;
import com.domobile.lockbean.C1372k;
import com.domobile.lockbean.Scene;
import com.domobile.p001a.C0581a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;

public class AppLockApplication extends GalleryAppImpl implements ActivityLifecycleCallbacks, C0588a {
    private static AppLockApplication f420p;
    private Bitmap f421A;
    private int f422B = 0;
    private long f423C = -1;
    private C1150y f424D = new C1150y();
    private Handler f425E = new C05874(this);
    public boolean f426a = false;
    public boolean f427b = false;
    public boolean f428c = false;
    public C0581a f429d;
    public boolean f430e = false;
    public boolean f431f = false;
    public boolean f432g = false;
    public boolean f433h = false;
    public boolean f434i = false;
    public C1360c f435j;
    public boolean f436k;
    public boolean f437l = false;
    public boolean f438m = false;
    public int f439n = 0;
    public boolean f440o = false;
    private BlankActivity f441q = null;
    private C1217c f442r;
    private C0411e f443s;
    private File f444t;
    private C0948h f445u;
    private ArrayList<String> f446v = new ArrayList();
    private HashMap<String, String> f447w = new HashMap();
    private HashMap<String, String> f448x;
    private ArrayList<String> f449y = new ArrayList();
    private HashMap<String, C0633m> f450z = new HashMap();

    class C05863 extends Thread {
        final /* synthetic */ AppLockApplication f418a;

        C05863(AppLockApplication appLockApplication) {
            this.f418a = appLockApplication;
        }

        public void run() {
            this.f418a.m582r();
        }
    }

    class C05874 extends Handler {
        final /* synthetic */ AppLockApplication f419a;

        C05874(AppLockApplication appLockApplication) {
            this.f419a = appLockApplication;
        }

        public void handleMessage(Message message) {
            C1148d.m2489A(this.f419a, "com.domobile.elock.main_finish");
        }
    }

    private void m574a(long j, int i) {
        boolean z = j != 0 && j < 2015120701;
        boolean z2 = C1150y.O > i && i <= 19;
        if ((z || z2) && LockService.f1931a && !C1150y.m2592a((Context) this, C1150y.m2601b((Context) this, 2015120701), false)) {
            C1017n.m2035a("com.android.settings", 0);
            Scene.m3390a("com.android.settings", 0);
            C1150y.m2582a((Context) this, C1150y.m2601b((Context) this, 2015120701), Boolean.valueOf(true));
            C1148d.m2520b((Context) this, "auto_lock_settings_success", (Object) Boolean.valueOf(true));
        }
    }

    public static AppLockApplication m577b() {
        return f420p;
    }

    public static AppLockApplication m578c() {
        return m577b();
    }

    private void m580p() {
        if (VERSION.SDK_INT >= 25) {
            final AppOpsManager appOpsManager = (AppOpsManager) getSystemService("appops");
            appOpsManager.startWatchingMode("android:system_alert_window", getPackageName(), new OnOpChangedListener(this) {
                final /* synthetic */ AppLockApplication f417b;

                public void onOpChanged(String str, String str2) {
                    try {
                        if (VERSION.SDK_INT >= 19 && appOpsManager.checkOp(str, Process.myUid(), this.f417b.getPackageName()) == 0) {
                            C1150y.m2552Q(AppLockApplication.m577b());
                        }
                    } catch (Exception e) {
                        C1150y.m2551P(AppLockApplication.m577b());
                    }
                }
            });
        }
    }

    private void m581q() {
        new C05863(this).start();
    }

    private void m582r() {
        try {
            JSONArray jSONArray = new JSONArray(C3613c.m15742f(new File(getFilesDir(), "com.domobile.applock.plugins.protected_apps")));
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    this.f447w.put(string, string);
                }
            }
        } catch (Exception e) {
        }
    }

    public void m583a() {
        boolean z = false;
        if (C1147a.ac(this) <= 2013061200) {
            if (C0581a.m556d(this, "applock_subs_monthly")) {
                C0581a.m546a((Context) this, "applock_subs_monthly");
            }
            if (C0581a.m556d(this, "applock_subs_yearly")) {
                C0581a.m546a((Context) this, "applock_subs_yearly");
            }
        }
        boolean z2 = C0581a.m555c(this, "applock_subs_yearly") || C0581a.m555c(this, "applock_subscription_yearly");
        this.f431f = z2;
        this.f432g = C0581a.m555c(this, "applock_subs_monthly");
        if (this.f432g || this.f431f) {
            z = true;
        }
        this.f430e = z;
        C1148d.m2489A(this, "com.domobile.elock.action.ACTION_PURCHASE_STATE_CHANGED");
    }

    public void m584a(BlankActivity blankActivity) {
        this.f441q = blankActivity;
    }

    public void m585a(String str) {
        if (!this.f446v.contains(str)) {
            this.f446v.add(str);
        }
    }

    public boolean mo2352a(Context context) {
        return C1150y.m2645n(context);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public HashMap<String, String> m587b(Context context) {
        if (this.f448x != null) {
            return this.f448x;
        }
        this.f448x = new HashMap();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            this.f448x.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.packageName);
        }
        this.f448x.remove("com.android.settings");
        return this.f448x;
    }

    public void m588b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator it = ((ArrayList) this.f446v.clone()).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str.equals(str2)) {
                    this.f446v.remove(str2);
                }
            }
        }
    }

    public ArrayList<String> m589c(String str) {
        ArrayList<String> arrayList = new ArrayList();
        C0633m c0633m = (C0633m) this.f450z.get(str);
        if (c0633m != null) {
            Iterator it = c0633m.f574b.iterator();
            while (it.hasNext()) {
                HidedPictureItem hidedPictureItem = (HidedPictureItem) it.next();
                if (c0633m.f575c == 2) {
                    arrayList.add(hidedPictureItem.f190i);
                } else {
                    arrayList.add(hidedPictureItem.f182a);
                }
            }
        }
        return arrayList;
    }

    public BlankActivity m590d() {
        return this.f441q;
    }

    public C1150y m591e() {
        this.f424D.m2666o(this);
        return this.f424D;
    }

    public Bitmap m592f() {
        if (this.f421A == null) {
            this.f421A = BitmapFactory.decodeResource(getResources(), R.drawable.num_button_numbers);
        }
        return this.f421A;
    }

    public String mo2353g() {
        return "https://www.domobile.com/";
    }

    public ArrayList<String> m594h() {
        return this.f446v;
    }

    public void m595i() {
        File file;
        CharSequence b = C1150y.m2602b((Context) this, "key_available_hider_folder");
        Object b2 = C1150y.m2602b((Context) this, "key_server_hider_folder");
        if (!TextUtils.isEmpty(b)) {
            try {
                File file2 = new File(C1150y.L);
                if (new File(file2, b).exists()) {
                    File file3 = new File(file2, b);
                    if (!(TextUtils.isEmpty(b2) || TextUtils.equals(b2, b))) {
                        file = new File(file2, b2);
                        if (file3.renameTo(file)) {
                            C1148d.m2520b((Context) this, "key_available_hider_folder", b2);
                            this.f444t = new File(file, "/dont_remove/");
                            return;
                        }
                    }
                    file = file3;
                    this.f444t = new File(file, "/dont_remove/");
                    return;
                }
            } catch (Exception e) {
            }
        }
        file = C0487k.m427d(this);
        if (file != null) {
            this.f444t = new File(file, "/dont_remove/");
            C1150y.m2583a((Context) this, "key_available_hider_folder", file.getName());
            return;
        }
        if (TextUtils.isEmpty(b2)) {
            file = new File(C1150y.L, ".MySecurityData");
            C1148d.m2520b((Context) this, "key_available_hider_folder", (Object) ".MySecurityData");
        } else {
            file = new File(C1150y.L, b2);
            C1148d.m2520b((Context) this, "key_available_hider_folder", b2);
        }
        this.f444t = new File(file, "/dont_remove/");
    }

    public synchronized void initializeSourceMap(DataManager dataManager) {
        if (dataManager.getSourceMap().isEmpty()) {
            dataManager.addSource(new UriSource(this));
            dataManager.addSource(new C0455e(this));
            if (dataManager.getActiveCount() > 0) {
                for (MediaSource resume : dataManager.getSourceMap().values()) {
                    resume.resume();
                }
            }
        }
    }

    public HashMap<String, C0633m> m596j() {
        return this.f450z;
    }

    public HashMap<String, String> m597k() {
        return this.f447w;
    }

    public ArrayList<String> m598l() {
        return this.f449y;
    }

    public File m599m() {
        return this.f444t;
    }

    public int m600n() {
        return this.f422B;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            if ("com.facebook.ads.AudienceNetworkActivity".equals(activity.getClass().getName())) {
                this.f440o = true;
                LockService b = LockService.m2176b();
                if (b != null) {
                    b.m2224a("com.facebook.ads.AudienceNetworkActivity", getPackageName());
                }
            } else {
                this.f440o = false;
            }
        } catch (Exception e) {
        }
        if (activity instanceof C0386c) {
            this.f422B++;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof C0386c) {
            this.f422B--;
            if (this.f422B <= 0) {
                this.f422B = 0;
                C1257b.m2966a((Context) this).m2985b();
            }
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            this.f423C = (long) activity.hashCode();
        }
        this.f425E.removeMessages(0);
    }

    public void onActivityStopped(Activity activity) {
        try {
            this.f440o = "com.facebook.ads.AudienceNetworkActivity".equals(activity.getClass().getName());
        } catch (Exception e) {
        }
        if (activity != null && ((long) activity.hashCode()) == this.f423C) {
            this.f425E.sendEmptyMessageDelayed(0, 180000);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Intent intent = new Intent("com.domobile.frame.action.ACTION_SCREEN_ORINET_CHANGED");
        intent.putExtra("com.domobile.frame.EXTRA_ORIENTATION", configuration.orientation);
        C1148d.m2510a((Context) this, intent);
    }

    public void onCreate() {
        super.onCreate();
        C1150y.m2558W(this);
        registerActivityLifecycleCallbacks(this);
        sendBroadcast(new Intent("com.domobile.applock.ACTION_APPLOCK_BOOT_COMPLETE").setFlags(32), "com.domobile.applock.PERMISSION_RECEIVE_APPLOCK_BOOT_COMPLETE");
        m595i();
        C1150y.m2541F(this);
        final long ac = (long) C1147a.ac(this);
        if (ac != 0 && ac <= 2013112901) {
            C1342b.m3326a((Context) this, "is_user_adtype_banner", Boolean.valueOf(true));
        }
        if (!(ac == 0 || ac >= 2015031201 || C1150y.m2614c((Context) this, "short_exit_flag"))) {
            C1150y.m2583a((Context) this, "short_exit_time_limit", "0SECONDS");
        }
        if (ac != 0 && ac < 2015072301) {
            C1148d.m2534y(this, "secure_code_md5");
        }
        if (!C1148d.m2535z(this, "ads_random_value")) {
            C1148d.m2520b((Context) this, "ads_random_value", (Object) Float.valueOf(new Random().nextFloat()));
        }
        C1150y.m2664z(this);
        f420p = this;
        m581q();
        m583a();
        try {
            this.f443s = C0411e.m158a(this);
            C0411e.m157a().getVersion();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (C0411e.m163d(this)) {
                    this.f443s = C0411e.m158a(this);
                    C0411e.m157a().getVersion();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            this.f442r = C1217c.m2854a((Context) this);
            C1217c.m2853a().getVersion();
        } catch (Exception e3) {
        }
        if (C1217c.m2853a() == null) {
            this.f428c = true;
            startActivity(new Intent(this, DatabaseErrorActivity.class).setFlags(268435456));
        }
        final int a = C1148d.m2499a((Context) this, "current_android_sdk_version", C1150y.O);
        new Thread(this) {
            final /* synthetic */ AppLockApplication f415c;

            public void run() {
                this.f415c.f439n = C1372k.m3456a(AppLockApplication.f420p);
                this.f415c.m574a(ac, a);
            }
        }.start();
        this.f445u = C0948h.m1695a();
        this.f445u.m1698a((Context) this);
        C1148d.m2520b((Context) this, "current_android_sdk_version", (Object) Integer.valueOf(C1150y.O));
        C0898c.m1572c(this);
        m580p();
    }

    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(this);
        if (this.f442r != null) {
            this.f442r.m2858b();
        }
        if (this.f443s != null) {
            this.f443s.m164b();
        }
    }
}
