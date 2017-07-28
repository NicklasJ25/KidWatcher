package com.facebook.ads.internal.p026e;

import android.content.Context;
import android.os.Process;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p018m.C1710f;
import com.facebook.ads.internal.p018m.C1736y;
import com.facebook.ads.internal.p018m.C1737z;
import com.facebook.ads.internal.p022h.C1608p;
import com.facebook.ads.internal.p028g.C1581g;
import com.facebook.ads.internal.p028g.C1583i;
import java.lang.Thread.UncaughtExceptionHandler;

public class C1557b implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f3798a;
    private final Context f3799b;

    public C1557b(@Nullable UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        this.f3798a = uncaughtExceptionHandler;
        if (context == null) {
            throw new IllegalArgumentException("Missing Context");
        }
        this.f3799b = context.getApplicationContext();
    }

    private void m4326a(Thread thread, Throwable th) {
        if (this.f3798a != null) {
            this.f3798a.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable th2) {
        }
        try {
            System.exit(10);
        } catch (Throwable th3) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String a = C1710f.m4917a(th);
        if (a != null && a.contains("com.facebook.ads")) {
            C1737z.m5001a(new C1608p(C1581g.m4409b(), C1581g.m4410c(), new C1736y(a, C1583i.f3925f)), this.f3799b);
        }
        m4326a(thread, th);
    }
}
