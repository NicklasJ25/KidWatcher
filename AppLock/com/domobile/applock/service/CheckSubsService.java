package com.domobile.applock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p001a.C0581a;
import com.domobile.p001a.C0581a.C0569a;
import com.domobile.p001a.p002a.C0576d;
import com.domobile.p001a.p002a.C0577e;
import com.domobile.p001a.p002a.C0578f;

public class CheckSubsService extends Service implements C0569a {
    private C0581a f1899a;

    class C10481 extends Thread {
        final /* synthetic */ CheckSubsService f1898a;

        C10481(CheckSubsService checkSubsService) {
            this.f1898a = checkSubsService;
        }

        public void run() {
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
            }
            this.f1898a.m2122b();
        }
    }

    private void m2119a() {
        int a = C1148d.m2499a((Context) this, "subscription_failed_times", 0) + 1;
        C1148d.m2520b((Context) this, "subscription_failed_times", (Object) Integer.valueOf(a));
        if (a >= 10) {
            C0581a.m553b(this, "applock_subs_monthly");
            C0581a.m553b(this, "applock_subs_yearly");
            C0581a.m553b(this, "applock_subscription_yearly");
        }
    }

    public static boolean m2121a(Context context) {
        long b = C1150y.m2596b(context, "chech_subscription_time", 0);
        return b > System.currentTimeMillis() || System.currentTimeMillis() - b > 86400000;
    }

    private void m2122b() {
        if (UpdateService.f2005a) {
            stopForeground(true);
        }
        stopSelf();
    }

    public void mo2447a(C0576d c0576d) {
        if (c0576d == null || !c0576d.m526b()) {
            m2119a();
            C1148d.m2520b((Context) this, "chech_subscription_time", (Object) Long.valueOf(System.currentTimeMillis()));
            m2122b();
        }
    }

    public void mo2448a(C0577e c0577e, C0576d c0576d) {
        if (c0576d != null) {
            try {
                if (!(c0576d.m527c() || c0577e == null)) {
                    String[] strArr = new String[]{"applock_subs_monthly", "applock_subscription_yearly", "applock_subs_yearly"};
                    if (c0577e.m532c(strArr[0]) || c0577e.m532c(strArr[1]) || c0577e.m532c(strArr[2])) {
                        C1148d.m2520b((Context) this, "subscription_failed_times", (Object) Integer.valueOf(0));
                        C0578f b = c0577e.m531b(strArr[0]);
                        if (b != null) {
                            C0581a.m545a((Context) this, b);
                        }
                        b = c0577e.m531b(strArr[1]);
                        if (b != null) {
                            C0581a.m545a((Context) this, b);
                        }
                        C0578f b2 = c0577e.m531b(strArr[2]);
                        if (b2 != null) {
                            C0581a.m545a((Context) this, b2);
                        }
                    } else {
                        m2119a();
                    }
                    AppLockApplication.m577b().m583a();
                    C1148d.m2520b((Context) this, "chech_subscription_time", (Object) Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            } finally {
                m2122b();
            }
        }
        m2122b();
    }

    public void mo2449a(C0578f c0578f, C0576d c0576d) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        new C10481(this).start();
        this.f1899a = new C0581a(this, C1150y.m2630h(this, getString(R.string.encode_base64_key)), this);
        if (UpdateService.f2005a) {
            startForeground(R.id.notify_foreground, C1150y.m2555T(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1899a.m564d();
    }
}
