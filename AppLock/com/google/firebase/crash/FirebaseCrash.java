package com.google.firebase.crash;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fp;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.fr;
import com.google.android.gms.internal.zzbnn;
import com.google.android.gms.p065a.C2312b;
import com.google.firebase.C3531b;
import com.google.firebase.iid.C3598c;

public class FirebaseCrash {
    private static final String f12134a = FirebaseCrash.class.getSimpleName();
    private static volatile FirebaseCrash f12135e;
    private boolean f12136b;
    private fo f12137c;
    private fl f12138d;

    FirebaseCrash(C3531b c3531b, boolean z) {
        this.f12136b = z;
        Object a = c3531b.m15431a();
        if (a == null) {
            Log.w(f12134a, "Application context is missing, disabling api");
            this.f12136b = false;
        }
        if (this.f12136b) {
            try {
                zzbnn com_google_android_gms_internal_zzbnn = new zzbnn(c3531b.m15436c().m15450b(), c3531b.m15436c().m15449a());
                fp.m10794a().m10795a(a);
                this.f12137c = fp.m10794a().m10796b();
                this.f12137c.mo3590a(C2312b.m7327a(a), com_google_android_gms_internal_zzbnn);
                this.f12138d = new fl(a);
                m15444f();
                String str = f12134a;
                String str2 = "FirebaseCrash reporting initialized ";
                String valueOf = String.valueOf(fp.m10794a().toString());
                Log.i(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return;
            } catch (Exception e) {
                str = f12134a;
                str2 = "Failed to initialize crash reporting: ";
                valueOf = String.valueOf(e.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.f12136b = false;
                return;
            }
        }
        Log.i(f12134a, "Crash reporting is disabled");
    }

    public static FirebaseCrash m15438a() {
        if (f12135e == null) {
            synchronized (FirebaseCrash.class) {
                if (f12135e == null) {
                    f12135e = getInstance(C3531b.m15427d());
                }
            }
        }
        return f12135e;
    }

    public static void m15439a(String str, long j, Bundle bundle) {
        try {
            m15438a().m15447b(str, j, bundle);
        } catch (fm e) {
            Log.v(f12134a, e.getMessage());
        }
    }

    private void m15440b() {
        if (m15442d()) {
            this.f12138d.m10776a();
            return;
        }
        throw new fm("Firebase Crash Reporting is disabled.");
    }

    private fo m15441c() {
        return this.f12137c;
    }

    private boolean m15442d() {
        return this.f12136b;
    }

    private static boolean m15443e() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private void m15444f() {
        if (m15443e()) {
            Thread.setDefaultUncaughtExceptionHandler(new fq(Thread.getDefaultUncaughtExceptionHandler(), this));
            return;
        }
        throw new RuntimeException("FirebaseCrash reporting may only be initialized on the main thread (preferably in your app's Application.onCreate)");
    }

    private String m15445g() {
        return C3598c.m15655a().m15656b();
    }

    @Keep
    @Deprecated
    public static FirebaseCrash getInstance(C3531b c3531b) {
        fr.m10797a(c3531b.m15431a());
        FirebaseCrash firebaseCrash = new FirebaseCrash(c3531b, ((Boolean) fr.f8935a.m9240c()).booleanValue());
        synchronized (FirebaseCrash.class) {
            if (f12135e == null) {
                f12135e = firebaseCrash;
                try {
                    f12135e.m15440b();
                } catch (fm e) {
                    Log.d(f12134a, "Cannot register Firebase Analytics listener since Firebase Crash Reporting is not enabled");
                }
            }
        }
        return firebaseCrash;
    }

    public void m15446a(Throwable th) {
        if (m15442d()) {
            fo c = m15441c();
            if (c != null && th != null) {
                try {
                    this.f12138d.m10777a(true, System.currentTimeMillis());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    c.mo3594b(m15445g());
                    c.mo3593b(C2312b.m7327a((Object) th));
                    return;
                } catch (Throwable e2) {
                    Log.e(f12134a, "report remoting failed", e2);
                    return;
                }
            }
            return;
        }
        throw new fm("Firebase Crash Reporting is disabled.");
    }

    public void m15447b(String str, long j, Bundle bundle) {
        if (m15442d()) {
            fo c = m15441c();
            if (c != null && str != null) {
                try {
                    c.mo3592a(str, j, bundle);
                    return;
                } catch (Throwable e) {
                    Log.e(f12134a, "log remoting failed", e);
                    return;
                }
            }
            return;
        }
        throw new fm("Firebase Crash Reporting is disabled.");
    }
}
