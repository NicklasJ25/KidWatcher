package com.google.android.exoplayer2.p043j;

import android.os.HandlerThread;
import android.os.Process;

public final class C2265n extends HandlerThread {
    private final int f6461a;

    public C2265n(String str, int i) {
        super(str);
        this.f6461a = i;
    }

    public void run() {
        Process.setThreadPriority(this.f6461a);
        super.run();
    }
}
