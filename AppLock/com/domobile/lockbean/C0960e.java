package com.domobile.lockbean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;

public class C0960e {
    protected Context f1528a;
    protected View f1529b;
    protected ImageView f1530c;
    protected TextView f1531d;
    protected boolean f1532e = false;

    public void mo2455a(Drawable drawable) {
        this.f1530c.setImageDrawable(drawable);
    }

    public void m1731a(String str) {
        try {
            if ("com.domobile.elock.appdetail".equals(str)) {
                mo2455a(C1148d.m2502a(this.f1528a.getResources(), (int) R.drawable.icon));
                m1733b(this.f1528a.getString(R.string.app_details));
            } else if ("com.domobile.elock.device_admin".equals(str)) {
                mo2455a(C1148d.m2502a(this.f1528a.getResources(), (int) R.drawable.icon));
                m1733b(this.f1528a.getString(R.string.device_admin));
            } else {
                PackageManager packageManager = this.f1528a.getPackageManager();
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                mo2455a(packageManager.getApplicationIcon(str));
                if ("com.android.phone".equals(str)) {
                    m1733b(this.f1528a.getString(R.string.in_call));
                } else {
                    m1733b((String) packageManager.getApplicationLabel(applicationInfo));
                }
            }
        } catch (Exception e) {
        }
    }

    protected View m1732b(int i) {
        return this.f1529b.findViewById(i);
    }

    public void m1733b(String str) {
        if (this.f1531d != null) {
            this.f1531d.setText(str);
        }
    }

    public void m1734c(int i) {
        m1733b(this.f1528a.getString(i));
    }

    public View m1735h() {
        return this.f1529b;
    }

    public ImageView m1736i() {
        return this.f1530c;
    }
}
