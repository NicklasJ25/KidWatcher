package com.domobile.applock.chamber.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
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
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p008a.C0770c;
import com.domobile.applock.chamber.p008a.C0770c.C0766a;
import com.domobile.applock.chamber.p008a.C0770c.C0767b;
import com.domobile.applock.chamber.p009c.C0793b;
import com.domobile.applock.chamber.p009c.C0795c;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1279a;
import com.domobile.frame.ui.C1288c;
import com.domobile.widget.recyclerview.C1412b;
import java.io.File;
import java.util.ArrayList;

public class C0851e extends C0400d implements OnMenuItemClickListener, C0766a, C0767b {
    private C0770c f1199a;
    private Drawable f1200e;
    private FrameLayout f1201f;
    private C0850a f1202g;

    private class C0850a implements OnClickListener, OnKeyListener {
        final /* synthetic */ C0851e f1185a;
        private WindowManager f1186b;
        private LayoutParams f1187c;
        private View f1188d;
        private ViewGroup f1189e;
        private MarginLayoutParams f1190f;
        private View f1191g;
        private View f1192h;
        private View f1193i;
        private View f1194j;
        private Animation f1195k;
        private Animation f1196l;
        private boolean f1197m;
        private FileInfo f1198n;

        class C08481 implements Runnable {
            final /* synthetic */ C0850a f1183a;

            C08481(C0850a c0850a) {
                this.f1183a = c0850a;
            }

            public void run() {
                if (this.f1183a.f1196l == null) {
                    this.f1183a.f1196l = AnimationUtils.loadAnimation(this.f1183a.f1185a.mActivity, R.anim.custom_dialog_appear);
                }
                this.f1183a.f1189e.setVisibility(0);
                this.f1183a.f1189e.startAnimation(this.f1183a.f1196l);
            }
        }

        class C08492 extends C0415f {
            final /* synthetic */ C0850a f1184a;

            C08492(C0850a c0850a) {
                this.f1184a = c0850a;
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f1184a.f1188d.getParent() != null) {
                    this.f1184a.f1186b.removeView(this.f1184a.f1188d);
                }
                this.f1184a.f1189e.clearAnimation();
                this.f1184a.f1197m = false;
            }
        }

        public C0850a(C0851e c0851e, Context context) {
            this.f1185a = c0851e;
            this.f1186b = (WindowManager) context.getSystemService("window");
            this.f1187c = new LayoutParams();
            this.f1187c.type = 1000;
            this.f1187c.format = 1;
            this.f1187c.flags = 32;
            this.f1187c.format = -3;
            this.f1187c.height = -1;
            this.f1187c.width = -1;
            this.f1187c.gravity = 17;
            this.f1188d = LayoutInflater.from(context).inflate(R.layout.layout_download_item_more, null);
            this.f1189e = (ViewGroup) this.f1188d.findViewById(R.id.cardView);
            this.f1190f = (MarginLayoutParams) this.f1189e.getLayoutParams();
            this.f1191g = this.f1188d.findViewById(R.id.txvDelete);
            this.f1191g.setOnClickListener(this);
            this.f1192h = this.f1188d.findViewById(R.id.txvCancel);
            this.f1192h.setOnClickListener(this);
            this.f1193i = this.f1188d.findViewById(R.id.txvRestart);
            this.f1193i.setOnClickListener(this);
            this.f1194j = this.f1188d.findViewById(R.id.txvSave);
            this.f1194j.setOnClickListener(this);
            this.f1188d.setOnClickListener(this);
            this.f1188d.setFocusableInTouchMode(true);
            this.f1188d.setFocusable(true);
            this.f1188d.requestFocus();
            this.f1188d.setOnKeyListener(this);
        }

