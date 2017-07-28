package com.google.android.gms.internal;

import com.google.firebase.database.C3537c;
import com.google.firebase.database.C3576f;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class lb implements hm {
    private ScheduledThreadPoolExecutor f8958a = new ScheduledThreadPoolExecutor(this, 1, new C3040a()) {
        final /* synthetic */ lb f9692a;

        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                Future future = (Future) runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (CancellationException e) {
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                }
            }
            if (th != null) {
                this.f9692a.mo3603a(th);
            }
        }
    };

    private class C3040a implements ThreadFactory {
        final /* synthetic */ lb f9694a;

        class C30391 implements UncaughtExceptionHandler {
            final /* synthetic */ C3040a f9693a;

            C30391(C3040a c3040a) {
                this.f9693a = c3040a;
            }

            public void uncaughtException(Thread thread, Throwable th) {
                this.f9693a.f9694a.mo3603a(th);
            }
        }

        private C3040a(lb lbVar) {
            this.f9694a = lbVar;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f9694a.mo3705a().newThread(runnable);
            ht b = this.f9694a.mo3706b();
            b.mo3701a(newThread, "FirebaseDatabaseWorker");
            b.mo3703a(newThread, true);
            b.mo3702a(newThread, new C30391(this));
            return newThread;
        }
    }

    public lb() {
        this.f8958a.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public static String m10813b(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof C3537c) {
            return "";
        }
        String valueOf = String.valueOf(C3576f.m15586c());
        return new StringBuilder(String.valueOf(valueOf).length() + 104).append("Uncaught exception in Firebase Database runloop (").append(valueOf).append("). Please report to firebase-database-client@google.com").toString();
    }

    protected ThreadFactory mo3705a() {
        return Executors.defaultThreadFactory();
    }

    public void mo3601a(Runnable runnable) {
        this.f8958a.execute(runnable);
    }

    public abstract void mo3603a(Throwable th);

    protected ht mo3706b() {
        return ht.f9185a;
    }

    public void mo3602c() {
        this.f8958a.setCorePoolSize(1);
    }

    public ScheduledExecutorService m10819d() {
        return this.f8958a;
    }
}
