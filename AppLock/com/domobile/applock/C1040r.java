package com.domobile.applock;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.domobile.eframe.widget.pagetabs.C0917b;
import com.domobile.widget.ViewPagerTabs;

public class C1040r extends C0704e implements OnPageChangeListener, OnTouchListener {
    private static final int[] f1875a = new int[]{R.string.photo, R.string.video};
    private ViewPager f1876e;
    private ViewPagerTabs f1877f;
    private C0400d[] f1878g;
    private C1039a f1879h;

    private class C1039a extends FragmentPagerAdapter implements C0917b {
        final /* synthetic */ C1040r f1874a;

        public C1039a(C1040r c1040r, FragmentActivity fragmentActivity) {
            this.f1874a = c1040r;
            super(fragmentActivity.getSupportFragmentManager());
        }

        public String mo2441a(int i) {
            return this.f1874a.mActivity.getString(C1040r.f1875a[i]);
        }

        public int getCount() {
            return C1040r.f1875a.length;
        }

        public Fragment getItem(int i) {
            return this.f1874a.f1878g[i];
        }

        public CharSequence getPageTitle(int i) {
            return mo2441a(i);
        }
    }

    public boolean mo2400b() {
        return true;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.fragment_media_safe, null);
        Bundle bundle2 = new Bundle();
        C1119v c1119v = new C1119v();
        bundle2.putInt("com.domobile.elock.EXTRA_TYPE", 1);
        c1119v.setArguments(bundle2);
        this.f1878g = new C0400d[]{new C1119v(), c1119v};
        this.f1876e = (ViewPager) findViewById(R.id.viewPager);
        this.f1879h = new C1039a(this, this.mActivity);
        this.f1876e.setAdapter(this.f1879h);
        this.f1877f = this.b.m65q();
        this.f1877f.setVisibility(0);
        this.f1877f.setViewPager(this.f1876e);
        this.f1876e.addOnPageChangeListener(this);
        this.f1876e.addOnPageChangeListener(this.f1877f);
        View findViewById = findViewById(R.id.fabAdd);
        findViewById.setOnClickListener(this);
        findViewById.setOnTouchListener(this);
    }

    public boolean isToolBarFloat() {
        return super.isToolBarFloat();
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.fabAdd) {
            ((C1119v) this.f1878g[this.f1876e.getCurrentItem()]).m2447c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.lock_media_safe);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.mActivity.invalidateOptionsMenu();
        if (i < this.f1878g.length) {
            this.f1878g[i].mo2402a();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return ((C1119v) this.f1878g[this.f1876e.getCurrentItem()]).onTouch(view, motionEvent);
    }
}
