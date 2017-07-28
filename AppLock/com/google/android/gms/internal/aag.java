package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@wh
public class aag<T> implements aaj<T> {
    private final Object f7630a = new Object();
    private T f7631b;
    private Throwable f7632c;
    private boolean f7633d;
    private boolean f7634e;
    private final aak f7635f = new aak();

    private boolean m8433a() {
        return this.f7632c != null || this.f7633d;
    }

    public void mo3377a(Runnable runnable) {
        this.f7635f.m8449a(runnable);
    }

    public void m8435a(Throwable th) {
        synchronized (this.f7630a) {
            if (this.f7634e) {
            } else if (m8433a()) {
                zzw.zzcQ().m15000a(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideException");
            } else {
                this.f7632c = th;
                this.f7630a.notifyAll();
                this.f7635f.m8448a();
            }
        }
    }

    public void m8436b(@Nullable T t) {
        synchronized (this.f7630a) {
            if (this.f7634e) {
            } else if (m8433a()) {
                zzw.zzcQ().m15000a(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideValue");
            } else {
                this.f7633d = true;
                this.f7631b = t;
                this.f7630a.notifyAll();
                this.f7635f.m8448a();
            }
        }
    }

    public void mo3378b(Runnable runnable) {
        this.f7635f.m8450b(runnable);
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f7630a) {
            if (m8433a()) {
                return false;
            }
            this.f7634e = true;
            this.f7633d = true;
            this.f7630a.notifyAll();
            this.f7635f.m8448a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f7630a) {
            if (!m8433a()) {
                try {
                    this.f7630a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f7632c != null) {
                throw new ExecutionException(this.f7632c);
            } else if (this.f7634e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f7631b;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f7630a) {
            if (!m8433a()) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.f7630a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f7632c != null) {
                throw new ExecutionException(this.f7632c);
            } else if (!this.f7633d) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f7634e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f7631b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f7630a) {
            z = this.f7634e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f7630a) {
            a = m8433a();
        }
        return a;
    }
}
