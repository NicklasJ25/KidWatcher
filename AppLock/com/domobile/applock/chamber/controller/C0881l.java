package com.domobile.applock.chamber.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.android.camera.C0473h;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1279a;
import java.io.File;

public class C0881l extends C0400d implements OnMenuItemClickListener {
    private FileInfo f1274a;
    private C0473h f1275e;
    private boolean f1276f = false;
    private boolean f1277g = false;
    private boolean f1278h = false;
    private Runnable f1279i = new C08761(this);
    private Runnable f1280j = new C08772(this);

    class C08761 implements Runnable {
        final /* synthetic */ C0881l f1269a;

        class C08751 extends C0415f {
            final /* synthetic */ C08761 f1268a;

            C08751(C08761 c08761) {
                this.f1268a = c08761;
            }

            public void onAnimationEnd(Animation animation) {
                this.f1268a.f1269a.b.m70v();
                this.f1268a.f1269a.mActionBar.m3008c(false);
            }
        }

        C08761(C0881l c0881l) {
            this.f1269a = c0881l;
        }

        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1269a.mActivity, 17432577);
            loadAnimation.setAnimationListener(new C08751(this));
            this.f1269a.b.m66r().startAnimation(loadAnimation);
            this.f1269a.mActionBar.m3013f().startAnimation(loadAnimation);
            this.f1269a.f1275e.m378c();
        }
    }

    class C08772 implements Runnable {
        final /* synthetic */ C0881l f1270a;

        C08772(C0881l c0881l) {
            this.f1270a = c0881l;
        }

        public void run() {
            this.f1270a.b.m71w();
            this.f1270a.mActionBar.m3008c(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f1270a.mActivity, 17432576);
            this.f1270a.b.m66r().startAnimation(loadAnimation);
            this.f1270a.mActionBar.m3013f().startAnimation(loadAnimation);
            this.f1270a.f1275e.m379d();
        }
    }

    class C08783 implements OnTouchListener {
        final /* synthetic */ C0881l f1271a;

        C08783(C0881l c0881l) {
            this.f1271a = c0881l;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f1271a.m1504c();
            }
            return false;
        }
    }

    class C08805 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ C0881l f1273a;

        C08805(C0881l c0881l) {
            this.f1273a = c0881l;
        }

        protected Object doInBackground(Object... objArr) {
            C0793b.m1220a(this.f1273a.mActivity, this.f1273a.f1274a);
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            this.f1273a.hideLoadingDialog();
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f1273a.showCancelableLoadingDialog();
        }
    }

    private void m1500a(long j) {
        this.mHandler.removeCallbacks(this.f1279i);
        this.mHandler.postDelayed(this.f1279i, j);
    }

    private void m1501b() {
        C1148d.m2521b(new C08805(this), new Object[0]);
    }

    private void m1504c() {
        this.mHandler.removeCallbacks(this.f1280j);
        this.mHandler.removeCallbacks(this.f1279i);
        if (this.mActionBar.m3013f().isShown()) {
            this.mHandler.post(this.f1279i);
        } else {
            this.mHandler.post(this.f1280j);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.mActionBar.m3008c(true);
        Object c1279a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.download_list_bottom_menus, c1279a);
        this.mActionBar.m3005b(c1279a, 0, this);
        m1500a(3500);
        this.rootView = layoutInflater.inflate(R.layout.movie_view, null);
        this.rootView.setOnTouchListener(new C08783(this));
        this.f1275e = new C0473h(this, this.rootView, this.mActivity, Uri.fromFile(new File(this.f1274a.f1289c))) {
            final /* synthetic */ C0881l f1272a;

            public void mo2126a(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
                imageView.setVisibility(8);
                imageView.setEnabled(false);
                imageView2.setVisibility(8);
                imageView2.setEnabled(false);
            }
        };
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1274a = (FileInfo) getArguments().getParcelable("EXTRA_FILE_INFO");
        if (this.f1274a != null) {
            this.b.m54a(this.f1274a.f1288b);
        }
        C1150y.m2605b(this.mActivity, (int) R.string.event_video_display);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_delete) {
            C0781d.m1197a(this.f1274a.f1287a);
            C0793b.m1226a(this.f1274a);
            Intent intent = new Intent();
            intent.putExtra("EXTRA_FILE_INFO", this.f1274a);
            this.b.setResult(-1, intent);
            this.b.mo2042a();
            return true;
        } else if (menuItem.getItemId() != R.id.action_save) {
            return false;
        } else {
            m1501b();
            return true;
        }
    }

    public void onPause() {
        super.onPause();
        this.f1276f = false;
        if (this.f1278h) {
            this.f1275e.m372a();
            this.f1278h = false;
        }
    }

    public void onResume() {
        super.onResume();
        this.f1276f = true;
        if (this.f1277g && this.f1276f && !this.f1278h) {
            this.f1275e.m376b();
            this.f1278h = true;
        }
    }
}
