package com.domobile.applock;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0384c;
import com.domobile.frame.C0399d;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.imagelock.C1318c;
import com.domobile.imagelock.LockPatternView;
import com.domobile.imagelock.LockPatternView.C0950c;
import com.domobile.imagelock.LockPatternView.C1308a;
import com.domobile.imagelock.LockPatternView.C1309b;
import com.domobile.lockbean.C1372k;
import com.domobile.lockbean.C1376m;
import com.domobile.widget.GuideStepLineView;
import java.util.ArrayList;
import java.util.List;

public class C0951i extends C0399d implements Callback, C0950c {
    private TextView f1487a;
    private TextView f1488b;
    private View f1489c;
    private View f1490d;
    private View f1491e;
    private GuideActivity f1492f;
    private Resources f1493g;
    private C1372k f1494h;
    private C1376m f1495i;
    private LockPatternView f1496j;
    private C1318c f1497k;
    private ArrayList<C1308a> f1498l;
    private View f1499m;
    private View f1500n;
    private View f1501o;
    private GuideStepLineView f1502p;
    private GuideStepLineView f1503q;
    private boolean f1504r = false;
    private boolean f1505s = true;
    private int f1506t = 0;
    private String f1507u;

    class C09491 implements OnClickListener {
        final /* synthetic */ C0951i f1486a;

        C09491(C0951i c0951i) {
            this.f1486a = c0951i;
        }

        public void onClick(View view) {
            this.f1486a.m1708d();
        }
    }

    private void m1703a(int i) {
        this.f1506t = i;
        m1706b(this.f1506t);
        if (this.f1506t < 2) {
            this.f1494h.m3465d();
            this.f1490d.setVisibility(8);
            this.f1489c.setVisibility(0);
        }
        switch (this.f1506t) {
            case 0:
                this.f1494h.m3468g();
                this.f1491e.setVisibility(8);
                if (C1150y.m2614c(this.f1492f, "first_launch")) {
                    this.f1488b.setHint(R.string.reset_passwd_msg);
                    return;
                } else {
                    this.f1488b.setHint(R.string.first_launch_set_pwd);
                    return;
                }
            case 1:
                this.f1494h.m3467f();
                this.f1491e.setVisibility(0);
                this.f1488b.setHint(R.string.enter_new_password_again);
                return;
            case 2:
                this.f1489c.setVisibility(8);
                this.f1490d.setVisibility(0);
                this.f1487a.requestFocus();
                return;
            default:
                return;
        }
    }

    private boolean m1705a(boolean z) {
        C1148d.m2520b(this.mActivity, "is_image_lock_pattern", (Object) Boolean.valueOf(z));
        if (this.f1504r) {
            C1147a.m2485d(this.mActivity, !this.f1505s ? R.string.password_modified : R.string.lockpattern_pattern_entered_header);
            this.mActivity.setResult(-1);
            this.mActivity.finish();
            return true;
        }
        CharSequence aa = C1150y.aa(this.mActivity);
        if (C1150y.m2614c(this.f1492f, "first_launch")) {
            if (!this.f1492f.getIntent().getBooleanExtra("GoToCore", true) || TextUtils.isEmpty(aa)) {
                return false;
            }
            this.f1492f.startActivity(new Intent(this.f1492f, MainTabFragmentActivity.class));
            this.f1492f.finish();
            return true;
        } else if (TextUtils.isEmpty(aa)) {
            return false;
        } else {
            C1150y.m2582a(this.f1492f, "first_launch", Boolean.valueOf(true));
            return false;
        }
    }

    private void m1706b(int i) {
        boolean z = true;
        this.f1502p.m3533a(i >= 1, this);
        GuideStepLineView guideStepLineView = this.f1503q;
        if (i < 2) {
            z = false;
        }
        guideStepLineView.m3533a(z, this);
    }

    private void m1707c(int i) {
        this.f1506t = i;
        m1706b(this.f1506t);
        switch (this.f1506t) {
            case 0:
                this.f1495i.m3495c().m3209b();
                this.f1495i.m3492a((int) R.string.lockpattern_recording_intro_header);
                return;
            case 1:
                this.f1495i.m1735h().setVisibility(0);
                this.f1490d.setVisibility(8);
                C1148d.m2519b(this.mActivity, this.f1487a);
                this.f1495i.m3495c().m3207a(300);
                this.f1495i.m3492a((int) R.string.lockpattern_need_to_confirm);
                return;
            case 2:
                this.f1495i.m1735h().setVisibility(8);
                this.f1490d.setVisibility(0);
                this.f1487a.requestFocus();
                return;
            default:
                return;
        }
    }

