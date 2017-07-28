package com.domobile.applock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.android.camera.gallery.HidedPictureItem;
import com.domobile.applock.aj.C0721a;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0384c;
import com.domobile.frame.C0399d;
import com.domobile.frame.C0635g;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.C1375l;
import org.json.JSONObject;

public class ab extends C0399d implements OnCheckedChangeListener {
    private int f584a = -1;
    private int f585b = -1;
    private TextView f586c;
    private EditText f587d;
    private EditText f588e;
    private EditText f589f;
    private CheckBox f590g;
    private CheckBox f591h;
    private View f592i;
    private View f593j;
    private Button f594k;
    private Button f595l;
    private Button f596m;
    private String f597n;
    private boolean f598o = false;
    private OnClickListener f599p = new C06372(this);
    private BroadcastReceiver f600q = new C06383(this);

    class C06361 extends C0635g {
        final /* synthetic */ ab f580a;

        C06361(ab abVar) {
            this.f580a = abVar;
        }

        public void afterTextChanged(Editable editable) {
            this.f580a.f595l.setEnabled(editable.length() >= 6);
        }
    }

    class C06372 implements OnClickListener {
        final /* synthetic */ ab f581a;

        C06372(ab abVar) {
            this.f581a = abVar;
        }

        public void onClick(View view) {
            if (view == this.f581a.f592i) {
                this.f581a.f590g.setChecked(true);
                this.f581a.f591h.setChecked(false);
            } else if (view == this.f581a.f593j) {
                this.f581a.f590g.setChecked(false);
                this.f581a.f591h.setChecked(true);
            }
        }
    }

    class C06383 extends BroadcastReceiver {
        final /* synthetic */ ab f582a;

