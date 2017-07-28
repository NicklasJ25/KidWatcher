package com.domobile.frame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1290d;
import com.domobile.p015b.C1168b.C1158b;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1165i;
import com.domobile.widget.ViewPagerTabs;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

public abstract class C0384c extends ActionBarActivity {
    private C1265b f35a = null;
    private C1290d f36b;
    private ViewPagerTabs f37c;
    private ActionBarHelper f38d;
    public boolean f39f;
    public boolean f40g;
    public Toolbar f41h;
    public DrawerLayout f42i;
    public ActionBarDrawerToggle f43j;

    public class C1264a extends ActionBarDrawerToggle {
        final /* synthetic */ C0384c f2602a;

        public C1264a(C0384c c0384c, Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
            this.f2602a = c0384c;
            super(activity, drawerLayout, toolbar, i, i2);
        }

        public void onDrawerClosed(View view) {
            if (((LayoutParams) view.getLayoutParams()).gravity == 3) {
                super.onDrawerClosed(view);
                this.f2602a.mo2360i();
            }
        }

        public void onDrawerOpened(View view) {
            if (((LayoutParams) view.getLayoutParams()).gravity == 3) {
                super.onDrawerOpened(view);
                this.f2602a.mo2361j();
            }
        }

        public void onDrawerSlide(View view, float f) {
            if (((LayoutParams) view.getLayoutParams()).gravity == 3) {
                super.onDrawerSlide(view, f);
            }
        }
    }

    public static class C1265b extends Handler {
        WeakReference<C0384c> f2603a;

        public C1265b(C0384c c0384c) {
            super(Looper.getMainLooper());
            this.f2603a = new WeakReference(c0384c);
        }

        public WeakReference<C0384c> m3017a() {
            return this.f2603a;
        }

