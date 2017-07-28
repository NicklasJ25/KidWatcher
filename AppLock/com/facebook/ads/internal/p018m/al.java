package com.facebook.ads.internal.p018m;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class al implements ThreadFactory {
    protected final AtomicLong f4234a = new AtomicLong();
    private int f4235b = Thread.currentThread().getPriority();

    protected String m4843a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f4234a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, m4843a(), 0);
        thread.setPriority(this.f4235b);
        return thread;
    }
}
