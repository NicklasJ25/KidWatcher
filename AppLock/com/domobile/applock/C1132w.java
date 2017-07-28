package com.domobile.applock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.android.camera.AppLockGallery;
import com.android.camera.C0423j;
import com.android.camera.C0423j.C0408b;
import com.android.camera.C0423j.C0481a;
import com.android.camera.C0433g;
import com.android.camera.C0487k;
import com.android.camera.MovieView;
import com.android.camera.gallery.C0449h;
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.util.CacheManager;
import com.domobile.applock.adapter.C0420b;
import com.domobile.applock.p003a.C0633m;
import com.domobile.applock.service.HidedMediasActionService;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1279a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class C1132w extends C0400d implements C0408b {
    private int f2167a = 0;
    private boolean f2168e = false;
    private String f2169f;
    private boolean f2170g = false;
    private boolean f2171h = false;
    private View f2172i;
    private RecyclerView f2173j;
    private C1279a f2174k;
    private AppLockApplication f2175l;
    private C1131a f2176m;
    private Resources f2177n;
    private int f2178o = -1;
    private boolean f2179p = false;
    private String f2180q = "";
    private BroadcastReceiver f2181r = new C11201(this);
    private Runnable f2182s = new C11222(this);
    private Runnable f2183t = new C11243(this);

    class C11201 extends BroadcastReceiver {
        long f2152a = 0;
        final /* synthetic */ C1132w f2153b;

        C11201(C1132w c1132w) {
            this.f2153b = c1132w;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED".equals(action) && !this.f2153b.f2168e) || ("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED".equals(action) && this.f2153b.f2168e)) {
                CharSequence stringExtra = intent.getStringExtra("com.domobile.elock.EXTRA_DATA_STRING");
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.equals(stringExtra, this.f2153b.f2169f) && this.f2152a + 2000 < currentTimeMillis) {
                    this.f2152a = currentTimeMillis;
                    this.f2153b.m2471e();
                }
            }
        }
    }

    class C11222 implements Runnable {
        final /* synthetic */ C1132w f2155a;

        class C11211 extends C0415f {
            final /* synthetic */ C11222 f2154a;

            C11211(C11222 c11222) {
                this.f2154a = c11222;
            }

            public void onAnimationEnd(Animation animation) {
                this.f2154a.f2155a.mActionBar.m3008c(false);
                this.f2154a.f2155a.findViewById(R.id.adview_layout).setVisibility(0);
            }
        }

        C11222(C1132w c1132w) {
            this.f2155a = c1132w;
        }

        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f2155a.mActivity.getApplicationContext(), 17432577);
            loadAnimation.setAnimationListener(new C11211(this));
            this.f2155a.mActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    class C11243 implements Runnable {
        final /* synthetic */ C1132w f2157a;

        class C11231 extends C0415f {
            final /* synthetic */ C11243 f2156a;

            C11231(C11243 c11243) {
                this.f2156a = c11243;
            }

            public void onAnimationStart(Animation animation) {
                this.f2156a.f2157a.findViewById(R.id.adview_layout).setVisibility(4);
            }
        }

        C11243(C1132w c1132w) {
            this.f2157a = c1132w;
        }

        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f2157a.mActivity.getApplicationContext(), 17432576);
            loadAnimation.setAnimationListener(new C11231(this));
            this.f2157a.mActionBar.m3008c(true);
            this.f2157a.mActionBar.m3013f().startAnimation(loadAnimation);
        }
    }

    class C11254 implements OnMenuItemClickListener {
        final /* synthetic */ C1132w f2158a;

        C11254(C1132w c1132w) {
            this.f2158a = c1132w;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.picture_hider_images_toolbar_menu_delete) {
                if (!this.f2158a.f2170g || this.f2158a.f2176m.m183e().isEmpty()) {
                    C1147a.m2485d(this.f2158a.mActivity, R.string.select_one_limit);
                } else {
                    this.f2158a.m2457a(this.f2158a.f2176m.m183e());
                }
            } else if (itemId == R.id.picture_hider_images_toolbar_menu_unlock) {
                if (!this.f2158a.f2170g || this.f2158a.f2176m.m183e().isEmpty()) {
                    C1147a.m2485d(this.f2158a.mActivity, R.string.select_one_limit);
                } else {
                    this.f2158a.m2465c();
                }
            } else if (itemId == R.id.picture_hider_images_toolbar_menu_checkall) {
                if (this.f2158a.f2176m.m184f() != this.f2158a.f2176m.getItemCount()) {
                    this.f2158a.f2176m.m181c();
                } else {
                    this.f2158a.f2176m.m182d();
                }
                this.f2158a.m2462b();
            }
            return false;
        }
    }

    class C11265 extends Thread {
        final /* synthetic */ C1132w f2159a;

        C11265(C1132w c1132w) {
            this.f2159a = c1132w;
        }

        public void run() {
            CacheManager.removeOldFilesIfNecessary(this.f2159a.mActivity);
            C0487k.m424b(this.f2159a.mActivity);
        }
    }

    class C11276 implements Runnable {
        final /* synthetic */ C1132w f2160a;

        C11276(C1132w c1132w) {
            this.f2160a = c1132w;
        }

        public void run() {
            this.f2160a.m2463b(1);
        }
    }

    class C11287 implements Runnable {
        final /* synthetic */ C1132w f2161a;

        C11287(C1132w c1132w) {
            this.f2161a = c1132w;
        }

        public void run() {
            this.f2161a.m2463b(0);
        }
    }

    class C11298 extends Thread {
        final /* synthetic */ C1132w f2162a;

        C11298(C1132w c1132w) {
            this.f2162a = c1132w;
        }

        public void run() {
            this.f2162a.m2472f();
        }
    }

    private class C1131a extends C0423j implements OnClickListener, OnLongClickListener {
        final /* synthetic */ C1132w f2165a;
        private boolean f2166k = false;

        public C1131a(C1132w c1132w, Activity activity, ArrayList arrayList) {
            this.f2165a = c1132w;
            super(activity, arrayList);
            if (arrayList != null) {
                this.f2166k = true;
            }
            m177a((C0408b) c1132w);
        }

        public int m2449a(HidedPictureItem hidedPictureItem) {
            return m185g().indexOf(hidedPictureItem);
        }

        public HidedPictureItem m2450a(int i) {
            return (HidedPictureItem) m185g().get(i);
        }

        public boolean m2451h() {
            return this.f2166k;
        }

        public void onClick(View view) {
            if (m180b()) {
                super.onClick(view);
            } else if (view != null && view.getTag() != null && (view.getTag() instanceof HidedPictureItem) && view.getId() == R.id.image_gallery_root) {
                this.f2165a.m2453a((HidedPictureItem) view.getTag());
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            C0481a c0481a = (C0481a) super.onCreateViewHolder(viewGroup, i);
            c0481a.f291a.setOnLongClickListener(this);
            if (this.f2165a.f2168e) {
                c0481a.f295e.setVisibility(0);
            }
            return c0481a;
        }

        public boolean onLongClick(View view) {
            boolean z = false;
            if (view.getId() != R.id.image_gallery_root) {
                return false;
            }
            C1148d.m2525c(this.c, 50);
            C1132w c1132w = this.f2165a;
            if (!this.f2165a.f2170g) {
                z = true;
            }
            c1132w.f2170g = z;
            Object tag = view.getTag();
            if (this.f2165a.f2170g && tag != null && (tag instanceof C0449h)) {
                m183e().add(tag);
            }
            this.f2165a.m2458a(this.f2165a.f2170g);
            return true;
        }
    }

    private void m2453a(HidedPictureItem hidedPictureItem) {
        if (a_(0) == null) {
            this.b.m80e();
            if (this.f2168e) {
                this.f2178o = this.f2176m.m2449a(hidedPictureItem);
                Intent intent = new Intent(this.mActivity, MovieView.class);
                intent.putExtra("com.domobile.elock.EXTRA_FILENAME", hidedPictureItem.mo2088e());
                intent.putExtra("com.domobile.elock.EXTRA_POSITION", this.f2178o);
                intent.putParcelableArrayListExtra("com.domobile.elock.EXTRA_PARCELABLE", this.f2176m.m185g());
                startActivityForResult(intent, 100);
                return;
            }
            Uri parse = Uri.parse(hidedPictureItem.getPath().toString());
            Intent intent2 = new Intent(this.mActivity, AppLockGallery.class);
            intent2.setDataAndType(parse, hidedPictureItem.f188g);
            intent2.setAction("android.intent.action.VIEW");
            startActivityForResult(intent2, 100);
        }
    }

    private void m2457a(ArrayList<C0449h> arrayList) {
        C0433g.m244a(this.mActivity, new C11287(this), !this.f2168e);
    }

    private void m2458a(boolean z) {
        this.f2170g = z;
        if (!this.f2170g) {
            this.f2176m.m182d();
        }
        m2474g();
        this.mActivity.invalidateOptionsMenu();
        this.mActionBar.m3011e().setSelected(this.f2170g);
        this.f2173j.setPadding(this.f2173j.getPaddingLeft(), this.f2173j.getPaddingTop(), this.f2173j.getPaddingRight(), this.f2170g ? this.mActivity.getResources().getDimensionPixelSize(R.dimen.adview_height) : 0);
        this.f2176m.m178a(z);
        m2462b();
    }

    private void m2462b() {
        ImageButton a = this.f2174k.m3069a((int) R.id.picture_hider_images_toolbar_menu_checkall).m3072a();
        if (this.f2176m.m184f() == this.f2176m.getItemCount()) {
            a.setImageResource(R.drawable.toolbar_unselect_all);
        } else {
            a.setImageResource(R.drawable.toolbar_select_all);
        }
        if (!this.f2170g || this.f2176m.m183e().isEmpty()) {
            this.b.m54a(this.f2169f);
        } else {
            this.b.m54a(C1147a.m2480a(this.f2169f, "(", Integer.valueOf(this.f2176m.m184f()), ")"));
        }
        m2474g();
    }

    private void m2463b(int i) {
        int i2 = 0;
        int itemCount = this.f2176m.getItemCount();
        while (i2 < itemCount && i2 < 3) {
            if (this.f2176m.m183e().contains(this.f2176m.m2450a(i2))) {
                m2468d();
                break;
            }
            i2++;
        }
        Iterator it = this.f2176m.m183e().iterator();
        while (it.hasNext()) {
            ((HidedPictureItem) it.next()).f192k = i;
        }
        C0633m c0633m = (C0633m) this.f2175l.m596j().get(this.f2169f);
        if (c0633m == null) {
            c0633m = new C0633m();
        }
        c0633m.f574b.addAll(this.f2176m.m183e());
        c0633m.f573a = this.f2169f;
        this.f2175l.m596j().put(this.f2169f, c0633m);
        HidedMediasActionService.m2135a(this.mActivity);
        this.b.mo2042a();
    }

    private void m2465c() {
        C0433g.m243a(this.mActivity, new C11276(this));
    }

    private void m2466c(int i) {
        int i2 = 3;
        int itemCount = this.f2176m.getItemCount();
        if (i >= 0 && i < 3 && itemCount > 0) {
            int i3 = 0;
            Object obj = "";
            while (i3 < i2 && i3 < itemCount) {
                if (i3 == i) {
                    i2++;
                } else {
                    obj = obj + (TextUtils.isEmpty(obj) ? "" : ",") + this.f2176m.m2450a(i3).getMediaID();
                }
                i3++;
            }
            if (!TextUtils.isEmpty(obj)) {
                this.f2179p = true;
                HidedPictureItem.m270a(this.mActivity, this.f2169f, obj, this.f2168e);
            }
        }
    }

    private void m2468d() {
        ArrayList arrayList = (ArrayList) this.f2176m.m185g().clone();
        arrayList.removeAll(this.f2176m.m183e());
        int size = arrayList.size();
        int i = 0;
        Object obj = "";
        while (i < size && i < 3) {
            String str = i == 0 ? "" : ",";
            obj = C1147a.m2480a(obj, str, ((HidedPictureItem) arrayList.get(i)).f182a);
            i++;
        }
        if (!TextUtils.isEmpty(obj)) {
            this.f2179p = true;
            HidedPictureItem.m270a(this.mActivity, this.f2169f, obj, this.f2168e);
        }
    }

    private void m2471e() {
        new C11298(this).start();
    }

    private void m2472f() {
        final ArrayList arrayList = new ArrayList();
        Cursor a = C0487k.m400a(this.f2169f, this.f2168e, -1);
        boolean isEmpty = TextUtils.isEmpty(this.f2180q);
        if (a != null) {
            int i = 0;
            ArrayList c = this.f2175l.m589c(this.f2169f);
            while (a.moveToNext()) {
                String string = a.getString(a.getColumnIndex(Columns.ID));
                if (!(this.f2175l.m598l().contains(string) || c.contains(string))) {
                    HidedPictureItem hidedPictureItem = new HidedPictureItem(HidedPictureItem.m264a(a), this.mActivity, a);
                    if (new File(hidedPictureItem.f185d).exists()) {
                        if (isEmpty && i < 3) {
                            this.f2180q += hidedPictureItem.getRotation();
                        }
                        i++;
                        arrayList.add(hidedPictureItem);
                    } else {
                        hidedPictureItem.m282b(this.mActivity, true);
                    }
                }
            }
            a.close();
        }
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ C1132w f2164b;

            public void run() {
                this.f2164b.hideLoadingDialog_mt();
                this.f2164b.f2172i.setVisibility(8);
                if (arrayList.size() == 0) {
                    this.f2164b.f2172i.setVisibility(0);
                }
                this.f2164b.f2176m = new C1131a(this.f2164b, this.f2164b.mActivity, arrayList);
                this.f2164b.f2173j.setAdapter(this.f2164b.f2176m);
            }
        });
    }

    private void m2474g() {
        if (this.f2170g) {
            if (!this.mActionBar.m3013f().isShown()) {
                this.mActionBar.m3013f().post(this.f2183t);
            }
        } else if (this.mActionBar.m3013f().isShown()) {
            this.mActionBar.m3013f().post(this.f2182s);
        }
    }

    public void mo2064a(C0423j c0423j, C0449h c0449h, boolean z) {
        m2474g();
        m2462b();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.image_gallery, null);
        this.f2172i = findViewById(R.id.no_images);
        this.f2173j = (RecyclerView) findViewById(R.id.listview);
        this.f2173j.setLayoutManager(new GridLayoutManager(this.mActivity, C0420b.m168a(this.mActivity)));
        this.mActionBar.m3008c(false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 100 || i2 != -1) {
            return;
        }
        if (this.f2168e) {
            m2466c(this.f2178o);
            if (this.f2178o == 0 && this.f2176m.getItemCount() <= 1) {
                Intent intent2 = new Intent("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED");
                intent2.putExtra("com.domobile.elock.EXTRA_FORCE_RELOAD", true);
                C1148d.m2510a(this.mActivity, intent2);
                this.b.mo2042a();
            }
            this.f2178o = -1;
            return;
        }
        intent2 = new Intent("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
        intent2.putExtra("com.domobile.elock.EXTRA_FORCE_RELOAD", true);
        C1148d.m2510a(this.mActivity, intent2);
        this.b.mo2042a();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0420b.m169a(this.f2173j, C0420b.m168a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        showCancelableLoadingDialog_mt();
        this.f2169f = this.mActivity.getIntent().getStringExtra("album");
        this.f2167a = this.mActivity.getIntent().getIntExtra("com.domobile.elock.EXTRA_TYPE", 0);
        this.f2168e = this.f2167a == 1;
        this.f2177n = this.mActivity.getResources();
        this.f2175l = C1150y.m2566a(this.mActivity);
        if (TextUtils.isEmpty(this.f2169f)) {
            this.b.mo2042a();
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
        intentFilter.addAction("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED");
        this.mActivity.registerReceiver(this.f2181r, intentFilter);
        this.b.m54a(this.f2169f);
        this.f2176m = new C1131a(this, this.mActivity, null);
        C1257b.m2966a(this.mActivity).m2980a(1).m2981a(true);
        this.f2174k = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.picture_hider_images_toolbar_menus, this.f2174k);
        this.mActionBar.m3005b(this.f2174k, 0, new C11254(this));
        m2471e();
        C1150y.m2605b(this.mActivity, (int) R.string.event_picture_hider_images);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.picture_hider_images_actionbar_menus, menu);
        if (this.f2170g) {
            menu.findItem(R.id.menu_actionbar_edit).setIcon(R.drawable.toolbar_ok);
        }
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        C1148d.m2509a(this.mActivity, this.f2181r);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.f2170g) {
            return super.onKeyDown(i, keyEvent);
        }
        m2458a(!this.f2170g);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        boolean z2 = true;
        if (menuItem.getItemId() == 16908332 && this.f2170g) {
            if (!this.f2170g) {
                z = true;
            }
            m2458a(z);
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_actionbar_edit) {
            if (this.f2170g) {
                z2 = false;
            }
            this.f2170g = z2;
            m2458a(this.f2170g);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super.onPause();
        this.f2171h = false;
        if (!this.f2179p) {
            int itemCount = this.f2176m.getItemCount();
            Object obj = "";
            CharSequence charSequence = "";
            int i = 0;
            while (i < itemCount && i < 3) {
                String str = charSequence + this.f2176m.m2450a(i).getRotation();
                String str2 = i == 0 ? "" : ",";
                obj = C1147a.m2480a(obj, str2, r6.f182a);
                i++;
                Object obj2 = str;
            }
            if (!TextUtils.equals(charSequence, this.f2180q) && !TextUtils.isEmpty(obj)) {
                HidedPictureItem.m270a(this.mActivity, this.f2169f, obj, this.f2168e);
            }
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.menu_actionbar_edit).getIcon().setAlpha(255);
    }

    public void onResume() {
        super.onResume();
        this.f2171h = true;
        if (this.f2176m.m2451h() && this.f2176m.getItemCount() == 0) {
            this.b.mo2042a();
        }
    }

    public void onStart() {
        super.onStart();
        new C11265(this).start();
    }

    public void ui(int i, Message message) {
    }
}