        public void m3018a(C0384c c0384c) {
            this.f2603a = new WeakReference(c0384c);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    if (this.f2603a.get() != null) {
                        C1148d.m2517a(((C0384c) this.f2603a.get()).f36b);
                        return;
                    }
                    return;
                case 101:
                    if (this.f2603a.get() != null) {
                        if (((C0384c) this.f2603a.get()).f36b != null && ((C0384c) this.f2603a.get()).f36b.m3121c()) {
                            ((C0384c) this.f2603a.get()).f36b.m3125e();
                        }
                        ((C0384c) this.f2603a.get()).f36b = C1148d.m2505a((Activity) this.f2603a.get(), null, null);
                        ((C0384c) this.f2603a.get()).f36b.m3117b(false);
                        return;
                    }
                    return;
                case 102:
                    if (this.f2603a.get() != null) {
                        if (((C0384c) this.f2603a.get()).f36b != null && ((C0384c) this.f2603a.get()).f36b.m3121c()) {
                            ((C0384c) this.f2603a.get()).f36b.m3125e();
                        }
                        ((C0384c) this.f2603a.get()).f36b = C1148d.m2505a((Activity) this.f2603a.get(), null, null);
                        ((C0384c) this.f2603a.get()).f36b.m3117b(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static String m45a(Bitmap bitmap, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(C1148d.L, "share_image.png");
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.PNG, 80, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (z && bitmap != null) {
                    bitmap.recycle();
                }
                return file.getAbsolutePath();
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return !z ? null : null;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                bitmap.recycle();
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (!z && bitmap != null) {
                bitmap.recycle();
                return null;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (z && bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private void mo2042a() {
        if (this.f35a == null) {
            this.f35a = new C1265b(this);
        }
        if (this.f35a.m3017a().get() == null) {
            this.f35a.m3018a(this);
        }
    }

    public void m47A() {
        C1148d.m2527d(this);
    }

    public void m48B() {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(getPackageName(), 0).applicationInfo;
            C1148d.m2512a(this, getString(C1165i.domo_share_message_title), getString(C1165i.domo_share_message, new Object[]{r1.applicationInfo.loadLabel(packageManager), r1.versionName, r1.packageName, r1.applicationInfo.loadLabel(packageManager)}), C0384c.m45a(((BitmapDrawable) applicationInfo.loadIcon(packageManager)).getBitmap(), false));
        } catch (Exception e) {
        }
    }

    public void m49C() {
        mo2042a();
        this.f35a.sendEmptyMessage(101);
    }

    public void m50D() {
        mo2042a();
        this.f35a.sendEmptyMessage(102);
    }

    public void m51E() {
        mo2042a();
        this.f35a.sendEmptyMessageDelayed(100, 1000);
    }

    public void m52a(C0399d c0399d) {
        m53a(c0399d, 0, 0);
    }

    public void m53a(C0399d c0399d, int i, int i2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!(i == 0 || i2 == 0)) {
            beginTransaction.setCustomAnimations(i, i2);
        }
        if (c0399d != null) {
            beginTransaction.replace(C1162f.domo_activity_fragment, c0399d);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void m54a(String str) {
        if (this.f41h != null) {
            this.f41h.setTitle((CharSequence) str);
            setSupportActionBar(this.f41h);
            if (this.f43j != null) {
                this.f43j.syncState();
            }
        }
    }

    public boolean m55a(int i, KeyEvent keyEvent) {
        return m64p() != null && ((C0399d) m64p()).onKeyDown(i, keyEvent);
    }

    public void m56b(int i) {
        if (this.f41h != null) {
            this.f41h.setTitle(i);
            setSupportActionBar(this.f41h);
            if (this.f43j != null) {
                this.f43j.syncState();
            }
        }
    }

    public boolean mo2046b() {
        return false;
    }

    public void mo2040c() {
        this.f37c = (ViewPagerTabs) findViewById(C1162f.view_pager_tabs);
        this.f41h = (Toolbar) findViewById(C1162f.action_toolbar);
        if (this.f41h != null) {
            setSupportActionBar(this.f41h);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            View findViewById = findViewById(C1162f.domo_activity_content);
            if (mo2046b() && findViewById != null) {
                findViewById.setPadding(0, 0, 0, 0);
            }
        }
        this.f42i = (DrawerLayout) findViewById(C1162f.drawer_layout);
        if (this.f42i != null) {
            this.f42i.setDrawerShadow(C1161e.drawerlayout_shadow, (int) GravityCompat.START);
            this.f43j = new C1264a(this, this, this.f42i, this.f41h, C1165i.app_name, C1165i.app_name);
            this.f42i.setDrawerListener(this.f43j);
            this.f43j.syncState();
        }
    }

    public abstract void mo2041d();

    public boolean mo2043f() {
        return false;
    }

    public View mo2359g() {
        return getLayoutInflater().inflate(C1163g.domo_activity, null);
    }

    public void mo2360i() {
    }

    public void mo2361j() {
        if (this.f38d != null) {
            this.f38d.clearSearch();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.f42i != null && this.f42i.isDrawerOpen(3)) {
            this.f42i.closeDrawers();
        } else if (!mo2043f()) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
        }
        mo2041d();
        setContentView(mo2359g());
        mo2040c();
        this.f38d = new ActionBarHelper(this);
        if (this.f39f) {
            C1148d.m2529f(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m55a(i, keyEvent)) {
            return true;
        }
        if (i == 84 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return i != 82 ? super.onKeyDown(i, keyEvent) : true;
        } else {
            if (m68t().isInSearchMode()) {
                m68t().clearSearch();
                return true;
            }
            m74z();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyUp(i, keyEvent);
        }
        if (m73y() != null) {
            m73y().m3015h();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (m64p() != null && m64p().onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.f38d.isInSearchMode()) {
                this.f38d.clearSearch();
                return true;
            } else if (this.f42i != null) {
                if (this.f42i.isDrawerOpen(3)) {
                    this.f42i.closeDrawer(3);
                    return true;
                } else if (this.f42i.isDrawerOpen(5)) {
                    this.f42i.closeDrawer(5);
                    return true;
                } else {
                    this.f42i.openDrawer(3);
                    return true;
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    public Fragment m64p() {
        return getSupportFragmentManager().findFragmentById(C1162f.domo_activity_fragment);
    }

    public ViewPagerTabs m65q() {
        return this.f37c;
    }

    public Toolbar m66r() {
        return this.f41h;
    }

    public View m67s() {
        return findViewById(C1162f.tab_actionbar_layout);
    }

    public ActionBarHelper m68t() {
        return this.f38d;
    }

    @TargetApi(21)
    public void m69u() {
        View findViewById = findViewById(C1162f.domo_activity_shadow);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
    }

    public void m70v() {
        if (this.f41h != null) {
            this.f41h.setVisibility(8);
            View findViewById = findViewById(C1162f.domo_activity_content);
            if (findViewById != null) {
                findViewById.setPadding(0, 0, 0, 0);
            }
        }
    }

    public void m71w() {
        if (this.f41h != null) {
            this.f41h.setVisibility(0);
            View findViewById = findViewById(C1162f.domo_activity_content);
            if (!mo2046b() && findViewById != null) {
                findViewById.setPadding(0, getResources().getDimensionPixelSize(C1148d.m2533h(this, C1158b.actionBarSize)), 0, 0);
            }
        }
    }

    @TargetApi(21)
    public void m72x() {
        View findViewById = findViewById(C1162f.domo_activity_shadow);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public C1263b m73y() {
        Fragment p = m64p();
        return (p == null || !(p instanceof C0399d)) ? null : ((C0399d) p).getActionBar();
    }

    public final void m74z() {
        if (this.f39f) {
            C1148d.m2528e(this);
        } else {
            finish();
        }
    }
}
