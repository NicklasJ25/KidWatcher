package com.domobile.applock;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;

public class C0634a extends C0400d implements OnClickListener {
    public static void m756a(Activity activity) {
        String string = activity.getString(R.string.url_facebook);
        try {
            if (activity.getPackageManager().getApplicationInfo("com.facebook.katana", 0).enabled) {
                string = C1147a.m2480a("fb://facewebmodal/f?href=", string);
            }
        } catch (NameNotFoundException e) {
        }
        try {
            C1148d.m2492D(activity, string);
        } catch (Exception e2) {
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.about_activity, null);
        C1148d.m2514a(findViewById(R.id.about_header), C1148d.m2501a(this.mActivity, BitmapFactory.decodeResource(this.mActivity.getResources(), R.drawable.leftmenu_header)));
        try {
            ((TextView) findViewById(R.id.about_app_version)).setText("v" + this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        findViewById(R.id.about_email).setOnClickListener(this);
        findViewById(R.id.about_weburl).setOnClickListener(this);
        findViewById(R.id.about_change_log).setOnClickListener(this);
        findViewById(R.id.about_facebook).setOnClickListener(this);
        findViewById(R.id.about_twitter).setOnClickListener(this);
        findViewById(R.id.about_gplus).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.about_facebook) {
            this.b.m80e();
            C0634a.m756a(this.mActivity);
        } else if (view.getId() == R.id.about_twitter) {
            this.b.m80e();
            C1148d.m2492D(this.mActivity, "http://www.twitter.com/bestapplock");
        } else if (view.getId() == R.id.about_gplus) {
            this.b.m80e();
            C1148d.m2492D(this.mActivity, this.mActivity.getString(R.string.url_goole_plus));
        } else if (view.getId() == R.id.about_email) {
            this.b.m80e();
            C1148d.m2496H(this.mActivity, null);
        } else if (view.getId() == R.id.about_weburl) {
            this.b.m80e();
            C1148d.m2492D(this.mActivity, "http://www.domobile.com");
        } else if (view.getId() == R.id.about_change_log) {
            C1148d.m2532g(this.mActivity).m3117b(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.about);
        C1150y.m2605b(this.mActivity, (int) R.string.event_about);
    }

    public void onResume() {
        super.onResume();
        this.b.m72x();
    }

    public void ui(int i, Message message) {
    }
}
