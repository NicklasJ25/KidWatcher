package com.domobile.applock.service;

import aaa.domobile.applock.accessibility.service.MyAccessibilityService;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.AppOpsManager.OnOpChangedListener;
import android.app.PendingIntent;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainActivity;
import com.domobile.applock.R;
import com.domobile.applock.TargetAdmobInterstitialActivity;
import com.domobile.applock.aj.C0721a;
import com.domobile.applock.livelock.p006a.C0966b;
import com.domobile.applock.livelock.p006a.C0971d;
import com.domobile.applock.receiver.AppLockDeviceAdminReceiver;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.theme.C1102c;
import com.domobile.eframe.C1215a;
import com.domobile.eframe.C1217c;
import com.domobile.eframe.C1219d;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;
import com.domobile.libs_ads.DoMobileFullScreenAdActivity;
import com.domobile.lockbean.C0964f;
import com.domobile.lockbean.C1375l;
import com.domobile.lockbean.C1381n;
import com.facebook.ads.C0665a;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1460d;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class LockService extends Service {
    private static String f1930H = "";
    public static final boolean f1931a = (C1150y.O > 19);
    public static final boolean f1932b = (C1150y.O > 21);
    public static final boolean f1933c;
    public static C0964f f1934k;
    private static boolean f1935l = false;
    private static LockService f1936m = null;
    private int f1937A = 1;
    private int f1938B = 1;
    private PendingIntent f1939C;
    private PendingIntent f1940D;
    private Map<String, Long> f1941E;
    private HashMap<String, String> f1942F = new HashMap();
    private C1061a f1943G;
    private int f1944I = 0;
    private int f1945J = 0;
    private boolean f1946K = false;
    private boolean f1947L = false;
    private boolean f1948M = false;
    private boolean f1949N = false;
    private boolean f1950O = false;
    private C1150y f1951P;
    private C1219d f1952Q;
    private Activity f1953R;
    private long f1954S;
    private boolean f1955T = false;
    private boolean f1956U = false;
    private boolean f1957V = false;
    private int f1958W = 0;
    private Handler f1959X = new C10551(this);
    DevicePolicyManager f1960d;
    ComponentName f1961e;
    String f1962f = "";
    String f1963g = "";
    String f1964h = "";
    String f1965i = "";
    String f1966j = "";
    private ActivityManager f1967n;
    private PackageManager f1968o;
    private AlarmManager f1969p;
    private UsageStatsManager f1970q;
    private AppOpsManager f1971r;
    private OnOpChangedListener f1972s;
    private WifiManager f1973t;
    private ConnectivityManager f1974u;
    private AppLockApplication f1975v;
    private long f1976w = 0;
    private int f1977x = 0;
    private boolean f1978y = false;
    private boolean f1979z = false;

    class C10551 extends Handler {
        final /* synthetic */ LockService f1921a;

        C10551(LockService lockService) {
            this.f1921a = lockService;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f1921a.m2199g();
                    return;
                case 1:
                    if (this.f1921a.f1975v.m600n() <= 0 && !this.f1921a.f1946K) {
                        this.f1921a.m2214n();
                        C1150y.m2633i(this.f1921a, this.f1921a.getPackageName());
                        return;
                    } else if (!this.f1921a.f1957V) {
                        this.f1921a.m2186c();
                        return;
                    } else {
                        return;
                    }
                case 2:
                    SwitcherLockReceiver.m2094a(this.f1921a);
                    this.f1921a.f1979z = false;
                    this.f1921a.f1978y = false;
                    this.f1921a.f1951P.f2219A = true;
                    this.f1921a.m2197f();
                    return;
                case 3:
                    this.f1921a.m2194e(this.f1921a);
                    return;
                case 4:
                    try {
                        this.f1921a.m2203i();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 5:
                    this.f1921a.m2218p();
                    return;
                default:
                    return;
            }
        }
    }

    class C10562 implements OnOpChangedListener {
        final /* synthetic */ LockService f1922a;

        C10562(LockService lockService) {
            this.f1922a = lockService;
        }

        public void onOpChanged(String str, String str2) {
            this.f1922a.f1956U = C1150y.m2553R(this.f1922a);
        }
    }

    class C10573 extends C0665a {
        final /* synthetic */ LockService f1923a;

        C10573(LockService lockService) {
            this.f1923a = lockService;
        }

        public void mo2390a(C1453b c1453b) {
            super.mo2390a(c1453b);
        }

        public void mo2391a(C1453b c1453b, C1460d c1460d) {
            super.mo2391a(c1453b, c1460d);
            C1148d.m2489A(this.f1923a, "com.domobile.elock.blank_finish");
            this.f1923a.f1952Q.m2867f();
        }

        public void mo2395d(C1453b c1453b) {
            super.mo2395d(c1453b);
            C1148d.m2489A(this.f1923a, "com.domobile.elock.blank_finish");
            this.f1923a.f1952Q.m2867f();
        }
    }

    class C10584 extends AdListener {
        final /* synthetic */ LockService f1924a;

        C10584(LockService lockService) {
            this.f1924a = lockService;
        }

        public void onAdClosed() {
            C1148d.m2489A(this.f1924a, "com.domobile.elock.blank_finish");
            this.f1924a.f1952Q.m2867f();
        }

        public void onAdFailedToLoad(int i) {
            C1148d.m2489A(this.f1924a, "com.domobile.elock.blank_finish");
            this.f1924a.f1952Q.m2867f();
        }

        public void onAdLeftApplication() {
            C1148d.m2489A(this.f1924a, "com.domobile.elock.blank_finish");
            this.f1924a.f1952Q.m2867f();
        }
    }

    public class C1061a extends BroadcastReceiver {
        final /* synthetic */ LockService f1928a;

        class C10601 extends Thread {
            final /* synthetic */ C1061a f1927a;

            C10601(C1061a c1061a) {
                this.f1927a = c1061a;
            }

            public void run() {
                this.f1927a.f1928a.m2202h();
            }
        }

        public C1061a(LockService lockService) {
            this.f1928a = lockService;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.domobile.elock.proctect_list_change".equals(action)) {
                this.f1928a.f1955T = C1150y.m2596b(context, "actived_profile", -100) == -1;
                if (this.f1928a.f1955T) {
                    this.f1928a.m2226a(true, false, false, 0);
                }
                new C10601(this).start();
            } else if ("com.domobile.elock.verify_pass".equals(action)) {
                this.f1928a.f1964h = intent.getStringExtra("verify_package");
                this.f1928a.m2181b(true);
                if (("com.domobile.applock".equals(this.f1928a.f1964h) || LockService.f1932b || this.f1928a.f1975v.f437l) && !this.f1928a.f1951P.f2231p) {
                    this.f1928a.m2218p();
                }
                this.f1928a.f1965i = this.f1928a.f1964h;
                C1150y.m2583a(context, "last_unlock_pkg", this.f1928a.f1965i);
                this.f1928a.f1963g = this.f1928a.f1964h;
                this.f1928a.f1964h = "";
                if (LockService.m2190d(context)) {
                    this.f1928a.m2226a(true, false, true, 0);
                }
            } else if ("com.domobile.applock.ACTION_CALL_STATE_RINGING".equals(action)) {
                this.f1928a.m2168a(context, true);
            } else if ("com.domobile.applock.ACTION_CALL_STATE_IDLE".equals(action)) {
                this.f1928a.m2168a(context, false);
            } else if ("android.intent.action.PHONE_STATE".equals(action)) {
                if (C1150y.m2614c(this.f1928a, "incall_locked")) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager.getCallState() == 1) {
                        this.f1928a.m2168a(context, true);
                    } else if (telephonyManager.getCallState() == 0) {
                        this.f1928a.m2168a(context, false);
                    }
                }
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.f1928a.f1959X.removeMessages(0);
                try {
                    if (this.f1928a.f1940D != null) {
                        this.f1928a.f1969p.cancel(this.f1928a.f1940D);
                    }
                } catch (Exception e) {
                }
                this.f1928a.f1959X.sendEmptyMessageDelayed(2, 200);
                context.sendBroadcast(new Intent("com.domobile.applock.ACTION_SCREEN_ON"));
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f1928a.f1959X.sendEmptyMessageDelayed(0, 15000);
                this.f1928a.f1959X.sendEmptyMessageDelayed(3, 200);
                context.sendBroadcast(new Intent("com.domobile.applock.ACTION_SCREEN_OFF"));
                this.f1928a.f1951P.f2219A = false;
            } else if ("com.domobile.elock.LOCK_CLOSE_WITH_BACK".equals(action)) {
                this.f1928a.m2226a(true, true, false, 1);
            } else if ("com.domobile.elock.ACTION_DEVICE_ADMIN_STATUS_CHENGED".equals(action)) {
                if (this.f1928a.f1960d != null) {
                    this.f1928a.f1951P.f2239x = this.f1928a.f1960d.isAdminActive(this.f1928a.f1961e);
                }
                this.f1928a.f1963g = "com.domobile.elock.device_admin";
            } else if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
                if (this.f1928a.f1958W == 0) {
                    this.f1928a.f1958W = 1;
                }
                if (this.f1928a.f1958W == 1) {
                    LockService.m2164a(context);
                }
            } else if ("com.domobile.elock.ACTION_LOCK_THEME_CHANGED".equals(action) || "com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED".equals(action)) {
                LockService.f1934k = null;
            } else if ("com.domobile.elock.ACTION_KILL_BACKGROUND_PROCESS".equals(action)) {
                if (this.f1928a.f1952Q == null || !this.f1928a.f1952Q.m2863b()) {
                    this.f1928a.f1959X.sendEmptyMessageDelayed(1, 100);
                }
            } else if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                this.f1928a.f1954S = System.currentTimeMillis();
            } else if ("com.domobile.applock.ACTION_STOP_WATCHDOG_AFTER_SCREEN_OFF".equals(action)) {
                if (!this.f1928a.m2221r()) {
                    this.f1928a.f1951P.f2219A = false;
                    this.f1928a.f1959X.sendEmptyMessage(0);
                }
            } else if ("com.domobile.applock.ACTION_ADS_PARAMS_CHANGED".equals(action)) {
                this.f1928a.f1938B = C1342b.m3318a(context, "interstitial_hour_gap", 1);
                this.f1928a.f1937A = C1342b.m3318a(context, "interstitial_mode_switcher", 1);
            }
        }
    }

    private class C1062b extends BroadcastReceiver {
        final /* synthetic */ LockService f1929a;

        private C1062b(LockService lockService) {
            this.f1929a = lockService;
        }

        public void onReceive(Context context, Intent intent) {
            if (!"com.domobile.applock.ACTION_FORCE_STOP_LOCKSERVICE".equals(intent.getAction())) {
                this.f1929a.startForeground(R.id.notify_foreground, C1150y.m2555T(context));
                context.stopService(new Intent(context.getApplicationContext(), ProtectorLockService.class));
                try {
                    context.getApplicationContext().unregisterReceiver(this);
                } catch (Exception e) {
                }
            } else if (LockService.f1932b && !this.f1929a.f1946K) {
                this.f1929a.m2189d();
                this.f1929a.f1959X.sendEmptyMessageDelayed(1, 1000);
            }
        }
    }

    static {
        boolean z = true;
        if (C1150y.O <= 14) {
            z = false;
        }
        f1933c = z;
    }

    private void m2163a(int i) {
        if (this.f1975v.f437l) {
            i = 1000;
        }
        if (i != this.f1977x) {
            m2199g();
            this.f1977x = i;
            this.f1969p.setRepeating(3, ((long) this.f1977x) + SystemClock.elapsedRealtime(), (long) this.f1977x, this.f1939C);
            m2178b(this.f1977x);
        }
    }

    public static void m2164a(Context context) {
        if (m2190d(context)) {
            f1934k.mo2467b(2 == context.getResources().getConfiguration().orientation);
        }
    }

    public static void m2165a(Context context, C1150y c1150y) {
        c1150y.f2228m = 0;
        C1342b.m3326a(context, "interstitial_gap_now", Integer.valueOf(c1150y.f2228m));
        c1150y.f2229n++;
        C1342b.m3326a(context, "interstitial_times_today", Integer.valueOf(c1150y.f2229n));
        C1342b.m3326a(context, "interstitial_show_timemills", Long.valueOf(System.currentTimeMillis()));
        C1150y.m2545J(context);
    }

    public static void m2166a(Context context, String str) {
        m2167a(context, str, false);
    }

    public static void m2167a(Context context, String str, boolean z) {
        f1930H = str;
        if (m2190d(context)) {
            f1934k.mo2460a(str, z);
            return;
        }
        if (f1936m != null) {
            f1936m.f1951P.f2225j = C1150y.m2544I(context);
            if (f1936m.f1951P.f2231p) {
                f1936m.m2181b(true);
                f1936m.f1959X.sendEmptyMessageDelayed(5, 2000);
            }
        }
        if (C1150y.m2536A(context)) {
            if (C1102c.m2400c(context)) {
                if (f1934k == null || !(f1934k instanceof C0971d)) {
                    f1934k = new C0971d(context, str, z);
                } else {
                    f1934k.mo2460a(str, z);
                }
                f1934k.mo2462d();
                return;
            }
            if (f1934k == null || !(f1934k instanceof C1381n)) {
                f1934k = new C1381n(context, str, z);
            } else {
                f1934k.mo2460a(str, z);
            }
            f1934k.mo2462d();
        } else if (C1102c.m2400c(context)) {
            if (f1934k == null || !(f1934k instanceof C0966b)) {
                f1934k = new C0966b(context, str, z);
            } else {
                f1934k.mo2460a(str, z);
            }
            f1934k.mo2462d();
        } else {
            if (f1934k == null || !(f1934k instanceof C1375l)) {
                f1934k = new C1375l(context, str, z);
            } else {
                f1934k.mo2460a(str, z);
            }
            f1934k.mo2462d();
        }
    }

    private void m2168a(Context context, boolean z) {
        this.f1946K = z;
        if (z) {
            m2167a(context, "com.android.phone", true);
            return;
        }
        m2226a(false, false, true, 0);
        if (f1931a) {
            C1150y c1150y = this.f1951P;
            C1150y.m2613c((Context) this);
        }
    }

    public static boolean m2172a() {
        return f1935l;
    }

    private boolean m2174a(String str) {
        try {
            if (ViewGroup.class.isAssignableFrom(Class.forName(str))) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static LockService m2176b() {
        return f1936m;
    }

    private static C0964f m2177b(Context context, String str, boolean z) {
        return C1150y.m2536A(context) ? C1102c.m2400c(context) ? new C0971d(context, str, z) : new C1381n(context, str, z) : C1102c.m2400c(context) ? new C0966b(context, str, z) : new C1375l(context, str, z);
    }

    private void m2178b(int i) {
        if (f1932b) {
            this.f1959X.removeMessages(4);
            this.f1959X.sendEmptyMessageDelayed(4, (long) i);
        }
    }

    private void m2180b(final String str) {
        File file = new File(C1277a.m3057a(str));
        if (file == null || !file.exists()) {
            new Thread(this) {
                final /* synthetic */ LockService f1926b;

                public void run() {
                    Bitmap b = C1277a.m3060b(str);
                    if (b != null) {
                        b.recycle();
                    }
                }
            }.start();
        }
    }

    private void m2181b(boolean z) {
        this.f1950O = z;
        C1148d.m2520b((Context) this, "show_initialed_ad_after_unlock", (Object) Boolean.valueOf(this.f1950O));
    }

    private void m2186c() {
        if (f1932b) {
            this.f1957V = true;
            stopService(new Intent(this, ProtectorLockService.class));
            IntentFilter intentFilter = new IntentFilter("com.domobile.applock.ACTION_PROTECTOR_SERVICE_COMPLETE");
            intentFilter.addAction("com.domobile.applock.ACTION_FORCE_STOP_LOCKSERVICE");
            registerReceiver(new C1062b(), intentFilter);
            startService(new Intent(this, ProtectorLockService.class));
        }
    }

    private void m2187c(Context context) {
        if (this.f1974u != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f1976w >= 1500) {
                boolean a;
                this.f1976w = currentTimeMillis;
                if (f1932b && this.f1951P.f2219A) {
                    Runtime.getRuntime().gc();
                }
                if (this.f1951P.f2235t) {
                    a = SwitcherLockReceiver.m2098a(this.f1974u);
                    if (this.f1951P.f2237v == a) {
                        this.f1979z = false;
                    } else if (C1150y.m2592a(context, "android.net.conn.CONNECTIVITY_CHANGE", false)) {
                        C0721a.m997b(context, "key_locked_2g3g_state", a);
                    } else {
                        SwitcherLockReceiver.m2097a((Context) this, this.f1951P.f2237v);
                        if (!this.f1979z) {
                            this.f1979z = true;
                            SwitcherLockReceiver.m2096a(this, "android.net.conn.CONNECTIVITY_CHANGE", true);
                        } else {
                            return;
                        }
                    }
                }
                if (this.f1951P.f2234s) {
                    a = this.f1973t.isWifiEnabled();
                    if (this.f1951P.f2236u == a) {
                        this.f1978y = false;
                    } else if (C1150y.m2592a(context, "android.net.wifi.WIFI_STATE_CHANGED", false)) {
                        C0721a.m997b(context, "key_locked_wifi_state", a);
                    } else {
                        this.f1973t.setWifiEnabled(this.f1951P.f2236u);
                        if (!this.f1978y) {
                            this.f1978y = true;
                            SwitcherLockReceiver.m2096a(this, "android.net.wifi.WIFI_STATE_CHANGED", true);
                        }
                    }
                }
            }
        }
    }

    private void m2189d() {
        this.f1957V = false;
        stopForeground(true);
    }

    private static boolean m2190d(Context context) {
        AppLockApplication appLockApplication = (AppLockApplication) context.getApplicationContext();
        return f1934k != null && (appLockApplication.f427b || appLockApplication.f426a);
    }

    @TargetApi(19)
    private void m2193e() {
        try {
            this.f1971r.stopWatchingMode(this.f1972s);
        } catch (Throwable th) {
        }
        this.f1975v.f437l = false;
        C1148d.m2509a((Context) this, this.f1943G);
        m2199g();
    }

    private void m2194e(Context context) {
        if (f1932b) {
            int myPid = Process.myPid();
            MemoryInfo[] processMemoryInfo = this.f1967n.getProcessMemoryInfo(new int[]{myPid});
            if (processMemoryInfo != null && ((long) processMemoryInfo[0].getTotalPss()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID > 40) {
                context.sendBroadcast(new Intent("com.domobile.applock.ACTION_FORCE_STOP_LOCKSERVICE"));
                this.f1969p.setExact(3, SystemClock.elapsedRealtime() + 15000, this.f1940D);
            }
        }
        if (this.f1951P.f2222g) {
            this.f1941E.clear();
            this.f1965i = "";
            this.f1963g = "";
            C1148d.m2534y(context, "last_unlock_pkg");
        } else if (this.f1951P.f2241z) {
            this.f1964h = "";
            if (TextUtils.equals(C1150y.m2616d(context), "SCREEN_OFF")) {
                this.f1941E.clear();
                this.f1965i = "";
                this.f1963g = "";
                C1148d.m2534y(context, "last_unlock_pkg");
            } else if (TextUtils.equals(this.f1963g, this.f1965i)) {
                this.f1941E.put(this.f1963g, Long.valueOf(System.currentTimeMillis() + ((long) this.f1951P.f2240y)));
                this.f1965i = "";
                this.f1963g = "";
                C1148d.m2534y(context, "last_unlock_pkg");
            }
        }
    }

    private void m2197f() {
        m2163a(300);
    }

    private void m2199g() {
        this.f1977x = 0;
        try {
            if (this.f1939C != null) {
                this.f1969p.cancel(this.f1939C);
            }
        } catch (Exception e) {
        }
        this.f1959X.removeMessages(4);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2202h() {
        /*
        r4 = this;
        r0 = r4.f1942F;
        r0.clear();
        r0 = r4.f1948M;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = 0;
        r0 = com.domobile.applock.C1017n.m2032a();	 Catch:{ Exception -> 0x0033, all -> 0x0040 }
        if (r0 == 0) goto L_0x003a;
    L_0x0011:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        if (r1 <= 0) goto L_0x003a;
    L_0x0017:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        if (r1 == 0) goto L_0x003a;
    L_0x001d:
        r1 = 1;
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        if (r1 != 0) goto L_0x0017;
    L_0x0028:
        r1 = 1;
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        r2 = r4.f1942F;	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        r2.put(r1, r1);	 Catch:{ Exception -> 0x0033, all -> 0x004a }
        goto L_0x0017;
    L_0x0033:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0009;
    L_0x0036:
        r0.close();
        goto L_0x0009;
    L_0x003a:
        if (r0 == 0) goto L_0x0009;
    L_0x003c:
        r0.close();
        goto L_0x0009;
    L_0x0040:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0044:
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.close();
    L_0x0049:
        throw r0;
    L_0x004a:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.service.LockService.h():void");
    }

    private void m2203i() {
        m2178b(this.f1977x);
        if (!this.f1955T) {
            m2187c((Context) this);
            if (!this.f1975v.f437l) {
                m2205j();
            }
        }
    }

    private void m2205j() {
        RunningTaskInfo runningTaskInfo;
        if (f1931a) {
            if (!this.f1956U || this.f1970q == null) {
                this.f1962f = C1150y.m2600b(this.f1967n);
            } else {
                this.f1962f = C1150y.m2574a(this.f1970q);
                if (this.f1962f == null) {
                    this.f1962f = this.f1963g;
                    runningTaskInfo = null;
                }
            }
            runningTaskInfo = null;
        } else {
            runningTaskInfo = C1150y.m2563a(this.f1967n);
            if (runningTaskInfo != null) {
                this.f1962f = runningTaskInfo.topActivity.getPackageName();
            } else {
                return;
            }
        }
        if (f1931a) {
            m2224a(null, this.f1962f);
        } else {
            m2224a(runningTaskInfo.topActivity.getClassName(), this.f1962f);
        }
    }

    private void m2208k() {
        if (System.currentTimeMillis() - this.f1954S < 1000) {
            if (this.f1951P.f2232q) {
                m2181b(false);
            } else {
                return;
            }
        }
        if (this.f1950O && C1150y.m2641l(this) && !this.f1951P.f2224i && this.f1951P.f2225j) {
            if (this.f1937A == 2) {
                C1147a.m2482b("time interval:", Long.valueOf(Math.abs(C1342b.m3319a((Context) this, "interstitial_show_timemills", 0) - System.currentTimeMillis())), "  ", Long.valueOf(((long) this.f1938B) * 3600000));
                if (Math.abs(C1342b.m3319a((Context) this, "interstitial_show_timemills", 0) - System.currentTimeMillis()) < ((long) this.f1938B) * 3600000) {
                    return;
                }
            }
            C1147a.m2481a((Object) "showInitialerAd：" + this.f1951P.f2228m);
            String str = "interstitial_times_date";
            Object format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
            if (format.equals(C1342b.m3323a((Context) this, "interstitial_times_date", ""))) {
                if (this.f1951P.f2228m < (this.f1951P.f2229n == 0 ? C1342b.m3318a((Context) this, "interstitial_first_gap", 1) : this.f1951P.f2226k)) {
                    C1150y c1150y = this.f1951P;
                    c1150y.f2228m++;
                    C1342b.m3326a((Context) this, "interstitial_gap_now", Integer.valueOf(this.f1951P.f2228m));
                    return;
                } else if (this.f1951P.f2229n >= this.f1951P.f2227l) {
                    return;
                }
            }
            this.f1951P.f2229n = 0;
            this.f1951P.f2228m = 0;
            C1342b.m3326a((Context) this, str, format);
            C1342b.m3326a((Context) this, "interstitial_times_today", Integer.valueOf(this.f1951P.f2229n));
            C1342b.m3326a((Context) this, "interstitial_gap_now", Integer.valueOf(this.f1951P.f2228m));
            return;
            m2209l();
            m2181b(false);
        } else if (this.f1952Q != null && !this.f1952Q.m2863b() && this.f1951P.f2232q) {
            m2181b(false);
            this.f1952Q.m2866e();
        }
    }

    private void m2209l() {
        JSONObject j = C1342b.m3348j(this);
        if (j != null) {
            String optString = j.optString("ad_pic");
            if (!(TextUtils.isEmpty(optString) || TextUtils.equals(C1342b.m3323a((Context) this, "domobile_custom_ad_showed", null), optString))) {
                File file = new File(C1277a.m3057a(optString));
                if (file != null && file.exists()) {
                    m2165a((Context) this, this.f1951P);
                    startActivity(new Intent(this, DoMobileFullScreenAdActivity.class).setFlags(268435456));
                    return;
                }
            }
        }
        if (!this.f1951P.f2230o && this.f1953R != null) {
            startActivity(new Intent(this, TargetAdmobInterstitialActivity.class).setFlags(268435456));
        } else if (this.f1952Q == null) {
        } else {
            if (this.f1952Q.m2863b()) {
                m2165a((Context) this, this.f1951P);
                this.f1952Q.m2862a();
                return;
            }
            this.f1952Q.m2866e();
        }
    }

    private void m2211m() {
        if (!this.f1963g.contains(this.f1966j) && this.f1951P.f2241z && !TextUtils.isEmpty(this.f1963g) && this.f1942F.containsKey(this.f1963g)) {
            if (this.f1941E.size() > 0 && this.f1951P.f2240y < Integer.MAX_VALUE) {
                Iterator it = this.f1941E.entrySet().iterator();
                long currentTimeMillis = System.currentTimeMillis();
                while (it.hasNext()) {
                    if (((Long) ((Entry) it.next()).getValue()).longValue() <= currentTimeMillis) {
                        it.remove();
                    }
                }
            }
            if (TextUtils.equals(this.f1963g, this.f1965i)) {
                this.f1941E.put(this.f1963g, Long.valueOf(System.currentTimeMillis() + ((long) this.f1951P.f2240y)));
                this.f1965i = "";
            }
        }
    }

    private void m2214n() {
        if (this.f1951P.f2241z && this.f1941E != null) {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f1941E.entrySet()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", entry.getKey());
                    jSONObject.put("value", (Long) entry.getValue());
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                }
            }
            C1148d.m2518a(jSONArray.toString(), new File(getFilesDir(), "short_exit_map").getAbsolutePath());
        }
    }

    private void m2216o() {
        if (this.f1951P.f2241z) {
            if (this.f1941E == null) {
                this.f1941E = new HashMap();
            }
            File file = new File(getFilesDir(), "short_exit_map");
            if (file.exists()) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONArray jSONArray = new JSONArray(C3613c.m15742f(file));
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        long optLong = jSONObject.optLong("value");
                        if (optLong > currentTimeMillis) {
                            this.f1941E.put(jSONObject.optString("key"), Long.valueOf(optLong));
                        }
                    }
                    file.delete();
                } catch (Exception e) {
                }
            }
        }
    }

    private void m2218p() {
        if (!this.f1951P.f2224i && this.f1951P.f2225j) {
            if (this.f1937A == 2) {
                C1147a.m2482b("time interval:", Long.valueOf(Math.abs(C1342b.m3319a((Context) this, "interstitial_show_timemills", 0) - System.currentTimeMillis())), "  ", Long.valueOf(((long) this.f1938B) * 3600000));
                if (Math.abs(C1342b.m3319a((Context) this, "interstitial_show_timemills", 0) - System.currentTimeMillis()) < ((long) this.f1938B) * 3600000) {
                    return;
                }
            }
            if (this.f1951P.f2228m < (this.f1951P.f2229n == 0 ? C1342b.m3318a((Context) this, "interstitial_first_gap", 1) : this.f1951P.f2226k)) {
                return;
            }
            if (this.f1951P.f2229n >= this.f1951P.f2227l) {
                return;
            }
            if (this.f1953R == null) {
                this.f1953R = new C1215a();
            }
            JSONObject j = C1342b.m3348j(this);
            if (j != null) {
                String optString = j.optString("ad_pic");
                if (!(TextUtils.isEmpty(optString) || TextUtils.equals(C1342b.m3323a((Context) this, "domobile_custom_ad_showed", null), optString))) {
                    File file = new File(C1277a.m3057a(optString));
                    if (file == null || !file.exists()) {
                        m2180b(optString);
                    } else {
                        return;
                    }
                }
            }
            if (this.f1951P.f2230o) {
                if (this.f1952Q != null) {
                    if (!this.f1952Q.m2864c()) {
                        if (this.f1952Q.m2863b() && !this.f1952Q.m2865d()) {
                            return;
                        }
                    }
                    return;
                }
                m2220q();
            }
        }
    }

    private void m2220q() {
        int b = C1342b.m3331b(this);
        if (b == 1) {
            this.f1952Q = new C1219d(this.f1953R);
            this.f1952Q.f2402b.m3795a(new C10573(this));
            try {
                this.f1952Q.f2402b.m3794a();
            } catch (Exception e) {
            }
        } else if (b == 0) {
            this.f1952Q = new C1219d(this.f1953R, C1148d.m2524c((Context) this, "key_actived_admob_publishid", "ca-app-pub-4885652974540015/9196455687"));
            AdRequest build = new Builder().build();
            this.f1952Q.f2401a.setAdListener(new C10584(this));
            try {
                this.f1952Q.f2401a.loadAd(build);
            } catch (Exception e2) {
            }
        }
    }

    @TargetApi(20)
    private boolean m2221r() {
        PowerManager powerManager = (PowerManager) getSystemService("power");
        return C1150y.O >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    public void m2224a(String str, CharSequence charSequence) {
        this.f1962f = (String) charSequence;
        if (this.f1951P.f2239x && "com.android.settings".equals(this.f1962f) && !f1931a && "com.android.settings.DeviceAdminAdd".equals(str)) {
            if (!"com.domobile.elock.device_admin".equals(this.f1963g)) {
                if (!this.f1963g.equals(this.f1962f)) {
                    m2211m();
                }
                this.f1963g = "com.domobile.elock.device_admin";
                m2166a((Context) this, "com.domobile.elock.device_admin");
            }
        } else if (!this.f1962f.equals(this.f1963g)) {
            if (!f1931a || !this.f1946K) {
                Object[] objArr = new Object[8];
                objArr[0] = "pkgname_before:";
                objArr[1] = this.f1963g;
                objArr[2] = "  class:";
                String str2 = (f1931a || this.f1975v.f437l) ? this.f1962f : str;
                objArr[3] = str2;
                objArr[4] = "  isFingerActivityCreated:";
                objArr[5] = Boolean.valueOf(this.f1975v.f436k);
                objArr[6] = "   isCalling:";
                objArr[7] = Boolean.valueOf(this.f1946K);
                C1147a.m2482b(objArr);
                if (!this.f1963g.equals(this.f1966j)) {
                    C1148d.m2534y(this, "last_unlock_pkg");
                }
                if (!this.f1962f.equals(this.f1966j)) {
                    this.f1975v.f436k = false;
                } else if (!AppLockApplication.m578c().f440o && this.f1951P.f2233r && !this.f1975v.f437l && this.f1975v.f436k) {
                    return;
                }
                m2211m();
                if (f1931a && !this.f1975v.f437l) {
                    str = this.f1962f;
                }
                boolean containsKey = this.f1975v.m587b((Context) this).containsKey(this.f1962f);
                if (!containsKey && !"com.android.systemui.recent.RecentsActivity".startsWith(str)) {
                    m2197f();
                } else if (!m2174a(str)) {
                    this.f1963g = this.f1962f;
                    m2163a(150);
                    if (containsKey) {
                        m2226a(true, false, false, 0);
                        m2208k();
                    }
                    if (f1934k == null) {
                        f1934k = m2177b(this, null, false);
                        f1934k.mo2468c();
                    }
                    this.f1949N = true;
                    if (containsKey) {
                        return;
                    }
                } else {
                    return;
                }
                if (this.f1942F.containsKey(this.f1962f)) {
                    this.f1963g = this.f1962f;
                    if (this.f1951P.f2241z && this.f1941E.containsKey(this.f1962f)) {
                        if (System.currentTimeMillis() <= ((Long) this.f1941E.get(this.f1962f)).longValue()) {
                            this.f1965i = this.f1962f;
                            C1148d.m2520b((Context) this, "last_unlock_pkg", (Object) this.f1965i);
                            if (this.f1949N) {
                                this.f1959X.sendEmptyMessageDelayed(1, 100);
                            }
                            this.f1949N = false;
                            if (!this.f1946K) {
                                m2226a(true, false, false, 0);
                                return;
                            }
                            return;
                        }
                        this.f1941E.remove(this.f1962f);
                    }
                    m2166a((Context) this, this.f1962f);
                } else if (!m2174a(str)) {
                    this.f1963g = this.f1962f;
                    C1150y.m2583a((Context) this, "last_unlock_pkg", this.f1962f);
                    if (!this.f1946K) {
                        m2226a(true, false, false, 0);
                    }
                    if (this.f1949N && !this.f1946K) {
                        this.f1959X.sendEmptyMessageDelayed(1, 100);
                    }
                    this.f1949N = false;
                }
            }
        }
    }

    public void m2225a(boolean z) {
        if (f1933c) {
            this.f1975v.f437l = z;
            m2197f();
        }
    }

    public void m2226a(boolean z, boolean z2, boolean z3, long j) {
        if (m2190d((Context) this)) {
            f1934k.mo2461a(z, z2, z3, j);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1958W == 0) {
            this.f1958W = 2;
        }
        if (this.f1958W == 2) {
            m2164a((Context) this);
        }
    }

    public void onCreate() {
        boolean z = true;
        super.onCreate();
        setTheme(R.style.Theme_Default_AppCompat_Light_NoActionBar);
        f1936m = this;
        this.f1975v = C1150y.m2566a((Context) this);
        this.f1951P = this.f1975v.m591e();
        if (this.f1951P.f2238w) {
            this.f1956U = C1150y.m2553R(this);
            this.f1975v.f437l = false;
            if (f1933c && C1150y.m2554S(this)) {
                this.f1975v.f437l = MyAccessibilityService.m1a((Context) this, MyAccessibilityService.class.getName());
            }
            f1935l = true;
            this.f1948M = C1217c.m2853a() == null;
            this.f1947L = !C1150y.m2614c((Context) this, "first_launch");
            this.f1938B = C1342b.m3318a((Context) this, "interstitial_hour_gap", 1);
            this.f1937A = C1342b.m3318a((Context) this, "interstitial_mode_switcher", 1);
            this.f1955T = C1150y.m2596b((Context) this, "actived_profile", -100) == -1;
            this.f1973t = (WifiManager) C1150y.m2640l(this, "wifi");
            this.f1974u = (ConnectivityManager) C1150y.m2640l(this, "connectivity");
            C0721a.m996a(this, "key_locked_wifi_state");
            C0721a.m996a(this, "key_locked_2g3g_state");
            this.f1951P.f2234s = C0721a.m998b(this, "key_locked_wifi_state");
            this.f1951P.f2235t = C0721a.m998b(this, "key_locked_2g3g_state");
            this.f1968o = getPackageManager();
            this.f1941E = new HashMap();
            Intent intent = new Intent(this, LockService.class);
            this.f1967n = (ActivityManager) C1150y.m2640l(this, "activity");
            this.f1969p = (AlarmManager) C1150y.m2640l(this, "alarm");
            this.f1939C = PendingIntent.getService(this, 0, intent, 0);
            this.f1960d = (DevicePolicyManager) C1150y.m2640l(this, "device_policy");
            this.f1961e = new ComponentName(this, AppLockDeviceAdminReceiver.class);
            if (this.f1960d != null) {
                this.f1951P.f2239x = this.f1960d.isAdminActive(this.f1961e);
            }
            this.f1940D = PendingIntent.getBroadcast(this, 0, new Intent("com.domobile.applock.ACTION_STOP_WATCHDOG_AFTER_SCREEN_OFF"), 0);
            if (f1931a) {
                this.f1970q = (UsageStatsManager) C1150y.m2640l(this, "usagestats");
                this.f1971r = (AppOpsManager) C1150y.m2640l(this, "appops");
                this.f1972s = new C10562(this);
                try {
                    this.f1971r.startWatchingMode("android:get_usage_stats", getPackageName(), this.f1972s);
                } catch (Throwable th) {
                }
            }
            if (this.f1948M || this.f1947L) {
                stopSelf();
                return;
            }
            this.f1963g = C1150y.m2602b((Context) this, "last_unlock_pkg");
            this.f1965i = this.f1963g;
            this.f1966j = getPackageName();
            m2202h();
            this.f1951P.f2240y = C1150y.m2623f(C1150y.m2616d((Context) this));
            C1150y c1150y = this.f1951P;
            if (this.f1951P.f2240y <= 0) {
                z = false;
            }
            c1150y.f2241z = z;
            this.f1951P.f2222g = C1150y.m2614c((Context) this, "lock_after_screen_on");
            m2216o();
            this.f1950O = C1150y.m2592a((Context) this, "show_initialed_ad_after_unlock", false);
            if (this.f1950O) {
                m2218p();
            }
            m2197f();
            this.f1943G = new C1061a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.addAction("com.domobile.elock.proctect_list_change");
            intentFilter.addAction("com.domobile.elock.verify_pass");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("com.domobile.elock.LOCK_CLOSE_WITH_BACK");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction("com.domobile.elock.ACTION_DEVICE_ADMIN_STATUS_CHENGED");
            intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            intentFilter.addAction("com.domobile.elock.ACTION_KILL_BACKGROUND_PROCESS");
            intentFilter.addAction("com.domobile.elock.ACTION_LOCK_THEME_CHANGED");
            intentFilter.addAction("com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED");
            intentFilter.addAction("com.domobile.applock.ACTION_ADS_PARAMS_CHANGED");
            registerReceiver(this.f1943G, intentFilter);
            registerReceiver(this.f1943G, new IntentFilter("com.domobile.applock.ACTION_STOP_WATCHDOG_AFTER_SCREEN_OFF"), "com.domobile.applock.PERMISSON_STOP_WATCHDOG_AFTER_SCREEN_OFF", null);
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.domobile.applock.ACTION_CALL_STATE_IDLE");
            intentFilter.addAction("com.domobile.applock.ACTION_CALL_STATE_RINGING");
            registerReceiver(this.f1943G, intentFilter, "com.domobile.applock.SEND_CALL_STATE_BROADCAST", null);
            m2186c();
            return;
        }
        m2199g();
        stopSelf();
    }

    public void onDestroy() {
        f1936m = null;
        m2214n();
        f1935l = false;
        m2193e();
        if (this.f1948M || this.f1947L) {
            super.onDestroy();
            return;
        }
        this.f1951P.f2238w = C1150y.m2627g((Context) this);
        if (this.f1951P.f2238w) {
            startActivity(new Intent(this, MainActivity.class).addFlags(268435456));
        } else {
            SwitcherLockReceiver.m2094a((Context) this);
            C1148d.m2534y(this, "last_unlock_pkg");
        }
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        try {
            m2203i();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
