package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@wh
public class aah<T> implements aaj<T> {
    private final T f7636a;
    private final aak f7637b = new aak();

    public aah(T t) {
        this.f7636a = t;
        this.f7637b.m8448a();
    }

    public void mo3377a(Runnable runnable) {
        this.f7637b.m8449a(runnable);
    }

    public void mo3378b(Runnable runnable) {
        this.f7637b.m8450b(runnable);
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.f7636a;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.f7636a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
