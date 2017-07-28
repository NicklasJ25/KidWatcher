package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.domobile.applock.adapter.C0688g;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.C1358a;
import com.domobile.lockbean.C1359b;
import com.domobile.lockbean.Location;
import com.domobile.lockbean.Scene;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ae extends C0704e implements Callback, OnItemClickListener, OnItemLongClickListener {
    HashMap<Long, String> f808a = new HashMap();
    private boolean f809e = true;
    private boolean f810f = true;
    private RecyclerView f811g;
    private C0688g f812h;
    private C0703a f813i;
    private ActionMode f814j;
    private Resources f815k;
    private Runnable f816l = new C06922(this);
    private Runnable f817m = new C06933(this);
    private BroadcastReceiver f818n = new C06944(this);

    class C06901 implements OnClickListener {
        final /* synthetic */ ae f777a;

        C06901(ae aeVar) {
            this.f777a = aeVar;
        }

        public void onClick(View view) {
            if (this.f777a.f813i == null) {
                this.f777a.f813i = new C0703a(this.f777a, this.f777a.mActivity);
            }
            this.f777a.f813i.m911a(view, (Scene) view.getTag());
        }
    }

    class C06922 implements Runnable {
        final /* synthetic */ ae f780a;

        C06922(ae aeVar) {
            this.f780a = aeVar;
        }

        public void run() {
            final ArrayList a = Scene.m3389a(this.f780a.mActivity, false);
            this.f780a.mHandler.post(new Runnable(this) {
                final /* synthetic */ C06922 f779b;

                public void run() {
                    this.f779b.f780a.f812h.m899a(a);
                    this.f779b.f780a.mActivity.invalidateOptionsMenu();
                    this.f779b.f780a.f812h.notifyDataSetChanged();
                }
            });
        }
    }

    class C06933 implements Runnable {
        final /* synthetic */ ae f781a;

        C06933(ae aeVar) {
            this.f781a = aeVar;
        }

        public void run() {
            this.f781a.m927d();
            this.f781a.call(256);
        }
    }

    class C06944 extends BroadcastReceiver {
        final /* synthetic */ ae f782a;

        C06944(ae aeVar) {
            this.f782a = aeVar;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.domobile.elock.action.ACTION_NEW_SCENE_ADDED".equals(action)) {
                this.f782a.f809e = true;
            } else if ("com.domobile.applock.ACTION_ALARM_LOCATION_EDITED".equals(action)) {
                this.f782a.f810f = true;
            }
        }
    }

    private class C0703a implements OnClickListener, OnKeyListener {
        final /* synthetic */ ae f795a;
        private WindowManager f796b;
        private LayoutParams f797c;
        private View f798d;
        private ViewGroup f799e = ((ViewGroup) this.f798d.findViewById(R.id.scenes_item_more_card));
        private MarginLayoutParams f800f = ((MarginLayoutParams) this.f799e.getLayoutParams());
        private View f801g = this.f798d.findViewById(R.id.scenes_item_delete);
        private View f802h;
        private View f803i;
        private Animation f804j;
        private Animation f805k;
        private Scene f806l;
        private boolean f807m;

        class C07011 implements Runnable {
            final /* synthetic */ C0703a f793a;

            C07011(C0703a c0703a) {
                this.f793a = c0703a;
            }

            public void run() {
                if (this.f793a.f805k == null) {
                    this.f793a.f805k = AnimationUtils.loadAnimation(this.f793a.f795a.mActivity, R.anim.custom_dialog_appear);
                }
                this.f793a.f799e.setVisibility(0);
                this.f793a.f799e.startAnimation(this.f793a.f805k);
            }
        }

        class C07022 extends C0415f {
            final /* synthetic */ C0703a f794a;

            C07022(C0703a c0703a) {
                this.f794a = c0703a;
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f794a.f798d.getParent() != null) {
                    this.f794a.f796b.removeView(this.f794a.f798d);
                }
                this.f794a.f799e.clearAnimation();
                this.f794a.f807m = false;
            }
        }

        public C0703a(ae aeVar, Context context) {
            this.f795a = aeVar;
            this.f798d = LayoutInflater.from(context).inflate(R.layout.scenes_item_more, null);
            this.f801g.setOnClickListener(this);
            this.f803i = this.f798d.findViewById(R.id.scenes_item_shotcut);
            this.f803i.setOnClickListener(this);
            this.f802h = this.f798d.findViewById(R.id.scenes_item_edit);
            this.f802h.setOnClickListener(this);
            this.f798d.setOnClickListener(this);
            this.f798d.setFocusableInTouchMode(true);
            this.f798d.setFocusable(true);
            this.f798d.requestFocus();
            this.f798d.setOnKeyListener(this);
            this.f796b = (WindowManager) context.getSystemService("window");
            this.f797c = new LayoutParams();
            this.f797c.type = 1000;
            this.f797c.format = 1;
            this.f797c.flags = 32;
            this.f797c.format = -3;
            this.f797c.height = -1;
            this.f797c.width = -1;
            this.f797c.gravity = 17;
        }

        private int m907b() {
            int i = 0;
            ViewGroup viewGroup = (ViewGroup) this.f798d.findViewById(R.id.scenes_item_more_menus);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    i += childAt.getLayoutParams().height;
                }
            }
            return i;
        }

        public C0703a m911a(View view, Scene scene) {
            this.f806l = scene;
            int[] iArr = new int[]{0, 0};
            view.getLocationInWindow(iArr);
            int i = C1148d.m2500a(this.f796b).y;
            this.f802h.setVisibility(0);
            this.f801g.setVisibility(0);
            switch ((int) scene.f2922a) {
                case -2:
                    break;
                case -1:
                    this.f802h.setVisibility(8);
                    break;
            }
            this.f801g.setVisibility(8);
            if (((double) iArr[1]) > ((double) i) * 0.6d) {
                this.f800f.topMargin = (iArr[1] + view.getHeight()) - m907b();
                this.f799e.setLayoutParams(this.f800f);
            } else {
                this.f800f.topMargin = iArr[1];
                this.f799e.setLayoutParams(this.f800f);
            }
            this.f799e.setVisibility(4);
            if (this.f798d.getParent() == null) {
                this.f796b.addView(this.f798d, this.f797c);
            }
            this.f799e.postDelayed(new C07011(this), 20);
            return this;
        }

        public void m912a() {
            this.f807m = true;
            if (this.f804j == null) {
                this.f804j = AnimationUtils.loadAnimation(this.f795a.mActivity, R.anim.custom_dialog_disappear);
                this.f804j.setAnimationListener(new C07022(this));
            }
            this.f799e.startAnimation(this.f804j);
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.scenes_item_edit:
                    this.f795a.m921b(this.f806l);
                    break;
                case R.id.scenes_item_shotcut:
                    this.f795a.m931a(this.f806l);
                    break;
                case R.id.scenes_item_delete:
                    this.f795a.m930e(this.f806l);
                    break;
            }
            if (!this.f807m) {
                m912a();
            }
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 4 || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            m912a();
            return true;
        }
    }

    public static void m916a(Handler handler, final Context context, final String str) {
        handler.post(new Runnable() {
            public void run() {
                C1147a.m2487w(context, str);
            }
        });
    }

    private void m921b(Scene scene) {
        if (scene == null || scene.f2922a != -1) {
            this.b.m80e();
            Intent intent = new Intent(this.mActivity, ScenesEditorActivity.class);
            if (scene != null) {
                intent.putExtra("com.domobile.elock.EXTRA_SCENE_ID", scene.f2922a);
                intent.putExtra("com.domobile.elock.EXTRA_SCENE_NAME", scene.f2923b);
            }
            startActivityForResult(intent, 1000);
            return;
        }
        C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.profile_cannot_edit, new Object[]{scene.f2923b}));
    }

    private void m925c(final Scene scene) {
        if (a_(0) == null && !MainTabFragmentActivity.m628a(this.b)) {
            C1288c c1288c = new C1288c(this.mActivity);
            c1288c.mo2528a(getString(R.string.are_you_sure_startup_scenes, scene.f2923b));
            c1288c.m3102a(17039360, null);
            c1288c.m3114b(17039370, new OnClickListener(this) {
                final /* synthetic */ ae f785b;

                class C06951 extends Thread {
                    final /* synthetic */ C06965 f783a;

                    C06951(C06965 c06965) {
                        this.f783a = c06965;
                    }

                    public void run() {
                        this.f783a.f785b.m928d(scene);
                    }
                }

                public void onClick(View view) {
                    new C06951(this).start();
                }
            }).m3117b(true).m3122d();
        }
    }

    private void m927d() {
        Scene a;
        this.f808a.clear();
        Cursor a2 = Location.m3379a();
        if (a2 != null) {
            while (a2.moveToNext()) {
                a = C1359b.m3412a(a2.getString(4));
                if (a != null) {
                    this.f808a.put(Long.valueOf(a.f2922a), a.f2923b);
                }
                a = C1359b.m3412a(a2.getString(5));
                if (a != null) {
                    this.f808a.put(Long.valueOf(a.f2922a), a.f2923b);
                }
            }
            a2.close();
        }
        a2 = C1358a.m3398a();
        if (a2 != null) {
            while (a2.moveToNext()) {
                a = C1359b.m3412a(a2.getString(7));
                if (a != null) {
                    this.f808a.put(Long.valueOf(a.f2922a), a.f2923b);
                }
            }
            a2.close();
        }
    }

    private void m928d(Scene scene) {
        showCancelableLoadingDialog();
        if (C1017n.m2041c(scene.f2922a)) {
            m916a(this.mHandler, this.mActivity, this.mActivity.getString(R.string.startup_success, new Object[]{scene.f2923b}));
            C1148d.m2489A(this.mActivity, "com.domobile.elock.proctect_list_change");
            this.b.mo2042a();
        } else {
            m916a(this.mHandler, this.mActivity, this.mActivity.getString(R.string.startup_failed, new Object[]{scene.f2923b}));
        }
        hideLoadingDialog();
    }

    private void m929e() {
        this.f812h.mo2399j();
        this.f814j.setTitle(C1147a.m2480a("(", Integer.valueOf(this.f812h.m895a().size()), ")"));
    }

    private void m930e(final Scene scene) {
        if (this.f812h.m895a().isEmpty() && scene == null) {
            C1147a.m2485d(this.mActivity, R.string.select_one_limit);
            return;
        }
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3109a(scene == null ? this.mActivity.getString(R.string.delete) : scene.f2923b);
        c1288c.mo2528a(getString(R.string.are_you_sure_delete, ""));
        c1288c.m3102a(17039360, null);
        c1288c.m3114b(17039370, new OnClickListener(this) {
            final /* synthetic */ ae f790b;

            public void onClick(View view) {
                if (scene != null) {
                    this.f790b.f812h.m895a().add(scene);
                }
                Iterator it = this.f790b.f812h.m895a().iterator();
                while (it.hasNext()) {
                    Scene scene = (Scene) it.next();
                    if (scene.f2922a > -1 && !this.f790b.f808a.containsKey(Long.valueOf(scene.f2922a)) && Scene.deleteScene(scene.f2922a) > 0) {
                        C1017n.m2031a(scene.f2922a);
                        int indexOf = this.f790b.f812h.m901b().indexOf(scene);
                        this.f790b.f812h.m901b().remove(scene);
                        this.f790b.f812h.notifyItemRemoved(indexOf);
                    }
                }
                this.f790b.f812h.m900a(false, null);
                if (this.f790b.f814j != null) {
                    this.f790b.f814j.finish();
                }
                this.f790b.mActivity.invalidateOptionsMenu();
            }
        }).m3117b(true).m3122d();
    }

    public void m931a(final Scene scene) {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3123d((int) R.string.send_profile_shortcut_msg);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b(17039370, new OnClickListener(this) {
            final /* synthetic */ ae f788b;

            class C06971 extends Thread {
                final /* synthetic */ C06986 f786a;

                C06971(C06986 c06986) {
                    this.f786a = c06986;
                }

                public void run() {
                    scene.m3393b(this.f786a.f788b.mActivity);
                }
            }

            public void onClick(View view) {
                new C06971(this).start();
            }
        }).m3109a(scene.f2923b).m3117b(true).m3122d();
    }

    public boolean mo2400b() {
        return true;
    }

    public boolean m933c() {
        if (!this.f812h.m902c()) {
            return false;
        }
        this.f814j.finish();
        return true;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.scenes_activity, null);
        findViewById(R.id.scenes_add).setOnClickListener(this);
        this.f811g = (RecyclerView) findViewById(R.id.scenes_list);
        this.f811g.setLayoutManager(new NpaLinearLayoutManager(this.mActivity));
        this.f812h = new C0688g(this.mActivity, null);
        this.f812h.m896a(new C06901(this));
        this.f811g.setAdapter(this.f812h);
        this.f812h.m897a((OnItemClickListener) this);
        this.f812h.m898a((OnItemLongClickListener) this);
        this.f811g.setClipToPadding(false);
        this.f811g.setPadding(0, 0, 0, this.f815k.getDimensionPixelSize(R.dimen.fab_icon_size) * 2);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_delete) {
            m930e(null);
        } else {
            this.f812h.m900a(false, null);
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            this.f809e = true;
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.scenes_add) {
            m921b(null);
        } else {
            super.onClick(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.scenes_mode);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.elock.action.ACTION_NEW_SCENE_ADDED");
        intentFilter.addAction("com.domobile.applock.ACTION_ALARM_LOCATION_EDITED");
        this.mActivity.registerReceiver(this.f818n, intentFilter);
        this.f815k = this.mActivity.getResources();
        C1150y.m2605b(this.mActivity, (int) R.string.event_scenes);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(R.menu.scenes_menus, menu);
        return true;
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        if (this.f812h.m901b().size() > 2) {
            menuInflater.inflate(R.menu.picture_hider_images_actionbar_menus, menu);
        }
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        C1148d.m2509a(this.mActivity, this.f818n);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f812h.m900a(false, null);
        m929e();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Scene scene = (Scene) this.f812h.m901b().get(i);
        if (!this.f812h.m902c()) {
            m925c(scene);
        } else if (scene.f2922a == -1 || scene.f2922a == -2) {
            C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.profile_cannot_edit, new Object[]{scene.f2923b}));
        } else {
            if (this.f812h.m895a().contains(scene)) {
                this.f812h.m895a().remove(scene);
            } else {
                this.f812h.m895a().add(scene);
            }
            m929e();
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Scene scene = (Scene) this.f812h.m901b().get(i);
        if (!(!this.f812h.m895a().isEmpty() || scene.f2922a == -1 || scene.f2922a == -2)) {
            this.f814j = this.mActivity.startSupportActionMode(this);
            this.f812h.m900a(true, scene);
            m929e();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_actionbar_edit && this.f812h.m901b().size() > 2) {
            this.f814j = this.mActivity.startSupportActionMode(this);
            this.f812h.m900a(true, null);
            m929e();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        MenuItem findItem = menu.findItem(R.id.menu_delete);
        Drawable mutate = C1148d.m2502a(this.mActivity.getResources(), (int) R.drawable.toolbar_trash).mutate();
        mutate.setColorFilter(-1, Mode.SRC_ATOP);
        findItem.setVisible(true);
        findItem.setIcon(mutate);
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_actionbar_edit);
        if (findItem != null) {
            findItem.getIcon().setAlpha(255);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f814j != null) {
            this.f814j.finish();
        }
        if (!(this.f809e || this.f810f || this.f812h == null)) {
            this.f812h.notifyDataSetChanged();
        }
        if (this.f810f) {
            this.f810f = false;
            new Thread(this.f817m).start();
        }
        if (this.f809e) {
            this.f809e = false;
            new Thread(this.f816l).start();
        }
    }

    public void ui(int i, Message message) {
        if (i == 256) {
            this.f812h.notifyDataSetChanged();
        }
    }
}
