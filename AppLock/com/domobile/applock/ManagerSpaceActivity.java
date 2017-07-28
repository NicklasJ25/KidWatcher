package com.domobile.applock;

import android.content.Context;
import android.os.Bundle;
import com.domobile.frame.p000a.C1148d;

public class ManagerSpaceActivity extends C0386c {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        m52a(new C1038q());
    }
}
