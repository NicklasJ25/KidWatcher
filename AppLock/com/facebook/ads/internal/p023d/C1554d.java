package com.facebook.ads.internal.p023d;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.p030j.p032b.C1656f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C1554d {
    private static final String f3789a = C1554d.class.getSimpleName();
    private static C1554d f3790b;
    private final Future<C1656f> f3791c;

    private C1554d(final Context context) {
        this.f3791c = Executors.newSingleThreadExecutor().submit(new Callable<C1656f>(this) {
            final /* synthetic */ C1554d f3788b;

            public C1656f m4317a() {
                return new C1656f(context);
            }

            public /* synthetic */ Object call() {
                return m4317a();
            }
        });
    }

    public static C1554d m4318a(Context context) {
        if (f3790b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f3790b == null) {
                    f3790b = new C1554d(applicationContext);
                }
            }
        }
        return f3790b;
    }

    @Nullable
    private C1656f m4319a() {
        Throwable e;
        try {
            return (C1656f) this.f3791c.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        } catch (TimeoutException e4) {
            e = e4;
        }
        Log.e(f3789a, "Timed out waiting for cache server.", e);
        return null;
    }

    public void m4320a(String str) {
        C1656f a = m4319a();
        if (a != null) {
            a.m4684a(str);
        }
    }

    @Nullable
    public String m4321b(String str) {
        C1656f a = m4319a();
        return a == null ? null : a.m4685b(str);
    }
}
