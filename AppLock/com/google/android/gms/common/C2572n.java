package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C2571l.C2565a;
import com.google.android.gms.common.C2571l.C2566b;
import com.google.android.gms.common.C2571l.C2570d;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.bm;

public class C2572n {
    private static C2572n f7530a;
    private final Context f7531b;
    private final bl f7532c = bm.m9120b(this.f7531b);

    private C2572n(Context context) {
        this.f7531b = context.getApplicationContext();
    }

    public static C2572n m8220a(Context context) {
        C2513c.m7932a((Object) context);
        synchronized (C2572n.class) {
            if (f7530a == null) {
                C2571l.m8216a(context);
                f7530a = new C2572n(context);
            }
        }
        return f7530a;
    }

    C2565a m8221a(PackageInfo packageInfo, C2565a... c2565aArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C2566b c2566b = new C2566b(packageInfo.signatures[0].toByteArray());
        while (i < c2565aArr.length) {
            if (c2565aArr[i].equals(c2566b)) {
                return c2565aArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m8222a(int i) {
        String[] a = this.f7532c.m9117a(i);
        if (a == null || a.length == 0) {
            return false;
        }
        for (String a2 : a) {
            if (m8227a(a2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m8223a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (C2489m.m7867d(this.f7531b)) {
            return m8229b(packageInfo, true);
        }
        boolean b = m8229b(packageInfo, false);
        if (b || !m8229b(packageInfo, true)) {
            return b;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return b;
    }

    public boolean m8224a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C2565a a;
            if (z) {
                a = m8221a(packageInfo, C2570d.f7526a);
            } else {
                a = m8221a(packageInfo, C2570d.f7526a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean m8225a(PackageManager packageManager, int i) {
        return m8222a(i);
    }

    @Deprecated
    public boolean m8226a(PackageManager packageManager, PackageInfo packageInfo) {
        return m8228b(packageInfo);
    }

    public boolean m8227a(String str) {
        try {
            return m8223a(this.f7532c.m9118b(str, 64));
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public boolean m8228b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m8224a(packageInfo, false)) {
            return true;
        }
        if (!m8224a(packageInfo, true)) {
            return false;
        }
        if (C2489m.m7867d(this.f7531b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    boolean m8229b(PackageInfo packageInfo, boolean z) {
        boolean z2 = false;
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        } else {
            C2565a c2566b = new C2566b(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            z2 = z ? C2571l.m8219b(str, c2566b) : C2571l.m8218a(str, c2566b);
            if (!z2) {
                Log.d("GoogleSignatureVerifier", "Cert not in list. atk=" + z);
            }
        }
        return z2;
    }
}
