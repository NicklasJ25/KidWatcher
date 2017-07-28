package com.domobile.applock;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

public class GuideActivity extends C0385b {
    C0951i f472a = null;

    public void onBackPressed() {
        if (!this.f472a.m1717c()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 2) {
            setRequestedOrientation(1);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f472a == null) {
            this.f472a = new C0951i();
        }
        this.f472a.m1715b(bundle);
        m52a(this.f472a);
        m70v();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return (i == 84 && keyEvent.getRepeatCount() == 0) ? true : i == 82 && keyEvent.getRepeatCount() == 0;
        } else {
            if (this.f472a.m1717c()) {
                return true;
            }
            finish();
            return true;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f472a != null) {
            this.f472a.m1712a(bundle);
        }
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
