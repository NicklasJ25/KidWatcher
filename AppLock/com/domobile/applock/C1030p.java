package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.applock.chamber.view.C0889a;
import com.domobile.applock.chamber.view.C0889a.C0888a;
import com.domobile.eframe.widget.pagetabs.C0917b;
import com.domobile.frame.p000a.C1148d;
import com.domobile.widget.ViewPagerTabs;
import java.io.File;

public class C1030p extends C0704e implements OnPageChangeListener {
    private static final int[] f1849a = new int[]{R.string.privacy, R.string.protect};
    private ViewPager f1850e;
    private ViewPagerTabs f1851f;
    private C1029a f1852g;
    private C0400d[] f1853h;
    private int f1854i = 0;
    private BroadcastReceiver f1855j = new C10271(this);

    class C10271 extends BroadcastReceiver {
        final /* synthetic */ C1030p f1845a;

        C10271(C1030p c1030p) {
            this.f1845a = c1030p;
        }

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "newest_theme_version")) {
                this.f1845a.f1854i = intent.getIntExtra("newest_theme_version", 0);
                this.f1845a.mActivity.invalidateOptionsMenu();
            }
        }
    }

    private class C1029a extends FragmentPagerAdapter implements C0917b {
        final /* synthetic */ C1030p f1848a;

        public C1029a(C1030p c1030p, FragmentActivity fragmentActivity) {
            this.f1848a = c1030p;
            super(fragmentActivity.getSupportFragmentManager());
        }

        public String mo2441a(int i) {
            return this.f1848a.mActivity.getString(C1030p.f1849a[i]);
        }

        public int getCount() {
            return C1030p.f1849a.length;
        }

        public Fragment getItem(int i) {
            return this.f1848a.f1853h[i];
        }

        public CharSequence getPageTitle(int i) {
            return mo2441a(i);
        }
    }

    private void m2074d() {
        if (C1150y.m2658u(this.mActivity)) {
            final String t = C1150y.m2655t(this.mActivity);
            if (!TextUtils.isEmpty(t) && new File(t).exists() && C1150y.m2654s(this.mActivity)) {
                C1150y.m2609b(this.mActivity, false);
                C0889a.m1537a(getChildFragmentManager(), t).m1539a(new C0888a(this) {
                    final /* synthetic */ C1030p f1847b;

                    public void mo2473a() {
                        this.f1847b.b.m80e();
                        this.f1847b.startActivity(AgentActivity.m570a(this.f1847b.mActivity, 307).putExtra("EXTRA_INVADER", C0814g.m1302b(t)));
                    }
                });
            }
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.main_pager_fragment, null);
        this.f1853h = new C0400d[]{new C1026o(), new ag()};
        this.f1850e = (ViewPager) findViewById(R.id.main_pager_pages);
        this.f1852g = new C1029a(this, this.mActivity);
        this.f1850e.setAdapter(this.f1852g);
        this.f1851f = this.b.m65q();
        this.f1851f.setVisibility(0);
        this.f1851f.setViewPager(this.f1850e);
        this.f1850e.addOnPageChangeListener(this);
        this.f1850e.addOnPageChangeListener(this.f1851f);
        m2074d();
    }

    public boolean isFragmentWithoutActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity.getPackageManager();
        this.mActivity.registerReceiver(this.f1855j, new IntentFilter("newest_theme_version"));
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.home_title_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
        if (getActionBarHelper() != null) {
            getActionBarHelper().configureMenu(this.mActivity, menu);
            getActionBarHelper().getSearchItem().setVisible(this.f1850e.getCurrentItem() == 0);
            ((C1026o) this.f1853h[0]).m2062b();
        }
    }

    public void onDestroy() {
        this.mActivity.unregisterReceiver(this.f1855j);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_theme) {
            this.b.m80e();
            C1148d.m2520b(this.mActivity, "newest_theme_version", (Object) Integer.valueOf(this.f1854i));
            this.mActivity.startActivity(AgentActivity.m570a(this.mActivity, 289));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.mActivity.invalidateOptionsMenu();
        if (i < this.f1853h.length) {
            this.f1853h[i].mo2402a();
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        int i = 0;
        super.onPrepareOptionsMenu(menu);
        if (this.f1854i > C1148d.m2499a(this.mActivity, "newest_theme_version", 0)) {
            i = 1;
        }
        menu.findItem(R.id.menu_action_theme).setIcon(i != 0 ? R.drawable.toolbar_theme_new : R.drawable.toolbar_theme);
    }

    public void onResume() {
        super.onResume();
        ViewCompat.setTranslationY(MainTabFragmentActivity.m633l().m643m(), 0.0f);
        if (this.f1850e.getChildCount() > 0 && this.f1850e.getCurrentItem() > -1 && this.f1853h != null && this.f1853h.length > 0) {
            this.f1853h[this.f1850e.getCurrentItem()].onResume();
        }
        this.f1851f.setVisibility(0);
        this.f1851f.setViewPager(this.f1850e);
        this.f1850e.addOnPageChangeListener(this.f1851f);
        this.b.m56b(R.string.app_name);
    }

    public void ui(int i, Message message) {
    }
}
