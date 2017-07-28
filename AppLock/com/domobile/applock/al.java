package com.domobile.applock;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PointerIconCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.domobile.applock.chamber.p009c.C0810f;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.applock.fake.C0933d;
import com.domobile.applock.fake.DefaultFakeViewInitialer;
import com.domobile.applock.livelock.p006a.C0962a;
import com.domobile.applock.livelock.p006a.C0962a.C0742a;
import com.domobile.applock.livelock.p006a.C0966b;
import com.domobile.applock.livelock.p014b.C0979d;
import com.domobile.applock.livelock.p014b.C0980e;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.theme.C1102c;
import com.domobile.frame.p000a.C1258c;
import com.domobile.frame.ui.C1288c;
import com.domobile.imagelock.C1318c;
import com.domobile.libs_ads.C1342b;
import com.domobile.lockbean.C0960e;
import com.domobile.lockbean.C1360c;
import com.domobile.lockbean.C1365d.C0743a;
import com.domobile.lockbean.C1372k;
import com.domobile.lockbean.C1375l;
import com.domobile.widget.FingerPrintStateView;

public class al extends C0741f implements TextWatcher, C0742a, C0743a {
    private Activity f954b;
    private View f955c;
    private C1372k f956d;
    private C0962a f957e;
    private String f958f = "";
    private C1360c f959g;
    private Runnable f960h = new C07381(this);
    private int f961i;
    private String f962j = "";
    private int f963k = 0;
    private int f964l = 0;

    class C07381 implements Runnable {
        final /* synthetic */ al f947a;

        C07381(al alVar) {
            this.f947a = alVar;
        }

        public void run() {
            this.f947a.m1052g();
        }
    }

    class C07392 implements OnClickListener {
        final /* synthetic */ al f948a;

        C07392(al alVar) {
            this.f948a = alVar;
        }

        public void onClick(View view) {
            this.f948a.m1055j();
        }
    }

    class C07403 implements OnClickListener {
        final /* synthetic */ al f949a;

        C07403(al alVar) {
            this.f949a = alVar;
        }

        public void onClick(View view) {
            this.f949a.startActivityForResult(new Intent(this.f949a.f954b, RetrievePasswordActivity.class), PointerIconCompat.TYPE_CONTEXT_MENU);
        }
    }

    private void m1047a(C0960e c0960e) {
        Intent intent = this.f954b.getIntent();
        String stringExtra = intent.getStringExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION");
        if ("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT".equals(intent.getAction())) {
            c0960e.m1733b(intent.getStringExtra("com.domobile.applock.EXTRA_PROFILE_NAME"));
        } else if (this.f954b.getIntent().getBooleanExtra("com.domobile.elock.EXTRA_GOTO_CHOOSEBG", false)) {
            c0960e.m1733b(this.f954b.getString(R.string.unlock_background));
        } else if (!TextUtils.isEmpty(stringExtra)) {
            r0 = SwitcherLockReceiver.m2092a(this.f954b, stringExtra);
            Drawable b = SwitcherLockReceiver.m2099b(this.f954b, stringExtra);
            c0960e.m1733b(r0);
            c0960e.mo2455a(b);
        } else if (!TextUtils.isEmpty(intent.getStringExtra("unlock_app_action"))) {
            stringExtra = intent.getStringExtra("unlock_app_pkgname");
            r0 = intent.getStringExtra("unlock_app_appname");
            try {
                PackageManager packageManager = this.f954b.getPackageManager();
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(stringExtra, 0);
                c0960e.mo2455a(packageManager.getApplicationIcon(stringExtra));
                if (TextUtils.isEmpty(r0)) {
                    c0960e.m1733b((String) packageManager.getApplicationLabel(applicationInfo));
                } else {
                    c0960e.m1733b(r0);
                }
            } catch (Exception e) {
            }
        }
    }

