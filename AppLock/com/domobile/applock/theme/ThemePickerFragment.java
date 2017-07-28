package com.domobile.applock.theme;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0386c;
import com.domobile.applock.C0704e;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0419f;
import com.domobile.applock.p003a.C0629j;
import com.domobile.applock.p003a.C0629j.C0627a;
import com.domobile.applock.p003a.C0629j.C0628b;
import com.domobile.applock.theme.C1101b.C1089a;
import com.domobile.eframe.widget.pagetabs.C0917b;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.ui.C1288c;
import com.domobile.widget.OverscrollRecyclerView;
import com.domobile.widget.ViewPagerTabs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ThemePickerFragment extends C0704e implements OnPageChangeListener {
    private static final int[] f2096f = new int[]{R.string.featured_themes, R.string.installed_themes};
    BroadcastReceiver f2097a = new C10872(this);
    private final String f2098e = "{\"name\": \"Default\",\"pic\": \"\",\"package\": \"com.domobile.applock\",\"size\": \"1024\",\"version\": \"20130922\",\"applock_version\": \"2013092201\"}";
    private Handler f2099g = new Handler();
    private C1100d f2100h;
    private C1100d f2101i;
    private String f2102j = "";
    private boolean f2103k = false;
    private boolean f2104l = false;
    private boolean f2105m = true;
    private ViewPager f2106n;
    private ViewPagerTabs f2107o;
    private C1097a f2108p;
    private View f2109q;
    private ThemeBean f2110r;

    class C10861 implements Runnable {
        final /* synthetic */ ThemePickerFragment f2057a;

        C10861(ThemePickerFragment themePickerFragment) {
            this.f2057a = themePickerFragment;
        }

        public void run() {
            this.f2057a.a_(0);
        }
    }

    class C10872 extends BroadcastReceiver {
        final /* synthetic */ ThemePickerFragment f2058a;

        C10872(ThemePickerFragment themePickerFragment) {
            this.f2058a = themePickerFragment;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                try {
                    Object replace = intent.getData().toString().toLowerCase().replace("package:", "");
                    if (!TextUtils.isEmpty(replace) && replace.startsWith("com.domobile.aut.")) {
                        this.f2058a.m2373c();
                    }
                } catch (Exception e) {
                }
            } else if ("com.domobile.applock.ACTION_STARTUP_THEME_SUCCESS".equals(action)) {
                this.f2058a.f2101i.notifyDataSetChanged();
            }
        }
    }

    class C10947 extends Thread {
        final /* synthetic */ ThemePickerFragment f2068a;

        C10947(ThemePickerFragment themePickerFragment) {
            this.f2068a = themePickerFragment;
        }

        public void run() {
            this.f2068a.m2374d();
        }
    }

    public static class ThemeBean implements Parcelable {
        public static final Creator<ThemeBean> CREATOR = new C10961();
        public long f2072a;
        public String f2073b;
        public String f2074c;
        public String f2075d;
        public String f2076e;
        public long f2077f;
        public long f2078g;
        public boolean f2079h;
        public boolean f2080i;
        public boolean f2081j;
        public String f2082k;
        public int f2083l;

        static class C10961 implements Creator<ThemeBean> {
            C10961() {
            }

            public ThemeBean m2337a(Parcel parcel) {
                return new ThemeBean(parcel);
            }

            public ThemeBean[] m2338a(int i) {
                return new ThemeBean[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2337a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2338a(i);
            }
        }

        public ThemeBean(PackageManager packageManager, JSONObject jSONObject, String str) {
            this.f2072a = jSONObject.optLong(Columns.SIZE);
            this.f2073b = jSONObject.optString("name");
            this.f2075d = C1147a.m2480a(new Object[0]);
            this.f2076e = jSONObject.optString("package");
            this.f2077f = jSONObject.optLong("version");
            this.f2078g = jSONObject.optLong("applock_version");
            this.f2079h = m2339a(packageManager);
            if (!TextUtils.isEmpty(jSONObject.optString("pic"))) {
                this.f2075d = C1147a.m2480a(jSONObject.optString("pic"), ".jpg");
                this.f2074c = C1147a.m2480a(r0, str, ".jpg");
            }
            this.f2080i = jSONObject.optBoolean("live");
            this.f2081j = jSONObject.optBoolean("charge");
            this.f2082k = jSONObject.optString("index");
        }

        public ThemeBean(Parcel parcel) {
            boolean z = true;
            this.f2072a = parcel.readLong();
            this.f2073b = parcel.readString();
            this.f2074c = parcel.readString();
            this.f2075d = parcel.readString();
            this.f2076e = parcel.readString();
            this.f2077f = parcel.readLong();
            this.f2078g = parcel.readLong();
            this.f2079h = parcel.readInt() == 1;
            this.f2080i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2081j = z;
            this.f2082k = parcel.readString();
        }

        public boolean m2339a(PackageManager packageManager) {
            return C1102c.m2394a(packageManager, this.f2076e);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeLong(this.f2072a);
            parcel.writeString(this.f2073b);
            parcel.writeString(this.f2074c);
            parcel.writeString(this.f2075d);
            parcel.writeString(this.f2076e);
            parcel.writeLong(this.f2077f);
            parcel.writeLong(this.f2078g);
            parcel.writeInt(this.f2079h ? 1 : 0);
            parcel.writeInt(this.f2080i ? 1 : 0);
            if (!this.f2081j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.f2082k);
        }
    }

    private class C1097a extends PagerAdapter implements C0917b {
        final /* synthetic */ ThemePickerFragment f2084a;

        private C1097a(ThemePickerFragment themePickerFragment) {
            this.f2084a = themePickerFragment;
        }

        public String mo2441a(int i) {
            return this.f2084a.mActivity.getString(ThemePickerFragment.f2096f[i]);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return ThemePickerFragment.f2096f.length;
        }

        public CharSequence getPageTitle(int i) {
            return mo2441a(i);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View a = i == 0 ? this.f2084a.m2351a(this.f2084a.f2100h) : this.f2084a.m2351a(this.f2084a.f2101i);
            ((ViewPager) viewGroup).addView(a);
            return a;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class C1098b extends ViewHolder {
        public View f2085a;
        public CacheImageView f2086b;
        public ImageView f2087c;
        public ImageView f2088d;
        public ImageView f2089e;
        ObjectAnimator f2090f;
        final /* synthetic */ ThemePickerFragment f2091g;

        public C1098b(ThemePickerFragment themePickerFragment, View view) {
            this.f2091g = themePickerFragment;
            super(view);
            this.f2085a = view.findViewById(R.id.theme_picker_item_imgcontainer);
            this.f2086b = (CacheImageView) view.findViewById(R.id.theme_picker_item_image);
            this.f2087c = (ImageView) view.findViewById(R.id.theme_picker_item_checked);
            this.f2088d = (ImageView) view.findViewById(R.id.theme_picker_item_live);
            this.f2089e = (ImageView) view.findViewById(R.id.theme_picker_item_charge);
        }

        public void m2341a() {
            if (this.f2090f == null) {
                this.f2090f = ObjectAnimator.ofFloat(this.f2088d, "rotation", new float[]{0.0f, 360.0f});
                this.f2090f.setInterpolator(new LinearInterpolator());
                this.f2090f.setRepeatMode(1);
                this.f2090f.setRepeatCount(-1);
                this.f2090f.setDuration(750);
            }
            this.f2090f.start();
        }

        public void m2342b() {
            if (this.f2090f != null) {
                this.f2090f.cancel();
            }
        }
    }

    private class C1099c implements C0607f {
        final /* synthetic */ ThemePickerFragment f2092a;

        private C1099c(ThemePickerFragment themePickerFragment) {
            this.f2092a = themePickerFragment;
        }

        public C1275d mo2363a() {
            this.f2092a.f2104l = true;
            String str = "";
            try {
                str = C1150y.m2572a(this.f2092a.mActivity, "THEME_PICKER_DOMAIN_SUFFIX", (Object) "").toString();
            } catch (Exception e) {
            }
            return new C1275d(C1147a.m2480a("https://www.domobile.com/", "apps/skin/unlock", str, ".json"));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2364a(java.lang.String r13) {
            /*
            r12 = this;
            r11 = 8;
            r10 = 1;
            r1 = 0;
            r0 = r12.f2092a;
            r0.f2104l = r1;
            r2 = new java.util.ArrayList;
            r2.<init>();
            r3 = new java.util.ArrayList;
            r0 = r12.f2092a;
            r0 = r0.f2101i;
            r0 = r0.f2095c;
            r3.<init>(r0);
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0065, all -> 0x008b }
            r0.<init>(r13);	 Catch:{ Exception -> 0x0065, all -> 0x008b }
            r4 = r12.f2092a;	 Catch:{ Exception -> 0x0065, all -> 0x008b }
            r4 = r4.mActivity;	 Catch:{ Exception -> 0x0065, all -> 0x008b }
            com.domobile.applock.theme.C1102c.m2403d(r4, r13);	 Catch:{ Exception -> 0x0065, all -> 0x008b }
        L_0x0029:
            r4 = "unlock_skin";
            r4 = r0.optJSONArray(r4);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            if (r4 == 0) goto L_0x003d;
        L_0x0031:
            r0 = r4.length();	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            if (r0 <= 0) goto L_0x003d;
        L_0x0037:
            r0 = r12.f2092a;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r5 = 0;
            r0.f2105m = r5;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
        L_0x003d:
            r0 = r12.f2092a;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r0 = r0.mActivity;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r5 = r0.getPackageManager();	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r6 = r4.length();	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r0 = r1;
        L_0x004a:
            if (r0 >= r6) goto L_0x00ed;
        L_0x004c:
            r7 = r4.getJSONObject(r0);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r8 = new com.domobile.applock.theme.ThemePickerFragment$ThemeBean;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r9 = r12.f2092a;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r9 = r9.f2102j;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r8.<init>(r5, r7, r9);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r7 = r8.f2079h;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            if (r7 == 0) goto L_0x0087;
        L_0x005f:
            r3.add(r8);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
        L_0x0062:
            r0 = r0 + 1;
            goto L_0x004a;
        L_0x0065:
            r0 = move-exception;
            r0 = r12.f2092a;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r0 = r0.mActivity;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r4 = com.domobile.applock.theme.C1102c.m2396b(r0);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            r0.<init>(r4);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            goto L_0x0029;
        L_0x0074:
            r0 = move-exception;
            r0 = r12.f2092a;
            r0 = r0.f2109q;
            r0.setVisibility(r11);
            r0 = r12.f2092a;
            r0 = r0.f2105m;
            if (r0 == 0) goto L_0x014f;
        L_0x0086:
            return;
        L_0x0087:
            r2.add(r8);	 Catch:{ Exception -> 0x0074, all -> 0x008b }
            goto L_0x0062;
        L_0x008b:
            r0 = move-exception;
            r4 = r12.f2092a;
            r4 = r4.f2109q;
            r4.setVisibility(r11);
            r4 = r12.f2092a;
            r4 = r4.f2105m;
            if (r4 != 0) goto L_0x0086;
        L_0x009d:
            r4 = r12.f2092a;
            r4.f2103k = r10;
            r4 = r12.f2092a;
            r4 = r4.f2110r;
            r3.add(r1, r4);
            r4 = r12.f2092a;
            r4 = r4.f2101i;
            r4.m2349a(r3);
            r3 = r12.f2092a;
            r3 = r3.f2100h;
            r3.m2349a(r2);
            r2 = r12.f2092a;
            r2 = r2.isFragmentResumed();
            if (r2 == 0) goto L_0x0086;
        L_0x00c5:
            r2 = r12.f2092a;
            r2 = r2.f2106n;
            r3 = r12.f2092a;
            r3 = r3.f2108p;
            r2.setAdapter(r3);
            r2 = r12.f2092a;
            r2 = r2.f2107o;
            r2.setVisibility(r1);
            r1 = r12.f2092a;
            r1 = r1.f2107o;
            r2 = r12.f2092a;
            r2 = r2.f2106n;
            r1.setViewPager(r2);
            throw r0;
        L_0x00ed:
            r0 = r12.f2092a;
            r0 = r0.f2109q;
            r0.setVisibility(r11);
            r0 = r12.f2092a;
            r0 = r0.f2105m;
            if (r0 != 0) goto L_0x0086;
        L_0x00fe:
            r0 = r12.f2092a;
            r0.f2103k = r10;
            r0 = r12.f2092a;
            r0 = r0.f2110r;
            r3.add(r1, r0);
            r0 = r12.f2092a;
            r0 = r0.f2101i;
            r0.m2349a(r3);
            r0 = r12.f2092a;
            r0 = r0.f2100h;
            r0.m2349a(r2);
            r0 = r12.f2092a;
            r0 = r0.isFragmentResumed();
            if (r0 == 0) goto L_0x0086;
        L_0x0126:
            r0 = r12.f2092a;
            r0 = r0.f2106n;
            r2 = r12.f2092a;
            r2 = r2.f2108p;
            r0.setAdapter(r2);
            r0 = r12.f2092a;
            r0 = r0.f2107o;
            r0.setVisibility(r1);
            r0 = r12.f2092a;
            r0 = r0.f2107o;
            r1 = r12.f2092a;
            r1 = r1.f2106n;
            r0.setViewPager(r1);
            goto L_0x0086;
        L_0x014f:
            r0 = r12.f2092a;
            r0.f2103k = r10;
            r0 = r12.f2092a;
            r0 = r0.f2110r;
            r3.add(r1, r0);
            r0 = r12.f2092a;
            r0 = r0.f2101i;
            r0.m2349a(r3);
            r0 = r12.f2092a;
            r0 = r0.f2100h;
            r0.m2349a(r2);
            r0 = r12.f2092a;
            r0 = r0.isFragmentResumed();
            if (r0 == 0) goto L_0x0086;
        L_0x0177:
            r0 = r12.f2092a;
            r0 = r0.f2106n;
            r2 = r12.f2092a;
            r2 = r2.f2108p;
            r0.setAdapter(r2);
            r0 = r12.f2092a;
            r0 = r0.f2107o;
            r0.setVisibility(r1);
            r0 = r12.f2092a;
            r0 = r0.f2107o;
            r1 = r12.f2092a;
            r1 = r1.f2106n;
            r0.setViewPager(r1);
            goto L_0x0086;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.theme.ThemePickerFragment.c.a(java.lang.String):void");
        }
    }

    private class C1100d extends C0419f implements OnClickListener, C0421b {
        final /* synthetic */ ThemePickerFragment f2093a;
        private View f2094b = null;
        private ArrayList<ThemeBean> f2095c = new ArrayList();

        public C1100d(ThemePickerFragment themePickerFragment, FragmentActivity fragmentActivity, ArrayList<ThemeBean> arrayList) {
            this.f2093a = themePickerFragment;
            if (arrayList != null) {
                this.f2095c.addAll(arrayList);
            }
        }

        public BitmapDrawable mo2069a(Object obj) {
            if (obj != null) {
                try {
                    if (obj instanceof String) {
                        return ThemePickerFragment.m2360b(this.f2093a.mActivity.getApplicationContext(), (String) obj);
                    }
                } catch (Exception e) {
                }
            }
            return null;
        }

        public ThemeBean m2347a(int i) {
            return (ThemeBean) this.f2095c.get(i);
        }

        public C1098b m2348a(ViewGroup viewGroup, int i) {
            View inflate = this.f2093a.mActivity.getLayoutInflater().inflate(R.layout.theme_picker_item, viewGroup, false);
            inflate.findViewById(R.id.theme_picker_item_name).setVisibility(8);
            C1098b c1098b = new C1098b(this.f2093a, inflate);
            c1098b.f2085a.setOnClickListener(this);
            c1098b.f2086b.m3044a((C0421b) this).m3043a(ResourcesCompat.getDrawable(this.f2093a.mActivity.getResources(), R.drawable.theme_picker_default_item_bgcolor, null));
            return c1098b;
        }

        public void m2349a(ArrayList<ThemeBean> arrayList) {
            this.f2095c.clear();
            this.f2095c.addAll(arrayList);
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f2095c.size();
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            int i2 = 0;
            C1098b c1098b = (C1098b) viewHolder;
            ThemeBean a = m2347a(i);
            a.f2083l = i;
            c1098b.f2085a.setTag(a);
            c1098b.f2087c.setVisibility(8);
            if (a.f2079h && C1102c.m2406e(this.f2093a.mActivity, a.f2076e)) {
                this.f2094b = c1098b.f2087c;
                c1098b.f2087c.setVisibility(0);
            }
            c1098b.f2086b.setImageDrawable(null);
            if (TextUtils.isEmpty(a.f2074c)) {
                c1098b.f2086b.setBackgroundResource(R.drawable.num_background);
            } else {
                c1098b.f2086b.setImage(a.f2074c);
            }
            if (a.f2080i) {
                c1098b.f2088d.setVisibility(0);
                c1098b.m2341a();
            } else {
                c1098b.f2088d.setVisibility(8);
                c1098b.m2342b();
            }
            ImageView imageView = c1098b.f2089e;
            if (!a.f2081j) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }

        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && view.getId() == R.id.theme_picker_item_imgcontainer) {
                ThemeBean themeBean = (ThemeBean) tag;
                if (!C1102c.m2385a(this.f2093a.b).equals(themeBean.f2076e)) {
                    if (!themeBean.m2339a(this.f2093a.mActivity.getPackageManager())) {
                        this.f2093a.b.m80e();
                        C1148d.m2493E(this.f2093a.mActivity, themeBean.f2076e);
                    } else if (!ThemePickerFragment.m2358a(this.f2093a.b, themeBean) && this.f2093a.a_(0) == null) {
                        if (!themeBean.f2081j || C1150y.m2638k(this.f2093a.mActivity) || C1102c.m2397b(this.f2093a.mActivity, themeBean.f2076e)) {
                            C1102c.m2390a(this.f2093a.mActivity, themeBean);
                            if (this.f2094b != null) {
                                this.f2094b.setVisibility(8);
                            }
                            this.f2094b = view.findViewById(R.id.theme_picker_item_checked);
                            this.f2094b.setVisibility(0);
                            return;
                        }
                        this.f2093a.m2354a(themeBean);
                    }
                }
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m2348a(viewGroup, i);
        }
    }

    private View m2351a(Adapter adapter) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.pick_lock_background_fragment, null);
        final OverscrollRecyclerView overscrollRecyclerView = (OverscrollRecyclerView) inflate.findViewById(R.id.pick_lock_background_grid);
        LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(m2368f(), 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        overscrollRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        overscrollRecyclerView.setAdapter(adapter);
        overscrollRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ ThemePickerFragment f2060b;

            public void onGlobalLayout() {
                C1148d.m2515a(overscrollRecyclerView.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                overscrollRecyclerView.m3553a(this.f2060b.b.m66r().getHeight(), this.f2060b.mActivity.findViewById(R.id.tab_actionbar_layout));
            }
        });
        return inflate;
    }

    private void m2354a(final ThemeBean themeBean) {
        C1101b.m2375a(getChildFragmentManager()).m2377a(new C1089a(this) {
            final /* synthetic */ ThemePickerFragment f2062b;

            public void mo2488a() {
                try {
                    this.f2062b.b.m80e();
                    C1148d.m2492D(this.f2062b.mActivity, themeBean.f2082k);
                } catch (Exception e) {
                }
            }

            public void mo2489a(String str) {
                this.f2062b.m2357a(str, themeBean);
            }

            public void mo2490b() {
                this.f2062b.b.m78a(false);
            }
        });
    }

    private void m2357a(final String str, final ThemeBean themeBean) {
        showLoadingDialog();
        C0629j.m751a(str, themeBean.f2076e, new C0628b(this) {
            final /* synthetic */ ThemePickerFragment f2066c;

            class C10911 implements C0627a {
                final /* synthetic */ C10925 f2063a;

                C10911(C10925 c10925) {
                    this.f2063a = c10925;
                }

                public void mo2491a(boolean z) {
                    this.f2063a.f2066c.hideLoadingDialog();
                    if (z) {
                        C1102c.m2390a(this.f2063a.f2066c.mActivity, themeBean);
                        C1102c.m2391a(this.f2063a.f2066c.mActivity, themeBean.f2076e);
                        this.f2063a.f2066c.f2101i.notifyDataSetChanged();
                        return;
                    }
                    this.f2063a.f2066c.m111a(this.f2063a.f2066c.getString(R.string.theme_activate_tips_failed));
                }
            }

            public void mo2492a(int i) {
                if (i == 2) {
                    C0629j.m750a(str, themeBean.f2076e, new C10911(this));
                    return;
                }
                this.f2066c.hideLoadingDialog();
                if (i == 0) {
                    this.f2066c.m111a(this.f2066c.getString(R.string.theme_activate_tips_invalid));
                } else if (i == 1) {
                    this.f2066c.m111a(this.f2066c.getString(R.string.theme_activate_tips_used));
                } else if (i == -1) {
                    this.f2066c.m111a(this.f2066c.getString(R.string.theme_activate_tips_failed));
                }
            }
        });
    }

    public static boolean m2358a(final C0386c c0386c, ThemeBean themeBean) {
        if (themeBean.f2078g <= ((long) C1150y.m2636j(c0386c, "com.domobile.applock"))) {
            return false;
        }
        new C1288c(c0386c).m3123d((int) R.string.themes_need_update_applock_message).m3114b((int) R.string.play_store, new OnClickListener() {
            public void onClick(View view) {
                c0386c.m80e();
                C1148d.m2493E(c0386c, "com.domobile.applock");
            }
        }).m3117b(true).m3122d();
        return true;
    }

    private static BitmapDrawable m2360b(Context context, String str) {
        String a = C1277a.m3057a(str);
        File file = new File(a);
        if (file.exists()) {
            return new BitmapDrawable(context.getResources(), a);
        }
        try {
            Bitmap c = C1277a.m3061c(str);
            if (c != null) {
                C1277a.m3058a(file, c, CompressFormat.PNG);
                c.recycle();
            }
            return new BitmapDrawable(context.getResources(), a);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int m2368f() {
        Resources resources = this.mActivity.getResources();
        return Math.max(3, C1148d.m2500a(this.mActivity.getWindowManager()).x / (resources.getDimensionPixelSize(R.dimen.PaddingSizeMiddle) + resources.getDimensionPixelSize(R.dimen.theme_picker_preview_imageWidth)));
    }

    public void m2373c() {
        new C10947(this).start();
    }

    public void m2374d() {
        ArrayList arrayList = new ArrayList(this.f2101i.f2095c);
        arrayList.addAll(this.f2100h.f2095c);
        if (arrayList.size() > 1) {
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            PackageManager packageManager = this.mActivity.getPackageManager();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ThemeBean themeBean = (ThemeBean) it.next();
                boolean a = themeBean.m2339a(packageManager);
                themeBean.f2079h = a;
                if (a) {
                    arrayList3.add(themeBean);
                } else {
                    arrayList2.add(themeBean);
                }
            }
            this.f2099g.post(new Runnable(this) {
                final /* synthetic */ ThemePickerFragment f2071c;

                public void run() {
                    this.f2071c.f2100h.m2349a(arrayList2);
                    this.f2071c.f2101i.m2349a(arrayList3);
                }
            });
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.pick_lock_background, null);
        this.f2106n = (ViewPager) findViewById(R.id.pick_lock_background_pages);
        this.f2108p = new C1097a();
        this.f2107o = this.b.m65q();
        this.f2106n.addOnPageChangeListener(this.f2107o);
        this.f2107o.setVisibility(8);
        this.f2109q = findViewById(16908292);
        this.f2109q.setVisibility(0);
    }

    public boolean isFragmentWithoutActionBar() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            m2373c();
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            int f = m2368f();
            for (C1100d c1100d : new C1100d[]{this.f2100h, this.f2101i}) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) c1100d.m166i().getLayoutManager();
                if (f != staggeredGridLayoutManager.getSpanCount()) {
                    staggeredGridLayoutManager.setSpanCount(f);
                    c1100d.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_theme_picker);
        this.f2100h = new C1100d(this, this.mActivity, null);
        this.f2101i = new C1100d(this, this.mActivity, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.density <= 1.0f) {
            this.f2102j = "_m";
        } else if (((double) displayMetrics.density) <= 1.5d) {
            this.f2102j = "_h";
        } else if (displayMetrics.density <= 2.0f) {
            this.f2102j = "_x";
        }
        try {
            this.f2110r = new ThemeBean(this.mActivity.getPackageManager(), new JSONObject("{\"name\": \"Default\",\"pic\": \"\",\"package\": \"com.domobile.applock\",\"size\": \"1024\",\"version\": \"20130922\",\"applock_version\": \"2013092201\"}"), this.f2102j);
        } catch (Exception e) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.mActivity.registerReceiver(this.f2097a, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.applock.ACTION_STARTUP_THEME_SUCCESS");
        this.mActivity.registerReceiver(this.f2097a, intentFilter);
        this.mActionBar.m3010d(true);
        this.mActionBar.m3000a(new C10861(this));
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.theme_picker_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        C1148d.m2509a(this.mActivity, this.f2097a);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_theme_picker_unlock_background) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.b.m80e();
        startActivity(AgentActivity.m570a(this.mActivity, 295));
        return true;
    }

    public void onPageSelected(int i) {
        ViewCompat.animate(this.b.m67s()).translationY(0.0f).setDuration(300).start();
    }

    public void onResume() {
        super.onResume();
        this.b.m56b(R.string.themes_picker);
        if (this.f2103k) {
            if (!this.f2104l && this.f2105m) {
                this.f2109q.setVisibility(0);
                C1148d.m2516a(new C1276e(), new C1099c());
            }
        } else if (!this.f2104l) {
            this.f2109q.setVisibility(0);
            C1148d.m2516a(new C1276e(), new C1099c());
        }
        if (this.f2103k && this.f2106n.getAdapter() == null) {
            this.f2106n.setAdapter(this.f2108p);
        }
        if (this.f2106n.getAdapter() != null) {
            this.f2107o.setViewPager(this.f2106n);
            this.f2107o.setVisibility(0);
        } else {
            this.f2107o.setVisibility(8);
        }
        this.f2106n.addOnPageChangeListener(this);
        this.f2106n.addOnPageChangeListener(this.f2107o);
        ViewCompat.setTranslationY(this.b.m67s(), 0.0f);
    }

    public void ui(int i, Message message) {
    }
}
