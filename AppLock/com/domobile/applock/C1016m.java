package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.domobile.applock.C0386c.C0745a;
import com.domobile.applock.adapter.C0419f;
import com.domobile.applock.adapter.C0689h;
import com.domobile.applock.p003a.C0612c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.C1359b;
import com.domobile.lockbean.Location;
import com.domobile.lockbean.Scene;
import com.domobile.widget.MyLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class C1016m extends C0704e {
    boolean f1795a = true;
    boolean f1796e = false;
    private RecyclerView f1797f;
    private int f1798g = -1;
    private ArrayList<Location> f1799h;
    private C1015a f1800i;
    private Location f1801j;
    private boolean f1802k = false;
    private ArrayList<Scene> f1803l;
    private Runnable f1804m = new C10043(this);
    private BroadcastReceiver f1805n = new C10054(this);

    class C10011 extends Thread {
        final /* synthetic */ C1016m f1766a;

        C10011(C1016m c1016m) {
            this.f1766a = c1016m;
        }

        public void run() {
            if (this.f1766a.f1795a) {
                this.f1766a.f1795a = false;
                this.f1766a.f1803l = Scene.m3388a(this.f1766a.mActivity);
                if (this.f1766a.f1796e) {
                    this.f1766a.call(0);
                }
            }
        }
    }

    class C10022 extends C0612c {
        final /* synthetic */ C1016m f1767a;

        C10022(C1016m c1016m) {
            this.f1767a = c1016m;
        }

        public void onChanged() {
            View findViewById = this.f1767a.findViewById(16908292);
            if (this.f1767a.f1800i.getItemCount() > 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
    }

    class C10043 implements Runnable {
        final /* synthetic */ C1016m f1770a;

        C10043(C1016m c1016m) {
            this.f1770a = c1016m;
        }

        public void run() {
            final ArrayList arrayList = new ArrayList();
            Cursor a = Location.m3379a();
            if (a != null) {
                while (a.moveToNext()) {
                    arrayList.add(new Location(a));
                }
                a.close();
            }
            this.f1770a.mHandler.post(new Runnable(this) {
                final /* synthetic */ C10043 f1769b;

                public void run() {
                    this.f1769b.f1770a.f1799h.clear();
                    this.f1769b.f1770a.f1799h.addAll(arrayList);
                    this.f1769b.f1770a.f1800i.notifyDataSetChanged();
                }
            });
        }
    }

    class C10054 extends BroadcastReceiver {
        final /* synthetic */ C1016m f1771a;

        C10054(C1016m c1016m) {
            this.f1771a = c1016m;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.domobile.elock.action.ACTION_SCENE_CHANGED".equals(intent.getAction())) {
                new Thread(this.f1771a.f1804m).start();
            }
        }
    }

    class C10087 implements OnClickListener {
        final /* synthetic */ C1016m f1778a;

        C10087(C1016m c1016m) {
            this.f1778a = c1016m;
        }

        public void onClick(View view) {
            this.f1778a.b.m80e();
            this.f1778a.b.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }
    }

    private class C1015a extends C0419f implements OnClickListener, OnCheckedChangeListener {
        final /* synthetic */ C1016m f1793a;
        private Resources f1794b;

        class C10121 implements Runnable {
            final /* synthetic */ C1015a f1788a;

            C10121(C1015a c1015a) {
                this.f1788a = c1015a;
            }

            public void run() {
                if (this.f1788a.f1793a.f1798g >= 0) {
                    this.f1788a.f1793a.f1797f.smoothScrollToPosition(this.f1788a.f1793a.f1798g);
                }
            }
        }

        public C1015a(C1016m c1016m) {
            this.f1793a = c1016m;
            this.f1794b = c1016m.mActivity.getResources();
        }

        private String m2003a(String str) {
            return TextUtils.isEmpty(str) ? this.f1793a.mActivity.getString(R.string.none_operation) : C1359b.m3420b(this.f1793a.mActivity, str);
        }

        private void m2004a(Location location) {
            int indexOf = this.f1793a.f1799h.indexOf(location);
            if (this.f1793a.f1798g == -1 || this.f1793a.f1798g != indexOf) {
                int d = this.f1793a.f1798g;
                this.f1793a.f1798g = indexOf;
                this.f1793a.f1800i.notifyItemChanged(d);
                this.f1793a.f1800i.notifyItemChanged(this.f1793a.f1798g);
            } else {
                this.f1793a.f1798g = -1;
                this.f1793a.f1800i.notifyItemChanged(indexOf);
            }
            if (this.f1793a.f1798g >= 0) {
                this.f1793a.mHandler.postDelayed(new C10121(this), 350);
            }
        }

        private void m2005b(final Location location) {
            C1288c c1288c = new C1288c(this.f1793a.mActivity);
            c1288c.m3101a((int) R.string.delete).mo2528a(this.f1793a.getString(R.string.are_you_sure_delete, location.m3384a(this.f1793a.mActivity)));
            c1288c.m3102a(17039360, null);
            c1288c.m3114b(17039370, new OnClickListener(this) {
                final /* synthetic */ C1015a f1792b;

                public void onClick(View view) {
                    C1148d.m2489A(this.f1792b.f1793a.mActivity, "com.domobile.applock.ACTION_ALARM_LOCATION_EDITED");
                    if (Location.m3376a(this.f1792b.f1793a.mActivity, location.f2915a) > 0) {
                        int indexOf = this.f1792b.f1793a.f1799h.indexOf(location);
                        this.f1792b.f1793a.f1799h.remove(location);
                        this.f1792b.f1793a.f1798g = -1;
                        this.f1792b.notifyItemRemoved(indexOf);
                        this.f1792b.m165a(150);
                    }
                }
            }).m3117b(true).m3122d();
        }

        public C0689h m2006a(ViewGroup viewGroup, int i) {
            C0689h c0689h = new C0689h(LayoutInflater.from(this.f1793a.mActivity).inflate(R.layout.timer_item, viewGroup, false));
            c0689h.f775l.setOnCheckedChangeListener(this);
            c0689h.f765b.setOnClickListener(this);
            c0689h.f767d.setOnClickListener(this);
            c0689h.itemView.setOnClickListener(this);
            c0689h.f764a.setOnClickListener(this);
            c0689h.f770g.setOnClickListener(this);
            c0689h.f772i.setOnClickListener(this);
            c0689h.f765b.setTextSize(28.0f);
            return c0689h;
        }

        public int getItemCount() {
            return this.f1793a.f1799h.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            TextView a;
            C0689h c0689h = (C0689h) viewHolder;
            c0689h.f776m.setVisibility((i == getItemCount() + -1 ? 1 : 0) != 0 ? 8 : 0);
            if (this.f1793a.f1798g == i) {
                c0689h.f766c.setVisibility(8);
                c0689h.f764a.setVisibility(0);
                c0689h.f770g.setVisibility(0);
                c0689h.f772i.setVisibility(0);
                c0689h.f769f.setVisibility(0);
                c0689h.f771h.setVisibility(0);
                c0689h.f767d.setVisibility(0);
                c0689h.f768e.setImageResource(R.drawable.ic_expand_up);
            } else {
                c0689h.f766c.setVisibility(0);
                c0689h.f764a.setVisibility(8);
                c0689h.f769f.setVisibility(8);
                c0689h.f771h.setVisibility(8);
                c0689h.f770g.setVisibility(8);
                c0689h.f772i.setVisibility(8);
                c0689h.f767d.setVisibility(8);
                c0689h.f768e.setImageResource(R.drawable.ic_expand_down);
            }
            Location location = (Location) this.f1793a.f1799h.get(i);
            if (c0689h.f766c.getChildCount() == 0) {
                a = ak.m1014a(this.f1793a.mActivity);
                a.setBackgroundColor(0);
                a.setTextColor(ResourcesCompat.getColor(this.f1793a.mActivity.getResources(), R.color.material_deep_teal_500, null));
                a.setTextSize(14.0f);
                c0689h.f766c.addView(a);
            } else {
                a = (TextView) c0689h.f766c.getChildAt(0);
            }
            a.setText(C1147a.m2480a(m2003a(location.f2919e), " / ", m2003a(location.f2920f)));
            c0689h.f764a.setText(location.f2918d);
            c0689h.f765b.setText(location.f2917c);
            c0689h.f770g.setText(m2003a(location.f2919e));
            c0689h.f772i.setText(m2003a(location.f2920f));
            c0689h.f767d.setTag(location);
            c0689h.f764a.setTag(location);
            c0689h.f765b.setTag(location);
            c0689h.f770g.setTag(location);
            c0689h.f772i.setTag(location);
            c0689h.itemView.setTag(location);
            c0689h.f775l.setOnCheckedChangeListener(null);
            c0689h.f775l.setChecked(location.f2916b);
            c0689h.f775l.setTag(location);
            c0689h.f775l.setOnCheckedChangeListener(this);
        }

        public void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
            C1288c a_ = this.f1793a.a_(0);
            if (a_ != null) {
                a_.m3107a(new OnDismissListener(this) {
                    final /* synthetic */ C1015a f1790b;

                    public void onDismiss() {
                        compoundButton.setOnCheckedChangeListener(null);
                        compoundButton.setChecked(false);
                        compoundButton.setOnCheckedChangeListener(this.f1790b);
                    }
                });
            } else if (compoundButton.getTag() != null) {
                Location location = (Location) compoundButton.getTag();
                Location.m3382a(this.f1793a.mActivity, location, z);
                location.f2916b = z;
                if (z) {
                    C1147a.m2487w(this.f1793a.mActivity, this.f1793a.mActivity.getString(R.string.startup_success, new Object[]{location.m3384a(this.f1793a.mActivity)}));
                }
            }
        }

        public void onClick(View view) {
            if (view.getTag() == null) {
                return;
            }
            if (view.getId() == R.id.timer_item_delete) {
                m2005b((Location) view.getTag());
            } else if (view.getId() == R.id.timer_item_name_editor) {
                this.f1793a.m2012a((Location) view.getTag());
            } else if (view.getId() == R.id.timer_item_action) {
                this.f1793a.f1802k = false;
                this.f1793a.m2021c((Location) view.getTag());
            } else if (view.getId() == R.id.timer_item_action_out) {
                this.f1793a.f1802k = true;
                this.f1793a.m2021c((Location) view.getTag());
            } else if (view.getId() == R.id.timer_item_time) {
                this.f1793a.m2013a((Location) view.getTag(), this.f1793a.m2025e());
            } else if (view.getId() == -1) {
                m2004a((Location) view.getTag());
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m2006a(viewGroup, i);
        }
    }

    private void m2012a(final Location location) {
        View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_rename_profile, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.dialog_rename_profine_text);
        editText.setText(location.f2918d);
        final C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.trigger_name_label).m3105a(inflate);
        c1288c.m3114b(17039370, null);
        c1288c.m3102a(17039360, null);
        c1288c.m3104a(new OnClickListener(this) {
            final /* synthetic */ C1016m f1775d;

            public void onClick(View view) {
                if (TextUtils.equals(location.f2918d, editText.getText())) {
                    c1288c.m3125e();
                    return;
                }
                Location location = new Location(location);
                location.f2918d = editText.getText().toString();
                if (this.f1775d.m2015b(location) > 0) {
                    c1288c.m3125e();
                    location.f2918d = location.f2918d;
                    this.f1775d.f1800i.notifyItemChanged(this.f1775d.f1799h.indexOf(location));
                }
            }
        }, false).m3117b(true).m3122d();
        editText.requestFocus();
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ C1016m f1777b;

            public void run() {
                C1148d.m2511a(this.f1777b.mActivity, editText);
            }
        }, 500);
    }

    private void m2013a(final Location location, final String[] strArr) {
        if (strArr.length != 0) {
            final C1288c c1288c = new C1288c(this.mActivity);
            c1288c.m3102a(17039360, null);
            c1288c.m3101a((int) R.string.pick_configured_wifi);
            c1288c.m3112a(strArr, -1, null, new OnItemClickListener(this) {
                final /* synthetic */ C1016m f1783d;

                class C10091 implements Runnable {
                    final /* synthetic */ C10108 f1779a;

                    C10091(C10108 c10108) {
                        this.f1779a = c10108;
                    }

                    public void run() {
                        this.f1779a.f1783d.f1797f.smoothScrollToPosition(this.f1779a.f1783d.f1798g);
                    }
                }

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Object obj = strArr[i];
                    if (TextUtils.equals(location.f2917c, obj)) {
                        c1288c.m3125e();
                        return;
                    }
                    Location location = new Location(location);
                    location.f2917c = obj;
                    long c = this.f1783d.m2015b(location);
                    if (c > 0) {
                        c1288c.m3125e();
                        location.f2917c = location.f2917c;
                        if (location.f2915a <= 0) {
                            location.f2915a = (int) c;
                            location.f2918d = location.f2918d;
                            this.f1783d.f1799h.add(location);
                            this.f1783d.f1798g = this.f1783d.f1799h.size() - 1;
                            this.f1783d.f1800i.notifyItemRangeChanged(0, this.f1783d.f1798g);
                            this.f1783d.f1800i.notifyItemInserted(this.f1783d.f1798g);
                            this.f1783d.mHandler.postDelayed(new C10091(this), 500);
                            return;
                        }
                        this.f1783d.f1800i.notifyItemChanged(this.f1783d.f1799h.indexOf(location));
                    }
                }
            }, false).m3117b(true).m3122d();
        } else if (((WifiManager) this.mActivity.getApplicationContext().getSystemService("wifi")).isWifiEnabled()) {
            m2020c();
        } else {
            m2024d();
        }
    }

    private long m2015b(Location location) {
        if (TextUtils.isEmpty(location.f2917c)) {
            return -1;
        }
        if (TextUtils.isEmpty(location.f2920f) && TextUtils.isEmpty(location.f2919e)) {
            new C1288c(this.mActivity).m3117b(true).m3113b((int) R.drawable.icon_dialog_alert_holo_light).m3123d((int) R.string.atleast_one_operation).m3114b(17039370, null).m3101a((int) R.string.notice).m3122d();
            return -1;
        }
        C1148d.m2489A(this.mActivity, "com.domobile.applock.ACTION_ALARM_LOCATION_EDITED");
        if (location.f2915a != -1) {
            return Location.m3383b(this.mActivity, location);
        }
        location.f2916b = true;
        long a = Location.m3377a(this.mActivity, location);
        if (a != -1) {
            C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.startup_success, new Object[]{location.m3384a(this.mActivity)}));
        }
        return a;
    }

    private void m2020c() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3123d((int) R.string.none_configured_wifi);
        c1288c.m3114b(17039370, null);
        c1288c.m3101a((int) R.string.notice);
        c1288c.m3117b(true).m3122d();
    }

    private void m2021c(final Location location) {
        final String[] a = C1150y.m2595a(this.mActivity, this.f1803l);
        final C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3109a(this.mActivity.getString(R.string.startup, new Object[]{this.mActivity.getString(R.string.scenes_mode)}));
        c1288c.m3102a(17039360, null);
        c1288c.m3106a(new C0745a(this.mActivity, a, true), -1, new OnItemClickListener(this) {
            final /* synthetic */ C1016m f1787d;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Location location = new Location(location);
                int i2 = i - 1;
                if (i2 == -1) {
                    if (this.f1787d.f1802k) {
                        location.f2920f = "";
                    } else {
                        location.f2919e = "";
                    }
                } else if (i2 == a.length - 1) {
                    c1288c.m3125e();
                    this.f1787d.f1801j = location;
                    this.f1787d.m109a(this.f1787d, 1000);
                    return;
                } else {
                    Scene scene = (Scene) this.f1787d.f1803l.get(i2);
                    if (this.f1787d.f1802k) {
                        location.f2920f = C1359b.m3414a(scene);
                    } else {
                        location.f2919e = C1359b.m3414a(scene);
                    }
                }
                if (this.f1787d.m2015b(location) > 0) {
                    c1288c.m3125e();
                    location.f2919e = location.f2919e;
                    location.f2920f = location.f2920f;
                    this.f1787d.f1800i.notifyItemChanged(this.f1787d.f1799h.indexOf(location));
                } else if (i2 == -1) {
                    c1288c.m3125e();
                }
            }
        }).m3117b(true).m3122d();
    }

    private void m2024d() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3123d((int) R.string.none_available_wifi);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b((int) R.string.setting, new C10087(this));
        c1288c.m3101a((int) R.string.notice);
        c1288c.m3117b(true).m3122d();
    }

    private String[] m2025e() {
        String[] strArr = new String[0];
        List<WifiConfiguration> configuredNetworks = ((WifiManager) this.mActivity.getApplicationContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            arrayList.add(Location.m3380a(wifiConfiguration.SSID));
        }
        return (String[]) arrayList.toArray(strArr);
    }

    public boolean mo2400b() {
        return true;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.timer_activity, null);
        this.f1797f = (RecyclerView) findViewById(R.id.timer_list);
        this.f1797f.setLayoutManager(new MyLinearLayoutManager(this.mActivity));
        findViewById(R.id.timer_add).setOnClickListener(this);
        this.f1799h = new ArrayList();
        this.f1800i = new C1015a(this);
        this.f1797f.setAdapter(this.f1800i);
        this.f1800i.registerAdapterDataObserver(new C10022(this));
        new Thread(this.f1804m).start();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1000) {
            return;
        }
        if (i2 == -1) {
            this.f1795a = true;
            this.f1796e = true;
            return;
        }
        call(0);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.timer_add) {
            super.onClick(view);
        } else if (a_(0) == null) {
            Location location = new Location();
            location.f2919e = C1359b.m3414a(new Scene(-1, this.mActivity.getString(R.string.default_profile)));
            location.f2916b = true;
            m2013a(location, m2025e());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.location_lock);
        C1150y.m2605b(this.mActivity, (int) R.string.event_location);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.elock.action.ACTION_SCENE_CHANGED");
        this.mActivity.registerReceiver(this.f1805n, intentFilter);
    }

    public void onDestroy() {
        super.onDestroy();
        C1148d.m2509a(this.mActivity, this.f1805n);
    }

    public void onResume() {
        super.onResume();
        new C10011(this).start();
    }

    public void ui(int i, Message message) {
        if (i == 0 && this.f1801j != null) {
            m2021c(this.f1801j);
        }
    }
}