    private void m1049b(String str) {
        if (TextUtils.isEmpty(this.f958f)) {
            this.f958f = C1150y.m2620e(this.mActivity);
        }
        if (C1150y.m2608b(this.mActivity, str, this.f958f)) {
            C1150y.m2588a(this.mActivity, str.length());
            m1056k();
            return;
        }
        if (this.f961i == 0) {
            this.f961i = C1150y.m2659v(this.mActivity);
        }
        if (this.f961i != 0) {
            if (this.f961i == str.length()) {
                m1057l();
            }
            if (this.f964l < 3) {
                int length = str.length();
                if (length == this.f961i && length > this.f963k) {
                    this.f964l++;
                }
                this.f963k = length;
                if (this.f964l == 3) {
                    C1258c.m2987b("**** 输错3次,保存记录 ****");
                    C1150y.m2589a(this.mActivity, System.currentTimeMillis());
                    m1051f();
                    m1055j();
                }
            }
        }
    }

    private void m1051f() {
        long q = C1150y.m2649q(this.mActivity);
        if (q != 0 && System.currentTimeMillis() - q <= 300000) {
            C1150y.m2589a(this.mActivity, 0);
            C1288c a = new C1288c(this.mActivity).mo2528a(getString(R.string.forget_passwd_title) + "?");
            a.m3102a((int) R.string.no, new C07392(this));
            a.m3114b((int) R.string.yes, new C07403(this)).m3122d();
        }
    }

    private void m1052g() {
        if (C1102c.m2400c(this.mActivity)) {
            m1054i();
        } else {
            m1053h();
        }
        C0933d.m1650a(this.mActivity, findViewById(R.id.verify_fakeview));
    }

    private void m1053h() {
        String a = C1102c.m2385a(this.f954b);
        LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.numboard_parent);
        viewGroup.removeAllViews();
        boolean e = C1102c.m2405e(this.mActivity);
        this.f956d = new C1372k(this.mActivity, null, 0, e);
        viewGroup.addView(layoutInflater.inflate(C1102c.m2381a(this.mActivity, a, C1102c.m2380a(e, 1)), null));
        this.f956d.m3458a(this.rootView);
        this.f956d.m3466e();
        this.f956d.m3457a((TextWatcher) this);
        if (C1150y.m2598b(this.mActivity).f2233r) {
            this.f959g = new C1360c(this.mActivity, (FingerPrintStateView) findViewById(R.id.locker_board_fingerprint), this);
        }
        m1047a(this.f956d);
        findViewById(R.id.numboard_exit_button).setOnClickListener(this);
        C1375l.m3479a(this.f956d.m3471l(), e);
        if (findViewById(R.id.locker_board_more) == null) {
            View findViewById = findViewById(R.id.numboard_retrieve_pwd);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        m1040a();
    }

