package com.domobile.applock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnCloseListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.domobile.applock.adapter.C0653c;
import com.domobile.applock.aj.C0721a;
import com.domobile.applock.p003a.C0621h;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.receiver.AppLockDeviceAdminReceiver;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0655a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1279a;
import com.domobile.libs_ads.C1342b;
import com.domobile.lockbean.C1370i;
import com.domobile.lockbean.C1371j;
import com.domobile.lockbean.Scene;
import com.domobile.widget.AppLockSwitch;
import com.domobile.widget.OverscrollRecyclerView;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class C1026o extends C0400d implements OnCloseListener, OnQueryTextListener, OnMenuItemClickListener, C0655a {
    private ArrayList<Scene> f1818A;
    private OnClickListener f1819B = new C10214(this);
    private BroadcastReceiver f1820C = new C10225(this);
    private OnCheckedChangeListener f1821D = new C10256(this);
    C1279a f1822a;
    byte[] f1823e = new byte[1];
    public boolean f1824f = false;
    private LayoutInflater f1825g;
    private DevicePolicyManager f1826h;
    private PackageManager f1827i;
    private boolean f1828j;
    private ComponentName f1829k;
    private C1150y f1830l;
    private OverscrollRecyclerView f1831m;
    private LinearLayoutManager f1832n;
    private SwipeRefreshLayout f1833o;
    private C1370i f1834p;
    private C1370i f1835q;
    private ArrayList<C1370i> f1836r = new ArrayList();
    private ArrayList<C1370i> f1837s = new ArrayList();
    private ArrayList<C1370i> f1838t = new ArrayList();
    private ArrayList<C1370i> f1839u = new ArrayList();
    private ArrayList<C1370i> f1840v = new ArrayList();
    private ArrayList<C1370i> f1841w = new ArrayList();
    private ArrayList<C1370i> f1842x = new ArrayList();
    private ArrayList<C1371j> f1843y = new ArrayList();
    private C0653c f1844z;

    class C10181 implements OnRefreshListener {
        final /* synthetic */ C1026o f1806a;

        C10181(C1026o c1026o) {
            this.f1806a = c1026o;
        }

        public void onRefresh() {
            this.f1806a.m2063b(3);
        }
    }

    class C10192 implements OnGlobalLayoutListener {
        final /* synthetic */ C1026o f1807a;

        C10192(C1026o c1026o) {
            this.f1807a = c1026o;
        }

        public void onGlobalLayout() {
            try {
                C1148d.m2515a(this.f1807a.f1831m.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                this.f1807a.m2064c();
            } catch (Exception e) {
            }
        }
    }

    class C10214 implements OnClickListener {
        final /* synthetic */ C1026o f1810a;

        C10214(C1026o c1026o) {
            this.f1810a = c1026o;
        }

        public void onClick(View view) {
            int id = view.getId();
            this.f1810a.b.m80e();
            if (id == R.id.locker_media_safe) {
                this.f1810a.startActivity(AgentActivity.m570a(this.f1810a.mActivity, 304));
            } else if (id == R.id.locker_backroom) {
                this.f1810a.startActivity(AgentActivity.m570a(this.f1810a.mActivity, 305));
            } else if (id == R.id.locker_header_more) {
                this.f1810a.startActivity(AgentActivity.m570a(this.f1810a.mActivity, 291));
            }
        }
    }

    class C10225 extends BroadcastReceiver {
        final /* synthetic */ C1026o f1811a;

        C10225(C1026o c1026o) {
            this.f1811a = c1026o;
        }

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "com.domobile.applock.ACTION_ACTIVED_PROFILE")) {
                this.f1811a.m2063b(3);
            } else if (!TextUtils.equals(intent.getAction(), "com.domobile.applock.ACTION_ADS_RECOMMEND_CHANGED")) {
            }
        }
    }

    class C10256 implements OnCheckedChangeListener {
        final /* synthetic */ C1026o f1817a;

        C10256(C1026o c1026o) {
            this.f1817a = c1026o;
        }

        public void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
            if (((AppLockSwitch) compoundButton).m3528a()) {
                final C1370i c1370i = (C1370i) compoundButton.getTag();
                int intValue;
                if (z && "com.domobile.notification".equals(c1370i.f2953c) && MainTabFragmentActivity.m631b(this.f1817a.b)) {
                    try {
                        intValue = ((Integer) compoundButton.getTag(R.id.tag_object)).intValue();
                        this.f1817a.f1844z.notifyItemChanged(intValue);
                        this.f1817a.f1834p = this.f1817a.f1844z.m788a(intValue);
                    } catch (Exception e) {
                    }
                } else if (z && MainTabFragmentActivity.m628a(this.f1817a.b)) {
                    try {
                        intValue = ((Integer) compoundButton.getTag(R.id.tag_object)).intValue();
                        this.f1817a.f1844z.notifyItemChanged(intValue);
                        this.f1817a.f1834p = this.f1817a.f1844z.m788a(intValue);
                    } catch (Exception e2) {
                    }
                } else if (!z && LockService.f1931a && "com.android.settings".equals(c1370i.f2953c)) {
                    C1150y.m2570a(this.f1817a.b, new OnClickListener(this) {
                        final /* synthetic */ C10256 f1813b;

                        public void onClick(View view) {
                            compoundButton.setChecked(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ C10256 f1816c;

                        public void onClick(View view) {
                            this.f1816c.f1817a.m2048a(compoundButton, c1370i);
                        }
                    });
                } else {
                    this.f1817a.m2048a(compoundButton, c1370i);
                }
            }
        }
    }

    public static List<C1370i> m2045a(Context context) {
        List<C1370i> arrayList = new ArrayList();
        String F = C1148d.m2494F(context, "switcher_lock.json");
        Resources resources = context.getResources();
        try {
            JSONArray jSONArray = new JSONArray(F);
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    C0721a c0721a = new C0721a(jSONArray.getJSONObject(i), context);
                    if (C1150y.O <= 19 || !"key_locked_2g3g_state".equals(c0721a.f902d)) {
                        C1370i c1370i = new C1370i(false);
                        c1370i.f2951a = R.string.desc_switcher_lock;
                        Drawable drawable = (BitmapDrawable) C1148d.m2502a(resources, c0721a.f899a).mutate();
                        drawable.setColorFilter(ResourcesCompat.getColor(resources, R.color.sliding_left_menu_item_icon_tintcolor, null), Mode.SRC_ATOP);
                        c1370i.m3454a(drawable);
                        c1370i.m3453a(2);
                        c1370i.f2953c = c0721a.f902d;
                        c1370i.f2955e = c0721a.f903e;
                        c1370i.f2952b = c0721a.f900b;
                        arrayList.add(c1370i);
                        i++;
                    } else {
                        i++;
                    }
                } catch (Exception e) {
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            Collections.sort(arrayList, C1370i.m3450c());
        } catch (Exception e3) {
        }
        return arrayList;
    }

    public static void m2046a(Activity activity, PackageManager packageManager, ArrayList<C1370i> arrayList, ArrayList<C1371j> arrayList2) {
        C1370i c1370i;
        boolean z = false;
        if (C1150y.O >= 18) {
            c1370i = new C1370i(true);
            c1370i.m3454a(C1148d.m2502a(activity.getResources(), (int) R.drawable.icon_notification_lock_small));
            c1370i.f2952b = activity.getString(R.string.notification_lock_title);
            c1370i.f2953c = "com.domobile.notification";
            c1370i.f2954d = new ComponentName(c1370i.f2953c, c1370i.f2953c);
            boolean z2 = arrayList2.contains(new C1371j(c1370i.f2953c)) && C0898c.m1570b(activity);
            c1370i.f2955e = z2;
            c1370i.f2951a = R.string.notification_item_desc;
            arrayList.add(c1370i);
        }
        c1370i = new C1370i(true);
        if (C1150y.m2639k(activity, "com.android.packageinstaller")) {
            c1370i.f2953c = "com.android.packageinstaller";
            c1370i.f2955e = arrayList2.contains(new C1371j(c1370i.f2953c));
        } else {
            c1370i.f2953c = "com.google.android.packageinstaller";
            if (arrayList2.contains(new C1371j("com.android.packageinstaller")) || arrayList2.contains(new C1371j(c1370i.f2953c))) {
                z = true;
            }
            c1370i.f2955e = z;
        }
        c1370i.f2952b = activity.getString(R.string.install_uninstall);
        c1370i.f2954d = new ComponentName(c1370i.f2953c, c1370i.f2953c);
        try {
            c1370i.m3454a(packageManager.getApplicationIcon(c1370i.f2953c));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        c1370i.f2951a = R.string.install_uninstall_info;
        try {
            C1370i c1370i2 = new C1370i(true);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.android.vending", 0);
            c1370i2.f2953c = "com.android.vending";
            c1370i2.m3454a(packageManager.getApplicationIcon(applicationInfo));
            c1370i2.f2952b = C1150y.m2575a((Context) activity, packageManager, applicationInfo);
            c1370i2.f2954d = new ComponentName(c1370i2.f2953c, c1370i2.f2953c);
            c1370i2.f2955e = arrayList2.contains(new C1371j(c1370i2.f2953c));
            c1370i2.f2951a = R.string.install_uninstall_info;
            arrayList.add(c1370i2);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            if (C1150y.O > 16 && !LockService.f1931a) {
                c1370i2 = new C1370i(true);
                applicationInfo = packageManager.getApplicationInfo("com.android.systemui", 0);
                c1370i2.f2953c = "com.android.systemui";
                c1370i2.m3454a(packageManager.getApplicationIcon(applicationInfo));
                c1370i2.f2952b = C1150y.m2575a((Context) activity, packageManager, applicationInfo);
                c1370i2.f2954d = new ComponentName(c1370i2.f2953c, c1370i2.f2953c);
                c1370i2.f2955e = arrayList2.contains(new C1371j(c1370i2.f2953c));
                c1370i2.f2951a = R.string.recent_activity_info;
                arrayList.add(c1370i2);
            }
        } catch (NameNotFoundException e22) {
            e22.printStackTrace();
        }
        try {
            c1370i2 = new C1370i(true);
            applicationInfo = packageManager.getApplicationInfo("com.sec.android.app.controlpanel", 0);
            c1370i2.f2953c = "com.sec.android.app.controlpanel";
            c1370i2.m3454a(packageManager.getApplicationIcon(applicationInfo));
            c1370i2.f2952b = C1150y.m2575a((Context) activity, packageManager, applicationInfo);
            c1370i2.f2954d = new ComponentName(c1370i2.f2953c, c1370i2.f2953c);
            c1370i2.f2955e = arrayList2.contains(new C1371j(c1370i2.f2953c));
            c1370i2.f2951a = R.string.app_details_info;
            arrayList.add(c1370i2);
        } catch (NameNotFoundException e3) {
        }
    }

    private void m2047a(RecyclerView recyclerView) {
        try {
            recyclerView.stopScroll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m2048a(CompoundButton compoundButton, C1370i c1370i) {
        C1148d.m2534y(this.mActivity, "actived_profile");
        if (!(this.f1830l.f2238w && LockService.m2172a())) {
            this.f1830l.m2665a(this.mActivity, true);
        }
        String str = c1370i.f2952b;
        c1370i.f2955e = !c1370i.f2955e;
        if (c1370i.f2954d == null) {
            C0721a.m995a(this.mActivity, c1370i.f2953c, c1370i.f2955e);
        } else {
            m2061a(c1370i.f2953c, c1370i.f2955e, c1370i.f2956f);
            String str2 = str;
            for (int i = 0; i < this.f1840v.size(); i++) {
                C1370i c1370i2 = (C1370i) this.f1840v.get(i);
                if (c1370i2.f2953c.equals(c1370i.f2953c) && c1370i2.f2955e != c1370i.f2955e) {
                    c1370i2.f2955e = c1370i.f2955e;
                    str2 = C1147a.m2480a(str2, ", ", c1370i2.f2952b);
                }
            }
            str = str2;
        }
        C1147a.m2487w(this.mActivity, this.f1844z.m789a(c1370i.f2955e, str));
        try {
            this.f1844z.m794b(((Integer) compoundButton.getTag(R.id.tag_object)).intValue());
        } catch (Exception e) {
        }
    }

    private void m2050a(boolean z) {
        this.mActionBar.m3008c(z);
        if (this.f1844z != null) {
            this.f1844z.m792a(z);
        }
    }

    private void m2056h() {
        boolean z = true;
        C1257b.m2966a(this.mActivity).m2980a(1);
        C0653c c0653c = this.f1844z;
        ArrayList arrayList = this.f1837s;
        ArrayList arrayList2 = this.f1839u;
        ArrayList arrayList3 = this.f1838t;
        if (this.f1840v.isEmpty()) {
            z = false;
        }
        c0653c.m791a(arrayList, arrayList2, arrayList3, z);
        if (this.f1831m.getAdapter() != this.f1844z) {
            this.f1831m.setAdapter(this.f1844z);
        } else {
            this.f1831m.m3555b();
        }
    }

    private void m2057i() {
        this.mActionBar.m3013f().getHeight();
        ViewCompat.animate(this.mActionBar.m3013f()).translationY(0.0f).setStartDelay(300).setDuration(300).start();
    }

    private List<C1370i> m2058j() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = this.f1827i.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return arrayList;
        }
        HashMap b = C1150y.m2566a(this.mActivity).m587b(this.mActivity);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            if (!(b.containsKey(str) || str.contains("com.domobile.applock") || C1150y.m2628g(str))) {
                C1370i c1370i = new C1370i(false);
                c1370i.f2952b = C1150y.m2576a(this.mActivity, this.f1827i, resolveInfo);
                c1370i.f2954d = new ComponentName(str, str2);
                c1370i.f2953c = str;
                c1370i.f2955e = this.f1843y.contains(new C1371j(c1370i.f2953c));
                if ((resolveInfo.activityInfo.applicationInfo.flags & 1) != 0) {
                    c1370i.f2951a = R.string.system_app;
                } else {
                    c1370i.f2951a = R.string.third_party_app;
                }
                arrayList.add(c1370i);
            }
        }
        try {
            Collections.sort(arrayList, C1370i.m3450c());
            if (C1150y.m2645n(this.b) && C1342b.m3335c(this.b) == 1) {
                C1370i c1370i2 = new C1370i(false);
                c1370i2.f2957g = true;
                if (arrayList.size() <= 1) {
                    arrayList.add(c1370i2);
                } else {
                    arrayList.add(1, c1370i2);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private List<C1370i> m2059k() {
        List<C1370i> arrayList = new ArrayList();
        C1370i c1370i = new C1370i(true);
        try {
            c1370i.m3454a(this.f1827i.getApplicationIcon("com.android.phone"));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        c1370i.f2952b = this.mActivity.getString(R.string.in_call);
        c1370i.f2953c = "com.android.phone";
        c1370i.f2954d = new ComponentName(c1370i.f2953c, c1370i.f2953c);
        c1370i.f2955e = C1150y.m2614c(this.mActivity, "incall_locked");
        c1370i.f2951a = R.string.in_call_desc;
        arrayList.add(c1370i);
        boolean c = C1150y.m2614c(this.mActivity, "appdetail_locked");
        try {
            C1370i c1370i2 = new C1370i(true);
            ApplicationInfo applicationInfo = this.f1827i.getApplicationInfo("com.android.settings", 0);
            c1370i2.f2953c = "com.android.settings";
            c1370i2.f2952b = C1150y.m2575a(this.mActivity, this.f1827i, applicationInfo);
            c1370i2.f2954d = new ComponentName(c1370i2.f2953c, c1370i2.f2953c);
            c1370i2.m3454a(this.f1827i.getApplicationIcon(applicationInfo));
            c1370i2.f2951a = R.string.app_details_info;
            boolean z = this.f1843y.contains(new C1371j(c1370i2.f2953c)) || c;
            c1370i2.f2955e = z;
            if (c) {
                m2061a(c1370i2.f2953c, true, true);
                C1148d.m2534y(this.mActivity, "appdetail_locked");
            }
            this.f1835q = c1370i2;
            arrayList.add(c1370i2);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        C1026o.m2046a(this.mActivity, this.f1827i, arrayList, this.f1843y);
        try {
            Collections.sort(arrayList, C1370i.m3450c());
        } catch (Exception e3) {
        }
        return arrayList;
    }

    public void mo2402a() {
        m2050a(true);
        this.f1831m.m3552a();
    }

    public void m2061a(String str, boolean z, boolean z2) {
        if (z2) {
            if (str.equals("com.android.phone")) {
                C1150y.m2582a(this.mActivity, "incall_locked", Boolean.valueOf(z));
            } else if (z) {
                C1017n.m2035a(str, 0);
            } else {
                C1017n.m2037a(str);
                if ("com.google.android.packageinstaller".equals(str)) {
                    C1017n.m2037a("com.android.packageinstaller");
                }
            }
        } else if (z) {
            C1017n.m2035a(str, 1);
            if (C1150y.O >= 19 && "com.android.providers.downloads.ui".equals(str)) {
                C1017n.m2035a("com.android.documentsui", 1);
            }
        } else {
            C1017n.m2037a(str);
            if (C1150y.O >= 19 && "com.android.providers.downloads.ui".equals(str)) {
                C1017n.m2037a("com.android.documentsui");
            }
        }
        this.f1824f = true;
    }

    public void m2062b() {
        if (getActionBarHelper() != null && getActionBarHelper().getSearchItem() != null) {
            getActionBarHelper().setActionBarController(this);
            SearchView searchView = getActionBarHelper().getSearchView();
            searchView.setQueryHint(this.mActivity.getString(R.string.domo_search));
            searchView.setOnQueryTextListener(this);
        }
    }

    public void m2063b(final int i) {
        new Thread(this) {
            final /* synthetic */ C1026o f1809b;

            public void run() {
                synchronized (this.f1809b.f1823e) {
                    if (i != 2) {
                        this.f1809b.m2066e();
                        this.f1809b.f1841w = (ArrayList) this.f1809b.m2059k();
                        this.f1809b.f1842x = (ArrayList) C1026o.m2045a(this.f1809b.mActivity);
                    }
                    if (i != 1) {
                        this.f1809b.f1840v = (ArrayList) this.f1809b.m2058j();
                    }
                    this.f1809b.call(6);
                }
            }
        }.start();
    }

    void m2064c() {
        View m = MainTabFragmentActivity.m633l().m643m();
        this.f1831m.m3553a(this.b.m66r().getHeight(), m);
        this.f1833o.setProgressViewOffset(false, (int) (((double) m.getHeight()) * 0.5d), (int) (((double) m.getHeight()) * 1.2d));
        ViewCompat.setTranslationY(this.mActionBar.m3013f(), ((float) this.mActionBar.m3013f().getHeight()) * 1.2f);
        if (!this.f1828j) {
            this.f1828j = true;
            m2063b(1);
        }
    }

    public void m2065d() {
        this.f1837s.clear();
        this.f1838t.clear();
        this.f1839u.clear();
        this.f1837s.addAll(this.f1841w);
        this.f1838t.addAll(this.f1840v);
        this.f1839u.addAll(this.f1842x);
        m2056h();
        if (this.f1840v.isEmpty()) {
            callDelayed(7, 150);
        } else {
            C1370i c1370i;
            this.f1836r.clear();
            Iterator it = this.f1841w.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2955e) {
                    this.f1836r.add(c1370i);
                }
            }
            it = this.f1842x.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2955e) {
                    this.f1836r.add(c1370i);
                }
            }
            it = this.f1840v.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2955e) {
                    this.f1836r.add(c1370i);
                }
            }
            callDelayed(8, 500);
        }
        this.f1833o.setRefreshing(false);
    }

    public void m2066e() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0017 in list [B:8:0x0014]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.f1843y;
        r0.clear();
        r1 = 0;
        r1 = com.domobile.applock.C1017n.m2032a();	 Catch:{ all -> 0x0053 }
        if (r1 == 0) goto L_0x0012;	 Catch:{ all -> 0x0053 }
    L_0x000c:
        r0 = r1.getCount();	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0018;
    L_0x0012:
        if (r1 == 0) goto L_0x0017;
    L_0x0014:
        r1.close();
    L_0x0017:
        return;
    L_0x0018:
        r0 = r1.moveToNext();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x005a;	 Catch:{ all -> 0x0053 }
    L_0x001e:
        r0 = new com.domobile.lockbean.j;	 Catch:{ all -> 0x0053 }
        r0.<init>();	 Catch:{ all -> 0x0053 }
        r2 = 0;	 Catch:{ all -> 0x0053 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0053 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ all -> 0x0053 }
    L_0x002a:
        r2 = 0;	 Catch:{ all -> 0x0053 }
        r2 = r1.getInt(r2);	 Catch:{ all -> 0x0053 }
        r0.f2960a = r2;	 Catch:{ all -> 0x0053 }
    L_0x0031:
        r2 = 1;	 Catch:{ all -> 0x0053 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0053 }
        if (r2 == 0) goto L_0x003f;	 Catch:{ all -> 0x0053 }
    L_0x0038:
        r2 = 1;	 Catch:{ all -> 0x0053 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0053 }
        r0.f2962c = r2;	 Catch:{ all -> 0x0053 }
    L_0x003f:
        r2 = 2;	 Catch:{ all -> 0x0053 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0053 }
        if (r2 == 0) goto L_0x004d;	 Catch:{ all -> 0x0053 }
    L_0x0046:
        r2 = 2;	 Catch:{ all -> 0x0053 }
        r2 = r1.getInt(r2);	 Catch:{ all -> 0x0053 }
        r0.f2961b = r2;	 Catch:{ all -> 0x0053 }
    L_0x004d:
        r2 = r3.f1843y;	 Catch:{ all -> 0x0053 }
        r2.add(r0);	 Catch:{ all -> 0x0053 }
        goto L_0x0018;
    L_0x0053:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();
    L_0x0059:
        throw r0;
    L_0x005a:
        if (r1 == 0) goto L_0x0017;
    L_0x005c:
        r1.close();
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.o.e():void");
    }

    public void mo2386f() {
        this.b.i.setDrawerListener(null);
        this.b.j.syncState();
        if (this.b.i.isDrawerOpen(3) || this.b.i.isDrawerOpen(5)) {
            this.b.i.closeDrawers();
        }
        m2050a(false);
    }

    public void mo2387g() {
        this.b.i.addDrawerListener(this.b.j);
        this.b.j.syncState();
        m2050a(true);
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1822a = new C1279a(this.mActivity);
        getMenuInflater().inflate(R.menu.lock_toolbar_menus, this.f1822a);
        this.mActionBar.m3005b(this.f1822a, 0, this);
        this.rootView = layoutInflater.inflate(R.layout.fragment_locker, null);
        this.f1833o = (SwipeRefreshLayout) findViewById(R.id.locker_swipe_refresh);
        this.f1833o.setOnRefreshListener(new C10181(this));
        m110a(this.f1833o);
        this.f1831m = (OverscrollRecyclerView) findViewById(R.id.main_list);
        this.f1832n = new NpaLinearLayoutManager(this.mActivity);
        this.f1831m.setLayoutManager(this.f1832n);
        this.f1831m.setHasFixedSize(true);
        this.f1844z = new C0653c(this.b, this.f1819B, this.f1821D);
        this.f1831m.setAdapter(this.f1844z);
        this.f1831m.m3555b();
        this.f1831m.getViewTreeObserver().addOnGlobalLayoutListener(new C10192(this));
    }

    public boolean isShowOptionsMenu() {
        return false;
    }

    public boolean onClose() {
        try {
            Collections.sort(this.f1841w, C1370i.m3450c());
            Collections.sort(this.f1842x, C1370i.m3450c());
            Collections.sort(this.f1840v, C1370i.m3450c());
        } catch (Exception e) {
        }
        this.f1837s.clear();
        this.f1838t.clear();
        this.f1839u.clear();
        this.f1837s.addAll(this.f1841w);
        this.f1839u.addAll(this.f1842x);
        this.f1838t.addAll(this.f1840v);
        m2056h();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1825g = LayoutInflater.from(this.mActivity);
        this.f1826h = (DevicePolicyManager) C1150y.m2640l(this.mActivity, "device_policy");
        this.f1829k = new ComponentName(this.mActivity, AppLockDeviceAdminReceiver.class);
        this.f1827i = this.mActivity.getPackageManager();
        this.f1830l = C1150y.m2598b(this.mActivity);
        C1150y.m2605b(this.mActivity, (int) R.string.event_lock);
    }

    public void onDestroy() {
        super.onDestroy();
        C1148d.m2509a(this.mActivity, this.f1820C);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        ((MainTabFragmentActivity) this.mActivity).m80e();
        switch (itemId) {
            case R.id.main_toolbar_menu_profile:
                startActivity(AgentActivity.m570a(this.mActivity, 260));
                break;
            case R.id.main_toolbar_menu_new_profile:
                Intent intent = new Intent(this.mActivity, ScenesEditorActivity.class);
                intent.putExtra("com.domobile.applock.EXTRA_COPY_FROM_LOCKING", true);
                startActivity(intent);
                break;
            case R.id.main_toolbar_menu_timer:
                startActivity(AgentActivity.m570a(this.mActivity, 261));
                break;
            case R.id.main_toolbar_menu_location:
                startActivity(AgentActivity.m570a(this.mActivity, 262));
                break;
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super.onPause();
        if (this.f1824f) {
            C1148d.m2489A(this.mActivity, "com.domobile.elock.proctect_list_change");
        }
    }

    public boolean onQueryTextChange(String str) {
        this.f1831m.m3552a();
        m2047a(this.f1831m);
        this.f1837s.clear();
        this.f1839u.clear();
        this.f1838t.clear();
        if (TextUtils.isEmpty(str)) {
            this.f1837s.addAll(this.f1841w);
            this.f1839u.addAll(this.f1842x);
            this.f1838t.addAll(this.f1840v);
        } else {
            C1370i c1370i;
            Iterator it = this.f1841w.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(str.toUpperCase())) {
                    this.f1837s.add(c1370i);
                }
            }
            it = this.f1842x.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(str.toUpperCase())) {
                    this.f1839u.add(c1370i);
                }
            }
            it = this.f1840v.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(str.toUpperCase())) {
                    this.f1838t.add(c1370i);
                }
            }
        }
        m2056h();
        return false;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }

    public void onResume() {
        super.onResume();
        this.f1818A = null;
        callDelayed(9, 300);
        if (this.mActivity instanceof MainTabFragmentActivity) {
            C0621h n = ((MainTabFragmentActivity) this.mActivity).m644n();
            ArrayList a = n.m732a(this.mActivity, "applock");
            if (this.f1844z != null) {
                this.f1844z.m790a(n, a);
            }
        }
        if (this.f1828j) {
            m2063b(3);
        }
        if (this.f1826h != null) {
            this.f1830l.f2239x = this.f1826h.isAdminActive(this.f1829k);
        }
        if (this.f1834p == null || !"com.domobile.notification".equals(this.f1834p.f2953c)) {
            if (LockService.f1931a) {
                boolean R = C1150y.m2553R(this.mActivity);
                if (R && this.f1834p != null) {
                    m2061a(this.f1834p.f2953c, true, this.f1834p.f2956f);
                    this.f1834p.f2955e = true;
                    this.f1844z.notifyDataSetChanged();
                    this.f1834p = null;
                }
                if (this.f1835q != null && ((this.f1830l.f2239x || R) && !C1150y.m2614c(this.mActivity, "auto_lock_settings_success"))) {
                    m2061a("com.android.settings", true, true);
                    this.f1835q.f2955e = true;
                    this.f1844z.notifyDataSetChanged();
                    C1148d.m2520b(this.mActivity, "auto_lock_settings_success", (Object) Boolean.valueOf(true));
                }
            }
            if (this.f1844z != null) {
                this.f1844z.m793b();
                return;
            }
            return;
        }
        if (C0898c.m1570b(this.mActivity)) {
            m2061a(this.f1834p.f2953c, true, this.f1834p.f2956f);
            this.f1834p.f2955e = true;
            this.f1844z.notifyDataSetChanged();
        }
        this.f1834p = null;
    }

    public void onStart() {
        super.onStart();
    }

    public void ui(int i, Message message) {
        switch (i) {
            case 1:
                hideLoadingDialog_mt();
                return;
            case 6:
                m2065d();
                return;
            case 7:
                m2063b(2);
                return;
            case 8:
                m2057i();
                return;
            case 9:
                if (C1148d.m2499a(this.mActivity, "enable_power_saving_warning_type", 2) == 1) {
                    ((MainTabFragmentActivity) this.b).m640h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
