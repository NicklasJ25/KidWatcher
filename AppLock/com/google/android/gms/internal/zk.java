package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@wh
public final class zk {
    private static final ThreadPoolExecutor f11668a = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m15082a("Default"));
    private static final ThreadPoolExecutor f11669b = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m15082a("Loader"));

    class C34721 implements Callable<Void> {
        final /* synthetic */ Runnable f11660a;

        C34721(Runnable runnable) {
            this.f11660a = runnable;
        }

        public Void m15076a() {
            this.f11660a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m15076a();
        }
    }

    class C34732 implements Callable<Void> {
        final /* synthetic */ Runnable f11661a;

        C34732(Runnable runnable) {
            this.f11661a = runnable;
        }

        public Void m15077a() {
            this.f11661a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m15077a();
        }
    }

    class C34743 implements Runnable {
        final /* synthetic */ aag f11662a;
        final /* synthetic */ Callable f11663b;

        C34743(aag com_google_android_gms_internal_aag, Callable callable) {
            this.f11662a = com_google_android_gms_internal_aag;
            this.f11663b = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.f11662a.m8436b(this.f11663b.call());
            } catch (Throwable e) {
                zzw.zzcQ().m15000a(e, "AdThreadPool.submit");
                this.f11662a.m8435a(e);
            }
        }
    }

    class C34754 implements Runnable {
        final /* synthetic */ aag f11664a;
        final /* synthetic */ Future f11665b;

        C34754(aag com_google_android_gms_internal_aag, Future future) {
            this.f11664a = com_google_android_gms_internal_aag;
            this.f11665b = future;
        }

        public void run() {
            if (this.f11664a.isCancelled()) {
                this.f11665b.cancel(true);
            }
        }
    }

    class C34765 implements ThreadFactory {
        final /* synthetic */ String f11666a;
        private final AtomicInteger f11667b = new AtomicInteger(1);

        C34765(String str) {
            this.f11666a = str;
        }

        public Thread newThread(Runnable runnable) {
            String str = this.f11666a;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.f11667b.getAndIncrement()).toString());
        }
    }

    static {
        f11668a.allowCoreThreadTimeOut(true);
        f11669b.allowCoreThreadTimeOut(true);
    }

    public static aaj<Void> m15078a(int i, Runnable runnable) {
        return i == 1 ? m15081a(f11669b, new C34721(runnable)) : m15081a(f11668a, new C34732(runnable));
    }

    public static aaj<Void> m15079a(Runnable runnable) {
        return m15078a(0, runnable);
    }

    public static <T> aaj<T> m15080a(Callable<T> callable) {
        return m15081a(f11668a, (Callable) callable);
    }

    public static <T> aaj<T> m15081a(ExecutorService executorService, Callable<T> callable) {
        Object com_google_android_gms_internal_aag = new aag();
        try {
            com_google_android_gms_internal_aag.mo3378b(new C34754(com_google_android_gms_internal_aag, executorService.submit(new C34743(com_google_android_gms_internal_aag, callable))));
        } catch (Throwable e) {
            aad.m8424c("Thread execution is rejected.", e);
            com_google_android_gms_internal_aag.cancel(true);
        }
        return com_google_android_gms_internal_aag;
    }

    private static ThreadFactory m15082a(String str) {
        return new C34765(str);
    }
}