    private void m1054i() {
        View findViewById;
        C0979d a = C0980e.m1860a(getContext());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.numboard_parent);
        viewGroup.removeAllViews();
        boolean e = C1102c.m2405e(this.mActivity);
        this.f957e = new C0962a(this.mActivity, a, C0966b.m1788a(this.mActivity), e);
        this.f957e.m1745a((C0742a) this);
        this.f957e.m1746a(C1318c.m3243a(this.mActivity));
        View h = this.f957e.m1735h();
        viewGroup.addView(h);
        this.f957e.m1750d();
        if (C1150y.m2598b(this.mActivity).f2233r) {
            findViewById = h.findViewById(R.id.locker_board_fingerprint);
            this.f959g = new C1360c(this.mActivity, (FingerPrintStateView) findViewById, this);
            C1102c.m2387a(this.mActivity, this.mActivity.getResources(), findViewById);
        }
        C1102c.m2387a(this.mActivity, this.mActivity.getResources(), (ViewGroup) h.findViewById(R.id.numboard_numslayout));
        findViewById = h.findViewById(R.id.locker_board_more);
        if (findViewById != null) {
            ((ImageView) findViewById).setImageResource(R.drawable.toolbar_more);
            C1102c.m2387a(this.mActivity, this.mActivity.getResources(), findViewById);
            findViewById.setOnClickListener(this);
        }
        this.f957e.mo2455a(ContextCompat.getDrawable(this.mActivity, R.drawable.icon));
        m1047a(this.f957e);
    }

    private void m1055j() {
        this.f963k = 0;
        this.f964l = 0;
    }

    private void m1056k() {
        m1055j();
        C0814g.m1299a(this.f962j);
        this.f962j = "";
        if (this.mActivity instanceof VerifyActivity) {
            ((VerifyActivity) this.mActivity).f504a = true;
        }
        this.f954b.setResult(-1, this.f954b.getIntent());
        C1150y.m2604b(this.f954b);
        this.f954b.finish();
    }

    private void m1057l() {
        if (C1150y.m2658u(this.mActivity) && TextUtils.isEmpty(this.f962j)) {
            C1258c.m2987b("**** 输入错误,拍照 ****");
            this.f962j = C0814g.m1295a(this.mActivity);
            C0810f.m1290a(this.mActivity).mo2423a(this.f962j);
        }
    }

    private void m1058m() {
        if (!TextUtils.isEmpty(this.f962j)) {
            C1258c.m2987b("**** 错误,保存照片 ****");
            C1150y.m2622e(this.mActivity, this.f962j);
            C1150y.m2609b(this.mActivity, true);
            this.f962j = "";
        }
    }

    public void mo2409a(String str) {
        m1049b(str);
    }

    public void afterTextChanged(Editable editable) {
        if (this.f956d != null) {
            m1049b(this.f956d.m3469j());
        }
    }

    public void mo2410b() {
        m1056k();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void mo2411c() {
    }

    public void mo2412d() {
        m1057l();
    }

    public void mo2413e() {
        this.f954b.finish();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!C1150y.m2614c(this.f954b, "first_launch")) {
            boolean booleanExtra = this.f954b.getIntent().getBooleanExtra("GoToCore", true);
            Intent intent = new Intent(this.f954b, GuideActivity.class);
            intent.putExtra("GoToCore", booleanExtra);
            this.f954b.startActivity(intent);
            this.f954b.finish();
        }
        this.rootView = layoutInflater.inflate(R.layout.verify, null);
        new DefaultFakeViewInitialer().mo2440b(this.rootView);
        if (C1150y.m2598b(this.mActivity).f2224i) {
            this.f955c = C1342b.m3320a(this.mActivity, C1150y.m2566a(this.mActivity), (ViewGroup) findViewById(R.id.adview_layout), C1342b.m3333b(this.f954b, "applock", 0).intValue(), "applock", false);
            if (this.f955c != null) {
                C1150y.m2545J(this.mActivity);
            }
        }
        m1052g();
        if (!C1150y.m2614c(this.f954b, "initial_has_notice")) {
            C1150y.m2582a(this.f954b, "initial_has_notice", Boolean.valueOf(true));
        }
        m1051f();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.numboard_exit_button) {
            this.f954b.finish();
        } else if (view.getId() == R.id.numboard_retrieve_pwd) {
            startActivityForResult(new Intent(this.f954b, RetrievePasswordActivity.class), PointerIconCompat.TYPE_CONTEXT_MENU);
        } else {
            super.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBar.m3006b(false);
        this.f954b = this.mActivity;
        C1150y.m2605b(this.mActivity, (int) R.string.event_verify);
    }

    public void onDestroy() {
        C1342b.m3328a(this.f955c);
        this.rootView.removeCallbacks(this.f960h);
        this.f955c = null;
        if (this.f957e != null) {
            this.f957e.m1749c();
        }
        m1058m();
        m1055j();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.f959g != null) {
            this.f959g.m3431e();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f959g != null) {
            this.f959g.m3425a();
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f957e != null) {
            this.f957e.m1742a();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f957e != null) {
            this.f957e.m1747b();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void ui(int i, Message message) {
    }
}
