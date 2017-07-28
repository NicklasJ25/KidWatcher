package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.camera.MediaTransferActivity;
import com.domobile.applock.service.HidedMediasActionService;
import com.domobile.applock.service.LockService;
import com.domobile.applock.service.UpdateService;
import com.domobile.eframe.C1217c;
import com.domobile.eframe.C1224e;
import com.domobile.eframe.DatabaseErrorActivity;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lockbean.C1358a;

public class MainActivity extends Activity {
    boolean f473a = false;

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2584a((Context) this, C1224e.m2873a((Context) this));
        String str = null;
        sendBroadcast(new Intent("com.domobile.applock.ACTION_DISABLE_THEME_LAUNCHER").setFlags(32));
        long b = UpdateService.m2276b((Context) this);
        if (b > 0) {
            UpdateService.m2266a((Context) this, b);
        }
        if (C1217c.m2853a() == null) {
            if (!C1150y.m2566a((Context) this).f428c) {
                startActivity(new Intent(this, DatabaseErrorActivity.class));
            }
            finish();
            return;
        }
        startService(new Intent(this, LockService.class));
        C1358a.m3402a((Context) this);
        C1148d.m2489A(this, "com.domobile.elock.action.CHANGE_NOTIFY");
        if (getIntent().getBooleanExtra("com.domobile.elock.EXTRA_NOT_OPEN_ACTIVITY", false)) {
            finish();
        } else if (HidedMediasActionService.m2133a() != null && HidedMediasActionService.m2151d()) {
            startActivity(new Intent(this, MediaTransferActivity.class).putExtra("com.domobile.elock.EXTRA_ACTIVITY", true));
            finish();
        } else if (str == null || str.indexOf("a02190205146de") != -1) {
            C1148d.m2489A(this, "com.domobile.elock.main_finish");
            Intent intent = new Intent(this, VerifyActivity.class);
            Intent intent2 = getIntent();
            if (intent2 != null) {
                intent.putExtras(intent2);
                intent.setAction(intent2.getAction());
            }
            startActivity(intent);
            finish();
        } else {
            throw new IndexOutOfBoundsException("a02190205146de");
        }
    }
}
