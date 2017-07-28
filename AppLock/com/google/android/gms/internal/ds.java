package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.C2513c;

public final class ds {
    private final Handler f8682a = new Handler();
    private final Context f8683b;
    private final C2822a f8684c;

    public interface C2822a {
        Context mo4279a();

        boolean mo4280a(int i);
    }

    public ds(C2822a c2822a) {
        this.f8683b = c2822a.mo4279a();
        C2513c.m7932a(this.f8683b);
        this.f8684c = c2822a;
    }

    public static boolean m10278a(Context context, boolean z) {
        C2513c.m7932a((Object) context);
        return dy.m10372a(context, z ? "com.google.android.gms.measurement.PackageMeasurementService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    private dc m10280c() {
        return dk.m9976a(this.f8683b).m10034f();
    }

    @MainThread
    public int m10281a(Intent intent, int i, final int i2) {
        final dk a = dk.m9976a(this.f8683b);
        final dc f = a.m10034f();
        if (intent == null) {
            f.m9817z().m9774a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            a.m10030d().m9490W();
            f.m9786D().m9776a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                a.m10036h().m9938a(new Runnable(this) {
                    final /* synthetic */ ds f8681d;

                    class C28201 implements Runnable {
                        final /* synthetic */ C28211 f8677a;

                        C28201(C28211 c28211) {
                            this.f8677a = c28211;
                        }

                        public void run() {
                            if (this.f8677a.f8681d.f8684c.mo4280a(i2)) {
                                a.m10030d().m9490W();
                                f.m9786D().m9774a("Local AppMeasurementService processed last upload request");
                            }
                        }
                    }

                    public void run() {
                        a.m9997O();
                        a.m9995M();
                        this.f8681d.f8682a.post(new C28201(this));
                    }
                });
            }
        }
        return 2;
    }

    @MainThread
    public IBinder m10282a(Intent intent) {
        if (intent == null) {
            m10280c().m9815x().m9774a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new dl(dk.m9976a(this.f8683b));
        }
        m10280c().m9817z().m9775a("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public void m10283a() {
        dk a = dk.m9976a(this.f8683b);
        dc f = a.m10034f();
        a.m10030d().m9490W();
        f.m9786D().m9774a("Local AppMeasurementService is starting up");
    }

    @MainThread
    public void m10284b() {
        dk a = dk.m9976a(this.f8683b);
        dc f = a.m10034f();
        a.m10030d().m9490W();
        f.m9786D().m9774a("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public boolean m10285b(Intent intent) {
        if (intent == null) {
            m10280c().m9815x().m9774a("onUnbind called with null intent");
        } else {
            m10280c().m9786D().m9775a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    @MainThread
    public void m10286c(Intent intent) {
        if (intent == null) {
            m10280c().m9815x().m9774a("onRebind called with null intent");
            return;
        }
        m10280c().m9786D().m9775a("onRebind called. action", intent.getAction());
    }
}
