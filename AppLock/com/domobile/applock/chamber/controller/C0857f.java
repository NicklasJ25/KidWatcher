package com.domobile.applock.chamber.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.frame.C0415f;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1279a;

public class C0857f extends C0400d implements OnMenuItemClickListener {
    private FileInfo f1208a;
    private FrameLayout f1209e;
    private Runnable f1210f = new C08553(this);
    private Runnable f1211g = new C08564(this);

    class C08521 implements OnTouchListener {
        final /* synthetic */ C0857f f1203a;

        C08521(C0857f c0857f) {
            this.f1203a = c0857f;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f1203a.m1444e();
            return true;
        }
    }

    class C08532 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ C0857f f1204a;

        C08532(C0857f c0857f) {
            this.f1204a = c0857f;
        }

        protected Object doInBackground(Object... objArr) {
            C0793b.m1220a(this.f1204a.mActivity, this.f1204a.f1208a);
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            this.f1204a.hideLoadingDialog();
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f1204a.showCancelableLoadingDialog();
        }
    }

    class C08553 implements Runnable {
        final /* synthetic */ C0857f f1206a;

        class C08541 extends C0415f {
            final /* synthetic */ C08553 f1205a;

            C08541(C08553 c08553) {
                this.f1205a = c08553;
            }

            public void onAnimationEnd(Animation animation) {
                this.f1205a.f1206a.b.m70v();
                this.f1205a.f1206a.mActionBar.m3008c(false);
            }
        }

        C08553(C0857f c0857f) {
            this.f1206a = c0857f;
        }

        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1206a.mActivity, 17432577);
            loadAnimation.setAnimationListener(new C08541(this));
            this.f1206a.b.m66r().startAnimation(loadAnimation);
            this.f1206a.mActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    class C08564 implements Runnable {
        final /* synthetic */ C0857f f1207a;

        C08564(C0857f c0857f) {
            this.f1207a = c0857f;
        }

        public void run() {
            this.f1207a.b.m71w();
            this.f1207a.mActionBar.m3008c(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1207a.mActivity, 17432576);
            this.f1207a.b.m66r().startAnimation(loadAnimation);
            this.f1207a.mActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    private void m1438a(long j) {
        this.mHandler.removeCallbacks(this.f1210f);
        this.mHandler.postDelayed(this.f1210f, j);
    }

    private void m1441b() {
        this.mActionBar.m3008c(true);
        Object c1279a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.download_list_bottom_menus, c1279a);
        this.mActionBar.m3005b(c1279a, 0, this);
    }

    private void m1442c() {
        this.f1209e = (FrameLayout) findViewById(R.id.contentView);
        CacheImageView cacheImageView = (CacheImageView) findViewById(R.id.imvImage);
        cacheImageView.m3052b(false);
        cacheImageView.setImage(this.f1208a.m1517d());
        this.rootView.setOnTouchListener(new C08521(this));
    }

    private void m1443d() {
        C1148d.m2521b(new C08532(this), new Object[0]);
    }

    private void m1444e() {
        this.mHandler.removeCallbacks(this.f1211g);
        this.mHandler.removeCallbacks(this.f1210f);
        if (this.mActionBar.m3013f().isShown()) {
            this.mHandler.post(this.f1210f);
        } else {
            this.mHandler.post(this.f1211g);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        m1441b();
        m1438a(3500);
        this.rootView = layoutInflater.inflate(R.layout.fragment_image_display, null);
        m1442c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1208a = (FileInfo) getArguments().getParcelable("EXTRA_FILE_INFO");
        if (this.f1208a != null) {
            this.b.m54a(this.f1208a.f1288b);
        }
        C1150y.m2605b(this.mActivity, (int) R.string.event_image_display);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_delete) {
            C0781d.m1197a(this.f1208a.f1287a);
            C0793b.m1226a(this.f1208a);
            Intent intent = new Intent();
            intent.putExtra("EXTRA_FILE_INFO", this.f1208a);
            this.b.setResult(-1, intent);
            this.b.mo2042a();
            return true;
        } else if (menuItem.getItemId() != R.id.action_save) {
            return false;
        } else {
            m1443d();
            return true;
        }
    }
}
