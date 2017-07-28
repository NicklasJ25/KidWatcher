package com.google.android.gms.internal;

import android.os.Process;

class bj implements Runnable {
    private final Runnable f7975a;
    private final int f7976b;

    public bj(Runnable runnable, int i) {
        this.f7975a = runnable;
        this.f7976b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f7976b);
        this.f7975a.run();
    }
}
