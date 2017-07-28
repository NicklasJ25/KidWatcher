package com.domobile.lockbean;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.android.gallery3d.BuildConfig;
import java.util.Comparator;

public class C1370i {
    private static Comparator<C1370i> f2950j;
    public int f2951a;
    public String f2952b = "";
    public String f2953c = "";
    public ComponentName f2954d = null;
    public boolean f2955e = false;
    public boolean f2956f = false;
    public boolean f2957g = false;
    private int f2958h = -1;
    private Drawable f2959i = null;

    static class C13691 implements Comparator<C1370i> {
        C13691() {
        }

        public int m3447a(C1370i c1370i, C1370i c1370i2) {
            if (c1370i == null || TextUtils.isEmpty(c1370i.f2952b)) {
                return 1;
            }
            if (c1370i2 == null || TextUtils.isEmpty(c1370i2.f2952b)) {
                return -1;
            }
            if (c1370i.f2955e && !c1370i2.f2955e) {
                return -1;
            }
            if (!c1370i.f2955e && c1370i2.f2955e) {
                return 1;
            }
            boolean a = C1370i.m3448a(c1370i.f2953c);
            boolean a2 = C1370i.m3448a(c1370i2.f2953c);
            return a == a2 ? (a && C1370i.m3449b(c1370i.f2953c)) ? 1 : (a2 && C1370i.m3449b(c1370i2.f2953c)) ? -1 : c1370i.f2952b.compareToIgnoreCase(c1370i2.f2952b) : !a2 ? -1 : 1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3447a((C1370i) obj, (C1370i) obj2);
        }
    }

    public C1370i(boolean z) {
        this.f2956f = z;
    }

    public static boolean m3448a(String str) {
        return TextUtils.equals("com.android.mms", str) || TextUtils.equals("com.google.android.email", str) || TextUtils.equals("com.android.email", str) || TextUtils.equals("com.google.android.gm", str) || C1370i.m3449b(str);
    }

    public static boolean m3449b(String str) {
        return TextUtils.equals("com.cooliris.media", str) || TextUtils.equals(BuildConfig.APPLICATION_ID, str) || TextUtils.equals("com.google.android.gallery3d", str) || TextUtils.equals("com.sec.android.gallery3d", str) || TextUtils.equals("com.android.gallery", str);
    }

    public static Comparator<C1370i> m3450c() {
        if (f2950j == null) {
            f2950j = new C13691();
        }
        return f2950j;
    }

    public Drawable m3451a() {
        return this.f2959i;
    }

    public Drawable m3452a(PackageManager packageManager) {
        try {
            return packageManager.getActivityIcon(this.f2954d);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void m3453a(int i) {
        this.f2958h = i;
    }

    public void m3454a(Drawable drawable) {
        this.f2959i = drawable;
    }

    public int m3455b() {
        return this.f2958h != -1 ? this.f2958h : this.f2956f ? 0 : 1;
    }
}
