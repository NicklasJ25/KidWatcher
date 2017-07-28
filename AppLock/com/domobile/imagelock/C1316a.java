package com.domobile.imagelock;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.domobile.applock.C0741f;
import com.domobile.applock.C1150y;
import com.domobile.applock.GuideActivity;
import com.domobile.applock.R;
import com.domobile.applock.RetrievePasswordActivity;
import com.domobile.applock.VerifyActivity;
import com.domobile.applock.chamber.p009c.C0810f;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.livelock.p006a.C0967c;
import com.domobile.applock.livelock.p014b.C0979d;
import com.domobile.applock.livelock.p014b.C0980e;
import com.domobile.applock.livelock.view.LivePatternView;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.theme.C1102c;
import com.domobile.eframe.C1224e;
import com.domobile.frame.p000a.C1258c;
import com.domobile.frame.ui.C1288c;
import com.domobile.imagelock.LockPatternView.C0950c;
import com.domobile.imagelock.LockPatternView.C1308a;
import com.domobile.imagelock.LockPatternView.C1309b;
import com.domobile.lockbean.C0960e;
import com.domobile.lockbean.C1360c;
import com.domobile.lockbean.C1365d.C0743a;
import com.domobile.lockbean.C1375l;
import com.domobile.lockbean.C1376m;
import com.domobile.widget.FingerPrintStateView;
import java.util.List;

public class C1316a extends C0741f implements C0743a {
    private LockPatternView f2833b;
    private C1318c f2834c;
    private int f2835d;
    private CountDownTimer f2836e;
    private View f2837f;
    private C1376m f2838g;
    private C0967c f2839h;
    private C1360c f2840i;
    private String f2841j = "";
    private int f2842k = 0;
    private C0950c f2843l = new C13134(this);

    class C13101 implements OnClickListener {
        final /* synthetic */ C1316a f2823a;

        C13101(C1316a c1316a) {
            this.f2823a = c1316a;
        }

        public void onClick(View view) {
            this.f2823a.m3229e();
        }
    }

    class C13112 implements OnClickListener {
        final /* synthetic */ C1316a f2824a;

        C13112(C1316a c1316a) {
            this.f2824a = c1316a;
        }

        public void onClick(View view) {
            this.f2824a.startActivityForResult(new Intent(this.f2824a.mActivity, RetrievePasswordActivity.class), PointerIconCompat.TYPE_CONTEXT_MENU);
        }
    }

    class C13134 implements C0950c {
        final /* synthetic */ C1316a f2827a;

        C13134(C1316a c1316a) {
            this.f2827a = c1316a;
        }

        public void mo2450a() {
            if (this.f2827a.f2833b != null) {
                this.f2827a.f2833b.m3212e();
            }
        }

        public void mo2451a(List<C1308a> list) {
            if (this.f2827a.f2834c == null || !this.f2827a.f2834c.m3246a((List) list)) {
                if (this.f2827a.f2833b != null) {
                    this.f2827a.m3221a(C1315a.NeedToUnlockWrong);
                    this.f2827a.f2833b.m3211d();
                }
                this.f2827a.m3236l();
                return;
            }
            this.f2827a.m3235k();
        }

        public void mo2452b() {
            if (this.f2827a.f2833b != null) {
                this.f2827a.f2833b.m3212e();
            }
        }

        public void mo2453b(List<C1308a> list) {
        }
    }

    private enum C1315a {
        NeedToUnlock,
        NeedToUnlockWrong,
        LockedOut
    }

    private void m3221a(C1315a c1315a) {
        switch (c1315a) {
            case NeedToUnlock:
                this.f2838g.m3492a((int) R.string.lockpattern_need_to_unlock);
                this.f2833b.setEnabled(true);
                this.f2833b.m3210c();
                return;
            case NeedToUnlockWrong:
                this.f2838g.m3492a((int) R.string.lockpattern_need_to_unlock_wrong);
                this.f2833b.setDisplayMode(C1309b.Wrong);
                this.f2833b.setEnabled(true);
                this.f2833b.m3210c();
                return;
            case LockedOut:
                this.f2833b.m3209b();
                this.f2833b.setEnabled(false);
                return;
            default:
                return;
        }
    }

