package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.applock.service.ProfilesService;
import com.domobile.frame.p000a.C1148d;
import com.domobile.imagelock.C1316a;

public class VerifyActivity extends C0385b {
    public boolean f504a = false;
    private C0741f f505b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_verify);
        Intent intent = new Intent("com.domobile.elock.verify_pass");
        intent.putExtra("verify_package", getPackageName());
        C1148d.m2510a((Context) this, intent);
        if (getIntent().getBooleanExtra("FORCE_PATTERN", false) && C1150y.m2537B(this)) {
            this.f505b = new C1316a();
        } else if (getIntent().getBooleanExtra("FORCE_NUMLOCK", false) || !C1150y.m2536A(this)) {
            this.f505b = new al();
        } else {
            this.f505b = new C1316a();
        }
        m52a(this.f505b);
    }

    protected void onDestroy() {
        SwitcherLockReceiver.m2093a((Activity) this);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f505b.onKeyDown(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onStop() {
        super.onStop();
        String action = getIntent().getAction();
        if ("com.domobile.applock.ACTION_STARTUP_PROFILE_EXPORT".equals(action)) {
            boolean booleanExtra = getIntent().getBooleanExtra("com.domobile.applock.EXTRA_AUTO_STARTUP_GUEST", true);
            if (!this.f504a && booleanExtra) {
                startService(new Intent(this, ProfilesService.class));
            }
            finish();
        } else if ("com.domobile.applock.plugins.ACTION_PLEASE_UNLOCK_APP".equals(action) && !this.f504a) {
            sendBroadcast(new Intent("com.domobile.applock.plugins.ACTION_PLEASE_UNLOCK_REFUSED").setPackage(getIntent().getStringExtra("unlock_app_pkgname")));
            finish();
        }
    }
}
