package com.domobile.eframe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.domobile.applock.C1017n;
import com.domobile.applock.C1140x.C1133a;
import com.domobile.applock.C1140x.C1137e;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.service.LockService;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import java.util.List;

public class DatabaseErrorActivity extends Activity implements OnClickListener, OnDismissListener {
    private void m2851a() {
        C1137e c1137e = C1149b.f2209G;
        Object[] objArr = new Object[1];
        C1137e c1137e2 = C1149b.f2209G;
        objArr[0] = getString(R.string.app_name);
        C1288c a = new C1288c(this).mo2528a(getString(R.string.database_open_error_content, objArr));
        C1137e c1137e3 = C1149b.f2209G;
        a.m3101a((int) R.string.database_open_error_title);
        C1133a c1133a = C1149b.f2208F;
        a.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        a.m3114b(17039370, (OnClickListener) this);
        a.m3107a((OnDismissListener) this);
        a.m3117b(true).m3122d();
    }

    private void m2852a(final String str) {
        try {
            if (str.contains("com.domobile.applock")) {
                finish();
                return;
            }
            PackageManager packageManager = getPackageManager();
            if (packageManager.getLaunchIntentForPackage(str) == null) {
                finish();
                return;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setPackage(str);
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                CharSequence string = getString(R.string.lock_app_when_installed, new Object[]{packageManager.getPackageInfo(str, 0).applicationInfo.loadLabel(packageManager)});
                C1288c c1288c = new C1288c(this);
                c1288c.m3101a((int) R.string.app_name).mo2528a(string);
                c1288c.m3107a((OnDismissListener) this);
                c1288c.m3120c((int) R.drawable.icon);
                c1288c.m3102a(17039360, null);
                c1288c.m3114b(17039370, new OnClickListener(this) {
                    final /* synthetic */ DatabaseErrorActivity f2393b;

                    public void onClick(View view) {
                        C1150y b = C1150y.m2598b(this.f2393b.getBaseContext());
                        C1148d.m2534y(this.f2393b.getBaseContext(), "actived_profile");
                        if (!(b.f2238w && LockService.m2172a())) {
                            b.m2665a(this.f2393b.getBaseContext(), true);
                        }
                        C1017n.m2035a(str, 1);
                        C1148d.m2489A(this.f2393b.getBaseContext(), "com.domobile.elock.proctect_list_change");
                    }
                }).m3117b(true).m3122d();
                return;
            }
            finish();
        } catch (Exception e) {
            finish();
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void onClick(View view) {
        C1148d.m2495G(this, getPackageName());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object stringExtra = getIntent().getStringExtra("com.domobile.elock.packagename");
        if (TextUtils.isEmpty(stringExtra)) {
            C1150y.m2566a((Context) this).f428c = true;
            if (C1217c.m2853a() == null) {
                m2851a();
                return;
            }
            return;
        }
        m2852a(stringExtra);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1150y.m2566a((Context) this).f428c = false;
    }

    public void onDismiss() {
        finish();
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
