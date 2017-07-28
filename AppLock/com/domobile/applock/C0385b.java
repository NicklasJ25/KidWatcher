package com.domobile.applock;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.domobile.eframe.C1224e;
import com.domobile.frame.C0384c;

public abstract class C0385b extends C0384c implements OnClickListener {
    public void mo2040c() {
        super.mo2040c();
        if (this.h != null) {
            this.h.setBackgroundResource(R.color.actionbar_toolbar_background);
        }
    }

    public void mo2041d() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1150y.m2584a((Context) this, C1224e.m2873a((Context) this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2584a((Context) this, C1224e.m2873a((Context) this));
    }

    protected void onResume() {
        super.onResume();
        C1150y.m2584a((Context) this, C1224e.m2873a((Context) this));
    }
}
