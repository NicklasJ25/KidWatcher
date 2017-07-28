package com.domobile.applock;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.imagelock.C1318c;

public class af extends C0400d {
    private final int f826a = 1;
    private final int f827e = 2;
    private View f828f;
    private View f829g;
    private C0705a f830h;
    private C0705a f831i;
    private C0705a f832j;
    private C0705a f833k;
    private C0705a f834l;
    private C0705a f835m;
    private C0705a f836n;
    private TextView f837o;
    private TextView f838p;
    private View f839q;
    private View f840r;
    private Resources f841s;

    private class C0705a implements OnClickListener {
        final /* synthetic */ af f819a;
        private View f820b;
        private ImageView f821c;
        private EditText f822d;
        private TextView f823e;
        private TextView f824f;
        private SwitchCompat f825g;

        C0705a(af afVar, View view) {
            this.f819a = afVar;
            this.f820b = view;
            this.f820b.setOnClickListener(this);
            this.f821c = (ImageView) view.findViewById(16908294);
            this.f823e = (TextView) view.findViewById(16908310);
            this.f822d = (EditText) view.findViewById(16908291);
            this.f824f = (TextView) view.findViewById(16908304);
            this.f825g = (SwitchCompat) view.findViewById(16908289);
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) == viewGroup.getChildCount() - 1) {
                view.findViewById(16908331).setVisibility(8);
            }
        }

        void m936a(int i, int i2, int i3) {
            this.f821c.setImageResource(i);
            this.f823e.setText(i2);
            if (i3 != 0) {
                this.f824f.setText(i3);
            }
        }

        void m937a(int i, int i2, int i3, String str) {
            m936a(i, i2, 0);
            this.f822d.setVisibility(0);
            this.f824f.setVisibility(8);
            this.f822d.setText(str);
            this.f822d.setHint(i3);
        }

        void m938a(int i, int i2, int i3, boolean z) {
            m936a(i, i2, i3);
            this.f825g.setVisibility(0);
            this.f825g.setChecked(z);
        }

        public void onClick(View view) {
            this.f819a.m942a(this);
        }
    }

    private String m939a(EditText editText) {
        try {
            return editText.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    private void m940a(boolean z) {
        int i = 1;
        this.b.m80e();
        Intent intent = new Intent(this.mActivity, GuideActivity.class);
        intent.putExtra("FORCE_NUMLOCK", z);
        intent.putExtra("FORCE_PATTERN", !z);
        intent.putExtra("com.domobile.applock.EXTRA_JUST_CHANGE_CIPHER", true);
        if (!z) {
            i = 2;
        }
        startActivityForResult(intent, i);
    }

    private void m941b(boolean z) {
        int i = R.drawable.unlock_settings_radio_on;
        int i2 = 0;
        int color = ResourcesCompat.getColor(this.f841s, R.color.unlock_settings_secondary_color, null);
        int color2 = ResourcesCompat.getColor(this.f841s, R.color.unlock_settings_primary_color, null);
        this.f838p.setTextColor(z ? color2 : color);
        TextView textView = this.f837o;
        if (z) {
            color2 = color;
        }
        textView.setTextColor(color2);
        this.f838p.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.unlock_settings_radio_on : R.drawable.unlock_settings_radio_off, 0, 0, 0);
        textView = this.f837o;
        if (z) {
            i = R.drawable.unlock_settings_radio_off;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        this.f828f.setVisibility(z ? 0 : 8);
        View view = this.f829g;
        if (z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    void m942a(C0705a c0705a) {
        boolean z = true;
        if (c0705a == this.f835m) {
            m940a(true);
        } else if (c0705a == this.f834l) {
            m940a(false);
        } else if (c0705a == this.f836n) {
            this.b.m80e();
            this.mActivity.startActivity(AgentActivity.m570a(this.mActivity, 256));
        } else if (c0705a == this.f831i || c0705a == this.f833k) {
            if (c0705a.f825g.isChecked()) {
                z = false;
            }
            this.f831i.f825g.setChecked(z);
            this.f833k.f825g.setChecked(z);
            C1150y.m2582a(this.mActivity, "vibrate_pattern_lock", Boolean.valueOf(z));
        } else if (c0705a == this.f830h) {
            if (c0705a.f825g.isChecked()) {
                z = false;
            }
            C1150y.m2598b(this.mActivity).f2223h = z;
            c0705a.f825g.setChecked(z);
            C1150y.m2582a(this.mActivity, "enable_visible_pattern", Boolean.valueOf(z));
        }
    }

    public void m943b() {
        this.f836n.f825g.setChecked(C1150y.m2592a(this.mActivity, "key_random_numboard", false));
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b.m56b(R.string.secure_setting);
        this.f841s = this.mActivity.getResources();
        this.rootView = layoutInflater.inflate(R.layout.secure, null);
        this.f838p = (TextView) findViewById(R.id.uc_password_radio);
        this.f840r = findViewById(R.id.uc_password_radio_parent);
        this.f840r.setOnClickListener(this);
        this.f837o = (TextView) findViewById(R.id.uc_pattern_radio);
        this.f839q = findViewById(R.id.uc_pattern_radio_parent);
        this.f839q.setOnClickListener(this);
        this.f829g = findViewById(R.id.secure_pattern_lock_parent);
        this.f834l = new C0705a(this, findViewById(R.id.uc_modify_pattern));
        this.f830h = new C0705a(this, findViewById(R.id.uc_pattern_visible));
        this.f831i = new C0705a(this, findViewById(R.id.uc_pattern_vibrate));
        this.f828f = findViewById(R.id.secure_number_lock_parent);
        this.f835m = new C0705a(this, findViewById(R.id.uc_modify_password));
        this.f832j = new C0705a(this, findViewById(R.id.uc_password_hint));
        this.f833k = new C0705a(this, findViewById(R.id.uc_password_vibrate));
        this.f836n = new C0705a(this, findViewById(R.id.uc_random_keyboard));
        this.f830h.m938a((int) R.drawable.unlock_settings_make_pattern_visible, (int) R.string.enable_visible_pattern_title, (int) R.string.summary_pattern_visible, C1150y.m2619d(this.mActivity, "enable_visible_pattern"));
        this.f831i.m938a((int) R.drawable.unlock_settings_touch_vibrate, (int) R.string.tactile_feedback_enabled, (int) R.string.summary_touch_vibrate, C1318c.m3243a(this.mActivity));
        this.f833k.m938a((int) R.drawable.unlock_settings_touch_vibrate, (int) R.string.tactile_feedback_enabled, (int) R.string.summary_touch_vibrate, C1318c.m3243a(this.mActivity));
        this.f836n.m938a((int) R.drawable.unlock_settings_random_keyboard, (int) R.string.setting_random_numboard, (int) R.string.setting_random_numboard_summary, C1150y.m2592a(this.mActivity, "key_random_numboard", false));
        this.f832j.m937a((int) R.drawable.unlock_settings_modify_password_hint, (int) R.string.password_hint, (int) R.string.summary_password_hint, C1150y.m2598b(this.mActivity).f2221f);
        this.f834l.m936a(R.drawable.unlock_settings_modify_pattern, R.string.title_modify_pattern, R.string.summary_modify_pattern);
        this.f835m.m936a(R.drawable.unlock_settings_modify_password, R.string.title_modify_password, R.string.summary_modify_password);
        m941b(!C1150y.m2614c(this.mActivity, "is_image_lock_pattern"));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            C1147a.m2485d(this.mActivity, R.string.password_modified);
            if (i == 2) {
                if (C1150y.m2537B(this.mActivity)) {
                    m941b(false);
                }
            } else if (i == 1 && C1150y.m2662x(this.mActivity)) {
                m941b(true);
            }
        }
    }

    public void onClick(View view) {
        if (view == this.f840r) {
            if (C1150y.m2536A(this.mActivity)) {
                m942a(this.f835m);
            }
        } else if (view == this.f839q && !C1150y.m2536A(this.mActivity)) {
            m942a(this.f834l);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_secure);
    }

    public void onPause() {
        super.onPause();
        C1148d.m2520b(this.mActivity, "password_hint", (Object) m939a(this.f832j.f822d));
    }

    public void onResume() {
        super.onResume();
        m943b();
    }

    public void ui(int i, Message message) {
    }
}
