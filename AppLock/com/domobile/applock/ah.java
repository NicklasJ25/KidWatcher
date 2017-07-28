package com.domobile.applock;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.camera.MediaReceiverActivity;
import com.domobile.applock.receiver.AppLockDeviceAdminReceiver;
import com.domobile.eframe.C1224e;
import com.domobile.frame.C0384c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.preference.Preference;
import com.domobile.preference.Preference.OnPreferenceChangeListener;
import com.domobile.preference.Preference.OnPreferenceClickListener;
import com.domobile.preference.PreferenceFragment;
import com.domobile.preference.SwitchPreference;

public class ah extends PreferenceFragment implements OnPreferenceClickListener {
    SwitchPreference f889a;
    SwitchPreference f890b;
    Preference f891c;
    Preference f892d;
    boolean f893e;
    private OnPreferenceChangeListener f894f = new C07161(this);

    class C07161 implements OnPreferenceChangeListener {
        final /* synthetic */ ah f887a;

        C07161(ah ahVar) {
            this.f887a = ahVar;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            String key = preference.getKey();
            C1150y b = C1150y.m2598b(this.f887a.mActivity);
            if (!key.equals("short_exit_time_limit")) {
                if ("show_notification".equals(key)) {
                    this.f887a.m978a(((Boolean) obj).booleanValue());
                    C1148d.m2489A(this.f887a.mActivity, "com.domobile.elock.action.CHANGE_NOTIFY");
                } else if ("lock_after_screen_on".equals(key)) {
                    b.f2222g = ((Boolean) obj).booleanValue();
                } else if ("enable_send_action".equals(key)) {
                    this.f887a.m982b(((Boolean) obj).booleanValue());
                } else if ("enable_device_admin".equals(key)) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (booleanValue == this.f887a.f893e) {
                        return false;
                    }
                    if (booleanValue) {
                        ((C0386c) this.f887a.mActivity).m80e();
                        MainTabFragmentActivity.m627a((C0386c) this.f887a.mActivity, (int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        return false;
                    }
                    this.f887a.m983c();
                    return false;
                } else if ("hide_app_icon".equals(key) || "random_numboard".equals(key)) {
                    return false;
                }
            }
            return true;
        }
    }

    class C07172 implements OnClickListener {
        final /* synthetic */ ah f888a;

        C07172(ah ahVar) {
            this.f888a = ahVar;
        }

        public void onClick(View view) {
            this.f888a.m984d();
        }
    }

    private void m975a() {
        super.removePreferenceScreen();
        addPreferencesFromResource(R.xml.applock_setting);
        this.f889a = (SwitchPreference) findPreference("show_notification");
        this.f889a.setOnPreferenceChangeListener(this.f894f);
        this.f891c = findPreference("applock_language");
        this.f891c.setOnPreferenceClickListener(this);
        this.f892d = findPreference("applock_about");
        this.f892d.setOnPreferenceClickListener(this);
        this.f892d.setSummary(C1147a.m2480a(this.mActivity.getString(R.string.app_name), " v", C1148d.ae(this.mActivity)));
        this.f890b = (SwitchPreference) findPreference("notify_when_codeset_excute");
        this.f890b.setOnPreferenceChangeListener(this.f894f);
        ((SwitchPreference) findPreference("enable_send_action")).setOnPreferenceChangeListener(this.f894f);
        m979b();
        m978a(C1150y.m2614c(this.mActivity, "show_notification"));
    }

    private void m978a(boolean z) {
        if (z) {
            this.f889a.setSummary((int) R.string.setting_notify_show_summary);
        } else {
            this.f889a.setSummary((int) R.string.setting_notify_gone_summary);
        }
    }

    private void m979b() {
        CharSequence b = C1150y.m2602b(this.mActivity, "applock_language");
        if (TextUtils.isEmpty(b)) {
            this.f891c.setSummary((int) R.string.default_language);
        } else {
            this.f891c.setSummary(b);
        }
    }

    private void m982b(boolean z) {
        this.mActivity.getPackageManager().setComponentEnabledSetting(new ComponentName(this.mActivity.getPackageName(), MediaReceiverActivity.class.getName()), z ? 1 : 2, 1);
    }

    private void m983c() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3117b(true).m3101a((int) R.string.notice);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3123d((int) R.string.device_admin_disabled_warning);
        c1288c.m3102a(17039360, null);
        c1288c.m3114b(17039370, new C07172(this)).m3122d();
    }

    private void m984d() {
        this.f893e = false;
        C1148d.m2520b(this.mActivity, "last_secure_level", (Object) Boolean.valueOf(false));
        C1150y.m2606b(this.mActivity, new ComponentName(this.mActivity, AppLockDeviceAdminReceiver.class));
        C1150y.m2606b(this.mActivity, C1150y.m2597b());
        ((C0386c) this.mActivity).m80e();
        this.mActivity.startActivity(new Intent("android.intent.action.DELETE", Uri.fromParts("package", "com.domobile.applockwatcher", null)));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((C0384c) this.mActivity).m56b(R.string.domo_setting);
        this.mActionBar.m3006b(false);
        m975a();
        C1150y.m2605b(this.mActivity, (int) R.string.event_setting);
    }

    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if ("applock_language".equals(key)) {
            C1224e c1224e = new C1224e(this.mActivity);
        } else if (preference == this.f892d) {
            ((C0386c) this.mActivity).m80e();
            startActivity(AgentActivity.m570a(this.mActivity, 276));
        } else if ("hide_app_icon".equals(key)) {
            ((C0386c) this.mActivity).m80e();
            r0 = AgentActivity.m570a(this.mActivity, InputDeviceCompat.SOURCE_KEYBOARD);
            r0.putExtra("EXTRA_SHOW_BACK", true);
            this.mActivity.startActivity(r0);
        } else if ("random_numboard".equals(key)) {
            ((C0386c) this.mActivity).m80e();
            r0 = AgentActivity.m570a(this.mActivity, 256);
            r0.putExtra("EXTRA_SHOW_BACK", true);
            this.mActivity.startActivity(r0);
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        ((C0384c) this.mActivity).m69u();
        this.f893e = C1150y.m2542G(this.mActivity);
    }

    public void ui(int i, Message message) {
    }
}
