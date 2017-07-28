package com.domobile.applock.chamber.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.p008a.C0762a;
import com.domobile.applock.chamber.p008a.C0762a.C0759a;
import com.domobile.applock.chamber.p008a.C0762a.C0760b;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p010b.C0778a;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1279a;
import com.domobile.widget.recyclerview.C1412b;
import java.util.ArrayList;
import java.util.Collections;

public class C0837b extends C0400d implements OnMenuItemClickListener, C0759a, C0760b {
    Callback f1155a = new SimpleCallback(this, 3, 0) {
        final /* synthetic */ C0837b f1140a;

        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        public boolean isLongPressDragEnabled() {
            return this.f1140a.f1156e.getItemCount() > 1;
        }

        public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = viewHolder2.getAdapterPosition();
            C0778a.m1182a(this.f1140a.f1156e.m1121b(adapterPosition), this.f1140a.f1156e.m1121b(adapterPosition2));
            Collections.swap(this.f1140a.f1156e.m1126f(), adapterPosition, adapterPosition2);
            this.f1140a.f1156e.notifyItemMoved(adapterPosition, adapterPosition2);
            return true;
        }

        public void onSwiped(ViewHolder viewHolder, int i) {
        }
    };
    private C0762a f1156e;
    private C0836a f1157f;
    private Drawable f1158g;
    private FrameLayout f1159h;

    private class C0836a implements OnClickListener, OnKeyListener {
        final /* synthetic */ C0837b f1143a;
        private WindowManager f1144b;
        private LayoutParams f1145c;
        private View f1146d;
        private ViewGroup f1147e;
        private MarginLayoutParams f1148f;
        private View f1149g;
        private View f1150h;
        private Animation f1151i;
        private Animation f1152j;
        private boolean f1153k;
        private BookmarkInfo f1154l;

        class C08341 implements Runnable {
            final /* synthetic */ C0836a f1141a;

            C08341(C0836a c0836a) {
                this.f1141a = c0836a;
            }

            public void run() {
                if (this.f1141a.f1152j == null) {
                    this.f1141a.f1152j = AnimationUtils.loadAnimation(this.f1141a.f1143a.mActivity, R.anim.custom_dialog_appear);
                }
                this.f1141a.f1147e.setVisibility(0);
                this.f1141a.f1147e.startAnimation(this.f1141a.f1152j);
            }
        }

        class C08352 extends C0415f {
            final /* synthetic */ C0836a f1142a;

            C08352(C0836a c0836a) {
                this.f1142a = c0836a;
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f1142a.f1146d.getParent() != null) {
                    this.f1142a.f1144b.removeView(this.f1142a.f1146d);
                }
                this.f1142a.f1147e.clearAnimation();
                this.f1142a.f1153k = false;
            }
        }

        public C0836a(C0837b c0837b, Context context) {
            this.f1143a = c0837b;
            this.f1144b = (WindowManager) context.getSystemService("window");
            this.f1145c = new LayoutParams();
            this.f1145c.type = 1000;
            this.f1145c.format = 1;
            this.f1145c.flags = 32;
            this.f1145c.format = -3;
            this.f1145c.height = -1;
            this.f1145c.width = -1;
            this.f1145c.gravity = 17;
            this.f1146d = LayoutInflater.from(context).inflate(R.layout.layout_bookmark_item_more, null);
            this.f1147e = (ViewGroup) this.f1146d.findViewById(R.id.cardView);
            this.f1148f = (MarginLayoutParams) this.f1147e.getLayoutParams();
            this.f1149g = this.f1146d.findViewById(R.id.txvEdit);
            this.f1149g.setOnClickListener(this);
            this.f1150h = this.f1146d.findViewById(R.id.txvDelete);
            this.f1150h.setOnClickListener(this);
            this.f1146d.setOnClickListener(this);
            this.f1146d.setFocusableInTouchMode(true);
            this.f1146d.setFocusable(true);
            this.f1146d.requestFocus();
            this.f1146d.setOnKeyListener(this);
        }

        private int m1373b() {
            int i = 0;
            ViewGroup viewGroup = (ViewGroup) this.f1146d.findViewById(R.id.vgItemLayer);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    i += childAt.getLayoutParams().height;
                }
            }
            return i;
        }

        public C0836a m1377a(View view, BookmarkInfo bookmarkInfo) {
            this.f1154l = bookmarkInfo;
            int[] iArr = new int[]{0, 0};
            view.getLocationInWindow(iArr);
            int i = C1148d.m2500a(this.f1144b).y;
            this.f1149g.setVisibility(0);
            this.f1150h.setVisibility(0);
            if (((double) iArr[1]) > ((double) i) * 0.6d) {
                this.f1148f.topMargin = (iArr[1] + view.getHeight()) - m1373b();
                this.f1147e.setLayoutParams(this.f1148f);
            } else {
                this.f1148f.topMargin = iArr[1];
                this.f1147e.setLayoutParams(this.f1148f);
            }
            this.f1147e.setVisibility(4);
            if (this.f1146d.getParent() == null) {
                this.f1144b.addView(this.f1146d, this.f1145c);
            }
            this.f1147e.postDelayed(new C08341(this), 20);
            return this;
        }

        public void m1378a() {
            this.f1153k = true;
            if (this.f1151i == null) {
                this.f1151i = AnimationUtils.loadAnimation(this.f1143a.mActivity, R.anim.custom_dialog_disappear);
                this.f1151i.setAnimationListener(new C08352(this));
            }
            this.f1147e.startAnimation(this.f1151i);
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.txvEdit:
                    this.f1143a.b.m80e();
                    BrowserHostActivity.m1308a(this.f1143a.mActivity, this.f1154l);
                    break;
                case R.id.txvDelete:
                    C0778a.m1187b(this.f1154l.f1281a);
                    this.f1143a.f1156e.m1118a(this.f1154l);
                    this.f1143a.m1385e();
                    break;
            }
            if (!this.f1153k) {
                m1378a();
            }
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 4 || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            m1378a();
            return true;
        }
    }

    private int m1380b(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private void m1381b() {
        this.f1159h = (FrameLayout) findViewById(R.id.contentView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvBookmarkList);
        LayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemDecoration c1412b = new C1412b(this.mActivity);
        c1412b.m3583a((m1380b((int) R.dimen.PaddingSizeLarge) * 2) + m1380b((int) R.dimen.icon_size_sdo));
        recyclerView.addItemDecoration(c1412b);
        this.f1156e = new C0762a();
        this.f1156e.m1116a((C0759a) this);
        this.f1156e.m1117a((C0760b) this);
        recyclerView.setAdapter(this.f1156e);
        new ItemTouchHelper(this.f1155a).attachToRecyclerView(recyclerView);
    }

    private void m1383c() {
        Object c1279a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.bookmark_list_bottom_menus, c1279a);
        this.mActionBar.m3005b(c1279a, 0, this);
        this.mActionBar.m3008c(false);
    }

    private void m1384d() {
        this.f1156e.m1119a(C0778a.m1185b());
        m1385e();
    }

    private void m1385e() {
        if (this.f1156e.getItemCount() == 0) {
            this.f1156e.m1120a(false);
            findViewById(R.id.imvEmptyView).setVisibility(0);
        } else {
            findViewById(R.id.imvEmptyView).setVisibility(8);
        }
        this.b.invalidateOptionsMenu();
    }

    public void mo2428a(int i) {
        BookmarkInfo b = this.f1156e.m1121b(i);
        Intent intent = new Intent();
        intent.putExtra("EXTRA_URL", b.f1282b);
        this.b.setResult(-1, intent);
        this.b.mo2042a();
    }

    public void mo2429a(View view, int i) {
        BookmarkInfo b = this.f1156e.m1121b(i);
        if (this.f1157f == null) {
            this.f1157f = new C0836a(this, this.mActivity);
        }
        this.f1157f.m1377a(view, b);
    }

    public void a_() {
        if (this.f1156e.m1124d()) {
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_checked);
        } else {
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_uncheck);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_bookmark_list, null);
        m1381b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.bookmark_list_title);
        this.f1158g = this.b.m66r().getNavigationIcon();
        m1383c();
        C1150y.m2605b(this.mActivity, (int) R.string.event_bookmark_list);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.bookmark_list_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f1156e.m1123c()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f1156e.m1120a(false);
        this.b.invalidateOptionsMenu();
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_delete) {
            return false;
        }
        ArrayList e = this.f1156e.m1125e();
        if (e.size() <= 0) {
            return true;
        }
        if (this.f1156e.m1124d()) {
            C0778a.m1180a();
            C0793b.m1232c(this.mActivity);
        } else {
            C0778a.m1183a(e);
            C0793b.m1224a(this.mActivity, e);
        }
        e.clear();
        m1384d();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_edit) {
            this.f1156e.m1122b();
            this.b.invalidateOptionsMenu();
            return true;
        } else if (!this.f1156e.m1123c()) {
            return false;
        } else {
            this.f1156e.m1114a();
            return true;
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_action_edit);
        if (this.f1156e.getItemCount() == 0) {
            findItem.setEnabled(false);
            findItem.setIcon(R.drawable.toolbar_edit);
            findItem.getIcon().setAlpha(85);
            this.mActionBar.m3008c(false);
            this.f1159h.setPadding(0, 0, 0, 0);
            this.b.m66r().setNavigationIcon(this.f1158g);
            return;
        }
        findItem.setEnabled(true);
        if (this.f1156e.m1123c()) {
            this.mActionBar.m3008c(true);
            this.f1159h.setPadding(0, 0, 0, m1380b((int) R.dimen.actionbar_footerview_height));
            findItem.setIcon(R.drawable.toolbar_ok);
            findItem.setTitle(R.string.save);
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_uncheck);
            return;
        }
        this.mActionBar.m3008c(false);
        this.f1159h.setPadding(0, 0, 0, 0);
        findItem.setIcon(R.drawable.toolbar_edit);
        findItem.getIcon().setAlpha(255);
        findItem.setTitle(R.string.edit);
        this.b.m66r().setNavigationIcon(this.f1158g);
    }

    public void onResume() {
        super.onResume();
        m1384d();
    }
}
