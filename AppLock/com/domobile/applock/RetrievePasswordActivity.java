package com.domobile.applock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View.OnClickListener;

public class RetrievePasswordActivity extends C0385b implements OnClickListener {
    ab f536a;

    @Nullable
    private String m666a(Intent intent) {
        String str = "";
        if (!"android.intent.action.VIEW".equals(intent.getAction())) {
            return str;
        }
        Uri data = intent.getData();
        return data != null ? data.getFragment() : str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m56b(R.string.forget_passwd_title);
        Bundle bundle2 = new Bundle();
        bundle2.putString("EXTRA_SECURE_CODE", m666a(getIntent()));
        this.f536a = new ab();
        this.f536a.setArguments(bundle2);
        m52a(this.f536a);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f536a != null) {
            this.f536a.m774a(m666a(intent));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
