package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class bi implements ThreadFactory {
    private final String f7971a;
    private final int f7972b;
    private final AtomicInteger f7973c;
    private final ThreadFactory f7974d;

    public bi(String str) {
        this(str, 0);
    }

    public bi(String str, int i) {
        this.f7973c = new AtomicInteger();
        this.f7974d = Executors.defaultThreadFactory();
        this.f7971a = (String) C2513c.m7933a((Object) str, (Object) "Name must not be null");
        this.f7972b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f7974d.newThread(new bj(runnable, this.f7972b));
        String str = this.f7971a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f7973c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