        C06383(ab abVar) {
            this.f582a = abVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    C1148d.m2516a(new C1276e(), new C0639a(this.f582a));
                }
            }
        }
    }

    public class C0639a implements C0607f {
        final /* synthetic */ ab f583a;

        public C0639a(ab abVar) {
            this.f583a = abVar;
        }

        private void m758b() {
            C1150y.m2568a(this.f583a.mActivity, this.f583a.mActivity.getString(R.string.operation_failed), this.f583a.mActivity.getString(R.string.query_secure_code_failed), this.f583a.mActivity.getString(17039370)).m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        }

        public C1275d mo2363a() {
            ((C0384c) this.f583a.mActivity).m51E();
            this.f583a.showLoadingDialog();
            long ad = (long) C1148d.ad(this.f583a.mActivity);
            String ah = C1148d.ah(this.f583a.mActivity);
            String b = C1150y.m2602b(this.f583a.mActivity, "secure_code_md5");
            C1275d c1275d = new C1275d("https://www.domobile.com/servlet/applock");
            c1275d.m3038a("action", "domo_user_reset");
            c1275d.m3038a("app_package", this.f583a.mActivity.getPackageName());
            c1275d.m3038a("version_code", String.valueOf(ad));
            String str = "imei";
            if (TextUtils.isEmpty(ah)) {
                ah = "";
            }
            c1275d.m3038a(str, ah);
            c1275d.m3038a("email", this.f583a.f597n);
            c1275d.m3038a("code_md5", b);
            return c1275d;
        }

        public void mo2364a(String str) {
            this.f583a.hideLoadingDialog();
            try {
                JSONObject jSONObject = new JSONObject(str);
                CharSequence optString = jSONObject.optString("code_md5");
                if (jSONObject.optInt("done") == 1) {
                    if (!TextUtils.isEmpty(optString)) {
                        this.f583a.f588e.setEnabled(true);
                        C1148d.m2520b(this.f583a.mActivity, "secure_code_md5", (Object) optString);
                    }
                    C1148d.m2520b(this.f583a.mActivity, "request_secure_code_time", (Object) Long.valueOf(System.currentTimeMillis()));
                    this.f583a.f596m.setEnabled(false);
                    C1150y.m2567a(this.f583a.mActivity, (int) R.string.operation_success, (int) R.string.query_secure_code_success, 17039370).m3113b((int) R.drawable.ic_dialog_ok_holo_light);
                    this.f583a.f595l.setText(R.string.reset_passwd_title);
                    this.f583a.m766b();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            m758b();
        }
    }

    private void m762a(boolean z) {
        Resources resources = this.mActivity.getResources();
        int color = resources.getColor(R.color.primary_dark_material_light);
        int color2 = resources.getColor(R.color.material_deep_teal_500);
        Drawable a = C1148d.m2502a(resources, (int) R.drawable.abc_btn_radio_to_on_mtrl_015);
        Drawable a2 = C1148d.m2502a(resources, (int) R.drawable.abc_btn_radio_to_on_mtrl_000);
        Drawable mutate = a.mutate();
        mutate.setColorFilter(color2, Mode.SRC_ATOP);
        Drawable mutate2 = a2.mutate();
        mutate2.setColorFilter(color, Mode.SRC_ATOP);
        CheckBox checkBox = this.f590g;
        if (!z) {
            mutate = mutate2;
        }
        checkBox.setCompoundDrawablesWithIntrinsicBounds(mutate, null, null, null);
        mutate = a.mutate();
        mutate.setColorFilter(color2, Mode.SRC_ATOP);
        mutate2 = a2.mutate();
        mutate2.setColorFilter(color, Mode.SRC_ATOP);
        CheckBox checkBox2 = this.f591h;
        if (z) {
            mutate = mutate2;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(mutate, null, null, null);
    }

    private boolean m763a() {
        C1150y b = C1150y.m2598b(this.mActivity);
        C0721a.m998b(this.mActivity, "key_locked_wifi_state");
        C0721a.m998b(this.mActivity, "key_locked_2g3g_state");
        if (b.f2235t || b.f2234s) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                if (b.f2234s) {
                    C0721a.m995a(this.mActivity, "key_locked_wifi_state", false);
                    ((WifiManager) this.mActivity.getApplicationContext().getSystemService("wifi")).setWifiEnabled(true);
                    this.f584a = 1;
                }
                if (b.f2235t) {
                    C0721a.m995a(this.mActivity, "key_locked_2g3g_state", false);
                    SwitcherLockReceiver.m2097a(this.mActivity, true);
                    this.f585b = 1;
                }
                showCancelableLoadingDialog();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.mActivity.registerReceiver(this.f600q, intentFilter);
                return false;
            }
        }
        return true;
    }

    public static boolean m764a(Activity activity) {
        if (C1148d.m2499a((Context) activity, "secure_code_error_times", 0) + 1 < 5) {
            return false;
        }
        if (System.currentTimeMillis() - C1150y.m2596b((Context) activity, "secure_code_error_timemills", 0) > 600000) {
            C1148d.m2534y(activity, "secure_code_error_times");
            return false;
        }
        C1150y.m2567a(activity, (int) R.string.notice, (int) R.string.max_secure_code_error_times, 17039370).m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        return true;
    }

    private void m766b() {
        boolean z = true;
        C1148d.m2509a(this.mActivity, this.f600q);
        if (this.f584a != -1 || this.f585b != -1) {
            SwitcherLockReceiver.m2097a(this.mActivity, false);
            ((WifiManager) this.mActivity.getApplicationContext().getSystemService("wifi")).setWifiEnabled(false);
            if (this.f584a != -1) {
                C0721a.m995a(this.mActivity, "key_locked_wifi_state", this.f584a == 1);
            }
            if (this.f585b != -1) {
                Context context = this.mActivity;
                String str = "key_locked_2g3g_state";
                if (this.f585b != 1) {
                    z = false;
                }
                C0721a.m995a(context, str, z);
            }
        }
    }

    public void m774a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(C1150y.m2602b(this.mActivity, "secure_code_md5"))) {
                this.f588e.setEnabled(false);
                return;
            }
            this.f588e.setText(str);
            this.f595l.performClick();
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence string;
        this.rootView = layoutInflater.inflate(R.layout.retrieve_dialog, null);
        this.mActionBar.m3006b(false);
        this.f586c = (TextView) findViewById(R.id.retrieve_password_question);
        this.f587d = (EditText) findViewById(R.id.retrieve_password_answer);
        this.f589f = (EditText) findViewById(R.id.retrieve_password_secure_email);
        this.f588e = (EditText) findViewById(R.id.retrieve_password_secure_code);
        this.f592i = findViewById(R.id.retrieve_password_radio1_parent);
        this.f593j = findViewById(R.id.retrieve_password_radio2_parent);
        this.f592i.setOnClickListener(this.f599p);
        this.f593j.setOnClickListener(this.f599p);
        this.f590g = (CheckBox) findViewById(R.id.retrieve_password_radio1);
        this.f591h = (CheckBox) findViewById(R.id.retrieve_password_radio2);
        this.f590g.setOnCheckedChangeListener(this);
        this.f591h.setOnCheckedChangeListener(this);
        this.f594k = (Button) findViewById(R.id.retrieve_password_commit_answer);
        this.f595l = (Button) findViewById(R.id.retrieve_password_commit_code);
        this.f596m = (Button) findViewById(R.id.retrieve_password_query_code);
        this.f594k.setOnClickListener(this);
        this.f595l.setOnClickListener(this);
        this.f596m.setOnClickListener(this);
        this.f595l.setEnabled(false);
        this.f596m.setEnabled(System.currentTimeMillis() - C1150y.m2596b(this.mActivity, "request_secure_code_time", 0) > 3600000);
        if (TextUtils.isEmpty(C1150y.m2602b(this.mActivity, "secure_code_md5"))) {
            this.f588e.setEnabled(false);
        } else {
            string = getArguments().getString("EXTRA_SECURE_CODE");
            if (!TextUtils.isEmpty(string)) {
                this.f588e.setText(string);
                this.f595l.performClick();
            }
        }
        this.f587d.setHint(this.mActivity.getString(R.string.please_enter, new Object[]{this.mActivity.getString(R.string.security_answer)}));
        this.f588e.setHint(this.mActivity.getString(R.string.please_enter, new Object[]{this.mActivity.getString(R.string.secure_code)}));
        this.f588e.addTextChangedListener(new C06361(this));
        this.f597n = C1150y.aa(this.mActivity);
        this.f589f.setHint(this.f597n);
        if (TextUtils.isEmpty(this.f597n)) {
            this.f589f.setHint(R.string.empty_secure_email);
        } else {
            this.f589f.setEnabled(false);
        }
        string = C1150y.m2602b(this.mActivity, "security_question");
        if (TextUtils.isEmpty(string)) {
            this.f591h.setChecked(true);
            findViewById(R.id.retrieve_automic_topbox).setVisibility(8);
            return;
        }
        this.f586c.setText(string);
        this.f590g.setChecked(true);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            View findViewById = findViewById(R.id.retrieve_password_layout1);
            View findViewById2 = findViewById(R.id.retrieve_password_layout2);
            if (compoundButton.getId() == R.id.retrieve_password_radio1) {
                m762a(true);
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
            } else if (compoundButton.getId() == R.id.retrieve_password_radio2) {
                m762a(false);
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.retrieve_password_commit_answer) {
            if (C1150y.m2603b(C1148d.m2507a(this.f587d)).equals(C1150y.ab(this.mActivity))) {
                intent = new Intent(this.mActivity, GuideActivity.class);
                intent.putExtra("GoToCore", true);
                this.mActivity.startActivity(intent);
                this.mActivity.setResult(-1);
                this.mActivity.finish();
                return;
            }
            C1148d.m2519b(this.mActivity, this.f587d);
            C1147a.m2485d(this.mActivity, R.string.security_answer_error);
        } else if (view.getId() == R.id.retrieve_password_commit_code) {
            if (!m764a(this.mActivity)) {
                CharSequence b = C1150y.m2602b(this.mActivity, "secure_code_md5");
                String obj = this.f588e.getText().toString();
                if (TextUtils.isEmpty(b) || TextUtils.isEmpty(obj) || !b.equalsIgnoreCase(HidedPictureItem.m275b(C1375l.m3481c(this.mActivity, C1150y.m2632i(obj))))) {
                    if (!(TextUtils.isEmpty(b) || TextUtils.isEmpty(obj))) {
                        C1148d.m2520b(this.mActivity, "secure_code_error_times", (Object) Integer.valueOf(C1148d.m2499a(this.mActivity, "secure_code_error_times", 0) + 1));
                        C1148d.m2520b(this.mActivity, "secure_code_error_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
                    }
                    C1148d.m2519b(this.mActivity, this.f588e);
                    C1147a.m2485d(this.mActivity, R.string.invalid_secure_code);
                    return;
                }
                C1150y.m2661w(this.mActivity);
                C1148d.m2534y(this.mActivity, "image_lock_pattern");
                C1148d.m2534y(this.mActivity, "first_launch");
                C1148d.m2534y(this.mActivity, "secure_code_error_times");
                this.mActivity.stopService(new Intent(this.mActivity, LockService.class));
                C1148d.m2534y(this.mActivity, "secure_code_md5");
                intent = new Intent(this.mActivity, GuideActivity.class);
                intent.putExtra("GoToCore", true);
                this.mActivity.startActivity(intent);
                this.mActivity.setResult(-1);
                this.mActivity.finish();
            }
        } else if (view.getId() == R.id.retrieve_password_query_code) {
            if (TextUtils.isEmpty(this.f597n)) {
                if (TextUtils.isEmpty(this.f589f.getText())) {
                    C1147a.m2485d(this.mActivity, R.string.empty_secure_email);
                    return;
                } else if (C1150y.m2631h(this.f589f.getText().toString())) {
                    this.f597n = this.f589f.getText().toString();
                    C1150y.m2657u(this.mActivity, this.f597n);
                    C1147a.m2485d(this.mActivity, R.string.secure_email_saved);
                    this.f589f.setEnabled(false);
                } else {
                    C1147a.m2485d(this.mActivity, R.string.email_error);
                    return;
                }
            }
            if (m763a()) {
                C1148d.m2516a(new C1276e(), new C0639a(this));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBar.m3010d(true);
        ((C0384c) this.mActivity).m69u();
        C1150y.m2605b(this.mActivity, (int) R.string.event_retrieve_password);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.retrieve_password_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_help) {
            return super.onOptionsItemSelected(menuItem);
        }
        C1148d.m2492D(this.mActivity, getString(R.string.url_retrieve_password_guide));
        this.f598o = true;
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.f598o) {
            findViewById(R.id.vgSupportEmail).setVisibility(0);
        }
    }

    public void onStop() {
        super.onStop();
        m766b();
    }

    public void ui(int i, Message message) {
    }
}
