package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class FingerPrintActivity extends Activity {
    public static void m616a(AppLockApplication appLockApplication) {
        appLockApplication.f436k = true;
        appLockApplication.startActivity(new Intent(appLockApplication, FingerPrintActivity.class).setFlags(268435456));
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AppLockApplication a = C1150y.m2566a((Context) this);
        if (a.f435j != null) {
            a.f435j.m3425a();
        }
        finish();
    }
}
