package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class dj extends dn {
    private static final AtomicLong f8445k = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService f8446a;
    private C2775d f8447b;
    private C2775d f8448c;
    private final PriorityBlockingQueue<FutureTask<?>> f8449d = new PriorityBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f8450e = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f8451f = new C2773b(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f8452g = new C2773b(this, "Thread death: Uncaught exception on network thread");
    private final Object f8453h = new Object();
    private final Semaphore f8454i = new Semaphore(2);
    private volatile boolean f8455j;

    static class C2772a extends RuntimeException {
    }

    private final class C2773b implements UncaughtExceptionHandler {
        final /* synthetic */ dj f8436a;
        private final String f8437b;

        public C2773b(dj djVar, String str) {
            this.f8436a = djVar;
            C2513c.m7932a((Object) str);
            this.f8437b = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.f8436a.mo3548u().m9815x().m9775a(this.f8437b, th);
        }
    }

    private final class C2774c<V> extends FutureTask<V> implements Comparable<C2774c> {
        final /* synthetic */ dj f8438a;
        private final long f8439b = dj.f8445k.getAndIncrement();
        private final boolean f8440c;
        private final String f8441d;

        C2774c(dj djVar, Runnable runnable, boolean z, String str) {
            this.f8438a = djVar;
            super(runnable, null);
            C2513c.m7932a((Object) str);
            this.f8441d = str;
            this.f8440c = z;
            if (this.f8439b == Format.OFFSET_SAMPLE_RELATIVE) {
                djVar.mo3548u().m9815x().m9774a("Tasks index overflow");
            }
        }

        C2774c(dj djVar, Callable<V> callable, boolean z, String str) {
            this.f8438a = djVar;
            super(callable);
            C2513c.m7932a((Object) str);
            this.f8441d = str;
            this.f8440c = z;
            if (this.f8439b == Format.OFFSET_SAMPLE_RELATIVE) {
                djVar.mo3548u().m9815x().m9774a("Tasks index overflow");
            }
        }

        public int m9923a(@NonNull C2774c c2774c) {
            if (this.f8440c != c2774c.f8440c) {
                return this.f8440c ? -1 : 1;
            } else {
                if (this.f8439b < c2774c.f8439b) {
                    return -1;
                }
                if (this.f8439b > c2774c.f8439b) {
                    return 1;
                }
                this.f8438a.mo3548u().m9816y().m9775a("Two tasks share the same index. index", Long.valueOf(this.f8439b));
                return 0;
            }
        }

        public /* synthetic */ int compareTo(@NonNull Object obj) {
            return m9923a((C2774c) obj);
        }

        protected void setException(Throwable th) {
            this.f8438a.mo3548u().m9815x().m9775a(this.f8441d, th);
            if (th instanceof C2772a) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }
    }

    private final class C2775d extends Thread {
        final /* synthetic */ dj f8442a;
        private final Object f8443b = new Object();
        private final BlockingQueue<FutureTask<?>> f8444c;

        public C2775d(dj djVar, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.f8442a = djVar;
            C2513c.m7932a((Object) str);
            C2513c.m7932a((Object) blockingQueue);
            this.f8444c = blockingQueue;
            setName(str);
        }

        private void m9924a(InterruptedException interruptedException) {
            this.f8442a.mo3548u().m9817z().m9775a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        public void m9925a() {
            synchronized (this.f8443b) {
                this.f8443b.notifyAll();
            }
        }

        public void run() {
            Object obj = null;
            while (obj == null) {
                try {
                    this.f8442a.f8454i.acquire();
                    obj = 1;
                } catch (InterruptedException e) {
                    m9924a(e);
                }
            }
            while (true) {
                try {
                    FutureTask futureTask = (FutureTask) this.f8444c.poll();
                    if (futureTask != null) {
                        futureTask.run();
                    } else {
                        synchronized (this.f8443b) {
                            if (this.f8444c.peek() == null && !this.f8442a.f8455j) {
                                try {
                                    this.f8443b.wait(30000);
                                } catch (InterruptedException e2) {
                                    m9924a(e2);
                                }
                            }
                        }
                        synchronized (this.f8442a.f8453h) {
                            if (this.f8444c.peek() == null) {
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this.f8442a.f8453h) {
                        this.f8442a.f8454i.release();
                        this.f8442a.f8453h.notifyAll();
                        if (this == this.f8442a.f8447b) {
                            this.f8442a.f8447b = null;
                        } else if (this == this.f8442a.f8448c) {
                            this.f8442a.f8448c = null;
                        } else {
                            this.f8442a.mo3548u().m9815x().m9774a("Current scheduler thread is neither worker nor network");
                        }
                    }
                }
            }
            synchronized (this.f8442a.f8453h) {
                this.f8442a.f8454i.release();
                this.f8442a.f8453h.notifyAll();
                if (this == this.f8442a.f8447b) {
                    this.f8442a.f8447b = null;
                } else if (this == this.f8442a.f8448c) {
                    this.f8442a.f8448c = null;
                } else {
                    this.f8442a.mo3548u().m9815x().m9774a("Current scheduler thread is neither worker nor network");
                }
            }
        }
    }

    dj(dk dkVar) {
        super(dkVar);
    }

    private void m9929a(C2774c<?> c2774c) {
        synchronized (this.f8453h) {
            this.f8449d.add(c2774c);
            if (this.f8447b == null) {
                this.f8447b = new C2775d(this, "Measurement Worker", this.f8449d);
                this.f8447b.setUncaughtExceptionHandler(this.f8451f);
                this.f8447b.start();
            } else {
                this.f8447b.m9925a();
            }
        }
    }

    private void m9930a(FutureTask<?> futureTask) {
        synchronized (this.f8453h) {
            this.f8450e.add(futureTask);
            if (this.f8448c == null) {
                this.f8448c = new C2775d(this, "Measurement Network", this.f8450e);
                this.f8448c.setUncaughtExceptionHandler(this.f8452g);
                this.f8448c.start();
            } else {
                this.f8448c.m9925a();
            }
        }
    }

    public <V> Future<V> m9936a(Callable<V> callable) {
        m9448R();
        C2513c.m7932a((Object) callable);
        C2774c c2774c = new C2774c(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f8447b) {
            if (!this.f8449d.isEmpty()) {
                mo3548u().m9817z().m9774a("Callable skipped the worker queue.");
            }
            c2774c.run();
        } else {
            m9929a(c2774c);
        }
        return c2774c;
    }

    protected void mo3551a() {
    }

    public void m9938a(Runnable runnable) {
        m9448R();
        C2513c.m7932a((Object) runnable);
        m9929a(new C2774c(this, runnable, false, "Task exception on worker thread"));
    }

    public <V> Future<V> m9939b(Callable<V> callable) {
        m9448R();
        C2513c.m7932a((Object) callable);
        C2774c c2774c = new C2774c(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f8447b) {
            c2774c.run();
        } else {
            m9929a(c2774c);
        }
        return c2774c;
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public void m9941b(Runnable runnable) {
        m9448R();
        C2513c.m7932a((Object) runnable);
        m9930a(new C2774c(this, runnable, false, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public void mo3531d() {
        if (Thread.currentThread() != this.f8448c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public void mo3532e() {
        if (Thread.currentThread() != this.f8447b) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    public boolean m9963x() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m9964y() {
        return Thread.currentThread() == this.f8447b;
    }

    ExecutorService m9965z() {
        ExecutorService executorService;
        synchronized (this.f8453h) {
            if (this.f8446a == null) {
                this.f8446a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f8446a;
        }
        return executorService;
    }
}
