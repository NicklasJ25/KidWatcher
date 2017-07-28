package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.Scene;
import com.domobile.p017d.C1213a;

public class ActiveProfileActivity extends C0386c {
    private Handler f407d = new Handler();
    private boolean f408e = true;
    private long f409k = -100;
    private String f410l;

    class C05821 extends Thread {
        final /* synthetic */ ActiveProfileActivity f404a;

        C05821(ActiveProfileActivity activeProfileActivity) {
            this.f404a = activeProfileActivity;
        }

        public void run() {
            this.f404a.m567a(new Scene(this.f404a.f409k, this.f404a.f410l));
            this.f404a.finish();
        }
    }

    private void m567a(Scene scene) {
        if (C1150y.m2643m(this)) {
            m569b(getString(R.string.billing_free_mode_summary));
            return;
        }
        m49C();
        if (C1017n.m2041c(scene.f2922a)) {
            m569b(getString(R.string.startup_success, new Object[]{scene.f2923b}));
            C1148d.m2489A(this, "com.domobile.elock.proctect_list_change");
        } else {
            m569b(getString(R.string.startup_failed, new Object[]{scene.f2923b}));
        }
        m51E();
    }

    private void m569b(final String str) {
        this.f407d.post(new Runnable(this) {
            final /* synthetic */ ActiveProfileActivity f406b;

            public void run() {
                C1147a.m2487w(this.f406b.getBaseContext(), str);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (C1213a.m2845a(i, i2, intent)) {
            new C05821(this).start();
        } else {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        Intent intent = getIntent();
        this.f409k = intent.getLongExtra("com.domobile.applock.EXTRA_PROFILE_ID", -100);
        this.f410l = intent.getStringExtra("com.domobile.applock.EXTRA_PROFILE_NAME");
        if (this.f409k == -100) {
            m569b(getString(R.string.startup_failed, new Object[]{this.f410l}));
            finish();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("unlock_app_appname", this.f410l);
        C1213a.m2847a((Context) this, "locked_active_profile_activity", true);
        C1213a.m2842a((Activity) this, bundle2, "locked_active_profile_activity");
        C1150y.m2605b((Context) this, (int) R.string.event_active_profile);
    }

    protected void onResume() {
        super.onResume();
        if (this.f408e) {
            m80e();
        }
        this.f408e = false;
    }
}
