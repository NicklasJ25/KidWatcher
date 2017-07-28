package com.android.camera;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.domobile.applock.C0386c;
import com.domobile.applock.MainActivity;
import com.domobile.applock.MainTabFragmentActivity;
import com.domobile.frame.p000a.C1148d;

public class MediaTransferActivity extends C0386c {
    private C0426f f48d;

    public void mo2042a() {
        if (getIntent().getBooleanExtra("com.domobile.elock.EXTRA_ACTIVITY", false)) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (MainTabFragmentActivity.m633l() == null) {
            startActivity(new Intent(this, MainTabFragmentActivity.class).putExtra("com.domobile.elock.EXTRA_IS_VIDEO_TYPE", this.f48d.f134a));
        }
        super.mo2042a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        this.f48d = new C0426f();
        m52a(this.f48d);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f48d != null ? this.f48d.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }
}
