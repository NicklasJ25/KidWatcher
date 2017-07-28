package com.domobile.applock.chamber.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.applock.chamber.p008a.C0777e;
import com.domobile.applock.chamber.p008a.C0777e.C0775a;
import com.domobile.applock.chamber.p010b.C0782e;
import com.domobile.applock.p003a.C0632l;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;

public class C0868j extends C0400d implements C0775a {
    private C0777e f1248a;
    private C0777e f1249e;
    private C0777e f1250f;
    private C0777e f1251g;
    private C0867a f1252h;

    private class C0867a implements OnClickListener, OnKeyListener {
        C0777e f1232a;
        final /* synthetic */ C0868j f1233b;
        private WindowManager f1234c;
        private LayoutParams f1235d;
        private View f1236e;
        private ViewGroup f1237f;
        private LinearLayout.LayoutParams f1238g;
        private View f1239h;
        private View f1240i;
        private Animation f1241j;
        private Animation f1242k;
        private boolean f1243l;
        private int f1244m;
        private int f1245n;
        private int f1246o;
        private SocialInfo f1247p;

        class C08651 implements Runnable {
            final /* synthetic */ C0867a f1230a;

            C08651(C0867a c0867a) {
                this.f1230a = c0867a;
            }

            public void run() {
                if (this.f1230a.f1242k == null) {
                    this.f1230a.f1242k = AnimationUtils.loadAnimation(this.f1230a.f1233b.mActivity, R.anim.custom_dialog_appear);
                }
                this.f1230a.f1237f.setVisibility(0);
                this.f1230a.f1237f.startAnimation(this.f1230a.f1242k);
            }
        }

        class C08662 extends C0415f {
            final /* synthetic */ C0867a f1231a;

            C08662(C0867a c0867a) {
                this.f1231a = c0867a;
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f1231a.f1236e.getParent() != null) {
                    this.f1231a.f1234c.removeView(this.f1231a.f1236e);
                }
                this.f1231a.f1237f.clearAnimation();
                this.f1231a.f1243l = false;
            }
        }

        public C0867a(C0868j c0868j, Context context) {
            this.f1233b = c0868j;
            this.f1234c = (WindowManager) context.getSystemService("window");
            this.f1235d = new LayoutParams();
            this.f1235d.type = 1000;
            this.f1235d.format = 1;
            this.f1235d.flags = 32;
            this.f1235d.format = -3;
            this.f1235d.height = -1;
            this.f1235d.width = -1;
            this.f1235d.gravity = 17;
            this.f1236e = LayoutInflater.from(context).inflate(R.layout.layout_social_item_more, null);
            this.f1237f = (ViewGroup) this.f1236e.findViewById(R.id.cardView);
            this.f1238g = (LinearLayout.LayoutParams) this.f1237f.getLayoutParams();
            this.f1239h = this.f1236e.findViewById(R.id.txvDelete);
            this.f1239h.setOnClickListener(this);
            this.f1240i = this.f1236e.findViewById(R.id.txvEdit);
            this.f1240i.setOnClickListener(this);
            this.f1236e.setOnClickListener(this);
            this.f1236e.setFocusableInTouchMode(true);
            this.f1236e.setFocusable(true);
            this.f1236e.requestFocus();
            this.f1236e.setOnKeyListener(this);
            C0632l.m754a(this.f1236e);
            this.f1244m = this.f1236e.getMeasuredWidth();
            this.f1245n = this.f1236e.getMeasuredHeight();
            this.f1246o = c0868j.getResources().getDimensionPixelSize(R.dimen.toolbar_height_std) + c0868j.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }

        public C0867a m1472a(View view, C0777e c0777e, SocialInfo socialInfo) {
            this.f1232a = c0777e;
            this.f1247p = socialInfo;
            Point a = C1148d.m2500a(this.f1234c);
            int[] iArr = new int[]{0, 0};
            view.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = (view.getWidth() / 2) + i;
            int height = (view.getHeight() / 2) + i2;
            this.f1239h.setVisibility(0);
            this.f1240i.setVisibility(0);
            if (i < this.f1244m / 2) {
                this.f1238g.leftMargin = 0;
            } else if (i > a.x - this.f1244m) {
                this.f1238g.leftMargin = a.x - this.f1244m;
            } else {
                this.f1238g.leftMargin = width - (this.f1244m / 2);
            }
            if (i2 <= this.f1245n) {
                this.f1238g.topMargin = this.f1246o;
            } else if (i2 > a.y - this.f1245n) {
                this.f1238g.topMargin = a.y - this.f1245n;
            } else {
                this.f1238g.topMargin = height - (this.f1245n / 2);
            }
            this.f1237f.setLayoutParams(this.f1238g);
            this.f1237f.setVisibility(4);
            if (this.f1236e.getParent() == null) {
                this.f1234c.addView(this.f1236e, this.f1235d);
            }
            this.f1237f.postDelayed(new C08651(this), 20);
            return this;
        }

