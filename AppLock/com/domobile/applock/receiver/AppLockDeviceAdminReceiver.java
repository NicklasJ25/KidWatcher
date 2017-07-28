package com.domobile.applock.receiver;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import com.domobile.applock.R;
import com.domobile.applock.service.LockService;
import com.domobile.frame.p000a.C1148d;

public class AppLockDeviceAdminReceiver extends DeviceAdminReceiver {
    public CharSequence onDisableRequested(Context context, Intent intent) {
        context.startService(new Intent(context, LockService.class));
        return context.getString(R.string.device_admin_disabled_warning);
    }

    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        C1148d.m2489A(context, "com.domobile.elock.ACTION_DEVICE_ADMIN_STATUS_CHENGED");
    }

    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        C1148d.m2489A(context, "com.domobile.elock.ACTION_DEVICE_ADMIN_STATUS_CHENGED");
    }
}
