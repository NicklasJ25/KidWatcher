package com.android.camera;

import android.content.Intent;
import android.net.Uri;
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
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.data.HidedMediaItem.OnActionDoneListener;
import com.domobile.applock.C0400d;
import com.domobile.applock.R;
import com.domobile.frame.C0415f;
import com.domobile.frame.ui.C1279a;
import java.io.File;
import java.util.ArrayList;

public class C0480i extends C0400d implements OnMenuItemClickListener, OnActionDoneListener {
    private C0473h f282a;
    private boolean f283e = false;
    private boolean f284f = false;
    private boolean f285g = false;
    private HidedPictureItem f286h;
    private int f287i;
    private ArrayList<HidedPictureItem> f288j;
    private Runnable f289k = new C04751(this);
    private Runnable f290l = new C04762(this);

    class C04751 implements Runnable {
        final /* synthetic */ C0480i f277a;

        class C04741 extends C0415f {
            final /* synthetic */ C04751 f276a;

            C04741(C04751 c04751) {
                this.f276a = c04751;
            }

            public void onAnimationEnd(Animation animation) {
                this.f276a.f277a.b.m70v();
                this.f276a.f277a.mActionBar.m3008c(false);
            }
        }

        C04751(C0480i c0480i) {
            this.f277a = c0480i;
        }

        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f277a.mActivity, 17432577);
            loadAnimation.setAnimationListener(new C04741(this));
            this.f277a.b.m66r().startAnimation(loadAnimation);
            this.f277a.mActionBar.m3013f().startAnimation(loadAnimation);
            this.f277a.f282a.m378c();
        }
    }

    class C04762 implements Runnable {
        final /* synthetic */ C0480i f278a;

        C04762(C0480i c0480i) {
            this.f278a = c0480i;
        }

        public void run() {
            this.f278a.b.m71w();
            this.f278a.mActionBar.m3008c(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f278a.mActivity, 17432576);
            this.f278a.b.m66r().startAnimation(loadAnimation);
            this.f278a.mActionBar.m3013f().startAnimation(loadAnimation);
            this.f278a.f282a.m379d();
        }
    }

    class C04773 implements OnTouchListener {
        final /* synthetic */ C0480i f279a;

        C04773(C0480i c0480i) {
            this.f279a = c0480i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f279a.m391e();
            }
            return false;
        }
    }

    class C04795 extends Thread {
        final /* synthetic */ C0480i f281a;

        C04795(C0480i c0480i) {
            this.f281a = c0480i;
        }

        public void run() {
            if (this.f281a.f286h != null) {
                try {
                    this.f281a.showCancelableLoadingDialog();
                    this.f281a.f286h.shareHidedMedia(this.f281a.mActivity);
                } catch (Exception e) {
                } finally {
                    this.f281a.hideLoadingDialog();
                }
            }
        }
    }

    private void m384a(long j) {
        this.mHandler.removeCallbacks(this.f289k);
        this.mHandler.postDelayed(this.f289k, j);
    }

    private void m385b() {
        this.f286h = (HidedPictureItem) this.f288j.get(this.f287i);
        this.f282a.m373a(Uri.fromFile(new File(this.f286h.f185d)));
    }

    private void m388c() {
        if (this.f286h != null) {
            this.f286h.setOnActionDoneListener(this);
            this.f286h.revertHidedMediaConfirm(this.mActivity);
        }
    }

    private void m390d() {
        new C04795(this).start();
    }

    private void m391e() {
        this.mHandler.removeCallbacks(this.f290l);
        this.mHandler.removeCallbacks(this.f289k);
        if (this.mActionBar.m3013f().isShown()) {
            this.mHandler.post(this.f289k);
        } else {
            this.mHandler.post(this.f290l);
        }
    }

    public void deleteHidedMediaDone(boolean z) {
        if (z) {
            this.b.setResult(-1);
            this.b.mo2042a();
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3008c(true);
        C1279a c1279a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.gallery_toolbar_menus, c1279a);
        c1279a.removeItem(R.id.gallery_toolbar_menu_rotate_left);
        c1279a.removeItem(R.id.gallery_toolbar_menu_rotate_right);
        this.mActionBar.m3005b(c1279a, 0, this);
        m384a(3500);
        this.rootView = layoutInflater.inflate(R.layout.movie_view, null);
        this.rootView.setOnTouchListener(new C04773(this));
        this.f282a = new C0473h(this, this.rootView, this.mActivity, Uri.fromFile(new File(this.f286h.f185d))) {
            final /* synthetic */ C0480i f280a;

            public void mo2125a(View view) {
                if (this.f280a.f287i > 0) {
                    this.f280a.f287i = this.f280a.f287i - 1;
                    this.f280a.m385b();
                }
            }

            public void mo2126a(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
                if (this.f280a.f287i <= 0) {
                    imageView.setEnabled(false);
                } else {
                    imageView.setEnabled(true);
                }
                if (this.f280a.f287i >= this.f280a.f288j.size() - 1) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setEnabled(true);
                }
            }

            public void mo2127b(View view) {
                if (this.f280a.f287i + 1 < this.f280a.f288j.size()) {
                    this.f280a.f287i = this.f280a.f287i + 1;
                    this.f280a.m385b();
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = this.mActivity.getIntent();
            this.f287i = intent.getIntExtra("com.domobile.elock.EXTRA_POSITION", 0);
            this.f288j = intent.getParcelableArrayListExtra("com.domobile.elock.EXTRA_PARCELABLE");
            this.f286h = (HidedPictureItem) this.f288j.get(intent.getIntExtra("com.domobile.elock.EXTRA_POSITION", 0));
            this.b.m54a(intent.getStringExtra("com.domobile.elock.EXTRA_FILENAME"));
        } catch (Exception e) {
            this.b.mo2042a();
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.gallery_toolbar_menu_detail) {
            if (this.f286h != null) {
                this.f286h.showHidedMediaDetail(this.mActivity);
            }
        } else if (itemId == R.id.gallery_toolbar_menu_revert) {
            m388c();
        } else if (itemId == R.id.gallery_toolbar_menu_share) {
            m390d();
        } else if (itemId == R.id.gallery_toolbar_menu_delete && this.f286h != null) {
            this.f286h.setOnActionDoneListener(this);
            this.f286h.deleteHidedMedia(this.mActivity);
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.f283e = false;
        if (this.f285g) {
            this.f282a.m372a();
            this.f285g = false;
        }
    }

    public void onResume() {
        super.onResume();
        this.f283e = true;
        if (this.f284f && this.f283e && !this.f285g) {
            this.f282a.m376b();
            this.f285g = true;
        }
    }

    public void revertHidedMediaDone(boolean z) {
        deleteHidedMediaDone(z);
    }
}
