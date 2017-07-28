package com.domobile.applock;

import android.os.Bundle;
import android.view.KeyEvent;

public class ScenesActivity extends C0386c {
    private ae f537d = null;

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_clear_mtrl_alpha);
        Bundle extras = getIntent().getExtras();
        this.f537d = new ae();
        this.f537d.setArguments(extras);
        m52a(this.f537d);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (i == 4 && keyEvent.getRepeatCount() == 0 && this.f537d.m933c()) ? true : super.onKeyDown(i, keyEvent);
    }
}