    private void m3224a(C0960e c0960e) {
        Intent intent = this.mActivity.getIntent();
        View b;
        if ("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT".equals(intent.getAction())) {
            c0960e.m1733b(intent.getStringExtra("com.domobile.applock.EXTRA_PROFILE_NAME"));
            if (this.f2838g != null) {
                b = this.f2838g.m3494b();
                if (b != null) {
                    b.setVisibility(8);
                }
            }
        } else if (intent.getBooleanExtra("com.domobile.elock.EXTRA_GOTO_CHOOSEBG", false)) {
            c0960e.m1734c(R.string.unlock_background);
        } else if (!TextUtils.isEmpty(intent.getStringExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION"))) {
            r0 = intent.getStringExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION");
            r1 = SwitcherLockReceiver.m2092a(this.mActivity, r0);
            Drawable b2 = SwitcherLockReceiver.m2099b(this.mActivity, r0);
            c0960e.m1733b(r1);
            c0960e.mo2455a(b2);
            if (this.f2838g != null) {
                b = this.f2838g.m3494b();
                if (b != null) {
                    b.setVisibility(8);
                }
            }
        } else if (!TextUtils.isEmpty(intent.getStringExtra("unlock_app_action"))) {
            r1 = intent.getStringExtra("unlock_app_pkgname");
            r0 = intent.getStringExtra("unlock_app_appname");
            try {
                PackageManager packageManager = this.mActivity.getPackageManager();
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(r1, 0);
                c0960e.mo2455a(packageManager.getApplicationIcon(r1));
                if (TextUtils.isEmpty(r0)) {
                    c0960e.m1733b((String) packageManager.getApplicationLabel(applicationInfo));
                } else {
                    c0960e.m1733b(r0);
                }
            } catch (Exception e) {
            }
        }
    }

    private void m3229e() {
        this.f2842k = 0;
    }

    private void m3230f() {
        long q = C1150y.m2649q(this.mActivity);
        if (q != 0 && System.currentTimeMillis() - q <= 300000) {
            C1150y.m2589a(this.mActivity, 0);
            C1288c a = new C1288c(this.mActivity).mo2528a(getString(R.string.forget_passwd_title) + "?");
            a.m3102a((int) R.string.no, new C13101(this));
            a.m3114b((int) R.string.yes, new C13112(this)).m3122d();
        }
    }

    private void m3231g() {
        if (this.f2833b != null) {
            ((LinearLayoutWithDefaultTouchRecepient) findViewById(R.id.topLayout)).setDefaultTouchRecepient(this.f2833b);
            this.f2833b.setTactileFeedbackEnabled(C1318c.m3243a(this.f2833b.getContext()));
            this.f2833b.setOnPatternListener(this.f2843l);
            m3221a(C1315a.NeedToUnlock);
        }
    }

    private void m3232h() {
        if (C1102c.m2400c(this.mActivity)) {
            m3234j();
        } else {
            m3233i();
        }
        C0933d.m1650a(this.mActivity, findViewById(R.id.verify_fakeview));
    }

    private void m3233i() {
        boolean e = C1102c.m2405e(this.mActivity);
        this.f2838g = new C1376m(this.mActivity, null, e, false);
        int a = C1102c.m2380a(e, 2);
        ((ViewGroup) findViewById(R.id.pattern_board_container)).addView(getLayoutInflater().inflate(C1102c.m2381a(this.mActivity, C1102c.m2385a(this.mActivity), a), null));
        this.f2838g.m3493a(this.rootView);
        this.f2833b = this.f2838g.m3495c();
        this.f2837f = findViewById(R.id.numboard_whole_layout);
        m3231g();
        if (C1150y.m2598b(this.mActivity).f2233r) {
            this.f2840i = new C1360c(this.mActivity, (FingerPrintStateView) findViewById(R.id.locker_board_fingerprint), this);
        }
        C1375l.m3479a(this.f2837f, e);
        m3224a(this.f2838g);
        Intent intent = this.mActivity.getIntent();
        if (intent.hasExtra("unlock_app_action") || !intent.getBooleanExtra("com.domobile.applock.EXTRA_CAN_CHANGE_UNLOCK_TYPE", true)) {
            View b = this.f2838g.m3494b();
            if (b != null) {
                b.setVisibility(8);
            }
        }
        m1040a();
    }

    private void m3234j() {
        View findViewById;
        C0979d a = C0980e.m1860a(getContext());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pattern_board_container);
        viewGroup.removeAllViews();
        this.f2839h = new C0967c(this.mActivity, a, C1102c.m2405e(this.mActivity));
        final LivePatternView a2 = this.f2839h.m1802a();
        View h = this.f2839h.m1735h();
        viewGroup.addView(h);
        a2.setOnPatternListener(new C0950c(this) {
            final /* synthetic */ C1316a f2826b;

            public void mo2450a() {
                a2.m1973e();
            }

            public void mo2451a(List<C1308a> list) {
                if (this.f2826b.f2834c == null || !this.f2826b.f2834c.m3246a((List) list)) {
                    a2.setDisplayMode(1);
                    a2.m1972d();
                    this.f2826b.m3236l();
                    return;
                }
                this.f2826b.m3235k();
                a2.m1972d();
            }

            public void mo2452b() {
                a2.m1973e();
            }

            public void mo2453b(List<C1308a> list) {
            }
        });
        a2.setTactileFeedbackEnabled(C1318c.m3243a(this.mActivity));
        a2.m1971c();
        if (C1150y.m2598b(this.mActivity).f2233r) {
            findViewById = h.findViewById(R.id.locker_board_fingerprint);
            this.f2840i = new C1360c(this.mActivity, (FingerPrintStateView) findViewById, this);
            C1102c.m2387a(this.mActivity, this.mActivity.getResources(), findViewById);
        }
        findViewById = h.findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            ((ImageView) findViewById).setImageResource(R.drawable.toolbar_more);
            C1102c.m2387a(this.mActivity, this.mActivity.getResources(), findViewById);
            findViewById.setOnClickListener(this);
        }
        C1102c.m2387a(this.mActivity, this.mActivity.getResources(), h.findViewById(R.id.pattern_board_patternview));
        this.f2839h.mo2455a(ContextCompat.getDrawable(this.mActivity, R.drawable.icon));
        m3224a(this.f2839h);
    }

    private void m3235k() {
        m3229e();
        C0814g.m1299a(this.f2841j);
        this.f2841j = "";
        if (this.mActivity instanceof VerifyActivity) {
            ((VerifyActivity) this.mActivity).f504a = true;
        }
        this.mActivity.setResult(-1, this.mActivity.getIntent());
        C1150y.m2604b(this.mActivity);
        this.mActivity.finish();
    }

    private void m3236l() {
        if (this.f2842k < 3) {
            this.f2842k++;
            if (this.f2842k == 3) {
                C1258c.m2987b("**** 输错3次,保存记录 ****");
                C1150y.m2589a(this.mActivity, System.currentTimeMillis());
                m3230f();
                m3229e();
            }
        }
        if (C1150y.m2658u(this.mActivity) && TextUtils.isEmpty(this.f2841j)) {
            C1258c.m2987b("**** 输入错误,拍照 ****");
            this.f2841j = C0814g.m1295a(this.mActivity);
            C0810f.m1290a(this.mActivity).mo2423a(this.f2841j);
        }
    }

    private void m3237m() {
        if (!TextUtils.isEmpty(this.f2841j)) {
            C1258c.m2987b("**** 错误,保存照片 ****");
            C1150y.m2622e(this.mActivity, this.f2841j);
            C1150y.m2609b(this.mActivity, true);
            this.f2841j = "";
        }
    }

    public void mo2410b() {
        m3235k();
    }

    public void mo2411c() {
    }

    public void mo2412d() {
        m3236l();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3006b(false);
        this.rootView = layoutInflater.inflate(R.layout.pattern_lock_port, null);
        m3232h();
        m3230f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1150y.m2584a(this.mActivity, C1224e.m2873a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_confirm_lock_pattern);
        Intent intent = this.mActivity.getIntent();
        if (!C1150y.m2614c(this.mActivity, "first_launch")) {
            boolean booleanExtra = intent.getBooleanExtra("GoToCore", true);
            Intent intent2 = new Intent(this.mActivity, GuideActivity.class);
            intent2.putExtra("GoToCore", booleanExtra);
            startActivity(intent2);
            this.mActivity.finish();
        }
        this.f2834c = new C1318c(this.mActivity);
    }

    public void onDestroy() {
        if (this.f2833b != null) {
            this.f2833b.m3206a();
        }
        this.f2833b = null;
        SwitcherLockReceiver.m2093a(this.mActivity);
        if (this.f2839h != null) {
            this.f2839h.m1806d();
        }
        m3237m();
        m3229e();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.f2840i != null) {
            this.f2840i.m3431e();
        }
        if (this.f2836e != null) {
            this.f2836e.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f2840i != null) {
            this.f2840i.m3425a();
        }
        m3231g();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("num_wrong_attempts", this.f2835d);
    }

    public void onStart() {
        super.onStart();
        if (this.f2839h != null) {
            this.f2839h.m1804b();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f2839h != null) {
            this.f2839h.m1805c();
        }
    }

    public void ui(int i, Message message) {
    }
}
