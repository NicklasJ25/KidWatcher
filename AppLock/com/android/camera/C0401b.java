package com.android.camera;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.provider.MediaStore.Images.Media;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.camera.ImageManager.C0381a;
import com.android.camera.gallery.C0382g;
import com.android.camera.gallery.C0450f;
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.app.Gallery;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0420b;
import com.domobile.applock.adapter.C0670a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1290d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class C0401b extends C0400d {
    private int f74a = 1;
    private Handler f75e = new Handler();
    private Thread f76f;
    private C0670a f77g;
    private ContentResolver f78h;
    private RecyclerView f79i;
    private View f80j;
    private ArrayList<C0382g> f81k = new ArrayList();
    private C1290d f82l;

    class C03911 implements Runnable {
        final /* synthetic */ C0401b f57a;

        C03911(C0401b c0401b) {
            this.f57a = c0401b;
        }

        public void run() {
            this.f57a.m119b();
        }
    }

    class C03955 implements Runnable {
        final /* synthetic */ C0401b f63a;

        C03955(C0401b c0401b) {
            this.f63a = c0401b;
        }

        public void run() {
            this.f63a.m128e();
        }
    }

    class C03966 implements Runnable {
        final /* synthetic */ C0401b f64a;

        C03966(C0401b c0401b) {
            this.f64a = c0401b;
        }

        public void run() {
            this.f64a.m130g();
        }
    }

    private class C0398a implements C0397c {
        public final String f65a;
        public final String f66b;
        public final C0382g f67c;
        public final int f68d;
        final /* synthetic */ C0401b f69e;

        public C0398a(C0401b c0401b, String str, String str2, C0382g c0382g) {
            this.f69e = c0401b;
            this.f65a = str;
            this.f66b = str2;
            this.f67c = c0382g;
            this.f68d = c0382g.mo2039c();
        }

        public Bitmap mo2047a(int i) {
            C0450f a = this.f67c.mo2036a(i);
            return a == null ? null : a.mo2089f();
        }

        public void mo2048a() {
            Uri build = Media.INTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("bucketId", this.f65a).build();
            this.f69e.b.m80e();
            Intent a = AgentActivity.m570a(this.f69e.mActivity, 293);
            a.putExtra("EXTRA_BUCKET_NAME", this.f66b);
            a.putExtra(Gallery.KEY_MEDIA_TYPES, this.f69e.f74a);
            a.setData(build);
            this.f69e.startActivityForResult(a, 10);
        }

        public int mo2049b() {
            return this.f67c.mo2039c();
        }

        public int mo2050b(int i) {
            C0450f a = this.f67c.mo2036a(i);
            return a == null ? 0 : a.mo2085d();
        }

        public String mo2051c() {
            return this.f66b;
        }

        public void mo2052c(int i) {
        }

        public int mo2053d() {
            return this.f68d;
        }

        public boolean mo2054e() {
            return HidedPictureItem.m273a(this.f67c.mo2036a(0).getMimeType());
        }
    }

    private C0382g m113a(int i, String str) {
        C0382g a = ImageManager.m36a(this.mActivity, C0381a.ALL, i, 2, str);
        this.f81k.add(a);
        return a;
    }

    private void m114a(C0398a c0398a) {
        if (this.f77g.getItemCount() == 0) {
            m121b(false);
        }
        this.f77g.m872a((C0397c) c0398a);
    }

    private void m118a(ArrayList<C0398a> arrayList) {
        C0382g a = ImageManager.m36a(this.mActivity, C0381a.ALL, this.f74a, 2, null);
        HashMap b = a.mo2038b();
        a.mo2037a();
        for (Entry entry : b.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                final C0398a c0398a = new C0398a(this, str, (String) entry.getValue(), m113a(this.f74a, str));
                arrayList.add(c0398a);
                this.f75e.post(new Runnable(this) {
                    final /* synthetic */ C0401b f62b;

                    public void run() {
                        this.f62b.m114a(c0398a);
                    }
                });
            }
        }
        this.f75e.post(new C03955(this));
    }

    private void m119b() {
        this.f76f = new Thread(this, "GalleryPicker Worker") {
            final /* synthetic */ C0401b f58a;

            public void run() {
                this.f58a.m122c();
            }
        };
        C0390a.m84a().m91c(this.f76f);
        this.f76f.start();
    }

    private void m121b(boolean z) {
        this.f80j.setVisibility(z ? 0 : 8);
    }

    private void m122c() {
        ArrayList arrayList = new ArrayList();
        m125d();
        m118a(arrayList);
        m129f();
        m125d();
    }

    private void m124c(boolean z) {
        m131a(z);
    }

    private void m125d() {
        final boolean a = ImageManager.m38a(this.f78h);
        this.f75e.post(new Runnable(this) {
            final /* synthetic */ C0401b f60b;

            public void run() {
                this.f60b.m124c(a);
            }
        });
    }

    private void m128e() {
        if (this.f77g.getItemCount() == 0) {
            m121b(true);
        }
    }

    private void m129f() {
        if (ImageManager.m41c()) {
            StatFs statFs = new StatFs(C1150y.L);
            if (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) < 2097152) {
                this.f75e.post(new C03966(this));
            }
        }
    }

    private void m130g() {
        C1147a.m2486e(this.mActivity, R.string.not_enough_space);
    }

    public void m131a(boolean z) {
        boolean z2 = this.f82l != null;
        if (z2 != z || this.f77g.m871a().size() != 0) {
            if (z2) {
                this.f82l.m3125e();
                this.f82l = null;
            } else if (z && this.f77g.m871a().size() == 0) {
                this.f82l = C1148d.m2505a(this.mActivity, null, this.mActivity.getResources().getString(R.string.wait));
                this.f82l.m3117b(true);
            }
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3010d(true);
        this.rootView = layoutInflater.inflate(R.layout.gallerypicker, null);
        this.f80j = findViewById(16908292);
        this.f79i = (RecyclerView) findViewById(R.id.albums);
        this.f79i.setLayoutManager(new GridLayoutManager(this.mActivity, C0670a.m867a(this.mActivity)));
        this.f77g = new C0670a(this.mActivity, null);
        this.f79i.setAdapter(this.f77g);
        this.f79i.postDelayed(new C03911(this), 100);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            this.b.mo2042a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0420b.m169a(this.f79i, C0670a.m867a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        this.f78h = this.mActivity.getContentResolver();
        this.f74a = this.mActivity.getIntent().getIntExtra("com.domobile.elock.EXTRA_TYPE", 1);
        if (this.f74a != 4) {
            i = 0;
        }
        this.b.m56b(i != 0 ? R.string.album_video : R.string.album_image);
        ImageManager.m37a();
    }

    public void ui(int i, Message message) {
    }
}
