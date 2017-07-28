package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.C2590o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C2835e implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final C2835e f8736a = new C2835e();
    private final AtomicBoolean f8737b = new AtomicBoolean();
    private final AtomicBoolean f8738c = new AtomicBoolean();
    private final ArrayList<C2834a> f8739d = new ArrayList();
    private boolean f8740e = false;

    public interface C2834a {
        void mo4190a(boolean z);
    }

    private C2835e() {
    }

    public static C2835e m10491a() {
        return f8736a;
    }

    public static void m10492a(Application application) {
        synchronized (f8736a) {
            if (!f8736a.f8740e) {
                application.registerActivityLifecycleCallbacks(f8736a);
                application.registerComponentCallbacks(f8736a);
                f8736a.f8740e = true;
            }
        }
    }

    private void m10493b(boolean z) {
        synchronized (f8736a) {
            Iterator it = this.f8739d.iterator();
            while (it.hasNext()) {
                ((C2834a) it.next()).mo4190a(z);
            }
        }
    }

    public void m10494a(C2834a c2834a) {
        synchronized (f8736a) {
            this.f8739d.add(c2834a);
        }
    }

    @TargetApi(16)
    public boolean m10495a(boolean z) {
        if (!this.f8738c.get()) {
            if (!C2590o.m8309d()) {
                return z;
            }
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f8738c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f8737b.set(true);
            }
        }
        return m10496b();
    }

    public boolean m10496b() {
        return this.f8737b.get();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f8737b.compareAndSet(true, false);
        this.f8738c.set(true);
        if (compareAndSet) {
            m10493b(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f8737b.compareAndSet(true, false);
        this.f8738c.set(true);
        if (compareAndSet) {
            m10493b(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f8737b.compareAndSet(false, true)) {
            this.f8738c.set(true);
            m10493b(true);
        }
    }
}
