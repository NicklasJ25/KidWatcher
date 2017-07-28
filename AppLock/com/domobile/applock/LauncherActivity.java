package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.domobile.eframe.C1224e;

public class LauncherActivity extends Activity {
    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2584a((Context) this, C1224e.m2873a((Context) this));
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
