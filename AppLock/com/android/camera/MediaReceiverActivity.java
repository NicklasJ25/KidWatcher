package com.android.camera;

import android.content.Context;
import android.os.Bundle;
import com.domobile.applock.C0386c;
import com.domobile.frame.p000a.C1148d;

public class MediaReceiverActivity extends C0386c {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        String action = getIntent().getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
            m52a(new C0426f());
        } else {
            finish();
        }
    }
}
