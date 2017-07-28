package com.domobile.applock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.domobile.applock.p003a.C0621h;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.service.LockService;
import com.domobile.applock.service.StepWindowService;
import com.domobile.applock.service.UpdateService.C1070c;
import com.domobile.eframe.ui.SlidingLeftMenu;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.libs_ads.C1342b;
import com.domobile.lockbean.C1382o;
import com.google.android.exoplayer2.Format;
import java.io.File;

public class MainTabFragmentActivity extends C0386c {
    private static MainTabFragmentActivity f489k;
    public int f490d = 0;
    public boolean f491e = false;
    private AppLockApplication f492l;
    private boolean f493m = false;
    private C1276e f494n = null;
    private SlidingLeftMenu f495o;
    private C0621h f496p;
    private boolean f497q = false;
    private int f498r = -1;
    private Handler f499s = new C05921(this);
    private BroadcastReceiver f500t = new C05953(this);

    class C05921 extends Handler {
        final /* synthetic */ MainTabFragmentActivity f476a;

        C05921(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f476a = mainTabFragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                    if (C1150y.m2554S(this.f476a.getBaseContext())) {
                        C1147a.m2486e(this.f476a, R.string.power_save_mode_success);
                        return;
                    }
                    C1147a.m2488x(this.f476a, this.f476a.getString(R.string.power_save_mode_disabled, new Object[]{this.f476a.getString(R.string.protect)}));
                    return;
                case 258:
                    this.f476a.m617F();
                    return;
                case 259:
                    C1147a.m2488x(this.f476a, this.f476a.getString(R.string.power_save_mode_failed, new Object[]{this.f476a.getString(R.string.protect)}));
                    return;
                default:
                    return;
            }
        }
    }

    class C05953 extends BroadcastReceiver {
        final /* synthetic */ MainTabFragmentActivity f481a;

        C05953(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f481a = mainTabFragmentActivity;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.domobile.elock.main_finish".equals(action)) {
                this.f481a.finish();
            } else if ("com.domobile.applock.ACTION_POWER_SAVE_MODE_CHANGED".equals(action)) {
                C1382o.m3517a().m3519b(context, -1);
                this.f481a.f499s.sendEmptyMessageDelayed(InputDeviceCompat.SOURCE_KEYBOARD, 1000);
            }
        }
    }

    class C05964 implements OnClickListener {
        final /* synthetic */ MainTabFragmentActivity f482a;

        C05964(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f482a = mainTabFragmentActivity;
        }

        public void onClick(View view) {
            C1148d.m2520b(this.f482a, "enable_power_save_mode", (Object) Boolean.valueOf(false));
        }
    }

    class C05986 implements OnClickListener {
        final /* synthetic */ MainTabFragmentActivity f485a;

        C05986(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f485a = mainTabFragmentActivity;
        }

        public void onClick(View view) {
            try {
                this.f485a.m80e();
                MainTabFragmentActivity.f489k.startActivity(C1150y.m2564a(this.f485a));
            } catch (Exception e) {
            }
        }
    }

    class C05997 implements OnClickListener {
        final /* synthetic */ MainTabFragmentActivity f486a;

        C05997(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f486a = mainTabFragmentActivity;
        }

        public void onClick(View view) {
            C1148d.m2520b(this.f486a, "last_secure_level", (Object) Boolean.valueOf(false));
        }
    }

    class C06008 implements OnClickListener {
        final /* synthetic */ MainTabFragmentActivity f487a;

        C06008(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f487a = mainTabFragmentActivity;
        }

        public void onClick(View view) {
            MainTabFragmentActivity.m627a(this.f487a, (int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
    }

    class C06019 implements OnClickListener {
        final /* synthetic */ MainTabFragmentActivity f488a;

        C06019(MainTabFragmentActivity mainTabFragmentActivity) {
            this.f488a = mainTabFragmentActivity;
        }

        public void onClick(View view) {
            this.f488a.m78a(false);
        }
    }

    private void m617F() {
        startService(new Intent(this, LockService.class));
        String string = getString(R.string.sdcard_tip_filename);
        String string2 = getString(R.string.sdcard_tip_for_backup_filename);
        try {
            File parentFile = this.f492l.m599m().getParentFile();
            File file = new File(parentFile, string);
            if (!file.exists()) {
                file.createNewFile();
            }
            File file2 = new File(parentFile, string2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Exception e) {
        }
        this.f495o.m2924b();
        this.f490d = C1148d.m2499a((Context) this, "lockactivity_open_times", 0);
        this.f490d++;
        C1148d.m2520b((Context) this, "lockactivity_open_times", (Object) Integer.valueOf(this.f490d));
        if (C1148d.m2529f(this) != null) {
            return;
        }
        if ((C1148d.m2499a((Context) this, "enable_power_saving_warning_type", 2) == 2 && m640h()) || m618G() != null || m630b(false) != null || m619H() != null || m621J() != null || m622K() == null) {
        }
    }

    private C1288c m618G() {
        boolean G = C1150y.m2542G(this);
        return (C1150y.m2592a((Context) this, "last_secure_level", true) == G || G) ? null : m620I();
    }

    private C1288c m619H() {
        return (!C1150y.m2543H(this) || 20160421 <= ((long) C1150y.m2636j(this, "com.domobile.applockwatcher"))) ? null : new C1288c(this).m3123d((int) R.string.watcher_update).m3102a(17039360, null).m3114b(17039370, new C05986(this)).m3117b(true).m3122d();
    }

    private C1288c m620I() {
        C1288c c1288c = new C1288c(this);
        c1288c.m3101a((int) R.string.device_admin).m3117b(true);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3123d((int) R.string.ask_install_protector);
        c1288c.m3102a(17039360, new C05997(this));
        c1288c.m3114b(17039370, new C06008(this)).m3122d();
        return c1288c;
    }

    private C1288c m621J() {
        boolean z = false;
        boolean a = C1342b.m3330a((Context) this, "trial_end_alerted", false);
        if (C1342b.m3330a((Context) this, "trial_end_notified", false) || C1150y.m2598b((Context) this).f2224i) {
            z = true;
        }
        if (a || !r0 || !C1150y.m2641l(this) || !C1150y.m2544I(this)) {
            return null;
        }
        int l = C1342b.m3350l(this);
        int i = l > 0 ? R.string.trial_ended_title : R.string.trial_ended_title_zero;
        CharSequence string = getString(l > 0 ? R.string.trial_ended_message : R.string.trial_ended_message_zero);
        C1342b.m3326a((Context) this, "trial_end_alerted", Boolean.valueOf(true));
        C1288c c1288c = new C1288c(this);
        c1288c.m3101a(i).mo2528a(string);
        c1288c.m3114b(17039360, null);
        c1288c.m3102a((int) R.string.advance_user, new C06019(this));
        return c1288c.m3117b(true).m3122d();
    }

    private C1288c m622K() {
        if (!C1148d.m2535z(this, "lockactivity_last_rate")) {
            C1150y.m2581a((Context) this, "lockactivity_last_rate", System.currentTimeMillis() - 864000000);
        }
        if (System.currentTimeMillis() - C1150y.m2596b((Context) this, "lockactivity_last_rate", 0) <= 1296000000) {
            return null;
        }
        C1148d.m2520b((Context) this, "lockactivity_last_rate", (Object) Long.valueOf(System.currentTimeMillis()));
        CharSequence string = getString(R.string.applock_rate_message, new Object[]{getString(R.string.app_name)});
        C1288c c1288c = new C1288c(this);
        c1288c.m3101a((int) R.string.domo_rate).mo2528a(string);
        c1288c.m3102a((int) R.string.domo_later, new OnClickListener(this) {
            final /* synthetic */ MainTabFragmentActivity f474a;

            {
                this.f474a = r1;
            }

            public void onClick(View view) {
                this.f474a.f490d = 0;
                C1148d.m2534y(this.f474a.getBaseContext(), "lockactivity_open_times");
            }
        });
        c1288c.m3114b((int) R.string.domo_rate, new OnClickListener(this) {
            final /* synthetic */ MainTabFragmentActivity f475a;

            {
                this.f475a = r1;
            }

            public void onClick(View view) {
                this.f475a.f490d = 4;
                Context baseContext = this.f475a.getBaseContext();
                C1148d.m2520b(baseContext, "lockactivity_open_times", (Object) Integer.valueOf(4));
                C1150y.m2581a(baseContext, "lockactivity_last_rate", (long) Format.OFFSET_SAMPLE_RELATIVE);
                C1148d.m2493E(baseContext, this.f475a.getPackageName());
            }
        });
        return c1288c.m3117b(true).m3122d();
    }

    public static void m623a(final Activity activity, boolean z) {
        int i;
        if (z || !C1150y.m2542G(activity)) {
            i = R.string.secure_level_enable_failed;
            C1382o.m3517a().m3519b(activity, -2);
        } else {
            i = R.string.secure_level_enabled;
            C1382o.m3517a().m3519b(activity, -1);
        }
        final Handler handler = new Handler(activity.getMainLooper());
        handler.postDelayed(new Runnable() {

            class C05931 implements Runnable {
                final /* synthetic */ C05942 f477a;

                C05931(C05942 c05942) {
                    this.f477a = c05942;
                }

                public void run() {
                    activity.finish();
                }
            }

            public void run() {
                if (i == R.string.secure_level_enable_failed) {
                    Toast.makeText(activity, i, 1).show();
                    if (activity instanceof OpenAdvanceProtectActivity) {
                        handler.postDelayed(new C05931(this), 1000);
                    }
                }
            }
        }, 1000);
    }

    public static void m624a(Context context) {
        m633l().m80e();
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo;
            C1148d.m2512a(context, context.getString(R.string.domo_share_message_title), context.getString(R.string.domo_share_message, new Object[]{r1.applicationInfo.loadLabel(packageManager), r1.versionName, r1.packageName, r1.applicationInfo.loadLabel(packageManager)}), C1148d.m2506a(((BitmapDrawable) applicationInfo.loadIcon(packageManager)).getBitmap(), false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m625a(Context context, int i, int i2, int i3) {
    }

    public static void m627a(C0386c c0386c, int i) {
        C1148d.m2520b((Context) c0386c, "last_secure_level", (Object) Boolean.valueOf(true));
        C1150y.m2587a(c0386c, i);
    }

    public static boolean m628a(C0386c c0386c) {
        if (!LockService.f1931a || C1150y.m2553R(c0386c)) {
            return false;
        }
        C1150y.m2569a(c0386c);
        return true;
    }

    private C1288c m630b(final boolean z) {
        boolean S = C1150y.m2554S(this);
        if (S == C1150y.m2592a((Context) this, "enable_power_save_mode", false) || S) {
            return null;
        }
        if (z) {
            m625a(this, R.string.category_saving_power_dialog, R.string.action_dialog_showed, R.string.label_dialog_showed);
        }
        C1288c c1288c = new C1288c(this);
        c1288c.m3101a((int) R.string.save_power_mode);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3123d((int) R.string.save_power_mode_summary);
        c1288c.m3102a(17039360, new C05964(this));
        c1288c.m3114b(17039370, new OnClickListener(this) {
            final /* synthetic */ MainTabFragmentActivity f484b;

            public void onClick(View view) {
                if (z) {
                    this.f484b.m636a((int) R.string.category_saving_power_dialog);
                } else {
                    this.f484b.m636a(-1);
                }
            }
        }).m3122d();
        return c1288c;
    }

    public static boolean m631b(C0386c c0386c) {
        if (C1150y.O < 18 || C0898c.m1570b(c0386c)) {
            return false;
        }
        C1150y.m2599b(c0386c);
        return true;
    }

    public static void m632k() {
        if (f489k != null) {
            DrawerLayout drawerLayout = f489k.i;
            if (drawerLayout.isDrawerOpen(3)) {
                drawerLayout.closeDrawer(3);
            } else {
                drawerLayout.openDrawer(3);
            }
        }
    }

    public static MainTabFragmentActivity m633l() {
        return f489k;
    }

    public void mo2042a() {
        super.mo2042a();
    }

    public void m636a(int i) {
        boolean S = C1150y.m2554S(this);
        this.f498r = i;
        if (i != -1) {
            m625a(this, i, R.string.action_open_management_page, R.string.label_open_management_page);
        }
        C1148d.m2520b((Context) this, "enable_power_save_mode", (Object) Boolean.valueOf(true));
        if (!S) {
            this.f497q = true;
        }
        m80e();
        try {
            startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            StepWindowService.m2249a(this, -3);
        } catch (Exception e) {
        }
    }

    public boolean mo2046b() {
        return true;
    }

    public boolean m638b(C0386c c0386c, int i) {
        c0386c.f44a = -1;
        if (i != FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
            return false;
        }
        if (!C1150y.m2543H(c0386c)) {
            m623a((Activity) c0386c, true);
            return true;
        } else if (!C1150y.m2566a((Context) c0386c).f438m) {
            return true;
        } else {
            C1150y.m2566a((Context) c0386c).f438m = false;
            C1150y.m2582a((Context) c0386c, "auto_upgrade_secure_level", Boolean.valueOf(false));
            c0386c.m80e();
            OpenAdvanceProtectActivity.m646a((Context) c0386c);
            return true;
        }
    }

    public View mo2359g() {
        return getLayoutInflater().inflate(R.layout.activity_material_tab, null);
    }

    public boolean m640h() {
        if (C1150y.m2614c((Context) this, "enable_power_save_mode_warned")) {
            return false;
        }
        C1148d.m2520b((Context) this, "enable_power_save_mode", (Object) Boolean.valueOf(true));
        C1148d.m2520b((Context) this, "enable_power_save_mode_warned", (Object) Boolean.valueOf(true));
        m630b(true);
        return true;
    }

    public void mo2360i() {
        super.mo2360i();
        this.f495o.m2921a(0);
    }

    public void mo2361j() {
        super.mo2361j();
    }

    public View m643m() {
        return findViewById(R.id.tab_actionbar_layout);
    }

    public C0621h m644n() {
        return this.f496p;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f492l.f429d != null) {
            this.f492l.f429d.m560a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
        if (i == 4102 && !C1150y.m2543H(this)) {
            m80e();
            this.a = 4102;
            C1148d.m2495G(this, getPackageName());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f495o = (SlidingLeftMenu) findViewById(R.id.drawerlayout_left);
        this.f495o.setActivity(this);
        this.f496p = new C0621h(this);
        this.f492l = C1150y.m2566a((Context) this);
        f489k = this;
        this.f494n = new C1276e();
        C1148d.m2516a(this.f494n, new C1070c(this));
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        IntentFilter intentFilter = new IntentFilter("com.domobile.elock.main_finish");
        intentFilter.addAction("com.domobile.applock.ACTION_POWER_SAVE_MODE_CHANGED");
        registerReceiver(this.f500t, intentFilter);
        this.f499s.sendEmptyMessageDelayed(258, 300);
        getIntent().getStringExtra("com.domobile.applock.EXTRA_OPEN_ACTIVITY");
        m52a(new C1030p());
    }

    protected void onDestroy() {
        if (this.f494n != null && this.f494n.isCancelled()) {
            this.f494n.cancel(true);
        }
        C1150y.m2566a((Context) this).f434i = false;
        this.f493m = true;
        C1148d.m2509a((Context) this, this.f500t);
        if (!LockService.f1932b) {
            C1148d.m2489A(this, "com.domobile.elock.ACTION_KILL_BACKGROUND_PROCESS");
        }
        f489k = null;
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (m68t().isInSearchMode()) {
            m68t().clearSearch();
        } else if (this.i.isDrawerOpen(5)) {
            this.i.closeDrawers();
        } else if (this.i.isDrawerOpen(3)) {
            C1148d.m2528e(this);
        } else {
            this.i.openDrawer(3);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getRepeatCount() != 0) {
            return i != 4 ? super.onKeyUp(i, keyEvent) : true;
        } else {
            m632k();
            return true;
        }
    }

    protected void onResume() {
        super.onResume();
        this.f491e = true;
        boolean S = C1150y.m2554S(this);
        if (this.f498r != -1) {
            m625a(this, this.f498r, S ? R.string.action_enabled : R.string.action_disabled, S ? R.string.label_enabled : R.string.label_disabled);
            this.f498r = -1;
        }
        if (this.f497q && !S) {
            C1382o.m3517a().m3519b(this, -2);
            this.f499s.sendEmptyMessageDelayed(259, 1000);
        }
        this.f497q = false;
        C1148d.m2489A(this, "com.domobile.applock.ACTION_REMOVE_POWER_MODE_GUIDE_WINDOW");
        if (this.f495o != null) {
            this.f495o.m2922a((Context) this);
        }
        f489k = this;
        m638b(this, this.a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    protected void onStop() {
        if (!this.f491e) {
            m80e();
        }
        this.f491e = false;
        super.onStop();
    }
}
