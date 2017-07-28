package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.domobile.applock.adapter.PluginsListAdapter;
import com.domobile.applock.theme.C1102c;
import com.domobile.frame.C0384c;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginsPagerSimpleFragment extends C0400d {
    BroadcastReceiver f528a = new C06031(this);
    private PackageManager f529e;
    private HashMap<String, PluginBean> f530f = new HashMap();
    private boolean f531g = false;
    private boolean f532h = false;
    private boolean f533i = true;
    private View f534j;
    private PluginsListAdapter f535k;

    class C06031 extends BroadcastReceiver {
        final /* synthetic */ PluginsPagerSimpleFragment f506a;

        C06031(PluginsPagerSimpleFragment pluginsPagerSimpleFragment) {
            this.f506a = pluginsPagerSimpleFragment;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                try {
                    CharSequence replace = intent.getData().toString().replace("package:", "");
                    if (!TextUtils.isEmpty(replace) && this.f506a.f530f.get(replace) != null) {
                        ((PluginBean) this.f506a.f530f.get(replace)).m653a(this.f506a.f529e);
                        this.f506a.f535k.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class PluginBean implements Parcelable {
        public static final Creator<PluginBean> CREATOR = new C06041();
        public static final String PLUGINS_JSON_FILE = "plugins_json_demo.json";
        public String f507a;
        public String f508b;
        public String f509c;
        public String f510d;
        public String f511e;
        public long f512f;
        public long f513g;
        public boolean f514h;
        public int f515i;
        public String f516j;
        public double f517k;
        public String f518l;
        public String f519m;
        public boolean f520n;
        public int f521o;
        public boolean f522p = false;

        static class C06041 implements Creator<PluginBean> {
            C06041() {
            }

            public PluginBean m649a(Parcel parcel) {
                return new PluginBean(parcel);
            }

            public PluginBean[] m650a(int i) {
                return new PluginBean[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m649a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m650a(i);
            }
        }

        public PluginBean(Context context, PackageManager packageManager, JSONObject jSONObject) {
            String string = context.getString(R.string.language_values);
            if (jSONObject.has(string)) {
                this.f508b = jSONObject.optString(string);
            } else {
                this.f508b = jSONObject.optString("values");
            }
            this.f507a = jSONObject.optString("desc");
            this.f510d = jSONObject.optString("package");
            this.f512f = jSONObject.optLong("version");
            this.f513g = jSONObject.optLong("applock_version");
            this.f514h = m653a(packageManager);
            this.f509c = jSONObject.optString("icon");
            this.f515i = jSONObject.optInt("can_open", 1);
            this.f511e = jSONObject.optString("class_name");
            this.f516j = jSONObject.optString("price");
            this.f517k = jSONObject.optDouble("rate");
            this.f518l = jSONObject.optString("developer");
            this.f519m = jSONObject.optString("pic");
        }

        public PluginBean(Parcel parcel) {
            boolean z = true;
            this.f507a = parcel.readString();
            this.f508b = parcel.readString();
            this.f509c = parcel.readString();
            this.f510d = parcel.readString();
            this.f512f = parcel.readLong();
            this.f513g = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f514h = z;
            this.f515i = parcel.readInt();
            this.f511e = parcel.readString();
            this.f516j = parcel.readString();
            this.f517k = parcel.readDouble();
            this.f518l = parcel.readString();
            this.f519m = parcel.readString();
        }

        public PluginBean(boolean z) {
            this.f522p = z;
        }

        public static String m651a(Context context) {
            try {
                return C3613c.m15742f(new File(context.getFilesDir(), PLUGINS_JSON_FILE));
            } catch (Exception e) {
                return C1148d.m2494F(context, PLUGINS_JSON_FILE);
            }
        }

        public static void m652a(Context context, String str) {
            try {
                C1148d.m2518a(str, new File(context.getFilesDir(), PLUGINS_JSON_FILE).getAbsolutePath());
            } catch (Exception e) {
            }
        }

        public boolean m653a(PackageManager packageManager) {
            this.f514h = C1102c.m2394a(packageManager, this.f510d);
            return this.f514h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f507a);
            parcel.writeString(this.f508b);
            parcel.writeString(this.f509c);
            parcel.writeString(this.f510d);
            parcel.writeLong(this.f512f);
            parcel.writeLong(this.f513g);
            parcel.writeInt(this.f514h ? 1 : 0);
            parcel.writeInt(this.f515i);
            parcel.writeString(this.f511e);
            parcel.writeString(this.f516j);
            parcel.writeDouble(this.f517k);
            parcel.writeString(this.f518l);
            parcel.writeString(this.f519m);
        }
    }

    public static class C0605a {
        public String f523a = "";
        public ArrayList<PluginBean> f524b;
    }

    private class C0608b implements C0607f {
        final /* synthetic */ PluginsPagerSimpleFragment f527a;

        private C0608b(PluginsPagerSimpleFragment pluginsPagerSimpleFragment) {
            this.f527a = pluginsPagerSimpleFragment;
        }

        public C1275d mo2363a() {
            this.f527a.f532h = true;
            return new C1275d(C1147a.m2480a("https://www.domobile.com/", "apps/store/", "com.domobile.applock", ".json"), "utf-8");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2364a(java.lang.String r5) {
            /*
            r4 = this;
            r3 = 8;
            r2 = 1;
            r0 = r4.f527a;
            r1 = 0;
            r0.f532h = r1;
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0030, all -> 0x004a }
            r0.<init>(r5);	 Catch:{ Exception -> 0x0030, all -> 0x004a }
            r0 = r4.f527a;	 Catch:{ Exception -> 0x0030, all -> 0x004a }
            r0 = r0.mActivity;	 Catch:{ Exception -> 0x0030, all -> 0x004a }
            com.domobile.applock.PluginsPagerSimpleFragment.PluginBean.m652a(r0, r5);	 Catch:{ Exception -> 0x0030, all -> 0x004a }
        L_0x0015:
            r0 = r4.f527a;	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r0 = r0.mHandler;	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r1 = new com.domobile.applock.PluginsPagerSimpleFragment$b$1;	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r1.<init>(r4, r5);	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r0.post(r1);	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r0 = r4.f527a;
            r0.f531g = r2;
            r0 = r4.f527a;
            r0 = r0.f534j;
            r0.setVisibility(r3);
        L_0x002f:
            return;
        L_0x0030:
            r0 = move-exception;
            r0 = r4.f527a;	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r0 = r0.mActivity;	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            r5 = com.domobile.applock.PluginsPagerSimpleFragment.PluginBean.m651a(r0);	 Catch:{ Exception -> 0x003a, all -> 0x004a }
            goto L_0x0015;
        L_0x003a:
            r0 = move-exception;
            r0 = r4.f527a;
            r0.f531g = r2;
            r0 = r4.f527a;
            r0 = r0.f534j;
            r0.setVisibility(r3);
            goto L_0x002f;
        L_0x004a:
            r0 = move-exception;
            r1 = r4.f527a;
            r1.f531g = r2;
            r1 = r4.f527a;
            r1 = r1.f534j;
            r1.setVisibility(r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.PluginsPagerSimpleFragment.b.a(java.lang.String):void");
        }
    }

    private void m660a(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        PackageManager packageManager;
        ArrayList arrayList;
        C0605a c0605a;
        JSONArray jSONArray;
        int i;
        PluginBean pluginBean;
        PluginBean pluginBean2;
        JSONArray jSONArray2;
        int i2;
        C0605a c0605a2;
        String string;
        JSONArray jSONArray3;
        PluginBean pluginBean3;
        try {
            jSONObject = new JSONObject(str);
            try {
                this.f533i = false;
                jSONObject2 = jSONObject;
            } catch (Exception e) {
                jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    this.f534j.setVisibility(8);
                    return;
                }
                try {
                    packageManager = this.mActivity.getPackageManager();
                    arrayList = new ArrayList();
                    c0605a = new C0605a();
                    c0605a.f524b = new ArrayList();
                    jSONArray = jSONObject2.getJSONArray("recommends");
                    for (i = 0; i < jSONArray.length(); i++) {
                        pluginBean = new PluginBean(this.mActivity, packageManager, jSONArray.optJSONObject(i));
                        if (this.f530f.containsKey(pluginBean.f510d)) {
                            c0605a.f524b.add(pluginBean);
                            this.f530f.put(pluginBean.f510d, pluginBean);
                        }
                    }
                    pluginBean2 = new PluginBean(true);
                    if (c0605a.f524b.size() > 1) {
                        c0605a.f524b.add(1, pluginBean2);
                    } else {
                        c0605a.f524b.add(pluginBean2);
                    }
                    arrayList.add(c0605a);
                    jSONArray2 = jSONObject2.getJSONArray("categories");
                    for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                        jSONObject = jSONArray2.getJSONObject(i2);
                        c0605a2 = new C0605a();
                        c0605a2.f524b = new ArrayList();
                        string = this.mActivity.getString(R.string.language_values);
                        if (jSONObject.has(string)) {
                            c0605a2.f523a = jSONObject.optString(string);
                        } else {
                            c0605a2.f523a = jSONObject.optString("values");
                        }
                        jSONArray3 = jSONObject.getJSONArray("apps");
                        for (i = 0; i < jSONArray3.length(); i++) {
                            pluginBean3 = new PluginBean(this.mActivity, packageManager, jSONArray3.optJSONObject(i));
                            if (this.f530f.containsKey(pluginBean3.f510d)) {
                                c0605a2.f524b.add(pluginBean3);
                                this.f530f.put(pluginBean3.f510d, pluginBean3);
                            }
                        }
                        pluginBean2 = new PluginBean(true);
                        if (c0605a2.f524b.size() > 3) {
                            c0605a2.f524b.add(3, pluginBean2);
                        } else {
                            c0605a2.f524b.add(pluginBean2);
                        }
                        arrayList.add(c0605a2);
                    }
                    this.f535k.m865a(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                } finally {
                    this.f534j.setVisibility(8);
                }
            }
        } catch (Exception e3) {
            jSONObject = null;
            jSONObject2 = jSONObject;
            if (jSONObject2 == null) {
                packageManager = this.mActivity.getPackageManager();
                arrayList = new ArrayList();
                c0605a = new C0605a();
                c0605a.f524b = new ArrayList();
                jSONArray = jSONObject2.getJSONArray("recommends");
                for (i = 0; i < jSONArray.length(); i++) {
                    pluginBean = new PluginBean(this.mActivity, packageManager, jSONArray.optJSONObject(i));
                    if (this.f530f.containsKey(pluginBean.f510d)) {
                        c0605a.f524b.add(pluginBean);
                        this.f530f.put(pluginBean.f510d, pluginBean);
                    }
                }
                pluginBean2 = new PluginBean(true);
                if (c0605a.f524b.size() > 1) {
                    c0605a.f524b.add(pluginBean2);
                } else {
                    c0605a.f524b.add(1, pluginBean2);
                }
                arrayList.add(c0605a);
                jSONArray2 = jSONObject2.getJSONArray("categories");
                for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                    jSONObject = jSONArray2.getJSONObject(i2);
                    c0605a2 = new C0605a();
                    c0605a2.f524b = new ArrayList();
                    string = this.mActivity.getString(R.string.language_values);
                    if (jSONObject.has(string)) {
                        c0605a2.f523a = jSONObject.optString("values");
                    } else {
                        c0605a2.f523a = jSONObject.optString(string);
                    }
                    jSONArray3 = jSONObject.getJSONArray("apps");
                    for (i = 0; i < jSONArray3.length(); i++) {
                        pluginBean3 = new PluginBean(this.mActivity, packageManager, jSONArray3.optJSONObject(i));
                        if (this.f530f.containsKey(pluginBean3.f510d)) {
                            c0605a2.f524b.add(pluginBean3);
                            this.f530f.put(pluginBean3.f510d, pluginBean3);
                        }
                    }
                    pluginBean2 = new PluginBean(true);
                    if (c0605a2.f524b.size() > 3) {
                        c0605a2.f524b.add(pluginBean2);
                    } else {
                        c0605a2.f524b.add(3, pluginBean2);
                    }
                    arrayList.add(c0605a2);
                }
                this.f535k.m865a(arrayList);
            }
            this.f534j.setVisibility(8);
            return;
        }
        if (jSONObject2 == null) {
            this.f534j.setVisibility(8);
            return;
        }
        packageManager = this.mActivity.getPackageManager();
        arrayList = new ArrayList();
        c0605a = new C0605a();
        c0605a.f524b = new ArrayList();
        jSONArray = jSONObject2.getJSONArray("recommends");
        for (i = 0; i < jSONArray.length(); i++) {
            pluginBean = new PluginBean(this.mActivity, packageManager, jSONArray.optJSONObject(i));
            if (this.f530f.containsKey(pluginBean.f510d)) {
                c0605a.f524b.add(pluginBean);
                this.f530f.put(pluginBean.f510d, pluginBean);
            }
        }
        if ((C1342b.m3337d(this.b) == 0 || C1342b.m3337d(this.b) == 1) && C1150y.m2645n(this.mActivity)) {
            pluginBean2 = new PluginBean(true);
            if (c0605a.f524b.size() > 1) {
                c0605a.f524b.add(1, pluginBean2);
            } else {
                c0605a.f524b.add(pluginBean2);
            }
        }
        arrayList.add(c0605a);
        jSONArray2 = jSONObject2.getJSONArray("categories");
        for (i2 = 0; i2 < jSONArray2.length(); i2++) {
            jSONObject = jSONArray2.getJSONObject(i2);
            c0605a2 = new C0605a();
            c0605a2.f524b = new ArrayList();
            string = this.mActivity.getString(R.string.language_values);
            if (jSONObject.has(string)) {
                c0605a2.f523a = jSONObject.optString(string);
            } else {
                c0605a2.f523a = jSONObject.optString("values");
            }
            jSONArray3 = jSONObject.getJSONArray("apps");
            for (i = 0; i < jSONArray3.length(); i++) {
                pluginBean3 = new PluginBean(this.mActivity, packageManager, jSONArray3.optJSONObject(i));
                if (this.f530f.containsKey(pluginBean3.f510d)) {
                    c0605a2.f524b.add(pluginBean3);
                    this.f530f.put(pluginBean3.f510d, pluginBean3);
                }
            }
            if (C1342b.m3339e(this.mActivity) == 1 && C1150y.m2645n(this.mActivity)) {
                pluginBean2 = new PluginBean(true);
                if (c0605a2.f524b.size() > 3) {
                    c0605a2.f524b.add(3, pluginBean2);
                } else {
                    c0605a2.f524b.add(pluginBean2);
                }
            }
            arrayList.add(c0605a2);
        }
        this.f535k.m865a(arrayList);
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.plugins_center_simple, null);
        this.f534j = findViewById(16908292);
        this.f534j.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvPluginsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        this.f535k = new PluginsListAdapter(this.b);
        recyclerView.setAdapter(this.f535k);
    }

    public boolean isFragmentWithoutActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.plugins_center);
        this.f529e = this.mActivity.getPackageManager();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.mActivity.registerReceiver(this.f528a, intentFilter);
        this.b.m54a("");
        this.b.m66r().setBackgroundColor(ContextCompat.getColor(this.mActivity, R.color.transparent));
        C1150y.m2605b(this.mActivity, (int) R.string.event_plugins_pager_simple);
    }

    public void onDestroy() {
        C1148d.m2509a(this.mActivity, this.f528a);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ((C0384c) this.mActivity).m72x();
        if (this.f531g) {
            if (!this.f532h && this.f533i) {
                this.f534j.setVisibility(0);
                C1148d.m2516a(new C1276e(), new C0608b());
            }
        } else if (!this.f532h) {
            this.f534j.setVisibility(0);
            C1148d.m2516a(new C1276e(), new C0608b());
        }
    }
}
