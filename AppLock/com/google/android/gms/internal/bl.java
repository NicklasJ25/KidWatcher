package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.C2590o;

public class bl {
    protected final Context f7979a;

    public bl(Context context) {
        this.f7979a = context;
    }

    public int m9112a(String str) {
        return this.f7979a.checkCallingOrSelfPermission(str);
    }

    public int m9113a(String str, String str2) {
        return this.f7979a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo m9114a(String str, int i) {
        return this.f7979a.getPackageManager().getApplicationInfo(str, i);
    }

    public boolean m9115a() {
        return Binder.getCallingUid() == Process.myUid() ? bk.m9111a(this.f7979a) : false;
    }

    @TargetApi(19)
    public boolean m9116a(int i, String str) {
        if (C2590o.m8312g()) {
            try {
                ((AppOpsManager) this.f7979a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f7979a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public String[] m9117a(int i) {
        return this.f7979a.getPackageManager().getPackagesForUid(i);
    }

    public PackageInfo m9118b(String str, int i) {
        return this.f7979a.getPackageManager().getPackageInfo(str, i);
    }

    public CharSequence m9119b(String str) {
        return this.f7979a.getPackageManager().getApplicationLabel(this.f7979a.getPackageManager().getApplicationInfo(str, 0));
    }
}
