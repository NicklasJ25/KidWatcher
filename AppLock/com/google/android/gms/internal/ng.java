package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.C2590o;
import java.util.ArrayList;
import java.util.List;

@wh
public class ng {
    private final Object f9990a = new Object();
    private C3094a f9991b = null;
    private boolean f9992c = false;

    @TargetApi(14)
    static class C3094a implements ActivityLifecycleCallbacks {
        @Nullable
        private Activity f9981a;
        private Context f9982b;
        private final Object f9983c = new Object();
        private boolean f9984d = true;
        private boolean f9985e = false;
        private List<C3095b> f9986f = new ArrayList();
        private Runnable f9987g;
        private boolean f9988h = false;
        private long f9989i;

        class C30931 implements Runnable {
            final /* synthetic */ C3094a f9980a;

            C30931(C3094a c3094a) {
                this.f9980a = c3094a;
            }

            public void run() {
                synchronized (this.f9980a.f9983c) {
                    if (this.f9980a.f9984d && this.f9980a.f9985e) {
                        this.f9980a.f9984d = false;
                        aad.m8421b("App went background");
                        for (C3095b a : this.f9980a.f9986f) {
                            try {
                                a.mo3849a(false);
                            } catch (Throwable e) {
                                aad.m8422b("OnForegroundStateChangedListener threw exception.", e);
                            }
                        }
                    } else {
                        aad.m8421b("App is still foreground");
                    }
                }
            }
        }

        C3094a() {
        }

        private void m12771a(Activity activity) {
            synchronized (this.f9983c) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.f9981a = activity;
                }
            }
        }

        @Nullable
        public Activity m12776a() {
            return this.f9981a;
        }

        public void m12777a(Application application, Context context) {
            if (!this.f9988h) {
                application.registerActivityLifecycleCallbacks(this);
                if (context instanceof Activity) {
                    m12771a((Activity) context);
                }
                this.f9982b = context;
                this.f9989i = ((Long) qb.aK.m13225c()).longValue();
                this.f9988h = true;
            }
        }

        public void m12778a(C3095b c3095b) {
            this.f9986f.add(c3095b);
        }

        @Nullable
        public Context m12779b() {
            return this.f9982b;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onActivityDestroyed(android.app.Activity r3) {
            /*
            r2 = this;
            r1 = r2.f9983c;
            monitor-enter(r1);
            r0 = r2.f9981a;	 Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0009;
        L_0x0007:
            monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        L_0x0008:
            return;
        L_0x0009:
            r0 = r2.f9981a;	 Catch:{ all -> 0x0016 }
            r0 = r0.equals(r3);	 Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014;
        L_0x0011:
            r0 = 0;
            r2.f9981a = r0;	 Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1);	 Catch:{ all -> 0x0016 }
            goto L_0x0008;
        L_0x0016:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0016 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ng.a.onActivityDestroyed(android.app.Activity):void");
        }

        public void onActivityPaused(Activity activity) {
            m12771a(activity);
            this.f9985e = true;
            if (this.f9987g != null) {
                zl.f11678a.removeCallbacks(this.f9987g);
            }
            Handler handler = zl.f11678a;
            Runnable c30931 = new C30931(this);
            this.f9987g = c30931;
            handler.postDelayed(c30931, this.f9989i);
        }

        public void onActivityResumed(Activity activity) {
            boolean z = false;
            m12771a(activity);
            this.f9985e = false;
            if (!this.f9984d) {
                z = true;
            }
            this.f9984d = true;
            if (this.f9987g != null) {
                zl.f11678a.removeCallbacks(this.f9987g);
            }
            synchronized (this.f9983c) {
                if (z) {
                    for (C3095b a : this.f9986f) {
                        try {
                            a.mo3849a(true);
                        } catch (Throwable e) {
                            aad.m8422b("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                } else {
                    aad.m8421b("App is still foreground.");
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            m12771a(activity);
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public interface C3095b {
        void mo3849a(boolean z);
    }

    @Nullable
    public Activity m12781a() {
        Activity a;
        synchronized (this.f9990a) {
            C2590o.m8307b();
            if (this.f9991b != null) {
                a = this.f9991b.m12776a();
            } else {
                a = null;
            }
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12782a(android.content.Context r5) {
        /*
        r4 = this;
        r2 = r4.f9990a;
        monitor-enter(r2);
        r0 = r4.f9992c;	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x0047;
    L_0x0007:
        com.google.android.gms.common.util.C2590o.m8307b();	 Catch:{ all -> 0x0031 }
        r0 = com.google.android.gms.internal.qb.aJ;	 Catch:{ all -> 0x0031 }
        r0 = r0.m13225c();	 Catch:{ all -> 0x0031 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x0031 }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
    L_0x0019:
        return;
    L_0x001a:
        r1 = 0;
        r0 = r5.getApplicationContext();	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        r0 = r5;
    L_0x0022:
        r3 = r0 instanceof android.app.Application;	 Catch:{ all -> 0x0031 }
        if (r3 == 0) goto L_0x0049;
    L_0x0026:
        r0 = (android.app.Application) r0;	 Catch:{ all -> 0x0031 }
    L_0x0028:
        if (r0 != 0) goto L_0x0034;
    L_0x002a:
        r0 = "Can not cast Context to Application";
        com.google.android.gms.internal.aad.m8426e(r0);	 Catch:{ all -> 0x0031 }
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        goto L_0x0019;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        r1 = r4.f9991b;	 Catch:{ all -> 0x0031 }
        if (r1 != 0) goto L_0x003f;
    L_0x0038:
        r1 = new com.google.android.gms.internal.ng$a;	 Catch:{ all -> 0x0031 }
        r1.<init>();	 Catch:{ all -> 0x0031 }
        r4.f9991b = r1;	 Catch:{ all -> 0x0031 }
    L_0x003f:
        r1 = r4.f9991b;	 Catch:{ all -> 0x0031 }
        r1.m12777a(r0, r5);	 Catch:{ all -> 0x0031 }
        r0 = 1;
        r4.f9992c = r0;	 Catch:{ all -> 0x0031 }
    L_0x0047:
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        goto L_0x0019;
    L_0x0049:
        r0 = r1;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ng.a(android.content.Context):void");
    }

    public void m12783a(C3095b c3095b) {
        synchronized (this.f9990a) {
            C2590o.m8307b();
            if (((Boolean) qb.aJ.m13225c()).booleanValue()) {
                if (this.f9991b == null) {
                    this.f9991b = new C3094a();
                }
                this.f9991b.m12778a(c3095b);
                return;
            }
        }
    }

    @Nullable
    public Context m12784b() {
        Context b;
        synchronized (this.f9990a) {
            C2590o.m8307b();
            if (this.f9991b != null) {
                b = this.f9991b.m12779b();
            } else {
                b = null;
            }
        }
        return b;
    }
}