    private void m1708d() {
        C1150y.m2657u(this.mActivity, this.f1487a.getText().toString());
        C1150y.m2582a(this.f1492f, "first_launch", Boolean.valueOf(true));
        C1150y.m2582a(this.f1492f, "last_secure_level", Boolean.valueOf(false));
        C1147a.m2485d(this.f1492f, R.string.save_done);
        this.f1492f.startActivity(new Intent(this.f1492f, MainTabFragmentActivity.class));
        this.f1492f.finish();
    }

    private void m1709e() {
        ((ViewStub) findViewById(R.id.guide_numboard)).inflate();
        this.f1494h = new C1372k(this.f1492f, this.rootView, 3);
        this.f1494h.m3463b(true);
        this.f1488b = this.f1494h.m3470k();
        this.f1491e = findViewById(R.id.numboard_back_button);
        this.f1489c = findViewById(R.id.numboard_whole_layout);
        this.f1494h.m3474o().setOnClickListener(this);
        this.f1494h.m3474o().setImageDrawable(C1150y.m2565a((BitmapDrawable) C1148d.m2502a(this.f1493g, (int) R.drawable.guide_button_ok), null, ResourcesCompat.getColor(this.f1493g, R.color.guide_ok_pressed_color, null)));
        findViewById(R.id.numboard_exit_button).setOnClickListener(this);
        findViewById(R.id.numboard_back_button).setOnClickListener(this);
    }

    private void m1710f() {
        ((ViewStub) findViewById(R.id.guide_patternboard)).inflate();
        this.f1495i = new C1376m(this.f1492f, this.rootView.findViewById(R.id.numboard_whole_layout), false, true);
        this.f1495i.m3498e(0);
        this.f1496j = this.f1495i.m3495c();
        this.f1496j.setOnPatternListener(this);
        this.f1496j.setInChooseMode(true);
        this.f1497k = new C1318c(this.f1492f);
        this.f1495i.m3497d(ResourcesCompat.getColor(this.f1493g, R.color.guide_pattern_header_textcolor, null));
    }

    public void mo2450a() {
        this.f1495i.m3492a((int) R.string.lockpattern_recording_inprogress);
    }

    public void m1712a(Bundle bundle) {
        bundle.putInt("state", this.f1506t);
        bundle.putString("first_passwd", this.f1507u);
    }

    public void mo2451a(List<C1308a> list) {
        if (this.f1506t == 0) {
            if (list.size() < 4) {
                this.f1495i.m3496c(this.mActivity.getString(R.string.lockpattern_recording_incorrect_too_short, new Object[]{Integer.valueOf(4)}));
                this.f1496j.setDisplayMode(C1309b.Wrong);
                this.f1496j.m3211d();
                return;
            }
            this.f1498l = new ArrayList(list);
            m1707c(1);
        } else if (this.f1506t != 1) {
        } else {
            if (this.f1498l.equals(list)) {
                this.f1497k.m3247b(list);
                if (!m1705a(true)) {
                    m1707c(2);
                    return;
                }
                return;
            }
            this.f1496j.setDisplayMode(C1309b.Wrong);
            this.f1496j.m3211d();
            this.f1495i.m3492a((int) R.string.lockpattern_need_to_unlock_wrong);
        }
    }

    public void mo2452b() {
    }

    public void m1715b(Bundle bundle) {
        if (bundle != null) {
            this.f1506t = bundle.getInt("state", 0);
            this.f1507u = bundle.getString("first_passwd");
        }
    }

    public void mo2453b(List<C1308a> list) {
    }

