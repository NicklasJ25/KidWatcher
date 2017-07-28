package com.domobile.applock.fake;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.fake.FakePagePickerFragment.FakeBean;
import com.domobile.eframe.widget.pagetabs.C0917b;
import com.domobile.frame.p000a.C1148d;
import com.domobile.widget.PageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

public class C0920a extends C0400d implements OnPageChangeListener {
    public ViewPager f1398a;
    public C0918a f1399e;
    private ArrayList<FakeBean> f1400f = new ArrayList();
    private HashMap<String, C0919b> f1401g = new HashMap();
    private PageIndicator f1402h;
    private String f1403i;
    private int f1404j = 0;

    class C09141 implements Runnable {
        final /* synthetic */ C0920a f1385a;

        C09141(C0920a c0920a) {
            this.f1385a = c0920a;
        }

        public void run() {
            this.f1385a.a_(0);
        }
    }

    class C09152 extends Thread {
        final /* synthetic */ C0920a f1386a;

        C09152(C0920a c0920a) {
            this.f1386a = c0920a;
        }

        public void run() {
            this.f1386a.m1636b();
        }
    }

    private class C0918a extends PagerAdapter implements C0917b {
        final /* synthetic */ C0920a f1389a;

        private C0918a(C0920a c0920a) {
            this.f1389a = c0920a;
        }

        public String mo2441a(int i) {
            return ((FakeBean) this.f1389a.f1400f.get(i)).m1608a(this.f1389a.mActivity);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f1389a.f1400f.size();
        }

