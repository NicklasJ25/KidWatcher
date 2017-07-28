package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.android.camera.C0397c;
import com.android.camera.C0411e;
import com.android.camera.C0487k;
import com.android.camera.gallery.C0453c;
import com.android.camera.gallery.HidedPictureItem;
import com.domobile.applock.adapter.C0420b;
import com.domobile.applock.adapter.C0670a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1288c;
import com.domobile.widget.OverscrollRecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class C1119v extends C0704e implements OnTouchListener {
    private OverscrollRecyclerView f2143a;
    private C0670a f2144e;
    private int f2145f = 0;
    private long f2146g = 0;
    private boolean f2147h = false;
    private String f2148i = null;
    private String f2149j = null;
    private boolean f2150k = false;
    private BroadcastReceiver f2151l = new C11102(this);

    class C11061 implements Runnable {
        final /* synthetic */ C1119v f2119a;

        C11061(C1119v c1119v) {
            this.f2119a = c1119v;
        }

        public void run() {
            this.f2119a.m2439e();
        }
    }

    class C11102 extends BroadcastReceiver {
        final /* synthetic */ C1119v f2125a;

        class C11071 extends Thread {
            final /* synthetic */ C11102 f2120a;

            C11071(C11102 c11102) {
                this.f2120a = c11102;
            }

            public void run() {
                this.f2120a.f2125a.m2448d();
            }
        }

        C11102(C1119v c1119v) {
            this.f2125a = c1119v;
        }

        public void onReceive(final Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.domobile.elock.action.ACTION_SCAN_UNTRACKED_IMAGES_COMPLETE".equals(action)) {
                this.f2125a.m2431a(null, true);
            } else if ("com.domobile.elock.action.ACTION_RELOAD_ALBUM_IMAGE".equals(action)) {
                if (intent.getBooleanExtra("com.domobile.elock.EXTRA_IS_VIDEO_TYPE", false) == this.f2125a.f2147h) {
                    this.f2125a.f2148i = intent.getStringExtra("com.domobile.elock.EXTRA_DATA_STRING");
                    this.f2125a.f2149j = intent.getStringExtra("android.intent.extra.TEXT");
                    if (this.f2125a.f2150k) {
                        new C11071(this).start();
                    }
                }
            } else if (("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED".equals(action) && !this.f2125a.f2147h) || ("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED".equals(action) && this.f2125a.f2147h)) {
                final Object stringExtra = intent.getStringExtra("com.domobile.elock.EXTRA_DATA_STRING");
                boolean booleanExtra = intent.getBooleanExtra("com.domobile.elock.EXTRA_FORCE_RELOAD", false);
                long currentTimeMillis = System.currentTimeMillis();
                if (intent.getBooleanExtra("com.domobile.elock.EXTRA_ADD_TO_ALBUM", false) && !TextUtils.isEmpty(stringExtra)) {
                    this.f2125a.f2146g = currentTimeMillis;
                    new Thread(this) {
                        final /* synthetic */ C11102 f2124c;

                        class C11081 implements Runnable {
                            final /* synthetic */ C11092 f2121a;

                            C11081(C11092 c11092) {
                                this.f2121a = c11092;
                            }

                            public void run() {
                                this.f2121a.f2124c.f2125a.f2144e.m871a().add(new C1118a(this.f2121a.f2124c.f2125a, context, stringExtra, 0));
                                this.f2121a.f2124c.f2125a.f2144e.notifyItemInserted(this.f2121a.f2124c.f2125a.f2144e.getItemCount() - 1);
                                this.f2121a.f2124c.f2125a.m2444g();
                            }
                        }

                        public void run() {
                            Object obj;
                            Iterator it = this.f2124c.f2125a.f2144e.m871a().iterator();
                            while (it.hasNext()) {
                                if (TextUtils.equals(((C0397c) it.next()).mo2051c(), stringExtra)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                this.f2124c.f2125a.mHandler.post(new C11081(this));
                            }
                        }
                    }.start();
                } else if (TextUtils.isEmpty(stringExtra) || booleanExtra || this.f2125a.f2146g + 2000 < currentTimeMillis) {
                    this.f2125a.f2146g = currentTimeMillis;
                    this.f2125a.m2431a((String) stringExtra, booleanExtra);
                }
            }
        }
    }

    class C11113 extends Thread {
        final /* synthetic */ C1119v f2126a;

        C11113(C1119v c1119v) {
            this.f2126a = c1119v;
        }

        public void run() {
            this.f2126a.m2448d();
        }
    }

    class C11124 implements OnClickListener {
        final /* synthetic */ C1119v f2127a;

        C11124(C1119v c1119v) {
            this.f2127a = c1119v;
        }

        public void onClick(View view) {
            this.f2127a.b.mo2042a();
        }
    }

    class C11135 implements OnGlobalLayoutListener {
        final /* synthetic */ C1119v f2128a;

        C11135(C1119v c1119v) {
            this.f2128a = c1119v;
        }

        public void onGlobalLayout() {
            C1148d.m2515a(this.f2128a.f2143a.getViewTreeObserver(), (OnGlobalLayoutListener) this);
            this.f2128a.f2143a.m3553a(this.f2128a.b.m66r().getHeight(), this.f2128a.mActivity.findViewById(R.id.tab_actionbar_layout));
        }
    }

    class C11146 implements OnClickListener {
        final /* synthetic */ C1119v f2129a;

        C11146(C1119v c1119v) {
            this.f2129a = c1119v;
        }

        public void onClick(View view) {
            C0487k.m414a(this.f2129a);
        }
    }

    private class C1118a implements C0397c {
        public boolean f2137a;
        public String f2138b;
        public int f2139c;
        final /* synthetic */ C1119v f2140d;
        private ArrayList<HidedPictureItem> f2141e = new ArrayList();
        private int f2142f = 320;

        public C1118a(C1119v c1119v, Context context, String str, int i) {
            this.f2140d = c1119v;
            this.f2142f = C1150y.m2548M(context).x;
            this.f2138b = str;
            this.f2139c = i;
        }

        private void m2416a(C1118a c1118a, boolean z) {
            if (z) {
                this.f2141e.clear();
                this.f2141e.addAll(c1118a.f2141e);
            }
            this.f2138b = c1118a.f2138b;
            this.f2139c = c1118a.f2139c;
        }

        public Bitmap mo2047a(int i) {
            HidedPictureItem hidedPictureItem = (HidedPictureItem) this.f2141e.get(i);
            String h = hidedPictureItem.mo2099h();
            if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                return BitmapFactory.decodeFile(h);
            }
            return hidedPictureItem.m289g() ? ThumbnailUtils.createVideoThumbnail(hidedPictureItem.mo2082a(), 1) : C0453c.m314a(hidedPictureItem.mo2082a(), this.f2142f);
        }

        public void mo2048a() {
            this.f2140d.b.m80e();
            Intent a = AgentActivity.m570a(this.f2140d.mActivity, 294);
            a.putExtra("album", mo2051c());
            a.putExtra("com.domobile.elock.EXTRA_TYPE", this.f2140d.f2145f);
            this.f2140d.mActivity.startActivity(a);
        }

        public void m2419a(HidedPictureItem hidedPictureItem) {
            this.f2141e.add(hidedPictureItem);
        }

        public int mo2049b() {
            return this.f2141e.size();
        }

        public int mo2050b(int i) {
            return ((HidedPictureItem) this.f2141e.get(i)).getRotation();
        }

        public String mo2051c() {
            return this.f2138b;
        }

        public void mo2052c(int i) {
            this.f2139c = i;
        }

        public int mo2053d() {
            return this.f2139c;
        }

        public boolean mo2054e() {
            return ((HidedPictureItem) this.f2141e.get(0)).m289g();
        }
    }

    private void m2428a(final C1118a c1118a) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ C1119v f2134b;

            public void run() {
                c1118a.f2137a = true;
                if (c1118a != null) {
                    int indexOf = this.f2134b.f2144e.m871a().indexOf(c1118a);
                    if (indexOf == -1) {
                        if (c1118a.f2139c > 0) {
                            this.f2134b.f2144e.m871a().add(c1118a);
                            this.f2134b.f2144e.notifyItemInserted(this.f2134b.f2144e.getItemCount() - 1);
                        }
                    } else if (c1118a.f2139c <= 0) {
                        this.f2134b.f2144e.m871a().remove(indexOf);
                        this.f2134b.f2144e.notifyItemRemoved(indexOf);
                    } else {
                        this.f2134b.f2144e.notifyItemChanged(indexOf);
                    }
                    this.f2134b.m2444g();
                }
            }
        });
    }

    private void m2431a(final String str, final boolean z) {
        new Thread(this) {
            final /* synthetic */ C1119v f2132c;

            public void run() {
                synchronized (this.f2132c.f2144e) {
                    this.f2132c.m2436b(str, z);
                }
            }
        }.start();
    }

    private void m2432a(final ArrayList<C0397c> arrayList) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ C1119v f2136b;

            public void run() {
                this.f2136b.f2144e.m874a(arrayList);
                this.f2136b.m2444g();
                this.f2136b.hideLoadingDialog_mt();
            }
        });
    }

    private void m2436b(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        Cursor a = C0487k.m401a(this.f2147h, str);
        if (a != null) {
            if (!(a.getCount() != 0 || this.f2144e == null || TextUtils.isEmpty(str))) {
                Iterator it = this.f2144e.m871a().iterator();
                while (it.hasNext()) {
                    C0397c c0397c = (C0397c) it.next();
                    if (TextUtils.equals(c0397c.mo2051c(), str)) {
                        c0397c.mo2052c(0);
                        m2428a((C1118a) c0397c);
                        a.close();
                        return;
                    }
                }
            }
            while (a.moveToNext() && !isDetached()) {
                String string = a.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    int a2 = C0487k.m397a(string, this.f2147h);
                    Cursor a3 = C0487k.m400a(string, this.f2147h, 3);
                    if (a3 != null) {
                        C1118a c1118a = new C1118a(this, this.mActivity, string, a2);
                        while (a3.moveToNext()) {
                            c1118a.m2419a(new HidedPictureItem(HidedPictureItem.m264a(a3), this.mActivity, a3));
                        }
                        if (this.f2144e == null || TextUtils.isEmpty(str)) {
                            arrayList.add(c1118a);
                        } else {
                            C1118a c1118a2;
                            Iterator it2 = this.f2144e.m871a().iterator();
                            while (it2.hasNext()) {
                                Object obj = (C0397c) it2.next();
                                if (TextUtils.equals(obj.mo2051c(), str)) {
                                    boolean z2 = z || (obj.mo2049b() < 3 && a2 > obj.mo2053d());
                                    if (z2) {
                                        C1257b.m2966a(this.mActivity).m2983a(obj);
                                        ((C1118a) obj).f2137a = true;
                                    }
                                    ((C1118a) obj).m2416a(c1118a, z2);
                                    c1118a2 = (C1118a) obj;
                                    if (c1118a2 == null) {
                                        c1118a2 = c1118a;
                                    }
                                    m2428a(c1118a2);
                                }
                            }
                            c1118a2 = null;
                            if (c1118a2 == null) {
                                c1118a2 = c1118a;
                            }
                            m2428a(c1118a2);
                        }
                        a3.close();
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                m2432a(arrayList);
            }
            a.close();
        }
    }

    private void m2439e() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.notice).m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3123d((int) R.string.this_function_need_storage);
        c1288c.m3114b(17039370, new C11124(this)).m3122d();
    }

    private void m2441f() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.notice);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3123d((int) R.string.find_out_untracked_medias);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b(17039370, new C11146(this)).m3117b(true).m3122d();
    }

    private void m2444g() {
        if (this.f2144e.getItemCount() == 0) {
            findViewById(16908292).setVisibility(0);
        } else {
            findViewById(16908292).setVisibility(8);
        }
    }

    public boolean mo2400b() {
        return false;
    }

    public void m2447c() {
        this.b.m80e();
        Intent a = AgentActivity.m570a(this.mActivity, 292);
        if (this.f2145f == 1) {
            a.putExtra("com.domobile.elock.EXTRA_TYPE", 4);
        }
        startActivity(a);
    }

    public void m2448d() {
        int i = 3;
        Iterator it = this.f2144e.m871a().iterator();
        while (it.hasNext()) {
            Object obj = (C0397c) it.next();
            if (TextUtils.equals(obj.mo2051c(), this.f2148i)) {
                if (TextUtils.isEmpty(this.f2149j)) {
                    Cursor a = C0487k.m400a(obj.mo2051c(), this.f2147h, 3);
                    if (a != null) {
                        ((C1118a) obj).f2141e.clear();
                        while (a.moveToNext()) {
                            ((C1118a) obj).m2419a(new HidedPictureItem(HidedPictureItem.m264a(a), this.mActivity, a));
                        }
                        a.close();
                    }
                } else {
                    ((C1118a) obj).f2141e.clear();
                    String[] split = this.f2149j.split(",");
                    int i2 = 0;
                    while (i2 < split.length && i2 < i) {
                        int i3;
                        if (TextUtils.isEmpty(split[i2])) {
                            i3 = i + 1;
                        } else {
                            Cursor a2 = C0487k.m399a(split[i2]);
                            if (a2 == null) {
                                i3 = i;
                            } else {
                                if (a2.moveToFirst()) {
                                    ((C1118a) obj).m2419a(new HidedPictureItem(HidedPictureItem.m264a(a2), this.mActivity, a2));
                                }
                                a2.close();
                                i3 = i;
                            }
                        }
                        i2++;
                        i = i3;
                    }
                }
                C1257b.m2966a(this.mActivity).m2983a(obj);
                m2428a((C1118a) obj);
                this.f2148i = null;
                this.f2149j = null;
            }
        }
        this.f2148i = null;
        this.f2149j = null;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActionBar.m3008c(false);
        this.rootView = layoutInflater.inflate(R.layout.gallerypicker, null);
        this.f2144e = new C0670a(this.mActivity, null);
        this.f2143a = (OverscrollRecyclerView) findViewById(R.id.albums);
        this.f2143a.setLayoutManager(new GridLayoutManager(this.mActivity, C0670a.m867a(this.mActivity)));
        this.f2143a.setAdapter(this.f2144e);
        m2431a(null, true);
        this.f2143a.getViewTreeObserver().addOnGlobalLayoutListener(new C11135(this));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.gallerypicker_add) {
            m2447c();
        } else {
            super.onClick(view);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0420b.m169a(this.f2143a, C0670a.m867a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f2145f = arguments.getInt("com.domobile.elock.EXTRA_TYPE", 0);
        }
        if (this.f2145f != 1) {
            z = false;
        }
        this.f2147h = z;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
        intentFilter.addAction("com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED");
        intentFilter.addAction("com.domobile.elock.action.ACTION_RELOAD_ALBUM_IMAGE");
        intentFilter.addAction("com.domobile.elock.action.ACTION_SCAN_UNTRACKED_IMAGES_COMPLETE");
        this.mActivity.registerReceiver(this.f2151l, intentFilter);
        C1150y.m2605b(this.mActivity, (int) R.string.event_picture_hider_albums);
    }

    public void onDestroy() {
        C1148d.m2509a(this.mActivity, this.f2151l);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.f2150k = false;
        this.mActionBar.m3011e().setOnLongClickListener(null);
    }

    public void onResume() {
        super.onResume();
        this.f2150k = true;
        if (!C1147a.m2484c()) {
            this.mActionBar.m3000a(new C11061(this));
        }
        if (!TextUtils.isEmpty(this.f2148i)) {
            new C11113(this).start();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                callDelayed(65537, 2000);
                break;
            case 1:
            case 3:
                this.mHandler.removeMessages(65537);
                break;
        }
        return false;
    }

    public void ui(int i, Message message) {
        switch (i) {
            case 65537:
                m2441f();
                return;
            case 65538:
                if (C0411e.m157a() == null) {
                    C1288c c1288c = new C1288c(this.mActivity);
                    c1288c.m3123d((int) R.string.vault_database_damaged_warning);
                    c1288c.m3102a(17039360, null);
                    c1288c.m3114b(17039370, new OnClickListener(this) {
                        final /* synthetic */ C1119v f2118a;

                        {
                            this.f2118a = r1;
                        }

                        public void onClick(View view) {
                            this.f2118a.callDelayed(65537, 150);
                        }
                    }).m3117b(false).m3122d();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