        private int m1417b() {
            int i = 0;
            ViewGroup viewGroup = (ViewGroup) this.f1188d.findViewById(R.id.vgItemLayer);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    i += childAt.getLayoutParams().height;
                }
            }
            return i;
        }

        public C0850a m1421a(View view, FileInfo fileInfo) {
            this.f1198n = fileInfo;
            int[] iArr = new int[]{0, 0};
            view.getLocationInWindow(iArr);
            int i = C1148d.m2500a(this.f1186b).y;
            if (fileInfo.f1293g == 1) {
                this.f1192h.setVisibility(0);
                this.f1193i.setVisibility(8);
                this.f1194j.setVisibility(8);
            } else if (fileInfo.f1293g == 3 || fileInfo.f1293g == 4) {
                this.f1192h.setVisibility(8);
                this.f1193i.setVisibility(0);
                this.f1194j.setVisibility(8);
            } else if (fileInfo.f1293g == 2) {
                this.f1192h.setVisibility(8);
                this.f1193i.setVisibility(8);
                this.f1194j.setVisibility(0);
            } else {
                this.f1192h.setVisibility(8);
                this.f1193i.setVisibility(8);
                this.f1194j.setVisibility(8);
            }
            this.f1191g.setVisibility(0);
            if (((double) iArr[1]) > ((double) i) * 0.6d) {
                this.f1190f.topMargin = (iArr[1] + view.getHeight()) - m1417b();
                this.f1189e.setLayoutParams(this.f1190f);
            } else {
                this.f1190f.topMargin = iArr[1];
                this.f1189e.setLayoutParams(this.f1190f);
            }
            this.f1189e.setVisibility(4);
            if (this.f1188d.getParent() == null) {
                this.f1186b.addView(this.f1188d, this.f1187c);
            }
            this.f1189e.postDelayed(new C08481(this), 20);
            return this;
        }

        public void m1422a() {
            this.f1197m = true;
            if (this.f1195k == null) {
                this.f1195k = AnimationUtils.loadAnimation(this.f1185a.mActivity, R.anim.custom_dialog_disappear);
                this.f1195k.setAnimationListener(new C08492(this));
            }
            this.f1189e.startAnimation(this.f1195k);
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.txvSave:
                    this.f1185a.m1427a(this.f1198n);
                    break;
                case R.id.txvDelete:
                    C0781d.m1197a(this.f1198n.f1287a);
                    this.f1185a.f1199a.m1149a(this.f1198n);
                    C0793b.m1226a(this.f1198n);
                    this.f1185a.m1434d();
                    break;
                case R.id.txvCancel:
                    C0795c.m1241a().m1245a(this.f1198n.f1287a);
                    C0781d.m1198a(this.f1198n.f1287a, 3);
                    this.f1185a.f1199a.mo2421a(this.f1198n.f1287a, 3);
                    break;
                case R.id.txvRestart:
                    C0795c.m1241a().m1246a(this.f1198n);
                    C0781d.m1198a(this.f1198n.f1287a, 0);
                    this.f1185a.f1199a.mo2421a(this.f1198n.f1287a, 3);
                    break;
            }
            if (!this.f1197m) {
                m1422a();
            }
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 4 || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            m1422a();
            return true;
        }
    }

    private void m1424a(final Uri uri, final String str) {
        C1288c a = new C1288c(this.b).mo2528a(getString(R.string.download_save_open_hint));
        a.m3102a((int) R.string.no, null);
        a.m3114b((int) R.string.yes, new OnClickListener(this) {
            final /* synthetic */ C0851e f1182c;

            public void onClick(View view) {
                C1150y.m2580a(this.f1182c.mActivity, uri, str);
            }
        }).m3122d();
    }

    private void m1427a(final FileInfo fileInfo) {
        C1148d.m2521b(new AsyncTask<Object, Object, String>(this) {
            final /* synthetic */ C0851e f1177b;

            protected String m1410a(Object... objArr) {
                return C0793b.m1220a(this.f1177b.mActivity, fileInfo);
            }

            protected void m1411a(String str) {
                super.onPostExecute(str);
                this.f1177b.hideLoadingDialog();
                if (!TextUtils.isEmpty(str)) {
                    this.f1177b.m1424a(Uri.fromFile(new File(str)), fileInfo.m1516c());
                }
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m1410a(objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m1411a((String) obj);
            }

            protected void onPreExecute() {
                super.onPreExecute();
                this.f1177b.showCancelableLoadingDialog();
            }
        }, new Object[0]);
    }

    private void m1428a(final ArrayList<FileInfo> arrayList) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>(this) {
            final /* synthetic */ C0851e f1175b;

            protected Object doInBackground(Object... objArr) {
                C0793b.m1230b(this.f1175b.mActivity, arrayList);
                return null;
            }

            protected void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                this.f1175b.hideLoadingDialog();
            }

            protected void onPreExecute() {
                super.onPreExecute();
                this.f1175b.showCancelableLoadingDialog();
            }
        }, new Object[0]);
    }

    private int m1429b(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private void m1430b() {
        this.f1201f = (FrameLayout) findViewById(R.id.contentView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvDownloadList);
        LayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemDecoration c1412b = new C1412b(this.mActivity);
        c1412b.m3583a((m1429b((int) R.dimen.PaddingSizeLarge) * 2) + m1429b((int) R.dimen.icon_size_sdo));
        recyclerView.addItemDecoration(c1412b);
        this.f1199a = new C0770c();
        this.f1199a.m1147a((C0766a) this);
        this.f1199a.m1148a((C0767b) this);
        recyclerView.setAdapter(this.f1199a);
    }

    private void m1432b(final FileInfo fileInfo) {
        C1148d.m2521b(new AsyncTask<Object, Object, String>(this) {
            final /* synthetic */ C0851e f1179b;

            protected String m1412a(Object... objArr) {
                return C0793b.m1220a(this.f1179b.mActivity, fileInfo);
            }

            protected void m1413a(String str) {
                super.onPostExecute(str);
                this.f1179b.hideLoadingDialog();
                if (!TextUtils.isEmpty(str)) {
                    C1150y.m2642m(this.f1179b.mActivity, str);
                }
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m1412a(objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m1413a((String) obj);
            }

            protected void onPreExecute() {
                super.onPreExecute();
                this.f1179b.showCancelableLoadingDialog();
            }
        }, new Object[0]);
    }

    private void m1433c() {
        Object c1279a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.download_list_bottom_menus, c1279a);
        this.mActionBar.m3005b(c1279a, 0, this);
        this.mActionBar.m3008c(false);
    }

    private void m1434d() {
        if (this.f1199a.getItemCount() == 0) {
            this.f1199a.m1153a(false);
            findViewById(R.id.imvEmptyView).setVisibility(0);
        } else {
            findViewById(R.id.imvEmptyView).setVisibility(8);
        }
        this.b.invalidateOptionsMenu();
    }

    private void m1435e() {
        this.f1199a.m1152a(C0781d.m1202b());
        m1434d();
    }

    public void mo2432a(View view, int i) {
        FileInfo b = this.f1199a.m1154b(i);
        if (b.f1293g != 2 || !new File(b.f1289c).exists()) {
            return;
        }
        if (b.m1515b() == 10) {
            this.b.m80e();
            BrowserHostActivity.m1311a(this, 100, b);
        } else if (b.m1515b() == 11) {
            this.b.m80e();
            BrowserHostActivity.m1313b(this, 100, b);
        } else if (b.m1515b() == 12) {
            this.b.m80e();
            BrowserHostActivity.m1313b(this, 100, b);
        } else if (b.m1515b() == 13) {
            try {
                if (VERSION.SDK_INT >= 16) {
                    this.b.m80e();
                    C1150y.m2579a(this.mActivity, FileProvider.getUriForFile(this.mActivity, "com.domobile.applock.FileProvider", new File(b.f1289c)));
                    return;
                }
                m1432b(b);
            } catch (Exception e) {
                m1432b(b);
            }
        } else {
            m1427a(b);
        }
    }

    public void mo2433b(View view, int i) {
        FileInfo b = this.f1199a.m1154b(i);
        if (this.f1202g == null) {
            this.f1202g = new C0850a(this, this.mActivity);
        }
        this.f1202g.m1421a(view, b);
    }

    public void b_() {
        if (this.f1199a.m1157d()) {
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_checked);
        } else {
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_uncheck);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_download_list, null);
        m1430b();
        m1435e();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            this.f1199a.m1149a((FileInfo) intent.getParcelableExtra("EXTRA_FILE_INFO"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.download_list_title);
        this.f1200e = this.b.m66r().getNavigationIcon();
        m1433c();
        C1150y.m2605b(this.mActivity, (int) R.string.event_download_list);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.download_list_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f1199a.m1156c()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f1199a.m1153a(false);
        this.b.invalidateOptionsMenu();
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList e = this.f1199a.m1158e();
        if (e.size() <= 0) {
            return true;
        }
        if (menuItem.getItemId() == R.id.action_delete) {
            if (this.f1199a.m1157d()) {
                C0781d.m1195a();
                C0793b.m1234d(this.mActivity);
            } else {
                C0781d.m1200a(e);
                C0793b.m1227a(e);
            }
            e.clear();
            m1435e();
            return true;
        } else if (menuItem.getItemId() != R.id.action_save) {
            return false;
        } else {
            m1428a(e);
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_edit) {
            this.f1199a.m1155b();
            this.b.invalidateOptionsMenu();
            return true;
        } else if (!this.f1199a.m1156c()) {
            return false;
        } else {
            this.f1199a.m1145a();
            return true;
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_action_edit);
        if (this.f1199a.getItemCount() == 0) {
            findItem.setEnabled(false);
            findItem.setIcon(R.drawable.toolbar_edit);
            findItem.getIcon().setAlpha(85);
            this.mActionBar.m3008c(false);
            this.f1201f.setPadding(0, 0, 0, 0);
            this.b.m66r().setNavigationIcon(this.f1200e);
            return;
        }
        findItem.setEnabled(true);
        if (this.f1199a.m1156c()) {
            this.mActionBar.m3008c(true);
            this.f1201f.setPadding(0, 0, 0, m1429b((int) R.dimen.actionbar_footerview_height));
            findItem.setIcon(R.drawable.toolbar_ok);
            findItem.setTitle(R.string.save);
            this.b.m66r().setNavigationIcon((int) R.drawable.vault_images_uncheck);
            return;
        }
        this.mActionBar.m3008c(false);
        this.f1201f.setPadding(0, 0, 0, 0);
        findItem.setIcon(R.drawable.toolbar_edit);
        findItem.getIcon().setAlpha(255);
        findItem.setTitle(R.string.edit);
        this.b.m66r().setNavigationIcon(this.f1200e);
    }
}
