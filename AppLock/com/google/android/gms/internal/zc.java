package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

@wh
public class zc {
    long f11606a = -1;
    long f11607b = -1;
    int f11608c = -1;
    int f11609d = -1;
    long f11610e = 0;
    final String f11611f;
    int f11612g = 0;
    int f11613h = 0;
    private final Object f11614i = new Object();

    public zc(String str) {
        this.f11611f = str;
    }

    public static boolean m15038a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            aad.m8425d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            aad.m8425d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            aad.m8426e("Fail to fetch AdActivity theme");
            aad.m8425d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public long m15039a() {
        return this.f11607b;
    }

    public Bundle m15040a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f11614i) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f11611f);
            bundle.putLong("basets", this.f11607b);
            bundle.putLong("currts", this.f11606a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f11608c);
            bundle.putInt("preqs_in_session", this.f11609d);
            bundle.putLong("time_in_session", this.f11610e);
            bundle.putInt("pclick", this.f11612g);
            bundle.putInt("pimp", this.f11613h);
            bundle.putBoolean("support_transparent_background", m15038a(context));
        }
        return bundle;
    }

    public void m15041a(int i) {
        this.f11609d = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15042a(com.google.android.gms.internal.zzec r11, long r12) {
        /*
        r10 = this;
        r1 = r10.f11614i;
        monitor-enter(r1);
        r0 = com.google.android.gms.ads.internal.zzw.zzcQ();	 Catch:{ all -> 0x0055 }
        r2 = r0.m15025n();	 Catch:{ all -> 0x0055 }
        r0 = com.google.android.gms.ads.internal.zzw.zzcS();	 Catch:{ all -> 0x0055 }
        r4 = r0.mo3360a();	 Catch:{ all -> 0x0055 }
        r6 = r10.f11607b;	 Catch:{ all -> 0x0055 }
        r8 = -1;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0058;
    L_0x001b:
        r2 = r4 - r2;
        r0 = com.google.android.gms.internal.qb.aL;	 Catch:{ all -> 0x0055 }
        r0 = r0.m13225c();	 Catch:{ all -> 0x0055 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x0055 }
        r6 = r0.longValue();	 Catch:{ all -> 0x0055 }
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x0049;
    L_0x002d:
        r0 = -1;
        r10.m15041a(r0);	 Catch:{ all -> 0x0055 }
    L_0x0031:
        r10.f11607b = r12;	 Catch:{ all -> 0x0055 }
        r2 = r10.f11607b;	 Catch:{ all -> 0x0055 }
        r10.f11606a = r2;	 Catch:{ all -> 0x0055 }
    L_0x0037:
        r0 = r11.f11879c;	 Catch:{ all -> 0x0055 }
        if (r0 == 0) goto L_0x005b;
    L_0x003b:
        r0 = r11.f11879c;	 Catch:{ all -> 0x0055 }
        r2 = "gw";
        r3 = 2;
        r0 = r0.getInt(r2, r3);	 Catch:{ all -> 0x0055 }
        r2 = 1;
        if (r0 != r2) goto L_0x005b;
    L_0x0047:
        monitor-exit(r1);	 Catch:{ all -> 0x0055 }
    L_0x0048:
        return;
    L_0x0049:
        r0 = com.google.android.gms.ads.internal.zzw.zzcQ();	 Catch:{ all -> 0x0055 }
        r0 = r0.m15027p();	 Catch:{ all -> 0x0055 }
        r10.m15041a(r0);	 Catch:{ all -> 0x0055 }
        goto L_0x0031;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0055 }
        throw r0;
    L_0x0058:
        r10.f11606a = r12;	 Catch:{ all -> 0x0055 }
        goto L_0x0037;
    L_0x005b:
        r0 = r10.f11608c;	 Catch:{ all -> 0x0055 }
        r0 = r0 + 1;
        r10.f11608c = r0;	 Catch:{ all -> 0x0055 }
        r0 = r10.f11609d;	 Catch:{ all -> 0x0055 }
        r0 = r0 + 1;
        r10.f11609d = r0;	 Catch:{ all -> 0x0055 }
        r0 = r10.f11609d;	 Catch:{ all -> 0x0055 }
        if (r0 != 0) goto L_0x0078;
    L_0x006b:
        r2 = 0;
        r10.f11610e = r2;	 Catch:{ all -> 0x0055 }
        r0 = com.google.android.gms.ads.internal.zzw.zzcQ();	 Catch:{ all -> 0x0055 }
        r0.m15003b(r4);	 Catch:{ all -> 0x0055 }
    L_0x0076:
        monitor-exit(r1);	 Catch:{ all -> 0x0055 }
        goto L_0x0048;
    L_0x0078:
        r0 = com.google.android.gms.ads.internal.zzw.zzcQ();	 Catch:{ all -> 0x0055 }
        r2 = r0.m15026o();	 Catch:{ all -> 0x0055 }
        r2 = r4 - r2;
        r10.f11610e = r2;	 Catch:{ all -> 0x0055 }
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zc.a(com.google.android.gms.internal.zzec, long):void");
    }

    public void m15043b() {
        synchronized (this.f11614i) {
            this.f11612g++;
        }
    }

    public void m15044c() {
        synchronized (this.f11614i) {
            this.f11613h++;
        }
    }

    public int m15045d() {
        return this.f11609d;
    }
}