    public boolean m1717c() {
        if (this.f1506t <= 0) {
            return false;
        }
        if (this.f1506t == 1) {
            this.f1500n.setSelected(false);
        } else if (this.f1506t == 2) {
            this.f1501o.setSelected(false);
        }
        if (this.f1494h != null) {
            m1703a(this.f1506t - 1);
            return true;
        } else if (this.f1495i == null) {
            return true;
        } else {
            m1707c(this.f1506t - 1);
            return true;
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = true;
        this.f1500n.setSelected(this.f1506t >= 1);
        View view = this.f1501o;
        if (this.f1506t < 2) {
            z = false;
        }
        view.setSelected(z);
        return false;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3006b(false);
        this.rootView = layoutInflater.inflate(R.layout.guide, null);
        this.f1490d = findViewById(R.id.guide_security_layout);
        this.f1487a = (EditText) findViewById(R.id.guide_security_email_edittext);
        this.f1502p = (GuideStepLineView) findViewById(R.id.guide_step_line1);
        this.f1503q = (GuideStepLineView) findViewById(R.id.guide_step_line2);
        this.f1499m = findViewById(R.id.guide_step_one);
        this.f1500n = findViewById(R.id.guide_step_two);
        this.f1501o = findViewById(R.id.guide_step_three);
        this.f1499m.setSelected(true);
        findViewById(R.id.guide_save_button).setOnClickListener(this);
        CharSequence aa = C1150y.aa(this.f1492f);
        if (TextUtils.isEmpty(aa)) {
            aa = C1150y.m2549N(this.mActivity);
            if (!TextUtils.isEmpty(aa)) {
                this.f1487a.setText(aa);
            }
        } else {
            this.f1487a.setText(aa);
            this.f1487a.setEnabled(false);
        }
        if (C1150y.m2614c(this.f1492f, "first_launch")) {
            findViewById(R.id.guide_steps).setVisibility(8);
        }
        if (this.f1505s) {
            m1710f();
            m1707c(0);
        } else {
            m1709e();
            m1703a(0);
        }
        findViewById(R.id.locker_board_more).setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.numboard_sure_button) {
            if (this.f1506t == 0) {
                if (TextUtils.isEmpty(this.f1494h.m3469j())) {
                    C1147a.m2485d(this.f1492f, R.string.password_cannot_empty);
                    return;
                }
                this.f1507u = this.f1494h.m3469j();
                m1703a(1);
            } else if (this.f1506t != 1) {
            } else {
                if (this.f1494h.m3469j().equals(this.f1507u)) {
                    C1150y.m2625f(this.f1492f, this.f1507u);
                    if (!m1705a(false)) {
                        m1703a(2);
                        return;
                    }
                    return;
                }
                C1147a.m2485d(this.f1492f, R.string.confirm_password_not_same);
            }
        } else if (view.getId() == R.id.numboard_exit_button) {
            this.f1492f.finish();
        } else if (view.getId() == R.id.numboard_back_button) {
            m1703a(0);
        } else if (view.getId() != R.id.guide_save_button) {
        } else {
            if (this.f1492f.getIntent().getBooleanExtra("GoToCore", true)) {
                String charSequence = this.f1487a.getText().toString();
                if (!TextUtils.isEmpty(charSequence) && !C1150y.m2631h(charSequence)) {
                    C1147a.m2485d(this.mActivity, R.string.email_error);
                    return;
                } else if (TextUtils.isEmpty(charSequence)) {
                    C1288c c1288c = new C1288c(this.f1492f);
                    c1288c.m3117b(true).m3101a((int) R.string.notice);
                    c1288c.m3123d((int) R.string.secure_email_empty_warning);
                    c1288c.m3114b(17039370, new C09491(this)).m3113b((int) R.drawable.icon_dialog_alert_holo_light);
                    c1288c.m3102a((int) R.string.back, null).m3122d();
                    return;
                } else {
                    m1708d();
                    return;
                }
            }
            this.f1492f.startService(new Intent(this.f1492f, LockService.class));
            this.f1492f.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1492f = (GuideActivity) this.mActivity;
        this.f1493g = this.mActivity.getResources();
        Intent intent = this.f1492f.getIntent();
        this.f1505s = !intent.getBooleanExtra("FORCE_NUMLOCK", false);
        this.f1504r = intent.getBooleanExtra("com.domobile.applock.EXTRA_JUST_CHANGE_CIPHER", false);
        C1150y.m2605b(this.mActivity, (int) R.string.event_guide);
    }

    public void onResume() {
        super.onResume();
        ((C0384c) this.mActivity).m72x();
    }

    public void ui(int i, Message message) {
    }
}
