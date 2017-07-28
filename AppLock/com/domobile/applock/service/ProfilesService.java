package com.domobile.applock.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.domobile.applock.C1017n;
import com.domobile.applock.R;
import com.domobile.applock.receiver.CodeSetReceiver;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;

public class ProfilesService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        long longExtra = intent.getLongExtra("com.domobile.applock.EXTRA_PROFILE_ID", -2);
        CharSequence stringExtra = intent.getStringExtra("com.domobile.applock.EXTRA_PROFILE_NAME");
        Object stringExtra2 = intent.getStringExtra("com.domobile.applock.EXTRA_PROFILE_MESSAGE");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = longExtra == -2 ? getString(R.string.guest_profile) : longExtra == -1 ? getString(R.string.default_profile) : "";
        }
        try {
            if (C1017n.m2041c(longExtra)) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    C1147a.m2487w(this, getString(R.string.startup_success, new Object[]{stringExtra}));
                } else {
                    C1147a.m2487w(this, stringExtra2);
                }
                C1148d.m2489A(this, "com.domobile.elock.proctect_list_change");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        CodeSetReceiver.m2089a((Service) this, i2);
        return super.onStartCommand(intent, i, i2);
    }
}
