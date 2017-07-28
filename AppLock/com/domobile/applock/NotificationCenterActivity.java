package com.domobile.applock;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.domobile.frame.p000a.C1148d;

public class NotificationCenterActivity extends C0386c {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        Toolbar r = m66r();
        m56b(R.string.notification_lock_title);
        r.setNavigationIcon((int) R.drawable.icon_notification_applock);
        r.setNavigationOnClickListener(null);
        m52a(new C1047s());
    }
}
