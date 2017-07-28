package com.domobile.applock;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;

public class C0954j extends C0400d implements OnCheckedChangeListener {
    private SwitchCompat f1511a;
    private LayoutInflater f1512e;

    class C09521 implements OnDismissListener {
        final /* synthetic */ C0954j f1508a;

        C09521(C0954j c0954j) {
            this.f1508a = c0954j;
        }

        public void onDismiss() {
            this.f1508a.f1511a.setChecked(false);
        }
    }

    private void m1719a(final boolean z) {
        this.mActivity.getPackageManager().setComponentEnabledSetting(new ComponentName(this.mActivity.getPackageName(), LauncherActivity.class.getName()), z ? 1 : 2, 1);
        new Thread(this) {
            final /* synthetic */ C0954j f1510b;

            public void run() {
                this.f1510b.m1722c();
                if (!z) {
                    C1150y.m2540E(this.f1510b.mActivity);
                }
            }
        }.start();
    }

    private void m1720b() {
        C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.be_success, new Object[]{this.b.h.getTitle()}));
    }

    private void m1722c() {
        ActivityManager activityManager = (ActivityManager) this.mActivity.getSystemService("activity");
        for (String killBackgroundProcesses : C1150y.m2566a(this.mActivity).m587b(this.mActivity).keySet()) {
            activityManager.killBackgroundProcesses(killBackgroundProcesses);
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1512e = layoutInflater;
        this.rootView = layoutInflater.inflate(R.layout.single_settings, null);
        ((TextView) findViewById(16908310)).setText(R.string.hide_app_icon);
        ((TextView) findViewById(16908304)).setText(R.string.hide_app_icon_summary);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.single_setting_content);
        for (int i = 0; i < 2; i++) {
            View inflate = this.f1512e.inflate(R.layout.fragment_hide_applock_try, viewGroup2, false);
            View findViewById = inflate.findViewById(R.id.button_try_sfb);
            if (i == 1) {
                findViewById.setId(R.id.button_try_sfd);
                ((ImageView) inflate.findViewById(R.id.single_setting_intro)).setImageResource(R.drawable.start_from_dialpad);
                ((TextView) inflate.findViewById(R.id.sfb_content)).setText(R.string.start_from_dialpad_summary);
                ((TextView) inflate.findViewById(R.id.sfb_action)).setText(R.string.start_from_dialpad_keywords);
                ((TextView) inflate.findViewById(R.id.sfb_title)).setText(R.string.start_from_dialpad);
            } else {
                ((MarginLayoutParams) inflate.getLayoutParams()).bottomMargin = 0;
            }
            findViewById.setOnClickListener(this);
            viewGroup2.addView(inflate);
        }
        findViewById(R.id.single_settings_item).setOnClickListener(this);
        this.f1511a = (SwitchCompat) findViewById(R.id.single_setting_switcher);
        this.f1511a.setChecked(C1150y.m2614c(this.mActivity, "key_hide_app_icon"));
        this.f1511a.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = false;
        if (z) {
            C1288c a_ = a_(0);
            if (a_ != null) {
                a_.m3107a(new C09521(this));
                return;
            }
        }
        C1148d.m2520b(this.mActivity, "key_hide_app_icon", (Object) Boolean.valueOf(z));
        if (!z) {
            z2 = true;
        }
        m1719a(z2);
        if (z) {
            m1720b();
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.button_try_sfb) {
            try {
                this.b.m80e();
                intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.domobile.com/applock"));
                intent.setFlags(268435456);
                this.mActivity.startActivity(intent);
            } catch (Exception e) {
            }
        } else if (view.getId() == R.id.single_settings_item) {
            this.f1511a.setChecked(!this.f1511a.isChecked());
        } else if (view.getId() == R.id.button_try_sfd) {
            try {
                this.b.m80e();
                intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:"));
                intent.setFlags(268435456);
                this.mActivity.startActivity(intent);
            } catch (Exception e2) {
            }
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.hide_app_icon);
        C1150y.m2605b(this.mActivity, (int) R.string.event_hide_appLock);
    }

    public void ui(int i, Message message) {
    }
}
