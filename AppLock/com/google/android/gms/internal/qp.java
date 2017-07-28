package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@wh
public class qp implements mj {
    @Nullable
    private CustomTabsSession f10351a;
    @Nullable
    private CustomTabsClient f10352b;
    @Nullable
    private CustomTabsServiceConnection f10353c;
    @Nullable
    private C3177a f10354d;

    public interface C3177a {
    }

    public static boolean m13332a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(mh.m12561a(context));
            }
        }
        return false;
    }

    @Nullable
    public CustomTabsSession m13333a() {
        if (this.f10352b == null) {
            this.f10351a = null;
        } else if (this.f10351a == null) {
            this.f10351a = this.f10352b.newSession(null);
        }
        return this.f10351a;
    }

    public void m13334a(Activity activity) {
        if (this.f10353c != null) {
            activity.unbindService(this.f10353c);
            this.f10352b = null;
            this.f10351a = null;
            this.f10353c = null;
        }
    }

    public void m13335a(C3177a c3177a) {
        this.f10354d = c3177a;
    }

    public void m13336b(Activity activity) {
        if (this.f10352b == null) {
            String a = mh.m12561a(activity);
            if (a != null) {
                this.f10353c = new mi(this);
                CustomTabsClient.bindCustomTabsService(activity, a, this.f10353c);
            }
        }
    }
}
