package com.android.camera;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.android.camera.C0423j.C0408b;
import com.android.camera.ImageManager.C0381a;
import com.android.camera.ImageManager.ImageListParam;
import com.android.camera.gallery.C0382g;
import com.android.camera.gallery.C0449h;
import com.android.camera.gallery.C0450f;
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.app.Gallery;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0420b;
import com.domobile.applock.p003a.C0633m;
import com.domobile.applock.service.HidedMediasActionService;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1279a;
import com.domobile.frame.ui.C1290d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class C0409d extends C0400d implements OnMenuItemClickListener, C0408b {
    boolean f91a = false;
    private int f92e;
    private C1279a f93f;
    private View f94g;
    private RecyclerView f95h;
    private C1290d f96i;
    private ImageListParam f97j;
    private ArrayList<C0449h> f98k;
    private C0382g f99l;
    private C0423j f100m;
    private AppLockApplication f101n;
    private String f102o;

    class C04032 implements Runnable {
        final /* synthetic */ C0409d f86a;

        C04032(C0409d c0409d) {
            this.f86a = c0409d;
        }

        public void run() {
            this.f86a.f96i = C1290d.m3132a(this.f86a.mActivity, null, this.f86a.mActivity.getString(R.string.wait), true, true);
            this.f86a.f96i.m3117b(true);
        }
    }

    class C04043 implements Runnable {
        final /* synthetic */ C0409d f87a;

        C04043(C0409d c0409d) {
            this.f87a = c0409d;
        }

        public void run() {
            this.f87a.m140b();
            this.f87a.f100m = new C0423j(this.f87a.mActivity, this.f87a.f98k, true);
            this.f87a.f100m.m177a(this.f87a);
            this.f87a.f95h.setAdapter(this.f87a.f100m);
            this.f87a.f94g.setVisibility(this.f87a.f98k.isEmpty() ? 0 : 8);
        }
    }

    class C04054 implements Runnable {
        final /* synthetic */ C0409d f88a;

        C04054(C0409d c0409d) {
            this.f88a = c0409d;
        }

        public void run() {
            this.f88a.f96i.m3125e();
            this.f88a.f96i = null;
        }
    }

    class C04065 implements Runnable {
        final /* synthetic */ C0409d f89a;

        C04065(C0409d c0409d) {
            this.f89a = c0409d;
        }

        public void run() {
            this.f89a.m147d();
        }
    }

    class C04076 extends Thread {
        final /* synthetic */ C0409d f90a;

        C04076(C0409d c0409d) {
            this.f90a = c0409d;
        }

        public void run() {
            this.f90a.showLoadingDialog();
            Collection arrayList = new ArrayList();
            Iterator it = this.f90a.f100m.m183e().iterator();
            while (it.hasNext()) {
                HidedPictureItem hidedPictureItem = new HidedPictureItem((C0450f) it.next());
                hidedPictureItem.f192k = 2;
                arrayList.add(hidedPictureItem);
            }
            if (!HidedMediasActionService.m2151d()) {
                Intent intent = new Intent(this.f90a.f92e == 4 ? "com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED" : "com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
                intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", this.f90a.f102o);
                intent.putExtra("com.domobile.elock.EXTRA_ADD_TO_ALBUM", true);
                C1148d.m2510a(this.f90a.mActivity, intent);
            }
            C0633m c0633m = (C0633m) this.f90a.f101n.m596j().get(this.f90a.f102o);
            if (c0633m == null) {
                c0633m = new C0633m();
            }
            c0633m.f573a = this.f90a.f102o;
            c0633m.f574b.addAll(arrayList);
            this.f90a.f101n.m596j().put(this.f90a.f102o, c0633m);
            HidedMediasActionService.m2135a(this.f90a.mActivity);
            this.f90a.hideLoadingDialog();
            this.f90a.mActivity.setResult(-1);
            this.f90a.b.mo2042a();
        }
    }

    private ImageListParam m133a(boolean z) {
        if (!z) {
            return ImageManager.m40b();
        }
        Uri data = this.mActivity.getIntent().getData();
        return ImageManager.m34a(C0381a.EXTERNAL, this.f92e, this.f91a ? 1 : 2, data != null ? data.getQueryParameter("bucketId") : null);
    }

    private void m138a(final boolean z, final boolean z2) {
        new Thread(this) {
            final /* synthetic */ C0409d f85c;

            public void run() {
                this.f85c.showCancelableLoadingDialog();
                this.f85c.m142b(z, z2);
                this.f85c.hideLoadingDialog();
            }
        }.start();
    }

    private boolean m139a(String str) {
        return str.equals("vnd.android.cursor.dir/image") || str.equals(GalleryUtils.MIME_TYPE_IMAGE);
    }

    private void m140b() {
        if (this.f96i != null) {
            this.mHandler.post(new C04054(this));
        }
    }

    private void m142b(boolean z, boolean z2) {
        int i = 0;
        if (this.f99l != null) {
            this.f99l.mo2037a();
            this.f99l = null;
        }
        m140b();
        if (z2) {
            this.mHandler.post(new C04032(this));
        }
        boolean z3 = (z || z2) ? false : true;
        this.f97j = m133a(z3);
        this.f99l = ImageManager.m35a(this.mActivity, this.f97j);
        ArrayList c = this.f101n.m589c(this.f102o);
        this.f98k = new ArrayList();
        int c2 = this.f99l == null ? 0 : this.f99l.mo2039c();
        while (i < c2) {
            try {
                C0450f a = this.f99l.mo2036a(i);
                String uri = a.mo2108b().toString();
                if (this.f101n.m598l().contains(uri) && c.contains(uri)) {
                    i++;
                } else {
                    this.f98k.add(a);
                    i++;
                }
            } catch (Exception e) {
            }
        }
        this.mHandler.post(new C04043(this));
    }

    private boolean m143b(String str) {
        return str.equals("vnd.android.cursor.dir/video") || str.equals(GalleryUtils.MIME_TYPE_VIDEO);
    }

    private void m145c() {
        boolean z = false;
        if (this.f100m.m184f() <= 0) {
            C1147a.m2485d(this.mActivity, R.string.select_one_limit);
        } else if (a_(0) == null) {
            if (this.f92e == 4) {
                z = true;
            }
            C0433g.m246a(this.mActivity, z, new C04065(this));
        }
    }

    private void m147d() {
        new C04076(this).start();
    }

    private void m149e() {
        ImageButton a = this.f93f.m3069a((int) R.id.image_gallery_selectall).m3072a();
        if (this.f100m.m184f() == this.f100m.getItemCount()) {
            a.setImageResource(R.drawable.toolbar_unselect_all);
        } else {
            a.setImageResource(R.drawable.toolbar_select_all);
        }
        if (this.f100m.m183e().isEmpty()) {
            this.b.m54a(this.f102o);
            return;
        }
        this.b.m54a(C1147a.m2480a(this.f102o, "(", Integer.valueOf(this.f100m.m184f()), ")"));
    }

    private void m151f() {
        this.f92e = 5;
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            String resolveType = intent.resolveType(this.mActivity);
            if (resolveType != null) {
                if (m139a(resolveType)) {
                    this.f92e = 1;
                }
                if (m143b(resolveType)) {
                    this.f92e = 4;
                }
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.f92e = extras.getInt(Gallery.KEY_MEDIA_TYPES, this.f92e) & 5;
            }
        }
    }

    public void mo2064a(C0423j c0423j, C0449h c0449h, boolean z) {
        m149e();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3008c(true);
        this.rootView = layoutInflater.inflate(R.layout.image_gallery, null);
        this.f94g = findViewById(R.id.no_images);
        this.f95h = (RecyclerView) findViewById(R.id.listview);
        this.f95h.setPadding(this.f95h.getPaddingLeft(), this.f95h.getPaddingTop(), this.f95h.getPaddingRight(), this.mActivity.getResources().getDimensionPixelSize(R.dimen.action_toolbar_height));
        this.f95h.setLayoutManager(new GridLayoutManager(this.mActivity.getApplicationContext(), C0420b.m168a(this.mActivity)));
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0420b.m169a(this.f95h, C0420b.m168a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1257b.m2966a(this.mActivity.getApplicationContext()).m2981a(true);
        C1257b.m2966a(this.mActivity.getApplicationContext()).m2980a(1);
        m151f();
        this.f101n = C1150y.m2566a(this.mActivity);
        this.f102o = this.mActivity.getIntent().getStringExtra("EXTRA_BUCKET_NAME");
        this.b.m54a(this.f102o);
        this.f93f = new C1279a(this.mActivity);
        this.f93f.add(0, (int) R.id.image_gallery_selectall, 0, (int) R.string.select_all).setIcon(R.drawable.toolbar_select_all);
        this.f93f.add(0, (int) R.id.image_gallery_hide, 1, (int) R.string.hide).setIcon(R.drawable.toolbar_lock);
        this.mActionBar.m3005b(this.f93f, 0, this);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.image_gallery_selectall) {
            if (this.f100m != null) {
                if (this.f100m.getItemCount() != this.f100m.m184f()) {
                    this.f100m.m181c();
                } else {
                    this.f100m.m182d();
                }
                m149e();
            }
        } else if (menuItem.getItemId() == R.id.image_gallery_hide) {
            m145c();
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        if (this.f99l != null) {
            this.f99l.mo2037a();
            this.f99l = null;
        }
    }

    public void onResume() {
        super.onResume();
        m138a(false, false);
    }

    public void ui(int i, Message message) {
    }
}
