package com.domobile.applock;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.fake.DefaultFakeViewInitialer;
import com.domobile.applock.p007c.C0754a;
import com.domobile.applock.receiver.AppLockDeviceAdminReceiver;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.widget.OverscrollRecyclerView;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ag extends C0400d {
    private final int[] f874a = new int[]{R.string.security, R.string.general, R.string.magic};
    private final int[] f875e = new int[]{R.drawable.protect_security, R.drawable.protect_general, R.drawable.protect_magic};
    private OverscrollRecyclerView f876f;
    private LinearLayoutManager f877g;
    private boolean f878h;
    private C0714b f879i;
    private C1150y f880j;
    private ArrayList<C0714b> f881k = new ArrayList();
    private ArrayList<ArrayList<C0714b>> f882l = new ArrayList();
    private int f883m = 0;
    private boolean f884n = false;
    private boolean f885o = false;
    private C0754a f886p;

    class C07061 implements OnGlobalLayoutListener {
        final /* synthetic */ ag f842a;

        C07061(ag agVar) {
            this.f842a = agVar;
        }

        public void onGlobalLayout() {
            try {
                C1148d.m2515a(this.f842a.f876f.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                this.f842a.f876f.m3553a(this.f842a.b.m66r().getHeight(), MainTabFragmentActivity.m633l().m643m());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C07072 extends ItemDecoration {
        final /* synthetic */ ag f843a;

        C07072(ag agVar) {
            this.f843a = agVar;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.set(0, 0, 0, this.f843a.mActivity.getResources().getDimensionPixelSize(R.dimen.PaddingSizeSmaller));
        }
    }

    private class C0713a extends Adapter<C0715c> implements OnClickListener {
        final /* synthetic */ ag f858a;
        private LayoutInflater f859b;
        private OnClickListener f860c = new C07081(this);

        class C07081 implements OnClickListener {
            final /* synthetic */ C0713a f844a;

            C07081(C0713a c0713a) {
                this.f844a = c0713a;
            }

            public void onClick(View view) {
                int adapterPosition = ((C0715c) view.getTag()).getAdapterPosition();
                if (this.f844a.f858a.f883m == -1 || this.f844a.f858a.f883m != adapterPosition) {
                    int c = this.f844a.f858a.f883m;
                    this.f844a.f858a.f883m = adapterPosition;
                    if (this.f844a.f858a.f883m == this.f844a.getItemCount() - 1) {
                        this.f844a.f858a.f884n = false;
                        C1150y.m2582a(this.f844a.f858a.mActivity, "show_magic_highlight", Boolean.valueOf(this.f844a.f858a.f884n));
                    }
                    this.f844a.notifyItemChanged(c);
                    this.f844a.notifyItemChanged(this.f844a.f858a.f883m);
                } else {
                    this.f844a.f858a.f883m = -1;
                    this.f844a.notifyItemChanged(adapterPosition);
                }
                this.f844a.f858a.mo2402a();
            }
        }

        class C07103 implements OnClickListener {
            final /* synthetic */ C0713a f850a;

            C07103(C0713a c0713a) {
                this.f850a = c0713a;
            }

            public void onClick(View view) {
                ((MainTabFragmentActivity) this.f850a.f858a.mActivity).m636a((int) R.string.category_disable_saving_power);
                C1150y.m2566a(this.f850a.f858a.mActivity).f434i = true;
            }
        }

        class C07114 implements OnClickListener {
            final /* synthetic */ C0713a f851a;

            C07114(C0713a c0713a) {
                this.f851a = c0713a;
            }

            public void onClick(View view) {
                this.f851a.m951b();
            }
        }

        private class C0712a {
            final /* synthetic */ C0713a f852a;
            private ImageView f853b;
            private TextView f854c;
            private TextView f855d;
            private SwitchCompat f856e;
            private View f857f;

            public C0712a(C0713a c0713a, View view) {
                this.f852a = c0713a;
                try {
                    this.f857f = view.findViewById(R.id.security_item_card);
                    this.f853b = (ImageView) view.findViewById(16908294);
                    this.f854c = (TextView) view.findViewById(16908308);
                    this.f855d = (TextView) view.findViewById(16908304);
                    this.f856e = (SwitchCompat) view.findViewById(16908289);
                } catch (Exception e) {
                }
            }
        }

        public C0713a(ag agVar) {
            this.f858a = agVar;
            this.f859b = agVar.mActivity.getLayoutInflater();
        }

        private void m949a() {
            C1288c c1288c = new C1288c(this.f858a.mActivity);
            c1288c.m3117b(true).m3101a((int) R.string.device_admin);
            c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
            c1288c.m3123d((int) R.string.device_admin_disabled_warning);
            c1288c.m3102a(17039360, null);
            c1288c.m3114b(17039370, new C07114(this)).m3122d();
        }

        private void m951b() {
            this.f858a.f878h = false;
            C1148d.m2520b(this.f858a.mActivity, "last_secure_level", (Object) Boolean.valueOf(false));
            this.f858a.f876f.getAdapter().notifyDataSetChanged();
            C1150y.m2606b(this.f858a.mActivity, new ComponentName(this.f858a.mActivity, AppLockDeviceAdminReceiver.class));
            C1150y.m2606b(this.f858a.mActivity, C1150y.m2597b());
            this.f858a.b.m80e();
            try {
                this.f858a.mActivity.startActivity(new Intent("android.intent.action.DELETE", Uri.fromParts("package", "com.domobile.applockwatcher", null)));
            } catch (Exception e) {
            }
        }

        public C0715c m952a(ViewGroup viewGroup, int i) {
            return new C0715c(this.f858a, this.f859b.inflate(R.layout.fragment_help_item, viewGroup, false));
        }

        public void m953a(C0714b c0714b, View view) {
            boolean z = false;
            boolean z2 = true;
            if (c0714b.f865e != 0) {
                this.f858a.b.m80e();
                this.f858a.mActivity.startActivity(AgentActivity.m570a(this.f858a.mActivity, c0714b.f865e));
                return;
            }
            final String str = c0714b.f861a;
            if ("short_exit_time_limit".equals(str)) {
                String[] stringArray = this.f858a.mActivity.getResources().getStringArray(R.array.short_exit_time_limit_name);
                final String[] stringArray2 = this.f858a.mActivity.getResources().getStringArray(R.array.short_exit_time_limit_value);
                final C1288c c1288c = new C1288c(this.f858a.mActivity);
                c1288c.m3101a((int) R.string.allow_short_exit);
                final View view2 = view;
                c1288c.m3112a(stringArray, -1, null, new OnItemClickListener(this) {
                    final /* synthetic */ C0713a f849e;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        boolean z = true;
                        String str = stringArray2[i];
                        this.f849e.f858a.f880j.f2240y = C1150y.m2623f(str);
                        this.f849e.f858a.f880j.f2241z = this.f849e.f858a.f880j.f2240y > 0;
                        C1148d.m2520b(this.f849e.f858a.mActivity, str, (Object) str);
                        ((TextView) view2.findViewById(16908304)).setText(C1150y.m2626g(this.f849e.f858a.mActivity, str));
                        Checkable checkable = (Checkable) view2.findViewById(16908289);
                        if (this.f849e.f858a.f880j.f2240y <= 0) {
                            z = false;
                        }
                        checkable.setChecked(z);
                        c1288c.m3125e();
                    }
                }, false).m3117b(true).m3122d();
            } else if ("lock_after_screen_on".equals(str)) {
                if (!c0714b.f866f) {
                    z = true;
                }
                c0714b.f866f = z;
                this.f858a.f880j.f2222g = c0714b.f866f;
                C1148d.m2520b(this.f858a.mActivity, str, (Object) Boolean.valueOf(c0714b.f866f));
                ((Checkable) view.findViewById(16908289)).setChecked(c0714b.f866f);
            } else if ("enable_power_save_mode".equals(str)) {
                if (this.f858a.f885o) {
                    C1288c c1288c2 = new C1288c(this.f858a.mActivity);
                    c1288c2.m3123d((int) R.string.disable_power_save_mode_warning);
                    c1288c2.m3101a((int) R.string.save_power_mode);
                    c1288c2.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
                    c1288c2.m3102a(17039360, null);
                    c1288c2.m3114b(17039370, new C07103(this)).m3117b(true).m3122d();
                    return;
                }
                ((MainTabFragmentActivity) this.f858a.mActivity).m636a((int) R.string.category_enable_saving_power);
            } else if (!"fingerprint_auth_enabled".equals(str)) {
                if (c0714b.f866f) {
                    z2 = false;
                }
                if (z2) {
                    this.f858a.b.m80e();
                    MainTabFragmentActivity.m627a(this.f858a.b, (int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    return;
                }
                m949a();
            } else if (c0714b.f866f || this.f858a.f886p.m1094a()) {
                if (c0714b.f866f) {
                    z2 = false;
                }
                c0714b.f866f = z2;
                this.f858a.f880j.f2233r = c0714b.f866f;
                C1148d.m2520b(this.f858a.mActivity, str, (Object) Boolean.valueOf(c0714b.f866f));
                ((Checkable) view.findViewById(16908289)).setChecked(c0714b.f866f);
            } else {
                new C1288c(this.f858a.mActivity).m3123d((int) R.string.please_enrolled_fingerprint_first).m3114b(17039370, null).m3122d();
            }
        }

        public void m954a(C0715c c0715c, int i) {
            c0715c.f870b.setTag(c0715c);
            c0715c.f870b.setOnClickListener(this.f860c);
            c0715c.f872d.setText(this.f858a.f874a[i]);
            c0715c.f871c.setImageResource(this.f858a.f875e[i]);
            if ((i == getItemCount() + -1 ? 1 : null) == null || !this.f858a.f884n) {
                c0715c.f872d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                c0715c.f872d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.new_dot, 0);
            }
            try {
                c0715c.f873e.removeViews(1, c0715c.f873e.getChildCount() - 1);
                if (this.f858a.f883m == i) {
                    ArrayList arrayList = (ArrayList) this.f858a.f882l.get(i);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C0714b c0714b = (C0714b) arrayList.get(i2);
                        if (c0714b != null) {
                            View inflate = this.f859b.inflate(R.layout.fragment_security_item, null);
                            C0712a c0712a = new C0712a(this, inflate);
                            c0715c.f873e.addView(inflate);
                            c0712a.f853b.setImageResource(c0714b.f862b);
                            c0712a.f854c.setText(c0714b.f863c);
                            c0712a.f857f.setOnClickListener(this);
                            c0712a.f857f.setTag(c0714b);
                            c0712a.f856e.setChecked(c0714b.f866f);
                            c0712a.f855d.setVisibility(0);
                            if (TextUtils.equals(c0714b.f861a, "short_exit_time_limit")) {
                                String b = C1150y.m2602b(this.f858a.mActivity, c0714b.f861a);
                                this.f858a.f880j.f2240y = C1150y.m2623f(b);
                                c0712a.f855d.setText(C1150y.m2626g(this.f858a.mActivity, b));
                                c0712a.f856e.setChecked(this.f858a.f880j.f2240y > 0);
                            } else if (TextUtils.equals(c0714b.f861a, "password")) {
                                if (C1150y.m2536A(this.f858a.mActivity)) {
                                    c0712a.f855d.setText(this.f858a.mActivity.getString(R.string.security_password_summary, new Object[]{this.f858a.mActivity.getString(R.string.image_lock)}));
                                } else {
                                    c0712a.f855d.setText(this.f858a.mActivity.getString(R.string.security_password_summary, new Object[]{this.f858a.mActivity.getString(R.string.number_lock)}));
                                }
                            } else if (c0714b.f864d != 0) {
                                c0712a.f855d.setText(c0714b.f864d);
                            } else {
                                c0712a.f855d.setVisibility(8);
                            }
                            c0712a.f856e.setTag(c0714b);
                            c0712a.f856e.setVisibility(c0714b.f867g ? 0 : 4);
                            c0712a.f856e.setTag(R.id.tag_object, Integer.valueOf(i2));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }

        public int getItemCount() {
            return this.f858a.f882l.size();
        }

        public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
            m954a((C0715c) viewHolder, i);
        }

        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof C0714b)) {
                m953a((C0714b) view.getTag(), view);
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m952a(viewGroup, i);
        }
    }

    private class C0714b {
        public String f861a;
        public int f862b;
        public int f863c;
        public int f864d;
        public int f865e;
        public boolean f866f;
        public boolean f867g;
        final /* synthetic */ ag f868h;

        public C0714b(ag agVar, String str, int i, int i2, int i3, int i4, boolean z) {
            this(agVar, str, i, i2, i3, i4, z, false);
        }

        public C0714b(ag agVar, String str, int i, int i2, int i3, int i4, boolean z, boolean z2) {
            this.f868h = agVar;
            this.f861a = str;
            this.f862b = i;
            this.f863c = i2;
            this.f864d = i3;
            this.f865e = i4;
            this.f867g = z;
            m956a(z2);
        }

        private void m956a(boolean z) {
            boolean z2 = true;
            if (this.f865e == 264) {
                if (TextUtils.isEmpty(C1150y.m2602b(this.f868h.mActivity, this.f861a))) {
                    z2 = false;
                }
                this.f866f = z2;
            } else if (this.f865e == 296) {
                CharSequence b = C1150y.m2602b(this.f868h.mActivity, this.f861a);
                if (TextUtils.isEmpty(b) || TextUtils.equals(DefaultFakeViewInitialer.class.getName(), b)) {
                    z2 = false;
                }
                this.f866f = z2;
            } else if (!TextUtils.equals(this.f861a, "short_exit_time_limit")) {
                if (TextUtils.equals(this.f861a, "enable_power_save_mode")) {
                    this.f866f = this.f868h.f885o;
                } else if (TextUtils.equals(this.f861a, "enable_device_admin")) {
                    this.f866f = this.f868h.f878h;
                    if (this.f866f) {
                        this.f864d = R.string.secure_level_enabled;
                    } else {
                        this.f864d = R.string.secure_level_disable;
                    }
                } else if (this.f867g) {
                    this.f866f = C1150y.m2592a(this.f868h.mActivity, this.f861a, z);
                } else {
                    this.f866f = true;
                }
            }
        }
    }

    private class C0715c extends ViewHolder {
        final /* synthetic */ ag f869a;
        private View f870b;
        private ImageView f871c;
        private TextView f872d;
        private ViewGroup f873e;

        public C0715c(ag agVar, View view) {
            this.f869a = agVar;
            super(view);
            try {
                this.f872d = (TextView) view.findViewById(16908310);
                this.f873e = (ViewGroup) view.findViewById(16908290);
                this.f871c = (ImageView) view.findViewById(16908294);
                this.f870b = view.findViewById(16908290);
                this.f870b.setPadding(0, this.f870b.getPaddingTop(), 0, this.f870b.getPaddingBottom());
            } catch (Exception e) {
            }
        }
    }

    public void mo2402a() {
        this.f876f.m3552a();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.fragment_security, null);
        this.f876f = (OverscrollRecyclerView) findViewById(R.id.security_list);
        this.f877g = new NpaLinearLayoutManager(this.mActivity);
        this.f876f.setLayoutManager(this.f877g);
        this.f876f.setAdapter(new C0713a(this));
        this.f876f.setItemViewCacheSize(this.f874a.length);
        this.f876f.getViewTreeObserver().addOnGlobalLayoutListener(new C07061(this));
        this.f876f.addItemDecoration(new C07072(this));
    }

    public boolean isShowOptionsMenu() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_security);
        this.f880j = C1150y.m2598b(this.mActivity);
        this.f884n = C1150y.m2619d(this.mActivity, "show_magic_highlight");
        this.f878h = C1150y.m2542G(this.mActivity);
        this.f885o = C1150y.m2554S(this.mActivity);
        this.f886p = C0754a.m1092a(this.mActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0714b(this, "password", R.drawable.protect_unlock_setting, R.string.secure_setting, 0, 263, false));
        arrayList.add(new C0714b(this, "secure_email", R.drawable.protect_retrive, R.string.secure_answer_setting_title, R.string.security_retrieve_summary, 264, false));
        if (this.f886p != null && this.f886p.m1095b()) {
            arrayList.add(new C0714b(this, "fingerprint_auth_enabled", R.drawable.protect_fingerprint, R.string.fingerprint_auth_enable_title, R.string.fingerprint_auth_enable_summary, 0, true));
        }
        this.f882l.add(arrayList);
        arrayList = new ArrayList();
        arrayList.add(new C0714b(this, "enable_power_save_mode", R.drawable.protect_power_save, R.string.save_power_mode, R.string.save_power_mode_summary, 0, true));
        this.f879i = new C0714b(this, "enable_device_admin", R.drawable.protect_advance, R.string.device_admin, R.string.device_admin_summary, 0, true);
        arrayList.add(this.f879i);
        arrayList.add(new C0714b(this, "short_exit_time_limit", R.drawable.protect_short_exit, R.string.allow_short_exit, R.string.allow_short_exit, 0, true));
        arrayList.add(new C0714b(this, "lock_after_screen_on", R.drawable.protect_relock, R.string.lock_after_screen_on, R.string.lock_after_screen_on_info, 0, true));
        this.f882l.add(arrayList);
        arrayList = new ArrayList();
        this.f882l.add(arrayList);
        arrayList.add(new C0714b(this, "key_hide_app_icon", R.drawable.protect_hide_applock, R.string.hide_app_icon, R.string.hide_app_icon_summary, InputDeviceCompat.SOURCE_KEYBOARD, true));
        arrayList.add(new C0714b(this, "key_random_numboard", R.drawable.unlock_settings_random_keyboard, R.string.setting_random_numboard, R.string.setting_random_numboard_summary, 256, true));
        arrayList.add(new C0714b(this, "fake_view_type", R.drawable.protect_cover, R.string.fake_page_picker, R.string.security_fake_summary, 296, true));
        int size = this.f882l.size();
        for (int i = 0; i < size; i++) {
            this.f881k.addAll((Collection) this.f882l.get(i));
        }
    }

    public void onResume() {
        super.onResume();
        this.f878h = C1150y.m2542G(this.mActivity);
        this.f885o = C1150y.m2554S(this.mActivity);
        Iterator it = this.f881k.iterator();
        while (it.hasNext()) {
            C0714b c0714b = (C0714b) it.next();
            c0714b.m956a(c0714b.f866f);
        }
        this.f876f.getAdapter().notifyDataSetChanged();
    }
}
