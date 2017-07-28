package com.domobile.applock.fake;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.domobile.applock.C0386c;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.C0933d.C0926b;
import com.domobile.applock.fake.FakePagePickerFragment.FakeBean;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;

public class C0928b extends C0400d {
    private final int f1414a = 0;
    private final int f1415e = 1;
    private final int f1416f = 2;
    private final int f1417g = 6;
    private final int f1418h = 7;
    private FakeBean f1419i;
    private C0906c f1420j;
    private Animation f1421k;
    private Animation f1422l;
    private View f1423m;
    private View f1424n;
    private View f1425o;
    private Handler f1426p = new C09253(this);

    class C09211 extends C0415f {
        final /* synthetic */ C0928b f1405a;

        C09211(C0928b c0928b) {
            this.f1405a = c0928b;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1405a.f1423m.setVisibility(8);
            this.f1405a.f1426p.sendEmptyMessageDelayed(1, 400);
        }
    }

    class C09222 extends C0415f {
        final /* synthetic */ C0928b f1406a;

        C09222(C0928b c0928b) {
            this.f1406a = c0928b;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1406a.f1426p.sendEmptyMessageDelayed(2, 1500);
        }
    }

    class C09253 extends Handler {
        final /* synthetic */ C0928b f1409a;

        class C09231 extends C0415f {
            final /* synthetic */ C09253 f1407a;

            C09231(C09253 c09253) {
                this.f1407a = c09253;
            }

            public void onAnimationEnd(Animation animation) {
                this.f1407a.f1409a.f1423m.setVisibility(8);
                this.f1407a.f1409a.findViewById(R.id.fake_try_help).setEnabled(true);
            }
        }

        class C09242 extends C0415f {
            final /* synthetic */ C09253 f1408a;

            C09242(C09253 c09253) {
                this.f1408a = c09253;
            }

            public void onAnimationEnd(Animation animation) {
                this.f1408a.f1409a.f1425o.setVisibility(8);
                this.f1408a.f1409a.f1426p.sendEmptyMessageDelayed(6, 1200);
            }
        }

        C09253(C0928b c0928b) {
            this.f1409a = c0928b;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f1409a.m1643b();
            } else if (message.what == 1) {
                this.f1409a.m1644c();
            } else if (message.what == 2) {
                this.f1409a.f1422l.setDuration(400);
                this.f1409a.f1423m.startAnimation(this.f1409a.f1422l);
                this.f1409a.f1422l.setAnimationListener(new C09231(this));
            } else if (message.what == 6) {
                this.f1409a.f1422l.setDuration(600);
                this.f1409a.f1425o.startAnimation(this.f1409a.f1422l);
                this.f1409a.f1425o.setVisibility(0);
                this.f1409a.f1422l.setAnimationListener(new C09242(this));
            } else if (message.what == 7) {
                C0928b.m1640a(this.f1409a.b, this.f1409a.f1419i);
            }
        }
    }

    private class C0927a extends C0926b {
        final /* synthetic */ C0928b f1413a;

        public C0927a(C0928b c0928b, Context context) {
            this.f1413a = c0928b;
            super(context, null);
        }

        public void run() {
            if (System.currentTimeMillis() - this.d >= 800 || this.c == null) {
                C1147a.m2487w(this.b, this.b.getString(R.string.applied_theme, new Object[]{this.f1413a.f1419i.m1609b(this.f1413a.mActivity)}));
                this.f1413a.f1426p.sendEmptyMessageDelayed(7, 400);
                C1148d.m2525c(this.f1413a.mActivity, 50);
            }
        }
    }

    public static void m1640a(C0386c c0386c, FakeBean fakeBean) {
        C0928b.m1641a(c0386c, fakeBean, true);
    }

    public static void m1641a(C0386c c0386c, FakeBean fakeBean, boolean z) {
        String str = "fake_view_type";
        if (TextUtils.isEmpty(fakeBean.f1371b)) {
            C1148d.m2534y(c0386c, str);
        } else {
            C1150y.m2583a((Context) c0386c, str, fakeBean.f1371b);
        }
        if (z) {
            c0386c.setResult(-1);
            c0386c.mo2042a();
        }
    }

    private void m1643b() {
        this.f1422l.setDuration(600);
        this.f1422l.setAnimationListener(new C09211(this));
        this.f1423m.setVisibility(0);
        this.f1423m.startAnimation(this.f1422l);
    }

    private void m1644c() {
        this.f1421k.setDuration(200);
        this.f1423m.startAnimation(this.f1421k);
        this.f1423m.setVisibility(0);
        this.f1421k.setAnimationListener(new C09222(this));
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3006b(false);
        this.mActionBar.m3008c(false);
        this.rootView = layoutInflater.inflate(R.layout.fake_try, null);
        try {
            Object a;
            String string = this.mActivity.getString(this.mActivity.getResources().getIdentifier(this.f1419i.f1372c, null, this.mActivity.getPackageName()));
            if (FakeBean.FC_TYPE.equals(this.f1419i.f1371b)) {
                a = C1147a.m2480a(" \"", this.mActivity.getString(17039370), "\" ", string);
            } else {
                String str = string;
            }
            ((TextView) findViewById(R.id.fake_try_summary)).setText(this.mActivity.getString(R.string.fake_page_howto, new Object[]{a}));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1424n = findViewById(R.id.fake_try_help);
        this.f1425o = findViewById(R.id.fake_try_help_touch);
        this.f1424n.setOnClickListener(this);
        try {
            this.f1420j = (C0906c) Class.forName(this.f1419i.f1371b).newInstance();
            this.f1420j.mo2440b(this.rootView);
            this.f1420j.mo2439a(this.mActivity, this.rootView, this.mActivity.getPackageName(), new C0927a(this, this.mActivity));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isToolBarFloat() {
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.fake_try_help) {
            this.f1426p.removeMessages(6);
            this.f1425o.clearAnimation();
            this.f1422l.setAnimationListener(null);
            this.f1425o.setVisibility(4);
            this.f1423m = this.f1420j.mo2438a(this.rootView);
            if (this.f1423m != null) {
                view.setEnabled(false);
                this.f1426p.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            return;
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m54a(" ");
        this.f1419i = (FakeBean) this.mActivity.getIntent().getParcelableExtra("com.domobile.elock.EXTRA_PARCELABLE");
        if (this.f1419i == null) {
            this.b.mo2042a();
            return;
        }
        this.f1421k = AnimationUtils.loadAnimation(this.mActivity, 17432576);
        this.f1422l = AnimationUtils.loadAnimation(this.mActivity, 17432577);
        C1150y.m2605b(this.mActivity, (int) R.string.event_fake_page_try);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1426p.removeMessages(0);
        this.f1426p.removeMessages(1);
        this.f1426p.removeMessages(2);
        this.f1426p.removeMessages(6);
        this.f1426p.removeMessages(7);
    }

    public void onPause() {
        super.onPause();
        this.f1426p.removeMessages(6);
    }

    public void onResume() {
        super.onResume();
        this.b.m72x();
        this.f1426p.sendEmptyMessageDelayed(6, 15000);
    }

    public void ui(int i, Message message) {
    }
}