        public CharSequence getPageTitle(int i) {
            return ((FakeBean) this.f1389a.f1400f.get(i)).m1608a(this.f1389a.mActivity);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            C0919b c0919b;
            FakeBean fakeBean = (FakeBean) this.f1389a.f1400f.get(i);
            if (this.f1389a.f1401g.containsKey(fakeBean.f1371b)) {
                c0919b = (C0919b) this.f1389a.f1401g.get(fakeBean.f1371b);
            } else {
                C0919b c0919b2 = new C0919b(this.f1389a, this.f1389a.mActivity, fakeBean);
                this.f1389a.f1401g.put(fakeBean.f1371b, c0919b2);
                c0919b = c0919b2;
            }
            c0919b.m1625b();
            viewGroup.addView(c0919b.m1627a());
            return c0919b.m1627a();
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class C0919b implements OnClickListener {
        final /* synthetic */ C0920a f1390a;
        private FakeBean f1391b;
        private View f1392c;
        private ImageView f1393d;
        private TextView f1394e;
        private SwitchCompat f1395f;
        private View f1396g;
        private TextView f1397h;

        public C0919b(C0920a c0920a, Context context, FakeBean fakeBean) {
            this.f1390a = c0920a;
            this.f1391b = fakeBean;
            m1628a(context, LayoutInflater.from(context));
        }

        private void m1625b() {
            if ((TextUtils.isEmpty(this.f1390a.f1403i) && TextUtils.isEmpty(this.f1391b.f1371b)) || TextUtils.equals(this.f1390a.f1403i, this.f1391b.f1371b)) {
                this.f1395f.setChecked(true);
            } else {
                this.f1395f.setChecked(false);
            }
        }

        private ImageView m1626c() {
            return this.f1393d;
        }

        public View m1627a() {
            return this.f1392c;
        }

        public void m1628a(Context context, LayoutInflater layoutInflater) {
            this.f1392c = layoutInflater.inflate(R.layout.theme_apply, null);
            this.f1394e = (TextView) this.f1392c.findViewById(16908310);
            this.f1395f = (SwitchCompat) this.f1392c.findViewById(16908289);
            this.f1393d = (ImageView) this.f1392c.findViewById(R.id.theme_apply_image);
            ((View) this.f1395f.getParent()).setOnClickListener(this);
            this.f1394e.setText(this.f1391b.m1608a(this.f1390a.mActivity));
            this.f1396g = this.f1392c.findViewById(R.id.theme_fc);
            this.f1397h = (TextView) this.f1392c.findViewById(R.id.theme_tips_text);
            View c = m1626c();
            if (FakeBean.FC_TYPE.equals(this.f1391b.f1371b)) {
                this.f1396g.setVisibility(0);
                this.f1397h.setText(String.format(this.f1390a.getString(R.string.aerr_application), new Object[]{this.f1390a.getString(R.string.app_name)}));
                return;
            }
            this.f1396g.setVisibility(8);
            Resources resources = context.getResources();
            try {
                C1148d.m2514a(c, C1148d.m2502a(resources, resources.getIdentifier(this.f1391b.f1370a, null, context.getPackageName())));
            } catch (Exception e) {
                c.setBackgroundResource(R.color.default_fakeview_forground_color);
            }
        }

        public void onClick(View view) {
            if (this.f1390a.a_(0) != null) {
                return;
            }
            if (TextUtils.isEmpty(this.f1391b.f1372c)) {
                C0928b.m1641a(this.f1390a.b, this.f1391b, false);
                this.f1390a.m1632c();
                return;
            }
            this.f1390a.b.m80e();
            this.f1390a.mActivity.startActivityForResult(AgentActivity.m570a(this.f1390a.mActivity, 297).putExtra("com.domobile.elock.EXTRA_PARCELABLE", this.f1391b), 100);
        }
    }

    private void m1632c() {
        this.f1403i = C1150y.m2629h(this.mActivity);
        if (!this.f1401g.isEmpty()) {
            for (C0919b a : this.f1401g.values()) {
                a.m1625b();
            }
        }
    }

    public void m1636b() {
        int i = 0;
        if (TextUtils.isEmpty(this.f1403i)) {
            this.f1404j = 0;
        }
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(C1148d.m2494F(this.mActivity, "fake_pages.json"));
            int length = jSONArray.length();
            while (i < length) {
                FakeBean fakeBean = new FakeBean(jSONArray.getJSONObject(i));
                if (TextUtils.equals(this.f1403i, fakeBean.f1371b)) {
                    this.f1404j = i;
                }
                arrayList.add(fakeBean);
                i++;
            }
        } catch (Exception e) {
        }
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ C0920a f1388b;

            public void run() {
                this.f1388b.f1400f.clear();
                this.f1388b.f1400f.addAll(arrayList);
                this.f1388b.f1399e = new C0918a();
                this.f1388b.f1398a.setAdapter(this.f1388b.f1399e);
                this.f1388b.f1402h.m3556a(this.f1388b.f1400f.size());
                this.f1388b.f1398a.setCurrentItem(this.f1388b.f1404j, false);
            }
        });
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.pick_lock_background, null);
        this.rootView.setBackgroundResource(R.color.card_page_bgcolor);
        this.f1398a = (ViewPager) findViewById(R.id.pick_lock_background_pages);
        this.f1402h = (PageIndicator) findViewById(R.id.page_indicator);
        this.f1402h.setVisibility(0);
        this.f1398a.addOnPageChangeListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.fake_page_picker);
        this.mActionBar.m3000a(new C09141(this));
        C1150y.m2605b(this.mActivity, (int) R.string.event_fake_apply_pager);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.default_menu_share) {
            Drawable background = findViewById(R.id.theme_apply_image).getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                Bitmap bitmap = ((BitmapDrawable) background).getBitmap();
                if (bitmap != null) {
                    this.b.m80e();
                    C1148d.m2512a(this.mActivity, null, this.mActivity.getString(R.string.fake_share_message, new Object[]{this.b.h.getTitle()}), C1148d.m2506a(bitmap, false));
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        try {
            this.f1402h.m3557b(i);
            ((C0919b) this.f1401g.get(Integer.valueOf(i))).m1625b();
        } catch (Exception e) {
        }
    }

    public void onResume() {
        super.onResume();
        m1632c();
        if (this.f1400f.isEmpty()) {
            new C09152(this).start();
        }
    }
}