        public void m1473a() {
            this.f1243l = true;
            if (this.f1241j == null) {
                this.f1241j = AnimationUtils.loadAnimation(this.f1233b.mActivity, R.anim.custom_dialog_disappear);
                this.f1241j.setAnimationListener(new C08662(this));
            }
            this.f1237f.startAnimation(this.f1241j);
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.txvEdit:
                    this.f1233b.b.m80e();
                    BrowserHostActivity.m1309a(this.f1233b.mActivity, this.f1247p);
                    break;
                case R.id.txvDelete:
                    C0782e.m1206a(this.f1247p.f1299a);
                    this.f1232a.m1176a(this.f1247p);
                    break;
            }
            if (!this.f1243l) {
                m1473a();
            }
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 4 || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            m1473a();
            return true;
        }
    }

    private void m1474b() {
        findViewById(R.id.vgTwitterLayer).setOnClickListener(this);
        findViewById(R.id.vgFacebookLayer).setOnClickListener(this);
        findViewById(R.id.vgGoogleLayer).setOnClickListener(this);
        findViewById(R.id.vgLinkedinLayer).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvTwitterList);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rcvFacebookList);
        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.rcvGoogleList);
        RecyclerView recyclerView4 = (RecyclerView) findViewById(R.id.rcvLinkedinList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
        recyclerView4.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
        this.f1248a = new C0777e();
        recyclerView.setAdapter(this.f1248a);
        this.f1248a.m1175a((C0775a) this);
        this.f1249e = new C0777e();
        recyclerView2.setAdapter(this.f1249e);
        this.f1249e.m1175a((C0775a) this);
        this.f1250f = new C0777e();
        recyclerView3.setAdapter(this.f1250f);
        this.f1250f.m1175a((C0775a) this);
        this.f1251g = new C0777e();
        recyclerView4.setAdapter(this.f1251g);
        this.f1251g.m1175a((C0775a) this);
    }

    private void m1475c() {
        this.f1248a.m1177a(C0782e.m1204a(this.mActivity, 11));
        this.f1249e.m1177a(C0782e.m1204a(this.mActivity, 10));
        this.f1250f.m1177a(C0782e.m1204a(this.mActivity, 13));
        this.f1251g.m1177a(C0782e.m1204a(this.mActivity, 12));
    }

    public void mo2436a(C0777e c0777e, View view, int i) {
        this.b.m80e();
        Intent intent = new Intent(this.mActivity, SocialVisitActivity.class);
        intent.putExtra("EXTRA_SOCIAL_INFO", c0777e.m1178b(i));
        startActivity(intent);
    }

    public void mo2437b(C0777e c0777e, View view, int i) {
        SocialInfo b = c0777e.m1178b(i);
        if (!TextUtils.isEmpty(b.f1301c)) {
            if (this.f1252h == null) {
                this.f1252h = new C0867a(this, this.mActivity);
            }
            this.f1252h.m1472a(view, c0777e, b);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_social_main, null);
        m1474b();
    }

    public void onClick(View view) {
        super.onClick(view);
        Parcelable parcelable = null;
        if (view.getId() == R.id.vgTwitterLayer) {
            parcelable = this.f1248a.m1178b(0);
        } else if (view.getId() == R.id.vgFacebookLayer) {
            parcelable = this.f1249e.m1178b(0);
        } else if (view.getId() == R.id.vgGoogleLayer) {
            parcelable = this.f1250f.m1178b(0);
        } else if (view.getId() == R.id.vgLinkedinLayer) {
            parcelable = this.f1251g.m1178b(0);
        }
        if (parcelable != null) {
            this.b.m80e();
            Intent intent = new Intent(this.mActivity, SocialVisitActivity.class);
            intent.putExtra("EXTRA_SOCIAL_INFO", parcelable);
            startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.privacy_social_title);
        C1150y.m2605b(this.mActivity, (int) R.string.event_social_main);
    }

    public void onResume() {
        super.onResume();
        m1475c();
    }
}
